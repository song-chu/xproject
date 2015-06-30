package jp.escofi.emr.engine.condition;

import java.util.Map;

import org.xml.sax.SAXException;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.ResultObject;


/**
 * 条件判定 条件文（エンジン用）クラス。
 * <DL>
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
public class RuleInstance implements Rule {

	/**
	 * 演算式クラス
	 */
	private AbstractCondition pdsCondition;
	/**
	 * Then条件文
	 */
	private Rule thenRule;
	/**
	 * Else条件文
	 */
	private Rule elseRule;
	/**
	 * Thenアクション
	 */
	private AbstractAction thenAction;
	/**
	 * Elseアクション
	 */
	private AbstractAction elseAction;
	/**
	 * 引数項目Map
	 */
	private Map<String, ConditionItemInfo> conditionItemMap;

	/**
	 * コンストラクタ
	 */
	public RuleInstance() {}

	/**
	 *  コンストラクタ
	 * @param condition 演算式
	 * @param thenRule Then条件文
	 * @param elseRule Else条件文
	 * @param thenAction Thenアクション
	 * @param elseAction Elseアクション
	 * @param conditionItemMap 引数項目
	 */
	public RuleInstance(AbstractCondition condition, Rule thenRule, Rule elseRule,
			AbstractAction thenAction, AbstractAction elseAction,
			Map<String, ConditionItemInfo> conditionItemMap) {
		this.pdsCondition = condition;
		this.thenRule = thenRule;
		this.elseRule = elseRule;
		this.thenAction = thenAction;
		this.elseAction = elseAction;
		this.conditionItemMap = conditionItemMap;
	}

	/**
	 * 条件文を処理する。（再帰処理）
	 *
	 * @param argItems 引数項目値マップ
	 * @return 属性値オブジェクト
	 * @throws ConditionNotMatchedException 条件不成立例外
	 */
	public ResultObject apply(Map<String, Object> argItems) throws ConditionNotMatchedException {

		if (pdsCondition.isJudge(argItems)) {
			if (thenRule != null) {
				return thenRule.apply(argItems);
			} else {
				return thenAction.getResultObject();
			}
		} else {
			if (elseRule != null) {
				return elseRule.apply(argItems);
			} else {
				if (elseAction == null) {
					throw new ConditionNotMatchedException(MessageCode.EMR_A_P007E, new Object[]{argItems});
				}
				return elseAction.getResultObject();
			}
		}
	}

	/**
	 * 引数項目Mapのゲッター
	 * @return 引数項目Map
	 */
	public Map<String, ConditionItemInfo> getConditionItemMap() {
		return conditionItemMap;
	}

	/**
	 * 初期条件文書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>初期条件文を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	public void toDump(XMLWriter writer) throws SAXException {
		writer.startElement(ElementType.CONDITION.toString());
		writer.startElement(ElementType.IF.toString());

		writer.startElement(ElementType.APPLY.toString());
		pdsCondition.toDump(writer, conditionItemMap);
		writer.endElement(ElementType.APPLY.toString());

		if (thenRule != null) {
			((InitRule) thenRule).toDump(writer, conditionItemMap);
		} else {
			thenAction.toDump(writer);
		}
		writer.endElement(ElementType.IF.toString());

		if (elseRule != null) {
			((InitRule) elseRule).toDump(writer, conditionItemMap);
		}
		if (elseAction != null) {
			writer.startElement(ElementType.ELSE.toString());
			elseAction.toDump(writer);
			writer.endElement(ElementType.ELSE.toString());
		}
		writer.endElement(ElementType.CONDITION.toString());

	}
}
