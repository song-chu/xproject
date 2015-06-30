package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 条件判定 関係演算式EXCLUDE。
 * <DL>
 * <DT>最終開発リビジョン：
 * <DD>$Revision: 1120 $
 * <DT>最終開発日時：
 * <DD>$Date: 2010-12-07 17:38:14 +0900 (轣ｫ, 07 12 2010) $
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
 * @see jp.iwin.pds.datamodel.condition.PCOASingleCondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOARelOperEXCLUDE extends PCOASingleCondition {
	/**
	 * 下限の境界値を含むか(true:含む)
	 */
	protected boolean lowereq;
	/**
	 * 上限の境界値を含むか(true:含む)
	 */
	protected boolean uppereq;

	/**
	 * コンストラクタ
	 *
	 * @param items
	 *            本演算子のオペランドリスト
	 */
	public PCOARelOperEXCLUDE(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * 下限の境界値を含むかを設定する。
	 *
	 * @param lower
	 *            下限の境界値を含むか
	 */
	public void setLowereq(boolean lowereq) {
		this.lowereq = lowereq;
	}

	/**
	 * 上限の境界値を含むかを設定する。
	 *
	 * @param upper
	 *            上限の境界値を含むか
	 */
	public void setUppereq(boolean uppereq) {
		this.uppereq = uppereq;
	}

	/**
	 * 関係演算EXCLUDEの条件式を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	@Override
	public void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.UPPEREQ.toString(),
				Boolean.toString(this.uppereq));
		writer.addAttribute(atts, PCTAttributeType.LOWEREQ.toString(),
				Boolean.toString(this.lowereq));
		writer.startElement(PCTElementType.EXCLUDE.toString(), atts);
		for (PCOAOperand item : this.items) {
			if (item instanceof PCOOperandVar) {
				((PCOOperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((PCOOperandConst) item).toDump(writer);
			}
		}
		writer.endElement(PCTElementType.EXCLUDE.toString());
	}

}
