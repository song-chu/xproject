package jp.escofi.emr.transformer.writer;

import java.util.LinkedHashSet;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 親XMLライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>XMLタグ出力処理の共通部分を定義する。
 *   <DD>条件文ライターで、
 *DBから取得したXML条件文を解析してパラメータ等を取得する処理が必要な為、
 *SAXのDefaultHandlerを継承している。
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
public abstract class AbstractXmlWriter extends DefaultHandler {

	/**
	 * 出力タグ種別。
	 */
	protected ElementType elementType;
	/**
	 * アトリビュート情報。
	 */
	protected AttributesImpl atts = new AttributesImpl();
	/**
	 * 子タグセット。
	 */
	protected Set<AbstractXmlWriter> childSet = new LinkedHashSet<AbstractXmlWriter>();
	/**
	 * タグ内容。
	 */
	protected String value = PDSConstants.EMPTY.toString();
	/**
	 * 終了タグなし。
	 * <P>
	 * true:終了タグなし形式、false:開始･終了タグ形式。<BR>
	 * 通常は開始･終了タグ形式で出力する。終了タグなし形式で出力する場合は、
	 *サブクラス側のコンストラクタで、この値をtrueにする。
	 * </P>
	 */
	protected boolean isEmptyElement = false;


	/**
	 * コンストラクタ。
	 * <P>
	 * コンストラクタでXMLタグ名を初期化する。
	 * </P>
	 * @param elementType 出力タグ種別
	 */
	protected AbstractXmlWriter(ElementType elementType) {
		this.elementType = elementType;
	}

	/**
	 * @param value タグ内容
	 */
	public final void setValue(String value) {
		this.value = value;
	}


	/**
	 * アトリビュート追加処理。
	 * <P>
	 * アトリビュート情報にアトリビュートを追加する。<BR>
	 * アトリビュート情報に書込むアトリビュート値のデータタイプはCDATA。
	 * </P>
	 * @param attribute アトリビュートタイプ定義
	 * @param value アトリビュート値
	 */
	protected final void addAttribute(AttributeType attribute, String value) {

		if (value == null) {
			return;
		}
		String attName = attribute.toString();

		atts.addAttribute(PDSConstants.EMPTY.toString(), attName,
				attName, PDSConstants.CDATA.toString(), value);
	}

	/**
	 * アトリビュート設定処理。
	 * <P>
	 * 指定したアトリビュート情報を設定する。<BR>
	 * 新規アトリビュートの場合はアトリビュート情報に追加する。<BR>
	 * アトリビュート情報に書込むアトリビュート値のデータタイプはCDATA。
	 * </P>
	 * @param attribute アトリビュートタイプ定義
	 * @param value アトリビュート値
	 */
	protected final void setAttribute(AttributeType attribute, String value) {

		if (value == null) {
			return;
		}
		String attName = attribute.toString();
		int index = atts.getIndex(attName);

		if (-1 < index) {
			atts.setAttribute(index, PDSConstants.EMPTY.toString(), attName,
					attName, PDSConstants.CDATA.toString(), value);
		} else {
			addAttribute(attribute, value);
		}
	}

	/**
	 * アトリビュート値取得。
	 *
	 * @param attribute 取得するアトリビュートタイプ定義
	 * @return 取得するアトリビュートの値
	 */
	protected final String getAttribute(AttributeType attribute) {
		String attName = attribute.toString();

		return atts.getValue(attName);
	}

	/**
	 * アトリビュート削除処理。
	 * <P>
	 * アトリビュート情報からアトリビュートを削除する。<BR>
	 * 既に削除済みの場合は何もしない。
	 * </P>
	 * @param attribute 削除するアトリビュートタイプ定義
	 */
	protected final void removeAttribute(AttributeType attribute) {
		String attName = attribute.toString();
		int index = atts.getIndex(attName);

		if (-1 < index) {
			atts.removeAttribute(index);
		}
	}

	/**
	 * タグ開始部分出力処理。
	 * <P>
	 * タグ開始部分を出力する。<BR>
	 * その他に処理が必要な場合は、このメソッドをオーバライドする。
	 * </P>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	protected void startElement(XMLWriter writer) throws SAXException {
		String elementName = elementType.toString();

		if (isEmptyElement) {
			writer.emptyElement(elementName, atts);
		} else {
			writer.startElement(elementName, atts);
		}
	}

	/**
	 * タグ内容部分出力処理。
	 * <P>
	 * 子タグセットに格納されたハンドラーのタグ内容部分出力処理を実行する。<BR>
	 * 子タグセットが空の場合は、タグ内容を出力する。<BR>
	 * その他に処理が必要な場合は、このメソッドをオーバライドする。
	 * </P>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	protected void outputBody(XMLWriter writer) throws SAXException {

		if (!isEmptyElement) {

			if (childSet.isEmpty()) {
				writer.characters(value);
			} else {

				for (AbstractXmlWriter child : childSet) {
					child.write(writer);
				}
			}
		}
	}

	/**
	 * タグ終了部分出力処理。
	 * <P>
	 * タグ終了部分を出力する。<BR>
	 * その他に処理が必要な場合は、このメソッドをオーバライドする。
	 * </P>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	protected void endElement(XMLWriter writer) throws SAXException {

		if (!isEmptyElement) {
			writer.endElement(elementType.toString());
		}
	}


	/**
	 * XMLタグ出力処理。
	 * <OL>
	 *  <LI>タグ開始部分出力処理</LI>
	 *  <LI>タグ内容部分出力処理</LI>
	 *  <LI>タグ終了部分出力処理</LI>
	 *  <LI>子タグ情報クリア処理</LI>
	 * </OL>
	 * <P>
	 * タグ独自の出力処理が必要な場合は、このメソッドをオーバライドする。
	 * </P>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	void write(XMLWriter writer) throws SAXException {
		startElement(writer);
		outputBody(writer);
		endElement(writer);
		childSet = null;
	}

}
