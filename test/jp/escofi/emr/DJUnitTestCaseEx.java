package jp.escofi.emr;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jp.co.dgic.testing.framework.DJUnitTestCase;
import jp.escofi.emr.engine.common.constant.Status;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.loader.InitialLoader;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.ResultObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author song.ck
 *
 */
public class DJUnitTestCaseEx extends DJUnitTestCase {

	/**
	 * ファイルセパレータ
	 */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator", "/");

	/**
	 * ダンプ要否
	 */
	protected static final boolean NEED_DUMP = true;

	/**
	 * リソースベースフォルダ
	 */
	protected static final String SLASH = "/";

	/**
	 * リソースベースフォルダ
	 */
	private String baseFolder = null;

	/**
	 * ログ
	 */
	protected Log log = null;

	/**
	 * ダンプリソースベースフォルダ
	 */
	protected static final String DUMP_BASE_FOLDER = "C:/emr/dump";

	/**
	 * コンストラクタ
	 *
	 * @param clazz
	 *            クラス
	 * @param baseFolder
	 *            リソースベースフォルダ
	 */
	@SuppressWarnings("unchecked")
	public DJUnitTestCaseEx(Class clazz, String baseFolder) {

		super();
		this.log = LogFactory.getLog(clazz);
		this.baseFolder = baseFolder;
	}

	/**
	 *
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		Method loadMethod = PropertyUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		Properties props = (Properties) loadMethod
				.invoke(PropertyUtil.class);

		props.setProperty("xml.datamodel.base", this.baseFolder);

		Field propsField = PropertyUtil.class.getDeclaredField("props");
		propsField.setAccessible(true);
		propsField.set(null, props);

		Field isLoadedField = PDSEngine.class.getDeclaredField("isLoaded");
		isLoadedField.setAccessible(true);
		isLoadedField.set(null, false);

		Field instanceField = PDSEngine.class.getDeclaredField("instance");
		instanceField.setAccessible(true);
		instanceField.set(null, null);
	}

	/**
	 *
	 */
	@Override
	protected void tearDown() throws Exception {

		this.replaceProperty("xml.meta.schema.filepath", "C:/FromSong/workspace/escofierm/xsd/emrmeta.xsd");
		super.tearDown();
	}

	/**
	 * プロパティ置換
	 *
	 * @param key
	 *            キー
	 * @param value
	 *            値
	 * @throws Exception	例外
	 */
	protected void replaceProperty(String key, String value) throws Exception {

		Field propsField = PropertyUtil.class.getDeclaredField("props");
		propsField.setAccessible(true);
		Properties props = (Properties) propsField.get(PropertyUtil.class);
		props.put(key, value);
		propsField.set(null, props);
	}

	/**
	 * <p>
	 * テストケース名によるリフレクションの設定<br>
	 * プロパティユティリティよりメータXMLのパス取得時、取得パスを置換する。
	 * </p>
	 *
	 * @param testCaseName
	 *            テストケース名
	 * @throws Exception	例外
	 */
	protected void replaceProp(String testCaseName) throws Exception {

		this.replaceProp(testCaseName, testCaseName);
	}

	/**
	 * <p>
	 * メタデータモデル名によるVirtual Mock Objectの設定<br>
	 * プロパティユティリティよりメータXMLのパス取得時、取得パスを置換する。
	 * </p>
	 *
	 * @param testCaseName
	 *            テストケース名
	 * @param dataModelMetaXmlName
	 *            メタデータモデル名
	 * @throws Exception	例外
	 */
	protected void replaceProp(String testCaseName, String dataModelMetaXmlName)
			throws Exception {

		log.info("########## " + testCaseName + " ##########");

		this.replaceProperty("xml.meta.filepath", this.baseFolder + SLASH
				+ dataModelMetaXmlName + "_Meta.xml");
	}

	/**
	 * エンジンのPDSオブジェクトをログ出力
	 *
	 * @throws Exception
	 *             例外
	 */
	protected void logPdsObjects() throws Exception {

		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(PDSEngine.class);
		this.log.info(pdsObjects);
	}

