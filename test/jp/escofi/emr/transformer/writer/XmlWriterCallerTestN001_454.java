package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import org.junit.Test;


/**
 * 運用ツールテストクラス（N001系）
 * <P>
 * 運用ツール正常系のテストメソッド定義クラス。
 * </P>
 * @author $Author$
 */
public final class XmlWriterCallerTestN001_454 extends XmlWriterCallerTest {

	private Properties setProperty(String testCaseName){
		Properties prop = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_N006";
		prop.setProperty("xml.meta.filepath", base+'/'+testCaseName+"_Meta.xml");
		prop.setProperty("xml.datamodel.base",base);
		prop.setProperty("DBDeleteFlg", Boolean.toString(true));
		prop.setProperty("productID", "1");


		return prop;

	}

	/**
	 * テストID：PXWXML_N_001_454 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_454() throws Exception {
		// property設定
		Properties p = setProperty(this.getName().substring(4));

		// テスト実行
		execTest(p,"AAA_001");
	}

	/**
	 * テストID：PXWXML_N_001_455 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_455() throws Exception {
		// property設定
		Properties p = setProperty(this.getName().substring(4));

		// テスト実行
		execTest(p,"AAA_001");
	}

	/**
	 * テストID：PXWXML_N_001_456 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_456() throws Exception {
		// property設定
		Properties p = setProperty(this.getName().substring(4));

		// テスト実行
		execTest(p,"AAA_001");
	}

	/**
	 * テストID：PXWXML_N_001_457 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_457() throws Exception {
		// property設定
		Properties p = setProperty(this.getName().substring(4));

		// テスト実行
		execTest(p,"AAA_001");
	}

}
