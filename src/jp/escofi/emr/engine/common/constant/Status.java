package jp.escofi.emr.engine.common.constant;

/**
 * �������ʃX�e�[�^�X��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������ʃX�e�[�^�X���`����enum�N���X�B
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
public enum Status {
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
