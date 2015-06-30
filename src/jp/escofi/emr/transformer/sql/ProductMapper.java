package jp.escofi.emr.transformer.sql;



/**
 * 案件管理マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ORマッパーのSQL定義とマッピングさせるインターフェース。
 *   <DD>案件管理から案件情報を抽出するメソッドを定義。
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
public interface ProductMapper {

	/**
	 * 案件数抽出。
	 * <P>
	 * 指定した案件番号の案件数を抽出する。
	 * </P>
	 * @param productCd 案件番号
	 * @return 指定した案件番号の案件数
	 */
	int count(String productCd);

}
