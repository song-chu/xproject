package jp.escofi.emr;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jp.co.dgic.testing.framework.DJUnitTestCase;
import jp.escofi.emr.engine.common.constant.Status;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.loader.InitialLoader;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.ResultObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author song.ck
 *
 */
public class DJUnitTestCaseEx extends DJUnitTestCase {

	/**
	 * �t�@�C���Z�p���[�^
	 */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator", "/");

	/**
	 * �_���v�v��
	 */
	protected static final boolean NEED_DUMP = true;

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	protected static final String SLASH = "/";

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	private String baseFolder = null;

	/**
	 * ���O
	 */
	protected Log log = null;

	/**
	 * �_���v���\�[�X�x�[�X�t�H���_
	 */
	protected static final String DUMP_BASE_FOLDER = "C:/emr/dump";

	/**
	 * �R���X�g���N�^
	 *
	 * @param clazz
	 *            �N���X
	 * @param baseFolder
	 *            ���\�[�X�x�[�X�t�H���_
	 */
	@SuppressWarnings("unchecked")
	public DJUnitTestCaseEx(Class clazz, String baseFolder) {

		super();
		this.log = LogFactory.getLog(clazz);
		this.baseFolder = baseFolder;
	}

	/**
	 *
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		Method loadMethod = PropertyUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		Properties props = (Properties) loadMethod
				.invoke(PropertyUtil.class);

		props.setProperty("xml.datamodel.base", this.baseFolder);

		Field propsField = PropertyUtil.class.getDeclaredField("props");
		propsField.setAccessible(true);
		propsField.set(null, props);

		Field isLoadedField = PDSEngine.class.getDeclaredField("isLoaded");
		isLoadedField.setAccessible(true);
		isLoadedField.set(null, false);

		Field instanceField = PDSEngine.class.getDeclaredField("instance");
		instanceField.setAccessible(true);
		instanceField.set(null, null);
	}

	/**
	 *
	 */
	@Override
	protected void tearDown() throws Exception {

		this.replaceProperty("xml.meta.schema.filepath", "C:/FromSong/workspace/escofierm/xsd/emrmeta.xsd");
		super.tearDown();
	}

	/**
	 * �v���p�e�B�u��
	 *
	 * @param key
	 *            �L�[
	 * @param value
	 *            �l
	 * @throws Exception	��O
	 */
	protected void replaceProperty(String key, String value) throws Exception {

		Field propsField = PropertyUtil.class.getDeclaredField("props");
		propsField.setAccessible(true);
		Properties props = (Properties) propsField.get(PropertyUtil.class);
		props.put(key, value);
		propsField.set(null, props);
	}

	/**
	 * <p>
	 * �e�X�g�P�[�X���ɂ�郊�t���N�V�����̐ݒ�<br>
	 * �v���p�e�B���e�B���e�B��胁�[�^XML�̃p�X�擾���A�擾�p�X��u������B
	 * </p>
	 *
	 * @param testCaseName
	 *            �e�X�g�P�[�X��
	 * @throws Exception	��O
	 */
	protected void replaceProp(String testCaseName) throws Exception {

		this.replaceProp(testCaseName, testCaseName);
	}

	/**
	 * <p>
	 * ���^�f�[�^���f�����ɂ��Virtual Mock Object�̐ݒ�<br>
	 * �v���p�e�B���e�B���e�B��胁�[�^XML�̃p�X�擾���A�擾�p�X��u������B
	 * </p>
	 *
	 * @param testCaseName
	 *            �e�X�g�P�[�X��
	 * @param dataModelMetaXmlName
	 *            ���^�f�[�^���f����
	 * @throws Exception	��O
	 */
	protected void replaceProp(String testCaseName, String dataModelMetaXmlName)
			throws Exception {

		log.info("########## " + testCaseName + " ##########");

		this.replaceProperty("xml.meta.filepath", this.baseFolder + SLASH
				+ dataModelMetaXmlName + "_Meta.xml");
	}

	/**
	 * �G���W����PDS�I�u�W�F�N�g�����O�o��
	 *
	 * @throws Exception
	 *             ��O
	 */
	protected void logPdsObjects() throws Exception {

		Field pdsObjectsField = PDSEngine.class.getDeclaredField("pdsObjects");
		pdsObjectsField.setAccessible(true);
		HashMap<String, Object> pdsObjects = (HashMap<String, Object>) pdsObjectsField
				.get(PDSEngine.class);
		this.log.info(pdsObjects);
	}

	/**
	 * �I�u�W�F�N�g���V�K�Z�b�g���쐬����B
	 *
	 * @param <T>	Java�^
	 *
	 * @param clazz
	 *            �f�[�^�^�C�v
	 * @param objects
	 *            �I�u�W�F�N�g
	 * @return �Z�b�g
	 */
	@SuppressWarnings("unchecked")
	protected <T> Set<T> getSet(Class<T> clazz, Object... objects) {

		Set<T> set = new HashSet<T>();
		if (objects != null && objects.length > 0) {
			for (Object obj : objects) {
				if (clazz == Integer.class) {
					set.add((T) new Integer(obj.toString()));
				} else if (clazz == Long.class) {
					set.add((T) new Long(obj.toString()));
				} else if (clazz == Double.class) {
					set.add((T) new Double(obj.toString()));
				} else if (clazz == Boolean.class) {
					set.add((T) new Boolean(obj.toString()));
				} else if (clazz == BigDecimal.class) {
					set.add((T) new BigDecimal(obj.toString()));
				} else {
					set.add((T) obj);
				}
			}
		}
		return (Set<T>) set;
	}

