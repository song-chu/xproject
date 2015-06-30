package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

/**
 * �������� Double�^EXCLUDE���Z�B
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
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperEXCLUDE
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperEXCLUDEDouble extends PCOARelOperEXCLUDE {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public PCORelOperEXCLUDEDouble(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * �����E�I�y�����h(Double)��EXCLUDE���Z���s���BDouble.compareTo()�𗘗p����B<br>
	 * ���I�y�����h�����E�I�y�����h�͈̔͊O�̏ꍇ�ATRUE��Ԃ��B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		Double sourceS = (Double) assign(this.items.get(0), argItems);
		Double target = (Double) assign(this.items.get(1), argItems);
		Double sourceL = (Double) assign(this.items.get(2), argItems);

		if (this.lowereq == true && this.uppereq == true) {
			if (sourceS.compareTo(target) >= 0 || sourceL.compareTo(target) <= 0) {
				return true;
			}
		} else if (this.lowereq == true && this.uppereq == false) {
			if (sourceS.compareTo(target) >= 0 || sourceL.compareTo(target) < 0) {
				return true;
			}
		} else if (this.lowereq == false && this.uppereq == true) {
			if (sourceS.compareTo(target) > 0 || sourceL.compareTo(target) <= 0) {
				return true;
			}
		} else if (this.lowereq == false && this.uppereq == false) {
			if (sourceS.compareTo(target) > 0 || sourceL.compareTo(target) < 0) {
				return true;
			}
		}
		return false;
	}
}
