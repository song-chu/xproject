package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n143�`179�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 *
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_143 extends
		XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_143 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_143() throws Exception {
		Properties p = createDatamodelProperties();

		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAttribute_field_id(999);
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
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_144 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_144() throws Exception {
		Properties p = createDatamodelProperties();

		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setAnser_no(1);
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
	 * �e�X�gID�FPXWXML_E_001_145�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_145() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_146�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_146() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_147�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_147() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_148�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_148() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_149�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_149() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_150�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_150() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_151�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_151() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_152�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_152() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_153�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_153() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_154�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_154() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_155 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_155() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String org = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_153_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setDatamodel_en_name(getTestcaseID());
			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setList_value("�l1,�l2,\"�l3-1,�l3-2,�l4");
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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", org);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_156 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_156() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String org = p.getProperty("xml.meta.filepath");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_154_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setDatamodel_en_name(getTestcaseID());
			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setList_value("�l1,�l2,\"\"�l3\"\",�l4");
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
		execXmlWriter();
		p.setProperty("xml.meta.filepath", org);

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_157�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_157() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_158�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_158() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_159�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_159() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_160�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_160() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_161�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_161() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_162�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_162() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_163�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_163() throws Exception {
		Properties p = createDatamodelProperties();

		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setMap_value("1,2,3");
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
	 * �e�X�gID�FPXWXML_E_001_164�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_164() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DB�f�[�^����
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_163_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setMap_value("1,2,3,4,5");
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
	 * �e�X�gID�FPXWXML_E_001_165�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_165() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_166�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_166() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_167�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_167() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_168�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_168() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_169�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_169() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_170�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_170() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_171�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_171() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_172�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_172() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_173�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_173() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_174�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_174() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_175�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_175() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_176�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_176() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_177�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_177() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_178�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_178() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	/**
	 * �e�X�gID�FPXWXML_E_001_179�^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_179() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}
	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_143";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID()
				+ "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");

		return p;
	}

}
