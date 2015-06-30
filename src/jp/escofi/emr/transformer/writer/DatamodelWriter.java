package jp.escofi.emr.transformer.writer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;
import jp.escofi.emr.transformer.sql.AttributeGroupMapper;
import jp.escofi.emr.transformer.sql.KeyitemMapper;
import jp.escofi.emr.transformer.sql.ResultObjectMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;


/**
 * データモデルライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>データモデル({@code <datamodel>})以下の要素を出力するXMLライター。
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
public final class DatamodelWriter extends AbstractXmlWriter {

	/**
	 * データモデルID
	 */
	private int dataModelID;
	/**
	 * FROMキー項目有無フラグ
	 */
	private boolean fromKeyFlg = false;
	/**
	 * FROMキー項目英語名
	 */
	private String fromKeyEnName;
	/**
	 * FROMキー項目初期値
	 */
	private String fromKeyDefValue;
	/**
	 * 継承元データモデルフラグ
	 */
	private boolean parentDmFlg = false;
	/**
	 * 案件番号
	 */
	private String productCd;
	/**
	 * 属性グループID
	 */
	private int attGroupID = 0;
	/**
	 * 継承元データモデル名（英語）
	 */
	private String extendsDm = null;


	/**
	 * コンストラクタ。
	 * <UL>
	 *  <LI>XMLタグ名を初期化する。</LI>
	 *  <LI>クラス変数：FROMキー項目有無フラグにfalseを設定する。</LI>
	 *  <LI>クラス変数：継承元データモデルフラグにfalseを設定する。</LI>
	 * </UL>
	 */
	public DatamodelWriter() {
		super(ElementType.DATA_MODEL);
	}


	/**
	 * @param dataModelID データモデルID
	 */
	public void setDataModelID(int dataModelID) {
		this.dataModelID = dataModelID;
	}
	/**
	 * アトリビュート情報にデータモデル名（英語）を設定。
	 * @param name データモデル名（英語）
	 */
	public void setName(String name) {
		setAttribute(AttributeType.NAME, name);
	}
	/**
	 * アトリビュート情報にXMLファイル名を設定。
	 * @param file XMLファイル名
	 */
	public void setFile(String file) {
		setAttribute(AttributeType.FILE, file);
	}
	/**
	 * 継承元データモデル名（英語）を設定。
	 * <P>
	 * パラメータがnull、空文字列以外の場合のみ、継承元データモデル名（英語）を設定する。
	 * </P>
	 * @param extendsDm 継承元データモデル名（英語）
	 */
	public void setExtendsDm(String extendsDm) {

		if (extendsDm != null && 0 < extendsDm.length()) {
			this.extendsDm = extendsDm;
		}
	}
	/**
	 * @param fromKeyFlg FROMキー項目有無フラグ：0：なし、1：あり
	 */
	public void setFromKeyFlg(String fromKeyFlg) {
		this.fromKeyFlg = PDSConstants.TRUE.isEquals(fromKeyFlg);
	}
	/**
	 * @param fromKeyEnName FROMキー項目英語名
	 */
	public void setFromKeyEnName(String fromKeyEnName) {
		this.fromKeyEnName = fromKeyEnName;
	}
	/**
	 * @param fromKeyDefValue FROMキー項目初期値
	 */
	public void setFromKeyDefValue(String fromKeyDefValue) {
		this.fromKeyDefValue = fromKeyDefValue;
	}

	/**
	 * @return データモデルID
	 */
	public int getDataModelID() {
		return dataModelID;
	}
	/**
	 * @return 案件CD
	 */
	public String getProductCd() {
		return productCd;
	}
	/**
	 * @return 属性グループID
	 */
	public int getAttGroupID() {
		return attGroupID;
	}


	/**
	 * @param parentDmFlg 継承元データモデルフラグ
	 */
	void setParentDmFlg(boolean parentDmFlg) {
		this.parentDmFlg = parentDmFlg;
	}
	/**
	 * @return 継承元データモデル名（英語）
	 */
	String getExtendsDm() {
		return extendsDm;
	}

	/**
	 * 出力情報編集処理(XML管理情報)。
	 * <OL>
	 *  <LI>クラス変数：案件番号に、引数：案件番号を保持する。</LI>
	 *  <LI>属性グループ情報を取得する。</LI>
	 *  <LI>属性グループ情報から、キー項目ライターリストを取得する。</LI>
	 *  <LI>キー項目ライターリストの項目の内、キー項目名がある物のみ、
	 *継承元クラス変数：子タグセットに追加する。</LI>
	 *  <LI>キー項目ライターを生成し、キー項目名に「attrName」を設定して、
	 *継承元クラス変数：子タグセットに追加する。</LI>
	 *  <LI>クラス変数：FROMキー項目有無フラグがtrueの場合、キー項目ライターを生成し、
	 *キー項目名にクラス変数：FROMキー項目英語名を設定して、
	 *継承元クラス変数：子タグセットに追加する。</LI>
	 * </OL>
	 * @param session DBセッション
	 * @param productCd 案件番号
	 */
	void init(SqlSession session, String productCd) {
		this.productCd = productCd;

		KeyitemMapper dbMapper = session.getMapper(KeyitemMapper.class);
		List<AttributeGroupMapper> gList = dbMapper.selectAttGroup(this);

		if (!gList.isEmpty()) {
			AttributeGroupMapper mapper = gList.get(0);
			List<KeyitemWriter> kList = mapper.getKeyItemList();

			for (KeyitemWriter writer : kList) {
				String name = writer.getName();

				if (name != null && 0 < name.length()) {
					childSet.add(writer);
				}
			}
		}
		KeyitemWriter writer = new KeyitemWriter();

		writer.setName(AttributeType.ATTR_NAME.toString());
		childSet.add(writer);

		if (fromKeyFlg) {
			writer = new KeyitemWriter();
			writer.setName(fromKeyEnName);
			childSet.add(writer);
		}
	}

	/**
	 * XML管理ファイル出力処理。
	 * <OL>
	 * <LI>アトリビュート情報編集処理
	 *  <OL>
	 *   <LI>継承元フラグ</LI>
	 *   <LI>クラス変数：FROMキー項目有無フラグがtrueの場合、初期値を出力する。</LI>
	 *  </OL>
	 * </LI>
	 * <LI>タグ開始部分出力処理</LI>
	 * <LI>タグ内容部分出力処理</LI>
	 * <LI>タグ終了部分出力処理</LI>
	 * </OL>
	 * @param writer XMLライター
	 * @throws SAXException XML出力例外
	 */
	@Override
	void write(XMLWriter writer) throws SAXException {

		addAttribute(AttributeType.PARENT_FLG, String.valueOf(parentDmFlg));
		addAttribute(AttributeType.EXTENDS_DM, extendsDm);

		if (fromKeyFlg) {
			addAttribute(AttributeType.INIT_VALUE, fromKeyDefValue);
		}
		startElement(writer);

		for (AbstractXmlWriter child : childSet) {
			child.write(writer);
		}
		endElement(writer);
	}

	/**
	 * データモデルファイル出力処理。
	 * <OL>
	 *  <LI>名前以外のアトリビュートを削除する。</LI>
	 *  <LI>データモデル出力用モデル構築処理</LI>
	 *  <LI>タグ開始部分出力処理</LI>
	 *  <LI>タグ内容部分出力処理</LI>
	 *  <LI>タグ終了部分出力処理</LI>
	 * </OL>
	 * @param writer XMLライター
	 * @param session DBセッション
	 * @throws SAXException XML出力例外
	 * @throws IOException ファイル入出力例外
	 * @throws ParserConfigurationException XML解析設定例外
	 * @throws EMRException 業務例外
	 */
	void writeDataModel(XMLWriter writer, SqlSession session)
	throws SAXException, IOException, ParserConfigurationException, EMRException {

		removeAttribute(AttributeType.FILE);
		removeAttribute(AttributeType.PARENT_FLG);
		removeAttribute(AttributeType.EXTENDS_DM);
		removeAttribute(AttributeType.INIT_VALUE);

		initDataModel(session);

		startElement(writer);

		for (AbstractXmlWriter child : childSet) {
			child.write(writer);
		}
		endElement(writer);
	}

	/**
	 * 出力情報編集処理(データモデル)。
	 * <OL>
	 *  <LI>キー項目情報を取得する。</LI>
	 *  <LI>継承元クラス変数：子タグ(キー項目)セットをクリアする。</LI>
	 *  <LI>変数：親タグライターの子タグセットに、
	 *継承元クラス変数：子タグ(キー項目)セットを設定する。</LI>
	 *  <LI>変数：インデックスを 0で初期化する。</LI>
	 *  <LI>取得したキー項目情報数分ループ
	 *   <OL>
	 *    <LI>キー項目情報の属性グループIDを変数：属性グループIDに保持する。</LI>
	 *    <LI>クラス変数：属性グループIDと変数：属性グループIDが一致しない場合、以下の処理を実施する。
	 *     <OL>
	 *      <LI>変数：インデックスが 0以上の場合は、attrName以下の出力内容編集を呼出す。</LI>
	 *      <LI>変数：親タグライターの子タグセットに、
	 *継承元クラス変数：子タグ(キー項目)セットを設定する。</LI>
	 *      <LI>クラス変数：属性グループIDに、変数：属性グループIDを保持する。</LI>
	 *      <LI>変数：インデックスを 0で初期化する。</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>変数：キー項目名に、キー項目情報のキー項目名を保持する。</LI>
	 *    <LI>変数：キー項目名がnull、または空文字の場合はcontinueする。</LI>
	 *    <LI>変数：番号に、キー項目情報のインデックスを保持する。</LI>
	 *    <LI>変数：インデックスと変数：番号が一致しない場合は、変数：インデックスに、
	 *変数：番号を保持する。</LI>
	 *    <LI>上記以外の場合は、業務例外を生成・throwする。</LI>
	 *    <LI>変数：親タグライターの子タグセットに、子タグセット取得処理の結果を保持する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>attrName以下の出力内容編集処理</LI>
	 * </OL>
	 * @param session DBセッション
	 * @throws ParserConfigurationException XML解析設定例外
	 * @throws SAXException XML出力例外
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException 業務例外
	 */
	private void initDataModel(SqlSession session)
	throws ParserConfigurationException, SAXException, IOException, EMRException {
		KeyitemMapper dbMapper = session.getMapper(KeyitemMapper.class);
		List<KeyitemWriter> kList = dbMapper.selectKeyItem(this);

		childSet.clear();

		Set<AbstractXmlWriter> parentSet = childSet;
		int index = 0;

		for (KeyitemWriter writer : kList) {
			int attGroupID = writer.getAttGroupID();

			if (this.attGroupID != attGroupID) {

				if (0 < index) {
					initChildSet(session, parentSet);
				}
				parentSet = childSet;
				this.attGroupID = attGroupID;
				index = 0;
			}
			String name = writer.getName();

			if (name == null || name.length() <= 0) {
				continue;
			}
			int i = writer.getIndex();

			if (i != index) {
				index = i;
			} else {
				throw new EMRException(MessageCode.EMR_B_P910E);
			}
			parentSet = getChildSet(writer, parentSet);
		}
		initChildSet(session, parentSet);
	}

	/**
	 * 子タグセット取得処理。
	 * <UL>
	 *  <LI>引数：親タグライターの子タグセットに、
	 *引数：キー項目ライターと同じ名前のキー項目ライターがある場合は、
	 *そのキー項目ライターの子タグセットを返す。</LI>
	 *  <LI>引数：親タグライターの子タグセットに、
	 *引数：キー項目ライターと同じ名前のキー項目ライターが無い場合は、
	 *以下の処理を行う。
	 *   <OL>
	 *    <LI>引数：キー項目ライターのデータモデル出力フラグをtrueに設定する。</LI>
	 *    <LI>引数：親タグライターの子タグセットに、
	 *引数：キー項目ライターを格納する。</LI>
	 *    <LI>引数：キー項目ライターの子タグセットを返す。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param writer キー項目ライター
	 * @param parentSet 親タグライターの子タグセット
	 * @return 子タグセット
	 */
	private Set<AbstractXmlWriter> getChildSet(KeyitemWriter writer, Set<AbstractXmlWriter> parentSet) {

		for (AbstractXmlWriter w : parentSet) {
			KeyitemWriter k = (KeyitemWriter) w;

			if (k.equals(writer)) {
				return k.childSet;
			}
		}
		writer.setDataModelWrite(true);
		parentSet.add(writer);

		return writer.childSet;
	}

	/**
	 * attrName以下の出力内容編集。
	 * <OL>
	 *  <LI>変数：サイズに、引数：子タグ情報格納セットのサイズを保持する。</LI>
	 *  <LI>属性項目情報を抽出する。</LI>
	 *  <LI>FROMキー項目有無フラグがtrueの場合
	 *   <OL>
	 *    <LI>変数：attrNameタグ編集マップを新規LinkedHashMapで初期化する。</LI>
	 *    <LI>取得した属性項目情報数分ループ
	 *     <OL>
	 *      <LI>属性項目情報の削除フラグがtrueの場合は、continueする。</LI>
	 *      <LI>属性項目情報から属性項目名を取得する。</LI>
	 *      <LI>変数：attrNameタグ編集マップから、
	 *属性項目名をキーにattrNameタグ取得する。</LI>
	 *      <LI>取得できなかった場合は、以下の処理を行う。
	 *       <OL>
	 *        <LI>attrNameタグを生成する。</LI>
	 *        <LI>変数：attrNameタグ編集マップに、
	 *属性項目名をキーとして、生成したattrNameタグを格納する。</LI>
	 *       </OL>
	 *      </LI>
	 *      <LI>fromkeyキータグ生成する。</LI>
	 *      <LI>valueタグ生成する。</LI>
	 *      <LI>fromkeyタグの子タグセットにvalueタグを追加する。</LI>
	 *      <LI>attrNameタグの子タグセットにfromkeyタグを追加する。</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>引数：子タグ情報格納セットに、
	 *変数：attrNameタグ編集マップの値を全て追加する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>上記以外の場合、取得した属性項目情報数分ループ
	 *   <OL>
	 *    <LI>属性項目情報の削除フラグがtrueの場合は、continueする。</LI>
	 *    <LI>attrNameタグを生成する。</LI>
	 *    <LI>valueタグ生成する。</LI>
	 *    <LI>attrNameタグの子タグセットにvalueタグを追加する。</LI>
	 *    <LI>引数：子タグ情報格納セットにattrNameタグを追加する。</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * <P>
	 * なお、attrName等が複数出力される場合のソートは、SQL抽出時で行われている。<BR>
	 * 並び順は、attrNameのキー項目値(、fromkeyキー項目値)の昇順となる。
	 * </P>
	 * @param session DBセッション
	 * @param parentSet 子タグ情報格納セット
	 * @return 編集後の子タグ情報格納セット
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws SAXException XML出力例外
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException データモデル出力処理例外
	 */
	private Set<AbstractXmlWriter> initChildSet(SqlSession session, Set<AbstractXmlWriter> parentSet)
	throws ParserConfigurationException, SAXException, IOException, EMRException {
		ResultObjectMapper dbMapper = session.getMapper(ResultObjectMapper.class);
		List<AttributeFieldMapper> list = dbMapper.select(this);

		if (fromKeyFlg) {
			Map<String, KeyitemWriter> attrMap =
				new LinkedHashMap<String, KeyitemWriter>();

			for (AttributeFieldMapper mapper : list) {

				if (mapper.isDelFlg()) {
					continue;
				}
				String key = mapper.getName();
				KeyitemWriter attrName = attrMap.get(key);

				if (attrName == null) {
					attrName = createAttrName(mapper);
					attrMap.put(key, attrName);
				}
				KeyitemWriter fromKey = createFromKey(mapper);
				ValueWiter value = createValue(session, mapper);

				fromKey.childSet.add(value);
				attrName.childSet.add(fromKey);
			}
			parentSet.addAll(attrMap.values());
		} else {

			for (AttributeFieldMapper mapper : list) {

				if (mapper.isDelFlg()) {
					continue;
				}
				KeyitemWriter attrName = createAttrName(mapper);
				ValueWiter value = createValue(session, mapper);

				attrName.childSet.add(value);
				parentSet.add(attrName);
			}
		}

		return parentSet;
	}

	/**
	 * attrNameタグ生成。
	 *
	 * @param mapper 属性項目情報マッパー
	 * @return attrNameタグ
	 */
	private KeyitemWriter createAttrName(AttributeFieldMapper mapper) {
		KeyitemWriter kWriter = new KeyitemWriter();

		kWriter.setDataModelWrite(true);
		kWriter.setName(AttributeType.ATTR_NAME.toString());
		kWriter.setKey(mapper.getName());
		kWriter.setJpName(mapper.getJpName());

		return kWriter;
	}

	/**
	 * fromkeyタグ生成。
	 *
	 * @param mapper 属性項目情報マッパー
	 * @return fromkeyタグ
	 */
	private KeyitemWriter createFromKey(AttributeFieldMapper mapper) {
		KeyitemWriter fromKey = new KeyitemWriter();

		fromKey.setDataModelWrite(true);
		fromKey.setName(fromKeyEnName);
		fromKey.setKey(mapper.getFromKeyValue());

		return fromKey;
	}

	/**
	 * valueタグ生成。
	 *
	 * @param session DBセッション
	 * @param mapper 属性項目情報マッパー
	 * @return valueタグ生成
	 * @throws ParserConfigurationException XML解析設定例外
	 * @throws SAXException XML出力例外
	 * @throws IOException ファイル入出力例外
	 * @throws EMRException 業務例外
	 */
	private ValueWiter createValue(SqlSession session, AttributeFieldMapper mapper)
	throws ParserConfigurationException, SAXException, IOException, EMRException {
		ValueWiter value = new ValueWiter(dataModelID);

		value.init(session, mapper);

		return value;
	}

}
