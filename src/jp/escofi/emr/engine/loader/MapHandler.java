package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;

import org.xml.sax.Attributes;


/**
 * マップ型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがMapの場合、
 *Mapデータタイプのバリュー（{@code <map>}）以下の要素を制御するSAXのイベントハンドラー。
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
public final class MapHandler extends AbstractDelegateHandler {

	/**
	 * 編集マップ
	 */
	private Map<String, Object> tempMap = new HashMap<String, Object>();
	/**
	 * マップキー
	 */
	private String mapKey;
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
	public MapHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {
		super(callerHandler);
		this.javaDataType = javaDataType;
	}

	/**
	 * タグ開始処理。
	 * <P>
	 * 対象タグがエントリーの場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>クラス変数：マップキーにアトリビュート情報のマップキーの値を保持する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファを新規StringBuilderで初期化する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (ElementType.ENTRY.toString().equals(qName)) {
			mapKey = atts.getValue(AttributeType.KEY.toString()).intern();
			buffer = new StringBuilder();
		}
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

		if (mapKey != null) {
			buffer.append(ch, start, length);
		}
	}

	/**
	 * タグ終了処理。
	 * <p>
	 * 対象タグがエントリーの場合は、以下の処理を行う。
	 * </p>
	 * <ul>
	 * <li>クラス変数：編集マップに変換したタグ内容を追加する。</li>
	 * <li>クラス変数：マップキーをnullにする。</li>
	 * <li>クラス変数：タグ内容取得バッファをnullにする。</li>
	 * </ul>
	 * <p>
	 * 対象タグがマップの場合は、以下の処理を行う。
	 * </p>
	 * <ul>
	 * <li>継承元クラス変数：呼出し元ハンドラーに編集したマップを設定する。</li>
	 * <li>継承元クラス変数：呼出し元ハンドラーにクラス変数：内部Javaデータ型を設定する。</li>
	 * <li>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</li>
	 * </ul>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case ENTRY:

			tempMap.put(mapKey, ConvertUtil.convert(buffer
					.toString(), javaDataType));
			mapKey = null;
			buffer = null;
			break;

		case MAP:
			Map<String,Object> map = Collections.unmodifiableMap(
					ConvertUtil.resizeMap(tempMap));
			AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;

			handler.setValue(map);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			tempMap = null;
			break;
		}
	}

}
