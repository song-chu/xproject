package jp.iwin.pds.xml2db.datamodel.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 条件判定 BigDecimal型EQ演算。
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
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperEQ
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperEQBigDecimal extends PCOARelOperEQ {

	/**
	 * 親クラスのコンストラクタを呼び出し、引数を渡す。
	 * @param items 本演算子のオペランドList
	 */
	public PCORelOperEQBigDecimal(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランドのEQ演算を行う。BigDecimal.compareTo()を利用する。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		BigDecimal source = (BigDecimal) assign(this.items.get(0), argItems);
		BigDecimal target = (BigDecimal) assign(this.items.get(1), argItems);

		if (source.compareTo(target) == 0) {
			return true;
		}
		return false;
	}
}
