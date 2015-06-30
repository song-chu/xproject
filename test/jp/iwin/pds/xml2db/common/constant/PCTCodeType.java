package jp.iwin.pds.xml2db.common.constant;


/**
 * 内部Javaデータ型のタイプ定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>内部Javaデータ型のタイプを定義するenumクラス。
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
public enum PCTCodeType {

	/**
	 * データ型：Integer
	 */
	INTEGER("java.lang.Integer"),
	/**
	 * データ型：Boolean
	 */
	BOOLEAN("java.lang.Boolean"),
	;

	/**
	 * 対応させる内部Javaデータ型
	 */
	private String value;

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>コンストラクタクラス。
	 * </DL>
	 * @param value 対応させる内部Javaデータ型
	 */
	private PCTCodeType(String value) {
		this.value = value;
	}


	/**
	 * 内部Javaデータ型取得。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字列表現を対応する内部Javaデータ型を返す。
	 * </DL>
	 * @return 内部Javaデータ型
	 */
	@Override
	public String toString() {
		return this.value.intern();
	}

}
