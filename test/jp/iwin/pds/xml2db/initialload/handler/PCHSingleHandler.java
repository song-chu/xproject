package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.XMLWriter;


/**
 * 単一型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値の属性タイプがSingleの場合、
 *単一データタイプのバリュー（{@code <single>}）以下の要素を制御するSAXのイベントハンドラー。
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PCHSingleHandler extends PCHARuleHandler {

	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType;
	/**
	 * タグ内容取得バッファ
	 */
	private StringBuilder buffer = new StringBuilder();


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSingleHandler(PCHConstHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer = writer;
	}

	/**
	 * コンストラクタ(内部Javaデータ型付き)。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param javadatatype 内部Javaデータ型
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHSingleHandler(PCHAResultObjectHandler callerHandler, String javadatatype) {

		super(callerHandler);

		this.javaDataType = javadatatype;
	}


	/**
	 * タグ内容処理。
	 * <p>
	 * 取得したタグ内容文字列をクラス変数：タグ内容取得バッファへ格納する。
	 * </p>
	 * @param ch 取得したタグ内容
	 * @param start 開始位置
	 * @param length 対象文字列長
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (this.buffer != null) {
			this.buffer.append(ch, start, length);
			this.writer.characters(ch, start, length);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが単一型の場合は、以下の処理を行う。
	 * </P>
	 * <UL>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーが属性値ハンドラー郡の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーに変換したタグ内容を設定する。</LI>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：内部Javaデータ型を設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>継承元クラス変数：呼出し元ハンドラーが条件式定数ハンドラーの場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>継承元クラス変数：呼出し元ハンドラーに取得したタグ内容を設定する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * <P>
	 * 上記の呼出し元ハンドラー毎の処理の後に、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.SINGLE.equals(qName)) {
			String str = this.buffer.toString();

			if (this.callerHandler instanceof PCHAResultObjectHandler) {
				PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;
				Object value = str;

				handler.setValue(value);
				handler.setJavaDataType(this.javaDataType);
			} else {
				this.writer.endElement(qName);
				((PCHConstHandler) this.callerHandler).setValue(str);
			}
			this.reader.setContentHandler(this.callerHandler);
			this.buffer = null;
		}
	}

}
