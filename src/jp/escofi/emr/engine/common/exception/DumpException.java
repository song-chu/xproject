package jp.escofi.emr.engine.common.exception;

import jp.escofi.emr.engine.common.constant.MessageCode;

/**
 * �_���v��O�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�_���v���鎞�A����������O��\��������O�N���X�B
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
public class DumpException extends EMRException {

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 */
	public DumpException(MessageCode errCode) {
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
	public DumpException(MessageCode errCode, Object[] arguments) {
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
	public DumpException(MessageCode errCode, Throwable cause){
		super(errCode, cause);
	}

}
