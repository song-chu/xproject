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
	 * リソースベースフォルダ
	 */
	private static final String BASE_FOLDER = "Z:/PDSNgine/xml/PDSDumpServiceAPI";

	/**
	 * ダンプリソースベースフォルダ
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSDumpServiceAPI_Dump";

	/**
	 *
	 */
	public PDSDumpServiceAPITest() {

		super(PDSDumpServiceAPITest.class, BASE_FOLDER);
	}

	/**
	 * テストID：PENDUMP-N-001-1
	 * @throws Exception 例外 例外
	 */
	@Test
	public void testPENDUMP_N_001_1() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-2
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_2() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-3
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_3() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-4
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_4() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-5
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_5() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-6
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_6() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-7
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_7() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-8
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_8() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-9
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_9() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

	/**
	 * テストID：PENDUMP-N-001-10
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_10() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_10");
		super.replaceProperty("xml.dumpxml.base", DUMP_BASE_FOLDER);

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(null,"all");

	}
	/**
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& [ 異常系テスト ] &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 */

	/**
	 * テストID：PENDUMP-E-001-1
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_1() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");
		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,null);
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			//結果確認
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("ここに来たらNG");
		}
	}
	/**
	 * テストID：PENDUMP-E-001-2
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_2() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			//結果確認
			assertEquals(PCTMessageCode.P008E, e.getErrCode());
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			fail("ここに来たらNG");
		}
	}


	/**
	 * テストID：PENDUMP-E-001-3
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_3()throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");
		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		// ダンプ実行
		try {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "PENDUMP-N-001-9");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			//結果確認
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("ここに来たらNG");
		}
	}

	/**
	 * テストID：PENDUMP-E-001-4
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_4() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump("D:/PDSNgine/DumpXML", "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}

	/**
	 * テストID：PENDUMP-E-001-5
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_5() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4), "PENDUMP_N_001_1");
		setReturnValueAtAllTimes("PDMObjectWriter","objectWrite", new IOException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-6
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_6() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("Writer","write", new IOException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-7
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_7() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-8
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_8() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(null, "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-9
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_9() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump("", "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-10
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_10() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(" ", "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-11
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_11() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump("　", "all");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			fail("ここに来たらNG");
		} catch (DumpException e) {
			//結果確認
			assertEquals(PCTMessageCode.P016E, e.getErrCode());
		}
	}
	/**
	 * テストID：PENDUMP-E-001-12
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_12() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, "");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			//結果確認
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("ここに来たらNG");
		}
	}
	/**
	 * テストID：PENDUMP-E-001-13
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_E_001_13() throws Exception {

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(this.getName().substring(4));
		setReturnValueAtAllTimes("PUTXMLWriter","endElement", new SAXException());

		// ----------------------<<対象機能実施>>-------------------------------//
		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		try {
		// ダンプ実行
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, " ");
			fail("ここに来たらNG");
		} catch (UnExpectedStateException e) {
			fail("ここに来たらNG");
		} catch (InitializeException e) {
			fail("ここに来たらNG");
		} catch (InvalidKeyException e) {
			//結果確認
			assertEquals(PCTMessageCode.P015E, e.getErrCode());
		} catch (DumpException e) {
			fail("ここに来たらNG");
		}
	}

	/**
	 * テストID：PENDUMP-N-001-11
	 * @throws Exception 例外
	 */
	@Test
	public void testPENDUMP_N_001_11() throws Exception{

		super.log.debug("########## " + this.getName() + " 開始 ##########");

		String testcase = this.getName().substring(4);

		//----------------------<<Mock>>-------------------------------//
		// Virtual Mock Object利用、返却値を設定する。
		super.replaceProp(testcase, testcase);
		super.replaceProperty("xml.dumpxml.base", DUMP_BASE_FOLDER);

		// イニシャルロードを実行する。
		PDSEngine.getInstance();
		// ----------------------<<対象機能実施>>-------------------------------//
		// ダンプを実行する。
		PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER,"all");

	}

}
