package jp.escofi.emr.engine.condition;

import java.util.Map;

import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * ���Z�����ۃN���X�B<BR>
 * <BR>
 * IF��THEN�̊ԁA�J�b�R�̊J������J�b�R�����܂ł̕�����"���Z��"�Ƃ���B�i���Z���ɂ͘_�����Z���E�֌W���Z������j <BR>
 * ���Z���̓I�y�����h�Ɖ��Z�q�ō\�������B
 * <DL>
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/08/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public abstract class AbstractCondition {

	/**
	 * ����̎��s�B
	 *
	 * @param argItems �������ڂ�Map�^�I�u�W�F�N�g
	 * @return �������茋��
	 */
	public abstract boolean isJudge(Map<String, Object> argItems);

	/**
	 * �����������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	public abstract void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException;

}
