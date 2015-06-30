package jp.iwin.pds.xml2db.initialload.handler;

import java.util.HashSet;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;

import org.xml.sax.Attributes;


/**
 * セットハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>引数項目のデータタイプがSetの場合、定数部（ｃonst）のSet（{@code <set>}）要素を制御するSAXのイベントハンドラー。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1059 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHSetHandler extends PCHARuleHandler {

	/**
	 * 属性値セット
	 */
	private Set<String> set = new HashSet<String>();
	/**
	 * タグ内容取得バッファ
	 */
	private StringBuilder buffer = null;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSetHandler(PCHConstHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer= writer;
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * 対象タグがエレメントの場合は、クラス変数：タグ内容取得バッファを新規StringBuilderで初期化する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (PCTElementType.ELEM.equals(qName)) {
			this.buffer = new StringBuilder();
		}else{
			this.writer.startElement(qName, atts);
		}
	}

	/**
	 * タグ内容処理。
	 * <P>
	 * 取得したタグ内容文字列をクラス変数：タグ内容取得バッファへ格納する。
	 * </P>
	 * @param ch 取得したタグ内容
	 * @param start 開始位置
	 * @param length 対象文字列長
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (this.buffer != null) {
			this.buffer.append(ch, start, length);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグがエレメントの場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：属性値セットに、文字列化したクラス変数：タグ内容取得バッファを追加する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * <P>
	 * 対象タグがセットの場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：属性値セットを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case ELEM:

			String str = this.buffer.toString().intern();
			this.writer.dataElement(qName, str);
			this.set.add(str);
			this.buffer = null;
			break;

		case SET:
			this.writer.endElement(qName);
			((PCHConstHandler)this.callerHandler).setValue(this.set);
			this.reader.setContentHandler(this.callerHandler);
			break;
		}
	}
}
