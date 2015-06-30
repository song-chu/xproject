package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * 条件判定 Object型NOTEQ演算。
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
public final class RelOperNOTEQObject extends AbstractRelOperNOTEQ {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public RelOperNOTEQObject(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランドのNOTEQ演算を行う。Object.equals()を利用する。
	 * BigDecimalのNOTEQ演算はRelOperNOTEQBigDecimalを利用すること。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		Object source = assign(items.get(0), argItems);
		Object target = assign(items.get(1), argItems);

		return (!source.equals(target));
	}
}
