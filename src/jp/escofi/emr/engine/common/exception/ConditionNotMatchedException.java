package jp.escofi.emr.engine.common.exception;

import jp.escofi.emr.engine.common.constant.MessageCode;

/**
 * �����s������O�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������茋�ʂɂ�鐬����������������ꍇ�A���������錟����O�N���X�B
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
@SuppressWarnings("serial")
public class ConditionNotMatchedException extends EMRException {

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 */
	public ConditionNotMatchedException(MessageCode errCode) {
		super(errCode);
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 * @param arguments �u��������̔z��
	 */
	public ConditionNotMatchedException(MessageCode errCode,
			Object[] arguments) {
		super(errCode, arguments);
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 * @param cause ������O
	 */
	public ConditionNotMatchedException(MessageCode errCode,
			Throwable cause) {
		super(errCode, cause);
	}
}
