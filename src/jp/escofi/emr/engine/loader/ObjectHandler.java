package jp.escofi.emr.engine.loader;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.search.PDSObjObject;

/**
 * オブジェクト型ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがオブジェクト型の場合、
 *オブジェクトデータタイプのバリュー（{@code <object>}）要素を制御するSAXのイベントハンドラー。
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
public final class ObjectHandler extends AbstractDelegateHandler {

	/**
	 * クラス名
	 */
	private String className = null;
	/**
	 * クラス情報
	 */
	private List<String> classInfo = null;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param className クラス名
	 * @param classInfo クラス情報
	 */
	public ObjectHandler(
			AbstractResultObjectHandler callerHandler, String className, List<String> classInfo) {

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

		if (ElementType.OBJECT.toString().equals(qName)) {
			AbstractResultObjectHandler handler =
				(AbstractResultObjectHandler) callerHandler;
			PDSObjObject value = new PDSObjObject(className, classInfo);

			handler.setValue(value);
			reader.setContentHandler(handler);
		}
	}

}
