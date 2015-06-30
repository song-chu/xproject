package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * マップ型ライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがマップの場合、
 *マップデータタイプのバリュー（{@code <map>}）以下の要素を出力するXMLライター。
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
public final class MapWriter extends AbstractAttributeValueWriter {

	/**
	 * キー項目
	 */
	private String key;


	/**
	 * コンストラクタでXMLタグ名を初期化する。
	 */
	public MapWriter() {
		super(ElementType.MAP);
	}


	/**
	 * @param key キー項目
	 */
	public void setKey(String key) {
		this.key = key;
	}


	/**
	 * タグ内容部分出力処理。
	 * <OL>
	 * <LI>クラス変数：キー項目を配列化する。({@code <entry>}のkeyアトリビュート)</LI>
	 * <LI>継承元クラス変数：タグ内容を配列化する。({@code <entry>}のタグ内容)</LI>
	 * <LI>キー項目配列の項目数とタグ内容配列の項目数で差分がある場合は、
	 *XML出力例外を生成・throwする。</LI>
	 * <LI>キー項目配列の項目数分、配列項目を{@code <entry>}で出力する。</LI>
	 * </OL>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	@Override
	protected void outputBody(XMLWriter writer) throws SAXException {
		String elementName = ElementType.ENTRY.toString();
		String attName = AttributeType.KEY.toString();
		String empty = PDSConstants.EMPTY.toString();
		List<String> tmpKeys = split(key);
		List<String> tmpVals = split(value);
		AttributesImpl atts = new AttributesImpl();

		if (tmpKeys.size() != tmpVals.size()) {
			throw new SAXException(new EMRException(MessageCode.EMR_B_P910E));
		}

		// アトリビュート情報のキー項目を初期化
		atts.addAttribute(empty, attName, attName, PDSConstants.CDATA.toString(), empty);

		for (int i = 0; i < tmpKeys.size(); i++) {
			atts.setValue(0, tmpKeys.get(i));
			writer.dataElement(elementName, atts, tmpVals.get(i));
		}
	}

}
