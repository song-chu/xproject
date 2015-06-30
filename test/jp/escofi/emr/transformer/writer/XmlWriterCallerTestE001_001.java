package jp.escofi.emr.transformer.writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.KeyitemMapper;
import jp.escofi.emr.transformer.sql.ResultObjectMapper;
import jp.iwin.pds.xml2db.datatable.TblAttributeElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblKeySolve;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.xml.sax.SAXException;


/**
 * 運用ツールテストクラス（E001系001～026）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: song.ck $
 */
public class XmlWriterCallerTestE001_001 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_1 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_1() throws Exception {

		String[] cmdarray = new String[] {
				"java",
				"-classpath",
				"Z:/OutputXML/bin;Z:/OutputXML/lib/commons-logging-1.1.1.jar;Z:/OutputXML/lib/log4j-1.2.9.jar;Z:/OutputXML/lib/mybatis-3.0.2.jar;Z:/OutputXML/lib/db2jcc.jar;Z:/OutputXML/lib/db2jcc_license_cu.jar;Z:/OutputXML/lib/pds.jar;Z:/OutputXML/lib/pdstool.jar",
				"jp.iwin.pds.xmlwriter.XmlWriterCaller" };
		String expectedMessage = "エラーコード：P908E、エラーメッセージ：引数不正。引数の数が不正です。（引数：[]）";
		this.main(cmdarray, expectedMessage);
	}

	/**
	 * テストID：PXWXML_E_001_2 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_2() throws Exception {

		String[] cmdarray = new String[] {
				"java",
				"-classpath",
				"Z:/OutputXML/bin;Z:/OutputXML/lib/commons-logging-1.1.1.jar;Z:/OutputXML/lib/log4j-1.2.9.jar;Z:/OutputXML/lib/mybatis-3.0.2.jar;Z:/OutputXML/lib/db2jcc.jar;Z:/OutputXML/lib/db2jcc_license_cu.jar;Z:/OutputXML/lib/pds.jar;Z:/OutputXML/lib/pdstool.jar",
				"jp.iwin.pds.xmlwriter.XmlWriterCaller", this.driver,
				this.url, this.username, this.password, this.productCD };
		String expectedMessage = String.format(
				"エラーコード：P908E、エラーメッセージ：引数不正。引数の数が不正です。（引数：[%1$s, %2$s, %3$s, %4$s, %5$s]）",
				this.driver, this.url, this.username, this.password, this.productCD);
		this.main(cmdarray, expectedMessage);
	}

	/**
	 * テストID：PXWXML_E_001_3 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_3() throws Exception {

		String[] cmdarray = new String[] {
				"java",
				"-classpath",
				"Z:/OutputXML/bin;Z:/OutputXML/lib/commons-logging-1.1.1.jar;Z:/OutputXML/lib/log4j-1.2.9.jar;Z:/OutputXML/lib/mybatis-3.0.2.jar;Z:/OutputXML/lib/db2jcc.jar;Z:/OutputXML/lib/db2jcc_license_cu.jar;Z:/OutputXML/lib/pds.jar;Z:/OutputXML/lib/pdstool.jar",
				"jp.iwin.pds.xmlwriter.XmlWriterCaller", this.driver,
				this.url, this.username, this.password, this.productCD,
				this.xmlbase, "XXX" };
		String expectedMessage = String.format(
				"エラーコード：P908E、エラーメッセージ：引数不正。引数の数が不正です。（引数：[%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, XXX]）",
				this.driver, this.url, this.username, this.password, this.productCD, this.xmlbase);
		this.main(cmdarray, expectedMessage);
	}

	/**
	 * テストID：PXWXML_E_001_4 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_4() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(Resources.class, "getResourceAsReader", 0,
				new IOException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals("XMLファイル出力中IOエラーが発生しました。(ファイルパス：configuration.xml)",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_5 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_5() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(SqlSessionFactoryBuilder.class, "build", 0, new NullPointerException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_6 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_6() throws Exception {
		// 異常値
		this.driver += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_7 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_7() throws Exception {
		// 異常値
		this.url += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_8 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_8() throws Exception {
		// 異常値
		this.username += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_9 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_9() throws Exception {
		// 異常値
		this.password += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_10 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_10() throws Exception {
		// 異常値
		this.productCD = "ZZZZZ_9999";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P906E, e.getErrCode());
			assertEquals(String.format("案件データが存在しません。(案件CD：%1$s)",
					this.productCD),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_11 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_11() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		insertMeta(dataModel, attGroup);

		// XML管理ファイル
		File f = new File(this.xmlbase + File.separator + "XML_Meta.xml");

		// 作業ディレクトリ
		createOutputDir();

		// XML管理ファイルを読込み専用に変更
		f.createNewFile();
		f.setReadOnly();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中IOエラーが発生しました。(ファイルパス：%1$s)",
					f.getAbsolutePath()),
					e.getMessage());
		} finally {
			f.delete();
		}
	}

	/**
	 * テストID：PXWXML_E_001_12 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_12() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		insertMeta(dataModel, attGroup);

		// 作業ディレクトリ
		createOutputDir();

		// ディレクトリ作成
		File dir = createDir("XML_Meta.xml");

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中IOエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		} finally {

			if (!dir.delete()) {
				throw new IOException("delete fail.");
			}
		}
	}

	/**
	 * テストID：PXWXML_E_001_13 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_13() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// データモデルファイル
		File f = new File(this.xmlbase + File.separator + "PENSER_N_001_1.xml");

		f.createNewFile();
		f.setReadOnly();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中IOエラーが発生しました。(ファイルパス：%1$s)",
					f.getAbsolutePath()),
					e.getMessage());
		} finally {
			f.delete();
		}
	}

	/**
	 * テストID：PXWXML_E_001_14 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_14() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ディレクトリ作成
		File dir = createDir("PENSER_N_001_1.xml");

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中IOエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		} finally {

			if (!dir.delete()) {
				throw new IOException("delete fail.");
			}
		}
	}

	/**
	 * テストID：PXWXML_E_001_15 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_15() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0, new ParserConfigurationException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_16 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_16() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0, new SAXException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_17 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_17() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(DatamodelinfoWriter.class, "write", 0,
				new RuntimeException(new SQLException()));

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P909E, e.getErrCode());
			assertEquals("XMLファイル出力処理中SQLエラーが発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_18 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_18() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(DatamodelinfoWriter.class, "write", 0,
				new NullPointerException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_19 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_19() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		dataModel.setProduct_id(99999);
		insertMeta(dataModel, attGroup);

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P912E, e.getErrCode());
			assertEquals(String.format("データモデルが存在しません。(案件CD：%1$s)",
					this.productCD),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_20 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_20() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		attGroup.setDatamodel_id(99999);
		insertMeta(dataModel, attGroup);

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/XmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");

//		PUTPropertyUtil.setProperty(p);
		replaceProperty(p);

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * テストID：PXWXML_E_001_21 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_21() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnValueAt(KeyitemMapper.class, "selectKeyitem", 0, new  ArrayList<KeyitemWriter>());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(String.format("属性グループが存在しません。(データモデルID：%1$s)",
					dataModel.getDatamodel_id()),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_22 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_22() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);
		List<TblKeySolve> keyList = new ArrayList<TblKeySolve>(2);

		TblKeySolve key = new TblKeySolve();

		key.setKey_solve_id(1);
		key.setDatamodel_id(dataModel.getDatamodel_id());
		key.setIndex(1);
		key.setKey_en_name("testkey01");
		keyList.add(key);

		key = new TblKeySolve();
		key.setKey_solve_id(2);
		key.setDatamodel_id(dataModel.getDatamodel_id());
		key.setIndex(1);
		key.setKey_en_name("testkey02");
		keyList.add(key);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, keyList);

		// 作業ディレクトリ
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_23 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_23() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		setReturnNullAt(ResultObjectMapper.class, "select", 0);

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_24 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_24() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValue.setAttribute_field_id(99999);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			e.printStackTrace();
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_25 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_25() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(2);

		for (int i = 1; i < 3; i++) {
			TblAttributeValue attValue = createDefaultAttValue(attField);

			attValue.setAttribute_value_id(i);
			attValue.setSingle_value(String.format("value%1$03d", i));
			attValueList.add(attValue);
		}
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_26 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_26() throws Exception {

		// データ投入
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValue.setAnser_no(1);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// 作業ディレクトリ
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}


	/**
	 * チェックパラメータテスト用メソッド
	 * @param cmdarray
	 *            コマンドアレイ
	 * @param expectedMessage
	 *            期待値メッセージ
	 *
	 * @throws Exception
	 */
	private void main(String[] cmdarray, String expectedMessage) throws Exception {

		// 異常値
		Process process = Runtime.getRuntime().exec(cmdarray);
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = br.readLine();
			while (line != null && line.length() > 0) {
				sb.append(line);
				line = br.readLine();
			}
		} finally {
			try {
				br.close();
			} catch (Exception ex) {

			}
		}
		int exitValue = process.waitFor();
		assertEquals(1, exitValue);
		String actual = sb.toString();
		log.info("[actual  ]" + actual);
		log.info("[expected]" + expectedMessage);
		boolean matched = (actual != null) && actual.contains(expectedMessage);
		assertEquals(true, matched);
	}

	/**
	 * @return デフォルトで投入するデータモデルデータ
	 */
	private TblDataModel createDefaultDatamodel() {
		TblDataModel dataModel = new TblDataModel();

		dataModel.setDatamodel_id(1);
		dataModel.setDatamodel_jp_name("データモデル_001");
		dataModel.setDatamodel_en_name(getTestcaseID());
		dataModel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
		dataModel.setXml_object_index(1);
		dataModel.setProduct_id(1);

		return dataModel;
	}

	/**
	 * @param dataModel 紐付けるデータモデル
	 * @return デフォルトで投入する属性グループデータ
	 */
	private TblAttributeGroup createDefaultAttGroup(TblDataModel dataModel) {
		TblAttributeGroup attGroup = new TblAttributeGroup();

		attGroup.setAttribute_group_id(1);
		attGroup.setAttribute_group_jp_name("属性グループ_001");
		attGroup.setDatamodel_id(dataModel.getDatamodel_id());
		attGroup.setProduct_id(dataModel.getProduct_id());

		return attGroup;
	}

	/**
	 * @param dataModel 紐付けるデータモデル
	 * @return デフォルトで投入する属性管理データ
	 */
	private TblAttributeElem createDefaultAttElem(TblDataModel dataModel) {
		TblAttributeElem attElem = new TblAttributeElem();

		attElem.setAttribute_elem_id(1);
		attElem.setDatamodel_id(dataModel.getDatamodel_id());
		attElem.setAttribute_field_jp_name("属性１");
		attElem.setAttribute_field_en_name("attrname1");
		attElem.setAttribute_type_cd("01");
		attElem.setJava_class_cd("01");
		attElem.setProduct_id(dataModel.getProduct_id());

		return attElem;
	}

	/**
	 * @param attElem 紐付ける属性管理
	 * @param attGroup 紐付ける属性グループ
	 * @return デフォルトで投入する属性項目データ
	 */
	private TblAttributeField createDefaultAttField(TblAttributeElem attElem,
			TblAttributeGroup attGroup) {
		TblAttributeField attField = new TblAttributeField();

		attField.setAttribute_field_id(1);
		attField.setAttribute_elem_id(attElem.getAttribute_elem_id());
		attField.setAttribute_group_id(attGroup.getAttribute_group_id());
		attField.setProduct_id(attElem.getProduct_id());

		return attField;
	}

	/**
	 * @param attField 紐付ける属性項目
	 * @return デフォルトで投入する属性値データ
	 */
	private TblAttributeValue createDefaultAttValue(TblAttributeField attField) {
		TblAttributeValue attValue = new TblAttributeValue();

		attValue.setAttribute_value_id(1);
		attValue.setAttribute_field_id(attField.getAttribute_field_id());
		attValue.setSingle_value("value001");

		return attValue;
	}

	/**
	 * XML管理情報投入。
	 *
	 * @param dataModel データモデル
	 * @param attGroup 属性グループ
	 * @throws IOException
	 */
	private void insertMeta(TblDataModel dataModel, TblAttributeGroup attGroup
			) throws IOException {

		// データ投入
		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			dbMapper.deleteAllDatamodel();
			dbMapper.deleteAllAttGroup();
			session.commit();

			dbMapper.insertDatamodel(dataModel);
			dbMapper.insertAttGroup(attGroup);
			session.commit();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * データモデル情報投入。
	 *
	 * @param dataModel データモデル
	 * @param attGroup 属性グループ
	 * @param attElem 属性管理
	 * @param attField 属性項目
	 * @param attValueList 属性値リスト
	 * @param keyList キー項目値リスト
	 * @throws IOException
	 */
	private void insertDatamodel(TblDataModel dataModel, TblAttributeGroup attGroup,
			TblAttributeElem attElem, TblAttributeField attField,
			List<TblAttributeValue> attValueList, List<TblKeySolve> keyList) throws IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			dbMapper.deleteAllDatamodel();
			dbMapper.deleteAllAttGroup();
			dbMapper.deleteAllKeySolve();
			dbMapper.deleteAllAttElem();
			dbMapper.deleteAllAttField();
			dbMapper.deleteAllAttValue();
			session.commit();

			dbMapper.insertDatamodel(dataModel);
			dbMapper.insertAttGroup(attGroup);
			dbMapper.insertAttElem(attElem);
			dbMapper.insertAttField(attField);

			for (TblAttributeValue attValue : attValueList) {
				dbMapper.insertAttValue(attValue);
			}

			if (keyList != null) {

				for (TblKeySolve key : keyList) {
					dbMapper.insertKeySolve(key);
				}
			}
			session.commit();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * ディレクトリ作成。
	 *
	 * @param dirname ディレクトリ名
	 * @return 作成したディレクトリ
	 * @throws IOException 作成失敗
	 */
	private File createDir(String dirname) throws IOException {
		File dir = new File(this.xmlbase + File.separator + dirname);

		createDir(dir);

		return dir;
	}

}
