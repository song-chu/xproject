package jp.iwin.pds.xml2db.initialload.handler;

/**
 * Delegateハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>タグ処理用のDelegateハンドラー群の共通処理を記載するSAXのイベントハンドラー。（抽象クラス）
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
 * @see PCHAResultObjectHandler
 * @see PCHARuleHandler
 * @see PCHELSEHandler
 * @see PCHIFHandler
 * @see PCHKeyItemHandler
 * @see PCHListHandler
 * @see PCHMapHandler
 * @see PCHObjectHandler
 * @see PCHRangeHandler
 * @see PCHResultHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public abstract class PCHADelegateHandler extends PCHAINIHandler {

	/**
	 * 呼出し元ハンドラー
	 */
	protected PCHAINIHandler callerHandler;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see PCHAResultObjectHandler
	 * @see PCHARuleHandler
	 * @see PCHKeyItemHandler
	 * @see PCHListHandler
	 * @see PCHMapHandler
	 * @see PCHObjectHandler
	 * @see PCHRangeHandler
	 */
	public PCHADelegateHandler(PCHAINIHandler callerHandler) {
		this.callerHandler = callerHandler;
		this.reader = callerHandler.reader;
		this.reader.setErrorHandler(this);
		this.globalConditionItemMap = callerHandler.globalConditionItemMap;
	}
}
