package jp.escofi.emr.transformer.constant;

/**
 * メッセージの置換文字列定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>運用ツールにて利用するメッセージの置換文字列部分を定義するenumクラス。
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
public enum MessageType {

	/**
	 * JDBC接続情報
	 */
	JDBC_INFO("JDBC接続情報"),
	/**
	 * 案件コード
	 */
	PRODUCT_CD("案件コード"),
	/**
	 * XMLファイル出力先
	 */
	XML_OUTPUT_PATH("XMLファイル出力先"),
	;

	/**
	 * 対応させる文字列
	 */
	private String value;


	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>コンストラクタクラス。
	 * </DL>
	 * @param value 対応させる置換文字列
	 */
	private MessageType(String value) {
		this.value = value;
	}


	/**
	 * エレメント名取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>対応する置換文字列を返す。
	 * </DL>
	 * @return 置換文字列
	 */
	@Override
	public String toString() {
		return value.intern();
	}

}
