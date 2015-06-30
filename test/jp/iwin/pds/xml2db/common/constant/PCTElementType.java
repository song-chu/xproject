package jp.iwin.pds.xml2db.common.constant;

import jp.iwin.pds.xml2db.common.exception.PEXException;

/**
 * �G�������g�^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�G�������g�̃^�C�v���`����enum�N���X�B
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
public enum PCTElementType {
	/**
	 * XML�Ǘ�
	 */
	DATAMODELINFO("datamodelinfo"),
	/**
	 * �f�[�^���f��
	 */
	DATAMODEL("datamodel"),
	/**
	 * �L�[����
	 */
	KEYITEM("keyitem"),
	/**
	 * ������
	 */
	ATTRNAME("attrname"),
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
	 * �������J�b�R
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
	NOTEQ("neq"),
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
	NOTIN("notin"),
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
	STARTSWITH("startswith"),
	/**
	 * �֌W���Z�qNOTSTARTSWITH
	 */
	NOTSTARTSWITH("nstartswith"),
	/**
	 * �֌W���Z�qSUBSET
	 */
	SUBSET("subset"),
	/**
	 * �֌W���Z�qNOTSUBSET
	 */
	NOTSUBSET("nsubset"),
	/**
	 * �֌W���Z�qINTERSECT
	 */
	INTERSECT("intersect"),
	/**
	 * �֌W���Z�qNOTINTERSECT
	 */
	NOTINTERSECT("nintersect"),
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
	private PCTElementType(String value) {
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
	public static PCTElementType getType(String value) {

		for (PCTElementType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		// TODO �Ή�������G���[�R�[�h�����܂�܂ł̉��B
		// value�Ɏw�肳�ꂽ�l�����O�֏o�͂���
		PEXException e = new PEXException(PCTMessageCode.P010E);
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
		return this.value.intern();
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
	public boolean equals(String value) {
		return this.value.equals(value);
	}

}
