package jp.iwin.pds.xml2db.engine;

import java.util.Properties;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.exception.PEXInitializeException;
import jp.iwin.pds.xml2db.common.util.PUTMessageUtil;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.common.util.SqlSessionUtil;
import jp.iwin.pds.xml2db.initialload.PILInitialLoader;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHKeyItemHandlerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ��̓G���W���N���X�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>
 *    <UL>
 *     <LI>�I�������������ꂽ�f�[�^���f����ێ����A���������������s���G���W���{�̃N���X�B
 *     <LI>PDS�I�u�W�F�N�g��PDS�I�u�W�F�N�g�L�[���ڂ͑��N���X����̃A�N�Z�X�𐧌����邽�߁A��̓G���W���̃����o�[�ϐ��Ƃ��ĕێ�����B
 *     <LI>�P�񃍁[�h�����Ǝg���܂킹�邱�Ƃ⃊�\�[�X�̐ߖ���l�����A
 *         ��̓G���W���̃C���X�^���X�́A�V�X�e����P�̂݁A�C�j�V�������[�h�̍ۂɐ�������B�iSingleton�j
 *    </UL>
 *  <DT>�ŏI�J�����r�W�����F
 *    <DD>$Revision: 1606 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-14 16:05:19 +0900 (火, 14 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.engine.PENServiceAPI
 * @see jp.iwin.pds.initialload.PILInitialLoader
 * @see jp.iwin.pds.dumptool.PDMObjectWriter
 * @version 1.0
 * @since 1.0
 * @author $Author: song.ck $
 */
public class PENEngine {

	/**
	 * ���O�o��
	 */
	private static final Log logger = LogFactory.getLog(PENEngine.class);


	/**
	 * �C�j�V�������[�h�ς݃t���O�Ftrue�i���[�h�ς݁j�Afalse�i�����[�h�j<br>
	 * 	<DL>
	 *  <DT style='color: red'>���ӎ����F
	 *   <DD style='color: red; font-weight: bold'>
	 *    true�i���[�h�ς݁j��ݒ肷��͉̂�̓G���W���݂̂ł���B
	 * </DL>
	 *
	 */
	private static boolean isLoaded = false;

	public static void excuteXML2DB() throws PEXInitializeException {
//		if (instance == null) {
			new PENEngine();
//		}
//		return instance;
	}

	public static void excuteXML2DB(Properties props) throws PEXInitializeException {
			new PENEngine(props);
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *	<DT>�g�p�ړI/�@�\�T�v�F
	 *	 <DD>���N���X����̃R���X�g���N�^�̐�����h�����߁A�f�t�H���g�R���X�g���N�^��private�ɂ���B
	 * </DL>
	 * @throws PEXInitializeException	�C�j�V�������[�h��O
	 */
	private PENEngine() throws PEXInitializeException {
		init();
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *	<DT>�g�p�ړI/�@�\�T�v�F
	 *	 <DD>���N���X����̃R���X�g���N�^�̐�����h�����߁A�f�t�H���g�R���X�g���N�^��private�ɂ���B
	 * </DL>
	 * @throws PEXInitializeException	�C�j�V�������[�h��O
	 */
	private PENEngine(Properties props) throws PEXInitializeException {
		init(props);
	}

	/**
	 * ���������B
	 * <DL>
	 *	<DT>�g�p�ړI/�@�\�T�v�F
	 *	 <DD>
	 *    <UL>
	 *     <LI>�C�j�V�������[�h���s���APDS�I�u�W�F�N�g�APDS�I�u�W�F�N�g�L�[���ڂɂ��̌��ʂ�ݒ肷��B
	 *     <LI>�R���X�g���N�^����ďo�����B
	 *    </UL>
	 *  <DT style='color: red'>���ӎ����F
	 *   <DD style='color: red; font-weight: bold'>
	 *    �C�j�V�������[�h��A�C�j�V�������[�h�ς݃t���O��true�ɐݒ肷��B
	 * </DL>
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 * @see jp.iwin.pds.common.exception.PEXInitializeException
	 * @throws PEXInitializeException �C�j�V�������[�h��O�B<br>
	 *         ��O�������ɂ̓A���[�g�ʒm���s���B�V�X�e���Ƃ��ĉ񕜕s�\�ȗ�O�ł��邽�߁ARuntimeException�Ƃ��č쐬����B
	 */
	private void init() throws PEXInitializeException {

		try {
			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P012I.toString()));
			 SqlSessionUtil.getSqlSession();
			 SqlSessionUtil.deleteAll();

			 new PILInitialLoader();

			 isLoaded = true;

			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P013I.toString()));

		} catch (PEXException e) {
			if (e.getCause() == null) {
				// ������O�̃g���[�X�����o��
				throw new PEXInitializeException(PCTMessageCode.P009E, e);
			} else {
				// ������O�̃g���[�X���͏o�͍ς݂Ȃ̂ŁA�G���[���b�Z�[�W�̂�
				throw new PEXInitializeException(PCTMessageCode.P009E);
			}
		} catch (Exception e) {
			// ������O�̃g���[�X�����o��
			throw new PEXInitializeException(PCTMessageCode.P009E, e);
		}finally{
			 SqlSessionUtil.closeSqlSession();
		}
	}

	/**
	 * ���������B
	 * <DL>
	 *	<DT>�g�p�ړI/�@�\�T�v�F
	 *	 <DD>
	 *    <UL>
	 *     <LI>�C�j�V�������[�h���s���APDS�I�u�W�F�N�g�APDS�I�u�W�F�N�g�L�[���ڂɂ��̌��ʂ�ݒ肷��B
	 *     <LI>�R���X�g���N�^����ďo�����B
	 *    </UL>
	 *  <DT style='color: red'>���ӎ����F
	 *   <DD style='color: red; font-weight: bold'>
	 *    �C�j�V�������[�h��A�C�j�V�������[�h�ς݃t���O��true�ɐݒ肷��B
	 * </DL>
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 * @see jp.iwin.pds.common.exception.PEXInitializeException
	 * @param props DB�ڑ����
	 * @throws PEXInitializeException �C�j�V�������[�h��O�B<br>
	 *         ��O�������ɂ̓A���[�g�ʒm���s���B�V�X�e���Ƃ��ĉ񕜕s�\�ȗ�O�ł��邽�߁ARuntimeException�Ƃ��č쐬����B
	 */
	private void init(Properties props) throws PEXInitializeException {

		try {
			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P012I.toString()));
			 SqlSessionUtil.getSqlSession(props);
			if(Boolean.valueOf(PUTPropertyUtil.getProperty("DBDeleteFlg"))){
				 SqlSessionUtil.deleteAll();
				 PCHKeyItemHandler.anser_no=0;
				 PCHKeyItemHandler.args_elem_id=0;
				 PCHKeyItemHandler.attribute_value_id=0;
				 PCHKeyItemHandler.attribute_group_id=0;
				 PCHKeyItemHandler.attribute_field_id=0;
				 PCHKeyItemHandler.attribute_elem_id=0;
				 PCHKeyItemHandlerFactory.datamodel_id=0;
				 PCHKeyItemHandlerFactory.key_solve_id=0;

			}
			 new PILInitialLoader();

			 isLoaded = true;

			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P013I.toString()));

		} catch (PEXException e) {
			if (e.getCause() == null) {
				// ������O�̃g���[�X�����o��
				throw new PEXInitializeException(PCTMessageCode.P009E, e);
			} else {
				// ������O�̃g���[�X���͏o�͍ς݂Ȃ̂ŁA�G���[���b�Z�[�W�̂�
				throw new PEXInitializeException(PCTMessageCode.P009E);
			}
		} catch (Exception e) {
			// ������O�̃g���[�X�����o��
			throw new PEXInitializeException(PCTMessageCode.P009E, e);
		}finally{
			 SqlSessionUtil.closeSqlSession();
		}
	}

	/**
	 * �C�j�V�������[�h�ς݃t���O�̎擾����
	 * <DL>
	 *	<DT>�g�p�ړI/�@�\�T�v�F
	 *	 <DD>
	 *    <UL>
	 *     <LI>�C�j�V�������[�h�ς݃t���O��ԋp����B
	 *    </UL>
	 * </DL>
	 * @throws true �C�j�V�������[�h�ς݁Afalse �C�j�V�������[�h�����{
	 */
	protected static boolean isLoaded() {
		return isLoaded;
	}

}
