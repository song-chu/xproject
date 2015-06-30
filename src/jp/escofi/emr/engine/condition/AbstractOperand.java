package jp.escofi.emr.engine.condition;

/**
 * オペランドクラス。
 * <BR>演算式が関係演算式の場合、演算子による判定対象になる部分を"オペランド"とする。
 * <BR>オペランドには変数と定数がある。
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
public abstract class AbstractOperand {

	/**
	 * オペランドの値
	 */
	protected Object value;

	/**
	 * オペランドの値のゲッターメソッド
	 * @return オペランドの値
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * オペランドの値のセッターメソッド
	 * @param value オペランドの値
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
