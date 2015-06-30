package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 論理演算子AND。
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
public final class LogicOperAND extends AbstractCompositeCondition {

	/**
	 * コンストラクタ。
	 * @param conditions 演算式のList
	 */
	public LogicOperAND(List<AbstractCondition> conditions) {
		super(conditions);
	}

	/**
	 * 論理演算子ANDの条件判定を行う。全てのコンディションがTRUE場合のみTRUEを返す。
	 * @param argItems 引数項目値マップ
	 * @return 条件判定結果フラグ
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		for (AbstractCondition condition : conditions) {
			boolean calcResult = condition.isJudge(argItems);
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
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(ElementType.AND.toString());
		for (AbstractCondition condition : conditions) {
			writer.startElement(ElementType.APPLY.toString());
			condition.toDump(writer, conditionItemMap);
			writer.endElement(ElementType.APPLY.toString());
		}
		writer.endElement(ElementType.AND.toString());
	}
}
