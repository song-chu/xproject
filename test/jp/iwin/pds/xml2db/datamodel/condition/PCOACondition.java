package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.Map;

import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * 演算式抽象クラス。<BR>
 * <BR>
 * IFとTHENの間、カッコの開けからカッコを閉じるまでの部分を"演算式"とする。（演算式には論理演算式・関係演算式ある） <BR>
 * 演算式はオペランドと演算子で構成される。
 * <DL>
 * <DT>最終開発リビジョン：
 * <DD>$Revision: 1115 $
 * <DT>最終開発日時：
 * <DD>$Date: 2010-12-07 16:29:34 +0900 (轣ｫ, 07 12 2010) $
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
public abstract class PCOACondition {

	/**
	 * 判定の実行。
	 *
	 * @return 条件判定結果
	 */
	public abstract boolean judge(Map<String, Object> argItems);

	/**
	 * 条件式書き出し。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException  XML解析エラー
	 */
	public abstract void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException;

}
