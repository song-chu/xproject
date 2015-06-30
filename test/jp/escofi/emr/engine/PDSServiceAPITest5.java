package jp.escofi.emr.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXException;

import org.junit.Test;

/**
 * Set eq,neqテスト
 *
 * @author seo.yi
 */
public class PDSServiceAPITest5 extends DJUnitTestCaseEx {

	private static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	/**
	 * ダンプリソースベースフォルダ
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PENServiceAPI5_Dump";

	public PDSServiceAPITest5() {

		super(PDSServiceAPITest5.class, BASE_FOLDER);
	}

	/**
	 * 検索キー設定→検索実施→引数項目値設定→条件判定実施
	 *
	 * @param dataModelName
	 *            データモデル名(テストケースID)
	 * @param vars
	 *            引数項目名=引数項目値
	 * @return PDS応答クラス
	 * @throws Exception
	 */
	private PDSResponse execute(String dataModelName, Map<String, Object> objMap)
			throws Exception {

		List<String> param = new ArrayList<String>();
		param.add(dataModelName); // 修正ポイント
		param.add("key1");
		param.add("key2");
		param.add("attrname1");
		param.add("001");

		// リフレクション利用、プロパティ・内部インスタンスを設定する。
		super.replaceProp(dataModelName);

		// イニシャルロードを実行する。
		PDSEngine.getInstance();

		PDSResponse res = super.getResult(param, objMap);

		// ダンプ実行
		if (NEED_DUMP) {
			PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, dataModelName);
		}

