package jp.iwin.pds.xml2db.common.constant;

import jp.iwin.pds.xml2db.common.exception.PEXException;

/**
 * エレメントタイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>エレメントのタイプを定義するenumクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1037 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:21:17 +0900 (轣ｫ, 07 12 2010) $
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
public enum PCTElementType {
	/**
	 * XML管理
	 */
	DATAMODELINFO("datamodelinfo"),
	/**
	 * データモデル
	 */
	DATAMODEL("datamodel"),
	/**
	 * キー項目
	 */
	KEYITEM("keyitem"),
	/**
	 * 属性名
	 */
	ATTRNAME("attrname"),
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
	 * 条件式カッコ
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
	NOTEQ("neq"),
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
	NOTIN("notin"),
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
	STARTSWITH("startswith"),
	/**
	 * 関係演算子NOTSTARTSWITH
	 */
	NOTSTARTSWITH("nstartswith"),
	/**
	 * 関係演算子SUBSET
	 */
	SUBSET("subset"),
	/**
	 * 関係演算子NOTSUBSET
	 */
	NOTSUBSET("nsubset"),
	/**
	 * 関係演算子INTERSECT
	 */
	INTERSECT("intersect"),
	/**
	 * 関係演算子NOTINTERSECT
	 */
	NOTINTERSECT("nintersect"),
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
	private PCTElementType(String value) {
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
	public static PCTElementType getType(String value) {

		for (PCTElementType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		// TODO 対応させるエラーコードが決まるまでの仮。
		// valueに指定された値をログへ出力する
		PEXException e = new PEXException(PCTMessageCode.P010E);
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
		return this.value.intern();
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
	public boolean equals(String value) {
		return this.value.equals(value);
	}

}
