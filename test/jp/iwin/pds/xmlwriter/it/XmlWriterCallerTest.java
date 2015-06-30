package jp.iwin.pds.xmlwriter.it;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import jp.co.dgic.testing.framework.DJUnitTestCase;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.transformer.XmlWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.ibm.db2.jcc.DB2Driver;

/**
 * 運用ツール親テストクラス。
 * <P>
 * テストケース全体での共通処理部分を定義する。
 * </P>
 * @author $Author: park.js $
 */
abstract class XmlWriterCallerTest extends DJUnitTestCase {

	/**
	 * ログ出力
	 */
	protected Log log = LogFactory.getLog(this.getClass());

	// 正常パラメータ
	protected String driver = null;
	protected String url = null;
	protected String username = null;
	protected String password = null;
	protected String productCD = null;
	protected String xmlbase = null;

	private static Properties propsOrg = PUTPropertyUtil.getProps();

	/**
	 * DB接続パラメータ等を設定。
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		driver = DB2Driver.class.getName();
		url = "jdbc:db2://192.168.100.2:50001/PDSDB4IT";
		username = "pdsiadm";
		password = "pdsiadm";
		productCD = "AAA_001";
		xmlbase = "Z:/OutputXML/xml/XmlWriter/out/" + getTestcaseID();

		PUTPropertyUtil.setProperty(propsOrg);

		log.info("##### " + this.getTestcaseID() + " #####");
	}

	/**
	 * @return テストケースID
	 */
	protected String getTestcaseID() {
		return this.getName().substring(4);
	}

	/**
	 * 運用ツール実行。
	 *
	 * @throws EMRException 運用ツール実装例外
	 */
	protected void execXmlWriter() throws EMRException {
		new XmlWriter(this.driver, this.url, this.username, this.password, this.productCD, this.xmlbase).write();
	}

	/**
	 * @param productCD 案件コード
	 * @throws EMRException 運用ツール実装例外
	 */
	protected void execXmlWriter(String productCD) throws EMRException {
		new XmlWriter(this.driver, this.url, this.username, this.password, productCD, this.xmlbase).write();
	}

