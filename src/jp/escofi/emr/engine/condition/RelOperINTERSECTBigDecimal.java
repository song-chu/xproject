package jp.escofi.emr.engine.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �������� BigDecimal�^INTERSECT���Z�B
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
public final class RelOperINTERSECTBigDecimal extends AbstractRelOperINTERSECT {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public RelOperINTERSECTBigDecimal(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h�iSET�j��INTERSECT���Z���s���B���ʗv�f����ȏ㑶�݂���ꍇTRUE��Ԃ��B<br>
	 * BigDecimal.compareTo()�𗘗p����B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isJudge(Map<String, Object> argItems) {
		Set<BigDecimal> source = (Set<BigDecimal>) assign(items.get(0), argItems);
		Set<BigDecimal> target = (Set<BigDecimal>) assign(items.get(1), argItems);

		for (BigDecimal elemTarget : source) {
			for (BigDecimal elemSource : target) {
				if (elemSource.compareTo(elemTarget) == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
