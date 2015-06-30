package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * ELSE文ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ELSE文（{@code <else>}）要素を制御するSAXのイベントハンドラー。
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
public final class ELSEHandler extends AbstractRuleHandler {

	/**
	 * 条件文
	 */
	private InitRule rule;

	/**
	 * 入れ子IF種類識別子
	 */
	private final IFType CHILD_IF_TYPE = IFType.IF_ELSE;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule 条件文
	 */
	public ELSEHandler(AbstractRuleHandler callerHandler, InitRule rule) {

		super(callerHandler);

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
		ElementType elementType = ElementType.getType(qName);
		AbstractDelegateHandler handler = null;

		switch (elementType) {
		case IF:
			handler = RuleHandlerFactory.createIFHandler(this, rule, CHILD_IF_TYPE);
			reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = RuleHandlerFactory.createELSEHandler(this, rule);
			reader.setContentHandler(handler);
			break;

		case RESULT:
			handler = ResultObjectHandlerFactory.createResultHandler(
					this, atts, rule, CHILD_IF_TYPE);
			reader.setContentHandler(handler);
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

		if (ElementType.ELSE.toString().equals(qName)) {
			reader.setContentHandler(callerHandler);
		}
	}


	/**
	 * @param rule 条件文
	 */
	void setRule(InitRule rule) {
		this.rule = rule;
	}

}
