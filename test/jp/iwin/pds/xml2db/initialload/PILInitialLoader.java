package jp.iwin.pds.xml2db.initialload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTMessageType;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.initialload.handler.PCHDataModelHandler;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHDataModelHandlerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 * イニシャルローダー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>
 *    <UL>
 *     <LI>XMLファイル管理（XMLファイル）を読み込み、ファイルの読み込み順、継承関係、キー情報及び選択方式（Map展開方式）情報を取得する。
 *     <LI>読み込み順でデータモデルXMLを読み込み、パース処理を行う。
 *     <LI>XMLファイル管理の参照先は、設定ファイルから取得する。
 *     <LI>データモデルのXML定義ファイルの参照先は、XMLファイル管理から取得する。
 *     <LI>XMLファイル管理、データモデルのXML定義ファイルの解析は、内部でXML解析ハンドラーを生成して行う。
 *    </UL>
 *  <DT>サンプルコード：
 *   <DD>他メソッドから呼出し例
 *    <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'><TT>
 *  PILInitialLoader loader = new PILInitialLoader();
 *
 *  {@code HashMap<String, Object>} pdsObjects = loader.getPDSObject();
 *  {@code HashMap<String, List<String>>} pdsItemKeys = loader.getPDSItemKeys();
 * </TT></PRE>
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
 * @see jp.iwin.pds.dumptool.PDMObjectWriter
 * @see jp.iwin.pds.engine.PENEngine
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PILInitialLoader {

	/**
	 * キー項目マップ
	 */
	private HashMap<String, List<String>> pdsItemKeys = new HashMap<String, List<String>>();

	/**
	 * PDSオブジェクトマップ
	 */
	private HashMap<String, Object> pdsObject = new HashMap<String, Object>();


	/**
	 * コンストラクタ。
	 * <DL>
	 *	<DT>使用目的/機能概要：
	 *	 <DD>クラスロード時に、データモデルのインスタンス化を行う。
	 *	 <DD>データモデルのインスタンス化は下記の処理順で行う。
	 *	 <DD>XMLファイル管理に複数の{@code <datamodel>}が定義されている場合は、3.を{@code <datamodel>}数繰り返す。
	 *   <OL>
	 *   <LI>DOMを利用し、XMLファイル管理を取得・展開する。
	 *   <LI>{@code <datamodel>}ノードリスト取得し、{@code <datamodel>}ノード毎にデーターモデルの
	 *XML定義ファイルの参照先を取得する。
	 *   <LI>データモデルハンドラーを生成し、データモデルのインスタンス化を行い、内部のPDSオブジェクトマップ、
	 *キー項目マップへ格納する。
	 *   </OL>
	 * </DL>
	 * @see jp.iwin.pds.dumptool.PDMObjectWriter
	 * @see jp.iwin.pds.engine.PENEngine
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws IOException ファイル入出力エラー
	 * @throws SAXException XML解析エラー
	 * @throws PEXException XMLファイルが存在しない、またはスキーマチェックエラー
	 */
	public PILInitialLoader() throws IOException, SAXException, ParserConfigurationException, PEXException {

		// ローカル変数のPDSオブジェクト（継承元用のテンポラリMap）
		Map<String, Object> pdsObjectLocal = new HashMap<String, Object>();

		HashMap<String, List<String>> pdsItemKeysLocal = new HashMap<String, List<String>>();

		// DOMを利用し、XMLファイル管理を取得・展開する。
		Document metaInfoDoc = PILResourceManager.getXMLMetaInfoDocument();

		// XMLファイル管理のルートエレメント取得
		Element dRoot = (Element) metaInfoDoc.getDocumentElement();

		// <datamodel>ノードリスト取得
		NodeList dataModels = dRoot.getElementsByTagName(PCTElementType.DATAMODEL.toString());

		// DataModelの読み込み・展開
		int items = dataModels.getLength();
		for (int i = 0; i < items; i++) {
			Element dataModel = (Element) dataModels.item(i);

			readDataModel(dataModel, pdsObjectLocal, pdsItemKeysLocal);
		}
	}


	/**
	 * @return PDSオブジェクトマップ
	 */
	public HashMap<String, Object> getPDSObject() {
		return this.pdsObject;
	}

	/**
	 * @return キー項目マップ
	 */
	public HashMap<String, List<String>> getPDSItemKeys() {
		return this.pdsItemKeys;
	}

	/**
	 * データモデル読込み。
	 * <P>
	 * データモデルの読み込み・展開。
	 * </P>
	 * @param dataModel データモデルのエレメント情報
	 * @param pdsObjectLocal ローカル変数のPDSオブジェクト
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws IOException ファイル入出力エラー
	 * @throws SAXException XML解析エラー
	 * @throws PEXException XMLファイルが存在しない、またはスキーマチェックエラー
	 */
	private void readDataModel(Element dataModel, Map<String, Object> pdsObjectLocal,HashMap<String, List<String>> pdsItemKeysLocal)
	throws IOException, SAXException, ParserConfigurationException, PEXException {
		// SAX reader
		XMLReader reader = PILResourceManager.getSAXReader();

		List<String> itemKeys = getKeyItemList(dataModel);

		// データモデルファイルPath
		String dataModelFile = dataModel.getAttribute(PCTAttributeType.FILE.toString());

		// 継承元か否かのフラグ
		String parentFlg = dataModel.getAttribute(PCTAttributeType.PARENTFLG.toString());

		// DataModelHandler生成
		PCHDataModelHandler dataModelHandler = PCHDataModelHandlerFactory.createDataModelHandler(
				reader, dataModel, pdsObjectLocal, itemKeys,pdsItemKeysLocal );

		reader.setContentHandler(dataModelHandler);

		// エラーハンドラーセット
		reader.setErrorHandler(dataModelHandler);


		// データモデルフルPath
		String dataModelPath = getDataModelPath(dataModelFile);

		// XMLファイルの存在チェック
		if (!new File(dataModelPath).canRead()) {
			throw new PEXException(
					PCTMessageCode.P004E, new Object[]{PCTMessageType.DATAMODEL, dataModelPath});
		}

		// XML解析
		try {
			reader.parse(dataModelPath);
		} catch (SAXException e) {
			throw new PEXException(
					PCTMessageCode.P005E, new Object[]{PCTMessageType.DATAMODEL, dataModelFile}, e);
		}

		Map<String, Object> dataModelMap = dataModelHandler.getDataModelMap();


		if (Boolean.valueOf(parentFlg)) {
			// 継承元の場合はローカル変数に保存
			pdsObjectLocal.putAll(dataModelMap);
			pdsItemKeysLocal.put(dataModelHandler.getDataModelName(), itemKeys);
		} else {
			// 個社の場合はクラスのメンバー変数に保存
			this.pdsObject.putAll(dataModelMap);
			this.pdsItemKeys.put(dataModelHandler.getDataModelName(), itemKeys);
		}

	}

	/**
	 * データモデルファイルパス取得。
	 * <P>
	 * データモデルファイルのフルパスを取得する。
	 * </P>
	 * @param dataModelFile データモデルのファイル名
	 * @return データモデルファイルのフルパス
	 */
	private String getDataModelPath(String dataModelFile) {

		// データモデルフルPath
		StringBuilder dataModelPath = new StringBuilder(
				PUTPropertyUtil.getProperty("xml.datamodel.base"));
		dataModelPath.append("/");
		dataModelPath.append(dataModelFile);

		return dataModelPath.toString();
	}

	/**
	 * キー項目名リスト取得。
	 *
	 * @param dataModel データモデルのエレメント情報
	 * @return キー項目名リスト
	 */
	private List<String> getKeyItemList(Element dataModel) {
		List<String> itemKeys = new ArrayList<String>();

		// KeyList取得
		NodeList elements = dataModel.getElementsByTagName(PCTElementType.KEYITEM.toString());
		int childItemLength = elements.getLength();

		// 入れ子の情報を取りやすくするため、一番下のエレメントから取り出す。
		for (int i = 0; i < childItemLength; i++) {
			Element elem = (Element) elements.item(i);
			// キー項目名
			Text elemName = (Text) elem.getFirstChild();
			itemKeys.add(elemName.getData());
		}

		return itemKeys;
	}

}
