package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.common.constant.PCTDataType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOAOperand;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperEXCLUDE;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperINCLUDE;
import jp.iwin.pds.xml2db.datamodel.condition.PCOASingleCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOOperandConst;
import jp.iwin.pds.xml2db.datamodel.condition.factory.PCOSingleConditionFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * 関係演算式ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>以下のタグに対応するSAXイベントハンドラー。
 *    <UL>
 *     <LI>{@code <eq>}</LI>
 *     <LI>{@code <neq>}</LI>
 *     <LI>{@code <gt>}</LI>
 *     <LI>{@code <geq>}</LI>
 *     <LI>{@code <lt>}</LI>
 *     <LI>{@code <leq>}</LI>
 *     <LI>{@code <in>}</LI>
 *     <LI>{@code <notin>}</LI>
 *     <LI>{@code <intersect>}</LI>
 *     <LI>{@code <nintersect>}</LI>
 *     <LI>{@code <startswith>}</LI>
 *     <LI>{@code <nstartswith>}</LI>
 *     <LI>{@code <subset>}</LI>
 *     <LI>{@code <nsubset>}</LI>
 *     <LI>{@code <include>}</LI>
 *     <LI>{@code <exclude>}</LI>
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
 * @see PCHConstHandler
 * @see PCHVarHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHSingleConditionHandler extends PCHAConditionHandler {

	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType;
	/**
	 * 引数項目リスト
	 */
	private List<PCOAOperand> conditionItems = new ArrayList<PCOAOperand>();
	/**
	 * 属性タイプ定義
	 * <P>
	 * 演算子毎に属性タイプを持つ必要あり。演算子が属性タイプを持ち仲介する（var -> const）
	 * </P>
	 */
	private PCTDataType dataType;
	/**
	 * 下限含むフラグ
	 */
	private boolean lowereq;
	/**
	 * 上限含むフラグ
	 */
	private boolean uppereq;


	/**
	 * コンストラクタ。
	 * <P>
	 * 内部で下限/上限含むフラグを使用しない場合は、こちらのコンストラクタを使用する。
	 * </P>
	 * @param callerHandler 呼出し元ハンドラー
	 * @param elementType エレメント定義
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSingleConditionHandler(PCHApplyHandler callerHandler, PCTElementType elementType, XMLWriter writer) {

		super(callerHandler, elementType);
		this.writer = writer;

		this.lowereq = false;
		this.uppereq = false;
	}

	/**
	 * コンストラクタ(下限/上限含むフラグ付)。
	 * <P>
	 * 内部で下限/上限含むフラグを使用する場合は、こちらのコンストラクタを使用する。
	 * </P>
	 * @param callerHandler 呼出し元ハンドラー
	 * @param elementType エレメント定義
	 * @param lowereq 下限含むフラグ
	 * @param uppereq 上限含むフラグ
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSingleConditionHandler(
			PCHApplyHandler callerHandler, PCTElementType elementType, String lowereq, String uppereq, XMLWriter writer) {

		super(callerHandler, elementType);
		this.writer = writer;
		this.lowereq = Boolean.valueOf(lowereq);
		this.uppereq = Boolean.valueOf(uppereq);
	}


	/**
	 * タグ開始処理。
	 * <P>
	 * 継承元クラス変数：XMLリーダーに、参照するタグに応じたハンドラーを設定する。
	 * </P>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 * @param atts アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName);
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHARuleHandler handler = PCHRuleHandlerFactory.createRuleHandler(
				elementType, this, atts, this.writer);

		if (handler != null) {
			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 参照中のタグ名から取得したエレメント定義が、クラス変数：エレメント定義と同一の場合、
	 *以下の処理を行う。
	 * </P>
	 * <OL>
	 *  <LI>エレメント定義に応じた引数項目リスト変換処理を行う。</LI>
	 *  <LI>エレメント定義に応じた演算子定義を取得する。</LI>
	 *  <LI>エレメント定義に応じた演算子定義を取得する。</LI>
	 *  <LI>演算子定義に応じた条件文オブジェクトを生成する。</LI>
	 *  <LI>演算子定義がINCLUDE、EXCLUDEの場合は、条件文オブジェクトに、
	 *下限/上限含むフラグを設定する。</LI>
	 *  <LI>呼出し元ハンドラーの条件文に、条件文オブジェクトを設定する。</LI>
	 *  <LI>XMLリーダーのハンドラーを、呼出し元ハンドラーに戻す。</LI>
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
			// エレメント定義に応じた引数項目リスト変換処理
			convertItems(elementType);

			PCTConditionType conditionType = getConditionType(elementType);
			PCOASingleCondition condition = PCOSingleConditionFactory.createSingleCondition(
					this.conditionItems, conditionType, this.javaDataType, this.dataType);

			// 関係演算子タイプがINCLUDE、EXCLUDEの場合は、下限/上限含むフラグを設定する。
			switch (conditionType) {
			case CONDITION_INCLUDE:
				PCOARelOperINCLUDE roi = (PCOARelOperINCLUDE) condition;

				roi.setLowereq(this.lowereq);
				roi.setUppereq(this.uppereq);
				break;

			case CONDITION_EXCLUDE:
				PCOARelOperEXCLUDE roe = (PCOARelOperEXCLUDE) condition;

				roe.setLowereq(this.lowereq);
				roe.setUppereq(this.uppereq);
				break;
			}
			PCHApplyHandler handler = (PCHApplyHandler) this.callerHandler;

			handler.setCondition(condition);
			this.reader.setContentHandler(handler);
		}
	}


	/**
	 * @param dataType データ型
	 * @see PCHVarHandler
	 */
	void setDataType(String dataType) {
		this.dataType = PCTDataType.getType(dataType);
	}
	/**
	 * @param javaDataType 内部Javaデータ型
	 * @see PCHVarHandler
	 */
	void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}
	/**
	 * @return 引数項目リスト
	 * @see PCHConstHandler
	 * @see PCHVarHandler
	 */
	List<PCOAOperand> getConditionItems() {
		return this.conditionItems;
	}


	/**
	 * 引数項目リスト変換。
	 * <P>
	 * エレメント定義に応じた引数項目リスト変換処理を行う。
	 * </P>
	 * @param elementType エレメント定義
	 */
	private void convertItems(PCTElementType elementType) {

		switch (elementType) {
		case GT:
		case GEQ:
		case LT:
		case LEQ:
		case STARTSWITH:
		case NOTSTARTSWITH:
		case INCLUDE:
		case EXCLUDE:
			convertItems();
			break;

		case INTERSECT:
		case NOTINTERSECT:
		case SUBSET:
		case NOTSUBSET:
			convertSetItems();
			break;

		case EQ:
		case NOTEQ:

			if (PCTDataType.SET.equals(this.dataType)) {
				convertSetItems();
			} else {
				convertItems();
			}
			break;

		case IN:
		case NOTIN:
			// 引数項目(var)のデータタイプがSetの場合、つまりconstが要素として前にある場合
			if (PCTDataType.SET.equals(this.dataType)) {
				convertItems();
			} else {
				convertSetItems();
			}
			break;

		default:
			break;
		}
	}

	/**
	 * 引数項目リスト変換(通常オブジェクト)。
	 * <P>
	 * 引数項目リストの各データを、内部Javaデータ型のオブジェクトに変換する。
	 * </P>
	 */
	private void convertItems() {

		for (PCOAOperand item : this.conditionItems) {

			if (item instanceof PCOOperandConst) {
				item.setValue(PUTConvertUtil.convert(item.getValue(), this.javaDataType));
			}
		}
	}

	/**
	 * 引数項目リスト変換(setオブジェクト)。
	 * <P>
	 * 引数項目リストの各setデータを、内部Javaデータ型のオブジェクトのsetに変換する。
	 * </P>
	 */
	private void convertSetItems() {

		for (PCOAOperand item : this.conditionItems) {

			if (item instanceof PCOOperandConst) {
				@SuppressWarnings("unchecked")
				Set<Object> set = (Set<Object>) item.getValue();
				Set<Object> newSet = new HashSet<Object>(set.size());

				for (Object elem : set) {
					newSet.add(PUTConvertUtil.convert(elem, this.javaDataType));
				}
				item.setValue(Collections.unmodifiableSet(newSet));
			}
		}
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
		case EQ:
			ret = PCTConditionType.CONDITION_EQ;
			break;

		case NOTEQ:
			ret = PCTConditionType.CONDITION_NOTEQ;
			break;

		case GT:
			ret = PCTConditionType.CONDITION_GT;
			break;

		case GEQ:
			ret = PCTConditionType.CONDITION_GEQ;
			break;

		case IN:
			ret = PCTConditionType.CONDITION_IN;
			break;

		case NOTIN:
			ret = PCTConditionType.CONDITION_NOTIN;
			break;

		case LT:
			ret = PCTConditionType.CONDITION_LT;
			break;

		case LEQ:
			ret = PCTConditionType.CONDITION_LEQ;
			break;

		case SUBSET:
			ret = PCTConditionType.CONDITION_SUBSET;
			break;

		case NOTSUBSET:
			ret = PCTConditionType.CONDITION_NOTSUBSET;
			break;

		case INTERSECT:
			ret = PCTConditionType.CONDITION_INTERSECT;
			break;

		case NOTINTERSECT:
			ret = PCTConditionType.CONDITION_NOTINTERSECT;
			break;

		case STARTSWITH:
			ret = PCTConditionType.CONDITION_STARTSWITH;
			break;

		case NOTSTARTSWITH:
			ret = PCTConditionType.CONDITION_NOTSTARTSWITH;
			break;

		case INCLUDE:
			ret = PCTConditionType.CONDITION_INCLUDE;
			break;

		case EXCLUDE:
			ret = PCTConditionType.CONDITION_EXCLUDE;
			break;
		}

		return ret;
	}
}
