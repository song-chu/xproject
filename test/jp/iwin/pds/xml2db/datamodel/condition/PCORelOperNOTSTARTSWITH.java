package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 条件判定 関係演算式NOTSTARTSWITH。
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
 * @see jp.iwin.pds.datamodel.condition.PCOASingleCondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperNOTSTARTSWITH extends PCOASingleCondition {

	/**
	 * コンストラクタ
	 * @param items	本演算子のオペランドリスト
	 */
	public PCORelOperNOTSTARTSWITH(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * 左右オペランド（String）のNOTSTARTSWITH演算を行う。
	 * 左オペランドが右オペランドから開始しない場合、TRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		String source = (String) assign(this.items.get(0), argItems);
		String target = (String) assign(this.items.get(1), argItems);

		return !(source.startsWith(target));
	}

	/**
	 * 関係演算NOTSTARTSWITHの条件式を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	@Override
	public void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(PCTElementType.NOTSTARTSWITH.toString());
		for (PCOAOperand item : this.items) {
			if (item instanceof PCOOperandVar) {
				((PCOOperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((PCOOperandConst) item).toDump(writer);
			}
		}
		writer.endElement(PCTElementType.NOTSTARTSWITH.toString());
	}
}
