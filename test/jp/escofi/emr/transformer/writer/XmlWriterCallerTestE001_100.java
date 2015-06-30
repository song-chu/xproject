package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.datatable.TblAttributeElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n100�`128�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_100 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_100 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_100() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeElem elem = dbMapper.selectAttElem(1);

			elem.setDatamodel_id(999);
			dbMapper.updateAttElem(elem);

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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_101 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_101() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_102 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_102() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_103 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_103() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_104 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_104() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_105 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_105() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_106 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_106() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_107 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_107() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeElem elem = dbMapper.selectAttElem(1);

			elem.setAttribute_type_cd("99");
			dbMapper.updateAttElem(elem);

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
	 * �e�X�gID�FPXWXML_E_001_108 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_108() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeElem elem = dbMapper.selectAttElem(1);

			elem.setJava_class_cd("99");
			dbMapper.updateAttElem(elem);

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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_109 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_109() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeElem elem = dbMapper.selectAttElem(1);

			elem.setProduct_id(999);
			dbMapper.updateAttElem(elem);

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
		execXmlWriter();

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_110 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_110() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_109_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setDatamodel_en_name(getTestcaseID());
			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeElem elem = dbMapper.selectAttElem(1);

			elem.setDelete_flg(true);
			dbMapper.updateAttElem(elem);

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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_111 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_111() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(2);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeField field = dbMapper.selectAttField(2);

			field.setAttribute_group_id(999);
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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_112 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_112() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_111_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(2);

			datamodel.setXml_name("PXWXML_E_001_111" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeField field = dbMapper.selectAttField(2);

			field.setAttribute_elem_id(999);
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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_111_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_113 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_113() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_114 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_114() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_115 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_115() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_116 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_116() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_117 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_117() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setFrom_key_value("001");
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
		execXmlWriter();

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_118 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_118() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_119 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_119() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_100_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("");
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
	 * �e�X�gID�FPXWXML_E_001_120 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_120() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_100_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML(" ");
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
	 * �e�X�gID�FPXWXML_E_001_121 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_121() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_100_MetaT.xml");
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
	 * �e�X�gID�FPXWXML_E_001_122 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_122() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_100_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("���b�n�m�c�h�s�h�n�m�����h�e�����`�o�o�k�x��" +
					"���`�m�c�����`�o�o�k�x�����d�p�����u�`�q���u�`�q�P���^������>" +
					"<������>�������Q<�^������><�^����><�^����������><����������>" +
					"<����><������>�������R<�^������><������>�������S<�^������><�^����>" +
					"<�^����������><�^������><�^����������><������������>�P<�^������������>" +
					"<�^����><�^������������������>");
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
	 * �e�X�gID�FPXWXML_E_001_123 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_123() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><and><apply><eq><var>var1</var>" +
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
		execXmlWriter();

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_124 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_124() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_125 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_125() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		Properties tp = new Properties();

		// DB�f�[�^����
		tp.setProperty("xml.datamodel.base", base);
		tp.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T01_Meta.xml");
		tp.setProperty("productID", "52");
		initDB(tp);

		tp.setProperty("DBDeleteFlg", Boolean.toString(false));
		tp.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T02_Meta.xml");
		tp.setProperty("productID", "53");
		initDB(tp);

		tp.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T03_Meta.xml");
		tp.setProperty("productID", "54");
		initDB(tp);

		tp.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T04_Meta.xml");
		tp.setProperty("productID", "55");
		initDB(tp);

		// ��ƃf�B���N�g��
		createOutputDir();

		productCD = "KKK_004";

		// �^�p�c�[�����s
		execXmlWriter();

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_126 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_126() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T01_Meta.xml");
		p.setProperty("productID", "52");
		initDB(p);

		p.setProperty("DBDeleteFlg", Boolean.toString(false));
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T02_Meta.xml");
		p.setProperty("productID", "53");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T03_Meta.xml");
		p.setProperty("productID", "54");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T04_Meta.xml");
		p.setProperty("productID", "55");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(2);

			datamodel.setDatamodel_en_name(getTestcaseID());
			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeField field = dbMapper.selectAttField(4);

			field.setDelete_flg(true);
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

		productCD = "KKK_004";

		// �^�p�c�[�����s
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_127 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_127() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T01_Meta.xml");
		p.setProperty("productID", "52");
		initDB(p);

		p.setProperty("DBDeleteFlg", Boolean.toString(false));
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T02_Meta.xml");
		p.setProperty("productID", "53");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T03_Meta.xml");
		p.setProperty("productID", "54");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T04_Meta.xml");
		p.setProperty("productID", "55");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			for (int i = 1; i < 5; i++) {
				TblDataModel datamodel = dbMapper.selectDataModel(i);
				String dmname = getTestcaseID() + String.format("T%1$02d", i);

				datamodel.setDatamodel_en_name(dmname);
				datamodel.setXml_name(dmname + PDSConstants.FILE_XML);
				dbMapper.updateDataModel(datamodel);
			}

			for (int i = 1; i < 9; i++) {
				TblAttributeField field = dbMapper.selectAttField(i);

				field.setDelete_flg(true);
				dbMapper.updateAttField(field);
			}
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

		productCD = "KKK_004";

		// �^�p�c�[�����s
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_128 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_128() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T01_Meta.xml");
		p.setProperty("productID", "52");
		initDB(p);

		p.setProperty("DBDeleteFlg", Boolean.toString(false));
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T02_Meta.xml");
		p.setProperty("productID", "53");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T03_Meta.xml");
		p.setProperty("productID", "54");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_125T04_Meta.xml");
		p.setProperty("productID", "55");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			for (int i = 1; i < 5; i++) {
				TblDataModel datamodel = dbMapper.selectDataModel(i);
				String dmname = String.format("PXWXML_E_001_127T%1$02d", i);

				datamodel.setDatamodel_en_name(dmname);
				datamodel.setXml_name(dmname + PDSConstants.FILE_XML);
				dbMapper.updateDataModel(datamodel);
			}

			for (int i = 1; i < 9; i++) {
				TblAttributeField field = dbMapper.selectAttField(i);

				field.setApproval_flg(false);
				dbMapper.updateAttField(field);
			}
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

		productCD = "KKK_004";

		// �^�p�c�[�����s
		execXmlWriter();
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_127_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}


	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_100";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");

		return p;
	}

}
