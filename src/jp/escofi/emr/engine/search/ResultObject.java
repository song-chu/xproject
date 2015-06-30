package jp.escofi.emr.engine.search;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.condition.RuleInstance;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 属性値オブジェクト。
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
public final class ResultObject{

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
	private boolean delFlg;

	/**
	 * メタ情報
	 */
	private String metaInfo;

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバー変数の値を設定することで、
	 * 外部からメンバー変数の値は変更できないようにする。
	 * @param value				結果値
	 * @param dataType			データ型
	 * @param javaDataType		内部データ型
	 * @param delFlg			削除フラグ
	 * @param metaInfo			メタ情報
	 */
	public ResultObject(Object value, String dataType,
			String javaDataType, boolean delFlg, String metaInfo) {
		this.value = value;
		this.dataType = dataType;
		this.javaDataType = javaDataType;
		this.delFlg = delFlg;
		this.metaInfo = metaInfo;
	}

	/**
	 * データ型取得
	 * @return	データ型
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * 結果値取得
	 * @return	結果値
	 */
	public Object getValue() {
		return value;
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
		return delFlg;
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
	public void toDump(XMLWriter writer) throws SAXException {

		AttributesImpl atts = new AttributesImpl();
		if (value instanceof RuleInstance) {
			writer.addAttribute(atts, AttributeType.COND_FLG.toString(),
					Boolean.TRUE.toString());
		} else if (delFlg) {
			writer.addAttribute(atts, AttributeType.COND_FLG.toString(), "");
		} else {
			writer.addAttribute(atts, AttributeType.COND_FLG.toString(),
					Boolean.FALSE.toString());
		}
		writer.addAttribute(atts, AttributeType.DATA_TYPE.toString(),
				dataType);
		writer.addAttribute(atts, AttributeType.META_INFO.toString(),
				metaInfo.toString());
		writer.addAttribute(atts, AttributeType.DEL_FLG.toString(),
				Boolean.toString(delFlg));
		writer.addAttribute(atts, AttributeType.REF.toString(),
				toString());

		writer.startElement(ElementType.VALUE.toString(), atts);


		if (value == null) {
			writer.emptyElement(ElementType.EMPTY.toString());
		}else if (value instanceof RuleInstance) {
			((RuleInstance) value).toDump(writer);
		} else if (value instanceof List) {
			toDumpList(writer);
		} else if (value instanceof Map) {
			toDumpMap(writer);
		} else if (value instanceof RangeObject) {
			((RangeObject) value).toDump(writer);
		} else if (value instanceof PDSObjObject) {
			((PDSObjObject) value).toDump(writer);
		} else {
			toDumpSingle(writer);
		}

		writer.endElement(ElementType.VALUE.toString());

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
	private Attributes makeJavaDataTypeAttr(XMLWriter writer, String value){
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts,AttributeType.JAVA_DATA_TYPE.toString(),value);
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
	public void toDumpSingle(XMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);
		writer.dataElement(ElementType.SINGLE.toString(),atts,value.toString());
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
	public void toDumpList(XMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(ElementType.LIST.toString(),atts);

		List<Object> list = (List<Object>) value;
		for(Object obj: list){
			writer.dataElement(ElementType.ELEM.toString(),obj.toString());
		}
		writer.endElement(ElementType.LIST.toString());
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
	public void toDumpMap(XMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(ElementType.MAP.toString(),atts);

		Map<String,Object> map = (Map<String, Object>) value;
		List<Map.Entry<String, Object>> entries = ConvertUtil.sortMap(map);
		for (Map.Entry<String, Object> entry : entries){
			AttributesImpl entryAtts = new AttributesImpl();
			writer.addAttribute(entryAtts,AttributeType.KEY.toString(), entry.getKey());
			writer.dataElement(ElementType.ENTRY.toString(),entryAtts,entry.getValue().toString());
		}
		writer.endElement(ElementType.MAP.toString());
	}
}
