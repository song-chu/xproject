package jp.escofi.emr.transformer.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.DatamodelMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;


/**
 * データモデル情報ライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>XML管理ファイルのデータモデル情報({@code <datamodelinfo>})以下の要素を出力するXMLライター。
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
public final class DatamodelinfoWriter extends AbstractXmlWriter {

	/**
	 * 案件番号
	 */
	private String productCd;
	/**
	 * XML出力先
	 */
	private String xmlBase;


	/**
	 * コンストラクタ。
	 * <UL>
	 *  <LI>継承元コンストラクタ呼出す。</LI>
	 *  <LI>引数をクラス変数へ保持する。</LI>
	 * </UL>
	 * @param productCd 案件番号
	 * @param xmlBase XML出力先
	 */
	public DatamodelinfoWriter(String productCd, String xmlBase) {
		super(ElementType.DATA_MODEL_INFO);
		this.productCd = productCd;
		this.xmlBase = xmlBase;
	}


	/**
	 * 出力情報編集処理。
	 * <OL>
	 *  <LI>変数：データモデル情報編集マップを新規LinkedHashMapで初期化する。</LI>
	 *  <LI>データモデル抽出を行う。</LI>
	 *  <LI>抽出したデータモデル数分、以下の処理を行う。
	 *   <OL>
	 *    <LI>データモデルから、継承元データモデル名を取得する。</LI>
	 *    <LI>継承元データモデル名が取得できた場合は、以下の処理を行う。
	 *     <OL>
	 *      <LI>変数：データモデル情報編集マップから、
	 *継承元データモデル名をキーに、データモデルを取得する。</LI>
	 *      <LI>取得したデータモデルの継承元データモデルフラグをtrueに設定する。</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>データモデルのタグ内容編集処理を呼出す。</LI>
	 *    <LI>継承元クラス変数：子タグセットに、データモデルを追加する。</LI>
	 *    <LI>変数：データモデル情報編集マップに、データモデル名をキーとして、
	 *データモデルを追加する。</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * @param session DBセッション
	 * @throws EMRException 業務例外
	 */
	private void init(SqlSession session) throws EMRException {
		Map<String, DatamodelWriter> dataModelMap = new LinkedHashMap<String, DatamodelWriter>();
		DatamodelMapper mapper = session.getMapper(DatamodelMapper.class);
		List<DatamodelWriter> writers = mapper.select(productCd);

		if (writers.isEmpty()) {
			throw new EMRException(MessageCode.EMR_B_P912E, new Object[] {
					productCd });
		}
		for (DatamodelWriter writer : writers) {
			String extendsDm = writer.getExtendsDm();

			if (extendsDm != null) {
				dataModelMap.get(extendsDm).setParentDmFlg(true);
			}
			writer.init(session, productCd);

			String key = writer.getAttribute(AttributeType.NAME);

			dataModelMap.put(key, writer);
		}
		childSet.addAll(dataModelMap.values());
	}

	/**
	 * XML出力処理。
	 * <OL>
	 *  <LI>出力情報編集処理</LI>
	 *  <LI>XML管理ファイルのXMLライターを取得する。</LI>
	 *  <LI>XMLライターに出力するXMLのインデント幅を設定して、XML出力を開始する。</LI>
	 *  <LI>データモデル情報タグの内容を出力する。</LI>
	 *  <LI>XMLライターのXML出力を終了する。</LI>
	 *  <LI>継承元クラス変数：子タグセットのイテレータを取得し、
	 *イテレータで次が無くなるまで以下の処理を繰返す。
	 *   <OL>
	 *    <LI>イテレータから、子タグ(データモデル)ライターを取得する。</LI>
	 *    <LI>データモデルライターから、ファイル名を取得する。</LI>
	 *    <LI>データモデルファイルのXMLライターを取得する。</LI>
	 *    <LI>XMLライターに出力するXMLのインデント幅を設定して、XML出力を開始する。</LI>
	 *    <LI>データモデルライターのデータモデル出力処理を呼出す。</LI>
	 *    <LI>XMLライターのXML出力を終了する。</LI>
	 *    <LI>イテレータから出力したデータモデルライターを削除する。</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * @param session SQLセッション
	 * @throws SAXException XML出力例外
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException 業務例外
	 * @throws ParserConfigurationException XML解析設定例外
	 */
	public void write(SqlSession session)
	throws SAXException, IOException, EMRException, ParserConfigurationException {

		init(session);

		XMLWriter writer = getWriter(PDSConstants.FILE_META.toString());

		writer.setIndentStep(4);
		writer.startDocument();

		startElement(writer);
		outputBody(writer);
		endElement(writer);

		writer.endDocument();

		Iterator<AbstractXmlWriter> ite = childSet.iterator();

		while (ite.hasNext()) {
			AbstractXmlWriter child = ite.next();
			String fileName = child.getAttribute(AttributeType.FILE);

			writer = getWriter(fileName);
			writer.setIndentStep(4);
			writer.startDocument();

			((DatamodelWriter) child).writeDataModel(writer, session);

			writer.endDocument();
			ite.remove();
		}
	}


	/**
	 * XMLライター取得。
	 * <OL>
	 *  <LI>XMLファイルパス編集</LI>
	 *  <LI>ファイル書込みチェック(ファイル生成、もしくはファイル書込み)</LI>
	 *  <LI>ファイル書込みチェックが失敗した場合は、EMRxceptionを生成、throwする。</LI>
	 *  <LI>XMLファイルパスから、ファイル出力を生成する。</LI>
	 *  <LI>内部文字コード定数から、文字コードセットを生成する。</LI>
	 *  <LI>ファイル出力、文字コードセットから、出力ライターを生成する。</LI>
	 *  <LI>出力ライターから、XMLライターを生成して返却する。</LI>
	 * </OL>
	 * @param fileName 出力するファイル名
	 * @return 指定したファイルへデータを出力するXMLライター
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException ファイル書込みチェックエラー
	 */
	private XMLWriter getWriter(String fileName) throws IOException, EMRException {
		File xmlFile = new File(xmlBase + File.separator + fileName);

		if (!xmlFile.createNewFile() && !xmlFile.canWrite()) {
			throw new EMRException(MessageCode.EMR_B_P904E, new Object[] { xmlFile.getAbsolutePath() });
		}
		FileOutputStream out = new FileOutputStream(xmlFile);
		Charset cSet = Charset.forName(PDSConstants.CHARSET.toString());

		return new XMLWriter(new OutputStreamWriter(out, cSet));
	}

}
