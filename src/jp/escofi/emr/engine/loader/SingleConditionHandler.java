package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.ConditionType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.engine.condition.AbstractOperand;
import jp.escofi.emr.engine.condition.AbstractRelOperEXCLUDE;
import jp.escofi.emr.engine.condition.AbstractRelOperINCLUDE;
import jp.escofi.emr.engine.condition.AbstractSingleCondition;
import jp.escofi.emr.engine.condition.OperandConst;
import jp.escofi.emr.engine.condition.OperandVar;
import jp.escofi.emr.engine.condition.SingleConditionFactory;

import org.xml.sax.Attributes;

/**
 * �֌W���Z���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�ȉ��̃^�O�ɑΉ�����SAX�C�x���g�n���h���[�B
 *    <UL>
 *     <LI>{@code <eq>}</LI>
 *     <LI>{@code <neq>}</LI>
 *     <LI>{@code <gt>}</LI>
 *     <LI>{@code <geq>}</LI>
 *     <LI>{@code <lt>}</LI>
 *     <LI>{@code <leq>}</LI>
 *     <LI>{@code <in>}</LI>
 *     <LI>{@code <notin>}</LI>
 *     <LI>{@code <intersect>}</LI>
 *     <LI>{@code <nintersect>}</LI>
 *     <LI>{@code <startswith>}</LI>
 *     <LI>{@code <nstartswith>}</LI>
 *     <LI>{@code <subset>}</LI>
 *     <LI>{@code <nsubset>}</LI>
 *     <LI>{@code <include>}</LI>
 *     <LI>{@code <exclude>}</LI>
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
public final class SingleConditionHandler extends AbstractConditionHandler {

	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �������ڃ��X�g
	 */
	private List<AbstractOperand> conditionItems = new ArrayList<AbstractOperand>();
	/**
	 * �����^�C�v��`���X�g
	 * <P>
	 * ���Z�q���ɑ����^�C�v�����K�v����B���Z�q�������^�C�v�����������ivar -> const�j
	 * </P>
	 */
	private List<DataType> dataTypes = new ArrayList<DataType>();
	/**
	 * �����܂ރt���O
	 */
	private boolean lowerEq;
	/**
	 * ����܂ރt���O
	 */
	private boolean upperEq;

	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �����ŉ���/����܂ރt���O���g�p���Ȃ��ꍇ�́A������̃R���X�g���N�^���g�p����B
	 * </P>
	 *
	 * @param callerHandler
	 *            �ďo�����n���h���[
	 * @param elementType
	 *            �G�������g��`
	 */
	public SingleConditionHandler(ApplyHandler callerHandler,
			ElementType elementType) {

		super(callerHandler, elementType);

		lowerEq = false;
		upperEq = false;
	}

	/**
	 * �R���X�g���N�^(����/����܂ރt���O�t)�B
	 * <P>
	 * �����ŉ���/����܂ރt���O���g�p����ꍇ�́A������̃R���X�g���N�^���g�p����B
	 * </P>
	 *
	 * @param callerHandler
	 *            �ďo�����n���h���[
	 * @param elementType
	 *            �G�������g��`
	 * @param lowerEq
	 *            �����܂ރt���O
	 * @param upperEq
	 *            ����܂ރt���O
	 */
	public SingleConditionHandler(ApplyHandler callerHandler,
			ElementType elementType, String lowerEq, String upperEq) {

		super(callerHandler, elementType);

		this.lowerEq = ConvertUtil.isConvertBoolean(lowerEq);
		this.upperEq = ConvertUtil.isConvertBoolean(upperEq);
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �p�����N���X�ϐ��FXML���[�_�[�ɁA�Q�Ƃ���^�O�ɉ������n���h���[��ݒ肷��B
	 * </P>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ���[�J����
	 * @param qName
	 *            �Q�ƒ��̃^�O��
	 * @param atts
	 *            �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		ElementType elementType = ElementType.getType(qName);
		AbstractRuleHandler handler = RuleHandlerFactory.createRuleHandler(
				elementType, this, atts);

		if (handler != null) {
			reader.setContentHandler(handler);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Q�ƒ��̃^�O������擾�����G�������g��`���A�N���X�ϐ��F�G�������g��`�Ɠ���̏ꍇ�A �ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�G�������g��`�ɉ������������ڃ��X�g�ϊ��������s���B</LI>
	 * <LI>�G�������g��`�ɉ��������Z�q��`���擾����B</LI>
	 * <LI>�G�������g��`�ɉ��������Z�q��`���擾����B</LI>
	 * <LI>���Z�q��`�ɉ������������I�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>���Z�q��`��INCLUDE�AEXCLUDE�̏ꍇ�́A�������I�u�W�F�N�g�ɁA ����/����܂ރt���O��ݒ肷��B</LI>
	 * <LI>�ďo�����n���h���[�̏������ɁA�������I�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>XML���[�_�[�̃n���h���[���A�ďo�����n���h���[�ɖ߂��B</LI>
	 * </OL>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ���[�J����
	 * @param qName
	 *            �Q�ƒ��̃^�O��
	 * @throw IllegalArgumentException �����s����O
	 *        <UL>
	 *        <LI>�^�O�̐�����������Ȃ��ꍇ
	 *        </UL>
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType localElementType = ElementType.getType(qName);

		if (this.elementType == localElementType) {
			// �G�������g��`�ɉ������������ڃ��X�g�ϊ�����
			convertItems(localElementType);

			ConditionType conditionType = getConditionType(localElementType);
			AbstractSingleCondition condition = SingleConditionFactory
					.createSingleCondition(conditionItems, conditionType,
							javaDataType, dataTypes);

			// �֌W���Z�q�^�C�v��INCLUDE�AEXCLUDE�̏ꍇ�́A����/����܂ރt���O��ݒ肷��B
			switch (conditionType) {
			case CONDITION_INCLUDE:
				AbstractRelOperINCLUDE roi = (AbstractRelOperINCLUDE) condition;

				roi.setLowerEq(lowerEq);
				roi.setUpperEq(upperEq);
				break;

			case CONDITION_EXCLUDE:
				AbstractRelOperEXCLUDE roe = (AbstractRelOperEXCLUDE) condition;

				roe.setLowerEq(lowerEq);
				roe.setUpperEq(upperEq);
				break;
			}
			ApplyHandler handler = (ApplyHandler) callerHandler;

			handler.setCondition(condition);
			reader.setContentHandler(handler);
		}
	}

	/**
	 * @param javaDataType
	 *            ����Java�f�[�^�^
	 */
	void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}

	/**
	 * �������ڒǉ��B
	 * <P>
	 * �����^�C�v��`���X�g�A�������ڃ��X�g�Ƀf�[�^�^�A�����l��ǉ�����B
	 * </P>
	 *
	 * @param dataType
	 *            �f�[�^�^
	 * @param item
	 *            ��������
	 */
	void addConditionItem(String dataType, AbstractOperand item) {
		dataTypes.add(DataType.getType(dataType));
		conditionItems.add(item);
	}

	/**
	 * �������ڃ��X�g�ϊ��B
	 * <P>
	 * �G�������g��`�ɉ������������ڃ`�F�b�N���s���A�`�F�b�N���ʂ�΃��X�g�ϊ��������s���B
	 * </P>
	 * <OL>
	 * <LI>����Java�f�[�^�^�^�C�v���擾����B</LI>
	 * <LI>����Java�f�[�^�^�^�C�v���擾�ł��Ȃ��ꍇ�́A��O����������B</LI>
	 * <LI>�������ڃ��X�g�ɃZ�b�g���܂ޏꍇ�́A����Java�f�[�^�^��boolean�̏ꍇ�ɗ�O����������B</LI>
	 * <LI>�G�������g��`�ɉ������������ڃ`�F�b�N���s���B</LI>
	 * <LI>�ϐ��̑��݃`�F�b�N���s���B</LI>
	 * <LI>���X�g�ϊ��������s���B</LI>
	 * </OL>
	 *
	 * @param elementType
	 *            �G�������g��`
	 * @throw IllegalArgumentException �����s����O
	 *        <UL>
	 *        <LI>����elementType��dataTypes�̐�����������Ȃ��ꍇ
	 *        </UL>
	 */
	private void convertItems(ElementType elementType) {

		int size = dataTypes.size();
		boolean containsSet = dataTypes.contains(DataType.SET);
		boolean containsSingle = dataTypes.contains(DataType.SINGLE);
		boolean isValid = true;
		switch (elementType) {
		case EQ:
		case NOT_EQ:
			isValid = (size == 2) && dataTypes.get(0).equals(dataTypes.get(1));
			break;

		case GT:
		case GEQ:
		case LT:
		case LEQ:
		case START_SWITH:
		case NOT_START_SWITH:
			isValid = (size == 2) && !containsSet;
			break;

		case IN:
		case NOT_IN:
			isValid = (size == 2)
					&& DataType.SINGLE == dataTypes.get(0)
					&& DataType.SET == dataTypes.get(1);
			break;

		case INTERSECT:
		case NOT_INTERSECT:
		case SUBSET:
		case NOT_SUBSET:
			isValid = (size == 2) && !containsSingle;
			break;

		case INCLUDE:
		case EXCLUDE:
			isValid = (size == 3) && !containsSet;
			break;
		}

		if (isValid) {
			// Const�̂݃`�F�b�N
			boolean hasVar = false;
			// �������ڂ̕ϊ������p
			List<OperandConst> convItems = new ArrayList<OperandConst>();

			for (AbstractOperand item : conditionItems) {

				if (item instanceof OperandConst) {
					convItems.add((OperandConst) item);
				} else if (item instanceof OperandVar) {
					hasVar = true;
				}
			}

			if (hasVar) {

				for (OperandConst item : convItems) {
					convertItems(item);
				}
			}
			isValid = hasVar;
		}

		if (!isValid) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P017E.toString(), new String[] {
							elementType.toString(),
							dataTypes.toString() }));
		}
	}

	/**
	 * �������ڕϊ������B
	 * <P>
	 * �������ڂɒl�����Java�f�[�^�^�ŕϊ������I�u�W�F�N�g���Z�b�g����B
	 * </P>
	 *
	 * @param item
	 *            ��������
	 */
	private void convertItems(OperandConst item) {

		switch (item.getDataType()) {
		case SINGLE:
			item.setValue(ConvertUtil.convert(item.getStrValue(),
					javaDataType));
			break;

		case SET:
			Set<String> set = item.getStrSetValue();
			Set<Object> newSet = new HashSet<Object>(set.size());

			for (String elem : set) {
				newSet.add(ConvertUtil.convert(elem, javaDataType));
			}
			item.setValue(Collections.unmodifiableSet(newSet));
			break;
		}
	}

	/**
	 * ���Z�q��`�擾�B
	 * <P>
	 * �G�������g��`�ɉ��������Z�q��`���擾����B
	 * </P>
	 *
	 * @param elementType
	 *            �G�������g��`
	 * @return ���Z�q��`
	 */
	private ConditionType getConditionType(ElementType elementType) {
		ConditionType ret = null;

		switch (elementType) {
		case EQ:
			ret = ConditionType.CONDITION_EQ;
			break;

		case NOT_EQ:
			ret = ConditionType.CONDITION_NOT_EQ;
			break;

		case GT:
			ret = ConditionType.CONDITION_GT;
			break;

		case GEQ:
			ret = ConditionType.CONDITION_GEQ;
			break;

		case IN:
			ret = ConditionType.CONDITION_IN;
			break;

		case NOT_IN:
			ret = ConditionType.CONDITION_NOT_IN;
			break;

		case LT:
			ret = ConditionType.CONDITION_LT;
			break;

		case LEQ:
			ret = ConditionType.CONDITION_LEQ;
			break;

		case SUBSET:
			ret = ConditionType.CONDITION_SUBSET;
			break;

		case NOT_SUBSET:
			ret = ConditionType.CONDITION_NOT_SUBSET;
			break;

		case INTERSECT:
			ret = ConditionType.CONDITION_INTERSECT;
			break;

		case NOT_INTERSECT:
			ret = ConditionType.CONDITION_NOT_INTERSECT;
			break;

		case START_SWITH:
			ret = ConditionType.CONDITION_START_SWITH;
			break;

		case NOT_START_SWITH:
			ret = ConditionType.CONDITION_NOT_START_SWITH;
			break;

		case INCLUDE:
			ret = ConditionType.CONDITION_INCLUDE;
			break;

		case EXCLUDE:
			ret = ConditionType.CONDITION_EXCLUDE;
			break;
		}

		return ret;
	}

}
