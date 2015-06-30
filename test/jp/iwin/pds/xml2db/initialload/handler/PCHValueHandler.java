package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTCodeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PROAction;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.datamodel.PRORule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;

/**
 * 属性値ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>検索結果の属性値({@code <value>})を処理するSAXイベントハンドラー。
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
 * @see PCHKeyItemHandler
 * @see PCHMapHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHValueHandler extends PCHAResultObjectHandler {

	/**
	 * 条件文フラグ
	 */
	private boolean condflg;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler
	 * @param atts
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHValueHandler(PCHKeyItemHandler callerHandler, Attributes atts, String jpname) {

		super(callerHandler, atts, jpname);

		String condflg = atts.getValue(PCTAttributeType.CONDFLG.toString()).intern();
		this.condflg = PUTConvertUtil.convert(
				condflg, PCTCodeType.BOOLEAN.toString());

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
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if ((!this.delflg)&&this.condflg) {
			PCHConditionHandler handler = PCHRuleHandlerFactory.createConditionHandler(this);

			this.reader.setContentHandler(handler);
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
	@SuppressWarnings("static-access")
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.VALUE.equals(qName)) {
			if((!this.delflg)&&this.condflg){
				PRORule rule = (PRORule) this.getValue();
				PROResultObject action = rule.getresultMap().get(this.anser_id);
				if(action.getJavaDataType()!=null){
					this.setJavaDataType(action.getJavaDataType());
				}
				this.setDataType(action.getDataType());
			}
			PROResultObject resultObject = getResultObject();

			((PCHKeyItemHandler) this.callerHandler).setValue(resultObject);
			this.reader.setContentHandler(this.callerHandler);
		}
	}
}
