package jp.iwin.pds.xml2db.initialload.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.datamodel.PRORule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * 条件文ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値のタイプが条件文の場合、条件文全体（{@code <condition>}）以下の要素を制御するSAXのイベントハンドラー。
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
 * @see PCHIFHandler
 * @see PCHValueHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHConditionHandler extends PCHARuleHandler {

	/**
	 * 条件文
	 */
	private PROINIRule rule;
	/**
	 * 子条件文
	 */
	private PROINIRule childRule;
	/**
	 * IF-THEN-ELSE識別子
	 */
	private PCTIFType childIFtype = PCTIFType.IF_TOP;

	public static Map<String,PROResultObject> resultMap ;
	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHConditionHandler(PCHAResultObjectHandler callerHandler) {

		super(callerHandler);

		this.conditionItemMap = new HashMap<String, PROConditionItemInfo>();
		this.resultMap= new HashMap<String, PROResultObject>();
		this.writer.startElement(PCTElementType.CONDITION.toString());
	}


	/**
	 * タグ開始処理。
	 * <UL>
	 *  <LI>対象タグがIF文の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>IF-THEN-ELSE識別子がTOPの場合は、
	 *クラス変数：子条件文オブジェクトを指定して新規IF文ハンドラーを生成する。</LI>
	 *    <LI>上記以外の場合は、
	 *クラス変数：子条件文オブジェクトを指定して新規IF文ハンドラーを生成する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成したIF文ハンドラーを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>対象タグがELSE文の場合は、以下の処理を行う。
	 *   <OL>
	 *    <LI>クラス変数：子条件文オブジェクトを指定して新規ELSE文ハンドラーを生成する。</LI>
	 *    <LI>継承元クラス変数：XMLリーダーに生成したELSE文ハンドラーを設定する。</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);
		PROINIRule rule = this.childRule;
		PCHARuleHandler handler;
		this.writer.startElement(qName);
		switch (elementType) {
		case IF:

			if (PCTIFType.IF_TOP.equals(this.childIFtype)) {
				rule = this.rule;
			}
			handler = PCHRuleHandlerFactory.createIFHandler(
					this, rule, this.childIFtype, this.writer);
			this.reader.setContentHandler(handler);
			break;

		case ELSE:
			handler = PCHRuleHandlerFactory.createELSEHandler(
					this, rule,this.writer);
			this.reader.setContentHandler(handler);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件文の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>条件文オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに生成した条件文オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.CONDITION.equals(qName)) {
			//引数項目情報Mapを編集不可能にする。
			Collections.unmodifiableMap(this.conditionItemMap);

			// 条件文の型変換(INIRule -> PDSRule)
			PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;

			handler.setValue(new PRORule(this.rule.getPdsCondition(),
					this.rule.getThenRule(), this.rule.getElseRule(),
					this.rule.getThenAction(), this.rule.getElseAction(),
					this.conditionItemMap,this.writer.getXML(),this.resultMap));

			this.reader.setContentHandler(handler);
		}
	}


	public Map<String, PROResultObject> getResultMap() {
		return resultMap;
	}

	public void putResutMap(String key, PROResultObject value) {
		this.resultMap.put(key, value);
	}


	/**
	 * @param childRule 子条件文
	 * @see PCHIFHandler
	 */
	void setChildRule(PROINIRule childRule) {
		this.childRule = childRule;
	}
	/**
	 * @param childIFtype IF-THEN-ELSE識別子
	 * @see PCHIFHandler
	 */
	void setChildIFtype(PCTIFType childIFtype) {
		this.childIFtype = childIFtype;
	}

	/**
	 * @param rule 条件文
	 * @see PCHIFHandler
	 */
	void setRule(PROINIRule rule) {
		this.rule = rule;
	}

}
