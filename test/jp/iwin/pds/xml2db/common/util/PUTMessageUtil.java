package jp.iwin.pds.xml2db.common.util;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * メッセージユーティリティ。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>システムにて利用するメッセージを外部プロパティファイルから取得するユーティリティクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1802 $
 *  <DT>最終開発日時：
 *   <DD>$Date:: 2010-12-17 17:50:#$
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
 * @author $Author: seo.yj $
 */
public class PUTMessageUtil {
	/**
	 * ログ出力
	 */
	private static final Log logger = LogFactory.getLog(PUTMessageUtil.class);
	/**
	 * デフォルトメッセージファイル名。
	 */
	public static final String MESSAGE_FILE = "pdsmessages.properties";
	/**
	 * メッセージのキーと値を保持するオブジェクト。
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
				.getResourceAsStream(MESSAGE_FILE);

		Properties p = new Properties();
//		Map<String, String> localProps = new HashMap<String, String>();

		try {
			p.load(is);
		} catch (Exception e) {
			logger.error("メッセージ設定ファイル取得中エラーが発生しました。Exception:" + e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				logger.error("メッセージ設定ファイルクローズ中エラーが発生しました。Exception:" + e);
			}
		}

		return p;
	}

	/**
	 * キーのメッセージ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>指定されたキーのメッセージを取得し、その結果を返す。
	 * </DL>
	 * @param key メッセージのキー
	 * @return 指定されたキーのメッセージの値
	 */
	public static String getMessage(String key) {
		if (key == null) {
			return key;
		}
		return props.getProperty(key);
	}

	/**
	 * メッセージ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>指定されたキーのメッセージを取得する。
	 *   <DD>メッセージが見つからなかった場合には、指定されたデフォルトが返される
	 * </DL>
	 * @param key メッセージのキー
	 * @param defaultValue メッセージのデフォルト値
	 * @return 指定されたキーのメッセージの値
	 */
	public static String getMessage(String key, String defaultValue) {
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
	 * メッセージ取得（置換文字対応）。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>指定されたキーのメッセージに含まれている{0}・・・{n}を指定した置換文字に換えてメッセージを形成する。
	 *   <DD>小数点を含む数字、日付も対応
	 * </DL>
	 * @param key メッセージのキー
	 * @param arguments	置換文字の配列
	 * @return 指定されたキーのメッセージの値
	 */
	public static String getMessage(String key, Object[] arguments) {
		if (key == null) {
			return key;
		}
		String pattern = props.getProperty(key);
		if (pattern == null) {
			return pattern;
		}

		return MessageFormat.format(pattern, arguments);
	}
}
