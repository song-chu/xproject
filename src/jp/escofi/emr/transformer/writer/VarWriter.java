package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.sql.ArgsElemMapper;
import jp.escofi.emr.transformer.sql.VarMapper;


/**
 * オペランド変数ライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>オペランド変数（{@code <var>}）以下の要素を出力するXMLライター。
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
public final class VarWriter extends AbstractRuleWriter {

	/**
	 * コンストラクタ。
	 * <OL>
	 *  <LI>継承元クラスのコンストラクタ呼出し。</LI>
	 *  <LI>継承元クラス変数：タグ内容取得バッファを初期化する。</LI>
	 * </OL>
	 * @param callerWriter 呼出し元ライター
	 */
	VarWriter(ConditionWriter callerWriter) {
		super(ElementType.VAR, callerWriter);
		buffer = new StringBuilder();
	}


	/**
	 * @return 継承元クラス変数：呼出し元ライターのデータモデルID
	 */
	public int getDataModelID() {
		return callerWriter.dataModelID;
	}
	/**
	 * @return 継承元クラス変数：タグ内容(引数項目英字名称)
	 */
	public String getName() {
		return value;
	}


	/**
	 * タグ終了処理。
	 * <OL>
	 *  <LI>継承元クラス変数：タグ内容取得バッファが空の場合は、業務例外を生成、throwする。</LI>
	 *  <LI>継承元クラス変数：タグ内容取得バッファの内容(引数項目英字名称)を、
	 *継承元クラス変数：タグ内容に保持する。</LI>
	 *  <LI>引数管理情報を抽出する。</LI>
	 *  <LI>引数管理情報が取得できない、または複数件取得した場合は、
	 *業務例外を生成、throwする。</LI>
	 *  <LI>引数管理情報の削除フラグがtrueの場合は、業務例外を生成、throwする。</LI>
	 *  <LI>引数管理情報からアトリビュート情報を編集する。</LI>
	 * </OL>
	 * @throws EMRException オペランド変数情報が取得できなかった場合。
	 */
	@Override
	void endElement() throws EMRException {

		if (buffer.length() <= 0) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		value = buffer.toString();

		VarMapper mapper = callerWriter.session.getMapper(VarMapper.class);
		List<ArgsElemMapper> tmpList = mapper.select(this);

		if (tmpList.isEmpty() || 1 < tmpList.size()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		ArgsElemMapper vMapper = tmpList.get(0);

		if (vMapper.isDelFlg()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		// アトリビュート情報編集
		addAttribute(AttributeType.JAVA_DATA_TYPE, vMapper.getJavaDataType());
		addAttribute(AttributeType.DATA_TYPE, vMapper.getDataType());
		addAttribute(AttributeType.VAR_INFO, vMapper.getVarInfo());
		addAttribute(AttributeType.JP_NAME, vMapper.getJpName());
	}

}
