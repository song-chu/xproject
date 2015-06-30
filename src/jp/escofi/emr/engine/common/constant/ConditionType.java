package jp.escofi.emr.engine.common.constant;

/**
 * 演算子の定義。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>演算子種類を定義するenumクラス。
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
public enum ConditionType {

	/**
	 * 論理演算子・タイプ：AND
	 */
	CONDITION_AND,
	/**
	 * 論理演算子・タイプ：OR
	 */
	CONDITION_OR,
	/**
	 * 関係演算子・タイプ：EQ
	 */
	CONDITION_EQ,
	/**
	 * 関係演算子・タイプ：NOTEQ
	 */
	CONDITION_NOT_EQ,
	/**
	 * 関係演算子・タイプ：GEQ
	 */
	CONDITION_GEQ,
	/**
	 * 関係演算子・タイプ：GT
	 */
	CONDITION_GT,
	/**
	 * 関係演算子・タイプ：LEQ
	 */
	CONDITION_LEQ,
	/**
	 * 関係演算子・タイプ：LT
	 */
	CONDITION_LT,
	/**
	 * 関係演算子・タイプ：IN
	 */
	CONDITION_IN,
	/**
	 * 関係演算子・タイプ：NOTIN
	 */
	CONDITION_NOT_IN,
	/**
	 * 関係演算子・タイプ：INCLUDE
	 */
	CONDITION_INCLUDE,
	/**
	 * 関係演算子・タイプ：EXCLUDE
	 */
	CONDITION_EXCLUDE,
	/**
	 * 関係演算子・タイプ：INTERSECT
	 */
	CONDITION_INTERSECT,
	/**
	 * 関係演算子・タイプ：NOTINTERSECT
	 */
	CONDITION_NOT_INTERSECT,
	/**
	 * 関係演算子・タイプ：STARTSWITH
	 */
	CONDITION_START_SWITH,
	/**
	 * 関係演算子・タイプ：NOTSTARTSWITH
	 */
	CONDITION_NOT_START_SWITH,
	/**
	 * 関係演算子・タイプ：SUBSET
	 */
	CONDITION_SUBSET,
	/**
	 * 関係演算子・タイプ：NOTSUBSET
	 */
	CONDITION_NOT_SUBSET,

}