	/**
	 * �e�X�g�h���C�u
	 *
	 * @param param
	 *            �p�����[�^
	 * @return ����
	 * @throws Exception
	 *             ��O
	 */
	protected ResultObject getResult(List<String> param) throws Exception {

		// �������ڎ擾����
		PDSResponse response = PDSServiceAPI.getConditionItems(param);

		// ----------------------<<���ʊm�F>>-------------------------------//
		// �X�e�[�^�X�m�F
		assertEquals(Status.NORMAL, response.getStatus());
		// �������ڎ擾�p�}�b�v�m�F
		assertEquals(null, response.getConditionItemInfoMap());
		// �������ڒl�}�b�v�m�F
		assertEquals(null, response.getConditionItemValueMap());
		// �������L���m�F
		assertEquals(false, response.isCondition());
		// ���^���m�F
		assertEquals("", response.getMetaInfo());

		return response.getResultObject();
	}

	/**
	 * �e�X�g�h���C�u
	 *
	 * @param param
	 *            �p�����[�^
	 * @param objMap
	 *            �I�u�W�F�N�g�}�b�v
	 * @return ����
	 * @throws Exception
	 *             ��O
	 */
	@Deprecated
	protected PDSResponse getResult2(List<String> param,
			Map<String, Object> objMap) throws Exception {

		return this.getResult(param, objMap);
	}

	/**
	 * �e�X�g�h���C�u
	 *
	 * @param param
	 *            �p�����[�^
	 * @param objMap
	 *            �I�u�W�F�N�g�}�b�v
	 * @return ����
	 * @throws Exception
	 *             ��O
	 */
	protected PDSResponse getResult(List<String> param,
			Map<String, Object> objMap) throws Exception {

		// �������ڎ擾����
		PDSResponse response = PDSServiceAPI.getConditionItems(param);
		Map<String, ConditionItemInfo> conditionItemInfoMap = response
				.getConditionItemInfoMap();
		if (conditionItemInfoMap == null) {
			return response;
		}

		// �������ڒlMap
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();
		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();
		for (ConditionItemInfo conditionItemInfo : collection) {
			// �������ڒl�}�b�v�ɐݒ�
			String itemName = conditionItemInfo.getItemName();
			conditionItemValueMap.put(itemName, objMap.get(itemName));
		}
		// PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
		response.setConditionItemValueMap(conditionItemValueMap);
		// �����l�擾���\�b�h���Ăяo���B
		return PDSServiceAPI.getAttrValue(response);
	}

	/**
	 * Exception�̃��O���o��
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X��
	 * @param e
	 *            ��O
	 */
	protected void toLog(String testCase, Exception e) {

		this.log.info("##### " + testCase + " ���� #####");
		this.log.info("Exception:" + e.getClass().getSimpleName());
		if (e instanceof EMRException) {
			this.log.info("ErrCode:" + ((EMRException) e).getErrCode());
			this.log.info("ErrMessage:" + ((EMRException) e).getErrMessage());
		}
		this.log.info(null, e);
	}

	/**
	 * PDSResponse�̃��O���o��
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X��
	 * @param response
	 *            PDS����
	 */
	protected void toLog(String testCase, PDSResponse response) {

		StringBuilder sb = new StringBuilder("##### " + testCase + " ���� #####");
		sb.append("\nPDSResponse:" + response);
		if (response != null) {
			sb.append("\nMetaInfo:" + response.getMetaInfo());
			sb.append("\nConditionItemInfoMap:"
					+ response.getConditionItemInfoMap());
			sb.append("\nConditionItemValueMap:"
					+ response.getConditionItemValueMap());
			sb.append("\nResultObject:" + response.getResultObject());
			sb.append("\nStatus:" + response.getStatus());
			sb.append("\nConditionFla:" + response.isCondition());
		}
		this.log.info(sb.toString());
	}

	/**
	 * ResultObject�̃��O���o��
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X��
	 * @param result
	 *            ���ʃI�u�W�F�N�g
	 */
	protected void toLog(String testCase, ResultObject result) {

		StringBuilder sb = new StringBuilder("##### " + testCase + " ���� #####");
		sb.append("\nResultObject:" + result);
		if (result != null) {
			sb.append("\nDataType:" + result.getDataType());
			sb.append("\nJavaDataType:" + result.getJavaDataType());
			sb.append("\nMetaInfo:" + result.getMetaInfo());
			sb.append("\nValue:" + result.getValue());
			sb.append("\nDelflg:" + result.isDeleted());
		}
		this.log.info(sb.toString());
	}

