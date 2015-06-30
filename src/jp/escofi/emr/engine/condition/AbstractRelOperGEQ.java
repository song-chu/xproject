package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * �������� �֌W���Z��GEQ�B
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
public abstract class AbstractRelOperGEQ extends AbstractSingleCondition {

	/**
	 * �e�N���X�̃R���X�g���N�^���Ăяo���A������n���B
	 *
	 * @param items
	 *            �{���Z�q�̃I�y�����h���X�g
	 */
	public AbstractRelOperGEQ(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * �֌W���ZGEQ�̏������������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	@Override
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(ElementType.GEQ.toString());
		for (AbstractOperand item : items) {
			if (item instanceof OperandVar) {
				((OperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((OperandConst) item).toDump(writer);
			}
		}
		writer.endElement(ElementType.GEQ.toString());
	}
}
