package jp.iwin.pds.xml2db.common.constant;

/**
 * 検索結果ステータス定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>検索結果ステータスを定義するenumクラス。
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
public enum PCTStatus {
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
