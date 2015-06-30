package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;


/**
 * データモデルハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデル（{@code <datamodel>}）要素を制御するSAXのイベントハンドラー。
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
public final class DataModelHandler extends AbstractINIHandler {

	/**
	 * キー項目リスト
	 */
	private List<String> keys = new ArrayList<String>();
	/**
	 * データモデルマップ
	 */
	private Map<String, Object> dataModelMap = new HashMap<String, Object>();
	/**
	 * データモデル名
	 */
	private String dataModelName;
	/**
	 * キー項目ハンドラー
	 */
	private KeyItemHandler keyItemHandler;


	/**
	 * コンストラクタ。
	 *
	 * @param reader XMLリーダー
	 * @param dataModelName データモデル名
	 */
	public DataModelHandler(XMLReader reader, String dataModelName) {
		this.reader = reader;
		this.dataModelName = dataModelName.intern();
		globalConditionItemMap = new HashMap<String, ConditionItemInfo>();
	}


	/**
	 * @param keyItemHandler キー項目ハンドラー
	 */
	public void setKeyItemHandler(KeyItemHandler keyItemHandler) {
		this.keyItemHandler = keyItemHandler;
	}

	/**
	 * @return データモデル名
	 */
	public String getDataModelName() {
		return dataModelName;
	}

	/**
	 * @return データモデルマップ
	 */
	public Map<String, Object> getDataModelMap() {
		return dataModelMap;
	}

	/**
	 * タグ開始処理。
	 * <OL>
	 *  <LI>クラス変数：キー項目リストに、クラス変数：データモデル名を格納する。</LI>
	 *  <LI>クラス変数：データモデルマップに、データモデル型のマップインスタンスを格納する。</LI>
	 *  <LI>対象タグがデータモデルの場合は、継承元クラス変数：XMLリーダーのハンドラーに、
	 *クラス変数：キー項目ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		keys.add(dataModelName);
		dataModelMap.put(dataModelName, new HashMap<String, Object>());

		if (ElementType.DATA_MODEL.toString().equals(qName)) {
			reader.setContentHandler(keyItemHandler);
		}
	}


	/**
	 * @return キー項目リスト
	 */
	List<String> getKeys() {
		return keys;
	}

}
