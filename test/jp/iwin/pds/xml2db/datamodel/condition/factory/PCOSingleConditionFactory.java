package jp.iwin.pds.xml2db.datamodel.condition.factory;

import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.common.constant.PCTConstants;
import jp.iwin.pds.xml2db.common.constant.PCTDataType;
import jp.iwin.pds.xml2db.datamodel.condition.PCOAOperand;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperEQ;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperEXCLUDE;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperGEQ;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperGT;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperIN;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperINCLUDE;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperINTERSECT;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperLEQ;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperLT;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperNOTEQ;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperNOTIN;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperNOTINTERSECT;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperNOTSUBSET;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperSUBSET;
import jp.iwin.pds.xml2db.datamodel.condition.PCOASingleCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEQBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEQBigDecimalSet;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEQObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEXCLUDEBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEXCLUDEDouble;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEXCLUDEInteger;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEXCLUDELong;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperEXCLUDEString;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGEQBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGEQDouble;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGEQInteger;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGEQLong;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGEQString;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGTBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGTDouble;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGTInteger;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGTLong;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperGTString;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINCLUDEBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINCLUDEDouble;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINCLUDEInteger;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINCLUDELong;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINCLUDEString;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINTERSECTBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperINTERSECTObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLEQBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLEQDouble;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLEQInteger;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLEQLong;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLEQString;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLTBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLTDouble;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLTInteger;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLTLong;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperLTString;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTEQBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTEQBigDecimalSet;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTEQObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTINBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTINObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTINTERSECTBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTINTERSECTObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTSTARTSWITH;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTSUBSETBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperNOTSUBSETObject;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperSTARTSWITH;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperSUBSETBigDecimal;
import jp.iwin.pds.xml2db.datamodel.condition.PCORelOperSUBSETObject;


