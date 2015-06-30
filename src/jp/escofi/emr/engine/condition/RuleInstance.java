package jp.escofi.emr.engine.condition;

import java.util.Map;

import org.xml.sax.SAXException;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.ResultObject;


/**
 * �������� �������i�G���W���p�j�N���X�B
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
public class RuleInstance implements Rule {

	/**
	 * ���Z���N���X
	 */
	private AbstractCondition pdsCondition;
	/**
	 * Then������
	 */
	private Rule thenRule;
	/**
	 * Else������
	 */
	private Rule elseRule;
	/**
	 * Then�A�N�V����
	 */
	private AbstractAction thenAction;
	/**
	 * Else�A�N�V����
	 */
	private AbstractAction elseAction;
	/**
	 * ��������Map
	 */
	private Map<String, ConditionItemInfo> conditionItemMap;

	/**
	 * �R���X�g���N�^
	 */
	public RuleInstance() {}

	/**
	 *  �R���X�g���N�^
	 * @param condition ���Z��
	 * @param thenRule Then������
	 * @param elseRule Else������
	 * @param thenAction Then�A�N�V����
	 * @param elseAction Else�A�N�V����
	 * @param conditionItemMap ��������
	 */
	public RuleInstance(AbstractCondition condition, Rule thenRule, Rule elseRule,
			AbstractAction thenAction, AbstractAction elseAction,
			Map<String, ConditionItemInfo> conditionItemMap) {
		this.pdsCondition = condition;
		this.thenRule = thenRule;
		this.elseRule = elseRule;
		this.thenAction = thenAction;
		this.elseAction = elseAction;
		this.conditionItemMap = conditionItemMap;
	}

	/**
	 * ����������������B�i�ċA�����j
	 *
	 * @param argItems �������ڒl�}�b�v
	 * @return �����l�I�u�W�F�N�g
	 * @throws ConditionNotMatchedException �����s������O
	 */
	public ResultObject apply(Map<String, Object> argItems) throws ConditionNotMatchedException {

		if (pdsCondition.isJudge(argItems)) {
			if (thenRule != null) {
				return thenRule.apply(argItems);
			} else {
				return thenAction.getResultObject();
			}
		} else {
			if (elseRule != null) {
				return elseRule.apply(argItems);
			} else {
				if (elseAction == null) {
					throw new ConditionNotMatchedException(MessageCode.EMR_A_P007E, new Object[]{argItems});
				}
				return elseAction.getResultObject();
			}
		}
	}

	/**
	 * ��������Map�̃Q�b�^�[
	 * @return ��������Map
	 */
	public Map<String, ConditionItemInfo> getConditionItemMap() {
		return conditionItemMap;
	}

	/**
	 * ���������������o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����������������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	public void toDump(XMLWriter writer) throws SAXException {
		writer.startElement(ElementType.CONDITION.toString());
		writer.startElement(ElementType.IF.toString());

		writer.startElement(ElementType.APPLY.toString());
		pdsCondition.toDump(writer, conditionItemMap);
		writer.endElement(ElementType.APPLY.toString());

		if (thenRule != null) {
			((InitRule) thenRule).toDump(writer, conditionItemMap);
		} else {
			thenAction.toDump(writer);
		}
		writer.endElement(ElementType.IF.toString());

		if (elseRule != null) {
			((InitRule) elseRule).toDump(writer, conditionItemMap);
		}
		if (elseAction != null) {
			writer.startElement(ElementType.ELSE.toString());
			elseAction.toDump(writer);
			writer.endElement(ElementType.ELSE.toString());
		}
		writer.endElement(ElementType.CONDITION.toString());

	}
}
