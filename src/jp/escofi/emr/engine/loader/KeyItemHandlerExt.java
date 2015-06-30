package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

import org.xml.sax.Attributes;

/**
 * 継承先キー項目ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値（{@code <value>}）要素が現すまで、属性keyを持つ要素を制御するSAXのイベントハンドラー。<BR>
 *       データモデルのインスタンスを生成する際に、継承元データモデルが有る場合は、このクラスを使用する。
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
public final class KeyItemHandlerExt extends KeyItemHandler {

	/**
	 * version/pattern/dateの初期値
	 */
	private String pdsObject;
	/**
	 * attrnameタグの親タグ名
	 */
	private String attrNameParent;
	/**
	 * attrnameタグの子タグ名
	 */
	private String attrNameChild;
	/**
	 * 継承元のデータモデルマップ
	 */
	private Map<String, Object> orgDM;
	/**
	 * 継承元キー項目リスト
	 */
	private List<String> extendsKeys = new ArrayList<String>();

	/**
	 * コンストラクタ。
	 *
	 * @param dataModelHandler
	 *            呼出し元ハンドラー
	 * @param orgDM
	 *            継承元のデータモデルマップ
	 * @param extendsInfo
	 *            継承情報
	 */
	public KeyItemHandlerExt(DataModelHandler dataModelHandler,
			Map<String, Object> orgDM, Map<AttributeType, String> extendsInfo) {

		super(dataModelHandler);

		this.orgDM = orgDM;
		attrNameParent = extendsInfo.get(AttributeType.ATTR_NAME_PARENT);
		attrNameChild = extendsInfo.get(AttributeType.ATTR_NAME_CHILD);
		pdsObject = extendsInfo.get(AttributeType.INIT_VALUE);
	}

	/**
	 * タグ開始処理。
	 * <OL>
	 * <LI>アトリビュート情報に継承元情報がある場合、継承元情報を継承元キー項目リストに追加する。</LI>
	 * <LI>継承元クラスのタグ開始処理を呼出す。</LI>
	 * </OL>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ローカル名
	 * @param qName
	 *            参照中のタグ名
	 * @param atts
	 *            アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		String org = atts.getValue(AttributeType.ORG.toString());

		if (org != null) {
			extendsKeys.add(org);
		}
		super.startElement(uri, localName, qName, atts);
	}

	/**
	 * 継承関係解決。
	 * <P>
	 * 継承元クラス変数：キー項目名リストの最後の項目が、 クラス変数：attrNameタグの親タグ名と一致する場合は、継承関係解決処理を実行する。
	 * </P>
	 *
	 * @param keyName
	 *            参照中のキー項目名
	 * @throw IllegalArgumentException 引数不正例外
	 *        <UL>
	 *        <LI>継承元マップが取得できなかった場合
	 *        </UL>
	 */
	@Override
	protected void initDataModelMap(String keyName) {

		// 継承元クラスでない場合は処理を抜ける。
		if (!attrNameParent.equals(keyName)) {
			return;
		}
		// 継承元のMAP取得
		Map<String, Object> orgAttrMap = getDataModelMap(orgDM, extendsKeys);
		if (orgAttrMap == null) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P020E.toString(), new Object[] { keys,
							extendsKeys }));
		}
		Map<String, Object> map = getDataModelMap(dataModelMap, keys);

		for (Entry<String, Object> entry : orgAttrMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			// 継承先のattrエレメントの子エレメントのMAP取得
			Object attrNameChildMap = map.get(key);

			// 継承先に継承元の値が設定されてない場合、key初期値と継承元の値を設定
			if (attrNameChildMap == null) {

				// attrエレメントの子エレメント有無をチェック
				if (attrNameChild == null) {
					// 継承元のkey、ValueをPut
					map.put(key, value);
				} else {
					// 子エレメントの空MAP取得（attname以下に追加するので常にTreeMap）
					Map<String, Object> extendsMap = new TreeMap<String, Object>();

					// key初期値と継承元のValueをPut
					extendsMap.put(pdsObject, value);
					// 継承先のMapにPut
					map.put(key, extendsMap);
				}
			} else if (attrNameChild != null
					&& attrNameChildMap instanceof Map<?, ?>) {
				// attrエレメントの子エレメント有かつ、子エレメントの型がMap
				@SuppressWarnings( { "unchecked" })
				Map<String, Object> childMap = (Map<String, Object>) attrNameChildMap;

				// 継承先に継承元の値が設定されている場合
				// 子エレメントのMAPにkey初期値が設定されてない場合
				// 子エレメントのMAPにkey初期値と継承元の値を設定
				if (childMap.get(pdsObject) == null) {
					childMap.put(pdsObject, value);
					// 継承先のMapにPut
					map.put(key, childMap);
				}
			}
		}
		objValue = map;

		if (!extendsKeys.isEmpty()) {
			extendsKeys.remove(extendsKeys.size() - 1);
		}
	}
}
