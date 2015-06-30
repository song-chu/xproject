package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;

/**
 * 論理演算式。論理演算式にはANDとORがある。
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
public abstract class PCOACompositeCondition extends PCOACondition {

	/**
	 * 本論理演算式を構成する演算式のList
	 */
	protected List<PCOACondition> conditions;

	/**
	 * 演算式リストを設定する。
	 * @param conditions 本論理演算式を構成する演算式のList
	 */
	public PCOACompositeCondition(List<PCOACondition> conditions) {
		this.conditions = conditions;
	}

}
