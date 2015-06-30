package jp.escofi.emr.transformer.writer;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;
import jp.escofi.emr.transformer.sql.ValueMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;


/**
 * 属性値ライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>属性値（{@code <value>}）以下の要素を出力するXMLライター。
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
public final class ValueWiter extends AbstractXmlWriter {

	/**
	 * データモデルID
	 */
	private int dataModelID;


	/**
	 * コンストラクタでXMLタグ名を初期化する。
	 *
	 * @param dataModelID データモデルID
	 */
	ValueWiter(int dataModelID) {
		super(ElementType.VALUE);
		this.dataModelID = dataModelID;
	}


	/**
	 * @return データモデルID
	 */
	public int getDataModelID() {
		return dataModelID;
	}


	/**
	 * 出力情報編集処理。
	 * <OL>
	 *  <LI>引数：属性項目情報マッパーの条件有無フラグがtrueの場合
	 *   <OL>
	 *    <LI>条件文ライターを生成する。</LI>
	 *    <LI>条件文ライターを初期化する。</LI>
	 *    <LI>子タグセットに生成した条件文ライターを追加する。</LI>
	 *    <LI>アトリビュート情報のメタ情報に空文字を設定する。</LI>
	 *    <LI>アトリビュート情報の削除フラグにfalseを設定する。</LI>
	 *   </OL>
	 *  <LI>上記以外の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>属性値ライターを取得する。</LI>
	 *    <LI>取得した属性値ライターがオブジェクト型ライター以外は、
	 *アトリビュート情報:javadatatypeを設定する。</LI>
	 *    <LI>属性値ライターの削除フラグがtrueの場合は、継承元クラス変数：子タグセットに、
	 *ダミー属性値ライターを格納する。</LI>
	 *    <LI>上記以外の場合は、継承元クラス変数：子タグセットに、取得した属性値ライターを格納する。</LI>
	 *    <LI>アトリビュート情報を編集する。</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * @param session DBセッション
	 * @param mapper 属性項目情報マッパー
	 * @throws ParserConfigurationException XML解析設定エラー
	 * @throws SAXException XML解析エラー
	 * @throws IOException 入出力エラー
	 * @throws EMRException データモデル出力処理例外
	 */
	void init(SqlSession session, AttributeFieldMapper mapper)
	throws ParserConfigurationException, SAXException, IOException, EMRException {

		// 条件文フラグ
		boolean isConditionFlg = mapper.isConditionFlg();
		boolean isDelFlg = false;
		String metaInfo = PDSConstants.EMPTY.toString();

		if (isConditionFlg) {
			// 条件文あり
			ConditionWriter child = new ConditionWriter(this, mapper);

			child.init(session);
			childSet.add(child);
		} else {
			// 条件文なし
			DataType dataType = mapper.getDataType();
			AbstractAttributeValueWriter child = getChildElement(
					session, dataType, mapper.getAttFieldID());

			// オブジェクト型以外はアトリビュート情報:javadatatypeを設定する。
			if (DataType.OBJECT != dataType) {
				child.setJavaDataType(mapper.getJavaDataType());
			}
			metaInfo = child.getMetaInfo();

			// 属性値の削除フラグ判定
			isDelFlg = child.isDelFlg();

			if (isDelFlg) {
				childSet.add(EmptyWriter.getInstance());
			} else {
				childSet.add(child);
			}
		}
		addAttribute(AttributeType.COND_FLG, String.valueOf(isConditionFlg));
		addAttribute(AttributeType.META_INFO, metaInfo);
		addAttribute(AttributeType.DATA_TYPE, mapper.getDataType().toString());
		addAttribute(AttributeType.DEL_FLG, String.valueOf(isDelFlg));
	}


	/**
	 * 属性値ライター取得。
	 * <OL>
	 *  <LI>引数：データ型に応じた属性値ライター取得メソッドを呼び出す。</LI>
	 *  <LI>属性値ライターが取得出来なかった、または取得した件数が1より多い場合は、
	 *業務例外を生成、throwする。</LI>
	 *  <LI>取得した属性値ライターの結果番号が 0以外の場合は、業務例外を生成、throwする。</LI>
	 *  <LI>取得した属性値ライターを戻す。</LI>
	 * </OL>
	 * @param session DBセッション
	 * @param dataType データ型
	 * @param attFieldID 属性項目ID
	 * @return 属性値ライター
	 * @throws EMRException データモデル出力処理例外<BR>
	 * - 属性値ライターが複数件取得された場合<BR>
	 * - 取得した属性値ライターの結果番号が、0以外の場合
	 */
	private AbstractAttributeValueWriter getChildElement(
			SqlSession session, DataType dataType, int attFieldID) throws EMRException {
		ValueMapper dbMapper = session.getMapper(ValueMapper.class);
		List<? extends AbstractAttributeValueWriter> recList = null;

		switch (dataType) {
		case LIST:
			recList = dbMapper.selectListAttFieldID(attFieldID);
			break;

		case MAP:
			recList = dbMapper.selectMapAttFieldID(attFieldID);
			break;

		case OBJECT:
			recList = dbMapper.selectObjectAttFieldID(attFieldID);
			break;

		case RANGE:
			recList = dbMapper.selectRangeAttFieldID(attFieldID);
			break;

		case SINGLE:
			recList = dbMapper.selectSingleAttFieldID(attFieldID);
			break;
		}

		if (recList.isEmpty() || 1 < recList.size()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		AbstractAttributeValueWriter writer = recList.get(0);

		if (0 != writer.getAnserNo()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		return writer;
	}

}
