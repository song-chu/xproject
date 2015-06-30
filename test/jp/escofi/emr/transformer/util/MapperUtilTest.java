package jp.escofi.emr.transformer.util;

import jp.co.dgic.testing.framework.DJUnitTestCase;
import jp.escofi.emr.engine.common.constant.DataType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MapperUtilTest extends DJUnitTestCase {

	private Log logger = LogFactory.getLog(MapperUtilTest.class);

	/**
	 * テストID:PUTMap_N_001_1
	 * 対象：getDataTypeByCd(String)（属性タイプ取得）
	 * 存在する属性タイプCDで検索
	 */
	@Test
	public void testPUTMap_N_001_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "01";
		logger.info("入力値：" + parameter);

		// テスト対象メソッド実行
		DataType result = MapperUtil.getDataTypeByCd(parameter);

		// 結果確認
		logger.info("結果値：" + result);
		assertEquals(DataType.SINGLE, result);
	}

	/**
	 * テストID:PUTMap_N_001_2
	 * 対象：getDataTypeByCd(String)（属性タイプ取得）
	 * 存在する属性タイプCDで検索
	 */
	@Test
	public void testPUTMap_N_001_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "06";
		logger.info("入力値：" + parameter);

		// テスト対象メソッド実行
		DataType result = MapperUtil.getDataTypeByCd(parameter);

		// 結果確認
		logger.info("結果値：" + result);
		assertEquals(DataType.SET, result);
	}

	/**
	 * テストID:PUTMap_E_001_1
	 * 対象：getDataTypeByCd(String)（属性タイプ取得）
	 * 存在しない属性タイプCDで検索
	 */
	@Test
	public void testPUTMap_E_001_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "07";
		logger.info("入力値：" + parameter);

		try{
			// テスト対象メソッド実行
			MapperUtil.getDataTypeByCd(parameter);

		} catch(IllegalArgumentException e) {
			// 結果確認
			logger.debug(e.getMessage());
		}
	}

	/**
	 * テストID:PUTMap_E_001_2
	 * 対象：getDataTypeByCd(String)（属性タイプ取得）
	 * nullケース
	 */
	@Test
	public void testPUTMap_E_001_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = null;
		logger.info("入力値：" + parameter);

		try{
			// テスト対象メソッド実行
			MapperUtil.getDataTypeByCd(parameter);

		} catch(IllegalArgumentException e) {
			// 結果確認
			logger.debug(e.getMessage());
		}
	}

	/**
	 * テストID:PUTMap_E_001_3
	 * 対象：getDataTypeByCd(String)（属性タイプ取得）
	 * 空文字ケース
	 */
	@Test
	public void testPUTMap_E_001_3() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "";
		logger.info("入力値：" + parameter);

		try{
			// テスト対象メソッド実行
			MapperUtil.getDataTypeByCd(parameter);

		} catch(IllegalArgumentException e) {
			// 結果確認
			logger.debug(e.getMessage());
		}
	}

	/**
	 * テストID:PUTMap_N_002_1
	 * 対象：getDataTypeNameByCd(String)（属性タイプ名取得）
	 * 存在する属性タイプCDで検索
	 */
	@Test
	public void testPUTMap_N_002_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "01";
		logger.info("入力値：" + parameter);

		// テスト対象メソッド実行
		String result = MapperUtil.getDataTypeNameByCd(parameter);

		// 結果値設定
		String expected = "single";

		// 結果確認
		logger.info("結果値：" + result);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMap_N_002_2
	 * 対象：getDataTypeNameByCd(String)（属性タイプ名取得）
	 * 存在する属性タイプCDで検索
	 */
	@Test
	public void testPUTMap_N_002_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "06";
		logger.info("入力値：" + parameter);

		// テスト対象メソッド実行
		String result = MapperUtil.getDataTypeNameByCd(parameter);

		// 結果値設定
		String expected = "set";

		// 結果確認
		logger.info("結果値：" + result);
		assertEquals(expected, result);
	}

	/**
	 * テストID:PUTMap_E_002_1
	 * 対象：getDataTypeNameByCd(String)（属性タイプ名取得）
	 * 存在しない属性タイプCDで検索
	 */
	@Test
	public void testPUTMap_E_002_1() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "07";
		logger.info("入力値：" + parameter);

		try{
			// テスト対象メソッド実行
			MapperUtil.getDataTypeNameByCd(parameter);

		} catch(IllegalArgumentException e) {
			// 結果確認
			logger.debug(e.getMessage());
		}
	}

	/**
	 * テストID:PUTMap_E_002_2
	 * 対象：getDataTypeNameByCd(String)（属性タイプ名取得）
	 * nullケース
	 */
	@Test
	public void testPUTMap_E_002_2() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = null;
		logger.info("入力値：" + parameter);

		try{
			// テスト対象メソッド実行
			MapperUtil.getDataTypeNameByCd(parameter);

		} catch(IllegalArgumentException e) {
			// 結果確認
			logger.debug(e.getMessage());
		}
	}

	/**
	 * テストID:PUTMap_E_002_3
	 * 対象：getDataTypeNameByCd(String)（属性タイプ名取得）
	 * 空文字ケース
	 */
	@Test
	public void testPUTMap_E_002_3() throws Exception {

		logger.info("########## " + this.getName() + " 開始 ##########");

		// 入力値設定
		String parameter = "";
		logger.info("入力値：" + parameter);

		try{
			// テスト対象メソッド実行
			MapperUtil.getDataTypeNameByCd(parameter);

		} catch(IllegalArgumentException e) {
			// 結果確認
			logger.debug(e.getMessage());
		}
	}
}
