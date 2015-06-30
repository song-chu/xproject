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

	// // [����n�e�X�g ]
	// /**
	// * �e�X�gID�FPUTCON_N_001_1
	// */
	// @Test
	// public void testPUTCON_N_001_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<String> result = ConvertUtil.toList(null, String.class);
	//
	// // ���ʊm�F
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_2
	// */
	// @Test
	// public void testPUTCON_N_001_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Integer> result = ConvertUtil.toList(null, Integer.class);
	//
	// // ���ʊm�F
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_3
	// */
	// @Test
	// public void testPUTCON_N_001_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Long> result = ConvertUtil.toList(null, Long.class);
	//
	// // ���ʊm�F
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_4
	// */
	// @Test
	// public void testPUTCON_N_001_4() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Double> result = ConvertUtil.toList(null, Double.class);
	//
	// // ���ʊm�F
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_5
	// */
	// @Test
	// public void testPUTCON_N_001_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<BigDecimal> result = ConvertUtil.toList(null, BigDecimal.class);
	//
	// // ���ʊm�F
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_6
	// */
	// @Test
	// public void testPUTCON_N_001_6() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Boolean> result = ConvertUtil.toList(null, Boolean.class);
	//
	// // ���ʊm�F
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_7
	// */
	// @Test
	// public void testPUTCON_N_001_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// String[] array = { "AAA", "BBB", "CCC" };
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<String> result = ConvertUtil.toList(array, String.class);
	//
	// // ���ʊm�F
	// for (String kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(3, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_8
	// */
	// @Test
	// public void testPUTCON_N_001_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Integer[] array = { 100, 150, 200, 250, 300 };
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Integer> result = ConvertUtil.toList(array, Integer.class);
	//
	// // ���ʊm�F
	// for (int kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(5, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_9
	// */
	// @Test
	// public void testPUTCON_N_001_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Long[] array = { new Long("9223372036854775807"),
	// new Long("-2147483648") };
	// ;
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Long> result = ConvertUtil.toList(array, Long.class);
	//
	// // ���ʊm�F
	// for (Long kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(2, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_10
	// */
	// @Test
	// public void testPUTCON_N_001_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Double[] array = { new Double("34.63E+230"), new Double("2.1E+12"),
	// new Double("9999999999.999") };
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Double> result = ConvertUtil.toList(array, Double.class);
	//
	// // ���ʊm�F
	// for (Double kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(3, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_11
	// */
	// @Test
	// public void testPUTCON_N_001_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// BigDecimal[] array = { new BigDecimal("5.056746E+502"),
	// new BigDecimal("-9.652245423543542E+503"),
	// new BigDecimal("-1.0E+593") };
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<BigDecimal> result = ConvertUtil
	// .toList(array, BigDecimal.class);
	//
	// // ���ʊm�F
	// for (BigDecimal kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(3, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_12
	// */
	// @Test
	// public void testPUTCON_N_001_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Boolean[] array = { true, false };
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Boolean> result = ConvertUtil.toList(array, Boolean.class);
	//
	// // ���ʊm�F
	// for (boolean kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(2, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_13
	// */
	// @Test
	// public void testPUTCON_N_001_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<String> c = new ArrayList<String>();
	// c.add("AAA");
	// c.add("BBB");
	// c.add("CCC");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<String> result = ConvertUtil.toList(c, String.class);
	//
	// // ���ʊm�F
	// for (String kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_14
	// */
	// @Test
	// public void testPUTCON_N_001_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<Integer> c = new ArrayList<Integer>();
	// c.add(1);
	// c.add(100);
	// c.add(10000);
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Integer> result = ConvertUtil.toList(c, Integer.class);
	//
	// // ���ʊm�F
	// for (int kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_15
	// */
	// @Test
	// public void testPUTCON_N_001_15() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<Long> c = new ArrayList<Long>();
	// c.add(new Long("9223372036854775804"));
	// c.add(new Long("-2147483648"));
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Long> result = ConvertUtil.toList(c, Long.class);
	//
	// // ���ʊm�F
	// for (Long kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_16
	// */
	// @Test
	// public void testPUTCON_N_001_16() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<Double> c = new ArrayList<Double>();
	// c.add(new Double("99999999999.99"));
	// c.add(new Double("2.1E+123"));
	// c.add(new Double("34.63E+230"));
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Double> result = ConvertUtil.toList(c, Double.class);
	//
	// // ���ʊm�F
	// for (Double kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_17
	// */
	// @Test
	// public void testPUTCON_N_001_17() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<BigDecimal> c = new ArrayList<BigDecimal>();
	// c.add(new BigDecimal("-40.5E+400"));
	// c.add(new BigDecimal("57348925734820512345.964325697"));
	// c.add(new BigDecimal("7.5426E+417"));
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<BigDecimal> result = ConvertUtil.toList(c, BigDecimal.class);
	//
	// // ���ʊm�F
	// for (BigDecimal kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_18
	// */
	// @Test
	// public void testPUTCON_N_001_18() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<Boolean> c = new ArrayList<Boolean>();
	// c.add(false);
	// c.add(true);
	// c.add(true);
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Boolean> result = ConvertUtil.toList(c, Boolean.class);
	//
	// // ���ʊm�F
	// for (Boolean kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_19
	// */
	// @Test
	// public void testPUTCON_N_001_19() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Collection<Object> c = new ArrayList<Object>();
	// c.add(false);
	// c.add("ABCDEFG");
	// c.add(new BigDecimal("43151541351.653654235423"));
	// c.add(new Long("-6542354233"));
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Object> result = ConvertUtil.toList(c, Object.class);
	//
	// // ���ʊm�F
	// for (Object kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_20
	// */
	// @Test
	// public void testPUTCON_N_001_20() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("key1", "value1");
	// map.put("key2", 100000);
	// map.put("key3", 35E+24);
	// map.put("key4", false);
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<HashMap> result = ConvertUtil.toList(map, HashMap.class);
	//
	// // ���ʊm�F
	// for (Map<String, Object> kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_21
	// */
	// @Test
	// public void testPUTCON_N_001_21() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<String> result = ConvertUtil.toList("AAA", String.class);
	//
	// // ���ʊm�F
	// for (String kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_22
	// */
	// @Test
	// public void testPUTCON_N_001_22() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Integer> result = ConvertUtil.toList(100, Integer.class);
	//
	// // ���ʊm�F
	// for (Integer kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_23
	// */
	// @Test
	// public void testPUTCON_N_001_23() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Long> result = ConvertUtil.toList(new Long("-2147483648"),
	// Long.class);
	//
	// // ���ʊm�F
	// for (Long kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_24
	// */
	// @Test
	// public void testPUTCON_N_001_24() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Double> result = ConvertUtil.toList(new Double("2.1E+12"),
	// Double.class);
	//
	// // ���ʊm�F
	// for (Double kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_25
	// */
	// @Test
	// public void testPUTCON_N_001_25() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<BigDecimal> result = ConvertUtil.toList(new BigDecimal(
	// "5.056746E+502"), BigDecimal.class);
	//
	// // ���ʊm�F
	// for (BigDecimal kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_001_26
	// */
	// @Test
	// public void testPUTCON_N_001_26() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// List<Boolean> result = ConvertUtil.toList(false, Boolean.class);
	//
	// // ���ʊm�F
	// for (Boolean kekkachi : result) {
	// logger.info(kekkachi);
	// }
	// assertEquals(1, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_1
	// */
	// @Test
	// public void testPUTCON_E_001_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Integer[] array = { 100, 200, 300 };
	// logger.info("���͒l(Integer�^)�F{100, 200, 300}");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(array, String.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_2
	// */
	// @Test
	// public void testPUTCON_E_001_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Long[] array = { new Long("9223372036854775807"),
	// new Long("-2147483648") };
	// logger.info("���͒l(Long�^)�F{9223372036854775807, -2147483648}");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(array, Integer.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_3
	// */
	// @Test
	// public void testPUTCON_E_001_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Double[] array = { new Double("34.63E+230"), new Double("2.1E+12"),
	// new Double("999999.999999") };
	// logger.info("���͒l(Double�^)�F{34.63E+230, 2.1E+12, 999999.999999}");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(array, Long.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_4
	// */
	// @Test
	// public void testPUTCON_E_001_4() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// BigDecimal[] array = { new BigDecimal("5.056746E+502"),
	// new BigDecimal("-9.652245423543542E+503"),
	// new BigDecimal("-1.0E+593") };
	// logger
	// .info("���͒l(BigDecimal�^)�F{5.056746E+502, -9.652245423543542E+503, -1.0E+593}");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(array, Double.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_5
	// */
	// @Test
	// public void testPUTCON_E_001_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Boolean[] array = { true, false };
	// logger.info("���͒l(Boolean�^)�F{true, false}");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(array, BigDecimal.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_6
	// */
	// @Test
	// public void testPUTCON_E_001_6() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// String[] array = { "AAA", "BBB", "CCC" };
	// logger.info("���͒l(String�^)�F{AAA, BBB, CCC}");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(array, Boolean.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_7
	// */
	// @Test
	// public void testPUTCON_E_001_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Collection<Integer> collection = new ArrayList<Integer>();
	// logger.info("���͒l�FCollection<Integer>, String.class");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(collection, String.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_8
	// */
	// @Test
	// public void testPUTCON_E_001_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Collection<Long> collection = new ArrayList<Long>();
	// logger.info("���͒l�FCollection<Long>, Integer.class");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(collection, Integer.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_9
	// */
	// @Test
	// public void testPUTCON_E_001_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Collection<Double> collection = new ArrayList<Double>();
	// logger.info("���͒l�FCollection<Double>, Long.class");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(collection, Long.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_10
	// */
	// @Test
	// public void testPUTCON_E_001_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Collection<BigDecimal> collection = new ArrayList<BigDecimal>();
	// logger.info("���͒l�FCollection<BigDecimal>, Double.class");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(collection, Double.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_11
	// */
	// @Test
	// public void testPUTCON_E_001_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Collection<Boolean> collection = new ArrayList<Boolean>();
	// logger.info("���͒l�FCollection<Boolean>, BigDecimal.class");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(collection, BigDecimal.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_12
	// */
	// @Test
	// public void testPUTCON_E_001_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // ���̓f�[�^
	// Collection<String> collection = new ArrayList<String>();
	// logger.info("���͒l�FCollection<String>, Boolean.class");
	// // �I�u�W�F�N�g�^�ϊ����s
	// ConvertUtil.toList(collection, Boolean.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_13
	// */
	// @Test
	// public void testPUTCON_E_001_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�F000, String.class");
	// ConvertUtil.toList(000, String.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_14
	// */
	// @Test
	// public void testPUTCON_E_001_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�F9999999999999999L, Integer.class");
	// ConvertUtil.toList(new Long("9999999999999999"), Integer.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_15
	// */
	// @Test
	// public void testPUTCON_E_001_15() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�F4.940656458412465, Long.class");
	// ConvertUtil.toList(new Double("4.940656458412465"), Long.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_16
	// */
	// @Test
	// public void testPUTCON_E_001_16() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�F1.101E+593, Boolean.class");
	// ConvertUtil.toList(new BigDecimal("1.101E+593"), Double.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_17
	// */
	// @Test
	// public void testPUTCON_E_001_17() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�Ftrue, Boolean.class");
	// ConvertUtil.toList(true, BigDecimal.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_18
	// */
	// @Test
	// public void testPUTCON_E_001_18() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�F'STRING', Boolean.class");
	// ConvertUtil.toList("STRING", Boolean.class);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_001_19
	// */
	// @Test
	// public void testPUTCON_E_001_19() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// try {
	// // �I�u�W�F�N�g�^�ϊ����s
	// logger.info("���͒l�F'AAA', null");
	// ConvertUtil.toList("AAA", null);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_002_1
	// */
	// @SuppressWarnings("rawtypes")
	// @Test
	// public void testPUTCON_N_002_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
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
	// logger.info("[���T�C�Y�O] �e�[�u���̃T�C�Y�F" + entry.length);
	// logger.info("[���T�C�Y�O] �i�[�f�[�^���F" + set.size());
	//
	// // �Z�b�g���T�C�Y����
	// set = ConvertUtil.resizeSet(set);
	//
	// field = changeField(field, "map");
	// map = (HashMap) (field.get(set));
	// field = changeField(field, "table");
	// entry = (Entry[]) (field.get(map));
	//
	// logger.info("[���T�C�Y��] �e�[�u���̃T�C�Y�F" + entry.length);
	// logger.info("[���T�C�Y��] �i�[�f�[�^���F" + set.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_E_002_1
	// */
	// @Test
	// public void testPUTCON_E_002_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �Z�b�g���T�C�Y����
	// try {
	// logger.info("���͒l�Fnull");
	// ConvertUtil.resizeSet(null);
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_N_003_1
	 * @throws Exception ��O
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testPUTCON_N_003_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");

		field = changeField(field, "table");
		Entry[] entry = (Entry[]) (field.get(map));

		logger.info("[���T�C�Y�O] �e�[�u���̃T�C�Y�F" + entry.length);
		logger.info("[���T�C�Y�O] �i�[�f�[�^���F" + map.size());

		// �}�b�v���T�C�Y����
		map = ConvertUtil.resizeMap(map);

		field = changeField(field, "table");
		entry = (Entry[]) (field.get(map));

		logger.info("[���T�C�Y�O] �e�[�u���̃T�C�Y�F" + entry.length);
		logger.info("[���T�C�Y��] �i�[�f�[�^���F" + map.size());
	}

	/**
	 * �e�X�gID�FPUTCON_E_003_1
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_E_003_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �Z�b�g���T�C�Y����
		try {
			logger.info("���͒l�Fnull");
			ConvertUtil.resizeMap(null);
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_1
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_N_004_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("AAA", "java.lang.String");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		assertEquals("AAA", result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_2
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_N_004_2() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("10000", "java.lang.Integer");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		assertEquals(10000, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_3
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_N_004_3() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("5643442543", "java.lang.Long");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		assertEquals(5643442543L, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_4
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_N_004_4() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("3.12E+100", "java.lang.Double");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		assertEquals(3.12E+100d, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_5
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_N_004_5() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("1.02567E+500",
				"java.math.BigDecimal");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		BigDecimal input = new BigDecimal("1.02567E+500");
		assertEquals(input, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_6
	 * @throws Exception ��O
	 */
	@Test
	public void testPUTCON_N_004_6() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("false", "java.lang.Boolean");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_7
	 */
	// @Test
	// public void testPUTCON_N_004_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// List<Integer> list = new ArrayList<Integer>();
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(list, "java.util.List");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_8
	 */
	// @Test
	// public void testPUTCON_N_004_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(map, "java.util.Map");
	//
	// // ���ʊm�F
	// assertEquals(map, result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_9
	 */
	// @Test
	// public void testPUTCON_N_004_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// Collection<Long> collection = new HashSet<Long>();
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(collection,
	// "java.util.Collection");
	//
	// // ���ʊm�F
	// assertEquals(collection, result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_10
	 */
	@Test
	public void testPUTCON_N_004_10() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// �I�u�W�F�N�g�^�ϊ����s
		Object result = ConvertUtil.convert("100", "java.lang.Double");

		// ���ʊm�F
		logger.info("�^�ϊ����ʁF" + result);
		assertEquals(100.0d, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_004_11
	 */
	// @Test
	// public void testPUTCON_N_004_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(100, "java.lang.String");
	//
	// // ���ʊm�F
	// logger.info("�^�ϊ����ʁF" + result);
	// assertEquals("100", result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_12
	 */
	// @Test
	// public void testPUTCON_N_004_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(Integer.parseInt("100"),
	// "java.lang.Long");
	//
	// // ���ʊm�F
	// logger.info("�^�ϊ����ʁF" + result);
	// assertEquals(100L, result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_13
	 */
	// @Test
	// public void testPUTCON_N_004_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("Boolean�^�z���String�^�֕ϊ�����e�X�g");
	//
	// boolean[] input = { true, false };
	// logger.info("���͒l�F{true, false}");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// String result = ConvertUtil.convert(input, "java.lang.String");
	// logger.info("�^�ϊ����ʁF" + result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_14
	 */
	// @Test
	// public void testPUTCON_N_004_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("���X�g�^�����X�g�^�֕ϊ�����e�X�g");
	// List<String> input = new ArrayList<String>();
	// input.add("12345");
	// input.add("����������");
	// input.add("ABCDE");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(input, "java.util.List");
	//
	// // ���ʊm�F
	// assertEquals(input, result);
	// }

	/**
	 * �e�X�gID�FPUTCON_N_004_15
	 */
	// @Test
	// public void testPUTCON_N_004_15() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("Map�^��Map�^�֕ϊ�����e�X�g");
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("key1", "value1");
	// map.put("key2", "value2");
	// map.put("key3", "value3");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// Object result = ConvertUtil.convert(map, "java.util.Map");
	//
	// // ���ʊm�F
	// assertEquals(map, result);
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_1
	 */
	@Test
	public void testPUTCON_E_004_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		try {
			// �I�u�W�F�N�g�^�ϊ����s
			logger.info("���͒l�Fnull, 'java.lang.String'");
			ConvertUtil.convert(null, "java.lang.String");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_004_2
	 */
	@Test
	public void testPUTCON_E_004_2() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		try {
			// �I�u�W�F�N�g�^�ϊ����s
			logger.info("���͒l�F'001', null");
			ConvertUtil.convert("001", null);
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_004_3
	 */
	@Test
	public void testPUTCON_E_004_3() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		try {
			// �I�u�W�F�N�g�^�ϊ����s
			logger.info("���͒l�F'100', 'java.lang.Test'");
			ConvertUtil.convert("100", "java.lang.Test");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_004_4
	 */
	@Test
	public void testPUTCON_E_004_4() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		try {
			// �I�u�W�F�N�g�^�ϊ����s
			logger.info("���͒l�F'AAA', 'java.math.BigDecimal'");
			ConvertUtil.convert("AAA", "java.math.BigDecimal");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_004_5
	 */
	// @SuppressWarnings("unused")
	// @Test
	// public void testPUTCON_E_004_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// boolean[] input = { true, false };
	// logger.info("���͒l�F{true, false}, 'java.math.BigDecimal'");
	// // �I�u�W�F�N�g�^�ϊ����s
	// try {
	// BigDecimal result = ConvertUtil.convert(input,
	// "java.math.BigDecimal");
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_6
	 */
	@Test
	public void testPUTCON_E_004_6() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");
		logger.info("���͒l�F'AAA', 'java.lang.Integer'");

		// �I�u�W�F�N�g�^�ϊ����s
		try {
			ConvertUtil.convert("AAA", "java.lang.Integer");
			fail();
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_004_7
	 */
	@Test
	public void testPUTCON_E_004_7() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");
		logger.info("���͒l�F'AAA', 'java.lang.Boolean'");

		// �I�u�W�F�N�g�^�ϊ����s
		try {
			ConvertUtil.convert("AAA", "java.lang.Boolean");
			fail();
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_004_8
	 */
	// @Test
	// public void testPUTCON_E_004_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("Boolean�^�z���Boolean�^�֕ϊ�����e�X�g");
	//
	// boolean[] input = { true, false };
	// logger.info("���͒l�F{true, false}");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// try {
	// ConvertUtil.convert(input, "java.lang.Boolean");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_9
	 */
	// @Test
	// public void testPUTCON_E_004_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("String�^�z���Boolean�^�֕ϊ�����e�X�g");
	// String[] input = { "true", "false" };
	// logger.info("���͒l�F{'true', 'false'}");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// try {
	// ConvertUtil.convert(input, "java.lang.Boolean");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_10
	 */
	// @Test
	// public void testPUTCON_E_004_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("String�^�z���Integer�^�֕ϊ�����e�X�g");
	// String[] input = { "AAA", "BBB", "CCC" };
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// try {
	// ConvertUtil.convert(input, "java.lang.Integer");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_11
	 */
	// @Test
	// public void testPUTCON_E_004_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("Integer�^�z���Long�^�֕ϊ�����e�X�g");
	// int[] input = { 10, 20, 30 };
	// logger.info("���͒l�F{10, 20, 30}");
	//
	// // �I�u�W�F�N�g�^�ϊ����s
	// try {
	// ConvertUtil.convert(input, "java.lang.Long");
	// fail();
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_12
	 */
	// @Test
	// public void testPUTCON_E_004_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	// logger.info("Long�^�z���Double�^�֕ϊ�����e�X�g");
	// long[] input = { 100L, 200L, 300L };
	// logger.info("���͒l�F{100L, 200L, 300L}");
	// // �I�u�W�F�N�g�^�ϊ����s
	//
	// try {
	// ConvertUtil.convert(input, "java.lang.Double");
	// } catch (IllegalArgumentException e) {
	// logger.info(e);
	// }
	// }

	/**
	 * �e�X�gID�FPUTCON_E_004_13
	 */
	@Test
	public void testPUTCON_E_004_13() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");
		logger.info("String��Map�^�֕ϊ�����e�X�g");
		String input = "xyz";
		logger.info("���͒l�F'xyz'");
		// �I�u�W�F�N�g�^�ϊ����s

		try {
			ConvertUtil.convert(input, "java.util.Map");
		} catch (IllegalArgumentException e) {
			logger.info(e);
		}
	}

	/**
	 * �e�X�gID�FPUTCON_N_005_1
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	@Test
	public void testPUTCON_N_005_1() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���̓f�[�^
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

		// �L�[���Ń\�[�g����B
		logger.info("#### <�\�[�g���s> ####");
		List<Map.Entry<String, Object>> entries = ConvertUtil.sortMap(map);

		for (Map.Entry<String, Object> entry : entries) {
			logger.info("key=" + entry.getKey() + ", value="
					+ entry.getValue().toString());
		}
	}

	/**
	 * �e�X�gID�FPUTCON_N_005_2
	 */
	@Test
	public void testPUTCON_N_005_2() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		Map<String, Object> map = new HashMap<String, Object>();

		List<Map.Entry<String, Object>> result = ConvertUtil.sortMap(map);

		List<Object> list = new ArrayList<Object>();

		// ���ʊm�F
		assertEquals(list, result);
		assertEquals(0, result.size());
	}

	/**
	 * �e�X�gID�FPUTCON_N_005_3
	 */
	@Test
	public void testPUTCON_N_005_3() throws Exception {

		logger.info("");
		logger.info("########## " + this.getName() + " �J�n ##########");

		List<Map.Entry<String, Object>> result = ConvertUtil.sortMap(null);

		List<Object> list = new ArrayList<Object>();

		// ���ʊm�F
		assertEquals(list, result);
		assertEquals(0, result.size());
	}

	// /**
	// * �e�X�gID�FPUTCON_N_006_1
	// */
	// @SuppressWarnings( { "unchecked", "rawtypes" })
	// @Test
	// public void testPUTCON_N_006_1() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// // ���̓f�[�^
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
	// // �L�[���Ń\�[�g����B
	// logger.info("#### <�\�[�g���s> ####");
	// List<Object> after = ConvertUtil.sortSet(set);
	//
	// for (Object obj : after) {
	// logger.info(obj.toString());
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_006_2
	// */
	// @Test
	// public void testPUTCON_N_006_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// Set<Object> set = new HashSet<Object>();
	// List<Object> result = ConvertUtil.sortSet(set);
	//
	// List<Object> list = new ArrayList<Object>();
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_006_3
	// */
	// @Test
	// public void testPUTCON_N_006_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// List<Object> result = ConvertUtil.sortSet(null);
	//
	// List<Object> list = new ArrayList<Object>();
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	// assertEquals(0, result.size());
	// }

	/**
	 * �e�X�gID�FPUTCON_N_007_1
	 */
	@Test
	public void testPUTCON_N_007_1() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.String");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.String");
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_2
	 */
	@Test
	public void testPUTCON_N_007_2() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Boolean");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Boolean");
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_3
	 */
	@Test
	public void testPUTCON_N_007_3() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Integer");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Integer");
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_4
	 */
	@Test
	public void testPUTCON_N_007_4() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Long");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Long");
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_5
	 */
	@Test
	public void testPUTCON_N_007_5() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Float");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Float");
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_6
	 */
	@Test
	public void testPUTCON_N_007_6() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.Double");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.lang.Double");
		assertEquals(false, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_7
	 */
	@Test
	public void testPUTCON_N_007_7() throws Exception {

		this.toLog(this.getName().substring(4), "java.math.BigDecimal");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("java.math.BigDecimal");
		assertEquals(true, result);
	}

	/**
	 * �e�X�gID�FPUTCON_N_007_8
	 */
	@Test
	public void testPUTCON_N_007_8() throws Exception {

		this.toLog(this.getName().substring(4), "jp.iwin.pds.BigDecimalEx");
		boolean result = ConvertUtil
				.isBigDecimalAssignable("jp.iwin.pds.BigDecimalEx");
		assertEquals(true, result);
	}

	/**
	 * �e�X�gID�FPUTCON_E_007_1
	 */
	@Test
	public void testPUTCON_E_007_1() throws Exception {

		this.toLog(this.getName().substring(4), "java.lang.XXX");
		try {
			boolean result = ConvertUtil
					.isBigDecimalAssignable("java.lang.XXX");
			fail("����I���̂���NG");
		} catch (IllegalArgumentException ex) {
			this.logger.info(null, ex);
		}
	}

	// /**
	// * �e�X�gID�FPUTCON_N_008_1
	// */
	// @Test
	// public void testPUTCON_N_008_1() throws Exception {
	//
	// String testCase = this.getName().substring(4);
	// String str = null;
	// try {
	// ConvertUtil.parseCSV(str);
	// fail("����I�����邽��NG");
	// } catch (Exception ex) {
	// this.toLog(testCase, ex.getMessage());
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_2
	// */
	// @Test
	// public void testPUTCON_N_008_2() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	// assertEquals(0, result.size());
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_3
	// */
	// @Test
	// public void testPUTCON_N_008_3() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = " ";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add(" ");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_4
	// */
	// @Test
	// public void testPUTCON_N_008_4() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = ",�v�f�P,�v�f�Q";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("");
	// list.add("�v�f�P");
	// list.add("�v�f�Q");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_5
	// */
	// @Test
	// public void testPUTCON_N_008_5() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,�v�f�Q,";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q");
	// list.add("");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_6
	// */
	// @Test
	// public void testPUTCON_N_008_6() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = ",,";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("");
	// list.add("");
	// list.add("");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_7
	// */
	// @Test
	// public void testPUTCON_N_008_7() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,�v�f�Q�|�P\",�v�f�Q�|�Q";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q�|�P");
	// list.add("�v�f�Q�|�Q");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_8
	// */
	// @Test
	// public void testPUTCON_N_008_8() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,\"�v�f�Q\"\"-�P\",�v�f�R";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q\"-�P");
	// list.add("�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_9
	// */
	// @Test
	// public void testPUTCON_N_008_9() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,\"�v�f�Q�|�P,�v�f�Q�|�Q\",�v�f�R";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q�|�P,�v�f�Q�|�Q");
	// list.add("�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_10
	// */
	// @Test
	// public void testPUTCON_N_008_10() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "\"�v�f�P\",\"�v�f�Q\",\"�v�f�R\"";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q");
	// list.add("�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_11
	// */
	// @Test
	// public void testPUTCON_N_008_11() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,�v�f�Q,�v�f�R";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q");
	// list.add("�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_12
	// */
	// @Test
	// public void testPUTCON_N_008_12() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,\"�v�f�Q�|�P\r\n�v�f�Q�|�Q\",�v�f�R";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q�|�P");
	// list.add("�v�f�Q�|�Q");
	// list.add("�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_13
	// */
	// @Test
	// public void testPUTCON_N_008_13() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,\"�v�f�Q,�v�f�R";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q,�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }
	//
	// /**
	// * �e�X�gID�FPUTCON_N_008_14
	// */
	// @Test
	// public void testPUTCON_N_008_14() throws Exception {
	//
	// logger.info("");
	// logger.info("########## " + this.getName() + " �J�n ##########");
	//
	// String str = "�v�f�P,�v�f�Q,�v�f�R\"";
	// List<String> result = ConvertUtil.parseCSV(str);
	//
	// List<String> list = new ArrayList<String>();
	// list.add("�v�f�P");
	// list.add("�v�f�Q");
	// list.add("�v�f�R");
	//
	// // ���ʊm�F
	// assertEquals(list, result);
	//
	// }

	/**
	 * �e�X�gID�FPUTCON_N_009_1
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
	 * �e�X�gID�FPUTCON_N_009_2
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
	 * �e�X�gID�FPUTCON_E_009_1
	 */
	@Test
	public void testPUTCON_E_009_1() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "True";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("����I�����邽��NG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_009_2
	 */
	@Test
	public void testPUTCON_E_009_2() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "TRUE";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("����I�����邽��NG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_009_3
	 */
	@Test
	public void testPUTCON_E_009_3() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "False";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("����I�����邽��NG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * �e�X�gID�FPUTCON_E_009_4
	 */
	@Test
	public void testPUTCON_E_009_4() throws Exception {

		String testCase = this.getName().substring(4);
		String input = "FALSE";
		try {
			ConvertUtil.convert(input,"Boolean");
			fail("����I�����邽��NG");
		} catch (IllegalArgumentException e) {
			this.toLog(testCase, String.format("input:%s, result:%s", input, e
					.getMessage()));
		}
	}

	/**
	 * ���O�o��
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param message
	 *            ���b�Z�[�W
	 */
	private void toLog(String testCase, String message) {

		logger.info("########## " + testCase + " ##########");
		logger.info(message);
	}
}
