package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;

import org.xml.sax.Attributes;


/**
 * �p����L�[���ڃn���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�i{@code <value>}�j�v�f�������܂ŁA����key�����v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B<BR>
 *       �f�[�^���f���̃C���X�^���X�𐶐�����ۂɁA�p�����f�[�^���f�����L��ꍇ�́A���̃N���X���g�p����B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1059 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHKeyItemHandlerExt extends PCHKeyItemHandler {

	/**
	 * version/pattern/date�̏����l
	 */
	private String initValue;
	/**
	 * attrname�^�O�̐e�^�O��
	 */
	private String attrnameParent;
	/**
	 * attrname�^�O�̎q�^�O��
	 */
	private String attrnameChild;
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
	 * @param dataModelHandler �ďo�����n���h���[
	 * @param orgDM �p�����̃f�[�^���f���}�b�v
	 * @param extendsInfo �p�����
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
	 */
	public PCHKeyItemHandlerExt(PCHDataModelHandler dataModelHandler,
			Map<String, Object> orgDM, Map<PCTAttributeType, String> extendsInfo) {

		super(dataModelHandler,extendsInfo,0);

		this.orgDM = orgDM;
		this.attrnameParent = extendsInfo.get(PCTAttributeType.ATTRNAME_PARENT);
		this.attrnameChild = extendsInfo.get(PCTAttributeType.ATTRNAME_CHILD);
		this.initValue = extendsInfo.get(PCTAttributeType.INITVALUE);
	}


	/**
	 * �^�O�J�n�����B
	 * <OL>
	 *  <LI>�A�g���r���[�g���Ɍp������񂪂���ꍇ�A�p���������p�����L�[���ڃ��X�g�ɒǉ�����B</LI>
	 *  <LI>�p�����N���X�̃^�O�J�n�������ďo���B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(
			String uri, String localName, String qName, Attributes atts) {
		String org = atts.getValue(PCTAttributeType.ORG.toString());

		if (org != null) {
			this.extendsKeys.add(org);
		}
		super.startElement(uri, localName, qName, atts);
	}


	/**
	 * �p���֌W�����B
	 * <P>�p�����N���X�ϐ��F�L�[���ږ����X�g�̍Ō�̍��ڂ��A
	 *�N���X�ϐ��Fattrname�^�O�̐e�^�O���ƈ�v����ꍇ�́A�p���֌W�������������s����B
	 * </P>
	 * @param keyName �Q�ƒ��̃L�[���ږ�
	 * @see PCHKeyItemHandler
	 */
	@Override
	protected void initDataModelMap(String keyName) {

		// �p�����N���X�łȂ��ꍇ�͏����𔲂���B
		if (!this.attrnameParent.equals(keyName)) {
			return;
		}
		// �p������MAP�擾
		Map<String, Object> orgAttrMap = getDataModelMap(this.orgDM, this.extendsKeys);
		Map<String, Object> map = getDataModelMap(this.dataModelMap, this.keys);

		for (Entry<String, Object> entry : orgAttrMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			// �p�����attr�G�������g�̎q�G�������g��MAP�擾
			Object attrnameChildMap = map.get(key);

			// �p����Ɍp�����̒l���ݒ肳��ĂȂ��ꍇ�Akey�����l�ƌp�����̒l��ݒ�
			if (attrnameChildMap == null) {

				// attr�G�������g�̎q�G�������g�L�����`�F�b�N
				if (this.attrnameChild == null) {
					// �p������key�AValue��Put
					map.put(key, value);
				} else {
					// �q�G�������g�̋�MAP�擾�iattname�ȉ��ɒǉ�����̂ŏ��TreeMap�j
					Map<String, Object> extendsMap = new TreeMap<String, Object>();

					// key�����l�ƌp������Value��Put
					extendsMap.put(this.initValue, value);
					//�p�����Map��Put
					map.put(key, extendsMap);
				}
			} else if (this.attrnameChild != null
					&& attrnameChildMap instanceof Map<?, ?>) {
				// attr�G�������g�̎q�G�������g�L���A�q�G�������g�̌^��Map
				@SuppressWarnings({"unchecked"})
				Map<String, Object> childMap = (Map<String, Object>) attrnameChildMap;

				// �p����Ɍp�����̒l���ݒ肳��Ă���ꍇ
				//�q�G�������g��MAP��key�����l���ݒ肳��ĂȂ��ꍇ
				//�q�G�������g��MAP��key�����l�ƌp�����̒l��ݒ�
				if (childMap.get(this.initValue) == null) {
					childMap.put(this.initValue, value);
					//�p�����Map��Put
					map.put(key, childMap);
				}
			}
		}
		this.value = map;

		if (!this.extendsKeys.isEmpty()) {
			this.extendsKeys.remove(this.extendsKeys.size() - 1);
		}
	}

}
