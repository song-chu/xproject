package jp.escofi.emr.engine.condition;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.PDSObjObject;
import jp.escofi.emr.engine.search.RangeObject;
import jp.escofi.emr.engine.search.ResultObject;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * �������� �A�N�V�����B
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
public class AbstractAction {

	/**
	 * �����l�I�u�W�F�N�g
	 */
	private ResultObject resultObject;

	/**
	 * �����l�I�u�W�F�N�g�������o�[�ϐ��ɃZ�b�g����B
	 * @param resultObject �����l�I�u�W�F�N�g
	 */
	public AbstractAction(ResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * �����l�I�u�W�F�N�g�̃Q�b�^�[���\�b�h�B
	 * @return resultObject �����l�I�u�W�F�N�g
	 */
	public ResultObject getResultObject() {
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
	protected void toDump(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();

		writer.addAttribute(atts, AttributeType.DATA_TYPE.toString(),
				resultObject.getDataType());
		writer.addAttribute(atts, AttributeType.META_INFO.toString(),
				resultObject.getMetaInfo().toString());
		writer.addAttribute(atts, AttributeType.DEL_FLG.toString(),
				Boolean.toString(resultObject.isDeleted()));
		writer.addAttribute(atts, AttributeType.REF.toString(),
				toString());

		writer.startElement(ElementType.RESULT.toString(), atts);

		if (resultObject.getValue() == null) {
			writer.emptyElement(ElementType.EMPTY.toString());
		} else if (resultObject.getValue() instanceof List) {
			resultObject.toDumpList(writer);
		} else if (resultObject.getValue() instanceof Map) {
			resultObject.toDumpMap(writer);
		} else if (resultObject.getValue() instanceof RangeObject) {
			((RangeObject) resultObject.getValue()).toDump(writer);
		} else if (resultObject.getValue() instanceof PDSObjObject) {
			((PDSObjObject) resultObject.getValue()).toDump(writer);
		} else {
			resultObject.toDumpSingle(writer);
		}

		writer.endElement(ElementType.RESULT.toString());

	}
}
