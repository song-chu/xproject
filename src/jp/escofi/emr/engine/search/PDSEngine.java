package jp.escofi.emr.engine.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.MessageType;
import jp.escofi.emr.engine.common.constant.Status;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.condition.Rule;
import jp.escofi.emr.engine.condition.RuleInstance;
import jp.escofi.emr.engine.loader.InitialLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/**
 * ��̓G���W���N���X�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>
 *    <UL>
 *     <LI>�I�������������ꂽ�f�[�^���f����ێ����A���������������s���G���W���{�̃N���X�B
 *     <LI>PDS�I�u�W�F�N�g��PDS�I�u�W�F�N�g�L�[���ڂ͑��N���X����̃A�N�Z�X�𐧌����邽�߁A��̓G���W���̃����o�[�ϐ��Ƃ��ĕێ�����B
 *     <LI>�P�񃍁[�h�����Ǝg���܂킹�邱�Ƃ⃊�\�[�X�̐ߖ���l�����A
 *         ��̓G���W���̃C���X�^���X�́A�V�X�e����P�̂݁A�C�j�V�������[�h�̍ۂɐ�������B�iSingleton�j
 *    </UL>
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
public class PDSEngine {

	/**
	 * ���O�o��
	 */
	private static final Log LOGGER = LogFactory.getLog(PDSEngine.class);
	/**
	 * PDS�I�u�W�F�N�g
	 */
	private static HashMap<String, Object> pdsObjects;
	/**
	 * PDS�I�u�W�F�N�g�L�[����
	 */
	private static HashMap<String, List<String>> pdsItemKeys;
	/**
	 * �N���X�����[�h�����ہA1�̃C���X�^���X�����������B
	 */
	private static PDSEngine instance;

	/**
	 * �C�j�V�������[�h�ς݃t���O�Ftrue�i���[�h�ς݁j�Afalse�i�����[�h�j<br>
	 * <DL>
	 * <DT style='color: red'>���ӎ����F
	 * <DD style='color: red; font-weight: bold'>
	 * true�i���[�h�ς݁j��ݒ肷��͉̂�̓G���W���݂̂ł���B
	 * </DL>
	 *
	 */
	private static boolean isLoaded = false;

	/**
	 * �C���X�^���X�擾�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�N���X���[�h���A�������ꂽ�L��̃C���X�^���X��Ԃ��B
	 * </DL>
	 *
	 * @return �{�N���X�̃C���X�^���X
	 * @throws InitializeException
	 *             �C�j�V�������[�h��O
	 */
	public static PDSEngine getInstance() throws InitializeException {
		if (instance == null) {
			instance = new PDSEngine();
		}
		return instance;
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>���N���X����̃R���X�g���N�^�̐�����h�����߁A�f�t�H���g�R���X�g���N�^��private�ɂ���B
	 * </DL>
	 *
	 * @throws InitializeException
	 *             �C�j�V�������[�h��O
	 */
	private PDSEngine() throws InitializeException {
		init();
	}

	/**
	 * ���������B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>�C�j�V�������[�h���s���APDS�I�u�W�F�N�g�APDS�I�u�W�F�N�g�L�[���ڂɂ��̌��ʂ�ݒ肷��B
	 * <LI>�R���X�g���N�^����ďo�����B
	 * </UL>
	 * <DT style='color: red'>���ӎ����F
	 * <DD style='color: red; font-weight: bold'>
	 * �C�j�V�������[�h��A�C�j�V�������[�h�ς݃t���O��true�ɐݒ肷��B
	 * </DL>
	 *
	 * @throws InitializeException
	 *             �C�j�V�������[�h��O�B<br>
	 *             ��O�������ɂ̓A���[�g�ʒm���s���B�V�X�e���Ƃ��ĉ񕜕s�\�ȗ�O�ł��邽�߁ARuntimeException�Ƃ��č쐬����B
	 */
	private void init() throws InitializeException {

		try {
			PropertyConfigurator.configure(PropertyUtil
					.getProperty("log4j.filepath"));

			LOGGER.info(MessageUtil.getMessage(MessageCode.EMR_A_P012I
					.toString()));

			InitialLoader loader = new InitialLoader();
			pdsObjects = loader.getPdsObject();
			pdsItemKeys = loader.getPdsItemKeys();
			isLoaded = true;

			LOGGER.info(MessageUtil.getMessage(MessageCode.EMR_A_P013I
					.toString()));

		} catch (EMRException e) {
			if (e.getCause() == null) {
				// ������O�̃g���[�X�����o��
				throw new InitializeException(MessageCode.EMR_A_P009E, e);
			} else {
				// ������O�̃g���[�X���͏o�͍ς݂Ȃ̂ŁA�G���[���b�Z�[�W�̂�
				throw new InitializeException(MessageCode.EMR_A_P009E);
			}
		} catch (Exception e) {
			// ������O�̃g���[�X�����o��
			throw new InitializeException(MessageCode.EMR_A_P009E, e);
		}
	}

	/**
	 * �������ڎ擾�����B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>�n���ꂽ�����L�[�Ɋ�Â��A�f�[�^���f�����������A��������ɕK�v�ȍ��ڂ��擾���A�ԋp����B
	 * <LI>�d��������������邽�߁A�������ڎ擾�̍ۂ̂�PDS�I�u�W�F�N�g�iMap�j�������s���B
	 * </UL>
	 * <DT>�g�p���@�F
	 * <DD>��̓G���W��API�N���X�̈������ڎ擾���\�b�h���Q�ƁB
	 * </DL>
	 *
	 * @param keys
	 *            �����L�[
	 * @return �����l�I�u�W�F�N�g
	 * @throws UnExpectedStateException
	 *             �\���s�\��ԗ�O
	 * @throws InvalidKeyException
	 *             �L�[�s����O
	 */
	protected PDSResponse getConditionItems(List<String> keys)
			throws UnExpectedStateException, InvalidKeyException {

		if (pdsObjects == null || pdsObjects.isEmpty() || pdsItemKeys == null
				|| pdsItemKeys.isEmpty()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P006E);
		}

		// �p�����[�^��null�A�����͒l�����݂��Ȃ��ꍇ
		if (keys == null || keys.isEmpty()) {
			throw new InvalidKeyException(MessageCode.EMR_A_P011E,
					new Object[] { MessageType.KEY_LIST });
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("keys=" + keys);
		}

		PDSResponse conditionItems = new PDSResponse();

		// �����L�[���Ƀf�[�^���f�����瑮���l�擾����B
		search(keys, conditionItems);
		return conditionItems;
	}

	/**
	 * �����l�I�u�W�F�N�g�擾�����B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>PDS�I�u�W�F�N�g���瑮���l�I�u�W�F�N�g�𒊏o����܂Ń��[�v�������s���B
	 * </DL>
	 *
	 * @param keys
	 *            �����L�[���X�g
	 * @param conditionItems
	 *            PDS�����N���X
	 * @throws UnExpectedStateException
	 *             �\���s�\��ԗ�O
	 * @throws InvalidKeyException
	 *             �L�[�s����O
	 */
	@SuppressWarnings("unchecked")
	private void search(List<String> keys, PDSResponse conditionItems)
			throws InvalidKeyException, UnExpectedStateException {
		// �w�肵���C���f�b�N�X�ɊY������L�[���擾����B
		String key = null;
		String dataModelName = null;
		Object obj = null;
		Map<String, Object> map = null;
		int attributeKeyIndex = 0;

		for (int i = 0; i < keys.size(); i++) {
			key = keys.get(i);

			if (i == 0) {
				// �ŏ��̃L�[�̓f�[�^���f����
				dataModelName = key;

				// �P�D�����ɂ��ă`�F�b�N���s���B
				// �f�[�^���f�����`�F�b�N
				checkDataModelName(dataModelName);

				// �L�[���`�F�b�N
				checkKeyCount(dataModelName, keys);

				// �������L�[�̃C���f�b�N�X�擾
				attributeKeyIndex = getAttributeKeyIndex(dataModelName);

				map = (Map<String, Object>) pdsObjects.get(dataModelName);
				continue;
			}

			// �������܂ł�HashMap
			if (i <= attributeKeyIndex) {
				obj = map.get(key);
			} else {
				// �������ȍ~��TreeMap
				// �u�w�肵���l�ȉ��ōő�̂��́v�����o���B
				SortedMap<String, Object> headMap = ((TreeMap<String, Object>) map)
						.headMap(key + "\0");

				if (headMap.isEmpty()) {
					// �X�e�[�^�X�R�iTreeMap�L�[�Y���Ȃ��j��ԋp����B
					conditionItems.setStatus(Status.TREEMAP_KEY_NOT_FOUND);
					break;
				} else {
					obj = map.get(headMap.lastKey());
				}
			}

			// Map����Ȃɂ��擾�ł��Ȃ������ꍇ
			if (obj == null) {
				// �L�[���������ł���ꍇ
				if (i == attributeKeyIndex) {
					// �X�e�[�^�X�Q�i�Y�������Ȃ��j��ԋp����B
					conditionItems.setStatus(Status.ATTR_NOT_FOUND);
					break;
				} else {
					// �L�[���������ȑO�ł���ꍇ�A��O���X���[����B
					throw new InvalidKeyException(MessageCode.EMR_A_P003E,
							new Object[] { keys });
				}
			} else {
				// Map�̏ꍇ
				if (obj instanceof Map) {
					// �擾�����}�b�v����̏ꍇ
					Map<String, Object> tempMap = (Map<String, Object>) obj;
					if (tempMap.isEmpty()) {
						// �X�e�[�^�X�Q�i�Y�������Ȃ��j��ԋp����B
						conditionItems.setStatus(Status.ATTR_NOT_FOUND);
						break;
					}
					// ���̊K�w�Ɍ�����������B
					map = (Map<String, Object>) obj;
					continue;
				} else if (obj instanceof ResultObject) {
					// �����l�I�u�W�F�N�g�̏ꍇ
					setConditionItems((ResultObject) obj, conditionItems);
					break;
				} else {
					// Map�ł������l�I�u�W�F�N�g�ł��Ȃ��ꍇ�A�z��O��O���X���[����B
					throw new UnExpectedStateException(MessageCode.EMR_A_P010E);
				}
			}
		}

		// ���ʃI�u�W�F�N�g���擾�ł����A�X�e�[�^�X���ݒ肳��ĂȂ��ꍇ
		if ((conditionItems.getResultObject() == null)
				&& (conditionItems.getStatus() == null)) {
			conditionItems.setStatus(Status.ATTR_NOT_FOUND);
		}
	}

	/**
	 * �������L�[�̃C���f�b�N�X�擾�����B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>TreeMap�͑������L�[�ȍ~�ɓo�ꂷ�邽�߁ATreeMap����l���擾����ۂɂ͑������L�[�̃C���f�b�N�X���K�v�ɂȂ�B
	 * </UL>
	 * <DT style='color: red'>���ӎ����F
	 * <DD style='color: red; font-weight: bold'>
	 * �f�[�^���f�����`�F�b�N���������{������A�Ăяo�����ƁB
	 * </DL>
	 *
	 * @param dataModelName
	 *            �f�[�^���f����
	 * @return �������L�[�̃C���f�b�N�X
	 * @throws UnExpectedStateException
	 *             �\�����ʃG���[
	 */
	private int getAttributeKeyIndex(String dataModelName)
			throws UnExpectedStateException {

		List<String> itemKeys = pdsItemKeys.get(dataModelName);

		String keyName;
		int attributeKeyIndex = -1;

		for (int i = 0; i < itemKeys.size(); i++) {
			keyName = itemKeys.get(i);
			if (AttributeType.ATTR_NAME.isEquals(keyName)) {
				// �C���f�b�N�X�Ɂ{�P����B0�̓f�[�^���f�����Ŏg�p�ς݁B
				attributeKeyIndex = i + 1;
				break;
			}
		}

		if (attributeKeyIndex == -1) {
			// �L�[���ڂɑ����������݂��Ȃ��ꍇ�A�z��O��O���X���[����B
			throw new UnExpectedStateException(MessageCode.EMR_A_P014E,
					new Object[] { itemKeys });
		}

		return attributeKeyIndex;
	}

	/**
	 * �����l�擾�����B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�������ڂɊ�A����������s���A���̌��ʂ�ԋp����
	 * </DL>
	 * <DT>�g�p���@�F
	 * <DD>��̓G���W��API�N���X�̑����l�擾���\�b�h���Q�Ƃ���
	 *
	 * @param res
	 *            PDS�����N���X
	 * @return �������茋��
	 * @throws ConditionNotMatchedException
	 *             �����s������O
	 * @throws InvalidKeyException
	 *             �L�[�s����O
	 * @throws UnExpectedStateException
	 *             �\���s�\��ԗ�O
	 */
	protected PDSResponse getAttrValue(PDSResponse res)
			throws ConditionNotMatchedException, InvalidKeyException,
			UnExpectedStateException {

		// �p�����[�^��null�`�F�b�N
		if (res == null) {
			throw new InvalidKeyException(MessageCode.EMR_A_P011E,
					new Object[] { MessageType.RESPONSE });
		}

		// �����l�I�u�W�F�N�g���擾
		ResultObject attrValue = res.getResultObject();

		if (attrValue == null) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P010E);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("ResultObject=" + attrValue.toString());
		}

		// �����l�I�u�W�F�N�g���猋�ʒl�I�u�W�F�N�g���擾
		Object obj = attrValue.getValue();

		// �����l�I�u�W�F�N�g���������̏ꍇ
		if (obj instanceof Rule) {
			// ����������s���B
			try {
				attrValue = ((Rule) obj).apply(res
						.getConditionItemValueMap());
			} catch (RuntimeException e) {
				// �������菈�����A�\�����ʎ��s����O�iRuntimeException�j�����������ꍇ
				throw new UnExpectedStateException(MessageCode.EMR_A_P010E, e);
			}
			res.setResultObject(attrValue);
		}

		return res;
	}

	/**
	 * ���ʒl�ݒ菈���B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>���ʒl��PDS�����N���X�Ɋi�[����
	 * </DL>
	 *
	 * @param resultObject
	 *            �����l�I�u�W�F�N�g
	 * @param conditionItems
	 *            PDS�����N���X
	 */
	private void setConditionItems(ResultObject resultObject,
			PDSResponse conditionItems) {

		// �����l���폜����Ă���ꍇ
		if (resultObject.isDeleted()) {
			// �X�e�[�^�X�F�폜�ς�ݒ�
			conditionItems.setStatus(Status.DELETED);
		} else {
			// �X�e�[�^�X�F�����ݒ�
			conditionItems.setStatus(Status.NORMAL);
		}

		conditionItems.setResultObject(resultObject);

		Object obj = resultObject.getValue();

		if (obj instanceof Rule) {
			conditionItems.setConditionItemInfoMap(((RuleInstance) obj)
					.getConditionItemMap());
			conditionItems.setConditionFlag(true);
		}

		conditionItems.setMetaInfo(resultObject.getMetaInfo());
	}

	/**
	 * �f�[�^���f�����`�F�b�N�����B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>�����̃f�[�^���f������PDS�I�u�W�F�N�g�iMap�j��PDS�I�u�W�F�N�g�L�[���ځiMap�j��
	 * ���v�f�̃L�[���������A��v����L�[�����邩���m�F����B
	 * <LI>���݂��Ȃ��ꍇ�͌㑱���������{�����A�Ɩ���O���X���[����
	 * </UL>
	 * </DL>
	 *
	 * @param dataModelName
	 *            �f�[�^���f����
	 * @throws InvalidKeyException
	 *             �L�[�s����O
	 */
	private void checkDataModelName(final String dataModelName)
			throws InvalidKeyException {

		boolean rtn = (pdsObjects.containsKey(dataModelName) && pdsItemKeys
				.containsKey(dataModelName));

		if (!rtn) {
			throw new InvalidKeyException(MessageCode.EMR_A_P001E,
					new String[] { dataModelName });
		}
	}

	/**
	 * �L�[���ڐ��`�F�b�N�����B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>PDS�I�u�W�F�N�g�L�[���ځiMAP�j��������̃f�[�^���f�����ɊY������L�[���ځiLIST�j�𒊏o���A<BR>
	 * �����̃L�[���ƃL�[���ڐ�����v���邱�Ƃ��m�F����B
	 * <LI>��v���Ȃ��ꍇ�͌㑱���������{�����A�Ɩ���O���X���[����B
	 * </UL>
	 * </DL>
	 *
	 * @param dataModelName
	 *            �f�[�^���f����
	 * @param keys
	 *            �L�[���
	 * @throws InvalidKeyException
	 *             �L�[�s����O
	 */
	private void checkKeyCount(final String dataModelName,
			final List<String> keys) throws InvalidKeyException {

		List<String> keyList = pdsItemKeys.get(dataModelName);
		boolean rtn = (keyList.size() == (keys.size() - 1));

		if (!rtn) {
			throw new InvalidKeyException(MessageCode.EMR_A_P002E,
					new Object[] { keys, keyList });
		}
	}

	/**
	 * �C�j�V�������[�h�ς݃t���O�̎擾����
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>�C�j�V�������[�h�ς݃t���O��ԋp����B
	 * </UL>
	 * </DL>
	 *
	 * @return true �C�j�V�������[�h�ς݁Afalse �C�j�V�������[�h�����{
	 */
	protected static boolean isLoaded() {
		return isLoaded;
	}

	/**
	 * �_���v���s�B
	 *<DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>
	 * <UL>
	 * <LI>�����̃f�[�^���f������PDS�I�u�W�F�N�g�iMap�j�̑��v�f�̃L�[���������A��v����L�[�����邩���m�F����B
	 * <LI>���݂��Ȃ��ꍇ�͌㑱���������{�����A�Ɩ���O���X���[����
	 * </UL>
	 * </DL>
	 *
	 * @param filePath
	 *            �t�@�C���p�X
	 * @param dataModelName
	 *            �f�[�^���f����
	 * @throws InvalidKeyException
	 *             �L�[�s����O
	 * @throws DumpException
	 *             �_���v��O
	 */
	protected void excuteDump(String filePath, String dataModelName)
			throws InvalidKeyException, DumpException {
		if (!dataModelName.equals(Constants.DATA_MODEL_ALL)
				&& pdsObjects.get(dataModelName) == null) {
			throw new InvalidKeyException(MessageCode.EMR_A_P015E,
					new Object[] { dataModelName });
		}
		try {
			ObjectWriter.excuteDump(filePath, dataModelName, pdsObjects,
					pdsItemKeys);
		} catch (Exception e) {
			throw new DumpException(MessageCode.EMR_A_P016E, e);
		}
	}
}
