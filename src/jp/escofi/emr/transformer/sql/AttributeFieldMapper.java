package jp.escofi.emr.transformer.sql;

import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.util.MapperUtil;


/**
 * 属性項目情報マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>取得した属性項目情報を格納するクラス。
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
public final class AttributeFieldMapper {

	/**
	 * 属性項目ID
	 */
	private int attFieldID;
	/**
	 * 条件有無フラグ
	 */
	private boolean conditionFlg;
	/**
	 * 条件XML
	 */
	private String conditionXml;
	/**
	 * データ型
	 */
	private DataType dataType;
	/**
	 * 内部javaデータ型
	 */
	private String javaDataType;
	/**
	 * 属性項目名（英語）
	 */
	private String name;
	/**
	 * 属性項目名（日本語）
	 */
	private String jpName;
	/**
	 * FROMキー項目値
	 */
	private String fromKeyValue;
	/**
	 * 削除フラグ
	 */
	private boolean delFlg;


	/**
	 * @return 属性項目ID
	 */
	public int getAttFieldID() {
		return attFieldID;
	}
	/**
	 * @param attFieldID 属性項目ID
	 */
	public void setAttFieldID(int attFieldID) {
		this.attFieldID = attFieldID;
	}
	/**
	 * @return 条件有無フラグ
	 */
	public boolean isConditionFlg() {
		return conditionFlg;
	}
	/**
	 * @param conditionFlg 条件有無フラグ：0：条件なし、1：条件あり
	 */
	public void setConditionFlg(int conditionFlg) {
		this.conditionFlg = PDSConstants.TRUE.isEquals(
				String.valueOf(conditionFlg));
	}
	/**
	 * @return 条件XML
	 */
	public String getConditionXml() {
		return conditionXml;
	}
	/**
	 * @param conditionXml 条件XML
	 */
	public void setConditionXml(String conditionXml) {
		this.conditionXml = conditionXml;
	}
	/**
	 * @return データ型
	 */
	public DataType getDataType() {
		return dataType;
	}
	/**
	 * @param dataTypeCd データ型
	 */
	public void setDataType(String dataTypeCd) {
		this.dataType = MapperUtil.getDataTypeByCd(dataTypeCd);
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
	 * @return 属性項目名（英語）
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 属性項目名（英語）
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return 属性項目名（日本語）
	 */
	public String getJpName() {
		return jpName;
	}
	/**
	 * @param jpName 属性項目名（日本語）
	 */
	public void setJpName(String jpName) {
		this.jpName = jpName;
	}
	/**
	 * @return FROMキー項目値
	 */
	public String getFromKeyValue() {
		return fromKeyValue;
	}
	/**
	 * @param fromKeyValue FROMキー項目値
	 */
	public void setFromKeyValue(String fromKeyValue) {
		this.fromKeyValue = fromKeyValue;
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
