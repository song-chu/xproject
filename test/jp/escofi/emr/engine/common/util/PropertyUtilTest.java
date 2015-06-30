package jp.escofi.emr.engine.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import jp.escofi.emr.DJUnitTestCaseEx;

import org.junit.Test;

public class PropertyUtilTest extends DJUnitTestCaseEx {

	/**
	 * リソースベースフォルダ
	 */
	protected static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	public PropertyUtilTest() {

		super(PropertyUtilTest.class, BASE_FOLDER);
	}

	/**
	 * テストID:PUTPro_N_001_1
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_1() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "xml.meta.filepath";
		String expected = "Z:/PDSNgine/xml/XML_Meta.xml";
		super.log.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_001_2
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_2() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "xml.test.filepath";
		String expected = null;
		super.log.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_001_3
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_3() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = null;
		String expected = null;
		super.log.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_001_4
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_001_4() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "";
		String expected = null;
		super.log.info("入力値：" + parameter1);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_002_1
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_1() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "xml.meta.filepath";
		String parameter2 = "T:/TEST/xml/XML_Meta.xml";
		String expected = "Z:/PDSNgine/xml/XML_Meta.xml";
		super.log.info("入力値（プロパティのキー）：" + parameter1);
		super.log.info("入力値（プロパティのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_002_2
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_2() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "xml.datamodel.base";
		String parameter2 = null;
		String expected = "Z:/PDSNgine/xml";
		super.log.info("入力値（プロパティのキー）：" + parameter1);
		super.log.info("入力値（プロパティのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_002_3
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_3() throws Exception {

		String testCase = this.getName().substring(4);
		log.info("########## " + testCase + " ##########");

		// 入力値設定
		String parameter1 = "xml.datamodel.base";
		String parameter2 = "";
		super.log.info("入力値（プロパティのキー）：" + parameter1);
		super.log.info("入力値（プロパティのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// 結果確認
		super.log.info("結果値：" + BASE_FOLDER);
		assertEquals(BASE_FOLDER, result);
	}

	/**
	 * テストID:PUTPro_N_002_4
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_4() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "xml.test.filepath";
		String parameter2 = "/ebs/test/DATA/ABC_1234.xml";
		String expected = "/ebs/test/DATA/ABC_1234.xml";
		super.log.info("入力値（プロパティのキー）：" + parameter1);
		super.log.info("入力値（プロパティのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_002_5
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_5() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = null;
		String parameter2 = "/home/pdsuser/XMLs/TestData";
		String expected = null;
		super.log.info("入力値（プロパティのキー）：" + parameter1);
		super.log.info("入力値（プロパティのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_N_002_6
	 * @throws Exception
	 */
	@Test
	public void testPUTPro_N_002_6() throws Exception {

		super.replaceProp(this.getName().substring(4), "XML");

		// 入力値設定
		String parameter1 = "";
		String parameter2 = "/ebs/test/DATA/ABC_1234.xml";
		String expected = "/ebs/test/DATA/ABC_1234.xml";
		super.log.info("入力値（プロパティのキー）：" + parameter1);
		super.log.info("入力値（プロパティのデフォルト値）：" + parameter2);

		// テスト対象メソッド実行
		String result = PropertyUtil.getProperty(parameter1, parameter2);

		// 結果確認
		super.log.info("結果値：" + expected);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTPro_E_001_1
	 * @throws Exception
	 **/
	@Test
	public void testPUTPro_E_001_1() throws Exception {

		String testCase = this.getName().substring(4);
		log.info("########## " + testCase + " ##########");

		super.setReturnValueAt(Properties.class, "load", 0, new IOException());

		Method loadMethod = PropertyUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(PropertyUtil.class);
	}

	/**
	 * テストID:PUTPro_E_001_2
	 * @throws Exception
	 **/
	@Test
	public void testPUTPro_E_001_2() throws Exception {

		String testCase = this.getName().substring(4);
		log.info("########## " + testCase + " ##########");

		super.setReturnValueAt(InputStream.class, "close", 0, new IOException());

		Method loadMethod = PropertyUtil.class.getDeclaredMethod("load");
		loadMethod.setAccessible(true);
		loadMethod.invoke(PropertyUtil.class);
	}
}
