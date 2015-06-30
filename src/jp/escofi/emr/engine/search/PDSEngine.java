package jp.escofi.emr.engine.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.Constants;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.constant.MessageType;
import jp.escofi.emr.engine.common.constant.Status;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.exception.DumpException;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.engine.common.util.PropertyUtil;
import jp.escofi.emr.engine.condition.Rule;
import jp.escofi.emr.engine.condition.RuleInstance;
import jp.escofi.emr.engine.loader.InitialLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/**
 * 解析エンジンクラス。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>
 *    <UL>
 *     <LI>オンメモリ化されたデータモデルを保持し、検索や条件判定を行うエンジン本体クラス。
 *     <LI>PDSオブジェクトとPDSオブジェクトキー項目は他クラスからのアクセスを制限するため、解析エンジンのメンバー変数として保持する。
 *     <LI>１回ロードされると使いまわせることやリソースの節約を考慮し、
 *         解析エンジンのインスタンスは、システム上１つのみ、イニシャルロードの際に生成する。（Singleton）
 *    </UL>
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
public class PDSEngine {

	/**
	 * ログ出力
	 */
	private static final Log LOGGER = LogFactory.getLog(PDSEngine.class);
	/**
	 * PDSオブジェクト
	 */
	private static HashMap<String, Object> pdsObjects;
	/**
	 * PDSオブジェクトキー項目
	 */
	private static HashMap<String, List<String>> pdsItemKeys;
	/**
	 * クラスがロードされる際、1個のインスタンスが生成される。
	 */
	private static PDSEngine instance;

	/**
	 * イニシャルロード済みフラグ：true（ロード済み）、false（未ロード）<br>
	 * <DL>
	 * <DT style='color: red'>注意事項：
	 * <DD style='color: red; font-weight: bold'>
	 * true（ロード済み）を設定するのは解析エンジンのみである。
	 * </DL>
	 *
	 */
	private static boolean isLoaded = false;

	/**
	 * インスタンス取得。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>クラスロード時、生成された有一のインスタンスを返す。
	 * </DL>
	 *
	 * @return 本クラスのインスタンス
	 * @throws InitializeException
	 *             イニシャルロード例外
	 */
	public static PDSEngine getInstance() throws InitializeException {
		if (instance == null) {
			instance = new PDSEngine();
		}
		return instance;
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>他クラスからのコンストラクタの生成を防ぐため、デフォルトコンストラクタをprivateにする。
	 * </DL>
	 *
	 * @throws InitializeException
	 *             イニシャルロード例外
	 */
	private PDSEngine() throws InitializeException {
		init();
	}

	/**
	 * 初期処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>イニシャルロードを行い、PDSオブジェクト、PDSオブジェクトキー項目にその結果を設定する。
	 * <LI>コンストラクタから呼出される。
	 * </UL>
	 * <DT style='color: red'>注意事項：
	 * <DD style='color: red; font-weight: bold'>
	 * イニシャルロード後、イニシャルロード済みフラグをtrueに設定する。
	 * </DL>
	 *
	 * @throws InitializeException
	 *             イニシャルロード例外。<br>
	 *             例外発生時にはアラート通知を行う。システムとして回復不能な例外であるため、RuntimeExceptionとして作成する。
	 */
	private void init() throws InitializeException {

		try {
			PropertyConfigurator.configure(PropertyUtil
					.getProperty("log4j.filepath"));

			LOGGER.info(MessageUtil.getMessage(MessageCode.EMR_A_P012I
					.toString()));

			InitialLoader loader = new InitialLoader();
			pdsObjects = loader.getPdsObject();
			pdsItemKeys = loader.getPdsItemKeys();
			isLoaded = true;

			LOGGER.info(MessageUtil.getMessage(MessageCode.EMR_A_P013I
					.toString()));

		} catch (EMRException e) {
			if (e.getCause() == null) {
				// 原因例外のトレース情報を出力
				throw new InitializeException(MessageCode.EMR_A_P009E, e);
			} else {
				// 原因例外のトレース情報は出力済みなので、エラーメッセージのみ
				throw new InitializeException(MessageCode.EMR_A_P009E);
			}
		} catch (Exception e) {
			// 原因例外のトレース情報を出力
			throw new InitializeException(MessageCode.EMR_A_P009E, e);
		}
	}

	/**
	 * 引数項目取得処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>渡された検索キーに基づき、データモデルを検索し、条件判定に必要な項目を取得し、返却する。
	 * <LI>重複検索を回避けるため、引数項目取得の際のみPDSオブジェクト（Map）検索を行う。
	 * </UL>
	 * <DT>使用方法：
	 * <DD>解析エンジンAPIクラスの引数項目取得メソッドを参照。
	 * </DL>
	 *
	 * @param keys
	 *            検索キー
	 * @return 属性値オブジェクト
	 * @throws UnExpectedStateException
	 *             予測不能状態例外
	 * @throws InvalidKeyException
	 *             キー不正例外
	 */
	protected PDSResponse getConditionItems(List<String> keys)
			throws UnExpectedStateException, InvalidKeyException {

		if (pdsObjects == null || pdsObjects.isEmpty() || pdsItemKeys == null
				|| pdsItemKeys.isEmpty()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P006E);
		}

		// パラメータがnull、或いは値が存在しない場合
		if (keys == null || keys.isEmpty()) {
			throw new InvalidKeyException(MessageCode.EMR_A_P011E,
					new Object[] { MessageType.KEY_LIST });
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("keys=" + keys);
		}

		PDSResponse conditionItems = new PDSResponse();

		// 検索キー順にデータモデルから属性値取得する。
		search(keys, conditionItems);
		return conditionItems;
	}

	/**
	 * 属性値オブジェクト取得処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>PDSオブジェクトから属性値オブジェクトを抽出するまでループ処理を行う。
	 * </DL>
	 *
	 * @param keys
	 *            検索キーリスト
	 * @param conditionItems
	 *            PDS応答クラス
	 * @throws UnExpectedStateException
	 *             予測不能状態例外
	 * @throws InvalidKeyException
	 *             キー不正例外
	 */
	@SuppressWarnings("unchecked")
	private void search(List<String> keys, PDSResponse conditionItems)
			throws InvalidKeyException, UnExpectedStateException {
		// 指定したインデックスに該当するキーを取得する。
		String key = null;
		String dataModelName = null;
		Object obj = null;
		Map<String, Object> map = null;
		int attributeKeyIndex = 0;

		for (int i = 0; i < keys.size(); i++) {
			key = keys.get(i);

			if (i == 0) {
				// 最初のキーはデータモデル名
				dataModelName = key;

				// １．引数についてチェックを行う。
				// データモデル名チェック
				checkDataModelName(dataModelName);

				// キー情報チェック
				checkKeyCount(dataModelName, keys);

				// 属性名キーのインデックス取得
				attributeKeyIndex = getAttributeKeyIndex(dataModelName);

				map = (Map<String, Object>) pdsObjects.get(dataModelName);
				continue;
			}

			// 属性名まではHashMap
			if (i <= attributeKeyIndex) {
				obj = map.get(key);
			} else {
				// 属性名以降はTreeMap
				// 「指定した値以下で最大のもの」を取り出す。
				SortedMap<String, Object> headMap = ((TreeMap<String, Object>) map)
						.headMap(key + "\0");

				if (headMap.isEmpty()) {
					// ステータス３（TreeMapキー該当なし）を返却する。
					conditionItems.setStatus(Status.TREEMAP_KEY_NOT_FOUND);
					break;
				} else {
					obj = map.get(headMap.lastKey());
				}
			}

			// Mapからなにも取得できなかった場合
			if (obj == null) {
				// キーが属性名である場合
				if (i == attributeKeyIndex) {
					// ステータス２（該当属性なし）を返却する。
					conditionItems.setStatus(Status.ATTR_NOT_FOUND);
					break;
				} else {
					// キーが属性名以前である場合、例外をスローする。
					throw new InvalidKeyException(MessageCode.EMR_A_P003E,
							new Object[] { keys });
				}
			} else {
				// Mapの場合
				if (obj instanceof Map) {
					// 取得したマップが空の場合
					Map<String, Object> tempMap = (Map<String, Object>) obj;
					if (tempMap.isEmpty()) {
						// ステータス２（該当属性なし）を返却する。
						conditionItems.setStatus(Status.ATTR_NOT_FOUND);
						break;
					}
					// 次の階層に検索し続ける。
					map = (Map<String, Object>) obj;
					continue;
				} else if (obj instanceof ResultObject) {
					// 属性値オブジェクトの場合
					setConditionItems((ResultObject) obj, conditionItems);
					break;
				} else {
					// Mapでも属性値オブジェクトでもない場合、想定外例外をスローする。
					throw new UnExpectedStateException(MessageCode.EMR_A_P010E);
				}
			}
		}

		// 結果オブジェクトが取得できず、ステータスが設定されてない場合
		if ((conditionItems.getResultObject() == null)
				&& (conditionItems.getStatus() == null)) {
			conditionItems.setStatus(Status.ATTR_NOT_FOUND);
		}
	}

	/**
	 * 属性名キーのインデックス取得処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>TreeMapは属性名キー以降に登場するため、TreeMapから値を取得する際には属性名キーのインデックスが必要になる。
	 * </UL>
	 * <DT style='color: red'>注意事項：
	 * <DD style='color: red; font-weight: bold'>
	 * データモデル名チェック処理を実施した後、呼び出すこと。
	 * </DL>
	 *
	 * @param dataModelName
	 *            データモデル名
	 * @return 属性名キーのインデックス
	 * @throws UnExpectedStateException
	 *             予期せぬエラー
	 */
	private int getAttributeKeyIndex(String dataModelName)
			throws UnExpectedStateException {

		List<String> itemKeys = pdsItemKeys.get(dataModelName);

		String keyName;
		int attributeKeyIndex = -1;

		for (int i = 0; i < itemKeys.size(); i++) {
			keyName = itemKeys.get(i);
			if (AttributeType.ATTR_NAME.isEquals(keyName)) {
				// インデックスに＋１する。0はデータモデル名で使用済み。
				attributeKeyIndex = i + 1;
				break;
			}
		}

		if (attributeKeyIndex == -1) {
			// キー項目に属性名が存在しない場合、想定外例外をスローする。
			throw new UnExpectedStateException(MessageCode.EMR_A_P014E,
					new Object[] { itemKeys });
		}

		return attributeKeyIndex;
	}

	/**
	 * 属性値取得処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>引数項目に基き、条件判定を行い、その結果を返却する
	 * </DL>
	 * <DT>使用方法：
	 * <DD>解析エンジンAPIクラスの属性値取得メソッドを参照する
	 *
	 * @param res
	 *            PDS応答クラス
	 * @return 条件判定結果
	 * @throws ConditionNotMatchedException
	 *             条件不成立例外
	 * @throws InvalidKeyException
	 *             キー不正例外
	 * @throws UnExpectedStateException
	 *             予測不能状態例外
	 */
	protected PDSResponse getAttrValue(PDSResponse res)
			throws ConditionNotMatchedException, InvalidKeyException,
			UnExpectedStateException {

		// パラメータのnullチェック
		if (res == null) {
			throw new InvalidKeyException(MessageCode.EMR_A_P011E,
					new Object[] { MessageType.RESPONSE });
		}

		// 属性値オブジェクトを取得
		ResultObject attrValue = res.getResultObject();

		if (attrValue == null) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P010E);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("ResultObject=" + attrValue.toString());
		}

		// 属性値オブジェクトから結果値オブジェクトを取得
		Object obj = attrValue.getValue();

		// 属性値オブジェクトが条件文の場合
		if (obj instanceof Rule) {
			// 条件判定を行う。
			try {
				attrValue = ((Rule) obj).apply(res
						.getConditionItemValueMap());
			} catch (RuntimeException e) {
				// 条件判定処理中、予期せぬ実行時例外（RuntimeException）が発生した場合
				throw new UnExpectedStateException(MessageCode.EMR_A_P010E, e);
			}
			res.setResultObject(attrValue);
		}

		return res;
	}

	/**
	 * 結果値設定処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>結果値をPDS応答クラスに格納する
	 * </DL>
	 *
	 * @param resultObject
	 *            属性値オブジェクト
	 * @param conditionItems
	 *            PDS応答クラス
	 */
	private void setConditionItems(ResultObject resultObject,
			PDSResponse conditionItems) {

		// 属性値が削除されている場合
		if (resultObject.isDeleted()) {
			// ステータス：削除済を設定
			conditionItems.setStatus(Status.DELETED);
		} else {
			// ステータス：正常を設定
			conditionItems.setStatus(Status.NORMAL);
		}

		conditionItems.setResultObject(resultObject);

		Object obj = resultObject.getValue();

		if (obj instanceof Rule) {
			conditionItems.setConditionItemInfoMap(((RuleInstance) obj)
					.getConditionItemMap());
			conditionItems.setConditionFlag(true);
		}

		conditionItems.setMetaInfo(resultObject.getMetaInfo());
	}

	/**
	 * データモデル名チェック処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>引数のデータモデル名でPDSオブジェクト（Map）やPDSオブジェクトキー項目（Map）の
	 * 第一要素のキーを検索し、一致するキーがあるかを確認する。
	 * <LI>存在しない場合は後続処理を実施せず、業務例外をスローする
	 * </UL>
	 * </DL>
	 *
	 * @param dataModelName
	 *            データモデル名
	 * @throws InvalidKeyException
	 *             キー不正例外
	 */
	private void checkDataModelName(final String dataModelName)
			throws InvalidKeyException {

		boolean rtn = (pdsObjects.containsKey(dataModelName) && pdsItemKeys
				.containsKey(dataModelName));

		if (!rtn) {
			throw new InvalidKeyException(MessageCode.EMR_A_P001E,
					new String[] { dataModelName });
		}
	}

	/**
	 * キー項目数チェック処理。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>PDSオブジェクトキー項目（MAP）から引数のデータモデル名に該当するキー項目（LIST）を抽出し、<BR>
	 * 引数のキー情報とキー項目数が一致することを確認する。
	 * <LI>一致しない場合は後続処理を実施せず、業務例外をスローする。
	 * </UL>
	 * </DL>
	 *
	 * @param dataModelName
	 *            データモデル名
	 * @param keys
	 *            キー情報
	 * @throws InvalidKeyException
	 *             キー不正例外
	 */
	private void checkKeyCount(final String dataModelName,
			final List<String> keys) throws InvalidKeyException {

		List<String> keyList = pdsItemKeys.get(dataModelName);
		boolean rtn = (keyList.size() == (keys.size() - 1));

		if (!rtn) {
			throw new InvalidKeyException(MessageCode.EMR_A_P002E,
					new Object[] { keys, keyList });
		}
	}

	/**
	 * イニシャルロード済みフラグの取得処理
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>イニシャルロード済みフラグを返却する。
	 * </UL>
	 * </DL>
	 *
	 * @return true イニシャルロード済み、false イニシャルロード未実施
	 */
	protected static boolean isLoaded() {
		return isLoaded;
	}

	/**
	 * ダンプ実行。
	 *<DL>
	 * <DT>使用目的/機能概要：
	 * <DD>
	 * <UL>
	 * <LI>引数のデータモデル名でPDSオブジェクト（Map）の第一要素のキーを検索し、一致するキーがあるかを確認する。
	 * <LI>存在しない場合は後続処理を実施せず、業務例外をスローする
	 * </UL>
	 * </DL>
	 *
	 * @param filePath
	 *            ファイルパス
	 * @param dataModelName
	 *            データモデル名
	 * @throws InvalidKeyException
	 *             キー不正例外
	 * @throws DumpException
	 *             ダンプ例外
	 */
	protected void excuteDump(String filePath, String dataModelName)
			throws InvalidKeyException, DumpException {
		if (!dataModelName.equals(Constants.DATA_MODEL_ALL)
				&& pdsObjects.get(dataModelName) == null) {
			throw new InvalidKeyException(MessageCode.EMR_A_P015E,
					new Object[] { dataModelName });
		}
		try {
			ObjectWriter.excuteDump(filePath, dataModelName, pdsObjects,
					pdsItemKeys);
		} catch (Exception e) {
			throw new DumpException(MessageCode.EMR_A_P016E, e);
		}
	}
}
