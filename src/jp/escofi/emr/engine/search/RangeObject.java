package jp.escofi.emr.engine.search;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �͈͌^�I�u�W�F�N�g�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>
 *    <UL>
 *     <LI> �͈͌^�̒l��ێ�����N���X�B
 *     <LI> �����l�I�u�W�F�N�g�Ɋi�[�����N���X�B
 *    </UL>
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
public class RangeObject {

	/**
	 * �����l�L���t���O
	 */
	private boolean hasLower;
	/**
	 * �����l
	 */
	private Object lower;
	/**
	 * �����l�܂ރt���O
	 */
	private boolean includeLower;
	/**
	 * ����l�L���t���O
	 */
	private boolean hasUpper;
	/**
	 * ����l
	 */
	private Object upper;
	/**
	 * ����l�܂ރt���O
	 */
	private boolean includeUpper;
	/**
	 * Java�f�[�^�^
	 */
	private String javaDataType;

	/**
	 * �����l�L���t���O�擾
	 * @return �����l�L���t���O
	 */
	public boolean hasLower() {
		return hasLower;
	}

	/**
	 * �����l�擾
	 * @return �����l
	 */
	public Object getLower() {
		return lower;
	}

	/**
	 * �����l�܂ރt���O�擾
	 * @return �����l�܂ރt���O
	 */
	public boolean includeLower() {
		return includeLower;
	}

	/**
	 * ����l�L���t���O�擾
	 * @return ����l�L���t���O
	 */
	public boolean hasUpper() {
		return hasUpper;
	}

	/**
	 * ����l�擾
	 * @return ����l
	 */
	public Object getUpper() {
		return upper;
	}

	/**
	 * ����l�܂ރt���O�擾
	 * @return ����l�܂ރt���O
	 */
	public boolean includeUpper() {
		return includeUpper;
	}

	/**
	 * ����Java�f�[�^�^�擾
	 * @return ����Java�f�[�^�^
	 */
	public String getJavaDataType() {
		return javaDataType;
	}

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�[�ϐ��̒l��ݒ肷�邱�ƂŁA
	 * �O�����烁���o�[�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B
	 * @param hasLower 		�����l�L���t���O
	 * @param lower			�����l
	 * @param includeLower	�����l�܂ރt���O
	 * @param hasUpper 		����l�L���t���O
	 * @param upper			����l
	 * @param includeUpper	����l�܂ރt���O
	 * @param javaDataType 	����Java�f�[�^�^
	 */
	public RangeObject(boolean hasLower, Object lower, boolean includeLower,
			boolean hasUpper, Object upper, boolean includeUpper, String javaDataType) {
		this.hasLower = hasLower;
		this.lower = lower;
		this.includeLower = includeLower;
		this.hasUpper = hasUpper;
		this.upper = upper;
		this.includeUpper = includeUpper;
		this.javaDataType = javaDataType;
	}

	/**
	 * �͈͌^�����l�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�͈͌^�����l�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	public void toDump(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.JAVA_DATA_TYPE.toString(),
				javaDataType);
		writer.startElement(ElementType.RANGE.toString(), atts);

		AttributesImpl upperAtts = new AttributesImpl();
		writer.addAttribute(upperAtts, AttributeType.EQ.toString(),
				Boolean.toString(includeUpper));
		if (upper == null) {
			writer.dataElement(ElementType.UPPER.toString(), upperAtts,
					"");
		} else {
			writer.dataElement(ElementType.UPPER.toString(), upperAtts,
					upper.toString());
		}

		AttributesImpl lowerAtts = new AttributesImpl();
		writer.addAttribute(lowerAtts, AttributeType.EQ.toString(),
				Boolean.toString(includeLower));
		if (lower == null) {
			writer.dataElement(ElementType.LOWER.toString(), lowerAtts,
					"");
		} else {
			writer.dataElement(ElementType.LOWER.toString(), lowerAtts,
					lower.toString());
		}
		writer.endElement(ElementType.RANGE.toString());
	}
}
