package jp.escofi.emr.engine.common.constant;

/**
 * ���b�Z�[�W��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�G���W���ɂė��p���郁�b�Z�[�W�̒u�������񕔕����`����enum�N���X�B
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
public enum MessageType {

	/**
	 * XML�Ǘ�
	 */
	XML_META("XML�Ǘ�"),
	/**
	 * �f�[�^���f��
	 */
	DATA_MODEL("�f�[�^���f���w�l�k�t�@�C��"),
	/**
	 * �����L�[
	 */
	KEY_LIST("�����L�["),
	/**
	 * PDS�����N���X
	 */
	RESPONSE("PDS�����N���X"),
	;

	/**
	 * �Ή������镶����
	 */
	private String value;


	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�R���X�g���N�^�N���X�B
	 * </DL>
	 * @param value �Ή�������u��������
	 */
	private MessageType(String value) {
		this.value = value;
	}


	/**
	 * �G�������g���擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�Ή�����u���������Ԃ��B
	 * </DL>
	 * @return �u��������
	 */
	@Override
	public String toString() {
		return value;
	}

}
