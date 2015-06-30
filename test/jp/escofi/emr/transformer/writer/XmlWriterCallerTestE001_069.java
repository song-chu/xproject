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
 * 運用ツールテストクラス（E001系069～087）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: devuser05 $
 */
public final class XmlWriterCallerTestE001_069 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_69 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_69() throws Exception {
		Properties p = createProperties();

		// DBデータ投入
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

			// 作業ディレクトリ
			createOutputDir();

			// 運用ツール実行
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
	 * テストID：PXWXML_E_001_70 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_70() throws Exception {
		Properties p = createProperties();

		// DBデータ投入
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

			// 作業ディレクトリ
			createOutputDir();

			// 運用ツール実行
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
	 * テストID：PXWXML_E_001_71 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_71() throws Exception {
		Properties p = createProperties();

		// DBデータ投入
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

			// 作業ディレクトリ
			createOutputDir();

			// 運用ツール実行
			execXmlWriter();
			fail();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}

			if (e instanceof EMRException) {
				assertEquals(MessageCode.EMR_B_P906E, ((EMRException)e).getErrCode());
				assertEquals(String.format("案件データが存在しません。(案件CD：%1$s)",
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
	 * テストID：PXWXML_E_001_72 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_72() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_73 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_73() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_74 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_74() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_75 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_75() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_76 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_76() throws Exception {
		Properties p = createProperties();

		// DBデータ投入
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

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
	}

	/**
	 * テストID：PXWXML_E_001_77 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_77() throws Exception {
		Properties p = createDatamodelProperties();


		// DBデータ投入
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

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_78 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_78() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_79 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_79() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_80 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_80() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_81 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_81() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_82 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_82() throws Exception {
		Properties p = createProperties();


		// DBデータ投入
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

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中IOエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_83 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_83() throws Exception {
		Properties p = createProperties();


		// DBデータ投入
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

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中IOエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_84 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_84() throws Exception {
		Properties p = createDatamodelProperties();


		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("ＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪＡＢＣＤＥＦＧＨＩＪ");
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

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_85 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_85() throws Exception {
		Properties p = createDatamodelProperties();


		// DBデータ投入
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

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		String base = p.getProperty("xml.datamodel.base");

		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_MetaT.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_86 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_86() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
	}

	/**
	 * テストID：PXWXML_E_001_87 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_87() throws Exception {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_072";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_86_Meta.xml");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
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
