package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 論理演算子OR。
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
public final class LogicOperOR extends AbstractCompositeCondition {

	/**
	 * コンストラクタ。
	 * @param conditions	演算式のList
	 */
	public LogicOperOR(List<AbstractCondition> conditions) {
		super(conditions);
	}

	/**
	 * 論理演算子ORの条件判定を行う。１個の演算式でもTRUE場合、TRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {
		for (AbstractCondition condition : conditions) {
			boolean calcResult = condition.isJudge(argItems);
			if (calcResult) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 論理演算ORの条件式を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	@Override
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(ElementType.OR.toString());
		for (AbstractCondition condition : conditions) {
			writer.startElement(ElementType.APPLY.toString());
			condition.toDump(writer, conditionItemMap);
			writer.endElement(ElementType.APPLY.toString());
		}
		writer.endElement(ElementType.OR.toString());
	}
}
