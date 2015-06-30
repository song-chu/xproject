package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHResultObjectHandlerFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * ELSE文ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ELSE文（{@code <else>}）要素を制御するSAXのイベントハンドラー。
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
 * @see PCHIFHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHELSEHandler extends PCHARuleHandler {

	/**
	 * 条件文
	 */
	private PROINIRule rule;

	/**
	 * 入れ子IF種類識別子
	 */
	private final PCTIFType childIFtype = PCTIFType.IF_ELSE;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule 条件文
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHELSEHandler(PCHARuleHandler callerHandler, PROINIRule rule, XMLWriter writer) {

		super(callerHandler);
		this.writer=writer;
		this.rule = rule;
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * 参照中のタグが以下の場合は、継承元クラス変数：XMLリーダーのハンドラーに、
	 *対応するハンドラーを設定する。
	 * </P>
	 * <UL>
	 *  <LI>IF文</LI>
	 *  <LI>ELSE文</LI>
	 *  <LI>条件式結果</LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHADelegateHandler handler = null;
		this.writer.startElement(qName);
		switch (elementType) {
		case IF:
			handler = PCHRuleHandlerFactory.createIFHandler(this, this.rule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = PCHRuleHandlerFactory.createELSEHandler(this, this.rule, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case RESULT:
			handler = PCHResultObjectHandlerFactory.createResultHandler(this, atts, this.rule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグがELSE文の場合は、継承元クラス変数：XMLリーダーに、
	 *継承元クラス変数：呼出し元ハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.ELSE.equals(qName)) {
			this.reader.setContentHandler(this.callerHandler);
		}
	}


	/**
	 * @param rule 条件文
	 * @see PCHIFHandler
	 */
	void setRule(PROINIRule rule) {
		this.rule = rule;
	}

}
