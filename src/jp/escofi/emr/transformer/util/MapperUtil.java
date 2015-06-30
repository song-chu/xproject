package jp.escofi.emr.transformer.util;

import jp.escofi.emr.engine.common.constant.DataType;

/**
 * マッパー共通関数ユーティリティ。
 * <DL>
 * <DT>使用目的/機能概要：
 * <DD>マッパークラス群にて使用する共通関数を定義したユーティリティクラス。
 * <DT>初版情報（作成日・作成者）：
 * <DD>2011/08/01 EBS
 * <DT>変更履歴（変更日、変更者、変更内容）：
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS 新規作成
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public class MapperUtil {

	/**
	 * 属性タイプ配列：｛属性タイプCD、属性タイプ名｝
	 * <UL>
	 * <LI>01:単一型</LI>
	 * <LI>02:リスト</LI>
	 * <LI>03:マップ</LI>
	 * <LI>04:範囲型</LI>
	 * <LI>05:オブジェクト型</LI>
	 * <LI>06:セット型</LI>
	 * </UL>
	 */
	private static final String[][] DATA_TYPE_ARRAY
	  = {{"01","single"}, {"02","list"}, {"03","map"}, {"04", "range"}, {"05", "object"}, {"06", "set"}};

	/**
	 * 属性タイプ取得。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>指定した属性タイプコードに該当する属性タイプを返却。
	 * </DL>
	 *
	 * @param cd 属性タイプコード
	 * @return 属性タイプ（Enum型）
	 * @throw IllegalArgumentException 指定した属性タイプが規定の属性タイプ配列に存在しない場合
	 */
	public static DataType getDataTypeByCd(String cd) {

		for (String[] array : DATA_TYPE_ARRAY) {
			if (array[0].equals(cd)) {
				return DataType.getType(array[1]);
			}
		}
		throw new IllegalArgumentException("Invalid data type code:[" + cd + "]");
	}

	/**
	 * 属性タイプ名取得。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>指定した属性タイプコードに該当する属性タイプ名を返却。
	 * </DL>
	 *
	 * @param cd 属性タイプコード
	 * @return 属性タイプ名
	 * @throw IllegalArgumentException 指定した属性タイプが規定の属性タイプ配列に存在しない場合
	 */
	public static String getDataTypeNameByCd(String cd) {
		for (String[] array : DATA_TYPE_ARRAY) {
			if (array[0].equals(cd)) {
				return array[1];
			}
		}
		throw new IllegalArgumentException("Invalid data type code:[" + cd + "]");
	}
}
