package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.search.RangeObject;

import org.xml.sax.Attributes;

/**
 * �͈͌^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���͈͌^�̏ꍇ�A
 *�͈̓f�[�^�^�C�v�̃o�����[�i{@code <range>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class RangeHandler extends AbstractDelegateHandler {

	/**
	 * �����l�L���t���O
	 */
	private boolean hasLower = false;
	/**
	 * �����l
	 */
	private Object lower = null;
	/**
	 * �����l�܂ރt���O
	 */
	private boolean includeLower = false;
	/**
	 * ����l�L���t���O
	 */
	private boolean hasUpper = false;
	/**
	 * ����l
	 */
	private Object upper = null;
	/**
	 * ����l�܂ރt���O
	 */
	private boolean includeUpper = false;
	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder buffer = null;

	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param javaDataType ����Java�f�[�^�^
	 */
	public RangeHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {

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
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			includeUpper = ConvertUtil.isConvertBoolean(
					atts.getValue(AttributeType.EQ.toString()));
			buffer = new StringBuilder();
			break;

		case LOWER:
			includeLower = ConvertUtil.isConvertBoolean(
					atts.getValue(AttributeType.EQ.toString()));
			buffer = new StringBuilder();
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

		if (buffer != null) {
			buffer.append(ch, start, length);
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
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case UPPER:
			if ("".equals(buffer.toString().trim())) {
				upper = null;
			} else {
				hasUpper = true;
				upper = ConvertUtil.convert(
						buffer.toString(), javaDataType);
			}
			buffer = null;
			break;

		case LOWER:
			if ("".equals(buffer.toString().trim())) {
				lower = null;
			} else {
				hasLower = true;
				lower = ConvertUtil.convert(
						buffer.toString(), javaDataType);
			}
			buffer = null;
			break;

		case RANGE:
			AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;
			RangeObject rangeObject = new RangeObject(hasLower, lower,
					includeLower, hasUpper, upper, includeUpper, javaDataType);

			handler.setValue(rangeObject);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			break;
		}
	}

}
