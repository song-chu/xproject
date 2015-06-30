package jp.iwin.pds.xml2db.datamodel;

import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;


/**
 * 条件判定 条件文（エンジン用）クラス。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1104 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 15:13:14 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public class PRORule implements PROIRule {

	/**
	 * 演算式クラス
	 */
	private PCOACondition pdsCondition;
	/**
	 * Then条件文
	 */
	private PROIRule thenRule;
	/**
	 * Else条件文
	 */
	private PROIRule elseRule;
	/**
	 * Thenアクション
	 */
	private PROAction thenAction;
	/**
	 * Elseアクション
	 */
	private PROAction elseAction;
	/**
	 * 引数項目Map
	 */
	private Map<String, PROConditionItemInfo> conditionItemMap;

	private Map<String,PROResultObject> resultMap ;

	public Map<String, PROResultObject> getresultMap() {
		return resultMap;
	}

	/**
	 * 条件式XML
	 */
	private String xml;


	public String getXml() {
		return xml;
	}

	/**
	 * コンストラクタ
	 */
	public PRORule() {}

	/**
	 *  コンストラクタ
	 * @param condition 演算式
	 * @param thenRule Then条件文
	 * @param elseRule Else条件文
	 * @param thenAction Thenアクション
	 * @param elseAction Elseアクション
	 * @param conditionItemMap 引数項目
	 */
	public PRORule(PCOACondition condition, PROIRule thenRule, PROIRule elseRule,
			PROAction thenAction, PROAction elseAction,
			Map<String, PROConditionItemInfo> conditionItemMap, String xml,Map<String,PROResultObject> resultMap ) {
		this.pdsCondition = condition;
		this.thenRule = thenRule;
		this.elseRule = elseRule;
		this.thenAction = thenAction;
		this.elseAction = elseAction;
		this.conditionItemMap = conditionItemMap;
		this.xml = xml;
		this.resultMap = resultMap;
	}

	/**
	 * 条件文を処理する。（再帰処理）
	 *
	 * @param argItems 引数項目値マップ
	 * @return 属性値オブジェクト
	 * @throws PEXConditionNotMatchedException 条件不成立例外
	 * @see jp.iwin.pds.datamodel.PROIRule#apply(java.util.Map)
	 */
	public PROResultObject apply(Map<String, Object> argItems) throws PEXConditionNotMatchedException {

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
					throw new PEXConditionNotMatchedException(PCTMessageCode.P007E, new Object[]{argItems});
				}
				return this.elseAction.getResultObject();
			}
		}
	}

	/**
	 * 引数項目Mapのゲッター
	 * @return 引数項目Map
	 * @see jp.iwin.pds.datamodel.PROIRule#getConditionItemMap()
	 */
	public Map<String, PROConditionItemInfo> getConditionItemMap() {
		return this.conditionItemMap;
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
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		writer.startElement(PCTElementType.CONDITION.toString());
		writer.startElement(PCTElementType.IF.toString());

		writer.startElement(PCTElementType.APPLY.toString());
		this.pdsCondition.toDump(writer, this.conditionItemMap);
		writer.endElement(PCTElementType.APPLY.toString());

		if (this.thenRule != null) {
			((PROINIRule) this.thenRule).toDump(writer, this.conditionItemMap);
		} else {
			this.thenAction.toDump(writer);
		}
		writer.endElement(PCTElementType.IF.toString());

		if (this.elseRule != null) {
			((PROINIRule) this.elseRule).toDump(writer, this.conditionItemMap);
		}
		if (this.elseAction != null) {
			writer.startElement(PCTElementType.ELSE.toString());
			this.elseAction.toDump(writer);
			writer.endElement(PCTElementType.ELSE.toString());
		}
		writer.endElement(PCTElementType.CONDITION.toString());

	}
}
