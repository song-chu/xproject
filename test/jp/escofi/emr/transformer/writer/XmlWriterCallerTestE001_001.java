package jp.escofi.emr.transformer.writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.KeyitemMapper;
import jp.escofi.emr.transformer.sql.ResultObjectMapper;
import jp.iwin.pds.xml2db.datatable.TblAttributeElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblKeySolve;
import jp.iwin.pds.xml2db.datatable.TblMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.xml.sax.SAXException;


/**
 * �^�p�c�[���e�X�g�N���X�iE001�n001�`026�j
 * <P>
 * �^�p�c�[���ُ�(���C������)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: song.ck $
 */
public class XmlWriterCallerTestE001_001 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_001_1 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_1() throws Exception {

		String[] cmdarray = new String[] {
				"java",
				"-classpath",
				"Z:/OutputXML/bin;Z:/OutputXML/lib/commons-logging-1.1.1.jar;Z:/OutputXML/lib/log4j-1.2.9.jar;Z:/OutputXML/lib/mybatis-3.0.2.jar;Z:/OutputXML/lib/db2jcc.jar;Z:/OutputXML/lib/db2jcc_license_cu.jar;Z:/OutputXML/lib/pds.jar;Z:/OutputXML/lib/pdstool.jar",
				"jp.iwin.pds.xmlwriter.XmlWriterCaller" };
		String expectedMessage = "�G���[�R�[�h�FP908E�A�G���[���b�Z�[�W�F�����s���B�����̐����s���ł��B�i�����F[]�j";
		this.main(cmdarray, expectedMessage);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_2 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_2() throws Exception {

		String[] cmdarray = new String[] {
				"java",
				"-classpath",
				"Z:/OutputXML/bin;Z:/OutputXML/lib/commons-logging-1.1.1.jar;Z:/OutputXML/lib/log4j-1.2.9.jar;Z:/OutputXML/lib/mybatis-3.0.2.jar;Z:/OutputXML/lib/db2jcc.jar;Z:/OutputXML/lib/db2jcc_license_cu.jar;Z:/OutputXML/lib/pds.jar;Z:/OutputXML/lib/pdstool.jar",
				"jp.iwin.pds.xmlwriter.XmlWriterCaller", this.driver,
				this.url, this.username, this.password, this.productCD };
		String expectedMessage = String.format(
				"�G���[�R�[�h�FP908E�A�G���[���b�Z�[�W�F�����s���B�����̐����s���ł��B�i�����F[%1$s, %2$s, %3$s, %4$s, %5$s]�j",
				this.driver, this.url, this.username, this.password, this.productCD);
		this.main(cmdarray, expectedMessage);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_3 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_3() throws Exception {

		String[] cmdarray = new String[] {
				"java",
				"-classpath",
				"Z:/OutputXML/bin;Z:/OutputXML/lib/commons-logging-1.1.1.jar;Z:/OutputXML/lib/log4j-1.2.9.jar;Z:/OutputXML/lib/mybatis-3.0.2.jar;Z:/OutputXML/lib/db2jcc.jar;Z:/OutputXML/lib/db2jcc_license_cu.jar;Z:/OutputXML/lib/pds.jar;Z:/OutputXML/lib/pdstool.jar",
				"jp.iwin.pds.xmlwriter.XmlWriterCaller", this.driver,
				this.url, this.username, this.password, this.productCD,
				this.xmlbase, "XXX" };
		String expectedMessage = String.format(
				"�G���[�R�[�h�FP908E�A�G���[���b�Z�[�W�F�����s���B�����̐����s���ł��B�i�����F[%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, XXX]�j",
				this.driver, this.url, this.username, this.password, this.productCD, this.xmlbase);
		this.main(cmdarray, expectedMessage);
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_4 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_4() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(Resources.class, "getResourceAsReader", 0,
				new IOException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�Fconfiguration.xml)",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_5 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_5() throws Exception {

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(SqlSessionFactoryBuilder.class, "build", 0, new NullPointerException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_6 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_6() throws Exception {
		// �ُ�l
		this.driver += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_7 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_7() throws Exception {
		// �ُ�l
		this.url += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_8 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_8() throws Exception {
		// �ُ�l
		this.username += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_9 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_9() throws Exception {
		// �ُ�l
		this.password += "test";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P903E, e.getErrCode());
			assertEquals("DB�R�l�N�V�����擾�Ɏ��s���܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_10 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_10() throws Exception {
		// �ُ�l
		this.productCD = "ZZZZZ_9999";

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P906E, e.getErrCode());
			assertEquals(String.format("�Č��f�[�^�����݂��܂���B(�Č�CD�F%1$s)",
					this.productCD),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_11 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_11() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		insertMeta(dataModel, attGroup);

		// XML�Ǘ��t�@�C��
		File f = new File(this.xmlbase + File.separator + "XML_Meta.xml");

		// ��ƃf�B���N�g��
		createOutputDir();

		// XML�Ǘ��t�@�C����Ǎ��ݐ�p�ɕύX
		f.createNewFile();
		f.setReadOnly();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					f.getAbsolutePath()),
					e.getMessage());
		} finally {
			f.delete();
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_12 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_12() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		insertMeta(dataModel, attGroup);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �f�B���N�g���쐬
		File dir = createDir("XML_Meta.xml");

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		} finally {

			if (!dir.delete()) {
				throw new IOException("delete fail.");
			}
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_13 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_13() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �f�[�^���f���t�@�C��
		File f = new File(this.xmlbase + File.separator + "PENSER_N_001_1.xml");

		f.createNewFile();
		f.setReadOnly();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					f.getAbsolutePath()),
					e.getMessage());
		} finally {
			f.delete();
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_14 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_14() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �f�B���N�g���쐬
		File dir = createDir("PENSER_N_001_1.xml");

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P904E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		} finally {

			if (!dir.delete()) {
				throw new IOException("delete fail.");
			}
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_15 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_15() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0, new ParserConfigurationException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_16 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_16() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(SAXParserFactory.class, "newSAXParser", 0, new SAXException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P905E, e.getErrCode());
			assertEquals(String.format("XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F%1$s)",
					this.xmlbase),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_17 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_17() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(DatamodelinfoWriter.class, "write", 0,
				new RuntimeException(new SQLException()));

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P909E, e.getErrCode());
			assertEquals("XML�t�@�C���o�͏�����SQL�G���[���������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_18 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_18() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(DatamodelinfoWriter.class, "write", 0,
				new NullPointerException());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_19 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_19() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		dataModel.setProduct_id(99999);
		insertMeta(dataModel, attGroup);

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P912E, e.getErrCode());
			assertEquals(String.format("�f�[�^���f�������݂��܂���B(�Č�CD�F%1$s)",
					this.productCD),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_20 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_20() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);

		attGroup.setDatamodel_id(99999);
		insertMeta(dataModel, attGroup);

		// ��ƃf�B���N�g��
		createOutputDir();

		// �^�p�c�[�����s
		execXmlWriter();

		Properties p = new Properties();
		String base = "Z:/OutputXML/xml/XmlWriter/in/TestData_E001";

		p.setProperty("xml.datamodel.base", base);
		p.setProperty("xml.meta.filepath", base + "/" + getTestcaseID() + "_Meta.xml");

//		PUTPropertyUtil.setProperty(p);
		replaceProperty(p);

		// �o�̓t�@�C����r
		diffResult();
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_21 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_21() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnValueAt(KeyitemMapper.class, "selectKeyitem", 0, new  ArrayList<KeyitemWriter>());

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(String.format("�����O���[�v�����݂��܂���B(�f�[�^���f��ID�F%1$s)",
					dataModel.getDatamodel_id()),
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_22 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_22() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);
		List<TblKeySolve> keyList = new ArrayList<TblKeySolve>(2);

		TblKeySolve key = new TblKeySolve();

		key.setKey_solve_id(1);
		key.setDatamodel_id(dataModel.getDatamodel_id());
		key.setIndex(1);
		key.setKey_en_name("testkey01");
		keyList.add(key);

		key = new TblKeySolve();
		key.setKey_solve_id(2);
		key.setDatamodel_id(dataModel.getDatamodel_id());
		key.setIndex(1);
		key.setKey_en_name("testkey02");
		keyList.add(key);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, keyList);

		// ��ƃf�B���N�g��
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_23 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_23() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attField.setCondition_flg(true);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		setReturnNullAt(ResultObjectMapper.class, "select", 0);

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_24 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_24() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValue.setAttribute_field_id(99999);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			e.printStackTrace();
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_25 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_25() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(2);

		for (int i = 1; i < 3; i++) {
			TblAttributeValue attValue = createDefaultAttValue(attField);

			attValue.setAttribute_value_id(i);
			attValue.setSingle_value(String.format("value%1$03d", i));
			attValueList.add(attValue);
		}
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}

	/**
	 * �e�X�gID�FPXWXML_E_001_26 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_001_26() throws Exception {

		// �f�[�^����
		TblDataModel dataModel = createDefaultDatamodel();
		TblAttributeGroup attGroup = createDefaultAttGroup(dataModel);
		TblAttributeElem attElem = createDefaultAttElem(dataModel);
		TblAttributeField attField = createDefaultAttField(attElem, attGroup);
		TblAttributeValue attValue = createDefaultAttValue(attField);
		List<TblAttributeValue> attValueList = new ArrayList<TblAttributeValue>(1);

		attValue.setAnser_no(1);
		attValueList.add(attValue);
		insertDatamodel(dataModel, attGroup, attElem, attField, attValueList, null);

		// ��ƃf�B���N�g��
		createOutputDir();

		try {
			execXmlWriter();
		} catch (EMRException e) {
			assertEquals(MessageCode.EMR_B_P910E, e.getErrCode());
			assertEquals("�\�����ʏ�Ԃ��������܂����B",
					e.getMessage());
		}
	}


	/**
	 * �`�F�b�N�p�����[�^�e�X�g�p���\�b�h
	 * @param cmdarray
	 *            �R�}���h�A���C
	 * @param expectedMessage
	 *            ���Ғl���b�Z�[�W
	 *
	 * @throws Exception
	 */
	private void main(String[] cmdarray, String expectedMessage) throws Exception {

		// �ُ�l
		Process process = Runtime.getRuntime().exec(cmdarray);
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = br.readLine();
			while (line != null && line.length() > 0) {
				sb.append(line);
				line = br.readLine();
			}
		} finally {
			try {
				br.close();
			} catch (Exception ex) {

			}
		}
		int exitValue = process.waitFor();
		assertEquals(1, exitValue);
		String actual = sb.toString();
		log.info("[actual  ]" + actual);
		log.info("[expected]" + expectedMessage);
		boolean matched = (actual != null) && actual.contains(expectedMessage);
		assertEquals(true, matched);
	}

