package jp.iwin.pds.xmlwriter.it;

import java.util.Properties;

import org.junit.Test;


/**
 * 運用ツールテストクラス（N001系）
 * <P>
 * 運用ツール正常系のテストメソッド定義クラス。
 * </P>
 * @author $Author$
 */
public final class XmlWriterCallerTestN001_053 extends XmlWriterCallerTest {

	private Properties setProperty(String xmlName){
		Properties prop = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_N002";
		prop.setProperty("xml.meta.filepath", base +'/'+xmlName+"_Meta.xml");
		prop.setProperty("xml.datamodel.base",base);

		return prop;

	}

	/**
	 * テストID：PXWXML_N_001_53 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_53() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_1");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_54 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_54() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_2");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_55 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_55() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_3");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_56 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_56() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_4");

		// テスト実行
		execTest(p);
	}
//	/**
//	 * テストID：PXWXML_N_001_57 運用ツール正常系
//	 * 値がカラムの最長桁数を超えるため、DBへ投入不可能
//	 * SQLCODE=-302, SQLSTATE=22001, SQLERRMC=null, DRIVER=3.58.82
//	 */
//	@Test
//	public void testPXWXML_N_001_57() throws Exception {
//		// property設定
//		Properties p = setProperty("PENSER_N_002_5");
//
//		// テスト実行
//		execTest(p);
//	}
	/**
	 * テストID：PXWXML_N_001_58 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_58() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_6");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_59 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_59() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_7");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_60運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_60() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_8");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_61運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_61() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_9");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_62運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_62() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_10");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_63運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_63() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_11");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_64運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_64() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_12");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_65運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_65() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_13");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_66運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_66() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_14");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_67運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_67() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_15");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_68運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_68() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_16");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_69運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_69() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_17");

		// テスト実行
		execTest(p);
	}

	/**
	 * テストID：PXWXML_N_001_70運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_70() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_18");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_71運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_71() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_19");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_72運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_72() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_20");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_73運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_73() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_21");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_74運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_74() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_22");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_75運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_75() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_23");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_76運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_76() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_24");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_77運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_77() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_25");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_78運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_78() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_26");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_79運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_79() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_27");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_80運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_80() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_28");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_81運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_81() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_29");

		// テスト実行
		execTest(p);
	}
//	/**
//	 * テストID：PXWXML_N_001_82運用ツール正常系
//	 * 値がカラムの最長桁数を超えるため、DBへ投入不可能
//	 * SQLCODE=-302, SQLSTATE=22001, SQLERRMC=null, DRIVER=3.58.82
//	 */
//	@Test
//	public void testPXWXML_N_001_82() throws Exception {
//		// property設定
//		Properties p = setProperty("PENSER_N_002_30");
//
//		// テスト実行
//		execTest(p);
//	}
	/**
	 * テストID：PXWXML_N_001_83運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_83() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_31");

		// テスト実行
		execTest(p);
	}
//	/**
//	 * テストID：PXWXML_N_001_84運用ツール正常系
//	 * 値がカラムの最長桁数を超えるため、DBへ投入不可能
//	 * SQLCODE=-302, SQLSTATE=22001, SQLERRMC=null, DRIVER=3.58.82
//	 */
//	@Test
//	public void testPXWXML_N_001_84() throws Exception {
//		// property設定
//		Properties p = setProperty("PENSER_N_002_32");
//
//		// テスト実行
//		execTest(p);
//	}
	/**
	 * テストID：PXWXML_N_001_85運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_85() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_33");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_86運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_86() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_34");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_87運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_87() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_35");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_88運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_88() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_36");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_89運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_89() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_37");

		// テスト実行
		execTest(p);
	}
//	/**
//	 * テストID：PXWXML_N_001_90運用ツール正常系
//	 *  値がカラムの最長桁数を超えるため、DBへ投入不可能
//	 * SQLCODE=-302, SQLSTATE=22001, SQLERRMC=null, DRIVER=3.58.82
//	 */
//	@Test
//	public void testPXWXML_N_001_90() throws Exception {
//		// property設定
//		Properties p = setProperty("PENSER_N_002_38");
//
//		// テスト実行
//		execTest(p);
//	}
	/**
	 * テストID：PXWXML_N_001_91運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_91() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_39");

		// テスト実行
		execTest(p);
	}
//	/**
//	 * テストID：PXWXML_N_001_92運用ツール正常系
//	 *  値がカラムの最長桁数を超えるため、DBへ投入不可能
//	 *  SQLCODE=-302, SQLSTATE=22001, SQLERRMC=null, DRIVER=3.58.82
//	 */
//	@Test
//	public void testPXWXML_N_001_92() throws Exception {
//		// property設定
//		Properties p = setProperty("PENSER_N_002_40");
//
//		// テスト実行
//		execTest(p);
//	}
	/**
	 * テストID：PXWXML_N_001_93運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_93() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_41");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_94運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_94() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_42");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_95運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_95() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_43");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_96運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_96() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_44");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_97運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_97() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_45");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_98運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_98() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_46");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_99運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_99() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_47");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_100運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_100() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_48");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_101運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_101() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_49");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_102運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_102() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_50");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_103運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_103() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_51");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_104運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_104() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_52");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_105運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_105() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_53");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_106運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_106() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_54");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_107運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_107() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_55");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_108運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_108() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_56");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_109運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_109() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_57");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_110運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_110() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_58");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_111運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_111() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_59");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_112運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_112() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_60");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_113運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_113() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_61");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_114運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_114() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_62");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_115運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_115() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_63");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_116運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_116() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_64");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_117運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_117() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_65");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_118運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_118() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_66");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_119運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_119() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_67");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_120運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_120() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_68");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_121運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_121() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_69");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_122運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_122() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_70");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_123運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_123() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_71");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_124運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_124() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_72");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_125運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_125() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_73");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_126運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_126() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_74");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_127運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_127() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_75");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_128運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_128() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_76");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_129運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_129() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_77");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_130運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_130() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_78");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_131運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_131() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_79");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_132運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_132() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_80");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_133運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_133() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_81");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_134運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_134() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_82");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_135運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_135() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_83");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_136運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_136() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_84");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_137運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_137() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_85");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_138運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_138() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_86");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_139運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_139() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_87");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_140運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_140() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_88");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_141運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_141() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_89");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_142運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_142() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_90");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_143運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_143() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_91");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_144運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_144() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_92");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_145運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_145() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_93");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_146運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_146() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_94");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_147運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_147() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_95");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_148運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_148() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_96");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_149運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_149() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_97");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_150運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_150() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_98");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_151運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_151() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_99");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_152運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_152() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_100");

		// テスト実行
		execTest(p);
	}
}
