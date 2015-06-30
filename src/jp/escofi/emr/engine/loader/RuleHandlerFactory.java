package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * 条件文ハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件文ハンドラー群のハンドラー生成メソッドを定義したファクトリークラス。
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
public final class RuleHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private RuleHandlerFactory() {}


	/**
	 * 条件文ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @return 条件文ハンドラー
	 */
	public static ConditionHandler createConditionHandler(
			AbstractResultObjectHandler callerHandler) {
		return new ConditionHandler(callerHandler);
	}

	/**
	 * 条件式アプライハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @return 条件式アプライハンドラー
	 */
	public static ApplyHandler createApplyHandler(
			AbstractRuleHandler callerHandler) {
		return new ApplyHandler(callerHandler);
	}

	/**
	 * IF文ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule 条件文
	 * @param ifType IF-THEN-ELSE識別子
	 * @return IF文ハンドラー
	 */
	public static IFHandler createIFHandler(AbstractRuleHandler callerHandler,
			InitRule rule, IFType ifType) {
		return new IFHandler(callerHandler, rule, ifType);
	}

	/**
	 * ELSE文ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule 条件文
	 * @return ELSE文ハンドラー
	 */
	public static ELSEHandler createELSEHandler(AbstractRuleHandler callerHandler,
			InitRule rule) {
		return new ELSEHandler(callerHandler, rule);
	}

	/**
	 * 条件文ハンドラー生成処理。
	 * <P>
	 * 条件式定数ハンドラーの内部でエレメントタイプに応じたハンドラーを生成する。<BR>
	 * このメソッドで生成できるハンドラーは下記。
	 * </P>
	 * <UL>
	 * <LI>セットハンドラー(エレメントタイプ：セット)</LI>
	 * <LI>単一型ハンドラー(エレメントタイプ：セット以外)</LI>
	 * </UL>
	 * @param elementType エレメントタイプ
	 * @param callerHandler 呼出し元ハンドラー
	 * @return 条件文ハンドラー
	 */
	public static AbstractRuleHandler createRuleHandler(
			ElementType elementType, ConstHandler callerHandler) {

		switch (elementType) {
		case SET:
			return new SetHandler(callerHandler);

		default:
			return new SingleHandler(callerHandler);
		}
	}

	/**
	 * 条件文ハンドラー生成処理。
	 * <P>
	 * 関係演算式ハンドラー群の内部でエレメントタイプに応じたハンドラーを生成する。<BR>
	 * このメソッドで生成できるハンドラーは下記。
	 * </P>
	 * <UL>
	 * <LI>条件式変数ハンドラー(エレメントタイプ：条件式変数)</LI>
	 * <LI>条件式定数ハンドラー(エレメントタイプ：条件式定数)</LI>
	 * </UL>
	 * <P>
	 * エレメントタイプの値がnull、または定義外のエレメントタイプの場合はnullを返す。
	 * </P>
	 * @param elementType エレメントタイプ
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @return 条件文ハンドラー
	 */
	public static AbstractRuleHandler createRuleHandler(ElementType elementType,
			SingleConditionHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case VAR:

			String strVarInfo = atts.getValue(AttributeType.VAR_INFO.toString());
			List<String> varInfo = ConvertUtil.parseCSV(strVarInfo);

			return new VarHandler(callerHandler,
					atts.getValue(AttributeType.DATA_TYPE.toString()).intern(),
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern(),
					Collections.unmodifiableList(varInfo));

		case CONST:
			return new ConstHandler(callerHandler);

		default:
			return null;
		}
	}


	/**
	 * 演算子ハンドラー生成処理。
	 * <P>
	 * 条件式アプライハンドラー群の内部でエレメントタイプに応じた演算子ハンドラーを生成する。<BR>
	 * このメソッドで生成できる演算子ハンドラーは下記。
	 * </P>
	 * <UL>
	 * <LI>論理演算子AND</LI>
	 * <LI>論理演算子OR</LI>
	 * <LI>関係演算子EQ</LI>
	 * <LI>関係演算子NOTEQ</LI>
	 * <LI>関係演算子LT</LI>
	 * <LI>関係演算子LEQ</LI>
	 * <LI>関係演算子GT</LI>
	 * <LI>関係演算子GEQ</LI>
	 * <LI>関係演算子IN</LI>
	 * <LI>関係演算子NOTIN</LI>
	 * <LI>関係演算子INTERSECT</LI>
	 * <LI>関係演算子NOTINTERSECT</LI>
	 * <LI>関係演算子STARTSWITH</LI>
	 * <LI>関係演算子NOTSTARTSWITH</LI>
	 * <LI>関係演算子SUBSET</LI>
	 * <LI>関係演算子NOTSUBSET</LI>
	 * <LI>関係演算子INCLUDE</LI>
	 * <LI>関係演算子EXCLUDE</LI>
	 * </UL>
	 * <P>
	 * エレメントタイプの値がnull、または定義外のエレメントタイプの場合はnullを返す。
	 * </P>
	 * @param elementType エレメントタイプ
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @return 演算子ハンドラー
	 */
	public static AbstractConditionHandler createConditionHandler(ElementType elementType,
			ApplyHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case AND:
		case OR:
			return new CompositeConditionHandler(callerHandler, elementType);

		case EQ:
		case NOT_EQ:
		case LT:
		case LEQ:
		case GT:
		case GEQ:
		case IN:
		case NOT_IN:
		case INTERSECT:
		case NOT_INTERSECT:
		case START_SWITH:
		case NOT_START_SWITH:
		case SUBSET:
		case NOT_SUBSET:
			return new SingleConditionHandler(callerHandler, elementType);

		case INCLUDE:
		case EXCLUDE:
			return new SingleConditionHandler(callerHandler, elementType,
					atts.getValue(AttributeType.LOWER_EQ.toString()),
					atts.getValue(AttributeType.UPPER_EQ.toString()));

		default:
			return null;
		}
	}

}
