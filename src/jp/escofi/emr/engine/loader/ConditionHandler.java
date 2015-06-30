package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.HashMap;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;
import jp.escofi.emr.engine.condition.RuleInstance;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.Attributes;


/**
 * 条件文ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のタイプが条件文の場合、条件文全体（{@code <condition>}）以下の要素を制御するSAXのイベントハンドラー。
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
public final class ConditionHandler extends AbstractRuleHandler {

	/**
	 * 条件文
	 */
	private InitRule rule;
	/**
	 * 子条件文
	 */
	private InitRule childRule;
	/**
	 * IF-THEN-ELSE識別子
	 */
	private IFType childIfType = IFType.IF_TOP;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 */
	public ConditionHandler(AbstractResultObjectHandler callerHandler) {

		super(callerHandler);

		conditionItemMap = new HashMap<String, ConditionItemInfo>();
	}


	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>対象タグがIF文の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>IF-THEN-ELSE識別子がTOPの場合は、
	 *クラス変数：子条件文オブジェクトを指定して新規IF文ハンドラーを生成する。</LI>
	 *    <LI>上記以外の場合は、
	 *クラス変数：子条件文オブジェクトを指定して新規IF文ハンドラーを生成する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成したIF文ハンドラーを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>対象タグがELSE文の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：子条件文オブジェクトを指定して新規ELSE文ハンドラーを生成する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成したELSE文ハンドラーを設定する。</LI>
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
		InitRule rule = childRule;
		AbstractRuleHandler handler;

		switch (elementType) {
		case IF:

			if (IFType.IF_TOP == childIfType) {
				this.rule = rule;
			}
			handler = RuleHandlerFactory.createIFHandler(
					this, rule, childIfType);
			reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = RuleHandlerFactory.createELSEHandler(
					this, rule);
			reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件文の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>条件文オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに生成した条件文オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.CONDITION.toString().equals(qName)) {

			// 呼出し元ハンドラー（属性値親ハンドラー）を取得する
			AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;

			// 属性値親ハンドラーに属性値（条件文）を設定する
			// その際、条件文オブジェクトを編集不可能にするため、以下を実施する
			// INIRule -> PDSRule
			// 引数項目情報Mapを編集不可能にする。
			handler.setValue(new RuleInstance(rule.getPdsCondition(),
					rule.getThenRule(), rule.getElseRule(),
					rule.getThenAction(), rule.getElseAction(),
					Collections.unmodifiableMap(conditionItemMap)));

			reader.setContentHandler(handler);
		}
	}


	/**
	 * @param childRule 子条件文
	 */
	void setChildRule(InitRule childRule) {
		this.childRule = childRule;
	}
	/**
	 * @param childIfType IF-THEN-ELSE識別子
	 */
	void setChildIfType(IFType childIfType) {
		this.childIfType = childIfType;
	}

	/**
	 * @param rule 条件文
	 */
	void setRule(InitRule rule) {
		this.rule = rule;
	}

}
