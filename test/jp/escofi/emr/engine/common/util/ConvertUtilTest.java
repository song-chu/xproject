package jp.escofi.emr.engine.common.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.co.dgic.testing.framework.DJUnitTestCase;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.iwin.pds.xml2db.engine.PENEngine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author song.ck
 *
 */
public class ConvertUtilTest extends DJUnitTestCase {

	/**
	 *
	 */
	private Log logger = LogFactory.getLog(ConvertUtilTest.class);

	/**
	 *
	 */
	private Field field;

	/**
	 *
	 */
	public ConvertUtilTest() {
		super();
	}

	/**
	 * @param name	name
	 */
	public ConvertUtilTest(String name) {
		super(name);
	}

	/**
	 *
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.setPENEngineNull();
	}

	/**
	 *
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 *
	 */
	private void setPENEngineNull() throws Exception {
		Field f = PENEngine.class.getDeclaredField("instance");
		f.setAccessible(true);
		f.set(null, null);

	}

	/**
	 * @param field	field
	 * @param arg	arg
	 * @return	Field
	 * @throws SecurityException SecurityException
	 * @throws NoSuchFieldException SecurityException
	 */
	private Field changeField(Field field, String arg)
			throws SecurityException, NoSuchFieldException {

		if (arg.equals("map")) {
			field = HashSet.class.getDeclaredField(arg);
		} else {
			field = HashMap.class.getDeclaredField(arg);
		}
		field.setAccessible(true);

		return field;
	}

