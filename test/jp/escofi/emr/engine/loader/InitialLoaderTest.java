/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.initialload.PILInitialLoader;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * イニシャルローダーテストクラス
 *
 * @author seo.yi
 */
public class InitialLoaderTest extends DJUnitTestCaseEx {

	/**
	 * リソースベースフォルダ
	 */
	protected static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader";

	/**
	 * コンストラクタ
	 */
	public InitialLoaderTest() {

		super(InitialLoaderTest.class, BASE_FOLDER);
	}

	/**
	 * テストID：PILINI_N_001_1 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	 */
	@Test
	public void testPILINI_N_001_1() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add(testCase);
		parameter1.add("attrname1");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("ConditionItem001", 150);
		objMap.put("ConditionItem001", 150);
		objMap.put("ConditionItem003", 150);
		objMap.put("ConditionItem004", 150);
		objMap.put("ConditionItem005", 150);
		objMap.put("ConditionItem006", 150);
		objMap.put("ConditionItem007", 150);
		objMap.put("ConditionItem008", this.getSet(BigDecimal.class,
				"1.23450e331", "-1.2345e-310"));
		objMap.put("ConditionItem009", this.getSet(Integer.class, 140, 150));
		objMap.put("ConditionItem010", this.getSet(Integer.class, 120, 150));
		objMap.put("ConditionItem011", this
				.getSet(Integer.class, 120, 150, 170));
		objMap.put("ConditionItem012", this.getSet(Integer.class, 130, 160));
		objMap.put("ConditionItem013", 150);
		objMap.put("ConditionItem014", 170);
		objMap.put("ConditionItem015", "abc");
		objMap.put("ConditionItem016", "bbbc");
		objMap.put("ConditionItem017", this.getSet(Integer.class, 1, 2, 3));

