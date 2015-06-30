package jp.escofi.emr.engine.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.MessageType;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.PropertyUtil;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 * ���\�[�X�}�l�W���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>XML�t�@�C���Ǘ��iXML�t�@�C���j�̎擾�@�\�ASAX���[�_�[�̎擾�@�\��񋟂���B
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
final class ResourceManager {

	/**
	 * ���[�e�B���e�B�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private ResourceManager() {}


	/**
	 * XML�Ǘ��t�@�C�����擾�B
	 * <P>
	 * DOM�𗘗p���AXML�Ǘ��t�@�C�����擾����B
	 * </P>
	 * @return XML�Ǘ��t�@�C���̃h�L�������g���
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws IOException �t�@�C�����o�̓G���[
	 * @throws EMRException XML�t�@�C�������݂��Ȃ��A�܂��̓X�L�[�}�`�F�b�N�G���[
	 * @throws SAXException �X�L�}��`��͕s�����ASAX��O
	 */
	static Document getXMLMetaInfoDocument()
			throws ParserConfigurationException, IOException, EMRException, SAXException {
		String xmlFileInfoPath = PropertyUtil.getProperty("xml.meta.filepath");
		File xmlFile = new File(xmlFileInfoPath);

		// XML�Ǘ��t�@�C���̑��݃`�F�b�N
		if (!xmlFile.canRead()) {
			throw new EMRException(
					MessageCode.EMR_A_P004E, new Object[]{MessageType.XML_META, xmlFileInfoPath});
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File(PropertyUtil.getProperty("xml.meta.schema.filepath")));
		factory.setSchema(schema);
		DocumentBuilder builder = factory.newDocumentBuilder();

		InputStreamReader isr = null;

		// XML���
		try {
			isr = new InputStreamReader(new FileInputStream(xmlFile), Constants.XML_IO_CHARSET);
			InputSource inputSource = new InputSource(isr);
			return builder.parse(inputSource);
		} catch (SAXException e) {
			throw new EMRException(
					MessageCode.EMR_A_P005E, new Object[]{MessageType.XML_META, xmlFile.getName()}, e);
		} finally {
			if (isr != null) {
				isr.close();
			}
		}
	}

	/**
	 * XML���[�_�[�擾�B
	 * <P>
	 * SAX��XML���[�_�[�𐶐�����B<BR>
	 * ��������XML���[�_�[�́AXML�L�����������s���l�ɐݒ肷��B
	 * </P>
	 * @return XML���[�_�[
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws SAXException XML��̓G���[
	 */
	static XMLReader getSAXReader() throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// �L�����������s���B
		 factory.setValidating(false);
		 factory.setNamespaceAware(true);
		 SchemaFactory schemafactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		 factory.setSchema(schemafactory.newSchema(new Source[]{ new StreamSource(PropertyUtil.getProperty("xml.schema.filepath"))}));

		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();

		return reader;
	}

}
