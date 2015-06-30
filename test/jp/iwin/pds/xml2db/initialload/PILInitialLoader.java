package jp.iwin.pds.xml2db.initialload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTMessageType;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.initialload.handler.PCHDataModelHandler;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHDataModelHandlerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 * �C�j�V�������[�_�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>
 *    <UL>
 *     <LI>XML�t�@�C���Ǘ��iXML�t�@�C���j��ǂݍ��݁A�t�@�C���̓ǂݍ��ݏ��A�p���֌W�A�L�[���y�ёI������iMap�W�J�����j�����擾����B
 *     <LI>�ǂݍ��ݏ��Ńf�[�^���f��XML��ǂݍ��݁A�p�[�X�������s���B
 *     <LI>XML�t�@�C���Ǘ��̎Q�Ɛ�́A�ݒ�t�@�C������擾����B
 *     <LI>�f�[�^���f����XML��`�t�@�C���̎Q�Ɛ�́AXML�t�@�C���Ǘ�����擾����B
 *     <LI>XML�t�@�C���Ǘ��A�f�[�^���f����XML��`�t�@�C���̉�͂́A������XML��̓n���h���[�𐶐����čs���B
 *    </UL>
 *  <DT>�T���v���R�[�h�F
 *   <DD>�����\�b�h����ďo����
 *    <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'><TT>
 *  PILInitialLoader loader = new PILInitialLoader();
 *
 *  {@code HashMap<String, Object>} pdsObjects = loader.getPDSObject();
 *  {@code HashMap<String, List<String>>} pdsItemKeys = loader.getPDSItemKeys();
 * </TT></PRE>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1230 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-09 15:44:09 +0900 (木, 09 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.dumptool.PDMObjectWriter
 * @see jp.iwin.pds.engine.PENEngine
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PILInitialLoader {

	/**
	 * �L�[���ڃ}�b�v
	 */
	private HashMap<String, List<String>> pdsItemKeys = new HashMap<String, List<String>>();

	/**
	 * PDS�I�u�W�F�N�g�}�b�v
	 */
	private HashMap<String, Object> pdsObject = new HashMap<String, Object>();


	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *	<DT>�g�p�ړI/�@�\�T�v�F
	 *	 <DD>�N���X���[�h���ɁA�f�[�^���f���̃C���X�^���X�����s���B
	 *	 <DD>�f�[�^���f���̃C���X�^���X���͉��L�̏������ōs���B
	 *	 <DD>XML�t�@�C���Ǘ��ɕ�����{@code <datamodel>}����`����Ă���ꍇ�́A3.��{@code <datamodel>}���J��Ԃ��B
	 *   <OL>
	 *   <LI>DOM�𗘗p���AXML�t�@�C���Ǘ����擾�E�W�J����B
	 *   <LI>{@code <datamodel>}�m�[�h���X�g�擾���A{@code <datamodel>}�m�[�h���Ƀf�[�^�[���f����
	 *XML��`�t�@�C���̎Q�Ɛ���擾����B
	 *   <LI>�f�[�^���f���n���h���[�𐶐����A�f�[�^���f���̃C���X�^���X�����s���A������PDS�I�u�W�F�N�g�}�b�v�A
	 *�L�[���ڃ}�b�v�֊i�[����B
	 *   </OL>
	 * </DL>
	 * @see jp.iwin.pds.dumptool.PDMObjectWriter
	 * @see jp.iwin.pds.engine.PENEngine
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws SAXException XML��̓G���[
	 * @throws PEXException XML�t�@�C�������݂��Ȃ��A�܂��̓X�L�[�}�`�F�b�N�G���[
	 */
	public PILInitialLoader() throws IOException, SAXException, ParserConfigurationException, PEXException {

		// ���[�J���ϐ���PDS�I�u�W�F�N�g�i�p�����p�̃e���|����Map�j
		Map<String, Object> pdsObjectLocal = new HashMap<String, Object>();

		HashMap<String, List<String>> pdsItemKeysLocal = new HashMap<String, List<String>>();

		// DOM�𗘗p���AXML�t�@�C���Ǘ����擾�E�W�J����B
		Document metaInfoDoc = PILResourceManager.getXMLMetaInfoDocument();

		// XML�t�@�C���Ǘ��̃��[�g�G�������g�擾
		Element dRoot = (Element) metaInfoDoc.getDocumentElement();

		// <datamodel>�m�[�h���X�g�擾
		NodeList dataModels = dRoot.getElementsByTagName(PCTElementType.DATAMODEL.toString());

		// DataModel�̓ǂݍ��݁E�W�J
		int items = dataModels.getLength();
		for (int i = 0; i < items; i++) {
			Element dataModel = (Element) dataModels.item(i);

			readDataModel(dataModel, pdsObjectLocal, pdsItemKeysLocal);
		}
	}


	/**
	 * @return PDS�I�u�W�F�N�g�}�b�v
	 */
	public HashMap<String, Object> getPDSObject() {
		return this.pdsObject;
	}

	/**
	 * @return �L�[���ڃ}�b�v
	 */
	public HashMap<String, List<String>> getPDSItemKeys() {
		return this.pdsItemKeys;
	}

	/**
	 * �f�[�^���f���Ǎ��݁B
	 * <P>
	 * �f�[�^���f���̓ǂݍ��݁E�W�J�B
	 * </P>
	 * @param dataModel �f�[�^���f���̃G�������g���
	 * @param pdsObjectLocal ���[�J���ϐ���PDS�I�u�W�F�N�g
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws SAXException XML��̓G���[
	 * @throws PEXException XML�t�@�C�������݂��Ȃ��A�܂��̓X�L�[�}�`�F�b�N�G���[
	 */
	private void readDataModel(Element dataModel, Map<String, Object> pdsObjectLocal,HashMap<String, List<String>> pdsItemKeysLocal)
	throws IOException, SAXException, ParserConfigurationException, PEXException {
		// SAX reader
		XMLReader reader = PILResourceManager.getSAXReader();

		List<String> itemKeys = getKeyItemList(dataModel);

		// �f�[�^���f���t�@�C��Path
		String dataModelFile = dataModel.getAttribute(PCTAttributeType.FILE.toString());

		// �p�������ۂ��̃t���O
		String parentFlg = dataModel.getAttribute(PCTAttributeType.PARENTFLG.toString());

		// DataModelHandler����
		PCHDataModelHandler dataModelHandler = PCHDataModelHandlerFactory.createDataModelHandler(
				reader, dataModel, pdsObjectLocal, itemKeys,pdsItemKeysLocal );

		reader.setContentHandler(dataModelHandler);

		// �G���[�n���h���[�Z�b�g
		reader.setErrorHandler(dataModelHandler);


		// �f�[�^���f���t��Path
		String dataModelPath = getDataModelPath(dataModelFile);

		// XML�t�@�C���̑��݃`�F�b�N
		if (!new File(dataModelPath).canRead()) {
			throw new PEXException(
					PCTMessageCode.P004E, new Object[]{PCTMessageType.DATAMODEL, dataModelPath});
		}

		// XML���
		try {
			reader.parse(dataModelPath);
		} catch (SAXException e) {
			throw new PEXException(
					PCTMessageCode.P005E, new Object[]{PCTMessageType.DATAMODEL, dataModelFile}, e);
		}

		Map<String, Object> dataModelMap = dataModelHandler.getDataModelMap();


		if (Boolean.valueOf(parentFlg)) {
			// �p�����̏ꍇ�̓��[�J���ϐ��ɕۑ�
			pdsObjectLocal.putAll(dataModelMap);
			pdsItemKeysLocal.put(dataModelHandler.getDataModelName(), itemKeys);
		} else {
			// �Ђ̏ꍇ�̓N���X�̃����o�[�ϐ��ɕۑ�
			this.pdsObject.putAll(dataModelMap);
			this.pdsItemKeys.put(dataModelHandler.getDataModelName(), itemKeys);
		}

	}

	/**
	 * �f�[�^���f���t�@�C���p�X�擾�B
	 * <P>
	 * �f�[�^���f���t�@�C���̃t���p�X���擾����B
	 * </P>
	 * @param dataModelFile �f�[�^���f���̃t�@�C����
	 * @return �f�[�^���f���t�@�C���̃t���p�X
	 */
	private String getDataModelPath(String dataModelFile) {

		// �f�[�^���f���t��Path
		StringBuilder dataModelPath = new StringBuilder(
				PUTPropertyUtil.getProperty("xml.datamodel.base"));
		dataModelPath.append("/");
		dataModelPath.append(dataModelFile);

		return dataModelPath.toString();
	}

	/**
	 * �L�[���ږ����X�g�擾�B
	 *
	 * @param dataModel �f�[�^���f���̃G�������g���
	 * @return �L�[���ږ����X�g
	 */
	private List<String> getKeyItemList(Element dataModel) {
		List<String> itemKeys = new ArrayList<String>();

		// KeyList�擾
		NodeList elements = dataModel.getElementsByTagName(PCTElementType.KEYITEM.toString());
		int childItemLength = elements.getLength();

		// ����q�̏������₷�����邽�߁A��ԉ��̃G�������g������o���B
		for (int i = 0; i < childItemLength; i++) {
			Element elem = (Element) elements.item(i);
			// �L�[���ږ�
			Text elemName = (Text) elem.getFirstChild();
			itemKeys.add(elemName.getData());
		}

		return itemKeys;
	}

}
