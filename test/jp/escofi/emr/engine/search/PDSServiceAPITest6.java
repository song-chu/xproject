package jp.escofi.emr.engine.search;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.escofi.emr.DJUnitTestCaseEx;
import jp.escofi.emr.engine.search.ConditionItemInfo;
import jp.escofi.emr.engine.search.PDSDumpServiceAPI;
import jp.escofi.emr.engine.search.PDSEngine;
import jp.escofi.emr.engine.search.PDSResponse;
import jp.escofi.emr.engine.search.PDSServiceAPI;
import jp.escofi.emr.engine.search.ResultObject;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;
import jp.iwin.pds.xml2db.common.exception.PEXInitializeException;
import jp.iwin.pds.xml2db.common.exception.PEXInvalidKeyException;
import jp.iwin.pds.xml2db.common.exception.PEXUnExpectedStateException;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.junit.Test;

public class PDSServiceAPITest6 extends DJUnitTestCaseEx {

	private static final String BASE_FOLDER = "Z:/PDSNgine/xml";

	/**
	 * _v\[Xx[XtH_
	 */
	private static final String DUMP_BASE_FOLDER = "Z:/PDSNgine/xml/PDSServiceAPI6_Dump";

	public PDSServiceAPITest6() {

		super(PDSServiceAPITest6.class, BASE_FOLDER);
	}

	/**
	 * õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
	 *
	 * @param dataModelName
	 *            f[^f¼(eXgP[XID)
	 * @param vars
	 *            øÚ¼=øÚl
	 * @return PDSNX
	 * @throws Exception
	 */
	private PDSResponse execute(String dataModelName, String... vars)
			throws Exception {

		// ----------------------<<üÍlÝè>>-------------------------------//
		// øÝè
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add(dataModelName); // C³|Cg
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock ObjectpAÔplðÝè·éB
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<ÎÛ@\À{>>-------------------------------//
		// CjV[hðÀs·éB
		PDSEngine.getInstance();

		// øÚæ¾
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res
				.getConditionItemInfoMap();

		if (conditionItemInfoMap == null) {
			return res;
		}

		// øÚlMap
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();

		String itemName = null; // øÚ¼
		String javaDataType = null; // øÚàf[^^

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		for (ConditionItemInfo conditionItemInfo : collection) {

			// øÚNX©çîñðæ¾·éB
			itemName = conditionItemInfo.getItemName();
			javaDataType = conditionItemInfo.getJavaDataType();

			String var = "";
			if (vars != null) {
				for (int i = 0; i < vars.length; i++) {

					int idx = -1;

					if (vars[i].startsWith(itemName)) {
						idx = vars[i].indexOf("=");
						var = vars[i].substring(idx + 1);
						break;
					}
				}
			}

			if ("".equals(var)) {
				var = "default";
			}

			// øÚæ¾îñÉîÃ«AøÚðæ¾ãA
			// øÚf[^^AøÚàf[^^Éí¹Ä^Ï·µAøÚlÉãü·éB
			Object varValue = PUTConvertUtil.convert(var, javaDataType);

			// øÚl}bvÉÝè
			conditionItemValueMap.put(itemName, varValue);
		}
		// _vÀs
		if (!this.getName().substring(11, 12).equals("E")) {

			if (NEED_DUMP) {
				PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
						.substring(4));
			}
		}

		// PDSNXÉøÚl}bvðÝè
		res.setConditionItemValueMap(conditionItemValueMap);

		// ®«læ¾\bhðÄÑo·B
		res = PDSServiceAPI.getAttrValue(res);
		return res;
	}

