package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 条件判定 関係演算式INCLUDE。
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
public abstract class AbstractRelOperINCLUDE extends AbstractSingleCondition {
	/**
	 * 下限の境界値を含むか(true:含む)
	 */
	protected boolean lowerEq;
	/**
	 * 上限の境界値を含むか(true:含む)
	 */
	protected boolean upperEq;

	/**
	 * コンストラクタ
	 *
	 * @param items
	 *            本演算子のオペランドリスト
	 */
	public AbstractRelOperINCLUDE(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * 下限の境界値を含むかを設定する。
	 *
	 * @param lowerEq
	 *            下限の境界値を含むか
	 */
	public void setLowerEq(boolean lowerEq) {
		this.lowerEq = lowerEq;
	}

	/**
	 * 上限の境界値を含むかを設定する。
	 *
	 * @param upperEq
	 *            上限の境界値を含むか
	 */
	public void setUpperEq(boolean upperEq) {
		this.upperEq = upperEq;
	}

	/**
	 * 関係演算INCLUDEの条件式を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	@Override
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.UPPER_EQ.toString(),
				Boolean.toString(upperEq));
		writer.addAttribute(atts, AttributeType.LOWER_EQ.toString(),
				Boolean.toString(lowerEq));
		writer.startElement(ElementType.INCLUDE.toString(), atts);
		for (AbstractOperand item : items) {
			if (item instanceof OperandVar) {
				((OperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((OperandConst) item).toDump(writer);
			}
		}
		writer.endElement(ElementType.INCLUDE.toString());
	}

}
