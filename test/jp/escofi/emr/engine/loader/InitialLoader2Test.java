/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.ResultObject;

import org.junit.Test;

/**
 * �C�j�V�������[�_�[�e�X�g�N���X
 *
 * @author seo.yi
 */
public class InitialLoader2Test extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader2";

	public InitialLoader2Test() {

		super(InitialLoader2Test.class, BASE_FOLDER);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_75 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_75() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_76 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_76() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_77 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_77() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_79 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_79() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_80 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_80() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_81 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_81() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_83 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_83() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_84 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_84() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_85 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_85() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_87 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_87() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_88 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_88() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_89 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_89() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_92 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_92() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_93 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_93() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_96 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_96() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_97 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_97() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_100 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_100() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_101 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_101() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_104 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_104() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_105 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_105() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_109 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_109() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_113 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_113() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_117 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_117() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_121 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_121() throws Exception {

		String testCase = this.getName().substring(4);
		invokeCheckInitialLoaderNormal(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_414 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_414() throws Exception {

		String testCase = this.getName().substring(4);
		String no = testCase.substring(13);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + no + "_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", "");

		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param1, objMap1);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_415 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_415() throws Exception {

		String testCase = this.getName().substring(4);
		this.replaceProp(testCase, testCase);

		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + testCase.substring(13) + "_1");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		List<String> expected = new ArrayList<String>();
		expected.add("abc");
		expected.add("");
		assertEquals(expected, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_416 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_416() throws Exception {

		String testCase = this.getName().substring(4);
		String no = testCase.substring(13);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + no + "_1");

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", super.getSet(String.class, "", "abc"));

		ResultObject resultObj = super.invokeCheckEngineNormalResult(
				testCase, param1, objMap1);
		assertEquals(true, resultObj.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_N_001_417 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_417() throws Exception {

		String testCase = this.getName().substring(4);

		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add("attr_" + testCase.substring(13) + "_1");

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("key1", "");
		assertEquals(expected, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_18 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_18() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_19 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_19() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_20 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_20() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_21 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_21() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_22 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_22() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_23 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_23() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_24 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_24() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_25 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_25() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_26 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_26() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_27 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_27() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_28 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_28() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_29 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_29() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_30 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_30() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_31 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_31() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_32 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_32() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_33 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_33() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_34 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_34() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_35 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_35() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_36 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_36() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_37 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_37() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_38 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_38() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_39 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_39() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_40 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_40() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_41 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_41() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_42 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_42() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_43 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_43() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_44 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_44() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_45 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_45() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_46 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_46() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_47 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_47() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_48 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_48() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_49 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_49() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_50 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_50() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_51 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_51() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_52 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_52() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_53 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_53() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_54 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_54() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_55 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_55() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_56 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_56() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_57 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_57() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_58 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_58() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_59 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_59() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_40 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_60() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_61 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_61() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_62 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_62() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_63 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_63() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_64 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_64() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_65 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_65() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_66 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_66() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_67 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_67() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_68 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_68() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_69 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_69() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_70 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_70() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_71 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_71() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_72 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_72() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_73 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_73() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_74 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_74() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_78 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_78() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_82 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_82() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_86 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_86() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_90 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_90() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_91 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_91() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_94 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_94() throws Exception {

		String testCase = this.getName().substring(4);

		// ����n
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_95 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_95() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_98 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_98() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_99 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_99() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_102 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_102() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_103 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_103() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_106 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_106() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_107 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_107() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_108 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_108() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_110 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_110() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_111 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_111() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_112 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_112() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_114 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_114() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_115 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_115() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_116 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_116() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_118 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_118() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_119 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_119() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_120 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_120() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_122 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_122() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_123 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_123() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_124 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_124() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_125 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_125() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		String dataModelName = testCase;
		String attrName = testCase;

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(dataModelName);
		param.add(attrName);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Double.NEGATIVE_INFINITY);

		PDSEngine.getInstance();
		PDSResponse response = super.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_126 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_126() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_127 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_127() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_128 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_128() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_129 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_129() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		List<Double> list = new ArrayList<Double>();
		list.add(Double.NEGATIVE_INFINITY);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals(list, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_130 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_130() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_131 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_131() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_132 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_132() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_133 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_133() throws Exception {

		String testCase = this.getName().substring(4);
		String metaXmlName = testCase;
		this.replaceProp(testCase, metaXmlName);

		String dataModelName = testCase;
		String attrName = testCase;

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(dataModelName);
		param.add(attrName);

		Map<String, Object> objMap = new HashMap<String, Object>();
		Set<Double> set = new HashSet<Double>();
		set.add(Double.NEGATIVE_INFINITY);
		objMap.put("var", set);

		PDSEngine.getInstance();
		PDSResponse response = super.getResult(param, objMap);
		ResultObject result = response.getResultObject();
		assertEquals(true, result.getValue());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_134 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_134() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_135 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_135() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_136 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_136() throws Exception {

		String testCase = this.getName().substring(4);

		// �ُ�n��IllegalArgumentException�����҂����P�[�X
		invokeCheckInitialLoaderException(testCase,
				IllegalArgumentException.class);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_137 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_137() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Double> map = new HashMap<String, Double>();
		map.put("abc", Double.NEGATIVE_INFINITY);

		ResultObject result = super.invokeCheckEngineNormalResult(testCase,
				param1);
		assertEquals(map, result.getValue());
	}
}
