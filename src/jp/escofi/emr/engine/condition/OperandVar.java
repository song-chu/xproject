package jp.escofi.emr.engine.condition;

import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * オペランド変数部クラス。
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
public final class OperandVar extends AbstractOperand {

	/**
	 * 変数（引数項目）名
	 */
	private String name;

	/**
	 * 引数項目名のセッターメソッド。
	 * @param name 変数（引数項目）名
	 */
	public OperandVar(String name) {
		this.name = name;
	}

	/**
	 * 引数項目名のゲッターメソッド。
	 * @return 変数（引数項目）名
	 */
	protected String getName() {
		return name;
	}

	/**
	 * オペランド変数部を書き出す。
	 *
	 * @param writer ライター
	 * @param conditionItemMap 引数項目マップ
	 * @throws SAXException XML解析エラー
	 */
	protected void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.DATA_TYPE.toString(),
				conditionItemMap.get(name).getItemType());
		writer.addAttribute(atts, AttributeType.JAVA_DATA_TYPE.toString(),
				conditionItemMap.get(name).getJavaDataType());
		writer.addAttribute(atts, AttributeType.VAR_INFO.toString(),
				ConvertUtil.toCsvString(conditionItemMap.get(name).getSearchInfo()));
		writer.addAttribute(atts, AttributeType.REF.toString(),
				conditionItemMap.get(name).toString());
		writer.dataElement(ElementType.VAR.toString(), atts, name);
	}

}
