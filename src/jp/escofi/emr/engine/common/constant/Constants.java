package jp.escofi.emr.engine.common.constant;

/**
 * 共通定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>共通定義クラス。
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
public class Constants {

	/**
	 * データモデル名：all
	 */
	public static final String DATA_MODEL_ALL ="all";

	/**
	 * XMLファイルIO用文字コード:システムプロパティから取得（デフォルト：Cp943C）
	 */
	public static final String XML_IO_CHARSET = System.getProperty("file.encoding", "Cp943C");

	/**
	 * XML符号化宣言用エンコード:Shift_JIS
	 */
	public static final String XML_ENCODING ="Shift_JIS";
}
