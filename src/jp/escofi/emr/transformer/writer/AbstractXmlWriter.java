package jp.escofi.emr.transformer.writer;

import java.util.LinkedHashSet;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;


/**
 * �eXML���C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>XML�^�O�o�͏����̋��ʕ������`����B
 *   <DD>���������C�^�[�ŁA
 *DB����擾����XML����������͂��ăp�����[�^�����擾���鏈�����K�v�ȈׁA
 *SAX��DefaultHandler���p�����Ă���B
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
public abstract class AbstractXmlWriter extends DefaultHandler {

	/**
	 * �o�̓^�O��ʁB
	 */
	protected ElementType elementType;
	/**
	 * �A�g���r���[�g���B
	 */
	protected AttributesImpl atts = new AttributesImpl();
	/**
	 * �q�^�O�Z�b�g�B
	 */
	protected Set<AbstractXmlWriter> childSet = new LinkedHashSet<AbstractXmlWriter>();
	/**
	 * �^�O���e�B
	 */
	protected String value = PDSConstants.EMPTY.toString();
	/**
	 * �I���^�O�Ȃ��B
	 * <P>
	 * true:�I���^�O�Ȃ��`���Afalse:�J�n��I���^�O�`���B<BR>
	 * �ʏ�͊J�n��I���^�O�`���ŏo�͂���B�I���^�O�Ȃ��`���ŏo�͂���ꍇ�́A
	 *�T�u�N���X���̃R���X�g���N�^�ŁA���̒l��true�ɂ���B
	 * </P>
	 */
	protected boolean isEmptyElement = false;


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �R���X�g���N�^��XML�^�O��������������B
	 * </P>
	 * @param elementType �o�̓^�O���
	 */
	protected AbstractXmlWriter(ElementType elementType) {
		this.elementType = elementType;
	}

	/**
	 * @param value �^�O���e
	 */
	public final void setValue(String value) {
		this.value = value;
	}


	/**
	 * �A�g���r���[�g�ǉ������B
	 * <P>
	 * �A�g���r���[�g���ɃA�g���r���[�g��ǉ�����B<BR>
	 * �A�g���r���[�g���ɏ����ރA�g���r���[�g�l�̃f�[�^�^�C�v��CDATA�B
	 * </P>
	 * @param attribute �A�g���r���[�g�^�C�v��`
	 * @param value �A�g���r���[�g�l
	 */
	protected final void addAttribute(AttributeType attribute, String value) {

		if (value == null) {
			return;
		}
		String attName = attribute.toString();

		atts.addAttribute(PDSConstants.EMPTY.toString(), attName,
				attName, PDSConstants.CDATA.toString(), value);
	}

	/**
	 * �A�g���r���[�g�ݒ菈���B
	 * <P>
	 * �w�肵���A�g���r���[�g����ݒ肷��B<BR>
	 * �V�K�A�g���r���[�g�̏ꍇ�̓A�g���r���[�g���ɒǉ�����B<BR>
	 * �A�g���r���[�g���ɏ����ރA�g���r���[�g�l�̃f�[�^�^�C�v��CDATA�B
	 * </P>
	 * @param attribute �A�g���r���[�g�^�C�v��`
	 * @param value �A�g���r���[�g�l
	 */
	protected final void setAttribute(AttributeType attribute, String value) {

		if (value == null) {
			return;
		}
		String attName = attribute.toString();
		int index = atts.getIndex(attName);

		if (-1 < index) {
			atts.setAttribute(index, PDSConstants.EMPTY.toString(), attName,
					attName, PDSConstants.CDATA.toString(), value);
		} else {
			addAttribute(attribute, value);
		}
	}

	/**
	 * �A�g���r���[�g�l�擾�B
	 *
	 * @param attribute �擾����A�g���r���[�g�^�C�v��`
	 * @return �擾����A�g���r���[�g�̒l
	 */
	protected final String getAttribute(AttributeType attribute) {
		String attName = attribute.toString();

		return atts.getValue(attName);
	}

	/**
	 * �A�g���r���[�g�폜�����B
	 * <P>
	 * �A�g���r���[�g��񂩂�A�g���r���[�g���폜����B<BR>
	 * ���ɍ폜�ς݂̏ꍇ�͉������Ȃ��B
	 * </P>
	 * @param attribute �폜����A�g���r���[�g�^�C�v��`
	 */
	protected final void removeAttribute(AttributeType attribute) {
		String attName = attribute.toString();
		int index = atts.getIndex(attName);

		if (-1 < index) {
			atts.removeAttribute(index);
		}
	}

	/**
	 * �^�O�J�n�����o�͏����B
	 * <P>
	 * �^�O�J�n�������o�͂���B<BR>
	 * ���̑��ɏ������K�v�ȏꍇ�́A���̃��\�b�h���I�[�o���C�h����B
	 * </P>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	protected void startElement(XMLWriter writer) throws SAXException {
		String elementName = elementType.toString();

		if (isEmptyElement) {
			writer.emptyElement(elementName, atts);
		} else {
			writer.startElement(elementName, atts);
		}
	}

	/**
	 * �^�O���e�����o�͏����B
	 * <P>
	 * �q�^�O�Z�b�g�Ɋi�[���ꂽ�n���h���[�̃^�O���e�����o�͏��������s����B<BR>
	 * �q�^�O�Z�b�g����̏ꍇ�́A�^�O���e���o�͂���B<BR>
	 * ���̑��ɏ������K�v�ȏꍇ�́A���̃��\�b�h���I�[�o���C�h����B
	 * </P>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	protected void outputBody(XMLWriter writer) throws SAXException {

		if (!isEmptyElement) {

			if (childSet.isEmpty()) {
				writer.characters(value);
			} else {

				for (AbstractXmlWriter child : childSet) {
					child.write(writer);
				}
			}
		}
	}

	/**
	 * �^�O�I�������o�͏����B
	 * <P>
	 * �^�O�I���������o�͂���B<BR>
	 * ���̑��ɏ������K�v�ȏꍇ�́A���̃��\�b�h���I�[�o���C�h����B
	 * </P>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	protected void endElement(XMLWriter writer) throws SAXException {

		if (!isEmptyElement) {
			writer.endElement(elementType.toString());
		}
	}


	/**
	 * XML�^�O�o�͏����B
	 * <OL>
	 *  <LI>�^�O�J�n�����o�͏���</LI>
	 *  <LI>�^�O���e�����o�͏���</LI>
	 *  <LI>�^�O�I�������o�͏���</LI>
	 *  <LI>�q�^�O���N���A����</LI>
	 * </OL>
	 * <P>
	 * �^�O�Ǝ��̏o�͏������K�v�ȏꍇ�́A���̃��\�b�h���I�[�o���C�h����B
	 * </P>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	void write(XMLWriter writer) throws SAXException {
		startElement(writer);
		outputBody(writer);
		endElement(writer);
		childSet = null;
	}

}
