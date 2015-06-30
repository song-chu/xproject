package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE001�n037�`058�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public final class XmlWriterCallerTestE001_037 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_37 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_37() throws Exception {
		Properties p = createIncludeProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_38 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_38() throws Exception {
		Properties p = createIncludeProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_39 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_39() throws Exception {
		Properties p = createIncludeProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_40 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_40() throws Exception {
		Properties p = createIncludeProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_41 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_41() throws Exception {
		Properties p = createSubsetProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_42 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_42() throws Exception {
		Properties p = createEqProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_43 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_43() throws Exception {
		Properties p = createEqProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_44 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_44() throws Exception {
		Properties p = createNeqProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><neq><const>" +
					"<single>�R���X�g�Q�T</single></const>" +
					"</neq></apply><result>1</result></if><else>" +
					"<if><apply><or><apply><and><apply><neq><const>" +
					"<single>�R���X�g�P</single></const><var>var1</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�Q</single></const><var>var2</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�R</single></const><var>var3</var></neq></apply>" +
					"</and></apply><apply><and><apply><neq><const><single>�R���X�g�S</single>" +
					"</const><var>var4</var></neq></apply><apply><neq><const><single>�R���X�g�T</single>" +
					"</const><var>var5</var></neq></apply><apply><neq><const><single>�R���X�g�U</single>" +
					"</const><var>var6</var></neq></apply></and></apply></or></apply>" +
					"<if><apply><and><apply><or><apply><neq><const><single>�R���X�g�V</single></const>" +
					"<var>var7</var></neq></apply><apply><neq><const><single>�R���X�g�W</single></const>" +
					"<var>var8</var></neq></apply><apply><neq><const><single>�R���X�g�X</single></const>" +
					"<var>var9</var></neq></apply></or></apply><apply><or><apply><neq><const>" +
					"<single>�R���X�g�P�O</single></const><var>var10</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�P�P</single></const><var>var11</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�P�Q</single></const><var>var12</var></neq></apply>" +
					"</or></apply></and></apply><if><apply><or><apply><and>" +
					"<apply><neq><const><single>�R���X�g�P�R</single></const><var>var13</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�P�S</single></const><var>var14</var></neq></apply>" +
					"</and></apply><apply><and><apply><neq><const><single>�R���X�g�P�T</single></const>" +
					"<var>var15</var></neq></apply><apply><neq><const><single>�R���X�g�P�U</single></const>" +
					"<var>var16</var></neq></apply></and></apply><apply><and><apply><neq>" +
					"<const><single>�R���X�g�P�V</single></const><var>var17</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�P�W</single></const><var>var18</var></neq></apply>" +
					"</and></apply></or></apply><if><apply><and><apply><or><apply><neq><const>" +
					"<single>�R���X�g�P�X</single></const><var>var19</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�Q�O</single></const><var>var20</var></neq></apply>" +
					"</or></apply><apply><or><apply><neq><const><single>�R���X�g�Q�P</single></const>" +
					"<var>var21</var></neq></apply><apply><neq><const><single>�R���X�g�Q�Q</single></const>" +
					"<var>var22</var></neq></apply></or></apply><apply><or><apply><neq><const>" +
					"<single>�R���X�g�Q�R</single></const><var>var23</var></neq></apply>" +
					"<apply><neq><const><single>�R���X�g�Q�S</single></const><var>var24</var></neq></apply>" +
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_45 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_45() throws Exception {
		Properties p = createGtProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_46 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_46() throws Exception {
		Properties p = createGeqProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_47 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_47() throws Exception {
		Properties p = createLtProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_48 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_48() throws Exception {
		Properties p = createLeqProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_49 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_49() throws Exception {
		Properties p = createInProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_50 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_50() throws Exception {
		Properties p = createNotinProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply><notin><const><single>�[��</single></const>" +
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_51 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_51() throws Exception {
		Properties p = createSubsetProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_52 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_52() throws Exception {
		Properties p = createNsubsetProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_53 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_53() throws Exception {
		Properties p = createIntersectProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_54 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_54() throws Exception {
		Properties p = createNintersectProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_55 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_55() throws Exception {
		Properties p = createIncludeProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_56 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_56() throws Exception {
		Properties p = createExcludeProperties();

		// DB�f�[�^����
		initDB(p);

		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);
			TblAttributeField field = dbMapper.selectAttField(1);

			field.setCondition_XML("<condition><if><apply>" +
					"<exclude uppereq=\"true\" lowereq=\"true\">" +
					"<const><single>���</single></const></exclude></apply>" +
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_57 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_57() throws Exception {
		Properties p = createStartswithProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_58 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_58() throws Exception {
		Properties p = createNstartswithProperties();

		// DB�f�[�^����
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
		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		try {
			execXmlWriter();
			fail();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}


	/**
	 * @return include�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createIncludeProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_37_Meta.xml");

		return p;
	}

	/**
	 * @return exclude�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createExcludeProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_56_Meta.xml");

		return p;
	}

	/**
	 * @return subset�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createSubsetProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_41_Meta.xml");

		return p;
	}

	/**
	 * @return nsubset�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createNsubsetProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_52_Meta.xml");

		return p;
	}

	/**
	 * @return eq�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createEqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_42_Meta.xml");

		return p;
	}

	/**
	 * @return neq�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createNeqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_44_Meta.xml");

		return p;
	}

	/**
	 * @return gt�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createGtProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_45_Meta.xml");

		return p;
	}

	/**
	 * @return geq�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createGeqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_46_Meta.xml");

		return p;
	}

	/**
	 * @return lt�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createLtProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_47_Meta.xml");

		return p;
	}

	/**
	 * @return leq�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createLeqProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_48_Meta.xml");

		return p;
	}

	/**
	 * @return in�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createInProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_49_Meta.xml");

		return p;
	}

	/**
	 * @return notin�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createNotinProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_50_Meta.xml");

		return p;
	}

	/**
	 * @return intersect�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createIntersectProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_53_Meta.xml");

		return p;
	}

	/**
	 * @return nintersect�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createNintersectProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_54_Meta.xml");

		return p;
	}

	/**
	 * @return startswith�^�O�ُ�n�����p�v���p�e�B
	 */
	private Properties createStartswithProperties() {
		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/PXWXML_E_001_57_Meta.xml");

		return p;
	}

	/**
	 * @return nstartswith�^�O�ُ�n�����p�v���p�e�B
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
