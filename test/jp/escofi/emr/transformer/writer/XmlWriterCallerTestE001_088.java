package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.datatable.TblAttributeElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblKeySolve;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 運用ツールテストクラス（E001系088～099）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_088 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_88 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_88() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeGroup group = dbMapper.selectAttGroup(1);

			group.setAttribute_group_id(4);
			group.setDatamodel_id(999);
			dbMapper.insertAttGroup(group);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_89 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_89() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeGroup group = dbMapper.selectAttGroup(3);

			group.setExtend_attribute_group_id(999);
			dbMapper.updateAttGroup(group);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_90 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_90() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeElem elem = dbMapper.selectAttElem(3);

			elem.setAttribute_field_en_name("attrname1");
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_91 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_91() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblKeySolve key = dbMapper.selectKeySolve(3);

			key.setDatamodel_id(999);
			dbMapper.updateKeySolve(key);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_92 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_92() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_91_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name("PXWXML_E_001_91" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblKeySolve key = dbMapper.selectKeySolve(3);

			key.setIndex(0);
			dbMapper.updateKeySolve(key);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_91_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_93 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_93() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_91_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name("PXWXML_E_001_91" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblKeySolve key = dbMapper.selectKeySolve(3);

			key.setIndex(11);
			dbMapper.updateKeySolve(key);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_91_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_94 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_94() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_91_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name("PXWXML_E_001_91" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblKeySolve key = dbMapper.selectKeySolve(3);

			key.setIndex(1);
			dbMapper.updateKeySolve(key);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_95 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_95() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(3);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblKeySolve key = dbMapper.selectKeySolve(3);

			key.setKey_en_name("");
			dbMapper.updateKeySolve(key);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_96 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_96() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_97 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_97() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_98 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_98() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_99 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_99() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblKeySolve key = dbMapper.selectKeySolve(3);

			key.setExtend_key_solve_id(999);
			dbMapper.updateKeySolve(key);

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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		// 出力ファイル比較
		diffResult();
	}


	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_088";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");

		return p;
	}

}
