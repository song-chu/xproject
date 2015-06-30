package jp.escofi.emr.engine.loader;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.xml.sax.XMLReader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.loader.DataModelHandlerFactory;


/**
 * データモデルハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデルハンドラー生成メソッドを定義したファクトリークラス。
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
public final class DataModelHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private DataModelHandlerFactory() {}


	/**
	 * データモデルハンドラー生成処理。
	 * <P>
	 * 生成するデータモデルハンドラーには予めキー項目ハンドラーをセットしておく。
	 * </P>
	 * @param reader SAXリーダー
	 * @param dataModel データモデルのエレメント情報
	 * @param pdsObjectLocal ローカル変数のPDSオブジェクト（継承元用のテンポラリMap）
	 * @param itemKeys キー項目名リスト
	 * @return データモデルハンドラーの新規インスタンス
	 */
	public static DataModelHandler createDataModelHandler(
			XMLReader reader, Element dataModel, Map<String, Object> pdsObjectLocal, List<String> itemKeys) {
		// データモデル名
		String dataModelName = dataModel.getAttribute(AttributeType.NAME.toString()).intern();

		// DataModelHandler生成
		DataModelHandler dataModelHandler = new DataModelHandler(reader, dataModelName);

		// KeyItemHandler生成
		KeyItemHandler keyItemHandler = KeyItemHandlerFactory.createKeyItemHandler(
				dataModelHandler, dataModel, pdsObjectLocal, itemKeys);

		// 予めKeyItemHandlerをセットしておく
		dataModelHandler.setKeyItemHandler(keyItemHandler);

		return dataModelHandler;
	}

}
