package jp.escofi.emr.engine.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 条件判定 BigDecimal型INTERSECT演算。
 * <DL>
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
public final class RelOperINTERSECTBigDecimal extends AbstractRelOperINTERSECT {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public RelOperINTERSECTBigDecimal(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランド（SET）のINTERSECT演算を行う。共通要素が一つ以上存在する場合TRUEを返す。<br>
	 * BigDecimal.compareTo()を利用する。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isJudge(Map<String, Object> argItems) {
		Set<BigDecimal> source = (Set<BigDecimal>) assign(items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(items.get(1), argItems);

		for (BigDecimal elemTarget : source) {
			for (BigDecimal elemSource : target) {
				if (elemSource.compareTo(elemTarget) == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
