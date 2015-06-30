package jp.iwin.pds.xml2db.initialload.handler;

import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * 条件式カッコハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件式のカッコ（{@code <apply>}）要素を制御するSAXのイベントハンドラー。
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
 * @see PCHCompositeConditionHandler
 * @see PCHSingleConditionHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHApplyHandler extends PCHARuleHandler {

	/**
	 * 条件文
	 */
	private PCOACondition condition;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHApplyHandler(PCHARuleHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer=writer;
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * 継承元クラス変数：XMLリーダーに、エレメントタイプに応じた演算子ハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName,atts);
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHAConditionHandler handler = PCHRuleHandlerFactory.createConditionHandler(
				elementType, this, atts, this.writer);

		if (handler != null) {
			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件式カッコの場合は、以下の処理を行う。
	 * </P>
	 * <UL>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーがIF文ハンドラーの場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>呼出し元ハンドラーから、条件文オブジェクトを取得する。</LI>
	 *    <LI>条件文オブジェクトに、クラス変数：条件文を設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーが論理演算式ハンドラーの場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>呼出し元ハンドラーから、条件文リストを取得する。</LI>
	 *    <LI>条件文リストにクラス変数：条件文を格納する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * <P>
	 * 呼出し元ハンドラー毎の処理の後、継承元クラス変数：XMLリーダーに、
	 *継承元クラス変数：呼出し元ハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.APPLY.equals(qName)) {

			if (this.callerHandler instanceof PCHIFHandler) {
				// IFから呼ばれた時 -- 呼ばれた条件文に演算式をセットする。
				PCHIFHandler handler = (PCHIFHandler) this.callerHandler;

				handler.getRule().setPdsCondition(this.condition);
			} else {
				// 論理演算式ハンドラーから呼ばれた時
				PCHCompositeConditionHandler handler =
					(PCHCompositeConditionHandler) this.callerHandler;
				List<PCOACondition> conditionItems = handler.getConditions();

				conditionItems.add(this.condition);
			}
			this.reader.setContentHandler(this.callerHandler);
		}
	}


	/**
	 * @param condition 条件文
	 * @see PCHCompositeConditionHandler
	 * @see PCHSingleConditionHandler
	 */
	void setCondition(PCOACondition condition) {
		this.condition = condition;
	}

}
