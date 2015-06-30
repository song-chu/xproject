package jp.escofi.emr.engine.common.constant;

import jp.escofi.emr.engine.common.exception.EMRException;

/**
 * エレメントタイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>エレメントのタイプを定義するenumクラス。
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
public enum ElementType {
	/**
	 * XML管理
	 */
	DATA_MODEL_INFO("datamodelinfo"),
	/**
	 * データモデル
	 */
	DATA_MODEL("datamodel"),
	/**
	 * キー項目
	 */
	KEY_ITEM("keyitem"),
	/**
	 * 属性名
	 */
	ATTR_NAME("attrname"),
	/**
	 * 属性値
	 */
	VALUE("value"),
	/**
	 * 条件式結果
	 */
	RESULT("result"),
	/**
	 * リスト型
	 */
	LIST("list"),
	/**
	 * マップ型
	 */
	MAP("map"),
	/**
	 * 範囲型
	 */
	RANGE("range"),
	/**
	 * オブジェクト型
	 */
	OBJECT("object"),
	/**
	 * 単一型
	 */
	SINGLE("single"),
	/**
	 * エレメント
	 */
	ELEM("elem"),
	/**
	 * エントリー
	 */
	ENTRY("entry"),
	/**
	 * IF文
	 */
	IF("if"),
	/**
	 * ELSE文
	 */
	ELSE("else"),
	/**
	 * 条件文
	 */
	CONDITION("condition"),
	/**
	 * 上限値
	 */
	UPPER("upper"),
	/**
	 * 下限値
	 */
	LOWER("lower"),
	/**
	 * セット
	 */
	SET("set"),
	/**
	 * 条件式定数
	 */
	CONST("const"),
	/**
	 * 条件式変数
	 */
	VAR("var"),
	/**
	 * 条件式アプライ
	 */
	APPLY("apply"),
	/**
	 * 論理演算子AND
	 */
	AND("and"),
	/**
	 * 論理演算子OR
	 */
	OR("or"),
	/**
	 * 関係演算子EQ
	 */
	EQ("eq"),
	/**
	 * 関係演算子NOTEQ
	 */
	NOT_EQ("neq"),
	/**
	 * 関係演算子LT
	 */
	LT("lt"),
	/**
	 * 関係演算子LEQ
	 */
	LEQ("leq"),
	/**
	 * 関係演算子GT
	 */
	GT("gt"),
	/**
	 * 関係演算子GEQ
	 */
	GEQ("geq"),
	/**
	 * 関係演算子IN
	 */
	IN("in"),
	/**
	 * 関係演算子NOTIN
	 */
	NOT_IN("notin"),
	/**
	 * 関係演算子INCLUDE
	 */
	INCLUDE("include"),
	/**
	 * 関係演算子EXCLUDE
	 */
	EXCLUDE("exclude"),
	/**
	 * 関係演算子STARTSWITH
	 */
	START_SWITH("startswith"),
	/**
	 * 関係演算子NOTSTARTSWITH
	 */
	NOT_START_SWITH("nstartswith"),
	/**
	 * 関係演算子SUBSET
	 */
	SUBSET("subset"),
	/**
	 * 関係演算子NOTSUBSET
	 */
	NOT_SUBSET("nsubset"),
	/**
	 * 関係演算子INTERSECT
	 */
	INTERSECT("intersect"),
	/**
	 * 関係演算子NOTINTERSECT
	 */
	NOT_INTERSECT("nintersect"),
	/**
	 * 空欄
	 */
	EMPTY("empty"),
	;

	/**
	 * 対応させるエレメント名
	 */
	private String value;

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>コンストラクタクラス。
	 * </DL>
	 * @param value 対応させるエレメント名
	 */
	private ElementType(String value) {
		this.value = value;
	}

	/**
	 * エレメントタイプ取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>エレメントタイプを取得する。
	 * </DL>
	 * @param value エレメント名
	 * @return エレメント名に対応したエレメントタイプ
	 * @throws IllegalArgumentException 不正引数例外<BR>
	 * 定義外のエレメント名の場合例外をスローする。
	 */
	public static ElementType getType(String value) {

		for (ElementType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		// valueに指定された値をログへ出力する
		EMRException e = new EMRException(MessageCode.EMR_A_P010E);
		throw new IllegalArgumentException(e);
	}

	/**
	 * エレメント名取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字列表現を対応するエレメント名を返す。
	 * </DL>
	 * @return エレメント名
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * 文字列一致判定。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>このタイプの文字列表現と比較文字列が一致するかを判定する。
	 * </DL>
	 * @param value 比較文字列
	 * @return 比較結果<BR>
	 *このタイプの文字列表現と比較文字列が一致していれば、true
	 */
	public boolean isEquals(String value) {
		return value.equals(value);
	}

}
