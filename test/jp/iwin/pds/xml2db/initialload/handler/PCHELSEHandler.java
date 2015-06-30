package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHResultObjectHandlerFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * ELSE���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>ELSE���i{@code <else>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see PCHApplyHandler
 * @see PCHIFHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHELSEHandler extends PCHARuleHandler {

	/**
	 * ������
	 */
	private PROINIRule rule;

	/**
	 * ����qIF��ގ��ʎq
	 */
	private final PCTIFType childIFtype = PCTIFType.IF_ELSE;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ������
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHELSEHandler(PCHARuleHandler callerHandler, PROINIRule rule, XMLWriter writer) {

		super(callerHandler);
		this.writer=writer;
		this.rule = rule;
	}


	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �Q�ƒ��̃^�O���ȉ��̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�̃n���h���[�ɁA
	 *�Ή�����n���h���[��ݒ肷��B
	 * </P>
	 * <UL>
	 *  <LI>IF��</LI>
	 *  <LI>ELSE��</LI>
	 *  <LI>����������</LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHADelegateHandler handler = null;
		this.writer.startElement(qName);
		switch (elementType) {
		case IF:
			handler = PCHRuleHandlerFactory.createIFHandler(this, this.rule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = PCHRuleHandlerFactory.createELSEHandler(this, this.rule, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case RESULT:
			handler = PCHResultObjectHandlerFactory.createResultHandler(this, atts, this.rule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O��ELSE���̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�ɁA
	 *�p�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.ELSE.equals(qName)) {
			this.reader.setContentHandler(this.callerHandler);
		}
	}


	/**
	 * @param rule ������
	 * @see PCHIFHandler
	 */
	void setRule(PROINIRule rule) {
		this.rule = rule;
	}

}
