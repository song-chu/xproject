package jp.escofi.emr.engine.loader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.BigDecimalEx;
import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;

import org.junit.Test;
import org.xml.sax.SAXParseException;

/**
 * イニシャルローダーテストクラス
 *
 * @author seo.yj
 */
public class InitialLoader5Test extends DJUnitTestCaseEx {

	/**
	 * リソースベースフォルダ
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/InitialLoader5";

	public InitialLoader5Test() {

		super(InitialLoader5Test.class, BASE_FOLDER);
	}

	/**
	 * テストID：PILINI_N_001_332 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_332() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 検索①の引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr33");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value33", result.getValue().toString());

		// 検索②の引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr32");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// 検索③の引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr31");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// 検索④の引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr22");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value22", result.getValue().toString());

		// 検索⑤の引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr21");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// 検索⑥の引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value1", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_N_001_339 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_339() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		PDSEngine.getInstance();

		super.logPdsObjects();

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();
		assertEquals("value31", result.getValue().toString());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr21");

		response = PDSServiceAPI.getConditionItems(param);
		result = response.getResultObject();
		assertEquals("value21", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_N_001_340 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_340() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		PDSEngine.getInstance();

		super.logPdsObjects();

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();
		assertEquals("value31", result.getValue().toString());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr22");

		response = PDSServiceAPI.getConditionItems(param);
		result = response.getResultObject();
		assertEquals("value22", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_N_001_341 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_341() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		PDSEngine.getInstance();

		super.logPdsObjects();

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();
		assertEquals("value31", result.getValue().toString());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr23");

		response = PDSServiceAPI.getConditionItems(param);
		result = response.getResultObject();
		assertEquals("value23", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_N_001_343 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_343() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr21");

		// 引数設定
		List<String> param2 = new ArrayList<String>();
		param2.add(testCase);
		param2.add("key1");
		param2.add("key2");
		param2.add("attr3");

		ResultObject result1 = super.getResult(param1);
		assertEquals("value21", result1.getValue());

		ResultObject result2 = super.getResult(param2);
		assertEquals("value31", result2.getValue());
	}

	/**
	 * テストID：PILINI_N_001_344 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_344() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr21");
		param1.add("001");

		List<String> param2 = new ArrayList<String>();
		param2.add(testCase);
		param2.add("key1");
		param2.add("key2");
		param2.add("attr3");
		param2.add("001");

		ResultObject result1 = super.getResult(param1);
		assertEquals("value21", result1.getValue());

		ResultObject result2 = super.getResult(param2);
		assertEquals("value31", result2.getValue());
	}

	/**
	 * テストID：PILINI_N_001_346 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_346() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr3");

		ResultObject result1 = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals("value3", result1.getValue());
	}

	/**
	 * テストID：PILINI_N_001_352 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_352() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();
		super.logPdsObjects();

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attrname1");
		ResultObject result = super.getResult(param);
		assertEquals("common352", result.getValue());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attrname2");
		result = super.getResult(param);
		assertEquals("standard352", result.getValue());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attrname3");
		result = super.getResult(param);
		assertEquals("value352", result.getValue());

		param.clear();
		param.add("PILINI_N_001_352_Std_2");
		param.add("stdkey1");
		param.add("attrname4");
		result = super.getResult(param);
		assertEquals("standard352_2", result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_372 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_372() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);
		ResultObject resultObj = super.invokeCheckEngineNormalResult(testCase, param, objMap);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * テストID：PILINI_E_001_309 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_309() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		assertEquals("value309_2_5", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_310 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_310() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase.concat("_1"));
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		assertEquals("value310_1_5", result.getValue().toString());
		super.toLog(testCase, response);
		super.toLog(testCase, result);

		// 引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase.concat("_2"));
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();

		assertEquals("value310_1_5", result.getValue().toString());
		super.toLog(testCase, response);
		super.toLog(testCase, result);
	}

	/**
	 * テストID：PILINI_E_001_311 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_311() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_312 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_312() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_313 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_313() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_314 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_314() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_315 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_315() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_316 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_316() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_317 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_317() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertTrue("エラーメッセージが相違", e.getMessage().startsWith(
				"継承対象データモデルが見つかりません。"));
	}

	/**
	 * テストID：PILINI_E_001_318 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_318() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (UnExpectedStateException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_319 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_319() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		try {
			new InitialLoader();
			fail("正常終了のためNG");
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_320 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_320() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		try {
			new InitialLoader();
			fail("正常終了のためNG");
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_321 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_321() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		try {
			new InitialLoader();
			fail("正常終了のためNG");
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_322 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_322() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		List<String> param1 = null;

		PDSEngine.getInstance();

		// テスト①
		for (int i = 1; i < 4; i++) {

			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key0");
			param1.add("key1");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
				fail("正常終了のためNG");
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}

		// テスト②
		for (int i = 1; i < 4; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}
	}

	/**
	 * テストID：PILINI_E_001_323 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_323() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;

		for (int i = 1; i < 4; i++) {
			// テスト①
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key7");
			param1.add("key8");
			param1.add("key1");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
				fail("正常終了のためNG");
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}

		for (int i = 1; i < 4; i++) {
			// テスト②
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key7");
			param1.add("key8");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
				fail("正常終了のためNG");
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}
	}

	/**
	 * テストID：PILINI_E_001_324 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_324() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// テスト①引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key5");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value324", result.getValue().toString());

		// テスト②引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key5");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard324", result.getValue().toString());

		// テスト③引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key5");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);
		super.toLog(testCase, response);
		super.toLog(testCase, result);
	}

	/**
	 * テストID：PILINI_E_001_325 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_325() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// テスト①引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value325", result.getValue().toString());

		// テスト②引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard325", result.getValue().toString());

		// テスト③引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);
	}

	/**
	 * テストID：PILINI_E_001_326 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_326() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// テスト①引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key7");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value326", result.getValue().toString());

		// テスト②引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key7");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard326", result.getValue().toString());

		// テスト③引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key7");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("common326", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_327 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_327() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// テスト①引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value327", result.getValue().toString());

		// テスト②引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard327", result.getValue().toString());

		// テスト③引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("common327", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_328 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_328() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// テスト①引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value328", result.getValue().toString());

		// テスト②引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("stdkey1");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard328", result.getValue().toString());

		// テスト③引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("stdkey1");
		param1.add("attrname3");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("common328", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_329 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_329() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value329_2", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_330 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_330() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr1");
		param1.add("005");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("attrname2", result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_331 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_331() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr2");
		param1.add("001");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals(false, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_333 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_333() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// 検索①の引数設定（最上位）
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr1");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// 検索②の引数設定（上位）
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr2");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// 検索③の引数設定（独自）
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * テストID：PILINI_E_001_334 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_334() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// 検索①の引数設定（最上位）
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr1");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// 検索②の引数設定（上位）
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr2");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// 検索③の引数設定（独自）
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * テストID：PILINI_E_001_335 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_335() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// 引数設定（独自）
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr3");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value31", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_336 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_336() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// 検索①の引数設定（最上位）
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr1");
		param1.add("003");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		this.toLog(testCase, response);
		this.toLog(testCase, result);

		// 検索②の引数設定（上位）
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr2");
		param1.add("003");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value21", result.getValue().toString());
		System.out.println(result.getValue());

		// 検索③の引数設定（独自）
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * テストID：PILINI_E_001_337 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_337() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// 検索①の引数設定（最上位）
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr1");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// 検索②の引数設定（上位）
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr2");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// 検索③の引数設定（独自）
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * テストID：PILINI_E_001_338 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_338() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSEngine.getInstance();
		super.logPdsObjects();

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		super.toLog(testCase, response);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");
		param.add("001");

		try {
			response = PDSServiceAPI.getConditionItems(param);
			fail();
		} catch (InvalidKeyException ex) {
			super.toLog(testCase, ex);
		}
	}

	/**
	 * テストID：PILINI_E_001_342 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_342() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_345 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_345() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_347 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_347() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_348 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_348() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertTrue("エラーメッセージが相違", e.getMessage().startsWith(
				"継承対象データモデルが見つかりません。"));
	}

	/**
	 * テストID：PILINI_E_001_349 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_349() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();
		super.logPdsObjects();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (UnExpectedStateException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_350 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_350() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_351 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_351() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertTrue("エラーメッセージが相違", e.getMessage().startsWith(
				"継承対象データモデルが見つかりません。"));
	}

	/**
	 * テストID：PILINI_E_001_353 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_353() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_354 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_354() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key3");
		param1.add("attrname1");

		PDSEngine.getInstance();
		super.logPdsObjects();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value354", result.getValue().toString());

		// 引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key3");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// 引数設定
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key3");
		param1.add("attrname3");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);
	}

	/**
	 * テストID：PILINI_E_001_355 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_355() throws Exception {

		super.replaceProperty("xml.meta.schema.filepath", "");
		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_356 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_356() throws Exception {

		super.replaceProperty("xml.meta.schema.filepath", "Z:/PDSNgine/xsd/abc.xsd");
		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());

//		super.replaceProp(testCase, testCase);
//
//		// 引数設定
//		List<String> param1 = new ArrayList<String>();
//		param1.add(testCase);
//		param1.add("attrname1");
//
//		PDSEngine.getInstance();
//
//		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
//		ResultObject result = response.getResultObject();
//		assertEquals(PCTStatus.NORMAL, response.getStatus());
//		assertEquals("value356", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_357 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_357() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value357", result.getValue().toString());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(EMRException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML管理が無効です。（ファイル名：PILINI_E_001_357_Meta.xml）", pe.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_358 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_358() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProperty("xml.schema.filepath", "");
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_359 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_359() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProperty("xml.schema.filepath", "abc.xsd");
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());
	}

//	/**
//	 * テストID：PILINI_E_001_360 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
//	 */
//	@Test
//	public void testPILINI_E_001_360() throws Exception {
//
//		String testCase = this.getName().substring(4);
//		String metaXmlName = testCase;
//		super.replaceProp(testCase, metaXmlName);
//
//		// 引数設定
//		List<String> param1 = new ArrayList<String>();
//		param1.add(testCase);
//		param1.add("attrname1");
//
//		ResultObject resultObj = super.invokeCheckEngineNormalResult(testCase, param1);
//		assertEquals("value360", resultObj.getValue());
//	}

