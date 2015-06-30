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
 * リソースマネジャー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>XMLファイル管理（XMLファイル）の取得機能、SAXリーダーの取得機能を提供する。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1054 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:59:36 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
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
	 * ユーティリティクラスなのでコンストラクタはprivate指定。
	 */
	private PILResourceManager() {}


	/**
	 * XML管理ファイルを取得。
	 * <P>
	 * DOMを利用し、XML管理ファイルを取得する。
	 * </P>
	 * @see PILInitialLoader
	 * @return XML管理ファイルのドキュメント情報
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws IOException ファイル入出力エラー
	 * @throws PEXException XMLファイルが存在しない、またはスキーマチェックエラー
	 * @throws SAXException
	 */
	static Document getXMLMetaInfoDocument()
			throws ParserConfigurationException, IOException, PEXException, SAXException {
		String xmlFileInfoPath = PUTPropertyUtil.getProperty("xml.meta.filepath");
		File xmlFile = new File(xmlFileInfoPath);

		// XML管理ファイルの存在チェック
		if (!xmlFile.canRead()) {
			throw new PEXException(
					PCTMessageCode.P004E, new Object[]{PCTMessageType.XMLMETA, xmlFileInfoPath});
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 有効性検査を行う。
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
	 * XMLリーダー取得。
	 * <P>
	 * SAXのXMLリーダーを生成する。<BR>
	 * 生成したXMLリーダーは、XML有効性検査を行う様に設定する。
	 * </P>
	 * @see PILInitialLoader
	 * @return XMLリーダー
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws SAXException XML解析エラー
	 */
	static XMLReader getSAXReader() throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 有効性検査を行う。
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		SchemaFactory schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		factory.setSchema(schemafactory.newSchema(new Source[]{ new StreamSource("Z:/PDSNgine/xsd/datamodel.xsd")}));

		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();

		return reader;
	}

}
