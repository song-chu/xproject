package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.datatable.TblArgsElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblKeySolve;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n180�`201�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_180 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_180 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_180() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_180_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);
			dbMapper.deleteAllAttGroup();

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
	 * �e�X�gID�FPXWXML_E_001_181 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_181() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_180_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("PXWXML_E_001_180" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeGroup attGroup = dbMapper.selectAttGroup(1);
			attGroup.setDelete_flg(1);

			dbMapper.updateAttGroup(attGroup);

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
		p.setProperty("xml.meta.filepath",  base + "/PXWXML_E_001_180_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_182 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_182() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_182_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);
			dbMapper.deleteAllAttGroup();

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
	 * �e�X�gID�FPXWXML_E_001_183�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_183() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_184 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_184() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeGroup attGroup=dbMapper.selectAttGroup(1);
			attGroup.setKey3("001");
			dbMapper.updateAttGroup(attGroup);

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
	 * �e�X�gID�FPXWXML_E_001_185 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_185() throws Exception {
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

			TblAttributeGroup attGroup=dbMapper.selectAttGroup(1);

			attGroup.setKey3("");
			dbMapper.updateAttGroup(attGroup);

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
	 * �e�X�gID�FPXWXML_E_001_186 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_186() throws Exception {
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

			TblKeySolve keysolve = dbMapper.selectKeySolve(3);
			keysolve.setIndex(11);
			dbMapper.updateKeySolve(keysolve);

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
	 * �e�X�gID�FPXWXML_E_001_187 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_187() throws Exception {
		Properties p = createDatamodelProperties();

		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAnser_no(0);
			dbMapper.updateAttValue(attValue);
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
	 * �e�X�gID�FPXWXML_E_001_188 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_188() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAttribute_value_id(2);
			attValue.setAnser_no(2);
			dbMapper.insertAttValue(attValue);

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
	 * �e�X�gID�FPXWXML_E_001_189 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_189() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_188_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAnser_no(2);
			dbMapper.updateAttValue(attValue);

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
	 * �e�X�gID�FPXWXML_E_001_190 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_190() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAttribute_value_id(2);
			attValue.setAnser_no(2);
			dbMapper.insertAttValue(attValue);

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
	 * �e�X�gID�FPXWXML_E_001_191 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_191() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_190_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAttribute_value_id(2);
			attValue.setAnser_no(0);
			dbMapper.insertAttValue(attValue);

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
	 * �e�X�gID�FPXWXML_E_001_192 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_192() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);

			dbMapper.deleteAllArgsElem();

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
	 * �e�X�gID�FPXWXML_E_001_193�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_193() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_192_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);

			TblArgsElem argsElem = dbMapper.selectArgsElem(1);
			argsElem.setDelete_flg(1);
			dbMapper.updateArgsElem(argsElem);

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
	 * �e�X�gID�FPXWXML_E_001_194�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_194() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_192_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();
			TblMapper dbMapper = session.getMapper(TblMapper.class);

			TblArgsElem argsElem = dbMapper.selectArgsElem(1);
			argsElem.setArgs_elem_id(2);
			dbMapper.insertArgsElem(argsElem);

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
	 * �e�X�gID�FPXWXML_E_001_195�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_195() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter("TEST_001");
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P909E, e.getErrCode());
			assertEquals("XML�t�@�C���o�͏�����SQL�G���[���������܂����B",
					e.getMessage());
		}
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_196�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_196() throws Exception {
		Properties p = createDatamodelProperties();
		p.setProperty("productID", "57");

		// DB�f�[�^����
		execTest(p,"anken001");
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_197�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_197() throws Exception {
		Properties p = createDatamodelProperties();
		p.setProperty("productID", "58");

		// DB�f�[�^����
		execTest(p,"anken002");
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_198�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_198() throws Exception {
		Properties p = createDatamodelProperties();
		p.setProperty("productID", "59");

		// DB�f�[�^����
		execTest(p,"anken003");
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_199�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_199() throws Exception {
		Properties p = createDatamodelProperties();
		p.setProperty("productID", "2");
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_198_Meta.xml");
		initDB(p);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		this.productCD = "JJJ_001";
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P912E, e.getErrCode());
			assertEquals(String.format("�f�[�^���f�������݂��܂���B(�Č�CD�F%1$s)",
					this.productCD),
					e.getMessage());
		}
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_200�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_200() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_198_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setDelete_flg(1);
			dbMapper.updateDataModel(datamodel);
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
			assertEquals(MessageCode.EMR_B_P912E, e.getErrCode());
			assertEquals(String.format("�f�[�^���f�������݂��܂���B(�Č�CD�F%1$s)",
					this.productCD),
					e.getMessage());
		}
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_201�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_201() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_180";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");


		return p;
	}

}
