package jp.iwin.pds.xml2db.engine;

import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTStatus;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;

/**
 * PDS応答クラス。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>
 *    <UL>
 *     <LI>条件判定に必要な引数項目の取得情報や引数項目値、検索結果ステータス、属性値を保持するクラス。
 *     <LI>APIが提供する引数項目取得メソッドの戻り値及属性値取得メソッドの引数クラスとして汎用的に利用する。
 *    </UL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1053 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:57:40 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.engine.PENEngine
 * @see jp.iwin.pds.engine.PENServiceAPI
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PENResponse {

	/**
	 * 検索結果ステータス
	 */
	private PCTStatus status;
	/**
	 * 引数項目取得用マップ（エンジンから設定）
	 */
	private Map<String, PROConditionItemInfo> conditionItemInfoMap;
	/**
	 * 条件判定用の引数項目値マップ（業務ラッパーが設定）
	 */
	private Map<String, Object> conditionItemValueMap;
	/**
	 * 属性値オブジェクト
	 */
	private PROResultObject resultObject;
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
	protected PENResponse() {}

	/**
	 * 引数項目取得用マップ取得。
	 * <DL>
	 *	 <DT>使用目的/機能概要：
	 *	  <DD>引数項目取得用マップを取得する。
	 * </DL>
	 * @return 引数項目取得用マップ
	 */
	public Map<String, PROConditionItemInfo> getConditionItemInfoMap() {
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
	protected void setConditionItemInfoMap(Map<String, PROConditionItemInfo> conditionItemInfoMap) {
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
	public PCTStatus getStatus() {
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
	protected void setStatus(PCTStatus status) {
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
	public PROResultObject getResultObject() {
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
	protected void setResultObject(PROResultObject resultObject) {
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
