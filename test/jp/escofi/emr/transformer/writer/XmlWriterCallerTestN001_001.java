package jp.escofi.emr.transformer.writer;

import java.util.Properties;

import org.junit.Test;


/**
 * �^�p�c�[���e�X�g�N���X�iN001�n�j
 * <P>
 * �^�p�c�[������n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author$
 */
public final class XmlWriterCallerTestN001_001 extends XmlWriterCallerTest {

	private Properties setProperty(String testCaseName,String productID){
		Properties prop = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_N001";
		prop.setProperty("xml.meta.filepath", base +"/PENSER_"+testCaseName+"_Meta.xml");
		prop.setProperty("xml.datamodel.base",base);
		prop.setProperty("DBDeleteFlg", Boolean.toString(true));
		prop.setProperty("productID", productID);

		return prop;

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_1 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_1() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		p.setProperty("DBDeleteFlg", Boolean.toString(true));

		execTest(p,"AAA_001");
	}
	/**
	 * �e�X�gID�FPXWXML_N_001_2 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_2() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"BBB_001");
	}
	/**
	 * �e�X�gID�FPXWXML_N_001_3 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_3() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"BBB_002");
	}
	/**
	 * �e�X�gID�FPXWXML_N_001_3 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_4() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"CCC_001");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_5 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_5() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"CCC_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_6 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_6() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"CCC_003");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_7 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_7() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"DDD_001");
	}
	/**
	 * �e�X�gID�FPXWXML_N_001_8 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_8() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"DDD_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_9 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_9() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"DDD_003");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_10 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_10() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"DDD_004");
	}
	/**
	 * �e�X�gID�FPXWXML_N_001_11 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_11() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"EEE_001");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_12 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_12() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"EEE_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_13 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_13() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"EEE_003");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_14 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_14() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"EEE_004");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_15 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_15() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"EEE_005");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_16 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_16() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"FFF_001");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_17 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_17() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"FFF_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_18 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_18() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"FFF_003");


	}
	/**
	 * �e�X�gID�FPXWXML_N_001_19 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_19() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"FFF_004");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_20 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_20() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"FFF_005");


	}
	/**
	 * �e�X�gID�FPXWXML_N_001_21 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_21() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"FFF_006");
	}
	/**
	 * �e�X�gID�FPXWXML_N_001_22 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_22() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_001");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_23 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_23() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_24 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_24() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_003");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_25 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_25() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_004");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_26 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_26() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_005");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_27 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_27() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_006");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_28 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_28() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"GGG_007");


	}
//	/**
//	 * �e�X�gID�FPXWXML_N_001_29 �^�p�c�[������n
//	 */
//	@Test
//	public void testPXWXML_N_001_29() throws Exception {
//
//		// property�ݒ�
//		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
//		// �e�X�g���s
//		execTest(p,"HHH_001");
//
//	}
	/**
	 * �e�X�gID�FPXWXML_N_001_30 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_30() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"HHH_002");

	}
//	/**
//	 * �e�X�gID�FPXWXML_N_001_31 �^�p�c�[������n
//	 */
//	@Test
//	public void testPXWXML_N_001_31() throws Exception {
//
//		// property�ݒ�
//		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
//		// �e�X�g���s
//		execTest(p,"HHH_003");
//
//	}
	/**
	 * �e�X�gID�FPXWXML_N_001_32�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_32() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"HHH_004");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_33�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_33() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"HHH_005");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_34 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_34() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"HHH_006");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_35 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_35() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"HHH_007");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_36 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_36() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"HHH_008");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_37 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_37() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_001");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_38 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_38() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_39 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_39() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_003");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_40 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_40() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_004");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_41�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_41() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_005");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_42�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_42() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_006");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_43�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_43() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_007");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_44�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_44() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_008");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_45�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_45() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"III_009");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_46�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_46() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"JJJ_001");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_47�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_47() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"JJJ_002");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_48�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_48() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"JJJ_003");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_49�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_49() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"JJJ_004");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_50�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_50() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"JJJ_005");

	}
	/**
	 * �e�X�gID�FPXWXML_N_001_51�^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_51() throws Exception {

		// property�ݒ�
		Properties p = setProperty(this.getName().substring(11),this.getName().substring(17));
		// �e�X�g���s
		execTest(p,"JJJ_006");

	}

}
