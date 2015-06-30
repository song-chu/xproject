package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.ConditionType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.engine.condition.AbstractOperand;
import jp.escofi.emr.engine.condition.AbstractRelOperEXCLUDE;
import jp.escofi.emr.engine.condition.AbstractRelOperINCLUDE;
import jp.escofi.emr.engine.condition.AbstractSingleCondition;
import jp.escofi.emr.engine.condition.OperandConst;
import jp.escofi.emr.engine.condition.OperandVar;
import jp.escofi.emr.engine.condition.SingleConditionFactory;

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
public final class SingleConditionHandler extends AbstractConditionHandler {

	/**
	 * 内部Javaデータ型
	 */
	private String javaDataType;
	/**
	 * 引数項目リスト
	 */
	private List<AbstractOperand> conditionItems = new ArrayList<AbstractOperand>();
	/**
	 * 属性タイプ定義リスト
	 * <P>
	 * 演算子毎に属性タイプを持つ必要あり。演算子が属性タイプを持ち仲介する（var -> const）
	 * </P>
	 */
	private List<DataType> dataTypes = new ArrayList<DataType>();
	/**
	 * 下限含むフラグ
	 */
	private boolean lowerEq;
	/**
	 * 上限含むフラグ
	 */
	private boolean upperEq;

	/**
	 * コンストラクタ。
	 * <P>
	 * 内部で下限/上限含むフラグを使用しない場合は、こちらのコンストラクタを使用する。
	 * </P>
	 *
	 * @param callerHandler
	 *            呼出し元ハンドラー
	 * @param elementType
	 *            エレメント定義
	 */
	public SingleConditionHandler(ApplyHandler callerHandler,
			ElementType elementType) {

		super(callerHandler, elementType);

		lowerEq = false;
		upperEq = false;
	}

	/**
	 * コンストラクタ(下限/上限含むフラグ付)。
	 * <P>
	 * 内部で下限/上限含むフラグを使用する場合は、こちらのコンストラクタを使用する。
	 * </P>
	 *
	 * @param callerHandler
	 *            呼出し元ハンドラー
	 * @param elementType
	 *            エレメント定義
	 * @param lowerEq
	 *            下限含むフラグ
	 * @param upperEq
	 *            上限含むフラグ
	 */
	public SingleConditionHandler(ApplyHandler callerHandler,
			ElementType elementType, String lowerEq, String upperEq) {

		super(callerHandler, elementType);

		this.lowerEq = ConvertUtil.isConvertBoolean(lowerEq);
		this.upperEq = ConvertUtil.isConvertBoolean(upperEq);
	}

