package jp.iwin.pds.xml2db.common.exception;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;

/**
 * 予測不能状態例外。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデルがNULLなど、システム上予測不能な状態を表す検査例外クラス。
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
@SuppressWarnings("serial")
public class PEXUnExpectedStateException extends PEXException {

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>親クラスのコンストラクターを呼び出し、引数を渡す。
	 * </DL>
	 * @param errCode エラーコード
	 */
	public PEXUnExpectedStateException(PCTMessageCode errCode) {
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
	public PEXUnExpectedStateException(PCTMessageCode errCode,
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
	public PEXUnExpectedStateException(PCTMessageCode errCode, Throwable cause) {
		super(errCode, cause);
	}
}
