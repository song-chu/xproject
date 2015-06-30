package jp.iwin.pds.xml2db.common.constant;

/**
 * メッセージ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>PDSエンジンにて利用するメッセージの置換文字列部分を定義するenumクラス。
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
public enum PCTMessageType {

	/**
	 * XML管理
	 */
	XMLMETA("XML管理"),
	/**
	 * データモデル
	 */
	DATAMODEL("データモデル"),
	/**
	 * 検索キー
	 */
	KEYLIST("検索キー"),
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
	private PCTMessageType(String value) {
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
		return this.value.intern();
	}

}
