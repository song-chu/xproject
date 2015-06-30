package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * IF文ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>IF文（{@code <if>}）要素を制御するSAXのイベントハンドラー。
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
public final class IFHandler extends AbstractRuleHandler {

	/**
	 * 呼出し元条件文
	 */
	private InitRule parentRule;
	/**
	 * 条件文
	 */
	private InitRule rule = new InitRule();
	/**
	 * 入れ子条件文
	 */
	private InitRule childRule;
	/**
	 * IF種類識別子
	 */
	private IFType ifType;
	/**
	 * 入れ子IF種類識別子
	 */
	private IFType childIfType;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param parentRule 呼出し元条件文
	 * @param ifType IF種類識別子
	 */
	public IFHandler(AbstractRuleHandler callerHandler, InitRule parentRule, IFType ifType) {

		super(callerHandler);

		this.parentRule = parentRule;
		this.ifType = ifType;
	}


	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>参照タグが条件式アプライの場合は以下の処理を行う。
	 *   <OL>
	 *    <LI>継承元クラス変数：XMLリーダーに、条件式アプライハンドラーを設定する。</LI>
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
		ElementType elementType = ElementType.getType(qName);
		AbstractDelegateHandler handler = null;
		InitRule initRule = null;

		switch (elementType) {
		case APPLY:
			handler = RuleHandlerFactory.createApplyHandler(this);
			reader.setContentHandler(handler);
			childIfType = IFType.IF_THEN; // applyの後はThen apply無しはElse
			break;

		case IF:
			initRule = getInitRule();
			handler = RuleHandlerFactory.createIFHandler(this, initRule, childIfType);
			reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = RuleHandlerFactory.createELSEHandler(this, childRule);
			reader.setContentHandler(handler);
			break;

		case RESULT:
			initRule = getInitRule();
			handler = ResultObjectHandlerFactory.createResultHandler(
					this, atts, initRule, childIfType);
			reader.setContentHandler(handler);
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

		if (ElementType.IF.toString().equals(qName)) {

			if (callerHandler instanceof IFHandler) {
				IFHandler handler = (IFHandler) callerHandler;

				// 入れ子の場合
				if (IFType.IF_THEN == ifType) {
					parentRule.setThenRule(rule);
				} else {
					// ElseIFは親IFのElseIfでは無く、
					// 前の兄弟IFのElseIFである。（Java条件文オブジェクト）
					parentRule.setElseRule(rule);
				}
				handler.childRule = rule;
				// CallerHandlerのフラグをElseにしておく（XML上IFの後のIFはElseIFのため）
				handler.childIfType = IFType.IF_ELSE;
			} else if (callerHandler instanceof ELSEHandler) {
				parentRule.setElseRule(rule);
				((ELSEHandler) callerHandler).setRule(rule);
			} else {
				ConditionHandler handler = (ConditionHandler) callerHandler;

				// TOPレベルの場合
				if (IFType.IF_TOP == ifType) {
					handler.setRule(rule);
				} else {
					parentRule.setElseRule(rule);
				}
				handler.setChildRule(rule);
				// CallerHandlerのフラグをElseにしておく（XML上IFの後のIFはElseIFのため）
				handler.setChildIfType(IFType.IF_ELSE);
			}
			reader.setContentHandler(callerHandler);
		}
	}


	/**
	 * @return 条件文
	 */
	InitRule getRule() {
		return rule;
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
	private InitRule getInitRule() {
		InitRule ret = childRule;

		if (IFType.IF_THEN == childIfType) {
			ret = rule;
		}

		return ret;
	}

}
