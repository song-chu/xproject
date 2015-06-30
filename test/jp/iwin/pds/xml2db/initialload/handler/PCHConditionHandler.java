package jp.iwin.pds.xml2db.initialload.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.datamodel.PRORule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * �������n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃^�C�v���������̏ꍇ�A�������S�́i{@code <condition>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1059 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHIFHandler
 * @see PCHValueHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHConditionHandler extends PCHARuleHandler {

	/**
	 * ������
	 */
	private PROINIRule rule;
	/**
	 * �q������
	 */
	private PROINIRule childRule;
	/**
	 * IF-THEN-ELSE���ʎq
	 */
	private PCTIFType childIFtype = PCTIFType.IF_TOP;

	public static Map<String,PROResultObject> resultMap ;
	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHConditionHandler(PCHAResultObjectHandler callerHandler) {

		super(callerHandler);

		this.conditionItemMap = new HashMap<String, PROConditionItemInfo>();
		this.resultMap= new HashMap<String, PROResultObject>();
		this.writer.startElement(PCTElementType.CONDITION.toString());
	}


	/**
	 * �^�O�J�n�����B
	 * <UL>
	 *  <LI>�Ώۃ^�O��IF���̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>IF-THEN-ELSE���ʎq��TOP�̏ꍇ�́A
	 *�N���X�ϐ��F�q�������I�u�W�F�N�g���w�肵�ĐV�KIF���n���h���[�𐶐�����B</LI>
	 *    <LI>��L�ȊO�̏ꍇ�́A
	 *�N���X�ϐ��F�q�������I�u�W�F�N�g���w�肵�ĐV�KIF���n���h���[�𐶐�����B</LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɐ�������IF���n���h���[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�Ώۃ^�O��ELSE���̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�N���X�ϐ��F�q�������I�u�W�F�N�g���w�肵�ĐV�KELSE���n���h���[�𐶐�����B</LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɐ�������ELSE���n���h���[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);
		PROINIRule rule = this.childRule;
		PCHARuleHandler handler;
		this.writer.startElement(qName);
		switch (elementType) {
		case IF:

			if (PCTIFType.IF_TOP.equals(this.childIFtype)) {
				rule = this.rule;
			}
			handler = PCHRuleHandlerFactory.createIFHandler(
					this, rule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = PCHRuleHandlerFactory.createELSEHandler(
					this, rule,this.writer);
			this.reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���������̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�������I�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɐ��������������I�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.CONDITION.equals(qName)) {
			//�������ڏ��Map��ҏW�s�\�ɂ���B
			Collections.unmodifiableMap(this.conditionItemMap);

			// �������̌^�ϊ�(INIRule -> PDSRule)
			PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;

			handler.setValue(new PRORule(this.rule.getPdsCondition(),
					this.rule.getThenRule(), this.rule.getElseRule(),
					this.rule.getThenAction(), this.rule.getElseAction(),
					this.conditionItemMap,this.writer.getXML(),this.resultMap));

			this.reader.setContentHandler(handler);
		}
	}


	public Map<String, PROResultObject> getResultMap() {
		return resultMap;
	}

	public void putResutMap(String key, PROResultObject value) {
		this.resultMap.put(key, value);
	}


	/**
	 * @param childRule �q������
	 * @see PCHIFHandler
	 */
	void setChildRule(PROINIRule childRule) {
		this.childRule = childRule;
	}
	/**
	 * @param childIFtype IF-THEN-ELSE���ʎq
	 * @see PCHIFHandler
	 */
	void setChildIFtype(PCTIFType childIFtype) {
		this.childIFtype = childIFtype;
	}

	/**
	 * @param rule ������
	 * @see PCHIFHandler
	 */
	void setRule(PROINIRule rule) {
		this.rule = rule;
	}

}
