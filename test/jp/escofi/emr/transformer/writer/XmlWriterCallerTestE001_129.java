package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.iwin.pds.xml2db.datatable.TblArgsElem;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 運用ツールテストクラス（E001系129～142）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_129 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_129 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_129() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_130 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_130() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_131 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_131() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_132 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_132() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_133 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_133() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_134 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_134() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_135 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_135() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_136 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_136() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_137 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_137() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
	 * テストID：PXWXML_E_001_138 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_138() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_139 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_139() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_140 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_140() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_141 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_141() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		execTest(p);
	}

	/**
	 * テストID：PXWXML_E_001_142 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_142() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
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
