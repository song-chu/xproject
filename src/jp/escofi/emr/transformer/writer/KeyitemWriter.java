package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;


/**
 * キー項目ライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>キー項目({@code <keyitem>})以下の要素を出力するXMLライター。
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
public final class KeyitemWriter extends AbstractXmlWriter {

	/**
	 * キー項目名（英語）
	 */
	private String name;
	/**
	 * キー項目値
	 */
	private String key;
	/**
	 * キー項目名（日本語）
	 */
	private String jpName;
	/**
	 * 継承元キー項目値
	 */
	private String org;
	/**
	 * データモデル出力フラグ
	 */
	private boolean isDataModelWrite = false;
	/**
	 * 属性グループID
	 */
	private int attGroupID = 0;
	/**
	 * キー項目インデックス
	 */
	private int index = 0;


	/**
	 * コンストラクタでXMLタグ名を初期化する。
	 */
	public KeyitemWriter() {
		super(ElementType.KEY_ITEM);
	}


	/**
	 * @param name キー項目名（英字）
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param key キー項目値
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @param jpName キー項目名（日本語）
	 */
	public void setJpName(String jpName) {
		this.jpName = jpName;
	}
	/**
	 * @param org 継承元キー項目値
	 */
	public void setOrg(String org) {
		this.org = org;
	}
	/**
	 * @param attGroupID 属性グループID
	 */
	public void setAttGroupID(int attGroupID) {
		this.attGroupID = attGroupID;
	}
	/**
	 * @param index キー項目インデックス
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * キー項目ライター一致判定。
	 * <P>
	 * 引数：オブジェクトのクラス型が一致した場合、引数：オブジェクトの以下の値が、
	 *このキー項目ライターの値と全て一致した場合は、同一のキー項目ライターと判定する。
	 * </P>
	 * <UL>
	 *  <LI>キー項目名（英字）</LI>
	 *  <LI>キー項目値</LI>
	 * </UL>
	 * @param obj オブジェクト
	 * @return 一致判定結果
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;

		if (obj instanceof KeyitemWriter) {
			KeyitemWriter writer = (KeyitemWriter) obj;

			ret = (name.equals(writer.name) &&
					key.equals(writer.key));
		}
		return ret;
	}

	/**
	 * ハッシュコード値。
	 * <P>
	 * このインスタンスのハッシュコード値は以下のクラス変数のハッシュコード値の合計とする。
	 * </P>
	 * <UL>
	 *  <LI>キー項目名（英字）</LI>
	 *  <LI>キー項目値</LI>
	 * </UL>
	 * @return ハッシュコード値
	 */
	@Override
	public int hashCode() {
		int name = 0;
		int key = 0;

		if (this.name != null) {
			name = this.name.hashCode();
		}

		if (this.key != null) {
			key = this.key.hashCode();
		}
		return name + key;
	}


	/**
	 * @return キー項目名（英字）
	 */
	String getName() {
		return name;
	}
	/**
	 * @return 属性グループID
	 */
	int getAttGroupID() {
		return attGroupID;
	}
	/**
	 * @return キー項目インデックス
	 */
	int getIndex() {
		return index;
	}

	/**
	 * データモデル出力フラグ設定
	 *
	 * @param isDataModelWrite データモデル出力フラグ true:データモデルの内容、false:XML管理ファイルの内容
	 */
	void setDataModelWrite(boolean isDataModelWrite) {
		this.isDataModelWrite = isDataModelWrite;
	}

	/**
	 * XML管理ファイル出力処理。
	 * <UL>
	 *  <LI>クラス変数：データモデル出力フラグがtrueの場合は、
	 *データモデルファイル出力処理を呼出す。</LI>
	 *  <LI>上記以外の場合は、以下の処理を実施する。
	 *   <OL>
	 *    <LI>タグ開始部分出力処理</LI>
	 *    <LI>タグ内容部分出力処理(クラス変数：キー項目名（英語）を出力)</LI>
	 *    <LI>タグ終了部分出力処理</LI>
	 *   </OL>
	 * </UL>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	@Override
	void write(XMLWriter writer) throws SAXException {

		if (isDataModelWrite) {
			writeDataModel(writer);
		} else {
			// タグ開始部分出力処理
			startElement(writer);

			// タグ内容部分出力処理
			writer.characters(name);

			// タグ終了部分出力処理
			endElement(writer);
		}
	}


	/**
	 * データモデルファイル出力処理。
	 * <OL>
	 * <LI>アトリビュート編集処理</LI>
	 * <LI>タグ開始部分出力処理</LI>
	 * <LI>タグ内容部分出力処理</LI>
	 * <LI>タグ終了部分出力処理</LI>
	 * <LI>子タグ情報クリア処理</LI>
	 * </OL>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	private void writeDataModel(XMLWriter writer) throws SAXException {

		// アトリビュート編集
		addAttribute(AttributeType.NAME, name);
		addAttribute(AttributeType.KEY, key);

		if (jpName != null && 0 < jpName.length()) {
			addAttribute(AttributeType.JP_NAME, jpName);
		}

		if (org != null && 0 < org.length()) {
			addAttribute(AttributeType.ORG, org);
		}

		// タグ開始処理
		startElement(writer);

		// タグ内容処理
		for (AbstractXmlWriter child : childSet) {
			child.write(writer);
		}

		// タグ終了処理
		endElement(writer);

		// 子タグ情報クリア処理
		childSet = null;
	}

}
