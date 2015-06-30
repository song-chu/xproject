package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 論理演算子AND。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1120 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 17:38:14 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOACompositeCondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCOLogicOperAND extends PCOACompositeCondition {

	/**
	 * コンストラクタ。
	 * @param conditions 演算式のList
	 */
	public PCOLogicOperAND(List<PCOACondition> conditions) {
		super(conditions);
	}

	/**
	 * 論理演算子ANDの条件判定を行う。全てのコンディションがTRUE場合のみTRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		for (PCOACondition condition : conditions) {
			boolean calcResult = condition.judge(argItems);
			if (!calcResult) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 論理演算ANDの条件式を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	@Override
	public void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(PCTElementType.AND.toString());
		for (PCOACondition condition : this.conditions) {
			writer.startElement(PCTElementType.APPLY.toString());
			condition.toDump(writer, conditionItemMap);
			writer.endElement(PCTElementType.APPLY.toString());
		}
		writer.endElement(PCTElementType.AND.toString());
	}
}