	/**
	 * オブジェクトより新規セットを作成する。
	 *
	 * @param <T>	Java型
	 *
	 * @param clazz
	 *            データタイプ
	 * @param objects
	 *            オブジェクト
	 * @return セット
	 */
	@SuppressWarnings("unchecked")
	protected <T> Set<T> getSet(Class<T> clazz, Object... objects) {

		Set<T> set = new HashSet<T>();
		if (objects != null && objects.length > 0) {
			for (Object obj : objects) {
				if (clazz == Integer.class) {
					set.add((T) new Integer(obj.toString()));
				} else if (clazz == Long.class) {
					set.add((T) new Long(obj.toString()));
				} else if (clazz == Double.class) {
					set.add((T) new Double(obj.toString()));
				} else if (clazz == Boolean.class) {
					set.add((T) new Boolean(obj.toString()));
				} else if (clazz == BigDecimal.class) {
					set.add((T) new BigDecimal(obj.toString()));
				} else {
					set.add((T) obj);
				}
			}
		}
		return (Set<T>) set;
	}

	/**
	 * テストドライブ
	 *
	 * @param param
	 *            パラメータ
	 * @return 結果
	 * @throws Exception
	 *             例外
	 */
	protected ResultObject getResult(List<String> param) throws Exception {

		// 引数項目取得処理
		PDSResponse response = PDSServiceAPI.getConditionItems(param);

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

		return response.getResultObject();
	}

	/**
	 * テストドライブ
	 *
	 * @param param
	 *            パラメータ
	 * @param objMap
	 *            オブジェクトマップ
	 * @return 結果
	 * @throws Exception
	 *             例外
	 */
	@Deprecated
	protected PDSResponse getResult2(List<String> param,
			Map<String, Object> objMap) throws Exception {

		return this.getResult(param, objMap);
	}

	/**
	 * テストドライブ
	 *
	 * @param param
	 *            パラメータ
	 * @param objMap
	 *            オブジェクトマップ
	 * @return 結果
	 * @throws Exception
	 *             例外
	 */
	protected PDSResponse getResult(List<String> param,
			Map<String, Object> objMap) throws Exception {

		// 引数項目取得処理
		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		Map<String, ConditionItemInfo> conditionItemInfoMap = response
				.getConditionItemInfoMap();
		if (conditionItemInfoMap == null) {
			return response;
		}

		// 引数項目値Map
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();
		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();
		for (ConditionItemInfo conditionItemInfo : collection) {
			// 引数項目値マップに設定
			String itemName = conditionItemInfo.getItemName();
			conditionItemValueMap.put(itemName, objMap.get(itemName));
		}
		// PDS応答クラスに引数項目値マップを設定
		response.setConditionItemValueMap(conditionItemValueMap);
		// 属性値取得メソッドを呼び出す。
		return PDSServiceAPI.getAttrValue(response);
	}

	/**
	 * Exceptionのログを出力
	 *
	 * @param testCase
	 *            テストケース名
	 * @param e
	 *            例外
	 */
	protected void toLog(String testCase, Exception e) {

		this.log.info("##### " + testCase + " 結果 #####");
		this.log.info("Exception:" + e.getClass().getSimpleName());
		if (e instanceof EMRException) {
			this.log.info("ErrCode:" + ((EMRException) e).getErrCode());
			this.log.info("ErrMessage:" + ((EMRException) e).getErrMessage());
		}
		this.log.info(null, e);
	}

	/**
	 * PDSResponseのログを出力
	 *
	 * @param testCase
	 *            テストケース名
	 * @param response
	 *            PDS応答
	 */
	protected void toLog(String testCase, PDSResponse response) {

		StringBuilder sb = new StringBuilder("##### " + testCase + " 結果 #####");
		sb.append("\nPDSResponse:" + response);
		if (response != null) {
			sb.append("\nMetaInfo:" + response.getMetaInfo());
			sb.append("\nConditionItemInfoMap:"
					+ response.getConditionItemInfoMap());
			sb.append("\nConditionItemValueMap:"
					+ response.getConditionItemValueMap());
			sb.append("\nResultObject:" + response.getResultObject());
			sb.append("\nStatus:" + response.getStatus());
			sb.append("\nConditionFla:" + response.isCondition());
		}
		this.log.info(sb.toString());
	}

	/**
	 * ResultObjectのログを出力
	 *
	 * @param testCase
	 *            テストケース名
	 * @param result
	 *            結果オブジェクト
	 */
	protected void toLog(String testCase, ResultObject result) {

		StringBuilder sb = new StringBuilder("##### " + testCase + " 結果 #####");
		sb.append("\nResultObject:" + result);
		if (result != null) {
			sb.append("\nDataType:" + result.getDataType());
			sb.append("\nJavaDataType:" + result.getJavaDataType());
			sb.append("\nMetaInfo:" + result.getMetaInfo());
			sb.append("\nValue:" + result.getValue());
			sb.append("\nDelflg:" + result.isDeleted());
		}
		this.log.info(sb.toString());
	}

