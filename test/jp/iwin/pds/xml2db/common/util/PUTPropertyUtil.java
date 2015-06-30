package jp.iwin.pds.xml2db.common.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * プロパティユーティリティ。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>システムにて利用する設定情報を外部プロパティファイルから取得するユーティリティクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1039 $
 *  <DT>最終開発日時：
 *   <DD>$Date:: 2010-12-21 14:51:27#$
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PUTPropertyUtil {
	/**
	 * ログ出力
	 */
	private static final Log logger = LogFactory.getLog(PUTPropertyUtil.class);
	/**
	 * デフォルトプロパティファイル名。
	 */
	private static final String PROPERTY_FILE = "outputxml.properties";
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
//		Map<String, String> localProps = new HashMap<String, String>();

		try {
			p.load(is);
		} catch (Exception e) {
			logger.error("プロパティファイル取得中エラーが発生しました。Exception:" + e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				logger.error("プロパティファイルクローズエラーが発生しました。Exception:" + e);
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

	/**
	 * 差分プロパティ設定。
	 * <P>
	 * 現在のプロパティに引数のプロパティを追加する。<BR>
	 * 既に設定済みのプロパティの場合は、引数のプロパティの値に更新する。
	 * </P>
	 * @param p 追加、もしくは更新するプロパティ
	 */
	public static void setProperty(Properties p) {
		props.putAll(p);
	}

	/**
	 * @return 現在のプロパティ
	 */
	public static Properties getProps() {
		return new Properties(props);
	}
}
