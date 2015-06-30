package jp.escofi.emr.transformer;

import java.util.Arrays;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.transformer.constant.MessageType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �^�p�c�[���N���o�b�`�B
 * <DL>
 * <DT>�g�p�ړI/�@�\�T�v�F
 * <DD>
 * <UL>
 * <LI>�f�[�^�x�[�X�ɓo�^���ꂽ�f�[�^���f������XML�t�@�C���֏o�͂���B
 * <LI>�p�����[�^�͑S�ĕK�{�ŁA�ȉ��̏��Ɏw�肷��B
 *  <OL>
 *   <LI>DB�ڑ��h���C�o�[</LI>
 *   <LI>DB�ڑ���</LI>
 *   <LI>DB�ڑ����[�U��</LI>
 *   <LI>DB�ڑ��p�X���[�h</LI>
 *   <LI>�Č��R�[�h</LI>
 *   <LI>XML�o�͐�</LI>
 *  </OL>
 * </LI>
 * </UL>
 * <DT>�T���v���R�[�h�F
 * <DD>�N���R�}���h��
 * <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'>
 * <TT>
 *  driver = "com.ibm.db2.jcc.DB2Driver"
 *  url = "jdbc:db2://192.168.100.2:50001/SAMPLE"
 *  username = "username"
 *  password = "password"
 *  productCd = "�Č��ԍ�01"
 *  xmlbase = "/home/pdsuser/XMLs/TestData"
 *
 *  java jp.escofi.emr.transformer.XmlWriterCaller $driver $url $username $password $productCd $xmlbase
 * </TT>
 * </PRE>
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/08/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public final class XmlWriterCaller {

	/**
	 * ���O�o��
	 */
	private static final Log LOGGER = LogFactory.getLog(XmlWriterCaller.class);

	/**
	 * ���C�������B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>XML�t�@�C���Ǘ��E�f�[�^���f��XML���o�͂���B
	 *    <OL>
	 *     <LI>�v���O�����N�������̓��͐��`�F�b�N</LI>
	 *     <LI>�p�����[�^�`�F�b�N</LI>
	 *     <LI>�J�n���O�o��</LI>
	 *     <LI>XML�o�͏���</LI>
	 *     <LI>XML�o�͏����ňُ킪���������ꍇ�́A�ُ�I��(���^�[���R�[�h�l:1)</LI>
	 *     <LI>�I�����O�o��</LI>
	 *     <LI>�I��(���^�[���R�[�h:0)</LI>
	 *    </OL>
	 * </DL>
	 * @param args �v���O�����N������
	 */
	public static void main(String[] args) {

		try {
			if (args == null || args.length != 6) {
				Object o = null;

				if (args != null) {
					o = Arrays.asList(args);
				}
				throw new EMRException(MessageCode.EMR_B_P908E, new Object[] { o });
			}
			String driver = args[0];
			String url = args[1];
			String userName = args[2];
			String password = args[3];
			String productCd = args[4];
			String xmlBase = args[5];

			checkParameter(driver, url, userName, password, productCd, xmlBase);

			LOGGER.info(MessageUtil.getMessage(
					MessageCode.EMR_B_P901I.toString(), new Object[] {
						productCd,
						xmlBase }));

			XmlWriter xmlWriter = new XmlWriter(driver, url, userName,
					password, productCd, xmlBase);

			xmlWriter.write();
		} catch (Exception e) {
			System.exit(1);
		}
		LOGGER.info(MessageUtil.getMessage(MessageCode.EMR_B_P902I.toString()));

		System.exit(0);
	}

	/**
	 * �N���p�����[�^�`�F�b�N�B
	 * <UL>
	 *  <LI>JDBC�ڑ������̓`�F�b�N</LI>
	 *  <LI>�Č��R�[�h���̓`�F�b�N</LI>
	 *  <LI>XML�t�@�C���o�͐���̓`�F�b�N</LI>
	 * </UL>
	 * @param driver
	 *            DB�ڑ��h���C�o�[
	 * @param url
	 *            DB�ڑ���
	 * @param userName
	 *            DB�ڑ����[�U��
	 * @param password
	 *            DB�ڑ��p�X���[�h
	 * @param productCd
	 *            �Č��R�[�h
	 * @param xmlBase
	 *            XML�o�͐�
	 * @throws EMRException
	 *             �p�����[�^�`�F�b�N���ʂ�Ȃ������ꍇ
	 */
	private static void checkParameter(String driver, String url, String userName,
			String password, String productCd, String xmlBase) throws EMRException {

		// JDBC�ڑ���񂪎w�肳��Ă��Ȃ��ꍇ
		if ((driver == null || driver.length() < 1)
				|| (url == null || url.length() < 1)
				|| (userName == null || userName.length() < 1)
				|| (password == null || password.length() < 1)) {
			throw new EMRException(MessageCode.EMR_B_P907E,
					new Object[] { MessageType.JDBC_INFO });
		}

		// �Č��R�[�h���w�肳��Ă��Ȃ��B
		if ((productCd == null || productCd.length() < 1)) {
			throw new EMRException(MessageCode.EMR_B_P907E,
					new Object[] { MessageType.PRODUCT_CD });
		} else if (10 < productCd.length()) {
			// �Č��R�[�h�̌�������������B
			throw new EMRException(MessageCode.EMR_B_P911E,
					new Object[] { productCd });
		}

		// XML�t�@�C���o�͐悪�w�肳��Ă��Ȃ��B
		if ((xmlBase == null || xmlBase.length() < 1)) {
			throw new EMRException(MessageCode.EMR_B_P907E,
					new Object[] { MessageType.XML_OUTPUT_PATH });
		}
	}

}
