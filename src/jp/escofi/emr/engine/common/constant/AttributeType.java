package jp.escofi.emr.engine.common.constant;


/**
 * アトリビュートタイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>アトリビュートのタイプ定義enumクラス。
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/0801 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public enum AttributeType {

	/**
	 * 名前（英字）
	 */
	NAME("name"),
	/**
	 * 名前（日本語）
	 */
	JP_NAME("jpname"),
	/**
	 * キー項目
	 */
	KEY("key"),
	/**
	 * ファイル名
	 */
	FILE("file"),
	/**
	 * 拡張
	 */
	EXTENDS_DM("extendsdm"),
	/**
	 * 初期値
	 */
	INIT_VALUE("initvalue"),
	/**
	 * 継承元フラグ
	 */
	PARENT_FLG("parentflg"),
	/**
	 * 条件式フラグ
	 */
	COND_FLG("condflg"),
	/**
	 * データ型
	 */
	DATA_TYPE("datatype"),
	/**
	 * 削除フラグ
	 */
	DEL_FLG("delflg"),
	/**
	 * 継承元情報
	 */
	ORG("org"),
	/**
	 * 内部Javaデータ型
	 */
	JAVA_DATA_TYPE("javadatatype"),
	/**
	 * クラス名
	 */
	CLASS_NAME("classname"),
	/**
	 * クラス情報
	 */
	SUB_INFO("subinfo"),
	/**
	 * 含むフラグ
	 */
	EQ("eq"),
	/**
	 * 引数項目取得情報
	 */
	VAR_INFO("varinfo"),
	/**
	 * 上限値含む
	 */
	UPPER_EQ("uppereq"),
	/**
	 * 下限値含む
	 */
	LOWER_EQ("lowereq"),
	/**
	 * メタ情報
	 */
	META_INFO("metainfo"),
	/**
	 * 属性値名
	 */
	ATTR_NAME("attrname"),
	/**
	 * 継承元データモデル名
	 */
	ATTR_NAME_PARENT("attrnameParent"),
	/**
	 * 継承先データモデル名
	 */
	ATTR_NAME_CHILD("attrnameChild"),
	/**
	 * メモリー上のアドレス
	 */
	REF("ref"),
	;

	/**
	 * 対応させるアトリビュート名
	 */
	private String value;

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>コンストラクタクラス。
	 * </DL>
	 * @param value 対応させるアトリビュート名
	 */
	private AttributeType(String value) {
		this.value = value;
	}

	/**
	 * アトリビュート名取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字列表現を対応するアトリビュート名を返す。
	 * </DL>
	 * @return アトリビュート名
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * 文字列一致判定。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>このタイプの文字列表現と比較文字列が一致するかを判定する。
	 * </DL>
	 * @param value 比較文字列
	 * @return 比較結果<BR>
	 *このタイプの文字列表現と比較文字列が一致していれば、true
	 */
	public boolean isEquals(String value) {
		return value.equals(value);
	}

}
