package jp.escofi.emr.transformer.sql;

import java.util.Arrays;
import java.util.List;

import jp.escofi.emr.transformer.writer.KeyitemWriter;


/**
 * �����O���[�v���}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�擾�����L�[���ڏ��t�������O���[�v�����i�[����N���X�B
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
public final class AttributeGroupMapper {

	/**
	 * �����O���[�vID
	 */
	private int attGroupID;

	/**
	 * �L�[���ڃ��C�^�[�z��
	 */
	private KeyitemWriter[] keyItems = new KeyitemWriter[10];


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �L�[���ڃ��C�^�[�z�������������B
	 * </P>
	 */
	public AttributeGroupMapper() {

		for (int i = 0; i < keyItems.length; i++) {
			keyItems[i] = new KeyitemWriter();
		}
	}

	/**
	 * @return �����O���[�vID
	 */
	public int getAttGroupID() {
		return attGroupID;
	}

	/**
	 * @return �L�[���ڃ��C�^�[���X�g
	 */
	public List<KeyitemWriter> getKeyItemList() {
		return Arrays.asList(keyItems);
	}

	/**
	 * @param attGroupID �����O���[�vID
	 */
	public void setAttGroupID(int attGroupID) {
		this.attGroupID = attGroupID;
	}

	/**
	 * @param key01Name �L�[����01�̉p����
	 */
	public void setKey01Name(String key01Name) {
		keyItems[0].setName(key01Name);
	}

	/**
	 * @param key02Name �L�[����02�̉p����
	 */
	public void setKey02Name(String key02Name) {
		keyItems[1].setName(key02Name);
	}

	/**
	 * @param key03Name �L�[����03�̉p����
	 */
	public void setKey03Name(String key03Name) {
		keyItems[2].setName(key03Name);
	}

	/**
	 * @param key04Name �L�[����04�̉p����
	 */
	public void setKey04Name(String key04Name) {
		keyItems[3].setName(key04Name);
	}

	/**
	 * @param key05Name �L�[����05�̉p����
	 */
	public void setKey05Name(String key05Name) {
		keyItems[4].setName(key05Name);
	}

	/**
	 * @param key06Name �L�[����06�̉p����
	 */
	public void setKey06Name(String key06Name) {
		keyItems[5].setName(key06Name);
	}

	/**
	 * @param key07Name �L�[����07�̉p����
	 */
	public void setKey07Name(String key07Name) {
		keyItems[6].setName(key07Name);
	}

	/**
	 * @param key08Name �L�[����08�̉p����
	 */
	public void setKey08Name(String key08Name) {
		keyItems[7].setName(key08Name);
	}

	/**
	 * @param key09Name �L�[����09�̉p����
	 */
	public void setKey09Name(String key09Name) {
		keyItems[8].setName(key09Name);
	}

	/**
	 * @param key10Name �L�[����10�̉p����
	 */
	public void setKey10Name(String key10Name) {
		keyItems[9].setName(key10Name);
	}

}
