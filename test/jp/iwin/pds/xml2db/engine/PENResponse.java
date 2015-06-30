package jp.iwin.pds.xml2db.engine;

import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;

/**
 * PDS�����N���X�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>
 *    <UL>
 *     <LI>��������ɕK�v�Ȉ������ڂ̎擾����������ڒl�A�������ʃX�e�[�^�X�A�����l��ێ�����N���X�B
 *     <LI>API���񋟂���������ڎ擾���\�b�h�̖߂�l�y�����l�擾���\�b�h�̈����N���X�Ƃ��Ĕėp�I�ɗ��p����B
 *    </UL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1053 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:57:40 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.engine.PENEngine
 * @see jp.iwin.pds.engine.PENServiceAPI
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PENResponse {

	/**
	 * �������ʃX�e�[�^�X
	 */
	private PCTStatus status;
	/**
	 * �������ڎ擾�p�}�b�v�i�G���W������ݒ�j
	 */
	private Map<String, PROConditionItemInfo> conditionItemInfoMap;
	/**
	 * ��������p�̈������ڒl�}�b�v�i�Ɩ����b�p�[���ݒ�j
	 */
	private Map<String, Object> conditionItemValueMap;
	/**
	 * �����l�I�u�W�F�N�g
	 */
	private PROResultObject resultObject;
	/**
	 * �����L���t���O
	 */
	private boolean conditionFlag;
	/**
	 * ���^���
	 */
	private String metaInfo;

	 /**
	  * �R���X�g���N�^�B
	  * <DL>
	  *	 <DT>�g�p�ړI/�@�\�T�v�F
	  *	  <DD>�G���W���O������C���X�^���X�����𐧌����邽��protected��ݒ肷��B
	  * </DL>
	  */
	protected PENResponse() {}

	/**
	 * �������ڎ擾�p�}�b�v�擾�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�������ڎ擾�p�}�b�v���擾����B
	 * </DL>
	 * @return �������ڎ擾�p�}�b�v
	 */
	public Map<String, PROConditionItemInfo> getConditionItemInfoMap() {
		return conditionItemInfoMap;
	}

	/**
	 * �������ڎ擾�p�}�b�v��ݒ�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�G���W���O������̃A�N�Z�X�𐧌����邽��protected��ݒ肷��B
	 * </DL>
	 * @param conditionItemInfoMap ��������p�������ڃ}�b�v
	 */
	protected void setConditionItemInfoMap(Map<String, PROConditionItemInfo> conditionItemInfoMap) {
		this.conditionItemInfoMap = conditionItemInfoMap;
	}

	/**
	 * ��������p�������ڃ}�b�v�擾�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>��������p�������ڃ}�b�v���擾����B
	 * </DL>
	 * @return ��������p�������ڃ}�b�v
	 */
	public Map<String, Object> getConditionItemValueMap() {
		return conditionItemValueMap;
	}

	/**
	 * ��������p�������ڃ}�b�v��ݒ�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>��������p�������ڃ}�b�v��ݒ肷��B
	 * </DL>
	 * @param conditionItemValueMap ��������p�������ڃ}�b�v
	 */
	public void setConditionItemValueMap(Map<String, Object>conditionItemValueMap) {
		this.conditionItemValueMap = conditionItemValueMap;
	}

	/**
	 * �������ʃX�e�[�^�X�擾�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�������ʃX�e�[�^�X���擾����B
	 * </DL>
	 * @return �������ʃX�e�[�^�X
	 */
	public PCTStatus getStatus() {
		return status;
	}

	/**
	 * �������ʃX�e�[�^�X��ݒ�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�G���W���O������̃A�N�Z�X�𐧌����邽��protected��ݒ肷��B
	 * </DL>
	 * @param status �������ʃX�e�[�^�X
	 */
	protected void setStatus(PCTStatus status) {
		this.status = status;
	}

	/**
	 * �����l�I�u�W�F�N�g�擾�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�����l�I�u�W�F�N�g���擾����B
	 * </DL>
	 * @return �����l�I�u�W�F�N�g
	 */
	public PROResultObject getResultObject() {
		return resultObject;
	}

	/**
	 * �����l�I�u�W�F�N�g��ݒ�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�G���W���O������̃A�N�Z�X�𐧌����邽��protected��ݒ肷��B
	 * </DL>
	 * @param resultObject �����l�I�u�W�F�N�g
	 */
	protected void setResultObject(PROResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * �����L���t���O�ԋp�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�����L���t���O��ԋp����B
	 * </DL>
	 * @return �����L���t���O
	 */
	public boolean isCondition() {
		return conditionFlag;
	}

	/**
	 * �����L���t���O��ݒ�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�G���W���O������̃A�N�Z�X�𐧌����邽��protected��ݒ肷��B
	 * </DL>
	 * @param conditionFlag �����L���t���O
	 */
	protected void setConditionFlag(boolean conditionFlag) {
		this.conditionFlag = conditionFlag;
	}

	/**
	 * ���^���ݒ�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>���^����ݒ肷��B�G���W���O������̃A�N�Z�X�𐧌����邽��protected��ݒ肷��B
	 * </DL>
	 * @param metaInfo ���^���
	 */
	protected void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
	}

	/**
	 * ���^���擾�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>���^�����擾����B
	 * </DL>
	 * @return ���^���
	 */
	public String getMetaInfo() {
		return metaInfo;
	}
}
