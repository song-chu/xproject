package jp.escofi.emr.engine.loader;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.AbstractCondition;

import org.xml.sax.Attributes;


/**
 * �������A�v���C�n���h���[
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������̃A�v���C�i{@code <apply>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class ApplyHandler extends AbstractRuleHandler {

	/**
	 * ������
	 */
	private AbstractCondition condition;


	/**
	 * �R���X�g���N�^�B
	 * @param callerHandler �ďo�����n���h���[
	 */
	public ApplyHandler(AbstractRuleHandler callerHandler) {
		super(callerHandler);
	}


	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �p�����N���X�ϐ��FXML���[�_�[�ɁA�G�������g�^�C�v�ɉ��������Z�q�n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		ElementType elementType = ElementType.getType(qName);
		AbstractConditionHandler handler = RuleHandlerFactory.createConditionHandler(
				elementType, this, atts);

		if (handler != null) {
			reader.setContentHandler(handler);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���������A�v���C�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <UL>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[��IF���n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�ďo�����n���h���[����A�������I�u�W�F�N�g���擾����B</LI>
	 *    <LI>�������I�u�W�F�N�g�ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[���_�����Z���n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�ďo�����n���h���[����A���������X�g���擾����B</LI>
	 *    <LI>���������X�g�ɃN���X�ϐ��F���������i�[����B</LI>
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

		if (ElementType.APPLY.toString().equals(qName)) {

			if (callerHandler instanceof IFHandler) {
				// IF����Ă΂ꂽ�� -- �Ă΂ꂽ�������ɉ��Z�����Z�b�g����B
				IFHandler handler = (IFHandler) callerHandler;

				handler.getRule().setPdsCondition(condition);
			} else {
				// �_�����Z���n���h���[����Ă΂ꂽ��
				CompositeConditionHandler handler =
					(CompositeConditionHandler) callerHandler;
				List<AbstractCondition> conditionItems = handler.getConditions();

				conditionItems.add(condition);
			}
			reader.setContentHandler(callerHandler);
		}
	}


	/**
	 * @param condition ������
	 */
	void setCondition(AbstractCondition condition) {
		this.condition = condition;
	}

}
