package jp.iwin.pds.xml2db.datamodel.condition;

/**
 * �I�y�����h�N���X�B
 * <BR>���Z�����֌W���Z���̏ꍇ�A���Z�q�ɂ�锻��ΏۂɂȂ镔����"�I�y�����h"�Ƃ���B
 * <BR>�I�y�����h�ɂ͕ϐ��ƒ萔������B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1120 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 17:38:14 +0900 (火, 07 12 2010) $
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
 * @author $Author: park.js $
 */
public abstract class PCOAOperand {

	/**
	 * �I�y�����h�̒l
	 */
	protected Object value;

	/**
	 * �I�y�����h�̒l�̃Q�b�^�[���\�b�h
	 * @return �I�y�����h�̒l
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * �I�y�����h�̒l�̃Z�b�^�[���\�b�h
	 * @param value �I�y�����h�̒l
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
