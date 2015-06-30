package jp.iwin.pds.xml2db.common.constant;

/**
 * 共通定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>共通定義クラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1230 $
 *  <DT>最終開発日時：
 *   <DD>$Date:: 2010-12-09 15:44:09#$
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
public class PCTConstants {

	/**
	 * 文字コード:Cp943C
	 */
	public static final String CHARSET = System.getProperty("file.encoding", "Cp943C");

	/**
	 * 属性名を表す
	 */
	public static final String ATTR_NAME = "attrname";

	/**
	 * XMLエレメント名：datamodel
	 * 	 */
	public static final String ELEMENT_DATAMODEL = "datamodel";
	/**
	 * XMLエレメント名：keyitem
	 */
	public static final String ELEMENT_KEYITEM = "keyitem";
	/**
	 * XMLエレメント名：attrname
	 */
	public static final String ELEMENT_ATTRNAME = "attrname";
	/**
	 * XMLエレメント名：version
	 */
	public static final String ELEMENT_VERSION = "version";
	/**
	 * XMLエレメント名：pattern
	 */
	public static final String ELEMENT_PATTERN = "pattern";
	/**
	 * XMLエレメント名：date
	 */
	public static final String ELEMENT_DATE = "date";
	/**
	 * XMLエレメント名：value
	 */
	public static final String ELEMENT_VALUE = "value";
	/**
	 * XMLエレメント名：single
	 */
	public static final String ELEMENT_SINGLE = "single";
	/**
	 * XMLエレメント名：list
	 */
	public static final String ELEMENT_LIST = "list";
	/**
	 * XMLエレメント名：elem
	 */
	public static final String ELEMENT_ELEM = "elem";
	/**
	 * XMLエレメント名：map
	 */
	public static final String ELEMENT_MAP = "map";
	/**
	 * XMLエレメント名：entry
	 */
	public static final String ELEMENT_ENTRY = "entry";
	/**
	 * XMLエレメント名：range
	 */
	public static final String ELEMENT_RANGE = "range";
	/**
	 * XMLエレメント名：upper
	 */
	public static final String ELEMENT_UPPER = "upper";
	/**
	 * XMLエレメント名：lower
	 */
	public static final String ELEMENT_LOWER = "lower";
	/**
	 * XMLエレメント名：object
	 */
	public static final String ELEMENT_OBJECT = "object";


	/**
	 * XMLエレメント名：condition
	 */
	public static final String ELEMENT_CONDITION = "condition";
	/**
	 * XMLエレメント名：if
	 */
	public static final String ELEMENT_IF = "if";
	/**
	 * XMLエレメント名：apply
	 */
	public static final String ELEMENT_APPLY = "apply";
	/**
	 * XMLエレメント名：else
	 */
	public static final String ELEMENT_ELSE = "else";
	/**
	 * XMLエレメント名：result
	 */
	public static final String ELEMENT_RESULT = "result";
	/**
	 * XMLエレメント名：and
	 */
	public static final String ELEMENT_AND = "and";
	/**
	 * XMLエレメント名：or
	 */
	public static final String ELEMENT_OR = "or";
	/**
	 * XMLエレメント名：eq
	 */
	public static final String ELEMENT_EQ = "eq";
	/**
	 * XMLエレメント名：neq
	 */
	public static final String ELEMENT_NOTEQ = "neq";
	/**
	 * XMLエレメント名：gt
	 */
	public static final String ELEMENT_GT = "gt";
	/**
	 * XMLエレメント名：geq
	 */
	public static final String ELEMENT_GEQ = "geq";
	/**
	 * XMLエレメント名：lt
	 */
	public static final String ELEMENT_LT = "lt";
	/**
	 * XMLエレメント名：leq
	 */
	public static final String ELEMENT_LEQ = "leq";
	/**
	 * XMLエレメント名：in
	 */
	public static final String ELEMENT_IN = "in";
	/**
	 * XMLエレメント名：notin
	 */
	public static final String ELEMENT_NOTIN = "notin";
	/**
	 * XMLエレメント名：subset
	 */
	public static final String ELEMENT_SUBSET = "subset";
	/**
	 * XMLエレメント名：nsubset
	 */
	public static final String ELEMENT_NOTSUBSET = "nsubset";
	/**
	 * XMLエレメント名：intersect
	 */
	public static final String ELEMENT_INTERSECT = "intersect";
	/**
	 * XMLエレメント名：nintersect
	 */
	public static final String ELEMENT_NOTINTERSECT = "nintersect";
	/**
	 * XMLエレメント名：include
	 */
	public static final String ELEMENT_INCLUDE = "include";
	/**
	 * XMLエレメント名：exclude
	 */
	public static final String ELEMENT_EXCLUDE = "exclude";
	/**
	 * XMLエレメント名：startswith
	 */
	public static final String ELEMENT_STARTSWITH = "startswith";
	/**
	 * XMLエレメント名：nstartswith
	 */
	public static final String ELEMENT_NOTSTARTSWITH = "nstartswith";
	/**
	 * XMLエレメント名：var
	 */
	public static final String ELEMENT_VAR = "var";
	/**
	 * XMLエレメント名：const
	 */
	public static final String ELEMENT_CONST = "const";
	/**
	 * XMLエレメント名：set
	 */
	public static final String ELEMENT_SET = "set";

	/**
	 * 属性：データモデル名
	 */
	public static final String ATTRIBUTE_NAME = "name";
	/**
	 * 属性：シーケンス番号
	 */
	public static final String ATTRIBUTE_SEQ = "seq";
	/**
	 * 属性：ファイル名
	 */
	public static final String ATTRIBUTE_FILE = "file";
	/**
	 * 属性：拡張
	 */
	public static final String ATTRIBUTE_EXTENDSDM = "extendsdm";
	/**
	 * 属性：継承元フラグ
	 */
	public static final String ATTRIBUTE_PARENTFLG = "parentflg";
	/**
	 * 属性：マップ種別
	 */
	public static final String ATTRIBUTE_MAPTYPE = "maptype";
	/**
	 * 属性：拡張項目
	 */
	public static final String ATTRIBUTE_EXTENDSITEM = "extendsitem";
	/**
	 * 属性：初期値
	 */
	public static final String ATTRIBUTE_INITVALUE = "initvalue";
	/**
	 * 属性：キー項目
	 */
	public static final String ATTRIBUTE_KEY = "key";
	/**
	 * 属性：継承元情報
	 */
	public static final String ATTRIBUTE_ORG = "org";
	/**
	 * 属性：削除フラグ
	 */
	public static final String ATTRIBUTE_DELFLG = "delflg";
	/**
	 * 属性：条件式フラグ
	 */
	public static final String ATTRIBUTE_CONDFLG = "condflg";
	/**
	 * 属性：ステータス
	 */
	public static final String ATTRIBUTE_STATUS = "status";
	/**
	 * 属性：内部Javaデータ型
	 */
	public static final String ATTRIBUTE_JAVADATATYPE = "javadatatype";
	/**
	 * 属性：含むフラグ
	 */
	public static final String ATTRIBUTE_EQ = "eq";
	/**
	 * 属性：クラス名
	 */
	public static final String ATTRIBUTE_CLASSNAME = "classname";
	/**
	 * 属性：クラス情報
	 */
	public static final String ATTRIBUTE_CLASSINFO = "classinfo";
	/**
	 * 属性：subinfo
	 */
	public static final String ATTRIBUTE_SUBINFO = "subinfo";
	/**
	 * 属性：データ種別
	 */
	public static final String ATTRIBUTE_DATATYPE = "datatype";
	/**
	 * 属性：引数項目取得情報
	 */
	public static final String ATTRIBUTE_VARINFO = "varinfo";
	/**
	 * 属性：下限値含む
	 */
	public static final String ATTRIBUTE_LOWEREQ = "lowereq";
	/**
	 * 属性：上限値含む
	 */
	public static final String ATTRIBUTE_UPPEREQ = "uppereq";

	/**
	 * マップ種別：HashMap
	 */
	public static final String CODE_HASHMAP = "hashmap";
	/**
	 * マップ種別：TreeMap
	 */
	public static final String CODE_TREEMAP = "treemap";
	/**
	 * 継承先データモデル名：親
	 */
	public static final String ATTRNAME_PARENT = "attrnameParent";
	/**
	 * 継承先データモデル名：子
	 */
	public static final String ATTRNAME_CHILD = "attrnameChild";
	/**
	 * データタイプ：Integer型
	 */
	public static final String CODE_INTEGER = "java.lang.Integer";
	/**
	 * データタイプ：Long型
	 */
	public static final String CODE_LONG = "java.lang.Long";
	/**
	 * データタイプ：Double型
	 */
	public static final String CODE_DOUBLE = "java.lang.Double";
	/**
	 * データタイプ：String型
	 */
	public static final String CODE_STRING ="java.lang.String";
	/**
	 * データタイプ：Boolean型
	 */
	public static final String CODE_BOOLEAN ="java.lang.Boolean";
	/**
	 * データタイプ：BigDecimal型
	 */
	public static final String CODE_BICDECIMAL ="java.math.BigDecimal";
	/**
	 * データモデル名：all
	 */
	public static final String DATAMODEL_ALL ="all";

	/**
	 * JDBCドライバ
	 */
	public static final String JDBC_DRIVER ="jdbc.driver";
	/**
	 * JDBC URL
	 */
	public static final String JDBC_URL ="jdbc.url";
	/**
	 * JDBC ユーザ名
	 */
	public static final String JDBC_USERNAME = "jdbc.username";
	/**
	 * JDBC パスワード
	 */
	public static final String JDBC_PASSWORD = "jdbc.password";

}