	/**
	 * @return �f�t�H���g�œ�������f�[�^���f���f�[�^
	 */
	private TblDataModel createDefaultDatamodel() {
		TblDataModel dataModel = new TblDataModel();

		dataModel.setDatamodel_id(1);
		dataModel.setDatamodel_jp_name("�f�[�^���f��_001");
		dataModel.setDatamodel_en_name(getTestcaseID());
		dataModel.setXml_name(getTestcaseID() + PDSConstants.FILE_XML);
		dataModel.setXml_object_index(1);
		dataModel.setProduct_id(1);

		return dataModel;
	}

	/**
	 * @param dataModel �R�t����f�[�^���f��
	 * @return �f�t�H���g�œ������鑮���O���[�v�f�[�^
	 */
	private TblAttributeGroup createDefaultAttGroup(TblDataModel dataModel) {
		TblAttributeGroup attGroup = new TblAttributeGroup();

		attGroup.setAttribute_group_id(1);
		attGroup.setAttribute_group_jp_name("�����O���[�v_001");
		attGroup.setDatamodel_id(dataModel.getDatamodel_id());
		attGroup.setProduct_id(dataModel.getProduct_id());

		return attGroup;
	}

	/**
	 * @param dataModel �R�t����f�[�^���f��
	 * @return �f�t�H���g�œ������鑮���Ǘ��f�[�^
	 */
	private TblAttributeElem createDefaultAttElem(TblDataModel dataModel) {
		TblAttributeElem attElem = new TblAttributeElem();

		attElem.setAttribute_elem_id(1);
		attElem.setDatamodel_id(dataModel.getDatamodel_id());
		attElem.setAttribute_field_jp_name("�����P");
		attElem.setAttribute_field_en_name("attrname1");
		attElem.setAttribute_type_cd("01");
		attElem.setJava_class_cd("01");
		attElem.setProduct_id(dataModel.getProduct_id());

		return attElem;
	}

