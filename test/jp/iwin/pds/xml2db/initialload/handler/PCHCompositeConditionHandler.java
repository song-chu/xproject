package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACompositeCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;
import jp.iwin.pds.xml2db.datamodel.condition.factory.PCOCompositeConditionFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * 論理演算式ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>データモデルXMLの以下のタグに対応するSAXイベントハンドラー。
 *    <UL>
 *     <LI>{@code <and>}</LI>
 *     <LI>{@code <or>}</LI>
 *    </UL>
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1059 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (轣ｫ, 07 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHApplyHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHCompositeConditionHandler extends PCHAConditionHandler {

	/**
	 * 条件文リスト
	 */
	private List<PCOACondition> conditions = new ArrayList<PCOACondition>();


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHCompositeConditionHandler(
			PCHApplyHandler callerHandler, PCTElementType elementType, XMLWriter writer) {
		super(callerHandler, elementType);
		this.writer = writer ;
	}

	/**
	 * タグ開始処理。
	 * <P>
	 * 対象タグが条件式カッコの場合は、継承元クラス変数：XMLリーダーに、
	 *条件式カッコハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName, atts);
		if (PCTElementType.APPLY.equals(qName)) {
			PCHApplyHandler handler = PCHRuleHandlerFactory.createApplyHandler(this, this.writer);

			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 参照中のタグ名から取得したエレメント定義が、クラス変数：エレメント定義と同一の場合は、
	 *以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>複合条件文オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに、生成した複合条件文オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに、継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);
		this.writer.endElement(qName);

		if (this.elementType.equals(elementType)) {
			PCHApplyHandler handler = (PCHApplyHandler) this.callerHandler;
			PCTConditionType conditionType = getConditionType(elementType);
			PCOACompositeCondition compositeCondition =
				PCOCompositeConditionFactory.createCompositeCondition(
						this.conditions, conditionType);

			handler.setCondition(compositeCondition);
			this.reader.setContentHandler(handler);
		}
	}


	/**
	 * @return 条件文リスト
	 * @see PCHApplyHandler
	 */
	List<PCOACondition> getConditions() {
		return this.conditions;
	}


	/**
	 * 演算子定義取得。
	 * <P>
	 * エレメント定義に応じた演算子定義を取得する。
	 * </P>
	 * @param elementType エレメント定義
	 * @return 演算子定義
	 */
	private PCTConditionType getConditionType(PCTElementType elementType) {
		PCTConditionType ret = null;

		switch (elementType) {
		case AND:
			ret = PCTConditionType.CONDITION_AND;
			break;

		case OR:
			ret = PCTConditionType.CONDITION_OR;
			break;
		}

		return ret;
	}

}
