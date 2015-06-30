package jp.escofi.emr.transformer.sql;

import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.util.MapperUtil;


/**
 * �������ڏ��}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�擾�����������ڏ����i�[����N���X�B
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/08/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public final class AttributeFieldMapper {

	/**
	 * ��������ID
	 */
	private int attFieldID;
	/**
	 * �����L���t���O
	 */
	private boolean conditionFlg;
	/**
	 * ����XML
	 */
	private String conditionXml;
	/**
	 * �f�[�^�^
	 */
	private DataType dataType;
	/**
	 * ����java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �������ږ��i�p��j
	 */
	private String name;
	/**
	 * �������ږ��i���{��j
	 */
	private String jpName;
	/**
	 * FROM�L�[���ڒl
	 */
	private String fromKeyValue;
	/**
	 * �폜�t���O
	 */
	private boolean delFlg;


	/**
	 * @return ��������ID
	 */
	public int getAttFieldID() {
		return attFieldID;
	}
	/**
	 * @param attFieldID ��������ID
	 */
	public void setAttFieldID(int attFieldID) {
		this.attFieldID = attFieldID;
	}
	/**
	 * @return �����L���t���O
	 */
	public boolean isConditionFlg() {
		return conditionFlg;
	}
	/**
	 * @param conditionFlg �����L���t���O�F0�F�����Ȃ��A1�F��������
	 */
	public void setConditionFlg(int conditionFlg) {
		this.conditionFlg = PDSConstants.TRUE.isEquals(
				String.valueOf(conditionFlg));
	}
	/**
	 * @return ����XML
	 */
	public String getConditionXml() {
		return conditionXml;
	}
	/**
	 * @param conditionXml ����XML
	 */
	public void setConditionXml(String conditionXml) {
		this.conditionXml = conditionXml;
	}
	/**
	 * @return �f�[�^�^
	 */
	public DataType getDataType() {
		return dataType;
	}
	/**
	 * @param dataTypeCd �f�[�^�^
	 */
	public void setDataType(String dataTypeCd) {
		this.dataType = MapperUtil.getDataTypeByCd(dataTypeCd);
	}
	/**
	 * @return ����java�f�[�^�^
	 */
	public String getJavaDataType() {
		return javaDataType;
	}
	/**
	 * @param javaDataType ����java�f�[�^�^
	 */
	public void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}
	/**
	 * @return �������ږ��i�p��j
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name �������ږ��i�p��j
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return �������ږ��i���{��j
	 */
	public String getJpName() {
		return jpName;
	}
	/**
	 * @param jpName �������ږ��i���{��j
	 */
	public void setJpName(String jpName) {
		this.jpName = jpName;
	}
	/**
	 * @return FROM�L�[���ڒl
	 */
	public String getFromKeyValue() {
		return fromKeyValue;
	}
	/**
	 * @param fromKeyValue FROM�L�[���ڒl
	 */
	public void setFromKeyValue(String fromKeyValue) {
		this.fromKeyValue = fromKeyValue;
	}
	/**
	 * @return �폜�t���O
	 */
	public boolean isDelFlg() {
		return delFlg;
	}
	/**
	 * @param delFlg �폜�t���O
	 */
	public void setDelFlg(int delFlg) {
		this.delFlg = PDSConstants.TRUE.isEquals(
				String.valueOf(delFlg));
	}

}
