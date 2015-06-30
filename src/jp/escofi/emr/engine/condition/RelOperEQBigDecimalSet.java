package jp.escofi.emr.engine.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �������� BigDecimal�W���^EQ���Z�B
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
public final class RelOperEQBigDecimalSet extends AbstractRelOperEQ {

	/**
	 * �e�N���X�̃R���X�g���N�^���Ăяo���A������n���B
	 * @param items �{���Z�q�̃I�y�����hList
	 */
	public RelOperEQBigDecimalSet(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h��EQ���Z���s���BBigDecimal.compareTo()�𗘗p����B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isJudge(Map<String, Object> argItems) {

		Set<BigDecimal> source = (Set<BigDecimal>) assign(items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(items.get(1), argItems);

		boolean bool = false;
		if(source.size()!=target.size()){
			return false;
		}
		for (BigDecimal elemSource : source) {
			bool = false;
			for (BigDecimal elemTarget : target) {
				if (elemSource.compareTo(elemTarget) == 0) {
					bool = true;
					break;
				}
			}

			if (bool == false) {
				return false;
			}
		}
		return true;
	}
}
