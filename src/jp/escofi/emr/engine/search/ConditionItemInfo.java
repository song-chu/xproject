package jp.escofi.emr.engine.search;

import java.util.List;

/**
 * 引数項目リストクラス。
 * <DL>
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
public class ConditionItemInfo {

	/**
	 * 引数項目名
	 */
	private final String ITEM_NAME;

	/**
	 * 引数項目データ型
	 */
	private final String ITEM_TYPE;
	/**
	 * 引数項目内部データ型
	 */
	private final String JAVA_DATA_TYPE;
	/**
	 * 引数項目取得情報
	 */
	private final List<String> SEARCH_INFO;

	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバー変数の値を設定することで、
	 * 外部からメンバー変数の値は変更できないようにする。（引数項目値除外）
	 *
	 * @param itemName			引数項目名
	 * @param itemType			引数項目データ型
	 * @param javaDataType		引数項目内部データ型
	 * @param searchInfo		引数項目取得情報
	 */
	public ConditionItemInfo(String itemName, String itemType, String javaDataType, List<String> searchInfo) {
		this.ITEM_NAME = itemName;
		this.ITEM_TYPE = itemType;
		this.JAVA_DATA_TYPE = javaDataType;
		this.SEARCH_INFO = searchInfo;
	}

	/**
	 * 引数項目名取得
	 * @return 引数項目名
	 */
	public final String getItemName() {
		return ITEM_NAME;
	}

	/**
	 * 引数項目データ型取得
	 * @return 引数項目データ型
	 */
	public String getItemType() {
		return ITEM_TYPE;
	}

	/**
	 * 引数項目内部データ型取得
	 * @return 引数項目内部データ型
	 */
	public String getJavaDataType() {
		return JAVA_DATA_TYPE;
	}

	/**
	 * 引数項目取得情報取得
	 * @return 引数項目取得情報
	 */
	public List<String> getSearchInfo() {
		return SEARCH_INFO;
	}
}
