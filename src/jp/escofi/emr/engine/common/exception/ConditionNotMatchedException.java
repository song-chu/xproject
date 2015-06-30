package jp.escofi.emr.engine.common.exception;

import jp.escofi.emr.engine.common.constant.MessageCode;

/**
 * 条件不成立例外。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件判定結果による成立する条件が無い場合、発生させる検査例外クラス。
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
@SuppressWarnings("serial")
public class ConditionNotMatchedException extends EMRException {

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 * </DL>
	 * @param errCode エラーコード
	 */
	public ConditionNotMatchedException(MessageCode errCode) {
		super(errCode);
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 * </DL>
	 * @param errCode エラーコード
	 * @param arguments 置換文字列の配列
	 */
	public ConditionNotMatchedException(MessageCode errCode,
			Object[] arguments) {
		super(errCode, arguments);
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 * </DL>
	 * @param errCode エラーコード
	 * @param cause 原因例外
	 */
	public ConditionNotMatchedException(MessageCode errCode,
			Throwable cause) {
		super(errCode, cause);
	}
}
