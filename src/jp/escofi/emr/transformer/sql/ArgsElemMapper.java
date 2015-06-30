package jp.escofi.emr.transformer.sql;

import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.util.MapperUtil;


/**
 * 引数管理情報マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>取得した引数管理情報を格納するクラス。
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
public final class ArgsElemMapper {

	/**
	 * 引数項目名（日本語）
	 */
	private String jpName;
	/**
	 * データ型
	 */
	private String dataType;
	/**
	 * 内部javaデータ型
	 */
	private String javaDataType;
	/**
	 * 引数項目情報
	 */
	private String varInfo;
	/**
	 * 削除フラグ
	 */
	private boolean delFlg;


	/**
	 * @return 引数項目名（日本語）
	 */
	public String getJpName() {
		return jpName;
	}
	/**
	 * @param jpName 引数項目名（日本語）
	 */
	public void setJpName(String jpName) {
		this.jpName = jpName;
		
	}
	/**
	 * @return データ型
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param dataTypeCd データ型CD
	 */
	public void setDataType(String dataTypeCd) {
		dataType = MapperUtil.getDataTypeNameByCd(dataTypeCd);
	}
	/**
	 * @return 内部javaデータ型
	 */
	public String getJavaDataType() {
		return javaDataType;
	}
	/**
	 * @param javaDataType 内部javaデータ型
	 */
	public void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}
	/**
	 * @return 引数項目情報
	 */
	public String getVarInfo() {
		return varInfo;
	}
	/**
	 * @param varInfo 引数項目情報
	 */
	public void setVarInfo(String varInfo) {
		this.varInfo = varInfo;
	}
	/**
	 * @return 削除フラグ
	 */
	public boolean isDelFlg() {
		return delFlg;
	}
	/**
	 * @param delFlg 削除フラグ
	 */
	public void setDelFlg(int delFlg) {
		this.delFlg = PDSConstants.TRUE.isEquals(
				String.valueOf(delFlg));
	}

}
