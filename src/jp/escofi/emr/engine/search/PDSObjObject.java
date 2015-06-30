package jp.escofi.emr.engine.search;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * オブジェクト型オブジェクト。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>
 *    <UL>
 *     <LI> オブジェクトの値を保持するクラス。
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
public class PDSObjObject {
	/**
	 * 実行オブジェクト名
	 */
	private String className;
	/**
	 * 付帯情報
	 */
	private List<String> attachedInfo;

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバ変数の値を設定することで
	 * 外部からメンバ変数の値は変更できないようにする。
	 * @param className		実行オブジェクト名
	 * @param attachedInfo	付帯情報
	 */
	public PDSObjObject(String className, List<String> attachedInfo) {
		this.className = className;
		this.attachedInfo = attachedInfo;
	}

	/**
	 * 実行オブジェクト名取得
	 * @return 実行オブジェクト名
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 付帯情報取得
	 * @return 付帯情報
	 */
	public List<String> getAttachedInfo() {
		return attachedInfo;
	}

	/**
	 * オブジェクト型属性値書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>オブジェクト型属性値を書き出す。
	 * </DL>
	 * @param writer ライター
	 * @throws SAXException XML解析エラー
	 */
	public void toDump(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.CLASS_NAME.toString(),
				className);
		writer.addAttribute(atts, AttributeType.SUB_INFO.toString(),
				ConvertUtil.toCsvString(attachedInfo));
		writer.emptyElement(ElementType.OBJECT.toString(), atts);
	}
}
