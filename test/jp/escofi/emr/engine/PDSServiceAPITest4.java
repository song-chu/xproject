package jp.escofi.emr.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.junit.Test;

public class PDSServiceAPITest4 extends DJUnitTestCaseEx {

	private static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	/**
	 * ダンプリソースベースフォルダ
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSServiceAPI4_Dump";

	public PDSServiceAPITest4() {

		super(PDSServiceAPITest4.class, BASE_FOLDER);
	}

	/**
	 * 検索キー設定→検索実施→引数項目値設定→条件判定実施
	 *
	 * @param dataModelName
	 *            データモデル名(テストケースID)
	 * @param vars
	 *            引数項目名=引数項目値
	 * @return PDS応答クラス
	 * @throws Exception
	 */
	private PDSResponse execute(String dataModelName, String... vars)
			throws Exception {

		// ----------------------<<入力値設定>>-------------------------------//
		// 引数設定
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add(dataModelName); // 修正ポイント
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(dataModelName);

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		// 引数項目取得処理
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res
				.getConditionItemInfoMap();

		if (conditionItemInfoMap == null) {
			return res;
		}

		// 引数項目値Map
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();

		String itemName = null; // 引数項目名
		String itemType = null; // 引数項目データ型
		String javaDataType = null; // 引数項目内部データ型
		List<String> searchInfo = null; // 引数項目取得情報
		Object varValue = null; // 引数項目値

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		String var = "";
		for (ConditionItemInfo conditionItemInfo : collection) {

			// 引数項目クラスから情報を取得する。
			itemName = conditionItemInfo.getItemName();
			itemType = conditionItemInfo.getItemType();
			javaDataType = conditionItemInfo.getJavaDataType();
			searchInfo = conditionItemInfo.getSearchInfo();

			if (vars != null) {
				for (int i = 0; i < vars.length; i++) {

					int idx = -1;

					if (vars[i].startsWith(itemName)) {
						idx = vars[i].indexOf("=");
						var = vars[i].substring(idx + 1);
						break;
					}
				}
			}

			if ("".equals(var)) {
				var = "default";
			}

			// 引数項目取得情報に基づき、引数項目を取得後、
			// 引数項目データ型、引数項目内部データ型に合わせて型変換し、引数項目値に代入する。
			varValue = PUTConvertUtil.convert(var, javaDataType);

			// 引数項目値マップに設定
			conditionItemValueMap.put(itemName, varValue);
		}
		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}

		// PDS応答クラスに引数項目値マップを設定
		res.setConditionItemValueMap(conditionItemValueMap);

