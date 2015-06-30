package jp.escofi.emr.engine.condition;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ConditionType;


/**
 * 論理演算式（AND/OR）の生成を担当するFacrotyクラス
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
public final class CompositeConditionFactory {

	/**
	 * 論理演算式を生成、返却する。
	 *
	 * @param conditions 演算式のリスト
	 * @param conditionType 演算子種類
	 * @return 論理演算式
	 */
	public static AbstractCompositeCondition createCompositeCondition(List<AbstractCondition> conditions,
			ConditionType conditionType) {

		if (conditionType == ConditionType.CONDITION_AND) {
			return new LogicOperAND(conditions);
		} else {
			return new LogicOperOR(conditions);
		}
	}
}
