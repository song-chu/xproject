package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHResultObjectHandlerFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * IF文ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>IF文（{@code <if>}）要素を制御するSAXのイベントハンドラー。
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHIFHandler extends PCHARuleHandler {

	/**
	 * 呼出し元条件文
	 */
	private PROINIRule parentRule;
	/**
	 * 条件文
	 */
	private PROINIRule rule = new PROINIRule();
	/**
	 * 入れ子条件文
	 */
	private PROINIRule childRule;
	/**
	 * IF種類識別子
	 */
	private PCTIFType ifType;
	/**
	 * 入れ子IF種類識別子
	 */
	private PCTIFType childIFtype;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param parentRule 呼出し元条件文
	 * @param ifType IF種類識別子
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHIFHandler(PCHARuleHandler callerHandler, PROINIRule parentRule, PCTIFType ifType, XMLWriter writer) {

		super(callerHandler);

		this.parentRule = parentRule;
		this.ifType = ifType;
		this.writer = writer;
	}


	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>参照タグが条件式カッコの場合は以下の処理を行う。
	 *   <OL>
	 *    <LI>継承元クラス変数：XMLリーダーに、条件式カッコハンドラーを設定する。</LI>
	 *    <LI>クラス変数：入れ子IF種類識別子に、THENを保持する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>参照タグがIF文の場合は以下の処理を行う。
	 *   <OL>
	 *    <LI>入れ子にセットすべき条件文を取得する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに、IF文ハンドラーを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>参照タグがELSE文の場合は以下の処理を行う。
	 *   <OL>
	 *    <LI>継承元クラス変数：XMLリーダーに、ELSE文ハンドラーを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>参照タグが条件式結果の場合は以下の処理を行う。
	 *   <OL>
	 *    <LI>入れ子にセットすべき条件文を取得する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに、条件式結果ハンドラーを設定する。</LI>
	 *   </OL>
	 *  </LI>
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
		PROINIRule iniRule = null;
		this.writer.startElement(qName);

		switch (elementType) {
		case APPLY:
			handler = PCHRuleHandlerFactory.createApplyHandler(this, this.writer);
			this.reader.setContentHandler(handler);
			this.childIFtype = PCTIFType.IF_THEN; // applyの後はThen apply無しはElse
			break;

		case IF:
			iniRule = getINIRule();
			handler = PCHRuleHandlerFactory.createIFHandler(this, iniRule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = PCHRuleHandlerFactory.createELSEHandler(this, this.childRule,this.writer);
			this.reader.setContentHandler(handler);
			break;

		case RESULT:
			iniRule = getINIRule();
			handler = PCHResultObjectHandlerFactory.createResultHandler(
					this, atts, iniRule, this.childIFtype,this.writer);
			this.reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグがIF文の場合は、以下の処理を行う。
	 * </P>
	 * <UL>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーがIF文ハンドラーの場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>入れ子の場合はクラス変数：呼出し元条件文のTHEN条件に、クラス変数：条件文を設定する。</LI>
	 *    <LI>上記以外の場合はクラス変数：呼出し元条件文のELSE条件に、クラス変数：条件文を設定する。</LI>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーの入れ子IF条件文に、クラス変数：条件文を設定する。</LI>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーの入れ子IF種類識別子に、IF種類識別子：ELSEを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーがELSE文ハンドラーの場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：呼出し元条件文のELSE条件に、クラス変数：条件文を設定する。</LI>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーに、クラス変数：条件文を設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーが条件文ハンドラーの場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>TOPレベルの場合は継承元クラス変数：呼出し元ハンドラーに、クラス変数：条件文を設定する。</LI>
	 *    <LI>上記以外の場合はクラス変数：呼出し元条件文のELSE条件に、クラス変数：条件文を設定する。</LI>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーの入れ子IF条件文に、クラス変数：条件文を設定する。</LI>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーの入れ子IF種類識別子に、IF種類識別子：ELSEを設定する。</LI>
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
		if (PCTElementType.IF.equals(qName)) {

			if (this.callerHandler instanceof PCHIFHandler) {
				PCHIFHandler handler = (PCHIFHandler) this.callerHandler;

				// 入れ子の場合
				if (PCTIFType.IF_THEN.equals(this.ifType)) {
					this.parentRule.setThenRule(this.rule);
				} else {
					// ElseIFは親IFのElseIfでは無く、
					// 前の兄弟IFのElseIFである。（Java条件文オブジェクト）
					this.parentRule.setElseRule(this.rule);
				}
				handler.childRule = this.rule;
				// CallerHandlerのフラグをElseにしておく（XML上IFの後のIFはElseIFのため）
				handler.childIFtype = PCTIFType.IF_ELSE;
			} else if (this.callerHandler instanceof PCHELSEHandler) {
				this.parentRule.setElseRule(this.rule);
				((PCHELSEHandler) this.callerHandler).setRule(this.rule);
			} else {
				PCHConditionHandler handler = (PCHConditionHandler) this.callerHandler;

				// TOPレベルの場合
				if (PCTIFType.IF_TOP.equals(this.ifType)) {
					handler.setRule(this.rule);
				} else {
					this.parentRule.setElseRule(this.rule);
				}
				handler.setChildRule(this.rule);
				// CallerHandlerのフラグをElseにしておく（XML上IFの後のIFはElseIFのため）
				handler.setChildIFtype(PCTIFType.IF_ELSE);
			}
			this.reader.setContentHandler(this.callerHandler);
		}
	}


	/**
	 * @return 条件文
	 * @see PCHApplyHandler
	 */
	PROINIRule getRule() {
		return this.rule;
	}


	/**
	 * 条件文取得処理。
	 * <P>
	 * 入れ子にセットすべき条件文を取得する。<BR>
	 * このような判定を行う理由はIf文がElseIFになる時、早いもの勝ち（XML要件）
	 *という、XMLとJavaオブジェクトの構造の違いにあるから。<BR>
	 * Javaの条件文オブジェクトはElseifは必ず直前条件文の入れ子となるが、
	 *XMLはレベルが同じ。
	 * </P>
	 * @return 条件文
	 */
	private PROINIRule getINIRule() {
		PROINIRule ret = this.childRule;

		if (PCTIFType.IF_THEN.equals(this.childIFtype)) {
			ret = this.rule;
		}

		return ret;
	}

}
