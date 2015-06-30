package jp.escofi.emr.engine.common.constant;

/**
 * メッセージ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>PDSエンジンにて利用するメッセージの置換文字列部分を定義するenumクラス。
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
	 * XML管理
	 */
	XML_META("XML管理"),
	/**
	 * データモデル
	 */
	DATA_MODEL("データモデルＸＭＬファイル"),
	/**
	 * 検索キー
	 */
	KEY_LIST("検索キー"),
	/**
	 * PDS応答クラス
	 */
	RESPONSE("PDS応答クラス"),
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
		return value;
	}

}
