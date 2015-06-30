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
 * リソースマネジャー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>XMLファイル管理（XMLファイル）の取得機能、SAXリーダーの取得機能を提供する。
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/08/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
final class ResourceManager {

	/**
	 * ユーティリティクラスなのでコンストラクタはprivate指定。
	 */
	private ResourceManager() {}


	/**
	 * XML管理ファイルを取得。
	 * <P>
	 * DOMを利用し、XML管理ファイルを取得する。
	 * </P>
	 * @return XML管理ファイルのドキュメント情報
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws IOException ファイル入出力エラー
	 * @throws EMRException XMLファイルが存在しない、またはスキーマチェックエラー
	 * @throws SAXException スキマ定義解析不正時、SAX例外
	 */
	static Document getXMLMetaInfoDocument()
			throws ParserConfigurationException, IOException, EMRException, SAXException {
		String xmlFileInfoPath = PropertyUtil.getProperty("xml.meta.filepath");
		File xmlFile = new File(xmlFileInfoPath);

		// XML管理ファイルの存在チェック
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

		// XML解析
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
	 * XMLリーダー取得。
	 * <P>
	 * SAXのXMLリーダーを生成する。<BR>
	 * 生成したXMLリーダーは、XML有効性検査を行う様に設定する。
	 * </P>
	 * @return XMLリーダー
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws SAXException XML解析エラー
	 */
	static XMLReader getSAXReader() throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 有効性検査を行う。
		 factory.setValidating(false);
		 factory.setNamespaceAware(true);
		 SchemaFactory schemafactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		 factory.setSchema(schemafactory.newSchema(new Source[]{ new StreamSource(PropertyUtil.getProperty("xml.schema.filepath"))}));

		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();

		return reader;
	}

}
