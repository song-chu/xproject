package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 運用ツールテストクラス（E001系037～058）
 * <P>
 * 運用ツール異常(メイン処理)系のテストメソッド定義クラス。
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_037 extends XmlWriterCallerTest {

	/**
	 * テストID：PXWXML_E_001_37 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_37() throws Exception {
		Properties p = createIncludeProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><include lowereq=\"true\">" +
					"<var>var1</var><var>var2</var><var>var3</var></include></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_38 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_38() throws Exception {
		Properties p = createIncludeProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><include uppereq=\"\" lowereq=\"true\">" +
					"<var>var1</var><var>var2</var><var>var3</var></include></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_39 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_39() throws Exception {
		Properties p = createIncludeProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><include uppereq=\"true\">" +
					"<var>var1</var><var>var2</var><var>var3</var></include></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_40 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_40() throws Exception {
		Properties p = createIncludeProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><include uppereq=\"true\" lowereq=\"\">" +
					"<var>var1</var><var>var2</var><var>var3</var></include></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_41 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_41() throws Exception {
		Properties p = createSubsetProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><subset><const><set>" +
					"<elem></elem>" +
					"</set></const><var>var1</var></subset></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_42 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_42() throws Exception {
		Properties p = createEqProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><eq><var>ConditionItem027</var>" +
					"<const><single></single></const>" +
					"</eq></apply><result>1</result></if></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_43 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_43() throws Exception {
		Properties p = createEqProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><eq>" +
					"<const><single>value027</single></const>" +
					"</eq></apply><result>1</result></if></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_44 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_44() throws Exception {
		Properties p = createNeqProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><neq><const>" +
					"<single>コンスト２５</single></const>" +
					"</neq></apply><result>1</result></if><else>" +
					"<if><apply><or><apply><and><apply><neq><const>" +
					"<single>コンスト１</single></const><var>var1</var></neq></apply>" +
					"<apply><neq><const><single>コンスト２</single></const><var>var2</var></neq></apply>" +
					"<apply><neq><const><single>コンスト３</single></const><var>var3</var></neq></apply>" +
					"</and></apply><apply><and><apply><neq><const><single>コンスト４</single>" +
					"</const><var>var4</var></neq></apply><apply><neq><const><single>コンスト５</single>" +
					"</const><var>var5</var></neq></apply><apply><neq><const><single>コンスト６</single>" +
					"</const><var>var6</var></neq></apply></and></apply></or></apply>" +
					"<if><apply><and><apply><or><apply><neq><const><single>コンスト７</single></const>" +
					"<var>var7</var></neq></apply><apply><neq><const><single>コンスト８</single></const>" +
					"<var>var8</var></neq></apply><apply><neq><const><single>コンスト９</single></const>" +
					"<var>var9</var></neq></apply></or></apply><apply><or><apply><neq><const>" +
					"<single>コンスト１０</single></const><var>var10</var></neq></apply>" +
					"<apply><neq><const><single>コンスト１１</single></const><var>var11</var></neq></apply>" +
					"<apply><neq><const><single>コンスト１２</single></const><var>var12</var></neq></apply>" +
					"</or></apply></and></apply><if><apply><or><apply><and>" +
					"<apply><neq><const><single>コンスト１３</single></const><var>var13</var></neq></apply>" +
					"<apply><neq><const><single>コンスト１４</single></const><var>var14</var></neq></apply>" +
					"</and></apply><apply><and><apply><neq><const><single>コンスト１５</single></const>" +
					"<var>var15</var></neq></apply><apply><neq><const><single>コンスト１６</single></const>" +
					"<var>var16</var></neq></apply></and></apply><apply><and><apply><neq>" +
					"<const><single>コンスト１７</single></const><var>var17</var></neq></apply>" +
					"<apply><neq><const><single>コンスト１８</single></const><var>var18</var></neq></apply>" +
					"</and></apply></or></apply><if><apply><and><apply><or><apply><neq><const>" +
					"<single>コンスト１９</single></const><var>var19</var></neq></apply>" +
					"<apply><neq><const><single>コンスト２０</single></const><var>var20</var></neq></apply>" +
					"</or></apply><apply><or><apply><neq><const><single>コンスト２１</single></const>" +
					"<var>var21</var></neq></apply><apply><neq><const><single>コンスト２２</single></const>" +
					"<var>var22</var></neq></apply></or></apply><apply><or><apply><neq><const>" +
					"<single>コンスト２３</single></const><var>var23</var></neq></apply>" +
					"<apply><neq><const><single>コンスト２４</single></const><var>var24</var></neq></apply>" +
					"</or></apply></and></apply><result>2</result></if><else><result>3</result></else></if>" +
					"</if></if></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_45 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_45() throws Exception {
		Properties p = createGtProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><gt>" +
					"</gt></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_46 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_46() throws Exception {
		Properties p = createGeqProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><geq>" +
					"</geq></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_47 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_47() throws Exception {
		Properties p = createLtProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><lt>" +
					"</lt></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_48 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_48() throws Exception {
		Properties p = createLeqProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><leq>" +
					"</leq></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_49 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_49() throws Exception {
		Properties p = createInProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><in>" +
					"</in></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_50 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_50() throws Exception {
		Properties p = createNotinProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><notin><const><single>ゼロ</single></const>" +
					"</notin></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_51 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_51() throws Exception {
		Properties p = createSubsetProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><subset><const><set>" +
					"<elem>5</elem>" +
					"</set></const></subset></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_52 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_52() throws Exception {
		Properties p = createNsubsetProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><nsubset>" +
					"<const><set><elem>-2147483648</elem><elem>-1</elem><elem>0</elem>" +
					"<elem>1</elem><elem>2147483647</elem></set></const></nsubset></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_53 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_53() throws Exception {
		Properties p = createIntersectProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><intersect>" +
					"<const><set><elem>-1</elem><elem>0</elem><elem>-2147483648</elem>" +
					"<elem>-9223372036854775804</elem><elem>-9223372036854775805</elem>" +
					"<elem>-9223372036854775808</elem><elem>2147483647</elem>" +
					"<elem>9223372036854775803</elem><elem>9223372036854775804</elem>" +
					"<elem>1000000000000000000</elem></set></const>" +
					"</intersect></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_54 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_54() throws Exception {
		Properties p = createNintersectProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><nintersect>" +
					"<const><set>" +
					"<elem>1234567890123456789012345678901234567890." +
					"1234567890123456789012345678901234567890</elem>" +
					"<elem>99999999999999999999999999999999999." +
					"65346543265426448746763565340001</elem>" +
					"<elem>-1.0E+650</elem>" +
					"<elem>-9.652245423543542E+53</elem>" +
					"<elem>0.001</elem>" +
					"<elem>562345435652254354354354312543." +
					"5634789563478569123789563785963478121</elem>" +
					"<elem>1.0E+447</elem>" +
					"<elem>10000000423542300560423000000.1</elem>" +
					"<elem>542354235234643161340.000010100200003000040</elem>" +
					"<elem>987464323455423430.000010000200005000040</elem>" +
					"</set></const></nintersect></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_55 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_55() throws Exception {
		Properties p = createIncludeProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><include uppereq=\"true\" lowereq=\"true\">" +
					"</include></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_56 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_56() throws Exception {
		Properties p = createExcludeProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply>" +
					"<exclude uppereq=\"true\" lowereq=\"true\">" +
					"<const><single>ｺｺｹ</single></const></exclude></apply>" +
					"<result>1</result></if><else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_57 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_57() throws Exception {
		Properties p = createStartswithProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><startswith>" +
					"</startswith></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * テストID：PXWXML_E_001_58 運用ツール異常系
	 */
	@Test
	public void testPXWXML_E_001_58() throws Exception {
		Properties p = createNstartswithProperties();

		// DBデータ投入
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><nstartswith>" +
					"</nstartswith></apply><result>1</result></if>" +
					"<else><result>2</result></else></condition>");
			dbMapper.updateAttField(field);

			session.commit();
		} catch (Exception e) {

			if (session != null) {
				session.rollback();
			}
			throw e;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		// 作業ディレクトリ
		createOutputDir();

		// 運用ツール実行
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XMLファイル出力中XMLエラーが発生しました。(ファイルパス：%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}


	/**
	 * @return includeタグ異常系試験用プロパティ
	 */
	private Properties createIncludeProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_37_Meta.xml");

		return p;
	}

	/**
	 * @return excludeタグ異常系試験用プロパティ
	 */
	private Properties createExcludeProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_56_Meta.xml");

		return p;
	}

	/**
	 * @return subsetタグ異常系試験用プロパティ
	 */
	private Properties createSubsetProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_41_Meta.xml");

		return p;
	}

	/**
	 * @return nsubsetタグ異常系試験用プロパティ
	 */
	private Properties createNsubsetProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_52_Meta.xml");

		return p;
	}

	/**
	 * @return eqタグ異常系試験用プロパティ
	 */
	private Properties createEqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_42_Meta.xml");

		return p;
	}

	/**
	 * @return neqタグ異常系試験用プロパティ
	 */
	private Properties createNeqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_44_Meta.xml");

		return p;
	}

	/**
	 * @return gtタグ異常系試験用プロパティ
	 */
	private Properties createGtProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_45_Meta.xml");

		return p;
	}

	/**
	 * @return geqタグ異常系試験用プロパティ
	 */
	private Properties createGeqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_46_Meta.xml");

		return p;
	}

	/**
	 * @return ltタグ異常系試験用プロパティ
	 */
	private Properties createLtProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_47_Meta.xml");

		return p;
	}

	/**
	 * @return leqタグ異常系試験用プロパティ
	 */
	private Properties createLeqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_48_Meta.xml");

		return p;
	}

	/**
	 * @return inタグ異常系試験用プロパティ
	 */
	private Properties createInProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_49_Meta.xml");

		return p;
	}

	/**
	 * @return notinタグ異常系試験用プロパティ
	 */
	private Properties createNotinProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_50_Meta.xml");

		return p;
	}

	/**
	 * @return intersectタグ異常系試験用プロパティ
	 */
	private Properties createIntersectProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_53_Meta.xml");

		return p;
	}

	/**
	 * @return nintersectタグ異常系試験用プロパティ
	 */
	private Properties createNintersectProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_54_Meta.xml");

		return p;
	}

	/**
	 * @return startswithタグ異常系試験用プロパティ
	 */
	private Properties createStartswithProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_57_Meta.xml");

		return p;
	}

	/**
	 * @return nstartswithタグ異常系試験用プロパティ
	 */
	private Properties createNstartswithProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_58_Meta.xml");
		p.setProperty("DBDeleteFlg", Boolean.toString(true));
		p.setProperty("productID", "1");

		return p;
	}

}
