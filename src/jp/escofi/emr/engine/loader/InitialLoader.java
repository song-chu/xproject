package jp.escofi.emr.engine.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.MessageType;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.loader.DataModelHandlerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
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
 *  InitialLoader loader = new InitialLoader();
 *
 *  {@code HashMap<String, Object>} pdsObjects = loader.getPDSObject();
 *  {@code HashMap<String, List<String>>} pdsItemKeys = loader.getPDSItemKeys();
 * </TT></PRE>
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
public final class InitialLoader {

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
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws SAXException XML��̓G���[
	 * @throws EMRException XML�t�@�C�������݂��Ȃ��A�܂��̓X�L�[�}�`�F�b�N�G���[
	 */
	public InitialLoader() throws IOException, SAXException, ParserConfigurationException, EMRException {

		// ���[�J���ϐ���PDS�I�u�W�F�N�g�i�p�����p�̃e���|����Map�j
		Map<String, Object> pdsObjectLocal = new HashMap<String, Object>();

		// DOM�𗘗p���AXML�t�@�C���Ǘ����擾�E�W�J����B
		Document metaInfoDoc = ResourceManager.getXMLMetaInfoDocument();

		// XML�t�@�C���Ǘ��̃��[�g�G�������g�擾
		Element dRoot = metaInfoDoc.getDocumentElement();

		// <datamodel>�m�[�h���X�g�擾
		NodeList dataModels = dRoot.getElementsByTagName(ElementType.DATA_MODEL.toString());

		// DataModel�̓ǂݍ��݁E�W�J
		int items = dataModels.getLength();
		for (int i = 0; i < items; i++) {
			Element dataModel = (Element) dataModels.item(i);
			if (dataModel.getAttribute(AttributeType.NAME.toString())
					.length() == 0) {
				throw new IllegalArgumentException(
						"Attribute 'name' must be set on element 'datamodel'.");
			} else if (dataModel.getAttribute(
					AttributeType.PARENT_FLG.toString()).length() == 0) {
				throw new IllegalArgumentException(
						"Attribute 'parentflg' must be set on element 'datamodel'.");
			}

			readDataModel(dataModel, pdsObjectLocal);
		}
	}


	/**
	 * @return PDS�I�u�W�F�N�g�}�b�v
	 */
	public HashMap<String, Object> getPdsObject() {
		return pdsObject;
	}

	/**
	 * @return �L�[���ڃ}�b�v
	 */
	public HashMap<String, List<String>> getPdsItemKeys() {
		return pdsItemKeys;
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
	 * @throws EMRException XML�t�@�C�������݂��Ȃ��A�܂��̓X�L�[�}�`�F�b�N�G���[
	 */
	private void readDataModel(Element dataModel, Map<String, Object> pdsObjectLocal)
	throws IOException, SAXException, ParserConfigurationException, EMRException {
		// SAX reader
		XMLReader reader = ResourceManager.getSAXReader();

		List<String> itemKeys = getKeyItemList(dataModel);

		// DataModelHandler����
		DataModelHandler dataModelHandler = DataModelHandlerFactory.createDataModelHandler(
				reader, dataModel, pdsObjectLocal, itemKeys);

		reader.setContentHandler(dataModelHandler);

		// �G���[�n���h���[�Z�b�g
		reader.setErrorHandler(dataModelHandler);


		// �f�[�^���f���t�@�C��Path
		String dataModelFile = dataModel.getAttribute(AttributeType.FILE.toString());

		// �f�[�^���f���t��Path
		String dataModelPath = getDataModelPath(dataModelFile);

		// XML�t�@�C���̑��݃`�F�b�N
		if (!new File(dataModelPath).canRead()) {
			throw new EMRException(
					MessageCode.EMR_A_P004E, new Object[]{MessageType.DATA_MODEL, dataModelPath});
		}

		InputStreamReader isr = null;

		// XML���
		try {
			isr = new InputStreamReader(new FileInputStream(dataModelPath), Constants.XML_IO_CHARSET);
			InputSource inputSource = new InputSource(isr);
			reader.parse(inputSource);
		} catch (SAXException e) {
			throw new EMRException(
					MessageCode.EMR_A_P005E, new Object[]{MessageType.DATA_MODEL, dataModelFile}, e);
		} finally {
			if (isr != null) {
				isr.close();
			}
		}
		Map<String, Object> dataModelMap = dataModelHandler.getDataModelMap();

		// �p�������ۂ��̃t���O
		String parentFlg = dataModel.getAttribute(AttributeType.PARENT_FLG.toString());
		if (ConvertUtil.isConvertBoolean(parentFlg)) {
			// �p�����̏ꍇ�̓��[�J���ϐ��ɕۑ�
			pdsObjectLocal.putAll(dataModelMap);
		} else {
			// �Ђ̏ꍇ�̓N���X�̃����o�[�ϐ��ɕۑ�
			pdsObject.putAll(dataModelMap);
			pdsItemKeys.put(dataModelHandler.getDataModelName(), itemKeys);
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
				PropertyUtil.getProperty("xml.datamodel.base"));
		dataModelPath.append(System.getProperty("file.separator", "/"));
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
		NodeList elements = dataModel.getElementsByTagName(ElementType.KEY_ITEM.toString());
		int childItemLength = elements.getLength();

		for (int i = 0; i < childItemLength; i++) {
			Element elem = (Element) elements.item(i);
			// �L�[���ږ�
			Text elemName = (Text) elem.getFirstChild();
			itemKeys.add(elemName.getData());
		}

		return itemKeys;
	}

}
