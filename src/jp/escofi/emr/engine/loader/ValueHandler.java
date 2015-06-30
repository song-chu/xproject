package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.search.ResultObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * 属性値ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>検索結果の属性値({@code <value>})を処理するSAXイベントハンドラー。
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
public final class ValueHandler extends AbstractResultObjectHandler {

	/**
	 * 条件文フラグ
	 */
	private boolean condFlg;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 */
	public ValueHandler(KeyItemHandler callerHandler, Attributes atts) {

		super(callerHandler, atts);
		condFlg = ConvertUtil.isConvertBoolean(atts.getValue(AttributeType.COND_FLG.toString()));
	}


	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>この属性値が継承元クラス変数：削除フラグがfalse、クラス変数：条件文フラグがtrueの場合は、
	 *XMLリーダーに条件文ハンドラーを設定する。</LI>
	 *  <LI>上記以外の場合は、継承元クラスメソッドのタグ開始処理を行う。</LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 * @throws SAXException  このハンドラーのデータ型と子タグのタグ名が一致しない場合
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts)
	throws SAXException {

		if (!delFlg && condFlg) {
			ConditionHandler handler = RuleHandlerFactory.createConditionHandler(this);
			reader.setContentHandler(handler);
		} else {
			super.startElement(uri, localName, qName, atts);
		}
	}


	/**
	 * タグ終了処理。
	 * <P>
	 * 条件式結果タグ修了時は、以下の処理を行う。
	 * </P>
	 * <OL>
	 *  <LI>結果オブジェクトを生成する。</LI>
	 *  <LI>呼出し元ハンドラーに、生成した結果オブジェクトを設定する。</LI>
	 *  <LI>XMLリーダーのハンドラーを呼出し元ハンドラーに戻す。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.VALUE.toString().equals(qName)) {
			ResultObject resultObject = getResultObject();

			((KeyItemHandler) callerHandler).setValue(resultObject);

			reader.setContentHandler(callerHandler);
		}
	}
}
