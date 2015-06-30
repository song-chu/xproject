package jp.escofi.emr.engine.common.constant;

import jp.escofi.emr.engine.common.util.MessageUtil;

/**
 * 内部Javaデータ型のタイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>内部Javaデータ型のタイプを定義するenumクラス。
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
public enum CodeType {

	/**
	 * データ型：String
	 */
	STRING("java.lang.String"),
	/**
	 * データ型：Boolean
	 */
	BOOLEAN("java.lang.Boolean"),
	/**
	 * データ型：Integer
	 */
	INTEGER("java.lang.Integer"),
	/**
	 * データ型：Long
	 */
	LONG("java.lang.Long"),
	/**
	 * データ型：Double
	 */
	DOUBLE("java.lang.Double"),
	/**
	 * データ型：BigDecimal
	 */
	BIG_DECIMAL("java.math.BigDecimal"),
	/**
	 * データ型：定義型以外
	 */
	OTHER(null), ;

	/**
	 * 対応させる内部Javaデータ型
	 */
	private String value;

	/**
	 * コンストラクタ。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>コンストラクタクラス。
	 * </DL>
	 *
	 * @param value
	 *            対応させる内部Javaデータ型
	 */
	private CodeType(String value) {
		this.value = value;
	}

	/**
	 * 内部Javaデータ型取得。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>文字列表現を対応する内部Javaデータ型を返す。
	 * </DL>
	 *
	 * @return 内部Javaデータ型
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * 内部Javaデータ型タイプ取得。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>値の内部Javaデータ型を設定可否判定を行った上で取得する。
	 * <DD>上記の判定で一致しない場合はOTHERを返す。
	 * </DL>
	 *
	 * @param value
	 *            内部Javaデータ型
	 * @return 値の内部Javaデータ型に対応した内部Javaデータ型タイプ
	 * @throws IllegalArgumentException
	 *             不正引数例外<BR>
	 *             使用不可の内部Javaデータ型の場合、例外をスローする。
	 */
	public static CodeType getType(String value) {

		try {
			Class<?> code = Class.forName(value);

			for (CodeType type : values()) {
				if (!OTHER.equals(type) &&
						Class.forName(type.value).isAssignableFrom(code)) {
					return type;
				}
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P011E.toString(), new String[] { value }), e);
		}

		return OTHER;
	}

}
