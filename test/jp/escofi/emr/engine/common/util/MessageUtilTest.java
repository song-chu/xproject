package jp.escofi.emr.engine.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import jp.co.dgic.testing.framework.DJUnitTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MessageUtilTest extends DJUnitTestCase {

	private Log logger = LogFactory.getLog(MessageUtilTest.class);

	/**
	 * テストID:PUTMes_N_001_1
	 */
	@Test
	public void testPUTMes_N_001_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P001E";
		String expected = "引数不正。検索対象のデータモデルが存在しません。(データモデル名：{0}）";
		logger.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_001_2
	 */
	@Test
	public void testPUTMes_N_001_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P999E";
		String expected = null;
		logger.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_001_3
	 */
	@Test
	public void testPUTMes_N_001_3() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = null;
		String expected = null;
		logger.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_001_4
	 */
	@Test
	public void testPUTMes_N_001_4() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "";
		String expected = null;
		logger.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_1
	 */
	@Test
	public void testPUTMes_N_002_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P001E";
		String parameter2 = "EBS１１２２３３";
		String expected = "引数不正。検索対象のデータモデルが存在しません。(データモデル名：{0}）";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_2
	 */
	@Test
	public void testPUTMes_N_002_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P001E";
		String parameter2 = null;
		String expected = "引数不正。検索対象のデータモデルが存在しません。(データモデル名：{0}）";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_3
	 */
	@Test
	public void testPUTMes_N_002_3() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P010E";
		String parameter2 = "";
		String expected = "予期せぬ状態が発生しました。";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_4
	 */
	@Test
	public void testPUTMes_N_002_4() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "E888";
		String parameter2 = "***defaultValue-aaa***";
		String expected = "***defaultValue-aaa***";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_5
	 */
	@Test
	public void testPUTMes_N_002_5() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = null;
		String parameter2 = "***defaultValue-bbb***";
		String expected = null;

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_6
	 */
	@Test
	public void testPUTMes_N_002_6() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "";
		String parameter2 = "***defaultValue-ccc***";
		String expected = "***defaultValue-ccc***";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_7
	 */
	@Test
	public void testPUTMes_N_002_7() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P777E";
		String parameter2 = "";
		String expected = "";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_002_8
	 */
	@Test
	public void testPUTMes_N_002_8() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P666E";
		String parameter2 = null;
		String expected = null;

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（メッセージのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_003_1
	 **/
	@Test
	public void testPUTMes_N_003_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P011E";
		String[] parameter2 = { "名前" };
		String expected = "名前が無効です。";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（置換文字の配列）：{'名前'}");

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_003_2
	 **/
	@Test
	public void testPUTMes_N_003_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P005E";
		Object[] parameter2 = { "XML管理ファイル", "PUTMes_N_003_2_Meta.xml" };
		String expected = "XML管理ファイルが無効です。（ファイル名：PUTMes_N_003_2_Meta.xml）";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（置換文字の配列）：{ 'XML管理ファイル', 'PUTMes_N_003_2_Meta.xml' }");

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_003_3
	 **/
	@Test
	public void testPUTMes_N_003_3() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = null;
		Object[] parameter2 = { "test.PUTMes_N_003_3.message" };
		String expected = null;

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（置換文字の配列）：{ 'test.PUTMes_N_003_3.message' }");

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_003_4
	 **/
	@Test
	public void testPUTMes_N_003_4() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P005E";
		Object[] parameter2 = { null, null };
		String expected = "nullが無効です。（ファイル名：null）";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（置換文字の配列）：{ null, null }");

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_003_5
	 **/
	@Test
	public void testPUTMes_N_003_5() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "P011E";
		Object[] parameter2 = { "" };
		String expected = "が無効です。";

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（置換文字の配列）：{ 空文字 }");

		// テスト対象メソッド実行
		String result = MessageUtil.getMessage(parameter1, parameter2);

		// 結果確認
		logger.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_N_003_6
	 **/
	@Test
	public void testPUTMes_N_003_6() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter1 = "PEEEEE";
		Object[] parameter2 = { "テストメッセージ" };
		String expected = null;

		logger.info("入力値（メッセージのキー）：" + parameter1);
		logger.info("入力値（置換文字の配列）：{ 'テストメッセージ' }");

		String result = MessageUtil.getMessage(parameter1, parameter2);

		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMes_E_001_1
	 **/
	@Test
	public void testPUTMes_E_001_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		super.setReturnValueAt(Properties.class, "load", 0, new IOException());

		Method loadMethod = MessageUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(MessageUtil.class);
	}

	/**
	 * テストID:PUTMes_E_001_2
	 **/
	@Test
	public void testPUTMes_E_001_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		super.setReturnValueAt(InputStream.class, "close", 0, new IOException());

		Method loadMethod = MessageUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(MessageUtil.class);
	}
}
