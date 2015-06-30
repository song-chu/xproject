package jp.escofi.emr.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
import jp.escofi.emr.engine.search.RangeObject;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PROObjObject;

import org.junit.Test;

public class PDSServiceAPITest2 extends DJUnitTestCaseEx {

	private static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	/**
	 * ダンプリソースベースフォルダ
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSServiceAPI2_Dump";

	public PDSServiceAPITest2() {

		super(PDSServiceAPITest2.class, BASE_FOLDER);
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
	 * 結果確認
	 *
	 * @param res
	 */
	private void assertResult(PDSResponse res, String flag) {
		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		// 結果値

		if (flag.substring(0, 4).equals("true")) {
			assertEquals(flag, result);
		} else {
			assertEquals(flag, result);
		}
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_1
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_1() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_1", "var1=あいうえお",
				"var2=あいうえお", "var3=かきくけこ", "var4=かきくけこ");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("value1");

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_2
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_2() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_2", "var1=const3",
				"var2=const3", "var3=const3", "var4=const3", "var5=const3",
				"var6=const3", "var7=const3", "var8=const3", "var9=const9");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, Boolean> result = (Map<String, Boolean>) res
				.getResultObject().getValue();
		Map<String, Boolean> expected = new HashMap<String, Boolean>();
		expected.put("key1", Boolean.FALSE);
		expected.put("key2", Boolean.TRUE);
		expected.put("key3", Boolean.TRUE);
		expected.put("key4", Boolean.TRUE);
		expected.put("key5", Boolean.TRUE);

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_3
	 */
	@Test
	public void testPENSER_N_002_3() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_3");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.DELETED, res.getStatus());
		// 条件文有無確認
		assertEquals(false, res.isCondition());
		// 属性値確認
		Object result = res.getResultObject().getValue();

		// 結果値
		assertEquals(null, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//

	}

	/**
	 * テストID：PENSER_N_002_4
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_4() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_4", "var1=const1",
				"var2=const2", "var3=const2", "var4=const4", "var5=const5",
				"var6=const6", "var7=const7", "var8=const8", "var9=const3");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, Long> result = (Map<String, Long>) res.getResultObject()
				.getValue();
		Map<String, Long> expected = new HashMap<String, Long>();
		expected.put("key1", new Long(9000000000000000000l));
		expected.put("key2", new Long(-2000000000l));
		expected.put("key3", new Long(0l));
		expected.put("key4", new Long(10000l));
		expected.put("key5", new Long(123456l));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_5
	 */
	@Test
	public void testPENSER_N_002_5() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_5", "var1=コンスト１",
				"var2=コンスト２", "var3=コンスト３", "var4=コンスト４", "var5=コンスト５",
				"var6=コンスト６", "var7=コンスト７", "var8=コンスト８", "var9=コンスト９",
				"var10=コンスト１０", "var11=コンスト１１", "var12=コンスト１２", "var13=コンスト１３",
				"var14=コンスト１４", "var15=コンスト１５", "var16=コンスト１６", "var17=コンスト１７",
				"var18=コンスト１８", "var19=コンスト１８", "var20=コンスト２０", "var21=コンスト２０",
				"var22=コンスト２２", "var23=コンスト２２", "var24=コンスト２３", "var25=コンスト２３");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// 上限値確認
		assertEquals(1.797693134862315e308d, result.getUpper());
		// 下限値確認
		assertEquals(-1.797693134862315e308d, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_6
	 */
	@Test
	public void testPENSER_N_002_6() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_6", "var1=あいうえ",
				"var2=かきくけ");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname6", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo6"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_7
	 */
	@Test
	public void testPENSER_N_002_7() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_7", "var1=const3",
				"var2=const3", "var3=const3", "var4=const3", "var5=const3",
				"var6=const3", "var7=const3", "var8=const3", "var9=const3",
				"var10=const3", "var11=const3", "var12=const3", "var13=const3",
				"var14=const3", "var15=const3", "var16=const3", "var17=const3",
				"var18=const3", "var19=コンスト１９", "var20=const3", "var21=コンスト２１",
				"var22=const3", "var23=コンスト２３", "var24=コンスト２４", "var25=コンスト２５");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// 上限値確認
		assertEquals("elsed", result.getUpper().toString());
		// 下限値確認
		assertEquals("elsec", result.getLower().toString());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_8
	 */
	@Test
	public void testPENSER_N_002_8() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_8", "var1=あいうえ",
				"var2=かきくけ");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname8", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo8"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_9
	 */
	@Test
	public void testPENSER_N_002_9() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_9", "var1=2147483645",
				"var2=-2147483448", "var3=1111111112", "var4=1234567890");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname9", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo9"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_10
	 */
	@Test
	public void testPENSER_N_002_10() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_10", "var1=2147483647",
				"var2=-2147483648", "var3=1000000000", "var4=-1111111111",
				"var5=0", "var6=2147483646", "var7=-2147483647",
				"var8=100000000", "var9=-111111111", "var10=1", "var11=1");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// 上限値確認
		assertEquals(1000, result.getUpper());
		// 下限値確認
		assertEquals(100, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_11
	 */
	@Test
	public void testPENSER_N_002_11() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_11", "var1=2147483647",
				"var2=-2147483648", "var3=1111111111", "var4=1234567891");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname11", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo11"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_12
	 */
	@Test
	public void testPENSER_N_002_12() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_12", "var1=2147483646",
				"var2=-2147483647", "var3=1000000001", "var4=-1111111112",
				"var5=1", "var6=2147483645", "var7=-2147483648",
				"var8=100000001", "var9=-111111112", "var10=0", "var11=0");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// 上限値確認
		assertEquals(new Long(12345678901l), result.getUpper());
		// 下限値確認
		assertEquals(new Long(-12345678901l), result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_13
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_13() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_13", "var1=0", "var2=0",
				"var3=2", "var4=2", "var5=4", "var6=4", "var7=6", "var8=6",
				"var9=8", "var10=8", "var11=10", "var12=10", "var13=12",
				"var14=12", "var15=14", "var16=14", "var17=16", "var18=16",
				"var19=2000000000", "var20=2000000000", "var21=-2000000000",
				"var22=-2000000000", "var23=10000", "var24=10000");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, Double> result = (Map<String, Double>) res
				.getResultObject().getValue();
		Map<String, Double> expected = new HashMap<String, Double>();
		expected.put("key1", 4.940656458412465e-324d);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_14
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_14() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_14", "var1=2147483647",
				"var2=-2147483640", "var3=11111111");

		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<BigDecimal> result = (List<BigDecimal>) res.getResultObject()
				.getValue();
		List<BigDecimal> expected = new ArrayList<BigDecimal>();
		expected.add(new BigDecimal("9876543210987654321098765.5"));
		expected.add(new BigDecimal("-9876543210987654321098765.5"));
		expected.add(new BigDecimal("3.0001"));
		expected.add(new BigDecimal("400"));
		expected.add(new BigDecimal("500001"));

		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_15
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_15() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_15", "var1=0", "var2=1",
				"var3=2", "var4=3", "var5=4", "var6=5", "var7=6", "var8=7",
				"var9=8", "var10=9", "var11=10", "var12=11", "var13=12",
				"var14=13", "var15=14", "var16=15", "var17=16", "var18=17",
				"var19=18", "var20=19", "var21=20", "var22=21", "var23=22",
				"var24=23");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "ifValue1");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_16
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_16() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_16", "var1=2147483640",
				"var2=-2147483640", "var3=1111111111", "var4=11111111",
				"var5=2500", "var6=57000");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<BigDecimal> result = (List<BigDecimal>) res.getResultObject()
				.getValue();
		List<BigDecimal> expected = new ArrayList<BigDecimal>();
		expected.add(new BigDecimal("123456789012345678901234567890.1"));
		expected.add(new BigDecimal("-123456789012345678901234567890.1"));
		expected.add(new BigDecimal("3.0001"));
		expected.add(new BigDecimal("400"));
		expected.add(new BigDecimal("500001"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_17
	 */
	@Test
	public void testPENSER_N_002_17() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_17",
				"var1=9223372036854775806", "var2=-9223372036854775807",
				"var3=2");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals("かきくけこ", result.getUpper());
		// 下限値確認
		assertEquals("あいうえお", result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_18
	 */
	@Test
	public void testPENSER_N_002_18() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_18",
				"var1=999999999999999999", "var2=999999999999999998",
				"var3=-888888888888888", "var4=-888888888888889",
				"var5=111111111", "var6=111111112", "var7=0", "var8=1",
				"var9=11", "var10=12", "var11=5000", "var12=5001",
				"var13=111111111111111111", "var14=13", "var15=600000",
				"var16=600000", "var17=1", "var18=1",
				"var19=111111111111111111", "var20=111111111111111112",
				"var21=-1000000000000000000", "var22=-1000000000000000001",
				"var23=6666666", "var24=6666666", "var25=6666666",
				"var26=6666665", "var27=6663666", "var28=6662666",
				"var29=5666666", "var30=6666666");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname18", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo18"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_19
	 */
	@Test
	public void testPENSER_N_002_19() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_19",
				"var1=9223372036854775807", "var2=-9223372036854775808",
				"var3=3");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(2147483647, result.getUpper());
		// 下限値確認
		assertEquals(-2147483648, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_20
	 */
	@Test
	public void testPENSER_N_002_20() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_20",
				"var1=999999999999999999", "var2=999999999999999999",
				"var3=-888888888888888", "var4=-888888888888888",
				"var5=111111111", "var6=111111111", "var7=0", "var8=0",
				"var9=11", "var10=11", "var11=5000", "var12=5000",
				"var13=111111111111111111", "var14=13", "var15=600000",
				"var16=600000", "var17=1", "var18=1",
				"var19=111111111111111111", "var20=111111111111111111",
				"var21=-1234567890123456789", "var22=-1234567890123456788",
				"var23=1236321", "var24=1236321");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname20", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo20"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_21
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_21() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_21",
				"var1=11111111111111", "var2=-2147483640",
				"var3=5011100000000000", "var4=-100000000000000000",
				"var5=111111111111111");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Double> result = (List<Double>) res.getResultObject().getValue();
		List<Double> expected = new ArrayList<Double>();
		expected.add(new Double(1.79e308d));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_22
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_22() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_22",
				"var1=999992147483646", "var2=-999992147483647", "var3=501",
				"var4=1", "var5=2999", "var6=-519");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) res
				.getResultObject().getValue();
		Map<String, BigDecimal> expected = new HashMap<String, BigDecimal>();
		expected.put("key1", new BigDecimal("12345678901234567890.1"));
		expected.put("key2", new BigDecimal("-12345678901234567890.1"));
		expected.put("key3", new BigDecimal("0"));
		expected.put("key4", new BigDecimal("1"));
		expected.put("key5", new BigDecimal("10000"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_23
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_23() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_23",
				"var1=111111111111112", "var2=-2147483641",
				"var3=5011100000000001", "var4=-100000000000000001",
				"var5=111111111111112");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("テストケース２３OK");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_24
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_24() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_24",
				"var1=999992147483647", "var2=-999992147483648", "var3=500",
				"var4=0", "var5=3000", "var6=-520");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) res
				.getResultObject().getValue();
		Map<String, BigDecimal> expected = new HashMap<String, BigDecimal>();
		expected.put("key1", new BigDecimal("50000000000000000000"));
		expected.put("key2", new BigDecimal("0.002"));
		expected.put("key3", new BigDecimal("0"));
		expected.put("key4", new BigDecimal("1"));
		expected.put("key5", new BigDecimal("10000"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_25
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_25() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_25", "var1=2147483648",
				"var2=2147.483647", "var3=21474836470000000001",
				"var4=-21474836470000000001", "var5=1111111111",
				"var6=1111111112", "var7=25001", "var8=57001");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "なにぬけの");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_26
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_26() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_26", "var1=2147483641",
				"var2=-2147483641", "var3=50111.00002", "var4=101",
				"var5=214.7483641", "var6=-214.7483641", "var7=0.000000041",
				"var8=2.222333444555666e100d");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Boolean> result = (List<Boolean>) res.getResultObject().getValue();
		List<Boolean> expected = new ArrayList<Boolean>();
		expected.add(true);
		expected.add(false);
		expected.add(true);
		expected.add(false);
		expected.add(true);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_27
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_27() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_27", "var1=2147483647",
				"var2=2147.483646", "var3=21474836470000000000",
				"var4=-21474836470000000000", "var5=111111111",
				"var6=1111111111", "var7=25000", "var8=57000");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, Integer> result = (Map<String, Integer>) res
				.getResultObject().getValue();
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("key1", new Integer("2147483647"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_28
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_28() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_28", "var1=2147483640",
				"var2=-2147483640", "var3=50111.00001", "var4=100",
				"var5=214.7483640", "var6=-214.7483640", "var7=0.00000004",
				"var8=222222222222222");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Long> result = (List<Long>) res.getResultObject().getValue();
		List<Long> expected = new ArrayList<Long>();
		expected.add(new Long(123456789012345l));
		expected.add(new Long(-123456789012345l));
		expected.add(new Long(1l));
		expected.add(new Long(50000l));
		expected.add(new Long(1234567890l));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_29
	 */
	@Test
	public void testPENSER_N_002_29() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_29", "var1=33147483646",
				"var2=-3347483647", "var3=0.00000003", "var4=-1.00006");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname29", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo29"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_30
	 */
	@Test
	public void testPENSER_N_002_30() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_30",
				"var1=1.92233720368547e100", "var2=1.92233720368547e100",
				"var3=-1.92233720368547e100", "var4=-1.92233720368547e100",
				"var5=0.000000001", "var6=0.000000001");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(new BigDecimal("111111111121474836479.2"), result.getUpper());
		// 下限値確認
		assertEquals(new BigDecimal("-111111111121474836480.1"), result
				.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_31
	 */
	@Test
	public void testPENSER_N_002_31() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_31",
				"var1=33147483647000000000", "var2=-33474836480000000000",
				"var3=0.00000004", "var4=-1.00005");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname31", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo31"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_32
	 */
	@Test
	public void testPENSER_N_002_32() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_32",
				"var1=1.92233720368547e100", "var2=1.92233720368548e100",
				"var3=-1.92233720368547e100", "var4=-1.92233720368548e100",
				"var5=0.000000001", "var6=0.000000002");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(new BigDecimal("111111111121474836479.2"), result.getUpper());
		// 下限値確認
		assertEquals(new BigDecimal("-111111111121474836480.1"), result
				.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_33
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_33() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_33", "var1=2147483647",
				"var2=-2147483648", "var3=21474836470000000000",
				"var4=-21474836480000000000.2", "var5=2147483648");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "テストケース３３OK");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_34
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_34() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_34",
				"var1=20000000000000000000", "var2=-20000000000000000001",
				"var3=0.0000000000000000001");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Boolean> result = (List<Boolean>) res.getResultObject().getValue();
		List<Boolean> expected = new ArrayList<Boolean>();
		expected.add(true);
		expected.add(false);
		expected.add(true);
		expected.add(false);
		expected.add(true);
		expected.add(false);
		expected.add(true);
		expected.add(false);
		expected.add(true);
		expected.add(false);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_35
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_35() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_35", "var1=2147483646",
				"var2=-2147483647", "var3=21474836470000000000.1",
				"var4=-21474836480000000000", "var5=2147483647");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, Integer> result = (Map<String, Integer>) res
				.getResultObject().getValue();
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("key1", new Integer("2000000000"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_36
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_36() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_36",
				"var1=20000000000000000001", "var2=-20000000000000000000",
				"var3=0.000000000000000001");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Long> result = (List<Long>) res.getResultObject().getValue();
		List<Long> expected = new ArrayList<Long>();
		expected.add(new Long(2000000000l));
		expected.add(new Long(-2000000000l));
		expected.add(new Long(0l));
		expected.add(new Long(50000l));
		expected.add(new Long(1234567890l));
		expected.add(new Long(1000l));
		expected.add(new Long(-200l));
		expected.add(new Long(1l));
		expected.add(new Long(50000l));
		expected.add(new Long(123890l));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_37
	 */
	@Test
	public void testPENSER_N_002_37() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_37",
				"var1=12345678901234567890", "var2=12345678901234567891",
				"var3=-12345678901234567890", "var4=-12345678901234567892",
				"var5=0.00000000000000000001", "var6=0.00000000000000000002",
				"var7=-0.00000000000000000001", "var8=-0.0000000000000000001",
				"var9=10000", "var10=10001", "var11=-2000", "var12=-2000");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname37", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo37"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_38
	 */
	@Test
	public void testPENSER_N_002_38() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_38", "var1=33147483647",
				"var2=-3347483648", "var3=0.00000004", "var4=-1.00005",
				"var5=0.00000004", "var6=-1.00005",
				"var7=20000000000000000000.09",
				"var8=-20000000000000000000.08",
				"var9=12345678901234567890.001",
				"var10=-12345678901234567890.001");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(new BigDecimal("10000000000000000000.2"), result.getUpper());
		// 下限値確認
		assertEquals(new BigDecimal("-10000000000000000000.1"), result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_39
	 */
	@Test
	public void testPENSER_N_002_39() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_39",
				"var1=12345678901234567890", "var2=12345678901234567890",
				"var3=-12345678901234567890", "var4=-12345678901234567890",
				"var5=0.00000000000000000001", "var6=0.00000000000000000001",
				"var7=-0.00000000000000000001", "var8=-0.00000000000000000001",
				"var9=10000", "var10=10000", "var11=-2000", "var12=-2001");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname39", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo39"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_40
	 */
	@Test
	public void testPENSER_N_002_40() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_40", "var1=33147483648",
				"var2=-3347483647", "var3=0.00000005", "var4=-1.00004",
				"var5=0.00000003", "var6=-1.00004",
				"var7=20000000000000000000.08",
				"var8=-20000000000000000000.08",
				"var9=12345678901234567890.002",
				"var10=-12345678901234567890.000");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(new BigDecimal("10000000000000000000.2"), result.getUpper());
		// 下限値確認
		assertEquals(new BigDecimal("-10000000000000000000.1"), result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_41
	 */
	@Test
	public void testPENSER_N_002_41() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_41", "var1=true",
				"var2=true", "var3=false", "var4=false", "var5=true",
				"var6=false", "var7=false", "var8=false", "var9=true",
				"var10=true");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals("表から十", result.getUpper());
		// 下限値確認
		assertEquals("ｿフト", result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_42
	 */
	@Test
	public void testPENSER_N_002_42() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_42", "var1=true",
				"var2=false", "var3=true", "var4=false", "var5=true",
				"var6=true");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname42", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo42"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_43
	 */
	@Test
	public void testPENSER_N_002_43() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_43", "var1=true",
				"var2=false", "var3=false", "var4=true", "var5=true",
				"var6=true", "var7=false", "var8=false", "var9=false",
				"var10=true", "var11=false", "var12=false", "var13=true",
				"var14=true", "var15=false", "var16=true");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(2147483647, result.getUpper());
		// 下限値確認
		assertEquals(-2147483648, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_44
	 */
	@Test
	public void testPENSER_N_002_44() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_44", "var1=false",
				"var2=true", "var3=false", "var4=true", "var5=false",
				"var6=false");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname44", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo44"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_45
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_45() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_45", "var1=true",
				"var2=true", "var3=true", "var4=false", "var5=true");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Double> result = (List<Double>) res.getResultObject().getValue();
		List<Double> expected = new ArrayList<Double>();
		expected.add(-2.123456789012345e200d);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_46
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_46() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_46", "var1=true",
				"var2=true", "var3=true", "var4=true", "var5=true",
				"var6=true", "var7=false", "var8=false");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) res
				.getResultObject().getValue();
		Map<String, BigDecimal> expected = new HashMap<String, BigDecimal>();
		expected.put("key1", new BigDecimal("12345678901234567890.123"));
		expected.put("key2", new BigDecimal("-99999999999999999999.22"));
		expected.put("key3", new BigDecimal("-3.56666"));
		expected.put("key4", new BigDecimal("100000"));
		expected.put("key5", new BigDecimal("30000"));
		expected.put("key6", new BigDecimal("-2500"));
		expected.put("key7", new BigDecimal("-39000"));
		expected.put("key8", new BigDecimal("67890"));
		expected.put("key9", new BigDecimal("150000"));
		expected.put("key10", new BigDecimal("-6.002"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_47
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_47() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_47", "var1=false",
				"var2=false", "var3=false", "var4=true", "var5=false");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("成功４７");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_48
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_48() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_48", "var1=true",
				"var2=true", "var3=true", "var4=true", "var5=true",
				"var6=true", "var7=true", "var8=true");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) res
				.getResultObject().getValue();
		Map<String, BigDecimal> expected = new HashMap<String, BigDecimal>();
		expected.put("key1", new BigDecimal("12345678901234567890.123"));
		expected.put("key2", new BigDecimal("-99999999999999999999.22"));
		expected.put("key3", new BigDecimal("-3.56666"));
		expected.put("key4", new BigDecimal("100000"));
		expected.put("key5", new BigDecimal("30000"));
		expected.put("key6", new BigDecimal("-2500"));
		expected.put("key7", new BigDecimal("-39000"));
		expected.put("key8", new BigDecimal("67890"));
		expected.put("key9", new BigDecimal("150000"));
		expected.put("key10", new BigDecimal("-6.002"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_49
	 */
	@Test
	public void testPENSER_N_002_49() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_49", "var1=1番口",
				"var2=2番日", "var3=３番目", "var4=3番目", "var5=5番目0", "var6=66番目",
				"var7=7番目7番目", "var8=true", "var9=9番目", "var10=10番目");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname49", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo49"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_50
	 */
	@Test
	public void testPENSER_N_002_50() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_50", "var5=const５",
				"var6=const6");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(147483647, result.getUpper());
		// 下限値確認
		assertEquals(-147483648, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(false, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_51
	 */
	@Test
	public void testPENSER_N_002_51() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_51", "var1=1番目",
				"var2=2番目", "var3=3番目", "var4=4番目", "var5=5番目", "var6=6番目",
				"var7=7番目", "var8=8番目", "var9=9番", "var10=11番目");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("classname51", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("subinfo51"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_52
	 */
	@Test
	public void testPENSER_N_002_52() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_52", "var5=const5",
				"var6=const６");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(9223372036854775807l, result.getUpper());
		// 下限値確認
		assertEquals(-9223372036854775808l, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_53
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_53() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_53", "var1=がぎぐげ",
				"var2=ざじずぜぞご", "var3=だぢづでど", "var4=-ばびぶべぽ", "var5=ぱぴぷぺぼ",
				"var6=てすと53");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, Double> result = (Map<String, Double>) res
				.getResultObject().getValue();
		Map<String, Double> expected = new HashMap<String, Double>();
		expected.put("key1", 3.8e200d);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_54
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_54() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_54", "var1=アイウエオ",
				"var2=アイウエお", "var3=カキクケコ", "var4=かキクケコ", "var5=サシスセソ",
				"var6=サシスセソ", "var7=タチツテト", "var8=タチツテト", "var9=ナニヌネノ",
				"var10=ナニヌネ", "var11=ハヒフヘホ", "var12=ヒフヘホ", "var13=マミムメモ",
				"var14=マミムメ", "var15=ラリルレロ", "var16=ﾗﾘﾙﾚﾛ", "var17=ガギグゲゴ",
				"var18=ガギグゲゴガギグゲゴ", "var19=ザジズゼゾ", "var20=ザジズゾ");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<BigDecimal> result = (List<BigDecimal>) res.getResultObject()
				.getValue();
		List<BigDecimal> expected = new ArrayList<BigDecimal>();
		expected.add(new BigDecimal("20000000000000000000.2222"));
		expected.add(new BigDecimal("-20000000000000000000.2222"));
		expected.add(new BigDecimal("1000000"));
		expected.add(new BigDecimal("-5000"));
		expected.add(new BigDecimal("5000010"));
		expected.add(new BigDecimal("5000000000000"));
		expected.add(new BigDecimal("50.001"));
		expected.add(new BigDecimal("12345"));
		expected.add(new BigDecimal("999"));
		expected.add(new BigDecimal("-51111111111111111111111111"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_55
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_55() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_55", "var1=がぎぐげご",
				"var2=ざじずぜそ", "var3=ばびぶべぼ");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "きゃきゅきょ");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_56
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_56() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_56", "var1=アイウエオ",
				"var2=アイウエオ", "var3=カキクケコ", "var4=カキクケコ", "var5=サシスセソ",
				"var6=サシスセソ", "var7=タチツテト", "var8=タチツテ", "var9=ナニヌネノ",
				"var10=ナニヌネノ", "var11=ハヒフヘホ", "var12=ハヒフヘホ", "var13=マミムメモ",
				"var14=マミムメモ", "var15=ラリルレロ", "var16=ラリルレロ", "var17=ガギグゲゴ",
				"var18=ガギグゲゴ", "var19=ザジズゼゾ", "var20=ザジズゼゾ");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<BigDecimal> result = (List<BigDecimal>) res.getResultObject()
				.getValue();
		List<BigDecimal> expected = new ArrayList<BigDecimal>();
		expected.add(new BigDecimal("20000000000000000000.2222"));
		expected.add(new BigDecimal("-20000000000000000000.2222"));
		expected.add(new BigDecimal("1000000"));
		expected.add(new BigDecimal("-5000"));
		expected.add(new BigDecimal("5000010"));
		expected.add(new BigDecimal("5000000000000"));
		expected.add(new BigDecimal("50.001"));
		expected.add(new BigDecimal("12345"));
		expected.add(new BigDecimal("999"));
		expected.add(new BigDecimal("-51111111111111111111111111"));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_57
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_57() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_57", "var1=121",
				"var2=21111111", "var3=-3000001", "var4=4000000",
				"var5=5000001", "var6=600000",
				"var7=123456789012345678901234567890.1",
				"var8=-123456789012345678901234567890.1",
				"var9=-1234567890123456789012345678901234567890", "var10=500",
				"var11=-2.00000002", "var12=600000.1");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("東京都");

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_58
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_58() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_58",
				"var1=12345678901234567890123456",
				"var2=12345678901234567890123457",
				"var3=-12345678901234567890.25",
				"var4=-12345678901234567890.25");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());

		// 属性値確認
		Map<String, Boolean> result = (Map<String, Boolean>) res
				.getResultObject().getValue();
		Map<String, Boolean> expected = new HashMap<String, Boolean>();
		expected.put("key1", false);
		expected.put("key2", false);
		expected.put("key3", false);
		expected.put("key4", false);
		expected.put("key5", false);
		expected.put("key6", true);
		expected.put("key7", true);
		expected.put("key8", true);
		expected.put("key9", true);
		expected.put("key10", true);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_59
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_59() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_59", "var1=121",
				"var2=21111111", "var3=-3000001", "var4=4000000",
				"var5=5000001", "var6=600000",
				"var7=123456789012345678901234567890.2",
				"var8=-123456789012345678901234567890.0",
				"var9=-1234567890123456789012345678901234567890.1",
				"var10=500.0000001", "var11=-2.000000021", "var12=600000.0");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		List<Integer> result = (List<Integer>) res.getResultObject().getValue();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50000000);

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_60
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_60() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_60",
				"var1=12345678901234567890123456",
				"var2=12345678901234567890123456",
				"var3=-12345678901234567890.25",
				"var4=-12345678901234567890.24");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());

		// 属性値確認
		Map<String, Long> result = (Map<String, Long>) res.getResultObject()
				.getValue();
		Map<String, Long> expected = new HashMap<String, Long>();
		expected.put("key1", new Long(9000000000000000000l));
		expected.put("key2", new Long(-9000000000000000000l));
		expected.put("key3", new Long(5000l));
		expected.put("key4", new Long(-55555555l));
		expected.put("key5", new Long(56895l));
		expected.put("key6", new Long(11l));
		expected.put("key7", new Long(-4l));
		expected.put("key8", new Long(45l));
		expected.put("key9", new Long(-3l));
		expected.put("key10", new Long(55l));

		// 結果値
		assertEquals(expected, result);
	}

	/**
	 * テストID：PENSER_N_002_61
	 */
	@Test
	public void testPENSER_N_002_61() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_61",
				"var1=2500000000000000001", "var2=-2500000000000000000",
				"var3=2500000000000000000.2", "var4=-2500000000000000000.221");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals(2.5e200, result.getUpper());
		// 下限値確認
		assertEquals(-3.8e300, result.getLower());
		// 上限値含むフラグ確認
		assertEquals(false, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_62
	 */
	@Test
	public void testPENSER_N_002_62() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_62", "var1=300.01",
				"var2=-800000.000000000000000000001",
				"var3=200000000000000000000000000000.25",
				"var4=-200000000000000000000000000000.2501",
				"var5=123456789012345679891");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("クラス名62", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("付帯情報62"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_63
	 */
	@Test
	public void testPENSER_N_002_63() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_63",
				"var1=2500000000000000000", "var2=-2500000000000000001",
				"var3=2500000000000000000.22", "var4=-2500000000000000000.22");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// 上限値確認
		assertEquals("xyz", result.getUpper());
		// 下限値確認
		assertEquals("abc", result.getLower());
		// 上限値含むフラグ確認
		assertEquals(true, result.includeUpper());
		// 下限値含むフラグ確認
		assertEquals(true, result.includeLower());
	}

	/**
	 * テストID：PENSER_N_002_64
	 */
	@Test
	public void testPENSER_N_002_64() throws Exception {

		// 検索キー設定→検索実施→引数項目値設定→条件判定実施
		PDSResponse res = this.execute("PENSER_N_002_64", "var1=300",
				"var2=-800000", "var3=100000000000000000000000000000.25",
				"var4=-200000000000000000000000000000.2500",
				"var5=123456789012345679890");

		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// クラス名
		assertEquals("クラス名64", result.getClassName());
		// 付帯情報
		assertEquals(Arrays.asList("付帯情報64"), result.getAttachedInfo());
	}

	/**
	 * テストID：PENSER_N_002_65 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_65() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=あｇｆｊａｄｆｋｊｔｅｓｕｔｏ　", "var2=あｇｆｊａｄｆｋｊｔｅｓｕｔｏ　"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_66 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_66() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=アｇｆｊａ12３４ｋｊ　"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_67 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_67() throws Exception {
		assertResult(this
				.execute(this.getName().substring(4, 19), "var2=一二表三四"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_68 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_68() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=＝*123@"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_69 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_69() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=12345678", "var2=12345678"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_70 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_70() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=12345678"), "false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_71 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_71() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 19), "var2=-520"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_72 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_72() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=9876543"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_73 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_73() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-9223372036854770000", "var2=-9223372036854770001"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_74 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_74() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=9223372036854770088"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_75 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_75() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=-100000000000002"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_76 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_76() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-1223372036854770000"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_77 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_77() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1.797693134862315e308", "var2=1.797693134862314e308"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_78 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_78() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-1.797693134862315e308"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_79 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_79() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=-4.940656458412464e-324d"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_80 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_80() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1.000693134860007e+17d"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_81 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_81() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1234567890123456789012345.12",
				"var2=1234567890123456789012345.11"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_82 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_82() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-0.6697362752017862813e-330"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_83 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_83() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=7.1740640385300991242e+309"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_84 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_84() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=12.100"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_85 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_85() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19), "var1=true",
				"var2=false"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_86 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_86() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 19), "var1=true"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_87 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_87() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 19), "var2=true"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_88 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_88() throws Exception {
		assertResult(this
				.execute(this.getName().substring(4, 19), "var1=false"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_89 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_89() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=あいうえおかきくけこ", "var2=あいうえおかきくけこ"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_90 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_90() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=+++++++"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_91 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_91() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=あaア一d1ｓ５"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_92 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_92() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=abcd efg"), "false" + this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_93 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_93() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=0.5627184893610027859e-330",
				"var2=0.5627184893610027859e-330"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_94 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_94() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1234567890001234567890"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_95 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_95() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=3.0149051771198015400e+310"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * テストID：PENSER_N_002_96 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_96() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-8.761456421457456363E+311"), "false"
				+ this.getName().substring(17, 19));
	}
}
