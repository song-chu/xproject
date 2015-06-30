package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.iwin.pds.xml2db.datatable.TblArgsElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n027�`036�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_027 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_27 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_27() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var1</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>1</result></if>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_28 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_28() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var1</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result></result></if></condition>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_29 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_29() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var1</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>a</result></if></condition>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_30 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_30() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var1</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>99999999999999999</result></if></condition>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_31 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_31() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var1</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>999</result></if></condition>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_32 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_32() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue value = dbMapper.selectAttValue(1);

			value.setAttribute_value_id(2);
			dbMapper.insertAttValue(value);

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
	 * �e�X�gID�FPXWXML_E_001_33 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_33() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var></var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>1</result></if></condition>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_34 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_34() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>" +
					"123456789012345678901234567890123456789012345678901234567890" +
					"12345678901234567890123456789012345678901234567890</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>1</result></if></condition>");
			dbMapper.updateAttField(field);

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
			assertEquals(MessageCode.EMR_B_P909E, e.getErrCode());
			assertEquals("XML�t�@�C���o�͏�����SQL�G���[���������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_35 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_35() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var99</var>" +
					"<var>var2</var></eq></apply><apply><eq><var>var3</var><var>var4</var>" +
					"</eq></apply></and></apply><result>1</result></if></condition>");
			dbMapper.updateAttField(field);

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
	 * �e�X�gID�FPXWXML_E_001_36 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_36() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblArgsElem ae = dbMapper.selectArgsElem(1);

			ae.setArgs_elem_id(5);
			dbMapper.insertArgsElem(ae);

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


	private Properties createProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_27_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");


		return p;
	}

}
