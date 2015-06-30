package jp.escofi.emr.transformer.writer;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * 条件文ライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件文全体（{@code <condition>}）以下の要素を出力するXMLライター。
 *	 <DD>以下の条件文内の要素もこのXMLライターで出力する。
 *    <UL>
 *     <LI>{@code <if>}</LI>
 *     <LI>{@code <else>}</LI>
 *     <LI>{@code <apply>}</LI>
 *     <LI>{@code <and>}</LI>
 *     <LI>{@code <or>}</LI>
 *     <LI>{@code <eq>}</LI>
 *     <LI>{@code <neq>}</LI>
 *     <LI>{@code <gt>}</LI>
 *     <LI>{@code <geq>}</LI>
 *     <LI>{@code <lt>}</LI>
 *     <LI>{@code <leq>}</LI>
 *     <LI>{@code <in>}</LI>
 *     <LI>{@code <notin>}</LI>
 *     <LI>{@code <intersect>}</LI>
 *     <LI>{@code <nintersect>}</LI>
 *     <LI>{@code <startswith>}</LI>
 *     <LI>{@code <nstartswith>}</LI>
 *     <LI>{@code <subset>}</LI>
 *     <LI>{@code <nsubset>}</LI>
 *     <LI>{@code <include>}</LI>
 *     <LI>{@code <exclude>}</LI>
 *     <LI>{@code <const>}</LI>
 *     <LI>{@code <single>}</LI>
 *     <LI>{@code <set>}</LI>
 *     <LI>{@code <elem>}</LI>
 *    </UL>
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
public final class ConditionWriter extends AbstractRuleWriter {

	/**
	 * XMLリーダー
	 */
	XMLReader reader;
	/**
	 * SQLセッション
	 */
	SqlSession session;
	/**
	 * 属性項目情報マッパー
	 */
	AttributeFieldMapper mapper;
	/**
	 * データモデルID
	 */
	int dataModelID;

	/**
	 * オペランド変数出現フラグ
	 */
	private boolean isVar = false;


	/**
	 * コンストラクタ（{@code <condition>}タグ）。
	 * <P>
	 * 継承元クラスのコンストラクタ呼出し。
	 * </P>
	 * @param callerWriter 呼出し元ライター
	 * @param mapper 属性項目情報マッパー
	 */
	public ConditionWriter(
			ValueWiter callerWriter, AttributeFieldMapper mapper) {
		super(ElementType.CONDITION);
		this.mapper = mapper;
		dataModelID = callerWriter.getDataModelID();
	}

	/**
	 * コンストラクタ（{@code <condition>}タグ以外）。
	 * <OL>
	 *  <LI>継承元クラスのコンストラクタ呼出し。</LI>
	 *  <LI>呼出し元ライターのクラス変数引継ぎ。</LI>
	 * </OL>
	 * @param elementType 出力タグ種別
	 * @param callerWriter 呼出し元ライター
	 */
	private ConditionWriter(
			ConditionWriter callerWriter, ElementType elementType) {
		super(elementType, callerWriter);
		mapper = callerWriter.mapper;
		dataModelID = callerWriter.dataModelID;
		reader = callerWriter.reader;
		session = callerWriter.session;
	}