	// // [正常系テスト ]
	// /**
	// * テストID：PUTCON_N_001_1
	// */
	// @Test
	// public void testPUTCON_N_001_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<String> result = ConvertUtil.toList(null, String.class);
	//
	// // 結果確認
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_2
	// */
	// @Test
	// public void testPUTCON_N_001_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Integer> result = ConvertUtil.toList(null, Integer.class);
	//
	// // 結果確認
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_3
	// */
	// @Test
	// public void testPUTCON_N_001_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Long> result = ConvertUtil.toList(null, Long.class);
	//
	// // 結果確認
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_4
	// */
	// @Test
	// public void testPUTCON_N_001_4() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Double> result = ConvertUtil.toList(null, Double.class);
	//
	// // 結果確認
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_5
	// */
	// @Test
	// public void testPUTCON_N_001_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<BigDecimal> result = ConvertUtil.toList(null, BigDecimal.class);
	//
	// // 結果確認
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_6
	// */
	// @Test
	// public void testPUTCON_N_001_6() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Boolean> result = ConvertUtil.toList(null, Boolean.class);
	//
	// // 結果確認
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_7
	// */
	// @Test
	// public void testPUTCON_N_001_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// String[] array = { "AAA", "BBB", "CCC" };
	//
	// // オブジェクト型変換実行
	// List<String> result = ConvertUtil.toList(array, String.class);
	//
	// // 結果確認
	// for (String kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(3, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_8
	// */
	// @Test
	// public void testPUTCON_N_001_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Integer[] array = { 100, 150, 200, 250, 300 };
	//
	// // オブジェクト型変換実行
	// List<Integer> result = ConvertUtil.toList(array, Integer.class);
	//
	// // 結果確認
	// for (int kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(5, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_9
	// */
	// @Test
	// public void testPUTCON_N_001_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Long[] array = { new Long("9223372036854775807"),
	// new Long("-2147483648") };
	// ;
	//
	// // オブジェクト型変換実行
	// List<Long> result = ConvertUtil.toList(array, Long.class);
	//
	// // 結果確認
	// for (Long kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(2, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_10
	// */
	// @Test
	// public void testPUTCON_N_001_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Double[] array = { new Double("34.63E+230"), new Double("2.1E+12"),
	// new Double("9999999999.999") };
	//
	// // オブジェクト型変換実行
	// List<Double> result = ConvertUtil.toList(array, Double.class);
	//
	// // 結果確認
	// for (Double kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(3, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_11
	// */
	// @Test
	// public void testPUTCON_N_001_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// BigDecimal[] array = { new BigDecimal("5.056746E+502"),
	// new BigDecimal("-9.652245423543542E+503"),
	// new BigDecimal("-1.0E+593") };
	//
	// // オブジェクト型変換実行
	// List<BigDecimal> result = ConvertUtil
	// .toList(array, BigDecimal.class);
	//
	// // 結果確認
	// for (BigDecimal kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(3, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_12
	// */
	// @Test
	// public void testPUTCON_N_001_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Boolean[] array = { true, false };
	//
	// // オブジェクト型変換実行
	// List<Boolean> result = ConvertUtil.toList(array, Boolean.class);
	//
	// // 結果確認
	// for (boolean kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(2, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_13
	// */
	// @Test
	// public void testPUTCON_N_001_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<String> c = new ArrayList<String>();
	// c.add("AAA");
	// c.add("BBB");
	// c.add("CCC");
	//
	// // オブジェクト型変換実行
	// List<String> result = ConvertUtil.toList(c, String.class);
	//
	// // 結果確認
	// for (String kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_14
	// */
	// @Test
	// public void testPUTCON_N_001_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<Integer> c = new ArrayList<Integer>();
	// c.add(1);
	// c.add(100);
	// c.add(10000);
	//
	// // オブジェクト型変換実行
	// List<Integer> result = ConvertUtil.toList(c, Integer.class);
	//
	// // 結果確認
	// for (int kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_15
	// */
	// @Test
	// public void testPUTCON_N_001_15() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<Long> c = new ArrayList<Long>();
	// c.add(new Long("9223372036854775804"));
	// c.add(new Long("-2147483648"));
	//
	// // オブジェクト型変換実行
	// List<Long> result = ConvertUtil.toList(c, Long.class);
	//
	// // 結果確認
	// for (Long kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_16
	// */
	// @Test
	// public void testPUTCON_N_001_16() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<Double> c = new ArrayList<Double>();
	// c.add(new Double("99999999999.99"));
	// c.add(new Double("2.1E+123"));
	// c.add(new Double("34.63E+230"));
	//
	// // オブジェクト型変換実行
	// List<Double> result = ConvertUtil.toList(c, Double.class);
	//
	// // 結果確認
	// for (Double kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_17
	// */
	// @Test
	// public void testPUTCON_N_001_17() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<BigDecimal> c = new ArrayList<BigDecimal>();
	// c.add(new BigDecimal("-40.5E+400"));
	// c.add(new BigDecimal("57348925734820512345.964325697"));
	// c.add(new BigDecimal("7.5426E+417"));
	//
	// // オブジェクト型変換実行
	// List<BigDecimal> result = ConvertUtil.toList(c, BigDecimal.class);
	//
	// // 結果確認
	// for (BigDecimal kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_18
	// */
	// @Test
	// public void testPUTCON_N_001_18() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<Boolean> c = new ArrayList<Boolean>();
	// c.add(false);
	// c.add(true);
	// c.add(true);
	//
	// // オブジェクト型変換実行
	// List<Boolean> result = ConvertUtil.toList(c, Boolean.class);
	//
	// // 結果確認
	// for (Boolean kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_19
	// */
	// @Test
	// public void testPUTCON_N_001_19() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Collection<Object> c = new ArrayList<Object>();
	// c.add(false);
	// c.add("ABCDEFG");
	// c.add(new BigDecimal("43151541351.653654235423"));
	// c.add(new Long("-6542354233"));
	//
	// // オブジェクト型変換実行
	// List<Object> result = ConvertUtil.toList(c, Object.class);
	//
	// // 結果確認
	// for (Object kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_20
	// */
	// @Test
	// public void testPUTCON_N_001_20() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("key1", "value1");
	// map.put("key2", 100000);
	// map.put("key3", 35E+24);
	// map.put("key4", false);
	//
	// // オブジェクト型変換実行
	// List<HashMap> result = ConvertUtil.toList(map, HashMap.class);
	//
	// // 結果確認
	// for (Map<String, Object> kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_21
	// */
	// @Test
	// public void testPUTCON_N_001_21() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<String> result = ConvertUtil.toList("AAA", String.class);
	//
	// // 結果確認
	// for (String kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_22
	// */
	// @Test
	// public void testPUTCON_N_001_22() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Integer> result = ConvertUtil.toList(100, Integer.class);
	//
	// // 結果確認
	// for (Integer kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_23
	// */
	// @Test
	// public void testPUTCON_N_001_23() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Long> result = ConvertUtil.toList(new Long("-2147483648"),
	// Long.class);
	//
	// // 結果確認
	// for (Long kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_24
	// */
	// @Test
	// public void testPUTCON_N_001_24() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Double> result = ConvertUtil.toList(new Double("2.1E+12"),
	// Double.class);
	//
	// // 結果確認
	// for (Double kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_25
	// */
	// @Test
	// public void testPUTCON_N_001_25() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<BigDecimal> result = ConvertUtil.toList(new BigDecimal(
	// "5.056746E+502"), BigDecimal.class);
	//
	// // 結果確認
	// for (BigDecimal kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_001_26
	// */
	// @Test
	// public void testPUTCON_N_001_26() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// List<Boolean> result = ConvertUtil.toList(false, Boolean.class);
	//
	// // 結果確認
	// for (Boolean kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_1
	// */
	// @Test
	// public void testPUTCON_E_001_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Integer[] array = { 100, 200, 300 };
	// logger.info("入力値(Integer型)：{100, 200, 300}");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(array, String.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_2
	// */
	// @Test
	// public void testPUTCON_E_001_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Long[] array = { new Long("9223372036854775807"),
	// new Long("-2147483648") };
	// logger.info("入力値(Long型)：{9223372036854775807, -2147483648}");
	//
	// // オブジェクト型変換実行
	// ConvertUtil.toList(array, Integer.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_3
	// */
	// @Test
	// public void testPUTCON_E_001_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Double[] array = { new Double("34.63E+230"), new Double("2.1E+12"),
	// new Double("999999.999999") };
	// logger.info("入力値(Double型)：{34.63E+230, 2.1E+12, 999999.999999}");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(array, Long.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_4
	// */
	// @Test
	// public void testPUTCON_E_001_4() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// BigDecimal[] array = { new BigDecimal("5.056746E+502"),
	// new BigDecimal("-9.652245423543542E+503"),
	// new BigDecimal("-1.0E+593") };
	// logger
	// .info("入力値(BigDecimal型)：{5.056746E+502, -9.652245423543542E+503, -1.0E+593}");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(array, Double.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_5
	// */
	// @Test
	// public void testPUTCON_E_001_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Boolean[] array = { true, false };
	// logger.info("入力値(Boolean型)：{true, false}");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(array, BigDecimal.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_6
	// */
	// @Test
	// public void testPUTCON_E_001_6() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// String[] array = { "AAA", "BBB", "CCC" };
	// logger.info("入力値(String型)：{AAA, BBB, CCC}");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(array, Boolean.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_7
	// */
	// @Test
	// public void testPUTCON_E_001_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Collection<Integer> collection = new ArrayList<Integer>();
	// logger.info("入力値：Collection<Integer>, String.class");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(collection, String.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_8
	// */
	// @Test
	// public void testPUTCON_E_001_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Collection<Long> collection = new ArrayList<Long>();
	// logger.info("入力値：Collection<Long>, Integer.class");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(collection, Integer.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_9
	// */
	// @Test
	// public void testPUTCON_E_001_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Collection<Double> collection = new ArrayList<Double>();
	// logger.info("入力値：Collection<Double>, Long.class");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(collection, Long.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_10
	// */
	// @Test
	// public void testPUTCON_E_001_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Collection<BigDecimal> collection = new ArrayList<BigDecimal>();
	// logger.info("入力値：Collection<BigDecimal>, Double.class");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(collection, Double.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_11
	// */
	// @Test
	// public void testPUTCON_E_001_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Collection<Boolean> collection = new ArrayList<Boolean>();
	// logger.info("入力値：Collection<Boolean>, BigDecimal.class");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(collection, BigDecimal.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_12
	// */
	// @Test
	// public void testPUTCON_E_001_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // 入力データ
	// Collection<String> collection = new ArrayList<String>();
	// logger.info("入力値：Collection<String>, Boolean.class");
	// // オブジェクト型変換実行
	// ConvertUtil.toList(collection, Boolean.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_13
	// */
	// @Test
	// public void testPUTCON_E_001_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：000, String.class");
	// ConvertUtil.toList(000, String.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_14
	// */
	// @Test
	// public void testPUTCON_E_001_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：9999999999999999L, Integer.class");
	// ConvertUtil.toList(new Long("9999999999999999"), Integer.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_15
	// */
	// @Test
	// public void testPUTCON_E_001_15() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：4.940656458412465, Long.class");
	// ConvertUtil.toList(new Double("4.940656458412465"), Long.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_16
	// */
	// @Test
	// public void testPUTCON_E_001_16() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：1.101E+593, Boolean.class");
	// ConvertUtil.toList(new BigDecimal("1.101E+593"), Double.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_17
	// */
	// @Test
	// public void testPUTCON_E_001_17() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：true, Boolean.class");
	// ConvertUtil.toList(true, BigDecimal.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_18
	// */
	// @Test
	// public void testPUTCON_E_001_18() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：'STRING', Boolean.class");
	// ConvertUtil.toList("STRING", Boolean.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_E_001_19
	// */
	// @Test
	// public void testPUTCON_E_001_19() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// try {
	// // オブジェクト型変換実行
	// logger.info("入力値：'AAA', null");
	// ConvertUtil.toList("AAA", null);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_002_1
	// */
	// @SuppressWarnings("rawtypes")
	// @Test
	// public void testPUTCON_N_002_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// field = changeField(field, "map");
	//
	// Set<Integer> set = new HashSet<Integer>();
	// set.add(1);
	// set.add(2);
	// set.add(3);
	//
	// HashMap map = (HashMap) (field.get(set));
	// field = changeField(field, "table");
	//
	// Entry[] entry = (Entry[]) (field.get(map));
	//
	// logger.info("[リサイズ前] テーブルのサイズ：" + entry.length);
	// logger.info("[リサイズ前] 格納データ数：" + set.size());
	//
	// // セットリサイズ処理
	// set = ConvertUtil.resizeSet(set);
	//
	// field = changeField(field, "map");
	// map = (HashMap) (field.get(set));
	// field = changeField(field, "table");
	// entry = (Entry[]) (field.get(map));
	//
	// logger.info("[リサイズ後] テーブルのサイズ：" + entry.length);
	// logger.info("[リサイズ後] 格納データ数：" + set.size());
	// }
	//
	// /**
	// * テストID：PUTCON_E_002_1
	// */
	// @Test
	// public void testPUTCON_E_002_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // セットリサイズ処理
	// try {
	// logger.info("入力値：null");
	// ConvertUtil.resizeSet(null);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_N_003_1
	 * @throws Exception 例外
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testPUTCON_N_003_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");

