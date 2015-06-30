package jp.escofi.emr.engine.condition;

import java.util.List;

import jp.escofi.emr.engine.common.constant.CodeType;
import jp.escofi.emr.engine.common.constant.ConditionType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

/**
 * �֌W���Z���̐�����S������Facroty�N���X
 * <DL>
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
public final class SingleConditionFactory {

	/**
	 * �֌W���Z���𐶐�����B
	 *
	 * @param operands
	 *            �I�y�����h�̃��X�g
	 * @param conditionType
	 *            ���Z�q���
	 * @param javaDataType
	 *            Java�f�[�^�^
	 * @param dataTypes
	 *            �f�[�^��ʃ��X�g
	 * @return �֌W���Z��
	 * @throw IllegalArgumentException �����s����O
	 *        <UL>
	 *        <LI>������conditionType�AjavaDataType�AcontainsSet�̐�����������Ȃ��ꍇ
	 *        </UL>
	 */
	public static AbstractSingleCondition createSingleCondition(
			List<AbstractOperand> operands, ConditionType conditionType,
			String javaDataType, List<DataType> dataTypes) {

		CodeType codeType = CodeType.getType(javaDataType);
		boolean containsSet = dataTypes.contains(DataType.SET);

		checkJavaDataType(conditionType, codeType, containsSet);

		switch (conditionType) {
		case CONDITION_EQ:
			return createSingleConditionEQ(operands, codeType, containsSet);
		case CONDITION_NOT_EQ:
			return createSingleConditionNOTEQ(operands, codeType, containsSet);
		case CONDITION_GT:
			return createSingleConditionGT(operands, codeType);
		case CONDITION_GEQ:
			return createSingleConditionGEQ(operands, codeType);
		case CONDITION_LT:
			return createSingleConditionLT(operands, codeType);
		case CONDITION_LEQ:
			return createSingleConditionLEQ(operands, codeType);
		case CONDITION_IN:
			return createSingleConditionIN(operands, codeType);
		case CONDITION_NOT_IN:
			return createSingleConditionNOTIN(operands, codeType);
		case CONDITION_SUBSET:
			return createSingleConditionSUBSET(operands, codeType);
		case CONDITION_NOT_SUBSET:
			return createSingleConditionNOTSUBSET(operands, codeType);
		case CONDITION_INTERSECT:
			return createSingleConditionINTERSECT(operands, codeType);
		case CONDITION_NOT_INTERSECT:
			return createSingleConditionNOTINTERSECT(operands, codeType);
		case CONDITION_START_SWITH:
			return createSingleConditionSTARTSWITH(operands, codeType);
		case CONDITION_NOT_START_SWITH:
			return createSingleConditionNOTSTARTSWITH(operands, codeType);
		case CONDITION_INCLUDE:
			return createSingleConditionINCLUDE(operands, codeType);
		case CONDITION_EXCLUDE:
			return createSingleConditionEXCLUDE(operands, codeType);
		default:
			return null;
		}
	}

	/**
	 * ���Z�q��ނ�Java�f�[�^�^�Ƃ̐������`�F�b�N�B
	 *
	 * @param conditionType
	 *            ���Z�q���
	 * @param javaDataType
	 *            Java�f�[�^�^
	 * @param containsSet
	 *            �f�[�^�^��set�^���̔���l
	 * @throw IllegalArgumentException �����s����O
	 *        <UL>
	 *        <LI>������conditionType�AjavaDataType�AcontainsSet�̐�����������Ȃ��ꍇ
	 *        </UL>
	 */
	private static void checkJavaDataType(ConditionType conditionType,
			CodeType javaDataType, boolean containsSet) {

		boolean isValid = !containsSet
				|| CodeType.BOOLEAN != javaDataType;

		if (isValid) {
			switch (conditionType) {
			case CONDITION_IN:
			case CONDITION_NOT_IN:
				isValid = (CodeType.BOOLEAN != javaDataType);
				break;

			case CONDITION_GT:
			case CONDITION_GEQ:
			case CONDITION_LT:
			case CONDITION_LEQ:
			case CONDITION_INCLUDE:
			case CONDITION_EXCLUDE:
				isValid = (CodeType.BOOLEAN != javaDataType
						|| CodeType.OTHER == javaDataType);
				break;

			case CONDITION_START_SWITH:
			case CONDITION_NOT_START_SWITH:
				isValid = (CodeType.STRING == javaDataType);
				break;
			}
		}

		if (!isValid) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P019E.toString(), new Object[] {
							conditionType.toString(), javaDataType.toString(),
							String.valueOf(containsSet) }));
		}
	}

	/**
	 * ��������EQ���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @param isSet
	 *            �f�[�^�^��set�^���̔���l
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperEQ createSingleConditionEQ(
			List<AbstractOperand> operands, CodeType javaDataType, boolean isSet) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			if (isSet) {
				return new RelOperEQBigDecimalSet(operands);
			} else {
				return new RelOperEQBigDecimal(operands);
			}
		} else {
			return new RelOperEQObject(operands);
		}
	}

	/**
	 * ��������NOTEQ���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @param isSet
	 *            �f�[�^�^��set�^���̔���l
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperNOTEQ createSingleConditionNOTEQ(
			List<AbstractOperand> operands, CodeType javaDataType, boolean isSet) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			if (isSet) {
				return new RelOperNOTEQBigDecimalSet(operands);
			} else {
				return new RelOperNOTEQBigDecimal(operands);
			}
		} else {
			return new RelOperNOTEQObject(operands);
		}
	}

	/**
	 * ��������GT���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperGT createSingleConditionGT(
			List<AbstractOperand> operands, CodeType javaDataType) {
		AbstractRelOperGT ret = null;

		switch (javaDataType) {
		case STRING:
			ret = new RelOperGTString(operands);
			break;
		case INTEGER:
			ret = new RelOperGTInteger(operands);
			break;
		case LONG:
			ret = new RelOperGTLong(operands);
			break;
		case DOUBLE:
			ret = new RelOperGTDouble(operands);
			break;
		case BIG_DECIMAL:
			ret = new RelOperGTBigDecimal(operands);
			break;
		}
		return ret;
	}

	/**
	 * ��������GEQ���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperGEQ createSingleConditionGEQ(
			List<AbstractOperand> operands, CodeType javaDataType) {

		AbstractRelOperGEQ ret = null;
		switch (javaDataType) {
		case STRING:
			ret = new RelOperGEQString(operands);
			break;
		case INTEGER:
			ret = new RelOperGEQInteger(operands);
			break;
		case LONG:
			ret = new RelOperGEQLong(operands);
			break;
		case DOUBLE:
			ret = new RelOperGEQDouble(operands);
			break;
		case BIG_DECIMAL:
			ret = new RelOperGEQBigDecimal(operands);
			break;
		}
		return ret;
	}

	/**
	 * ��������LT���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperLT createSingleConditionLT(
			List<AbstractOperand> operands, CodeType javaDataType) {
		AbstractRelOperLT ret = null;

		switch (javaDataType) {
		case STRING:
			ret = new RelOperLTString(operands);
			break;
		case INTEGER:
			ret = new RelOperLTInteger(operands);
			break;
		case LONG:
			ret = new RelOperLTLong(operands);
			break;
		case DOUBLE:
			ret = new RelOperLTDouble(operands);
			break;
		case BIG_DECIMAL:
			ret = new RelOperLTBigDecimal(operands);
			break;
		}
		return ret;
	}

	/**
	 * ��������LEQ���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperLEQ createSingleConditionLEQ(
			List<AbstractOperand> operands, CodeType javaDataType) {
		AbstractRelOperLEQ ret = null;

		switch (javaDataType) {
		case STRING:
			ret = new RelOperLEQString(operands);
			break;
		case INTEGER:
			ret = new RelOperLEQInteger(operands);
			break;
		case LONG:
			ret = new RelOperLEQLong(operands);
			break;
		case DOUBLE:
			ret = new RelOperLEQDouble(operands);
			break;
		case BIG_DECIMAL:
			ret = new RelOperLEQBigDecimal(operands);
			break;
		}
		return ret;
	}

	/**
	 * ��������IN���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperIN createSingleConditionIN(
			List<AbstractOperand> operands, CodeType javaDataType) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			return new RelOperINBigDecimal(operands);
		} else {
			return new RelOperINObject(operands);
		}
	}

	/**
	 * ��������NOTIN���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperNOTIN createSingleConditionNOTIN(
			List<AbstractOperand> operands, CodeType javaDataType) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			return new RelOperNOTINBigDecimal(operands);
		} else {
			return new RelOperNOTINObject(operands);
		}
	}

	/**
	 * ��������SUBSET���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperSUBSET createSingleConditionSUBSET(
			List<AbstractOperand> operands, CodeType javaDataType) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			return new RelOperSUBSETBigDecimal(operands);
		} else {
			return new RelOperSUBSETObject(operands);
		}
	}

	/**
	 * ��������NOTSUBSET���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperNOTSUBSET createSingleConditionNOTSUBSET(
			List<AbstractOperand> operands, CodeType javaDataType) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			return new RelOperNOTSUBSETBigDecimal(operands);
		} else {
			return new RelOperNOTSUBSETObject(operands);
		}
	}

	/**
	 * ��������INTERSECT���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperINTERSECT createSingleConditionINTERSECT(
			List<AbstractOperand> operands, CodeType javaDataType) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			return new RelOperINTERSECTBigDecimal(operands);
		} else {
			return new RelOperINTERSECTObject(operands);
		}
	}

	/**
	 * ��������NOTINTERSECT���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperNOTINTERSECT createSingleConditionNOTINTERSECT(
			List<AbstractOperand> operands, CodeType javaDataType) {

		if (CodeType.BIG_DECIMAL == javaDataType) {
			return new RelOperNOTINTERSECTBigDecimal(operands);
		} else {
			return new RelOperNOTINTERSECTObject(operands);
		}
	}

	/**
	 * ��������STARTSWITH���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static RelOperSTARTSWITH createSingleConditionSTARTSWITH(
			List<AbstractOperand> operands, CodeType javaDataType) {

		return new RelOperSTARTSWITH(operands);
	}

	/**
	 * ��������NOTSTARTSWITH���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static RelOperNOTSTARTSWITH createSingleConditionNOTSTARTSWITH(
			List<AbstractOperand> operands, CodeType javaDataType) {

		return new RelOperNOTSTARTSWITH(operands);
	}

	/**
	 * ��������INCLUDE���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperINCLUDE createSingleConditionINCLUDE(
			List<AbstractOperand> operands, CodeType javaDataType) {
		AbstractRelOperINCLUDE ret = null;

		switch (javaDataType) {
		case STRING:
			ret = new RelOperINCLUDEString(operands);
			break;
		case INTEGER:
			ret = new RelOperINCLUDEInteger(operands);
			break;
		case LONG:
			ret = new RelOperINCLUDELong(operands);
			break;
		case DOUBLE:
			ret = new RelOperINCLUDEDouble(operands);
			break;
		case BIG_DECIMAL:
			ret = new RelOperINCLUDEBigDecimal(operands);
			break;
		}
		return ret;
	}

	/**
	 * ��������EXCLUDE���Z�I�u�W�F�N�g���쐬
	 *
	 * @param operands
	 *            �I�y�����h���X�g
	 * @param javaDataType
	 *            JAVA�f�[�^�^�C�v
	 * @return ��������I�u�W�F�N�g
	 */
	private static AbstractRelOperEXCLUDE createSingleConditionEXCLUDE(
			List<AbstractOperand> operands, CodeType javaDataType) {
		AbstractRelOperEXCLUDE ret = null;

		switch (javaDataType) {
		case STRING:
			ret = new RelOperEXCLUDEString(operands);
			break;
		case INTEGER:
			ret = new RelOperEXCLUDEInteger(operands);
			break;
		case LONG:
			ret = new RelOperEXCLUDELong(operands);
			break;
		case DOUBLE:
			ret = new RelOperEXCLUDEDouble(operands);
			break;
		case BIG_DECIMAL:
			ret = new RelOperEXCLUDEBigDecimal(operands);
			break;
		}
		return ret;
	}
}
