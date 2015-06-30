package jp.escofi.emr.engine.condition;

import java.util.Map;

import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 演算式抽象クラス。<BR>
 * <BR>
 * IFとTHENの間、カッコの開けからカッコを閉じるまでの部分を"演算式"とする。（演算式には論理演算式・関係演算式ある） <BR>
 * 演算式はオペランドと演算子で構成される。
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
public abstract class AbstractCondition {

	/**
	 * 判定の実行。
	 *
	 * @param argItems 引数項目のMap型オブジェクト
	 * @return 条件判定結果
	 */
	public abstract boolean isJudge(Map<String, Object> argItems);

	/**
	 * 条件式書き出し。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	public abstract void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException;

}
