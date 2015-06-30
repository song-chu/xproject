package jp.iwin.pds.xml2db.datamodel;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * 条件判定 アクション。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1405 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-10 18:08:01 +0900 ( 10 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PROAction {

	/**
	 * 属性値オブジェクト
	 */
	private PROResultObject resultObject;

	/**
	 * 属性値オブジェクトをメンバー変数にセットする。
	 * @param resultObject 属性値オブジェクト
	 */
	public PROAction(PROResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * 属性値オブジェクトのゲッターメソッド。
	 * @return resultObject 属性値オブジェクト
	 */
	public PROResultObject getResultObject() {
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
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();

		writer.addAttribute(atts, PCTAttributeType.DATATYPE.toString(),
				this.resultObject.getDataType());
		writer.addAttribute(atts, PCTAttributeType.METAINFO.toString(),
				this.resultObject.getMetaInfo().toString());
		writer.addAttribute(atts, PCTAttributeType.DELFLG.toString(),
				Boolean.toString(this.resultObject.isDeleted()));
		writer.addAttribute(atts, PCTAttributeType.REF.toString(),
				this.toString());

		writer.startElement(PCTElementType.RESULT.toString(), atts);

		if (this.resultObject.getValue() == null) {
			writer.emptyElement(PCTElementType.EMPTY.toString());
		} else if (this.resultObject.getValue() instanceof List) {
			this.resultObject.toDumpList(writer);
		} else if (this.resultObject.getValue() instanceof Map) {
			this.resultObject.toDumpMap(writer);
		} else if (this.resultObject.getValue() instanceof PRORangeObject) {
			((PRORangeObject) this.resultObject.getValue()).toDump(writer);
		} else if (this.resultObject.getValue() instanceof PROObjObject) {
			((PROObjObject) this.resultObject.getValue()).toDump(writer);
		} else {
			this.resultObject.toDumpSingle(writer);
		}

		writer.endElement(PCTElementType.RESULT.toString());

	}
}
