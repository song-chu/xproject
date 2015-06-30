package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;

import org.xml.sax.Attributes;


/**
 * リスト型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがListの場合、
 *Listデータタイプのバリュー（{@code <list>}）以下の要素を制御するSAXのイベントハンドラー。
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
public final class ListHandler extends AbstractDelegateHandler {

	/**
	 * 編集リスト
	 */
	private ArrayList<Object> tempList = new ArrayList<Object>();
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
	public ListHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {
		super(callerHandler);
		this.javaDataType = javaDataType;
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

		if (ElementType.ELEM.toString().equals(qName)) {
			buffer = new StringBuilder();
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
	 * 対象タグがエレメントの場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：編集リストに変換したタグ内容を追加する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * <P>
	 * 対象タグがリストの場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに編集したリストを設定する。</LI>
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

		switch(elementType) {
		case ELEM:

			tempList.add(ConvertUtil.convert(buffer.toString(),
					javaDataType));
			buffer = null;
			break;

		case LIST:
			tempList.trimToSize();

			List<Object> list = Collections.unmodifiableList(tempList);
			AbstractResultObjectHandler handler =
				(AbstractResultObjectHandler) callerHandler;

			handler.setValue(list);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			tempList = null;
			break;
		}
	}

}
