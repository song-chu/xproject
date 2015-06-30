package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * �_�����Z�qOR�B
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
public final class LogicOperOR extends AbstractCompositeCondition {

	/**
	 * �R���X�g���N�^�B
	 * @param conditions	���Z����List
	 */
	public LogicOperOR(List<AbstractCondition> conditions) {
		super(conditions);
	}

	/**
	 * �_�����Z�qOR�̏���������s���B�P�̉��Z���ł�TRUE�ꍇ�ATRUE��Ԃ��B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 */
	@Override
	public boolean isJudge(Map<String, Object> argItems) {
		for (AbstractCondition condition : conditions) {
			boolean calcResult = condition.isJudge(argItems);
			if (calcResult) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �_�����ZOR�̏������������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	@Override
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(ElementType.OR.toString());
		for (AbstractCondition condition : conditions) {
			writer.startElement(ElementType.APPLY.toString());
			condition.toDump(writer, conditionItemMap);
			writer.endElement(ElementType.APPLY.toString());
		}
		writer.endElement(ElementType.OR.toString());
	}
}
