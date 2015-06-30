package jp.iwin.pds.xml2db.dumptool;

import java.util.Comparator;

/**
 * セッコンパレータクラス。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>セットの要素をソートするために要素を比較するクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1129 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-08 10:49:00 +0900 (豌ｴ, 08 12 2010) $
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
 * @author $Author: park.js $
 */
public class PDMSetComparator implements Comparator<Object> {

	/**
	 * 要素比較。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>二つの要素を比較する。
	 * </DL>
	 * @param obj1 要素1
	 * @param obj2 要素2
	 * @return 比較結果
	 */
	public int compare(Object obj1, Object obj2) {
		String val1 = obj1.toString();
		String val2 = obj2.toString();
		return val1.compareTo(val2);
	}

}
