package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.condition.PCOOperandVar;


/**
 * 条件式変数ハンドラー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>条件式の変数（{@code <var>}）要素を制御するSAXのイベントハンドラー。
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHVarHandler extends PCHARuleHandler {

	/**
	 * データ型
	 */
	private String _dataType;
	/**
	 * 内部Javaデータ型
	 */
	private String _javaDataType;
	/**
	 * 引数項目取得情報
	 */
	private String _varInfo;
	/**
	 * タグ内容取得バッファ
	 */
	private StringBuilder _buffer = new StringBuilder();

	private String _jpname;


	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler 呼出し元ハンドラー
	 * @param dataType データ型
	 * @param javaDataType 内部Javaデータ型
	 * @param varInfo 引数項目取得情報
	 * @param jpname 引数項目日本語名
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHVarHandler(PCHSingleConditionHandler callerHandler, String dataType,
			String javaDataType, String varInfo, String jpname, XMLWriter writer) {

		super(callerHandler);

		_jpname = jpname;
		_dataType = dataType;
		_javaDataType = javaDataType;
		_varInfo = varInfo;
		this.writer = writer;
	}


	/**
	 * タグ内容処理。
	 * <P>
	 * 取得したタグ内容文字列をクラス変数：タグ内容取得バッファへ格納する。
	 * </P>
	 * @param ch 取得したタグ内容
	 * @param start 開始位置
	 * @param length 対象文字列長
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (_buffer != null) {
			_buffer.append(ch, start, length);
			writer.characters(ch, start, length);
		}
	}

	/**
	 * タグ終了処理。
	 * <P>
	 * 対象タグが条件式変数の場合は、以下の処理を行う。
	 * </P>
	 * <OL>
	 * <LI>業務ラッパー返却用引数項目情報を作る。</LI>
	 * <LI>取得したタグ内容を文字列化する。</LI>
	 * <LI>取得したタグ内容が、グローバルの引数項目情報マップに含まれる場合、
	 *グローバルの引数項目情報マップから引数項目情報を取得する。</LI>
	 * <LI>取得したタグ内容が、グローバルの引数項目情報マップに含まれない場合、
	 *引数項目情報を生成し、グローバルの引数項目情報マップへ格納する。</LI>
	 * <LI>取得した引数項目情報を、継承元クラス変数：引数項目情報マップへ格納する。</LI>
	 * <LI>取得したタグ内容から、条件式変数オブジェクトを生成する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーに生成した条件式変数オブジェクトを設定する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：データ型を設定する。</LI>
	 * <LI>継承元クラス変数：呼出し元ハンドラーにクラス変数：内部Javaデータ型を設定する。</LI>
	 * <LI>継承元クラス変数：XMLリーダーに継承元クラス変数：呼出し元ハンドラーを設定する。</LI>
	 * <LI>クラス変数：タグ内容取得バッファをnullにする。</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ローカル名
	 * @param qName 参照中のタグ名
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.VAR.equals(qName)) {
			// 業務ラッパー返却用引数項目情報を作る。
			List<String> varInfoList;
			String name = _buffer.toString().intern();
			PROConditionItemInfo conditionItemInfo;

			if (0 < _varInfo.length()) {
				varInfoList = PUTConvertUtil.parseCSV(_varInfo);
			} else {
				varInfoList = new ArrayList<String>(1);
				varInfoList.add(_varInfo);
			}

			//グローバルの引数項目情報Mapにあるか否か判断
			if (globalConditionItemMap.containsKey(name)) {
				//ある場合は参照をアサイン
				conditionItemInfo = globalConditionItemMap.get(name);
			} else {
				//無い場合は生成しグローバルにセット
				conditionItemInfo = new PROConditionItemInfo(name,
					_dataType, _javaDataType, varInfoList, _jpname);
				globalConditionItemMap.put(name, conditionItemInfo);
			}
			conditionItemMap.put(name, conditionItemInfo);

			// 演算子（SingleCondition）にデータタイプをセットする。後constオブジェクトにセットされる。
			PCHSingleConditionHandler handler = (PCHSingleConditionHandler) callerHandler;
			PCOOperandVar itemVar = new PCOOperandVar(name);

			handler.getConditionItems().add(itemVar);
			handler.setDataType(_dataType);
			handler.setJavaDataType(_javaDataType);
			reader.setContentHandler(handler);
			_buffer = null;
		}
	}
}
