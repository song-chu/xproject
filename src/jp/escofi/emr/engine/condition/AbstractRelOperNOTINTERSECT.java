package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 条件判定 関係演算式NOTINTERSECT。
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
public abstract class AbstractRelOperNOTINTERSECT extends AbstractSingleCondition {

	/**
	 * コンストラクタ。
	 * @param items  本演算子のオペランドリスト
	 */
	public AbstractRelOperNOTINTERSECT(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 関係演算NOTINTERSECTの条件式を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	@Override
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(ElementType.NOT_INTERSECT.toString());
		for (AbstractOperand item : items) {
			if (item instanceof OperandVar) {
				((OperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((OperandConst) item).toDump(writer);
			}
		}
		writer.endElement(ElementType.NOT_INTERSECT.toString());
	}
}
