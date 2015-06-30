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
 * 条件判定 条件文（イニシャルローダ用）クラス。
 * <DL>
 * <DT>初版情報（作成日・作成者）：
 * <DD>2011/08/01 EBS
 * <DT>変更履歴（変更日、変更者、変更内容）：
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS 新規作成
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public class InitRule implements Rule {

	/**
	 * 演算式クラス
	 */
	private AbstractCondition pdsCondition;
	/**
	 * THEN条件文
	 */
	private Rule thenRule;
	/**
	 * ELSE条件文
	 */
	private Rule elseRule;
	/**
	 * THENアクション
	 */
	private AbstractAction thenAction;
	/**
	 * ELSEアクション
	 */
	private AbstractAction elseAction;

	/**
	 * コンストラクタ
	 */
	public InitRule() {
	}

	/**
	 * 条件文を処理する。（再帰処理）
	 *
	 * @param argItems
	 *            引数項目値マップ
	 * @return 属性値オブジェクト
	 */
	public ResultObject apply(Map<String, Object> argItems)
			throws ConditionNotMatchedException {

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
					throw new ConditionNotMatchedException(
							MessageCode.EMR_A_P007E, new Object[] { argItems });
				}
				return elseAction.getResultObject();
			}
		}
	}

	/**
	 * 演算式のセッター
	 *
	 * @param pdsCondition
	 *            演算式
	 */
	public void setPdsCondition(AbstractCondition pdsCondition) {
		this.pdsCondition = pdsCondition;
	}

	/**
	 * Then条件文のセッター
	 *
	 * @param thenRule
	 *            Then条件文
	 */
	public void setThenRule(InitRule thenRule) {
		this.thenRule = thenRule;
	}

	/**
	 * Else条件文のセッター
	 *
	 * @param elseRule
	 *            Else条件文
	 */
	public void setElseRule(InitRule elseRule) {
		this.elseRule = elseRule;
	}

	/**
	 * Thenアクションのセッター
	 *
	 * @param thenAction
	 *            Thenアクション
	 */
	public void setThenAction(AbstractAction thenAction) {
		this.thenAction = thenAction;
	}

	/**
	 * Elseアクションのセッター
	 *
	 * @param elseAction
	 *            Elseアクション
	 */
	public void setElseAction(AbstractAction elseAction) {
		this.elseAction = elseAction;
	}

	/**
	 * 演算式のゲッター
	 *
	 * @return 演算式
	 */
	public AbstractCondition getPdsCondition() {
		return pdsCondition;
	}

	/**
	 * Then条件文のゲッター
	 *
	 * @return thenRule Then条件文
	 */
	public Rule getThenRule() {
		return thenRule;
	}

	/**
	 * Else条件文のゲッター
	 *
	 * @return elseRule Else条件文
	 */
	public Rule getElseRule() {
		return elseRule;
	}

	/**
	 * Thenアクションのゲッター
	 *
	 * @return Thenアクション
	 */
	public AbstractAction getThenAction() {
		return thenAction;
	}

	/**
	 * Elseアクションのゲッター
	 *
	 * @return Elseアクション
	 */
	public AbstractAction getElseAction() {
		return elseAction;
	}

	/**
	 * 条件文書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>条件文書を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException XML解析エラー
	 */
	protected void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
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
	}
}
