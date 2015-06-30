package jp.iwin.pds.xml2db.datamodel;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 実行オブジェクト。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>
 *    <UL>
 *     <LI> 実行型の値を保持するクラス。
 *     <LI> 属性値オブジェクトに格納されるクラス。
 *    </UL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1047 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:49:56 +0900 (轣ｫ, 07 12 2010) $
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
 * @author $Author: seo.yi $
 */
public class PROObjObject {
	/**
	 * 実行オブジェクト名
	 */
	private String className;
	/**
	 * 付帯情報
	 */
	private String attachedInfo;

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバ変数の値を設定することで
	 * 外部からメンバ変数の値は変更できないようにする。
	 * @param className		実行オブジェクト名
	 * @param attachedInfo	付帯情報
	 */
	public PROObjObject(String className, String attachedInfo) {
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
	public String getAttachedInfo() {
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
	protected void toDump(PUTXMLWriter witer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		witer.addAttribute(atts, PCTAttributeType.CLASSNAME.toString(),
				this.className);
		witer.addAttribute(atts, PCTAttributeType.SUBINFO.toString(),
				this.attachedInfo);
		witer.emptyElement(PCTElementType.OBJECT.toString(), atts);
	}
}
