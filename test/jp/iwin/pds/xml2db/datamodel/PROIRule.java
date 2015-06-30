package jp.iwin.pds.xml2db.datamodel;

import java.util.Map;

import jp.iwin.pds.xml2db.common.exception.PEXConditionNotMatchedException;

/**
 * �������� �������C���^�t�F�[�X�B
 * <DL>
 *	<DT>�ŏI�J�����r�W�����F
 *	 <DD>$Revision: 1047 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:49:56 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.PROINIRule
 * @see jp.iwin.pds.datamodel.PRORule
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public interface PROIRule {
	/**
	 * ��������̎��s�B
	 * @param argItems �������ڂ�Map�^�I�u�W�F�N�g
	 * @return �����l�I�u�W�F�N�g
	 * @throws PEXConditionNotMatchedException �����s������O
	 */
	public PROResultObject apply(Map<String, Object> argItems) throws PEXConditionNotMatchedException;
}
