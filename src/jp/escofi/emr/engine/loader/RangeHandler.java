package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.search.RangeObject;

import org.xml.sax.Attributes;

/**
 * 範囲型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプが範囲型の場合、
 *範囲データタイプのバリュー（{@code <range>}）以下の要素を制御するSAXのイベントハンドラー。
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
public final class RangeHandler extends AbstractDelegateHandler {

	/**
	 * 下限値有無フラグ
	 */
	private boolean hasLower = false;
	/**
	 * 下限値
	 */
	private Object lower = null;
	/**
	 * 下限値含むフラグ
	 */
	private boolean includeLower = false;
	/**
	 * 上限値有無フラグ
	 */
	private boolean hasUpper = false;
	/**
	 * 上限値
	 */
	private Object upper = null;
	/**
	 * 上限値含むフラグ
	 */
	private boolean includeUpper = false;
	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType;
	/**
	 * タグ内容取得バッファ
	 */
	private StringBuilder buffer = null;

	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param javaDataType 内部Javaデータ型
	 */
	public RangeHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {

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
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			includeUpper = ConvertUtil.isConvertBoolean(
					atts.getValue(AttributeType.EQ.toString()));
			buffer = new StringBuilder();
			break;

		case LOWER:
			includeLower = ConvertUtil.isConvertBoolean(
					atts.getValue(AttributeType.EQ.toString()));
			buffer = new StringBuilder();
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

		if (buffer != null) {
			buffer.append(ch, start, length);
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
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			if ("".equals(buffer.toString().trim())) {
				upper = null;
			} else {
				hasUpper = true;
				upper = ConvertUtil.convert(
						buffer.toString(), javaDataType);
			}
			buffer = null;
			break;

		case LOWER:
			if ("".equals(buffer.toString().trim())) {
				lower = null;
			} else {
				hasLower = true;
				lower = ConvertUtil.convert(
						buffer.toString(), javaDataType);
			}
			buffer = null;
			break;

		case RANGE:
			AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;
			RangeObject rangeObject = new RangeObject(hasLower, lower,
					includeLower, hasUpper, upper, includeUpper, javaDataType);

			handler.setValue(rangeObject);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			break;
		}
	}

}
