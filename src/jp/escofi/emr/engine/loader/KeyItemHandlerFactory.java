package jp.escofi.emr.engine.loader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

import org.w3c.dom.Element;

/**
 * �L�[���ڃn���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�L�[���ڃn���h���[�S�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
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
final class KeyItemHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private KeyItemHandlerFactory() {
	}

	/**
	 * �L�[���ڃn���h���[���������B
	 *
	 * @param dataModelHandler
	 *            �f�[�^���f���n���h���[
	 * @param dataModel
	 *            �f�[�^���f���̃G�������g���
	 * @param pdsObjectLocal
	 *            ���[�J���ϐ���PDS�I�u�W�F�N�g�i�p�����p�̃e���|����Map�j
	 * @param itemKeys
	 *            �L�[���ږ����X�g
	 * @return �L�[���ڃn���h���[�̐V�K�C���X�^���X
	 */
	@SuppressWarnings("unchecked")
	public static KeyItemHandler createKeyItemHandler(
			DataModelHandler dataModelHandler, Element dataModel,
			Map<String, Object> pdsObjectLocal, List<String> itemKeys) {

		// �p�����̃f�[�^���f��
		String extendsDM = dataModel.getAttribute(
				AttributeType.EXTENDS_DM.toString()).intern();

		// KeyItemHandler�錾
		KeyItemHandler keyItemHandler;

		if (extendsDM.length() <= 0) { // �p�����f�[�^���f���������ꍇ
			keyItemHandler = new KeyItemHandler(dataModelHandler);
		} else {// �p�����f�[�^���f�����L��ꍇ
			// �p�����f�[�^���f����HashMap
			Map<String, Object> orgMap = (Map<String, Object>) pdsObjectLocal
					.get(extendsDM);

			if (orgMap == null) {
				throw new IllegalArgumentException(MessageUtil.getMessage(
						MessageCode.EMRA_A_P021E.toString(), new Object[] {
								dataModel.getAttribute(
										AttributeType.NAME.toString())
										.intern(), extendsDM }));
			}
			// �p�����������邽�߂̏��
			Map<AttributeType, String> extendsInfo = getExtendsInfo(
					dataModel, itemKeys);

			keyItemHandler = new KeyItemHandlerExt(dataModelHandler, orgMap,
					extendsInfo);
		}

		return keyItemHandler;
	}

	/**
	 * �p���֌W���}�b�v�擾�B
	 *
	 * @param dataModel
	 *            �f�[�^���f���̃G�������g���
	 * @param itemKeys
	 *            �L�[���ږ����X�g
	 * @return �p���֌W���}�b�v
	 */
	private static Map<AttributeType, String> getExtendsInfo(
			Element dataModel, List<String> itemKeys) {
		HashMap<AttributeType, String> extendsInfo = new HashMap<AttributeType, String>();

		String attrNameChild = null;
		String attrNameParent = null;
		String initValue = null;

		// initvalue�擾
		initValue = dataModel.getAttribute(AttributeType.INIT_VALUE
				.toString());
		extendsInfo.put(AttributeType.INIT_VALUE, initValue);

		if (itemKeys.size() > 1) {
			int attrNameIdex = itemKeys.indexOf(ElementType.ATTR_NAME
					.toString());
			// attrname���ŏ�ʃG�������g�̏ꍇ�AattrnameChild���̂ݎ擾
			if (attrNameIdex == 0) {
				attrNameChild = itemKeys.get(attrNameIdex + 1);
				// attrname���ŉ��ʃG�������g�̏ꍇ�AattrnameParent���̂ݎ擾
			} else if (attrNameIdex == (itemKeys.size() - 1)) {
				attrNameParent = itemKeys.get(attrNameIdex - 1);
				// attrname���^�񒆃G�������g�̏ꍇ�AattrnameChild�AattrnameParent���擾
			} else {
				attrNameChild = itemKeys.get(attrNameIdex + 1);
				attrNameParent = itemKeys.get(attrNameIdex - 1);
			}
		}

		extendsInfo.put(AttributeType.ATTR_NAME_PARENT, attrNameParent);
		extendsInfo.put(AttributeType.ATTR_NAME_CHILD, attrNameChild);

		return extendsInfo;
	}

}
