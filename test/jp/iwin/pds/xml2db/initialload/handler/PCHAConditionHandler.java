package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;


/**
 * 演算式ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>演算式ハンドラー群が共通的に行う処理を纏めた抽象クラスのSAXイベントハンドラー。（抽象クラス）
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1059 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHApplyHandler
 * @see PCHCompositeConditionHandler
 * @see PCHSingleConditionHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public abstract class PCHAConditionHandler extends PCHARuleHandler {

	/**
	 * エレメント定義
	 */
	protected PCTElementType elementType;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param elementType エレメント定義
	 * @see PCHCompositeConditionHandler
	 * @see PCHSingleConditionHandler
	 */
	public PCHAConditionHandler(PCHApplyHandler callerHandler, PCTElementType elementType) {

		super(callerHandler);

		this.elementType = elementType;
	}

}
