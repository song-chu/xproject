package jp.escofi.emr.engine.search;

import java.util.Map;

import jp.escofi.emr.engine.common.constant.Status;

/**
 * PDS応答クラス。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>
 *    <UL>
 *     <LI>条件判定に必要な引数項目の取得情報や引数項目値、検索結果ステータス、属性値を保持するクラス。
 *     <LI>APIが提供する引数項目取得メソッドの戻り値及属性値取得メソッドの引数クラスとして汎用的に利用する。
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
public class PDSResponse {

	/**
	 * 検索結果ステータス
	 */
	private Status status;
	/**
	 * 引数項目取得用マップ（エンジンから設定）
	 */
	private Map<String, ConditionItemInfo> conditionItemInfoMap;
	/**
	 * 条件判定用の引数項目値マップ（業務ラッパーが設定）
	 */
	private Map<String, Object> conditionItemValueMap;
	/**
	 * 属性値オブジェクト
	 */
	private ResultObject resultObject;
	/**
	 * 条件有無フラグ
	 */
	private boolean conditionFlag;
	/**
	 * メタ情報
	 */
	private String metaInfo;

	 /**
	  * コンストラクタ。
	  * <DL>
	  *	 <DT>使用目的/機能概要：
	  *	  <DD>エンジン外部からインスタンス生成を制限するためprotectedを設定する。
	  * </DL>
	  */
	protected PDSResponse() {}

	/**
	 * 引数項目取得用マップ取得。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>引数項目取得用マップを取得する。
	 * </DL>
	 * @return 引数項目取得用マップ
	 */
	public Map<String, ConditionItemInfo> getConditionItemInfoMap() {
		return conditionItemInfoMap;
	}

	/**
	 * 引数項目取得用マップを設定。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>エンジン外部からのアクセスを制限するためprotectedを設定する。
	 * </DL>
	 * @param conditionItemInfoMap 条件判定用引数項目マップ
	 */
	protected void setConditionItemInfoMap(Map<String, ConditionItemInfo> conditionItemInfoMap) {
		this.conditionItemInfoMap = conditionItemInfoMap;
	}

	/**
	 * 条件判定用引数項目マップ取得。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>条件判定用引数項目マップを取得する。
	 * </DL>
	 * @return 条件判定用引数項目マップ
	 */
	public Map<String, Object> getConditionItemValueMap() {
		return conditionItemValueMap;
	}

	/**
	 * 条件判定用引数項目マップを設定。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>条件判定用引数項目マップを設定する。
	 * </DL>
	 * @param conditionItemValueMap 条件判定用引数項目マップ
	 */
	public void setConditionItemValueMap(Map<String, Object>conditionItemValueMap) {
		this.conditionItemValueMap = conditionItemValueMap;
	}

	/**
	 * 検索結果ステータス取得。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>検索結果ステータスを取得する。
	 * </DL>
	 * @return 検索結果ステータス
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * 検索結果ステータスを設定。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>エンジン外部からのアクセスを制限するためprotectedを設定する。
	 * </DL>
	 * @param status 検索結果ステータス
	 */
	protected void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 属性値オブジェクト取得。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>属性値オブジェクトを取得する。
	 * </DL>
	 * @return 属性値オブジェクト
	 */
	public ResultObject getResultObject() {
		return resultObject;
	}

	/**
	 * 属性値オブジェクトを設定。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>エンジン外部からのアクセスを制限するためprotectedを設定する。
	 * </DL>
	 * @param resultObject 属性値オブジェクト
	 */
	protected void setResultObject(ResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * 条件有無フラグ返却。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>条件有無フラグを返却する。
	 * </DL>
	 * @return 条件有無フラグ
	 */
	public boolean isCondition() {
		return conditionFlag;
	}

	/**
	 * 条件有無フラグを設定。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>エンジン外部からのアクセスを制限するためprotectedを設定する。
	 * </DL>
	 * @param conditionFlag 条件有無フラグ
	 */
	protected void setConditionFlag(boolean conditionFlag) {
		this.conditionFlag = conditionFlag;
	}

	/**
	 * メタ情報設定。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>メタ情報を設定する。エンジン外部からのアクセスを制限するためprotectedを設定する。
	 * </DL>
	 * @param metaInfo メタ情報
	 */
	protected void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
	}

	/**
	 * メタ情報取得。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>メタ情報を取得する。
	 * </DL>
	 * @return メタ情報
	 */
	public String getMetaInfo() {
		return metaInfo;
	}
}
