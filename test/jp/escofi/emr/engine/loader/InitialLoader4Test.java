/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.exception.PEXUnExpectedStateException;
import jp.iwin.pds.xml2db.datamodel.PROObjObject;
import jp.iwin.pds.xml2db.initialload.PILInitialLoader;

import org.junit.Test;

/**
 * イニシャルローダーテストクラス
 *
 * @author seo.yi
 */
public class InitialLoader4Test extends DJUnitTestCaseEx {

	/**
	 * リソースベースフォルダ
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader4";

	/**
	 *
	 */
	public InitialLoader4Test() {

		super(InitialLoader4Test.class, BASE_FOLDER);
	}

	/**
	 * エンジンテスト
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param objMap1
	 *            引数項目マップ
	 * @return 例外
	 * @throws Exception
	 *             例外
	 */
	private Exception invokeCheckEngineException(String testCase,
			Map<String, Object> objMap1) throws Exception {

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_" + testCase.substring(13) + "_1");

		Exception e = this
				.invokeCheckEngineException(testCase, param1, objMap1);
		assertNotNull("正常終了のためNG", e);
		return e;
	}

	/**
	 * テストID：PILINI_N_001_5 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 * @throws Exception 例外
	 */
	@Test
	public void testPILINI_N_001_5() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param
				.add("PILINI_N_001_5_6789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		param.add("key1_678901234567890");
		param.add("key2_678901234567890");
		param
				.add("PILINI_N_001_5_1_89012345678901234567890123456789012345678901234567890123456789012345678901234567890");

		PDSEngine.getInstance();
		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();

		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals(null, response.getConditionItemInfoMap());
		assertEquals(null, response.getConditionItemValueMap());
		assertEquals(false, response.isCondition());
		assertEquals("12345678901234567890", response.getMetaInfo());
		assertEquals(
				"12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
				result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_6 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 * @throws Exception 例外
	 */
	@Test
	public void testPILINI_N_001_6() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param
				.add("PILINI_N_001_6_6789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		param.add("key1_678901234567890");
		param.add("key2_678901234567890");
		param
				.add("PILINI_N_001_6_6789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap
				.put(
						"var4567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
						"12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_7 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_7() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add("PILINI_N_001_7");
		param1.add("key1");
		param1.add("key2");
		param1.add("PILINI_N_001_7_1");

		PDSEngine.getInstance();
		PDSResponse response1 = PDSServiceAPI.getConditionItems(param1);
		ResultObject result1 = response1.getResultObject();

		assertEquals(PCTStatus.NORMAL, response1.getStatus());
		assertEquals(null, response1.getConditionItemInfoMap());
		assertEquals(null, response1.getConditionItemValueMap());
		assertEquals(false, response1.isCondition());
		assertEquals("", response1.getMetaInfo());
		assertEquals("", result1.getValue());

		// 引数設定
		List<String> param2 = new ArrayList<String>();
		param2.add("PILINI_N_001_7");
		param2.add("key1");
		param2.add("key2");
		param2.add("PILINI_N_001_7_2");

		PDSEngine.getInstance();
		PDSResponse response2 = PDSServiceAPI.getConditionItems(param2);
		ResultObject result2 = response2.getResultObject();
		List<String> list = (List<String>) result2.getValue();

		assertEquals(PCTStatus.NORMAL, response2.getStatus());
		assertEquals(null, response2.getConditionItemInfoMap());
		assertEquals(null, response2.getConditionItemValueMap());
		assertEquals(false, response2.isCondition());
		assertEquals("", response2.getMetaInfo());
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("");
		assertEquals(expectedList, list);

		// 引数設定
		List<String> param3 = new ArrayList<String>();
		param3.add("PILINI_N_001_7");
		param3.add("key1");
		param3.add("key2");
		param3.add("PILINI_N_001_7_3");

		PDSEngine.getInstance();
		PDSResponse response3 = PDSServiceAPI.getConditionItems(param3);
		ResultObject result3 = response3.getResultObject();
		Map<String, String> map = (Map<String, String>) result3.getValue();

		assertEquals(PCTStatus.NORMAL, response3.getStatus());
		assertEquals(null, response3.getConditionItemInfoMap());
		assertEquals(null, response3.getConditionItemValueMap());
		assertEquals(false, response3.isCondition());
		assertEquals("", response3.getMetaInfo());
		Map<String, String> expectedMap = new HashMap<String, String>();
		expectedMap.put("key_1", "");
		assertEquals(expectedMap, map);

		// 引数設定
		List<String> param4 = new ArrayList<String>();
		param4.add("PILINI_N_001_7");
		param4.add("key1");
		param4.add("key2");
		param4.add("PILINI_N_001_7_4");

		PDSEngine.getInstance();
		PDSResponse response4 = PDSServiceAPI.getConditionItems(param4);
		ResultObject result4 = response4.getResultObject();
		RangeObject range = (RangeObject) result4.getValue();

		assertEquals(PCTStatus.NORMAL, response4.getStatus());
		assertEquals(null, response4.getConditionItemInfoMap());
		assertEquals(null, response4.getConditionItemValueMap());
		assertEquals(false, response4.isCondition());
		assertEquals("", response4.getMetaInfo());
		assertEquals(null, range.getUpper());
		assertEquals(null, range.getLower());
		assertEquals(true, range.includeUpper());
		assertEquals(true, range.includeLower());

		// 引数設定
		List<String> param5 = new ArrayList<String>();
		param5.add("PILINI_N_001_7");
		param5.add("key1");
		param5.add("key2");
		param5.add("PILINI_N_001_7_5");

		PDSEngine.getInstance();
		PDSResponse response5 = PDSServiceAPI.getConditionItems(param5);
		ResultObject result5 = response5.getResultObject();
		PROObjObject obj = (PROObjObject) result5.getValue();

		assertEquals(PCTStatus.NORMAL, response5.getStatus());
		assertEquals(null, response5.getConditionItemInfoMap());
		assertEquals(null, response5.getConditionItemValueMap());
		assertEquals(false, response5.isCondition());
		assertEquals("", obj.getClassName());
		assertEquals(new ArrayList<String>(), obj.getAttachedInfo());
	}

	/**
	 * テストID：PILINI_N_001_8 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_8() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add("PILINI_N_001_8");
		param.add("key1");
		param.add("PILINI_N_001_8");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_198 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_198() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字\"列");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_199 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_199() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文'字列");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_208 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_208() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attr_208_1");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字列");

		PDSEngine.getInstance();
		PDSResponse response = super.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_209 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_209() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_209_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "文字列");

		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());

		// 引数設定
		List<String> param2 = new ArrayList<String>();
		param2.add(testCase);
		param2.add("key1");
		param2.add("attr_209_2");

		Map<String, Object> objMap2 = new HashMap<String, Object>();
		objMap2.put("var", 12345678);

		PDSResponse response2 = this.getResult(param2, objMap2);
		ResultObject result2 = response2.getResultObject();
		assertEquals(true, result2.getValue());
	}

	/**
	 * テストID：PILINI_N_001_410 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_410() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr_410_1");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", 1.08E3f);
		ResultObject resultObj = this.invokeCheckEngineNormalResult(testCase, param, objMap);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * テストID：PILINI_E_001_190 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_190() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_191 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_191() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("ke>y1");
		param.add("PILINI_E_001_191");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字列");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_192 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_192() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_193 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_193() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_194 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_194() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("PILI'NI_E_001_194");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字列");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_195 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_195() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_196 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_196() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字列");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		List<String> list = (List<String>) result.getValue();

		List<String> expected = new ArrayList<String>();
		expected.add("文字>列1");
		assertEquals(expected, list);
	}

	/**
	 * テストID：PILINI_E_001_197 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_197() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_200 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_200() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_201 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_201() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:list、datatype:single)", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_202 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_202() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_203 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_203() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_204 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_204() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_205 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_205() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_206 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_206() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字列");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals("日本語", result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_207 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 * @throws Exception 例外
	 */
	@Test
	public void testPILINI_E_001_207() throws Exception {

		String testCase = this.getName().substring(4);
//		String metaXmlName = testCase;
//		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("属性_207");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "文字列");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals("日本語", result.getValue());
//		PDSEngine.getInstance();
//		PDSResponse response = PDSServiceAPI.getConditionItems(param);
//		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
	}

	/**
	 * テストID：PILINI_E_001_210 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_210() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_210_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "文字列");

		Exception e = super.invokeCheckEngineException(testCase, param1,
				objMap1);
		assertEquals(PEXUnExpectedStateException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_211 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_211() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:map、datatype:list)", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_212 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_212() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:range、datatype:map)", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_213 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_213() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:object、datatype:range)", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_214 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_214() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:list、datatype:object)", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_215 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_215() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_215_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "文字列");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		RangeObject rangeObj = (RangeObject) result1.getValue();
		assertEquals(true, rangeObj.getUpper());
		assertEquals(false, rangeObj.getLower());
		assertEquals(false, rangeObj.includeUpper());
		assertEquals(true, rangeObj.includeLower());
	}

	/**
	 * テストID：PILINI_E_001_216 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_216() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_217 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_217() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:eq、datatypes:[single, set])", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_218 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_218() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_219 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_219() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_220 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_220() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_221 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_221() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_222 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_222() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_222_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_223 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_223() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_223_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Double.class, 1.79769313486231E308d));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * テストID：PILINI_E_001_224 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_224() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_225 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_225() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_225_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_226 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_226() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"タグに不整合が存在します。(conditionType:CONDITION_GEQ、javaDataType:java.lang.Boolean、set:false)",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_227 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_227() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:geq、datatypes:[set, single])",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_228 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_228() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:geq、datatypes:[single, set])",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_229 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_229() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"タグに不整合が存在します。(conditionType:CONDITION_LT、javaDataType:java.lang.Boolean、set:false)",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_230 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_230() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_230_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "false");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_231 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_231() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:lt、datatypes:[set, single])", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_232 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_232() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:lt、datatypes:[single, set])", e
				.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_233 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_233() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_233_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_234 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_234() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"タグに不整合が存在します。(conditionType:CONDITION_LEQ、javaDataType:java.lang.Boolean、set:false)",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_235 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_235() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("タグに不整合が存在します。(elementType:leq、datatypes:[set, single])",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_236 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_236() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_237 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_237() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_237_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_238 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_238() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_238_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_239 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_239() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_239_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Double.class, 1.79769313486231E308d));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_240 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_240() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_240_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", new BigDecimal("1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_241 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_241() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_241_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_242 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_242() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_242_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_243 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_243() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_243_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Integer.class, Integer.MAX_VALUE));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_244 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_244() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_244_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Long.MAX_VALUE);

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_245 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_245() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_245_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Boolean.class, true, false));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_N_001_246 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_246() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_246_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(String.class, "true", "false", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(false, result1.getValue());
	}

	/**
	 * テストID：PILINI_N_001_249 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_249() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_249_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(String.class, "true", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(false, result1.getValue());
	}

	/**
	 * テストID：PILINI_N_001_254 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_254() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_254_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(String.class, "false", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_N_001_257 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_257() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_257_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(String.class, "true", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(false, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_247 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_247() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_247_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", 1.79769313486231E308d);

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * テストID：PILINI_E_001_248 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_248() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_248_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(BigDecimal.class,
				"1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_250 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_250() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_250_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Boolean.class, true));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_251 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_251() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_251_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Integer.class, Integer.MAX_VALUE));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_252 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_252() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_252_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Long.MAX_VALUE);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_253 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_253() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_253_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Boolean.class, true, false));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_255 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_255() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_255_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", 1.79769313486231E308d);

		Exception e = super.invokeCheckEngineException(testCase, param1,
				objMap1);
		System.out.println(e);
	}

	/**
	 * テストID：PILINI_E_001_256 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_256() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_256_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(BigDecimal.class,
				"1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_258 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_258() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_258_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Boolean.class, true));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_259 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_259() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_259_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Integer.class, Integer.MAX_VALUE));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_260 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_260() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_260_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Long.MAX_VALUE);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_261 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_261() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_261_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_262 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_262() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_262_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_263 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_263() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_263_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Double.class, -1.79769313486231E308d));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * テストID：PILINI_E_001_264 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_264() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_264_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", new BigDecimal("-1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_265 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_265() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_265_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "false");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_266 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_266() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_266_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_267 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_267() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_267_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", 0);

		try {
			new PILInitialLoader();
			fail("正常終了のためNG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * テストID：PILINI_E_001_268 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_268() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_268_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Long.class, Long.MIN_VALUE));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * テストID：PILINI_E_001_269 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_269() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_269_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * テストID：PILINI_E_001_270 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_270() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_270_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "2147483647abc");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_271 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_271() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_271_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(String.class, "abcxxx"));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * テストID：PILINI_E_001_272 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_272() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"タグに不整合が存在します。(elementType:startswith、datatypes:[single, set])",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_273 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_273() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_273_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "92233");

		ResultObject result1 = this.invokeCheckEngineNormalResult(testCase,
				param1, objMap1);
		assertEquals(false, result1.getValue());
	}

	/**
	 * テストID：PILINI_E_001_274 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_274() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_275 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_275() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"タグに不整合が存在します。(elementType:nstartswith、datatypes:[set, single])",
				e.getMessage());
	}

	/**
	 * テストID：PILINI_E_001_276 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_276() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_277 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_277() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_278 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_278() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_279 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_279() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_280 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_280() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_281 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_281() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_282 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_282() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_283 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_283() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_284 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_284() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_285 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_285() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_286 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_286() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_287 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_287() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_288 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_288() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_289 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_289() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_290 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_290() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_291 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_291() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_292 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_292() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_293 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_293() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_294 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_294() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_295 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_295() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_296 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_296() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_297 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_297() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_298 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_298() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_299 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_299() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_300 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_300() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_301 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_301() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_302 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_302() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_303 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_303() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_304 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_304() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_305 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_305() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_306 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_306() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_307 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_307() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_308 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_308() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_378 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_378() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_379 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_379() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_380 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_380() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_381 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_381() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_382 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_382() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_383 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_383() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_384 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_384() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_385 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_385() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_386 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_386() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_387 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_387() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_388 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_388() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_389 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_389() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_390 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_390() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_391 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_391() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_392 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_392() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_393 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_393() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_394 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_394() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_395 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_395() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_396 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_396() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_397 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_397() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_398 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_398() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_399 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_399() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_400 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_400() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_401 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_401() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_402 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_402() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_403 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_403() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_404 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_404() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_405 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_405() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_406 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_406() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_407 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_407() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_408 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_408() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_409 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_409() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_411 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_411() throws Exception {

		String testCase = this.getName().substring(4);
		Map<String, Object> objMap1 = new HashMap<String, Object>();
		Exception e = this.invokeCheckEngineException(testCase, objMap1);
		assertEquals(PEXUnExpectedStateException.class, e.getClass());
	}
}
