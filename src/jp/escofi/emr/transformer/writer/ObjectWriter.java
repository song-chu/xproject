package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * オブジェクト型ライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のデータタイプがオブジェクトの場合、
 *オブジェクトデータタイプのバリュー（{@code <object>}）の要素を出力するXMLライター。
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
public final class ObjectWriter extends AbstractAttributeValueWriter {


	/**
	 * コンストラクタ。
	 * <UL>
	 *  <LI>XMLタグ名を初期化する。</LI>
	 *  <LI>子タグ情報セットにnullを入れる。</LI>
	 *  <LI>タグの出力形式を終了タグなし形式に設定する。</LI>
	 * </UL>
	 */
	public ObjectWriter() {
		super(ElementType.OBJECT);
		childSet = null;
		isEmptyElement = true;
	}


	/**
	 * クラス名設定。
	 * <P>
	 * タグのclassnameアトリビュートに値を設定。
	 * </P>
	 * @param className クラス名
	 */
	public void setClassName(String className) {
		setAttribute(AttributeType.CLASS_NAME, className);
	}

	/**
	 * 付帯情報設定。
	 * <P>
	 * タグのsubinfoアトリビュートに値を設定。
	 * </P>
	 * @param subInfo 付帯情報
	 */
	public void setSubInfo(String subInfo) {
		setAttribute(AttributeType.SUB_INFO, subInfo);
	}

}
