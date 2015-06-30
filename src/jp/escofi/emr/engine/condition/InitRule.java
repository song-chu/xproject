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
 * �������� �������i�C�j�V�������[�_�p�j�N���X�B
 * <DL>
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/08/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public class InitRule implements Rule {

	/**
	 * ���Z���N���X
	 */
	private AbstractCondition pdsCondition;
	/**
	 * THEN������
	 */
	private Rule thenRule;
	/**
	 * ELSE������
	 */
	private Rule elseRule;
	/**
	 * THEN�A�N�V����
	 */
	private AbstractAction thenAction;
	/**
	 * ELSE�A�N�V����
	 */
	private AbstractAction elseAction;

	/**
	 * �R���X�g���N�^
	 */
	public InitRule() {
	}

	/**
	 * ����������������B�i�ċA�����j
	 *
	 * @param argItems
	 *            �������ڒl�}�b�v
	 * @return �����l�I�u�W�F�N�g
	 */
	public ResultObject apply(Map<String, Object> argItems)
			throws ConditionNotMatchedException {

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
					throw new ConditionNotMatchedException(
							MessageCode.EMR_A_P007E, new Object[] { argItems });
				}
				return elseAction.getResultObject();
			}
		}
	}

	/**
	 * ���Z���̃Z�b�^�[
	 *
	 * @param pdsCondition
	 *            ���Z��
	 */
	public void setPdsCondition(AbstractCondition pdsCondition) {
		this.pdsCondition = pdsCondition;
	}

	/**
	 * Then�������̃Z�b�^�[
	 *
	 * @param thenRule
	 *            Then������
	 */
	public void setThenRule(InitRule thenRule) {
		this.thenRule = thenRule;
	}

	/**
	 * Else�������̃Z�b�^�[
	 *
	 * @param elseRule
	 *            Else������
	 */
	public void setElseRule(InitRule elseRule) {
		this.elseRule = elseRule;
	}

	/**
	 * Then�A�N�V�����̃Z�b�^�[
	 *
	 * @param thenAction
	 *            Then�A�N�V����
	 */
	public void setThenAction(AbstractAction thenAction) {
		this.thenAction = thenAction;
	}

	/**
	 * Else�A�N�V�����̃Z�b�^�[
	 *
	 * @param elseAction
	 *            Else�A�N�V����
	 */
	public void setElseAction(AbstractAction elseAction) {
		this.elseAction = elseAction;
	}

	/**
	 * ���Z���̃Q�b�^�[
	 *
	 * @return ���Z��
	 */
	public AbstractCondition getPdsCondition() {
		return pdsCondition;
	}

	/**
	 * Then�������̃Q�b�^�[
	 *
	 * @return thenRule Then������
	 */
	public Rule getThenRule() {
		return thenRule;
	}

	/**
	 * Else�������̃Q�b�^�[
	 *
	 * @return elseRule Else������
	 */
	public Rule getElseRule() {
		return elseRule;
	}

	/**
	 * Then�A�N�V�����̃Q�b�^�[
	 *
	 * @return Then�A�N�V����
	 */
	public AbstractAction getThenAction() {
		return thenAction;
	}

	/**
	 * Else�A�N�V�����̃Q�b�^�[
	 *
	 * @return Else�A�N�V����
	 */
	public AbstractAction getElseAction() {
		return elseAction;
	}

	/**
	 * �����������o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���������������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException XML��̓G���[
	 */
	protected void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
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
	}
}
