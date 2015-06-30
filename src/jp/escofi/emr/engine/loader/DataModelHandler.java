package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;


/**
 * �f�[�^���f���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f���i{@code <datamodel>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class DataModelHandler extends AbstractINIHandler {

	/**
	 * �L�[���ڃ��X�g
	 */
	private List<String> keys = new ArrayList<String>();
	/**
	 * �f�[�^���f���}�b�v
	 */
	private Map<String, Object> dataModelMap = new HashMap<String, Object>();
	/**
	 * �f�[�^���f����
	 */
	private String dataModelName;
	/**
	 * �L�[���ڃn���h���[
	 */
	private KeyItemHandler keyItemHandler;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param reader XML���[�_�[
	 * @param dataModelName �f�[�^���f����
	 */
	public DataModelHandler(XMLReader reader, String dataModelName) {
		this.reader = reader;
		this.dataModelName = dataModelName.intern();
		globalConditionItemMap = new HashMap<String, ConditionItemInfo>();
	}


	/**
	 * @param keyItemHandler �L�[���ڃn���h���[
	 */
	public void setKeyItemHandler(KeyItemHandler keyItemHandler) {
		this.keyItemHandler = keyItemHandler;
	}

	/**
	 * @return �f�[�^���f����
	 */
	public String getDataModelName() {
		return dataModelName;
	}

	/**
	 * @return �f�[�^���f���}�b�v
	 */
	public Map<String, Object> getDataModelMap() {
		return dataModelMap;
	}

	/**
	 * �^�O�J�n�����B
	 * <OL>
	 *  <LI>�N���X�ϐ��F�L�[���ڃ��X�g�ɁA�N���X�ϐ��F�f�[�^���f�������i�[����B</LI>
	 *  <LI>�N���X�ϐ��F�f�[�^���f���}�b�v�ɁA�f�[�^���f���^�̃}�b�v�C���X�^���X���i�[����B</LI>
	 *  <LI>�Ώۃ^�O���f�[�^���f���̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�̃n���h���[�ɁA
	 *�N���X�ϐ��F�L�[���ڃn���h���[��ݒ肷��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		keys.add(dataModelName);
		dataModelMap.put(dataModelName, new HashMap<String, Object>());

		if (ElementType.DATA_MODEL.toString().equals(qName)) {
			reader.setContentHandler(keyItemHandler);
		}
	}


	/**
	 * @return �L�[���ڃ��X�g
	 */
	List<String> getKeys() {
		return keys;
	}

}
