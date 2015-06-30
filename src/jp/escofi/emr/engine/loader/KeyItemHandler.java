package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;

import org.xml.sax.Attributes;


/**
 * キー項目ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値（{@code <value>}）要素が現すまで、属性keyを持つ要素を制御するSAXのイベントハンドラー。
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
public class KeyItemHandler extends AbstractDelegateHandler {

	/**
	 * キー項目名リスト
	 */
	protected List<String> keyNameList = new ArrayList<String>();
	/**
	 * 属性値オブジェクト
	 */
	protected Object objValue = null;
	/**
	 * 子データモデル情報マップ
	 */
	protected Map<String, Object> dataModelMap;
	/**
	 * キー項目リスト
	 */
	protected List<String> keys;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 */
	public KeyItemHandler(DataModelHandler callerHandler) {

		super(callerHandler);

		dataModelMap = callerHandler.getDataModelMap();
		keys = callerHandler.getKeys();
	}


	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>参照中のタグが属性値の場合は、継承元クラス変数：XMLリーダーのハンドラーに、
	 *属性値ハンドラーを設定する。</LI>
	 *  <LI>参照中のタグが上記以外は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：子データモデル情報マップから、
	 *キー項目リストの最後の項目のデータモデルマップを取得する。</LI>
	 *    <LI>アトリビュート情報から、データモデル名を取得する。</LI>
	 *    <LI>アトリビュート情報から、キー項目を取得する。</LI>
	 *    <LI>取得したデータモデル名に対応するデータモデルのマップインスタンスを取得する。</LI>
	 *    <LI>取得したデータモデルマップに、取得したマップインスタンスを格納する。</LI>
	 *    <LI>クラス変数：キー項目リストに、取得したキー項目を格納する。</LI>
	 *    <LI>クラス変数：キー項目名リストに、取得したデータモデル名を格納する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case VALUE:
			ValueHandler handler = ResultObjectHandlerFactory.createValueHandler(
					this, atts);
			reader.setContentHandler(handler);

			break;

		default:
			Map<String, Object> map = getDataModelMap(dataModelMap, keys);
			String keyName = atts.getValue(AttributeType.NAME.toString()).intern();
			String key = atts.getValue(AttributeType.KEY.toString()).intern();

			if (map != null) {
				Map<String, Object> childMap;

				if (AttributeType.ATTR_NAME.isEquals(keyName)) {
					childMap = new TreeMap<String, Object>();
				} else {
					childMap = new HashMap<String, Object>();
				}
				objValue = childMap;
				map.put(key, childMap);
			}
			keys.add(key);
			keyNameList.add(keyName);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 * <UL>
	 *  <LI>参照中のタグがデータモデルの場合は、継承元クラス変数：XMLリーダーのハンドラーに、
	 *継承元クラス変数：呼出し元ハンドラーを設定する。
	 *  </LI>
	 *  <LI>参照中のタグがキー項目の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：キー項目名リストから最後の項目を削除する。</LI>
	 *    <LI>クラス変数：キー項目リストから最後の項目を取り出し、リストから削除する。</LI>
	 *    <LI>クラス変数：子データモデル情報マップから、
	 *キー項目リストの最後の項目のデータモデルマップを取得する。</LI>
	 *    <LI>取得したデータモデルマップに、クラス変数：属性値オブジェクトを格納する。</LI>
	 *    <LI>クラス変数：属性値オブジェクトに、取得したデータモデルマップを保持する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */

	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case KEY_ITEM:
			// キー項目から削除
			String keyName = keyNameList.remove(keyNameList.size() - 1);

			// 継承関係解決処理
			initDataModelMap(keyName);

			String key = keys.remove(keys.size() - 1);
			Map<String, Object> map = getDataModelMap(dataModelMap, keys);

			map.put(key, objValue);
			objValue = map;
			break;

		case DATA_MODEL:
			// データモデルタグを抜ける時にXMLリーダーのハンドラーを
			// 呼出し元ハンドラー（データモデルハンドラー）に戻す
			// データモデルハンドラー側ではendElement処理は実装していないので、
			// キー項目ハンドラーでデータモデルの閉じタグを参照して問題なし
			reader.setContentHandler(callerHandler);
			break;
		}
	}


	/**
	 * データモデルマップを取得。
	 *
	 * @param orgMap データモデルマップ
	 * @param keys キー項目リスト
	 * @return データモデルマップ
	 */
	@SuppressWarnings("unchecked")
	protected final Map<String, Object> getDataModelMap(
			Map<String, Object> orgMap, List<String> keys) {
		Map<String, Object> map = orgMap;

		for (String key : keys) {
			map = (Map<String, Object>) map.get(key);
		}

		return map;
	}

	/**
	 * @param value 属性値オブジェクト
	 */
	protected final void setValue(Object value) {
		objValue = value;
	}

	/**
	 * 継承関係解決。
	 * <P>
	 * キー項目の継承関係解決処理を行う。<BR>
	 * 通常は何もしない。<BR>
	 * 継承先キー項目ハンドラー側で処理ロジックを実装させる為のメソッド。
	 * </P>
	 * @param keyName 参照中のキー項目名
	 */
	protected void initDataModelMap(String keyName) {}

}
