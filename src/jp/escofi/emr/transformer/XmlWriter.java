package jp.escofi.emr.transformer;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.ProductMapper;
import jp.escofi.emr.transformer.writer.DatamodelinfoWriter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xml.sax.SAXException;

/**
 * �^�p�c�[���B
 * <DL>
 * <DT>�g�p�ړI/�@�\�T�v�F
 * <DD>�f�[�^�x�[�X�ɓo�^���ꂽ�f�[�^���f������XML�t�@�C���֏o�͂���B
 * <DT>�T���v���R�[�h�F
 * <DD>�����\�b�h����ďo����
 * <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'>
 * <TT>
 *  XmlWriter writer = new XmlWriter();
 *
 *  String driver = "com.ibm.db2.jcc.DB2Driver";
 *  String url = "jdbc:db2://192.168.100.2:50001/SAMPLE";
 *  String username = "username";
 *  String password = "password";
 *  String productCd = "�Č��ԍ�01";
 *  String xmlbase = "/home/pdsuser/XMLs/TestData";
 *
 *  XmlWriter xmlWriter = new XmlWriter(driver, url, username, password, productCd, xmlbase);
 *
 *  xmlWriter.write();
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
public class XmlWriter {

	/**
	 * DB�ڑ��h���C�o�[
	 */
	private String driver;
	/**
	 * DB�ڑ���
	 */
	private String url;
	/**
	 * DB�ڑ����[�U��
	 */
	private String userName;
	/**
	 * DB�ڑ��p�X���[�h
	 */
	private String password;
	/**
	 * �Č��ԍ�
	 */
	private String productCd;
	/**
	 * XML�o�͐�
	 */
	private String xmlBase;


	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�������N���X�ϐ��ɕێ�����B
	 * </DL>
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
	 */
	public XmlWriter(String driver, String url, String userName,
			String password, String productCd, String xmlBase) {
		super();
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.productCd = productCd;
		this.xmlBase = xmlBase;
	}

	/**
	 * XML�o�͏����B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>XML�t�@�C���Ǘ��E�f�[�^���f��XML���o�͂���B
	 *    <OL>
	 *     <LI>SQL�Z�b�V�������擾����B</LI>
	 *     <LI>�Č��R�[�h�`�F�b�N������B</LI>
	 *     <LI>XML�t�@�C���Ǘ��E�f�[�^���f��XML�o�͏������ďo���B</LI>
	 *     <LI>��L�̏����ŗ�O�����������ꍇ�́A
	 *����������O�ɉ������G���[�R�[�h��EMRException�𐶐�����throw����B</LI>
	 *    </OL>
	 * </DL>
	 * @throws EMRException
	 *             �Ɩ���O
	 */
	public void write() throws EMRException {
		SqlSession session = null;

		try {
			session = getSqlSession();

			checkProductCd(session);

			DatamodelinfoWriter writer = new DatamodelinfoWriter(
					productCd, xmlBase);

			writer.write(session);
		} catch (IOException e) {
			throw new EMRException(MessageCode.EMR_B_P904E,
					new Object[] { xmlBase }, e);
		} catch (ParserConfigurationException e) {
			throw new EMRException(MessageCode.EMR_B_P905E,
					new Object[] { xmlBase }, e);
		} catch (SAXException e) {
			throw new EMRException(MessageCode.EMR_B_P905E,
					new Object[] { xmlBase }, e);
		} catch (RuntimeException e) {
			Throwable err = e;

			while (err.getCause() != null) {
				err = err.getCause();

				if (err instanceof SQLException) {
					throw new EMRException(MessageCode.EMR_B_P909E, e);
				}
			}
			throw new EMRException(MessageCode.EMR_B_P910E, e);
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}


	/**
	 * SQL�Z�b�V�������擾����B
	 * <OL>
	 *  <LI>JDBC�ڑ��p�v���p�e�B���擾����B</LI>
	 *  <LI>MyBATIS�ݒ�t�@�C����Ǎ��ށB</LI>
	 *  <LI>JDBC�ڑ��p�v���p�e�B�AMyBATIS�ݒ�t�@�C������A
	 *�Z�b�V�����t�@�N�g���[�𐶐�����B</LI>
	 *  <LI>�Z�b�V�����t�@�N�g���[����AAutoCommit:true�̃Z�b�V�������擾����B</LI>
	 *  <LI>��L�̏����ŗ�O�����������ꍇ�́A
	 *����������O�ɉ������G���[�R�[�h��EMRException�𐶐�����throw����B</LI>
	 *  <LI>�擾�����Z�b�V������ԋp����B</LI>
	 * </OL>
	 * @return SQL�Z�b�V����
	 * @throws EMRException
	 *             �Ɩ���O
	 */
	private SqlSession getSqlSession() throws EMRException {
		Properties props = getDBProperties();
		SqlSession session = null;

		try {
			Reader reader = Resources
					.getResourceAsReader(PDSConstants.CONF_MY_BATIS.toString());
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sesseionFactory = builder.build(reader, props);

			session = sesseionFactory.openSession(true);
		} catch (IOException e) {
			throw new EMRException(MessageCode.EMR_B_P904E,
					new Object[] { PDSConstants.CONF_MY_BATIS.toString() });
		} catch (RuntimeException e) {
			throw new EMRException(MessageCode.EMR_B_P903E, e);
		}
		return session;
	}

	/**
	 * DB�ڑ����̃v���p�e�B�擾�B
	 *
	 * @return DB�ڑ����̃v���p�e�B
	 */
	private Properties getDBProperties() {
		Properties props = new Properties();

		props.setProperty(PDSConstants.JDBC_DRIVER.toString(), driver);
		props.setProperty(PDSConstants.JDBC_URL.toString(), url);
		props.setProperty(PDSConstants.JDBC_USER_NAME.toString(), userName);
		props.setProperty(PDSConstants.JDBC_PASSWORD.toString(), password);

		return props;
	}

	/**
	 * �Č��R�[�h�`�F�b�N�B
	 * <OL>
	 *  <LI>�Č��R�[�h�̑��݃`�F�b�N������B</LI>
	 *  <LI>��L�̃`�F�b�N�Ɏ��s�����ꍇ�́AEMRException�𐶐�����throw����B</LI>
	 * </OL>
	 * @param session SQL�Z�b�V����
	 * @throws EMRException - �Č��R�[�h�����݂��Ȃ��ꍇ
	 */
	private void checkProductCd(SqlSession session) throws EMRException {
		ProductMapper pMapper = session.getMapper(ProductMapper.class);

		if (pMapper.count(productCd) < 1) {
			throw new EMRException(MessageCode.EMR_B_P906E,
					new Object[] { productCd });
		}
	}

}
