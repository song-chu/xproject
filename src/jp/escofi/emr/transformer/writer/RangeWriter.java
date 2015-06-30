package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * �͈͌^���C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���͈͂̏ꍇ�A
 *�͈̓f�[�^�^�C�v�̃o�����[�i{@code <range>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class RangeWriter extends AbstractAttributeValueWriter {

	/**
	 * ����l
	 */
	private String upper;
	/**
	 * ����l�܂ރt���O
	 */
	private boolean upperFlg;
	/**
	 * �����l
	 */
	private String lower;
	/**
	 * �����l�܂ރt���O
	 */
	private boolean lowerFlg;


	/**
	 * �R���X�g���N�^��XML�^�O��������������B
	 */
	public RangeWriter() {
		super(ElementType.RANGE);
	}


	/**
	 * @param upper �Z�b�g���� upper
	 */
	public void setUpper(String upper) {
		this.upper = upper;
	}
	/**
	 * @param upperFlg �Z�b�g���� upperFlg
	 */
	public void setUpperFlg(String upperFlg) {
		this.upperFlg = PDSConstants.TRUE.isEquals(upperFlg);
	}
	/**
	 * @param lower �Z�b�g���� lower
	 */
	public void setLower(String lower) {
		this.lower = lower;
	}
	/**
	 * @param lowerFlg �Z�b�g���� lowerFlg
	 */
	public void setLowerFlg(String lowerFlg) {
		this.lowerFlg = PDSConstants.TRUE.isEquals(lowerFlg);
	}


	/**
	 * �^�O���e�����o�͏����B
	 * <OL>
	 * <LI>upper�^�O��������</LI>
	 * <LI>lower�^�O��������</LI>
	 * </OL>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	@Override
	protected void outputBody(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		String attName = AttributeType.EQ.toString();
		String elementName;

		// upper�^�O��������
		elementName = ElementType.UPPER.toString();

		// �A�g���r���[�g���̃L�[���ڂ�������
		atts.addAttribute(PDSConstants.EMPTY.toString(), attName, attName,
				PDSConstants.CDATA.toString(), String.valueOf(upperFlg));

		writer.dataElement(elementName, atts, upper);

		// lower�^�O��������
		elementName = ElementType.LOWER.toString();

		atts.setValue(0, String.valueOf(lowerFlg));

		writer.dataElement(elementName, atts, lower);
	}

}