	/**
	 * タグ開始処理。
	 * <P>
	 * 継承元クラス変数：XMLリーダーに、参照するタグに応じたハンドラーを設定する。
	 * </P>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ローカル名
	 * @param qName
	 *            参照中のタグ名
	 * @param atts
	 *            アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		ElementType elementType = ElementType.getType(qName);
		AbstractRuleHandler handler = RuleHandlerFactory.createRuleHandler(
				elementType, this, atts);

		if (handler != null) {
			reader.setContentHandler(handler);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 参照中のタグ名から取得したエレメント定義が、クラス変数：エレメント定義と同一の場合、 以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>エレメント定義に応じた引数項目リスト変換処理を行う。</LI>
	 * <LI>エレメント定義に応じた演算子定義を取得する。</LI>
	 * <LI>エレメント定義に応じた演算子定義を取得する。</LI>
	 * <LI>演算子定義に応じた条件文オブジェクトを生成する。</LI>
	 * <LI>演算子定義がINCLUDE、EXCLUDEの場合は、条件文オブジェクトに、 下限/上限含むフラグを設定する。</LI>
	 * <LI>呼出し元ハンドラーの条件文に、条件文オブジェクトを設定する。</LI>
	 * <LI>XMLリーダーのハンドラーを、呼出し元ハンドラーに戻す。</LI>
	 * </OL>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ローカル名
	 * @param qName
	 *            参照中のタグ名
	 * @throw IllegalArgumentException 引数不正例外
	 *        <UL>
	 *        <LI>タグの整合性が合わない場合
	 *        </UL>
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType localElementType = ElementType.getType(qName);

		if (this.elementType == localElementType) {
			// エレメント定義に応じた引数項目リスト変換処理
			convertItems(localElementType);

			ConditionType conditionType = getConditionType(localElementType);
			AbstractSingleCondition condition = SingleConditionFactory
					.createSingleCondition(conditionItems, conditionType,
							javaDataType, dataTypes);

			// 関係演算子タイプがINCLUDE、EXCLUDEの場合は、下限/上限含むフラグを設定する。
			switch (conditionType) {
			case CONDITION_INCLUDE:
				AbstractRelOperINCLUDE roi = (AbstractRelOperINCLUDE) condition;

				roi.setLowerEq(lowerEq);
				roi.setUpperEq(upperEq);
				break;

			case CONDITION_EXCLUDE:
				AbstractRelOperEXCLUDE roe = (AbstractRelOperEXCLUDE) condition;

				roe.setLowerEq(lowerEq);
				roe.setUpperEq(upperEq);
				break;
			}
			ApplyHandler handler = (ApplyHandler) callerHandler;

			handler.setCondition(condition);
			reader.setContentHandler(handler);
		}
	}

	/**
	 * @param javaDataType
	 *            内部Javaデータ型
	 */
	void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}

	/**
	 * 引数項目追加。
	 * <P>
	 * 属性タイプ定義リスト、引数項目リストにデータ型、属性値を追加する。
	 * </P>
	 *
	 * @param dataType
	 *            データ型
	 * @param item
	 *            引数項目
	 */
	void addConditionItem(String dataType, AbstractOperand item) {
		dataTypes.add(DataType.getType(dataType));
		conditionItems.add(item);
	}

	/**
	 * 引数項目リスト変換。
	 * <P>
	 * エレメント定義に応じた引数項目チェックを行い、チェックが通ればリスト変換処理を行う。
	 * </P>
	 * <OL>
	 * <LI>内部Javaデータ型タイプを取得する。</LI>
	 * <LI>内部Javaデータ型タイプを取得できない場合は、例外が発生する。</LI>
	 * <LI>引数項目リストにセットを含む場合は、内部Javaデータ型がbooleanの場合に例外が発生する。</LI>
	 * <LI>エレメント定義に応じた引数項目チェックを行う。</LI>
	 * <LI>変数の存在チェックを行う。</LI>
	 * <LI>リスト変換処理を行う。</LI>
	 * </OL>
	 *
	 * @param elementType
	 *            エレメント定義
	 * @throw IllegalArgumentException 引数不正例外
	 *        <UL>
	 *        <LI>引数elementTypeとdataTypesの整合性が合わない場合
	 *        </UL>
	 */
	private void convertItems(ElementType elementType) {

		int size = dataTypes.size();
		boolean containsSet = dataTypes.contains(DataType.SET);
		boolean containsSingle = dataTypes.contains(DataType.SINGLE);
		boolean isValid = true;
		switch (elementType) {
		case EQ:
		case NOT_EQ:
			isValid = (size == 2) && dataTypes.get(0).equals(dataTypes.get(1));
			break;

		case GT:
		case GEQ:
		case LT:
		case LEQ:
		case START_SWITH:
		case NOT_START_SWITH:
			isValid = (size == 2) && !containsSet;
			break;

		case IN:
		case NOT_IN:
			isValid = (size == 2)
					&& DataType.SINGLE == dataTypes.get(0)
					&& DataType.SET == dataTypes.get(1);
			break;

		case INTERSECT:
		case NOT_INTERSECT:
		case SUBSET:
		case NOT_SUBSET:
			isValid = (size == 2) && !containsSingle;
			break;

		case INCLUDE:
		case EXCLUDE:
			isValid = (size == 3) && !containsSet;
			break;
		}

		if (isValid) {
			// Constのみチェック
			boolean hasVar = false;
			// 引数項目の変換処理用
			List<OperandConst> convItems = new ArrayList<OperandConst>();

			for (AbstractOperand item : conditionItems) {

				if (item instanceof OperandConst) {
					convItems.add((OperandConst) item);
				} else if (item instanceof OperandVar) {
					hasVar = true;
				}
			}

			if (hasVar) {

				for (OperandConst item : convItems) {
					convertItems(item);
				}
			}
			isValid = hasVar;
		}

		if (!isValid) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P017E.toString(), new String[] {
							elementType.toString(),
							dataTypes.toString() }));
		}
	}

	/**
	 * 引数項目変換処理。
	 * <P>
	 * 引数項目に値を内部Javaデータ型で変換したオブジェクトをセットする。
	 * </P>
	 *
	 * @param item
	 *            引数項目
	 */
	private void convertItems(OperandConst item) {

		switch (item.getDataType()) {
		case SINGLE:
			item.setValue(ConvertUtil.convert(item.getStrValue(),
					javaDataType));
			break;

		case SET:
			Set<String> set = item.getStrSetValue();
			Set<Object> newSet = new HashSet<Object>(set.size());

			for (String elem : set) {
				newSet.add(ConvertUtil.convert(elem, javaDataType));
			}
			item.setValue(Collections.unmodifiableSet(newSet));
			break;
		}
	}

	/**
	 * 演算子定義取得。
	 * <P>
	 * エレメント定義に応じた演算子定義を取得する。
	 * </P>
	 *
	 * @param elementType
	 *            エレメント定義
	 * @return 演算子定義
	 */
	private ConditionType getConditionType(ElementType elementType) {
		ConditionType ret = null;

		switch (elementType) {
		case EQ:
			ret = ConditionType.CONDITION_EQ;
			break;

		case NOT_EQ:
			ret = ConditionType.CONDITION_NOT_EQ;
			break;

		case GT:
			ret = ConditionType.CONDITION_GT;
			break;

		case GEQ:
			ret = ConditionType.CONDITION_GEQ;
			break;

		case IN:
			ret = ConditionType.CONDITION_IN;
			break;

		case NOT_IN:
			ret = ConditionType.CONDITION_NOT_IN;
			break;

		case LT:
			ret = ConditionType.CONDITION_LT;
			break;

		case LEQ:
			ret = ConditionType.CONDITION_LEQ;
			break;

		case SUBSET:
			ret = ConditionType.CONDITION_SUBSET;
			break;

		case NOT_SUBSET:
			ret = ConditionType.CONDITION_NOT_SUBSET;
			break;

		case INTERSECT:
			ret = ConditionType.CONDITION_INTERSECT;
			break;

		case NOT_INTERSECT:
			ret = ConditionType.CONDITION_NOT_INTERSECT;
			break;

		case START_SWITH:
			ret = ConditionType.CONDITION_START_SWITH;
			break;

		case NOT_START_SWITH:
			ret = ConditionType.CONDITION_NOT_START_SWITH;
			break;

		case INCLUDE:
			ret = ConditionType.CONDITION_INCLUDE;
			break;

		case EXCLUDE:
			ret = ConditionType.CONDITION_EXCLUDE;
			break;
		}

		return ret;
	}

}
