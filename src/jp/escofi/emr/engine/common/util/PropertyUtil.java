package jp.escofi.emr.engine.common.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * �v���p�e�B���[�e�B���e�B�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�V�X�e���ɂė��p����ݒ�����O���v���p�e�B�t�@�C������擾���郆�[�e�B���e�B�N���X�B
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/08/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public class PropertyUtil {
	/**
	 * ���O�o��
	 */
	private static final Log LOGGER = LogFactory.getLog(PropertyUtil.class);
	/**
	 * �f�t�H���g�v���p�e�B�t�@�C�����B
	 */
	private static final String PROPERTY_FILE = "pds.properties";
	/**
	 * �v���p�e�B�̃L�[�ƒl��ێ�����I�u�W�F�N�g�B
	 */
	private static Properties props = load();

	/**
	 * �v���p�e�B���[�h�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�w�肳�ꂽ�v���p�e�B�t�@�C����ǂݍ��ށB
	 * </DL>
	 * @return �v���p�e�B
	 */
	private static Properties load() {

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(PROPERTY_FILE);

		Properties p = new Properties();

		try {
			p.load(is);
		} catch (Exception e) {
			LOGGER.error("�v���p�e�B�t�@�C���擾���G���[���������܂����BException:" + e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				LOGGER.error("�v���p�e�B�t�@�C���N���[�Y�G���[���������܂����BException:" + e);
			}
		}

		return p;
	}

	/**
	 * �v���p�e�B�l�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�w�肳�ꂽ�L�[�̃v���p�e�B���擾���A���̌��ʂ�Ԃ��B
	 * </DL>
	 * @param key �v���p�e�B�̃L�[
	 * @return �w�肳�ꂽ�L�[�̃v���p�e�B�̒l
	 */
	public static String getProperty(String key) {
		if (key == null) {
			return key;
		}
		return props.getProperty(key);
	}

	/**
	 * �v���p�e�B�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�w�肳�ꂽ�L�[�̃v���p�e�B���擾����B
	 *   <DD>�v���p�e�B��������Ȃ������ꍇ�ɂ́A�w�肳�ꂽ�f�t�H���g���Ԃ����B
	 * </DL>
	 * @param key �v���p�e�B�̃L�[
	 * @param defaultValue �v���p�e�B�̃f�t�H���g�l
	 * @return �w�肳�ꂽ�L�[�̃v���p�e�B�̒l
	 */
	public static String getProperty(String key, String defaultValue) {
		if (key == null) {
			return key;
		}
		String result = props.getProperty(key);
		if (result == null) {
			return defaultValue;
		}
		return result;
	}

}
