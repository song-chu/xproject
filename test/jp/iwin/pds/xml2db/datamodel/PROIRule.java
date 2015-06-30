package jp.iwin.pds.xml2db.datamodel;

import java.util.Map;

import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;

/**
 * 条件判定 条件文インタフェース。
 * <DL>
 *	<DT>最終開発リビジョン：
 *	 <DD>$Revision: 1047 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 10:49:56 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.PROINIRule
 * @see jp.iwin.pds.datamodel.PRORule
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public interface PROIRule {
	/**
	 * 条件判定の実行。
	 * @param argItems 引数項目のMap型オブジェクト
	 * @return 属性値オブジェクト
	 * @throws PEXConditionNotMatchedException 条件不成立例外
	 */
	public PROResultObject apply(Map<String, Object> argItems) throws PEXConditionNotMatchedException;
}
