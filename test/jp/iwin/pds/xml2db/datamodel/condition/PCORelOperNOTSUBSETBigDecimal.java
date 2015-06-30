package jp.iwin.pds.xml2db.datamodel.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �������� BigDecimal�^NOTSUBSET���Z�B
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
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTSUBSET
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCORelOperNOTSUBSETBigDecimal extends PCOARelOperNOTSUBSET {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public PCORelOperNOTSUBSETBigDecimal(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h�iBigDecimal��SET�j��NOTSUBSET���Z���s���B�W�����I�y�����h���W���E�I�y�����h�̕����W���ł͂Ȃ��ꍇTRUE��Ԃ��B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean judge(Map<String, Object> argItems) {

		Set<BigDecimal> source = (Set<BigDecimal>) assign(this.items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(this.items.get(1), argItems);

		boolean bool = false;

		for (BigDecimal elemSource : source) {
			bool = false;
			for (BigDecimal elemTarget : target) {
				if (elemSource.compareTo(elemTarget) == 0) {
					bool = true;
					break;
				}
			}

			if (bool == false) {
				return true;
			}
		}
		return false;
	}
}
