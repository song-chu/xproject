package jp.escofi.emr.engine.loader;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.OperandVar;
import jp.escofi.emr.engine.search.ConditionItemInfo;


/**
 * 条件式変数ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件式の変数（{@code <var>}）要素を制御するSAXのイベントハンドラー。
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
public final class VarHandler extends AbstractRuleHandler {

	/**
	 * データ型
	 */
	private String dataType;
	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType;
	/**
	 * 引数項目取得情報
	 */
	private List<String> varInfo;
	/**
	 * タグ内容取得バッファ
	 */
	private StringBuilder buffer = new StringBuilder();


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param dataType データ型
	 * @param javaDataType 内部Javaデータ型
	 * @param varInfo 引数項目取得情報
	 */
	public VarHandler(SingleConditionHandler callerHandler, String dataType,
			String javaDataType, List<String> varInfo) {

		super(callerHandler);

		this.dataType = dataType;
		this.javaDataType = javaDataType;
		this.varInfo = varInfo;
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
	 * 対象タグが条件式変数の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>業務ラッパー返却用引数項目情報を作る。</LI>
	 * <LI>取得したタグ内容を文字列化する。</LI>
	 * <LI>取得したタグ内容が、グローバルの引数項目情報マップに含まれる場合、
	 *グローバルの引数項目情報マップから引数項目情報を取得する。</LI>
	 * <LI>取得したタグ内容が、グローバルの引数項目情報マップに含まれない場合、
	 *引数項目情報を生成し、グローバルの引数項目情報マップへ格納する。</LI>
	 * <LI>取得した引数項目情報を、継承元クラス変数：引数項目情報マップへ格納する。</LI>
	 * <LI>取得したタグ内容から、条件式変数オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに生成した条件式変数オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：データ型を設定する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：内部Javaデータ型を設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.VAR.toString().equals(qName)) {
			// 業務ラッパー返却用引数項目情報を作る。
			String name = buffer.toString().intern();
			ConditionItemInfo conditionItemInfo;

			//グローバルの引数項目情報Mapにあるか否か判断
			if (globalConditionItemMap.containsKey(name)) {
				//ある場合は参照をアサイン
				conditionItemInfo = globalConditionItemMap.get(name);
			} else {
				//無い場合は生成しグローバルにセット
				conditionItemInfo = new ConditionItemInfo(name,
					dataType, javaDataType, varInfo);
				globalConditionItemMap.put(name, conditionItemInfo);
			}
			conditionItemMap.put(name, conditionItemInfo);

			// 演算子（SingleCondition）にデータタイプをセットする。後constオブジェクトにセットされる。
			SingleConditionHandler handler = (SingleConditionHandler) callerHandler;
			OperandVar itemVar = new OperandVar(name);

			handler.addConditionItem(dataType, itemVar);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			buffer = null;
		}
	}
}
