package jp.escofi.emr.engine.common.constant;

/**
 * �����^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�l�̑����^�C�v��`enum�N���X�B
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
public enum DataType {
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
	private DataType(String value) {
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
	public static DataType getType(String value) {

		for (DataType type : values()) {
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
		return value;
	}


}
