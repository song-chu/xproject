package jp.escofi.emr.engine.condition;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ConditionType;


/**
 * �_�����Z���iAND/OR�j�̐�����S������Facroty�N���X
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
public final class CompositeConditionFactory {

	/**
	 * �_�����Z���𐶐��A�ԋp����B
	 *
	 * @param conditions ���Z���̃��X�g
	 * @param conditionType ���Z�q���
	 * @return �_�����Z��
	 */
	public static AbstractCompositeCondition createCompositeCondition(List<AbstractCondition> conditions,
			ConditionType conditionType) {

		if (conditionType == ConditionType.CONDITION_AND) {
			return new LogicOperAND(conditions);
		} else {
			return new LogicOperOR(conditions);
		}
	}
}