	/**
	 * �C�j�V�������[�_�[�G���[�P�[�X�e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @return Exception ��O
	 * @throws Exception
	 *             ��O
	 */
	protected Exception invokeCheckInitialLoaderException(String testCase)
			throws Exception {

		this.replaceProp(testCase, testCase);

		try {
			new InitialLoader();
			fail("����I���̂���NG");
			return null;
		} catch (Exception e) {
			this.toLog(testCase, e);
			return e;
		}
	}

	/**
	 * �C�j�V�������[����O�P�[�X���e�X�g �z�茋��:IllegalArgumentException
	 * @param testCase 	�e�X�g�P�[�XID
	 * @param exceptionClass 	��O�N���X
	 *
	 * @throws Exception ��O
	 */
	protected void invokeCheckInitialLoaderException(String testCase,
			Class exceptionClass) throws Exception {

		this.replaceProp(testCase, testCase);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		try {
			new InitialLoader();
			fail();
		} catch (Exception e) {
			this.toLog(testCase, e);
			assertEquals(exceptionClass, e.getClass());
		}
	}

	/**
	 * �C�j�V�������[�_�[����P�[�X�e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X
	 * @throws Exception
	 *             ��O
	 */
	protected void invokeCheckInitialLoaderNormal(String testCase)
			throws Exception {

		this.invokeCheckInitialLoaderNormal(testCase, testCase);
	}

	/**
	 * �C�j�V�������[�_�[����P�[�X�e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X
	 * @param metaXmlName
	 *            ���[�^XML��
	 * @throws Exception
	 *             ��O
	 */
	protected void invokeCheckInitialLoaderNormal(String testCase,
			String metaXmlName) throws Exception {

		this.replaceProp(testCase, metaXmlName);

		// ����n
		new InitialLoader();
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param param1
	 *            �����L�[�p�����[�^
	 * @return ��O
	 * @throws Exception
	 *             ��O
	 */
	protected Exception invokeCheckEngineException(String testCase,
			List<String> param1) throws Exception {

		this.replaceProp(testCase, testCase);

		try {
			PDSEngine.getInstance();
			PDSServiceAPI.getConditionItems(param1);
			fail("����I���̂���NG");
			return null;
		} catch (Exception e) {
			this.toLog(testCase, e);
			return e;
		}
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param param1
	 *            �����L�[�p�����[�^
	 * @param objMap1
	 *            �������ڃ}�b�v
	 * @return ��O
	 * @throws Exception
	 *             ��O
	 */
	protected Exception invokeCheckEngineException(String testCase,
			List<String> param1, Map<String, Object> objMap1) throws Exception {

		this.replaceProp(testCase, testCase);

		try {
			PDSEngine.getInstance();
			PDSResponse response1 = this.getResult(param1, objMap1);
			response1.getResultObject();
			fail("����I���̂���NG");
			return null;
		} catch (Exception e) {
			this.toLog(testCase, e);
			return e;
		}
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param param1
	 *            �����L�[�p�����[�^
	 * @return ���ʃI�u�W�F�N�g
	 * @throws Exception
	 *             ��O
	 */
	protected ResultObject invokeCheckEngineNormalResult(String testCase,
			List<String> param1) throws Exception {

		this.replaceProp(testCase, testCase);

		PDSEngine.getInstance();
		PDSResponse response = PDSServiceAPI.getConditionItems(param1);
		return response.getResultObject();
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param param1
	 *            �����L�[�p�����[�^
	 * @param objMap1
	 *            �������ڃ}�b�v
	 * @return ���ʃI�u�W�F�N�g
	 * @throws Exception
	 *             ��O
	 */
	protected ResultObject invokeCheckEngineNormalResult(String testCase,
			List<String> param1, Map<String, Object> objMap1) throws Exception {

		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		ResultObject result1 = response1.getResultObject();
		assertNotNull(result1);
		return result1;
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param param1
	 *            �����L�[�p�����[�^
	 * @return PDS�����I�u�W�F�N�g
	 * @throws Exception
	 *             ��O
	 */
	protected PDSResponse invokeCheckEngineNormalResponse(String testCase,
			List<String> param1) throws Exception {

		this.replaceProp(testCase, testCase);

		PDSEngine.getInstance();
		return PDSServiceAPI.getConditionItems(param1);
	}

	/**
	 * �G���W���e�X�g
	 *
	 * @param testCase
	 *            �e�X�g�P�[�X�ԍ�
	 * @param param1
	 *            �����L�[�p�����[�^
	 * @param objMap1
	 *            �������ڃ}�b�v
	 * @return PDS�����I�u�W�F�N�g
	 * @throws Exception
	 *             ��O
	 */
	protected PDSResponse invokeCheckEngineNormalResponse(String testCase,
			List<String> param1, Map<String, Object> objMap1) throws Exception {

		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		PDSEngine.getInstance();
		PDSResponse response1 = this.getResult(param1, objMap1);
		assertNotNull(response1);
		return response1;
	}
}
