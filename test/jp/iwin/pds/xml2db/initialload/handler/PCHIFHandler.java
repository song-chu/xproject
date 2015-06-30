package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHResultObjectHandlerFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * IF���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>IF���i{@code <if>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHIFHandler extends PCHARuleHandler {

	/**
	 * �ďo����������
	 */
	private PROINIRule parentRule;
	/**
	 * ������
	 */
	private PROINIRule rule = new PROINIRule();
	/**
	 * ����q������
	 */
	private PROINIRule childRule;
	/**
	 * IF��ގ��ʎq
	 */
	private PCTIFType ifType;
	/**
	 * ����qIF��ގ��ʎq
	 */
	private PCTIFType childIFtype;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param parentRule �ďo����������
	 * @param ifType IF��ގ��ʎq
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHIFHandler(PCHARuleHandler callerHandler, PROINIRule parentRule, PCTIFType ifType, XMLWriter writer) {

		super(callerHandler);

		this.parentRule = parentRule;
		this.ifType = ifType;
		this.writer = writer;
	}


	/**
	 * �^�O�J�n�����B
	 * <UL>
	 *  <LI>�Q�ƃ^�O���������J�b�R�̏ꍇ�͈ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁA�������J�b�R�n���h���[��ݒ肷��B</LI>
	 *    <LI>�N���X�ϐ��F����qIF��ގ��ʎq�ɁATHEN��ێ�����B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�Q�ƃ^�O��IF���̏ꍇ�͈ȉ��̏������s���B
	 *   <OL>
	 *    <LI>����q�ɃZ�b�g���ׂ����������擾����B</LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁAIF���n���h���[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�Q�ƃ^�O��ELSE���̏ꍇ�͈ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁAELSE���n���h���[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�Q�ƃ^�O�����������ʂ̏ꍇ�͈ȉ��̏������s���B
	 *   <OL>
	 *    <LI>����q�ɃZ�b�g���ׂ����������擾����B</LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁA���������ʃn���h���[��ݒ肷��B</LI>
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
		PCHADelegateHandler handler = null;
		PROINIRule iniRule = null;
		this.writer.startElement(qName);

		switch (elementType) {
		case APPLY:
			handler = PCHRuleHandlerFactory.createApplyHandler(this, this.writer);
			this.reader.setContentHandler(handler);
			this.childIFtype = PCTIFType.IF_THEN; // apply�̌��Then apply������Else
			break;

		case IF:
			iniRule = getINIRule();
			handler = PCHRuleHandlerFactory.createIFHandler(this, iniRule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = PCHRuleHandlerFactory.createELSEHandler(this, this.childRule,this.writer);
			this.reader.setContentHandler(handler);
			break;

		case RESULT:
			iniRule = getINIRule();
			handler = PCHResultObjectHandlerFactory.createResultHandler(
					this, atts, iniRule, this.childIFtype,this.writer);
			this.reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O��IF���̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <UL>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[��IF���n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>����q�̏ꍇ�̓N���X�ϐ��F�ďo������������THEN�����ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>��L�ȊO�̏ꍇ�̓N���X�ϐ��F�ďo������������ELSE�����ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�̓���qIF�������ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�̓���qIF��ގ��ʎq�ɁAIF��ގ��ʎq�FELSE��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[��ELSE���n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�N���X�ϐ��F�ďo������������ELSE�����ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[���������n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>TOP���x���̏ꍇ�͌p�����N���X�ϐ��F�ďo�����n���h���[�ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>��L�ȊO�̏ꍇ�̓N���X�ϐ��F�ďo������������ELSE�����ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�̓���qIF�������ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�̓���qIF��ގ��ʎq�ɁAIF��ގ��ʎq�FELSE��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * <P>
	 * �ďo�����n���h���[���̏����̌�A�p�����N���X�ϐ��FXML���[�_�[�ɁA
	 *�p�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

	this.writer.endElement(qName);
		if (PCTElementType.IF.equals(qName)) {

			if (this.callerHandler instanceof PCHIFHandler) {
				PCHIFHandler handler = (PCHIFHandler) this.callerHandler;

				// ����q�̏ꍇ
				if (PCTIFType.IF_THEN.equals(this.ifType)) {
					this.parentRule.setThenRule(this.rule);
				} else {
					// ElseIF�͐eIF��ElseIf�ł͖����A
					// �O�̌Z��IF��ElseIF�ł���B�iJava�������I�u�W�F�N�g�j
					this.parentRule.setElseRule(this.rule);
				}
				handler.childRule = this.rule;
				// CallerHandler�̃t���O��Else�ɂ��Ă����iXML��IF�̌��IF��ElseIF�̂��߁j
				handler.childIFtype = PCTIFType.IF_ELSE;
			} else if (this.callerHandler instanceof PCHELSEHandler) {
				this.parentRule.setElseRule(this.rule);
				((PCHELSEHandler) this.callerHandler).setRule(this.rule);
			} else {
				PCHConditionHandler handler = (PCHConditionHandler) this.callerHandler;

				// TOP���x���̏ꍇ
				if (PCTIFType.IF_TOP.equals(this.ifType)) {
					handler.setRule(this.rule);
				} else {
					this.parentRule.setElseRule(this.rule);
				}
				handler.setChildRule(this.rule);
				// CallerHandler�̃t���O��Else�ɂ��Ă����iXML��IF�̌��IF��ElseIF�̂��߁j
				handler.setChildIFtype(PCTIFType.IF_ELSE);
			}
			this.reader.setContentHandler(this.callerHandler);
		}
	}


	/**
	 * @return ������
	 * @see PCHApplyHandler
	 */
	PROINIRule getRule() {
		return this.rule;
	}


	/**
	 * �������擾�����B
	 * <P>
	 * ����q�ɃZ�b�g���ׂ����������擾����B<BR>
	 * ���̂悤�Ȕ�����s�����R��If����ElseIF�ɂȂ鎞�A�������̏����iXML�v���j
	 *�Ƃ����AXML��Java�I�u�W�F�N�g�̍\���̈Ⴂ�ɂ��邩��B<BR>
	 * Java�̏������I�u�W�F�N�g��Elseif�͕K�����O�������̓���q�ƂȂ邪�A
	 *XML�̓��x���������B
	 * </P>
	 * @return ������
	 */
	private PROINIRule getINIRule() {
		PROINIRule ret = this.childRule;

		if (PCTIFType.IF_THEN.equals(this.childIFtype)) {
			ret = this.rule;
		}

		return ret;
	}

}
