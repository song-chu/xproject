package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * 条件判定 Double型EXCLUDE演算。
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
public final class RelOperEXCLUDEDouble extends AbstractRelOperEXCLUDE {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public RelOperEXCLUDEDouble(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 左中右オペランド(Double)のEXCLUDE演算を行う。Double.compareTo()を利用する。<br>
	 * 中オペランドが左右オペランドの範囲外の場合、TRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		Double sourceS = (Double) assign(items.get(0), argItems);
		Double target = (Double) assign(items.get(1), argItems);
		Double sourceL = (Double) assign(items.get(2), argItems);

		if (lowerEq == true && upperEq == true) {
			if (sourceS.compareTo(target) > 0 || sourceL.compareTo(target) < 0) {
				return true;
			}
		} else if (lowerEq == true && upperEq == false) {
			if (sourceS.compareTo(target) > 0 || sourceL.compareTo(target) <= 0) {
				return true;
			}
		} else if (lowerEq == false && upperEq == true) {
			if (sourceS.compareTo(target) >= 0 || sourceL.compareTo(target) < 0) {
				return true;
			}
		} else if (lowerEq == false && upperEq == false) {
			if (sourceS.compareTo(target) >= 0 || sourceL.compareTo(target) <= 0) {
				return true;
			}
		}
		return false;
	}
}
