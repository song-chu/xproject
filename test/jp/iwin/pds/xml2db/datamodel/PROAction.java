package jp.iwin.pds.xml2db.datamodel;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * �������� �A�N�V�����B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1405 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-10 18:08:01 +0900 ( 10 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PROAction {

	/**
	 * �����l�I�u�W�F�N�g
	 */
	private PROResultObject resultObject;

	/**
	 * �����l�I�u�W�F�N�g�������o�[�ϐ��ɃZ�b�g����B
	 * @param resultObject �����l�I�u�W�F�N�g
	 */
	public PROAction(PROResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * �����l�I�u�W�F�N�g�̃Q�b�^�[���\�b�h�B
	 * @return resultObject �����l�I�u�W�F�N�g
	 */
	public PROResultObject getResultObject() {
		return resultObject;
	}

	/**
	 * ���ʃI�u�W�F�N�g�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���ʃI�u�W�F�N�g�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();

		writer.addAttribute(atts, PCTAttributeType.DATATYPE.toString(),
				this.resultObject.getDataType());
		writer.addAttribute(atts, PCTAttributeType.METAINFO.toString(),
				this.resultObject.getMetaInfo().toString());
		writer.addAttribute(atts, PCTAttributeType.DELFLG.toString(),
				Boolean.toString(this.resultObject.isDeleted()));
		writer.addAttribute(atts, PCTAttributeType.REF.toString(),
				this.toString());

		writer.startElement(PCTElementType.RESULT.toString(), atts);

		if (this.resultObject.getValue() == null) {
			writer.emptyElement(PCTElementType.EMPTY.toString());
		} else if (this.resultObject.getValue() instanceof List) {
			this.resultObject.toDumpList(writer);
		} else if (this.resultObject.getValue() instanceof Map) {
			this.resultObject.toDumpMap(writer);
		} else if (this.resultObject.getValue() instanceof PRORangeObject) {
			((PRORangeObject) this.resultObject.getValue()).toDump(writer);
		} else if (this.resultObject.getValue() instanceof PROObjObject) {
			((PROObjObject) this.resultObject.getValue()).toDump(writer);
		} else {
			this.resultObject.toDumpSingle(writer);
		}

		writer.endElement(PCTElementType.RESULT.toString());

	}
}
