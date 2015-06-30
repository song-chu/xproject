package jp.iwin.pds.xml2db.dumptool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTConstants;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * オブジェクトライタークラス。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>PDSオブジェクト（HashMap）の属性値が取得できるまでのキー項目ツリー構造を書き出すクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1230 $
 *  <DT>最終開発日時：
 *   <DD>$Date:: 2010-12-09 15:44:09 +0900#$
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public class PDMObjectWriter {
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

		if (filePath == null) {
			filePath = PUTPropertyUtil.getProperty("xml.dumpxml.base");
		}

		if (dataModelName.equals("all")) {
			Set<String> keySet = pdsObject.keySet();
			for (String key : keySet) {
				objectWrite(filePath, key,
						(Map<String, Object>) pdsObject.get(key),
						pdsItemKeys.get(key));
			}
		} else {
			objectWrite(filePath, dataModelName,
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
		PUTXMLWriter witer = null;
		try {
			witer = new PUTXMLWriter(new OutputStreamWriter(
					new FileOutputStream(fullFileName), PCTConstants.CHARSET));
			witer.startDocument();
			witer.setIndentStep(4);

			Attributes atts = makeKeyItemAttr(witer, dataModelName, null);
			witer.startElement(PCTElementType.DATAMODEL.toString(), atts);
			mapExplore(dataModel, keyItemNames, 0, witer);
			witer.endElement(PCTElementType.DATAMODEL.toString());
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
			List<String> keyItemNames, int index, PUTXMLWriter writer)
			throws SAXException {
		// キー順でソートする。
		List<Map.Entry<String, Object>> entries = PUTConvertUtil
				.sortMap(dataModel);

		// 繰り返し処理
		for (Map.Entry<String, Object> entry : entries) {
			Object value = entry.getValue();

			// KeyItemWriteStart(keyItemNames.get(index), entry.getKey(), w);
			Attributes atts = makeKeyItemAttr(writer, keyItemNames.get(index),
					entry.getKey());
			writer.startElement(PCTElementType.KEYITEM.toString(), atts);
			index++;
			// 結果オブジェクトかMapかより書き出しメソッドを分けて呼び出し
			if (value instanceof PROResultObject) {
				((PROResultObject) value).toDump(writer);
			} else {
				mapExplore((Map<String, Object>) value, keyItemNames, index,
						writer);
			}
			index--;
			// KeyItemWriteEnd(w);
			writer.endElement(PCTElementType.KEYITEM.toString());
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
	private static Attributes makeKeyItemAttr(PUTXMLWriter writer, String name,
			String key) {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.NAME.toString(), name);
		if (key != null) {
			writer.addAttribute(atts, PCTAttributeType.KEY.toString(), key);
		}
		return atts;
	}

}
