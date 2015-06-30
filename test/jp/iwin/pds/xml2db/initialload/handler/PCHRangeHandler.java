package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PRORangeObject;

import org.xml.sax.Attributes;


/**
 * 範囲型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプが範囲型の場合、
 *範囲データタイプのバリュー（{@code <range>}）以下の要素を制御するSAXのイベントハンドラー。
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
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHRangeHandler extends PCHADelegateHandler {

	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType;
	/**
	 * 上限値含むフラグ
	 */
	private boolean includeUpper = false;
	/**
	 * 下限値含むフラグ
	 */
	private boolean includeLower = false;
	/**
	 * 上限値
	 */
	private Object upper = null;
	/**
	 * 下限値
	 */
	private Object lower = null;
	/**
	 * タグ内容取得バッファ
	 */
	private StringBuilder buffer = null;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param javaDataType 内部Javaデータ型
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHRangeHandler(PCHAResultObjectHandler callerHandler, String javaDataType) {

		super(callerHandler);

		this.javaDataType = javaDataType;
	}

	/**
	 * タグ開始処理。
	 * <P>
	 * 対象タグが上限値の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：上限値含むフラグにアトリビュート情報の含むフラグの値を保持する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファを新規StringBuilderで初期化する。</LI>
	 * </OL>
	 * <P>
	 * 対象タグが下限値の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：下限値含むフラグにアトリビュート情報の含むフラグの値を保持する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファを新規StringBuilderで初期化する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			this.includeUpper = Boolean.valueOf(
					atts.getValue(PCTAttributeType.EQ.toString()));
			this.buffer = new StringBuilder();
			break;

		case LOWER:
			this.includeLower = Boolean.valueOf(
					atts.getValue(PCTAttributeType.EQ.toString()));
			this.buffer = new StringBuilder();
			break;
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
	 * 対象タグが上限値の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：上限値に変換したタグ内容を追加する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * <P>
	 * 対象タグが下限値の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：下限値に変換したタグ内容を追加する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * <P>
	 * 対象タグが範囲型の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに編集した範囲情報を設定する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：内部Javaデータ型を設定する。</LI>
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
		case UPPER:
			this.upper = this.buffer.toString().intern();
			this.buffer = null;
			break;

		case LOWER:
			this.lower = this.buffer.toString().intern();
			this.buffer = null;
			break;

		case RANGE:
			PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;
			PRORangeObject rangeObject = new PRORangeObject(this.lower,
					this.includeLower, this.upper, this.includeUpper);

			handler.setValue(rangeObject);
			handler.setJavaDataType(this.javaDataType);
			this.reader.setContentHandler(handler);
			break;
		}
	}

}