	/**
	 * õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
	 *
	 * @param dataModelName
	 *            f[^f¼(eXgP[XID)
	 * @param varMap
	 *            øÚ}bv
	 * @return PDSNX
	 * @throws Exception
	 */
	private PDSResponse execute2(String dataModelName,
			Map<String, Object> objMap) throws Exception {

		// ----------------------<<üÍlÝè>>-------------------------------//
		// øÝè
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add(dataModelName); // C³|Cg
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock ObjectpAÔplðÝè·éB
		super.replaceProp(super.getName().substring(4));

		// ----------------------<<ÎÛ@\À{>>-------------------------------//
		// CjV[hðÀs·éB
		PDSEngine.getInstance();

		// øÚæ¾
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res
				.getConditionItemInfoMap();

		if (conditionItemInfoMap == null) {
			return res;
		}

		// øÚlMap
		Map<String, Object> conditionItemValueMap = new HashMap<String, Object>();

		Collection<ConditionItemInfo> collection = conditionItemInfoMap
				.values();

		for (ConditionItemInfo conditionItemInfo : collection) {
			// øÚNX©çîñðæ¾·éB
			String itemName = conditionItemInfo.getItemName();

			if (objMap != null && objMap.containsKey(itemName)) {
				Object var = objMap.get(itemName);
				conditionItemValueMap.put(itemName, var);
			}
		}
		// _vÀs
		if (!this.getName().substring(11, 12).equals("E")) {

			if (NEED_DUMP) {
				PDSDumpServiceAPI.excuteDump(DUMP_BASE_FOLDER, this.getName()
						.substring(4));
			}
		}

		// PDSNXÉøÚl}bvðÝè
		res.setConditionItemValueMap(conditionItemValueMap);

		// ®«læ¾\bhðÄÑo·B
		res = PDSServiceAPI.getAttrValue(res);
		return res;
	}

	/**
	 * ÊmF
	 *
	 * @param res
	 */
	private void assertResult(PDSResponse res, String flag) {
		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		// Êl

		if (flag.substring(0, 4).equals("true")) {
			assertEquals(flag, result);
		} else {
			assertEquals(flag, result);
		}
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_353 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_353() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();

		varMap.put("var2", this.getSet(BigDecimal.class,
				"-8.761456421457456363E+311", "-8.761456421457456362E+311"));
		assertResult(this.execute2(this.getName().substring(4), varMap),
				"false353");
	}

