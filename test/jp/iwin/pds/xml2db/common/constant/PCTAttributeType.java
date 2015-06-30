package jp.iwin.pds.xml2db.common.constant;


/**
 * アトリビュートタイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>アトリビュートのタイプ定義enumクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1037 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:21:17 +0900 (轣ｫ, 07 12 2010) $
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
 * @author $Author: seo.yi $
 */
public enum PCTAttributeType {

	/**
	 * 名前（英字）
	 */
	NAME("name"),
	/**
	 * 名前（日本語）
	 */
	JPNAME("jpname"),
	/**
	 * キー項目
	 */
	KEY("key"),
	/**
	 * シーケンス番号
	 */
	SEQ("seq"),
	/**
	 * ファイル名
	 */
	FILE("file"),
	/**
	 * 拡張
	 */
	EXTENDSDM("extendsdm"),
	/**
	 * マップ種別
	 */
	MAPTYPE("maptype"),
	/**
	 * 初期値
	 */
	INITVALUE("initvalue"),
	/**
	 * 継承元フラグ
	 */
	PARENTFLG("parentflg"),
	/**
	 * 条件式フラグ
	 */
	CONDFLG("condflg"),
	/**
	 * データ型
	 */
	DATATYPE("datatype"),
	/**
	 * 削除フラグ
	 */
	DELFLG("delflg"),
	/**
	 * 継承元情報
	 */
	ORG("org"),
	/**
	 * 内部Javaデータ型
	 */
	JAVADATATYPE("javadatatype"),
	/**
	 * クラス名
	 */
	CLASSNAME("classname"),
	/**
	 * クラス情報
	 */
	SUBINFO("subinfo"),
	/**
	 * 含むフラグ
	 */
	EQ("eq"),
	/**
	 * 引数項目取得情報
	 */
	VARINFO("varinfo"),
	/**
	 * 上限値含む
	 */
	UPPEREQ("uppereq"),
	/**
	 * 下限値含む
	 */
	LOWEREQ("lowereq"),
	/**
	 * メタ情報
	 */
	METAINFO("metainfo"),
	/**
	 * 属性値名
	 */
	ATTRNAME("attrname"),
	/**
	 * 継承元データモデル名
	 */
	ATTRNAME_PARENT("attrnameParent"),
	/**
	 * 継承先データモデル名
	 */
	ATTRNAME_CHILD("attrnameChild"),
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
	private PCTAttributeType(String value) {
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
		return this.value.intern();
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
	public boolean equals(String value) {
		return this.value.equals(value);
	}

}