	/**
	 * SQLセッションを取得する。
	 * <OL>
	 *  <LI>JDBC接続用プロパティを取得する。</LI>
	 *  <LI>MyBATIS設定ファイルを読込む。</LI>
	 *  <LI>JDBC接続用プロパティ、MyBATIS設定ファイルから、
	 *セッションファクトリーを生成する。</LI>
	 *  <LI>セッションファクトリーから、AutoCommit:falseのセッションを取得する。</LI>
	 *  <LI>上記の処理で例外が発生した場合は、
	 *発生した例外に応じたエラーコードでEMRExceptionを生成してthrowする。</LI>
	 *  <LI>取得したセッションを返却する。</LI>
	 * </OL>
	 * @return SQLセッション
	 * @throws IOException
	 *             IO例外
	 */
	protected SqlSession getSqlSession() throws IOException {
		Properties props = new Properties();

		props.setProperty(PDSConstants.JDBC_DRIVER.toString(), this.driver);
		props.setProperty(PDSConstants.JDBC_URL.toString(), this.url);
		props.setProperty(PDSConstants.JDBC_USER_NAME.toString(), this.username);
		props.setProperty(PDSConstants.JDBC_PASSWORD.toString(), this.password);

		Reader reader = Resources.getResourceAsReader("mapper_config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sesseionFactory = builder.build(reader, props);

		return sesseionFactory.openSession();
	}

	/**
	 * 出力先ディレクトリ作成。
	 *
	 * @throws IOException 作成失敗
	 */
	protected void createOutputDir() throws IOException {
		createDir(new File(this.xmlbase));
	}

	/**
	 * ディレクトリ作成。
	 *
	 * @param dirname ディレクトリ名
	 * @return 作成したディレクトリ
	 * @throws IOException 作成失敗
	 */
	protected File createDir(File dir) throws IOException {

		if (dir.exists()) {
			deleteDir(dir);
		} else if (!dir.mkdir()) {
			throw new IOException("mkdir fail.:" + dir.getAbsolutePath());
		}

		return dir;
	}

	/**
	 * ディレクトリ削除。
	 *
	 * @param dir ディレクトリ
	 * @throws IOException 削除失敗
	 */
	protected void deleteDir(File dir) throws IOException {

		for (File f : dir.listFiles(getXmlNameFilter())) {

			if (f.isDirectory()) {
				deleteDir(f);
			}
			if (!f.delete()) {
				throw new IOException("delete fail.:" + f.getAbsolutePath());
			}
		}
	}

	/**
	 * DBへデータ投入。
	 * <P>
	 * 更新プロパティで指定したXMLファイルの内容をDBへ投入する。
	 * </P>
	 * @param p 更新プロパティ
	 * @throws InitializeException DBへのデータ投入失敗
	 */
	protected void initDB(Properties p) throws InitializeException {

		PUTPropertyUtil.setProperty(p);

		Properties props = new Properties();

		props.setProperty(PDSConstants.JDBC_DRIVER.toString(), this.driver);
		props.setProperty(PDSConstants.JDBC_URL.toString(), this.url);
		props.setProperty(PDSConstants.JDBC_USER_NAME.toString(), this.username);
		props.setProperty(PDSConstants.JDBC_PASSWORD.toString(), this.password);

		//		try {
		////			PDSEngine.excuteXML2DB(props);
		//		} catch (InitializeException e) {
		//			// TODO 自動生成された catch ブロック
		//			e.printStackTrace();
		//		}
	}

	/**
	 * 正常系テスト実行。
	 * <P>
	 * 使用プロパティで指定した比較元データを基に正常系テストを実施する。
	 * </P>
	 * @param p 使用プロパティ
	 * @throws InitializeException DBデータ投入失敗
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException 業務例外
	 */
	protected void execTest(Properties p) throws InitializeException, IOException, EMRException {

		// DBデータ投入
		initDB(p);

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter();

		// 出力ファイル比較
		diffResult();
	}

	/**
	 * 正常系テスト実行。
	 * <P>
	 * 使用プロパティで指定した比較元データを基に正常系テストを実施する。
	 * </P>
	 * @param p 使用プロパティ
	 * @param productDC 案件コード
	 * @throws InitializeException DBデータ投入失敗
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException 業務例外
	 */
	protected void execTest(Properties p, String productCD) throws InitializeException, IOException, EMRException {

		// DBデータ投入
		initDB(p);

		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		execXmlWriter(productCD);

		// 出力ファイル比較
		diffResult();
	}

	protected void diffResult() throws IOException {
		// 出力先ディレクトリ比較
		File[] xmlFiles = new File(this.xmlbase).listFiles(getXmlNameFilter());

		for (File xmlFile : xmlFiles) {
			String fileName = xmlFile.getName();
			String result = readFile(xmlFile.getAbsolutePath());
			String org;

			// XML管理ファイル
			if (PDSConstants.FILE_META.equals(fileName)) {
				org = readFile(PUTPropertyUtil.getProperty("xml.meta.filepath"));
			} else {
				org = readFile(PUTPropertyUtil.getProperty("xml.datamodel.base") + '/' + fileName);
			}
			assertEquals(org, result);
		}
	}

	/**
	 * ファイル読込み。
	 * <P>
	 * 指定されたファイル内容を行毎にtrimして連結した文字列を取得する。
	 * </P>
	 * @param file 読み込むファイルパス
	 * @return 取得したファイル内容文字列
	 * @throws IOException ファイル読込み例外
	 */
	private String readFile(String file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		StringBuilder temp = new StringBuilder();

		try {
			while (in.ready()) {
				temp.append(in.readLine().trim());

				if ('>' != temp.charAt(temp.length() - 1)) {
					temp.append(' ');
				}
			}
		} finally {
			in.close();
		}

		return temp.toString();
	}

	/**
	 * XML選択用フィルター取得。
	 * <P>
	 * 拡張子がXMLのファイルのみ選択されるファイル名フィルターを取得。
	 * </P>
	 * @return ファイル名フィルター
	 */
	private FilenameFilter getXmlNameFilter() {
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(PDSConstants.FILE_XML.toString());
			}
		};
	}

}
