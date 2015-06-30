package jp.escofi.emr.engine.condition;

import java.util.Map;

import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.search.ResultObject;

/**
 * 条件判定 条件文インタフェース。
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
public interface Rule {
	/**
	 * 条件判定の実行。
	 * @param argItems 引数項目のMap型オブジェクト
	 * @return 属性値オブジェクト
	 * @throws ConditionNotMatchedException 条件不成立例外
	 */
	public ResultObject apply(Map<String, Object> argItems) throws ConditionNotMatchedException;
}
