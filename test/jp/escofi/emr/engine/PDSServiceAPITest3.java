package jp.escofi.emr.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.junit.Test;

public class PDSServiceAPITest3 extends DJUnitTestCaseEx {

	private static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	/**
	 * �_���v���\�[�X�x�[�X�t�H���_
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSServiceAPI3_Dump";

	public PDSServiceAPITest3() {

		super(PDSServiceAPITest3.class, BASE_FOLDER);
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
	 * �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
	 *
	 * @param dataModelName
	 *            �f�[�^���f����(�e�X�g�P�[�XID)
	 * @param vars
	 *            �������ږ�=�������ڒl
	 * @return PDS�����N���X
	 * @throws Exception
	 */
	private PDSResponse execute2(String dataModelName,
			Map<String, Object> objMap) throws Exception {

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

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		Object var = null;
		for (ConditionItemInfo conditionItemInfo : collection) {

			// �������ڃN���X��������擾����B
			itemName = conditionItemInfo.getItemName();
			itemType = conditionItemInfo.getItemType();
			javaDataType = conditionItemInfo.getJavaDataType();
			searchInfo = conditionItemInfo.getSearchInfo();

			if (objMap != null && objMap.containsKey(itemName)) {
				var = objMap.get(itemName);
			}

			if ("".equals(var)) {
				var = "default";
			}

			// �������ڎ擾���Ɋ�Â��A�������ڂ��擾��A
			// �������ڃf�[�^�^�A�������ړ����f�[�^�^�ɍ��킹�Č^�ϊ����A�������ڒl�ɑ������B
			if (!"set".equals(itemType) && (var != null)) {
				var = PUTConvertUtil.convert(var.toString(), javaDataType);
			}

			// �������ڒl�}�b�v�ɐݒ�
			conditionItemValueMap.put(itemName, var);
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
	private void assertResult(PDSResponse res, boolean flag) {
		// ----------------------<<���ʊm�F�A�C���|�C���gSTART>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// �����l�m�F
		String result = (String) res.getResultObject().getValue();
		// ���ʒl
		if (flag) {
			assertEquals("true", result);
		} else {
			assertEquals("false", result);
		}
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//
	}

	/**
	 * �e�X�gID�FPENSER_N_002_161 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_161() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=��������������������", "var2=��������������������"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_162 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_162() throws Exception {
		assertResult(this
				.execute(this.getName().substring(4, 20), "var1=���{�P���{"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_163 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_163() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1234567890123456789.90", "var2=1234567890123456789.9"),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_164 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_164() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=98765432109876543209.90000001"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_165 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_165() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�B!�B�B#�B$�B%�B'�B(�B)�B�B"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_166 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_166() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�e�X�g�R�[�h���{��P�Q�R�S�T�Eýĺ���12345"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_167 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_167() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-999888777666555444333222111.907002"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_168 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_168() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=9.99887766554433221100"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_169 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_169() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=��������������������", "var2=��������������������"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_170 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_170() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�e�X�g�葃�ˁE1ýāE�葃�˃e�X�g"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_171 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_171() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483648", "var2=-2147483648"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_172 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_172() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2147483646"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_173 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_173() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�����u1�v�@�@4�@�@�ʒu�u2�v"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_174 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_174() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=���������ア���ς���������������������������"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_175 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_175() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483647"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_176 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_176() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2147483647"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_177 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_177() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-9000000000000000008", "var2=-9000000000000000009"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_178 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_178() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=9223372036854775807"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_179 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_179() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20), "var1=0",
				"var2=1"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_180 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_180() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2147483647"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_181 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_181() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=12345678901234567"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_182 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_182() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-9223372036854775808"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_183 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_183() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483648"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_184 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_184() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2147483647"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_185 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_185() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=98745632100123456.90807048725610",
				"var2=98745632100123456.9080704872561000001"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_186 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_186() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-999888777666555444333222111000.102030405060708090"),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_187 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_187() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2.7976931348624", "var2=2.7976931348623"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_188 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_188() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1.3076936231570e+156d"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_189 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_189() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=9787675747372717000.9090000090000"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_190 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_190() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=99999999999999999999999999999999.9900"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_191 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_191() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=0.797693134862315"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_192 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_192() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=123456789012345.94065645"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_193 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_193() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20), "var1=��������",
				"var2=��������"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_194 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_194() throws Exception {
		assertResult(
				this.execute(this.getName().substring(4, 20), "var1=���{���{"),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_195 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_195() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=12345678901234567890000000.90",
				"var2=12345678901234567890000000.9"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_196 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_196() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=98765432109876543209.9876543210000001"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_197 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_197() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�B!�B�B#�B$�B%�B'�B(�B)�B�B�B�B�BE"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_198 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_198() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=123�e�X�g�R�[�h���{��P�Q�R�S�T�Eýĺ���12345"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_199 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_199() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-999888777666555444333222.907002"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_200 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_200() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=8.99887766554433221100"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_201 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_201() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�J�^�J�i��������������������", "var2=�J�^�J�i��������������������"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_202 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_202() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�e�X�g�葃�ˁEÂ�āE�葃�˃e�X�g"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_203 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_203() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483640", "var2=-2147483640"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_204 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_204() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20), "var1=0"),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_205 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_205() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=�����u1�v�@�@�@�@�ʒu�u2�vA"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_206 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_206() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=���������ア���ς�������������������"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_207 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_207() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483645"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_208 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_208() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1047483647"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_209 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_209() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1023300000000000001", "var2=1023300000000000000"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_210 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_210() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=9223372036854775806"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_211 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_211() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20), "var1=9",
				"var2=10"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_212 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_212() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1147483647"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_213 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_213() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=123456789012345"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_214 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_214() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-9223372036854775801"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_215 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_215() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483647"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_216 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_216() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-2147483646"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_217 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_217() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=98745632100123456.90807048725610",
				"var2=98745632100123456.9080704872561000002"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_218 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_218() throws Exception {
		assertResult(
				this
						.execute(this.getName().substring(4, 20),
								"var1=-999888777666555444333222111000.10203040506070809000000"),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_219 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_219() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2.7976931348621", "var2=2.7976931348620"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_220 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_220() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1.3076936231570e+56d"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_221 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_221() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=9787675747372717000.90900000700"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_222 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_222() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=99999999999999999999999999999999.9900"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_223 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_223() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1.797E+200"), true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_224 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_224() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1542423.792E+271"), false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_225 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_225() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet = new HashSet<String>();
		varSet.add("����");

		varMap.put("var1", "����");
		varMap.put("var2", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_226 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_226() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "������");

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_227 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_227() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet = new HashSet<String>();
		varSet.add("��");
		varSet.add("��");
		varSet.add("�O");
		varSet.add("�l");
		varSet.add("��");
		varSet.add("�Z");
		varSet.add("��");
		varSet.add("��");
		varSet.add("��");
		varSet.add("�\");

		varMap.put("var1", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_228 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_228() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "����������");

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_229 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_229() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet = new HashSet<Integer>();
		varSet.add(2147483647);
		varSet.add(1);
		varSet.add(0);
		varSet.add(-2);
		varSet.add(-2147483648);

		varMap.put("var1", Integer.parseInt("-1"));
		varMap.put("var2", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_230 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_230() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", Integer.parseInt("5"));

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_231 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_231() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet = new HashSet<Integer>();
		varSet.add(-2);
		varMap.put("var1", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_232 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_232() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", Integer.parseInt("-2"));

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_233 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_233() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Long> varSet = new HashSet<Long>();
		varSet.add(new Long("-9223372036854775808"));
		varSet.add(new Long("-9223372036854775807"));
		varSet.add(new Long("-2147483649"));
		varSet.add(new Long("-1"));
		varSet.add(new Long("0"));
		varSet.add(new Long("1"));
		varSet.add(new Long("2147483648"));
		varSet.add(new Long("9999999999999999"));
		varSet.add(new Long("9223372036854775806"));
		varSet.add(new Long("9223372036854775807"));

		varMap.put("var1", new Long("9223372036854775807"));
		varMap.put("var2", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_234 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_234() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		varMap.put("var1", new Double("4.940656458412465"));

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_235 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_235() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Long> varSet = new HashSet<Long>();
		varSet.add(new Long("9223372036854775807"));

		varMap.put("var1", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_236 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_236() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		varMap.put("var1", new Double("1.0E-17"));

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_237 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_237() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet = new HashSet<BigDecimal>();
		varSet.add(new BigDecimal(
				"7234542387463.995423523499333333333330000222345849628532"));

		varMap.put("var1", new BigDecimal(
				"7234542387463.995423523499333333333330000222345849628531"));
		varMap.put("var2", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_238 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_238() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		varMap
				.put(
						"var1",
						new BigDecimal(
								"2.999999999999998888888888888877777777777777666666666666555555555555544444444441"));

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_239 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_239() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet = new HashSet<BigDecimal>();
		varSet.add(new BigDecimal("1231231231239988776655.9901088000044"));
		varSet.add(new BigDecimal("123123123123654264235423.99010880000500"));
		varSet.add(new BigDecimal("1231231231236524543254413.990108800003"));
		varSet.add(new BigDecimal("123123123123654278777774.9901087000000000"));
		varSet.add(new BigDecimal(
				"1231231231235423541235423.99010880000400000006500000000"));
		varMap.put("var1", varSet);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_240 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_240() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		varMap
				.put(
						"var1",
						new BigDecimal(
								"1234567890123456789012345678901234567890.12340000567800009012345"));

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_241 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_241() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		Set<String> varSet2 = new HashSet<String>();
		varSet1.add("�u�[��'0'����%�Ђ炪��1$(2�`).3&�M�v�B#����!");
		varSet2.add("�u�[��'0'����%�Ђ炪��1$(2�`).3&�M�v�B#����!");

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_242 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_242() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(-1);

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_243 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_243() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Long> varSet1 = new HashSet<Long>();
		varSet1.add(new Long("9223372036854775807"));
		varSet1.add(new Long("9223372036854775804"));
		varSet1.add(new Long("9223372036854775803"));
		varSet1.add(new Long("2147483647"));
		varSet1.add(new Long("-1"));
		varSet1.add(new Long("0"));
		varSet1.add(new Long("-2147483648"));
		varSet1.add(new Long("-9223372036854775804"));
		varSet1.add(new Long("-9223372036854775805"));
		varSet1.add(new Long("-9223372036854775808"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_244 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_244() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();
		varSet1
				.add(new BigDecimal(
						"573489573492573934956973489142.75893465934568349156396234956349534953492534729543544232"));
		varSet1
				.add(new BigDecimal(
						"13489256234789563478953462891.256347892562347895634895634925432"));
		varSet1.add(new BigDecimal("-1.0E+593"));
		varSet1
				.add(new BigDecimal(
						"99999999999999999999999999999999999.65465246524000654652454525432346302"));
		varSet1
				.add(new BigDecimal(
						"1234567890123456789012345678901234567890.1234567890123456789012345678901234567891"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_245 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_245() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		varSet1.add("��N");
		varSet1.add("���N");
		varSet1.add("�ė��N");
		varSet1.add("���N");
		varSet1.add("���N");

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_246 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_246() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(0);

		Set<Integer> varSet2 = new HashSet<Integer>();
		varSet2.add(1);
		varSet2.add(2);
		varSet2.add(3);
		varSet2.add(4);
		varSet2.add(5);
		varSet2.add(6);
		varSet2.add(7);
		varSet2.add(8);
		varSet2.add(9);
		varSet2.add(10);

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_247 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_247() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Double> varSet1 = new HashSet<Double>();
		varSet1.add(new Double("4.94065645841246544e-324d"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_248 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_248() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();
		varSet1
				.add(new BigDecimal(
						"1234567890123456789012345678901234567890.1234567890123456789012345678901234567890"));
		varSet1
				.add(new BigDecimal(
						"99999999999999999999999999999999999.0000000000000000000000000000000000000001"));
		varSet1.add(new BigDecimal("3.34E+535"));
		varSet1.add(new BigDecimal("-9.652245423543542E+503"));
		varSet1
				.add(new BigDecimal(
						"0.000000000000000000000000000000000000000000000000000000000000000000001"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_249 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_249() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(1);
		varSet1.add(3);
		varSet1.add(5);
		varSet1.add(7);
		varSet1.add(9);

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_250 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_250() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		varSet1.add("��");
		varSet1.add("��");
		varSet1.add("��");
		varSet1.add("��");
		varSet1.add("��");

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_251 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_251() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();
		Set<BigDecimal> varSet2 = new HashSet<BigDecimal>();
		varSet1.add(new BigDecimal("4.056746E+505"));
		varSet1.add(new BigDecimal("4.056746E+506"));
		varSet1.add(new BigDecimal("4.056746E+507"));
		varSet1.add(new BigDecimal("4.056746E+508"));
		varSet1.add(new BigDecimal("4.056746E+509"));

		varSet2.add(new BigDecimal("5.056746E+501"));
		varSet2.add(new BigDecimal("5.056746E+502"));
		varSet2.add(new BigDecimal("5.056746E+503"));
		varSet2.add(new BigDecimal("5.056746E+504"));
		varSet2.add(new BigDecimal("5.056746E+505"));
		varSet2.add(new BigDecimal("5.056746E+506"));
		varSet2.add(new BigDecimal("5.056746E+507"));
		varSet2.add(new BigDecimal("5.056746E+508"));
		varSet2.add(new BigDecimal("5.056746E+509"));
		varSet2.add(new BigDecimal("5.056746E+510"));

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_252 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_252() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Long> varSet1 = new HashSet<Long>();
		varSet1.add(new Long("9223372036854775807"));
		varSet1.add(new Long("9223372036854775804"));
		varSet1.add(new Long("9223372036854775803"));
		varSet1.add(new Long("2147483647"));
		varSet1.add(new Long("-1"));
		varSet1.add(new Long("0"));
		varSet1.add(new Long("-2147483648"));
		varSet1.add(new Long("-9223372036854775804"));
		varSet1.add(new Long("-9223372036854775805"));
		varSet1.add(new Long("-9223372036854775808"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_253 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_253() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(-9);
		varSet1.add(-7);
		varSet1.add(-5);
		varSet1.add(-3);
		varSet1.add(-1);
		varSet1.add(1);
		varSet1.add(3);
		varSet1.add(5);
		varSet1.add(7);
		varSet1.add(9);

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_254 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_254() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		varSet1.add("��");
		varSet1.add("���");
		varSet1.add("�O�O�O");
		varSet1.add("�l�l�l�l");
		varSet1.add("�܌܌܌܌�");
		varSet1.add("�Z�Z�Z�Z�Z�Z");
		varSet1.add("��������������");
		varSet1.add("����������������");
		varSet1.add("����������");
		varSet1.add("�\�\�\�\�\�\�\�\�\�\");

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_255 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_255() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();
		varSet1
				.add(new BigDecimal(
						"5734895932652346523465256234905623478.52548968898978573492105712349054235423"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_256 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_256() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Double> varSet1 = new HashSet<Double>();
		Set<Double> varSet2 = new HashSet<Double>();
		varSet1.add(new Double("999999999999999.999999999911111"));
		varSet1.add(new Double("999999999999999.99999999992001"));
		varSet1.add(new Double("999999999999.99999999999"));
		varSet1.add(new Double("2.1E+123"));
		varSet1.add(new Double("34.63E+230"));

		varSet2.add(new Double("999999999999999.999999999911111"));
		varSet2.add(new Double("999999999999999.99999999992001"));
		varSet2.add(new Double("999999999999.99999999999"));
		varSet2.add(new Double("2.1E+123"));
		varSet2.add(new Double("34.63E+230"));

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_257 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_257() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();
		Set<BigDecimal> varSet2 = new HashSet<BigDecimal>();

		varSet1.add(new BigDecimal("1.111E+733"));
		varSet1.add(new BigDecimal("7.5426E+417"));
		varSet1
				.add(new BigDecimal(
						"5734892573489125348120512345.964325623496542643263426234999995423997"));
		varSet1.add(new BigDecimal(
				"-54242563452345555435342352346.999999999999999999999999998"));
		varSet1.add(new BigDecimal("5.0E+999"));

		varSet2.add(new BigDecimal("1.111E+733"));
		varSet2.add(new BigDecimal("7.5426E+417"));
		varSet2
				.add(new BigDecimal(
						"5734892573489125348120512345.964325623496542643263426234999995423997"));
		varSet2.add(new BigDecimal(
				"-54242563452345555435342352346.999999999999999999999999998"));
		varSet2.add(new BigDecimal("-40.5E+400"));
		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_258 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_258() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Long> varSet1 = new HashSet<Long>();
		varSet1.add(new Long("9223372036854775807"));
		varSet1.add(new Long("9223372036854775804"));
		varSet1.add(new Long("9223372036854775803"));
		varSet1.add(new Long("2147483647"));
		varSet1.add(new Long("-1"));
		varSet1.add(new Long("0"));
		varSet1.add(new Long("-2147483650"));
		varSet1.add(new Long("-9223372036854775804"));
		varSet1.add(new Long("-9223372036854775805"));
		varSet1.add(new Long("-9223372036854775808"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_259 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_259() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(-10);
		varSet1.add(-8);
		varSet1.add(-6);
		varSet1.add(-4);
		varSet1.add(-2);
		varSet1.add(0);
		varSet1.add(2);
		varSet1.add(4);
		varSet1.add(6);
		varSet1.add(8);

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_260 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_260() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		varSet1.add("�܌܌�");

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_261 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_261() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();

		varSet1.add(new BigDecimal("1.11E+533"));
		varSet1.add(new BigDecimal("7.5426E+517"));
		varSet1.add(new BigDecimal("2.65245234E+520"));
		varSet1.add(new BigDecimal("-1.0E+535"));
		varSet1.add(new BigDecimal("-9.652245423543542E+553"));
		varSet1.add(new BigDecimal("-1.1E+530"));
		varSet1.add(new BigDecimal("2.05224543543542E+543"));
		varSet1.add(new BigDecimal("1.052E+563"));
		varSet1.add(new BigDecimal("1.0E+308"));
		varSet1.add(new BigDecimal("5.4E+170"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_262 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_262() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Double> varSet1 = new HashSet<Double>();
		Set<Double> varSet2 = new HashSet<Double>();
		varSet1.add(new Double("1.011E+11"));
		varSet1.add(new Double("2.022E+22"));
		varSet1.add(new Double("3.033E+33"));
		varSet1.add(new Double("4.044E+44"));
		varSet1.add(new Double("5.055E+55"));

		varSet2.add(new Double("1.011E+11"));
		varSet2.add(new Double("2.022E+22"));
		varSet2.add(new Double("3.033E+33"));
		varSet2.add(new Double("4.044E+44"));
		varSet2.add(new Double("5.055E+55"));
		varSet2.add(new Double("6.066E+66"));
		varSet2.add(new Double("7.077E+77"));
		varSet2.add(new Double("8.088E+88"));
		varSet2.add(new Double("9.099E+99"));
		varSet2.add(new Double("0"));

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_263 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_263() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(1);
		varSet1.add(2);
		varSet1.add(3);
		varSet1.add(4);
		varSet1.add(5);

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_264 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_264() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		varSet1.add("����");

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_265 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_265() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Long> varSet1 = new HashSet<Long>();
		varSet1.add(new Long("9999999999999"));
		varSet1.add(new Long("8888888888888"));
		varSet1.add(new Long("7777777777777"));
		varSet1.add(new Long("6666666666666"));
		varSet1.add(new Long("5555555555555"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_266 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_266() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();

		varSet1.add(new BigDecimal("1.234568E+629"));
		varSet1.add(new BigDecimal("7.5426E+617"));
		varSet1.add(new BigDecimal("2.65245234E+620"));
		varSet1.add(new BigDecimal("-1.0E+635"));
		varSet1.add(new BigDecimal("-9.6542E+653"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_267 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_267() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		Set<String> varSet2 = new HashSet<String>();

		varSet1.add("����������");
		varSet1.add("����I");
		varSet1.add("�����Ă�");
		varSet1.add("������");
		varSet1.add("�Ȃɂʂ˂�");

		varSet2.add("����������");
		varSet2.add("�J�L�N�P�R");
		varSet2.add("����������");
		varSet2.add("�����Ă�");
		varSet2.add("�܂݂ނ߂�");
		varSet2.add("�n�q�t�w�z");
		varSet2.add("�Ȃɂʂ˂�");
		varSet2.add("������");
		varSet2.add("����I");
		varSet2.add("����B");

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);
		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_268 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_268() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(1);
		varSet1.add(2);
		varSet1.add(3);
		varSet1.add(4);
		varSet1.add(5);

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_269 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_269() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Double> varSet1 = new HashSet<Double>();
		varSet1.add(new Double("99.99E+99"));
		varSet1.add(new Double("999999999999999.99999999999992"));
		varSet1.add(new Double("99999999999999.9999999999993"));
		varSet1.add(new Double("9999999999999.999999999994"));
		varSet1.add(new Double("999999999999.99999999995"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				true);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_270 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_270() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();

		varSet1.add(new BigDecimal("2.345E+433"));
		varSet1.add(new BigDecimal("3.26E+717"));
		varSet1.add(new BigDecimal("1.4E+420"));
		varSet1.add(new BigDecimal("1.0E-235"));
		varSet1.add(new BigDecimal("9.652E-153"));
		varSet1.add(new BigDecimal("-4.2E+630"));
		varSet1.add(new BigDecimal("43212.043542E+393"));
		varSet1.add(new BigDecimal("5423333121.052E+763"));
		varSet1.add(new BigDecimal("1.0552E+348"));
		varSet1.add(new BigDecimal("5.4E+170"));

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_271 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_271() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<String> varSet1 = new HashSet<String>();
		varSet1.add("��");
		varSet1.add("��");
		varSet1.add("��");
		varSet1.add("��");
		varSet1.add("��");

		varMap.put("var1", varSet1);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}

	/**
	 * �e�X�gID�FPENSER_N_002_272 �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{�����ʊm�F
	 */
	@Test
	public void testPENSER_N_002_272() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<Integer> varSet1 = new HashSet<Integer>();
		Set<Integer> varSet2 = new HashSet<Integer>();
		varSet1.add(3);
		varSet1.add(2);
		varSet1.add(1);
		varSet1.add(-123456);
		varSet1.add(-99999999);
		varSet1.add(2147483647);
		varSet1.add(-2147483648);
		varSet1.add(99999999);
		varSet1.add(0);
		varSet1.add(111);

		varSet2.add(2147483647);

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				false);
	}
}