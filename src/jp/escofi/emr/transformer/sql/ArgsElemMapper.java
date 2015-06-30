package jp.escofi.emr.transformer.sql;

import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.util.MapperUtil;


/**
 * �����Ǘ����}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�擾���������Ǘ������i�[����N���X�B
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
public final class ArgsElemMapper {

	/**
	 * �������ږ��i���{��j
	 */
	private String jpName;
	/**
	 * �f�[�^�^
	 */
	private String dataType;
	/**
	 * ����java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �������ڏ��
	 */
	private String varInfo;
	/**
	 * �폜�t���O
	 */
	private boolean delFlg;


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
	 * @return �f�[�^�^
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param dataTypeCd �f�[�^�^CD
	 */
	public void setDataType(String dataTypeCd) {
		dataType = MapperUtil.getDataTypeNameByCd(dataTypeCd);
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
	 * @return �������ڏ��
	 */
	public String getVarInfo() {
		return varInfo;
	}
	/**
	 * @param varInfo �������ڏ��
	 */
	public void setVarInfo(String varInfo) {
		this.varInfo = varInfo;
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
