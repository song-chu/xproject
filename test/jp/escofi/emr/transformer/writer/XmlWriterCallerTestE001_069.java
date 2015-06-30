package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblMapper;
import jp.iwin.pds.xml2db.datatable.TblProduct;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n069�`087�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: devuser05 $
 */
public final class XmlWriterCallerTestE001_069 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_69 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_69() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;
		TblMapper dbMapper = null;
		TblProduct productOrg = null;

		try {
			session = getSqlSession();
			dbMapper = session.getMapper(TblMapper.class);

			TblProduct product = dbMapper.selectProduct(1);

			productOrg = product.clone();
			product.setRelease_date(" ");
			dbMapper.updateProduct(product);

			session.commit();

			// ��ƃf�B���N�g��
			createOutputDir();

			// �^�p�c�[�����s
			execXmlWriter();

		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {

				if (dbMapper != null && productOrg != null) {
					dbMapper.updateProduct(productOrg);
					session.commit();
				}
				session.close();
			}
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_70 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_70() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;
		TblMapper dbMapper = null;
		TblProduct productOrg = null;

		try {
			session = getSqlSession();
			dbMapper = session.getMapper(TblMapper.class);

			TblProduct product = dbMapper.selectProduct(1);

			productOrg = product.clone();
			product.setRelease_date("201101");
			dbMapper.updateProduct(product);

			session.commit();

			// ��ƃf�B���N�g��
			createOutputDir();

			// �^�p�c�[�����s
			execXmlWriter();

		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {

				if (dbMapper != null && productOrg != null) {
					dbMapper.updateProduct(productOrg);
					session.commit();
				}
				session.close();
			}
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_71 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_71() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;
		TblMapper dbMapper = null;
		TblProduct productOrg = null;

		try {
			session = getSqlSession();
			dbMapper = session.getMapper(TblMapper.class);

			TblProduct product = dbMapper.selectProduct(1);

			productOrg = product.clone();
			product.setDelete_flg(true);
			dbMapper.updateProduct(product);

			session.commit();

			// ��ƃf�B���N�g��
			createOutputDir();

			// �^�p�c�[�����s
			execXmlWriter();
			fail();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}

			if (e instanceof EMRException) {
				assertEquals(MessageCode.EMR_B_P906E, ((EMRException)e).getErrCode());
				assertEquals(String.format("�Č��f�[�^�����݂��܂���B(�Č�CD�F%1$s)",
						this.productCD),
						e.getMessage());
			} else {
				throw e;
			}
		} finally {

			if (session != null) {

				if (dbMapper != null && productOrg != null) {
					dbMapper.updateProduct(productOrg);
					session.commit();
				}
				session.close();
			}
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_72 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_72() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_73 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_73() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_74 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_74() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_75 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_75() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_76 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_76() throws Exception {
		Properties p = createProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setExtend_datamodel_id(999);
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
		execXmlWriter();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_77 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_77() throws Exception {
		Properties p = createDatamodelProperties();


		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setFrom_key_en_name("");
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
		execXmlWriter();

		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_78 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_78() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_79 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_79() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_80 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_80() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_81 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_81() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		execTest(p);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_82 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_82() throws Exception {
		Properties p = createProperties();


		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("");
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
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_83 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_83() throws Exception {
		Properties p = createProperties();


		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name(" ");
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
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_84 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_84() throws Exception {
		Properties p = createDatamodelProperties();


		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i�`�a�b�c�d�e�f�g�h�i");
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
		execXmlWriter();

		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_85 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_85() throws Exception {
		Properties p = createDatamodelProperties();


		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("ABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJ");
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
		execXmlWriter();

		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		PUTPropertyUtil.setProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_86 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_86() throws Exception {
		Properties p = createDatamodelProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			for (int i = 0; i < 3; i++) {
				TblDataModel datamodel = dbMapper.selectDataModel(i + 1);

				datamodel.setXml_object_index(i);
				dbMapper.updateDataModel(datamodel);
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

		// �^�p�c�[�����s
		execXmlWriter();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_87 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_87() throws Exception {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_072";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_86_Meta.xml");

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			for (int i = 0; i < 3; i++) {
				TblDataModel datamodel = dbMapper.selectDataModel(i + 1);

				datamodel.setXml_object_index(1);
				dbMapper.updateDataModel(datamodel);
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

		// �^�p�c�[�����s
		execXmlWriter();
	}


	private Properties createProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_27_Meta.xml");

		return p;
	}

	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_072";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");


		return p;
	}

}
