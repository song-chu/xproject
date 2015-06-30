package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOOperandConst;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * 条件式定数ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件式の定数（{@code <const>}）要素を制御するSAXのイベントハンドラー。
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
 * @see PCHSetHandler
 * @see PCHSingleHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHConstHandler extends PCHARuleHandler {

	/**
	 * 属性値
	 */
	private Object value;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHConstHandler(PCHSingleConditionHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer=writer;
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * 継承元クラス変数：XMLリーダーに、エレメントタイプに応じたルールハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName);
		// エレメントタイプ取得
		PCTElementType elementType = PCTElementType.getType(qName);
		// ルールハンドラー取得
		PCHARuleHandler handler = PCHRuleHandlerFactory.createRuleHandler(elementType, this, this.writer);

		this.reader.setContentHandler(handler);
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件式定数の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>引数項目定数部オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに生成した引数項目定数部オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.CONST.equals(qName)) {
			PCHSingleConditionHandler handler = (PCHSingleConditionHandler) this.callerHandler;
			PCOOperandConst itemConst = new PCOOperandConst(this.value);

			handler.getConditionItems().add(itemConst);
			this.reader.setContentHandler(handler);
		}
	}


	/**
	 * @param value 属性値
	 * @see PCHSetHandler
	 * @see PCHSingleHandler
	 */
	void setValue(Object value) {
		this.value = value;
	}

}
