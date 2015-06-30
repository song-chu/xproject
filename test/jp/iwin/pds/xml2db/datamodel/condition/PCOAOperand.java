package jp.iwin.pds.xml2db.datamodel.condition;

/**
 * オペランドクラス。
 * <BR>演算式が関係演算式の場合、演算子による判定対象になる部分を"オペランド"とする。
 * <BR>オペランドには変数と定数がある。
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
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOAOperand {

	/**
	 * オペランドの値
	 */
	protected Object value;

	/**
	 * オペランドの値のゲッターメソッド
	 * @return オペランドの値
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * オペランドの値のセッターメソッド
	 * @param value オペランドの値
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
