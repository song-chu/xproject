package jp.escofi.emr.engine.loader;

import java.util.Map;

import jp.escofi.emr.engine.search.ConditionItemInfo;


/**
 * ルールハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ルールハンドラー郡の共通処理を記載するSAXイベントハンドラーの親クラス。（抽象クラス）
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
public abstract class AbstractRuleHandler extends AbstractDelegateHandler {

	/**
	 * 引数項目マップ
	 */
	protected Map<String, ConditionItemInfo> conditionItemMap;


	/**
	 * コンストラクタ。
	 * <P>
	 * 呼出し元ハンドラーがルールハンドラーのサブクラスの場合は、引数項目マップを引継ぐ。
	 * </P>
	 * @param callerHandler 呼出し元ハンドラー
	 */
	public AbstractRuleHandler(AbstractDelegateHandler callerHandler) {

		super(callerHandler);

		if (callerHandler instanceof AbstractRuleHandler) {
			conditionItemMap = ((AbstractRuleHandler) callerHandler).conditionItemMap;
		}
	}

}
