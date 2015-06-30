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
public final class XmlWriterCallerTestN001_001 extends XmlWriterCallerTest {

	private Properties setProperty(String testCaseName,String productID){
		Properties prop = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_N001";
		prop.setProperty("xml.meta.filepath", base +"/PENSER_"+testCaseName+"_Meta.xml");
		prop.setProperty("xml.datamodel.base",base);
		prop.setProperty("DBDeleteFlg", Boolean.toString(true));
		prop.setProperty("productID", productID);

		return prop;

	}
	/**
	 * テストID：PXWXML_N_001_1 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_1() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		p.setProperty("DBDeleteFlg", Boolean.toString(true));

		execTest(p,"AAA_001");
	}
	/**
	 * テストID：PXWXML_N_001_2 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_2() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"BBB_001");
	}
	/**
	 * テストID：PXWXML_N_001_3 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_3() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"BBB_002");
	}
	/**
	 * テストID：PXWXML_N_001_3 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_4() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"CCC_001");

	}
	/**
	 * テストID：PXWXML_N_001_5 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_5() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"CCC_002");

	}
	/**
	 * テストID：PXWXML_N_001_6 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_6() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"CCC_003");

	}
	/**
	 * テストID：PXWXML_N_001_7 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_7() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"DDD_001");
	}
	/**
	 * テストID：PXWXML_N_001_8 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_8() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"DDD_002");

	}
	/**
	 * テストID：PXWXML_N_001_9 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_9() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"DDD_003");

	}
	/**
	 * テストID：PXWXML_N_001_10 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_10() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"DDD_004");
	}
	/**
	 * テストID：PXWXML_N_001_11 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_11() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"EEE_001");

	}
	/**
	 * テストID：PXWXML_N_001_12 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_12() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"EEE_002");

	}
	/**
	 * テストID：PXWXML_N_001_13 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_13() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"EEE_003");

	}
	/**
	 * テストID：PXWXML_N_001_14 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_14() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"EEE_004");

	}
	/**
	 * テストID：PXWXML_N_001_15 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_15() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"EEE_005");

	}
	/**
	 * テストID：PXWXML_N_001_16 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_16() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"FFF_001");

	}
	/**
	 * テストID：PXWXML_N_001_17 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_17() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"FFF_002");

	}
	/**
	 * テストID：PXWXML_N_001_18 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_18() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"FFF_003");


	}
	/**
	 * テストID：PXWXML_N_001_19 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_19() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"FFF_004");

	}
	/**
	 * テストID：PXWXML_N_001_20 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_20() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"FFF_005");


	}
	/**
	 * テストID：PXWXML_N_001_21 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_21() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"FFF_006");
	}
	/**
	 * テストID：PXWXML_N_001_22 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_22() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_001");

	}
	/**
	 * テストID：PXWXML_N_001_23 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_23() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_002");

	}
	/**
	 * テストID：PXWXML_N_001_24 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_24() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_003");

	}
	/**
	 * テストID：PXWXML_N_001_25 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_25() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_004");

	}
	/**
	 * テストID：PXWXML_N_001_26 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_26() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_005");

	}
	/**
	 * テストID：PXWXML_N_001_27 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_27() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_006");

	}
	/**
	 * テストID：PXWXML_N_001_28 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_28() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"GGG_007");


	}
//	/**
//	 * テストID：PXWXML_N_001_29 運用ツール正常系
//	 */
//	@Test
//	public void testPXWXML_N_001_29() throws Exception {
//
//		// property設定
//		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
//		// テスト実行
//		execTest(p,"HHH_001");
//
//	}
	/**
	 * テストID：PXWXML_N_001_30 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_30() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"HHH_002");

	}
//	/**
//	 * テストID：PXWXML_N_001_31 運用ツール正常系
//	 */
//	@Test
//	public void testPXWXML_N_001_31() throws Exception {
//
//		// property設定
//		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
//		// テスト実行
//		execTest(p,"HHH_003");
//
//	}
	/**
	 * テストID：PXWXML_N_001_32運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_32() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"HHH_004");

	}
	/**
	 * テストID：PXWXML_N_001_33運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_33() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"HHH_005");

	}
	/**
	 * テストID：PXWXML_N_001_34 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_34() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"HHH_006");

	}
	/**
	 * テストID：PXWXML_N_001_35 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_35() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"HHH_007");

	}
	/**
	 * テストID：PXWXML_N_001_36 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_36() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"HHH_008");

	}
	/**
	 * テストID：PXWXML_N_001_37 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_37() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_001");

	}
	/**
	 * テストID：PXWXML_N_001_38 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_38() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_002");

	}
	/**
	 * テストID：PXWXML_N_001_39 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_39() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_003");

	}
	/**
	 * テストID：PXWXML_N_001_40 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_40() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_004");

	}
	/**
	 * テストID：PXWXML_N_001_41運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_41() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_005");

	}
	/**
	 * テストID：PXWXML_N_001_42運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_42() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_006");

	}
	/**
	 * テストID：PXWXML_N_001_43運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_43() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_007");

	}
	/**
	 * テストID：PXWXML_N_001_44運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_44() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_008");

	}
	/**
	 * テストID：PXWXML_N_001_45運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_45() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"III_009");

	}
	/**
	 * テストID：PXWXML_N_001_46運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_46() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"JJJ_001");

	}
	/**
	 * テストID：PXWXML_N_001_47運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_47() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"JJJ_002");

	}
	/**
	 * テストID：PXWXML_N_001_48運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_48() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"JJJ_003");

	}
	/**
	 * テストID：PXWXML_N_001_49運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_49() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"JJJ_004");

	}
	/**
	 * テストID：PXWXML_N_001_50運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_50() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"JJJ_005");

	}
	/**
	 * テストID：PXWXML_N_001_51運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_51() throws Exception {

		// property設定
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// テスト実行
		execTest(p,"JJJ_006");

	}

}
