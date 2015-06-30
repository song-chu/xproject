package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTCodeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHDelegateHandlerFactory;

import org.xml.sax.Attributes;


/**
 * 属性値親ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値（検索結果の属性値・条件判定結果の属性値）の共通処理を記載するSAXイベントハンドラーの親クラス。（抽象クラス）
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1800 $
 *  <DT>最終開発日時：
 *   <DD>$Date:: 2010-12-17 17:48:0#$
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHConditionHandler
 * @see PCHListHandler
 * @see PCHMapHandler
 * @see PCHObjectHandler
 * @see PCHRangeHandler
 * @see PCHResultHandler
 * @see PCHSingleHandler
 * @see PCHValueHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yj $
 */
public abstract class PCHAResultObjectHandler extends PCHADelegateHandler {

	/**
	 * 削除フラグ
	 */
	protected boolean delflg;

	/**
	 * データ型
	 */
	private String dataType;

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * メタ情報
	 */
	private String metaInfo;
	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType = null;
	/**
	 * 属性値
	 */
	private Object value = null;

	private String jpname="";
	protected static String anser_id;

	public Object getValue() {
		return value;
	}



	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @see PCHResultHandler
	 * @see PCHValueHandler
	 */
	public PCHAResultObjectHandler(PCHADelegateHandler callerHandler, Attributes atts, String jpname) {

		super(callerHandler);

		String dataType = atts.getValue(PCTAttributeType.DATATYPE.toString()).intern();
		String delflg = atts.getValue(PCTAttributeType.DELFLG.toString()).intern();
		String metaInfo = atts.getValue(PCTAttributeType.METAINFO.toString()).intern();

		this.dataType = dataType;
		this.delflg = Boolean.parseBoolean(delflg);
		this.metaInfo = metaInfo;
		this.jpname= jpname;
	}

	public PCHAResultObjectHandler(PCHADelegateHandler callerHandler, Attributes atts) {

		super(callerHandler);

		String dataType = atts.getValue(PCTAttributeType.DATATYPE.toString()).intern();
		String delflg = atts.getValue(PCTAttributeType.DELFLG.toString()).intern();
		String metaInfo = atts.getValue(PCTAttributeType.METAINFO.toString()).intern();

		this.dataType = dataType;
		this.delflg = Boolean.parseBoolean(delflg);
		this.metaInfo = metaInfo;
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * クラス変数：削除フラグがtrueの場合は何も行わない。<BR>
	 * 上記以外の場合は、XMLリーダーのハンドラーを参照するタグに応じたハンドラーへ切替える。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (this.delflg) {
			return;
		}
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHADelegateHandler handler = PCHDelegateHandlerFactory.createDelegateHandler(
				elementType, this, atts);

		if (handler != null) {
			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * 結果オブジェクト取得処理。
	 * <P>
	 * 現在のクラス変数から、結果オブジェクトを生成する。
	 * </P>
	 * @return 結果オブジェクト
	 * @see PCHResultHandler
	 * @see PCHValueHandler
	 */
	protected final PROResultObject getResultObject() {
		return  new PROResultObject(this.value, this.dataType,
				this.javaDataType, this.delflg, this.metaInfo, this.jpname);
	}

	/**
	 * @param value 属性値
	 * @see PCHConditionHandler
	 * @see PCHListHandler
	 * @see PCHMapHandler
	 * @see PCHObjectHandler
	 * @see PCHRangeHandler
	 * @see PCHSingleHandler
	 */
	protected final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @param javaDataType 内部Javaデータ型
	 * @see PCHListHandler
	 * @see PCHMapHandler
	 * @see PCHObjectHandler
	 * @see PCHRangeHandler
	 * @see PCHSingleHandler
	 */
	protected final void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType.intern();
	}

}
