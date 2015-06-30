package jp.escofi.emr.engine.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * 条件判定 BigDecimal型GT演算。
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
public final class RelOperGTBigDecimal extends AbstractRelOperGT {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public RelOperGTBigDecimal(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランド（BigDecimal）のGT演算を行う。BigDecimal.compareTo()を利用する。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		BigDecimal source = (BigDecimal) assign(items.get(0), argItems);
		BigDecimal target = (BigDecimal) assign(items.get(1), argItems);

		if (source.compareTo(target) > 0) {
			return true;
		}
		return false;
	}
}
