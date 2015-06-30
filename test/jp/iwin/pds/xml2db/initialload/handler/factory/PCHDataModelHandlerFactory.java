package jp.iwin.pds.xml2db.initialload.handler.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.initialload.handler.PCHDataModelHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;

import org.w3c.dom.Element;
import org.xml.sax.XMLReader;


/**
 * データモデルハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデルハンドラー生成メソッドを定義したファクトリークラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1230 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-09 15:44:09 +0900 (譛ｨ, 09 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.PILInitialLoader
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCHDataModelHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private PCHDataModelHandlerFactory() {}


	/**
	 * データモデルハンドラー生成処理。
	 * <P>
	 * 生成するデータモデルハンドラーには予めキー項目ハンドラーをセットしておく。
	 * </P>
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 * @param reader SAXリーダー
	 * @param dataModel データモデルのエレメント情報
	 * @param pdsObjectLocal ローカル変数のPDSオブジェクト（継承元用のテンポラリMap）
	 * @param itemKeys キー項目名リスト
	 * @return データモデルハンドラーの新規インスタンス
	 */
	public static PCHDataModelHandler createDataModelHandler(
			XMLReader reader, Element dataModel, Map<String, Object> pdsObjectLocal, List<String> itemKeys,HashMap<String, List<String>> pdsItemKeysLocal) {
		// データモデル名
		String dataModelName = dataModel.getAttribute(PCTAttributeType.NAME.toString()).intern();

		// DataModelHandler生成
		PCHDataModelHandler dataModelHandler = new PCHDataModelHandler(reader, dataModelName);

		// KeyItemHandler生成
		PCHKeyItemHandler keyItemHandler = PCHKeyItemHandlerFactory.createKeyItemHandler(
				dataModelHandler, dataModel, pdsObjectLocal, itemKeys,pdsItemKeysLocal);

		// 予めKeyItemHandlerをセットしておく
		dataModelHandler.setKeyItemHandler(keyItemHandler);

		return dataModelHandler;
	}

}
