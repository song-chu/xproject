package jp.escofi.emr.transformer.writer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.XmlWriterCaller;

import org.junit.Test;

/**
 * �^�p�c�[���e�X�g�N���X�iE002�n�j
 * <P>
 * �^�p�c�[���ُ�(�N���p�����[�^�`�F�b�N)�n�̃e�X�g���\�b�h��`�N���X�B
 * </P>
 * @author $Author: devuser05 $
 */
public class XmlWriterCallerTestE002 extends XmlWriterCallerTest {

	/**
	 * �e�X�gID�FPXWXML_E_002_1 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_1() throws Exception {

		// �ُ�l
		this.driver = null;
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_2 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_2() throws Exception {

		// �ُ�l
		this.driver = "";
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_3 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_3() throws Exception {

		// �ُ�l
		this.url = null;
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_4 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_4() throws Exception {

		// �ُ�l
		this.url = "";
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_5 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_5() throws Exception {

		// �ُ�l
		this.username = null;
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_6 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_6() throws Exception {

		// �ُ�l
		this.username = "";
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_7 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_7() throws Exception {

		// �ُ�l
		this.password = null;
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_8 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_8() throws Exception {

		// �ُ�l
		this.password = "";
		this.checkParameter("�����s���BJDBC�ڑ���񂪎w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_9 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_9() throws Exception {

		// �ُ�l
		this.productCD = null;
		this.checkParameter("�����s���B�Č��R�[�h���w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_10 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_10() throws Exception {

		// �ُ�l
		this.productCD = "";
		this.checkParameter("�����s���B�Č��R�[�h���w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_11 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_11() throws Exception {

		// �ُ�l
		this.xmlbase = null;
		this.checkParameter("�����s���BXML�t�@�C���o�͐悪�w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_12 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_12() throws Exception {

		// �ُ�l
		this.xmlbase = "";
		this.checkParameter("�����s���BXML�t�@�C���o�͐悪�w�肳��Ă��܂���B");
	}

	/**
	 * �e�X�gID�FPXWXML_E_002_13 �^�p�c�[���ُ�n
	 */
	@Test
	public void testPXWXML_E_002_13() throws Exception {

		// �ُ�l
		this.productCD = "ZZZZZ_99999";
		this.checkParameter("�Č�CD�̌������s���ł��B(�Č�CD�F" + this.productCD + ")");
	}


	/**
	 * �`�F�b�N�p�����[�^�e�X�g�p���\�b�h
	 * @param expectedMessage
	 *            ���Ғl���b�Z�[�W
	 *
	 * @throws Exception
	 */
	private void checkParameter(String expectedMessage) throws Exception {
		Method method = XmlWriterCaller.class.getDeclaredMethod(
				"checkParameter", String.class, String.class, String.class,
				String.class, String.class, String.class);

		method.setAccessible(true);

		try {
			method.invoke(null, driver, url, username, password, productCD,
					xmlbase);
			fail();
		} catch (InvocationTargetException ex) {
			Throwable throwable = ex.getTargetException();
			if (throwable instanceof EMRException) {
				assertEquals(expectedMessage, throwable.getMessage());
			}
		}
	}

}