		field = changeField(field, "table");
		Entry[] entry = (Entry[]) (field.get(map));

		logger.info("[リサイズ前] テーブルのサイズ：" + entry.length);
		logger.info("[リサイズ前] 格納データ数：" + map.size());

		// マップリサイズ処理
		map = ConvertUtil.resizeMap(map);

		field = changeField(field, "table");
		entry = (Entry[]) (field.get(map));

		logger.info("[リサイズ前] テーブルのサイズ：" + entry.length);
		logger.info("[リサイズ後] 格納データ数：" + map.size());
	}

	/**
	 * テストID：PUTCON_E_003_1
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_E_003_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// セットリサイズ処理
		try {
			logger.info("入力値：null");
			ConvertUtil.resizeMap(null);
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_N_004_1
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_N_004_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("AAA", "java.lang.String");

		// 結果確認
		logger.info("型変換結果：" + result);
		assertEquals("AAA", result);
	}

	/**
	 * テストID：PUTCON_N_004_2
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_N_004_2() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("10000", "java.lang.Integer");

		// 結果確認
		logger.info("型変換結果：" + result);
		assertEquals(10000, result);
	}

	/**
	 * テストID：PUTCON_N_004_3
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_N_004_3() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("5643442543", "java.lang.Long");

		// 結果確認
		logger.info("型変換結果：" + result);
		assertEquals(5643442543L, result);
	}

	/**
	 * テストID：PUTCON_N_004_4
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_N_004_4() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("3.12E+100", "java.lang.Double");

		// 結果確認
		logger.info("型変換結果：" + result);
		assertEquals(3.12E+100d, result);
	}

	/**
	 * テストID：PUTCON_N_004_5
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_N_004_5() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("1.02567E+500",
				"java.math.BigDecimal");

		// 結果確認
		logger.info("型変換結果：" + result);
		BigDecimal input = new BigDecimal("1.02567E+500");
		assertEquals(input, result);
	}

	/**
	 * テストID：PUTCON_N_004_6
	 * @throws Exception 例外
	 */
	@Test
	public void testPUTCON_N_004_6() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("false", "java.lang.Boolean");

		// 結果確認
		logger.info("型変換結果：" + result);
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_004_7
	 */
	// @Test
	// public void testPUTCON_N_004_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// List<Integer> list = new ArrayList<Integer>();
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(list, "java.util.List");
	//
	// // 結果確認
	// assertEquals(list, result);
	// }

	/**
	 * テストID：PUTCON_N_004_8
	 */
	// @Test
	// public void testPUTCON_N_004_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(map, "java.util.Map");
	//
	// // 結果確認
	// assertEquals(map, result);
	// }

	/**
	 * テストID：PUTCON_N_004_9
	 */
	// @Test
	// public void testPUTCON_N_004_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// Collection<Long> collection = new HashSet<Long>();
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(collection,
	// "java.util.Collection");
	//
	// // 結果確認
	// assertEquals(collection, result);
	// }

	/**
	 * テストID：PUTCON_N_004_10
	 */
	@Test
	public void testPUTCON_N_004_10() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// オブジェクト型変換実行
		Object result = ConvertUtil.convert("100", "java.lang.Double");

		// 結果確認
		logger.info("型変換結果：" + result);
		assertEquals(100.0d, result);
	}

	/**
	 * テストID：PUTCON_N_004_11
	 */
	// @Test
	// public void testPUTCON_N_004_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(100, "java.lang.String");
	//
	// // 結果確認
	// logger.info("型変換結果：" + result);
	// assertEquals("100", result);
	// }

	/**
	 * テストID：PUTCON_N_004_12
	 */
	// @Test
	// public void testPUTCON_N_004_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(Integer.parseInt("100"),
	// "java.lang.Long");
	//
	// // 結果確認
	// logger.info("型変換結果：" + result);
	// assertEquals(100L, result);
	// }

	/**
	 * テストID：PUTCON_N_004_13
	 */
	// @Test
	// public void testPUTCON_N_004_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("Boolean型配列をString型へ変換するテスト");
	//
	// boolean[] input = { true, false };
	// logger.info("入力値：{true, false}");
	//
	// // オブジェクト型変換実行
	// String result = ConvertUtil.convert(input, "java.lang.String");
	// logger.info("型変換結果：" + result);
	// }

	/**
	 * テストID：PUTCON_N_004_14
	 */
	// @Test
	// public void testPUTCON_N_004_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("リスト型をリスト型へ変換するテスト");
	// List<String> input = new ArrayList<String>();
	// input.add("12345");
	// input.add("あいうえお");
	// input.add("ABCDE");
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(input, "java.util.List");
	//
	// // 結果確認
	// assertEquals(input, result);
	// }

	/**
	 * テストID：PUTCON_N_004_15
	 */
	// @Test
	// public void testPUTCON_N_004_15() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("Map型をMap型へ変換するテスト");
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("key1", "value1");
	// map.put("key2", "value2");
	// map.put("key3", "value3");
	//
	// // オブジェクト型変換実行
	// Object result = ConvertUtil.convert(map, "java.util.Map");
	//
	// // 結果確認
	// assertEquals(map, result);
	// }

	/**
	 * テストID：PUTCON_E_004_1
	 */
	@Test
	public void testPUTCON_E_004_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		try {
			// オブジェクト型変換実行
			logger.info("入力値：null, 'java.lang.String'");
			ConvertUtil.convert(null, "java.lang.String");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_E_004_2
	 */
	@Test
	public void testPUTCON_E_004_2() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		try {
			// オブジェクト型変換実行
			logger.info("入力値：'001', null");
			ConvertUtil.convert("001", null);
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_E_004_3
	 */
	@Test
	public void testPUTCON_E_004_3() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		try {
			// オブジェクト型変換実行
			logger.info("入力値：'100', 'java.lang.Test'");
			ConvertUtil.convert("100", "java.lang.Test");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_E_004_4
	 */
	@Test
	public void testPUTCON_E_004_4() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		try {
			// オブジェクト型変換実行
			logger.info("入力値：'AAA', 'java.math.BigDecimal'");
			ConvertUtil.convert("AAA", "java.math.BigDecimal");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_E_004_5
	 */
	// @SuppressWarnings("unused")
	// @Test
	// public void testPUTCON_E_004_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// boolean[] input = { true, false };
	// logger.info("入力値：{true, false}, 'java.math.BigDecimal'");
	// // オブジェクト型変換実行
	// try {
	// BigDecimal result = ConvertUtil.convert(input,
	// "java.math.BigDecimal");
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_E_004_6
	 */
	@Test
	public void testPUTCON_E_004_6() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");
		logger.info("入力値：'AAA', 'java.lang.Integer'");

		// オブジェクト型変換実行
		try {
			ConvertUtil.convert("AAA", "java.lang.Integer");
			fail();
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_E_004_7
	 */
	@Test
	public void testPUTCON_E_004_7() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");
		logger.info("入力値：'AAA', 'java.lang.Boolean'");

		// オブジェクト型変換実行
		try {
			ConvertUtil.convert("AAA", "java.lang.Boolean");
			fail();
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_E_004_8
	 */
	// @Test
	// public void testPUTCON_E_004_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("Boolean型配列をBoolean型へ変換するテスト");
	//
	// boolean[] input = { true, false };
	// logger.info("入力値：{true, false}");
	//
	// // オブジェクト型変換実行
	// try {
	// ConvertUtil.convert(input, "java.lang.Boolean");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_E_004_9
	 */
	// @Test
	// public void testPUTCON_E_004_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("String型配列をBoolean型へ変換するテスト");
	// String[] input = { "true", "false" };
	// logger.info("入力値：{'true', 'false'}");
	//
	// // オブジェクト型変換実行
	// try {
	// ConvertUtil.convert(input, "java.lang.Boolean");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_E_004_10
	 */
	// @Test
	// public void testPUTCON_E_004_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("String型配列をInteger型へ変換するテスト");
	// String[] input = { "AAA", "BBB", "CCC" };
	//
	// // オブジェクト型変換実行
	// try {
	// ConvertUtil.convert(input, "java.lang.Integer");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_E_004_11
	 */
	// @Test
	// public void testPUTCON_E_004_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("Integer型配列をLong型へ変換するテスト");
	// int[] input = { 10, 20, 30 };
	// logger.info("入力値：{10, 20, 30}");
	//
	// // オブジェクト型変換実行
	// try {
	// ConvertUtil.convert(input, "java.lang.Long");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_E_004_12
	 */
	// @Test
	// public void testPUTCON_E_004_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	// logger.info("Long型配列をDouble型へ変換するテスト");
	// long[] input = { 100L, 200L, 300L };
	// logger.info("入力値：{100L, 200L, 300L}");
	// // オブジェクト型変換実行
	//
	// try {
	// ConvertUtil.convert(input, "java.lang.Double");
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * テストID：PUTCON_E_004_13
	 */
	@Test
	public void testPUTCON_E_004_13() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");
		logger.info("StringをMap型へ変換するテスト");
		String input = "xyz";
		logger.info("入力値：'xyz'");
		// オブジェクト型変換実行

		try {
			ConvertUtil.convert(input, "java.util.Map");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * テストID：PUTCON_N_005_1
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	@Test
	public void testPUTCON_N_005_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力データ
		Map<String, Object> map = new HashMap<String, Object>();
		List list8 = new ArrayList();
		list8.add("8");
		list8.add("88");
		list8.add("888");

		map.put("key1", 1);
		map.put("key2", true);
		map.put("key3", false);
		map.put("key4", "STRING4");
		map.put("key5", new Long("-9223372036854775805"));
		map.put("key6", new BigDecimal("66.66E+666"));
		map.put("key7", new Double("4.94065645841246544e-324d"));
		map.put("key8", list8);

		Set set = map.entrySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator
					.next();
			logger.info("key=" + entry.getKey() + ", value="
					+ entry.getValue().toString());
		}

		// キー順でソートする。
		logger.info("#### <ソート実行> ####");
		List<Map.Entry<String, Object>> entries = ConvertUtil.sortMap(map);

		for (Map.Entry<String, Object> entry : entries) {
			logger.info("key=" + entry.getKey() + ", value="
					+ entry.getValue().toString());
		}
	}

	/**
	 * テストID：PUTCON_N_005_2
	 */
	@Test
	public void testPUTCON_N_005_2() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		Map<String, Object> map = new HashMap<String, Object>();

		List<Map.Entry<String, Object>> result = ConvertUtil.sortMap(map);

		List<Object> list = new ArrayList<Object>();

		// 結果確認
		assertEquals(list, result);
		assertEquals(0, result.size());
	}

	/**
	 * テストID：PUTCON_N_005_3
	 */
	@Test
	public void testPUTCON_N_005_3() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " 開始 ##########");

		List<Map.Entry<String, Object>> result = ConvertUtil.sortMap(null);

		List<Object> list = new ArrayList<Object>();

		// 結果確認
		assertEquals(list, result);
		assertEquals(0, result.size());
	}

	// /**
	// * テストID：PUTCON_N_006_1
	// */
	// @SuppressWarnings( { "unchecked", "rawtypes" })
	// @Test
	// public void testPUTCON_N_006_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// // 入力データ
	// List list8 = new ArrayList();
	// list8.add("88888");
	// list8.add("8888");
	// list8.add("888");
	// list8.add("88");
	// list8.add("8");
	//
	// Set<Object> set = new HashSet();
	// set.add(1);
	// set.add(true);
	// set.add(false);
	// set.add("STRING4");
	// set.add(new Long("22337206854775805"));
	// set.add(new BigDecimal("22.22E+590"));
	// set.add(new Double("3.940e+24d"));
	// set.add(list8);
	//
	// List<Object> before = ConvertUtil.toList(set, Object.class);
	// for (Object obj : before) {
	// logger.info(obj.toString());
	// }
	//
	// // キー順でソートする。
	// logger.info("#### <ソート実行> ####");
	// List<Object> after = ConvertUtil.sortSet(set);
	//
	// for (Object obj : after) {
	// logger.info(obj.toString());
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_006_2
	// */
	// @Test
	// public void testPUTCON_N_006_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// Set<Object> set = new HashSet<Object>();
	// List<Object> result = ConvertUtil.sortSet(set);
	//
	// List<Object> list = new ArrayList<Object>();
	//
	// // 結果確認
	// assertEquals(list, result);
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_006_3
	// */
	// @Test
	// public void testPUTCON_N_006_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// List<Object> result = ConvertUtil.sortSet(null);
	//
	// List<Object> list = new ArrayList<Object>();
	//
	// // 結果確認
	// assertEquals(list, result);
	// assertEquals(0, result.size());
	// }

	/**
	 * テストID：PUTCON_N_007_1
	 */
	@Test
	public void testPUTCON_N_007_1() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.String");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.String");
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_007_2
	 */
	@Test
	public void testPUTCON_N_007_2() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Boolean");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Boolean");
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_007_3
	 */
	@Test
	public void testPUTCON_N_007_3() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Integer");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Integer");
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_007_4
	 */
	@Test
	public void testPUTCON_N_007_4() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Long");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Long");
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_007_5
	 */
	@Test
	public void testPUTCON_N_007_5() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Float");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Float");
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_007_6
	 */
	@Test
	public void testPUTCON_N_007_6() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Double");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Double");
		assertEquals(false, result);
	}

	/**
	 * テストID：PUTCON_N_007_7
	 */
	@Test
	public void testPUTCON_N_007_7() throws Exception {

		this.toLog(this.getName().substring(4), "java.math.BigDecimal");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.math.BigDecimal");
		assertEquals(true, result);
	}

	/**
	 * テストID：PUTCON_N_007_8
	 */
	@Test
	public void testPUTCON_N_007_8() throws Exception {

		this.toLog(this.getName().substring(4), "jp.iwin.pds.BigDecimalEx");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("jp.iwin.pds.BigDecimalEx");
		assertEquals(true, result);
	}

	/**
	 * テストID：PUTCON_E_007_1
	 */
	@Test
	public void testPUTCON_E_007_1() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.XXX");
		try {
			boolean result = ConvertUtil
					.isBigDecimalAssignable("java.lang.XXX");
			fail("正常終了のためNG");
		} catch (IllegalArgumentException ex) {
			this.logger.info(null, ex);
		}
	}

	// /**
	// * テストID：PUTCON_N_008_1
	// */
	// @Test
	// public void testPUTCON_N_008_1() throws Exception {
	//
	// String testCase = this.getName().substring(4);
	// String str = null;
	// try {
	// ConvertUtil.parseCSV(str);
	// fail("正常終了するためNG");
	// } catch (Exception ex) {
	// this.toLog(testCase, ex.getMessage());
	// }
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_2
	// */
	// @Test
	// public void testPUTCON_N_008_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	//
	// // 結果確認
	// assertEquals(list, result);
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_3
	// */
	// @Test
	// public void testPUTCON_N_008_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = " ";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add(" ");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_4
	// */
	// @Test
	// public void testPUTCON_N_008_4() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = ",要素１,要素２";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("");
	// list.add("要素１");
	// list.add("要素２");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_5
	// */
	// @Test
	// public void testPUTCON_N_008_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,要素２,";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２");
	// list.add("");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_6
	// */
	// @Test
	// public void testPUTCON_N_008_6() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = ",,";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("");
	// list.add("");
	// list.add("");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_7
	// */
	// @Test
	// public void testPUTCON_N_008_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,要素２－１\",要素２－２";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２－１");
	// list.add("要素２－２");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_8
	// */
	// @Test
	// public void testPUTCON_N_008_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,\"要素２\"\"-１\",要素３";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２\"-１");
	// list.add("要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_9
	// */
	// @Test
	// public void testPUTCON_N_008_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,\"要素２－１,要素２－２\",要素３";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２－１,要素２－２");
	// list.add("要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_10
	// */
	// @Test
	// public void testPUTCON_N_008_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "\"要素１\",\"要素２\",\"要素３\"";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２");
	// list.add("要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_11
	// */
	// @Test
	// public void testPUTCON_N_008_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,要素２,要素３";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２");
	// list.add("要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_12
	// */
	// @Test
	// public void testPUTCON_N_008_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,\"要素２－１\r\n要素２－２\",要素３";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２－１");
	// list.add("要素２－２");
	// list.add("要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_13
	// */
	// @Test
	// public void testPUTCON_N_008_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,\"要素２,要素３";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２,要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * テストID：PUTCON_N_008_14
	// */
	// @Test
	// public void testPUTCON_N_008_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " 開始 ##########");
	//
	// String str = "要素１,要素２,要素３\"";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("要素１");
	// list.add("要素２");
	// list.add("要素３");
	//
	// // 結果確認
	// assertEquals(list, result);
	//
	// }

	/**
	 * テストID：PUTCON_N_009_1
	 */
	@Test
	public void testPUTCON_N_009_1() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "true";
		Boolean result = ConvertUtil.convert(input, "Boolean");
		assertEquals(Boolean.TRUE, result);
		this.toLog(testCase, String
				.format("input:%s, result:%s", input, result));
	}

	/**
	 * テストID：PUTCON_N_009_2
	 */
	@Test
	public void testPUTCON_N_009_2() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "false";
		Boolean result = ConvertUtil.convert(input,"Boolean");
		assertEquals(Boolean.FALSE, result);
		this.toLog(testCase, String
				.format("input:%s, result:%s", input, result));
	}

	/**
	 * テストID：PUTCON_E_009_1
	 */
	@Test
	public void testPUTCON_E_009_1() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "True";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("正常終了するためNG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * テストID：PUTCON_E_009_2
	 */
	@Test
	public void testPUTCON_E_009_2() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "TRUE";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("正常終了するためNG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * テストID：PUTCON_E_009_3
	 */
	@Test
	public void testPUTCON_E_009_3() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "False";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("正常終了するためNG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * テストID：PUTCON_E_009_4
	 */
	@Test
	public void testPUTCON_E_009_4() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "FALSE";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("正常終了するためNG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * ログ出力
	 *
	 * @param testCase
	 *            テストケース番号
	 * @param message
	 *            メッセージ
	 */
	private void toLog(String testCase, String message) {

		logger.info("########## " + testCase + " ##########");
		logger.info(message);
	}
}
