package jp.escofi.emr.engine.loader;

import java.util.Set;

import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.OperandConst;

import org.xml.sax.Attributes;


/**
 * 条件式定数ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件式の定数（{@code <const>}）要素を制御するSAXのイベントハンドラー。
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
public final class ConstHandler extends AbstractRuleHandler {

	/**
	 * データ型
	 */
	private String dataType;
	/**
	 * 変換前属性値（単一値）
	 */
	private String strValue;
	/**
	 * 変換前属性値（セット）
	 */
	private Set<String> strSetValue;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 */
	public ConstHandler(SingleConditionHandler callerHandler) {
		super(callerHandler);
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * 継承元クラス変数：XMLリーダーに、エレメントタイプに応じたルールハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		// エレメントタイプ取得
		ElementType elementType = ElementType.getType(qName);
		// ルールハンドラー取得
		AbstractRuleHandler handler = RuleHandlerFactory.createRuleHandler(elementType, this);

		reader.setContentHandler(handler);
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件式定数の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>引数項目定数部オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに生成した引数項目定数部オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.CONST.toString().equals(qName)) {
			SingleConditionHandler handler = (SingleConditionHandler) callerHandler;
			OperandConst itemConst = null;

			switch (DataType.getType(dataType)) {
			case SINGLE:
				itemConst = new OperandConst(strValue);
				break;
			case SET:
				itemConst = new OperandConst(strSetValue);
				break;
			}
			handler.addConditionItem(dataType, itemConst);
			reader.setContentHandler(handler);
		}
	}


	/**
	 * @param dataType データ型
	 */
	void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * @param value 属性値
	 */
	void setStrValue(String value) {
		strValue = value;
	}
	/**
	 * @param value 属性値
	 */
	void setStrSetValue(Set<String> value) {
		strSetValue = value;
	}

}
