package jp.iwin.pds.xml2db.datamodel;

import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;


/**
 * �������� �������i�G���W���p�j�N���X�B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1104 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 15:13:14 +0900 (火, 07 12 2010) $
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
public class PRORule implements PROIRule {

	/**
	 * ���Z���N���X
	 */
	private PCOACondition pdsCondition;
	/**
	 * Then������
	 */
	private PROIRule thenRule;
	/**
	 * Else������
	 */
	private PROIRule elseRule;
	/**
	 * Then�A�N�V����
	 */
	private PROAction thenAction;
	/**
	 * Else�A�N�V����
	 */
	private PROAction elseAction;
	/**
	 * ��������Map
	 */
	private Map<String, PROConditionItemInfo> conditionItemMap;

	private Map<String,PROResultObject> resultMap ;

	public Map<String, PROResultObject> getresultMap() {
		return resultMap;
	}

	/**
	 * ������XML
	 */
	private String xml;


	public String getXml() {
		return xml;
	}

	/**
	 * �R���X�g���N�^
	 */
	public PRORule() {}

	/**
	 *  �R���X�g���N�^
	 * @param condition ���Z��
	 * @param thenRule Then������
	 * @param elseRule Else������
	 * @param thenAction Then�A�N�V����
	 * @param elseAction Else�A�N�V����
	 * @param conditionItemMap ��������
	 */
	public PRORule(PCOACondition condition, PROIRule thenRule, PROIRule elseRule,
			PROAction thenAction, PROAction elseAction,
			Map<String, PROConditionItemInfo> conditionItemMap, String xml,Map<String,PROResultObject> resultMap ) {
		this.pdsCondition = condition;
		this.thenRule = thenRule;
		this.elseRule = elseRule;
		this.thenAction = thenAction;
		this.elseAction = elseAction;
		this.conditionItemMap = conditionItemMap;
		this.xml = xml;
		this.resultMap = resultMap;
	}

	/**
	 * ����������������B�i�ċA�����j
	 *
	 * @param argItems �������ڒl�}�b�v
	 * @return �����l�I�u�W�F�N�g
	 * @throws PEXConditionNotMatchedException �����s������O
	 * @see jp.iwin.pds.datamodel.PROIRule#apply(java.util.Map)
	 */
	public PROResultObject apply(Map<String, Object> argItems) throws PEXConditionNotMatchedException {

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
					throw new PEXConditionNotMatchedException(PCTMessageCode.P007E, new Object[]{argItems});
				}
				return this.elseAction.getResultObject();
			}
		}
	}

	/**
	 * ��������Map�̃Q�b�^�[
	 * @return ��������Map
	 * @see jp.iwin.pds.datamodel.PROIRule#getConditionItemMap()
	 */
	public Map<String, PROConditionItemInfo> getConditionItemMap() {
		return this.conditionItemMap;
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
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		writer.startElement(PCTElementType.CONDITION.toString());
		writer.startElement(PCTElementType.IF.toString());

		writer.startElement(PCTElementType.APPLY.toString());
		this.pdsCondition.toDump(writer, this.conditionItemMap);
		writer.endElement(PCTElementType.APPLY.toString());

		if (this.thenRule != null) {
			((PROINIRule) this.thenRule).toDump(writer, this.conditionItemMap);
		} else {
			this.thenAction.toDump(writer);
		}
		writer.endElement(PCTElementType.IF.toString());

		if (this.elseRule != null) {
			((PROINIRule) this.elseRule).toDump(writer, this.conditionItemMap);
		}
		if (this.elseAction != null) {
			writer.startElement(PCTElementType.ELSE.toString());
			this.elseAction.toDump(writer);
			writer.endElement(PCTElementType.ELSE.toString());
		}
		writer.endElement(PCTElementType.CONDITION.toString());

	}
}
