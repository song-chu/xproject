package jp.escofi.emr.transformer;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.ProductMapper;
import jp.escofi.emr.transformer.writer.DatamodelinfoWriter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xml.sax.SAXException;

/**
 * 運用ツール。
 * <DL>
 * <DT>使用目的/機能概要：
 * <DD>データベースに登録されたデータモデル情報をXMLファイルへ出力する。
 * <DT>サンプルコード：
 * <DD>他メソッドから呼出し例
 * <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'>
 * <TT>
 *  XmlWriter writer = new XmlWriter();
 *
 *  String driver = "com.ibm.db2.jcc.DB2Driver";
 *  String url = "jdbc:db2://192.168.100.2:50001/SAMPLE";
 *  String username = "username";
 *  String password = "password";
 *  String productCd = "案件番号01";
 *  String xmlbase = "/home/pdsuser/XMLs/TestData";
 *
 *  XmlWriter xmlWriter = new XmlWriter(driver, url, username, password, productCd, xmlbase);
 *
 *  xmlWriter.write();
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
public class XmlWriter {

	/**
	 * DB接続ドライバー
	 */
	private String driver;
	/**
	 * DB接続先
	 */
	private String url;
	/**
	 * DB接続ユーザ名
	 */
	private String userName;
	/**
	 * DB接続パスワード
	 */
	private String password;
	/**
	 * 案件番号
	 */
	private String productCd;
	/**
	 * XML出力先
	 */
	private String xmlBase;


	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>引数をクラス変数に保持する。
	 * </DL>
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
	 */
	public XmlWriter(String driver, String url, String userName,
			String password, String productCd, String xmlBase) {
		super();
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.productCd = productCd;
		this.xmlBase = xmlBase;
	}

	/**
	 * XML出力処理。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>XMLファイル管理・データモデルXMLを出力する。
	 *    <OL>
	 *     <LI>SQLセッションを取得する。</LI>
	 *     <LI>案件コードチェックをする。</LI>
	 *     <LI>XMLファイル管理・データモデルXML出力処理を呼出す。</LI>
	 *     <LI>上記の処理で例外が発生した場合は、
	 *発生した例外に応じたエラーコードでEMRExceptionを生成してthrowする。</LI>
	 *    </OL>
	 * </DL>
	 * @throws EMRException
	 *             業務例外
	 */
	public void write() throws EMRException {
		SqlSession session = null;

		try {
			session = getSqlSession();

			checkProductCd(session);

			DatamodelinfoWriter writer = new DatamodelinfoWriter(
					productCd, xmlBase);

			writer.write(session);
		} catch (IOException e) {
			throw new EMRException(MessageCode.EMR_B_P904E,
					new Object[] { xmlBase }, e);
		} catch (ParserConfigurationException e) {
			throw new EMRException(MessageCode.EMR_B_P905E,
					new Object[] { xmlBase }, e);
		} catch (SAXException e) {
			throw new EMRException(MessageCode.EMR_B_P905E,
					new Object[] { xmlBase }, e);
		} catch (RuntimeException e) {
			Throwable err = e;

			while (err.getCause() != null) {
				err = err.getCause();

				if (err instanceof SQLException) {
					throw new EMRException(MessageCode.EMR_B_P909E, e);
				}
			}
			throw new EMRException(MessageCode.EMR_B_P910E, e);
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}


	/**
	 * SQLセッションを取得する。
	 * <OL>
	 *  <LI>JDBC接続用プロパティを取得する。</LI>
	 *  <LI>MyBATIS設定ファイルを読込む。</LI>
	 *  <LI>JDBC接続用プロパティ、MyBATIS設定ファイルから、
	 *セッションファクトリーを生成する。</LI>
	 *  <LI>セッションファクトリーから、AutoCommit:trueのセッションを取得する。</LI>
	 *  <LI>上記の処理で例外が発生した場合は、
	 *発生した例外に応じたエラーコードでEMRExceptionを生成してthrowする。</LI>
	 *  <LI>取得したセッションを返却する。</LI>
	 * </OL>
	 * @return SQLセッション
	 * @throws EMRException
	 *             業務例外
	 */
	private SqlSession getSqlSession() throws EMRException {
		Properties props = getDBProperties();
		SqlSession session = null;

		try {
			Reader reader = Resources
					.getResourceAsReader(PDSConstants.CONF_MY_BATIS.toString());
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sesseionFactory = builder.build(reader, props);

			session = sesseionFactory.openSession(true);
		} catch (IOException e) {
			throw new EMRException(MessageCode.EMR_B_P904E,
					new Object[] { PDSConstants.CONF_MY_BATIS.toString() });
		} catch (RuntimeException e) {
			throw new EMRException(MessageCode.EMR_B_P903E, e);
		}
		return session;
	}

	/**
	 * DB接続情報のプロパティ取得。
	 *
	 * @return DB接続情報のプロパティ
	 */
	private Properties getDBProperties() {
		Properties props = new Properties();

		props.setProperty(PDSConstants.JDBC_DRIVER.toString(), driver);
		props.setProperty(PDSConstants.JDBC_URL.toString(), url);
		props.setProperty(PDSConstants.JDBC_USER_NAME.toString(), userName);
		props.setProperty(PDSConstants.JDBC_PASSWORD.toString(), password);

		return props;
	}

	/**
	 * 案件コードチェック。
	 * <OL>
	 *  <LI>案件コードの存在チェックをする。</LI>
	 *  <LI>上記のチェックに失敗した場合は、EMRExceptionを生成してthrowする。</LI>
	 * </OL>
	 * @param session SQLセッション
	 * @throws EMRException - 案件コードが存在しない場合
	 */
	private void checkProductCd(SqlSession session) throws EMRException {
		ProductMapper pMapper = session.getMapper(ProductMapper.class);

		if (pMapper.count(productCd) < 1) {
			throw new EMRException(MessageCode.EMR_B_P906E,
					new Object[] { productCd });
		}
	}

}
