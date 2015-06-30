package jp.iwin.pds.xml2db.initialload.handler.factory;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.PCHAConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHAResultObjectHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHARuleHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHApplyHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHCompositeConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHConstHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHELSEHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHIFHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSetHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSingleConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSingleHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHVarHandler;

import org.xml.sax.Attributes;


/**
 * 条件文ハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件文ハンドラー群のハンドラー生成メソッドを定義したファクトリークラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1062 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 11:11:06 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHDelegateHandlerFactory
 * @see jp.iwin.pds.initialload.handler.PCHApplyHandler
 * @see jp.iwin.pds.initialload.handler.PCHCompositeConditionHandler
 * @see jp.iwin.pds.initialload.handler.PCHConditionHandler
 * @see jp.iwin.pds.initialload.handler.PCHConstHandler
 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
 * @see jp.iwin.pds.initialload.handler.PCHSingleConditionHandler
 * @see jp.iwin.pds.initialload.handler.PCHValueHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHRuleHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private PCHRuleHandlerFactory() {}

	/**
	 * 条件文ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @return 条件文ハンドラー
	 * @see jp.iwin.pds.initialload.handler.PCHValueHandler
	 */
	public static PCHConditionHandler createConditionHandler(
			PCHAResultObjectHandler callerHandler) {
		return new PCHConditionHandler(callerHandler);
	}

	/**
	 * 条件式カッコハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @return 条件式カッコハンドラー
	 * @see jp.iwin.pds.initialload.handler.PCHCompositeConditionHandler
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 */
	public static PCHApplyHandler createApplyHandler(
			PCHARuleHandler callerHandler, XMLWriter writer) {
		return new PCHApplyHandler(callerHandler, writer);
	}

	/**
	 * IF文ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule 条件文
	 * @param ifType IF-THEN-ELSE識別子
	 * @return IF文ハンドラー
	 * @see jp.iwin.pds.initialload.handler.PCHConditionHandler
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 */
	public static PCHIFHandler createIFHandler(PCHARuleHandler callerHandler,
			PROINIRule rule, PCTIFType ifType, XMLWriter writer) {
		return new PCHIFHandler(callerHandler, rule, ifType, writer);
	}

	/**
	 * ELSE文ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule 条件文
	 * @return ELSE文ハンドラー
	 * @see jp.iwin.pds.initialload.handler.PCHConditionHandler
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 */
	public static PCHELSEHandler createELSEHandler(PCHARuleHandler callerHandler,
			PROINIRule rule, XMLWriter writer) {
		return new PCHELSEHandler(callerHandler, rule,writer);
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
	 * @see jp.iwin.pds.initialload.handler.PCHConstHandler
	 */
	public static PCHARuleHandler createRuleHandler(
			PCTElementType elementType, PCHConstHandler callerHandler,XMLWriter writer) {

		switch (elementType) {
		case SET:
			return new PCHSetHandler(callerHandler,writer);

		default:
			return new PCHSingleHandler(callerHandler,writer);
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
	 * @see jp.iwin.pds.initialload.handler.PCHSingleConditionHandler
	 */
	public static PCHARuleHandler createRuleHandler(PCTElementType elementType,
			PCHSingleConditionHandler callerHandler, Attributes atts, XMLWriter writer) {

		switch (elementType) {
		case VAR:
			return new PCHVarHandler(callerHandler,
					atts.getValue(PCTAttributeType.DATATYPE.toString()).intern(),
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern(),
					atts.getValue(PCTAttributeType.VARINFO.toString()).intern(),
					atts.getValue(PCTAttributeType.JPNAME.toString()),writer);

		case CONST:
			return new PCHConstHandler(callerHandler,writer);

		default:
			return null;
		}
	}


	/**
	 * 演算子ハンドラー生成処理。
	 * <P>
	 * 条件式カッコハンドラー群の内部でエレメントタイプに応じた演算子ハンドラーを生成する。<BR>
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
	 * @see jp.iwin.pds.initialload.handler.PCHApplyHandler
	 */
	public static PCHAConditionHandler createConditionHandler(PCTElementType elementType,
			PCHApplyHandler callerHandler, Attributes atts, XMLWriter writer) {

		switch (elementType) {
		case AND:
		case OR:
			return new PCHCompositeConditionHandler(callerHandler, elementType, writer);

		case EQ:
		case NOTEQ:
		case LT:
		case LEQ:
		case GT:
		case GEQ:
		case IN:
		case NOTIN:
		case INTERSECT:
		case NOTINTERSECT:
		case STARTSWITH:
		case NOTSTARTSWITH:
		case SUBSET:
		case NOTSUBSET:
			return new PCHSingleConditionHandler(callerHandler, elementType, writer);

		case INCLUDE:
		case EXCLUDE:
			return new PCHSingleConditionHandler(callerHandler, elementType,
					atts.getValue(PCTAttributeType.LOWEREQ.toString()).intern(),
					atts.getValue(PCTAttributeType.UPPEREQ.toString()).intern(),writer);

		default:
			return null;
		}
	}

}
