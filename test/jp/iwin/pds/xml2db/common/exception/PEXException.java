package jp.iwin.pds.xml2db.common.exception;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.util.PUTMessageUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 業務例外。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>PDSシステムで返却する例外クラスの親クラス。検査例外。<BR>
 *       例外の具体的な原因を識別するため、エラーコード。エラーメッセージを保持する。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1038 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:23:29 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PEXException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6376274209054407785L;
	/**
	 * ログ出力
	 */
	private static final Log logger = LogFactory.getLog(PEXException.class);
	/**
	 * エラーコード
	 */
	private PCTMessageCode errCode;
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
	public PCTMessageCode getErrCode() {
		return this.errCode;
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
		return this.errMessage;
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
	public PEXException(PCTMessageCode errCode) {

		super(PUTMessageUtil.getMessage(errCode.toString()));

		this.errCode = errCode;
		this.errMessage = PUTMessageUtil.getMessage(errCode.toString());

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
	public PEXException(PCTMessageCode errCode, Object[] arguments) {

		super(PUTMessageUtil.getMessage(errCode.toString(), arguments));

		this.errCode = errCode;
		this.errMessage = getMessage();

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
	public PEXException(PCTMessageCode errCode, Object[] arguments, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		this.errMessage = PUTMessageUtil.getMessage(errCode.toString(), arguments);

		logger.error(this.errMessage, cause);
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
	public PEXException(PCTMessageCode errCode, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		this.errMessage = cause.getMessage();

		logger.error(errCode.toString(), cause);
	}


	/**
	 * エラーメッセージ出力。
	 * <p>
	 * ログへ発生したエラーについてのメッセージを出力する。
	 * </P>
	 */
	private void outErrMessage() {
		StringBuilder sb = new StringBuilder("エラーコード：");

		sb.append(this.errCode);
		sb.append("、エラーメッセージ：");
		sb.append(this.errMessage);

		logger.error(sb.toString());
	}

}
