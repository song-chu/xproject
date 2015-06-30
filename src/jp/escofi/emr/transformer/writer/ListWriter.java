package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;


/**
 * リスト型ライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがリストの場合、
 *リストデータタイプのバリュー（{@code <list>}）以下の要素を出力するXMLライター。
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
public final class ListWriter extends AbstractAttributeValueWriter {


	/**
	 * コンストラクタでXMLタグ名を初期化する。
	 */
	public ListWriter() {
		super(ElementType.LIST);
	}


	/**
	 * タグ内容部分出力処理。
	 * <OL>
	 * <LI>継承元クラス変数：タグ内容を配列化する。</LI>
	 * <LI>配列の項目数分、配列項目を{@code <elem>}で出力する。</LI>
	 * </OL>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	@Override
	protected void outputBody(XMLWriter writer) throws SAXException {
		String elementName = ElementType.ELEM.toString();
		List<String> tmp = split(value);

		for (String val : tmp) {
			writer.dataElement(elementName, val);
		}
	}

}
