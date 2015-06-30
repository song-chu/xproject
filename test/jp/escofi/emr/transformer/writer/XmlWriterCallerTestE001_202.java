package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 運用ツールテストクラス（E001系202～）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: devuser05 $
 */
public final class XmlWriterCallerTestE001_202 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_202 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_202() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setProduct_id(999);
			dbMapper.updateDataModel(datamodel);

			TblAttributeGroup group = dbMapper.selectAttGroup(1);

			group.setDatamodel_id(999);
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
		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_203 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_203() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String org = p.getProperty("xml.meta.filepath");

		// DBデータ投入
		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T01_Meta.xml");
		p.setProperty("productID", "52");
		initDB(p);

		p.setProperty("DBDeleteFlg", Boolean.toString(false));
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T02_Meta.xml");
		p.setProperty("productID", "53");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T03_Meta.xml");
		p.setProperty("productID", "54");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T04_Meta.xml");
		p.setProperty("productID", "55");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(4);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeField field = dbMapper.selectAttField(13);

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
		p.setProperty("xml.meta.filepath", org);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_204 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_204() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");
		String org = p.getProperty("xml.meta.filepath");

		// DBデータ投入
		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T01_Meta.xml");
		p.setProperty("productID", "52");
		initDB(p);

		p.setProperty("DBDeleteFlg", Boolean.toString(false));
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T02_Meta.xml");
		p.setProperty("productID", "53");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T03_Meta.xml");
		p.setProperty("productID", "54");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T04_Meta.xml");
		p.setProperty("productID", "55");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("PXWXML_E_001_204T01" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			datamodel = dbMapper.selectDataModel(2);
			datamodel.setXml_name("PXWXML_E_001_204T02" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			datamodel = dbMapper.selectDataModel(4);
			datamodel.setXml_name("PXWXML_E_001_203" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			for (int i = 1; i < 14; i++) {
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
		p.setProperty("xml.meta.filepath", org);

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_205 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_205() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "T_Meta.xml");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeValue value = dbMapper.selectAttValue(3);

			value.setMap_value("");
			dbMapper.updateAttValue(value);
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
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_206 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_206() throws Exception {
		Properties p = createDatamodelProperties();
		String base = p.getProperty("xml.datamodel.base");

		// DBデータ投入
		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T01_Meta.xml");
		p.setProperty("productID", "52");
		initDB(p);

		p.setProperty("DBDeleteFlg", Boolean.toString(false));
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T02_Meta.xml");
		p.setProperty("productID", "53");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T03_Meta.xml");
		p.setProperty("productID", "54");
		initDB(p);

		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_203T04_Meta.xml");
		p.setProperty("productID", "55");
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblDataModel datamodel = dbMapper.selectDataModel(1);

			datamodel.setXml_name("PXWXML_E_001_203T01" + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			datamodel = dbMapper.selectDataModel(4);
			datamodel.setDatamodel_en_name(getTestcaseID());
			datamodel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
			dbMapper.updateDataModel(datamodel);

			TblAttributeField field = dbMapper.selectAttField(3);

			field.setApproval_flg(false);
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
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");

		PUTPropertyUtil.setProperty(p);

		// 出力ファイル比較
		diffResult();
	}
	/**
	 * テストID：PXWXML_E_001_207 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_207() throws Exception {
		Properties p = createDatamodelProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeValue attValue = dbMapper.selectAttValue(1);

			attValue.setList_value(attValue.getList_value() + "\"");
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

		// 出力ファイル比較
		diffResult();
	}


	private Properties createDatamodelProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_202";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");


		return p;
	}

}
