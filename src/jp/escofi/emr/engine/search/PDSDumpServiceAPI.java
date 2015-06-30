package jp.escofi.emr.engine.search;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;

/**
 * �_���vAPI�N���X�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�T�[�u���b�g�Ȃǂ̃N���C�A���gAP����Ăяo�����_���v���s���\�b�h��񋟂���API�N���X�B
 *  <DT>�T���v���R�[�h�F
 *   <DD>�N���C�A���g����̌ďo����
 *    <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'><TT>
 *    String filePath = "/pdsngine/dumpxml";
 *    String dataModelName = "provision";
 *
 *   try {
 *        //�_���v���s���\�b�h���Ăяo���B
 *        PDSDumpServiceAPI.excuteDump(filePath,dataModelName);
 *
 *    } catch (UnExpectedStateException e) {
 *        // ��O�����i�ȗ��j
 *    } catch (InvalidKeyException e) {
 *        // ��O�����i�ȗ��j
 *    } catch (InitializeException e) {
 *        // ��O�����i�ȗ��j
 *    } catch (DumpException e) {
 *        // ��O�����i�ȗ��j
 *    }
 *   </TT></PRE>
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/08/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */

public class PDSDumpServiceAPI {

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���N���X����̃R���X�g���N�^�̐�����h�����߁A�f�t�H���g�R���X�g���N�^��private�ɂ���B
	 * </DL>
	 */
	private PDSDumpServiceAPI() {
	}

	/**
	 * �_���v���s�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>XML�o�͐�ƃf�[�^���f��������̓G���W���֓n���A��̓G���W���̃_���v���s���\�b�h���Ăяo���B<BR>
	 *    <UL>
	 *     <LI>XML�o�͐�w�薳���̏ꍇ�A�v���p�e�B����擾
	 *     <LI>�f�[�^���f�������uall�v�Ɏw�肷��ꍇ�A�S�f�[�^���f����Ώۂɂ���B
	 *    </UL>
	 *  <DT>�g�p���@�F
	 *   <DD>�N���XJavaDoc�̃T���v���R�[�h���Q��
	 *  <DT style='color: red'>���ӎ����F
	 *   <DD style='color: red; font-weight: bold'>
	 *    �ďo�����͈����̃t�@�C���p�X���t���p�X�œn�����ƁB
	 * </DL>
	 *
	 * @param filePath �t�@�C���p�X
	 * @param dataModelName �f�[�^���f����
	 * @throws UnExpectedStateException �\���s�\��ԗ�O
	 * @throws InitializeException �C�j�V�������[�h��O
	 * @throws InvalidKeyException �L�[�s����O
	 * @throws DumpException �_���v��O
	 */
	public static void excuteDump(String filePath, String dataModelName)
			throws UnExpectedStateException, InitializeException,
			InvalidKeyException, DumpException {
		if (dataModelName==null){
			throw new InvalidKeyException(MessageCode.EMR_A_P015E, new Object[] {dataModelName});
		}
		if (!PDSEngine.isLoaded()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P008E);
		}
		PDSEngine.getInstance().excuteDump(filePath, dataModelName);
	}
}
