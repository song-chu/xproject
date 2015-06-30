package jp.escofi.emr.engine.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.MessageType;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.loader.DataModelHandlerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
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
 *  InitialLoader loader = new InitialLoader();
 *
 *  {@code HashMap<String, Object>} pdsObjects = loader.getPDSObject();
 *  {@code HashMap<String, List<String>>} pdsItemKeys = loader.getPDSItemKeys();
 * </TT></PRE>
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
public final class InitialLoader {

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
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws IOException ファイル入出力エラー
	 * @throws SAXException XML解析エラー
	 * @throws EMRException XMLファイルが存在しない、またはスキーマチェックエラー
	 */
	public InitialLoader() throws IOException, SAXException, ParserConfigurationException, EMRException {

		// ローカル変数のPDSオブジェクト（継承元用のテンポラリMap）
		Map<String, Object> pdsObjectLocal = new HashMap<String, Object>();

		// DOMを利用し、XMLファイル管理を取得・展開する。
		Document metaInfoDoc = ResourceManager.getXMLMetaInfoDocument();

		// XMLファイル管理のルートエレメント取得
		Element dRoot = metaInfoDoc.getDocumentElement();

		// <datamodel>ノードリスト取得
		NodeList dataModels = dRoot.getElementsByTagName(ElementType.DATA_MODEL.toString());

		// DataModelの読み込み・展開
		int items = dataModels.getLength();
		for (int i = 0; i < items; i++) {
			Element dataModel = (Element) dataModels.item(i);
			if (dataModel.getAttribute(AttributeType.NAME.toString())
					.length() == 0) {
				throw new IllegalArgumentException(
						"Attribute 'name' must be set on element 'datamodel'.");
			} else if (dataModel.getAttribute(
					AttributeType.PARENT_FLG.toString()).length() == 0) {
				throw new IllegalArgumentException(
						"Attribute 'parentflg' must be set on element 'datamodel'.");
			}

			readDataModel(dataModel, pdsObjectLocal);
		}
	}


	/**
	 * @return PDSオブジェクトマップ
	 */
	public HashMap<String, Object> getPdsObject() {
		return pdsObject;
	}

	/**
	 * @return キー項目マップ
	 */
	public HashMap<String, List<String>> getPdsItemKeys() {
		return pdsItemKeys;
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
	 * @throws EMRException XMLファイルが存在しない、またはスキーマチェックエラー
	 */
	private void readDataModel(Element dataModel, Map<String, Object> pdsObjectLocal)
	throws IOException, SAXException, ParserConfigurationException, EMRException {
		// SAX reader
		XMLReader reader = ResourceManager.getSAXReader();

		List<String> itemKeys = getKeyItemList(dataModel);

		// DataModelHandler生成
		DataModelHandler dataModelHandler = DataModelHandlerFactory.createDataModelHandler(
				reader, dataModel, pdsObjectLocal, itemKeys);

		reader.setContentHandler(dataModelHandler);

		// エラーハンドラーセット
		reader.setErrorHandler(dataModelHandler);


		// データモデルファイルPath
		String dataModelFile = dataModel.getAttribute(AttributeType.FILE.toString());

		// データモデルフルPath
		String dataModelPath = getDataModelPath(dataModelFile);

		// XMLファイルの存在チェック
		if (!new File(dataModelPath).canRead()) {
			throw new EMRException(
					MessageCode.EMR_A_P004E, new Object[]{MessageType.DATA_MODEL, dataModelPath});
		}

		InputStreamReader isr = null;

		// XML解析
		try {
			isr = new InputStreamReader(new FileInputStream(dataModelPath), Constants.XML_IO_CHARSET);
			InputSource inputSource = new InputSource(isr);
			reader.parse(inputSource);
		} catch (SAXException e) {
			throw new EMRException(
					MessageCode.EMR_A_P005E, new Object[]{MessageType.DATA_MODEL, dataModelFile}, e);
		} finally {
			if (isr != null) {
				isr.close();
			}
		}
		Map<String, Object> dataModelMap = dataModelHandler.getDataModelMap();

		// 継承元か否かのフラグ
		String parentFlg = dataModel.getAttribute(AttributeType.PARENT_FLG.toString());
		if (ConvertUtil.isConvertBoolean(parentFlg)) {
			// 継承元の場合はローカル変数に保存
			pdsObjectLocal.putAll(dataModelMap);
		} else {
			// 個社の場合はクラスのメンバー変数に保存
			pdsObject.putAll(dataModelMap);
			pdsItemKeys.put(dataModelHandler.getDataModelName(), itemKeys);
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
				PropertyUtil.getProperty("xml.datamodel.base"));
		dataModelPath.append(System.getProperty("file.separator", "/"));
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
		NodeList elements = dataModel.getElementsByTagName(ElementType.KEY_ITEM.toString());
		int childItemLength = elements.getLength();

		for (int i = 0; i < childItemLength; i++) {
			Element elem = (Element) elements.item(i);
			// キー項目名
			Text elemName = (Text) elem.getFirstChild();
			itemKeys.add(elemName.getData());
		}

		return itemKeys;
	}

}
