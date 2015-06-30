package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PRORangeObject;

import org.xml.sax.Attributes;


/**
 * �͈͌^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���͈͌^�̏ꍇ�A
 *�͈̓f�[�^�^�C�v�̃o�����[�i{@code <range>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1059 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHRangeHandler extends PCHADelegateHandler {

	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * ����l�܂ރt���O
	 */
	private boolean includeUpper = false;
	/**
	 * �����l�܂ރt���O
	 */
	private boolean includeLower = false;
	/**
	 * ����l
	 */
	private Object upper = null;
	/**
	 * �����l
	 */
	private Object lower = null;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder buffer = null;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param javaDataType ����Java�f�[�^�^
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHRangeHandler(PCHAResultObjectHandler callerHandler, String javaDataType) {

		super(callerHandler);

		this.javaDataType = javaDataType;
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �Ώۃ^�O������l�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�N���X�ϐ��F����l�܂ރt���O�ɃA�g���r���[�g���̊܂ރt���O�̒l��ێ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��V�KStringBuilder�ŏ���������B</LI>
	 * </OL>
	 * <P>
	 * �Ώۃ^�O�������l�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�N���X�ϐ��F�����l�܂ރt���O�ɃA�g���r���[�g���̊܂ރt���O�̒l��ێ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��V�KStringBuilder�ŏ���������B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			this.includeUpper = Boolean.valueOf(
					atts.getValue(PCTAttributeType.EQ.toString()));
			this.buffer = new StringBuilder();
			break;

		case LOWER:
			this.includeLower = Boolean.valueOf(
					atts.getValue(PCTAttributeType.EQ.toString()));
			this.buffer = new StringBuilder();
			break;
		}
	}

	/**
	 * �^�O���e�����B
	 * <P>
	 * �擾�����^�O���e��������N���X�ϐ��F�^�O���e�擾�o�b�t�@�֊i�[����B
	 * </P>
	 * @param ch �擾�����^�O���e
	 * @param start �J�n�ʒu
	 * @param length �Ώە�����
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (this.buffer != null) {
			this.buffer.append(ch, start, length);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O������l�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�N���X�ϐ��F����l�ɕϊ������^�O���e��ǉ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * <P>
	 * �Ώۃ^�O�������l�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�N���X�ϐ��F�����l�ɕϊ������^�O���e��ǉ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * <P>
	 * �Ώۃ^�O���͈͌^�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɕҏW�����͈͏���ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F����Java�f�[�^�^��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			this.upper = this.buffer.toString().intern();
			this.buffer = null;
			break;

		case LOWER:
			this.lower = this.buffer.toString().intern();
			this.buffer = null;
			break;

		case RANGE:
			PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;
			PRORangeObject rangeObject = new PRORangeObject(this.lower,
					this.includeLower, this.upper, this.includeUpper);

			handler.setValue(rangeObject);
			handler.setJavaDataType(this.javaDataType);
			this.reader.setContentHandler(handler);
			break;
		}
	}

}