/**
 * �֌W���Z���̐�����S������Facroty�N���X
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1146 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-08 15:38:57 +0900 (水, 08 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTINTERSECT
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCOSingleConditionFactory {

	/**
	 * �֌W���Z���𐶐�����B
	 * @param operands	�I�y�����h�̃��X�g
	 * @param conditionType	���Z�q���
	 * @param javaDataType	Java�f�[�^�^
	 * @param dataType �f�[�^���
	 * @return	�֌W���Z��
	 */
	public static PCOASingleCondition createSingleCondition(List<PCOAOperand> operands,
			PCTConditionType conditionType, String javaDataType, PCTDataType dataType) {

		switch (conditionType) {
		case CONDITION_EQ:
			return createSingleConditionEQ(operands, javaDataType, dataType);

		case CONDITION_NOTEQ:
			return createSingleConditionNOTEQ(operands, javaDataType, dataType);

		case CONDITION_GT:
			return createSingleConditionGT(operands, javaDataType);

		case CONDITION_GEQ:
			return createSingleConditionGEQ(operands, javaDataType);

		case CONDITION_LT:
			return createSingleConditionLT(operands, javaDataType);

		case CONDITION_LEQ:
			return createSingleConditionLEQ(operands, javaDataType);

		case CONDITION_IN:
			return createSingleConditionIN(operands, javaDataType);

		case CONDITION_NOTIN:
			return createSingleConditionNOTIN(operands, javaDataType);

		case CONDITION_SUBSET:
			return createSingleConditionSUBSET(operands, javaDataType);

		case CONDITION_NOTSUBSET:
			return createSingleConditionNOTSUBSET(operands, javaDataType);

		case CONDITION_INTERSECT:
			return createSingleConditionINTERSECT(operands, javaDataType);

		case CONDITION_NOTINTERSECT:
			return createSingleConditionNOTINTERSECT(operands, javaDataType);

		case CONDITION_STARTSWITH:
			return createSingleConditionSTARTSWITH(operands, javaDataType);

		case CONDITION_NOTSTARTSWITH:
			return createSingleConditionNOTSTARTSWITH(operands, javaDataType);

		case CONDITION_INCLUDE:
			return createSingleConditionINCLUDE(operands, javaDataType);

		case CONDITION_EXCLUDE:
			return createSingleConditionEXCLUDE(operands, javaDataType);

		default:
			return null;
		}
	}

	private static PCOARelOperEQ createSingleConditionEQ(List<PCOAOperand> operands,
			String javaDataType, PCTDataType dataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			if (PCTDataType.SET.equals(dataType)) {
				return new PCORelOperEQBigDecimalSet(operands);
			} else {
				return new PCORelOperEQBigDecimal(operands);
			}
		} else {
			return new PCORelOperEQObject(operands);
		}
	}

	private static PCOARelOperNOTEQ createSingleConditionNOTEQ(List<PCOAOperand> operands,
			String javaDataType, PCTDataType dataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			if (PCTDataType.SET.equals(dataType)) {
				return new PCORelOperNOTEQBigDecimalSet(operands);
			} else {
				return new PCORelOperNOTEQBigDecimal(operands);
			}
		} else {
			return new PCORelOperNOTEQObject(operands);
		}
	}

	private static PCOARelOperGT createSingleConditionGT(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperGTBigDecimal(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_INTEGER)) {
			return new PCORelOperGTInteger(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_DOUBLE)) {
			return new PCORelOperGTDouble(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_LONG)) {
			return new PCORelOperGTLong(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_STRING)) {
			return new PCORelOperGTString(operands);
		}
		return null;
	}

	private static PCOARelOperGEQ createSingleConditionGEQ(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperGEQBigDecimal(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_INTEGER)) {
			return new PCORelOperGEQInteger(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_DOUBLE)) {
			return new PCORelOperGEQDouble(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_LONG)) {
			return new PCORelOperGEQLong(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_STRING)) {
			return new PCORelOperGEQString(operands);
		}
		return null;
	}

	private static PCOARelOperLT createSingleConditionLT(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperLTBigDecimal(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_INTEGER)) {
			return new PCORelOperLTInteger(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_DOUBLE)) {
			return new PCORelOperLTDouble(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_LONG)) {
			return new PCORelOperLTLong(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_STRING)) {
			return new PCORelOperLTString(operands);
		}
		return null;
	}

	private static PCOARelOperLEQ createSingleConditionLEQ(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperLEQBigDecimal(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_INTEGER)) {
			return new PCORelOperLEQInteger(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_DOUBLE)) {
			return new PCORelOperLEQDouble(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_LONG)) {
			return new PCORelOperLEQLong(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_STRING)) {
			return new PCORelOperLEQString(operands);
		}
		return null;
	}

	private static PCOARelOperIN createSingleConditionIN(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperINBigDecimal(operands);
		} else {
			return new PCORelOperINObject(operands);
		}
	}

	private static PCOARelOperNOTIN createSingleConditionNOTIN(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperNOTINBigDecimal(operands);
		} else {
			return new PCORelOperNOTINObject(operands);
		}
	}

	private static PCOARelOperSUBSET createSingleConditionSUBSET(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperSUBSETBigDecimal(operands);
		} else {
			return new PCORelOperSUBSETObject(operands);
		}
	}

	private static PCOARelOperNOTSUBSET createSingleConditionNOTSUBSET(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperNOTSUBSETBigDecimal(operands);
		} else {
			return new PCORelOperNOTSUBSETObject(operands);
		}
	}

	private static PCOARelOperINTERSECT createSingleConditionINTERSECT(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperINTERSECTBigDecimal(operands);
		} else {
			return new PCORelOperINTERSECTObject(operands);
		}
	}

	private static PCOARelOperNOTINTERSECT createSingleConditionNOTINTERSECT(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperNOTINTERSECTBigDecimal(operands);
		} else {
			return new PCORelOperNOTINTERSECTObject(operands);
		}
	}

	private static PCORelOperSTARTSWITH createSingleConditionSTARTSWITH(List<PCOAOperand> operands,
			String javaDataType) {
			return new PCORelOperSTARTSWITH(operands);
	}

	private static PCORelOperNOTSTARTSWITH createSingleConditionNOTSTARTSWITH(List<PCOAOperand> operands,
			String javaDataType) {
			return new PCORelOperNOTSTARTSWITH(operands);
	}

	private static PCOARelOperINCLUDE createSingleConditionINCLUDE(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperINCLUDEBigDecimal(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_INTEGER)) {
			return new PCORelOperINCLUDEInteger(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_DOUBLE)) {
			return new PCORelOperINCLUDEDouble(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_LONG)) {
			return new PCORelOperINCLUDELong(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_STRING)) {
			return new PCORelOperINCLUDEString(operands);
		}
		return null;
	}

	private static PCOARelOperEXCLUDE createSingleConditionEXCLUDE(List<PCOAOperand> operands,
			String javaDataType) {
		if (javaDataType.equals(PCTConstants.CODE_BICDECIMAL)) {
			return new PCORelOperEXCLUDEBigDecimal(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_INTEGER)) {
			return new PCORelOperEXCLUDEInteger(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_DOUBLE)) {
			return new PCORelOperEXCLUDEDouble(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_LONG)) {
			return new PCORelOperEXCLUDELong(operands);
		} else if (javaDataType.equals(PCTConstants.CODE_STRING)) {
			return new PCORelOperEXCLUDEString(operands);
		}
		return null;
	}
}
