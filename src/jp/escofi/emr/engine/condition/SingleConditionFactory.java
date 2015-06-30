package jp.escofi.emr.engine.condition;

import java.util.List;

import jp.escofi.emr.engine.common.constant.CodeType;
import jp.escofi.emr.engine.common.constant.ConditionType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

/**
 * 関係演算式の生成を担当するFacrotyクラス
 * <DL>
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/08/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public final class SingleConditionFactory {

	/**
	 * 関係演算式を生成する。
	 *
	 * @param operands
	 *            オペランドのリスト
	 * @param conditionType
	 *            演算子種類
	 * @param javaDataType
	 *            Javaデータ型
	 * @param dataTypes
	 *            データ種別リスト
	 * @return 関係演算式
	 * @throw IllegalArgumentException 引数不正例外
	 *        <UL>
	 *        <LI>引数のconditionType、javaDataType、containsSetの整合性が合わない場合
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
	 * 演算子種類とJavaデータ型との整合性チェック。
	 *
	 * @param conditionType
	 *            演算子種類
	 * @param javaDataType
	 *            Javaデータ型
	 * @param containsSet
	 *            データ型がset型かの判定値
	 * @throw IllegalArgumentException 引数不正例外
	 *        <UL>
	 *        <LI>引数のconditionType、javaDataType、containsSetの整合性が合わない場合
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
	 * 条件判定EQ演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @param isSet
	 *            データ型がset型かの判定値
	 * @return 条件判定オブジェクト
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
	 * 条件判定NOTEQ演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @param isSet
	 *            データ型がset型かの判定値
	 * @return 条件判定オブジェクト
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
	 * 条件判定GT演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定GEQ演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定LT演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定LEQ演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定IN演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定NOTIN演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定SUBSET演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定NOTSUBSET演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定INTERSECT演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定NOTINTERSECT演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定STARTSWITH演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
	 */
	private static RelOperSTARTSWITH createSingleConditionSTARTSWITH(
			List<AbstractOperand> operands, CodeType javaDataType) {

		return new RelOperSTARTSWITH(operands);
	}

	/**
	 * 条件判定NOTSTARTSWITH演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
	 */
	private static RelOperNOTSTARTSWITH createSingleConditionNOTSTARTSWITH(
			List<AbstractOperand> operands, CodeType javaDataType) {

		return new RelOperNOTSTARTSWITH(operands);
	}

	/**
	 * 条件判定INCLUDE演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
	 * 条件判定EXCLUDE演算オブジェクトを作成
	 *
	 * @param operands
	 *            オペランドリスト
	 * @param javaDataType
	 *            JAVAデータタイプ
	 * @return 条件判定オブジェクト
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
