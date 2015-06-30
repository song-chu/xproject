package jp.escofi.emr.engine.loader;

import java.util.Map;

import jp.escofi.emr.engine.search.ConditionItemInfo;


/**
 * ���[���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���[���n���h���[�S�̋��ʏ������L�ڂ���SAX�C�x���g�n���h���[�̐e�N���X�B�i���ۃN���X�j
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
public abstract class AbstractRuleHandler extends AbstractDelegateHandler {

	/**
	 * �������ڃ}�b�v
	 */
	protected Map<String, ConditionItemInfo> conditionItemMap;


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �ďo�����n���h���[�����[���n���h���[�̃T�u�N���X�̏ꍇ�́A�������ڃ}�b�v�����p���B
	 * </P>
	 * @param callerHandler �ďo�����n���h���[
	 */
	public AbstractRuleHandler(AbstractDelegateHandler callerHandler) {

		super(callerHandler);

		if (callerHandler instanceof AbstractRuleHandler) {
			conditionItemMap = ((AbstractRuleHandler) callerHandler).conditionItemMap;
		}
	}

}
