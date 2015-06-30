package jp.escofi.emr.engine.common.constant;

/**
 * 検索結果ステータス定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>検索結果ステータスを定義するenumクラス。
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
public enum Status {
	/**
	 * ステータス：正常
	 */
	NORMAL,
	/**
	 * ステータス：該当属性なし
	 */
	ATTR_NOT_FOUND,
	/**
	 * ステータス：TreeMapキー該当なし
	 */
	TREEMAP_KEY_NOT_FOUND,
	/**
	 * ステータス：削除済
	 */
	DELETED,
}
