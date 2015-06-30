/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.exception.PEXUnExpectedStateException;
import jp.iwin.pds.xml2db.datamodel.PROObjObject;
import jp.iwin.pds.xml2db.initialload.PILInitialLoader;

import org.junit.Test;

/**
 * �C�j�V�������[�_�[�e�X�g�N���X
 *
 * @author seo.yi
 */
public class InitialLoader4Test extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader4";

	/**
	 *
	 */
	public InitialLoader4Test() {

		super(InitialLoader4Test.class, BASE_FOLDER);
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param objMap1
	 *            �������ڃ}�b�v
	 * @return ��O
	 * @throws Exception
	 *             ��O
	 */
	private Exception invokeCheckEngineException(String testCase,
			Map<String, Object> objMap1) throws Exception {

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_" + testCase.substring(13) + "_1");

		Exception e = this
				.invokeCheckEngineException(testCase, param1, objMap1);
		assertNotNull("����I���̂���NG", e);
		return e;
	}

	/**
	 * �e�X�gID�FPILINI_N_001_5 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 * @throws Exception ��O
	 */
	@Test
	public void testPILINI_N_001_5() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param
				.add("PILINI_N_001_5_6789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		param.add("key1_678901234567890");
		param.add("key2_678901234567890");
		param
				.add("PILINI_N_001_5_1_89012345678901234567890123456789012345678901234567890123456789012345678901234567890");

		PDSEngine.getInstance();
		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();

		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals(null, response.getConditionItemInfoMap());
		assertEquals(null, response.getConditionItemValueMap());
		assertEquals(false, response.isCondition());
		assertEquals("12345678901234567890", response.getMetaInfo());
		assertEquals(
				"12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
				result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_6 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 * @throws Exception ��O
	 */
	@Test
	public void testPILINI_N_001_6() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param
				.add("PILINI_N_001_6_6789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		param.add("key1_678901234567890");
		param.add("key2_678901234567890");
		param
				.add("PILINI_N_001_6_6789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap
				.put(
						"var4567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
						"12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_7 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_7() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add("PILINI_N_001_7");
		param1.add("key1");
		param1.add("key2");
		param1.add("PILINI_N_001_7_1");

		PDSEngine.getInstance();
		PDSResponse response1 = PDSServiceAPI.getConditionItems(param1);
		ResultObject result1 = response1.getResultObject();

		assertEquals(PCTStatus.NORMAL, response1.getStatus());
		assertEquals(null, response1.getConditionItemInfoMap());
		assertEquals(null, response1.getConditionItemValueMap());
		assertEquals(false, response1.isCondition());
		assertEquals("", response1.getMetaInfo());
		assertEquals("", result1.getValue());

		// �����ݒ�
		List<String> param2 = new ArrayList<String>();
		param2.add("PILINI_N_001_7");
		param2.add("key1");
		param2.add("key2");
		param2.add("PILINI_N_001_7_2");

		PDSEngine.getInstance();
		PDSResponse response2 = PDSServiceAPI.getConditionItems(param2);
		ResultObject result2 = response2.getResultObject();
		List<String> list = (List<String>) result2.getValue();

		assertEquals(PCTStatus.NORMAL, response2.getStatus());
		assertEquals(null, response2.getConditionItemInfoMap());
		assertEquals(null, response2.getConditionItemValueMap());
		assertEquals(false, response2.isCondition());
		assertEquals("", response2.getMetaInfo());
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("");
		assertEquals(expectedList, list);

		// �����ݒ�
		List<String> param3 = new ArrayList<String>();
		param3.add("PILINI_N_001_7");
		param3.add("key1");
		param3.add("key2");
		param3.add("PILINI_N_001_7_3");

		PDSEngine.getInstance();
		PDSResponse response3 = PDSServiceAPI.getConditionItems(param3);
		ResultObject result3 = response3.getResultObject();
		Map<String, String> map = (Map<String, String>) result3.getValue();

		assertEquals(PCTStatus.NORMAL, response3.getStatus());
		assertEquals(null, response3.getConditionItemInfoMap());
		assertEquals(null, response3.getConditionItemValueMap());
		assertEquals(false, response3.isCondition());
		assertEquals("", response3.getMetaInfo());
		Map<String, String> expectedMap = new HashMap<String, String>();
		expectedMap.put("key_1", "");
		assertEquals(expectedMap, map);

		// �����ݒ�
		List<String> param4 = new ArrayList<String>();
		param4.add("PILINI_N_001_7");
		param4.add("key1");
		param4.add("key2");
		param4.add("PILINI_N_001_7_4");

		PDSEngine.getInstance();
		PDSResponse response4 = PDSServiceAPI.getConditionItems(param4);
		ResultObject result4 = response4.getResultObject();
		RangeObject range = (RangeObject) result4.getValue();

		assertEquals(PCTStatus.NORMAL, response4.getStatus());
		assertEquals(null, response4.getConditionItemInfoMap());
		assertEquals(null, response4.getConditionItemValueMap());
		assertEquals(false, response4.isCondition());
		assertEquals("", response4.getMetaInfo());
		assertEquals(null, range.getUpper());
		assertEquals(null, range.getLower());
		assertEquals(true, range.includeUpper());
		assertEquals(true, range.includeLower());

		// �����ݒ�
		List<String> param5 = new ArrayList<String>();
		param5.add("PILINI_N_001_7");
		param5.add("key1");
		param5.add("key2");
		param5.add("PILINI_N_001_7_5");

		PDSEngine.getInstance();
		PDSResponse response5 = PDSServiceAPI.getConditionItems(param5);
		ResultObject result5 = response5.getResultObject();
		PROObjObject obj = (PROObjObject) result5.getValue();

		assertEquals(PCTStatus.NORMAL, response5.getStatus());
		assertEquals(null, response5.getConditionItemInfoMap());
		assertEquals(null, response5.getConditionItemValueMap());
		assertEquals(false, response5.isCondition());
		assertEquals("", obj.getClassName());
		assertEquals(new ArrayList<String>(), obj.getAttachedInfo());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_8 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_8() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add("PILINI_N_001_8");
		param.add("key1");
		param.add("PILINI_N_001_8");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_198 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_198() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "����\"��");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_199 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_199() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "��'����");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_208 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_208() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attr_208_1");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "������");

		PDSEngine.getInstance();
		PDSResponse response = super.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_209 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_209() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_209_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "������");

		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());

		// �����ݒ�
		List<String> param2 = new ArrayList<String>();
		param2.add(testCase);
		param2.add("key1");
		param2.add("attr_209_2");

		Map<String, Object> objMap2 = new HashMap<String, Object>();
		objMap2.put("var", 12345678);

		PDSResponse response2 = this.getResult(param2, objMap2);
		ResultObject result2 = response2.getResultObject();
		assertEquals(true, result2.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_410 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_410() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr_410_1");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", 1.08E3f);
		ResultObject resultObj = this.invokeCheckEngineNormalResult(testCase, param, objMap);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_190 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_190() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_191 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_191() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("ke>y1");
		param.add("PILINI_E_001_191");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "������");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_192 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_192() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_193 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_193() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_194 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_194() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("PILI'NI_E_001_194");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "������");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_195 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_195() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_196 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_196() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "������");

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		List<String> list = (List<String>) result.getValue();

		List<String> expected = new ArrayList<String>();
		expected.add("����>��1");
		assertEquals(expected, list);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_197 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_197() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_200 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_200() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_201 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_201() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:list�Adatatype:single)", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_202 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_202() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_203 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_203() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_204 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_204() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_205 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_205() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_206 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_206() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "������");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals("���{��", result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_207 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 * @throws Exception ��O
	 */
	@Test
	public void testPILINI_E_001_207() throws Exception {

		String testCase = this.getName().substring(4);
//		String metaXmlName = testCase;
//		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("����_207");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", "������");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals("���{��", result.getValue());
//		PDSEngine.getInstance();
//		PDSResponse response = PDSServiceAPI.getConditionItems(param);
//		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_210 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_210() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_210_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "������");

		Exception e = super.invokeCheckEngineException(testCase, param1,
				objMap1);
		assertEquals(PEXUnExpectedStateException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_211 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_211() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:map�Adatatype:list)", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_212 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_212() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:range�Adatatype:map)", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_213 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_213() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:object�Adatatype:range)", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_214 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_214() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:list�Adatatype:object)", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_215 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_215() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_215_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "������");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		RangeObject rangeObj = (RangeObject) result1.getValue();
		assertEquals(true, rangeObj.getUpper());
		assertEquals(false, rangeObj.getLower());
		assertEquals(false, rangeObj.includeUpper());
		assertEquals(true, rangeObj.includeLower());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_216 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_216() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_217 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_217() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:eq�Adatatypes:[single, set])", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_218 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_218() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_219 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_219() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_220 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_220() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_221 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_221() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_222 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_222() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_222_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_223 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_223() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_223_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Double.class, 1.79769313486231E308d));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_224 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_224() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_225 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_225() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_225_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_226 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_226() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"�^�O�ɕs���������݂��܂��B(conditionType:CONDITION_GEQ�AjavaDataType:java.lang.Boolean�Aset:false)",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_227 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_227() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:geq�Adatatypes:[set, single])",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_228 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_228() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:geq�Adatatypes:[single, set])",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_229 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_229() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"�^�O�ɕs���������݂��܂��B(conditionType:CONDITION_LT�AjavaDataType:java.lang.Boolean�Aset:false)",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_230 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_230() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_230_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "false");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_231 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_231() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:lt�Adatatypes:[set, single])", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_232 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_232() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:lt�Adatatypes:[single, set])", e
				.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_233 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_233() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_233_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_234 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_234() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"�^�O�ɕs���������݂��܂��B(conditionType:CONDITION_LEQ�AjavaDataType:java.lang.Boolean�Aset:false)",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_235 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_235() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals("�^�O�ɕs���������݂��܂��B(elementType:leq�Adatatypes:[set, single])",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_236 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_236() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_237 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_237() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_237_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_238 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_238() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_238_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_239 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_239() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_239_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Double.class, 1.79769313486231E308d));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_240 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_240() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_240_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", new BigDecimal("1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_241 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_241() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_241_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_242 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_242() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_242_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_243 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_243() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_243_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Integer.class, Integer.MAX_VALUE));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_244 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_244() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_244_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Long.MAX_VALUE);

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_245 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_245() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_245_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Boolean.class, true, false));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_N_001_246 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_246() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_246_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(String.class, "true", "false", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(false, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_249 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_249() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_249_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(String.class, "true", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(false, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_254 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_254() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_254_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(String.class, "false", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_257 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_257() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_257_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(String.class, "true", "abc"));

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(false, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_247 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_247() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_247_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", 1.79769313486231E308d);

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_248 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_248() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_248_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(BigDecimal.class,
				"1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_250 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_250() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_250_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Boolean.class, true));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_251 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_251() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_251_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Integer.class, Integer.MAX_VALUE));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_252 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_252() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_252_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Long.MAX_VALUE);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_253 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_253() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_253_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Boolean.class, true, false));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_255 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_255() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_255_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", 1.79769313486231E308d);

		Exception e = super.invokeCheckEngineException(testCase, param1,
				objMap1);
		System.out.println(e);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_256 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_256() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_256_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(BigDecimal.class,
				"1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_258 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_258() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_258_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Boolean.class, true));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_259 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_259() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_259_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Integer.class, Integer.MAX_VALUE));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_260 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_260() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_260_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Long.MAX_VALUE);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_261 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_261() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_261_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_262 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_262() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_262_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "true");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_263 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_263() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_263_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(Double.class, -1.79769313486231E308d));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_264 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_264() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_264_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", new BigDecimal("-1.2345678901234567890E310"));

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_265 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_265() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_265_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "false");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_266 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_266() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_266_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_267 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_267() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_267_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", 0);

		try {
			new PILInitialLoader();
			fail("����I���̂���NG");
		} catch (Exception e) {
			super.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_268 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_268() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_268_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(Long.class, Long.MIN_VALUE));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_269 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_269() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_269_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", true);

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_270 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_270() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_270_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "2147483647abc");

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertEquals(true, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_271 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_271() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_271_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", this.getSet(String.class, "abcxxx"));

		super.invokeCheckEngineException(testCase, param1, objMap1);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_272 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_272() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"�^�O�ɕs���������݂��܂��B(elementType:startswith�Adatatypes:[single, set])",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_273 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_273() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attr_273_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "92233");

		ResultObject result1 = this.invokeCheckEngineNormalResult(testCase,
				param1, objMap1);
		assertEquals(false, result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_274 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_274() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_275 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_275() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertEquals(
				"�^�O�ɕs���������݂��܂��B(elementType:nstartswith�Adatatypes:[set, single])",
				e.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_276 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_276() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_277 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_277() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_278 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_278() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_279 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_279() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_280 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_280() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_281 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_281() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_282 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_282() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_283 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_283() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_284 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_284() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_285 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_285() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_286 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_286() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_287 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_287() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_288 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_288() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_289 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_289() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_290 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_290() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_291 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_291() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_292 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_292() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_293 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_293() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_294 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_294() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_295 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_295() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_296 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_296() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_297 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_297() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_298 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_298() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_299 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_299() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_300 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_300() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_301 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_301() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_302 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_302() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_303 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_303() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_304 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_304() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_305 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_305() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_306 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_306() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_307 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_307() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_308 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_308() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_378 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_378() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_379 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_379() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_380 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_380() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_381 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_381() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_382 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_382() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_383 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_383() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_384 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_384() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_385 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_385() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_386 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_386() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_387 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_387() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_388 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_388() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_389 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_389() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_390 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_390() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_391 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_391() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_392 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_392() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_393 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_393() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_394 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_394() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_395 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_395() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_396 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_396() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_397 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_397() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_398 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_398() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_399 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_399() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_400 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_400() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_401 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_401() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_402 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_402() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_403 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_403() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_404 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_404() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_405 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_405() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_406 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_406() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_407 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_407() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_408 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_408() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_409 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_409() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = this.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_411 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_411() throws Exception {

		String testCase = this.getName().substring(4);
		Map<String, Object> objMap1 = new HashMap<String, Object>();
		Exception e = this.invokeCheckEngineException(testCase, objMap1);
		assertEquals(PEXUnExpectedStateException.class, e.getClass());
	}
}
