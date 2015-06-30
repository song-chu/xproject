package jp.iwin.pds.xml2db.common.constant;

/**
 * ���b�Z�[�W��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�G���W���ɂė��p���郁�b�Z�[�W�̒u�������񕔕����`����enum�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1037 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:21:17 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public enum PCTMessageType {

	/**
	 * XML�Ǘ�
	 */
	XMLMETA("XML�Ǘ�"),
	/**
	 * �f�[�^���f��
	 */
	DATAMODEL("�f�[�^���f��"),
	/**
	 * �����L�[
	 */
	KEYLIST("�����L�["),
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
	private PCTMessageType(String value) {
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
		return this.value.intern();
	}

}
