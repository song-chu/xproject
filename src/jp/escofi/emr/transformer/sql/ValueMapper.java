package jp.escofi.emr.transformer.sql;

import java.util.List;

import jp.escofi.emr.transformer.writer.ListWriter;
import jp.escofi.emr.transformer.writer.MapWriter;
import jp.escofi.emr.transformer.writer.ObjectWriter;
import jp.escofi.emr.transformer.writer.RangeWriter;
import jp.escofi.emr.transformer.writer.ResultWriter;
import jp.escofi.emr.transformer.writer.SingleWriter;


/**
 * �����l�}�b�p�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>OR�}�b�p�[��SQL��`�ƃ}�b�s���O������C���^�[�t�F�[�X�B
 *   <DD>�����l�e�[�u�����瑮���l���𒊏o���郁�\�b�h���`�B
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
public interface ValueMapper {

	/**
	 * ���X�g�^��񒊏o�i��������ID�w��j�B
	 * <P>
	 * �w�肵����������ID�̃��X�g�^���𒊏o����B
	 * </P>
	 * @param attFieldID ��������ID
	 * @return ���X�g�^���C�^�[���X�g
	 */
	List<ListWriter> selectListAttFieldID(int attFieldID);

	/**
	 * ���X�g�^��񒊏o�i���ʔԍ��w��j�B
	 * <P>
	 * �w�肵�����ʔԍ��w��̃��X�g�^���𒊏o����B
	 * </P>
	 * @param result �������ʒl���C�^�[
	 * @return ���X�g�^���C�^�[���X�g
	 */
	List<ListWriter> selectListAnserNo(ResultWriter result);

	/**
	 * �}�b�v�^��񒊏o�i��������ID�w��j�B
	 * <P>
	 * �w�肵����������ID�̃}�b�v�^���𒊏o����B
	 * </P>
	 * @param attFieldID ��������ID
	 * @return �}�b�v�^���C�^�[���X�g
	 */
	List<MapWriter> selectMapAttFieldID(int attFieldID);

	/**
	 * �}�b�v�^��񒊏o�i���ʔԍ��w��j�B
	 * <P>
	 * �w�肵�����ʔԍ��w��̃}�b�v�^���𒊏o����B
	 * </P>
	 * @param result �������ʒl���C�^�[
	 * @return �}�b�v�^���C�^�[���X�g
	 */
	List<MapWriter> selectMapAnserNo(ResultWriter result);

	/**
	 * �I�u�W�F�N�g�^��񒊏o�i��������ID�w��j�B
	 * <P>
	 * �w�肵����������ID�̃I�u�W�F�N�g�^���𒊏o����B
	 * </P>
	 * @param attFieldID ��������ID
	 * @return �I�u�W�F�N�g�^���C�^�[���X�g
	 */
	List<ObjectWriter> selectObjectAttFieldID(int attFieldID);

	/**
	 * �I�u�W�F�N�g�^��񒊏o�i���ʔԍ��w��j�B
	 * <P>
	 * �w�肵�����ʔԍ��w��̃I�u�W�F�N�g�^���𒊏o����B
	 * </P>
	 * @param result �������ʒl���C�^�[
	 * @return �I�u�W�F�N�g�^���C�^�[���X�g
	 */
	List<ObjectWriter> selectObjectAnserNo(ResultWriter result);

	/**
	 * �͈͌^��񒊏o�i��������ID�w��j�B
	 * <P>
	 * �w�肵����������ID�͈̔͌^���𒊏o����B
	 * </P>
	 * @param attFieldID ��������ID
	 * @return �͈͌^���C�^�[���X�g
	 */
	List<RangeWriter> selectRangeAttFieldID(int attFieldID);

	/**
	 * �͈͌^��񒊏o�i���ʔԍ��w��j�B
	 * <P>
	 * �w�肵�����ʔԍ��w��͈̔͌^���𒊏o����B
	 * </P>
	 * @param result �������ʒl���C�^�[
	 * @return �͈͌^���C�^�[���X�g
	 */
	List<RangeWriter> selectRangeAnserNo(ResultWriter result);

	/**
	 * �P��^��񒊏o�i��������ID�w��j�B
	 * <P>
	 * �w�肵����������ID�̒P��^���𒊏o����B
	 * </P>
	 * @param attFieldID ��������ID
	 * @return �P��^���C�^�[���X�g
	 */
	List<SingleWriter> selectSingleAttFieldID(int attFieldID);

	/**
	 * �P��^��񒊏o�i���ʔԍ��w��j�B
	 * <P>
	 * �w�肵�����ʔԍ��w��̒P��^���𒊏o����B
	 * </P>
	 * @param result �������ʒl���C�^�[
	 * @return �P��^���C�^�[���X�g
	 */
	List<SingleWriter> selectSingleAnserNo(ResultWriter result);

}
