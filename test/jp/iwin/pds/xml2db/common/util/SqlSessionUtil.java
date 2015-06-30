/**
 *
 */
package jp.iwin.pds.xml2db.common.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import jp.iwin.pds.xml2db.common.constant.PCTConstants;
import jp.iwin.pds.xml2db.datatable.TblArgsElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblKeySolve;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibm.db2.jcc.DB2Driver;

/**
 * @author park.js
 *
 */
public class SqlSessionUtil {

	protected static String driver = DB2Driver.class.getName();
	protected static String url = "jdbc:db2://192.168.100.2:50001/PDSDB";
	protected static String username = "pdsiadm";
	protected static String password = "pdsiadm";

	private static SqlSession _sqlSession = null;

	public static void getSqlSession(Properties props) throws IOException {
		Reader reader = Resources.getResourceAsReader("mapper_config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sesseionFactory = builder.build(reader, props);

		_sqlSession = sesseionFactory.openSession();
	}

	public static void getSqlSession() throws IOException {

//		if(_sqlSession==null){

		Properties props = new Properties();
		props.setProperty(PCTConstants.JDBC_DRIVER, driver);
		props.setProperty(PCTConstants.JDBC_URL, url);
		props.setProperty(PCTConstants.JDBC_USERNAME, username);
		props.setProperty(PCTConstants.JDBC_PASSWORD, password);

		Reader reader = Resources.getResourceAsReader("mapper_config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sesseionFactory = builder.build(reader, props);

		_sqlSession = sesseionFactory.openSession();
//		}
	}

	public static void closeSqlSession(){
		_sqlSession.close();
	}

	public static void deleteAll(){
		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.deleteAllDatamodel();
		dbMapper.deleteAllArgsElem();
		dbMapper.deleteAllAttElem();
		dbMapper.deleteAllAttField();
		dbMapper.deleteAllAttValue();
		dbMapper.deleteAllAttGroup();
		dbMapper.deleteAllKeySolve();
		_sqlSession.commit();
	}

	public static void insertDatamodel(TblDataModel datamodel){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertDatamodel(datamodel);
		_sqlSession.commit();
	}

	public static void insertKeySolve(TblKeySolve keySolve){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertKeySolve(keySolve);
		_sqlSession.commit();
	}

	public static void insertArgElem(TblArgsElem argsElem){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertArgsElem(argsElem);
		_sqlSession.commit();
	}

	public static void insertAttElem(TblAttributeElem attElem){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertAttElem(attElem);
		_sqlSession.commit();
	}

	public static void insertAttField(TblAttributeField attField){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertAttField(attField);
		_sqlSession.commit();
	}

	public static void insertAttValue(TblAttributeValue attValue){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertAttValue(attValue);
		_sqlSession.commit();
	}

	public static void inertAttGroup(TblAttributeGroup attGroup){

		TblMapper dbMapper = _sqlSession.getMapper(TblMapper.class);
		dbMapper.insertAttGroup(attGroup);
		_sqlSession.commit();
	}


}
