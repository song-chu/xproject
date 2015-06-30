package jp.iwin.pds.xml2db.datamodel.condition.factory;

import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACompositeCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOLogicOperAND;
import jp.iwin.pds.xml2db.datamodel.condition.PCOLogicOperOR;


/**
 * 論理演算式（AND/OR）の生成を担当するFacrotyクラス
 * <DL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1040 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:25:55 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTINTERSECT
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCOCompositeConditionFactory {

	/**
	 * 左右オペランド（ObjectのSET）のNOTINTERSECT演算を行う。共通要素が１個も存在しない場合、TRUEを返す。
	 * @param conditions 演算式のリスト
	 * @param conditionType 演算子種類
	 * @return 論理演算式
	 */
	public static PCOACompositeCondition createCompositeCondition(List<PCOACondition> conditions,
			PCTConditionType conditionType) {

		if (conditionType.equals(PCTConditionType.CONDITION_AND)) {
			return new PCOLogicOperAND(conditions);
		} else {
			return new PCOLogicOperOR(conditions);
		}
	}
}
