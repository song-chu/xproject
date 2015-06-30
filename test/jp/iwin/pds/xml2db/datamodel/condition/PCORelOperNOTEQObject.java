package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

/**
 * �������� Object�^NOTEQ���Z�B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1120 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 17:38:14 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTEQ
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperNOTEQObject extends PCOARelOperNOTEQ {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public PCORelOperNOTEQObject(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h��NOTEQ���Z���s���BObject.equals()�𗘗p����B
	 * BigDecimal��NOTEQ���Z��PCORelOperNOTEQBigDecimal�𗘗p���邱�ƁB
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		Object source = assign(this.items.get(0), argItems);
		Object target = assign(this.items.get(1), argItems);

		return (!source.equals(target));
	}
}
