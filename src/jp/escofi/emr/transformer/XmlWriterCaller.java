package jp.escofi.emr.transformer;

import java.util.Arrays;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.transformer.constant.MessageType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 運用ツール起動バッチ。
 * <DL>
 * <DT>使用目的/機能概要：
 * <DD>
 * <UL>
 * <LI>データベースに登録されたデータモデル情報をXMLファイルへ出力する。
 * <LI>パラメータは全て必須で、以下の順に指定する。
 *  <OL>
 *   <LI>DB接続ドライバー</LI>
 *   <LI>DB接続先</LI>
 *   <LI>DB接続ユーザ名</LI>
 *   <LI>DB接続パスワード</LI>
 *   <LI>案件コード</LI>
 *   <LI>XML出力先</LI>
 *  </OL>
 * </LI>
 * </UL>
 * <DT>サンプルコード：
 * <DD>起動コマンド例
 * <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'>
 * <TT>
 *  driver = "com.ibm.db2.jcc.DB2Driver"
 *  url = "jdbc:db2://192.168.100.2:50001/SAMPLE"
 *  username = "username"
 *  password = "password"
 *  productCd = "案件番号01"
 *  xmlbase = "/home/pdsuser/XMLs/TestData"
 *
 *  java jp.escofi.emr.transformer.XmlWriterCaller $driver $url $username $password $productCd $xmlbase
 * </TT>
 * </PRE>
 * <DT>初版情報（作成日・作成者）：
 * <DD>2011/08/01 EBS
 * <DT>変更履歴（変更日、変更者、変更内容）：
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS 新規作成
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public final class XmlWriterCaller {

	/**
	 * ログ出力
	 */
	private static final Log LOGGER = LogFactory.getLog(XmlWriterCaller.class);

	/**
	 * メイン処理。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>XMLファイル管理・データモデルXMLを出力する。
	 *    <OL>
	 *     <LI>プログラム起動引数の入力数チェック</LI>
	 *     <LI>パラメータチェック</LI>
	 *     <LI>開始ログ出力</LI>
	 *     <LI>XML出力処理</LI>
	 *     <LI>XML出力処理で異常が発生した場合は、異常終了(リターンコード値:1)</LI>
	 *     <LI>終了ログ出力</LI>
	 *     <LI>終了(リターンコード:0)</LI>
	 *    </OL>
	 * </DL>
	 * @param args プログラム起動引数
	 */
	public static void main(String[] args) {

		try {
			if (args == null || args.length != 6) {
				Object o = null;

				if (args != null) {
					o = Arrays.asList(args);
				}
				throw new EMRException(MessageCode.EMR_B_P908E, new Object[] { o });
			}
			String driver = args[0];
			String url = args[1];
			String userName = args[2];
			String password = args[3];
			String productCd = args[4];
			String xmlBase = args[5];

			checkParameter(driver, url, userName, password, productCd, xmlBase);

			LOGGER.info(MessageUtil.getMessage(
					MessageCode.EMR_B_P901I.toString(), new Object[] {
						productCd,
						xmlBase }));

			XmlWriter xmlWriter = new XmlWriter(driver, url, userName,
					password, productCd, xmlBase);

			xmlWriter.write();
		} catch (Exception e) {
			System.exit(1);
		}
		LOGGER.info(MessageUtil.getMessage(MessageCode.EMR_B_P902I.toString()));

		System.exit(0);
	}

	/**
	 * 起動パラメータチェック。
	 * <UL>
	 *  <LI>JDBC接続情報入力チェック</LI>
	 *  <LI>案件コード入力チェック</LI>
	 *  <LI>XMLファイル出力先入力チェック</LI>
	 * </UL>
	 * @param driver
	 *            DB接続ドライバー
	 * @param url
	 *            DB接続先
	 * @param userName
	 *            DB接続ユーザ名
	 * @param password
	 *            DB接続パスワード
	 * @param productCd
	 *            案件コード
	 * @param xmlBase
	 *            XML出力先
	 * @throws EMRException
	 *             パラメータチェックが通らなかった場合
	 */
	private static void checkParameter(String driver, String url, String userName,
			String password, String productCd, String xmlBase) throws EMRException {

		// JDBC接続情報が指定されていない場合
		if ((driver == null || driver.length() < 1)
				|| (url == null || url.length() < 1)
				|| (userName == null || userName.length() < 1)
				|| (password == null || password.length() < 1)) {
			throw new EMRException(MessageCode.EMR_B_P907E,
					new Object[] { MessageType.JDBC_INFO });
		}

		// 案件コードが指定されていない。
		if ((productCd == null || productCd.length() < 1)) {
			throw new EMRException(MessageCode.EMR_B_P907E,
					new Object[] { MessageType.PRODUCT_CD });
		} else if (10 < productCd.length()) {
			// 案件コードの桁数が多すぎる。
			throw new EMRException(MessageCode.EMR_B_P911E,
					new Object[] { productCd });
		}

		// XMLファイル出力先が指定されていない。
		if ((xmlBase == null || xmlBase.length() < 1)) {
			throw new EMRException(MessageCode.EMR_B_P907E,
					new Object[] { MessageType.XML_OUTPUT_PATH });
		}
	}

}
