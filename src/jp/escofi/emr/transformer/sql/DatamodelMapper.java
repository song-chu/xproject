package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.DatamodelWriter;


/**
 * データモデルマッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ORマッパーのSQL定義とマッピングさせるインターフェース。
 *   <DD>データモデルテーブルからデータモデルを抽出するメソッドを定義。
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
public interface DatamodelMapper {

	/**
	 * データモデル抽出（案件番号指定）。
	 * <P>
	 * 指定した案件番号の本番日以前のデータモデルを抽出する。
	 * </P>
	 * @param productCd 案件番号
	 * @return データモデルライターリスト
	 */
	List<DatamodelWriter> select(String productCd);

}
