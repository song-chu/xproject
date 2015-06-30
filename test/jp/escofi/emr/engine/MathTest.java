package jp.escofi.emr.engine;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.Status;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.escofi.emr.engine.condition.Rule;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSObjObject;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MathTest extends DJUnitTestCaseEx {

	/**
	 * Log�o��
	 */
	private static final Log logger =LogFactory.getLog(MathTest.class);
	/**
	 * XML�x�[�X�t�H���_
	 */
	private static final String BASE_FOLDER = "C:/FromSong/workspace/testdata/xml/math";

	/**
	 *
	 */
	public MathTest() {

		super(MathTest.class, BASE_FOLDER);
	}

	// ����n�e�X�g
	/**
	 * �e�X�gID�FPENSER-N-001-1
	 * @throws Exception ��O
	 */
	@Test
	public void testPENSER_N_001_1() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = response.getResultObject();
			// ���ʒl
			assertEquals("value001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-2
	 */
	@Test
	public void testPENSER_N_001_2() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_2");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-3
	 */
	@Test
	public void testPENSER_N_001_3() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_3");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("key4");
		parameter1.add("key5");
		parameter1.add("key6");
		parameter1.add("key7");
		parameter1.add("key8");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value003", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-4
	 */
	@Test
	public void testPENSER_N_001_4() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_4");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value004_1", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_4");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("value004_2", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-5
	 */
	@Test
	public void testPENSER_N_001_5() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_5");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value005_1", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_5");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard004", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-6
	 */
	@Test
	public void testPENSER_N_001_6() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_6");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value6_1", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_6");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom");

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("value6_2", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_6");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("value6_3", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-7
	 */
	@Test
	public void testPENSER_N_001_7() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_7");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attr1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value7_1", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_7");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_7");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-8
	 */
	@Test
	public void testPENSER_N_001_8() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_8");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals(true, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Boolean", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-9
	 */
	@Test
	public void testPENSER_N_001_9() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_9");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("008");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals(123456, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Integer", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-10
	 */
	@Test
	public void testPENSER_N_001_10() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_10");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			assertEquals(Long.parseLong("1234567890"), result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Long", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-11
	 */
	@Test
	public void testPENSER_N_001_11() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_11");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			assertEquals(Double.parseDouble("2.20"), result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-12
	 */
	@Test
	public void testPENSER_N_001_12() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_12");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			assertEquals(new BigDecimal("0.90"), result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-13
	 */
	@Test
	public void testPENSER_N_001_13() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_13");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			List<String> kekkachi = new ArrayList<String>();
			kekkachi.add("value013_1");
			kekkachi.add("value013_2");
			kekkachi.add("value013_3");
			kekkachi.add("value013_4");
			kekkachi.add("value013_5");

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("list", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-14
	 */
	@Test
	public void testPENSER_N_001_14() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_14");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			List<Boolean> kekkachi = new ArrayList<Boolean>();
			kekkachi.add(true);
			kekkachi.add(false);

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("list", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Boolean", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-15
	 */
	@Test
	public void testPENSER_N_001_15() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_15");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("006");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			List<Integer> kekkachi = new ArrayList<Integer>();
			kekkachi.add(112233);
			kekkachi.add(223344);
			kekkachi.add(334455);
			kekkachi.add(445566);
			kekkachi.add(556677);

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("list", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Integer", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-16
	 */
	@Test
	public void testPENSER_N_001_16() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_16");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			List<Long> kekkachi = new ArrayList<Long>();
			kekkachi.add(new Long(1111111111));
			kekkachi.add(new Long(1222222222));
			kekkachi.add(new Long(1444444444));
			kekkachi.add(new Long(1888888888));
			kekkachi.add(new Long(2147483647));

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("list", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Long", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-17
	 */
	@Test
	public void testPENSER_N_001_17() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_17");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			List<Double> kekkachi = new ArrayList<Double>();
			kekkachi.add(new Double(1.10));
			kekkachi.add(new Double(2.20));
			kekkachi.add(new Double(3.30));
			kekkachi.add(new Double(4.40));
			kekkachi.add(new Double(5.50));

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("list", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-18
	 */
	@Test
	public void testPENSER_N_001_18() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_18");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			List<BigDecimal> kekkachi = new ArrayList<BigDecimal>();
			kekkachi.add(new BigDecimal("0.10"));
			kekkachi.add(new BigDecimal("0.20"));
			kekkachi.add(new BigDecimal("0.40"));
			kekkachi.add(new BigDecimal("0.80"));
			kekkachi.add(new BigDecimal("0.90"));

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("list", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-19
	 */
	@Test
	public void testPENSER_N_001_19() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_19");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			Map<String, String> kekkachi = new TreeMap<String, String>();
			kekkachi.put("key019_1", "value019_1");
			kekkachi.put("key019_2", "value019_2");
			kekkachi.put("key019_3", "value019_3");
			kekkachi.put("key019_4", "value019_4");
			kekkachi.put("key019_5", "value019_5");

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("map", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-20
	 */
	@Test
	public void testPENSER_N_001_20() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_20");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			Map<String, Boolean> kekkachi = new TreeMap<String, Boolean>();
			kekkachi.put("key020_1", true);
			kekkachi.put("key020_2", false);

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("map", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Boolean", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-21
	 */
	@Test
	public void testPENSER_N_001_21() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_21");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			Map<String, Integer> kekkachi = new TreeMap<String, Integer>();
			kekkachi.put("key021_1", 111222);
			kekkachi.put("key021_2", 333444);
			kekkachi.put("key021_3", 555666);
			kekkachi.put("key021_4", 777888);
			kekkachi.put("key021_5", 999000);

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("map", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Integer", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-22
	 */
	@Test
	public void testPENSER_N_001_22() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_22");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			Map<String, Long> kekkachi = new TreeMap<String, Long>();
			kekkachi.put("key022_1", new Long(2147403647));
			kekkachi.put("key022_2", new Long(2147083647));
			kekkachi.put("key022_3", new Long(2140483647));
			kekkachi.put("key022_4", new Long(2107483647));
			kekkachi.put("key022_5", new Long(2147483647));

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("map", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Long", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-23
	 */
	@Test
	public void testPENSER_N_001_23() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_23");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("015");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			Map<String, Double> kekkachi = new TreeMap<String, Double>();
			kekkachi.put("key023_1", 1.20);
			kekkachi.put("key023_2", 2.40);
			kekkachi.put("key023_3", 3.60);
			kekkachi.put("key023_4", 4.80);
			kekkachi.put("key023_5", 5.00);

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("map", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-24
	 */
	@Test
	public void testPENSER_N_001_24() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_24");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			Map<String, BigDecimal> kekkachi = new TreeMap<String, BigDecimal>();
			kekkachi.put("key024_1", new BigDecimal("0.11"));
			kekkachi.put("key024_2", new BigDecimal("0.22"));
			kekkachi.put("key024_3", new BigDecimal("0.44"));
			kekkachi.put("key024_4", new BigDecimal("0.88"));
			kekkachi.put("key024_5", new BigDecimal("0.99"));

			assertEquals(kekkachi, result.getValue());
			// �f�[�^�^�m�F
			assertEquals("map", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-25
	 */
	@Test
	public void testPENSER_N_001_25() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_25");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject()
					.getValue();
			// ����l�m�F
			assertEquals("��", range.getUpper());
			// �����l�m�F
			assertEquals("��", range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-26
	 */
	@Test
	public void testPENSER_N_001_26() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_26");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�m�F
			PDSObjObject obj = (PDSObjObject) response.getResultObject()
					.getValue();
			// ���s�I�u�W�F�N�g���m�F
			assertEquals("TestCace026", obj.getClassName());
			// �t�я��m�F
			assertEquals(Arrays.asList("attached026"), obj.getAttachedInfo());

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("object", result.getDataType());
			// Java�f�[�^�^
			assertEquals(null, result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-27
	 */
	@Test
	public void testPENSER_N_001_27() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_27");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());
			// �������ڎ擾�p�}�b�v�m�F
			assertEquals(
					"ConditionItem027=jp.escofi.emr.engine.search.ConditionItemInfo",
					response.getConditionItemInfoMap().toString().substring(1,
							63));
			// �������ڒl�}�b�v�m�F
			assertEquals(null, response.getConditionItemValueMap());
			// �������L���m�F
			assertEquals(true, response.isCondition());
			// ���^���m�F
			assertEquals("", response.getMetaInfo());

			// ���ʒl�擾
			Object kekkachi = response.getResultObject().getValue();
			boolean flag = false;
			if (kekkachi instanceof Rule) {
				flag = true;
			}
			assertEquals(true, kekkachi instanceof Rule);
			// �N���X�^�m�F
			assertEquals(flag, true);

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("other", result.getDataType());
			// Java�f�[�^�^
			assertEquals(null, result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-28
	 */
	@Test
	public void testPENSER_N_001_28() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_28");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("006");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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
			assertEquals("1001", response.getMetaInfo());

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			assertEquals("value028", response.getResultObject().getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("1001", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-29
	 */
	@Test
	public void testPENSER_N_001_29() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_29");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname2");
		parameter1.add("007");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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
			assertEquals("1002", response.getMetaInfo());

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			assertEquals("value029", response.getResultObject().getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("1002", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-30
	 */
	@Test
	public void testPENSER_N_001_30() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_30");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.ATTR_NOT_FOUND, response.getStatus());
			// �������ڎ擾�p�}�b�v�m�F
			assertEquals(null, response.getConditionItemInfoMap());
			// �������ڒl�}�b�v�m�F
			assertEquals(null, response.getConditionItemValueMap());
			// �������L���m�F
			assertEquals(false, response.isCondition());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-31
	 */
	@Test
	public void testPENSER_N_001_31() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_31");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("000");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.TREEMAP_KEY_NOT_FOUND, response.getStatus());
			// �������ڎ擾�p�}�b�v�m�F
			assertEquals(null, response.getConditionItemInfoMap());
			// �������ڒl�}�b�v�m�F
			assertEquals(null, response.getConditionItemValueMap());
			// �������L���m�F
			assertEquals(false, response.isCondition());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-32
	 */
	@Test
	public void testPENSER_N_001_32() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_32");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("005");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.DELETED, response.getStatus());
			// �������ڎ擾�p�}�b�v�m�F
			assertEquals(null, response.getConditionItemInfoMap());
			// �������ڒl�}�b�v�m�F
			assertEquals(null, response.getConditionItemValueMap());
			// �������L���m�F
			assertEquals(false, response.isCondition());
			// ���^���m�F
			assertEquals("", response.getMetaInfo());

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();

			// ���ʒl
			assertEquals(null, response.getResultObject().getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals(null, result.getJavaDataType());
			// �폜�t���O
			assertEquals(true, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-33
	 */
	@Test
	public void testPENSER_N_001_33() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_33");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value033_1", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_33");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-34
	 */
	@Test
	public void testPENSER_N_001_34() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_34");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_34");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-35
	 */
	@Test
	public void testPENSER_N_001_35() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_35");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value035_2", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_35");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("value035_1", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-36
	 */
	@Test
	public void testPENSER_N_001_36() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_36");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_36");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-37
	 */
	@Test
	public void testPENSER_N_001_37() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_37");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value037_3", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_37");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-38
	 */
	@Test
	public void testPENSER_N_001_38() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_38");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("common001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_38");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-39
	 */
	@Test
	public void testPENSER_N_001_39() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_39");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value039_2", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_39");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-40
	 */
	@Test
	public void testPENSER_N_001_40() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_40");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value040_3", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_40");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-41
	 */
	@Test
	public void testPENSER_N_001_41() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_41");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofcom");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("common001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_41");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofcom2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-42
	 */
	@Test
	public void testPENSER_N_001_42() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_42");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("key3");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_42");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("key3");
			parameter1.add("attrofstd2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-43
	 */
	@Test
	public void testPENSER_N_001_43() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_43");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("004");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("value043_2", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_43");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("008");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-44
	 */
	@Test
	public void testPENSER_N_001_44() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_44");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_44");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");
			parameter1.add("001");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-45
	 */
	@Test
	public void testPENSER_N_001_45() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_45");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("common001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_45");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("001");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-46
	 */
	@Test
	public void testPENSER_N_001_46() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_46");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_46");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");
			parameter1.add("001");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-47
	 */
	@Test
	public void testPENSER_N_001_47() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_47");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("common001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_47");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("001");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-48
	 */
	@Test
	public void testPENSER_N_001_48() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_48");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofcom");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("common001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_48");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofcom2");
			parameter1.add("001");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("common002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-49
	 */
	@Test
	public void testPENSER_N_001_49() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_49");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_49");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");
			parameter1.add("001");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-50
	 */
	@Test
	public void testPENSER_N_001_50() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_50");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			ResultObject result = (ResultObject) response
					.getResultObject();
			// ���ʒl
			assertEquals("standard001", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

			// �����ݒ�
			parameter1 = new ArrayList<String>();
			parameter1.add("PENSER_N_001_50");
			parameter1.add("key1");
			parameter1.add("key2");
			parameter1.add("attrofstd2");

			// �������ڎ擾����
			response = PDSServiceAPI.getConditionItems(parameter1);

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

			// �����l�擾
			result = (ResultObject) response.getResultObject();
			// ���ʒl
			assertEquals("standard002", result.getValue());
			// �f�[�^�^�m�F
			assertEquals("single", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());
			// �폜�t���O
			assertEquals(false, result.isDeleted());
			// ���^���m�F
			assertEquals("", result.getMetaInfo());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-51
	 */
	@Test
	public void testPENSER_N_001_51() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_51");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		// �������ڎ擾����
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

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

		// �����l�擾
		ResultObject result = (ResultObject) response.getResultObject();
		// ���ʒl
		assertEquals("standard001", result.getValue());
		// �f�[�^�^�m�F
		assertEquals("single", result.getDataType());
		// Java�f�[�^�^
		assertEquals("java.lang.String", result.getJavaDataType());
		// �폜�t���O
		assertEquals(false, result.isDeleted());
		// ���^���m�F
		assertEquals("", result.getMetaInfo());

		result.getDataType();
		result.getJavaDataType();

		// �����ݒ�
		parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_51");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrofstd2");

		// �������ڎ擾����
		response = PDSServiceAPI.getConditionItems(parameter1);

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

		// �����l�擾
		result = (ResultObject) response.getResultObject();
		// ���ʒl
		assertEquals("standard002", result.getValue());
		// �f�[�^�^�m�F
		assertEquals("single", result.getDataType());
		// Java�f�[�^�^
		assertEquals("java.lang.String", result.getJavaDataType());
		// �폜�t���O
		assertEquals(false, result.isDeleted());
		// ���^���m�F
		assertEquals("", result.getMetaInfo());

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �����L�[�ݒ聨�������{���������ڒl�ݒ聨����������{
	 *
	 * @param dataModelName
	 *            �f�[�^���f����(�e�X�g�P�[�XID)
	 * @param vars
	 *            �������ږ�=�������ڒl
	 * @return PDS�����N���X
	 * @throws InitializeException
	 * @throws UnExpectedStateException
	 * @throws InvalidKeyException
	 * @throws ConditionNotMatchedException
	 */
	@SuppressWarnings("unused")
	public void testPENSER_N_001_52() throws Exception {

		Map<String, Object> objMap = new HashMap<String, Object>();

		Set<Integer> varSet1 = new HashSet<Integer>();
		varSet1.add(1);
		varSet1.add(3);
		varSet1.add(5);
		varSet1.add(7);
		varSet1.add(9);

		objMap.put("var1", varSet1);

		// ----------------------<<���͒l�ݒ�>>-------------------------------//
		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add("PENSER_N_001_52"); // �C���|�C���g
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		// �������ڎ擾����
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res.getConditionItemInfoMap();

		// �������ڒlMap
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();

		String itemName = null; // �������ږ�
		String itemType = null; // �������ڃf�[�^�^
		String javaDataType = null; // �������ړ����f�[�^�^
		List<String> searchInfo = null; // �������ڎ擾���

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		for (ConditionItemInfo conditionItemInfo : collection) {

			// �������ڃN���X��������擾����B
			itemName = conditionItemInfo.getItemName();
			itemType = conditionItemInfo.getItemType();
			javaDataType = conditionItemInfo.getJavaDataType();
			searchInfo = conditionItemInfo.getSearchInfo();

			Object var = null;
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

		// PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
		res.setConditionItemValueMap(conditionItemValueMap);

		// �����l�擾���\�b�h���Ăяo���B
		PDSServiceAPI.getAttrValue(res);

		// ----------------------<< ���ʊm�F >>-----------------------//
		// �X�e�[�^�X�m�F
		assertEquals(Status.NORMAL, res.getStatus());
		// �������L���m�F
		assertEquals(true, res.isCondition());
		// ���^���m�F
		assertEquals("", res.getMetaInfo());

		// ���ʊm�F
		assertEquals(true, res.getResultObject().getValue());
		// �����l�擾
		ResultObject result = (ResultObject) res.getResultObject();
		// �f�[�^�^�m�F
		assertEquals("single", result.getDataType());
		// Java�f�[�^�^
		assertEquals("java.lang.Boolean", result.getJavaDataType());
		// �폜�t���O
		assertEquals(false, result.isDeleted());
		// ���^���m�F
		assertEquals("", result.getMetaInfo());

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-53
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����i������j
	 * XML�ݒ�F<upper>�ɂ͗L���l�A<lower>�ɂ͋󕶎�
	 */
	public void testPENSER_N_001_53() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_53");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(true, range.hasUpper());
			// �����l�L���t���O
			assertEquals(false, range.hasLower());
			// ����l�m�F
			assertEquals("AAA", range.getUpper());
			// �����l�m�F
			assertEquals(null, range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.lang.String", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-54
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����i������j
	 * XML�ݒ�F<upper>�ɂ͋󕶎��A<lower>�ɂ͗L���l
	 */
	public void testPENSER_N_001_54() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_54");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(false, range.hasUpper());
			// �����l�L���t���O
			assertEquals(true, range.hasLower());
			// ����l�m�F
			assertEquals(null, range.getUpper());
			// �����l�m�F
			assertEquals("ABC", range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.lang.String", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-55
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����i������j
	 * XML�ݒ�F<upper>�A<lower>�ɋ󕶎�
	 */
	public void testPENSER_N_001_55() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_55");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(false, range.hasUpper());
			// �����l�L���t���O
			assertEquals(false, range.hasLower());
			// ����l�m�F
			assertEquals(null, range.getUpper());
			// �����l�m�F
			assertEquals(null, range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.lang.String", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.String", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-56
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����i���l�^�j
	 * XML�ݒ�F<upper>�ɂ͗L���l�A<lower>�ɂ͋󕶎�
	 */
	public void testPENSER_N_001_56() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_56");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(true, range.hasUpper());
			// �����l�L���t���O
			assertEquals(false, range.hasLower());
			// ����l�m�F
			assertEquals(Double.valueOf("3214567890123456789.88000e-326"), range.getUpper());
			// �����l�m�F
			assertEquals(null, range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-57
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����i���l�^�j
	 * �����̂�
	 */
	public void testPENSER_N_001_57() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_57");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(false, range.hasUpper());
			// �����l�L���t���O
			assertEquals(true, range.hasLower());
			// ����l�m�F
			assertEquals(null, range.getUpper());
			// �����l�m�F
			assertEquals(Double.valueOf("3214567890123456789.88000e-326"), range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-58
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����i���l�^�j
	 * ��������Ȃ�
	 */
	public void testPENSER_N_001_58() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_58");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(false, range.hasUpper());
			// �����l�L���t���O
			assertEquals(false, range.hasLower());
			// ����l�m�F
			assertEquals(null, range.getUpper());
			// �����l�m�F
			assertEquals(null, range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.lang.Double", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-59
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����iBigDecimal�j
	 * XML�ݒ�F<upper>�ɂ͗L���l�A<lower>�ɂ͋󕶎�
	 */
	public void testPENSER_N_001_59() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_59");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(true, range.hasUpper());
			// �����l�L���t���O
			assertEquals(false, range.hasLower());
			// ����l�m�F
			assertEquals(new BigDecimal("-4.2612892558531226012E+311"), range.getUpper());
			// �����l�m�F
			assertEquals(null, range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-60
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����iBigDecimal�j
	 * �����̂�
	 */
	public void testPENSER_N_001_60() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_60");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(false, range.hasUpper());
			// �����l�L���t���O
			assertEquals(true, range.hasLower());
			// ����l�m�F
			assertEquals(null, range.getUpper());
			// �����l�m�F
			assertEquals(new BigDecimal("-4.2612892558531226012E+311"), range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-001-61
	 * �ΏہFgetConditionItems�i�������ڎ擾�����j
	 * �͈͌^�I�u�W�F�N�g�ɂď��/�����iBigDecimal�j
	 * ��������Ȃ�
	 */
	public void testPENSER_N_001_61() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_61");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�m�F
			RangeObject range = (RangeObject) response.getResultObject().getValue();
			// ����l�L���t���O
			assertEquals(false, range.hasUpper());
			// �����l�L���t���O
			assertEquals(false, range.hasLower());
			// ����l�m�F
			assertEquals(null, range.getUpper());
			// �����l�m�F
			assertEquals(null, range.getLower());
			// ����l�܂ރt���O�m�F
			assertEquals(true, range.includeUpper());
			// �����l�܂ރt���O�m�F
			assertEquals(true, range.includeLower());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", range.getJavaDataType());

			// �����l�擾
			ResultObject result = (ResultObject) response.getResultObject();
			// �f�[�^�^�m�F
			assertEquals("range", result.getDataType());
			// Java�f�[�^�^
			assertEquals("java.math.BigDecimal", result.getJavaDataType());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

		// �_���v���s
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, super.getName()
					.substring(4));
		}
	}

	/**
	 * �e�X�gID�FPENSER-N-002-1
	 */
	@Test
	public void testPENSER_N_002_1() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_1");

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		// �_���v���s
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENSER_N_001_1");
	}

	/**
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&& &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& [
	 * �ُ�n�e�X�g ] &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&
	 */

	/**
	 * �e�X�gID�FPENSER_E_001_1
	 */
	@Test
	public void testPENSER_E_001_1() throws Exception {

		try {
			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P008E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_2_1
	 */
	@Test
	public void testPENSER_E_001_2_1() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		addReturnNull("PILInitialLoader", "getPDSObject");
		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_2_2
	 */
	@Test
	public void testPENSER_E_001_2_2() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		addReturnValue("PILInitialLoader", "getPDSObject",
				new HashMap<String, Object>());
		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E-001_2_3
	 */
	@Test
	public void testPENSER_E_001_2_3() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		addReturnNull("PILInitialLoader", "getPDSItemKeys");
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_2_4
	 */
	@Test
	public void testPENSER_E_001_2_4() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		addReturnValue("PILInitialLoader", "getPDSItemKeys",
				new HashMap<String, Object>());
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_N_001_2");

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P006E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_3
	 */
	@Test
	public void testPENSER_E_001_3() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_3");
		parameter1.add("attr1");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P014E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_4
	 */
	@Test
	public void testPENSER_E_001_4() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_4");
		parameter1.add("attr1");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));
		setReturnValueAt("Map", "get", 2, new ArrayList<String>());

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);

			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P010E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E-001_5_1
	 */
	@Test
	public void testPENSER_E_001_5_1() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(null);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P011E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E-001_5_2
	 */
	@Test
	public void testPENSER_E_001_5_2() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P011E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_6
	 */
	@Test
	public void testPENSER_E_001_6() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_6");
		parameter1.add("a");
		parameter1.add("b");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P003E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_7
	 */
	@Test
	public void testPENSER_E_001_7() throws Exception {

		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("notfound");
		parameter1.add("notfound");
		parameter1.add("notfound");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P001E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_8
	 */
	@Test
	public void testPENSER_E_001_8() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_8");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P002E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_9
	 */
	@Test
	public void testPENSER_E_001_9() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_10
	 */
	@Test
	public void testPENSER_E_001_10() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_10");
		parameter1.add("attr");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);

			fail();
		} catch (InitializeException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_11
	 */
	@Test
	public void testPENSER_E_001_11() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProperty("xml.meta.filepath", "Z:/notfound.xml");

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_12
	 */
	@Test
	public void testPENSER_E_001_12() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_13
	 */
	@Test
	public void testPENSER_E_001_13() throws Exception {

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));
		setReturnValueAtAllTimes("DocumentBuilder", "parse", new IOException());

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(new ArrayList<String>());
			fail();
		} catch (InitializeException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P009E, e.getErrCode());
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_14
	 */
	@Test
	public void testPENSER_E_001_14() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_8");
		parameter1.add("attr1");
		parameter1.add("001");

		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_E_001_8");

		try {
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			PDSServiceAPI.getConditionItems(parameter1);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P002E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_15
	 * �Ώ�:getConditionItems(�������ڎ擾����)
	 * PDS�����N���X�̕ύX�s���ڂɂ��ĕύX�������B
	 * �������ڎ擾�pMap
	 */
	@Test
	public void testPENSER_E_001_15() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_15");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �������ڎ擾�pMap
			Map<String, ConditionItemInfo> map = response.getConditionItemInfoMap();

			//�}�b�v�ύX
			map.put("testKey", new ConditionItemInfo("", "", "", new ArrayList<String>()));
			fail();

		} catch (UnsupportedOperationException e) {
			// ���ʊm�F
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_16
	 * �Ώ�:getConditionItems(�������ڎ擾����)
	 * PDS�����N���X�̕ύX�s���ڂɂ��ĕύX�������B
	 * �������ڏ��̈������ڎ擾���
	 */
	@Test
	public void testPENSER_E_001_16() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_16");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �������ڎ擾�pMap
			Map<String, ConditionItemInfo> map = response.getConditionItemInfoMap();

			// �������ڏ��
			ConditionItemInfo itemInfo = map.get("var1");

			// �������ڎ擾���
			List<String> list = itemInfo.getSearchInfo();

			// �������ڎ擾����ύX
			list.add("test1");
			fail();

		} catch (UnsupportedOperationException e) {
			// ���ʊm�F
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_17
	 * �Ώ�:getConditionItems(�������ڎ擾����)
	 * PDS�����N���X�̕ύX�s���ڂɂ��ĕύX�������B
	 * �����l�I�u�W�F�N�g�̃��X�g
	 */
	@Test
	public void testPENSER_E_001_17() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_17");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�I�u�W�F�N�g�擾
			ResultObject result = response.getResultObject();

			// ���X�g�擾
			List<String> list = (List<String>)result.getValue();

			// ���X�g�ύX
			list.add("test");
			fail();

		} catch (UnsupportedOperationException e) {
			// ���ʊm�F
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_18
	 * �Ώ�:getConditionItems(�������ڎ擾����)
	 * PDS�����N���X�̕ύX�s���ڂɂ��ĕύX�������B
	 * �����l�I�u�W�F�N�g��Map
	 */
	@Test
	public void testPENSER_E_001_18() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_18");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�I�u�W�F�N�g�擾
			ResultObject result = response.getResultObject();

			// �}�b�v�擾
			Map<String, String> map = (Map<String, String>)result.getValue();

			// �}�b�v�ύX
			map.put("key", "value");
			fail();

		} catch (UnsupportedOperationException e) {
			// ���ʊm�F
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_001_19
	 * �Ώ�:getConditionItems(�������ڎ擾����)
	 * PDS�����N���X�̕ύX�s���ڂɂ��ĕύX�������B
	 * �I�u�W�F�N�g�^���̕t�я��
	 */
	@Test
	public void testPENSER_E_001_19() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_001_19");
		parameter1.add("key1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4));

			// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ----------------------<<���ʊm�F>>-------------------------------//
			// �X�e�[�^�X�m�F
			assertEquals(Status.NORMAL, response.getStatus());

			// �����l�I�u�W�F�N�g�擾
			ResultObject result = response.getResultObject();

			// �I�u�W�F�N�g�^�I�u�W�F�N�g�擾
			PDSObjObject obj = (PDSObjObject)result.getValue();

			// �t�я��擾
			List<String> list = obj.getAttachedInfo();

			// �t�я��ύX
			list.add("test");
			fail();

		} catch (UnsupportedOperationException e) {
			// ���ʊm�F
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_002_1
	 */
	@Test
	public void testPENSER_E_002_1() throws Exception {

		try {
			PDSServiceAPI.getAttrValue(null);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P008E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_002_2
	 */
	@Test
	public void testPENSER_E_002_2() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_001_1");
		parameter1.add("attrname1");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_1");

			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			response = null;

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (InitializeException e) {
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P011E, e.getErrCode());
		} catch (UnExpectedStateException e) {
			fail();
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_002_3
	 */
	@Test
	public void testPENSER_E_002_3() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_2");

			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			addReturnValue("Rule", "apply",
					new ConditionNotMatchedException(MessageCode.EMR_A_P007E));

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (ConditionNotMatchedException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P007E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_002_4
	 */
	@Test
	public void testPENSER_E_002_4() throws Exception {

		// �����ݒ�
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_2");

			// �C�j�V�������[�h�����s����B
			PDSEngine.getInstance();

			// �������ڎ擾����
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			addReturnValue("Rule", "apply", new RuntimeException());

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (ConditionNotMatchedException e) {
			fail();
		} catch (InvalidKeyException e) {
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P010E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER_E_003_1
	 */
	@Test
	public void testPENSER_E_003_1() throws Exception {

		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENSER_E_003_1");
			fail();
		} catch (UnExpectedStateException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P008E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER-E-003-2
	 */
	@Test
	public void testPENSER_E_003_2() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
			// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "xxx");
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P015E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER-E-003-3
	 */
	@Test
	public void testPENSER_E_003_3() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4));
		setReturnValueAtAllTimes("ObjectWriter", "objectWrite",
				new IOException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
			// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENSER_E_003_3");
			fail();
		} catch (DumpException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P016E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENSER-E-003-4
	 */
	@Test
	public void testPENSER_E_003_4() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(super.getName().substring(4), "PENSER_E_003_3");

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
			// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, null);
			fail();
		} catch (InvalidKeyException e) {
			// ���ʊm�F
			assertEquals(MessageCode.EMR_A_P015E, e.getErrCode());
		} catch (Exception e) {
			fail();
		}
	}
}
