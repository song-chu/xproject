package jp.iwin.pds.xml2db.initialload.handler;

import java.util.Map;

import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 親ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>タグ処理用のハンドラー群の共通処理を記載するSAXのイベントハンドラー。（抽象クラス）
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1405 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-10 18:08:01 +0900 (驥 10 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHADelegateHandler
 * @see PCHDataModelHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
abstract class PCHAINIHandler extends DefaultHandler {

	/**
	 * XMLリーダー
	 */
	protected XMLReader reader;
	/**
	 * 引数項目マップ
	 */
	protected Map<String, PROConditionItemInfo> globalConditionItemMap;

	/**
	 * エラー情報出力処理。
	 * <P>
	 * XML解析例外をシステム側へthrowする。<BR>
	 * 詳細なエラーハンドリングは解析実行処理側で行う。
	 * </P>
	 * @param e XML解析例外
	 * @throws SAXException XML解析例外
	 */
	@Override
	public void error(SAXParseException e) throws SAXException {
		throw e;
	}

	/**
	 * 引数項目Mapを取得（XML２DB）
	 * @return
	 */
	public Map<String, PROConditionItemInfo> getGlobalConditionItemMap() {
		return globalConditionItemMap;
	}
}
