package jp.escofi.emr.engine.common.constant;

/**
 * ���Z�q�̒�`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���Z�q��ނ��`����enum�N���X�B
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
public enum ConditionType {

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
	CONDITION_NOT_EQ,
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
	CONDITION_NOT_IN,
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
	CONDITION_NOT_INTERSECT,
	/**
	 * �֌W���Z�q�E�^�C�v�FSTARTSWITH
	 */
	CONDITION_START_SWITH,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTSTARTSWITH
	 */
	CONDITION_NOT_START_SWITH,
	/**
	 * �֌W���Z�q�E�^�C�v�FSUBSET
	 */
	CONDITION_SUBSET,
	/**
	 * �֌W���Z�q�E�^�C�v�FNOTSUBSET
	 */
	CONDITION_NOT_SUBSET,

}
