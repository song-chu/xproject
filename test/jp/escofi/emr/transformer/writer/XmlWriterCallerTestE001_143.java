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
 * 運用ツールテストクラス（E001系143～179）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 *
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_143 extends
		XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_143 運用ツール異常系
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
	 * テストID：PXWXML_E_001_144 運用ツール異常系
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
	 * テストID：PXWXML_E_001_145運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_145() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_146運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_146() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_147運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_147() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_148運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_148() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_149運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_149() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_150運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_150() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_151運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_151() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_152運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_152() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_153運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_153() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_154運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_154() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_155 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_155() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String org = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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

			attValue.setList_value("値1,値2,\"値3-1,値3-2,値4");
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", org);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}
	/**
	 * テストID：PXWXML_E_001_156 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_156() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String org = p.getProperty("xml.meta.filepath");

		// DBデータ投入
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

			attValue.setList_value("値1,値2,\"\"値3\"\",値4");
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
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();
		p.setProperty("xml.meta.filepath", org);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}
	/**
	 * テストID：PXWXML_E_001_157運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_157() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_158運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_158() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_159運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_159() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_160運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_160() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_161運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_161() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_162運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_162() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_163運用ツール異常系
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
	 * テストID：PXWXML_E_001_164運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_164() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_165運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_165() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_166運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_166() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_167運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_167() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_168運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_168() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_169運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_169() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_170運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_170() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_171運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_171() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_172運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_172() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_173運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_173() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_174運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_174() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_175運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_175() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_176運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_176() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_177運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_177() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_178運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_178() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}
	/**
	 * テストID：PXWXML_E_001_179運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_179() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
