package jp.iwin.pds.xml2db.common.constant;

/**
 * ���Z�q�̒�`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���Z�q��ނ��`����enum�N���X�B
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
public enum PCTConditionType {

	/**
	 * �_�����Z�q�E�^�C�v�FAND
	 */
	CONDITION_AND,
	/**
	 * �_�����Z�q�E�^�C�v�FOR
	 */
	CONDITION_OR,
	/**
	 * �֌W���Z�q�E�^�C�v�FEQ
	 */
	CONDITION_EQ,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTEQ
	 */
	CONDITION_NOTEQ,
	/**
	 * �֌W���Z�q�E�^�C�v�FGEQ
	 */
	CONDITION_GEQ,
	/**
	 * �֌W���Z�q�E�^�C�v�FGT
	 */
	CONDITION_GT,
	/**
	 * �֌W���Z�q�E�^�C�v�FLEQ
	 */
	CONDITION_LEQ,
	/**
	 * �֌W���Z�q�E�^�C�v�FLT
	 */
	CONDITION_LT,
	/**
	 * �֌W���Z�q�E�^�C�v�FIN
	 */
	CONDITION_IN,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTIN
	 */
	CONDITION_NOTIN,
	/**
	 * �֌W���Z�q�E�^�C�v�FINCLUDE
	 */
	CONDITION_INCLUDE,
	/**
	 * �֌W���Z�q�E�^�C�v�FEXCLUDE
	 */
	CONDITION_EXCLUDE,
	/**
	 * �֌W���Z�q�E�^�C�v�FINTERSECT
	 */
	CONDITION_INTERSECT,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTINTERSECT
	 */
	CONDITION_NOTINTERSECT,
	/**
	 * �֌W���Z�q�E�^�C�v�FSTARTWITH
	 */
	CONDITION_STARTSWITH,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTSTARTWITH
	 */
	CONDITION_NOTSTARTSWITH,
	/**
	 * �֌W���Z�q�E�^�C�v�FSUBSET
	 */
	CONDITION_SUBSET,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTSUBSET
	 */
	CONDITION_NOTSUBSET,

}
