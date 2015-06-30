package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * �֌W���Z���N���X�B
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
public abstract class AbstractSingleCondition extends AbstractCondition {

	/**
	 * �I�y�����h���X�g
	 */
	protected List<AbstractOperand> items;

	/**
	 * �R���X�g���N�^�B
	 * @param items  �I�y�����h���X�g
	 */
	public AbstractSingleCondition(List<AbstractOperand> items) {
		this.items = items;
	}

	/**
	 * �������ڂ̒萔�����͕ϐ����̒l��Ԃ��B
	 * @param operand �I�y�����h
	 * @param argItems �������ڂ�Map�^�I�u�W�F�N�g
	 * @return result �������ڂ̒萔�����͕ϐ����̒l
	 */
	protected Object assign(AbstractOperand operand, Map<String, Object> argItems) {

		Object result;

		if (operand instanceof OperandVar) {
			OperandVar itemVar = (OperandVar) operand;
			result = (argItems.get(itemVar.getName()));
		} else {
			result = ((OperandConst) operand).getValue();
		}

		return result;
	}

}
