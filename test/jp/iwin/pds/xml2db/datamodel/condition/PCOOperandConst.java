package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;

/**
 * �I�y�����h�萔���N���X�B
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
public final class PCOOperandConst extends PCOAOperand {

	/**
	 * �����o�[�ϐ��Ɉ����̒l��ݒ肷��B
	 * @param value �萔�̒l
	 */
	public PCOOperandConst(Object value) {
		this.value = value;
	}

	/**
	 * �I�y�����h�萔���������o���B
	 *
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	@SuppressWarnings("unchecked")
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		writer.startElement(PCTElementType.CONST.toString());
		if (this.value instanceof Set) {
			writer.startElement(PCTElementType.SET.toString());
			List<Object> list = PUTConvertUtil
					.sortSet((Set<Object>) this.value);
			for (Object elem : list) {
				writer.dataElement(PCTElementType.ELEM.toString(),
						elem.toString());
			}
			writer.endElement(PCTElementType.SET.toString());
		} else {
			writer.dataElement(PCTElementType.SINGLE.toString(),
					this.value.toString());
		}
		writer.endElement(PCTElementType.CONST.toString());
	}
}
