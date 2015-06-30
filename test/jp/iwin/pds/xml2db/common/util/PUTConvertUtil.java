package jp.iwin.pds.xml2db.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTConstants;
import jp.iwin.pds.xml2db.dumptool.PDMMapComparator;
import jp.iwin.pds.xml2db.dumptool.PDMSetComparator;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;


/**
 * 型変換ユーティリティ。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>イニシャルロード時に指定したオブジェクト型へ型変換を行うためのユーティリティクラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1801 $
 *  <DT>最終開発日時：
 *   <DD>$Date:: 2010-12-17 17:49:2#$
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
 * @author $Author: seo.yj $
 */
public class PUTConvertUtil {

	private static final char QUOTE  = '"';
	private static final char COMMA  = ',';
	private static final char ESCAPE = '\\';
	private static final char RETURNCODE = '\n';
	private static final String BLANK = "";

	/**
	 * オブジェクトの配列変換。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>オブジェクトを配列に変換する。
	 *   <TABLE width=40% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *    <TR><TD colspan=2>引数のインスタンスが</TD></TR>
	 *    <TR><TD>nullの場合</TD><TD>Object[0]を返却</TD></TR>
	 *    <TR><TD>Object[]の場合</TD><TD>そのまま返却</TD></TR>
	 *    <TR><TD>Collectionの場合</TD><TD>配列に変換して返却</TD></TR>
	 *    <TR><TD>それ以外の場合</TD><TD>要素を1つ持つ配列として返却</TD></TR>
	 *   </TABLE><P></P>
	 * </DL>
	 * @param obj オブジェクト
	 * @return オブジェクトを変換した配列
	 */
	@SuppressWarnings("rawtypes")
	private static Object[] toArray(Object obj) {
		if (obj == null) {
			return new Object[0];
		} else if (obj.getClass().isArray()) {
			return (Object[]) obj;
		} else if (obj instanceof Collection) {
			return ((Collection) obj).toArray();
		}
		return new Object[] { obj };
	}

	/**
	 * オブジェクトのリスト変換。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>オブジェクトをリストに変換する。
	 *   <TABLE width=40% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *    <TR><TD colspan=2>引数のインスタンスが</TD></TR>
	 *    <TR><TD>nullの場合</TD><TD>要素を持たない&lt;E&gt;型のリストとして返却</TD></TR>
	 *    <TR><TD>Object[]の場合</TD><TD>&lt;E&gt;型のリストに変換して返却</TD></TR>
	 *    <TR><TD>Collectionの場合</TD><TD>&lt;E&gt;型のリストとして返却</TD></TR>
	 *    <TR><TD>それ以外の場合</TD><TD>要素を1つ持つ&lt;E&gt;型のリストとして返却</TD></TR>
	 *   </TABLE><P></P>
	 * </DL>
	 * @param obj オブジェクト
	 * @param elementClass 返却するリストの要素を表す型
	 * @return オブジェクトを変換したリスト
	 * @throws IllegalArgumentException 不正引数例外
	 *         <UL>
	 *          <LI>引数elementClassがnullの場合
	 *          <LI>objまたはその要素が&lt;E&gt;型ではない場合
	 *         </UL>
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> toList(Object obj, Class<E> elementClass)
			throws IllegalArgumentException {
		if (elementClass == null) {
			throw new IllegalArgumentException("Argument 'elementClass' ("
					+ Class.class.getName() + ") is null");
		}

		Object[] array = toArray(obj);
		List<E> result = new ArrayList<E>();
		for (Object element : array) {
			if (element != null
					&& !elementClass.isAssignableFrom(element.getClass())) {
				String message = "Unable to cast '"
						+ element.getClass().getName() + "' to '"
						+ elementClass.getName() + "'";
				throw new IllegalArgumentException(message,
						new ClassCastException(message));
			}
			result.add((E) element);
		}
		return result;
	}

	/**
	 * セット型のサイズ変換。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>渡されたセットに格納されているデータ分にセットのサイズを縮小し、返却する。
	 *   <DD>関係演算子ハンドラー群のタグ終了処理メソッドで使われる。
	 * </DL>
	 * @param set セット（リサイズ前）
	 * @return セット（リサイズ後）
	 * @throws IllegalArgumentException 引数がnullの場合
	 */
	public static <E> Set<E> resizeSet(Set<E> set)
			throws IllegalArgumentException {
		if (set == null) {
			throw new IllegalArgumentException();
		}
		Set<E> result = new HashSet<E>(set.size());
		for (E element : set) {
			result.add((E) element);
		}
		return result;
	}

	/**
	 * マップ型のサイズ変換。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>渡されたマップに格納されているデータ分にマップのサイズを縮小し、返却する。
	 * </DL>
	 * @see jp.iwin.pds.initialload.handler.PCHMapHandler
	 * @param map マップ（リサイズ前）
	 * @return マップ（リサイズ後）
	 * @throws IllegalArgumentException 引数がnullの場合
	 */
	public static <K,V> Map<K,V> resizeMap(Map<K,V> map)
			throws IllegalArgumentException {
		if (map == null) {
			throw new IllegalArgumentException();
		}
		Map<K,V> result = new HashMap<K,V>(map.size());
		for(Entry<K,V> e:map.entrySet()){
			result.put((K) e.getKey(),(V)e.getValue());
		}
		return result;
	}

