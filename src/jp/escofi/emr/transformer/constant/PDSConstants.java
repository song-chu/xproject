package jp.escofi.emr.transformer.constant;


/**
 * 運用ツール内共通定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>共通定義クラス。
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
public enum PDSConstants {

	/**
	 * フラグ値：true
	 */
	TRUE("1"),
	/**
	 * データ種別：CDATA
	 */
	CDATA("CDATA"),
	/**
	 * MyBATIS設定ファイル
	 */
	CONF_MY_BATIS("configuration.xml"),
	/**
	 * JDBCドライバ
	 */
	JDBC_DRIVER("jdbc.driver"),
	/**
	 * JDBC URL
	 */
	JDBC_URL("jdbc.url"),
	/**
	 * JDBC ユーザ名
	 */
	JDBC_USER_NAME("jdbc.username"),
	/**
	 * JDBC パスワード
	 */
	JDBC_PASSWORD("jdbc.password"),
	/**
	 * XML管理ファイル名
	 */
	FILE_META("XML_Meta.xml"),
	/**
	 * XMLファイル拡張子
	 */
	FILE_XML(".xml"),
	/**
	 * 内部文字コード
	 */
	CHARSET(System.getProperty("file.encoding", "Cp943C")),
	/**
	 * 空文字列
	 */
	EMPTY(""),
	;


	/**
	 * 対応させる定義値
	 */
	private String value;


	/**
	 * コンストラクタ
	 * @param value	定数値
	 */
	private PDSConstants(String value) {
		this.value = value;
	}


	/**
	 * 定義値一致判定。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>この定義値と比較文字列が一致するかを判定する。
	 * </DL>
	 * @param value 比較文字列
	 * @return 比較結果<BR>
	 *このタイプの文字列表現と比較文字列が一致していれば、true
	 */
	public boolean isEquals(String value) {
		return value.equals(value);
	}

	/**
	 * 定義値取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>定義値の文字列表現を返す。
	 * </DL>
	 * @return 定義値
	 */
	@Override
	public String toString() {
		return value.intern();
	}

}
