package jp.escofi.emr.engine.condition;

import java.util.Map;

import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.search.ResultObject;

/**
 * �������� �������C���^�t�F�[�X�B
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
public interface Rule {
	/**
	 * ��������̎��s�B
	 * @param argItems �������ڂ�Map�^�I�u�W�F�N�g
	 * @return �����l�I�u�W�F�N�g
	 * @throws ConditionNotMatchedException �����s������O
	 */
	public ResultObject apply(Map<String, Object> argItems) throws ConditionNotMatchedException;
}
