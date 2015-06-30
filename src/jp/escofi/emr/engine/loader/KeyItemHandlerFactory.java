package jp.escofi.emr.engine.loader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

import org.w3c.dom.Element;

/**
 * キー項目ハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>キー項目ハンドラー郡のハンドラー生成メソッドを定義したファクトリークラス。
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
final class KeyItemHandlerFactory {

	/**
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private KeyItemHandlerFactory() {
	}

	/**
	 * キー項目ハンドラー生成処理。
	 *
	 * @param dataModelHandler
	 *            データモデルハンドラー
	 * @param dataModel
	 *            データモデルのエレメント情報
	 * @param pdsObjectLocal
	 *            ローカル変数のPDSオブジェクト（継承元用のテンポラリMap）
	 * @param itemKeys
	 *            キー項目名リスト
	 * @return キー項目ハンドラーの新規インスタンス
	 */
	@SuppressWarnings("unchecked")
	public static KeyItemHandler createKeyItemHandler(
			DataModelHandler dataModelHandler, Element dataModel,
			Map<String, Object> pdsObjectLocal, List<String> itemKeys) {

		// 継承元のデータモデル
		String extendsDM = dataModel.getAttribute(
				AttributeType.EXTENDS_DM.toString()).intern();

		// KeyItemHandler宣言
		KeyItemHandler keyItemHandler;

		if (extendsDM.length() <= 0) { // 継承元データモデルが無い場合
			keyItemHandler = new KeyItemHandler(dataModelHandler);
		} else {// 継承元データモデルが有る場合
			// 継承元データモデルのHashMap
			Map<String, Object> orgMap = (Map<String, Object>) pdsObjectLocal
					.get(extendsDM);

			if (orgMap == null) {
				throw new IllegalArgumentException(MessageUtil.getMessage(
						MessageCode.EMRA_A_P021E.toString(), new Object[] {
								dataModel.getAttribute(
										AttributeType.NAME.toString())
										.intern(), extendsDM }));
			}
			// 継承を解決するための情報
			Map<AttributeType, String> extendsInfo = getExtendsInfo(
					dataModel, itemKeys);

			keyItemHandler = new KeyItemHandlerExt(dataModelHandler, orgMap,
					extendsInfo);
		}

		return keyItemHandler;
	}

	/**
	 * 継承関係情報マップ取得。
	 *
	 * @param dataModel
	 *            データモデルのエレメント情報
	 * @param itemKeys
	 *            キー項目名リスト
	 * @return 継承関係情報マップ
	 */
	private static Map<AttributeType, String> getExtendsInfo(
			Element dataModel, List<String> itemKeys) {
		HashMap<AttributeType, String> extendsInfo = new HashMap<AttributeType, String>();

		String attrNameChild = null;
		String attrNameParent = null;
		String initValue = null;

		// initvalue取得
		initValue = dataModel.getAttribute(AttributeType.INIT_VALUE
				.toString());
		extendsInfo.put(AttributeType.INIT_VALUE, initValue);

		if (itemKeys.size() > 1) {
			int attrNameIdex = itemKeys.indexOf(ElementType.ATTR_NAME
					.toString());
			// attrnameが最上位エレメントの場合、attrnameChild情報のみ取得
			if (attrNameIdex == 0) {
				attrNameChild = itemKeys.get(attrNameIdex + 1);
				// attrnameが最下位エレメントの場合、attrnameParent情報のみ取得
			} else if (attrNameIdex == (itemKeys.size() - 1)) {
				attrNameParent = itemKeys.get(attrNameIdex - 1);
				// attrnameが真ん中エレメントの場合、attrnameChild、attrnameParent情報取得
			} else {
				attrNameChild = itemKeys.get(attrNameIdex + 1);
				attrNameParent = itemKeys.get(attrNameIdex - 1);
			}
		}

		extendsInfo.put(AttributeType.ATTR_NAME_PARENT, attrNameParent);
		extendsInfo.put(AttributeType.ATTR_NAME_CHILD, attrNameChild);

		return extendsInfo;
	}

}
