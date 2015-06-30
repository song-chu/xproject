package jp.escofi.emr.engine.loader;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.AbstractCondition;

import org.xml.sax.Attributes;


/**
 * 条件式アプライハンドラー
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件式のアプライ（{@code <apply>}）要素を制御するSAXのイベントハンドラー。
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
public final class ApplyHandler extends AbstractRuleHandler {

	/**
	 * 条件文
	 */
	private AbstractCondition condition;


	/**
	 * コンストラクタ。
	 * @param callerHandler 呼出し元ハンドラー
	 */
	public ApplyHandler(AbstractRuleHandler callerHandler) {
		super(callerHandler);
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
		ElementType elementType = ElementType.getType(qName);
		AbstractConditionHandler handler = RuleHandlerFactory.createConditionHandler(
				elementType, this, atts);

		if (handler != null) {
			reader.setContentHandler(handler);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件式アプライの場合は、以下の処理を行う。
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

		if (ElementType.APPLY.toString().equals(qName)) {

			if (callerHandler instanceof IFHandler) {
				// IFから呼ばれた時 -- 呼ばれた条件文に演算式をセットする。
				IFHandler handler = (IFHandler) callerHandler;

				handler.getRule().setPdsCondition(condition);
			} else {
				// 論理演算式ハンドラーから呼ばれた時
				CompositeConditionHandler handler =
					(CompositeConditionHandler) callerHandler;
				List<AbstractCondition> conditionItems = handler.getConditions();

				conditionItems.add(condition);
			}
			reader.setContentHandler(callerHandler);
		}
	}


	/**
	 * @param condition 条件文
	 */
	void setCondition(AbstractCondition condition) {
		this.condition = condition;
	}

}
