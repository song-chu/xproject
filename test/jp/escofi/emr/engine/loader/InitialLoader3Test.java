/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXUnExpectedStateException;

import org.junit.Test;

/**
 * イニシャルローダーテストクラス
 *
 * @author seo.yi
 */
public class InitialLoader3Test extends DJUnitTestCaseEx {

	/**
	 * リソースベースフォルダ
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader3";

	public InitialLoader3Test() {

		super(InitialLoader3Test.class, BASE_FOLDER);
	}

	/**
	 * テストID：PILINI_N_001_177 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_N_001_177() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		PDSResponse response = super.invokeCheckEngineNormalResponse(testCase,
				param1);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
	}

	/**
	 * テストID：PILINI_E_001_138 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_138() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		IllegalArgumentException iae = (IllegalArgumentException) e;
		assertEquals("Attribute 'name' must be set on element 'datamodel'.",
				iae.getMessage());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(IllegalArgumentException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML管理が無効です。（ファイル名：PILINI_E_001_138_Meta.xml）", pe.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_139 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_139() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(FileNotFoundException.class, e.getClass());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(EMRException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML管理が無効です。（ファイル名：PILINI_E_001_139_Meta.xml）", pe.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_140 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_140() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		IllegalArgumentException iae = (IllegalArgumentException) e;
		assertEquals(
				"Attribute 'parentflg' must be set on element 'datamodel'.",
				iae.getMessage());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(EMRException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML管理が無効です。（ファイル名：PILINI_E_001_140_Meta.xml）", pe.getErrMessage());
	}

	/**
	 * テストID：PILINI_E_001_141 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_141() throws Exception {

		String testCase = this.getName().substring(4);

		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_142 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_142() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_143 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_143() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_144 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_144() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_145 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_145() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_146 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_146() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_147 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_147() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_148 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_148() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_149 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_149() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_150 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_150() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_151 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_151() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_152 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_152() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_153 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_153() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_154 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_154() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_155 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_155() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_156 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_156() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_157 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_157() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_158 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_158() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_159 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_159() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_160 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_160() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_161 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_161() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_162 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_162() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_163 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_163() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_164 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_164() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_165 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_165() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_166 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_166() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_167 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_167() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_168 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_168() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_169 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_169() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_170 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_170() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_171 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_171() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_172 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_172() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_173 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_173() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_174 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_174() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_175 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_175() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_176 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_176() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_178 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_178() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_179 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_179() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, ex.getClass());
	}

	/**
	 * テストID：PILINI_E_001_180 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_180() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, ex.getClass());
	}

	/**
	 * テストID：PILINI_E_001_181 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_181() throws Exception {

		String testCase = this.getName().substring(4);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, ex.getClass());
	}

	/**
	 * テストID：PILINI_E_001_182 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_182() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, ex.getClass());
	}

	/**
	 * テストID：PILINI_E_001_183 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_183() throws Exception {

		String testCase = this.getName().substring(4);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, ex.getClass());
	}

	/**
	 * テストID：PILINI_E_001_184 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_184() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_185 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_185() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_186 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_186() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_187 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_187() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		Exception e = super.invokeCheckEngineException(testCase, param1,
				objMap1);
		assertEquals(PEXUnExpectedStateException.class, e.getClass());
	}

	/**
	 * テストID：PILINI_E_001_188 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_188() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * テストID：PILINI_E_001_189 イニシャルローダーのコンストラクタ→期待例外をcatch→結果確認
	 */
	@Test
	public void testPILINI_E_001_189() throws Exception {

		String testCase = this.getName().substring(4);

		// 引数設定
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}
}
