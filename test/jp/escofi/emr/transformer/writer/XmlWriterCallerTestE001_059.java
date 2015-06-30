package jp.escofi.emr.transformer.writer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

/**
 * 運用ツールテストクラス（E001系059～068）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_059 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_59 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_59() throws Exception {
		File confOrg = Resources.getResourceAsFile(PDSConstants.CONF_MY_BATIS.toString());
		File confTmp = new File(confOrg.getAbsolutePath() + ".test");

		confOrg.renameTo(confTmp);

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals("XMLファイル出力中IOエラーが発生しました。(ファイルパス：configuration.xml)",
					e.getMessage());
		} finally {
			confTmp.renameTo(confOrg);
		}
	}

	/**
	 * テストID：PXWXML_E_001_60 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_60() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_61 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_61() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_62 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_62() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_63 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_63() throws Exception {
		try {
			execErrConf();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DBコネクション取得に失敗しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_64 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_64() throws Exception {
		try {
			execErrMapper();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_65 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_65() throws Exception {
		try {
			execErrMapper();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_66 運用ツール異常系
	 * 結果は目視確認
	 */
//	@Test
//	public void testPXWXML_E_001_66() throws Exception {
//		try {
//			execErrMapper();
//		} catch (EMRException e) {
//			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
//			assertEquals("DBコネクション取得に失敗しました。",
//					e.getMessage());
//		}
//	}

	@Test
	public void testPXWXML_E_001_66() throws Exception {
		File testOrg = null;
		File testTmp = null;
		try {
			Properties p = createProperties();

			// DBデータ投入
			initDB(p);

			// 作業ディレクトリ
			createOutputDir();

			// execErrMapper()
			String testFileName = "sqlDatamodel.xml";
			File confOrg = Resources.getResourceAsFile(
					PDSConstants.CONF_MY_BATIS.toString());
			testOrg = new File(confOrg.getParentFile(), testFileName);

			String orgPath = testOrg.getAbsolutePath();
			testTmp = new File(orgPath + ".test");
			File test = new File("Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_060/" +
					getTestcaseID() + testFileName);

			testOrg.renameTo(testTmp);
			copyFile(test, testOrg);

			// 運用ツール実行
			execXmlWriter();
		} finally {
			if (testOrg.exists()) {
				testOrg.delete();
			}
			testTmp.renameTo(testOrg);
		}
	}



	/**
	 * テストID：PXWXML_E_001_67 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_67() throws Exception {
		String testFileName = "sqlProduct.xml";
		File confOrg = Resources.getResourceAsFile(
				PDSConstants.CONF_MY_BATIS.toString());
		File testOrg = new File(confOrg.getParentFile(), testFileName);

		try {
			execErr(testFileName, testOrg);
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_68 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_68() throws Exception {
		try {
			execErrMapper();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("予期せぬ状態が発生しました。",
					e.getMessage());
		}
	}


	/**
	 * 作業ファイルコピー。
	 *
	 * @param from コピー元
	 * @param to コピー先
	 * @throws IOException コピー失敗
	 */
	private void copyFile(File from, File to) throws IOException {
//		CharBuffer buff = CharBuffer.allocate(10);
		FileReader reader = null;
		FileWriter writer = null;

		try {
			reader = new FileReader(from);
			writer = new FileWriter(to);

			int c;

			while ((c = reader.read()) != -1) {
				writer.write(c);
			}

//			while (reader.ready()) {
//				reader.read(buff);
//				writer.append(buff);
//				buff.clear();
//			}
		} finally {

			if (reader != null) {
				reader.close();
			}

			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * configuration.xml異常系テスト。
	 *
	 * @throws IOException ファイル入出力エラー
	 */
	private void execErrConf() throws IOException, EMRException {
		String confName = PDSConstants.CONF_MY_BATIS.toString();
		File confOrg = Resources.getResourceAsFile(confName);

		execErr(confName, confOrg);
	}

	/**
	 * mapper.xml異常系テスト。
	 *
	 * @throws IOException ファイル入出力エラー
	 */
	private void execErrMapper() throws IOException, EMRException {
		String testFileName = "sqlDatamodel.xml";
		File confOrg = Resources.getResourceAsFile(
				PDSConstants.CONF_MY_BATIS.toString());
		File testOrg = new File(confOrg.getParentFile(), testFileName);

		execErr(testFileName, testOrg);
	}

	/**
	 * 設定ファイル異常系テスト
	 *
	 * @param testFileName テスト対象設定ファイル
	 * @param testOrg テスト対象元ファイル
	 * @throws IOException ファイル入出力エラー
	 */
	private void execErr(String testFileName, File testOrg) throws IOException, EMRException{
		String orgPath = testOrg.getAbsolutePath();
		File testTmp = new File(orgPath + ".test");
		File test = new File("Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001_060/" +
				getTestcaseID() + testFileName);

		testOrg.renameTo(testTmp);
		copyFile(test, testOrg);

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} finally {
			if (testOrg.exists()) {
				testOrg.delete();
			}
			testTmp.renameTo(testOrg);
		}
	}

	private Properties createProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_27_Meta.xml");

		return p;
	}
}