	/**
	 * テストID：PILINI_E_001_361 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_361() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attrname1");
		param1.add("version");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value361", result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_362 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_362() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("正常終了のためNG");
		} catch (UnExpectedStateException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_363 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_363() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		System.out.println("文字化けを確認：" + result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_364 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_364() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		System.out.println("文字化けを確認：" + result.getValue().toString());
	}

	/**
	 * テストID：PILINI_E_001_365 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_365() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		IllegalArgumentException iae = (IllegalArgumentException) e;
		assertEquals("Attribute 'name' must be set on element 'datamodel'.",
				iae.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_366 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_366() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_367 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_367() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1, objMap1);
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_368 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_368() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1, objMap1);
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_369 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_369() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_370 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_370() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
		EMRException pe = (EMRException) e;
		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
		assertEquals("データモデルＸＭＬファイルが無効です。（ファイル名：PILINI_E_001_370.xml）", pe
				.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_371 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_371() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
		EMRException pe = (EMRException) e;
		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
		assertEquals("データモデルＸＭＬファイルが無効です。（ファイル名：PILINI_E_001_371.xml）", pe
				.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_373 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_373() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_374 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_374() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_375 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_375() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		try {
			new InitialLoader();
			fail();
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_N_001_376 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_376() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		this.replaceProp(testCase, testCase);
		PDSEngine.getInstance();
		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		super.toLog(testCase, response);
		assertEquals(PCTStatus.DELETED, response.getStatus());

		ResultObject result = response.getResultObject();
		super.toLog(testCase, result);
	}

	/**
	 * テストID：PILINI_E_001_377 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_377() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	// /**
	// * テストID：PILINI_E_001_412 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	// */
	// @Test
	// public void testPILINI_E_001_412() throws Exception {
	//
	// String testCase = this.getName().substring(4);
	// String metaXmlName = testCase;
	// super.replaceProp(testCase, metaXmlName);
	//
	// // 引数設定
	// List<String> param1 = new ArrayList<String>();
	// param1.add(testCase);
	// param1.add("attrname1");
	//
	// try {
	// new InitialLoader();
	// fail();
	// } catch (EMRException e) {
	// this.toLog(testCase, e);
	// }
	// }

