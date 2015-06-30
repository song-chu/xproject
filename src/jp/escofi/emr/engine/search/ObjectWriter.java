package jp.escofi.emr.engine.search;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * オブジェクトライタークラス。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>PDSオブジェクト（HashMap）の属性値が取得できるまでのキー項目ツリー構造を書き出すクラス。
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
public class ObjectWriter {
	/**
	 * ダンプ実行。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>引数によりファイルパスとダンプ範囲を決め、実行する。
	 * </DL>
	 * @param filePath ファイルパス
	 * @param dataModelName データモデル名
	 * @param pdsObject PDSオブジェクト
	 * @param pdsItemKeys データモデル別キー項目リスト
	 * @throws IOException ファイル入出力エラー
	 * @throws SAXException XML解析エラー
	 */
	@SuppressWarnings("unchecked")
	public static void excuteDump(String filePath, String dataModelName,
			Map<String, Object> pdsObject,
			HashMap<String, List<String>> pdsItemKeys) throws IOException,
			SAXException {

		String path = filePath;
		if (path == null || path.equals("")) {
			path = PropertyUtil.getProperty("xml.dumpxml.base");
		}

		if (dataModelName.equals(Constants.DATA_MODEL_ALL)) {
			Set<String> keySet = pdsObject.keySet();
			for (String key : keySet) {
				objectWrite(path, key,
						(Map<String, Object>) pdsObject.get(key),
						pdsItemKeys.get(key));
			}
		} else {
			objectWrite(path, dataModelName,
					(Map<String, Object>) pdsObject.get(dataModelName),
					pdsItemKeys.get(dataModelName));
		}

	}

	/**
	 * オブジェクト書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>XMLライターを生成し、ルートエレメントを書き出す。
	 * </DL>
	 * @param filePath ファイルパス
	 * @param dataModelName データモデル名
	 * @param dataModel データモデル
	 * @param keyItemNames キー項目リスト
	 * @throws IOException ファイル入出力エラー
	 * @throws SAXException XML解析エラー
	 */
	private static void objectWrite(String filePath, String dataModelName,
			Map<String, Object> dataModel, List<String> keyItemNames)
			throws SAXException, IOException {

		String fullFileName = getFilePath(filePath, dataModelName);
		XMLWriter witer = null;
		try {
			witer = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(fullFileName), Constants.XML_IO_CHARSET));
			witer.startDocument();
			witer.setIndentStep(4);

			Attributes atts = makeKeyItemAttr(witer, dataModelName, null);
			witer.startElement(ElementType.DATA_MODEL.toString(), atts);
			mapExplore(dataModel, keyItemNames, 0, witer);
			witer.endElement(ElementType.DATA_MODEL.toString());
			witer.endDocument();
		} catch (SAXException e) {
			witer.flush();
			throw e;
		}

	}

	/**
	 * キー項目書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>属性値が取得できるまでのキー項目ツリー構造を書き出す。
	 * </DL>
	 * @param dataModel データモデルマップ
	 * @param keyItemNames キー項目リスト
	 * @param index キー項目レベル
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	@SuppressWarnings("unchecked")
	private static void mapExplore(Map<String, Object> dataModel,
			List<String> keyItemNames, int index, XMLWriter writer)
			throws SAXException {
		// キー順でソートする。
		List<Map.Entry<String, Object>> entries = ConvertUtil
				.sortMap(dataModel);

		// 繰り返し処理
		int tempIndex = index;
		for (Map.Entry<String, Object> entry : entries) {
			Object value = entry.getValue();

			Attributes atts = makeKeyItemAttr(writer, keyItemNames.get(tempIndex),
					entry.getKey());
			writer.startElement(ElementType.KEY_ITEM.toString(), atts);
			tempIndex++;
			// 結果オブジェクトかMapかより書き出しメソッドを分けて呼び出し
			if (value instanceof ResultObject) {
				((ResultObject) value).toDump(writer);
			} else {
				mapExplore((Map<String, Object>) value, keyItemNames, tempIndex,
						writer);
			}
			tempIndex--;
			writer.endElement(ElementType.KEY_ITEM.toString());
		}
	}

	/**
	 * ファイルフルネーム生成。
	 *
	 * @param filePath ファイルパス
	 * @param dataModelName データモデル名
	 * @return ファイルフルネーム
	 */
	private static String getFilePath(String filePath, String dataModelName) {

		StringBuilder dataModelPath = new StringBuilder(filePath);
		Date date = new Date();
		dataModelPath.append("/");
		dataModelPath.append(dataModelName);
		dataModelPath.append("_");
		dataModelPath.append(new SimpleDateFormat("yyyyMMdd").format(date
				.getTime()));
		dataModelPath.append("_");
		dataModelPath.append(new SimpleDateFormat("HHmmss").format(date
				.getTime()));
		dataModelPath.append(".xml");

		return dataModelPath.toString();

	}

	/**
	 * アトリビュート生成。
	 *
	 * @param writer ライター
	 * @param name アトリビュートnameの値
	 * @param key アトリビュートkeyの値
	 * @return アトリビュート
	 */
	private static Attributes makeKeyItemAttr(XMLWriter writer, String name,
			String key) {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.NAME.toString(), name);
		if (key != null) {
			writer.addAttribute(atts, AttributeType.KEY.toString(), key);
		}
		return atts;
	}

}