		// 属性値取得メソッドを呼び出す。
		res = PDSServiceAPI.getAttrValue(res);
		return res;
	}

	/**
	 * テストID：PENSER_N_002_273
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_273() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_273", "var1=あ", "var2=あ",
				"var3=お");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_274
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_274() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_274", "var1=アアア",
				"var2=ｱｱｱ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_275
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_275() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_275", "var1=ｶｶｶ",
				"var3=ｺｺｶ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_276
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_276() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_276", "var1=ＡＡｱｱｱ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_277
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_277() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_277", "var2=かきくけこ",
				"var3=かきくけけ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_278
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_278() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_278", "var2=あいうえお");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_279
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_279() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_279", "var3=!'()\"#$%$#\")()())%$#%%%");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_280
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_280() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_280", "var2=あいうえ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_281
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_281() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_281", "var1=-2147483648",
				"var2=2147483647", "var3=2147483646");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_282
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_282() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_282", "var1=-2147483647",
				"var2=-2147483647");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_283
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_283() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_283", "var1=-2147483647",
				"var3=999");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_284
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_284() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_284", "var1=-1");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_285
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_285() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_285", "var2=-2147483648",
				"var3=1");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_286
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_286() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_286", "var2=2147483647");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_287
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_287() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_287", "var3=-9999998");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_288
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_288() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_288", "var2=0");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_289
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_289() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_289",
				"var1=-9223372036854775808", "var2=-9223372036854775807",
				"var3=0");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_290
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_290() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_290", "var1=0", "var2=-1");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_291
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_291() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_291",
				"var1=999999999999999999", "var3=1000000000000000000");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_292
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_292() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_292",
				"var1=1234567896123456789");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_293
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_293() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_293",
				"var2=9223372036123123124", "var3=9223372036123123124");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_294
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_294() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_294",
				"var2=-9223372036854775808");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_295
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_295() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_295",
				"var3=9223372036854321097");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_296
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_296() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_296",
				"var2=9223372036543209999");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_297
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_297() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_297",
				"var1=4.94065645841246e-300d", "var2=4.94065645841246e-324d",
				"var3=0");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_298
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_298() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_298",
				"var1=1.797693134862314e+308d", "var2=1.797693134862313e+308d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_299
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_299() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_299",
				"var1=0.123456789012345e-324d", "var3=1.234567890123456e+308d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_300
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_300() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_300",
				"var1=-4.940656458412465e-324d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_301
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_301() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_301",
				"var2=-1.112223334445557e+308", "var3=-1.112223334445559e+308d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_302
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_302() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_302",
				"var2=1.010202030304040e+308d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_303
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_303() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_303",
				"var3=2.22333444555666e-299d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_304
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_304() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_304",
				"var2=1.23456444556000e+308d");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_305
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_305() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_305",
				"var1=1234567890123456789.9000e-326",
				"var2=1234567890123456789.9020e-326",
				"var3=1234567890123456789.9010e-326");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_306
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_306() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_306",
				"var1=-1234567890123456789.90000",
				"var2=-1234567890123456789.9000");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_307
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_307() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_307",
				"var1=2234567890123456789.900010",
				"var3=2234567890123456989.124400");
		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_308
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_308() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_308",
				"var1=-3234567890123456789.434600");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_309
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_309() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_309",
				"var2=-42345678901234562512.9000",
				"var3=-42345678901234562511.9010");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_310
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_310() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_310",
				"var2=5234567890123479952.121560");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_311
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_311() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_311",
				"var3=62345678902349876543.56471010");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_312
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_312() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_312",
				"var2=-7234567890321654999.9000");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_313
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_313() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_313",
				"var1=AAAｶｶｶSSSﾀﾀﾀNNN", "var2=AAAｶｶｶSSSﾀﾀﾀNNN",
				"var3=ＡＡＡｶｶｶSSSﾀﾀﾀNNN");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_314
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_314() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_314", "var1=あああああああああ",
				"var2=あああああああああああ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_315
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_315() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_315", "var1=ﾗﾘﾙﾚﾚﾚ",
				"var3=ﾗﾘﾙﾛﾛﾛ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_316
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_316() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_316",
				"var1=あああかかかさささたたたなななははは");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_317
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_317() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_317", "var2=あああああああああお",
				"var3=あああああああああお");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_318
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_318() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_318",
				"var2=ららABHDMKL)($#!");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_319
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_319() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_319", "var3=おおここそそととのの");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_320
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_320() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_320",
				"var2=ああああああああああああああB");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_321
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_321() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_321", "var1=-2147483648",
				"var2=-2147483210", "var3=-2147483210");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_322
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_322() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_322", "var1=2147432100",
				"var2=2147483646");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_323
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_323() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_323", "var1=-2147483648",
				"var3=2147483646");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_324
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_324() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_324", "var1=-2147481234");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_325
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_325() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_325", "var2=2147412346",
				"var3=2147483210");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_326
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_326() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_326", "var2=-2147483648");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_327
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_327() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_327", "var3=-1234483210");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_328
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_328() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_328", "var2=2147443322");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_329
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_329() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_329",
				"var1=3214567890123456789.88000e-326",
				"var2=3214567890123456888.12010e-326",
				"var3=3214567890123456999.12010e-326");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_330
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_330() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_330",
				"var1=-4324567451245589.14789600",
				"var2=4324567890369874700.9874560");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_331
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_331() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_331",
				"var1=-5434567890987654321.6500",
				"var3=-5434567890765432100.2020");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_332
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_332() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_332",
				"var1=6544567890123456621.8080");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_333
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_333() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_333",
				"var2=-7654567890123456903.12012090",
				"var3=7654567890123456111.20101201");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_334
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_334() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_334",
				"var2=-8764567890123452224.100");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_335
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_335() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_335",
				"var3=9874567890123454789.5600");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_336
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_336() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_336",
				"var2=-1094567890123456789.0126020");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_337
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_337() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_337",
				"var1=ｴあいうえおかきくけこさしすせそたちすてと", "var2=ｴあいうえおかきくけこさしすせそたちすてと");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_338
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_338() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_338",
				"var1=らはがふぁかなばヴぁめけいえうえじぇいぇ", "var2=らはがふぁかなヴ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_339
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_339() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_339",
				"var1=はぱかじせヴぇねゃはやがたきめさＡＢＣＤ", "var2=はぱかじせヴぇねゃはやがたきめさＡ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_340
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_340() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_340",
				"var1=あいうわざまはがヴぁふぁらただうあおあせ", "var2=まはがヴぁふぁらただ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_341
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_341() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_341",
				"var1=かぁおあかきしヴぃびしひぱじゃけねへべそ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_342
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_342() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_342",
				"var1=すふｵくぶすうくぷむぬぶくけこさしくぷむぬぶ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_343
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_343() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_343",
				"var1=UYINDMKXDXDFCFG１２３４５６７８９０ぢ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_344
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_344() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_344",
				"var1=ねけいええおかぇ()'(%$#$#せけねべ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_345
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_345() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_345",
				"var2=(ＡＤＧＫＵＴＥＷ%#ｱｳｳｽｴｵｶくづえアウウスエオカ)");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_346
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_346() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_346", "var2=そどえおえおXYZ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_347
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_347() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_347",
				"var2=うあいあじゃかえおかぱまぁかなこさしすせそあきな");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_348
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_348() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_348", "var2=りえおかしヴぃふぃりち");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_349
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_349() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_349",
				"var1=１２３４５%'()#$!ＡＯＰＥＤXYZ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_350
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_350() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_350",
				"var1=めじぇうええおかきねへいぇさしべげてせで");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_351
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_351() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_351",
				"var1=ＨＧＦＤＦＳＹＨＨＤＪＩＥＫＪＭＮＤＧＤＵＧＳＲＳＹ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 * テストID：PENSER_N_002_352
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_352() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_352",
				"var1=ぜあえせえおねえへいぇけこけいえうえせそ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/***
	 *String a = "あ"; String b = "ｱ"; int tempInt = a.compareTo(b);
	 */

}
