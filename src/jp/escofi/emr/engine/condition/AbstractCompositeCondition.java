package jp.escofi.emr.engine.condition;

import java.util.List;

/**
 * �_�����Z���B�_�����Z���ɂ�AND��OR������B
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
public abstract class AbstractCompositeCondition extends AbstractCondition {

	/**
	 * �{�_�����Z�����\�����鉉�Z����List
	 */
	protected List<AbstractCondition> conditions;

	/**
	 * ���Z�����X�g��ݒ肷��B
	 * @param conditions �{�_�����Z�����\�����鉉�Z����List
	 */
	public AbstractCompositeCondition(List<AbstractCondition> conditions) {
		this.conditions = conditions;
	}

}
