package jp.iwin.pds.xml2db.initialload.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.xml.sax.Attributes;


/**
 * マップ型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがMapの場合、
 *Mapデータタイプのバリュー（{@code <map>}）以下の要素を制御するSAXのイベントハンドラー。
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
public final class PCHMapHandler extends PCHADelegateHandler {

	/**
	 * 編集マップ
	 */
	private Map<String, Object> tempmap = new HashMap<String, Object>();
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
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHMapHandler(PCHAResultObjectHandler callerHandler, String javaDataType) {
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

		if (PCTElementType.ENTRY.equals(qName)) {
			String key = atts.getValue(PCTAttributeType.KEY.toString());

			this.mapKey = key.intern();
			this.buffer = new StringBuilder();
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

		if (this.mapKey != null) {
			this.buffer.append(ch, start, length);
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
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case ENTRY:

			if (0 < this.buffer.length()) {
				this.tempmap.put(this.mapKey,this.buffer.toString().intern());
			}
			this.mapKey = null;
			this.buffer = null;
			break;

		case MAP:
			Map<String,Object> map = Collections.unmodifiableMap(
					PUTConvertUtil.resizeMap(this.tempmap));
			PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;

			handler.setValue(map);
			handler.setJavaDataType(this.javaDataType);
			this.reader.setContentHandler(handler);
			this.tempmap = null;
			break;
		}
	}

}
