package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * ダミー項目ライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>ダミー項目({@code <empty>})を出力するXMLライター。
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
public final class EmptyWriter extends AbstractXmlWriter {

	/**
	 * 共通インスタンス
	 */
	private static final EmptyWriter WRITER = new EmptyWriter();


	/**
	 * @return 空項目ライター
	 */
	public static EmptyWriter getInstance() {
		return WRITER;
	}


	/**
	 * コンストラクタ。
	 * <P>
	 * このインスタンスはシングルトンとするため、コンストラクタはprivate指定。
	 * </P>
	 * <UL>
	 *  <LI>XMLタグ名を初期化する。</LI>
	 *  <LI>タグ内容にnullを入れる。</LI>
	 *  <LI>終了タグなしをtrueにする。</LI>
	 * </UL>
	 */
	private EmptyWriter() {
		super(ElementType.EMPTY);
		childSet = null;
		value = null;
		isEmptyElement = true;
	}

}
