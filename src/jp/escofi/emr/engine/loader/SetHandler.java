package jp.escofi.emr.engine.loader;

import java.util.HashSet;
import java.util.Set;

import jp.escofi.emr.engine.common.constant.ElementType;

import org.xml.sax.Attributes;


/**
 * �Z�b�g�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������ڂ̃f�[�^�^�C�v��Set�̏ꍇ�A�萔���i��onst�j��Set�i{@code <set>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class SetHandler extends AbstractRuleHandler {

	/**
	 * �����l�Z�b�g
	 */
	private Set<String> set = new HashSet<String>();
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder buffer = null;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 */
	public SetHandler(ConstHandler callerHandler) {
		super(callerHandler);
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
	 * <LI>�N���X�ϐ��F�����l�Z�b�g�ɁA�����񉻂����N���X�ϐ��F�^�O���e�擾�o�b�t�@��ǉ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * <P>
	 * �Ώۃ^�O���Z�b�g�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F�����l�Z�b�g��ݒ肷��B</LI>
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
		case ELEM:
			String str = buffer.toString();

			set.add(str);
			buffer = null;
			break;

		case SET:
			ConstHandler handler = (ConstHandler)callerHandler;

			handler.setDataType(elementType.toString());
			handler.setStrSetValue(set);
			reader.setContentHandler(callerHandler);
			break;
		}
	}
}
