package jp.escofi.emr.engine.common.constant;

/**
 * 属性タイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>値の属性タイプ定義enumクラス。
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
public enum DataType {
	/**
	 * 範囲
	 */
	RANGE("range"),
	/**
	 * オブジェクト
	 */
	OBJECT("object"),
	/**
	 * 単一
	 */
	SINGLE("single"),
	/**
	 * リスト
	 */
	LIST("list"),
	/**
	 * マップ
	 */
	MAP("map"),
	/**
	 * セット
	 */
	SET("set"),
	/**
	 * その他
	 */
	OTHER("");

	/**
	 * 対応させる値の属性タイプ
	 */
	private String value;

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>コンストラクタクラス。
	 * </DL>
	 * @param value 対応させる値の属性タイプ
	 */
	private DataType(String value) {
		this.value = value;
	}

	/**
	 * 属性タイプ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>値の属性タイプを取得する。
	 *   <DD>定義外の値の属性タイプが指定された場合は、{@link #OTHER}を返却する。
	 * </DL>
	 * @param value 値の属性タイプ
	 * @return 値の属性タイプに対応した属性タイプ
	 */
	public static DataType getType(String value) {

		for (DataType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		return OTHER;
	}

	/**
	 * 値の属性タイプ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>対応する値の属性タイプの文字列表現を返す。
	 * </DL>
	 * @return 値の属性タイプの文字列表現
	 */
	@Override
	public String toString() {
		return value;
	}


}
