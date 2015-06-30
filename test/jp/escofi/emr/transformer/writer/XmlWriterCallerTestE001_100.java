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
 * 運用ツールテストクラス（E001系100～128）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_100 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_100 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_100() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_101 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_101() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_102 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_102() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_103 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_103() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_104 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_104() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_105 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_105() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_106 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_106() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_107 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_107() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_108 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_108() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_109 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_109() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_110 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_110() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_111 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_111() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_112 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_112() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_111_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_113 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_113() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_114 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_114() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_115 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_115() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_116 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_116() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_117 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_117() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_118 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_118() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_119 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_119() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_120 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_120() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_121 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_121() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_122 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_122() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_100_MetaT.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("＜ＣＯＮＤＩＴＩＯＮ＞＜ＩＦ＞＜ＡＰＰＬＹ＞" +
					"＜ＡＮＤ＞＜ＡＰＰＬＹ＞＜ＥＱ＞＜ＶＡＲ＞ＶＡＲ１＜／ｖａｒ>" +
					"<ｖａｒ>ｖａｒ２<／ｖａｒ><／ｅｑ><／ａｐｐｌｙ><ａｐｐｌｙ>" +
					"<ｅｑ><ｖａｒ>ｖａｒ３<／ｖａｒ><ｖａｒ>ｖａｒ４<／ｖａｒ><／ｅｑ>" +
					"<／ａｐｐｌｙ><／ａｎｄ><／ａｐｐｌｙ><ｒｅｓｕｌｔ>１<／ｒｅｓｕｌｔ>" +
					"<／ｉｆ><／ｃｏｎｄｉｔｉｏｎ>");
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_123 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_123() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_124 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_124() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_125 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_125() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		Properties tp = new Properties();

		// DBデータ投入
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

		// 作業ディレクトリ
		createOutputDir();

		productCD = "KKK_004";

		// 運用ツール実行
		execXmlWriter();

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_126 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_126() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		productCD = "KKK_004";

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_127 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_127() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String metaOrg = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		productCD = "KKK_004";

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", metaOrg);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_128 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_128() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
		// 作業ディレクトリ
		createOutputDir();

		productCD = "KKK_004";

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_127_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
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
