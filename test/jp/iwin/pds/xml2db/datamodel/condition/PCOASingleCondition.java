package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

/**
 * �֌W���Z���N���X�B
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
 * @see jp.iwin.pds.datamodel.condition.PCOACondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOASingleCondition extends PCOACondition {

	/**
	 * �I�y�����h���X�g
	 */
	protected List<PCOAOperand> items;

	/**
	 * �R���X�g���N�^�B
	 * @param items  �I�y�����h���X�g
	 */
	public PCOASingleCondition(List<PCOAOperand> items) {
		this.items = items;
	}

	/**
	 * �������ڂ̒萔�����͕ϐ����̒l��Ԃ��B
	 * @param operand �I�y�����h
	 * @param argItems �������ڂ�Map�^�I�u�W�F�N�g
	 * @return result �������ڂ̒萔�����͕ϐ����̒l
	 */
	protected Object assign(PCOAOperand operand, Map<String, Object> argItems) {

		Object result;

		if (operand instanceof PCOOperandVar) {
			PCOOperandVar itemVar = (PCOOperandVar) operand;
			result = (argItems.get(itemVar.getName()));
		} else {
			result = ((PCOOperandConst) operand).getValue();
		}

		return result;
	}

}
