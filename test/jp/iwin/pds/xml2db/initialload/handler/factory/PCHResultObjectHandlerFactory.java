package jp.iwin.pds.xml2db.initialload.handler.factory;

import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.PCHARuleHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHResultHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHValueHandler;

import org.xml.sax.Attributes;


/**
 * 属性値ハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値ハンドラー郡のハンドラー生成メソッドを定義したファクトリークラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1062 $
 *  <DT>最終開発日時：
 *   <DD>$Date 2010-11-26 19:51:57 +0900 (金, 26 11 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
 * @see jp.iwin.pds.initialload.handler.PCHELSEHandler
 * @see jp.iwin.pds.initialload.handler.PCHKeyItemHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHResultObjectHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private PCHResultObjectHandlerFactory() {}


	/**
	 * 属性値ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @return 属性値ハンドラーの新規インスタンス
	 * @see jp.iwin.pds.initialload.handler.PCHKeyItemHandler
	 */
	public static PCHValueHandler createValueHandler(
			PCHKeyItemHandler callerHandler, Attributes atts,String jpname) {

		return new PCHValueHandler(callerHandler, atts, jpname);
	}

	/**
	 * 条件式結果ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @param rule ルールオブジェクト
	 * @param ifType 条件式タイプ
	 * @return 条件式結果ハンドラーの新規インスタンス
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 * @see jp.iwin.pds.initialload.handler.PCHELSEHandler
	 */
	public static PCHResultHandler createResultHandler(PCHARuleHandler callerHandler,
			Attributes atts, PROINIRule rule, PCTIFType ifType, XMLWriter writer) {

		return new PCHResultHandler(callerHandler, rule, ifType, atts, writer);
	}
}
