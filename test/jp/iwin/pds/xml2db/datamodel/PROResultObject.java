package jp.iwin.pds.xml2db.datamodel;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 属性値オブジェクト。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1768 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-17 13:15:18 +0900 (驥17 12 2010) $
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
 * @author $Author: park.js $
 */
public final class PROResultObject{

	/**
	 * 結果値<br>
	 * 単一値、List、Map、範囲オブジェクト、実行オブジェクト
	 */
	private Object value;

	/**
	 * データ型
	 */
	private String dataType;

	/**
	 * 内部データ型
	 */
	private String javaDataType;

	/**
	 * 削除フラグ
	 */
	private boolean delflg;

	/**
	 * メタ情報
	 */
	private String metaInfo;

	private String jpname;

	public String getJpname() {
		return jpname;
	}

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバー変数の値を設定することで、
	 * 外部からメンバー変数の値は変更できないようにする。
	 * @param value				結果値
	 * @param dataType			データ型
	 * @param javaDataType		内部データ型
	 * @param delflg			削除フラグ
	 * @param metaInfo			メタ情報
	 */
	public PROResultObject(Object value, String dataType,
			String javaDataType, boolean delflg, String metaInfo, String jpname) {
		this.value = value;
		this.dataType = dataType;
		this.javaDataType = javaDataType;
		this.delflg = delflg;
		this.metaInfo = metaInfo;
		this.jpname= jpname;

	}

	/**
	 * データ型取得
	 * @return	データ型
	 */
	public String getDataType() {
		return this.dataType;
	}

	/**
	 * 結果値取得
	 * @return	結果値
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * 内部データ型取得
	 * @return 内部データ型
	 */
	public String getJavaDataType() {
		return javaDataType;
	}

	/**
	 * 削除フラグ取得
	 * @return delflg	削除フラグ
	 */
	public boolean isDeleted() {
		return delflg;
	}

	/**
	 * メタ情報取得
	 * @return metaInfo	メタ情報
	 */
	public String getMetaInfo() {
		return metaInfo;
	}

	/**
	 * 属性値オブジェクト書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>属性値オブジェクトを書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	public void toDump(PUTXMLWriter writer) throws SAXException {

		AttributesImpl atts = new AttributesImpl();
		if (this.value instanceof PRORule) {
			writer.addAttribute(atts, PCTAttributeType.CONDFLG.toString(),
					Boolean.TRUE.toString());
		} else if (this.delflg) {
			writer.addAttribute(atts, PCTAttributeType.CONDFLG.toString(), "");
		} else {
			writer.addAttribute(atts, PCTAttributeType.CONDFLG.toString(),
					Boolean.FALSE.toString());
		}
		writer.addAttribute(atts, PCTAttributeType.DATATYPE.toString(),
				this.dataType);
		writer.addAttribute(atts, PCTAttributeType.METAINFO.toString(),
				this.metaInfo.toString());
		writer.addAttribute(atts, PCTAttributeType.DELFLG.toString(),
				Boolean.toString(this.delflg));
		writer.addAttribute(atts, PCTAttributeType.REF.toString(),
				this.toString());

		writer.startElement(PCTElementType.VALUE.toString(), atts);


		if (this.value == null) {
			writer.emptyElement(PCTElementType.EMPTY.toString());
		}else if (this.value instanceof PRORule) {
			((PRORule) this.value).toDump(writer);
		} else if (this.value instanceof List) {
			toDumpList(writer);
		} else if (this.value instanceof Map) {
			toDumpMap(writer);
		} else if (this.value instanceof PRORangeObject) {
			((PRORangeObject) this.value).toDump(writer);
		} else if (this.value instanceof PROObjObject) {
			((PROObjObject) this.value).toDump(writer);
		} else {
			toDumpSingle(writer);
		}

		writer.endElement(PCTElementType.VALUE.toString());

	}

	/**
	 * 内部データタイプアトリビュート生成
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>内部データタイプアトリビュート生成する。
	 * </DL>
	 * @param writer ライター
	 * @param value アトリビュートの値
	 * @return Attributes アトリビュート
	 */
	private Attributes makeJavaDataTypeAttr(PUTXMLWriter writer, String value){
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts,PCTAttributeType.JAVADATATYPE.toString(),value);
		return atts;
	}


	/**
	 * 単一属性値書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>単一属性値を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	protected void toDumpSingle(PUTXMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);
		writer.dataElement(PCTElementType.SINGLE.toString(),atts,this.value.toString());
	}

	/**
	 * List型属性値書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>List型属性値を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	@SuppressWarnings("unchecked")
	protected void toDumpList(PUTXMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(PCTElementType.LIST.toString(),atts);

		List<Object> list = (List<Object>) this.value;
		for(Object obj: list){
			writer.dataElement(PCTElementType.ELEM.toString(),obj.toString());
		}
		writer.endElement(PCTElementType.LIST.toString());
	}

	/**
	 * Map型属性値書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>Map型属性値を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	@SuppressWarnings("unchecked")
	protected void toDumpMap(PUTXMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(PCTElementType.MAP.toString(),atts);

		Map<String,Object> map = (Map<String, Object>) this.value;
		List<Map.Entry<String, Object>> entries = PUTConvertUtil.sortMap(map);
		for (Map.Entry<String, Object> entry : entries){
			AttributesImpl entryAtts = new AttributesImpl();
			writer.addAttribute(entryAtts,PCTAttributeType.KEY.toString(), entry.getKey());
			writer.dataElement(PCTElementType.ENTRY.toString(),entryAtts,entry.getValue().toString());
		}
		writer.endElement(PCTElementType.MAP.toString());
	}
}
