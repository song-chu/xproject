package jp.escofi.emr.engine.condition;

import java.util.List;

/**
 * 論理演算式。論理演算式にはANDとORがある。
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
public abstract class AbstractCompositeCondition extends AbstractCondition {

	/**
	 * 本論理演算式を構成する演算式のList
	 */
	protected List<AbstractCondition> conditions;

	/**
	 * 演算式リストを設定する。
	 * @param conditions 本論理演算式を構成する演算式のList
	 */
	public AbstractCompositeCondition(List<AbstractCondition> conditions) {
		this.conditions = conditions;
	}

}
