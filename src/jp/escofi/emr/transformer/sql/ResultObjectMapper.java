package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.DatamodelWriter;


/**
 * �������ڃ}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>OR�}�b�p�[��SQL��`�ƃ}�b�s���O������C���^�[�t�F�[�X�B
 *   <DD>�������ڃe�[�u�����瑮���l���𒊏o���郁�\�b�h���`�B
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
public interface ResultObjectMapper {

	/**
	 * �������ڏ�񒊏o�B
	 * <P>
	 * �w�肵�������O���[�v�̑����Ǘ����t���������ڏ��𒊏o����B
	 * </P>
	 * @param dataModel �f�[�^���f�����C�^�[
	 * @return �������ڏ��}�b�p�[���X�g
	 */
	List<AttributeFieldMapper> select(DatamodelWriter dataModel);

}
