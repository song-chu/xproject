package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

import org.xml.sax.Attributes;

/**
 * �p����L�[���ڃn���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�i{@code <value>}�j�v�f�������܂ŁA����key�����v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B<BR>
 *       �f�[�^���f���̃C���X�^���X�𐶐�����ۂɁA�p�����f�[�^���f�����L��ꍇ�́A���̃N���X���g�p����B
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
public final class KeyItemHandlerExt extends KeyItemHandler {

	/**
	 * version/pattern/date�̏����l
	 */
	private String pdsObject;
	/**
	 * attrname�^�O�̐e�^�O��
	 */
	private String attrNameParent;
	/**
	 * attrname�^�O�̎q�^�O��
	 */
	private String attrNameChild;
	/**
	 * �p�����̃f�[�^���f���}�b�v
	 */
	private Map<String, Object> orgDM;
	/**
	 * �p�����L�[���ڃ��X�g
	 */
	private List<String> extendsKeys = new ArrayList<String>();

	/**
	 * �R���X�g���N�^�B
	 *
	 * @param dataModelHandler
	 *            �ďo�����n���h���[
	 * @param orgDM
	 *            �p�����̃f�[�^���f���}�b�v
	 * @param extendsInfo
	 *            �p�����
	 */
	public KeyItemHandlerExt(DataModelHandler dataModelHandler,
			Map<String, Object> orgDM, Map<AttributeType, String> extendsInfo) {

		super(dataModelHandler);

		this.orgDM = orgDM;
		attrNameParent = extendsInfo.get(AttributeType.ATTR_NAME_PARENT);
		attrNameChild = extendsInfo.get(AttributeType.ATTR_NAME_CHILD);
		pdsObject = extendsInfo.get(AttributeType.INIT_VALUE);
	}

	/**
	 * �^�O�J�n�����B
	 * <OL>
	 * <LI>�A�g���r���[�g���Ɍp������񂪂���ꍇ�A�p���������p�����L�[���ڃ��X�g�ɒǉ�����B</LI>
	 * <LI>�p�����N���X�̃^�O�J�n�������ďo���B</LI>
	 * </OL>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ���[�J����
	 * @param qName
	 *            �Q�ƒ��̃^�O��
	 * @param atts
	 *            �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		String org = atts.getValue(AttributeType.ORG.toString());

		if (org != null) {
			extendsKeys.add(org);
		}
		super.startElement(uri, localName, qName, atts);
	}

	/**
	 * �p���֌W�����B
	 * <P>
	 * �p�����N���X�ϐ��F�L�[���ږ����X�g�̍Ō�̍��ڂ��A �N���X�ϐ��FattrName�^�O�̐e�^�O���ƈ�v����ꍇ�́A�p���֌W�������������s����B
	 * </P>
	 *
	 * @param keyName
	 *            �Q�ƒ��̃L�[���ږ�
	 * @throw IllegalArgumentException �����s����O
	 *        <UL>
	 *        <LI>�p�����}�b�v���擾�ł��Ȃ������ꍇ
	 *        </UL>
	 */
	@Override
	protected void initDataModelMap(String keyName) {

		// �p�����N���X�łȂ��ꍇ�͏����𔲂���B
		if (!attrNameParent.equals(keyName)) {
			return;
		}
		// �p������MAP�擾
		Map<String, Object> orgAttrMap = getDataModelMap(orgDM, extendsKeys);
		if (orgAttrMap == null) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P020E.toString(), new Object[] { keys,
							extendsKeys }));
		}
		Map<String, Object> map = getDataModelMap(dataModelMap, keys);

		for (Entry<String, Object> entry : orgAttrMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			// �p�����attr�G�������g�̎q�G�������g��MAP�擾
			Object attrNameChildMap = map.get(key);

			// �p����Ɍp�����̒l���ݒ肳��ĂȂ��ꍇ�Akey�����l�ƌp�����̒l��ݒ�
			if (attrNameChildMap == null) {

				// attr�G�������g�̎q�G�������g�L�����`�F�b�N
				if (attrNameChild == null) {
					// �p������key�AValue��Put
					map.put(key, value);
				} else {
					// �q�G�������g�̋�MAP�擾�iattname�ȉ��ɒǉ�����̂ŏ��TreeMap�j
					Map<String, Object> extendsMap = new TreeMap<String, Object>();

					// key�����l�ƌp������Value��Put
					extendsMap.put(pdsObject, value);
					// �p�����Map��Put
					map.put(key, extendsMap);
				}
			} else if (attrNameChild != null
					&& attrNameChildMap instanceof Map<?, ?>) {
				// attr�G�������g�̎q�G�������g�L���A�q�G�������g�̌^��Map
				@SuppressWarnings( { "unchecked" })
				Map<String, Object> childMap = (Map<String, Object>) attrNameChildMap;

				// �p����Ɍp�����̒l���ݒ肳��Ă���ꍇ
				// �q�G�������g��MAP��key�����l���ݒ肳��ĂȂ��ꍇ
				// �q�G�������g��MAP��key�����l�ƌp�����̒l��ݒ�
				if (childMap.get(pdsObject) == null) {
					childMap.put(pdsObject, value);
					// �p�����Map��Put
					map.put(key, childMap);
				}
			}
		}
		objValue = map;

		if (!extendsKeys.isEmpty()) {
			extendsKeys.remove(extendsKeys.size() - 1);
		}
	}
}
