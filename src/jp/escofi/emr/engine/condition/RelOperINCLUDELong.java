package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * �������� Long�^INCLUDE���Z�B
 * <DL>
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
public final class RelOperINCLUDELong extends AbstractRelOperINCLUDE {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public RelOperINCLUDELong(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * �����E�I�y�����h(Long)��INCLUDE���Z���s���BLong.compareTo()�𗘗p����B<br>
	 * ���I�y�����h�����E�I�y�����h�͈͓̔��̏ꍇ�ATRUE��Ԃ��B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	public boolean isJudge(Map<String,Object> argItems) {

		Long sourceS = (Long) assign(items.get(0), argItems);
		Long target = (Long) assign(items.get(1), argItems);
		Long sourceL = (Long) assign(items.get(2), argItems);

		if (lowerEq == true && upperEq == true) {
			if (sourceS.compareTo(target) <= 0 && sourceL.compareTo(target) >= 0) {
				return true;
			}
		} else if (lowerEq == true && upperEq == false) {
			if (sourceS.compareTo(target) <= 0 && sourceL.compareTo(target) > 0) {
				return true;
			}
		} else if (lowerEq == false && upperEq == true) {
			if (sourceS.compareTo(target) < 0 && sourceL.compareTo(target) >= 0) {
				return true;
			}
		} else if (lowerEq == false && upperEq == false) {
			if (sourceS.compareTo(target) < 0 && sourceL.compareTo(target) > 0) {
				return true;
			}
		}
		return false;
	}
}
