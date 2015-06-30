package jp.iwin.pds.xml2db.dumptool;

import java.util.Comparator;

/**
 * �Z�b�R���p���[�^�N���X�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�Z�b�g�̗v�f���\�[�g���邽�߂ɗv�f���r����N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1129 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-08 10:49:00 +0900 (水, 08 12 2010) $
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
 * @author $Author: park.js $
 */
public class PDMSetComparator implements Comparator<Object> {

	/**
	 * �v�f��r�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>��̗v�f���r����B
	 * </DL>
	 * @param obj1 �v�f1
	 * @param obj2 �v�f2
	 * @return ��r����
	 */
	public int compare(Object obj1, Object obj2) {
		String val1 = obj1.toString();
		String val2 = obj2.toString();
		return val1.compareTo(val2);
	}

}
