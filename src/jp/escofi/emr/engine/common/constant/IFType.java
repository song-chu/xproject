package jp.escofi.emr.engine.common.constant;

/**
 * IF-THEN-ELSE���ʎq�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>IF�ATHENIF�AELSEIF�����ʂ���enum�N���X�B
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
public enum IFType {
	/**
	 * IF�^�C�v�FTOP
	 */
	IF_TOP,
	/**
	 * IF�^�C�v�FELSE
	 */
	IF_ELSE,
	/**
	 * IF�^�C�v�FTHEN
	 */
	IF_THEN,
}
