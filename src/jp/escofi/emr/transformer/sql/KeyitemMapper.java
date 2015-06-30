package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.DatamodelWriter;
import jp.escofi.emr.transformer.writer.KeyitemWriter;


/**
 * キー項目マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ORマッパーのSQL定義とマッピングさせるインターフェース。
 *   <DD>属性グループテーブルからデータモデルのキー項目情報を抽出するメソッドを定義。
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
public interface KeyitemMapper {

	/**
	 * 属性グループ情報抽出。
	 * <P>
	 * 指定したデータモデルのキー項目名付き属性グループ情報を抽出する。
	 * </P>
	 * @param dataModel データモデル
	 * @return 属性グループ情報マッパー
	 */
	List<AttributeGroupMapper> selectAttGroup(DatamodelWriter dataModel);

	/**
	 * キー項目情報抽出。
	 * <P>
	 * 指定したデータモデルのキー項目情報を抽出する。
	 * </P>
	 * @param dataModel データモデル
	 * @return キー項目ライターリスト
	 */
	List<KeyitemWriter> selectKeyItem(DatamodelWriter dataModel);

}
