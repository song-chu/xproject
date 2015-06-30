package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * �_�����Z�qAND�B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1120 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 17:38:14 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOACompositeCondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCOLogicOperAND extends PCOACompositeCondition {

	/**
	 * �R���X�g���N�^�B
	 * @param conditions ���Z����List
	 */
	public PCOLogicOperAND(List<PCOACondition> conditions) {
		super(conditions);
	}

	/**
	 * �_�����Z�qAND�̏���������s���B�S�ẴR���f�B�V������TRUE�ꍇ�̂�TRUE��Ԃ��B
	 * @param argItems �������ڒl�}�b�v
	 * @return �������茋�ʃt���O
	 * @see jp.iwin.pds.datamodel.condition.PCOACondition#judge(java.util.Map)
	 */
	public boolean judge(Map<String, Object> argItems) {

		for (PCOACondition condition : conditions) {
			boolean calcResult = condition.judge(argItems);
			if (!calcResult) {
				return false;
			}
		}
		return true;
	}

	/**
	 * �_�����ZAND�̏������������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	@Override
	public void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		writer.startElement(PCTElementType.AND.toString());
		for (PCOACondition condition : this.conditions) {
			writer.startElement(PCTElementType.APPLY.toString());
			condition.toDump(writer, conditionItemMap);
			writer.endElement(PCTElementType.APPLY.toString());
		}
		writer.endElement(PCTElementType.AND.toString());
	}
}
