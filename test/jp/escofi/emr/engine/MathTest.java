package jp.escofi.emr.engine;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.Status;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.escofi.emr.engine.condition.Rule;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSObjObject;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MathTest extends DJUnitTestCaseEx {

	/**
	 * Log出力
	 */
	private static final Log logger =LogFactory.getLog(MathTest.class);
	/**
	 * XMLベースフォルダ
	 */
	private static final String BASE_FOLDER = "C:/FromSong/workspace/testdata/xml/math";

	/**
	 *
	 */
	public MathTest() {

		super(MathTest.class, BASE_FOLDER);
	}

	// 正常系テスト
	/**
	 * テストID：PENSER-N-001-1
	 * @throws Exception 例外
	 */
	@Test
	public void testPENSER_N_001_1() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = response.getResultObject();
			// 結果値
			assertEquals("value001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * テストID：PENSER-N-001-2
	 */
	@Test
	public void testPENSER_N_001_2() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_2");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-3
	 */
	@Test
	public void testPENSER_N_001_3() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_3");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("key4");
		parameter1.add("key5");
		parameter1.add("key6");
		parameter1.add("key7");
		parameter1.add("key8");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value003", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-4
	 */
	@Test
	public void testPENSER_N_001_4() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_4");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value004_1", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_4");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("value004_2", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-5
	 */
	@Test
	public void testPENSER_N_001_5() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_5");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value005_1", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_5");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// ----------------------<<対象機能実施>>-------------------------------//
			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard004", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-6
	 */
	@Test
	public void testPENSER_N_001_6() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_6");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value6_1", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_6");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom");

			// ----------------------<<対象機能実施>>-------------------------------//
			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("value6_2", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_6");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// ----------------------<<対象機能実施>>-------------------------------//
			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("value6_3", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-7
	 */
	@Test
	public void testPENSER_N_001_7() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_7");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value7_1", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_7");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_7");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-8
	 */
	@Test
	public void testPENSER_N_001_8() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_8");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals(true, result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Boolean", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-9
	 */
	@Test
	public void testPENSER_N_001_9() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_9");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("008");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals(123456, result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Integer", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-10
	 */
	@Test
	public void testPENSER_N_001_10() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_10");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			assertEquals(Long.parseLong("1234567890"), result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Long", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-11
	 */
	@Test
	public void testPENSER_N_001_11() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_11");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			assertEquals(Double.parseDouble("2.20"), result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Double", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-12
	 */
	@Test
	public void testPENSER_N_001_12() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_12");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			assertEquals(new BigDecimal("0.90"), result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-13
	 */
	@Test
	public void testPENSER_N_001_13() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_13");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			List<String> kekkachi = new ArrayList<String>();
			kekkachi.add("value013_1");
			kekkachi.add("value013_2");
			kekkachi.add("value013_3");
			kekkachi.add("value013_4");
			kekkachi.add("value013_5");

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("list", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-14
	 */
	@Test
	public void testPENSER_N_001_14() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_14");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			List<Boolean> kekkachi = new ArrayList<Boolean>();
			kekkachi.add(true);
			kekkachi.add(false);

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("list", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Boolean", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-15
	 */
	@Test
	public void testPENSER_N_001_15() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_15");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("006");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			List<Integer> kekkachi = new ArrayList<Integer>();
			kekkachi.add(112233);
			kekkachi.add(223344);
			kekkachi.add(334455);
			kekkachi.add(445566);
			kekkachi.add(556677);

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("list", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Integer", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-16
	 */
	@Test
	public void testPENSER_N_001_16() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_16");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			List<Long> kekkachi = new ArrayList<Long>();
			kekkachi.add(new Long(1111111111));
			kekkachi.add(new Long(1222222222));
			kekkachi.add(new Long(1444444444));
			kekkachi.add(new Long(1888888888));
			kekkachi.add(new Long(2147483647));

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("list", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Long", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-17
	 */
	@Test
	public void testPENSER_N_001_17() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_17");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			List<Double> kekkachi = new ArrayList<Double>();
			kekkachi.add(new Double(1.10));
			kekkachi.add(new Double(2.20));
			kekkachi.add(new Double(3.30));
			kekkachi.add(new Double(4.40));
			kekkachi.add(new Double(5.50));

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("list", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Double", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-18
	 */
	@Test
	public void testPENSER_N_001_18() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_18");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			List<BigDecimal> kekkachi = new ArrayList<BigDecimal>();
			kekkachi.add(new BigDecimal("0.10"));
			kekkachi.add(new BigDecimal("0.20"));
			kekkachi.add(new BigDecimal("0.40"));
			kekkachi.add(new BigDecimal("0.80"));
			kekkachi.add(new BigDecimal("0.90"));

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("list", result.getDataType());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-19
	 */
	@Test
	public void testPENSER_N_001_19() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_19");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			Map<String, String> kekkachi = new TreeMap<String, String>();
			kekkachi.put("key019_1", "value019_1");
			kekkachi.put("key019_2", "value019_2");
			kekkachi.put("key019_3", "value019_3");
			kekkachi.put("key019_4", "value019_4");
			kekkachi.put("key019_5", "value019_5");

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("map", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-20
	 */
	@Test
	public void testPENSER_N_001_20() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_20");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			Map<String, Boolean> kekkachi = new TreeMap<String, Boolean>();
			kekkachi.put("key020_1", true);
			kekkachi.put("key020_2", false);

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("map", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Boolean", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-21
	 */
	@Test
	public void testPENSER_N_001_21() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_21");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			Map<String, Integer> kekkachi = new TreeMap<String, Integer>();
			kekkachi.put("key021_1", 111222);
			kekkachi.put("key021_2", 333444);
			kekkachi.put("key021_3", 555666);
			kekkachi.put("key021_4", 777888);
			kekkachi.put("key021_5", 999000);

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("map", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Integer", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-22
	 */
	@Test
	public void testPENSER_N_001_22() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_22");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			Map<String, Long> kekkachi = new TreeMap<String, Long>();
			kekkachi.put("key022_1", new Long(2147403647));
			kekkachi.put("key022_2", new Long(2147083647));
			kekkachi.put("key022_3", new Long(2140483647));
			kekkachi.put("key022_4", new Long(2107483647));
			kekkachi.put("key022_5", new Long(2147483647));

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("map", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Long", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-23
	 */
	@Test
	public void testPENSER_N_001_23() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_23");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("015");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			Map<String, Double> kekkachi = new TreeMap<String, Double>();
			kekkachi.put("key023_1", 1.20);
			kekkachi.put("key023_2", 2.40);
			kekkachi.put("key023_3", 3.60);
			kekkachi.put("key023_4", 4.80);
			kekkachi.put("key023_5", 5.00);

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("map", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Double", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-24
	 */
	@Test
	public void testPENSER_N_001_24() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_24");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			Map<String, BigDecimal> kekkachi = new TreeMap<String, BigDecimal>();
			kekkachi.put("key024_1", new BigDecimal("0.11"));
			kekkachi.put("key024_2", new BigDecimal("0.22"));
			kekkachi.put("key024_3", new BigDecimal("0.44"));
			kekkachi.put("key024_4", new BigDecimal("0.88"));
			kekkachi.put("key024_5", new BigDecimal("0.99"));

			assertEquals(kekkachi, result.getValue());
			// データ型確認
			assertEquals("map", result.getDataType());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-25
	 */
	@Test
	public void testPENSER_N_001_25() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_25");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject()
					.getValue();
			// 上限値確認
			assertEquals("あ", range.getUpper());
			// 下限値確認
			assertEquals("ん", range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-26
	 */
	@Test
	public void testPENSER_N_001_26() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_26");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値確認
			PDSObjObject obj = (PDSObjObject) response.getResultObject()
					.getValue();
			// 実行オブジェクト名確認
			assertEquals("TestCace026", obj.getClassName());
			// 付帯情報確認
			assertEquals(Arrays.asList("attached026"), obj.getAttachedInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// データ型確認
			assertEquals("object", result.getDataType());
			// Javaデータ型
			assertEquals(null, result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-27
	 */
	@Test
	public void testPENSER_N_001_27() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_27");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(
					"ConditionItem027=jp.escofi.emr.engine.search.ConditionItemInfo",
					response.getConditionItemInfoMap().toString().substring(1,
							63));
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(true, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 結果値取得
			Object kekkachi = response.getResultObject().getValue();
			boolean flag = false;
			if (kekkachi instanceof Rule) {
				flag = true;
			}
			assertEquals(true, kekkachi instanceof Rule);
			// クラス型確認
			assertEquals(flag, true);

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// データ型確認
			assertEquals("other", result.getDataType());
			// Javaデータ型
			assertEquals(null, result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-28
	 */
	@Test
	public void testPENSER_N_001_28() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_28");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("006");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("1001", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			assertEquals("value028", response.getResultObject().getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("1001", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-29
	 */
	@Test
	public void testPENSER_N_001_29() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_29");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname2");
		parameter1.add("007");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("1002", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			assertEquals("value029", response.getResultObject().getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("1002", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * テストID：PENSER-N-001-30
	 */
	@Test
	public void testPENSER_N_001_30() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_30");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.ATTR_NOT_FOUND, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-31
	 */
	@Test
	public void testPENSER_N_001_31() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_31");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("000");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.TREEMAP_KEY_NOT_FOUND, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-32
	 */
	@Test
	public void testPENSER_N_001_32() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_32");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.DELETED, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();

			// 結果値
			assertEquals(null, response.getResultObject().getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals(null, result.getJavaDataType());
			// 削除フラグ
			assertEquals(true, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-33
	 */
	@Test
	public void testPENSER_N_001_33() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_33");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value033_1", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_33");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-34
	 */
	@Test
	public void testPENSER_N_001_34() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_34");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_34");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-35
	 */
	@Test
	public void testPENSER_N_001_35() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_35");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value035_2", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_35");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("value035_1", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-36
	 */
	@Test
	public void testPENSER_N_001_36() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_36");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_36");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-37
	 */
	@Test
	public void testPENSER_N_001_37() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_37");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value037_3", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_37");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-38
	 */
	@Test
	public void testPENSER_N_001_38() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_38");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("common001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_38");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-39
	 */
	@Test
	public void testPENSER_N_001_39() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_39");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value039_2", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_39");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-40
	 */
	@Test
	public void testPENSER_N_001_40() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_40");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value040_3", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_40");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-41
	 */
	@Test
	public void testPENSER_N_001_41() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_41");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("common001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_41");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-42
	 */
	@Test
	public void testPENSER_N_001_42() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_42");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_42");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-43
	 */
	@Test
	public void testPENSER_N_001_43() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_43");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("004");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("value043_2", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_43");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("008");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-44
	 */
	@Test
	public void testPENSER_N_001_44() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_44");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_44");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");
			parameter1.add("001");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-45
	 */
	@Test
	public void testPENSER_N_001_45() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_45");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("common001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_45");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("001");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-46
	 */
	@Test
	public void testPENSER_N_001_46() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_46");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_46");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");
			parameter1.add("001");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-47
	 */
	@Test
	public void testPENSER_N_001_47() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_47");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("common001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_47");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("001");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-48
	 */
	@Test
	public void testPENSER_N_001_48() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_48");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("common001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_48");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("001");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("common002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-49
	 */
	@Test
	public void testPENSER_N_001_49() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_49");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_49");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");
			parameter1.add("001");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-50
	 */
	@Test
	public void testPENSER_N_001_50() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_50");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			ResultObject result = (ResultObject) response
					.getResultObject();
			// 結果値
			assertEquals("standard001", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

			// 引数設定
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_50");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");

			// 引数項目取得処理
			response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());
			// 引数項目取得用マップ確認
			assertEquals(null, response.getConditionItemInfoMap());
			// 引数項目値マップ確認
			assertEquals(null, response.getConditionItemValueMap());
			// 条件文有無確認
			assertEquals(false, response.isCondition());
			// メタ情報確認
			assertEquals("", response.getMetaInfo());

			// 属性値取得
			result = (ResultObject) response.getResultObject();
			// 結果値
			assertEquals("standard002", result.getValue());
			// データ型確認
			assertEquals("single", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());
			// 削除フラグ
			assertEquals(false, result.isDeleted());
			// メタ情報確認
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-51
	 */
	@Test
	public void testPENSER_N_001_51() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_51");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		// 引数項目取得処理
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<結果確認>>-------------------------------//
		// ステータス確認
		assertEquals(Status.NORMAL, response.getStatus());
		// 引数項目取得用マップ確認
		assertEquals(null, response.getConditionItemInfoMap());
		// 引数項目値マップ確認
		assertEquals(null, response.getConditionItemValueMap());
		// 条件文有無確認
		assertEquals(false, response.isCondition());
		// メタ情報確認
		assertEquals("", response.getMetaInfo());

		// 属性値取得
		ResultObject result = (ResultObject) response.getResultObject();
		// 結果値
		assertEquals("standard001", result.getValue());
		// データ型確認
		assertEquals("single", result.getDataType());
		// Javaデータ型
		assertEquals("java.lang.String", result.getJavaDataType());
		// 削除フラグ
		assertEquals(false, result.isDeleted());
		// メタ情報確認
		assertEquals("", result.getMetaInfo());

		result.getDataType();
		result.getJavaDataType();

		// 引数設定
		parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_51");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd2");

		// 引数項目取得処理
		response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<結果確認>>-------------------------------//
		// ステータス確認
		assertEquals(Status.NORMAL, response.getStatus());
		// 引数項目取得用マップ確認
		assertEquals(null, response.getConditionItemInfoMap());
		// 引数項目値マップ確認
		assertEquals(null, response.getConditionItemValueMap());
		// 条件文有無確認
		assertEquals(false, response.isCondition());
		// メタ情報確認
		assertEquals("", response.getMetaInfo());

		// 属性値取得
		result = (ResultObject) response.getResultObject();
		// 結果値
		assertEquals("standard002", result.getValue());
		// データ型確認
		assertEquals("single", result.getDataType());
		// Javaデータ型
		assertEquals("java.lang.String", result.getJavaDataType());
		// 削除フラグ
		assertEquals(false, result.isDeleted());
		// メタ情報確認
		assertEquals("", result.getMetaInfo());

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * 検索キー設定→検索実施→引数項目値設定→条件判定実施
	 *
	 * @param dataModelName
	 *            データモデル名(テストケースID)
	 * @param vars
	 *            引数項目名=引数項目値
	 * @return PDS応答クラス
	 * @throws InitializeException
	 * @throws UnExpectedStateException
	 * @throws InvalidKeyException
	 * @throws ConditionNotMatchedException
	 */
	@SuppressWarnings("unused")
	public void testPENSER_N_001_52() throws Exception {

		Map<String, Object> objMap = new HashMap<String, Object>();

		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(1);
		varSet1.add(3);
		varSet1.add(5);
		varSet1.add(7);
		varSet1.add(9);

		objMap.put("var1", varSet1);

		// ----------------------<<入力値設定>>-------------------------------//
		// 引数設定
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add("PENSER_N_001_52"); // 修正ポイント
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		// 引数項目取得処理
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res.getConditionItemInfoMap();

		// 引数項目値Map
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();

		String itemName = null; // 引数項目名
		String itemType = null; // 引数項目データ型
		String javaDataType = null; // 引数項目内部データ型
		List<String> searchInfo = null; // 引数項目取得情報

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		for (ConditionItemInfo conditionItemInfo : collection) {

			// 引数項目クラスから情報を取得する。
			itemName = conditionItemInfo.getItemName();
			itemType = conditionItemInfo.getItemType();
			javaDataType = conditionItemInfo.getJavaDataType();
			searchInfo = conditionItemInfo.getSearchInfo();

			Object var = null;
			if (objMap != null && objMap.containsKey(itemName)) {
				var = objMap.get(itemName);
			}

			if ("".equals(var)) {
				var = "default";
			}

			// 引数項目取得情報に基づき、引数項目を取得後、
			// 引数項目データ型、引数項目内部データ型に合わせて型変換し、引数項目値に代入する。
			if (!"set".equals(itemType) && (var != null)) {
				var = PUTConvertUtil.convert(var.toString(), javaDataType);
			}

			// 引数項目値マップに設定
			conditionItemValueMap.put(itemName, var);
		}

		// PDS応答クラスに引数項目値マップを設定
		res.setConditionItemValueMap(conditionItemValueMap);

		// 属性値取得メソッドを呼び出す。
		PDSServiceAPI.getAttrValue(res);

		// ----------------------<< 結果確認 >>-----------------------//
		// ステータス確認
		assertEquals(Status.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// メタ情報確認
		assertEquals("", res.getMetaInfo());

		// 結果確認
		assertEquals(true, res.getResultObject().getValue());
		// 属性値取得
		ResultObject result = (ResultObject) res.getResultObject();
		// データ型確認
		assertEquals("single", result.getDataType());
		// Javaデータ型
		assertEquals("java.lang.Boolean", result.getJavaDataType());
		// 削除フラグ
		assertEquals(false, result.isDeleted());
		// メタ情報確認
		assertEquals("", result.getMetaInfo());

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-53
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（文字列）
	 * XML設定：<upper>には有効値、<lower>には空文字
	 */
	public void testPENSER_N_001_53() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_53");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(true, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(false, range.hasLower());
			// 上限値確認
			assertEquals("AAA", range.getUpper());
			// 下限値確認
			assertEquals(null, range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.lang.String", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-54
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（文字列）
	 * XML設定：<upper>には空文字、<lower>には有効値
	 */
	public void testPENSER_N_001_54() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_54");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(false, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(true, range.hasLower());
			// 上限値確認
			assertEquals(null, range.getUpper());
			// 下限値確認
			assertEquals("ABC", range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.lang.String", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-55
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（文字列）
	 * XML設定：<upper>、<lower>に空文字
	 */
	public void testPENSER_N_001_55() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_55");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(false, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(false, range.hasLower());
			// 上限値確認
			assertEquals(null, range.getUpper());
			// 下限値確認
			assertEquals(null, range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.lang.String", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.String", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-56
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（数値型）
	 * XML設定：<upper>には有効値、<lower>には空文字
	 */
	public void testPENSER_N_001_56() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_56");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(true, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(false, range.hasLower());
			// 上限値確認
			assertEquals(Double.valueOf("3214567890123456789.88000e-326"), range.getUpper());
			// 下限値確認
			assertEquals(null, range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.lang.Double", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Double", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-57
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（数値型）
	 * 下限のみ
	 */
	public void testPENSER_N_001_57() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_57");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(false, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(true, range.hasLower());
			// 上限値確認
			assertEquals(null, range.getUpper());
			// 下限値確認
			assertEquals(Double.valueOf("3214567890123456789.88000e-326"), range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.lang.Double", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Double", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-58
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（数値型）
	 * 上限下限なし
	 */
	public void testPENSER_N_001_58() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_58");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(false, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(false, range.hasLower());
			// 上限値確認
			assertEquals(null, range.getUpper());
			// 下限値確認
			assertEquals(null, range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.lang.Double", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.lang.Double", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-59
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（BigDecimal）
	 * XML設定：<upper>には有効値、<lower>には空文字
	 */
	public void testPENSER_N_001_59() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_59");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(true, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(false, range.hasLower());
			// 上限値確認
			assertEquals(new BigDecimal("-4.2612892558531226012E+311"), range.getUpper());
			// 下限値確認
			assertEquals(null, range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-60
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（BigDecimal）
	 * 下限のみ
	 */
	public void testPENSER_N_001_60() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_60");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(false, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(true, range.hasLower());
			// 上限値確認
			assertEquals(null, range.getUpper());
			// 下限値確認
			assertEquals(new BigDecimal("-4.2612892558531226012E+311"), range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-001-61
	 * 対象：getConditionItems（引数項目取得処理）
	 * 範囲型オブジェクトにて上限/下限（BigDecimal）
	 * 上限下限なし
	 */
	public void testPENSER_N_001_61() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_61");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値確認
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// 上限値有無フラグ
			assertEquals(false, range.hasUpper());
			// 下限値有無フラグ
			assertEquals(false, range.hasLower());
			// 上限値確認
			assertEquals(null, range.getUpper());
			// 下限値確認
			assertEquals(null, range.getLower());
			// 上限値含むフラグ確認
			assertEquals(true, range.includeUpper());
			// 下限値含むフラグ確認
			assertEquals(true, range.includeLower());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", range.getJavaDataType());

			// 属性値取得
			ResultObject result = (ResultObject) response.getResultObject();
			// データ型確認
			assertEquals("range", result.getDataType());
			// Javaデータ型
			assertEquals("java.math.BigDecimal", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PENSER-N-002-1
	 */
	@Test
	public void testPENSER_N_002_1() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_1");

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		// ダンプ実行
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENSER_N_001_1");
	}

	/**
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&& &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& [
	 * 異常系テスト ] &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&
	 */

	/**
	 * テストID：PENSER_E_001_1
	 */
	@Test
	public void testPENSER_E_001_1() throws Exception {

		try {
			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P008E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_001_2_1
	 */
	@Test
	public void testPENSER_E_001_2_1() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		addReturnNull("PILInitialLoader", "getPDSObject");
		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_001_2_2
	 */
	@Test
	public void testPENSER_E_001_2_2() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		addReturnValue("PILInitialLoader", "getPDSObject",
				new HashMap<String, Object>());
		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E-001_2_3
	 */
	@Test
	public void testPENSER_E_001_2_3() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		addReturnNull("PILInitialLoader", "getPDSItemKeys");
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_001_2_4
	 */
	@Test
	public void testPENSER_E_001_2_4() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		addReturnValue("PILInitialLoader", "getPDSItemKeys",
				new HashMap<String, Object>());
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_001_3
	 */
	@Test
	public void testPENSER_E_001_3() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_3");
		parameter1.add("attr1");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P014E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_001_4
	 */
	@Test
	public void testPENSER_E_001_4() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_4");
		parameter1.add("attr1");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));
		setReturnValueAt("Map", "get", 2, new ArrayList<String>());

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);

			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P010E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E-001_5_1
	 */
	@Test
	public void testPENSER_E_001_5_1() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(null);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P011E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E-001_5_2
	 */
	@Test
	public void testPENSER_E_001_5_2() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P011E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_6
	 */
	@Test
	public void testPENSER_E_001_6() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_6");
		parameter1.add("a");
		parameter1.add("b");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P003E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_7
	 */
	@Test
	public void testPENSER_E_001_7() throws Exception {

		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("notfound");
		parameter1.add("notfound");
		parameter1.add("notfound");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P001E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_8
	 */
	@Test
	public void testPENSER_E_001_8() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_8");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P002E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_9
	 */
	@Test
	public void testPENSER_E_001_9() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_10
	 */
	@Test
	public void testPENSER_E_001_10() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_10");
		parameter1.add("attr");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);

			fail();
		} catch (InitializeException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_11
	 */
	@Test
	public void testPENSER_E_001_11() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProperty("xml.meta.filepath", "Z:/notfound.xml");

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_12
	 */
	@Test
	public void testPENSER_E_001_12() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_13
	 */
	@Test
	public void testPENSER_E_001_13() throws Exception {

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));
		setReturnValueAtAllTimes("DocumentBuilder", "parse", new IOException());

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_14
	 */
	@Test
	public void testPENSER_E_001_14() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_8");
		parameter1.add("attr1");
		parameter1.add("001");

		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_E_001_8");

		try {
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P002E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_001_15
	 * 対象:getConditionItems(引数項目取得処理)
	 * PDS応答クラスの変更不可項目について変更を試す。
	 * 引数項目取得用Map
	 */
	@Test
	public void testPENSER_E_001_15() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_15");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 引数項目取得用Map
			Map<String, ConditionItemInfo> map = response.getConditionItemInfoMap();

			//マップ変更
			map.put("testKey", new ConditionItemInfo("", "", "", new ArrayList<String>()));
			fail();

		} catch (UnsupportedOperationException e) {
			// 結果確認
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * テストID：PENSER_E_001_16
	 * 対象:getConditionItems(引数項目取得処理)
	 * PDS応答クラスの変更不可項目について変更を試す。
	 * 引数項目情報の引数項目取得情報
	 */
	@Test
	public void testPENSER_E_001_16() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_16");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 引数項目取得用Map
			Map<String, ConditionItemInfo> map = response.getConditionItemInfoMap();

			// 引数項目情報
			ConditionItemInfo itemInfo = map.get("var1");

			// 引数項目取得情報
			List<String> list = itemInfo.getSearchInfo();

			// 引数項目取得情報を変更
			list.add("test1");
			fail();

		} catch (UnsupportedOperationException e) {
			// 結果確認
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * テストID：PENSER_E_001_17
	 * 対象:getConditionItems(引数項目取得処理)
	 * PDS応答クラスの変更不可項目について変更を試す。
	 * 属性値オブジェクトのリスト
	 */
	@Test
	public void testPENSER_E_001_17() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_17");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値オブジェクト取得
			ResultObject result = response.getResultObject();

			// リスト取得
			List<String> list = (List<String>)result.getValue();

			// リスト変更
			list.add("test");
			fail();

		} catch (UnsupportedOperationException e) {
			// 結果確認
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * テストID：PENSER_E_001_18
	 * 対象:getConditionItems(引数項目取得処理)
	 * PDS応答クラスの変更不可項目について変更を試す。
	 * 属性値オブジェクトのMap
	 */
	@Test
	public void testPENSER_E_001_18() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_18");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値オブジェクト取得
			ResultObject result = response.getResultObject();

			// マップ取得
			Map<String, String> map = (Map<String, String>)result.getValue();

			// マップ変更
			map.put("key", "value");
			fail();

		} catch (UnsupportedOperationException e) {
			// 結果確認
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * テストID：PENSER_E_001_19
	 * 対象:getConditionItems(引数項目取得処理)
	 * PDS応答クラスの変更不可項目について変更を試す。
	 * オブジェクト型情報の付帯情報
	 */
	@Test
	public void testPENSER_E_001_19() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_19");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<対象機能実施>>-------------------------------//
			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<結果確認>>-------------------------------//
			// ステータス確認
			assertEquals(Status.NORMAL, response.getStatus());

			// 属性値オブジェクト取得
			ResultObject result = response.getResultObject();

			// オブジェクト型オブジェクト取得
			PDSObjObject obj = (PDSObjObject)result.getValue();

			// 付帯情報取得
			List<String> list = obj.getAttachedInfo();

			// 付帯情報変更
			list.add("test");
			fail();

		} catch (UnsupportedOperationException e) {
			// 結果確認
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * テストID：PENSER_E_002_1
	 */
	@Test
	public void testPENSER_E_002_1() throws Exception {

		try {
			PDSServiceAPI.getAttrValue(null);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P008E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_002_2
	 */
	@Test
	public void testPENSER_E_002_2() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_1");

			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			response = null;

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P011E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * テストID：PENSER_E_002_3
	 */
	@Test
	public void testPENSER_E_002_3() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_2");

			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			addReturnValue("Rule", "apply",
					new ConditionNotMatchedException(MessageCode.EMR_A_P007E));

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (ConditionNotMatchedException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P007E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_002_4
	 */
	@Test
	public void testPENSER_E_002_4() throws Exception {

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object利用、返却値を設定する。
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_2");

			// イニシャルロードを実行する。
			PDSEngine.getInstance();

			// 引数項目取得処理
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			addReturnValue("Rule", "apply", new RuntimeException());

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (ConditionNotMatchedException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P010E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER_E_003_1
	 */
	@Test
	public void testPENSER_E_003_1() throws Exception {

		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENSER_E_003_1");
			fail();
		} catch (UnExpectedStateException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P008E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER-E-003-2
	 */
	@Test
	public void testPENSER_E_003_2() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
			// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "xxx");
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P015E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER-E-003-3
	 */
	@Test
	public void testPENSER_E_003_3() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4));
		setReturnValueAtAllTimes("ObjectWriter", "objectWrite",
				new IOException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
			// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENSER_E_003_3");
			fail();
		} catch (DumpException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P016E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENSER-E-003-4
	 */
	@Test
	public void testPENSER_E_003_4() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(super.getName().substring(4), "PENSER_E_003_3");

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
			// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, null);
			fail();
		} catch (InvalidKeyException e) {
			// 結果確認
			assertEquals(MessageCode.EMR_A_P015E, e.getErrCode());
		} catch (Exception e) {
			fail();
		}
	}
}