	/**
	 * テストID：PILINI_E_001_413 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_413() throws Exception {

		String testCase = this.getName().substring(4);
//		String metaXmlName = testCase;
//		super.replaceProp(testCase, metaXmlName);
//
//		// 引数設定
//		List<String> param1 = new ArrayList<String>();
//		param1.add(testCase);
//		param1.add("attrname1");
//
//		PDSEngine.getInstance();
//
//		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
//		ResultObject result = response.getResultObject();
//
//		assertEquals("value413", result.getValue().toString());

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
		EMRException pe = (EMRException)e;
		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
		assertEquals("XML管理が無効です。（ファイル名：PILINI_E_001_413_Meta.xml）", pe.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_418 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_418() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_N_001_419 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_419() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimalEx("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		assertEquals(new BigDecimalEx("9.8765432109876543210E310"), resultObj
				.getValue());
	}

	/**
	 * テストID：PILINI_N_001_420 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_420() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimal("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		List<BigDecimalEx> expected = new ArrayList<BigDecimalEx>();
		expected.add(new BigDecimalEx("9.8765432109876543210E310"));
		expected.add(new BigDecimalEx("1.2345678901234567890E310"));
		assertEquals(expected, resultObj.getValue());
	}

	/**
	 * テストID：PILINI_N_001_421 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_421() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimal("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		Map<String, BigDecimalEx> expected = new HashMap<String, BigDecimalEx>();
		expected.put("key1", new BigDecimalEx("9.8765432109876543210E310"));
		expected.put("key2", new BigDecimalEx("1.2345678901234567890E310"));
		assertEquals(expected, resultObj.getValue());
	}

	/**
	 * テストID：PILINI_N_001_422 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_422() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimalEx("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		RangeObject expected = (RangeObject) resultObj.getValue();
		assertEquals(true, expected.includeUpper());
		assertEquals(true, expected.includeLower());
		assertEquals(new BigDecimalEx("9.8765432109876543210E310"), expected
				.getUpper());
		assertEquals(new BigDecimalEx("1.2345678901234567890E310"), expected
				.getLower());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("attr2");
		resultObj = super.getResult(param);
		assertEquals(new BigDecimalEx("1.2345678901234567890E310"), resultObj
				.getValue());
	}

	/**
	 * テストID：PILINI_E_001_423
	 */
	@Test
	public void testPILINI_E_001_423() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * テストID：PILINI_E_001_424
	 */
	@Test
	public void testPILINI_E_001_424() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * テストID：PILINI_E_001_425
	 */
	@Test
	public void testPILINI_E_001_425() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * テストID：PILINI_E_001_426
	 */
	@Test
	public void testPILINI_E_001_426() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * テストID：PILINI_E_001_427
	 */
	@Test
	public void testPILINI_E_001_427() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * テストID：PILINI_E_001_428
	 */
	@Test
	public void testPILINI_E_001_428() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * テストID：PILINI_E_001_429
	 */
	@Test
	public void testPILINI_E_001_429() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * テストID：PILINI_E_001_430
	 */
	@Test
	public void testPILINI_E_001_430() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * テストID：PILINI_E_001_431
	 */
	@Test
	public void testPILINI_E_001_431() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
}
