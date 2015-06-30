package jp.iwin.pds.xml2db.common.util;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * ���b�Z�[�W���[�e�B���e�B�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�V�X�e���ɂė��p���郁�b�Z�[�W���O���v���p�e�B�t�@�C������擾���郆�[�e�B���e�B�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1802 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date:: 2010-12-17 17:50:#$
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yj $
 */
public class PUTMessageUtil {
	/**
	 * ���O�o��
	 */
	private static final Log logger = LogFactory.getLog(PUTMessageUtil.class);
	/**
	 * �f�t�H���g���b�Z�[�W�t�@�C�����B
	 */
	public static final String MESSAGE_FILE = "pdsmessages.properties";
	/**
	 * ���b�Z�[�W�̃L�[�ƒl��ێ�����I�u�W�F�N�g�B
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
				.getResourceAsStream(MESSAGE_FILE);

		Properties p = new Properties();
//		Map<String, String> localProps = new HashMap<String, String>();

		try {
			p.load(is);
		} catch (Exception e) {
			logger.error("���b�Z�[�W�ݒ�t�@�C���擾���G���[���������܂����BException:" + e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				logger.error("���b�Z�[�W�ݒ�t�@�C���N���[�Y���G���[���������܂����BException:" + e);
			}
		}

		return p;
	}

	/**
	 * �L�[�̃��b�Z�[�W�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�w�肳�ꂽ�L�[�̃��b�Z�[�W���擾���A���̌��ʂ�Ԃ��B
	 * </DL>
	 * @param key ���b�Z�[�W�̃L�[
	 * @return �w�肳�ꂽ�L�[�̃��b�Z�[�W�̒l
	 */
	public static String getMessage(String key) {
		if (key == null) {
			return key;
		}
		return props.getProperty(key);
	}

	/**
	 * ���b�Z�[�W�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�w�肳�ꂽ�L�[�̃��b�Z�[�W���擾����B
	 *   <DD>���b�Z�[�W��������Ȃ������ꍇ�ɂ́A�w�肳�ꂽ�f�t�H���g���Ԃ����
	 * </DL>
	 * @param key ���b�Z�[�W�̃L�[
	 * @param defaultValue ���b�Z�[�W�̃f�t�H���g�l
	 * @return �w�肳�ꂽ�L�[�̃��b�Z�[�W�̒l
	 */
	public static String getMessage(String key, String defaultValue) {
		if (key == null) {
			return key;
		}
		String result = props.getProperty(key);
		if (result == null) {
			return defaultValue;
		}
		return result;
	}

	/**
	 * ���b�Z�[�W�擾�i�u�������Ή��j�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�w�肳�ꂽ�L�[�̃��b�Z�[�W�Ɋ܂܂�Ă���{0}�E�E�E{n}���w�肵���u�������Ɋ����ă��b�Z�[�W���`������B
	 *   <DD>�����_���܂ސ����A���t���Ή�
	 * </DL>
	 * @param key ���b�Z�[�W�̃L�[
	 * @param arguments	�u�������̔z��
	 * @return �w�肳�ꂽ�L�[�̃��b�Z�[�W�̒l
	 */
	public static String getMessage(String key, Object[] arguments) {
		if (key == null) {
			return key;
		}
		String pattern = props.getProperty(key);
		if (pattern == null) {
			return pattern;
		}

		return MessageFormat.format(pattern, arguments);
	}
}
