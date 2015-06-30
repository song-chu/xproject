package jp.iwin.pds.xml2db.datamodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;

/**
 * �������� �������i�C�j�V�������[�_�p�j�N���X�B
 * <DL>
 * <DT>�ŏI�J�����r�W�����F
 * <DD>$Revision: 1104 $
 * <DT>�ŏI�J�������F
 * <DD>$Date: 2010-12-07 15:13:14 +0900 (火, 07 12 2010) $
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/12/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/12/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>
 * Copyright(c)2011 Nissay Information Technology Co.,Ltd.
 * </P>
 *
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public class PROINIRule implements PROIRule {

	/**
	 * ���Z���N���X
	 */
	private PCOACondition pdsCondition;
	/**
	 * THEN������
	 */
	private PROIRule thenRule;
	/**
	 * ELSE������
	 */
	private PROIRule elseRule;
	/**
	 * THEN�A�N�V����
	 */
	private PROAction thenAction;
	/**
	 * ELSE�A�N�V����
	 */
	private PROAction elseAction;
	/**
	 *
	 */
	private Map<String,PROResultObject> resutMap ;


	public Map<String, PROResultObject> getResutMap() {
		return resutMap;
	}

	public void setResutMap(Map<String, PROResultObject> resutMap) {
		this.resutMap = resutMap;
	}

	/**
	 * �R���X�g���N�^
	 */
	public PROINIRule() {
	}

	/**
	 * ����������������B�i�ċA�����j
	 *
	 * @param argItems
	 *            �������ڒl�}�b�v
	 * @return �����l�I�u�W�F�N�g
	 * @see jp.iwin.pds.datamodel.PROIRule#apply(java.util.Map)
	 */
	public PROResultObject apply(Map<String, Object> argItems)
			throws PEXConditionNotMatchedException {

		if (this.pdsCondition.judge(argItems)) {
			if (this.thenRule != null) {
				return thenRule.apply(argItems);
			} else {
				return this.thenAction.getResultObject();
			}
		} else {
			if (this.elseRule != null) {
				return elseRule.apply(argItems);
			} else {
				if (this.elseAction == null) {
					throw new PEXConditionNotMatchedException(
							PCTMessageCode.P007E, new Object[] { argItems });
				}
				return this.elseAction.getResultObject();
			}
		}
	}

	/**
	 * ���Z���̃Z�b�^�[
	 *
	 * @param pdsCondition
	 *            ���Z��
	 */
	public void setPdsCondition(PCOACondition pdsCondition) {
		this.pdsCondition = pdsCondition;
	}

	/**
	 * Then�������̃Z�b�^�[
	 *
	 * @param thenRule
	 *            Then������
	 */
	public void setThenRule(PROINIRule thenRule) {
		this.thenRule = thenRule;
	}

	/**
	 * Else�������̃Z�b�^�[
	 *
	 * @param elseRule
	 *            Else������
	 */
	public void setElseRule(PROINIRule elseRule) {
		this.elseRule = elseRule;
	}

	/**
	 * Then�A�N�V�����̃Z�b�^�[
	 *
	 * @param thenAction
	 *            Then�A�N�V����
	 */
	public void setThenAction(PROAction thenAction) {
		this.thenAction = thenAction;
	}

	/**
	 * Else�A�N�V�����̃Z�b�^�[
	 *
	 * @param elseAction
	 *            Else�A�N�V����
	 */
	public void setElseAction(PROAction elseAction) {
		this.elseAction = elseAction;
	}

	/**
	 * ���Z���̃Q�b�^�[
	 *
	 * @return ���Z��
	 */
	public PCOACondition getPdsCondition() {
		return this.pdsCondition;
	}

	/**
	 * Then�������̃Q�b�^�[
	 *
	 * @return thenRule Then������
	 */
	public PROIRule getThenRule() {
		return thenRule;
	}

	/**
	 * Else�������̃Q�b�^�[
	 *
	 * @return elseRule Else������
	 */
	public PROIRule getElseRule() {
		return elseRule;
	}

	/**
	 * Then�A�N�V�����̃Q�b�^�[
	 *
	 * @return Then�A�N�V����
	 */
	public PROAction getThenAction() {
		return this.thenAction;
	}

	/**
	 * Else�A�N�V�����̃Q�b�^�[
	 *
	 * @return Else�A�N�V����
	 */
	public PROAction getElseAction() {
		return this.elseAction;
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
	protected void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(PCTElementType.IF.toString());

		writer.startElement(PCTElementType.APPLY.toString());

		this.pdsCondition.toDump(writer, conditionItemMap);
		writer.endElement(PCTElementType.APPLY.toString());

		if (this.thenRule != null) {
			((PROINIRule) this.thenRule).toDump(writer, conditionItemMap);
		} else {
			this.thenAction.toDump(writer);
		}
		writer.endElement(PCTElementType.IF.toString());
		if (this.elseRule != null) {
			((PROINIRule) this.elseRule).toDump(writer, conditionItemMap);
		}
		if (this.elseAction != null) {
			writer.startElement(PCTElementType.ELSE.toString());
			this.elseAction.toDump(writer);
			writer.endElement(PCTElementType.ELSE.toString());
		}
	}
}
