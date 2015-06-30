package jp.iwin.pds.xml2db.datamodel.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * �������� BigDecimal�^EQ���Z�B
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
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperEQ
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperEQBigDecimal extends PCOARelOperEQ {

	/**
	 * �e�N���X�̃R���X�g���N�^���Ăяo���A������n���B
	 * @param items �{���Z�q�̃I�y�����hList
	 */
	public PCORelOperEQBigDecimal(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h��EQ���Z���s���BBigDecimal.compareTo()�𗘗p����B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		BigDecimal source = (BigDecimal) assign(this.items.get(0), argItems);
		BigDecimal target = (BigDecimal) assign(this.items.get(1), argItems);

		if (source.compareTo(target) == 0) {
			return true;
		}
		return false;
	}
}
