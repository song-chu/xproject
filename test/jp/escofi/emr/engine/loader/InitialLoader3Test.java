/**
 *
 */
package jp.escofi.emr.engine.loader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXUnExpectedStateException;

import org.junit.Test;

/**
 * �C�j�V�������[�_�[�e�X�g�N���X
 *
 * @author seo.yi
 */
public class InitialLoader3Test extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PILInitialLoader3";

	public InitialLoader3Test() {

		super(InitialLoader3Test.class, BASE_FOLDER);
	}

	/**
	 * �e�X�gID�FPILINI_N_001_177 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_N_001_177() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		PDSResponse response = super.invokeCheckEngineNormalResponse(testCase,
				param1);
		assertEquals(PCTStatus.ATTR_NOT_FOUND, response.getStatus());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_138 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_138() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		IllegalArgumentException iae = (IllegalArgumentException) e;
		assertEquals("Attribute 'name' must be set on element 'datamodel'.",
				iae.getMessage());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(IllegalArgumentException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML�Ǘ��������ł��B�i�t�@�C�����FPILINI_E_001_138_Meta.xml�j", pe.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_139 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_139() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(FileNotFoundException.class, e.getClass());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(EMRException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML�Ǘ��������ł��B�i�t�@�C�����FPILINI_E_001_139_Meta.xml�j", pe.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_140 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_140() throws Exception {

		String testCase = this.getName().substring(4);

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, e.getClass());
		IllegalArgumentException iae = (IllegalArgumentException) e;
		assertEquals(
				"Attribute 'parentflg' must be set on element 'datamodel'.",
				iae.getMessage());

//		Exception e = super.invokeCheckInitialLoaderException(testCase);
//		assertEquals(EMRException.class, e.getClass());
//		EMRException pe = (EMRException)e;
//		assertEquals(PCTMessageCode.P005E, pe.getErrCode());
//		assertEquals("XML�Ǘ��������ł��B�i�t�@�C�����FPILINI_E_001_140_Meta.xml�j", pe.getErrMessage());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_141 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_141() throws Exception {

		String testCase = this.getName().substring(4);

		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_142 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_142() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_143 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_143() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_144 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_144() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_145 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_145() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_146 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_146() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_147 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_147() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_148 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_148() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_149 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_149() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_150 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_150() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_151 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_151() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_152 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_152() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_153 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_153() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_154 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_154() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_155 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_155() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_156 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_156() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_157 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_157() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_158 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_158() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_159 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_159() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_160 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_160() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_161 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_161() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_162 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_162() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_163 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_163() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_164 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_164() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_165 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_165() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_166 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_166() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_167 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_167() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_168 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_168() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_169 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_169() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_170 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_170() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_171 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_171() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_172 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_172() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_173 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_173() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_174 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_174() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_175 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_175() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_176 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_176() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_178 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_178() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_179 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_179() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, ex.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_180 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_180() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, ex.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_181 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_181() throws Exception {

		String testCase = this.getName().substring(4);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, ex.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_182 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_182() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(EMRException.class, ex.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_183 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_183() throws Exception {

		String testCase = this.getName().substring(4);

		Exception ex = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(IllegalArgumentException.class, ex.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_184 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_184() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_185 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_185() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_186 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_186() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_187 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_187() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param1 = new ArrayList<String>();
		param1.add(testCase);
		param1.add(testCase);

		Map<String, Object> objMap1 = new HashMap<String, Object>();
		objMap1.put("var", Integer.MAX_VALUE);

		Exception e = super.invokeCheckEngineException(testCase, param1,
				objMap1);
		assertEquals(PEXUnExpectedStateException.class, e.getClass());
	}

	/**
	 * �e�X�gID�FPILINI_E_001_188 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_188() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}

	/**
	 * �e�X�gID�FPILINI_E_001_189 �C�j�V�������[�_�[�̃R���X�g���N�^�����җ�O��catch�����ʊm�F
	 */
	@Test
	public void testPILINI_E_001_189() throws Exception {

		String testCase = this.getName().substring(4);

		// �����ݒ�
		List<String> param = new ArrayList<String>();
		param.add(testCase);
		param.add(testCase);

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("var", Integer.MAX_VALUE);

		super.invokeCheckInitialLoaderException(testCase);
	}
}
