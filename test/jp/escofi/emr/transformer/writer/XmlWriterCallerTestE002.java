package jp.escofi.emr.transformer.writer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.XmlWriterCaller;

import org.junit.Test;

/**
 * 運用ツールテストクラス（E002系）
 * <P>
 * 運用ツール異常(起動パラメータチェック)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: devuser05 $
 */
public class XmlWriterCallerTestE002 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_002_1 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_1() throws Exception {

		// 異常値
		this.driver = null;
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_2 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_2() throws Exception {

		// 異常値
		this.driver = "";
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_3 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_3() throws Exception {

		// 異常値
		this.url = null;
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_4 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_4() throws Exception {

		// 異常値
		this.url = "";
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_5 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_5() throws Exception {

		// 異常値
		this.username = null;
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_6 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_6() throws Exception {

		// 異常値
		this.username = "";
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_7 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_7() throws Exception {

		// 異常値
		this.password = null;
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_8 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_8() throws Exception {

		// 異常値
		this.password = "";
		this.checkParameter("引数不正。JDBC接続情報が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_9 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_9() throws Exception {

		// 異常値
		this.productCD = null;
		this.checkParameter("引数不正。案件コードが指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_10 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_10() throws Exception {

		// 異常値
		this.productCD = "";
		this.checkParameter("引数不正。案件コードが指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_11 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_11() throws Exception {

		// 異常値
		this.xmlbase = null;
		this.checkParameter("引数不正。XMLファイル出力先が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_12 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_12() throws Exception {

		// 異常値
		this.xmlbase = "";
		this.checkParameter("引数不正。XMLファイル出力先が指定されていません。");
	}

	/**
	 * テストID：PXWXML_E_002_13 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_002_13() throws Exception {

		// 異常値
		this.productCD = "ZZZZZ_99999";
		this.checkParameter("案件CDの桁数が不正です。(案件CD：" + this.productCD + ")");
	}


	/**
	 * チェックパラメータテスト用メソッド
	 * @param expectedMessage
	 *            期待値メッセージ
	 *
	 * @throws Exception
	 */
	private void checkParameter(String expectedMessage) throws Exception {
		Method method = XmlWriterCaller.class.getDeclaredMethod(
				"checkParameter", String.class, String.class, String.class,
				String.class, String.class, String.class);

		method.setAccessible(true);

		try {
			method.invoke(null, driver, url, username, password, productCD,
					xmlbase);
			fail();
		} catch (InvocationTargetException ex) {
			Throwable throwable = ex.getTargetException();
			if (throwable instanceof EMRException) {
				assertEquals(expectedMessage, throwable.getMessage());
			}
		}
	}

}
