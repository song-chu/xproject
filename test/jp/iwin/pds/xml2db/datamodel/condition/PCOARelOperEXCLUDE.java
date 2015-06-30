package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �������� �֌W���Z��EXCLUDE�B
 * <DL>
 * <DT>�ŏI�J�����r�W�����F
 * <DD>$Revision: 1120 $
 * <DT>�ŏI�J�������F
 * <DD>$Date: 2010-12-07 17:38:14 +0900 (火, 07 12 2010) $
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/12/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/12/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>
 * Copyright(c)2011 Nissay Information Technology Co.,Ltd.
 * </P>
 *
 * @see jp.iwin.pds.datamodel.condition.PCOASingleCondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOARelOperEXCLUDE extends PCOASingleCondition {
	/**
	 * �����̋��E�l���܂ނ�(true:�܂�)
	 */
	protected boolean lowereq;
	/**
	 * ����̋��E�l���܂ނ�(true:�܂�)
	 */
	protected boolean uppereq;

	/**
	 * �R���X�g���N�^
	 *
	 * @param items
	 *            �{���Z�q�̃I�y�����h���X�g
	 */
	public PCOARelOperEXCLUDE(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * �����̋��E�l���܂ނ���ݒ肷��B
	 *
	 * @param lower
	 *            �����̋��E�l���܂ނ�
	 */
	public void setLowereq(boolean lowereq) {
		this.lowereq = lowereq;
	}

	/**
	 * ����̋��E�l���܂ނ���ݒ肷��B
	 *
	 * @param upper
	 *            ����̋��E�l���܂ނ�
	 */
	public void setUppereq(boolean uppereq) {
		this.uppereq = uppereq;
	}

	/**
	 * �֌W���ZEXCLUDE�̏������������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	@Override
	public void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.UPPEREQ.toString(),
				Boolean.toString(this.uppereq));
		writer.addAttribute(atts, PCTAttributeType.LOWEREQ.toString(),
				Boolean.toString(this.lowereq));
		writer.startElement(PCTElementType.EXCLUDE.toString(), atts);
		for (PCOAOperand item : this.items) {
			if (item instanceof PCOOperandVar) {
				((PCOOperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((PCOOperandConst) item).toDump(writer);
			}
		}
		writer.endElement(PCTElementType.EXCLUDE.toString());
	}

}
