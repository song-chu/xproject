package jp.escofi.emr.engine.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import jp.co.dgic.testing.framework.DJUnitTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MessageUtilTest extends DJUnitTestCase {

	private Log logger = LogFactory.getLog(MessageUtilTest.class);

	/**
	 * �e�X�gID:PUTMes_N_001_1
	 */
	@Test
	public void testPUTMes_N_001_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P001E";
		String expected = "�����s���B�����Ώۂ̃f�[�^���f�������݂��܂���B(�f�[�^���f�����F{0}�j";
		logger.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_001_2
	 */
	@Test
	public void testPUTMes_N_001_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P999E";
		String expected = null;
		logger.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_001_3
	 */
	@Test
	public void testPUTMes_N_001_3() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = null;
		String expected = null;
		logger.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_001_4
	 */
	@Test
	public void testPUTMes_N_001_4() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "";
		String expected = null;
		logger.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_1
	 */
	@Test
	public void testPUTMes_N_002_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P001E";
		String parameter2 = "EBS�P�P�Q�Q�R�R";
		String expected = "�����s���B�����Ώۂ̃f�[�^���f�������݂��܂���B(�f�[�^���f�����F{0}�j";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_2
	 */
	@Test
	public void testPUTMes_N_002_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P001E";
		String parameter2 = null;
		String expected = "�����s���B�����Ώۂ̃f�[�^���f�������݂��܂���B(�f�[�^���f�����F{0}�j";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_3
	 */
	@Test
	public void testPUTMes_N_002_3() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P010E";
		String parameter2 = "";
		String expected = "�\�����ʏ�Ԃ��������܂����B";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_4
	 */
	@Test
	public void testPUTMes_N_002_4() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "E888";
		String parameter2 = "***defaultValue-aaa***";
		String expected = "***defaultValue-aaa***";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_5
	 */
	@Test
	public void testPUTMes_N_002_5() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = null;
		String parameter2 = "***defaultValue-bbb***";
		String expected = null;

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_6
	 */
	@Test
	public void testPUTMes_N_002_6() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "";
		String parameter2 = "***defaultValue-ccc***";
		String expected = "***defaultValue-ccc***";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_7
	 */
	@Test
	public void testPUTMes_N_002_7() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P777E";
		String parameter2 = "";
		String expected = "";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_002_8
	 */
	@Test
	public void testPUTMes_N_002_8() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P666E";
		String parameter2 = null;
		String expected = null;

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i���b�Z�[�W�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_003_1
	 **/
	@Test
	public void testPUTMes_N_003_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P011E";
		String[] parameter2 = { "���O" };
		String expected = "���O�������ł��B";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i�u�������̔z��j�F{'���O'}");

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_003_2
	 **/
	@Test
	public void testPUTMes_N_003_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P005E";
		Object[] parameter2 = { "XML�Ǘ��t�@�C��", "PUTMes_N_003_2_Meta.xml" };
		String expected = "XML�Ǘ��t�@�C���������ł��B�i�t�@�C�����FPUTMes_N_003_2_Meta.xml�j";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i�u�������̔z��j�F{ 'XML�Ǘ��t�@�C��', 'PUTMes_N_003_2_Meta.xml' }");

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_003_3
	 **/
	@Test
	public void testPUTMes_N_003_3() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = null;
		Object[] parameter2 = { "test.PUTMes_N_003_3.message" };
		String expected = null;

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i�u�������̔z��j�F{ 'test.PUTMes_N_003_3.message' }");

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_003_4
	 **/
	@Test
	public void testPUTMes_N_003_4() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P005E";
		Object[] parameter2 = { null, null };
		String expected = "null�������ł��B�i�t�@�C�����Fnull�j";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i�u�������̔z��j�F{ null, null }");

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_003_5
	 **/
	@Test
	public void testPUTMes_N_003_5() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "P011E";
		Object[] parameter2 = { "" };
		String expected = "�������ł��B";

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i�u�������̔z��j�F{ �󕶎� }");

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// ���ʊm�F
		logger.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_N_003_6
	 **/
	@Test
	public void testPUTMes_N_003_6() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter1 = "PEEEEE";
		Object[] parameter2 = { "�e�X�g���b�Z�[�W" };
		String expected = null;

		logger.info("���͒l�i���b�Z�[�W�̃L�[�j�F" + parameter1);
		logger.info("���͒l�i�u�������̔z��j�F{ '�e�X�g���b�Z�[�W' }");

		String result = MessageUtil.getMessage(parameter1, parameter2);

		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMes_E_001_1
	 **/
	@Test
	public void testPUTMes_E_001_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		super.setReturnValueAt(Properties.class, "load", 0, new IOException());

		Method loadMethod = MessageUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(MessageUtil.class);
	}

	/**
	 * �e�X�gID:PUTMes_E_001_2
	 **/
	@Test
	public void testPUTMes_E_001_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		super.setReturnValueAt(InputStream.class, "close", 0, new IOException());

		Method loadMethod = MessageUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(MessageUtil.class);
	}
}
