package jp.escofi.emr.engine.search;

import java.util.Map;

import jp.escofi.emr.engine.common.constant.Status;

/**
 * PDS�����N���X�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>
 *    <UL>
 *     <LI>��������ɕK�v�Ȉ������ڂ̎擾����������ڒl�A�������ʃX�e�[�^�X�A�����l��ێ�����N���X�B
 *     <LI>API���񋟂���������ڎ擾���\�b�h�̖߂�l�y�����l�擾���\�b�h�̈����N���X�Ƃ��Ĕėp�I�ɗ��p����B
 *    </UL>
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
public class PDSResponse {

	/**
	 * �������ʃX�e�[�^�X
	 */
	private Status status;
	/**
	 * �������ڎ擾�p�}�b�v�i�G���W������ݒ�j
	 */
	private Map<String, ConditionItemInfo> conditionItemInfoMap;
	/**
	 * ��������p�̈������ڒl�}�b�v�i�Ɩ����b�p�[���ݒ�j
	 */
	private Map<String, Object> conditionItemValueMap;
	/**
	 * �����l�I�u�W�F�N�g
	 */
	private ResultObject resultObject;
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
	protected PDSResponse() {}

	/**
	 * �������ڎ擾�p�}�b�v�擾�B
	 * <DL>
	 *	 <DT>�g�p�ړI/�@�\�T�v�F
	 *	  <DD>�������ڎ擾�p�}�b�v���擾����B
	 * </DL>
	 * @return �������ڎ擾�p�}�b�v
	 */
	public Map<String, ConditionItemInfo> getConditionItemInfoMap() {
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
	protected void setConditionItemInfoMap(Map<String, ConditionItemInfo> conditionItemInfoMap) {
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
	public Status getStatus() {
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
	protected void setStatus(Status status) {
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
	public ResultObject getResultObject() {
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
	protected void setResultObject(ResultObject resultObject) {
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
