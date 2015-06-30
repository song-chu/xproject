package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * IF���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>IF���i{@code <if>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class IFHandler extends AbstractRuleHandler {

	/**
	 * �ďo����������
	 */
	private InitRule parentRule;
	/**
	 * ������
	 */
	private InitRule rule = new InitRule();
	/**
	 * ����q������
	 */
	private InitRule childRule;
	/**
	 * IF��ގ��ʎq
	 */
	private IFType ifType;
	/**
	 * ����qIF��ގ��ʎq
	 */
	private IFType childIfType;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param parentRule �ďo����������
	 * @param ifType IF��ގ��ʎq
	 */
	public IFHandler(AbstractRuleHandler callerHandler, InitRule parentRule, IFType ifType) {

		super(callerHandler);

		this.parentRule = parentRule;
		this.ifType = ifType;
	}


	/**
	 * �^�O�J�n�����B
	 * <UL>
	 *  <LI>�Q�ƃ^�O���������A�v���C�̏ꍇ�͈ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁA�������A�v���C�n���h���[��ݒ肷��B</LI>
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
		ElementType elementType = ElementType.getType(qName);
		AbstractDelegateHandler handler = null;
		InitRule initRule = null;

		switch (elementType) {
		case APPLY:
			handler = RuleHandlerFactory.createApplyHandler(this);
			reader.setContentHandler(handler);
			childIfType = IFType.IF_THEN; // apply�̌��Then apply������Else
			break;

		case IF:
			initRule = getInitRule();
			handler = RuleHandlerFactory.createIFHandler(this, initRule, childIfType);
			reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = RuleHandlerFactory.createELSEHandler(this, childRule);
			reader.setContentHandler(handler);
			break;

		case RESULT:
			initRule = getInitRule();
			handler = ResultObjectHandlerFactory.createResultHandler(
					this, atts, initRule, childIfType);
			reader.setContentHandler(handler);
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

		if (ElementType.IF.toString().equals(qName)) {

			if (callerHandler instanceof IFHandler) {
				IFHandler handler = (IFHandler) callerHandler;

				// ����q�̏ꍇ
				if (IFType.IF_THEN == ifType) {
					parentRule.setThenRule(rule);
				} else {
					// ElseIF�͐eIF��ElseIf�ł͖����A
					// �O�̌Z��IF��ElseIF�ł���B�iJava�������I�u�W�F�N�g�j
					parentRule.setElseRule(rule);
				}
				handler.childRule = rule;
				// CallerHandler�̃t���O��Else�ɂ��Ă����iXML��IF�̌��IF��ElseIF�̂��߁j
				handler.childIfType = IFType.IF_ELSE;
			} else if (callerHandler instanceof ELSEHandler) {
				parentRule.setElseRule(rule);
				((ELSEHandler) callerHandler).setRule(rule);
			} else {
				ConditionHandler handler = (ConditionHandler) callerHandler;

				// TOP���x���̏ꍇ
				if (IFType.IF_TOP == ifType) {
					handler.setRule(rule);
				} else {
					parentRule.setElseRule(rule);
				}
				handler.setChildRule(rule);
				// CallerHandler�̃t���O��Else�ɂ��Ă����iXML��IF�̌��IF��ElseIF�̂��߁j
				handler.setChildIfType(IFType.IF_ELSE);
			}
			reader.setContentHandler(callerHandler);
		}
	}


	/**
	 * @return ������
	 */
	InitRule getRule() {
		return rule;
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
	private InitRule getInitRule() {
		InitRule ret = childRule;

		if (IFType.IF_THEN == childIfType) {
			ret = rule;
		}

		return ret;
	}

}
