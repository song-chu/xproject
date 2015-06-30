package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �������� �֌W���Z��INCLUDE�B
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
public abstract class AbstractRelOperINCLUDE extends AbstractSingleCondition {
	/**
	 * �����̋��E�l���܂ނ�(true:�܂�)
	 */
	protected boolean lowerEq;
	/**
	 * ����̋��E�l���܂ނ�(true:�܂�)
	 */
	protected boolean upperEq;

	/**
	 * �R���X�g���N�^
	 *
	 * @param items
	 *            �{���Z�q�̃I�y�����h���X�g
	 */
	public AbstractRelOperINCLUDE(List<AbstractOperand> items) {
		super(items);
	}

	/**
	 * �����̋��E�l���܂ނ���ݒ肷��B
	 *
	 * @param lowerEq
	 *            �����̋��E�l���܂ނ�
	 */
	public void setLowerEq(boolean lowerEq) {
		this.lowerEq = lowerEq;
	}

	/**
	 * ����̋��E�l���܂ނ���ݒ肷��B
	 *
	 * @param upperEq
	 *            ����̋��E�l���܂ނ�
	 */
	public void setUpperEq(boolean upperEq) {
		this.upperEq = upperEq;
	}

	/**
	 * �֌W���ZINCLUDE�̏������������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	@Override
	public void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.UPPER_EQ.toString(),
				Boolean.toString(upperEq));
		writer.addAttribute(atts, AttributeType.LOWER_EQ.toString(),
				Boolean.toString(lowerEq));
		writer.startElement(ElementType.INCLUDE.toString(), atts);
		for (AbstractOperand item : items) {
			if (item instanceof OperandVar) {
				((OperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((OperandConst) item).toDump(writer);
			}
		}
		writer.endElement(ElementType.INCLUDE.toString());
	}

}
