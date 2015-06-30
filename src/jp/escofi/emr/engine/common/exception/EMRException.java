package jp.escofi.emr.engine.common.exception;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.MessageUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * �Ɩ���O�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�V�X�e���ŕԋp�����O�N���X�̐e�N���X�B������O�B<BR>
 *       ��O�̋�̓I�Ȍ��������ʂ��邽�߁A�G���[�R�[�h�B�G���[���b�Z�[�W��ێ�����B
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
public class EMRException extends Exception {
	/**
	 * SERIALVERSIONUID
	 */
	private static final long serialVersionUID = 6376274209054407785L;
	/**
	 * ���O�o��
	 */
	private static final Log LOGGER = LogFactory.getLog(EMRException.class);
	/**
	 * �G���[�R�[�h
	 */
	private MessageCode errCode;
	/**
	 * �G���[���b�Z�[�W
	 */
	private String errMessage;

	/**
	 * �G���[�R�[�h�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�G���[�R�[�h��Ԃ��B
	 * </DL>
	 * @return the errCode
	 */
	public MessageCode getErrCode() {
		return errCode;
	}

	/**
	 * �G���[���b�Z�[�W�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�G���[���b�Z�[�W��Ԃ��B
	 * </DL>
	 * @return the errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 *   <BR>�G���[���e�����O�ɏo�͂���B
	 *   <BR>�G���[�R�[�h�̂ݎw�肷��ꍇ�i�Œ�̃��b�Z�[�W�𗘗p����ꍇ�j�B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 */
	public EMRException(MessageCode errCode) {

		super(MessageUtil.getMessage(errCode.toString()));

		this.errCode = errCode;
		errMessage = getMessage();

		outErrMessage();
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 *   <BR>�G���[���e�����O�ɏo�͂���B
	 *   <BR>��O�������̃G���[���b�Z�[�W��Ǝ��̂��̂ɂ���ꍇ�B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 * @param arguments �u��������̔z��
	 */
	public EMRException(MessageCode errCode, Object[] arguments) {

		super(MessageUtil.getMessage(errCode.toString(), arguments));

		this.errCode = errCode;
		errMessage = getMessage();

		outErrMessage();
	}

	/**
	 * �R���X�g���N�^(������O�t��)�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 *   <BR>�G���[���e�����O�ɏo�͂���B
	 *   <BR>��O�������̃G���[���b�Z�[�W��Ǝ��̂��̂ɂ���ꍇ�A��������O�̃g���[�X�����o�͂���ۂɗ��p�B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 * @param arguments �u��������̔z��
	 * @param cause ������O
	 */
	public EMRException(MessageCode errCode, Object[] arguments, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		errMessage = MessageUtil.getMessage(errCode.toString(), arguments);

		LOGGER.error(errMessage, cause);
	}

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A�����Ƃ��Č�����O���쐬�������b�Z�[�W��n���B
	 *   <BR>�G���[���e�����O�ɏo�͂���B
	 *   <BR>������O�̃g���[�X�����o�͂���ۂɗ��p�B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 * @param cause ������O
	 */
	public EMRException(MessageCode errCode, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		errMessage = MessageUtil.getMessage(errCode.toString());

		LOGGER.error(errCode.toString(), cause);
	}


	/**
	 * �G���[���b�Z�[�W�o�́B
	 * <p>
	 * ���O�֔��������G���[�ɂ��Ẵ��b�Z�[�W���o�͂���B
	 * </P>
	 */
	private void outErrMessage() {
		StringBuilder sb = new StringBuilder("�G���[�R�[�h�F");

		sb.append(errCode);
		sb.append("�A�G���[���b�Z�[�W�F");
		sb.append(errMessage);

		LOGGER.error(sb.toString());
	}

}
