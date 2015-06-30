package jp.iwin.pds.xml2db.common.exception;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;

/**
 * �\���s�\��ԗ�O�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f����NULL�ȂǁA�V�X�e����\���s�\�ȏ�Ԃ�\��������O�N���X�B
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
@SuppressWarnings("serial")
public class PEXUnExpectedStateException extends PEXException {

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�e�N���X�̃R���X�g���N�^�[���Ăяo���A������n���B
	 * </DL>
	 * @param errCode �G���[�R�[�h
	 */
	public PEXUnExpectedStateException(PCTMessageCode errCode) {
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
	public PEXUnExpectedStateException(PCTMessageCode errCode,
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
	public PEXUnExpectedStateException(PCTMessageCode errCode, Throwable cause) {
		super(errCode, cause);
	}
}
