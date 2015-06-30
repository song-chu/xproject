package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * �������� Object�^NOTEQ���Z�B
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
public final class RelOperNOTEQObject extends AbstractRelOperNOTEQ {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public RelOperNOTEQObject(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h��NOTEQ���Z���s���BObject.equals()�𗘗p����B
	 * BigDecimal��NOTEQ���Z��RelOperNOTEQBigDecimal�𗘗p���邱�ƁB
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		Object source = assign(items.get(0), argItems);
		Object target = assign(items.get(1), argItems);

		return (!source.equals(target));
	}
}
