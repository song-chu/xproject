package jp.escofi.emr.engine.search;

import java.io.IOException;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * @author seo.yi
 *
 */
public class PDSDumpServiceAPITest extends DJUnitTestCaseEx {

	/**
	 * ���\�[�X�x�[�X�t�H���_
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PDSDumpServiceAPI";

	/**
	 * �_���v���\�[�X�x�[�X�t�H���_
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSDumpServiceAPI_Dump";

	/**
	 *
	 */
	public PDSDumpServiceAPITest() {

		super(PDSDumpServiceAPITest.class, BASE_FOLDER);
	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-1
	 * @throws Exception ��O ��O
	 */
	@Test
	public void testPENDUMP_N_001_1() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-2
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_2() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-3
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_3() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-4
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_4() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-5
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_5() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-6
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_6() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-7
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_7() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-8
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_8() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-9
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_9() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-10
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_10() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_10");
		super.replaceProperty("xml.dumpxml.base", DUMP_BASE_FOLDER);

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(null,"all");

	}
	/**
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& [ �ُ�n�e�X�g ] &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 */

	/**
	 * �e�X�gID�FPENDUMP-E-001-1
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_1() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,null);
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("�����ɗ�����NG");
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-2
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_2() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P008E, e.getErrCode());
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			fail("�����ɗ�����NG");
		}
	}


	/**
	 * �e�X�gID�FPENDUMP-E-001-3
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_3()throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		// �_���v���s
		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENDUMP-N-001-9");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("�����ɗ�����NG");
		}
	}

	/**
	 * �e�X�gID�FPENDUMP-E-001-4
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_4() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump("D:/PDSNgine/DumpXML", "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}

	/**
	 * �e�X�gID�FPENDUMP-E-001-5
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_5() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");
		setReturnValueAtAllTimes("PDMObjectWriter","objectWrite", new IOException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-6
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_6() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("Writer","write", new IOException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-7
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_7() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-8
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_8() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(null, "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-9
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_9() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump("", "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-10
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_10() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(" ", "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-11
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_11() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump("�@", "all");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			fail("�����ɗ�����NG");
		} catch (DumpException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-12
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_12() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("�����ɗ�����NG");
		}
	}
	/**
	 * �e�X�gID�FPENDUMP-E-001-13
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_E_001_13() throws Exception {

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();

		try {
		// �_���v���s
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, " ");
			fail("�����ɗ�����NG");
		} catch (UnExpectedStateException e) {
			fail("�����ɗ�����NG");
		} catch (InitializeException e) {
			fail("�����ɗ�����NG");
		} catch (InvalidKeyException e) {
			//���ʊm�F
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("�����ɗ�����NG");
		}
	}

	/**
	 * �e�X�gID�FPENDUMP-N-001-11
	 * @throws Exception ��O
	 */
	@Test
	public void testPENDUMP_N_001_11() throws Exception{

		super.log.debug("########## " + this.getName() + " �J�n ##########");

		String testcase = this.getName().substring(4);

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object���p�A�ԋp�l��ݒ肷��B
		super.replaceProp(testcase, testcase);
		super.replaceProperty("xml.dumpxml.base", DUMP_BASE_FOLDER);

		// �C�j�V�������[�h�����s����B
		PDSEngine.getInstance();
		// ----------------------<<�Ώۋ@�\���{>>-------------------------------//
		// �_���v�����s����B
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

}
