package jp.escofi.emr.engine.loader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.BigDecimalEx;
import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;

import org.junit.Test;
import org.xml.sax.SAXParseException;

/**
 * �C�j�V�������[�_�[�e�X�g�N���X
 *
 * @author seo.yj
 */
public class InitialLoader5Test extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/InitialLoader5";

	public InitialLoader5Test() {

		super(InitialLoader5Test.class, BASE_FOLDER);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_332 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_332() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����@�̈����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr33");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value33", result.getValue().toString());

		// �����A�̈����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr32");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// �����B�̈����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr31");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// �����C�̈����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr22");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value22", result.getValue().toString());

		// �����D�̈����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr21");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// �����E�̈����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value1", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_339 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_339() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		PDSEngine.getInstance();

		super.logPdsObjects();

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();
		assertEquals("value31", result.getValue().toString());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr21");

		response = PDSServiceAPI.getConditionItems(param);
		result = response.getResultObject();
		assertEquals("value21", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_340 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_340() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		PDSEngine.getInstance();

		super.logPdsObjects();

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();
		assertEquals("value31", result.getValue().toString());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr22");

		response = PDSServiceAPI.getConditionItems(param);
		result = response.getResultObject();
		assertEquals("value22", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_341 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_341() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		PDSEngine.getInstance();

		super.logPdsObjects();

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		ResultObject result = response.getResultObject();
		assertEquals("value31", result.getValue().toString());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr23");

		response = PDSServiceAPI.getConditionItems(param);
		result = response.getResultObject();
		assertEquals("value23", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_343 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_343() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr21");

		// �����ݒ�
		List<String> param2 = new ArrayList<String>();
		param2.add(testCase);
		param2.add("key1");
		param2.add("key2");
		param2.add("attr3");

		ResultObject result1 = super.getResult(param1);
		assertEquals("value21", result1.getValue());

		ResultObject result2 = super.getResult(param2);
		assertEquals("value31", result2.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_344 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_344() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr21");
		param1.add("001");

		List<String> param2 = new ArrayList<String>();
		param2.add(testCase);
		param2.add("key1");
		param2.add("key2");
		param2.add("attr3");
		param2.add("001");

		ResultObject result1 = super.getResult(param1);
		assertEquals("value21", result1.getValue());

		ResultObject result2 = super.getResult(param2);
		assertEquals("value31", result2.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_346 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_346() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr3");

		ResultObject result1 = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals("value3", result1.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_352 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_352() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();
		super.logPdsObjects();

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attrname1");
		ResultObject result = super.getResult(param);
		assertEquals("common352", result.getValue());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attrname2");
		result = super.getResult(param);
		assertEquals("standard352", result.getValue());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("attrname3");
		result = super.getResult(param);
		assertEquals("value352", result.getValue());

		param.clear();
		param.add("PILINI_N_001_352_Std_2");
		param.add("stdkey1");
		param.add("attrname4");
		result = super.getResult(param);
		assertEquals("standard352_2", result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_372 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_372() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);
		ResultObject resultObj = super.invokeCheckEngineNormalResult(testCase, param, objMap);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_309 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_309() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		assertEquals("value309_2_5", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_310 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_310() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase.concat("_1"));
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		assertEquals("value310_1_5", result.getValue().toString());
		super.toLog(testCase, response);
		super.toLog(testCase, result);

		// �����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase.concat("_2"));
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();

		assertEquals("value310_1_5", result.getValue().toString());
		super.toLog(testCase, response);
		super.toLog(testCase, result);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_311 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_311() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_312 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_312() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_313 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_313() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_314 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_314() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_315 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_315() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (InvalidKeyException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_316 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_316() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_317 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_317() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertTrue("�G���[���b�Z�[�W������", e.getMessage().startsWith(
				"�p���Ώۃf�[�^���f����������܂���B"));
	}

	/**
	 * �e�X�gID�FPILINI_E_001_318 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_318() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (UnExpectedStateException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_319 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_319() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		try {
			new InitialLoader();
			fail("����I���̂���NG");
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_320 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_320() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		try {
			new InitialLoader();
			fail("����I���̂���NG");
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_321 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_321() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");
		param1.add("005");

		try {
			new InitialLoader();
			fail("����I���̂���NG");
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_322 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_322() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		List<String> param1 = null;

		PDSEngine.getInstance();

		// �e�X�g�@
		for (int i = 1; i < 4; i++) {

			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key0");
			param1.add("key1");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
				fail("����I���̂���NG");
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}

		// �e�X�g�A
		for (int i = 1; i < 4; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_323 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_323() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;

		for (int i = 1; i < 4; i++) {
			// �e�X�g�@
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key7");
			param1.add("key8");
			param1.add("key1");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
				fail("����I���̂���NG");
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}

		for (int i = 1; i < 4; i++) {
			// �e�X�g�A
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key7");
			param1.add("key8");
			param1.add("key2");
			param1.add("attrname".concat(String.valueOf(i)));

			try {
				PDSServiceAPI.getConditionItems(param1);
				fail("����I���̂���NG");
			} catch (InvalidKeyException e) {
				this.toLog(testCase, e);
			}
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_324 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_324() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �e�X�g�@�����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key5");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value324", result.getValue().toString());

		// �e�X�g�A�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key5");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard324", result.getValue().toString());

		// �e�X�g�B�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key5");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);
		super.toLog(testCase, response);
		super.toLog(testCase, result);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_325 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_325() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �e�X�g�@�����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value325", result.getValue().toString());

		// �e�X�g�A�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard325", result.getValue().toString());

		// �e�X�g�B�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_326 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_326() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �e�X�g�@�����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key7");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value326", result.getValue().toString());

		// �e�X�g�A�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key7");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard326", result.getValue().toString());

		// �e�X�g�B�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key7");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("common326", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_327 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_327() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �e�X�g�@�����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value327", result.getValue().toString());

		// �e�X�g�A�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard327", result.getValue().toString());

		// �e�X�g�B�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key8");
		param1.add("key9");
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("common327", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_328 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_328() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �e�X�g�@�����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value328", result.getValue().toString());

		// �e�X�g�A�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("stdkey1");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("standard328", result.getValue().toString());

		// �e�X�g�B�����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("stdkey1");
		param1.add("attrname3");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("common328", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_329 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_329() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname3");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value329_2", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_330 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_330() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr1");
		param1.add("005");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("attrname2", result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_331 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_331() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key11");
		param1.add("key12");
		param1.add("attr2");
		param1.add("001");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals(false, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_333 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_333() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// �����@�̈����ݒ�i�ŏ�ʁj
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr1");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// �����A�̈����ݒ�i��ʁj
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr2");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// �����B�̈����ݒ�i�Ǝ��j
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_334 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_334() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// �����@�̈����ݒ�i�ŏ�ʁj
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr1");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// �����A�̈����ݒ�i��ʁj
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr2");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// �����B�̈����ݒ�i�Ǝ��j
		for (int i = 1; i < 6; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_335 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_335() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// �����ݒ�i�Ǝ��j
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr3");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value31", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_336 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_336() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// �����@�̈����ݒ�i�ŏ�ʁj
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr1");
		param1.add("003");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		this.toLog(testCase, response);
		this.toLog(testCase, result);

		// �����A�̈����ݒ�i��ʁj
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attr2");
		param1.add("003");

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value21", result.getValue().toString());
		System.out.println(result.getValue());

		// �����B�̈����ݒ�i�Ǝ��j
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_337 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_337() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();

		List<String> param1 = null;
		PDSResponse response = null;
		ResultObject result = null;

		// �����@�̈����ݒ�i�ŏ�ʁj
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr1");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// �����A�̈����ݒ�i��ʁj
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr2");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			this.toLog(testCase, response);
			this.toLog(testCase, result);
		}

		// �����B�̈����ݒ�i�Ǝ��j
		for (int i = 1; i < 5; i++) {
			param1 = new ArrayList<String>();
			param1.add(testCase);
			param1.add("key1");
			param1.add("key2");
			param1.add("attr3");
			param1.add("00".concat(String.valueOf(i)));

			response = PDSServiceAPI.getConditionItems(param1);
			result = response.getResultObject();
			assertEquals(PCTStatus.NORMAL, response.getStatus());
			assertEquals("value3".concat(String.valueOf(i)), result.getValue()
					.toString());
			System.out.println(result.getValue());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_338 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_338() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");

		PDSEngine.getInstance();
		super.logPdsObjects();

		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		super.toLog(testCase, response);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("key2");
		param.add("key3");
		param.add("attr3");
		param.add("001");

		try {
			response = PDSServiceAPI.getConditionItems(param);
			fail();
		} catch (InvalidKeyException ex) {
			super.toLog(testCase, ex);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_342 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_342() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_345 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_345() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_347 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_347() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_348 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_348() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertTrue("�G���[���b�Z�[�W������", e.getMessage().startsWith(
				"�p���Ώۃf�[�^���f����������܂���B"));
	}

	/**
	 * �e�X�gID�FPILINI_E_001_349 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_349() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key2");
		param1.add("attrname1");

		PDSEngine.getInstance();
		super.logPdsObjects();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (UnExpectedStateException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_350 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_350() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_351 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_351() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		assertTrue("�G���[���b�Z�[�W������", e.getMessage().startsWith(
				"�p���Ώۃf�[�^���f����������܂���B"));
	}

	/**
	 * �e�X�gID�FPILINI_E_001_353 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_353() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_354 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_354() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key3");
		param1.add("attrname1");

		PDSEngine.getInstance();
		super.logPdsObjects();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value354", result.getValue().toString());

		// �����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key3");
		param1.add("attrname2");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);

		// �����ݒ�
		param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("key3");
		param1.add("attrname3");

		PDSEngine.getInstance();

		response = PDSServiceAPI.getConditionItems(param1);
		result = response.getResultObject();
		super.toLog(testCase, response);
		super.toLog(testCase, result);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
		assertEquals(null, result);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_355 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_355() throws Exception {

		super.replaceProperty("xml.meta.schema.filepath", "");
		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_356 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_356() throws Exception {

		super.replaceProperty("xml.meta.schema.filepath", "Z:/PDSNgine/xsd/abc.xsd");
		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());

//		super.replaceProp(testCase, testCase);
//
//		// �����ݒ�
//		List<String> param1 = new ArrayList<String>();
//		param1.add(testCase);
//		param1.add("attrname1");
//
//		PDSEngine.getInstance();
//
//		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
//		ResultObject result = response.getResultObject();
//		assertEquals(PCTStatus.NORMAL, response.getStatus());
//		assertEquals("value356", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_357 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_357() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value357", result.getValue().toString());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(EMRException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML�Ǘ��������ł��B�i�t�@�C�����FPILINI_E_001_357_Meta.xml�j", pe.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_358 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_358() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProperty("xml.schema.filepath", "");
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_359 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_359() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProperty("xml.schema.filepath", "abc.xsd");
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXParseException.class, e.getClass());
	}

//	/**
//	 * �e�X�gID�FPILINI_E_001_360 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
//	 */
//	@Test
//	public void testPILINI_E_001_360() throws Exception {
//
//		String testCase = this.getName().substring(4);
//		String metaXmlName = testCase;
//		super.replaceProp(testCase, metaXmlName);
//
//		// �����ݒ�
//		List<String> param1 = new ArrayList<String>();
//		param1.add(testCase);
//		param1.add("attrname1");
//
//		ResultObject resultObj = super.invokeCheckEngineNormalResult(testCase, param1);
//		assertEquals("value360", resultObj.getValue());
//	}

	/**
	 * �e�X�gID�FPILINI_E_001_361 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_361() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("key1");
		param1.add("attrname1");
		param1.add("version");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		assertEquals("value361", result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_362 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_362() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		try {
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
		} catch (UnExpectedStateException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_363 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_363() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		System.out.println("�����������m�F�F" + result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_364 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_364() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attrname1");

		PDSEngine.getInstance();

		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		ResultObject result = response.getResultObject();

		System.out.println("�����������m�F�F" + result.getValue().toString());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_365 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_365() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		IllegalArgumentException iae = (IllegalArgumentException) e;
		assertEquals("Attribute 'name' must be set on element 'datamodel'.",
				iae.getMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_366 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_366() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		PDSEngine.getInstance();
		PDSResponse response = this.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_367 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_367() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1, objMap1);
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_368 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_368() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1, objMap1);
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_369 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_369() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_370 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_370() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
		EMRException pe = (EMRException) e;
		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
		assertEquals("�f�[�^���f���w�l�k�t�@�C���������ł��B�i�t�@�C�����FPILINI_E_001_370.xml�j", pe
				.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_371 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_371() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
		EMRException pe = (EMRException) e;
		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
		assertEquals("�f�[�^���f���w�l�k�t�@�C���������ł��B�i�t�@�C�����FPILINI_E_001_371.xml�j", pe
				.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_373 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_373() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_374 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_374() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_375 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_375() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		super.replaceProp(testCase, metaXmlName);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		try {
			new InitialLoader();
			fail();
		} catch (EMRException e) {
			this.toLog(testCase, e);
		}
	}

	/**
	 * �e�X�gID�FPILINI_N_001_376 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_376() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		this.replaceProp(testCase, testCase);
		PDSEngine.getInstance();
		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		super.toLog(testCase, response);
		assertEquals(PCTStatus.DELETED, response.getStatus());

		ResultObject result = response.getResultObject();
		super.toLog(testCase, result);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_377 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_377() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	// /**
	// * �e�X�gID�FPILINI_E_001_412 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	// */
	// @Test
	// public void testPILINI_E_001_412() throws Exception {
	//
	// String testCase = this.getName().substring(4);
	// String metaXmlName = testCase;
	// super.replaceProp(testCase, metaXmlName);
	//
	// // �����ݒ�
	// List<String> param1 = new ArrayList<String>();
	// param1.add(testCase);
	// param1.add("attrname1");
	//
	// try {
	// new InitialLoader();
	// fail();
	// } catch (EMRException e) {
	// this.toLog(testCase, e);
	// }
	// }

	/**
	 * �e�X�gID�FPILINI_E_001_413 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_413() throws Exception {

		String testCase = this.getName().substring(4);
//		String metaXmlName = testCase;
//		super.replaceProp(testCase, metaXmlName);
//
//		// �����ݒ�
//		List<String> param1 = new ArrayList<String>();
//		param1.add(testCase);
//		param1.add("attrname1");
//
//		PDSEngine.getInstance();
//
//		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
//		ResultObject result = response.getResultObject();
//
//		assertEquals("value413", result.getValue().toString());

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, e.getClass());
		EMRException pe = (EMRException)e;
		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
		assertEquals("XML�Ǘ��������ł��B�i�t�@�C�����FPILINI_E_001_413_Meta.xml�j", pe.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_418 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_418() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_419 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_419() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimalEx("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		assertEquals(new BigDecimalEx("9.8765432109876543210E310"), resultObj
				.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_420 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_420() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimal("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		List<BigDecimalEx> expected = new ArrayList<BigDecimalEx>();
		expected.add(new BigDecimalEx("9.8765432109876543210E310"));
		expected.add(new BigDecimalEx("1.2345678901234567890E310"));
		assertEquals(expected, resultObj.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_421 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_421() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimal("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		Map<String, BigDecimalEx> expected = new HashMap<String, BigDecimalEx>();
		expected.put("key1", new BigDecimalEx("9.8765432109876543210E310"));
		expected.put("key2", new BigDecimalEx("1.2345678901234567890E310"));
		assertEquals(expected, resultObj.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_422 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_422() throws Exception {

		String testCase = this.getName().substring(4);
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add("key1");
		param.add("attr");
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", new BigDecimalEx("1.2345678901234567890E310"));
		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param, objMap);
		RangeObject expected = (RangeObject) resultObj.getValue();
		assertEquals(true, expected.includeUpper());
		assertEquals(true, expected.includeLower());
		assertEquals(new BigDecimalEx("9.8765432109876543210E310"), expected
				.getUpper());
		assertEquals(new BigDecimalEx("1.2345678901234567890E310"), expected
				.getLower());

		param.clear();
		param.add(testCase);
		param.add("key1");
		param.add("attr2");
		resultObj = super.getResult(param);
		assertEquals(new BigDecimalEx("1.2345678901234567890E310"), resultObj
				.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_423
	 */
	@Test
	public void testPILINI_E_001_423() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_424
	 */
	@Test
	public void testPILINI_E_001_424() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPILINI_E_001_425
	 */
	@Test
	public void testPILINI_E_001_425() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPILINI_E_001_426
	 */
	@Test
	public void testPILINI_E_001_426() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPILINI_E_001_427
	 */
	@Test
	public void testPILINI_E_001_427() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPILINI_E_001_428
	 */
	@Test
	public void testPILINI_E_001_428() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_429
	 */
	@Test
	public void testPILINI_E_001_429() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_430
	 */
	@Test
	public void testPILINI_E_001_430() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_431
	 */
	@Test
	public void testPILINI_E_001_431() throws Exception {

		String testCase = this.getName().substring(4);
		super.replaceProp(testCase, testCase);
		try {
			PDSEngine.getInstance();
			fail();
		} catch (EMRException e) {
			EMRException pe = (EMRException) e;
			assertEquals(PCTMessageCode.P009E, pe.getErrCode());
		}
	}
}
