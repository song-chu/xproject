package jp.escofi.emr.engine.search;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �I�u�W�F�N�g���C�^�[�N���X�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�I�u�W�F�N�g�iHashMap�j�̑����l���擾�ł���܂ł̃L�[���ڃc���[�\���������o���N���X�B
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
public class ObjectWriter {
	/**
	 * �_���v���s�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����ɂ��t�@�C���p�X�ƃ_���v�͈͂����߁A���s����B
	 * </DL>
	 * @param filePath �t�@�C���p�X
	 * @param dataModelName �f�[�^���f����
	 * @param pdsObject PDS�I�u�W�F�N�g
	 * @param pdsItemKeys �f�[�^���f���ʃL�[���ڃ��X�g
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws SAXException XML��̓G���[
	 */
	@SuppressWarnings("unchecked")
	public static void excuteDump(String filePath, String dataModelName,
			Map<String, Object> pdsObject,
			HashMap<String, List<String>> pdsItemKeys) throws IOException,
			SAXException {

		String path = filePath;
		if (path == null || path.equals("")) {
			path = PropertyUtil.getProperty("xml.dumpxml.base");
		}

		if (dataModelName.equals(Constants.DATA_MODEL_ALL)) {
			Set<String> keySet = pdsObject.keySet();
			for (String key : keySet) {
				objectWrite(path, key,
						(Map<String, Object>) pdsObject.get(key),
						pdsItemKeys.get(key));
			}
		} else {
			objectWrite(path, dataModelName,
					(Map<String, Object>) pdsObject.get(dataModelName),
					pdsItemKeys.get(dataModelName));
		}

	}

	/**
	 * �I�u�W�F�N�g�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>XML���C�^�[�𐶐����A���[�g�G�������g�������o���B
	 * </DL>
	 * @param filePath �t�@�C���p�X
	 * @param dataModelName �f�[�^���f����
	 * @param dataModel �f�[�^���f��
	 * @param keyItemNames �L�[���ڃ��X�g
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws SAXException XML��̓G���[
	 */
	private static void objectWrite(String filePath, String dataModelName,
			Map<String, Object> dataModel, List<String> keyItemNames)
			throws SAXException, IOException {

		String fullFileName = getFilePath(filePath, dataModelName);
		XMLWriter witer = null;
		try {
			witer = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(fullFileName), Constants.XML_IO_CHARSET));
			witer.startDocument();
			witer.setIndentStep(4);

			Attributes atts = makeKeyItemAttr(witer, dataModelName, null);
			witer.startElement(ElementType.DATA_MODEL.toString(), atts);
			mapExplore(dataModel, keyItemNames, 0, witer);
			witer.endElement(ElementType.DATA_MODEL.toString());
			witer.endDocument();
		} catch (SAXException e) {
			witer.flush();
			throw e;
		}

	}

	/**
	 * �L�[���ڏ����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����l���擾�ł���܂ł̃L�[���ڃc���[�\���������o���B
	 * </DL>
	 * @param dataModel �f�[�^���f���}�b�v
	 * @param keyItemNames �L�[���ڃ��X�g
	 * @param index �L�[���ڃ��x��
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	@SuppressWarnings("unchecked")
	private static void mapExplore(Map<String, Object> dataModel,
			List<String> keyItemNames, int index, XMLWriter writer)
			throws SAXException {
		// �L�[���Ń\�[�g����B
		List<Map.Entry<String, Object>> entries = ConvertUtil
				.sortMap(dataModel);

		// �J��Ԃ�����
		int tempIndex = index;
		for (Map.Entry<String, Object> entry : entries) {
			Object value = entry.getValue();

			Attributes atts = makeKeyItemAttr(writer, keyItemNames.get(tempIndex),
					entry.getKey());
			writer.startElement(ElementType.KEY_ITEM.toString(), atts);
			tempIndex++;
			// ���ʃI�u�W�F�N�g��Map����菑���o�����\�b�h�𕪂��ČĂяo��
			if (value instanceof ResultObject) {
				((ResultObject) value).toDump(writer);
			} else {
				mapExplore((Map<String, Object>) value, keyItemNames, tempIndex,
						writer);
			}
			tempIndex--;
			writer.endElement(ElementType.KEY_ITEM.toString());
		}
	}

	/**
	 * �t�@�C���t���l�[�������B
	 *
	 * @param filePath �t�@�C���p�X
	 * @param dataModelName �f�[�^���f����
	 * @return �t�@�C���t���l�[��
	 */
	private static String getFilePath(String filePath, String dataModelName) {

		StringBuilder dataModelPath = new StringBuilder(filePath);
		Date date = new Date();
		dataModelPath.append("/");
		dataModelPath.append(dataModelName);
		dataModelPath.append("_");
		dataModelPath.append(new SimpleDateFormat("yyyyMMdd").format(date
				.getTime()));
		dataModelPath.append("_");
		dataModelPath.append(new SimpleDateFormat("HHmmss").format(date
				.getTime()));
		dataModelPath.append(".xml");

		return dataModelPath.toString();

	}

	/**
	 * �A�g���r���[�g�����B
	 *
	 * @param writer ���C�^�[
	 * @param name �A�g���r���[�gname�̒l
	 * @param key �A�g���r���[�gkey�̒l
	 * @return �A�g���r���[�g
	 */
	private static Attributes makeKeyItemAttr(XMLWriter writer, String name,
			String key) {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.NAME.toString(), name);
		if (key != null) {
			writer.addAttribute(atts, AttributeType.KEY.toString(), key);
		}
		return atts;
	}

}
