package jp.escofi.emr.engine.common.constant;

import jp.escofi.emr.engine.common.exception.EMRException;

/**
 * �G�������g�^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�G�������g�̃^�C�v���`����enum�N���X�B
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
public enum ElementType {
	/**
	 * XML�Ǘ�
	 */
	DATA_MODEL_INFO("datamodelinfo"),
	/**
	 * �f�[�^���f��
	 */
	DATA_MODEL("datamodel"),
	/**
	 * �L�[����
	 */
	KEY_ITEM("keyitem"),
	/**
	 * ������
	 */
	ATTR_NAME("attrname"),
	/**
	 * �����l
	 */
	VALUE("value"),
	/**
	 * ����������
	 */
	RESULT("result"),
	/**
	 * ���X�g�^
	 */
	LIST("list"),
	/**
	 * �}�b�v�^
	 */
	MAP("map"),
	/**
	 * �͈͌^
	 */
	RANGE("range"),
	/**
	 * �I�u�W�F�N�g�^
	 */
	OBJECT("object"),
	/**
	 * �P��^
	 */
	SINGLE("single"),
	/**
	 * �G�������g
	 */
	ELEM("elem"),
	/**
	 * �G���g���[
	 */
	ENTRY("entry"),
	/**
	 * IF��
	 */
	IF("if"),
	/**
	 * ELSE��
	 */
	ELSE("else"),
	/**
	 * ������
	 */
	CONDITION("condition"),
	/**
	 * ����l
	 */
	UPPER("upper"),
	/**
	 * �����l
	 */
	LOWER("lower"),
	/**
	 * �Z�b�g
	 */
	SET("set"),
	/**
	 * �������萔
	 */
	CONST("const"),
	/**
	 * �������ϐ�
	 */
	VAR("var"),
	/**
	 * �������A�v���C
	 */
	APPLY("apply"),
	/**
	 * �_�����Z�qAND
	 */
	AND("and"),
	/**
	 * �_�����Z�qOR
	 */
	OR("or"),
	/**
	 * �֌W���Z�qEQ
	 */
	EQ("eq"),
	/**
	 * �֌W���Z�qNOTEQ
	 */
	NOT_EQ("neq"),
	/**
	 * �֌W���Z�qLT
	 */
	LT("lt"),
	/**
	 * �֌W���Z�qLEQ
	 */
	LEQ("leq"),
	/**
	 * �֌W���Z�qGT
	 */
	GT("gt"),
	/**
	 * �֌W���Z�qGEQ
	 */
	GEQ("geq"),
	/**
	 * �֌W���Z�qIN
	 */
	IN("in"),
	/**
	 * �֌W���Z�qNOTIN
	 */
	NOT_IN("notin"),
	/**
	 * �֌W���Z�qINCLUDE
	 */
	INCLUDE("include"),
	/**
	 * �֌W���Z�qEXCLUDE
	 */
	EXCLUDE("exclude"),
	/**
	 * �֌W���Z�qSTARTSWITH
	 */
	START_SWITH("startswith"),
	/**
	 * �֌W���Z�qNOTSTARTSWITH
	 */
	NOT_START_SWITH("nstartswith"),
	/**
	 * �֌W���Z�qSUBSET
	 */
	SUBSET("subset"),
	/**
	 * �֌W���Z�qNOTSUBSET
	 */
	NOT_SUBSET("nsubset"),
	/**
	 * �֌W���Z�qINTERSECT
	 */
	INTERSECT("intersect"),
	/**
	 * �֌W���Z�qNOTINTERSECT
	 */
	NOT_INTERSECT("nintersect"),
	/**
	 * ��
	 */
	EMPTY("empty"),
	;

	/**
	 * �Ή�������G�������g��
	 */
	private String value;

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�R���X�g���N�^�N���X�B
	 * </DL>
	 * @param value �Ή�������G�������g��
	 */
	private ElementType(String value) {
		this.value = value;
	}

	/**
	 * �G�������g�^�C�v�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�G�������g�^�C�v���擾����B
	 * </DL>
	 * @param value �G�������g��
	 * @return �G�������g���ɑΉ������G�������g�^�C�v
	 * @throws IllegalArgumentException �s��������O<BR>
	 * ��`�O�̃G�������g���̏ꍇ��O���X���[����B
	 */
	public static ElementType getType(String value) {

		for (ElementType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		// value�Ɏw�肳�ꂽ�l�����O�֏o�͂���
		EMRException e = new EMRException(MessageCode.EMR_A_P010E);
		throw new IllegalArgumentException(e);
	}

	/**
	 * �G�������g���擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>������\����Ή�����G�������g����Ԃ��B
	 * </DL>
	 * @return �G�������g��
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * �������v����B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���̃^�C�v�̕�����\���Ɣ�r�����񂪈�v���邩�𔻒肷��B
	 * </DL>
	 * @param value ��r������
	 * @return ��r����<BR>
	 *���̃^�C�v�̕�����\���Ɣ�r�����񂪈�v���Ă���΁Atrue
	 */
	public boolean isEquals(String value) {
		return value.equals(value);
	}

}
