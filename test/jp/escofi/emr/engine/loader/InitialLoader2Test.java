/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.ResultObject;

import org.junit.Test;

/**
 * イニシャルローダーテストクラス
 *
 * @author seo.yi
 */
public class InitialLoader2Test extends DJUnitTestCaseEx {

	/**
	 * リソースベースフォルダ
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader2";

	public InitialLoader2Test() {

		super(InitialLoader2Test.class, BASE_FOLDER);
	}

	/**
	 * テストID：PILINI_N_001_75 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_75() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_76 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_76() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_77 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_77() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_79 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_79() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_80 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_80() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_81 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_81() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_83 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_83() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_84 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_84() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_85 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_85() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_87 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_87() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_88 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_88() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_89 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_89() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_92 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_92() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_93 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_93() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_96 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_96() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_97 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_97() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_100 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_100() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_101 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_101() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_104 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_104() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_105 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_105() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_109 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_109() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_113 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_113() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_117 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_117() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_121 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_121() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * テストID：PILINI_N_001_414 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_414() throws Exception {

		String testCase = this.getName().substring(4);
		String no = testCase.substring(13);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + no + "_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "");

		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param1, objMap1);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * テストID：PILINI_N_001_415 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_415() throws Exception {

		String testCase = this.getName().substring(4);
		this.replaceProp(testCase, testCase);

		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + testCase.substring(13) + "_1");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		List<String> expected = new ArrayList<String>();
		expected.add("abc");
		expected.add("");
		assertEquals(expected, result.getValue());
	}

	/**
	 * テストID：PILINI_N_001_416 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_416() throws Exception {

		String testCase = this.getName().substring(4);
		String no = testCase.substring(13);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + no + "_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(String.class, "", "abc"));

		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param1, objMap1);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * テストID：PILINI_N_001_417 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_417() throws Exception {

		String testCase = this.getName().substring(4);

		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + testCase.substring(13) + "_1");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "");
		assertEquals(expected, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_18 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_18() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_19 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_19() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_20 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_20() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_21 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_21() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_22 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_22() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_23 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_23() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_24 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_24() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_25 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_25() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_26 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_26() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_27 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_27() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_28 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_28() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_29 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_29() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_30 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_30() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_31 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_31() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_32 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_32() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_33 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_33() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_34 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_34() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_35 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_35() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_36 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_36() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_37 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_37() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_38 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_38() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_39 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_39() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_40 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_40() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_41 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_41() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_42 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_42() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_43 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_43() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_44 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_44() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_45 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_45() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_46 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_46() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_47 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_47() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_48 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_48() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_49 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_49() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_50 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_50() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_51 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_51() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_52 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_52() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_53 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_53() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_54 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_54() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_55 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_55() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_56 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_56() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_57 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_57() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_58 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_58() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_59 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_59() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_40 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_60() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_61 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_61() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_62 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_62() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_63 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_63() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_64 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_64() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_65 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_65() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_66 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_66() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_67 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_67() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_68 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_68() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_69 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_69() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_70 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_70() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_71 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_71() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_72 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_72() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_73 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_73() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_74 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_74() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_78 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_78() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_82 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_82() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_86 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_86() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_90 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_90() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_91 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_91() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_94 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_94() throws Exception {

		String testCase = this.getName().substring(4);

		// 正常系
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_95 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_95() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_98 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_98() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_99 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_99() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_102 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_102() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_103 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_103() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_106 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_106() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_107 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_107() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_108 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_108() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_110 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_110() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_111 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_111() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_112 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_112() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_114 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_114() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_115 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_115() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_116 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_116() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_118 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_118() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_119 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_119() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_120 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_120() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_122 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_122() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_123 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_123() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_124 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_124() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_125 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_125() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		String dataModelName = testCase;
		String attrName = testCase;

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(dataModelName);
		param.add(attrName);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Double.NEGATIVE_INFINITY);

		PDSEngine.getInstance();
		PDSResponse response = super.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_126 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_126() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_127 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_127() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_128 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_128() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_129 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_129() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		List<Double> list = new ArrayList<Double>();
		list.add(Double.NEGATIVE_INFINITY);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals(list, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_130 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_130() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_131 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_131() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_132 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_132() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_133 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_133() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		String dataModelName = testCase;
		String attrName = testCase;

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(dataModelName);
		param.add(attrName);

		Map<String, Object> objMap = new HashMap<String, Object>();
		Set<Double> set = new HashSet<Double>();
		set.add(Double.NEGATIVE_INFINITY);
		objMap.put("var", set);

		PDSEngine.getInstance();
		PDSResponse response = super.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * テストID：PILINI_E_001_134 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_134() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_135 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_135() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_136 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_136() throws Exception {

		String testCase = this.getName().substring(4);

		// 異常系でIllegalArgumentExceptionが期待されるケース
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * テストID：PILINI_E_001_137 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_137() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Double> map = new HashMap<String, Double>();
		map.put("abc", Double.NEGATIVE_INFINITY);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals(map, result.getValue());
	}
}
