package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.VarWriter;


/**
 * �I�y�����h�ϐ��}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>OR�}�b�p�[��SQL��`�ƃ}�b�s���O������C���^�[�t�F�[�X�B
 *   <DD>�����Ǘ��e�[�u������I�y�����h�ϐ����𒊏o���郁�\�b�h���`�B
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
public interface VarMapper {

	/**
	 * �����Ǘ���񒊏o�B
	 * <P>
	 * �w�肵���������ږ��̈����Ǘ����𒊏o����B
	 * </P>
	 * @param var �I�y�����h�ϐ����C�^�[
	 * @return �������ϐ����C�^�[���X�g
	 */
	List<ArgsElemMapper> select(VarWriter var);

}
