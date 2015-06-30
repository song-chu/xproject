package jp.iwin.pds.xml2db.datamodel;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �����l�I�u�W�F�N�g�B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1768 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-17 13:15:18 +0900 (�17 12 2010) $
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
 * @author $Author: park.js $
 */
public final class PROResultObject{

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
	private boolean delflg;

	/**
	 * ���^���
	 */
	private String metaInfo;

	private String jpname;

	public String getJpname() {
		return jpname;
	}

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�[�ϐ��̒l��ݒ肷�邱�ƂŁA
	 * �O�����烁���o�[�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B
	 * @param value				���ʒl
	 * @param dataType			�f�[�^�^
	 * @param javaDataType		�����f�[�^�^
	 * @param delflg			�폜�t���O
	 * @param metaInfo			���^���
	 */
	public PROResultObject(Object value, String dataType,
			String javaDataType, boolean delflg, String metaInfo, String jpname) {
		this.value = value;
		this.dataType = dataType;
		this.javaDataType = javaDataType;
		this.delflg = delflg;
		this.metaInfo = metaInfo;
		this.jpname= jpname;

	}

	/**
	 * �f�[�^�^�擾
	 * @return	�f�[�^�^
	 */
	public String getDataType() {
		return this.dataType;
	}

	/**
	 * ���ʒl�擾
	 * @return	���ʒl
	 */
	public Object getValue() {
		return this.value;
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
		return delflg;
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
	public void toDump(PUTXMLWriter writer) throws SAXException {

		AttributesImpl atts = new AttributesImpl();
		if (this.value instanceof PRORule) {
			writer.addAttribute(atts, PCTAttributeType.CONDFLG.toString(),
					Boolean.TRUE.toString());
		} else if (this.delflg) {
			writer.addAttribute(atts, PCTAttributeType.CONDFLG.toString(), "");
		} else {
			writer.addAttribute(atts, PCTAttributeType.CONDFLG.toString(),
					Boolean.FALSE.toString());
		}
		writer.addAttribute(atts, PCTAttributeType.DATATYPE.toString(),
				this.dataType);
		writer.addAttribute(atts, PCTAttributeType.METAINFO.toString(),
				this.metaInfo.toString());
		writer.addAttribute(atts, PCTAttributeType.DELFLG.toString(),
				Boolean.toString(this.delflg));
		writer.addAttribute(atts, PCTAttributeType.REF.toString(),
				this.toString());

		writer.startElement(PCTElementType.VALUE.toString(), atts);


		if (this.value == null) {
			writer.emptyElement(PCTElementType.EMPTY.toString());
		}else if (this.value instanceof PRORule) {
			((PRORule) this.value).toDump(writer);
		} else if (this.value instanceof List) {
			toDumpList(writer);
		} else if (this.value instanceof Map) {
			toDumpMap(writer);
		} else if (this.value instanceof PRORangeObject) {
			((PRORangeObject) this.value).toDump(writer);
		} else if (this.value instanceof PROObjObject) {
			((PROObjObject) this.value).toDump(writer);
		} else {
			toDumpSingle(writer);
		}

		writer.endElement(PCTElementType.VALUE.toString());

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
	private Attributes makeJavaDataTypeAttr(PUTXMLWriter writer, String value){
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts,PCTAttributeType.JAVADATATYPE.toString(),value);
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
	protected void toDumpSingle(PUTXMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);
		writer.dataElement(PCTElementType.SINGLE.toString(),atts,this.value.toString());
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
	protected void toDumpList(PUTXMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(PCTElementType.LIST.toString(),atts);

		List<Object> list = (List<Object>) this.value;
		for(Object obj: list){
			writer.dataElement(PCTElementType.ELEM.toString(),obj.toString());
		}
		writer.endElement(PCTElementType.LIST.toString());
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
	protected void toDumpMap(PUTXMLWriter writer) throws SAXException{
		Attributes atts = makeJavaDataTypeAttr(writer,javaDataType);

		writer.startElement(PCTElementType.MAP.toString(),atts);

		Map<String,Object> map = (Map<String, Object>) this.value;
		List<Map.Entry<String, Object>> entries = PUTConvertUtil.sortMap(map);
		for (Map.Entry<String, Object> entry : entries){
			AttributesImpl entryAtts = new AttributesImpl();
			writer.addAttribute(entryAtts,PCTAttributeType.KEY.toString(), entry.getKey());
			writer.dataElement(PCTElementType.ENTRY.toString(),entryAtts,entry.getValue().toString());
		}
		writer.endElement(PCTElementType.MAP.toString());
	}
}
