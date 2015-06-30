package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * オペランド変数部クラス。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1121 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 17:46:37 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOAOperand
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCOOperandVar extends PCOAOperand {

	/**
	 * 変数（引数項目）名
	 */
	private String name;

	/**
	 * 引数項目名のセッターメソッド。
	 * @param name 変数（引数項目）名
	 */
	public PCOOperandVar(String name) {
		this.name = name;
	}

	/**
	 * 引数項目名のゲッターメソッド。
	 * @return 変数（引数項目）名
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * オペランド変数部を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException XML解析エラー
	 */
	protected void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.DATATYPE.toString(),
				conditionItemMap.get(this.name).getItemType());
		writer.addAttribute(atts, PCTAttributeType.JAVADATATYPE.toString(),
				conditionItemMap.get(this.name).getJavaDataType());
		writer.addAttribute(atts, PCTAttributeType.VARINFO.toString(),
				conditionItemMap.get(this.name).getSearchInfo().toString());
		writer.addAttribute(atts, PCTAttributeType.REF.toString(),
				conditionItemMap.get(this.name).toString());
		writer.dataElement(PCTElementType.VAR.toString(), atts, this.name);
	}

}
