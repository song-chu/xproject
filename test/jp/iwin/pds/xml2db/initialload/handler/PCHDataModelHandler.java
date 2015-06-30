package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;


/**
 * �f�[�^���f���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f���i{@code <datamodel>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see PCHKeyItemHandler
 * @see PCHKeyItemHandlerExt
 * @see jp.iwin.pds.initialload.PILInitialLoader
 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHDataModelHandler extends PCHAINIHandler {

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
	private PCHKeyItemHandler keyItemHandler;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param reader XML���[�_�[
	 * @param dataModelName �f�[�^���f����
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
	 */
	public PCHDataModelHandler(XMLReader reader, String dataModelName) {
		this.reader = reader;
		this.dataModelName = dataModelName.intern();
		this.globalConditionItemMap = new HashMap<String, PROConditionItemInfo>();
	}


	/**
	 * @param keyItemHandler �L�[���ڃn���h���[
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
	 */
	public void setKeyItemHandler(PCHKeyItemHandler keyItemHandler) {
		this.keyItemHandler = keyItemHandler;
	}

	/**
	 * @return �f�[�^���f����
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 */
	public String getDataModelName() {
		return dataModelName;
	}

	/**
	 * @return �f�[�^���f���}�b�v
	 * @see PCHKeyItemHandler
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 */
	public Map<String, Object> getDataModelMap() {
		return this.dataModelMap;
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

		this.keys.add(this.dataModelName);
		this.dataModelMap.put(this.dataModelName, new HashMap<String, Object>());

		if (PCTElementType.DATAMODEL.equals(qName)) {
			this.reader.setContentHandler(this.keyItemHandler);
		}
	}


	/**
	 * @return �L�[���ڃ��X�g
	 * @see PCHKeyItemHandler
	 */
	List<String> getKeys() {
		return this.keys;
	}

}
