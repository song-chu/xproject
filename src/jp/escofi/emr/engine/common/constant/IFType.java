package jp.escofi.emr.engine.common.constant;

/**
 * IF-THEN-ELSE識別子。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>IF、THENIF、ELSEIFを識別するenumクラス。
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
public enum IFType {
	/**
	 * IFタイプ：TOP
	 */
	IF_TOP,
	/**
	 * IFタイプ：ELSE
	 */
	IF_ELSE,
	/**
	 * IFタイプ：THEN
	 */
	IF_THEN,
}
