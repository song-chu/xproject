package jp.iwin.pds.xml2db.dumptool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTConstants;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �I�u�W�F�N�g���C�^�[�N���X�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�I�u�W�F�N�g�iHashMap�j�̑����l���擾�ł���܂ł̃L�[���ڃc���[�\���������o���N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1230 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date:: 2010-12-09 15:44:09 +0900#$
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public class PDMObjectWriter {
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

		if (filePath == null) {
			filePath = PUTPropertyUtil.getProperty("xml.dumpxml.base");
		}

		if (dataModelName.equals("all")) {
			Set<String> keySet = pdsObject.keySet();
			for (String key : keySet) {
				objectWrite(filePath, key,
						(Map<String, Object>) pdsObject.get(key),
						pdsItemKeys.get(key));
			}
		} else {
			objectWrite(filePath, dataModelName,
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
		PUTXMLWriter witer = null;
		try {
			witer = new PUTXMLWriter(new OutputStreamWriter(
					new FileOutputStream(fullFileName), PCTConstants.CHARSET));
			witer.startDocument();
			witer.setIndentStep(4);

			Attributes atts = makeKeyItemAttr(witer, dataModelName, null);
			witer.startElement(PCTElementType.DATAMODEL.toString(), atts);
			mapExplore(dataModel, keyItemNames, 0, witer);
			witer.endElement(PCTElementType.DATAMODEL.toString());
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
			List<String> keyItemNames, int index, PUTXMLWriter writer)
			throws SAXException {
		// �L�[���Ń\�[�g����B
		List<Map.Entry<String, Object>> entries = PUTConvertUtil
				.sortMap(dataModel);

		// �J��Ԃ�����
		for (Map.Entry<String, Object> entry : entries) {
			Object value = entry.getValue();

			// KeyItemWriteStart(keyItemNames.get(index), entry.getKey(), w);
			Attributes atts = makeKeyItemAttr(writer, keyItemNames.get(index),
					entry.getKey());
			writer.startElement(PCTElementType.KEYITEM.toString(), atts);
			index++;
			// ���ʃI�u�W�F�N�g��Map����菑���o�����\�b�h�𕪂��ČĂяo��
			if (value instanceof PROResultObject) {
				((PROResultObject) value).toDump(writer);
			} else {
				mapExplore((Map<String, Object>) value, keyItemNames, index,
						writer);
			}
			index--;
			// KeyItemWriteEnd(w);
			writer.endElement(PCTElementType.KEYITEM.toString());
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
	private static Attributes makeKeyItemAttr(PUTXMLWriter writer, String name,
			String key) {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.NAME.toString(), name);
		if (key != null) {
			writer.addAttribute(atts, PCTAttributeType.KEY.toString(), key);
		}
		return atts;
	}

}
