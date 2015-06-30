package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;

import org.xml.sax.Attributes;


/**
 * 継承先キー項目ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値（{@code <value>}）要素が現すまで、属性keyを持つ要素を制御するSAXのイベントハンドラー。<BR>
 *       データモデルのインスタンスを生成する際に、継承元データモデルが有る場合は、このクラスを使用する。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1059 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHKeyItemHandlerExt extends PCHKeyItemHandler {

	/**
	 * version/pattern/dateの初期値
	 */
	private String initValue;
	/**
	 * attrnameタグの親タグ名
	 */
	private String attrnameParent;
	/**
	 * attrnameタグの子タグ名
	 */
	private String attrnameChild;
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
	 * @param dataModelHandler 呼出し元ハンドラー
	 * @param orgDM 継承元のデータモデルマップ
	 * @param extendsInfo 継承情報
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
	 */
	public PCHKeyItemHandlerExt(PCHDataModelHandler dataModelHandler,
			Map<String, Object> orgDM, Map<PCTAttributeType, String> extendsInfo) {

		super(dataModelHandler,extendsInfo,0);

		this.orgDM = orgDM;
		this.attrnameParent = extendsInfo.get(PCTAttributeType.ATTRNAME_PARENT);
		this.attrnameChild = extendsInfo.get(PCTAttributeType.ATTRNAME_CHILD);
		this.initValue = extendsInfo.get(PCTAttributeType.INITVALUE);
	}


	/**
	 * タグ開始処理。
	 * <OL>
	 *  <LI>アトリビュート情報に継承元情報がある場合、継承元情報を継承元キー項目リストに追加する。</LI>
	 *  <LI>継承元クラスのタグ開始処理を呼出す。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(
			String uri, String localName, String qName, Attributes atts) {
		String org = atts.getValue(PCTAttributeType.ORG.toString());

		if (org != null) {
			this.extendsKeys.add(org);
		}
		super.startElement(uri, localName, qName, atts);
	}


	/**
	 * 継承関係解決。
	 * <P>継承元クラス変数：キー項目名リストの最後の項目が、
	 *クラス変数：attrnameタグの親タグ名と一致する場合は、継承関係解決処理を実行する。
	 * </P>
	 * @param keyName 参照中のキー項目名
	 * @see PCHKeyItemHandler
	 */
	@Override
	protected void initDataModelMap(String keyName) {

		// 継承元クラスでない場合は処理を抜ける。
		if (!this.attrnameParent.equals(keyName)) {
			return;
		}
		// 継承元のMAP取得
		Map<String, Object> orgAttrMap = getDataModelMap(this.orgDM, this.extendsKeys);
		Map<String, Object> map = getDataModelMap(this.dataModelMap, this.keys);

		for (Entry<String, Object> entry : orgAttrMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			// 継承先のattrエレメントの子エレメントのMAP取得
			Object attrnameChildMap = map.get(key);

			// 継承先に継承元の値が設定されてない場合、key初期値と継承元の値を設定
			if (attrnameChildMap == null) {

				// attrエレメントの子エレメント有無をチェック
				if (this.attrnameChild == null) {
					// 継承元のkey、ValueをPut
					map.put(key, value);
				} else {
					// 子エレメントの空MAP取得（attname以下に追加するので常にTreeMap）
					Map<String, Object> extendsMap = new TreeMap<String, Object>();

					// key初期値と継承元のValueをPut
					extendsMap.put(this.initValue, value);
					//継承先のMapにPut
					map.put(key, extendsMap);
				}
			} else if (this.attrnameChild != null
					&& attrnameChildMap instanceof Map<?, ?>) {
				// attrエレメントの子エレメント有かつ、子エレメントの型がMap
				@SuppressWarnings({"unchecked"})
				Map<String, Object> childMap = (Map<String, Object>) attrnameChildMap;

				// 継承先に継承元の値が設定されている場合
				//子エレメントのMAPにkey初期値が設定されてない場合
				//子エレメントのMAPにkey初期値と継承元の値を設定
				if (childMap.get(this.initValue) == null) {
					childMap.put(this.initValue, value);
					//継承先のMapにPut
					map.put(key, childMap);
				}
			}
		}
		this.value = map;

		if (!this.extendsKeys.isEmpty()) {
			this.extendsKeys.remove(this.extendsKeys.size() - 1);
		}
	}

}
