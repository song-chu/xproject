package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;


/**
 * データモデルハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデル（{@code <datamodel>}）要素を制御するSAXのイベントハンドラー。
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
 * @see PCHKeyItemHandler
 * @see PCHKeyItemHandlerExt
 * @see jp.iwin.pds.initialload.PILInitialLoader
 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHDataModelHandler extends PCHAINIHandler {

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
	private PCHKeyItemHandler keyItemHandler;


	/**
	 * コンストラクタ。
	 *
	 * @param reader XMLリーダー
	 * @param dataModelName データモデル名
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
	 */
	public PCHDataModelHandler(XMLReader reader, String dataModelName) {
		this.reader = reader;
		this.dataModelName = dataModelName.intern();
		this.globalConditionItemMap = new HashMap<String, PROConditionItemInfo>();
	}


	/**
	 * @param keyItemHandler キー項目ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
	 */
	public void setKeyItemHandler(PCHKeyItemHandler keyItemHandler) {
		this.keyItemHandler = keyItemHandler;
	}

	/**
	 * @return データモデル名
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 */
	public String getDataModelName() {
		return dataModelName;
	}

	/**
	 * @return データモデルマップ
	 * @see PCHKeyItemHandler
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 */
	public Map<String, Object> getDataModelMap() {
		return this.dataModelMap;
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

		this.keys.add(this.dataModelName);
		this.dataModelMap.put(this.dataModelName, new HashMap<String, Object>());

		if (PCTElementType.DATAMODEL.equals(qName)) {
			this.reader.setContentHandler(this.keyItemHandler);
		}
	}


	/**
	 * @return キー項目リスト
	 * @see PCHKeyItemHandler
	 */
	List<String> getKeys() {
		return this.keys;
	}

}
