package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * 範囲型ライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプが範囲の場合、
 *範囲データタイプのバリュー（{@code <range>}）以下の要素を出力するXMLライター。
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
public final class RangeWriter extends AbstractAttributeValueWriter {

	/**
	 * 上限値
	 */
	private String upper;
	/**
	 * 上限値含むフラグ
	 */
	private boolean upperFlg;
	/**
	 * 下限値
	 */
	private String lower;
	/**
	 * 下限値含むフラグ
	 */
	private boolean lowerFlg;


	/**
	 * コンストラクタでXMLタグ名を初期化する。
	 */
	public RangeWriter() {
		super(ElementType.RANGE);
	}


	/**
	 * @param upper セットする upper
	 */
	public void setUpper(String upper) {
		this.upper = upper;
	}
	/**
	 * @param upperFlg セットする upperFlg
	 */
	public void setUpperFlg(String upperFlg) {
		this.upperFlg = PDSConstants.TRUE.isEquals(upperFlg);
	}
	/**
	 * @param lower セットする lower
	 */
	public void setLower(String lower) {
		this.lower = lower;
	}
	/**
	 * @param lowerFlg セットする lowerFlg
	 */
	public void setLowerFlg(String lowerFlg) {
		this.lowerFlg = PDSConstants.TRUE.isEquals(lowerFlg);
	}


	/**
	 * タグ内容部分出力処理。
	 * <OL>
	 * <LI>upperタグ書き込み</LI>
	 * <LI>lowerタグ書き込み</LI>
	 * </OL>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	@Override
	protected void outputBody(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		String attName = AttributeType.EQ.toString();
		String elementName;

		// upperタグ書き込み
		elementName = ElementType.UPPER.toString();

		// アトリビュート情報のキー項目を初期化
		atts.addAttribute(PDSConstants.EMPTY.toString(), attName, attName,
				PDSConstants.CDATA.toString(), String.valueOf(upperFlg));

		writer.dataElement(elementName, atts, upper);

		// lowerタグ書き込み
		elementName = ElementType.LOWER.toString();

		atts.setValue(0, String.valueOf(lowerFlg));

		writer.dataElement(elementName, atts, lower);
	}

}
