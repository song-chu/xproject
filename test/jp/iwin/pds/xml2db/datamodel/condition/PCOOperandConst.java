package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;

/**
 * オペランド定数部クラス。
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
public final class PCOOperandConst extends PCOAOperand {

	/**
	 * メンバー変数に引数の値を設定する。
	 * @param value 定数の値
	 */
	public PCOOperandConst(Object value) {
		this.value = value;
	}

	/**
	 * オペランド定数部を書き出す。
	 *
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	@SuppressWarnings("unchecked")
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		writer.startElement(PCTElementType.CONST.toString());
		if (this.value instanceof Set) {
			writer.startElement(PCTElementType.SET.toString());
			List<Object> list = PUTConvertUtil
					.sortSet((Set<Object>) this.value);
			for (Object elem : list) {
				writer.dataElement(PCTElementType.ELEM.toString(),
						elem.toString());
			}
			writer.endElement(PCTElementType.SET.toString());
		} else {
			writer.dataElement(PCTElementType.SINGLE.toString(),
					this.value.toString());
		}
		writer.endElement(PCTElementType.CONST.toString());
	}
}
