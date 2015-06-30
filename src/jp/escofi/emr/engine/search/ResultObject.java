package jp.escofi.emr.engine.search;

import java.util.List;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.condition.RuleInstance;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �����l�I�u�W�F�N�g�B
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
public final class ResultObject{

	/**
	 * ���ʒl<br>
	 * �P��l�AList�AMap�A�͈̓I�u�W�F�N�g�A���s�I�u�W�F�N�g
	 */
	private Object value;

	/**
	 * �f�[�^�^
	 */
	private String dataType;

	/**
	 * �����f�[�^�^
	 */
	private String javaDataType;

	/**
	 * �폜�t���O
	 */
	private boolean delFlg;

	/**
	 * ���^���
	 */
	private String metaInfo;

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�[�ϐ��̒l��ݒ肷�邱�ƂŁA
	 * �O�����烁���o�[�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B
	 * @param value				���ʒl
	 * @param dataType			�f�[�^�^
	 * @param javaDataType		�����f�[�^�^
	 * @param delFlg			�폜�t���O
	 * @param metaInfo			���^���
	 */
	public ResultObject(Object value, String dataType,
			String javaDataType, boolean delFlg, String metaInfo) {
		this.value = value;
		this.dataType = dataType;
		this.javaDataType = javaDataType;
		this.delFlg = delFlg;
		this.metaInfo = metaInfo;
	}

	/**
	 * �f�[�^�^�擾
	 * @return	�f�[�^�^
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * ���ʒl�擾
	 * @return	���ʒl
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * �����f�[�^�^�擾
	 * @return �����f�[�^�^
	 */
	public String getJavaDataType() {
		return javaDataType;
	}

	/**
	 * �폜�t���O�擾
	 * @return delflg	�폜�t���O
	 */
	public boolean isDeleted() {
		return delFlg;
	}

	/**
	 * ���^���擾
	 * @return metaInfo	���^���
	 */
	public String getMetaInfo() {
		return metaInfo;
	}

	/**
	 * �����l�I�u�W�F�N�g�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����l�I�u�W�F�N�g�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	public void toDump(XMLWriter writer) throws SAXException {

		AttributesImpl atts = new AttributesImpl();
		if (value instanceof RuleInstance) {
			writer.addAttribute(atts, AttributeType.COND_FLG.toString(),
					Boolean.TRUE.toString());
		} else if (delFlg) {
			writer.addAttribute(atts, AttributeType.COND_FLG.toString(), "");
		} else {
			writer.addAttribute(atts, AttributeType.COND_FLG.toString(),
					Boolean.FALSE.toString());
		}
		writer.addAttribute(atts, AttributeType.DATA_TYPE.toString(),
				dataType);
		writer.addAttribute(atts, AttributeType.META_INFO.toString(),
				metaInfo.toString());
		writer.addAttribute(atts, AttributeType.DEL_FLG.toString(),
				Boolean.toString(delFlg));
		writer.addAttribute(atts, AttributeType.REF.toString(),
				toString());

		writer.startElement(ElementType.VALUE.toString(), atts);


		if (value == null) {
			writer.emptyElement(ElementType.EMPTY.toString());
		}else if (value instanceof RuleInstance) {
			((RuleInstance) value).toDump(writer);
		} else if (value instanceof List) {
			toDumpList(writer);
		} else if (value instanceof Map) {
			toDumpMap(writer);
		} else if (value instanceof RangeObject) {
			((RangeObject) value).toDump(writer);
		} else if (value instanceof PDSObjObject) {
			((PDSObjObject) value).toDump(writer);
		} else {
			toDumpSingle(writer);
		}

		writer.endElement(ElementType.VALUE.toString());

	}

	/**
	 * �����f�[�^�^�C�v�A�g���r���[�g����
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����f�[�^�^�C�v�A�g���r���[�g��������B
	 * </DL>
	 * @param writer ���C�^�[
	 * @param value �A�g���r���[�g�̒l
	 * @return Attributes �A�g���r���[�g
	 */
	private Attributes makeJavaDataTypeAttr(XMLWriter writer, String value){
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts,AttributeType.JAVA_DATA_TYPE.toString(),value);
		return atts;
	}


	/**
	 * �P�ꑮ���l�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�P�ꑮ���l�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	public void toDumpSingle(XMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);
		writer.dataElement(ElementType.SINGLE.toString(),atts,value.toString());
	}

	/**
	 * List�^�����l�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>List�^�����l�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	@SuppressWarnings("unchecked")
	public void toDumpList(XMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(ElementType.LIST.toString(),atts);

		List<Object> list = (List<Object>) value;
		for(Object obj: list){
			writer.dataElement(ElementType.ELEM.toString(),obj.toString());
		}
		writer.endElement(ElementType.LIST.toString());
	}

	/**
	 * Map�^�����l�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>Map�^�����l�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	@SuppressWarnings("unchecked")
	public void toDumpMap(XMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(ElementType.MAP.toString(),atts);

		Map<String,Object> map = (Map<String, Object>) value;
		List<Map.Entry<String, Object>> entries = ConvertUtil.sortMap(map);
		for (Map.Entry<String, Object> entry : entries){
			AttributesImpl entryAtts = new AttributesImpl();
			writer.addAttribute(entryAtts,AttributeType.KEY.toString(), entry.getKey());
			writer.dataElement(ElementType.ENTRY.toString(),entryAtts,entry.getValue().toString());
		}
		writer.endElement(ElementType.MAP.toString());
	}
}
