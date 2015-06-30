package jp.iwin.pds.xml2db.initialload.handler;

import java.util.List;

import org.xml.sax.Attributes;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROAction;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;


/**
 * 条件式結果ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件判定結果{@code <result>}の要素を処理するSAXイベントハンドラー。
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHResultHandler extends PCHAResultObjectHandler {

	/**
	 * ルールオブジェクト
	 */
	private PROINIRule rule;
	/**
	 * 条件式タイプ
	 */
	private PCTIFType ifType;

	private XMLWriter writer;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule ルールオブジェクト
	 * @param ifType 条件式タイプ
	 * @param atts アトリビュート情報
	 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
	 */
	public PCHResultHandler(PCHADelegateHandler callerHandler, PROINIRule rule,
			PCTIFType ifType, Attributes atts, XMLWriter writer) {

		super(callerHandler, atts);

		this.rule = rule;
		this.ifType = ifType;
		this.writer = writer;
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 条件式結果タグ修了時は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>結果オブジェクトを生成する。</LI>
	 * <LI>クラス変数：条件式結果タイプがTHENの場合は、クラス変数：ルールオブジェクトのTHEN結果に、
	 *生成した結果オブジェクトを設定する。</LI>
	 * <LI>上記以外の場合は、クラス変数：ルールオブジェクトのTHEN結果に、
	 *生成した結果オブジェクトを設定する。</LI>
	 * <LI>XMLリーダーのハンドラーを呼出し元ハンドラーに戻す。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@SuppressWarnings("static-access")
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.RESULT.equals(qName)) {
			PCHKeyItemHandler.anser_no++;
			this.anser_id = Integer.toString(PCHKeyItemHandler.anser_no);
			this.writer.characters(this.anser_id );
			this.writer.endElement(qName);
			PROResultObject resultObject = getResultObject();
			PROAction action = new PROAction(resultObject);
			PCHConditionHandler.resultMap.put(this.anser_id, resultObject);

			if (PCTIFType.IF_THEN.equals(this.ifType)) {
				this.rule.setThenAction(action);
			} else {
				this.rule.setElseAction(action);
			}


			this.reader.setContentHandler(this.callerHandler);
		}
	}
}
