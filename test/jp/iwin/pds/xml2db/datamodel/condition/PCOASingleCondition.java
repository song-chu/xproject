package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

/**
 * 関係演算式クラス。
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
 * @see jp.iwin.pds.datamodel.condition.PCOACondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOASingleCondition extends PCOACondition {

	/**
	 * オペランドリスト
	 */
	protected List<PCOAOperand> items;

	/**
	 * コンストラクタ。
	 * @param items  オペランドリスト
	 */
	public PCOASingleCondition(List<PCOAOperand> items) {
		this.items = items;
	}

	/**
	 * 引数項目の定数部又は変数部の値を返す。
	 * @param operand オペランド
	 * @param argItems 引数項目のMap型オブジェクト
	 * @return result 引数項目の定数部又は変数部の値
	 */
	protected Object assign(PCOAOperand operand, Map<String, Object> argItems) {

		Object result;

		if (operand instanceof PCOOperandVar) {
			PCOOperandVar itemVar = (PCOOperandVar) operand;
			result = (argItems.get(itemVar.getName()));
		} else {
			result = ((PCOOperandConst) operand).getValue();
		}

		return result;
	}

}
