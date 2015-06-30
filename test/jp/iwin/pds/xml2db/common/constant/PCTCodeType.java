package jp.iwin.pds.xml2db.common.constant;


/**
 * ����Java�f�[�^�^�̃^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>����Java�f�[�^�^�̃^�C�v���`����enum�N���X�B
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
public enum PCTCodeType {

	/**
	 * �f�[�^�^�FInteger
	 */
	INTEGER("java.lang.Integer"),
	/**
	 * �f�[�^�^�FBoolean
	 */
	BOOLEAN("java.lang.Boolean"),
	;

	/**
	 * �Ή����������Java�f�[�^�^
	 */
	private String value;

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�R���X�g���N�^�N���X�B
	 * </DL>
	 * @param value �Ή����������Java�f�[�^�^
	 */
	private PCTCodeType(String value) {
		this.value = value;
	}


	/**
	 * ����Java�f�[�^�^�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>������\����Ή��������Java�f�[�^�^��Ԃ��B
	 * </DL>
	 * @return ����Java�f�[�^�^
	 */
	@Override
	public String toString() {
		return this.value.intern();
	}

}
