package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �I�y�����h�ϐ����N���X�B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1121 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 17:46:37 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOAOperand
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCOOperandVar extends PCOAOperand {

	/**
	 * �ϐ��i�������ځj��
	 */
	private String name;

	/**
	 * �������ږ��̃Z�b�^�[���\�b�h�B
	 * @param name �ϐ��i�������ځj��
	 */
	public PCOOperandVar(String name) {
		this.name = name;
	}

	/**
	 * �������ږ��̃Q�b�^�[���\�b�h�B
	 * @return �ϐ��i�������ځj��
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * �I�y�����h�ϐ����������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException XML��̓G���[
	 */
	protected void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.DATATYPE.toString(),
				conditionItemMap.get(this.name).getItemType());
		writer.addAttribute(atts, PCTAttributeType.JAVADATATYPE.toString(),
				conditionItemMap.get(this.name).getJavaDataType());
		writer.addAttribute(atts, PCTAttributeType.VARINFO.toString(),
				conditionItemMap.get(this.name).getSearchInfo().toString());
		writer.addAttribute(atts, PCTAttributeType.REF.toString(),
				conditionItemMap.get(this.name).toString());
		writer.dataElement(PCTElementType.VAR.toString(), atts, this.name);
	}

}
