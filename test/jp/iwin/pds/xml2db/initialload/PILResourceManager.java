package jp.iwin.pds.xml2db.initialload;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.constant.PCTMessageType;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 * ���\�[�X�}�l�W���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>XML�t�@�C���Ǘ��iXML�t�@�C���j�̎擾�@�\�ASAX���[�_�[�̎擾�@�\��񋟂���B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1054 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:59:36 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PILInitialLoader
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
final class PILResourceManager {

	/**
	 * ���[�e�B���e�B�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private PILResourceManager() {}


	/**
	 * XML�Ǘ��t�@�C�����擾�B
	 * <P>
	 * DOM�𗘗p���AXML�Ǘ��t�@�C�����擾����B
	 * </P>
	 * @see PILInitialLoader
	 * @return XML�Ǘ��t�@�C���̃h�L�������g���
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws PEXException XML�t�@�C�������݂��Ȃ��A�܂��̓X�L�[�}�`�F�b�N�G���[
	 * @throws SAXException
	 */
	static Document getXMLMetaInfoDocument()
			throws ParserConfigurationException, IOException, PEXException, SAXException {
		String xmlFileInfoPath = PUTPropertyUtil.getProperty("xml.meta.filepath");
		File xmlFile = new File(xmlFileInfoPath);

		// XML�Ǘ��t�@�C���̑��݃`�F�b�N
		if (!xmlFile.canRead()) {
			throw new PEXException(
					PCTMessageCode.P004E, new Object[]{PCTMessageType.XMLMETA, xmlFileInfoPath});
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// �L�����������s���B
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		SchemaFactory schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		factory.setSchema(schemafactory.newSchema(new Source[]{ new StreamSource("Z:/PDSNgine/xsd/XML_Meta.xsd")}));
		DocumentBuilder builder = factory.newDocumentBuilder();

		try {
			return builder.parse(xmlFileInfoPath);
		} catch (SAXException e) {
			throw new PEXException(
					PCTMessageCode.P005E, new Object[]{PCTMessageType.XMLMETA, xmlFile.getName()}, e);
		}
	}

	/**
	 * XML���[�_�[�擾�B
	 * <P>
	 * SAX��XML���[�_�[�𐶐�����B<BR>
	 * ��������XML���[�_�[�́AXML�L�����������s���l�ɐݒ肷��B
	 * </P>
	 * @see PILInitialLoader
	 * @return XML���[�_�[
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws SAXException XML��̓G���[
	 */
	static XMLReader getSAXReader() throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// �L�����������s���B
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		SchemaFactory schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		factory.setSchema(schemafactory.newSchema(new Source[]{ new StreamSource("Z:/PDSNgine/xsd/datamodel.xsd")}));

		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();

		return reader;
	}

}
