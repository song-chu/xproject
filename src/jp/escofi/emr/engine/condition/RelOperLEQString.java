package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * 条件判定 String型LEQ演算。
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
public final class RelOperLEQString extends AbstractRelOperLEQ {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public RelOperLEQString(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランドのLEQ演算を行う。String.compareTo()を利用する。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		String source = (String) assign(items.get(0), argItems);
		String target = (String) assign(items.get(1), argItems);

		if (source.compareTo(target) <= 0) {
			return true;
		}

		return false;
	}
}
