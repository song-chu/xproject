package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.PDSObjObject;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * 条件判定 アクション。
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
public class AbstractAction {

	/**
	 * 属性値オブジェクト
	 */
	private ResultObject resultObject;

	/**
	 * 属性値オブジェクトをメンバー変数にセットする。
	 * @param resultObject 属性値オブジェクト
	 */
	public AbstractAction(ResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * 属性値オブジェクトのゲッターメソッド。
	 * @return resultObject 属性値オブジェクト
	 */
	public ResultObject getResultObject() {
		return resultObject;
	}

	/**
	 * 結果オブジェクト書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>結果オブジェクトを書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	protected void toDump(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();

		writer.addAttribute(atts, AttributeType.DATA_TYPE.toString(),
				resultObject.getDataType());
		writer.addAttribute(atts, AttributeType.META_INFO.toString(),
				resultObject.getMetaInfo().toString());
		writer.addAttribute(atts, AttributeType.DEL_FLG.toString(),
				Boolean.toString(resultObject.isDeleted()));
		writer.addAttribute(atts, AttributeType.REF.toString(),
				toString());

		writer.startElement(ElementType.RESULT.toString(), atts);

		if (resultObject.getValue() == null) {
			writer.emptyElement(ElementType.EMPTY.toString());
		} else if (resultObject.getValue() instanceof List) {
			resultObject.toDumpList(writer);
		} else if (resultObject.getValue() instanceof Map) {
			resultObject.toDumpMap(writer);
		} else if (resultObject.getValue() instanceof RangeObject) {
			((RangeObject) resultObject.getValue()).toDump(writer);
		} else if (resultObject.getValue() instanceof PDSObjObject) {
			((PDSObjObject) resultObject.getValue()).toDump(writer);
		} else {
			resultObject.toDumpSingle(writer);
		}

		writer.endElement(ElementType.RESULT.toString());

	}
}