	/**
	 * @param attElem �R�t���鑮���Ǘ�
	 * @param attGroup �R�t���鑮���O���[�v
	 * @return �f�t�H���g�œ������鑮�����ڃf�[�^
	 */
	private TblAttributeField createDefaultAttField(TblAttributeElem attElem,
			TblAttributeGroup attGroup) {
		TblAttributeField attField = new TblAttributeField();

		attField.setAttribute_field_id(1);
		attField.setAttribute_elem_id(attElem.getAttribute_elem_id());
		attField.setAttribute_group_id(attGroup.getAttribute_group_id());
		attField.setProduct_id(attElem.getProduct_id());

		return attField;
	}

	/**
	 * @param attField �R�t���鑮������
	 * @return �f�t�H���g�œ������鑮���l�f�[�^
	 */
	private TblAttributeValue createDefaultAttValue(TblAttributeField attField) {
		TblAttributeValue attValue = new TblAttributeValue();

		attValue.setAttribute_value_id(1);
		attValue.setAttribute_field_id(attField.getAttribute_field_id());
		attValue.setSingle_value("value001");

		return attValue;
	}

	/**
	 * XML�Ǘ���񓊓��B
	 *
	 * @param dataModel �f�[�^���f��
	 * @param attGroup �����O���[�v
	 * @throws IOException
	 */
	private void insertMeta(TblDataModel dataModel, TblAttributeGroup attGroup
			) throws IOException {

		// �f�[�^����
		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			dbMapper.deleteAllDatamodel();
			dbMapper.deleteAllAttGroup();
			session.commit();

			dbMapper.insertDatamodel(dataModel);
			dbMapper.insertAttGroup(attGroup);
			session.commit();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * �f�[�^���f����񓊓��B
	 *
	 * @param dataModel �f�[�^���f��
	 * @param attGroup �����O���[�v
	 * @param attElem �����Ǘ�
	 * @param attField ��������
	 * @param attValueList �����l���X�g
	 * @param keyList �L�[���ڒl���X�g
	 * @throws IOException
	 */
	private void insertDatamodel(TblDataModel dataModel, TblAttributeGroup attGroup,
			TblAttributeElem attElem, TblAttributeField attField,
			List<TblAttributeValue> attValueList, List<TblKeySolve> keyList) throws IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();

			TblMapper dbMapper = session.getMapper(TblMapper.class);

			dbMapper.deleteAllDatamodel();
			dbMapper.deleteAllAttGroup();
			dbMapper.deleteAllKeySolve();
			dbMapper.deleteAllAttElem();
			dbMapper.deleteAllAttField();
			dbMapper.deleteAllAttValue();
			session.commit();

			dbMapper.insertDatamodel(dataModel);
			dbMapper.insertAttGroup(attGroup);
			dbMapper.insertAttElem(attElem);
			dbMapper.insertAttField(attField);

			for (TblAttributeValue attValue : attValueList) {
				dbMapper.insertAttValue(attValue);
			}

			if (keyList != null) {

				for (TblKeySolve key : keyList) {
					dbMapper.insertKeySolve(key);
				}
			}
			session.commit();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * �f�B���N�g���쐬�B
	 *
	 * @param dirname �f�B���N�g����
	 * @return �쐬�����f�B���N�g��
	 * @throws IOException �쐬���s
	 */
	private File createDir(String dirname) throws IOException {
		File dir = new File(this.xmlbase + File.separator + dirname);

		createDir(dir);

		return dir;
	}

}
