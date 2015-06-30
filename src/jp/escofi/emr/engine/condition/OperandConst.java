package jp.escofi.emr.engine.condition;

import java.util.Set;

import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;

/**
 * オペランド定数部クラス。
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
public final class OperandConst extends AbstractOperand {

	/**
	 * データ型
	 */
	private DataType dataType;
	/**
	 * 変換前属性値（単一値）
	 */
	private String strValue;
	/**
	 * 変換前属性値（セット）
	 */
	private Set<String> strSetValue;


	/**
	 * メンバー変数に引数の値を設定する。
	 * @param value 定数の値
	 */
	public OperandConst(String value) {
		dataType = DataType.SINGLE;
		strValue = value;
	}
	/**
	 * メンバー変数に引数の値を設定する。
	 * @param value 定数の値
	 */
	public OperandConst(Set<String> value) {
		dataType = DataType.SET;
		strSetValue = value;
	}


	/**
	 * @return データ型
	 */
	public DataType getDataType() {
		return dataType;
	}
	/**
	 * @return 変換前属性値（単一値）
	 */
	public String getStrValue() {
		return strValue;
	}
	/**
	 * @return 変換前属性値（セット）
	 */
	public Set<String> getStrSetValue() {
		return strSetValue;
	}


	/**
	 * オペランド定数部を書き出す。
	 *
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	protected void toDump(XMLWriter writer) throws SAXException {
		writer.startElement(ElementType.CONST.toString());

		if (DataType.SET == dataType) {
			String sName = ElementType.SET.toString();
			String eName = ElementType.ELEM.toString();

			writer.startElement(sName);

			for (String elem : strSetValue) {
				writer.dataElement(eName, elem);
			}
			writer.endElement(sName);
		} else {
			writer.dataElement(ElementType.SINGLE.toString(),
					strValue.toString());
		}
		writer.endElement(ElementType.CONST.toString());
	}

}
