package jp.escofi.emr.engine.search;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 範囲型オブジェクト。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>
 *    <UL>
 *     <LI> 範囲型の値を保持するクラス。
 *     <LI> 属性値オブジェクトに格納されるクラス。
 *    </UL>
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
public class RangeObject {

	/**
	 * 下限値有無フラグ
	 */
	private boolean hasLower;
	/**
	 * 下限値
	 */
	private Object lower;
	/**
	 * 下限値含むフラグ
	 */
	private boolean includeLower;
	/**
	 * 上限値有無フラグ
	 */
	private boolean hasUpper;
	/**
	 * 上限値
	 */
	private Object upper;
	/**
	 * 上限値含むフラグ
	 */
	private boolean includeUpper;
	/**
	 * Javaデータ型
	 */
	private String javaDataType;

	/**
	 * 下限値有無フラグ取得
	 * @return 下限値有無フラグ
	 */
	public boolean hasLower() {
		return hasLower;
	}

	/**
	 * 下限値取得
	 * @return 下限値
	 */
	public Object getLower() {
		return lower;
	}

	/**
	 * 下限値含むフラグ取得
	 * @return 下限値含むフラグ
	 */
	public boolean includeLower() {
		return includeLower;
	}

	/**
	 * 上限値有無フラグ取得
	 * @return 上限値有無フラグ
	 */
	public boolean hasUpper() {
		return hasUpper;
	}

	/**
	 * 上限値取得
	 * @return 上限値
	 */
	public Object getUpper() {
		return upper;
	}

	/**
	 * 上限値含むフラグ取得
	 * @return 上限値含むフラグ
	 */
	public boolean includeUpper() {
		return includeUpper;
	}

	/**
	 * 内部Javaデータ型取得
	 * @return 内部Javaデータ型
	 */
	public String getJavaDataType() {
		return javaDataType;
	}

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバー変数の値を設定することで、
	 * 外部からメンバー変数の値は変更できないようにする。
	 * @param hasLower 		下限値有無フラグ
	 * @param lower			下限値
	 * @param includeLower	下限値含むフラグ
	 * @param hasUpper 		上限値有無フラグ
	 * @param upper			上限値
	 * @param includeUpper	上限値含むフラグ
	 * @param javaDataType 	内部Javaデータ型
	 */
	public RangeObject(boolean hasLower, Object lower, boolean includeLower,
			boolean hasUpper, Object upper, boolean includeUpper, String javaDataType) {
		this.hasLower = hasLower;
		this.lower = lower;
		this.includeLower = includeLower;
		this.hasUpper = hasUpper;
		this.upper = upper;
		this.includeUpper = includeUpper;
		this.javaDataType = javaDataType;
	}

	/**
	 * 範囲型属性値書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>範囲型属性値を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	public void toDump(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.JAVA_DATA_TYPE.toString(),
				javaDataType);
		writer.startElement(ElementType.RANGE.toString(), atts);

		AttributesImpl upperAtts = new AttributesImpl();
		writer.addAttribute(upperAtts, AttributeType.EQ.toString(),
				Boolean.toString(includeUpper));
		if (upper == null) {
			writer.dataElement(ElementType.UPPER.toString(), upperAtts,
					"");
		} else {
			writer.dataElement(ElementType.UPPER.toString(), upperAtts,
					upper.toString());
		}

		AttributesImpl lowerAtts = new AttributesImpl();
		writer.addAttribute(lowerAtts, AttributeType.EQ.toString(),
				Boolean.toString(includeLower));
		if (lower == null) {
			writer.dataElement(ElementType.LOWER.toString(), lowerAtts,
					"");
		} else {
			writer.dataElement(ElementType.LOWER.toString(), lowerAtts,
					lower.toString());
		}
		writer.endElement(ElementType.RANGE.toString());
	}
}
