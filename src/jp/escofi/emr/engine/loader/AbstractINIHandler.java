package jp.escofi.emr.engine.loader;

import java.util.Map;

import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 親ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>タグ処理用のハンドラー群の共通処理を記載するSAXのイベントハンドラー。（抽象クラス）
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
abstract class AbstractINIHandler extends DefaultHandler {

	/**
	 * XMLリーダー
	 */
	protected XMLReader reader;
	/**
	 * 引数項目マップ
	 */
	protected Map<String, ConditionItemInfo> globalConditionItemMap;

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
}
