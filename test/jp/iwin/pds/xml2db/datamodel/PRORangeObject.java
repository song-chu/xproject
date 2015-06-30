package jp.iwin.pds.xml2db.datamodel;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �͈̓I�u�W�F�N�g�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>
 *    <UL>
 *     <LI> �͈͌^�̒l��ێ�����N���X�B
 *     <LI> �����l�I�u�W�F�N�g�Ɋi�[�����N���X�B
 *    </UL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1104 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 15:13:14 +0900 (火, 07 12 2010) $
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
public class PRORangeObject {
	/**
	 * �����l
	 */
	private Object min;
	/**
	 * �����l�܂ރt���O
	 */
	private boolean includeMin;
	/**
	 * ����l
	 */
	private Object max;
	/**
	 * ����l�܂ރt���O
	 */
	private boolean includeMax;

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�[�ϐ��̒l��ݒ肷�邱�ƂŁA
	 * �O�����烁���o�[�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B
	 * @param min			�����l
	 * @param includeMin	�����l�܂ރt���O
	 * @param max			����l
	 * @param includeMax	����l�܂ރt���O
	 */
	public PRORangeObject(Object min, boolean includeMin, Object max,
			boolean includeMax) {
		this.min = min;
		this.includeMin = includeMin;
		this.max = max;
		this.includeMax = includeMax;
	}

	/**
	 * �����l�擾
	 * @return �����l
	 */
	public Object getMin() {
		return min;
	}

	/**
	 * �����l�܂ރt���O�擾
	 * @return �����l�܂ރt���O
	 */
	public boolean includeMin() {
		return includeMin;
	}

	/**
	 * ����l�擾
	 * @return ����l
	 */
	public Object getMax() {
		return max;
	}

	/**
	 * ����l�܂ރt���O�擾
	 * @return ����l�܂ރt���O
	 */
	public boolean includeMax() {
		return includeMax;
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
	protected void toDump(PUTXMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, PCTAttributeType.JAVADATATYPE.toString(),
				this.max.getClass().getName());
		writer.startElement(PCTElementType.RANGE.toString(), atts);

		AttributesImpl upperAtts = new AttributesImpl();
		writer.addAttribute(upperAtts, PCTAttributeType.EQ.toString(),
				Boolean.toString(this.includeMax));
		writer.dataElement(PCTElementType.UPPER.toString(), upperAtts,
				this.max.toString());

		AttributesImpl lowerAtts = new AttributesImpl();
		writer.addAttribute(lowerAtts, PCTAttributeType.EQ.toString(),
				Boolean.toString(this.includeMin));
		writer.dataElement(PCTElementType.LOWER.toString(), lowerAtts,
				this.min.toString());

		writer.endElement(PCTElementType.RANGE.toString());
	}

}
