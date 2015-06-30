package jp.iwin.pds.xml2db.dumptool;

import java.util.Comparator;
import java.util.Map;

/**
 * マップコンパレータクラス。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>マップをキー順序でソートするためにキーを比較するクラス。
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
public class PDMMapComparator implements Comparator<Object> {

	/**
	 * キー値比較。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>二つのエントリのキー値を比較する。
	 * </DL>
	 * @param obj1 エントリ1
	 * @param obj2 エントリ2
	 * @return 比較結果
	 */
	@SuppressWarnings("unchecked")
	public int compare(Object obj1, Object obj2) {
		Map.Entry<String, Object> ent1 = (Map.Entry<String, Object>) obj1;
		Map.Entry<String, Object> ent2 = (Map.Entry<String, Object>) obj2;
		String val1 = (String) ent1.getKey();
		String val2 = (String) ent2.getKey();
		return val1.compareTo(val2);
	}

}
