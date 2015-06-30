package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * ELSE���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>ELSE���i{@code <else>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class ELSEHandler extends AbstractRuleHandler {

	/**
	 * ������
	 */
	private InitRule rule;

	/**
	 * ����qIF��ގ��ʎq
	 */
	private final IFType CHILD_IF_TYPE = IFType.IF_ELSE;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ������
	 */
	public ELSEHandler(AbstractRuleHandler callerHandler, InitRule rule) {

		super(callerHandler);

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
		ElementType elementType = ElementType.getType(qName);
		AbstractDelegateHandler handler = null;

		switch (elementType) {
		case IF:
			handler = RuleHandlerFactory.createIFHandler(this, rule, CHILD_IF_TYPE);
			reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = RuleHandlerFactory.createELSEHandler(this, rule);
			reader.setContentHandler(handler);
			break;

		case RESULT:
			handler = ResultObjectHandlerFactory.createResultHandler(
					this, atts, rule, CHILD_IF_TYPE);
			reader.setContentHandler(handler);
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

		if (ElementType.ELSE.toString().equals(qName)) {
			reader.setContentHandler(callerHandler);
		}
	}


	/**
	 * @param rule ������
	 */
	void setRule(InitRule rule) {
		this.rule = rule;
	}

}
