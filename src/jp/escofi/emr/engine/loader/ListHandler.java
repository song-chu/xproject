package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;

import org.xml.sax.Attributes;


/**
 * ���X�g�^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v��List�̏ꍇ�A
 *List�f�[�^�^�C�v�̃o�����[�i{@code <list>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class ListHandler extends AbstractDelegateHandler {

	/**
	 * �ҏW���X�g
	 */
	private ArrayList<Object> tempList = new ArrayList<Object>();
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
	public ListHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {
		super(callerHandler);
		this.javaDataType = javaDataType;
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �Ώۃ^�O���G�������g�̏ꍇ�́A�N���X�ϐ��F�^�O���e�擾�o�b�t�@��V�KStringBuilder�ŏ���������B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (ElementType.ELEM.toString().equals(qName)) {
			buffer = new StringBuilder();
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
	 * �Ώۃ^�O���G�������g�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�N���X�ϐ��F�ҏW���X�g�ɕϊ������^�O���e��ǉ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * <P>
	 * �Ώۃ^�O�����X�g�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɕҏW�������X�g��ݒ肷��B</LI>
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

		switch(elementType) {
		case ELEM:

			tempList.add(ConvertUtil.convert(buffer.toString(),
					javaDataType));
			buffer = null;
			break;

		case LIST:
			tempList.trimToSize();

			List<Object> list = Collections.unmodifiableList(tempList);
			AbstractResultObjectHandler handler =
				(AbstractResultObjectHandler) callerHandler;

			handler.setValue(list);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			tempList = null;
			break;
		}
	}

}
