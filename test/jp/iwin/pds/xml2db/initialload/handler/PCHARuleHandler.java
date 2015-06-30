package jp.iwin.pds.xml2db.initialload.handler;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;


/**
 * ルールハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ルールハンドラー郡の共通処理を記載するSAXイベントハンドラーの親クラス。（抽象クラス）
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
 * @see PCHAConditionHandler
 * @see PCHApplyHandler
 * @see PCHConditionHandler
 * @see PCHConstHandler
 * @see PCHELSEHandler
 * @see PCHIFHandler
 * @see PCHSetHandler
 * @see PCHSingleConditionHandler
 * @see PCHSingleHandler
 * @see PCHVarHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public abstract class PCHARuleHandler extends PCHADelegateHandler {

	/**
	 * 引数項目マップ
	 */
	protected Map<String, PROConditionItemInfo> conditionItemMap;
	protected StringBuilder sb = new StringBuilder();
	protected XMLWriter writer = new XMLWriter(sb);
//	protected Map<String,PROResultObject> resultMap ;


	/**
	 * コンストラクタ。
	 * <P>
	 * 呼出し元ハンドラーがルールハンドラーのサブクラスの場合は、引数項目マップを引継ぐ。
	 * </P>
	 * @param callerHandler 呼出し元ハンドラー
	 * @see PCHAConditionHandler
	 * @see PCHApplyHandler
	 * @see PCHConditionHandler
	 * @see PCHConstHandler
	 * @see PCHELSEHandler
	 * @see PCHIFHandler
	 * @see PCHSetHandler
	 * @see PCHSingleConditionHandler
	 * @see PCHSingleHandler
	 * @see PCHVarHandler
	 */
	public PCHARuleHandler(PCHADelegateHandler callerHandler) {

		super(callerHandler);

		if (callerHandler instanceof PCHARuleHandler) {
			this.conditionItemMap = ((PCHARuleHandler) callerHandler).conditionItemMap;
//			this.resultMap = ((PCHARuleHandler) callerHandler).resultMap;
		}
	}

}
