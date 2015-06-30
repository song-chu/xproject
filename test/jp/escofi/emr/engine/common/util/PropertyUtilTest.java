package jp.escofi.emr.engine.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import jp.escofi.emr.DJUnitTestCaseEx;

import org.junit.Test;

public class PropertyUtilTest extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	protected static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	public PropertyUtilTest() {

		super(PropertyUtilTest.class, BASE_FOLDER);
	}

	/**
	 * �e�X�gID:PUTPro_N_001_1
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_1() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "xml.meta.filepath";
		String expected = "Z:/PDSNgine/xml/XML_Meta.xml";
		super.log.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_001_2
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_2() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "xml.test.filepath";
		String expected = null;
		super.log.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_001_3
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_3() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = null;
		String expected = null;
		super.log.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_001_4
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_4() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "";
		String expected = null;
		super.log.info("���͒l�F" + parameter1);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_002_1
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_1() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "xml.meta.filepath";
		String parameter2 = "T:/TEST/xml/XML_Meta.xml";
		String expected = "Z:/PDSNgine/xml/XML_Meta.xml";
		super.log.info("���͒l�i�v���p�e�B�̃L�[�j�F" + parameter1);
		super.log.info("���͒l�i�v���p�e�B�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_002_2
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_2() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "xml.datamodel.base";
		String parameter2 = null;
		String expected = "Z:/PDSNgine/xml";
		super.log.info("���͒l�i�v���p�e�B�̃L�[�j�F" + parameter1);
		super.log.info("���͒l�i�v���p�e�B�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_002_3
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_3() throws Exception {

		String testCase = this.getName().substring(4);
		log.info("########## " + testCase + " ##########");

		// ���͒l�ݒ�
		String parameter1 = "xml.datamodel.base";
		String parameter2 = "";
		super.log.info("���͒l�i�v���p�e�B�̃L�[�j�F" + parameter1);
		super.log.info("���͒l�i�v���p�e�B�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// ���ʊm�F
		super.log.info("���ʒl�F" + BASE_FOLDER);
		assertEquals(BASE_FOLDER, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_002_4
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_4() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "xml.test.filepath";
		String parameter2 = "/ebs/test/DATA/ABC_1234.xml";
		String expected = "/ebs/test/DATA/ABC_1234.xml";
		super.log.info("���͒l�i�v���p�e�B�̃L�[�j�F" + parameter1);
		super.log.info("���͒l�i�v���p�e�B�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_002_5
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_5() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = null;
		String parameter2 = "/home/pdsuser/XMLs/TestData";
		String expected = null;
		super.log.info("���͒l�i�v���p�e�B�̃L�[�j�F" + parameter1);
		super.log.info("���͒l�i�v���p�e�B�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_N_002_6
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_6() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// ���͒l�ݒ�
		String parameter1 = "";
		String parameter2 = "/ebs/test/DATA/ABC_1234.xml";
		String expected = "/ebs/test/DATA/ABC_1234.xml";
		super.log.info("���͒l�i�v���p�e�B�̃L�[�j�F" + parameter1);
		super.log.info("���͒l�i�v���p�e�B�̃f�t�H���g�l�j�F" + parameter2);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// ���ʊm�F
		super.log.info("���ʒl�F" + expected);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTPro_E_001_1
	 * @throws Exception
	 **/
	@Test
	public void testPUTPro_E_001_1() throws Exception {

		String testCase = this.getName().substring(4);
		log.info("########## " + testCase + " ##########");

		super.setReturnValueAt(Properties.class, "load", 0, new IOException());

		Method loadMethod = PropertyUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(PropertyUtil.class);
	}

	/**
	 * �e�X�gID:PUTPro_E_001_2
	 * @throws Exception
	 **/
	@Test
	public void testPUTPro_E_001_2() throws Exception {

		String testCase = this.getName().substring(4);
		log.info("########## " + testCase + " ##########");

		super.setReturnValueAt(InputStream.class, "close", 0, new IOException());

		Method loadMethod = PropertyUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(PropertyUtil.class);
	}
}
