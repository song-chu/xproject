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
public final class XmlWriterCallerTestN001_153 extends XmlWriterCallerTest {

	private Properties setProperty(String xmlName){
		Properties prop = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_N003";
		prop.setProperty("xml.meta.filepath", base +'/'+xmlName+"_Meta.xml");
		prop.setProperty("xml.datamodel.base",base);
		prop.setProperty("DBDeleteFlg", Boolean.toString(true));
		prop.setProperty("productID", "1");

		return prop;

	}

	/**
	 * テストID：PXWXML_N_001_153 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_153() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_101");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_154 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_154() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_102");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_155 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_155() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_103");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_156 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_156() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_104");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_157 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_157() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_105");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_158 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_158() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_106");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_159 運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_159() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_107");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_160運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_160() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_108");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_161運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_161() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_109");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_162運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_162() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_110");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_163運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_163() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_111");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_164運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_164() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_112");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_165運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_165() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_113");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_166運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_166() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_114");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_167運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_167() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_115");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_168運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_168() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_116");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_169運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_169() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_117");

		// テスト実行
		execTest(p);
	}

	/**
	 * テストID：PXWXML_N_001_170運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_170() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_118");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_171運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_171() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_119");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_172運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_172() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_120");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_173運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_173() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_121");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_174運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_174() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_122");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_175運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_175() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_123");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_176運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_176() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_124");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_177運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_177() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_125");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_178運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_178() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_126");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_179運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_179() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_127");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_180運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_180() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_128");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_181運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_181() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_129");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_182運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_182() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_130");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_183運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_183() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_131");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_184運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_184() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_132");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_185運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_185() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_133");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_186運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_186() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_134");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_187運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_187() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_135");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_188運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_188() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_136");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_189運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_189() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_137");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_190運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_190() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_138");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_191運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_191() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_139");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_192運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_192() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_140");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_193運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_193() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_141");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_194運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_194() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_142");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_195運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_195() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_143");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_196運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_196() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_144");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_197運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_197() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_145");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_198運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_198() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_146");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_199運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_199() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_147");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_200運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_200() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_148");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_201運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_201() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_149");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_202運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_202() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_150");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_203運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_203() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_151");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_204運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_204() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_152");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_205運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_205() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_153");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_206運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_206() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_154");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_207運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_207() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_155");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_208運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_208() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_156");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_209運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_209() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_157");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_210運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_210() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_158");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_211運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_211() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_159");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_212運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_212() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_160");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_213運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_213() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_161");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_214運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_214() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_162");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_215運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_215() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_163");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_216運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_216() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_164");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_217運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_217() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_165");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_218運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_218() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_166");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_219運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_219() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_167");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_220運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_220() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_168");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_221運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_221() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_169");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_222運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_222() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_170");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_223運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_223() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_171");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_224運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_224() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_172");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_225運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_225() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_173");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_226運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_226() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_174");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_227運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_227() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_175");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_228運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_228() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_176");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_229運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_229() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_177");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_230運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_230() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_178");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_231運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_231() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_179");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_232運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_232() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_180");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_233運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_233() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_181");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_234運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_234() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_182");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_235運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_235() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_183");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_236運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_236() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_184");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_237運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_237() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_185");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_238運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_238() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_186");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_239運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_239() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_187");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_240運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_240() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_188");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_241運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_241() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_189");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_242運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_242() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_190");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_243運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_243() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_191");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_244運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_244() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_192");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_245運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_245() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_193");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_246運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_246() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_194");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_247運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_247() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_195");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_248運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_248() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_196");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_249運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_249() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_197");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_250運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_250() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_198");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_251運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_251() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_199");

		// テスト実行
		execTest(p);
	}
	/**
	 * テストID：PXWXML_N_001_252運用ツール正常系
	 */
	@Test
	public void testPXWXML_N_001_252() throws Exception {
		// property設定
		Properties p = setProperty("PENSER_N_002_200");

		// テスト実行
		execTest(p);
	}
}
