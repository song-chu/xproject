package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.datamodel.PROObjObject;

/**
 * オブジェクト型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがオブジェクト型の場合、
 *オブジェクトデータタイプのバリュー（{@code <object>}）要素を制御するSAXのイベントハンドラー。
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
public final class PCHObjectHandler extends PCHADelegateHandler {

	/**
	 * クラス名
	 */
	private String className = null;
	/**
	 * クラス情報
	 */
	private String classInfo = null;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param className クラス名
	 * @param classInfo クラス情報
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHObjectHandler(
			PCHAResultObjectHandler callerHandler, String className, String classInfo) {

		super(callerHandler);

		this.className = className;
		this.classInfo = classInfo;
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグがオブジェクト型の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 *  <LI>実行オブジェクトを生成する。</LI>
	 *  <LI>呼出し元ハンドラーの属性値に、実行オブジェクトを設定する。</LI>
	 *  <LI>XMLリーダーのハンドラーを、呼出し元ハンドラーに戻す。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.OBJECT.equals(qName)) {
			PCHAResultObjectHandler handler =
				(PCHAResultObjectHandler) this.callerHandler;
			PROObjObject value = new PROObjObject(this.className, this.classInfo);

			handler.setValue(value);
			this.reader.setContentHandler(handler);
		}
	}

}
