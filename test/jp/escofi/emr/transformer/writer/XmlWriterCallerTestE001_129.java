package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.iwin.pds.xml2db.datatable.TblArgsElem;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n129�`142�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_129 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_129 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_129() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblArgsElem elem = dbMapper.selectArgsElem(1);

			elem.setDatamodel_id(999);
			dbMapper.updateArgsElem(elem);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_130 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_130() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_129_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblArgsElem elem = dbMapper.selectArgsElem(1);

			elem.setArgs_field_en_name("");
			dbMapper.updateArgsElem(elem);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_131 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_131() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_132 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_132() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_133 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_133() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_134 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_134() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_135 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_135() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_136 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_136() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_129_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblArgsElem elem = dbMapper.selectArgsElem(1);

			elem.setAttribute_type_cd("99");
			dbMapper.updateArgsElem(elem);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_137 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_137() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_129_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblArgsElem elem = dbMapper.selectArgsElem(1);

			elem.setJava_class_cd("99");
			dbMapper.updateArgsElem(elem);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_138 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_138() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_139 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_139() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_140 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_140() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_141 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_141() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_142 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_142() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_129_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblArgsElem elem = dbMapper.selectArgsElem(1);

			elem.setDelete_flg(true);
			dbMapper.updateArgsElem(elem);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}


	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_129";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");


		return p;
	}

}