	/**
	 * eXgIDFPENSER_N_002_354 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_354() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("ver1", this.getSet(BigDecimal.class,
				"-1.6997384703785268276e-311"));
		assertResult(this.execute2(this.getName().substring(4), varMap),
				"true354");
	}

	/**
	 * eXgIDFPENSER_N_002_355 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_355() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("ver1", this.getSet(String.class, " @",
				" @"));
		varMap.put("ver2", this.getSet(String.class, " @"));
		assertResult(this.execute2(this.getName().substring(4), varMap),
				"false355");
	}

	/**
	 * eXgIDFPENSER_N_002_356 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_356() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("ver1", this.getSet(String.class, "ÜÊhabcú{Japan",
				"ÜÊhabcú{Japam"));
		assertResult(this.execute2(this.getName().substring(4), varMap),
				"true356");
	}

	/**
	 * eXgIDFPENSER_N_002_357 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_357() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var2=-999888777666555444333222111.907002"), "true357");
	}

	/**
	 * eXgIDFPENSER_N_002_358 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_358() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=98745632100123456.90807048725610",
				"var2=98745632100123456.9080704872561000001"), "false358");
	}

	/**
	 * eXgIDFPENSER_N_002_359 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_359() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1234567890123456789.90", "var2=1234567890123456789.9"),
				"false359");
	}

	/**
	 * eXgIDFPENSER_N_002_360 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_360() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-9223372036854775808"), "true360");
	}

	/**
	 * eXgIDFPENSER_N_002_361 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_361() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-9000000000000000008", "var2=-9000000000000000009"),
				"false361");
	}

	/**
	 * eXgIDFPENSER_N_002_362 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_362() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=9223372036854775807"), "false362");
	}

	/**
	 * eXgIDFPENSER_N_002_363 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_363() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=34567890.94065645"), "true363");
	}

	/**
	 * eXgIDFPENSER_N_002_364 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_364() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2.7976931348624", "var2=2.7976931348623"), "false364");
	}

	/**
	 * eXgIDFPENSER_N_002_365 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_365() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1.3076936231570e+156d"), "false365");
	}

	/**
	 * eXgIDFPENSER_N_002_366 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_366() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var2=-999888777666555444333222.907002"), "true366");
	}

	/**
	 * eXgIDFPENSER_N_002_367 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_367() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=8.99887766554433221100"), "true367");
	}

	/**
	 * eXgIDFPENSER_N_002_368 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_368() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=98765432109876543209.9876543210000001"), "false368");
	}

	/**
	 * eXgIDFPENSER_N_002_369 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_369() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1542423.792E+271"), "true369");
	}

	/**
	 * eXgIDFPENSER_N_002_370 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_370() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var2=1.797E+200"), "true370");
	}

	/**
	 * eXgIDFPENSER_N_002_371 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_371() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=2.7976931348621", "var2=2.7976931348620"), "false371");
	}

	/**
	 * eXgIDFPENSER_N_002_372 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_372() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=-9223372036854775801"), "true372");
	}

	/**
	 * eXgIDFPENSER_N_002_373 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_373() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var2=123456789012345"), "true373");
	}

	/**
	 * eXgIDFPENSER_N_002_374 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_374() throws Exception {
		assertResult(this.execute(this.getName().substring(4, 20),
				"var1=1023300000000000001", "var2=1023300000000000000"),
				"false374");
	}

	/**
	 * eXgIDFPENSER_N_002_375 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_375() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		Set<BigDecimal> varSet1 = new HashSet<BigDecimal>();
		Set<BigDecimal> varSet2 = new HashSet<BigDecimal>();
		varSet1.add(new BigDecimal("4.056746E+508"));
		varSet1.add(new BigDecimal("4.056746E+509"));

		varSet2.add(new BigDecimal("5.056746E+508"));
		varSet2.add(new BigDecimal("5.056746E+509"));
		varSet2.add(new BigDecimal("5.056746E+510"));

		varMap.put("var1", varSet1);
		varMap.put("var2", varSet2);

		assertResult(this.execute2(this.getName().substring(4, 20), varMap),
				"true375");
	}

	/***
	 * eXgIDFPENSER_N_002_376
	 */
	@Test
	public void testPENSER_N_002_376() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=2234567890123456789.900010e-326",
				"var3=2234567890123456989.124400e-326");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true376";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/***
	 * eXgIDFPENSER_N_002_377
	 */
	@Test
	public void testPENSER_N_002_377() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var3=62345678902349876543.56471010");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true377";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/***
	 * eXgIDFPENSER_N_002_378
	 */
	@Test
	public void testPENSER_N_002_378() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var2=-7654567890123456903.12012090",
				"var3=7654567890123456111.12012190");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false378";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_379
	 */
	@Test
	public void testPENSER_N_002_379() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var2=1.010202030304040e+308d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true379";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_409
	 */
	@Test
	public void testPENSER_N_002_409() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var3=1.123456789012346e-300");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true409";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_380
	 */
	@Test
	public void testPENSER_N_002_380() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=0.123456789012345e-324d", "var3=1.234567890123456e+308d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true380";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_381
	 */
	@Test
	public void testPENSER_N_002_381() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var2=1.112223334445557e+308d", "var3=1.112223334445558e+308d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true381";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_382
	 */
	@Test
	public void testPENSER_N_002_382() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=0.123456789012345e-324d", "var3=1.234567890123456e+308d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false382";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_383
	 */
	@Test
	public void testPENSER_N_002_383() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=999999999999999999", "var3=1000000000000000000");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true383";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_384
	 */
	@Test
	public void testPENSER_N_002_384() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=0", "var2=-1");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false384";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_385
	 */
	@Test
	public void testPENSER_N_002_385() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=0", "var2=-1");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false385";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_386
	 */
	@Test
	public void testPENSER_N_002_386() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=0", "var2=-1");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false386";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_387
	 */
	@Test
	public void testPENSER_N_002_387() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var2= ¢¤¦");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true387";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/***
	 * eXgIDFPENSER_N_002_388
	 */
	@Test
	public void testPENSER_N_002_388() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var3=¨¨±±»»ÆÆÌÌ");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false388";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/***
	 * eXgIDFPENSER_N_002_389
	 */
	@Test
	public void testPENSER_N_002_389() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var3=¨¨±±»»ÆÆÌÌ");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false389";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/***
	 * eXgIDFPENSER_N_002_390
	 */
	@Test
	public void testPENSER_N_002_390() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var2=-7234567890321654999.9000");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true390";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_391
	 */
	@Test
	public void testPENSER_N_002_391() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=-1.123456789012345e-300d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false391";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_392
	 */
	@Test
	public void testPENSER_N_002_392() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=1.123456789012345e-300d", "var2=1.123456789012345e-300d",
				"var3=1.123456789012345e-300d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true392";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_393
	 */
	@Test
	public void testPENSER_N_002_393() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=1.797693134862313e+308d", "var2=1.797693134862314e+308d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false393";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_394
	 */
	@Test
	public void testPENSER_N_002_394() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=1.797693134862313e+308d", "var2=1.797693134862314e+308d");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false394";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_395
	 */
	@Test
	public void testPENSER_N_002_395() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=999999999999999999", "var3=1000000000000000000");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false395";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_396
	 */
	@Test
	public void testPENSER_N_002_396() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=0", "var2=-1");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true396";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_397
	 */
	@Test
	public void testPENSER_N_002_397() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=-9223372036854775808", "var2=-9223372036854775807",
				"var3=0");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false397";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_398
	 */
	@Test
	public void testPENSER_N_002_398() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=-9223372036854775808", "var2=-9223372036854775807",
				"var3=0");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false398";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_399
	 */
	@Test
	public void testPENSER_N_002_399() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=³³³³µ");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true399";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_400
	 */
	@Test
	public void testPENSER_N_002_400() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=-1");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "false400";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_401
	 */
	@Test
	public void testPENSER_N_002_401() throws Exception {

		// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
		PDSResponse res = this.execute(this.getName().substring(4, 20),
				"var1=-2147483648", "var2=2147483647", "var3=2147483647");

		// ----------------------<<ÊmFAC³|CgSTART>>-------------------------------//
		// Xe[^XmF
		assertEquals(PCTStatus.NORMAL, res.getStatus());
		// ð¶L³mF
		assertEquals(true, res.isCondition());
		// ®«lmF
		String result = (String) res.getResultObject().getValue();
		String expected = "true401";

		// Êl
		assertEquals(expected, result);
		// ----------------------<<ÊmFAC³|CgEND>>-------------------------------//
	}

	/**
	 * eXgIDFPENSER_N_002_403
	 */
	@Test
	public void testPENSER_N_002_403() throws Exception {
		assertResult(this.execute(this.getName().substring(4), "var2="), "true"
				+ this.getName().substring(17));
	}

	/**
	 * eXgIDFPENSER_N_002_408 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_408() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", 12345678);
		varMap.put("var2", 12345678L);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false408");
	}

	/**
	 * eXgIDFPENSER_N_002_410 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_410() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "12345678");
		varMap.put("var2", 12345678);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false410");
	}

	/**
	 * eXgIDFPENSER_N_002_411 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_411() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", 92233720368547d);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false411");
	}

	/**
	 * eXgIDFPENSER_N_002_412 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_412() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", new BigDecimal("-1.797693134862315e308"));
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false412");
	}

	/**
	 * eXgIDFPENSER_N_002_413 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_413() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "false");
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false413");
	}

	/**
	 * eXgIDFPENSER_N_002_414 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_414() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", this.getSet(Integer.class, -453689));

		assertResult(this.execute2(this.getName().substring(4), varMap),
				"false414");
	}

	/**
	 * eXgIDFPENSER_N_002_415 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_N_002_415() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1000);

		assertResult(this.execute2(this.getName().substring(4), varMap),
				"false415");
	}

	/**
	 * eXgIDFPENSER_E_002_4 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	// @Test
	// public void testPENSER_E_002_4() throws Exception {
	//
	// try {
	// // eXgÎÛ\bhÀs
	// this.execute(this.getName().substring(4, 18),
	// "var1=false", "var2=true");
	// fail();
	// } catch (PEXUnExpectedStateException e) {
	// // ÊmF
	// assertTrue(true);
	// log.info(e);
	// }
	// }

	/**
	 * eXgIDFPENSER_E_002_5 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	// @Test
	// public void testPENSER_E_002_5() throws Exception {
	//
	// try {
	// // eXgÎÛ\bhÀs
	// this.execute(this.getName().substring(4, 18),
	// "var1=false", "var2=false");
	// fail();
	// } catch (PEXUnExpectedStateException e) {
	// // ÊmF
	// assertTrue(true);
	// log.info(e);
	// }
	// }

	/**
	 * eXgIDFPENSER_E_002_6 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	// @Test
	// public void testPENSER_E_002_6() throws Exception {
	//
	// try {
	// // eXgÎÛ\bhÀs
	// this.execute(this.getName().substring(4, 18),
	// "var1=true", "var2=false");
	// fail();
	// } catch (PEXUnExpectedStateException e) {
	// // ÊmF
	// assertTrue(true);
	// log.info(e);
	// }
	// }

	/**
	 * eXgIDFPENSER_E_002_7 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	// @Test
	// public void testPENSER_E_002_7() throws Exception {
	//
	// try {
	// // eXgÎÛ\bhÀs
	// this.execute(this.getName().substring(4, 18),
	// "var1=true", "var2=true");
	// fail();
	// } catch (PEXUnExpectedStateException e) {
	// // ÊmF
	// assertTrue(true);
	// log.info(e);
	// }
	// }

	/**
	 * eXgIDFPENSER_E_002_8
	 */
	@Test
	public void testPENSER_E_002_8() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4, 18), "var1=true",
					"var2=false", "var3=true");

			fail();
		} catch (PEXInitializeException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_N_002_9
	 */
	@Test
	public void testPENSER_E_002_9() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4), "var1=false",
					"var2=true", "var3=false");

			fail();
		} catch (PEXInitializeException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_10
	 */
	@Test
	public void testPENSER_E_002_10() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4), "var1=2147483646",
					"var2=-2147483647", "var3=21474836470000000000.1",
					"var4=-21474836480000000000", "var5=2147483647");

			fail();
		} catch (PEXConditionNotMatchedException e) {
			// ÊmF
			assertEquals(PCTMessageCode.P007E, e.getErrCode());
		}
	}

	/**
	 * eXgIDFPENSER_E_002_11
	 */
	@Test
	public void testPENSER_E_002_11() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4), "var1=2147483647",
					"var2=-2147483640", "var3=11111111");

			fail();
		} catch (PEXConditionNotMatchedException e) {
			// ÊmF
			assertEquals(PCTMessageCode.P007E, e.getErrCode());
		}
	}

	/**
	 * eXgIDFPENSER_E_002_12 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_12() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			assertResult(this.execute(this.getName().substring(4), "var1=0",
					"var2="), "true" + this.getName().substring(17));

			fail();
		} catch (IllegalArgumentException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_13 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_13() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 3.0149e+100d);
		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXInitializeException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertEquals(PCTMessageCode.P010E, e.getErrCode());
		}
	}

	/**
	 * eXgIDFPENSER_E_002_14 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_14() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", this.getSet(BigDecimal.class, "3.0149e+100"));
		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXInitializeException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertEquals(PCTMessageCode.P010E, e.getErrCode());
		}
	}

	/**
	 * eXgIDFPENSER_E_002_15 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_15() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", new BigDecimal("3.0149e+100"));
		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXInitializeException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertEquals(PCTMessageCode.P010E, e.getErrCode());
		}
	}

	/**
	 * eXgIDFPENSER_E_002_16 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_16() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4), "var2=0");

			fail();
		} catch (IllegalArgumentException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_17 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_17() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4),
					"var1=-9223372036854770000");

			fail();
		} catch (IllegalArgumentException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_18 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_18() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4), "var1=");

			fail();
		} catch (IllegalArgumentException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_19 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_19() throws Exception {

		try {
			// õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{
			this.execute(this.getName().substring(4), "var1=false");

			fail();
		} catch (IllegalArgumentException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_105
	 */
	@Test
	public void testPENSER_E_002_105() throws Exception {

		// øÝè
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock ObjectpAÔplðÝè·éB
			super.replaceProp(super.getName().substring(4), "PENSER_E_002_2");

			// CjV[hðÀs·éB
			PDSEngine.getInstance();

			// øÚæ¾
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ®«lIuWFNgÉnullðÝè·éB
			response.setResultObject(null);

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		} catch (NullPointerException e) {
			fail();
		}
	}

	/**
	 * eXgIDFPENSER_E_002_106
	 */
	@Test
	public void testPENSER_E_002_106() throws Exception {

		// øÝè
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock ObjectpAÔplðÝè·éB
		super.replaceProp(super.getName().substring(4), "PENSER_N_002_1");

		// CjV[hðÀs·éB
		PDSEngine.getInstance();

		// øÚæ¾
		PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

		// ÊlIuWFNgÉnullðÝè·éB
		response.setResultObject(new ResultObject(null, "String",
				"java.lang.String", false, ""));
		PDSServiceAPI.getAttrValue(response);

		// ÊmF
		assertEquals(null, response.getResultObject().getValue());
	}

	/**
	 * eXgIDFPENSER_E_002_107
	 */
	@Test
	public void testPENSER_E_002_107() throws Exception {

		// øÝè
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_N_002_1");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			super.replaceProp(super.getName().substring(4), "PENSER_N_002_1");

			// CjV[hðÀs·éB
			PDSEngine.getInstance();

			// øÚæ¾
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			// ÊlIuWFNgÉnullðÝè·éB
			response.setConditionItemValueMap(null);
			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_108_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_108_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_108_1");
	}

	/**
	 * eXgIDFPENSER_E_002_108_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_108_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1234567l);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_108_2");
	}

	/**
	 * eXgIDFPENSER_E_002_108_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_108_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 0.1234567d);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_108_3");
	}

	/**
	 * eXgIDFPENSER_E_002_109 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_109() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", new BigDecimal("9.90"));
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_109");
	}

	/**
	 * eXgIDFPENSER_E_002_110 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_110() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", true);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_110");
	}

	/**
	 * eXgIDFPENSER_E_002_111_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_111_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", new BigDecimal("9"));
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_111_1");
	}

	/**
	 * eXgIDFPENSER_E_002_111_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_111_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", new BigDecimal("1234567"));
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_111_2");
	}

	/**
	 * eXgIDFPENSER_E_002_111_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_111_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", new BigDecimal("9.99999"));
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_111_3");
	}

	/**
	 * eXgIDFPENSER_E_002_112_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_112_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", "one");
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_112_1");
	}

	/**
	 * eXgIDFPENSER_E_002_112_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_112_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", "one");
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_112_2");
	}

	/**
	 * eXgIDFPENSER_E_002_112_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_112_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", "one");
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_112_3");
	}

	/**
	 * eXgIDFPENSER_E_002_113_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_113_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", true);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_113_1");
	}

	/**
	 * eXgIDFPENSER_E_002_113_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_113_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", true);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_113_2");
	}

	/**
	 * eXgIDFPENSER_E_002_113_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_113_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", true);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_113_3");
	}

	/**
	 * eXgIDFPENSER_E_002_114 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_114() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", "9.90");

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_115_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_115_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 9);

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_115_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_115_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1234567l);

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_115_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_115_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 9.99999d);

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_116 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_116() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", false);

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_117 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_117() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", "false");
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_117");
	}

	/**
	 * eXgIDFPENSER_E_002_118_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_118_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_118_1");
	}

	/**
	 * eXgIDFPENSER_E_002_118_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_118_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1234567l);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_118_2");
	}

	/**
	 * eXgIDFPENSER_E_002_118_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_118_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 0.1234567d);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_118_3");
	}

	/**
	 * eXgIDFPENSER_E_002_119 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_119() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", new BigDecimal("9.90"));
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_119");
	}

	/**
	 * eXgIDFPENSER_E_002_120_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_120_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 123l);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_120_1");
	}

	/**
	 * eXgIDFPENSER_E_002_120_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_120_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 1234567d);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_120_2");
	}

	/**
	 * eXgIDFPENSER_E_002_120_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_120_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 12345);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_120_3");
	}

	/**
	 * eXgIDFPENSER_E_002_120_4 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_120_4() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 123l);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_120_4");
	}

	/**
	 * eXgIDFPENSER_E_002_120_5 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_120_5() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 123456);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_120_5");
	}

	/**
	 * eXgIDFPENSER_E_002_120_6 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_120_6() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 123456789d);
		PDSResponse res = this.execute2(this.getName().substring(4), varMap);
		assertResult(res, "false_e_120_6");
	}

	/**
	 * eXgIDFPENSER_E_002_121 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_121() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var2", 9.99999f);

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_122
	 */
	@Test
	public void testPENSER_E_002_122() throws Exception {

		// øÝè
		List<String> parameter1 = new ArrayList<String>();
		parameter1.add("PENSER_E_002_122");
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		try {
			// ----------------------<<Mock>>-------------------------------//
			// Virtual Mock ObjectpAÔplðÝè·éB
			super.replaceProp(super.getName().substring(4));

			// CjV[hðÀs·éB
			PDSEngine.getInstance();

			// øÚæ¾
			PDSResponse response = PDSServiceAPI.getConditionItems(parameter1);

			PDSServiceAPI.getAttrValue(response);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		} catch (PEXUnExpectedStateException e) {
			fail();
		} catch (NullPointerException e) {
			fail();
		}
	}

	/**
	 * eXgIDFPENSER_E_002_123_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_123_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "123");
		varMap.put("var2", "123");
		varMap.put("var3", "");
		assertResult(this.execute2(this.getName().substring(4), varMap),
				"true_e_123_1");
	}

	/**
	 * eXgIDFPENSER_E_002_123_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_123_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "123");
		varMap.put("var2", "123");
		varMap.put("var3", "");
		assertResult(this.execute2(this.getName().substring(4), varMap),
				"false_e_123_2");
	}

	/**
	 * eXgIDFPENSER_E_002_123_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_123_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "123");
		varMap.put("var2", "123");
		varMap.put("var3", "124");
		varMap.put("var4", "123");

		assertResult(this.execute2(this.getName().substring(4), varMap),
				"true_e_123_3");
	}

	/**
	 * eXgIDFPENSER_E_002_124_1 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_124_1() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var5", "123");
		varMap.put("var6", "123");
		varMap.put("var7", "123");
		varMap.put("var8", "124");

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_124_2 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_124_2() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "123");
		varMap.put("var3", "123");
		varMap.put("var5", "124");
		varMap.put("var6", "123");

		assertResult(this.execute2(this.getName().substring(4), varMap),
				"true_e_124_2");
	}

	/**
	 * eXgIDFPENSER_E_002_124_3 õL[Ýè¨õÀ{¨øÚlÝè¨ð»èÀ{¨ÊmF
	 */
	@Test
	public void testPENSER_E_002_124_3() throws Exception {

		Map<String, Object> varMap = new HashMap<String, Object>();
		varMap.put("var1", "123");
		varMap.put("var2", "125");
		varMap.put("var5", "124");
		varMap.put("var6", "123");

		try {
			this.execute2(this.getName().substring(4), varMap);
			fail();
		} catch (PEXConditionNotMatchedException e) {
			fail();
		} catch (PEXInvalidKeyException e) {
			fail();
		} catch (PEXUnExpectedStateException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}

	/**
	 * eXgIDFPENSER_E_002_125 øÚ}bvÌlðÏX
	 */
	@Test
	public void testPENSER_E_002_125() throws Exception {

		// ----------------------<<üÍlÝè>>-------------------------------//
		// øÝè
		List<String> parameter1 = new ArrayList<String>();

		parameter1.add(getName().substring(4)); // C³|Cg
		parameter1.add("key1");
		parameter1.add("key2");
		parameter1.add("attrname1");
		parameter1.add("001");

		// ----------------------<<Mock>>-------------------------------//
		// Virtual Mock ObjectpAÔplðÝè·éB
		super.replaceProp(getName().substring(4));

		// ----------------------<<ÎÛ@\À{>>-------------------------------//
		// CjV[hðÀs·éB
		PDSEngine.getInstance();

		// øÚæ¾
		PDSResponse res = PDSServiceAPI.getConditionItems(parameter1);

		Map<String, ConditionItemInfo> conditionItemInfoMap = res
				.getConditionItemInfoMap();

		try {
			conditionItemInfoMap.put("test", null);
			fail();
		} catch (UnsupportedOperationException e) {
			// ÊmF
			assertTrue(true);
			log.info(e);
		}
	}
}
