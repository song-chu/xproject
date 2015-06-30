package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.exception.EMRException;

import org.xml.sax.SAXException;


/**
 * 親条件文XMLライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>条件文XMLタグ出力処理の共通部分を定義する。（抽象クラス）
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
abstract class AbstractRuleWriter extends AbstractXmlWriter {

	/**
	 * 呼出し元ライター
	 */
	ConditionWriter callerWriter = null;
	/**
	 * タグ内容取得バッファ
	 */
	StringBuilder buffer = null;


	/**
	 * コンストラクタ({@code <condition>}タグ)。
	 * <OL>
	 *  <LI>継承元クラスのコンストラクタ呼出し。</LI>
	 * </OL>
	 * @param elementType 出力タグ種別
	 */
	AbstractRuleWriter(ElementType elementType) {
		super(elementType);
	}

	/**
	 * コンストラクタ({@code <condition>}タグ以外)。
	 * <OL>
	 *  <LI>継承元クラスのコンストラクタ呼出し。</LI>
	 *  <LI>呼出し元ライターの子タグセットに自身を追加。</LI>
	 *  <LI>呼出し元ライターをクラス変数に保持。</LI>
	 * </OL>
	 * @param elementType 出力タグ種別
	 * @param callerWriter 呼出し元ライター
	 */
	AbstractRuleWriter(ElementType elementType, ConditionWriter callerWriter) {
		super(elementType);
		callerWriter.childSet.add(this);
		this.callerWriter = callerWriter;
	}


	/**
	 * タグ内容処理。
	 * <P>
	 * 取得したタグ内容文字列をクラス変数：タグ内容取得バッファへ格納する。
	 * </P>
	 * @param ch 取得したタグ内容
	 * @param start 開始位置
	 * @param length 対象文字列長
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (buffer != null) {
			buffer.append(ch, start, length);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 参照中のタグ名が継承元クラス変数：出力タグ種別と一致する場合は、以下の処理を実施する。
	 * </P>
	 * <OL>
	 *  <LI>クラス変数：タグ内容取得バッファがnull以外の場合は、継承先クラスのタグ終了処理呼出し。</LI>
	 *  <LI>上記の処理で業務例外がthrowされた場合は、業務例外をSAX例外にラップしてthrowする。</LI>
	 *  <LI>クラス変数：呼出し元ライターがnull以外の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：呼出し元ライターのXMLリーダーのコンテンツハンドラーをクラス変数：呼出し元ライターへ切替える。</LI>
	 *    <LI>クラス変数：呼出し元ライターにnullを入れる。</LI>
	 *   </OL>
	 *  <LI>クラス変数：タグ内容取得バッファにnullを入れる。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @throws SAXException 継承先クラスのタグ終了処理で発生した業務例外
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (elementType.equals(qName)) {

			try {
				endElement();
			} catch (EMRException e) {
				throw new SAXException(e);
			}

			if (callerWriter != null) {
				callerWriter.reader.setContentHandler(callerWriter);
				callerWriter = null;
			}
			buffer = null;
		}
	}


	/**
	 * 継承先クラスのタグ終了処理。
	 *
	 * @throws EMRException 業務例外
	 */
	abstract void endElement() throws EMRException;

}
