package jp.iwin.pds.xml2db.datamodel.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 条件判定 BigDecimal型NOTSUBSET演算。
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
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTSUBSET
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperNOTSUBSETBigDecimal extends PCOARelOperNOTSUBSET {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public PCORelOperNOTSUBSETBigDecimal(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランド（BigDecimalのSET）のNOTSUBSET演算を行う。集合左オペランドが集合右オペランドの部分集合ではない場合TRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean judge(Map<String, Object> argItems) {

		Set<BigDecimal> source = (Set<BigDecimal>) assign(this.items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(this.items.get(1), argItems);

		boolean bool = false;

		for (BigDecimal elemSource : source) {
			bool = false;
			for (BigDecimal elemTarget : target) {
				if (elemSource.compareTo(elemTarget) == 0) {
					bool = true;
					break;
				}
			}

			if (bool == false) {
				return true;
			}
		}
		return false;
	}
}
