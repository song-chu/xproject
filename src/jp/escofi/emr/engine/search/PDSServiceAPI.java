package jp.escofi.emr.engine.search;

import java.util.List;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;

/**
 * 解析エンジンAPIクラス。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>業務ラッパからの問合せ要求に対応するメソッドを提供するAPIクラス。
 *  <DT>サンプルコード：
 *   <DD>業務ラッパーからの呼出し例
 *    <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'><TT>
 *    // キー情報をリストに追加する。必ず、キー順序とおりに追加すること。
 *    List&lt;String&gt; keys = new ArrayList&lt;String&gt;();
 *
 *    keys.add("データモデル名");
 *    keys.add("検索キー１");
 *    keys.add("検索キー２");
 *
 *    try {
 *        // 引数項目取得メソッドを呼出す。
 *        PDSResponse res = PDSServiceAPI.getConditionItems(keys);
 *
 *        // 取得した結果が条件文オブジェクトではない場合
 *        if (!res.isCondition()) {
 *            // 検索結果ステータスが正常ではない場合
 *            if (res.getStatus() != Status.NORMAL) {
 *                // ステータスに該当する処理（省略）
 *            }
 *        } else {
 *            // 取得した結果が条件文オブジェクトである場合
 *              // 条件判定用引数項目マップ取得し、値を設定する。
 *              Map&lt;String, ConditionItemInfo&gt; conditionItemInfoMap = res.getConditionItemInfoMap();
 *            Map&lt;String, Object&gt; conditionItemValueMap = new  HashMap&lt;String, Object&gt;();
 *
 *            String itemName           = null;    // 引数項目名
 *              String itemType           = null;    // 引数項目データ型
 *              String javaDataType       = null;    // 引数項目内部データ型
 *              List<String> searchInfo           = null;    // 引数項目取得情報
 *              Object value              = null;    // 引数項目値
 *
 *              Collection<ConditionItemInfo> collection = conditionItemInfoMap.values();
 *
 *            for(ConditionItemInfo conditionItemInfo: collection) {
 *
 *                // 引数項目クラスから情報を取得する。
 *                   itemName     = conditionItemInfo.getItemName();
 *                itemType     = conditionItemInfo.getItemType();
 *                javaDataType = conditionItemInfo.getJavaDataType();
 *                searchInfo   = conditionItemInfo.getSearchInfo();
 *
 *                // 引数項目取得情報に基づき、引数項目を取得後、
 *                   // 引数項目データ型、引数項目内部データ型に合わせて型変換し、引数項目値に代入する。
 *                  // (省略)
 *
 *                  // 引数項目値マップに設定
 *                  conditionItemValueMap.put(itemName, value);
 *            }
 *
 *            // PDS応答クラスに引数項目値マップを設定
 *              res.setConditionItemValueMap(conditionItemValueMap);
 *
 *            // 属性値取得メソッドを呼び出す。
 *              res = PDSServiceAPI.getAttrValue(res);
 *        }
 *        // 属性値オブジェクトを取得し、結果値オブジェクトに格納する。
 *          ResultObject ro = res.getResultObject();
 *         Object obj = ro.getValue();
 *
 *        // データ型を確認し、属性値取得処理を行う。
 *        if (obj instanceof RangeObject) {
 *            // 省略
 *        } else if (obj instanceof bjObject) {
 *            // 省略
 *        } else {
 *            // 省略
 *        }
 *    } catch (UnExpectedStateException e) {
 *        // 例外処理（省略）
 *    } catch (InvalidKeyException e) {
 *        // 例外処理（省略）
 *    } catch (ConditionNotMatchedException e) {
 *        // 例外処理（省略）
 *    }
 *   </TT></E>
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
public class PDSServiceAPI {

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>他クラスからのコンストラクタの生成を防ぐため、デフォルトコンストラクタをprivateにする。
	 * </DL>
	 */
	private PDSServiceAPI() {
	}

	/**
	 * 引数項目取得処理。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>引数の検索キー情報を解析エンジンへ渡し、解析エンジンの引数項目取得メソッドを呼び出す。<BR>
	 *       その結果、返却されるPDS応答クラスを業務ラッパーに返却する。
	 *  <DT>使用方法：
	 *   <DD>クラスJavaDocのサンプルコードを参照
	 *  <DT style='color: red'>注意事項：
	 *   <DD style='color: red; font-weight: bold'>
	 *    呼出し側は引数のキー情報をPDSオブジェクト（Map）データ格納順にソートして渡すこと。
	 * </DL>
	 *
	 * @param keys 検索キー情報
	 * @return PDS応答クラス
	 * @throws UnExpectedStateException 予測不能状態例外
	 * @throws InvalidKeyException キー不正例外
	 * @throws InitializeException イニシャルロード例外
	 */
	public static PDSResponse getConditionItems(List<String> keys)
			throws UnExpectedStateException, InvalidKeyException, InitializeException {

		// イニシャルロードされていない場合
		if (!PDSEngine.isLoaded()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P008E);
		}
		return PDSEngine.getInstance().getConditionItems(keys);
	}

	/**
	 * 属性値取得処理。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>
	 *    <UL>引数のPDS応答クラスを解析エンジンへ渡し、解析エンジンの属性値取得メソッドを呼出す。<BR>
	 *        その結果、返却されるPDS応答クラスを業務ラッパーに返却する。
	 *    </UL>
	 *  <DT>使用方法：
	 *   <DD>クラスJavaDocのサンプルコードを参照
	 *  <DT>前提事項：
	 *   <DD>条件判定に必要な引数項目値が業務ラッパーにより引数のPDS応答クラスに設定されていること。
	 *  <DT style='color: red'>注意事項：
	 *   <DD style='color: red; font-weight: bold'>
	 *    業務ラッパーは引数項目取得処理を行った後、当メソッドを呼出すこと。
	 * </DL>
	 * @param res PDS応答クラス（条件判定前）
	 * @return PDS応答クラス（条件判定後）
	 * @throws InvalidKeyException キー不正例外
	 * @throws ConditionNotMatchedException 条件不成立例外
	 * @throws InitializeException イニシャルロード例外
	 * @throws UnExpectedStateException 予測不能状態例外
	 */
	public static PDSResponse getAttrValue(PDSResponse res)
			throws InvalidKeyException, ConditionNotMatchedException, InitializeException, UnExpectedStateException {

		// イニシャルロードされていない場合
		if (!PDSEngine.isLoaded()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P008E);
		}

		return PDSEngine.getInstance().getAttrValue(res);
	}

}
