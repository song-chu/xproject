package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * 属性値ハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値ハンドラー郡のハンドラー生成メソッドを定義したファクトリークラス。
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
public final class ResultObjectHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private ResultObjectHandlerFactory() {}


	/**
	 * 属性値ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @return 属性値ハンドラーの新規インスタンス
	 */
	public static ValueHandler createValueHandler(
			KeyItemHandler callerHandler, Attributes atts) {

		return new ValueHandler(callerHandler, atts);
	}

	/**
	 * 条件式結果ハンドラー生成処理。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @param rule ルールオブジェクト
	 * @param ifType 条件式タイプ
	 * @return 条件式結果ハンドラーの新規インスタンス
	 */
	public static ResultHandler createResultHandler(AbstractRuleHandler callerHandler,
			Attributes atts, InitRule rule, IFType ifType) {

		return new ResultHandler(callerHandler, rule, ifType, atts);
	}
}
