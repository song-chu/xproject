package jp.escofi.emr.engine.common.exception;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 業務例外。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>PDSシステムで返却する例外クラスの親クラス。検査例外。<BR>
 *       例外の具体的な原因を識別するため、エラーコード。エラーメッセージを保持する。
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
public class EMRException extends Exception {
	/**
	 * SERIALVERSIONUID
	 */
	private static final long serialVersionUID = 6376274209054407785L;
	/**
	 * ログ出力
	 */
	private static final Log LOGGER = LogFactory.getLog(EMRException.class);
	/**
	 * エラーコード
	 */
	private MessageCode errCode;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;

	/**
	 * エラーコード取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>エラーコードを返す。
	 * </DL>
	 * @return the errCode
	 */
	public MessageCode getErrCode() {
		return errCode;
	}

	/**
	 * エラーメッセージ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>エラーメッセージを返す。
	 * </DL>
	 * @return the errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 *   <BR>エラー内容をログに出力する。
	 *   <BR>エラーコードのみ指定する場合（固定のメッセージを利用する場合）。
	 * </DL>
	 * @param errCode エラーコード
	 */
	public EMRException(MessageCode errCode) {

		super(MessageUtil.getMessage(errCode.toString()));

		this.errCode = errCode;
		errMessage = getMessage();

		outErrMessage();
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 *   <BR>エラー内容をログに出力する。
	 *   <BR>例外発生時のエラーメッセージを独自のものにする場合。
	 * </DL>
	 * @param errCode エラーコード
	 * @param arguments 置換文字列の配列
	 */
	public EMRException(MessageCode errCode, Object[] arguments) {

		super(MessageUtil.getMessage(errCode.toString(), arguments));

		this.errCode = errCode;
		errMessage = getMessage();

		outErrMessage();
	}

	/**
	 * コンストラクタ(原因例外付き)。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 *   <BR>エラー内容をログに出力する。
	 *   <BR>例外発生時のエラーメッセージを独自のものにする場合、かつ原因例外のトレース情報を出力する際に利用。
	 * </DL>
	 * @param errCode エラーコード
	 * @param arguments 置換文字列の配列
	 * @param cause 原因例外
	 */
	public EMRException(MessageCode errCode, Object[] arguments, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		errMessage = MessageUtil.getMessage(errCode.toString(), arguments);

		LOGGER.error(errMessage, cause);
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数として原因例外が作成したメッセージを渡す。
	 *   <BR>エラー内容をログに出力する。
	 *   <BR>原因例外のトレース情報を出力する際に利用。
	 * </DL>
	 * @param errCode エラーコード
	 * @param cause 原因例外
	 */
	public EMRException(MessageCode errCode, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		errMessage = MessageUtil.getMessage(errCode.toString());

		LOGGER.error(errCode.toString(), cause);
	}


	/**
	 * エラーメッセージ出力。
	 * <p>
	 * ログへ発生したエラーについてのメッセージを出力する。
	 * </P>
	 */
	private void outErrMessage() {
		StringBuilder sb = new StringBuilder("エラーコード：");

		sb.append(errCode);
		sb.append("、エラーメッセージ：");
		sb.append(errMessage);

		LOGGER.error(sb.toString());
	}

}
