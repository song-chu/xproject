package jp.escofi.emr.engine.loader;

import org.xml.sax.Attributes;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.AbstractAction;
import jp.escofi.emr.engine.condition.InitRule;
import jp.escofi.emr.engine.search.ResultObject;


/**
 * 条件式結果ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件判定結果{@code <result>}の要素を処理するSAXイベントハンドラー。
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
public final class ResultHandler extends AbstractResultObjectHandler {

	/**
	 * ルールオブジェクト
	 */
	private InitRule rule;
	/**
	 * 条件式タイプ
	 */
	private IFType ifType;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param rule ルールオブジェクト
	 * @param ifType 条件式タイプ
	 * @param atts アトリビュート情報
	 */
	public ResultHandler(AbstractDelegateHandler callerHandler, InitRule rule,
			IFType ifType, Attributes atts) {

		super(callerHandler, atts);

		this.rule = rule;
		this.ifType = ifType;
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 条件式結果タグ修了時は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>結果オブジェクトを生成する。</LI>
	 * <LI>クラス変数：条件式結果タイプがTHENの場合は、クラス変数：ルールオブジェクトのTHEN結果に、
	 *生成した結果オブジェクトを設定する。</LI>
	 * <LI>上記以外の場合は、クラス変数：ルールオブジェクトのTHEN結果に、
	 *生成した結果オブジェクトを設定する。</LI>
	 * <LI>XMLリーダーのハンドラーを呼出し元ハンドラーに戻す。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.RESULT.toString().equals(qName)) {
			ResultObject resultObject = getResultObject();
			AbstractAction action = new AbstractAction(resultObject);

			if (IFType.IF_THEN == ifType) {
				rule.setThenAction(action);
			} else {
				rule.setElseAction(action);
			}
			reader.setContentHandler(callerHandler);
		}
	}
}
