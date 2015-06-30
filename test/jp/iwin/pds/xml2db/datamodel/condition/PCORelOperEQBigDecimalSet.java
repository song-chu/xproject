package jp.iwin.pds.xml2db.datamodel.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 条件判定 BigDecimal集合型EQ演算。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1146 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-08 15:38:57 +0900 (豌ｴ, 08 12 2010) $
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
public final class PCORelOperEQBigDecimalSet extends PCOARelOperEQ {

	/**
	 * 親クラスのコンストラクタを呼び出し、引数を渡す。
	 * @param items 本演算子のオペランドList
	 */
	public PCORelOperEQBigDecimalSet(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランドのEQ演算を行う。BigDecimal.compareTo()を利用する。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean judge(Map<String, Object> argItems) {

		Set<BigDecimal> source = (Set<BigDecimal>) assign(this.items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(this.items.get(1), argItems);

		boolean bool = false;
		if(source.size()!=target.size()){
			return false;
		}
		for (BigDecimal elemSource : source) {
			bool = false;
			for (BigDecimal elemTarget : target) {
				if (elemSource.compareTo(elemTarget) == 0) {
					bool = true;
					break;
				}
			}

			if (bool == false) {
				return false;
			}
		}
		return true;
	}
}
