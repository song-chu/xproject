package jp.iwin.pds.xml2db.common.constant;

/**
 * �����^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�l�̑����^�C�v��`enum�N���X�B
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
public enum PCTDataType {
	/**
	 * �͈�
	 */
	RANGE("range"),
	/**
	 * �I�u�W�F�N�g
	 */
	OBJECT("object"),
	/**
	 * �P��
	 */
	SINGLE("single"),
	/**
	 * ���X�g
	 */
	LIST("list"),
	/**
	 * �}�b�v
	 */
	MAP("map"),
	/**
	 * �Z�b�g
	 */
	SET("set"),
	/**
	 * ���̑�
	 */
	OTHER("");

	/**
	 * �Ή�������l�̑����^�C�v
	 */
	private String value;

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�R���X�g���N�^�N���X�B
	 * </DL>
	 * @param value �Ή�������l�̑����^�C�v
	 */
	private PCTDataType(String value) {
		this.value = value;
	}

	/**
	 * �����^�C�v�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�l�̑����^�C�v���擾����B
	 *   <DD>��`�O�̒l�̑����^�C�v���w�肳�ꂽ�ꍇ�́A{@link #OTHER}��ԋp����B
	 * </DL>
	 * @param value �l�̑����^�C�v
	 * @return �l�̑����^�C�v�ɑΉ����������^�C�v
	 */
	public static PCTDataType getType(String value) {

		for (PCTDataType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		return OTHER;
	}

	/**
	 * �l�̑����^�C�v�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�Ή�����l�̑����^�C�v�̕�����\����Ԃ��B
	 * </DL>
	 * @return �l�̑����^�C�v�̕�����\��
	 */
	@Override
	public String toString() {
		return this.value.intern();
	}


}
