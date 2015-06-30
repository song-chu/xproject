package jp.iwin.pds.xml2db.common.exception;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.util.PUTMessageUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * �Ɩ���O�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�V�X�e���ŕԋp�����O�N���X�̐e�N���X�B������O�B<BR>
 *       ��O�̋�̓I�Ȍ��������ʂ��邽�߁A�G���[�R�[�h�B�G���[���b�Z�[�W��ێ�����B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1038 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:23:29 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PEXException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6376274209054407785L;
	/**
	 * ���O�o��
	 */
	private static final Log logger = LogFactory.getLog(PEXException.class);
	/**
	 * �G���[�R�[�h
	 */
	private PCTMessageCode errCode;
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
	public PCTMessageCode getErrCode() {
		return this.errCode;
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
		return this.errMessage;
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
	public PEXException(PCTMessageCode errCode) {

		super(PUTMessageUtil.getMessage(errCode.toString()));

		this.errCode = errCode;
		this.errMessage = PUTMessageUtil.getMessage(errCode.toString());

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
	public PEXException(PCTMessageCode errCode, Object[] arguments) {

		super(PUTMessageUtil.getMessage(errCode.toString(), arguments));

		this.errCode = errCode;
		this.errMessage = getMessage();

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
	public PEXException(PCTMessageCode errCode, Object[] arguments, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		this.errMessage = PUTMessageUtil.getMessage(errCode.toString(), arguments);

		logger.error(this.errMessage, cause);
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
	public PEXException(PCTMessageCode errCode, Throwable cause) {

		super(cause);

		this.errCode = errCode;
		this.errMessage = cause.getMessage();

		logger.error(errCode.toString(), cause);
	}


	/**
	 * �G���[���b�Z�[�W�o�́B
	 * <p>
	 * ���O�֔��������G���[�ɂ��Ẵ��b�Z�[�W���o�͂���B
	 * </P>
	 */
	private void outErrMessage() {
		StringBuilder sb = new StringBuilder("�G���[�R�[�h�F");

		sb.append(this.errCode);
		sb.append("�A�G���[���b�Z�[�W�F");
		sb.append(this.errMessage);

		logger.error(sb.toString());
	}

}
