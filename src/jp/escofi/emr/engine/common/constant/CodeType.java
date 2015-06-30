package jp.escofi.emr.engine.common.constant;

import jp.escofi.emr.engine.common.util.MessageUtil;

/**
 * ����Java�f�[�^�^�̃^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>����Java�f�[�^�^�̃^�C�v���`����enum�N���X�B
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
public enum CodeType {

	/**
	 * �f�[�^�^�FString
	 */
	STRING("java.lang.String"),
	/**
	 * �f�[�^�^�FBoolean
	 */
	BOOLEAN("java.lang.Boolean"),
	/**
	 * �f�[�^�^�FInteger
	 */
	INTEGER("java.lang.Integer"),
	/**
	 * �f�[�^�^�FLong
	 */
	LONG("java.lang.Long"),
	/**
	 * �f�[�^�^�FDouble
	 */
	DOUBLE("java.lang.Double"),
	/**
	 * �f�[�^�^�FBigDecimal
	 */
	BIG_DECIMAL("java.math.BigDecimal"),
	/**
	 * �f�[�^�^�F��`�^�ȊO
	 */
	OTHER(null), ;

	/**
	 * �Ή����������Java�f�[�^�^
	 */
	private String value;

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�R���X�g���N�^�N���X�B
	 * </DL>
	 *
	 * @param value
	 *            �Ή����������Java�f�[�^�^
	 */
	private CodeType(String value) {
		this.value = value;
	}

	/**
	 * ����Java�f�[�^�^�擾�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>������\����Ή��������Java�f�[�^�^��Ԃ��B
	 * </DL>
	 *
	 * @return ����Java�f�[�^�^
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * ����Java�f�[�^�^�^�C�v�擾�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�l�̓���Java�f�[�^�^��ݒ�۔�����s������Ŏ擾����B
	 * <DD>��L�̔���ň�v���Ȃ��ꍇ��OTHER��Ԃ��B
	 * </DL>
	 *
	 * @param value
	 *            ����Java�f�[�^�^
	 * @return �l�̓���Java�f�[�^�^�ɑΉ���������Java�f�[�^�^�^�C�v
	 * @throws IllegalArgumentException
	 *             �s��������O<BR>
	 *             �g�p�s�̓���Java�f�[�^�^�̏ꍇ�A��O���X���[����B
	 */
	public static CodeType getType(String value) {

		try {
			Class<?> code = Class.forName(value);

			for (CodeType type : values()) {
				if (!OTHER.equals(type) &&
						Class.forName(type.value).isAssignableFrom(code)) {
					return type;
				}
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P011E.toString(), new String[] { value }), e);
		}

		return OTHER;
	}

}
