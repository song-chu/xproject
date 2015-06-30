package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;

import org.xml.sax.Attributes;


/**
 * Delegateハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>Delegateハンドラー郡のハンドラー生成メソッドを定義したファクトリークラス。
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
public final class DelegateHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private DelegateHandlerFactory() {}


	/**
	 * Delegateハンドラー生成処理。
	 * <P>
	 * 属性値ハンドラー郡の内部でエレメントタイプに応じたハンドラーを生成する。<br>
	 * このメソッドで生成できるハンドラーは下記。
	 * </P>
	 * <UL>
	 * <LI>リスト型ハンドラー</LI>
	 * <LI>マップ型ハンドラー</LI>
	 * <LI>範囲型ハンドラー</LI>
	 * <LI>単一型ハンドラー</LI>
	 * <LI>オブジェクト型ハンドラー</LI>
	 * </UL>
	 * <P>
	 * エレメントタイプの値がnull、または定義外のエレメントタイプの場合はnullを返す。
	 * </P>
	 * <P>
	 * 条件式定数ハンドラー内で単一型ハンドラーを生成する場合は、このメソッドではなく、
	 * {@link RuleHandlerFactory#createRuleHandler(ElementType, jp.escofi.emr.engine.loader.ConstHandler)}
	 * を使用する。
	 * </P>
	 * @param elementType エレメントタイプ
	 * @param callerHandler 呼出し元ハンドラー
	 * @param atts アトリビュート情報
	 * @return エレメントタイプに応じたハンドラー
	 */
	public static AbstractDelegateHandler createDelegateHandler(
			ElementType elementType, AbstractResultObjectHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case LIST:
			return new ListHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case MAP:
			return new MapHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case RANGE:
			return new RangeHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case SINGLE:
			return new SingleHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case OBJECT:

			// オブジェクト型の付帯情報を取得
			String strSubInfo = atts.getValue(AttributeType.SUB_INFO.toString());
			List<String> subInfo = ConvertUtil.parseCSV(strSubInfo);

			return new ObjectHandler(callerHandler,
					atts.getValue(AttributeType.CLASS_NAME.toString()).intern(),
					Collections.unmodifiableList(subInfo));
		default:
			return null;
		}
	}

}
