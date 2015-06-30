package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 条件判定 Object型NOTINTERSECT演算。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1120 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 17:38:14 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTINTERSECT
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperNOTINTERSECTObject extends PCOARelOperNOTINTERSECT {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public PCORelOperNOTINTERSECTObject(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランド（ObjectのSET）のNOTINTERSECT演算を行う。共通要素が１個も存在しない場合、TRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean judge(Map<String, Object> argItems) {

		Set<Object> source = (Set<Object>) assign(this.items.get(0), argItems);
		Set<Object> target = (Set<Object>) assign(this.items.get(1), argItems);

		for (Object elemTarget : target) {
			if (source.contains(elemTarget)) {
				return false;
			}
		}
		return true;
	}

}
