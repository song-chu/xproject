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
 * �^�p�c�[���e�e�X�g�N���X�B
 * <P>
 * �e�X�g�P�[�X�S�̂ł̋��ʏ����������`����B
 * </P>
 * @author $Author: park.js $
 */
abstract class XmlWriterCallerTest extends DJUnitTestCase {

	/**
	 * ���O�o��
	 */
	protected Log log = LogFactory.getLog(this.getClass());

	// ����p�����[�^
	protected String driver = null;
	protected String url = null;
	protected String username = null;
	protected String password = null;
	protected String productCD = null;
	protected String xmlbase = null;

	private static Properties propsOrg = PUTPropertyUtil.getProps();

	/**
	 * DB�ڑ��p�����[�^����ݒ�B
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
	 * @return �e�X�g�P�[�XID
	 */
	protected String getTestcaseID() {
		return this.getName().substring(4);
	}

	/**
	 * �^�p�c�[�����s�B
	 *
	 * @throws EMRException �^�p�c�[��������O
	 */
	protected void execXmlWriter() throws EMRException {
		new XmlWriter(this.driver, this.url, this.username, this.password, this.productCD, this.xmlbase).write();
	}

	/**
	 * @param productCD �Č��R�[�h
	 * @throws EMRException �^�p�c�[��������O
	 */
	protected void execXmlWriter(String productCD) throws EMRException {
		new XmlWriter(this.driver, this.url, this.username, this.password, productCD, this.xmlbase).write();
	}

	/**
	 * SQL�Z�b�V�������擾����B
	 * <OL>
	 *  <LI>JDBC�ڑ��p�v���p�e�B���擾����B</LI>
	 *  <LI>MyBATIS�ݒ�t�@�C����Ǎ��ށB</LI>
	 *  <LI>JDBC�ڑ��p�v���p�e�B�AMyBATIS�ݒ�t�@�C������A
	 *�Z�b�V�����t�@�N�g���[�𐶐�����B</LI>
	 *  <LI>�Z�b�V�����t�@�N�g���[����AAutoCommit:false�̃Z�b�V�������擾����B</LI>
	 *  <LI>��L�̏����ŗ�O�����������ꍇ�́A
	 *����������O�ɉ������G���[�R�[�h��EMRException�𐶐�����throw����B</LI>
	 *  <LI>�擾�����Z�b�V������ԋp����B</LI>
	 * </OL>
	 * @return SQL�Z�b�V����
	 * @throws IOException
	 *             IO��O
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
	 * �o�͐�f�B���N�g���쐬�B
	 *
	 * @throws IOException �쐬���s
	 */
	protected void createOutputDir() throws IOException {
		createDir(new File(this.xmlbase));
	}

	/**
	 * �f�B���N�g���쐬�B
	 *
	 * @param dirname �f�B���N�g����
	 * @return �쐬�����f�B���N�g��
	 * @throws IOException �쐬���s
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
	 * �f�B���N�g���폜�B
	 *
	 * @param dir �f�B���N�g��
	 * @throws IOException �폜���s
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
	 * DB�փf�[�^�����B
	 * <P>
	 * �X�V�v���p�e�B�Ŏw�肵��XML�t�@�C���̓��e��DB�֓�������B
	 * </P>
	 * @param p �X�V�v���p�e�B
	 * @throws InitializeException DB�ւ̃f�[�^�������s
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
		//			// TODO �����������ꂽ catch �u���b�N
		//			e.printStackTrace();
		//		}
	}

	/**
	 * ����n�e�X�g���s�B
	 * <P>
	 * �g�p�v���p�e�B�Ŏw�肵����r���f�[�^����ɐ���n�e�X�g�����{����B
	 * </P>
	 * @param p �g�p�v���p�e�B
	 * @throws InitializeException DB�f�[�^�������s
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �Ɩ���O
	 */
	protected void execTest(Properties p) throws InitializeException, IOException, EMRException {

		// DB�f�[�^����
		initDB(p);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		execXmlWriter();

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * ����n�e�X�g���s�B
	 * <P>
	 * �g�p�v���p�e�B�Ŏw�肵����r���f�[�^����ɐ���n�e�X�g�����{����B
	 * </P>
	 * @param p �g�p�v���p�e�B
	 * @param productDC �Č��R�[�h
	 * @throws InitializeException DB�f�[�^�������s
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �Ɩ���O
	 */
	protected void execTest(Properties p, String productCD) throws InitializeException, IOException, EMRException {

		// DB�f�[�^����
		initDB(p);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		execXmlWriter(productCD);

		// �o�̓t�@�C����r
		diffResult();
	}

	protected void diffResult() throws IOException {
		// �o�͐�f�B���N�g����r
		File[] xmlFiles = new File(this.xmlbase).listFiles(getXmlNameFilter());

		for (File xmlFile : xmlFiles) {
			String fileName = xmlFile.getName();
			String result = readFile(xmlFile.getAbsolutePath());
			String org;

			// XML�Ǘ��t�@�C��
			if (PDSConstants.FILE_META.equals(fileName)) {
				org = readFile(PUTPropertyUtil.getProperty("xml.meta.filepath"));
			} else {
				org = readFile(PUTPropertyUtil.getProperty("xml.datamodel.base") + '/' + fileName);
			}
			assertEquals(org, result);
		}
	}

	/**
	 * �t�@�C���Ǎ��݁B
	 * <P>
	 * �w�肳�ꂽ�t�@�C�����e���s����trim���ĘA��������������擾����B
	 * </P>
	 * @param file �ǂݍ��ރt�@�C���p�X
	 * @return �擾�����t�@�C�����e������
	 * @throws IOException �t�@�C���Ǎ��ݗ�O
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
	 * XML�I��p�t�B���^�[�擾�B
	 * <P>
	 * �g���q��XML�̃t�@�C���̂ݑI�������t�@�C�����t�B���^�[���擾�B
	 * </P>
	 * @return �t�@�C�����t�B���^�[
	 */
	private FilenameFilter getXmlNameFilter() {
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(PDSConstants.FILE_XML.toString());
			}
		};
	}

}
