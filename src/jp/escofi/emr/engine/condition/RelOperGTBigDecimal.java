package jp.escofi.emr.engine.condition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * �������� BigDecimal�^GT���Z�B
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
public final class RelOperGTBigDecimal extends AbstractRelOperGT {

	/**
	 * �R���X�g���N�^
	 * @param items	�{���Z�q�̃I�y�����h���X�g
	 */
	public RelOperGTBigDecimal(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * ���E�I�y�����h�iBigDecimal�j��GT���Z���s���BBigDecimal.compareTo()�𗘗p����B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {

		BigDecimal source = (BigDecimal) assign(items.get(0), argItems);
		BigDecimal target = (BigDecimal) assign(items.get(1), argItems);

		if (source.compareTo(target) > 0) {
			return true;
		}
		return false;
	}
}