		return res;
	}

	/**
	 * 結果確認
	 *
	 * @param res
	 * @param expected
	 *            期待値
	 */
	private void assertResult(PDSResponse res, String expected) {
		// ----------------------<<結果確認、修正ポイントSTART>>-------------------------------//
		// ステータス確認
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// 条件文有無確認
		assertEquals(true, res.isCondition());
		// 属性値確認
		String result = (String) res.getResultObject().getValue();
		// 結果値
		assertEquals(expected, result);
		// ----------------------<<結果確認、修正ポイントEND>>-------------------------------//
	}

	/**
	 * テストID：PENSER_N_002_97 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_97() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "あ"));
		varMap.put("vSet12", this.getSet(String.class, "あ"));
		varMap.put("vSet13", this.getSet(String.class, "A"));
		varMap.put("vSet14", this.getSet(String.class, "A"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_98 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_98() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "あいう", "かきこ"));
		varMap.put("vSet21", this.getSet(String.class, "くあｇ", "ggs"));
		varMap.put("vSet31", this.getSet(String.class, "はまる", "abc"));
		varMap.put("vSet33", this.getSet(String.class, "アイウ", "def"));
		varMap.put("vSet35", this.getSet(String.class, "漢字", "nんs"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_99 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_99() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet12", this.getSet(String.class, "あか", "さた", "なは", "まや",
				"らわ", "ab", "cd", "ef", "gh", "12"));
		varMap.put("vSet22", this.getSet(String.class, "あか", "さた", "なは", "まや",
				"らわ", "ab", "cd", "ef", "gh", "22"));
		varMap.put("vSet32", this.getSet(String.class, "あか", "さた", "なは", "まや",
				"らわ", "ab", "cd", "ef", "gh", "32"));
		varMap.put("vSet42", this.getSet(String.class, "いき3", "しち3", "にひ3",
				"みゆ3", "ij3", "kl3", "mn3", "op3", "55"));
		varMap.put("vSet44", this.getSet(String.class, "いき5", "しち5", "にひ5",
				"みゆ5", "ij5", "kl5", "mn5", "op5", "55"));
		varMap.put("vSet46", this.getSet(String.class, "いき7", "しち7", "にひx",
				"みゆ7", "ij7", "kl7", "mn7", "op7", "77"));
		varMap.put("vSet48", this.getSet(String.class, "いき9", "しち9", "にひ9",
				"みゆ9", "ij9", "kl9", "mn9", "op9", "99"));
		varMap.put("vSet50", this.getSet(String.class, "いき11", "しち11", "にひ11",
				"みゆ11", "ij11", "kl11", "mn11", "op11", "1111"));
		varMap.put("vSet52", this.getSet(String.class, "いき13", "しち13", "にひ13",
				"みゆ13", "ij13", "kl13", "mn13", "op13", "1313"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_100 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_100() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "Aい亜"));
		varMap.put("vSet13", this.getSet(String.class, "日本Japn"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_101 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_101() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet12", this.getSet(Integer.class, -2147483648, 1, 2, 3,
				4, 5, 6, 7, 8, 2147483647));
		varMap.put("vSet14", this.getSet(Integer.class, -100, -10, -1, 0, 1,
				10, 100, 1000, 10000, 100000));
		varMap.put("vSet16", this.getSet(Integer.class, 0, 2, 4, 8, 16, 32, 64,
				128, 256, 512));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_102 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_102() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Integer.class, 100000));
		varMap.put("vSet21", this.getSet(Integer.class, 7));
		varMap.put("vSet31", this.getSet(Integer.class, 456));
		varMap.put("vSet33", this.getSet(Integer.class, -12345));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value3");
	}

	/**
	 * テストID：PENSER_N_002_103 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_103() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Integer.class, 143500));
		varMap.put("vSet12", this.getSet(Integer.class, -9886));
		varMap.put("vSet21", this.getSet(Integer.class, 17));
		varMap.put("vSet22", this.getSet(Integer.class, 17));
		varMap.put("vSet31", this.getSet(Integer.class, 5463));
		varMap.put("vSet32", this.getSet(Integer.class, 5463));
		varMap.put("vSet41", this.getSet(Integer.class, -453689));
		varMap.put("vSet42", this.getSet(Integer.class, -453689));
		varMap.put("vSet43", this.getSet(Integer.class, 136));
		varMap.put("vSet44", this.getSet(Integer.class, 135));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value3");
	}

	/**
	 * テストID：PENSER_N_002_104 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_104() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Integer.class, -10, -9, -8, -7, -6,
				-5, -4, -3, -2, -1));
		varMap.put("vSet13", this.getSet(Integer.class, -310, -9, -8, -7, -6,
				-5, -4, -3, -2, -1));
		varMap.put("vSet15", this.getSet(Integer.class, -10, -29, -8, -7, -6,
				-5, -4, -3, -2, -1));
		varMap.put("vSet17", this.getSet(Integer.class, -10, -9, -18, -7, -6,
				-5, -4, -3, -2, -1));
		varMap.put("vSet19", this.getSet(Integer.class, -10, -9, -8, -1007, -6,
				-5, -4, -3, -2, -1));
		varMap.put("vSet21", this.getSet(Integer.class, -10, -9, -8, -7, -506,
				-5, -4, -3, -2, -1));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_105 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_105() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Long.class, -9223372036854775808L,
				13372036854775808L, 23372036854775808L, 33372036854775808L,
				43372036854775808L));
		varMap.put("vSet12", this.getSet(Long.class, -9223372036854775808L,
				11372036854775808L, 23372036854775808L, 33372036854775808L,
				43372036854775808L));
		varMap.put("vSet21", this.getSet(Long.class, -1223372036854775808L,
				-13372036854775808L, 2337236854775808L, 9372036854775808L,
				4337236854775808L));
		varMap.put("vSet22", this.getSet(Long.class, -1223372036854775808L,
				-13372036854775808L, 2337236854775808L, 9372036854775808L,
				4337236854775808L));
		varMap.put("vSet23", this.getSet(Long.class, 141429980234160128L,
				-4940784473383940096L, 3696662677605377024L,
				-1469441245665285120L, 8950200105762337792L));
		varMap.put("vSet24", this.getSet(Long.class, 141429980234160128L,
				-4940784473383940096L, 3696662677605377024L,
				-1469441245665285120L, 8950200105762337792L));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_106 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_106() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Long.class, -9223372036854775808L));
		varMap.put("vSet21", this.getSet(Long.class, 9223372036854775807L));
		varMap.put("vSet23", this.getSet(Long.class, 12345678901L));
		varMap.put("vSet25", this.getSet(Long.class, -98765432109L));
		varMap.put("vSet27", this.getSet(Long.class, -59769496296L));
		varMap.put("vSet29", this.getSet(Long.class, -100000000001L));
		varMap.put("vSet31", this.getSet(Long.class, -104136000000010L));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_107 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_107() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Long.class, -1223372036854775801L));
		varMap.put("vSet12", this.getSet(Long.class, -1223372036854775801L));
		varMap.put("vSet13", this.getSet(Long.class, 1223372036854775801L));
		varMap.put("vSet14", this.getSet(Long.class, 1223372036854775801L));
		varMap.put("vSet15", this.getSet(Long.class, 1000000000000000000L));
		varMap.put("vSet16", this.getSet(Long.class, 1000000000000000001L));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_108 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_108() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Long.class, -100000000000001L,
				-100000000000002L, -100000000000003L, -100000000000004L,
				-100000000000005L, -100000000000006L, -100000000000007L,
				-100000000000008L, -100000000000009L, -100000000000010L));
		varMap.put("vSet21", this.getSet(Long.class, -200000000000001L,
				-200000000000002L, -200000000000003L, -200000000000004L,
				-200000000000005L, -200000000000006L, -200000000000007L,
				-200000000000008L, -200000000000009L, -200000000000010L));
		varMap.put("vSet31", this.getSet(Long.class, -300000000000001L,
				-300000000000002L, -300000000000003L, -300000000000004L,
				-300000000000005L, -300000000000006L, -300000000000007L,
				-300000000000008L, -300000000000009L, -300000000000010L));
		varMap.put("vSet41", this.getSet(Long.class, -400000000000001L,
				-400000000000002L, -400000000000003L, -400000000000004L,
				-400000000000005L, -400000000000006L, -400000000000007L,
				-400000000000008L, -400000000000009L, -400000000000010L));
		varMap.put("vSet43", this.getSet(Long.class, -430000000000001L,
				-430000000000002L, -430000000000003L, -430000000000004L,
				-430000000000005L, -430000000000006L, -430000000000007L,
				-430000000000008L, -430000000000009L, -430000000000010L));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_109 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_109() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet12", this
				.getSet(Double.class, -4.940656458412465e-324d));
		varMap
				.put("vSet22", this.getSet(Double.class,
						1.797693134862315e+308d));
		varMap.put("vSet24", this.getSet(Double.class, 1.234567890123456e+10d));
		varMap.put("vSet26", this.getSet(Double.class, -12345.67890123456d));
		varMap.put("vSet28", this.getSet(Double.class, -52345.67890123456d));
		varMap.put("vSet30", this.getSet(Double.class, -999.00090123456d));
		varMap.put("vSet32", this.getSet(Double.class, 999.999998d));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_110 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_110() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Double.class,
				1.11111111111111111e-21d, 1.11111111111111112e-22d,
				1.11111111111111113e-23d, 1.11111111111111114e-24d,
				1.11111111111111115e-25d, 1.11111111111111116e-26d,
				1.11111111111111117e-27d, 1.11111111111111118e-28d,
				1.11111111111111119e-29d, 1.11111111111111110e-20d));
		varMap.put("vSet21", this.getSet(Double.class, 1.000693134860001e+11d,
				-1.000693134860002e+12d, 1.000693134860003e+13d,
				1.000693134860004e+14d, 1.000693134860005e+15d,
				1.000693134860006e+16d, 1.000693134860007e+17d,
				1.000693134860008e+18d, 1.000693134860009e+19d,
				1.000693134860010e+20d));
		varMap.put("vSet23", this.getSet(Double.class, 2.1000001e+23d,
				-2.1000001e+23d, 2.1000001e+23d, 2.1010001e+23d,
				2.1005001e+23d, 2.10014001e+23d, 2.1006001e+23d,
				2.15600001e+23d, 2.1000546701e+23d, 2.10012001e+23d));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_111 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_111() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Double.class, 1.111111111e-21d,
				1.1111111112e-22d, 1.111111111113e-23d, 1.111111111114e-24d,
				1.111111111115e-25d));
		varMap.put("vSet12", this.getSet(Double.class, 1.111111111e-21d,
				1.1111111112e-22d, 1.111111111113e-23d, 1.111111111114e-24d,
				1.111111111115e-25d));
		varMap.put("vSet13", this.getSet(Double.class, 1.00069000860001e+11d,
				-1.000691114860002e+12d, 1.00069222860003e+13d,
				1.0006931333004e+14d, 1.00069315560005e+15d));
		varMap.put("vSet14", this.getSet(Double.class, 1.00069000860001e+11d,
				-1.000691114860002e+12d, 1.00069222860003e+13d,
				1.0006931333004e+14d, 1.00069315560005e+15d));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_112 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_112() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Double.class, 1.701785987232706E308d));
		varMap.put("vSet21", this.getSet(Double.class, 3.240485049468877E307d));
		varMap.put("vSet31", this.getSet(Double.class, 8.246309119634988E307d));
		varMap.put("vSet41", this.getSet(Double.class, 2.829388440709593E307d));
		varMap.put("vSet43", this.getSet(Double.class, 5.576269818120417E307d));
		varMap.put("vSet45", this.getSet(Double.class, 9.184651480540669E307d));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_113 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_113() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"4.3912819275889700929E+311", "-7.7114350550860677004E+311",
				"7.18899412892447663E+310", "9.241035883921602074E+311",
				"-5.887811237446918458E+310", "-6.902493275336397826E+310",
				"3.0111087261947538268E+311", "-6.0010656821394321586E+311",
				"5.411473412259863589E+310", "-2.308234056683997506E+310"));
		varMap.put("vSet13", this.getSet(BigDecimal.class,
				"4.1014971554569698835E+311", "-6.362476749287065354E+310",
				"8.2817760328482922381E+311", "6.426497134113312233E-325",
				"-6.2127535981529269804E+310", "-4.9116696329078316774E+311",
				"1.691293121246291041E+311", "-3.24480450152561859E+310",
				"9.545093680224276083E+310", "-8.7215615799918424877E+311"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_114 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_114() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet12", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet21", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet22", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet31", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet32", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet41", this.getSet(BigDecimal.class,
				"-4.3612868834645391757E-325"));
		varMap.put("vSet42", this.getSet(BigDecimal.class,
				"-4.3612868834645391756E-325"));
		varMap.put("vSet51", this.getSet(BigDecimal.class,
				"-3.078510971167075165E+310"));
		varMap.put("vSet52", this.getSet(BigDecimal.class,
				"-2.1616001205249840936E+310"));
		varMap.put("vSet53", this.getSet(BigDecimal.class,
				"4.95981552467606311E+310"));
		varMap.put("vSet54", this.getSet(BigDecimal.class,
				"6.356221751005895942E+310"));
		varMap.put("vSet55", this.getSet(BigDecimal.class,
				"-4.9011108060532877247E+311"));
		varMap.put("vSet56", this.getSet(BigDecimal.class,
				"-1.629484958344732993E+310"));
		varMap.put("vSet57", this.getSet(BigDecimal.class,
				"2.907556102747533118E+310"));
		varMap.put("vSet58", this.getSet(BigDecimal.class,
				"1.5114646761380576204E+311"));
		varMap.put("vSet59", this.getSet(BigDecimal.class,
				"-8.7512314947736962484E+311"));
		varMap.put("vSet60", this.getSet(BigDecimal.class,
				"8.958554074956396152E+310"));
		varMap.put("vSet61", this.getSet(BigDecimal.class,
				"-6.7417711481570074659E+310"));
		varMap.put("vSet62", this.getSet(BigDecimal.class,
				"-6.7417711481570074659E+310"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_115 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_115() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"-4.8114815366530681638E+311"));
		varMap.put("vSet21", this.getSet(BigDecimal.class,
				"-6.99108295875048801E+311"));
		varMap.put("vSet23", this.getSet(BigDecimal.class,
				"-3.9213635454382293268E+311"));
		varMap.put("vSet25", this.getSet(BigDecimal.class,
				"-9.2016887261486852924E+311"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_116 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_116() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"-2.4888173228419354E+308", "-3.16343276943335343E+309",
				"3.875722573103562235E+310", "-9.759485746354575287E+310",
				"1.2112219017957643715E+311"));
		varMap.put("vSet13", this.getSet(BigDecimal.class,
				"-4.611788487281474928E+310", "-4.2612892558531226012E+311",
				"9.9514010440826311887E+311", "-3.21281958621782897E+309",
				"5.925697282143981028E+310"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_E_002_117 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_117() throws Exception {

		String testCase = this.getName().substring(4);

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Boolean.class, true));
		varMap.put("vSet13", this.getSet(Boolean.class, false));
		varMap.put("vSet15", this.getSet(Boolean.class, true));
		varMap.put("vSet17", this.getSet(Boolean.class, false));
		varMap.put("vSet19", this.getSet(Boolean.class, true));
		varMap.put("vSet21", this.getSet(Boolean.class, false));

		assertResult(this.execute(testCase, varMap), "false_e_117");
	}

	/**
	 * テストID：PENSER_E_002_118 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_118() throws Exception {

		String testCase = this.getName().substring(4);

		// Map<String, Object> varMap = new HashMap<String, Object>();
		// varMap.put("vSet12", this.getSet(Boolean.class, true));
		// varMap.put("vSet22", this.getSet(Boolean.class, true, false));
		// varMap.put("vSet32", this.getSet(Boolean.class));
		// varMap.put("vSet42", this.getSet(Boolean.class, false, true));
		// varMap.put("vSet52", this.getSet(Boolean.class, true));
		// varMap.put("vSet54", this.getSet(Boolean.class, true, false));
		//
		// assertResult(this.execute(testCase, varMap), "false_e_118");

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PENSER_E_002_119 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_119() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(Boolean.class, true, false));
		varMap.put("vSet21", this.getSet(Boolean.class, true, false));
		varMap.put("vSet23", this.getSet(Boolean.class, true, false));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"false_e_119");
	}

	/**
	 * テストID：PENSER_E_002_120 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_120() throws Exception {

		String testCase = this.getName().substring(4);

		// Map<String, Object> varMap = new HashMap<String, Object>();
		// varMap.put("vSet11", this.getSet(Boolean.class, true));
		// varMap.put("vSet12", this.getSet(Boolean.class, true));
		// varMap.put("vSet13", this.getSet(Boolean.class, true));
		// varMap.put("vSet14", this.getSet(Boolean.class, false));
		// varMap.put("vSet15", this.getSet(Boolean.class, false));
		// varMap.put("vSet16", this.getSet(Boolean.class, true));
		//
		// assertResult(this.execute(this.getName().substring(4), varMap),
		// "false_e_120");

		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());
	}

	/**
	 * テストID：PENSER_N_002_121 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_121() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "テスト漢字"));
		varMap.put("vSet21", this.getSet(String.class, "ABCDE"));
		varMap.put("vSet31", this.getSet(String.class, "ghksljh"));
		varMap.put("vSet41", this.getSet(String.class, "まめaA"));
		varMap.put("vSet43", this.getSet(String.class, "fkdjg%"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_122 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_122() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "テ字A", "afjdkoioad",
				"カタカナ", "ひらがな", "!#$%&'().", "13245", "zwAひか国", "*****", ",."));
		varMap.put("vSet12", this.getSet(String.class, "テ字A", "afjdkoioad",
				"カタカナ", "ひらがな", "!#$%&'().", "13245", "zwAひか国", "*****", ",."));
		varMap.put("vSet21", this.getSet(String.class, "ABCDE", "あああ", "abc",
				"   ", "1234", "@@@@", "/////", "<>", "[]", "^^^^"));
		varMap.put("vSet22", this.getSet(String.class, "ABCDE", "あああ", "aBc",
				"   ", "1234", "@@@@", "/////", "<>", "[]", "^^^^"));
		varMap.put("vSet23", this.getSet(String.class, "afbかa", "あ", "い", "う",
				"え", "お", "A", "B", "z", "0"));
		varMap.put("vSet24", this.getSet(String.class, "afaかa", "あ", "い", "う",
				"え", "お", "A", "B", "z", "0"));
		varMap.put("vSet25", this.getSet(String.class, "ヤフー", "あ", "い", "う",
				"え", "お", "A", "B", "z", "0"));
		varMap.put("vSet26", this.getSet(String.class, "ヤフー", "あ", "い", "う",
				"え", "お", "A", "B", "z", "0"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value3");
	}

	/**
	 * テストID：PENSER_N_002_123 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_123() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "ｄｇｈｇｈテ字A", "Ａ", "ＢＣ",
				"ＤＥＦ", "ＧＨＩＪ"));
		varMap.put("vSet13", this.getSet(String.class, "!#$%'(()", "ア", "カキ",
				"サシス", "タチツ"));
		varMap.put("vSet15", this.getSet(String.class, "ZZafbかa", "地図", "辞書",
				"Xyz", "ワオン"));
		varMap.put("vSet17", this.getSet(String.class, "ヤ@フー", "00000",
				"1423534654", "491386", "-4576357"));
		varMap.put("vSet19", this.getSet(String.class, "計画１", "１", "２３４",
				"５６７", "８９０１"));
		varMap.put("vSet21", this.getSet(String.class, "+++++++", "ーーー", "＿＿＿",
				"／／／", "＠＠＠"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_124 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_124() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(String.class, "RIUOTSKJLSGｄｇｈｇｈテ字A"));
		varMap.put("vSet21", this.getSet(String.class, "!#$%a'(()"));
		varMap.put("vSet23", this.getSet(String.class, "ジショZZafbかa"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_125 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_125() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"-5.9817034389012826554E+311", "-3.013569472093771905E+310",
				"4.6212281783754534422E-326", "3.7215043852977411973E+311",
				"-2.9522255611438540572E+309"));
		varMap.put("vSet21", this.getSet(BigDecimal.class,
				"-6.287860396969205254E+310", "-3.917302272534161709E+309",
				"-9.8518433645469580507E+310", "4.3411083401745703856E+311",
				"8.7915989277981961256E+311"));
		varMap.put("vSet31", this.getSet(BigDecimal.class,
				"9.226231287519986127E+309", "1.5212930609529806975E+311",
				"-6.1813205215763093165E+311", "-2.946637126068934902E+310",
				"-2.671598230174284619E+311"));
		varMap.put("vSet41", this.getSet(BigDecimal.class,
				"-8.2211118410229277487E+311", "-2.892846226350137361E+309",
				"7.232247790818069076E+310", "5.901725078894210197E+311",
				"-4.4938325316016230166E+310"));
		varMap.put("vSet43", this.getSet(BigDecimal.class,
				"-6.986826918860019984E-330", "5.432214624023365586E+310",
				"-6.694694794386496911E+310", "-5.3113650035263091448E+310",
				"6.511354521146265611E+310"));
		varMap.put("vSet45", this.getSet(BigDecimal.class,
				"1.1512531416567043477E+309", "-1.0217191836389046372E+311",
				"-3.2114821843981263795E+311", "9.623917481562357757E+309",
				"-3.614620398541107449E+310"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_126 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_126() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet12", this.getSet(BigDecimal.class,
				"2.1112476578581437637E+311"));
		varMap.put("vSet22", this.getSet(BigDecimal.class,
				"-3.054245051328007905E-327"));
		varMap.put("vSet24", this.getSet(BigDecimal.class,
				"7.9717054027038563705E+311"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value3");
	}

	/**
	 * テストID：PENSER_N_002_127 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_127() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"-4.803770632399515489E+310"));
		varMap.put("vSet13", this.getSet(BigDecimal.class,
				"-3.9910910211880950507E-330"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_128 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_128() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet11", this.getSet(BigDecimal.class,
				"6.0816677723786702502E+311", "-3.3149E-321",
				"1.609179066337876017E+310", "-3.4814114059934607333E+311",
				"7.1620618927054668574E+310", "1.549E-322",
				"1.2819580050040030443E+310", "-8.3749E-321",
				"-6.4013643001737486775E+310", "-6.3149E-321"));
		varMap.put("vSet12", this.getSet(BigDecimal.class,
				"6.0816677723786702502E+311", "-3.3149E-322",
				"1.609179066337876017E+310", "-3.4814114059934607333E+311",
				"7.1620618927054668574E+310", "1.549E-322",
				"1.2819580050040030443E+310", "-8.3749E-321",
				"-6.4013643001737486775E+310", "-6.3149E-321"));
		varMap.put("vSet21", this.getSet(BigDecimal.class, "5.5149E-321",
				"-1010.0", "7.548570913072135537E+310", "-9550.0",
				"-6.541600493300025391E+311", "-8.8549E-321",
				"9.861348220685170792E+309", "-2.3812027601780035573E+311",
				"3210.0", "3.945961103165373042E+310"));
		varMap.put("vSet22", this.getSet(BigDecimal.class, "5.5149E-321",
				"-1010.0", "7.548570913072145537E+310", "-9550.0",
				"-6.541600493300025391E+311", "-8.8549E-321",
				"9.861348220685170792E+309", "-2.3812027601780035573E+311",
				"3210.0", "3.945961103165373042E+310"));
		varMap.put("vSet23", this.getSet(BigDecimal.class, "8910.0", "5970.0",
				"-3.006361491104670129E+310", "-450.0",
				"9.3210206818345103393E+311", "6410.0", "-5.9949E-321",
				"-8.44118828532728431E+311", "2130.0", "-850.0"));
		varMap.put("vSet24", this.getSet(BigDecimal.class, "8910.0", "5970.1",
				"-3.006361491104670129E+310", "-450.0",
				"9.3210206818345103393E+311", "6410.0", "-5.9949E-321",
				"-8.44118828532728431E+311", "2130.0", "-850.0"));
		varMap.put("vSet25", this.getSet(BigDecimal.class,
				"-5.446582329525276974E+310", "5.7820503472810042018E+310",
				"4.949E-322", "8.99908135306884E+308", "-4.8949E-321",
				"-1.4015799439816982717E+311", "3.706133785800298265E+310",
				"-8.5349E-321", "-6.781079509935408349E+311", "4.3549E-321"));
		varMap.put("vSet26", this.getSet(BigDecimal.class,
				"-5.446582329525276974E+310", "5.7820503472810042018E+310",
				"4.949E-322", "8.99908135306884E+308", "-4.8949E-321",
				"-1.4015799439816982717E+311", "3.706133785800298265E+310",
				"-8.5340E-321", "-6.781079509935408349E+311", "4.3549E-321"));
		varMap.put("vSet27", this.getSet(BigDecimal.class, "8610.0",
				"6.6616814722307296875E+311", "-7.2749E-321",
				"-2.67608170591981943E+309", "1.1610640663708538951E+311",
				"-4610.0", "-8.5213466478360741127E+311", "2530.0", "5110.0",
				"-4.0349E-321"));
		varMap.put("vSet28", this.getSet(BigDecimal.class, "8610.0",
				"6.6616814722307296875E+311", "-7.2749E-321",
				"-2.67608170591981943E+309", "1.1610640663708538951E+311",
				"-4610.01", "-8.5213466478360741127E+311", "2530.0", "5110.0",
				"-4.0349E-321"));
		varMap.put("vSet29", this.getSet(BigDecimal.class,
				"3.1210871596399316383E+311", "-3.86631500066861271E+310",
				"-5.669618765118665307E+310", "-9.186286001726630132E+310",
				"7430.0", "8.968966368929333867E+310",
				"-3.002832272670582951E+310", "8.1640588173386750144E+310",
				"1.7034198151813342976E+310", "-5.106236629834020754E+310"));
		varMap.put("vSet30", this.getSet(BigDecimal.class,
				"3.1210871596399316383E+311", "-3.86631500066861271E+310",
				"-5.669618765118665307E+310", "-9.186285001726630132E+310",
				"7430.0", "8.968966368929333867E+310",
				"-3.002832272670582951E+310", "8.1640588173386750144E+310",
				"1.7034198151813342976E+310", "-5.106236629834020754E+310"));
		varMap.put("vSet31", this.getSet(BigDecimal.class,
				"-7.688207323488338297E+310", "8610.0", "-5.6149E-321",
				"-6930.0", "1.749767623233424346E+310",
				"-3.826144866915835068E+310", "2.86359775267914217E+310",
				"8.3349E-321", "-9.721393581525468471E+311", "2.3149E-321"));
		varMap.put("vSet32", this.getSet(BigDecimal.class,
				"-1.688207323488338297E+310", "8610.0", "-5.6149E-321",
				"-6930.0", "1.749767623233424346E+310",
				"-3.826144866915835068E+310", "2.86359775267914217E+310",
				"8.3349E-321", "-9.721393581525468471E+311", "2.3149E-321"));

		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_129 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_129() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(String.class, "あｇｆｊａｄｆｋｊｔｅｓｕｔｏ　"));
		varMap.put("vSet2", this.getSet(String.class, "あｇｆｊａｄｆｋｊｔｅｓｕｔｏ　"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_130 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_130() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(String.class, "あgfaいう", "かABCきこ",
				"くあ-ｇ", "ggs", "ａＡ"));
		varMap.put("vSet2", this.getSet(String.class, "あgfaいう", "かABCきこ",
				"くあ-ｇ", "ghs", "ａＡ"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_131 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_131() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet2", this.getSet(String.class, "あか", "さた", "なは", "まや",
				"らわ", "ｱb", "ＡＢ", "ef", "gh", "11"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_132 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_132() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet2", this.getSet(String.class, "ﾜﾊhabc日本Japan"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_133 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_133() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Integer.class, 128));
		varMap.put("vSet2", this.getSet(Integer.class, 127));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_134 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_134() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Integer.class, -2, -1, 0, 1, 2));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_135 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_135() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet2", this.getSet(Integer.class, -453689, -9886, 17,
				1264, -8, -120, -429, -7563, -47541, -999));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_136 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_136() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Integer.class, -10000));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_137 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_137() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Long.class, -9223372036854775808L,
				13372036854775808L, 23372036854775808L, 33372036854775808L,
				43372036854775808L));
		varMap.put("vSet2", this.getSet(Long.class, -9223372036854775808L,
				13372036854775808L, 23372036854775808L, 33372036854775808L,
				43372036854775808L));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_138 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_138() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Long.class, -9223372036854775808L));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_139 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_139() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet2", this.getSet(Long.class, -1223372036854775801L));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_140 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_140() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Long.class, -100000000000001L,
				-100000000000002L, -100000000000003L, -100000000000004L,
				-990000000000005L, -100000000000006L, -100000000000007L,
				-100000000000008L, -100000000000009L, -100000000000010L));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_141 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_141() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Double.class, 1.111111111e-21d,
				1.1111111112e-22d, 1.111111111113e-23d, 1.111111111114e-24d,
				1.111111111115e-25d));
		varMap.put("vSet2", this.getSet(Double.class, 1.111111111e-21d,
				1.1111111112e-22d, 1.111111111113e-23d, 1.111111110004e-24d,
				1.111111111115e-25d));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_142 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_142() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Double.class, 1.701785987232706E308));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_143 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_143() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap
				.put("vSet2", this.getSet(Double.class,
						-4.940656458412464e-324d));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_144 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_144() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(Double.class, 1.000693134860001e+11d,
				-1.000693134860002e+12d, 1.000693134860003e+13d,
				1.000693134860004e+14d, 1.000693134860005e+15d,
				1.000693134860006e+16d, 1.000693134860007e+17d,
				1.000693134860008e+18d, 1.000693134860009e+19d,
				1.000693134860010e+20d));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_145 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_145() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(BigDecimal.class,
				"-4.361265375674645391757E-325"));
		varMap.put("vSet2", this.getSet(BigDecimal.class,
				"-4.361265375674645391757E-325"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_146 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_146() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(BigDecimal.class,
				"0.3785538680759255789e+311", "-6.0339377816298938242e-329",
				"-1.5554053338944619856e-331", "7.1740640385300991241e+309",
				"-7.3093707959338412850e-330", "9.4216976280510426111e+310",
				"2.6060474052291199016e-330", "7.9202538774231271530e+310",
				"-4.9312340658717982512e-330", "7.0505013142305847450e+310"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_147 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_147() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet2", this.getSet(BigDecimal.class,
				"2.8237009414209024824e-330", "-7.6561293085593160917e+310",
				"-0.6697362752017862813e-330", "4.6203219877924329677e+310",
				"8.6997384703785268276e-330"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_148 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_148() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(BigDecimal.class,
				"-8.6997384703785268276e-311"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_E_002_149 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_149() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());

		// Map<String, Object> varMap = new HashMap<String, Object>();
		// varMap.put("vSet1", this.getSet(Boolean.class, true));
		// varMap.put("vSet2", this.getSet(Boolean.class, false));
		// assertResult(this.execute(this.getName().substring(4), varMap),
		// "value2");
	}

	/**
	 * テストID：PENSER_E_002_150 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_150() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());

		// Map<String, Object> varMap = new HashMap<String, Object>();
		// varMap.put("vSet1", this.getSet(Boolean.class, true, false));
		// assertResult(this.execute(this.getName().substring(4), varMap),
		// "value1");
	}

	/**
	 * テストID：PENSER_E_002_151 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_151() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());

		// Map<String, Object> varMap = new HashMap<String, Object>();
		// varMap.put("vSet2", this.getSet(Boolean.class, true));
		// assertResult(this.execute(this.getName().substring(4), varMap),
		// "value1");
	}

	/**
	 * テストID：PENSER_E_002_152 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_E_002_152() throws Exception {

		String testCase = this.getName().substring(4);
		Exception e = super.invokeCheckInitialLoaderException(testCase);
		assertEquals(PEXException.class, e.getClass());

		// Map<String, Object> varMap = new HashMap<String, Object>();
		// varMap.put("vSet1", this.getSet(Boolean.class, true));
		// assertResult(this.execute(this.getName().substring(4), varMap),
		// "value2");
	}

	/**
	 * テストID：PENSER_N_002_153 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_153() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(String.class, "テ字A", "afjdkoioad",
				"カタカナ", "ひらがな", "!#$%'().", "13245", "zwAひか国", "*****", ",.",
				"ｶｷｸ"));
		varMap.put("vSet2", this.getSet(String.class, "テ字A", "afjdkoioad",
				"カタカナ", "ひらがな", "!#$%'().", "13245", "zwAひか国", "*****", ",.",
				"ｶｷｸ"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_154 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_154() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(String.class, "ﾜAあＢｂａ－%"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_155 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_155() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet2", this.getSet(String.class, "ｱｲｳRIUOTLSGｄｇｈｇｈテ字A"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_156 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_156() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(String.class, "+++++++", "ーーー", "＿＿＿",
				"／／／", "＠＠＠"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_157 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_157() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(BigDecimal.class,
				"3.0149051771198015400e+310", "-5.2778711920576941156e-330",
				"6.3951857635749372320e+310", "-0.5522463080539941129e-330",
				"9.9897317695446487160e+310"));
		varMap.put("vSet2", this.getSet(BigDecimal.class,
				"3.0149051771198015400e+310", "-5.2778711920576941156e-330",
				"7.3951857635749372320e+310", "-0.5522463080539941129e-330",
				"9.9897317695446487160e+310"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}

	/**
	 * テストID：PENSER_N_002_158 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_158() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(BigDecimal.class,
				"0.5627184893610027859e-330"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_159 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_159() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		varMap.put("vSet2", this.getSet(BigDecimal.class,
				"2.13467276578581437637E+311"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value2");
	}

	/**
	 * テストID：PENSER_N_002_160 検索キー設定→検索実施→引数項目値設定→条件判定実施→結果確認
	 */
	@Test
	public void testPENSER_N_002_160() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("vSet1", this.getSet(BigDecimal.class,
				"3.0461174422355271324e+310", "-1.3862039436029390352e-330",
				"4.1270899543164007671e+310", "-9.4361044947433475532e-330",
				"4.1517407759696384392e+310"));
		assertResult(this.execute(this.getName().substring(4), varMap),
				"value1");
	}
}