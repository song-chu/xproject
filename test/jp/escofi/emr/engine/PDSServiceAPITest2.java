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
	 * �_���v���\�[�X�x�[�X�t�H���_
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSServiceAPI2_Dump";

	public PDSServiceAPITest2() {

		super(PDSServiceAPITest2.class, BASE_FOLDER);
	}

	/**
	 * �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
	 *
	 * @param dataModelName
	 *            �f�[�^���f����(�e�X�g�P�[�XID)
	 * @param vars
	 *            �������ږ�=�������ڒl
	 * @return PDS�����N���X
	 * @throws Exception
	 */
	private PDSResponse execute(String dataModelName, String... vars)
			throws Exception {

		// ----------------------<<���͒l�ݒ�>>-------------------------------//
		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add(dataModelName); // �C���|�C���g
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(dataModelName);

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		// �������ڎ擾����
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res
				.getConditionItemInfoMap();

		if (conditionItemInfoMap == null) {
			return res;
		}

		// �������ڒlMap
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();

		String itemName = null; // �������ږ�
		String itemType = null; // �������ڃf�[�^�^
		String javaDataType = null; // �������ړ����f�[�^�^
		List<String> searchInfo = null; // �������ڎ擾���
		Object varValue = null; // �������ڒl

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		String var = "";
		for (ConditionItemInfo conditionItemInfo : collection) {

			// �������ڃN���X��������擾����B
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

			// �������ڎ擾���Ɋ�Â��A�������ڂ��擾��A
			// �������ڃf�[�^�^�A�������ړ����f�[�^�^�ɍ��킹�Č^�ϊ����A�������ڒl�ɑ������B
			varValue = PUTConvertUtil.convert(var, javaDataType);

			// �������ڒl�}�b�v�ɐݒ�
			conditionItemValueMap.put(itemName, varValue);
		}
		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}

		// PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
		res.setConditionItemValueMap(conditionItemValueMap);

		// �����l�擾���\�b�h���Ăяo���B
		res = PDSServiceAPI.getAttrValue(res);
		return res;
	}

	/**
	 * ���ʊm�F
	 *
	 * @param res
	 */
	private void assertResult(PDSResponse res, String flag) {
		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		// ���ʒl

		if (flag.substring(0, 4).equals("true")) {
			assertEquals(flag, result);
		} else {
			assertEquals(flag, result);
		}
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_1
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_1() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_1", "var1=����������",
				"var2=����������", "var3=����������", "var4=����������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("value1");

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_2
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_2() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_2", "var1=const3",
				"var2=const3", "var3=const3", "var4=const3", "var5=const3",
				"var6=const3", "var7=const3", "var8=const3", "var9=const9");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, Boolean> result = (Map<String, Boolean>) res
				.getResultObject().getValue();
		Map<String, Boolean> expected = new HashMap<String, Boolean>();
		expected.put("key1", Boolean.FALSE);
		expected.put("key2", Boolean.TRUE);
		expected.put("key3", Boolean.TRUE);
		expected.put("key4", Boolean.TRUE);
		expected.put("key5", Boolean.TRUE);

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_3
	 */
	@Test
	public void testPENSER_N_002_3() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_3");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.DELETED, res.getStatus());
		// �������L���m�F
		assertEquals(false, res.isCondition());
		// �����l�m�F
		Object result = res.getResultObject().getValue();

		// ���ʒl
		assertEquals(null, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//

	}

	/**
	 * �e�X�gID�FPENSER_N_002_4
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_4() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_4", "var1=const1",
				"var2=const2", "var3=const2", "var4=const4", "var5=const5",
				"var6=const6", "var7=const7", "var8=const8", "var9=const3");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, Long> result = (Map<String, Long>) res.getResultObject()
				.getValue();
		Map<String, Long> expected = new HashMap<String, Long>();
		expected.put("key1", new Long(9000000000000000000l));
		expected.put("key2", new Long(-2000000000l));
		expected.put("key3", new Long(0l));
		expected.put("key4", new Long(10000l));
		expected.put("key5", new Long(123456l));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_5
	 */
	@Test
	public void testPENSER_N_002_5() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_5", "var1=�R���X�g�P",
				"var2=�R���X�g�Q", "var3=�R���X�g�R", "var4=�R���X�g�S", "var5=�R���X�g�T",
				"var6=�R���X�g�U", "var7=�R���X�g�V", "var8=�R���X�g�W", "var9=�R���X�g�X",
				"var10=�R���X�g�P�O", "var11=�R���X�g�P�P", "var12=�R���X�g�P�Q", "var13=�R���X�g�P�R",
				"var14=�R���X�g�P�S", "var15=�R���X�g�P�T", "var16=�R���X�g�P�U", "var17=�R���X�g�P�V",
				"var18=�R���X�g�P�W", "var19=�R���X�g�P�W", "var20=�R���X�g�Q�O", "var21=�R���X�g�Q�O",
				"var22=�R���X�g�Q�Q", "var23=�R���X�g�Q�Q", "var24=�R���X�g�Q�R", "var25=�R���X�g�Q�R");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// ����l�m�F
		assertEquals(1.797693134862315e308d, result.getUpper());
		// �����l�m�F
		assertEquals(-1.797693134862315e308d, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_6
	 */
	@Test
	public void testPENSER_N_002_6() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_6", "var1=��������",
				"var2=��������");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname6", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo6"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_7
	 */
	@Test
	public void testPENSER_N_002_7() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_7", "var1=const3",
				"var2=const3", "var3=const3", "var4=const3", "var5=const3",
				"var6=const3", "var7=const3", "var8=const3", "var9=const3",
				"var10=const3", "var11=const3", "var12=const3", "var13=const3",
				"var14=const3", "var15=const3", "var16=const3", "var17=const3",
				"var18=const3", "var19=�R���X�g�P�X", "var20=const3", "var21=�R���X�g�Q�P",
				"var22=const3", "var23=�R���X�g�Q�R", "var24=�R���X�g�Q�S", "var25=�R���X�g�Q�T");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// ����l�m�F
		assertEquals("elsed", result.getUpper().toString());
		// �����l�m�F
		assertEquals("elsec", result.getLower().toString());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_8
	 */
	@Test
	public void testPENSER_N_002_8() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_8", "var1=��������",
				"var2=��������");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname8", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo8"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_9
	 */
	@Test
	public void testPENSER_N_002_9() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_9", "var1=2147483645",
				"var2=-2147483448", "var3=1111111112", "var4=1234567890");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname9", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo9"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_10
	 */
	@Test
	public void testPENSER_N_002_10() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_10", "var1=2147483647",
				"var2=-2147483648", "var3=1000000000", "var4=-1111111111",
				"var5=0", "var6=2147483646", "var7=-2147483647",
				"var8=100000000", "var9=-111111111", "var10=1", "var11=1");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// ����l�m�F
		assertEquals(1000, result.getUpper());
		// �����l�m�F
		assertEquals(100, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_11
	 */
	@Test
	public void testPENSER_N_002_11() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_11", "var1=2147483647",
				"var2=-2147483648", "var3=1111111111", "var4=1234567891");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname11", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo11"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_12
	 */
	@Test
	public void testPENSER_N_002_12() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_12", "var1=2147483646",
				"var2=-2147483647", "var3=1000000001", "var4=-1111111112",
				"var5=1", "var6=2147483645", "var7=-2147483648",
				"var8=100000001", "var9=-111111112", "var10=0", "var11=0");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		;
		// ����l�m�F
		assertEquals(new Long(12345678901l), result.getUpper());
		// �����l�m�F
		assertEquals(new Long(-12345678901l), result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_13
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_13() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_13", "var1=0", "var2=0",
				"var3=2", "var4=2", "var5=4", "var6=4", "var7=6", "var8=6",
				"var9=8", "var10=8", "var11=10", "var12=10", "var13=12",
				"var14=12", "var15=14", "var16=14", "var17=16", "var18=16",
				"var19=2000000000", "var20=2000000000", "var21=-2000000000",
				"var22=-2000000000", "var23=10000", "var24=10000");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, Double> result = (Map<String, Double>) res
				.getResultObject().getValue();
		Map<String, Double> expected = new HashMap<String, Double>();
		expected.put("key1", 4.940656458412465e-324d);

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_14
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_14() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_14", "var1=2147483647",
				"var2=-2147483640", "var3=11111111");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<BigDecimal> result = (List<BigDecimal>) res.getResultObject()
				.getValue();
		List<BigDecimal> expected = new ArrayList<BigDecimal>();
		expected.add(new BigDecimal("9876543210987654321098765.5"));
		expected.add(new BigDecimal("-9876543210987654321098765.5"));
		expected.add(new BigDecimal("3.0001"));
		expected.add(new BigDecimal("400"));
		expected.add(new BigDecimal("500001"));

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_15
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_15() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_15", "var1=0", "var2=1",
				"var3=2", "var4=3", "var5=4", "var6=5", "var7=6", "var8=7",
				"var9=8", "var10=9", "var11=10", "var12=11", "var13=12",
				"var14=13", "var15=14", "var16=15", "var17=16", "var18=17",
				"var19=18", "var20=19", "var21=20", "var22=21", "var23=22",
				"var24=23");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "ifValue1");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_16
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_16() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_16", "var1=2147483640",
				"var2=-2147483640", "var3=1111111111", "var4=11111111",
				"var5=2500", "var6=57000");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<BigDecimal> result = (List<BigDecimal>) res.getResultObject()
				.getValue();
		List<BigDecimal> expected = new ArrayList<BigDecimal>();
		expected.add(new BigDecimal("123456789012345678901234567890.1"));
		expected.add(new BigDecimal("-123456789012345678901234567890.1"));
		expected.add(new BigDecimal("3.0001"));
		expected.add(new BigDecimal("400"));
		expected.add(new BigDecimal("500001"));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_17
	 */
	@Test
	public void testPENSER_N_002_17() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_17",
				"var1=9223372036854775806", "var2=-9223372036854775807",
				"var3=2");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals("����������", result.getUpper());
		// �����l�m�F
		assertEquals("����������", result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_18
	 */
	@Test
	public void testPENSER_N_002_18() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
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

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname18", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo18"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_19
	 */
	@Test
	public void testPENSER_N_002_19() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_19",
				"var1=9223372036854775807", "var2=-9223372036854775808",
				"var3=3");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(2147483647, result.getUpper());
		// �����l�m�F
		assertEquals(-2147483648, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_20
	 */
	@Test
	public void testPENSER_N_002_20() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
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

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname20", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo20"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_21
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_21() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_21",
				"var1=11111111111111", "var2=-2147483640",
				"var3=5011100000000000", "var4=-100000000000000000",
				"var5=111111111111111");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<Double> result = (List<Double>) res.getResultObject().getValue();
		List<Double> expected = new ArrayList<Double>();
		expected.add(new Double(1.79e308d));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_22
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_22() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_22",
				"var1=999992147483646", "var2=-999992147483647", "var3=501",
				"var4=1", "var5=2999", "var6=-519");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) res
				.getResultObject().getValue();
		Map<String, BigDecimal> expected = new HashMap<String, BigDecimal>();
		expected.put("key1", new BigDecimal("12345678901234567890.1"));
		expected.put("key2", new BigDecimal("-12345678901234567890.1"));
		expected.put("key3", new BigDecimal("0"));
		expected.put("key4", new BigDecimal("1"));
		expected.put("key5", new BigDecimal("10000"));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_23
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_23() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_23",
				"var1=111111111111112", "var2=-2147483641",
				"var3=5011100000000001", "var4=-100000000000000001",
				"var5=111111111111112");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("�e�X�g�P�[�X�Q�ROK");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_24
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_24() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_24",
				"var1=999992147483647", "var2=-999992147483648", "var3=500",
				"var4=0", "var5=3000", "var6=-520");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) res
				.getResultObject().getValue();
		Map<String, BigDecimal> expected = new HashMap<String, BigDecimal>();
		expected.put("key1", new BigDecimal("50000000000000000000"));
		expected.put("key2", new BigDecimal("0.002"));
		expected.put("key3", new BigDecimal("0"));
		expected.put("key4", new BigDecimal("1"));
		expected.put("key5", new BigDecimal("10000"));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_25
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_25() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_25", "var1=2147483648",
				"var2=2147.483647", "var3=21474836470000000001",
				"var4=-21474836470000000001", "var5=1111111111",
				"var6=1111111112", "var7=25001", "var8=57001");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "�Ȃɂʂ���");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_26
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_26() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_26", "var1=2147483641",
				"var2=-2147483641", "var3=50111.00002", "var4=101",
				"var5=214.7483641", "var6=-214.7483641", "var7=0.000000041",
				"var8=2.222333444555666e100d");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<Boolean> result = (List<Boolean>) res.getResultObject().getValue();
		List<Boolean> expected = new ArrayList<Boolean>();
		expected.add(true);
		expected.add(false);
		expected.add(true);
		expected.add(false);
		expected.add(true);

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_27
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_27() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_27", "var1=2147483647",
				"var2=2147.483646", "var3=21474836470000000000",
				"var4=-21474836470000000000", "var5=111111111",
				"var6=1111111111", "var7=25000", "var8=57000");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, Integer> result = (Map<String, Integer>) res
				.getResultObject().getValue();
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("key1", new Integer("2147483647"));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_28
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_28() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_28", "var1=2147483640",
				"var2=-2147483640", "var3=50111.00001", "var4=100",
				"var5=214.7483640", "var6=-214.7483640", "var7=0.00000004",
				"var8=222222222222222");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<Long> result = (List<Long>) res.getResultObject().getValue();
		List<Long> expected = new ArrayList<Long>();
		expected.add(new Long(123456789012345l));
		expected.add(new Long(-123456789012345l));
		expected.add(new Long(1l));
		expected.add(new Long(50000l));
		expected.add(new Long(1234567890l));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_29
	 */
	@Test
	public void testPENSER_N_002_29() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_29", "var1=33147483646",
				"var2=-3347483647", "var3=0.00000003", "var4=-1.00006");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname29", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo29"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_30
	 */
	@Test
	public void testPENSER_N_002_30() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_30",
				"var1=1.92233720368547e100", "var2=1.92233720368547e100",
				"var3=-1.92233720368547e100", "var4=-1.92233720368547e100",
				"var5=0.000000001", "var6=0.000000001");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(new BigDecimal("111111111121474836479.2"), result.getUpper());
		// �����l�m�F
		assertEquals(new BigDecimal("-111111111121474836480.1"), result
				.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_31
	 */
	@Test
	public void testPENSER_N_002_31() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_31",
				"var1=33147483647000000000", "var2=-33474836480000000000",
				"var3=0.00000004", "var4=-1.00005");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname31", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo31"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_32
	 */
	@Test
	public void testPENSER_N_002_32() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_32",
				"var1=1.92233720368547e100", "var2=1.92233720368548e100",
				"var3=-1.92233720368547e100", "var4=-1.92233720368548e100",
				"var5=0.000000001", "var6=0.000000002");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(new BigDecimal("111111111121474836479.2"), result.getUpper());
		// �����l�m�F
		assertEquals(new BigDecimal("-111111111121474836480.1"), result
				.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_33
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_33() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_33", "var1=2147483647",
				"var2=-2147483648", "var3=21474836470000000000",
				"var4=-21474836480000000000.2", "var5=2147483648");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "�e�X�g�P�[�X�R�ROK");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_34
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_34() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_34",
				"var1=20000000000000000000", "var2=-20000000000000000001",
				"var3=0.0000000000000000001");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_35
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_35() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_35", "var1=2147483646",
				"var2=-2147483647", "var3=21474836470000000000.1",
				"var4=-21474836480000000000", "var5=2147483647");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, Integer> result = (Map<String, Integer>) res
				.getResultObject().getValue();
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("key1", new Integer("2000000000"));

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_36
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_36() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_36",
				"var1=20000000000000000001", "var2=-20000000000000000000",
				"var3=0.000000000000000001");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_37
	 */
	@Test
	public void testPENSER_N_002_37() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_37",
				"var1=12345678901234567890", "var2=12345678901234567891",
				"var3=-12345678901234567890", "var4=-12345678901234567892",
				"var5=0.00000000000000000001", "var6=0.00000000000000000002",
				"var7=-0.00000000000000000001", "var8=-0.0000000000000000001",
				"var9=10000", "var10=10001", "var11=-2000", "var12=-2000");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname37", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo37"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_38
	 */
	@Test
	public void testPENSER_N_002_38() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_38", "var1=33147483647",
				"var2=-3347483648", "var3=0.00000004", "var4=-1.00005",
				"var5=0.00000004", "var6=-1.00005",
				"var7=20000000000000000000.09",
				"var8=-20000000000000000000.08",
				"var9=12345678901234567890.001",
				"var10=-12345678901234567890.001");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(new BigDecimal("10000000000000000000.2"), result.getUpper());
		// �����l�m�F
		assertEquals(new BigDecimal("-10000000000000000000.1"), result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_39
	 */
	@Test
	public void testPENSER_N_002_39() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_39",
				"var1=12345678901234567890", "var2=12345678901234567890",
				"var3=-12345678901234567890", "var4=-12345678901234567890",
				"var5=0.00000000000000000001", "var6=0.00000000000000000001",
				"var7=-0.00000000000000000001", "var8=-0.00000000000000000001",
				"var9=10000", "var10=10000", "var11=-2000", "var12=-2001");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname39", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo39"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_40
	 */
	@Test
	public void testPENSER_N_002_40() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_40", "var1=33147483648",
				"var2=-3347483647", "var3=0.00000005", "var4=-1.00004",
				"var5=0.00000003", "var6=-1.00004",
				"var7=20000000000000000000.08",
				"var8=-20000000000000000000.08",
				"var9=12345678901234567890.002",
				"var10=-12345678901234567890.000");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(new BigDecimal("10000000000000000000.2"), result.getUpper());
		// �����l�m�F
		assertEquals(new BigDecimal("-10000000000000000000.1"), result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_41
	 */
	@Test
	public void testPENSER_N_002_41() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_41", "var1=true",
				"var2=true", "var3=false", "var4=false", "var5=true",
				"var6=false", "var7=false", "var8=false", "var9=true",
				"var10=true");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals("�\����\", result.getUpper());
		// �����l�m�F
		assertEquals("��t�g", result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_42
	 */
	@Test
	public void testPENSER_N_002_42() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_42", "var1=true",
				"var2=false", "var3=true", "var4=false", "var5=true",
				"var6=true");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname42", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo42"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_43
	 */
	@Test
	public void testPENSER_N_002_43() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_43", "var1=true",
				"var2=false", "var3=false", "var4=true", "var5=true",
				"var6=true", "var7=false", "var8=false", "var9=false",
				"var10=true", "var11=false", "var12=false", "var13=true",
				"var14=true", "var15=false", "var16=true");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(2147483647, result.getUpper());
		// �����l�m�F
		assertEquals(-2147483648, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_44
	 */
	@Test
	public void testPENSER_N_002_44() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_44", "var1=false",
				"var2=true", "var3=false", "var4=true", "var5=false",
				"var6=false");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname44", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo44"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_45
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_45() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_45", "var1=true",
				"var2=true", "var3=true", "var4=false", "var5=true");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<Double> result = (List<Double>) res.getResultObject().getValue();
		List<Double> expected = new ArrayList<Double>();
		expected.add(-2.123456789012345e200d);

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_46
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_46() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_46", "var1=true",
				"var2=true", "var3=true", "var4=true", "var5=true",
				"var6=true", "var7=false", "var8=false");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_47
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_47() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_47", "var1=false",
				"var2=false", "var3=false", "var4=true", "var5=false");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("�����S�V");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_48
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_48() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_48", "var1=true",
				"var2=true", "var3=true", "var4=true", "var5=true",
				"var6=true", "var7=true", "var8=true");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_49
	 */
	@Test
	public void testPENSER_N_002_49() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_49", "var1=1�Ԍ�",
				"var2=2�ԓ�", "var3=�R�Ԗ�", "var4=3�Ԗ�", "var5=5�Ԗ�0", "var6=66�Ԗ�",
				"var7=7�Ԗ�7�Ԗ�", "var8=true", "var9=9�Ԗ�", "var10=10�Ԗ�");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname49", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo49"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_50
	 */
	@Test
	public void testPENSER_N_002_50() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_50", "var5=const�T",
				"var6=const6");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(147483647, result.getUpper());
		// �����l�m�F
		assertEquals(-147483648, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(false, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_51
	 */
	@Test
	public void testPENSER_N_002_51() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_51", "var1=1�Ԗ�",
				"var2=2�Ԗ�", "var3=3�Ԗ�", "var4=4�Ԗ�", "var5=5�Ԗ�", "var6=6�Ԗ�",
				"var7=7�Ԗ�", "var8=8�Ԗ�", "var9=9��", "var10=11�Ԗ�");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("classname51", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("subinfo51"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_52
	 */
	@Test
	public void testPENSER_N_002_52() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_52", "var5=const5",
				"var6=const�U");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(9223372036854775807l, result.getUpper());
		// �����l�m�F
		assertEquals(-9223372036854775808l, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_53
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_53() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_53", "var1=��������",
				"var2=������������", "var3=�����Âł�", "var4=-�΂тԂׂ�", "var5=�ς҂Ղ؂�",
				"var6=�Ă���53");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, Double> result = (Map<String, Double>) res
				.getResultObject().getValue();
		Map<String, Double> expected = new HashMap<String, Double>();
		expected.put("key1", 3.8e200d);

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_54
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_54() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_54", "var1=�A�C�E�G�I",
				"var2=�A�C�E�G��", "var3=�J�L�N�P�R", "var4=���L�N�P�R", "var5=�T�V�X�Z�\",
				"var6=�T�V�X�Z�\", "var7=�^�`�c�e�g", "var8=�^�`�c�e�g", "var9=�i�j�k�l�m",
				"var10=�i�j�k�l", "var11=�n�q�t�w�z", "var12=�q�t�w�z", "var13=�}�~������",
				"var14=�}�~����", "var15=����������", "var16=�����", "var17=�K�M�O�Q�S",
				"var18=�K�M�O�Q�S�K�M�O�Q�S", "var19=�U�W�Y�[�]", "var20=�U�W�Y�]");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_55
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_55() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_55", "var1=����������",
				"var2=����������", "var3=�΂тԂׂ�");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		Map<String, String> result = (Map<String, String>) res
				.getResultObject().getValue();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "���Ⴋ�カ��");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_56
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_56() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_56", "var1=�A�C�E�G�I",
				"var2=�A�C�E�G�I", "var3=�J�L�N�P�R", "var4=�J�L�N�P�R", "var5=�T�V�X�Z�\",
				"var6=�T�V�X�Z�\", "var7=�^�`�c�e�g", "var8=�^�`�c�e", "var9=�i�j�k�l�m",
				"var10=�i�j�k�l�m", "var11=�n�q�t�w�z", "var12=�n�q�t�w�z", "var13=�}�~������",
				"var14=�}�~������", "var15=����������", "var16=����������", "var17=�K�M�O�Q�S",
				"var18=�K�M�O�Q�S", "var19=�U�W�Y�[�]", "var20=�U�W�Y�[�]");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_57
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_57() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_57", "var1=121",
				"var2=21111111", "var3=-3000001", "var4=4000000",
				"var5=5000001", "var6=600000",
				"var7=123456789012345678901234567890.1",
				"var8=-123456789012345678901234567890.1",
				"var9=-1234567890123456789012345678901234567890", "var10=500",
				"var11=-2.00000002", "var12=600000.1");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<String> result = (List<String>) res.getResultObject().getValue();
		List<String> expected = new ArrayList<String>();
		expected.add("�����s");

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_58
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_58() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_58",
				"var1=12345678901234567890123456",
				"var2=12345678901234567890123457",
				"var3=-12345678901234567890.25",
				"var4=-12345678901234567890.25");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());

		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_59
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPENSER_N_002_59() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_59", "var1=121",
				"var2=21111111", "var3=-3000001", "var4=4000000",
				"var5=5000001", "var6=600000",
				"var7=123456789012345678901234567890.2",
				"var8=-123456789012345678901234567890.0",
				"var9=-1234567890123456789012345678901234567890.1",
				"var10=500.0000001", "var11=-2.000000021", "var12=600000.0");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		List<Integer> result = (List<Integer>) res.getResultObject().getValue();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50000000);

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_60
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_60() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_60",
				"var1=12345678901234567890123456",
				"var2=12345678901234567890123456",
				"var3=-12345678901234567890.25",
				"var4=-12345678901234567890.24");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());

		// �����l�m�F
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

		// ���ʒl
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_61
	 */
	@Test
	public void testPENSER_N_002_61() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_61",
				"var1=2500000000000000001", "var2=-2500000000000000000",
				"var3=2500000000000000000.2", "var4=-2500000000000000000.221");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals(2.5e200, result.getUpper());
		// �����l�m�F
		assertEquals(-3.8e300, result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(false, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_62
	 */
	@Test
	public void testPENSER_N_002_62() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_62", "var1=300.01",
				"var2=-800000.000000000000000000001",
				"var3=200000000000000000000000000000.25",
				"var4=-200000000000000000000000000000.2501",
				"var5=123456789012345679891");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("�N���X��62", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("�t�я��62"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_63
	 */
	@Test
	public void testPENSER_N_002_63() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_63",
				"var1=2500000000000000000", "var2=-2500000000000000001",
				"var3=2500000000000000000.22", "var4=-2500000000000000000.22");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		RangeObject result = (RangeObject) res.getResultObject()
				.getValue();
		// ����l�m�F
		assertEquals("xyz", result.getUpper());
		// �����l�m�F
		assertEquals("abc", result.getLower());
		// ����l�܂ރt���O�m�F
		assertEquals(true, result.includeUpper());
		// �����l�܂ރt���O�m�F
		assertEquals(true, result.includeLower());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_64
	 */
	@Test
	public void testPENSER_N_002_64() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_64", "var1=300",
				"var2=-800000", "var3=100000000000000000000000000000.25",
				"var4=-200000000000000000000000000000.2500",
				"var5=123456789012345679890");

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		PROObjObject result = (PROObjObject) res.getResultObject().getValue();
		// �N���X��
		assertEquals("�N���X��64", result.getClassName());
		// �t�я��
		assertEquals(Arrays.asList("�t�я��64"), result.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPENSER_N_002_65 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_65() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=�������������������������������@", "var2=�������������������������������@"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_66 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_66() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=�A��������12�R�S�����@"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_67 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_67() throws Exception {
		assertResult(this
				.execute(this.getName().substring(4, 19), "var2=���\�O�l"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_68 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_68() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=��*123@"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_69 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_69() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=12345678", "var2=12345678"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_70 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_70() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=12345678"), "false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_71 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_71() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 19), "var2=-520"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_72 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_72() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=9876543"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_73 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_73() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-9223372036854770000", "var2=-9223372036854770001"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_74 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_74() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=9223372036854770088"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_75 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_75() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=-100000000000002"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_76 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_76() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-1223372036854770000"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_77 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_77() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1.797693134862315e308", "var2=1.797693134862314e308"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_78 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_78() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-1.797693134862315e308"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_79 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_79() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=-4.940656458412464e-324d"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_80 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_80() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1.000693134860007e+17d"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_81 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_81() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1234567890123456789012345.12",
				"var2=1234567890123456789012345.11"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_82 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_82() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-0.6697362752017862813e-330"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_83 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_83() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=7.1740640385300991242e+309"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_84 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_84() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=12.100"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_85 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_85() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19), "var1=true",
				"var2=false"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_86 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_86() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 19), "var1=true"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_87 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_87() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 19), "var2=true"),
				"false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_88 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_88() throws Exception {
		assertResult(this
				.execute(this.getName().substring(4, 19), "var1=false"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_89 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_89() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=��������������������", "var2=��������������������"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_90 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_90() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=+++++++"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_91 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_91() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=��a�A��d1���T"), "true" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_92 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_92() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=abcd efg"), "false" + this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_93 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_93() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=0.5627184893610027859e-330",
				"var2=0.5627184893610027859e-330"), "false"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_94 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_94() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=1234567890001234567890"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_95 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_95() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var2=3.0149051771198015400e+310"), "true"
				+ this.getName().substring(17, 19));
	}

	/**
	 * �e�X�gID�FPENSER_N_002_96 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_96() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 19),
				"var1=-8.761456421457456363E+311"), "false"
				+ this.getName().substring(17, 19));
	}
}
