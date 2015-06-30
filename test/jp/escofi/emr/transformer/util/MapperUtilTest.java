package jp.escofi.emr.transformer.util;

import jp.co.dgic.testing.framework.DJUnitTestCase;
import jp.escofi.emr.engine.common.constant.DataType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MapperUtilTest extends DJUnitTestCase {

	private Log logger = LogFactory.getLog(MapperUtilTest.class);

	/**
	 * �e�X�gID:PUTMap_N_001_1
	 * �ΏہFgetDataTypeByCd(String)�i�����^�C�v�擾�j
	 * ���݂��鑮���^�C�vCD�Ō���
	 */
	@Test
	public void testPUTMap_N_001_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "01";
		logger.info("���͒l�F" + parameter);

		// �e�X�g�Ώۃ��\�b�h���s
		DataType result = MapperUtil.getDataTypeByCd(parameter);

		// ���ʊm�F
		logger.info("���ʒl�F" + result);
		assertEquals(DataType.SINGLE, result);
	}

	/**
	 * �e�X�gID:PUTMap_N_001_2
	 * �ΏہFgetDataTypeByCd(String)�i�����^�C�v�擾�j
	 * ���݂��鑮���^�C�vCD�Ō���
	 */
	@Test
	public void testPUTMap_N_001_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "06";
		logger.info("���͒l�F" + parameter);

		// �e�X�g�Ώۃ��\�b�h���s
		DataType result = MapperUtil.getDataTypeByCd(parameter);

		// ���ʊm�F
		logger.info("���ʒl�F" + result);
		assertEquals(DataType.SET, result);
	}

	/**
	 * �e�X�gID:PUTMap_E_001_1
	 * �ΏہFgetDataTypeByCd(String)�i�����^�C�v�擾�j
	 * ���݂��Ȃ������^�C�vCD�Ō���
	 */
	@Test
	public void testPUTMap_E_001_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "07";
		logger.info("���͒l�F" + parameter);

		try{
			// �e�X�g�Ώۃ��\�b�h���s
			MapperUtil.getDataTypeByCd(parameter);

		} catch(IllegalArgumentException e) {
			// ���ʊm�F
			logger.debug(e.getMessage());
		}
	}

	/**
	 * �e�X�gID:PUTMap_E_001_2
	 * �ΏہFgetDataTypeByCd(String)�i�����^�C�v�擾�j
	 * null�P�[�X
	 */
	@Test
	public void testPUTMap_E_001_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = null;
		logger.info("���͒l�F" + parameter);

		try{
			// �e�X�g�Ώۃ��\�b�h���s
			MapperUtil.getDataTypeByCd(parameter);

		} catch(IllegalArgumentException e) {
			// ���ʊm�F
			logger.debug(e.getMessage());
		}
	}

	/**
	 * �e�X�gID:PUTMap_E_001_3
	 * �ΏہFgetDataTypeByCd(String)�i�����^�C�v�擾�j
	 * �󕶎��P�[�X
	 */
	@Test
	public void testPUTMap_E_001_3() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "";
		logger.info("���͒l�F" + parameter);

		try{
			// �e�X�g�Ώۃ��\�b�h���s
			MapperUtil.getDataTypeByCd(parameter);

		} catch(IllegalArgumentException e) {
			// ���ʊm�F
			logger.debug(e.getMessage());
		}
	}

	/**
	 * �e�X�gID:PUTMap_N_002_1
	 * �ΏہFgetDataTypeNameByCd(String)�i�����^�C�v���擾�j
	 * ���݂��鑮���^�C�vCD�Ō���
	 */
	@Test
	public void testPUTMap_N_002_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "01";
		logger.info("���͒l�F" + parameter);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MapperUtil.getDataTypeNameByCd(parameter);

		// ���ʒl�ݒ�
		String expected = "single";

		// ���ʊm�F
		logger.info("���ʒl�F" + result);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMap_N_002_2
	 * �ΏہFgetDataTypeNameByCd(String)�i�����^�C�v���擾�j
	 * ���݂��鑮���^�C�vCD�Ō���
	 */
	@Test
	public void testPUTMap_N_002_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "06";
		logger.info("���͒l�F" + parameter);

		// �e�X�g�Ώۃ��\�b�h���s
		String result = MapperUtil.getDataTypeNameByCd(parameter);

		// ���ʒl�ݒ�
		String expected = "set";

		// ���ʊm�F
		logger.info("���ʒl�F" + result);
		assertEquals(expected, result);
	}

	/**
	 * �e�X�gID:PUTMap_E_002_1
	 * �ΏہFgetDataTypeNameByCd(String)�i�����^�C�v���擾�j
	 * ���݂��Ȃ������^�C�vCD�Ō���
	 */
	@Test
	public void testPUTMap_E_002_1() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "07";
		logger.info("���͒l�F" + parameter);

		try{
			// �e�X�g�Ώۃ��\�b�h���s
			MapperUtil.getDataTypeNameByCd(parameter);

		} catch(IllegalArgumentException e) {
			// ���ʊm�F
			logger.debug(e.getMessage());
		}
	}

	/**
	 * �e�X�gID:PUTMap_E_002_2
	 * �ΏہFgetDataTypeNameByCd(String)�i�����^�C�v���擾�j
	 * null�P�[�X
	 */
	@Test
	public void testPUTMap_E_002_2() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = null;
		logger.info("���͒l�F" + parameter);

		try{
			// �e�X�g�Ώۃ��\�b�h���s
			MapperUtil.getDataTypeNameByCd(parameter);

		} catch(IllegalArgumentException e) {
			// ���ʊm�F
			logger.debug(e.getMessage());
		}
	}

	/**
	 * �e�X�gID:PUTMap_E_002_3
	 * �ΏہFgetDataTypeNameByCd(String)�i�����^�C�v���擾�j
	 * �󕶎��P�[�X
	 */
	@Test
	public void testPUTMap_E_002_3() throws Exception {

		logger.info("########## " + this.getName() + " �J�n ##########");

		// ���͒l�ݒ�
		String parameter = "";
		logger.info("���͒l�F" + parameter);

		try{
			// �e�X�g�Ώۃ��\�b�h���s
			MapperUtil.getDataTypeNameByCd(parameter);

		} catch(IllegalArgumentException e) {
			// ���ʊm�F
			logger.debug(e.getMessage());
		}
	}
}