	/**
	 * オブジェクトの型変換。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>引数objを引数dataTypeのデータ型に変換する。
	 * </DL>
	 * @param obj オブジェクト
	 * @param dataType データ型
	 * @return 変換後のオブジェクト
	 * @throws IllegalArgumentException 引数obj又はdataTypeがnullの場合
	 * @throws ClassNotFoundException クラス検索失敗例外
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> T convert(Object obj, String dataType)
			throws IllegalArgumentException {
		if (obj == null) {
			throw new IllegalArgumentException("Argument 'obj' ("
					+ Class.class.getName() + ") is null");
		}
		if (dataType == null) {
			throw new IllegalArgumentException("Argument 'dataType' ("
					+ Class.class.getName() + ") is null");
		}

		Class<T> clazz = null;

		try {
			clazz = (Class<T>) Class.forName(dataType);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}

		if(dataType.equals(PCTConstants.CODE_STRING)){
			return (T) ((String) convert(obj, clazz, true)).intern();
		}else if(dataType.equals(PCTConstants.CODE_BOOLEAN)){
			return (T) Boolean.valueOf((Boolean) convert(obj, clazz, true));
		}else{
			return convert(obj, clazz, true);
		}
	}

	/**
	 * オブジェクトの型変換。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>オブジェクトを&lt;T&gt;型に変換する。
	 *  </DT>
	 * </DL>
	 * @param obj オブジェクト
	 * @param clazz 変換後の型
	 * @param allowsNull 引数objがnullの場合を許容するかどうか
	 * @return 変換後のオブジェクト。
	 *   <TABLE width=60% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *    <TR><TD>allowsNullがfalse且つobjがnull</TD><TD>例外をスロー</TD></TR>
	 *    <TR><TD>allowsNullがtrue且つobjがnull</TD><TD>nullを返却</TD></TR>
	 *    <TR><TD>objがclazz型</TD><TD>そのまま返却</TD></TR>
	 *    <TR><TD>objがclazz型ではない</TD><TD>{@link ConvertUtils}を使用して適切な型に変換して返却
	 *    </TD></TR></TABLE><P></P>
	 * @throws IllegalArgumentException 不正引数例外
	 *         <UL>
	 *          <LI>引数clazzがnullの場合
	 *          <LI>引数allowsNullがfalse且つ引数objがnullの場合
	 *          <LI>変換に失敗した場合
	 *         </UL>
	 */
	@SuppressWarnings("unchecked")
	private static <T> T convert(Object obj, Class<T> clazz, boolean allowsNull)
			throws IllegalArgumentException {

		if (clazz.isAssignableFrom(obj.getClass())) {
			return (T) obj;
		}

		Object result = null;
		try {
			result = ConvertUtils.convert(obj.toString(), clazz);
		} catch (ConversionException e) {
			throw new IllegalArgumentException(e);
		}
		return (T) result;
	}

	/**
	 * マップをソート。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>マップのエントリをキー順にソートする。
	 * </DL>
	 * @param map マップ
	 * @return エントリリスト（ソート後）
	 */
	public static List<Map.Entry<String, Object>> sortMap(
			Map<String, Object> map) {

		if (map == null) {
			map = new HashMap<String, Object>();
		}

		List<Map.Entry<String, Object>> entries = new ArrayList<Map.Entry<String, Object>>(
				map.entrySet());

		Collections.sort(entries, new PDMMapComparator());

		return entries;
	}

