package jp.iwin.pds.xml2db.datamodel;

import java.util.List;

/**
 * 引数項目リストクラス。
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1104 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 15:13:14 +0900 (07 12 2010) $
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
 * @author $Author: park.js $
 */
public class PROConditionItemInfo {

	/**
	 * 引数項目名
	 */
	private final String itemName;

	/**
	 * 引数項目データ型
	 */
	private final String itemType;
	/**
	 * 引数項目内部データ型
	 */
	private final String javaDataType;
	/**
	 * 引数項目取得情報
	 */
	private final List<String> searchInfo;
	/**
	 * 引数項目日本語名
	 */
	private final String jpname;



	/**
	 * コンストラクタ<br>
	 * コンストラクタからメンバー変数の値を設定することで、
	 * 外部からメンバー変数の値は変更できないようにする。（引数項目値除外）
	 *
	 * @param itemType		引数項目データ型
	 * @param javaDataType		引数項目内部データ型
	 * @param searchInfo	引数項目取得情報
	 */
	public PROConditionItemInfo(String itemName, String itemType, String javaDataType, List<String> searchInfo,String jpname) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.javaDataType = javaDataType;
		this.searchInfo = searchInfo;
		this.jpname = jpname;
	}

	/**
	 * 引数項目名取得
	 * @return itemName	引数項目名
	 */
	public final String getItemName() {
		return itemName;
	}

	/**
	 * 引数項目データ型取得
	 * @return 引数項目データ型
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * 引数項目内部データ型取得
	 * @return 引数項目内部データ型
	 */
	public String getJavaDataType() {
		return javaDataType;
	}

	/**
	 * 引数項目取得情報取得
	 * @return 引数項目取得情報
	 */
	public List<String> getSearchInfo() {
		return searchInfo;
	}

	/**
	 * 引数項目日本語名取得
	 * @return
	 */
	public String getJpname() {
		return jpname;
	}
}
