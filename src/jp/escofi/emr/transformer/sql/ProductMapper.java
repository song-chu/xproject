package jp.escofi.emr.transformer.sql;



/**
 * �Č��Ǘ��}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>OR�}�b�p�[��SQL��`�ƃ}�b�s���O������C���^�[�t�F�[�X�B
 *   <DD>�Č��Ǘ�����Č����𒊏o���郁�\�b�h���`�B
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
public interface ProductMapper {

	/**
	 * �Č������o�B
	 * <P>
	 * �w�肵���Č��ԍ��̈Č����𒊏o����B
	 * </P>
	 * @param productCd �Č��ԍ�
	 * @return �w�肵���Č��ԍ��̈Č���
	 */
	int count(String productCd);

}