	/**
	 * セットをソート。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>セットを要素順にソートする。
	 * </DL>
	 * @param set セット
	 * @return リスト（ソート後）
	 */
	public static List<Object> sortSet(Set<Object> set) {

		List<Object> list = toList(set, Object.class);

		Collections.sort(list, new PDMSetComparator());

		return list;
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
	 * csvString が null/空文字 だった場合には、 要素数0のリストに変換される。<br>
	 * エスケープ文字(ダブルクォート)の後のカンマは区切り文字 としては認識しない。<br>
	 * エスケープ文字(ダブルクォート)の後のエスケープ文字はエスケープ文字として 認識しない。<br>
	 * 改行（CRLF）、ダブルクォート、カンマを含むフィールドは、ダブルクォーテーションで囲むべきである。
	 * </p>
	 *
	 * @param csvString
	 *            CSV形式の文字列
	 * @return カンマで分解された文字列を要素に持つリスト
	 */
	public static List<String> parseCSV(String csvString) {

		List<String> list = new ArrayList<String>();	// 項目リスト

		int commaPosition = 0;
		int quotePosition = 0;
		int escapePosition = 0;
		int returnPosition = 0;

		if(csvString.equals(BLANK)){
			return new ArrayList<String>();
		}

		// 改行コードの位置
		returnPosition = csvString.indexOf(RETURNCODE);
		if(returnPosition<0){
			returnPosition = Integer.MAX_VALUE;
		}
		// エスケープの位置、ダブルクォートの位置をindexOfで取得するかどうかのフラグ
		boolean eFlg = true;
		boolean qFlg = true;

		while(true){
			commaPosition = csvString.indexOf(COMMA);
			if(qFlg && quotePosition!=Integer.MAX_VALUE){
				quotePosition = csvString.indexOf(QUOTE);
				if(quotePosition<0){
					quotePosition = Integer.MAX_VALUE;
				}
			}
			if(eFlg && escapePosition!=Integer.MAX_VALUE){
				escapePosition = csvString.indexOf(ESCAPE);
				if(escapePosition<0){
					escapePosition = Integer.MAX_VALUE;
				}
			}
			eFlg = qFlg = false;
			//カンマが一番先にある場合、カンマまでを取得
			if(commaPosition>=0 && commaPosition<quotePosition && commaPosition<escapePosition && commaPosition<returnPosition){
				list.add(csvString.substring(0,commaPosition));
				csvString = csvString.substring(commaPosition+1);
				if(csvString.equals(BLANK)){
					list.add(BLANK);
					return list;
				}
				quotePosition -=(commaPosition+1);
				escapePosition -=(commaPosition+1);
				returnPosition -=(commaPosition+1);
			}else{
				//それ以外の場合、従来通りの処理
				boolean inquote = false;					//「"」内外フラグ
				boolean first = true;						// 項目先頭フラグ
				int currentPosition = 0;					// 文字列中の現在の位置
				int endPosition = 0;			// 文字列の最後の位置
				int size = csvString.length();
				char[] chToken = new char[size];
				int pos = 0;

				endPosition = size;
				while ( currentPosition < endPosition ) {

					boolean addFlg=false;
					char ch = csvString.charAt(currentPosition);

					switch ( ch ){
						case QUOTE:
							qFlg = true;
							if ( inquote ) {
								// 次が行の終わりならそこまででリターン
								if( currentPosition+1 >= endPosition ) {
									list.add(new String(chToken,0,pos));
									return list;
								}

								// 「"」の次の文字を判別
								char nextch = csvString.charAt(currentPosition+1);
								switch( nextch ){
									// 先頭が「"」で「",」を検出したら項目の終わり
									case COMMA:
										inquote = false;
										currentPosition ++;
										list.add(new String(chToken,0,pos));		// リストに項目を追加
										addFlg = true;
										break;

									// 先頭が「"」で「""」が出てきたときは、１文字として認識。
									// 「"",」が出てきたときもこれでOK
									case QUOTE:
										currentPosition ++;
										chToken[pos] = ch;
										pos++;
										break;

									// 先頭が「"」で「"(改行)」を検出したら項目の終わり
									// 本来ないはず
									case RETURNCODE:
										list.add(new String(chToken));		// リストに項目を追加
										return list;
									case ESCAPE:
										eFlg = true;
										break;
									default:
										break;
								}
							} else {
								// 項目の先頭なら「"」内外フラグオン
								if( first ) {
									inquote = true;
									first = false;
								} else {// 先頭に「"」がない場合に「"」が出てきたときは無視
								}
							}
							break;

						case COMMA:
							if ( inquote ) {
								chToken[pos] = ch;
								pos++;
							} else {
								list.add(new String(chToken,0,pos));
								addFlg = true;
							}
							break;

						case ESCAPE:
							eFlg = true;
							// 次が行の終わりなら何もしない
							if( currentPosition+1 >= endPosition ) {
								break;
							}
							if( first ){
								first = false;
							}
							// 「\」の次の文字を判別
							char nextch = csvString.charAt(currentPosition+1);
							switch( nextch ) {
								case ESCAPE:		// 「\\」が出てきたときは文字として認識

									currentPosition ++;
									chToken[pos] = ch;
									pos++;
									break;
								case 'n':		// 「\n」が出てきたときは改行として認識
									currentPosition ++;
									chToken[pos] = RETURNCODE;
									pos++;
									break;
								default:
									break;
							}
							break;

						case RETURNCODE:	// 改行コードが出てきたら、そこで行の終わりとして、残りのデータは破棄
							list.add(new String(chToken,0,pos));
							return list;

						default:		// 普通の文字なら項目の文字列に追加
							if( first ){
								first = false;
							}
							chToken[pos] = ch;
							pos++;
					} // switch end
					// 現在位置をインクリメント
					currentPosition ++;

					// 行の終わりまできたらそこまでを１項目とする
					if( currentPosition >= endPosition ) {
						if(addFlg){
							list.add("");
						}else{
							list.add(new String(chToken,0,pos));
						}
						return list;
					}

					if(addFlg){
						csvString = csvString.substring(currentPosition);
						quotePosition -=currentPosition;
						escapePosition -=currentPosition;
						returnPosition -=currentPosition;
						break;
					}
				} // while2 end
			}
		} // while1 end
	}
}
