package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * �������� �֌W���Z��IN�B
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
public abstract class PCOARelOperIN extends PCOASingleCondition {

	/**
	 * �R���X�g���N�^�B
	 *
	 * @param items
	 *            �{���Z�q�̃I�y�����h���X�g
	 */
	public PCOARelOperIN(List<PCOAOperand> items) {
		super(items);
	}

	/**
	 * �֌W���ZIN�̏������������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	@Override
	public void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(PCTElementType.IN.toString());
		for (PCOAOperand item : this.items) {
			if (item instanceof PCOOperandVar) {
				((PCOOperandVar) item).toDump(writer, conditionItemMap);
			} else {
				((PCOOperandConst) item).toDump(writer);
			}
		}
		writer.endElement(PCTElementType.IN.toString());
	}
}
