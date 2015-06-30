package jp.escofi.emr.transformer.writer;

import java.util.ArrayList;
import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.transformer.constant.PDSConstants;


/**
 * 親属性値XMLライター。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>属性値出力処理用のライター群の共通処理を記載するXMLライター。（抽象クラス）
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
public abstract class AbstractAttributeValueWriter extends AbstractXmlWriter {

	/**
	 * 属性値ID
	 */
	private int attValueID;
	/**
	 * メタ情報
	 */
	private String metaInfo;
	/**
	 * 結果番号
	 */
	private int anserNo;
	/**
	 * 削除フラグ
	 */
	private boolean delFlg;


	/**
	 * コンストラクタ。
	 * <P>
	 * コンストラクタでXMLタグ名を初期化する。
	 * </P>
	 * @param elementType 出力タグ種別
	 */
	protected AbstractAttributeValueWriter(ElementType elementType) {
		super(elementType);
	}

	/**
	 * @return 属性値ID
	 */
	public final int getAttValueID() {
		return attValueID;
	}
	/**
	 * @param attValueID 属性値ID
	 */
	public final void setAttValueID(int attValueID) {
		this.attValueID = attValueID;
	}
	/**
	 * @return metainfo メタ情報
	 */
	public final String getMetaInfo() {
		return metaInfo;
	}
	/**
	 * @param metaInfo メタ情報
	 */
	public final void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
	}
	/**
	 * @return 結果番号
	 */
	public final int getAnserNo() {
		return anserNo;
	}
	/**
	 * @param anserNo 結果番号
	 */
	public final void setAnserNo(int anserNo) {
		this.anserNo = anserNo;
	}
	/**
	 * @return 削除フラグ
	 */
	public final boolean isDelFlg() {
		return delFlg;
	}
	/**
	 * @param delFlg 削除フラグ
	 */
	public final void setDelFlg(int delFlg) {
		this.delFlg = PDSConstants.TRUE.isEquals(
				String.valueOf(delFlg));
	}
	/**
	 * 内部Javaデータ型設定。
	 * <P>
	 * タグのjavadatatypeアトリビュートに値を設定。
	 * </P>
	 * @param javaDataType 内部Javaデータ型
	 */
	public final void setJavaDataType(String javaDataType) {
		setAttribute(AttributeType.JAVA_DATA_TYPE, javaDataType);
	}


	/**
	 * パラメータ文字列のリスト化。
	 * <P>
	 * List値、Mapキー、Map値の文字列をカンマ（,）区切りでリストに分割する。<BR>
	 * ただし、ダブルクォート（"）で囲んだ文字列内のカンマは文字列としてそのまま出力する。<BR>
	 * ダブルクォート（"）で囲んだ文字列内で、ダブルクォートを連続している場合は、
	 *単一のダブルクォートとして出力する。
	 * </P>
	 * <P>
	 * 対象文字列が空の場合は、サイズ1の空文字の項目のリストを返す。
	 * </P>
	 * @param param 対象文字列
	 * @return リスト化した対象文字列
	 */
	protected final List<String> split(String param) {
		List<String> ret;

		if (PDSConstants.EMPTY.isEquals(param)) {
			ret = new ArrayList<String>();
			ret.add(param);
		} else {
			ret =  ConvertUtil.parseCSV(param);
		}
		return ret;
	}

}
