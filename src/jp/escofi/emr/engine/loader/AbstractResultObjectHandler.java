package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.engine.search.ResultObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * 属性値親ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値（検索結果の属性値・条件判定結果の属性値）の共通処理を記載するSAXイベントハンドラーの親クラス。（抽象クラス）
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
public abstract class AbstractResultObjectHandler extends AbstractDelegateHandler {

	/**
	 * 削除フラグ
	 */
	protected boolean delFlg;
	/**
	 * データ型
	 */
	protected String dataType;

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

	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler
	 *            呼出し元ハンドラー
	 * @param atts
	 *            アトリビュート情報
	 */
	public AbstractResultObjectHandler(AbstractDelegateHandler callerHandler,
			Attributes atts) {

		super(callerHandler);
		dataType = atts.getValue(AttributeType.DATA_TYPE.toString()).intern();
		delFlg = ConvertUtil.isConvertBoolean(atts.getValue(AttributeType.DEL_FLG.toString()));
		metaInfo = atts.getValue(AttributeType.META_INFO.toString()).intern();
	}

	/**
	 * タグ開始処理。
	 * <P>
	 * クラス変数：削除フラグがtrueの場合は何も行わない。<BR>
	 * 上記以外の場合は、XMLリーダーのハンドラーを参照するタグに応じたハンドラーへ切替える。
	 * </P>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ローカル名
	 * @param qName
	 *            参照中のタグ名
	 * @param atts
	 *            アトリビュート情報
	 * @throws SAXException
	 *             このハンドラーのデータ型と子タグのタグ名が一致しない場合
	 * @throw IllegalArgumentException 引数不正例外
	 *        <UL>
	 *        <LI>引数elementTypeとdataTypesの整合性が合わない場合
	 *        </UL>
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if (delFlg) {
			return;
		}
		ElementType elementType = ElementType.getType(qName);

		if (!elementType.toString().equals(dataType)) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P018E.toString(), new String[] {
							elementType.toString(), dataType }));
		}
		AbstractDelegateHandler handler = DelegateHandlerFactory
				.createDelegateHandler(elementType, this, atts);

		if (handler != null) {
			reader.setContentHandler(handler);
		}
	}

	/**
	 * 結果オブジェクト取得処理。
	 * <P>
	 * 現在のクラス変数から、結果オブジェクトを生成する。
	 * </P>
	 *
	 * @return 結果オブジェクト
	 */
	protected final ResultObject getResultObject() {
		return new ResultObject(value, dataType, javaDataType, delFlg,
				metaInfo);
	}

	/**
	 * @param value
	 *            属性値
	 */
	protected final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @param javaDataType
	 *            内部Javaデータ型
	 */
	protected final void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}

}
