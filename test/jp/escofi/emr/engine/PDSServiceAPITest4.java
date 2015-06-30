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
	 * �_���v���\�[�X�x�[�X�t�H���_
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSServiceAPI4_Dump";

	public PDSServiceAPITest4() {

		super(PDSServiceAPITest4.class, BASE_FOLDER);
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
	 * �e�X�gID�FPENSER_N_002_273
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_273() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_273", "var1=��", "var2=��",
				"var3=��");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_274
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_274() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_274", "var1=�A�A�A",
				"var2=���");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_275
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_275() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_275", "var1=���",
				"var3=���");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_276
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_276() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_276", "var1=�`�`���");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_277
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_277() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_277", "var2=����������",
				"var3=����������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_278
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_278() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_278", "var2=����������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_279
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_279() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_279", "var3=!'()\"#$%$#\")()())%$#%%%");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_280
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_280() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_280", "var2=��������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_281
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_281() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_281", "var1=-2147483648",
				"var2=2147483647", "var3=2147483646");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_282
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_282() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_282", "var1=-2147483647",
				"var2=-2147483647");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_283
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_283() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_283", "var1=-2147483647",
				"var3=999");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_284
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_284() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_284", "var1=-1");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_285
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_285() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_285", "var2=-2147483648",
				"var3=1");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_286
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_286() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_286", "var2=2147483647");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_287
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_287() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_287", "var3=-9999998");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_288
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_288() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_288", "var2=0");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_289
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_289() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_289",
				"var1=-9223372036854775808", "var2=-9223372036854775807",
				"var3=0");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_290
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_290() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_290", "var1=0", "var2=-1");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_291
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_291() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_291",
				"var1=999999999999999999", "var3=1000000000000000000");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_292
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_292() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_292",
				"var1=1234567896123456789");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_293
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_293() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_293",
				"var2=9223372036123123124", "var3=9223372036123123124");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_294
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_294() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_294",
				"var2=-9223372036854775808");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_295
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_295() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_295",
				"var3=9223372036854321097");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_296
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_296() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_296",
				"var2=9223372036543209999");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_297
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_297() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_297",
				"var1=4.94065645841246e-300d", "var2=4.94065645841246e-324d",
				"var3=0");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_298
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_298() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_298",
				"var1=1.797693134862314e+308d", "var2=1.797693134862313e+308d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_299
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_299() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_299",
				"var1=0.123456789012345e-324d", "var3=1.234567890123456e+308d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_300
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_300() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_300",
				"var1=-4.940656458412465e-324d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_301
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_301() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_301",
				"var2=-1.112223334445557e+308", "var3=-1.112223334445559e+308d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_302
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_302() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_302",
				"var2=1.010202030304040e+308d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_303
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_303() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_303",
				"var3=2.22333444555666e-299d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_304
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_304() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_304",
				"var2=1.23456444556000e+308d");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_305
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_305() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_305",
				"var1=1234567890123456789.9000e-326",
				"var2=1234567890123456789.9020e-326",
				"var3=1234567890123456789.9010e-326");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_306
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_306() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_306",
				"var1=-1234567890123456789.90000",
				"var2=-1234567890123456789.9000");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_307
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_307() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_307",
				"var1=2234567890123456789.900010",
				"var3=2234567890123456989.124400");
		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_308
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_308() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_308",
				"var1=-3234567890123456789.434600");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_309
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_309() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_309",
				"var2=-42345678901234562512.9000",
				"var3=-42345678901234562511.9010");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_310
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_310() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_310",
				"var2=5234567890123479952.121560");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_311
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_311() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_311",
				"var3=62345678902349876543.56471010");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_312
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_312() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_312",
				"var2=-7234567890321654999.9000");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_313
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_313() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_313",
				"var1=AAA���SSS���NNN", "var2=AAA���SSS���NNN",
				"var3=�`�`�`���SSS���NNN");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_314
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_314() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_314", "var1=������������������",
				"var2=����������������������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_315
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_315() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_315", "var1=������",
				"var3=������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_316
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_316() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_316",
				"var1=�������������������������ȂȂȂ͂͂�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_317
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_317() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_317", "var2=��������������������",
				"var3=��������������������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_318
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_318() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_318",
				"var2=���ABHDMKL)($#!");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_319
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_319() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_319", "var3=�������������ƂƂ̂�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_320
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_320() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_320",
				"var2=����������������������������B");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_321
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_321() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_321", "var1=-2147483648",
				"var2=-2147483210", "var3=-2147483210");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_322
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_322() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_322", "var1=2147432100",
				"var2=2147483646");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_323
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_323() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_323", "var1=-2147483648",
				"var3=2147483646");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_324
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_324() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_324", "var1=-2147481234");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_325
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_325() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_325", "var2=2147412346",
				"var3=2147483210");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_326
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_326() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_326", "var2=-2147483648");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_327
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_327() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_327", "var3=-1234483210");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_328
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_328() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_328", "var2=2147443322");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_329
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_329() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_329",
				"var1=3214567890123456789.88000e-326",
				"var2=3214567890123456888.12010e-326",
				"var3=3214567890123456999.12010e-326");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_330
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_330() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_330",
				"var1=-4324567451245589.14789600",
				"var2=4324567890369874700.9874560");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_331
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_331() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_331",
				"var1=-5434567890987654321.6500",
				"var3=-5434567890765432100.2020");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_332
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_332() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_332",
				"var1=6544567890123456621.8080");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_333
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_333() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_333",
				"var2=-7654567890123456903.12012090",
				"var3=7654567890123456111.20101201");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_334
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_334() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_334",
				"var2=-8764567890123452224.100");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_335
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_335() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_335",
				"var3=9874567890123454789.5600");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_336
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_336() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_336",
				"var2=-1094567890123456789.0126020");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_337
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_337() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_337",
				"var1=��������������������������������������Ă�", "var2=��������������������������������������Ă�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_338
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_338() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_338",
				"var1=��͂��ӂ����Ȃ΃����߂�����������������", "var2=��͂��ӂ����ȃ�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_339
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_339() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_339",
				"var1=�͂ς����������˂�͂₪�����߂��`�a�b�c", "var2=�͂ς����������˂�͂₪�����߂��`");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_340
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_340() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_340",
				"var1=�������킴�܂͂������ӂ��炽������������", "var2=�܂͂������ӂ��炽��");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_341
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_341() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_341",
				"var1=�������������������т��Ђς��Ⴏ�˂ւׂ�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_342
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_342() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_342",
				"var1=���ӵ���Ԃ������ՂނʂԂ������������Ղނʂ�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_343
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_343() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_343",
				"var1=UYINDMKXDXDFCFG�P�Q�R�S�T�U�V�W�X�O��");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_344
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_344() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_344",
				"var1=�˂�������������()'(%$#$#�����˂�");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_345
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_345() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_345",
				"var2=(�`�c�f�j�t�s�d�v%#����������Â��A�E�E�X�G�I�J)");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_346
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_346() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_346", "var2=���ǂ�������XYZ");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_347
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_347() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_347",
				"var2=�����������Ⴉ�������ς܂����Ȃ�����������������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_348
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_348() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_348", "var2=�肦�����������ӂ��肿");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_349
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_349() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_349",
				"var1=�P�Q�R�S�T%'()#$!�`�n�o�d�cXYZ");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_350
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_350() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_350",
				"var1=�߂����������������˂ւ��������ׂ��Ă���");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_351
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_351() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_351",
				"var1=�g�f�e�c�e�r�x�g�g�c�i�h�d�j�i�l�m�c�f�c�t�f�r�q�r�x");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value1";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 * �e�X�gID�FPENSER_N_002_352
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPENSER_N_002_352() throws Exception {

		// �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
		PDSResponse res = this.execute("PENSER_N_002_352",
				"var1=�������������˂��ւ���������������������");

		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		String expected = "value2";

		// ���ʒl
		assertEquals(expected, result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/***
	 *String a = "��"; String b = "�"; int tempInt = a.compareTo(b);
	 */

}
