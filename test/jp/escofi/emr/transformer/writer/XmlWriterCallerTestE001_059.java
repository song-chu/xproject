package jp.escofi.emr.transformer.writer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n059�`068�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_059 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_59 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_59() throws Exception {
		File confOrg = Resources.getResourceAsFile(PDSConstants.CONF_MY_BATIS.toString());
		File confTmp = new File(confOrg.getAbsolutePath() + ".test");

		confOrg.renameTo(confTmp);

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�Fconfiguration.xml)",
					e.getMessage());
		} finally {
			confTmp.renameTo(confOrg);
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_60 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_60() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_61 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_61() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_62 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_62() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_63 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_63() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_64 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_64() throws Exception {
		try {
			execErrMapper();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_65 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_65() throws Exception {
		try {
			execErrMapper();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_66 �^�p�c�[���ُ�n
	 * ���ʂ͖ڎ��m�F
	 */
//	@Test
//	public void testPXWXML_E_001_66() throws Exception {
//		try {
//			execErrMapper();
//		} catch (EMRException e) {
//			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
//			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
//					e.getMessage());
//		}
//	}

	@Test
	public void testPXWXML_E_001_66() throws Exception {
		File testOrg = null;
		File testTmp = null;
		try {
			Properties p = createProperties();

			// DB�f�[�^����
			initDB(p);

			// ��ƃf�B���N�g��
			createOutputDir();

			// execErrMapper()
			String testFileName = "sqlDatamodel.xml";
			File confOrg = Resources.getResourceAsFile(
					PDSConstants.CONF_MY_BATIS.toString());
			testOrg = new File(confOrg.getParentFile(), testFileName);

			String orgPath = testOrg.getAbsolutePath();
			testTmp = new File(orgPath + ".test");
			File test = new File("Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_060/" +
					getTestcaseID() + testFileName);

			testOrg.renameTo(testTmp);
			copyFile(test, testOrg);

			// �^�p�c�[�����s
			execXmlWriter();
		} finally {
			if (testOrg.exists()) {
				testOrg.delete();
			}
			testTmp.renameTo(testOrg);
		}
	}



	/**
	 * �e�X�gID�FPXWXML_E_001_67 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_67() throws Exception {
		String testFileName = "sqlProduct.xml";
		File confOrg = Resources.getResourceAsFile(
				PDSConstants.CONF_MY_BATIS.toString());
		File testOrg = new File(confOrg.getParentFile(), testFileName);

		try {
			execErr(testFileName, testOrg);
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_68 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_68() throws Exception {
		try {
			execErrMapper();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}


	/**
	 * ��ƃt�@�C���R�s�[�B
	 *
	 * @param from �R�s�[��
	 * @param to �R�s�[��
	 * @throws IOException �R�s�[���s
	 */
	private void copyFile(File from, File to) throws IOException {
//		CharBuffer buff = CharBuffer.allocate(10);
		FileReader reader = null;
		FileWriter writer = null;

		try {
			reader = new FileReader(from);
			writer = new FileWriter(to);

			int c;

			while ((c = reader.read()) != -1) {
				writer.write(c);
			}

//			while (reader.ready()) {
//				reader.read(buff);
//				writer.append(buff);
//				buff.clear();
//			}
		} finally {

			if (reader != null) {
				reader.close();
			}

			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * configuration.xml�ُ�n�e�X�g�B
	 *
	 * @throws IOException �t�@�C�����o�̓G���[
	 */
	private void execErrConf() throws IOException, EMRException {
		String confName = PDSConstants.CONF_MY_BATIS.toString();
		File confOrg = Resources.getResourceAsFile(confName);

		execErr(confName, confOrg);
	}

	/**
	 * mapper.xml�ُ�n�e�X�g�B
	 *
	 * @throws IOException �t�@�C�����o�̓G���[
	 */
	private void execErrMapper() throws IOException, EMRException {
		String testFileName = "sqlDatamodel.xml";
		File confOrg = Resources.getResourceAsFile(
				PDSConstants.CONF_MY_BATIS.toString());
		File testOrg = new File(confOrg.getParentFile(), testFileName);

		execErr(testFileName, testOrg);
	}

	/**
	 * �ݒ�t�@�C���ُ�n�e�X�g
	 *
	 * @param testFileName �e�X�g�Ώېݒ�t�@�C��
	 * @param testOrg �e�X�g�Ώی��t�@�C��
	 * @throws IOException �t�@�C�����o�̓G���[
	 */
	private void execErr(String testFileName, File testOrg) throws IOException, EMRException{
		String orgPath = testOrg.getAbsolutePath();
		File testTmp = new File(orgPath + ".test");
		File test = new File("Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_060/" +
				getTestcaseID() + testFileName);

		testOrg.renameTo(testTmp);
		copyFile(test, testOrg);

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} finally {
			if (testOrg.exists()) {
				testOrg.delete();
			}
			testTmp.renameTo(testOrg);
		}
	}

	private Properties createProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_27_Meta.xml");

		return p;
	}
}
