/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.initialload.PILInitialLoader;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * �C�j�V�������[�_�[�e�X�g�N���X
 *
 * @author seo.yi
 */
public class InitialLoaderTest extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	protected static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader";

	/**
	 * �R���X�g���N�^
	 */
	public InitialLoaderTest() {

		super(InitialLoaderTest.class, BASE_FOLDER);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_1 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_1() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add(testCase);
		parameter1.add("attrname1");

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("ConditionItem001", 150);
		objMap.put("ConditionItem001", 150);
		objMap.put("ConditionItem003", 150);
		objMap.put("ConditionItem004", 150);
		objMap.put("ConditionItem005", 150);
		objMap.put("ConditionItem006", 150);
		objMap.put("ConditionItem007", 150);
		objMap.put("ConditionItem008", this.getSet(BigDecimal.class,
				"1.23450e331", "-1.2345e-310"));
		objMap.put("ConditionItem009", this.getSet(Integer.class, 140, 150));
		objMap.put("ConditionItem010", this.getSet(Integer.class, 120, 150));
		objMap.put("ConditionItem011", this
				.getSet(Integer.class, 120, 150, 170));
		objMap.put("ConditionItem012", this.getSet(Integer.class, 130, 160));
		objMap.put("ConditionItem013", 150);
		objMap.put("ConditionItem014", 170);
		objMap.put("ConditionItem015", "abc");
		objMap.put("ConditionItem016", "bbbc");
		objMap.put("ConditionItem017", this.getSet(Integer.class, 1, 2, 3));

		PDSResponse response = super.invokeCheckEngineNormalResponse(testCase,
				parameter1, objMap);

		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// �������L���m�F
		assertEquals(true, response.isCondition());
		// �����l�m�F
		String result = (String) response.getResultObject().getValue();
		// ���ʒl
		assertEquals("value1", result);
		// ----------------------<<���ʊm�F�A�C���|�C���gEND>>-------------------------------//

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPILINI_N_001_2 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_2() throws Exception {

		this.replaceProp(this.getName().substring(4));

		PDSEngine engine = PDSEngine.getInstance();
		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(engine);

		Field pdsItemKeysField = PDSEngine.class
				.getDeclaredField("pdsItemKeys");
		pdsItemKeysField.setAccessible(true);
		HashMap<String, List<String>> pdsItemKeys = (HashMap<String, List<String>>) pdsItemKeysField
				.get(engine);

		// ----------------------<<���ʊm�F�P>>-------------------------------//
		// �C�j�V�������[�h�ς݂̃I�u�W�F�N�g�̃T�C�Y�y�сA�A�C�e���L�[�T�C�Y���`�F�b�N
		assertEquals(52, pdsObjects.size());
		assertEquals(52, pdsItemKeys.size());

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PILINI_N_001_15");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		// �������ڎ擾����
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<���ʊm�F�Q>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// �������L���m�F
		assertEquals(false, response.isCondition());
		// �����l�m�F
		List<Integer> resultObjectValue = (List<Integer>) response
				.getResultObject().getValue();

		// ���Ғl
		List<Integer> expectedResultObjectValue = new ArrayList<Integer>();
		expectedResultObjectValue.add(112233);
		expectedResultObjectValue.add(223344);
		expectedResultObjectValue.add(334455);
		expectedResultObjectValue.add(445566);
		expectedResultObjectValue.add(556677);

		assertEquals(expectedResultObjectValue, resultObjectValue);

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER + "/All", "all");
		}
	}

	/**
	 * �e�X�gID�FPILINI_N_001_3 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_3() throws Exception {

		this.replaceProp(this.getName().substring(4));

		PDSEngine engine = PDSEngine.getInstance();
		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(engine);

		Field pdsItemKeysField = PDSEngine.class
				.getDeclaredField("pdsItemKeys");
		pdsItemKeysField.setAccessible(true);
		HashMap<String, List<String>> pdsItemKeys = (HashMap<String, List<String>>) pdsItemKeysField
				.get(engine);

		// ----------------------<<���ʊm�F�P>>-------------------------------//
		// �C�j�V�������[�h�ς݂̃I�u�W�F�N�g�̃T�C�Y�y�сA�A�C�e���L�[�T�C�Y���`�F�b�N
		assertEquals(52, pdsObjects.size());
		assertEquals(52, pdsItemKeys.size());

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PILINI_N_001_35");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		// �������ڎ擾����
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<���ʊm�F�Q>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// �������L���m�F
		assertEquals(false, response.isCondition());
		// �����l�m�F
		ResultObject resultObject = response
				.getResultObject();
		// �폜�t���O�m�F
		assertEquals("value035_2", ((String) resultObject.getValue()));

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPILINI_N_001_4 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_4() throws Exception {

		this.replaceProp(this.getName().substring(4));

		PDSEngine engine = PDSEngine.getInstance();
		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(engine);

		Field pdsItemKeysField = PDSEngine.class
				.getDeclaredField("pdsItemKeys");
		pdsItemKeysField.setAccessible(true);
		HashMap<String, List<String>> pdsItemKeys = (HashMap<String, List<String>>) pdsItemKeysField
				.get(engine);

		// ----------------------<<���ʊm�F�P>>-------------------------------//
		// �C�j�V�������[�h�ς݂̃I�u�W�F�N�g�̃T�C�Y�y�сA�A�C�e���L�[�T�C�Y���`�F�b�N
		assertEquals(52, pdsObjects.size());
		assertEquals(52, pdsItemKeys.size());

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PILINI_N_001_45");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		// �������ڎ擾����
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ----------------------<<���ʊm�F�Q>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(PCTStatus.NORMAL, response.getStatus());
		// �������L���m�F
		assertEquals(false, response.isCondition());
		// �����l�m�F
		ResultObject result = response.getResultObject();
		// �폜�t���O�m�F
		assertEquals("common001", ((String) result.getValue()));

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_1 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_1() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "XML�Ǘ������݂��܂���B�i�t�@�C���p�X�FZ:/PDSNgine/xml/PILInitialLoader/PILINI_E_001_1_Meta.xml�j";
		assertEquals(PCTMessageCode.P004E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_2 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_2() throws Exception {

		String testCase = this.getName().substring(4);
		this.replaceProp(testCase, testCase + "_XXX");

		// �ُ�n��PEXException�����҂����P�[�X
		try {
			PILInitialLoader loader = new PILInitialLoader();
			fail();
		} catch (PEXException e) {
			String expectedMessage = "XML�Ǘ������݂��܂���B�i�t�@�C���p�X�FZ:/PDSNgine/xml/PILInitialLoader/PILINI_E_001_2_XXX_Meta.xml�j";
			assertEquals(PCTMessageCode.P004E, e.getErrCode());
			assertEquals(expectedMessage, e.getErrMessage());
		}
	}

	/**
	 * �e�X�gID�FPILINI_E_001_3 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_3() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "XML�Ǘ��������ł��B�i�t�@�C�����FPILINI_E_001_3_Meta.xml�j";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_4 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_4() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(DocumentBuilderFactory.class,
				"newDocumentBuilder", 0, new ParserConfigurationException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(ParserConfigurationException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_5 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_5() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(DocumentBuilder.class, "parse", 0,
				new IOException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IOException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_6 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_6() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0,
				new SAXException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_7 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_7() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(SAXParser.class, "getXMLReader", 0,
				new SAXException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(SAXException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_8 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_8() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0,
				new ParserConfigurationException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(ParserConfigurationException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_9 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_9() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "�f�[�^���f���w�l�k�t�@�C�������݂��܂���B�i�t�@�C���p�X�FZ:/PDSNgine/xml/PILInitialLoader"
				+ FILE_SEPARATOR + "PILINI_E_001_9.xml�j";
		assertEquals(PCTMessageCode.P004E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_10 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_10() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "�f�[�^���f���w�l�k�t�@�C�������݂��܂���B�i�t�@�C���p�X�FZ:/PDSNgine/xml/PILInitialLoader"
				+ FILE_SEPARATOR + "PILINI_E_001_10_XXX.xml�j";
		assertEquals(PCTMessageCode.P004E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_11 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_11() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "�f�[�^���f���w�l�k�t�@�C���������ł��B�i�t�@�C�����FPILINI_E_001_11.xml�j";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_12 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_12() throws Exception {

		String testCase = this.getName().substring(4);
		super.setReturnValueAt(XMLReader.class, "parse", 0, new IOException());
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IOException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_13 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_13() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "�f�[�^���f���w�l�k�t�@�C���������ł��B�i�t�@�C�����FPILINI_E_001_13.xml�j";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_14 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_14() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_15 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_15() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_16 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_16() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "�f�[�^���f���w�l�k�t�@�C���������ł��B�i�t�@�C�����FPILINI_E_001_16.xml�j";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_17 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_17() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
		PEXException pexE = (PEXException) e;
		String expectedMessage = "�f�[�^���f���w�l�k�t�@�C���������ł��B�i�t�@�C�����FPILINI_E_001_17.xml�j";
		assertEquals(PCTMessageCode.P005E, pexE.getErrCode());
		assertEquals(expectedMessage, pexE.getErrMessage());
	}

	// /**
	// * �e�X�gID�FPILINI_E_001_18 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	// */
	// @Test
	// public void testPILINI_E_001_18() throws Exception {
	//
	// this.replaceProp(this.getName().substring(4));
	//
	// PDSEngine engine = PDSEngine.getInstance();
	//
	// // �����ݒ�
	// List<String> parameter1 = new ArrayList<String>();
	// parameter1.add("PILINI_E_001_18");
	// parameter1.add("attr1");
	//
	// Map<String, Object> objMap = new HashMap<String, Object>();
	// objMap.put("ConditionItem001", 100);
	// objMap.put("ConditionItem002", 101);
	//
	// // �������ڎ擾����
	// PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);
	//
	// Map<String, PROConditionItemInfo> conditionItemInfoMap = response
	// .getConditionItemInfoMap();
	//
	// assertNotNull(conditionItemInfoMap);
	//
	// // �������ڒlMap
	// Map<String, Object> conditionItemValueMap = new HashMap<String,
	// Object>();
	//
	// Collection<PROConditionItemInfo> collection = conditionItemInfoMap
	// .values();
	// for (PROConditionItemInfo conditionItemInfo : collection) {
	// // �������ڃN���X��������擾����B
	// String itemName = conditionItemInfo.getItemName();
	// String javaDataType = conditionItemInfo.getJavaDataType();
	//
	// // �������ڒl�}�b�v�ɐݒ�
	// if (objMap.containsKey(itemName)) {
	// Object varValue = PUTConvertUtil.convert(objMap.get(itemName),
	// javaDataType);
	// conditionItemValueMap.put(itemName, varValue);
	// }
	// }
	// // PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
	// response.setConditionItemValueMap(conditionItemValueMap);
	//
	// try {
	// // �����l�擾���\�b�h���Ăяo���B
	// response = PDSServiceAPI.getAttrValue(response);
	// fail();
	// } catch (PEXConditionNotMatchedException e) {
	// assertTrue(true);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPILINI_E_001_19 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	// */
	// @Test
	// public void testPILINI_E_001_19() throws Exception {
	//
	// this.replaceProp(this.getName().substring(4));
	//
	// PDSEngine engine = PDSEngine.getInstance();
	//
	// // �����ݒ�
	// List<String> parameter1 = new ArrayList<String>();
	// parameter1.add("PILINI_E_001_19");
	// parameter1.add("attr1");
	//
	// Map<String, Object> objMap = new HashMap<String, Object>();
	// objMap.put("ConditionItem001", 101);
	//
	// // �������ڎ擾����
	// PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);
	//
	// Map<String, PROConditionItemInfo> conditionItemInfoMap = response
	// .getConditionItemInfoMap();
	//
	// assertNotNull(conditionItemInfoMap);
	//
	// // �������ڒlMap
	// Map<String, Object> conditionItemValueMap = new HashMap<String,
	// Object>();
	//
	// Collection<PROConditionItemInfo> collection = conditionItemInfoMap
	// .values();
	// for (PROConditionItemInfo conditionItemInfo : collection) {
	// // �������ڃN���X��������擾����B
	// String itemName = conditionItemInfo.getItemName();
	// String javaDataType = conditionItemInfo.getJavaDataType();
	//
	// // �������ڒl�}�b�v�ɐݒ�
	// if (objMap.containsKey(itemName)) {
	// Object varValue = PUTConvertUtil.convert(objMap.get(itemName),
	// javaDataType);
	// conditionItemValueMap.put(itemName, varValue);
	// }
	// }
	// // PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
	// response.setConditionItemValueMap(conditionItemValueMap);
	//
	// try {
	// // �����l�擾���\�b�h���Ăяo���B
	// response = PDSServiceAPI.getAttrValue(response);
	// fail();
	// } catch (PEXConditionNotMatchedException e) {
	// assertTrue(true);
	// }
	// }
	//
	// /**
	// * �e�X�gID�FPILINI_E_001_20 �C�j�V�������[�_�[�̃R���X�g���N�^��PDS�I�u�W�F�N�g�}�b�v�E�L�[���ڃ}�b�v�擾�����ʊm�F
	// */
	// @Test
	// public void testPILINI_E_001_20() throws Exception {
	//
	// this.replaceProp(this.getName().substring(4));
	//
	// PDSEngine engine = PDSEngine.getInstance();
	//
	// // �����ݒ�
	// List<String> parameter1 = new ArrayList<String>();
	// parameter1.add("PILINI_E_001_20");
	// parameter1.add("attr1");
	//
	// Map<String, Object> objMap = new HashMap<String, Object>();
	// objMap.put("ConditionItem001", 100);
	//
	// // �������ڎ擾����
	// PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);
	//
	// Map<String, PROConditionItemInfo> conditionItemInfoMap = response
	// .getConditionItemInfoMap();
	//
	// assertNotNull(conditionItemInfoMap);
	//
	// // �������ڒlMap
	// Map<String, Object> conditionItemValueMap = new HashMap<String,
	// Object>();
	//
	// Collection<PROConditionItemInfo> collection = conditionItemInfoMap
	// .values();
	// for (PROConditionItemInfo conditionItemInfo : collection) {
	// // �������ڃN���X��������擾����B
	// String itemName = conditionItemInfo.getItemName();
	// String javaDataType = conditionItemInfo.getJavaDataType();
	//
	// // �������ڒl�}�b�v�ɐݒ�
	// if (objMap.containsKey(itemName)) {
	// Object varValue = PUTConvertUtil.convert(objMap.get(itemName),
	// javaDataType);
	// conditionItemValueMap.put(itemName, varValue);
	// }
	// }
	// // PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
	// response.setConditionItemValueMap(conditionItemValueMap);
	//
	// // �����l�擾���\�b�h���Ăяo���B
	// response = PDSServiceAPI.getAttrValue(response);
	//
	// // �_���v���s
	// PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
	// .substring(4));
	// }
}
