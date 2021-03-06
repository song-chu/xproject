package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.ListWriter;
import jp.escofi.emr.transformer.writer.MapWriter;
import jp.escofi.emr.transformer.writer.ObjectWriter;
import jp.escofi.emr.transformer.writer.RangeWriter;
import jp.escofi.emr.transformer.writer.ResultWriter;
import jp.escofi.emr.transformer.writer.SingleWriter;


/**
 * 属性値マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>ORマッパーのSQL定義とマッピングさせるインターフェース。
 *   <DD>属性値テーブルから属性値情報を抽出するメソッドを定義。
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
public interface ValueMapper {

	/**
	 * リスト型情報抽出（属性項目ID指定）。
	 * <P>
	 * 指定した属性項目IDのリスト型情報を抽出する。
	 * </P>
	 * @param attFieldID 属性項目ID
	 * @return リスト型ライターリスト
	 */
	List<ListWriter> selectListAttFieldID(int attFieldID);

	/**
	 * リスト型情報抽出（結果番号指定）。
	 * <P>
	 * 指定した結果番号指定のリスト型情報を抽出する。
	 * </P>
	 * @param result 条件結果値ライター
	 * @return リスト型ライターリスト
	 */
	List<ListWriter> selectListAnserNo(ResultWriter result);

	/**
	 * マップ型情報抽出（属性項目ID指定）。
	 * <P>
	 * 指定した属性項目IDのマップ型情報を抽出する。
	 * </P>
	 * @param attFieldID 属性項目ID
	 * @return マップ型ライターリスト
	 */
	List<MapWriter> selectMapAttFieldID(int attFieldID);

	/**
	 * マップ型情報抽出（結果番号指定）。
	 * <P>
	 * 指定した結果番号指定のマップ型情報を抽出する。
	 * </P>
	 * @param result 条件結果値ライター
	 * @return マップ型ライターリスト
	 */
	List<MapWriter> selectMapAnserNo(ResultWriter result);

	/**
	 * オブジェクト型情報抽出（属性項目ID指定）。
	 * <P>
	 * 指定した属性項目IDのオブジェクト型情報を抽出する。
	 * </P>
	 * @param attFieldID 属性項目ID
	 * @return オブジェクト型ライターリスト
	 */
	List<ObjectWriter> selectObjectAttFieldID(int attFieldID);

	/**
	 * オブジェクト型情報抽出（結果番号指定）。
	 * <P>
	 * 指定した結果番号指定のオブジェクト型情報を抽出する。
	 * </P>
	 * @param result 条件結果値ライター
	 * @return オブジェクト型ライターリスト
	 */
	List<ObjectWriter> selectObjectAnserNo(ResultWriter result);

	/**
	 * 範囲型情報抽出（属性項目ID指定）。
	 * <P>
	 * 指定した属性項目IDの範囲型情報を抽出する。
	 * </P>
	 * @param attFieldID 属性項目ID
	 * @return 範囲型ライターリスト
	 */
	List<RangeWriter> selectRangeAttFieldID(int attFieldID);

	/**
	 * 範囲型情報抽出（結果番号指定）。
	 * <P>
	 * 指定した結果番号指定の範囲型情報を抽出する。
	 * </P>
	 * @param result 条件結果値ライター
	 * @return 範囲型ライターリスト
	 */
	List<RangeWriter> selectRangeAnserNo(ResultWriter result);

	/**
	 * 単一型情報抽出（属性項目ID指定）。
	 * <P>
	 * 指定した属性項目IDの単一型情報を抽出する。
	 * </P>
	 * @param attFieldID 属性項目ID
	 * @return 単一型ライターリスト
	 */
	List<SingleWriter> selectSingleAttFieldID(int attFieldID);

	/**
	 * 単一型情報抽出（結果番号指定）。
	 * <P>
	 * 指定した結果番号指定の単一型情報を抽出する。
	 * </P>
	 * @param result 条件結果値ライター
	 * @return 単一型ライターリスト
	 */
	List<SingleWriter> selectSingleAnserNo(ResultWriter result);

}
