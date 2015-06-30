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
public final class XmlWriterCallerTestN001_454 extends XmlWriterCallerTest {

	private Properties setProperty(String testCaseName){
		Properties prop = new Properties();
		String base = "Z:/OutputXML/xml/PXWXmlWriter/in/TestData_N006";
		prop.setProperty("xml.meta.filepath", base+'/'+testCaseName+"_Meta.xml");
		prop.setProperty("xml.datamodel.base",base);
		prop.setProperty("DBDeleteFlg", Boolean.toString(true));
		prop.setProperty("productID", "1");


		return prop;

	}

	/**
	 * �e�X�gID�FPXWXML_N_001_454 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_454() throws Exception {
		// property�ݒ�
		Properties p = setProperty(this.getName().substring(4));

		// �e�X�g���s
		execTest(p,"AAA_001");
	}

	/**
	 * �e�X�gID�FPXWXML_N_001_455 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_455() throws Exception {
		// property�ݒ�
		Properties p = setProperty(this.getName().substring(4));

		// �e�X�g���s
		execTest(p,"AAA_001");
	}

	/**
	 * �e�X�gID�FPXWXML_N_001_456 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_456() throws Exception {
		// property�ݒ�
		Properties p = setProperty(this.getName().substring(4));

		// �e�X�g���s
		execTest(p,"AAA_001");
	}

	/**
	 * �e�X�gID�FPXWXML_N_001_457 �^�p�c�[������n
	 */
	@Test
	public void testPXWXML_N_001_457() throws Exception {
		// property�ݒ�
		Properties p = setProperty(this.getName().substring(4));

		// �e�X�g���s
		execTest(p,"AAA_001");
	}

}
