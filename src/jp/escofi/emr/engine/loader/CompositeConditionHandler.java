package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.List;

import jp.escofi.emr.engine.common.constant.ConditionType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.AbstractCompositeCondition;
import jp.escofi.emr.engine.condition.AbstractCondition;
import jp.escofi.emr.engine.condition.CompositeConditionFactory;

import org.xml.sax.Attributes;


/**
 * �_�����Z���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f��XML�̈ȉ��̃^�O�ɑΉ�����SAX�C�x���g�n���h���[�B
 *    <UL>
 *     <LI>{@code <and>}</LI>
 *     <LI>{@code <or>}</LI>
 *    </UL>
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
public final class CompositeConditionHandler extends AbstractConditionHandler {

	/**
	 * ���������X�g
	 */
	private List<AbstractCondition> conditions = new ArrayList<AbstractCondition>();


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param elementType �G�������g�^�C�v
	 */
	public CompositeConditionHandler(
			ApplyHandler callerHandler, ElementType elementType) {
		super(callerHandler, elementType);
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �Ώۃ^�O���������A�v���C�̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�ɁA
	 *�������A�v���C�n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (ElementType.APPLY.toString().equals(qName)) {
			ApplyHandler handler = RuleHandlerFactory.createApplyHandler(this);

			reader.setContentHandler(handler);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Q�ƒ��̃^�O������擾�����G�������g��`���A�N���X�ϐ��F�G�������g��`�Ɠ���̏ꍇ�́A
	 *�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�����������I�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɁA�������������������I�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁA�p�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType localElementType = ElementType.getType(qName);

		if (this.elementType == localElementType) {
			ApplyHandler handler = (ApplyHandler) callerHandler;
			ConditionType conditionType = getConditionType(localElementType);
			AbstractCompositeCondition compositeCondition =
				CompositeConditionFactory.createCompositeCondition(
						conditions, conditionType);

			handler.setCondition(compositeCondition);
			reader.setContentHandler(handler);
		}
	}


	/**
	 * @return ���������X�g
	 */
	List<AbstractCondition> getConditions() {
		return conditions;
	}


	/**
	 * ���Z�q��`�擾�B
	 * <P>
	 * �G�������g��`�ɉ��������Z�q��`���擾����B
	 * </P>
	 * @param elementType �G�������g��`
	 * @return ���Z�q��`
	 */
	private ConditionType getConditionType(ElementType elementType) {
		ConditionType ret = null;

		switch (elementType) {
		case AND:
			ret = ConditionType.CONDITION_AND;
			break;

		case OR:
			ret = ConditionType.CONDITION_OR;
			break;
		}

		return ret;
	}

}
