package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.DatamodelWriter;


/**
 * 属性項目マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ORマッパーのSQL定義とマッピングさせるインターフェース。
 *   <DD>属性項目テーブルから属性値情報を抽出するメソッドを定義。
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
public interface ResultObjectMapper {

	/**
	 * 属性項目情報抽出。
	 * <P>
	 * 指定した属性グループの属性管理情報付き属性項目情報を抽出する。
	 * </P>
	 * @param dataModel データモデルライター
	 * @return 属性項目情報マッパーリスト
	 */
	List<AttributeFieldMapper> select(DatamodelWriter dataModel);

}
