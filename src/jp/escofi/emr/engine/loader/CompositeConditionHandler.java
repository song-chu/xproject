package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.List;

import jp.escofi.emr.engine.common.constant.ConditionType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.AbstractCompositeCondition;
import jp.escofi.emr.engine.condition.AbstractCondition;
import jp.escofi.emr.engine.condition.CompositeConditionFactory;

import org.xml.sax.Attributes;


/**
 * 論理演算式ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデルXMLの以下のタグに対応するSAXイベントハンドラー。
 *    <UL>
 *     <LI>{@code <and>}</LI>
 *     <LI>{@code <or>}</LI>
 *    </UL>
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
public final class CompositeConditionHandler extends AbstractConditionHandler {

	/**
	 * 条件文リスト
	 */
	private List<AbstractCondition> conditions = new ArrayList<AbstractCondition>();


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param elementType エレメントタイプ
	 */
	public CompositeConditionHandler(
			ApplyHandler callerHandler, ElementType elementType) {
		super(callerHandler, elementType);
	}

	/**
	 * タグ開始処理。
	 * <P>
	 * 対象タグが条件式アプライの場合は、継承元クラス変数：XMLリーダーに、
	 *条件式アプライハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (ElementType.APPLY.toString().equals(qName)) {
			ApplyHandler handler = RuleHandlerFactory.createApplyHandler(this);

			reader.setContentHandler(handler);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 参照中のタグ名から取得したエレメント定義が、クラス変数：エレメント定義と同一の場合は、
	 *以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>複合条件文オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに、生成した複合条件文オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに、継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType localElementType = ElementType.getType(qName);

		if (this.elementType == localElementType) {
			ApplyHandler handler = (ApplyHandler) callerHandler;
			ConditionType conditionType = getConditionType(localElementType);
			AbstractCompositeCondition compositeCondition =
				CompositeConditionFactory.createCompositeCondition(
						conditions, conditionType);

			handler.setCondition(compositeCondition);
			reader.setContentHandler(handler);
		}
	}


	/**
	 * @return 条件文リスト
	 */
	List<AbstractCondition> getConditions() {
		return conditions;
	}


	/**
	 * 演算子定義取得。
	 * <P>
	 * エレメント定義に応じた演算子定義を取得する。
	 * </P>
	 * @param elementType エレメント定義
	 * @return 演算子定義
	 */
	private ConditionType getConditionType(ElementType elementType) {
		ConditionType ret = null;

		switch (elementType) {
		case AND:
			ret = ConditionType.CONDITION_AND;
			break;

		case OR:
			ret = ConditionType.CONDITION_OR;
			break;
		}

		return ret;
	}

}
