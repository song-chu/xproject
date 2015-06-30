package jp.iwin.pds.xml2db.datatable;


/**
 * テストデータ投入用SQLインターフェース。
 *
 * @author $Author: devuser05 $
 */
public interface TblMapper {

	/**
	 * データモデルテーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllDatamodel();
	/**
	 * 属性グループテーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllAttGroup();
	/**
	 * キー項目解決テーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllKeySolve();
	/**
	 * 属性管理テーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllAttElem();
	/**
	 * 属性項目テーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllAttField();
	/**
	 * 引数管理テーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllArgsElem();
	/**
	 * 属性値テーブル全削除。
	 * @return 削除件数
	 */
	int deleteAllAttValue();


	/**
	 * データモデルテーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertDatamodel(TblDataModel datamodel);
	/**
	 * 属性グループテーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertAttGroup(TblAttributeGroup attGroup);
	/**
	 * キー項目解決テーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertKeySolve(TblKeySolve keySolve);
	/**
	 * 属性管理テーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertAttElem(TblAttributeElem attElem);
	/**
	 * 属性項目テーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertAttField(TblAttributeField attField);
	/**
	 * 引数管理テーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertArgsElem(TblArgsElem argsElem);
	/**
	 * 属性値テーブルデータ投入
	 * @return SQL実行結果値
	 */
	int insertAttValue(TblAttributeValue attValue);

	/**
	 * データモデル取得
	 * @param datamodel_id データモデルID
	 * @return データモデル
	 */
	TblDataModel selectDataModel(int datamodel_id);
	/**
	 * 属性グループ取得
	 * @param attribute_group_id 属性グループID
	 * @return 属性グループ
	 */
	TblAttributeGroup selectAttGroup(int attribute_group_id);
	/**
	 * キー項目解決取得
	 * @param key_solve_id キー項目解決ID
	 * @return キー項目解決
	 */
	TblKeySolve selectKeySolve(int key_solve_id);
	/**
	 * 属性管理取得
	 * @param attribute_elem_id 属性管理ID
	 * @return 属性管理
	 */
	TblAttributeElem selectAttElem(int attribute_elem_id);
	/**
	 * 属性項目取得
	 * @param attribute_field_id 属性項目ID
	 * @return 属性項目
	 */
	TblAttributeField selectAttField(int attribute_field_id);
	/**
	 * 引数管理取得
	 * @param args_elem_id 引数管理ID
	 * @return 引数管理
	 */
	TblArgsElem selectArgsElem(int args_elem_id);
	/**
	 * 属性値取得
	 * @param attribute_value_id 属性値ID
	 * @return 属性値
	 */
	TblAttributeValue selectAttValue(int attribute_value_id);
	/**
	 * 案件管理取得
	 * @param product_id 案件管理ID
	 * @return 案件管理
	 */
	TblProduct selectProduct(int product_id);

	/**
	 * データモデル更新
	 * @param datamodel データモデル
	 * @return SQL実行結果値
	 */
	int updateDataModel(TblDataModel datamodel);
	/**
	 * 属性グループ更新
	 * @param attGroup 属性グループ
	 * @return SQL実行結果値
	 */
	int updateAttGroup(TblAttributeGroup attGroup);
	/**
	 * キー項目解決更新
	 * @param keySolve キー項目解決
	 * @return SQL実行結果値
	 */
	int updateKeySolve(TblKeySolve keySolve);
	/**
	 * 属性管理更新
	 * @param attElem 属性管理
	 * @return SQL実行結果値
	 */
	int updateAttElem(TblAttributeElem attElem);
	/**
	 * 属性項目更新
	 * @param attField 属性項目
	 * @return SQL実行結果値
	 */
	int updateAttField(TblAttributeField attField);
	/**
	 * 引数管理更新
	 * @param argsElem 引数管理
	 * @return SQL実行結果値
	 */
	int updateArgsElem(TblArgsElem argsElem);
	/**
	 * 属性値更新
	 * @param attValue 属性値
	 * @return SQL実行結果値
	 */
	int updateAttValue(TblAttributeValue attValue);
	/**
	 * 案件管理更新
	 * @param product 案件管理
	 * @return SQL実行結果値
	 */
	int updateProduct(TblProduct product);

}
