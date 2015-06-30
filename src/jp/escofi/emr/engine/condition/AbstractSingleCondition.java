package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * 関係演算式クラス。
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
public abstract class AbstractSingleCondition extends AbstractCondition {

	/**
	 * オペランドリスト
	 */
	protected List<AbstractOperand> items;

	/**
	 * コンストラクタ。
	 * @param items  オペランドリスト
	 */
	public AbstractSingleCondition(List<AbstractOperand> items) {
		this.items = items;
	}

	/**
	 * 引数項目の定数部又は変数部の値を返す。
	 * @param operand オペランド
	 * @param argItems 引数項目のMap型オブジェクト
	 * @return result 引数項目の定数部又は変数部の値
	 */
	protected Object assign(AbstractOperand operand, Map<String, Object> argItems) {

		Object result;

		if (operand instanceof OperandVar) {
			OperandVar itemVar = (OperandVar) operand;
			result = (argItems.get(itemVar.getName()));
		} else {
			result = ((OperandConst) operand).getValue();
		}

		return result;
	}

}
