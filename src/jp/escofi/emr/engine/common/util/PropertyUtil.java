package jp.escofi.emr.engine.common.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * プロパティユーティリティ。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>システムにて利用する設定情報を外部プロパティファイルから取得するユーティリティクラス。
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/08/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public class PropertyUtil {
	/**
	 * ログ出力
	 */
	private static final Log LOGGER = LogFactory.getLog(PropertyUtil.class);
	/**
	 * デフォルトプロパティファイル名。
	 */
	private static final String PROPERTY_FILE = "pds.properties";
	/**
	 * プロパティのキーと値を保持するオブジェクト。
	 */
	private static Properties props = load();

	/**
	 * プロパティロード。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>指定されたプロパティファイルを読み込む。
	 * </DL>
	 * @return プロパティ
	 */
	private static Properties load() {

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(PROPERTY_FILE);

		Properties p = new Properties();

		try {
			p.load(is);
		} catch (Exception e) {
			LOGGER.error("プロパティファイル取得中エラーが発生しました。Exception:" + e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				LOGGER.error("プロパティファイルクローズエラーが発生しました。Exception:" + e);
			}
		}

		return p;
	}

	/**
	 * プロパティ値取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>指定されたキーのプロパティを取得し、その結果を返す。
	 * </DL>
	 * @param key プロパティのキー
	 * @return 指定されたキーのプロパティの値
	 */
	public static String getProperty(String key) {
		if (key == null) {
			return key;
		}
		return props.getProperty(key);
	}

	/**
	 * プロパティ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>指定されたキーのプロパティを取得する。
	 *   <DD>プロパティが見つからなかった場合には、指定されたデフォルトが返される。
	 * </DL>
	 * @param key プロパティのキー
	 * @param defaultValue プロパティのデフォルト値
	 * @return 指定されたキーのプロパティの値
	 */
	public static String getProperty(String key, String defaultValue) {
		if (key == null) {
			return key;
		}
		String result = props.getProperty(key);
		if (result == null) {
			return defaultValue;
		}
		return result;
	}

}
