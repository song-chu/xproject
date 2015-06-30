package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.HashMap;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;
import jp.escofi.emr.engine.condition.RuleInstance;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.Attributes;


/**
 * �������n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃^�C�v���������̏ꍇ�A�������S�́i{@code <condition>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class ConditionHandler extends AbstractRuleHandler {

	/**
	 * ������
	 */
	private InitRule rule;
	/**
	 * �q������
	 */
	private InitRule childRule;
	/**
	 * IF-THEN-ELSE���ʎq
	 */
	private IFType childIfType = IFType.IF_TOP;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 */
	public ConditionHandler(AbstractResultObjectHandler callerHandler) {

		super(callerHandler);

		conditionItemMap = new HashMap<String, ConditionItemInfo>();
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
		ElementType elementType = ElementType.getType(qName);
		InitRule rule = childRule;
		AbstractRuleHandler handler;

		switch (elementType) {
		case IF:

			if (IFType.IF_TOP == childIfType) {
				this.rule = rule;
			}
			handler = RuleHandlerFactory.createIFHandler(
					this, rule, childIfType);
			reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = RuleHandlerFactory.createELSEHandler(
					this, rule);
			reader.setContentHandler(handler);
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

		if (ElementType.CONDITION.toString().equals(qName)) {

			// �ďo�����n���h���[�i�����l�e�n���h���[�j���擾����
			AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;

			// �����l�e�n���h���[�ɑ����l�i�������j��ݒ肷��
			// ���̍ہA�������I�u�W�F�N�g��ҏW�s�\�ɂ��邽�߁A�ȉ������{����
			// INIRule -> PDSRule
			// �������ڏ��Map��ҏW�s�\�ɂ���B
			handler.setValue(new RuleInstance(rule.getPdsCondition(),
					rule.getThenRule(), rule.getElseRule(),
					rule.getThenAction(), rule.getElseAction(),
					Collections.unmodifiableMap(conditionItemMap)));

			reader.setContentHandler(handler);
		}
	}


	/**
	 * @param childRule �q������
	 */
	void setChildRule(InitRule childRule) {
		this.childRule = childRule;
	}
	/**
	 * @param childIfType IF-THEN-ELSE���ʎq
	 */
	void setChildIfType(IFType childIfType) {
		this.childIfType = childIfType;
	}

	/**
	 * @param rule ������
	 */
	void setRule(InitRule rule) {
		this.rule = rule;
	}

}
