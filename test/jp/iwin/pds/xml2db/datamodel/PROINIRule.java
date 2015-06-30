package jp.iwin.pds.xml2db.datamodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;

/**
 * 条件判定 条件文（イニシャルローダ用）クラス。
 * <DL>
 * <DT>最終開発リビジョン：
 * <DD>$Revision: 1104 $
 * <DT>最終開発日時：
 * <DD>$Date: 2010-12-07 15:13:14 +0900 (轣ｫ, 07 12 2010) $
 * <DT>初版情報（作成日・作成者）：
 * <DD>2011/12/01 EBS
 * <DT>変更履歴（変更日、変更者、変更内容）：
 * <DD>
 * <UL>
 * <LI>2011/12/01 EBS 新規作成
 * </UL>
 * </DL>
 * <P>
 * Copyright(c)2011 Nissay Information Technology Co.,Ltd.
 * </P>
 *
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public class PROINIRule implements PROIRule {

	/**
	 * 演算式クラス
	 */
	private PCOACondition pdsCondition;
	/**
	 * THEN条件文
	 */
	private PROIRule thenRule;
	/**
	 * ELSE条件文
	 */
	private PROIRule elseRule;
	/**
	 * THENアクション
	 */
	private PROAction thenAction;
	/**
	 * ELSEアクション
	 */
	private PROAction elseAction;
	/**
	 *
	 */
	private Map<String,PROResultObject> resutMap ;


	public Map<String, PROResultObject> getResutMap() {
		return resutMap;
	}

	public void setResutMap(Map<String, PROResultObject> resutMap) {
		this.resutMap = resutMap;
	}

	/**
	 * コンストラクタ
	 */
	public PROINIRule() {
	}

	/**
	 * 条件文を処理する。（再帰処理）
	 *
	 * @param argItems
	 *            引数項目値マップ
	 * @return 属性値オブジェクト
	 * @see jp.iwin.pds.datamodel.PROIRule#apply(java.util.Map)
	 */
	public PROResultObject apply(Map<String, Object> argItems)
			throws PEXConditionNotMatchedException {

		if (this.pdsCondition.judge(argItems)) {
			if (this.thenRule != null) {
				return thenRule.apply(argItems);
			} else {
				return this.thenAction.getResultObject();
			}
		} else {
			if (this.elseRule != null) {
				return elseRule.apply(argItems);
			} else {
				if (this.elseAction == null) {
					throw new PEXConditionNotMatchedException(
							PCTMessageCode.P007E, new Object[] { argItems });
				}
				return this.elseAction.getResultObject();
			}
		}
	}

	/**
	 * 演算式のセッター
	 *
	 * @param pdsCondition
	 *            演算式
	 */
	public void setPdsCondition(PCOACondition pdsCondition) {
		this.pdsCondition = pdsCondition;
	}

	/**
	 * Then条件文のセッター
	 *
	 * @param thenRule
	 *            Then条件文
	 */
	public void setThenRule(PROINIRule thenRule) {
		this.thenRule = thenRule;
	}

	/**
	 * Else条件文のセッター
	 *
	 * @param elseRule
	 *            Else条件文
	 */
	public void setElseRule(PROINIRule elseRule) {
		this.elseRule = elseRule;
	}

	/**
	 * Thenアクションのセッター
	 *
	 * @param thenAction
	 *            Thenアクション
	 */
	public void setThenAction(PROAction thenAction) {
		this.thenAction = thenAction;
	}

	/**
	 * Elseアクションのセッター
	 *
	 * @param elseAction
	 *            Elseアクション
	 */
	public void setElseAction(PROAction elseAction) {
		this.elseAction = elseAction;
	}

	/**
	 * 演算式のゲッター
	 *
	 * @return 演算式
	 */
	public PCOACondition getPdsCondition() {
		return this.pdsCondition;
	}

	/**
	 * Then条件文のゲッター
	 *
	 * @return thenRule Then条件文
	 */
	public PROIRule getThenRule() {
		return thenRule;
	}

	/**
	 * Else条件文のゲッター
	 *
	 * @return elseRule Else条件文
	 */
	public PROIRule getElseRule() {
		return elseRule;
	}

	/**
	 * Thenアクションのゲッター
	 *
	 * @return Thenアクション
	 */
	public PROAction getThenAction() {
		return this.thenAction;
	}

	/**
	 * Elseアクションのゲッター
	 *
	 * @return Elseアクション
	 */
	public PROAction getElseAction() {
		return this.elseAction;
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
	protected void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(PCTElementType.IF.toString());

		writer.startElement(PCTElementType.APPLY.toString());

		this.pdsCondition.toDump(writer, conditionItemMap);
		writer.endElement(PCTElementType.APPLY.toString());

		if (this.thenRule != null) {
			((PROINIRule) this.thenRule).toDump(writer, conditionItemMap);
		} else {
			this.thenAction.toDump(writer);
		}
		writer.endElement(PCTElementType.IF.toString());
		if (this.elseRule != null) {
			((PROINIRule) this.elseRule).toDump(writer, conditionItemMap);
		}
		if (this.elseAction != null) {
			writer.startElement(PCTElementType.ELSE.toString());
			this.elseAction.toDump(writer);
			writer.endElement(PCTElementType.ELSE.toString());
		}
	}
}
