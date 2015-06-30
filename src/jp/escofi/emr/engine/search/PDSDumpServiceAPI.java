package jp.escofi.emr.engine.search;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;

/**
 * ダンプAPIクラス。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>サーブレットなどのクライアントAPから呼び出されるダンプ実行メソッドを提供するAPIクラス。
 *  <DT>サンプルコード：
 *   <DD>クライアントからの呼出し例
 *    <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'><TT>
 *    String filePath = "/pdsngine/dumpxml";
 *    String dataModelName = "provision";
 *
 *   try {
 *        //ダンプ実行メソッドを呼び出す。
 *        PDSDumpServiceAPI.excuteDump(filePath,dataModelName);
 *
 *    } catch (UnExpectedStateException e) {
 *        // 例外処理（省略）
 *    } catch (InvalidKeyException e) {
 *        // 例外処理（省略）
 *    } catch (InitializeException e) {
 *        // 例外処理（省略）
 *    } catch (DumpException e) {
 *        // 例外処理（省略）
 *    }
 *   </TT></PRE>
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

public class PDSDumpServiceAPI {

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>他クラスからのコンストラクタの生成を防ぐため、デフォルトコンストラクタをprivateにする。
	 * </DL>
	 */
	private PDSDumpServiceAPI() {
	}

	/**
	 * ダンプ実行。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>XML出力先とデータモデル名を解析エンジンへ渡し、解析エンジンのダンプ実行メソッドを呼び出す。<BR>
	 *    <UL>
	 *     <LI>XML出力先指定無しの場合、プロパティから取得
	 *     <LI>データモデル名を「all」に指定する場合、全データモデルを対象にする。
	 *    </UL>
	 *  <DT>使用方法：
	 *   <DD>クラスJavaDocのサンプルコードを参照
	 *  <DT style='color: red'>注意事項：
	 *   <DD style='color: red; font-weight: bold'>
	 *    呼出し側は引数のファイルパスをフルパスで渡すこと。
	 * </DL>
	 *
	 * @param filePath ファイルパス
	 * @param dataModelName データモデル名
	 * @throws UnExpectedStateException 予測不能状態例外
	 * @throws InitializeException イニシャルロード例外
	 * @throws InvalidKeyException キー不正例外
	 * @throws DumpException ダンプ例外
	 */
	public static void excuteDump(String filePath, String dataModelName)
			throws UnExpectedStateException, InitializeException,
			InvalidKeyException, DumpException {
		if (dataModelName==null){
			throw new InvalidKeyException(MessageCode.EMR_A_P015E, new Object[] {dataModelName});
		}
		if (!PDSEngine.isLoaded()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P008E);
		}
		PDSEngine.getInstance().excuteDump(filePath, dataModelName);
	}
}