	/**
	 * 出力情報編集処理。
	 * <p>
	 * 条件文XML解析してXML出力モデルを構築する。
	 * </p>
	 * @param session DBセッション
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws SAXException XML解析エラー
	 * @throws IOException 入出力エラー
	 */
	public void init(SqlSession session)
	throws ParserConfigurationException, SAXException, IOException {

		this.session = session;

		// 条件文XML解析
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		reader = parser.getXMLReader();

		// コンテンツハンドラーセット
		reader.setContentHandler(this);

		// エラーハンドラーセット
		reader.setErrorHandler(this);

		// 条件文XML解析開始
		reader.parse(new InputSource(
				new StringReader(mapper.getConditionXml())));

	}

	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>対象タグが条件文の場合は、何も行わない。</LI>
	 *  <LI>対象タグが条件結果値の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>新規条件結果値ライターを生成する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成した条件結果値ライターを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>対象タグがオペランド変数文の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：オペランド変数出現フラグを、trueにする。</LI>
	 *    <LI>新規オペランド変数ライターを生成する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成したオペランド変数ライターを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>対象タグが上記の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>新規条件文ライターを生成する。</LI>
	 *    <LI>
	 *     対象タグが{@code <include>}、{@code <exclude>}の場合は以下の処理を行う。
	 *     業務例外が発生した場合は、SAX例外にラップして外部へthrowする。
	 *     <OL>
	 *      <LI>アトリビュート情報：上限値含むフラグを取得する。</LI>
	 *      <LI>アトリビュート情報：上限値含むフラグが取得できない場合は、業務例外を生成、throwする。</LI>
	 *      <LI>アトリビュート情報：上限値含むフラグを、生成した条件文ライターのアトリビュート情報に追加する。</LI>
	 *      <LI>アトリビュート情報：下限値含むフラグを取得する。</LI>
	 *      <LI>アトリビュート情報：下限値含むフラグが取得できない場合は、業務例外を生成、throwする。</LI>
	 *      <LI>アトリビュート情報：下限値含むフラグを、生成した条件文ライターのアトリビュート情報に追加する。</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>
	 *     対象タグが{@code <elem>}、{@code <single>}の場合は、
	 *生成した条件文ライターのタグ内容取得バッファを新規StringBuilderインスタンスで初期化する。
	 *    </LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成した条件文ライターを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 * @throws SAXException 業務例外
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case CONDITION:
			break;
		case RESULT:
			reader.setContentHandler(new ResultWriter(this));
			break;

		case VAR:
			isVar = true;
			reader.setContentHandler(new VarWriter(this));
			break;

		default:
			ConditionWriter writer = new ConditionWriter(this, elementType);

			switch (elementType) {
			case INCLUDE:
			case EXCLUDE:
				String flg = atts.getValue(AttributeType.UPPER_EQ.toString());

				try {
					if (flg == null || flg.length() <= 0) {
						throw new EMRException(MessageCode.EMR_B_P910E);
					}
					writer.addAttribute(AttributeType.UPPER_EQ, flg);

					flg = atts.getValue(AttributeType.LOWER_EQ.toString());

					if (flg == null || flg.length() <= 0) {
						throw new EMRException(MessageCode.EMR_B_P910E);
					}
					writer.addAttribute(AttributeType.LOWER_EQ, flg);
				} catch (EMRException e) {
					throw new SAXException(e);
				}
				break;

			case ELEM:
			case SINGLE:
				writer.buffer = new StringBuilder();
				break;
			}
			reader.setContentHandler(writer);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 * <UL>
	 *  <LI>関係演算子タグの場合は、オペランド変数出現フラグがfalseの場合、
	 *業務例外を生成、throwする。</LI>
	 *  <LI>単一値、集合要素タグの場合
	 *   <OL>
	 *    <LI>継承元クラス変数：タグ内容取得バッファが空の場合は、業務例外を生成、throwする。</LI>
	 *    <LI>継承元クラス変数：タグ内容取得バッファの内容を、
	 *継承元クラス変数：タグ内容に保持する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @throws EMRException 業務例外
	 */
	@Override
	void endElement() throws EMRException {

		switch (elementType) {
		case EQ:
		case NOT_EQ:
		case GT:
		case GEQ:
		case LT:
		case LEQ:
		case IN:
		case NOT_IN:
		case SUBSET:
		case NOT_SUBSET:
		case INTERSECT:
		case NOT_INTERSECT:
		case INCLUDE:
		case EXCLUDE:
		case START_SWITH:
		case NOT_START_SWITH:

			if (!isVar) {
				throw new EMRException(MessageCode.EMR_B_P910E);
			}
			break;

		case ELEM:
		case SINGLE:

			if (buffer.length() <= 0) {
				throw new EMRException(MessageCode.EMR_B_P910E);
			}
			value = buffer.toString();
			break;
		}
	}

}
