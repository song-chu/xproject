package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;
import jp.escofi.emr.transformer.sql.ValueMapper;


/**
 * 条件結果値ライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>条件結果値（{@code <result>}）以下の要素を出力するXMLライター。
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
public final class ResultWriter extends AbstractRuleWriter {

	/**
	 * 結果番号
	 */
	private int anserNo;


	/**
	 * コンストラクタ。
	 * <OL>
	 *  <LI>継承元クラスのコンストラクタ呼出し。</LI>
	 *  <LI>継承元クラス変数：タグ内容取得バッファを初期化する。</LI>
	 * </OL>
	 * @param callerWriter 呼出し元ライター
	 */
	ResultWriter(ConditionWriter callerWriter) {
		super(ElementType.RESULT, callerWriter);
		buffer = new StringBuilder();
	}


	/**
	 * @return 継承元クラス変数：呼出し元ライターの属性項目ID
	 */
	public int getAttFieldID() {
		return callerWriter.mapper.getAttFieldID();
	}
	/**
	 * @return 結果番号
	 */
	public int getAnserNo() {
		return anserNo;
	}


	/**
	 * タグ終了処理。
	 * <OL>
	 *    <LI>継承元クラス変数：タグ内容取得バッファが空の場合は、業務例外を生成、throwする。</LI>
	 *    <LI>継承元クラス変数：タグ内容取得バッファの内容を、
	 *継承元クラス変数：タグ内容に保持する。</LI>
	 *  <LI>属性値ライターを取得する。</LI>
	 *  <LI>取得した属性値ライターがオブジェクト型ライター以外は、
	 *アトリビュート情報:javadatatypeを設定する。</LI>
	 *  <LI>属性値ライターの削除フラグ判定
	 *   <OL>
	 *    <LI>削除フラグがtrueの場合は、継承元クラス変数：子タグセットに、ダミー属性値ライターを格納する。</LI>
	 *    <LI>上記以外の場合は、継承元クラス変数：子タグセットに、取得した属性値ライターを格納する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>アトリビュート情報を編集する。</LI>
	 * </OL>
	 */
	@Override
	void endElement() throws EMRException {

		if (buffer.length() <= 0) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		value = buffer.toString();

		AttributeFieldMapper mapper = callerWriter.mapper;
		DataType dataType = mapper.getDataType();
		AbstractAttributeValueWriter child = getChildElement(dataType);

		// オブジェクト型以外はアトリビュート情報:javadatatypeを設定する。
		if (DataType.OBJECT != dataType) {
			child.setJavaDataType(mapper.getJavaDataType());
		}

		// 削除フラグ判定
		boolean isDelFlg = child.isDelFlg();

		if (isDelFlg) {
			childSet.add(EmptyWriter.getInstance());
		} else {
			childSet.add(child);
		}

		// アトリビュート情報編集
		addAttribute(AttributeType.META_INFO, child.getMetaInfo());
		addAttribute(AttributeType.DATA_TYPE, dataType.toString());
		addAttribute(AttributeType.DEL_FLG, String.valueOf(isDelFlg));
	}

	/**
	 * 属性値ライター取得。
	 * <OL>
	 *  <LI>継承元クラス変数：タグ内容取得バッファの内容(問合せ番号)を数値として取得する。</LI>
	 *  <LI>引数：データ型に応じた属性値ライター取得メソッドを呼び出す。</LI>
	 *  <LI>属性値ライターが取得出来なかった、または複数取得した場合は、
	 *業務例外を生成、throwする。</LI>
	 *  <LI>属性値ライターが取得出来た場合は、取得した属性値ライターを戻す。</LI>
	 * </OL>
	 * @param dataType データ型
	 * @return 属性値ライター
	 * @throws EMRException 業務例外<BR>
	 * - 属性値ライターが取得できなかった場合<BR>
	 * - 属性値ライターが複数件取得された場合
	 */
	private AbstractAttributeValueWriter getChildElement(DataType dataType) throws EMRException {
		ValueMapper mapper = callerWriter.session.getMapper(ValueMapper.class);
		List<? extends AbstractAttributeValueWriter> recList = null;

		anserNo = Integer.parseInt(value);

		switch (dataType) {
		case LIST:
			recList = mapper.selectListAnserNo(this);
			break;

		case MAP:
			recList = mapper.selectMapAnserNo(this);
			break;

		case OBJECT:
			recList = mapper.selectObjectAnserNo(this);
			break;

		case RANGE:
			recList = mapper.selectRangeAnserNo(this);
			break;

		case SINGLE:
			recList = mapper.selectSingleAnserNo(this);
			break;
		}

		if (recList.isEmpty() || 1 < recList.size()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}

		return recList.get(0);
	}

}
