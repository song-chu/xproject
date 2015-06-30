package jp.escofi.emr.engine.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.escofi.emr.engine.search.MapComparator;

/**
 * 型変換ユーティリティ。
 * <DL>
 * <DT>使用目的/機能概要：
 * <DD>イニシャルロード時に指定したオブジェクト型へ型変換を行うためのユーティリティクラス。
 * <DT>初版情報（作成日・作成者）：
 * <DD>2011/08/01 EBS
 * <DT>変更履歴（変更日、変更者、変更内容）：
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS 新規作成
 * </UL>
 * </DL>
 * <P>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public class ConvertUtil {

	/**
	 * 引用符
	 */
	private static final char QUOTE = '"';
	/**
	 * カンマ
	 */
	private static final char COMMA = ',';
	/**
	 * エスケープ
	 */
	private static final char ESCAPE = '\\';
	/**
	 * 改行コード
	 */
	private static final char RETURN_CODE = '\n';
	/**
	 * 空文字
	 */
	private static final String BLANK = "";

	/**
	 * マップ型のサイズ変換。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>渡されたマップに格納されているデータ分にマップのサイズを縮小し、返却する。
	 * </DL>
	 *
	 * @param <K>
	 *            マップキータイプ
	 * @param <V>
	 *            マップ値タイプ
	 * @param map
	 *            マップ（リサイズ前）
	 * @return マップ（リサイズ後）
	 * @throw IllegalArgumentException 引数がnullの場合
	 */
	public static <K, V> Map<K, V> resizeMap(Map<K, V> map) {
		if (map == null) {
			throw new IllegalArgumentException();
		}
		Map<K, V> result = new HashMap<K, V>(map.size());
		for (Entry<K, V> e : map.entrySet()) {
			result.put(e.getKey(), e.getValue());
		}
		return result;
	}

	/**
	 * 文字列の型変換。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>引数strを引数dataTypeのデータ型に変換する。
	 * </DL>
	 *
	 * @param <T>
	 *            データタイプ
	 *
	 * @param str
	 *            文字列
	 * @param dataType
	 *            データ型
	 * @return 変換後のオブジェクト
	 * @throw IllegalArgumentException 不正引数例外
	 *        <UL>
	 *        <LI>引数str又はdataTypeがnullの場合
	 *        <LI>引数のデータ型が存在しない場合（ClassNotFoundException）
	 *        </UL>
	 */
	@SuppressWarnings( { "unchecked" })
	public static <T> T convert(String str, String dataType) {

		if (str == null) {
			throw new IllegalArgumentException("Argument 'str' ("
					+ ConvertUtil.class.getName() + ") is null");
		}
		if (dataType == null) {
			throw new IllegalArgumentException("Argument 'dataType' ("
					+ ConvertUtil.class.getName() + ") is null");
		}

		try {
			Class<T> clazz = (Class<T>) Class.forName(dataType);
			return convert(str, clazz);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * 文字列の型変換。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>文字列を&lt;T&gt;型に変換する。</DT>
	 * </DL>
	 * @param <T> Java型
	 *
	 * @param str
	 *            文字列
	 * @param clazz
	 *            変換後の型
	 * @return 変換後のオブジェクト。
	 *         <TABLE width=60% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *         <TR>
	 *         <TD>clazzがString型</TD>
	 *         <TD>intern()を実行し、文字列Poolからオブジェクトを取得</TD>
	 *         </TR>
	 *         <TR>
	 *         <TD>clazzがBoolean型</TD>
	 *         <TD>strが'true'/'false'の場合(小文字のみ有効)、変換</TD>
	 *         </TR>
	 *         <TR>
	 *         <TD>上記以外</TD>
	 *         <TD>clazzの新規インスタンスを生成し返却</TD>
	 *         </TR>
	 *         </TABLE>
	 * @throw IllegalArgumentException 不正引数例外
	 *        <UL>
	 *        <LI>引数strが'true'/'false'何れも該当しない場合
	 *        <LI>新規インスタンス生成に失敗した場合
	 *        </UL>
	 */
	@SuppressWarnings("unchecked")
	private static <T> T convert(String str, Class<T> clazz) {

		// 文字列の場合は文字列Poolからオブジェクト取得
		if (clazz == String.class) {
			return (T) (str.intern());
			// Booleanの場合は
		} else if (clazz == Boolean.class) {
			return (T) isConvertBoolean(str);
		} else {
			try {
				return clazz.getConstructor(String.class).newInstance(str);
			} catch (Exception e) {
				throw new IllegalArgumentException("Argument '" + str
						+ "' (String) cannot be converted to '"
						+ clazz.getName() + "'");
			}
		}
	}

	/**
	 * マップをソート。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>マップのエントリをキー順にソートする。
	 * </DL>
	 *
	 * @param map
	 *            マップ
	 * @return エントリリスト（ソート後）
	 */
	public static List<Map.Entry<String, Object>> sortMap(
			Map<String, Object> map) {

		List<Map.Entry<String, Object>> entries = null;
		if (map == null) {
			entries = new ArrayList<Map.Entry<String, Object>>(
					new HashMap<String, Object>().entrySet());
			return entries;
		}

		entries = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
		Collections.sort(entries, new MapComparator());
		return entries;
	}

	/**
	 * Javaデータ型のBigDecimal設定可否判定
	 *
	 * @param javaDataType
	 *            Javaデータ型
	 * @return BigDecimal設定可否
	 * @throw IllegalArgumentException 不正引数例外
	 *        <UL>
	 *        <LI>引数Javaデータ型が存在しない場合（ClassNotFoundException）
	 *        </UL>
	 */
	public static boolean isBigDecimalAssignable(String javaDataType) {

		try {
			return BigDecimal.class.isAssignableFrom(Class
					.forName(javaDataType));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * CSV形式の文字列を文字列のリストに変換する。
	 *
	 * <p>
	 * 文字列の先頭がカンマで 始まっていたり、文字列の最後がカンマで終わっている場合には、
	 * それぞれ変換結果のリストの最初か、あるいは最後の要素が空文字列となるように 変換される。
	 * </p>
	 * <p>
	 * カンマが連続している場合には、空文字列として変換される。
	 * </p>
	 * <p>
	 * csvStringが空文字 だった場合には、 要素数0のリストに変換される。<br>
	 * csvStringに改行が含まれてる場合には、改行直前までのリストを返す。<br>
	 * フィールドの値に含まれるダブルクォートはその直前にダブルクォートを付加。<br>
	 * ダブルクォート、カンマを含むフィールドは、ダブルクォーテーションで囲むべきである。
	 * </p>
	 *
	 * @param csvString
	 *            CSV形式の文字列
	 * @return カンマで分解された文字列を要素に持つリスト
	 */
	public static List<String> parseCSV(String csvString) {

		List<String> list = new ArrayList<String>(); // 項目リスト

		int commaPosition = 0;
		int quotePosition = 0;
		int escapePosition = 0;
		int returnPosition = 0;

		if (csvString.equals(BLANK)) {
			return new ArrayList<String>();
		}

		// 改行コードの位置
		returnPosition = csvString.indexOf(RETURN_CODE);
		if (returnPosition < 0) {
			returnPosition = Integer.MAX_VALUE;
		}
		// エスケープの位置、ダブルクォートの位置をindexOfで取得するかどうかのフラグ
		boolean eFlg = true;
		boolean qFlg = true;

		String tempString = csvString;
		while (true) {
			commaPosition = tempString.indexOf(COMMA);
			if (qFlg && quotePosition != Integer.MAX_VALUE) {
				quotePosition = tempString.indexOf(QUOTE);
				if (quotePosition < 0) {
					quotePosition = Integer.MAX_VALUE;
				}
			}
			if (eFlg && escapePosition != Integer.MAX_VALUE) {
				escapePosition = tempString.indexOf(ESCAPE);
				if (escapePosition < 0) {
					escapePosition = Integer.MAX_VALUE;
				}
			}
			eFlg = qFlg = false;
			// カンマが一番先にある場合、カンマまでを取得
			if (commaPosition >= 0 && commaPosition < quotePosition
					&& commaPosition < escapePosition
					&& commaPosition < returnPosition) {
				list.add(tempString.substring(0, commaPosition).intern());
				tempString = tempString.substring(commaPosition + 1);
				if (tempString.equals(BLANK)) {
					list.add(BLANK);
					return list;
				}
				quotePosition -= (commaPosition + 1);
				escapePosition -= (commaPosition + 1);
				returnPosition -= (commaPosition + 1);
			} else {
				// それ以外の場合、従来通りの処理
				boolean inQuote = false; // 「"」内外フラグ
				boolean first = true; // 項目先頭フラグ
				int currentPosition = 0; // 文字列中の現在の位置
				int endPosition = 0; // 文字列の最後の位置
				int size = tempString.length();
				char[] chToken = new char[size];
				int pos = 0;

				endPosition = size;
				while (currentPosition < endPosition) {

					boolean addFlg = false;
					char ch = tempString.charAt(currentPosition);

					switch (ch) {
					case QUOTE:
						qFlg = true;
						if (inQuote) {
							// 次が行の終わりならそこまででリターン
							if (currentPosition + 1 >= endPosition) {
								list.add(new String(chToken, 0, pos).intern());
								return list;
							}

							// 「"」の次の文字を判別
							char nextCh = tempString.charAt(currentPosition + 1);
							switch (nextCh) {
							// 先頭が「"」で「",」を検出したら項目の終わり
							case COMMA:
								inQuote = false;
								currentPosition++;
								list.add(new String(chToken, 0, pos).intern()); // リストに項目を追加
								addFlg = true;
								break;

							// 先頭が「"」で「""」が出てきたときは、１文字として認識。
							// 「"",」が出てきたときもこれでOK
							case QUOTE:
								currentPosition++;
								chToken[pos] = ch;
								pos++;
								break;

							// 先頭が「"」で「"(改行)」を検出したら項目の終わり
							// 本来ないはず
							case RETURN_CODE:
								list.add(new String(chToken).intern()); // リストに項目を追加
								return list;
							case ESCAPE:
								eFlg = true;
								break;
							default:
								break;
							}
						} else {
							// 項目の先頭なら「"」内外フラグオン
							if (first) {
								inQuote = true;
								first = false;
							} else {// 先頭に「"」がない場合に「"」が出てきたときは無視
							}
						}
						break;

					case COMMA:
						if (inQuote) {
							chToken[pos] = ch;
							pos++;
						} else {
							list.add(new String(chToken, 0, pos).intern());
							addFlg = true;
						}
						break;

					case ESCAPE:
						eFlg = true;
						// 次が行の終わりなら何もしない
						if (currentPosition + 1 >= endPosition) {
							break;
						}
						if (first) {
							first = false;
						}
						// 「\」の次の文字を判別
						char nextCh = tempString.charAt(currentPosition + 1);
						switch (nextCh) {
						case ESCAPE: // 「\\」が出てきたときは文字として認識

							currentPosition++;
							chToken[pos] = ch;
							pos++;
							break;
						case 'n': // 「\n」が出てきたときは改行として認識
							currentPosition++;
							chToken[pos] = RETURN_CODE;
							pos++;
							break;
						default:
							break;
						}
						break;

					case RETURN_CODE: // 改行コードが出てきたら、そこで行の終わりとして、残りのデータは破棄
						list.add(new String(chToken, 0, pos).intern());
						return list;

					default: // 普通の文字なら項目の文字列に追加
						if (first) {
							first = false;
						}
						chToken[pos] = ch;
						pos++;
					} // switch end
					// 現在位置をインクリメント
					currentPosition++;

					// 行の終わりまできたらそこまでを１項目とする
					if (currentPosition >= endPosition) {
						if (addFlg) {
							list.add(BLANK);
						} else {
							list.add(new String(chToken, 0, pos).intern());
						}
						return list;
					}

					if (addFlg) {
						tempString = tempString.substring(currentPosition);
						quotePosition -= currentPosition;
						escapePosition -= currentPosition;
						returnPosition -= currentPosition;
						break;
					}
				} // while2 end
			}
		} // while1 end
	}

	/**
	 * 文字列リストのＣＳＶ文字列化。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>文字列リストをCSV文字列化する。
	 * </DL>
	 *
	 * @param list
	 *            CSV項目リスト
	 * @return String ＣＳＶ行データ
	 */
	public static String toCsvString(List<String> list) {
		StringBuffer csv = new StringBuffer();
		if (list.size() == 0) {
			return csv.toString();
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				// NULL項目が入ってきたら、空文字とする
				list.add(i, BLANK);
			}
			StringBuffer token = new StringBuffer(list.get(i));
			int currentPosition = 0; // 文字列中の現在の位置

			while (currentPosition < token.length()) {
				char ch = token.charAt(currentPosition);
				switch (ch) {
				case QUOTE:
					token.insert(currentPosition, QUOTE);
					currentPosition += 2;
					break;

				case ESCAPE:
					token.insert(currentPosition, ESCAPE);
					currentPosition += 2;
					break;

				case RETURN_CODE:
					token.replace(currentPosition, currentPosition + 1, "\\n");
					currentPosition += 2;
					break;

				default:
					currentPosition++;
				}
			}
			if ((token.toString().indexOf("\"") != -1) || // 文字列の中に「"」もしくは「,」が存在したら
					(token.toString().indexOf(",") != -1)) { // 項目の最初と最後に「"」を付加
				token.insert(0, QUOTE).append(QUOTE);
			}
			csv.append(token).append(COMMA); // 項目の次にカンマ付加
		}
		csv.deleteCharAt(csv.length() - 1); // 最後のカンマを削除
		return csv.toString();
	}

	/**
	 * 文字列の<Boolean>型変換。
	 * <DL>
	 * <DT>使用目的/機能概要：
	 * <DD>文字列を&lt;Boolean&gt;型に変換する。</DT>
	 * </DL>
	 *
	 * @param str
	 *            文字列
	 * @return 変換後のオブジェクト。
	 * @throw IllegalArgumentException 不正引数例外
	 *        <UL>
	 *        <LI>引数strが'true'/'false'何れも該当しない場合
	 *        <LI>新規インスタンス生成に失敗した場合
	 *        </UL>
	 */
	public static Boolean isConvertBoolean(String str) {

		if (Boolean.TRUE.toString().equals(str.toLowerCase())) {
			return Boolean.TRUE;
		} else if (Boolean.FALSE.toString().equals(str.toLowerCase())) {
			return Boolean.FALSE;
		}

		throw new IllegalArgumentException("Argument '" + str
				+ "' (String) cannot be converted to '"
				+ Boolean.class.getName() + "'");
	}
}
