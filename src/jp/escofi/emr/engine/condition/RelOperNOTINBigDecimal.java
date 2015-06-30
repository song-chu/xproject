package jp.escofi.emr.engine.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 条件判定 BigDecimal型NOTIN演算。
 * <DL>
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/08//01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public final class RelOperNOTINBigDecimal extends AbstractRelOperNOTIN {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public RelOperNOTINBigDecimal(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランド（BigDecimal）のNOTIN演算を行う。左オペランドが集合右オペランドに１個も存在しない場合、TRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isJudge(Map<String, Object> argItems) {
		BigDecimal source = (BigDecimal) assign(items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(items.get(1), argItems);
		for (BigDecimal elem : target) {
			if (source.compareTo(elem) == 0) {
				return false;
			}
		}
		return true;
	}
}