		PDSResponse response = super.invokeCheckEngineNormalResponse(testCase,
				parameter1, objMap);

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// 条件文有無確認
		assertEquals(true, response.isCondition());
		// 属性値確認
		String result = (String) response.getResultObject().getValue();
		// 結果値
		assertEquals("value1", result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PILINI_N_001_2 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	 */
	@Test
	public void testPILINI_N_001_2() throws Exception {

		this.replaceProp(this.getName().substring(4));

		PDSEngine engine = PDSEngine.getInstance();
		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(engine);

		Field pdsItemKeysField = PDSEngine.class
				.getDeclaredField("pdsItemKeys");
		pdsItemKeysField.setAccessible(true);
		HashMap<String, List<String>> pdsItemKeys = (HashMap<String, List<String>>) pdsItemKeysField
				.get(engine);

		// ----------------------<<結果確認１>>-------------------------------//
		// イニシャルロード済みのオブジェクトのサイズ及び、アイテムキーサイズをチェック
		assertEquals(52, pdsObjects.size());
		assertEquals(52, pdsItemKeys.size());

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PILINI_N_001_15");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		// 引数項目取得処理
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<結果確認２>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// 条件文有無確認
		assertEquals(false, response.isCondition());
		// 属性値確認
		List<Integer> resultObjectValue = (List<Integer>) response
				.getResultObject().getValue();

		// 期待値
		List<Integer> expectedResultObjectValue = new ArrayList<Integer>();
		expectedResultObjectValue.add(112233);
		expectedResultObjectValue.add(223344);
		expectedResultObjectValue.add(334455);
		expectedResultObjectValue.add(445566);
		expectedResultObjectValue.add(556677);

		assertEquals(expectedResultObjectValue, resultObjectValue);

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER + "/All", "all");
		}
	}

	/**
	 * テストID：PILINI_N_001_3 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	 */
	@Test
	public void testPILINI_N_001_3() throws Exception {

		this.replaceProp(this.getName().substring(4));

		PDSEngine engine = PDSEngine.getInstance();
		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(engine);

		Field pdsItemKeysField = PDSEngine.class
				.getDeclaredField("pdsItemKeys");
		pdsItemKeysField.setAccessible(true);
		HashMap<String, List<String>> pdsItemKeys = (HashMap<String, List<String>>) pdsItemKeysField
				.get(engine);

		// ----------------------<<結果確認１>>-------------------------------//
		// イニシャルロード済みのオブジェクトのサイズ及び、アイテムキーサイズをチェック
		assertEquals(52, pdsObjects.size());
		assertEquals(52, pdsItemKeys.size());

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PILINI_N_001_35");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		// 引数項目取得処理
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<結果確認２>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// 条件文有無確認
		assertEquals(false, response.isCondition());
		// 属性値確認
		ResultObject resultObject = response
				.getResultObject();
		// 削除フラグ確認
		assertEquals("value035_2", ((String) resultObject.getValue()));

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PILINI_N_001_4 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	 */
	@Test
	public void testPILINI_N_001_4() throws Exception {

		this.replaceProp(this.getName().substring(4));

		PDSEngine engine = PDSEngine.getInstance();
		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(engine);

		Field pdsItemKeysField = PDSEngine.class
				.getDeclaredField("pdsItemKeys");
		pdsItemKeysField.setAccessible(true);
		HashMap<String, List<String>> pdsItemKeys = (HashMap<String, List<String>>) pdsItemKeysField
				.get(engine);

		// ----------------------<<結果確認１>>-------------------------------//
		// イニシャルロード済みのオブジェクトのサイズ及び、アイテムキーサイズをチェック
		assertEquals(52, pdsObjects.size());
		assertEquals(52, pdsItemKeys.size());

		// 引数設定
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PILINI_N_001_45");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		// 引数項目取得処理
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<結果確認２>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// 条件文有無確認
		assertEquals(false, response.isCondition());
		// 属性値確認
		ResultObject result = response.getResultObject();
		// 削除フラグ確認
		assertEquals("common001", ((String) result.getValue()));

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * テストID：PILINI_E_001_1 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_1() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "XML管理が存在しません。（ファイルパス：Z:/PDSNgine/xml/PILInitialLoader/PILINI_E_001_1_Meta.xml）";
		assertEquals(PCTMessageCode.P004E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_2 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_2() throws Exception {

		String testCase = this.getName().substring(4);
		this.replaceProp(testCase, testCase + "_XXX");

		// 異常系でPEXExceptionが期待されるケース
		try {
			PILInitialLoader loader = new PILInitialLoader();
			fail();
		} catch (PEXException e) {
			String expectedMessage = "XML管理が存在しません。（ファイルパス：Z:/PDSNgine/xml/PILInitialLoader/PILINI_E_001_2_XXX_Meta.xml）";
			assertEquals(PCTMessageCode.P004E, e.getErrCode());
			assertEquals(expectedMessage, e.getErrMessage());
		}
	}

	/**
	 * テストID：PILINI_E_001_3 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_3() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "XML管理が無効です。（ファイル名：PILINI_E_001_3_Meta.xml）";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_4 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_4() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(DocumentBuilderFactory.class,
				"newDocumentBuilder", 0, new ParserConfigurationException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(ParserConfigurationException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_5 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_5() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(DocumentBuilder.class, "parse", 0,
				new IOException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IOException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_6 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_6() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0,
				new SAXException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_7 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_7() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(SAXParser.class, "getXMLReader", 0,
				new SAXException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_8 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_8() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0,
				new ParserConfigurationException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(ParserConfigurationException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_9 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_9() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "データモデルＸＭＬファイルが存在しません。（ファイルパス：Z:/PDSNgine/xml/PILInitialLoader"
				+ FILE_SEPARATOR + "PILINI_E_001_9.xml）";
		assertEquals(PCTMessageCode.P004E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_10 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_10() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "データモデルＸＭＬファイルが存在しません。（ファイルパス：Z:/PDSNgine/xml/PILInitialLoader"
				+ FILE_SEPARATOR + "PILINI_E_001_10_XXX.xml）";
		assertEquals(PCTMessageCode.P004E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_11 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_11() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "データモデルＸＭＬファイルが無効です。（ファイル名：PILINI_E_001_11.xml）";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_12 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_12() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(XMLReader.class, "parse", 0, new IOException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IOException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_13 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_13() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "データモデルＸＭＬファイルが無効です。（ファイル名：PILINI_E_001_13.xml）";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_14 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_14() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_15 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_15() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_16 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_16() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "データモデルＸＭＬファイルが無効です。（ファイル名：PILINI_E_001_16.xml）";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_17 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_17() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "データモデルＸＭＬファイルが無効です。（ファイル名：PILINI_E_001_17.xml）";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	// /**
	// * テストID：PILINI_E_001_18 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	// */
	// @Test
	// public void testPILINI_E_001_18() throws Exception {
	//
	// this.replaceProp(this.getName().substring(4));
	//
	// PDSEngine engine = PDSEngine.getInstance();
	//
	// // 引数設定
	// List<String> parameter1 = new ArrayList<String>();
	// parameter1.add("PILINI_E_001_18");
	// parameter1.add("attr1");
	//
	// Map<String, Object> objMap = new HashMap<String, Object>();
	// objMap.put("ConditionItem001", 100);
	// objMap.put("ConditionItem002", 101);
	//
	// // 引数項目取得処理
	// PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);
	//
	// Map<String, PROConditionItemInfo> conditionItemInfoMap = response
	// .getConditionItemInfoMap();
	//
	// assertNotNull(conditionItemInfoMap);
	//
	// // 引数項目値Map
	// Map<String, Object> conditionItemValueMap = new HashMap<String,
	// Object>();
	//
	// Collection<PROConditionItemInfo> collection = conditionItemInfoMap
	// .values();
	// for (PROConditionItemInfo conditionItemInfo : collection) {
	// // 引数項目クラスから情報を取得する。
	// String itemName = conditionItemInfo.getItemName();
	// String javaDataType = conditionItemInfo.getJavaDataType();
	//
	// // 引数項目値マップに設定
	// if (objMap.containsKey(itemName)) {
	// Object varValue = PUTConvertUtil.convert(objMap.get(itemName),
	// javaDataType);
	// conditionItemValueMap.put(itemName, varValue);
	// }
	// }
	// // PDS応答クラスに引数項目値マップを設定
	// response.setConditionItemValueMap(conditionItemValueMap);
	//
	// try {
	// // 属性値取得メソッドを呼び出す。
	// response = PDSServiceAPI.getAttrValue(response);
	// fail();
	// } catch (PEXConditionNotMatchedException e) {
	// assertTrue(true);
	// }
	// }
	//
	// /**
	// * テストID：PILINI_E_001_19 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	// */
	// @Test
	// public void testPILINI_E_001_19() throws Exception {
	//
	// this.replaceProp(this.getName().substring(4));
	//
	// PDSEngine engine = PDSEngine.getInstance();
	//
	// // 引数設定
	// List<String> parameter1 = new ArrayList<String>();
	// parameter1.add("PILINI_E_001_19");
	// parameter1.add("attr1");
	//
	// Map<String, Object> objMap = new HashMap<String, Object>();
	// objMap.put("ConditionItem001", 101);
	//
	// // 引数項目取得処理
	// PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);
	//
	// Map<String, PROConditionItemInfo> conditionItemInfoMap = response
	// .getConditionItemInfoMap();
	//
	// assertNotNull(conditionItemInfoMap);
	//
	// // 引数項目値Map
	// Map<String, Object> conditionItemValueMap = new HashMap<String,
	// Object>();
	//
	// Collection<PROConditionItemInfo> collection = conditionItemInfoMap
	// .values();
	// for (PROConditionItemInfo conditionItemInfo : collection) {
	// // 引数項目クラスから情報を取得する。
	// String itemName = conditionItemInfo.getItemName();
	// String javaDataType = conditionItemInfo.getJavaDataType();
	//
	// // 引数項目値マップに設定
	// if (objMap.containsKey(itemName)) {
	// Object varValue = PUTConvertUtil.convert(objMap.get(itemName),
	// javaDataType);
	// conditionItemValueMap.put(itemName, varValue);
	// }
	// }
	// // PDS応答クラスに引数項目値マップを設定
	// response.setConditionItemValueMap(conditionItemValueMap);
	//
	// try {
	// // 属性値取得メソッドを呼び出す。
	// response = PDSServiceAPI.getAttrValue(response);
	// fail();
	// } catch (PEXConditionNotMatchedException e) {
	// assertTrue(true);
	// }
	// }
	//
	// /**
	// * テストID：PILINI_E_001_20 イニシャルローダーのコンストラクタ→PDSオブジェクトマップ・キー項目マップ取得→結果確認
	// */
	// @Test
	// public void testPILINI_E_001_20() throws Exception {
	//
	// this.replaceProp(this.getName().substring(4));
	//
	// PDSEngine engine = PDSEngine.getInstance();
	//
	// // 引数設定
	// List<String> parameter1 = new ArrayList<String>();
	// parameter1.add("PILINI_E_001_20");
	// parameter1.add("attr1");
	//
	// Map<String, Object> objMap = new HashMap<String, Object>();
	// objMap.put("ConditionItem001", 100);
	//
	// // 引数項目取得処理
	// PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);
	//
	// Map<String, PROConditionItemInfo> conditionItemInfoMap = response
	// .getConditionItemInfoMap();
	//
	// assertNotNull(conditionItemInfoMap);
	//
	// // 引数項目値Map
	// Map<String, Object> conditionItemValueMap = new HashMap<String,
	// Object>();
	//
	// Collection<PROConditionItemInfo> collection = conditionItemInfoMap
	// .values();
	// for (PROConditionItemInfo conditionItemInfo : collection) {
	// // 引数項目クラスから情報を取得する。
	// String itemName = conditionItemInfo.getItemName();
	// String javaDataType = conditionItemInfo.getJavaDataType();
	//
	// // 引数項目値マップに設定
	// if (objMap.containsKey(itemName)) {
	// Object varValue = PUTConvertUtil.convert(objMap.get(itemName),
	// javaDataType);
	// conditionItemValueMap.put(itemName, varValue);
	// }
	// }
	// // PDS応答クラスに引数項目値マップを設定
	// response.setConditionItemValueMap(conditionItemValueMap);
	//
	// // 属性値取得メソッドを呼び出す。
	// response = PDSServiceAPI.getAttrValue(response);
	//
	// // ダンプ実行
	// PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
	// .substring(4));
	// }
}