	/**
	 * イニシャルローダーエラーケーステスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @return Exception 例外
	 * @throws Exception
	 *             例外
	 */
	protected Exception invokeCheckInitialLoaderException(String testCase)
			throws Exception {

		this.replaceProp(testCase, testCase);

		try {
			new InitialLoader();
			fail("正常終了のためNG");
			return null;
		} catch (Exception e) {
			this.toLog(testCase, e);
			return e;
		}
	}

	/**
	 * イニシャルローだ例外ケースをテスト 想定結果:IllegalArgumentException
	 * @param testCase 	テストケースID
	 * @param exceptionClass 	例外クラス
	 *
	 * @throws Exception 例外
	 */
	protected void invokeCheckInitialLoaderException(String testCase,
			Class exceptionClass) throws Exception {

		this.replaceProp(testCase, testCase);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		try {
			new InitialLoader();
			fail();
		} catch (Exception e) {
			this.toLog(testCase, e);
			assertEquals(exceptionClass, e.getClass());
		}
	}

	/**
	 * イニシャルローダー正常ケーステスト
	 *
	 * @param testCase
	 *            テストケース
	 * @throws Exception
	 *             例外
	 */
	protected void invokeCheckInitialLoaderNormal(String testCase)
			throws Exception {

		this.invokeCheckInitialLoaderNormal(testCase, testCase);
	}

	/**
	 * イニシャルローダー正常ケーステスト
	 *
	 * @param testCase
	 *            テストケース
	 * @param metaXmlName
	 *            メータXML名
	 * @throws Exception
	 *             例外
	 */
	protected void invokeCheckInitialLoaderNormal(String testCase,
			String metaXmlName) throws Exception {

		this.replaceProp(testCase, metaXmlName);

		// 正常系
		new InitialLoader();
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param param1
	 *            検索キーパラメータ
	 * @return 例外
	 * @throws Exception
	 *             例外
	 */
	protected Exception invokeCheckEngineException(String testCase,
			List<String> param1) throws Exception {

		this.replaceProp(testCase, testCase);

		try {
			PDSEngine.getInstance();
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
			return null;
		} catch (Exception e) {
			this.toLog(testCase, e);
			return e;
		}
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param param1
	 *            検索キーパラメータ
	 * @param objMap1
	 *            引数項目マップ
	 * @return 例外
	 * @throws Exception
	 *             例外
	 */
	protected Exception invokeCheckEngineException(String testCase,
			List<String> param1, Map<String, Object> objMap1) throws Exception {

		this.replaceProp(testCase, testCase);

		try {
			PDSEngine.getInstance();
			PDSResponse response1 = this.getResult(param1, objMap1);
			response1.getResultObject();
			fail("正常終了のためNG");
			return null;
		} catch (Exception e) {
			this.toLog(testCase, e);
			return e;
		}
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param param1
	 *            検索キーパラメータ
	 * @return 結果オブジェクト
	 * @throws Exception
	 *             例外
	 */
	protected ResultObject invokeCheckEngineNormalResult(String testCase,
			List<String> param1) throws Exception {

		this.replaceProp(testCase, testCase);

		PDSEngine.getInstance();
		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		return response.getResultObject();
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param param1
	 *            検索キーパラメータ
	 * @param objMap1
	 *            引数項目マップ
	 * @return 結果オブジェクト
	 * @throws Exception
	 *             例外
	 */
	protected ResultObject invokeCheckEngineNormalResult(String testCase,
			List<String> param1, Map<String, Object> objMap1) throws Exception {

		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertNotNull(result1);
		return result1;
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param param1
	 *            検索キーパラメータ
	 * @return PDS応答オブジェクト
	 * @throws Exception
	 *             例外
	 */
	protected PDSResponse invokeCheckEngineNormalResponse(String testCase,
			List<String> param1) throws Exception {

		this.replaceProp(testCase, testCase);

		PDSEngine.getInstance();
		return PDSServiceAPI.getConditionItems(param1);
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param param1
	 *            検索キーパラメータ
	 * @param objMap1
	 *            引数項目マップ
	 * @return PDS応答オブジェクト
	 * @throws Exception
	 *             例外
	 */
	protected PDSResponse invokeCheckEngineNormalResponse(String testCase,
			List<String> param1, Map<String, Object> objMap1) throws Exception {

		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		assertNotNull(response1);
		return response1;
	}
}
