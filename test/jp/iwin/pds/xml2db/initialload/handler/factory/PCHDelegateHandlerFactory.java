package jp.iwin.pds.xml2db.initialload.handler.factory;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.initialload.handler.PCHADelegateHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHAResultObjectHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHListHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHMapHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHObjectHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHRangeHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSingleHandler;

import org.xml.sax.Attributes;


/**
 * Delegateハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>Delegateハンドラー郡のハンドラー生成メソッドを定義したファクトリークラス。
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
 * @see jp.iwin.pds.initialload.handler.PCHAResultObjectHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHDelegateHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private PCHDelegateHandlerFactory() {}


	/**
	 * Delegateハンドラー生成処理。
	 * <P>
	 * 属性値ハンドラー郡の内部でエレメントタイプに応じたハンドラーを生成する。<br>
	 * このメソッドで生成できるハンドラーは下記。
	 * </P>
	 * <UL>
	 * <LI>リスト型ハンドラー</LI>
	 * <LI>マップ型ハンドラー</LI>
	 * <LI>範囲型ハンドラー</LI>
	 * <LI>単一型ハンドラー</LI>
	 * <LI>オブジェクト型ハンドラー</LI>
	 * </UL>
	 * <P>
	 * エレメントタイプの値がnull、または定義外のエレメントタイプの場合はnullを返す。
	 * </P>
	 * <P>
	 * 条件式定数ハンドラー内で単一型ハンドラーを生成する場合は、このメソッドではなく、
	 * {@link PCHRuleHandlerFactory#createRuleHandler(PCTElementType, jp.iwin.pds.initialload.handler.PCHConstHandler)}
	 * を使用する。
	 * </P>
	 * @param elementType エレメントタイプ
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @return エレメントタイプに応じたハンドラー
	 * @see jp.iwin.pds.initialload.handler.PCHAResultObjectHandler
	 */
	public static PCHADelegateHandler createDelegateHandler(
			PCTElementType elementType, PCHAResultObjectHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case LIST:
			return new PCHListHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case MAP:
			return new PCHMapHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case RANGE:
			return new PCHRangeHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case SINGLE:
			return new PCHSingleHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case OBJECT:
			return new PCHObjectHandler(callerHandler,
					atts.getValue(PCTAttributeType.CLASSNAME.toString()).intern(),
					atts.getValue(PCTAttributeType.SUBINFO.toString()).intern());

		default:
			return null;
		}
	}

}
