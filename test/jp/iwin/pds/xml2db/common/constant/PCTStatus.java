package jp.iwin.pds.xml2db.common.constant;

/**
 * �������ʃX�e�[�^�X��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������ʃX�e�[�^�X���`����enum�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1037 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:21:17 +0900 (火, 07 12 2010) $
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
public enum PCTStatus {
	/**
	 * �X�e�[�^�X�F����
	 */
	NORMAL,
	/**
	 * �X�e�[�^�X�F�Y�������Ȃ�
	 */
	ATTR_NOT_FOUND,
	/**
	 * �X�e�[�^�X�FTreeMap�L�[�Y���Ȃ�
	 */
	TREEMAP_KEY_NOT_FOUND,
	/**
	 * �X�e�[�^�X�F�폜��
	 */
	DELETED,
}
