package jp.escofi.emr.engine.condition;

/**
 * �I�y�����h�N���X�B
 * <BR>���Z�����֌W���Z���̏ꍇ�A���Z�q�ɂ�锻��ΏۂɂȂ镔����"�I�y�����h"�Ƃ���B
 * <BR>�I�y�����h�ɂ͕ϐ��ƒ萔������B
 * <DL>
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
public abstract class AbstractOperand {

	/**
	 * �I�y�����h�̒l
	 */
	protected Object value;

	/**
	 * �I�y�����h�̒l�̃Q�b�^�[���\�b�h
	 * @return �I�y�����h�̒l
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * �I�y�����h�̒l�̃Z�b�^�[���\�b�h
	 * @param value �I�y�����h�̒l
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
