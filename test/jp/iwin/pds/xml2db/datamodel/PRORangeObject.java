package jp.iwin.pds.xml2db.datamodel;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 範囲オブジェクト。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>
 *    <UL>
 *     <LI> 範囲型の値を保持するクラス。
 *     <LI> 属性値オブジェクトに格納されるクラス。
 *    </UL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1104 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 15:13:14 +0900 (轣ｫ, 07 12 2010) $
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
public class PRORangeObject {
	/**
	 * 下限値
	 */
	private Object min;
	/**
	 * 下限値含むフラグ
	 */
	private boolean includeMin;
	/**
	 * 上限値
	 */
	private Object max;
	/**
	 * 上限値含むフラグ
	 */
	private boolean includeMax;

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバー変数の値を設定することで、
	 * 外部からメンバー変数の値は変更できないようにする。
	 * @param min			下限値
	 * @param includeMin	下限値含むフラグ
	 * @param max			上限値
	 * @param includeMax	上限値含むフラグ
	 */
	public PRORangeObject(Object min, boolean includeMin, Object max,
			boolean includeMax) {
		this.min = min;
		this.includeMin = includeMin;
		this.max = max;
		this.includeMax = includeMax;
	}

	/**
	 * 下限値取得
	 * @return 下限値
	 */
	public Object getMin() {
		return min;
	}

	/**
	 * 下限値含むフラグ取得
	 * @return 下限値含むフラグ
	 */
	public boolean includeMin() {
		return includeMin;
	}

	/**
	 * 上限値取得
	 * @return 上限値
	 */
	public Object getMax() {
		return max;
	}

	/**
	 * 上限値含むフラグ取得
	 * @return 上限値含むフラグ
	 */
	public boolean includeMax() {
		return includeMax;
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
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.JAVADATATYPE.toString(),
				this.max.getClass().getName());
		writer.startElement(PCTElementType.RANGE.toString(), atts);

		AttributesImpl upperAtts = new AttributesImpl();
		writer.addAttribute(upperAtts, PCTAttributeType.EQ.toString(),
				Boolean.toString(this.includeMax));
		writer.dataElement(PCTElementType.UPPER.toString(), upperAtts,
				this.max.toString());

		AttributesImpl lowerAtts = new AttributesImpl();
		writer.addAttribute(lowerAtts, PCTAttributeType.EQ.toString(),
				Boolean.toString(this.includeMin));
		writer.dataElement(PCTElementType.LOWER.toString(), lowerAtts,
				this.min.toString());

		writer.endElement(PCTElementType.RANGE.toString());
	}

}
