package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * 演算式ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>演算式ハンドラー群が共通的に行う処理を纏めた抽象クラスのSAXイベントハンドラー。（抽象クラス）
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
public abstract class AbstractConditionHandler extends AbstractRuleHandler {

	/**
	 * エレメント定義
	 */
	protected ElementType elementType;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param elementType エレメント定義
	 */
	public AbstractConditionHandler(ApplyHandler callerHandler, ElementType elementType) {

		super(callerHandler);

		this.elementType = elementType;
	}

}
