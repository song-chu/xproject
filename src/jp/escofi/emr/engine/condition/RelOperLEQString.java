package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

/**
 * �������� String�^LEQ���Z�B
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
public final class RelOperLEQString extends AbstractRelOperLEQ {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public RelOperLEQString(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h��LEQ���Z���s���BString.compareTo()�𗘗p����B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		String source = (String) assign(items.get(0), argItems);
		String target = (String) assign(items.get(1), argItems);

		if (source.compareTo(target) <= 0) {
			return true;
		}

		return false;
	}
}
