package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;

import org.xml.sax.Attributes;


/**
 * �}�b�v�^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v��Map�̏ꍇ�A
 *Map�f�[�^�^�C�v�̃o�����[�i{@code <map>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class MapHandler extends AbstractDelegateHandler {

	/**
	 * �ҏW�}�b�v
	 */
	private Map<String, Object> tempMap = new HashMap<String, Object>();
	/**
	 * �}�b�v�L�[
	 */
	private String mapKey;
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
	public MapHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {
		super(callerHandler);
		this.javaDataType = javaDataType;
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �Ώۃ^�O���G���g���[�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�N���X�ϐ��F�}�b�v�L�[�ɃA�g���r���[�g���̃}�b�v�L�[�̒l��ێ�����B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��V�KStringBuilder�ŏ���������B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (ElementType.ENTRY.toString().equals(qName)) {
			mapKey = atts.getValue(AttributeType.KEY.toString()).intern();
			buffer = new StringBuilder();
		}
	}

	/**
	 * �^�O���e�����B
	 * <p>
	 * �擾�����^�O���e��������N���X�ϐ��F�^�O���e�擾�o�b�t�@�֊i�[����B
	 * </p>
	 * @param ch �擾�����^�O���e
	 * @param start �J�n�ʒu
	 * @param length �Ώە�����
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (mapKey != null) {
			buffer.append(ch, start, length);
		}
	}

	/**
	 * �^�O�I�������B
	 * <p>
	 * �Ώۃ^�O���G���g���[�̏ꍇ�́A�ȉ��̏������s���B
	 * </p>
	 * <ul>
	 * <li>�N���X�ϐ��F�ҏW�}�b�v�ɕϊ������^�O���e��ǉ�����B</li>
	 * <li>�N���X�ϐ��F�}�b�v�L�[��null�ɂ���B</li>
	 * <li>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</li>
	 * </ul>
	 * <p>
	 * �Ώۃ^�O���}�b�v�̏ꍇ�́A�ȉ��̏������s���B
	 * </p>
	 * <ul>
	 * <li>�p�����N���X�ϐ��F�ďo�����n���h���[�ɕҏW�����}�b�v��ݒ肷��B</li>
	 * <li>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F����Java�f�[�^�^��ݒ肷��B</li>
	 * <li>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</li>
	 * </ul>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case ENTRY:

			tempMap.put(mapKey, ConvertUtil.convert(buffer
					.toString(), javaDataType));
			mapKey = null;
			buffer = null;
			break;

		case MAP:
			Map<String,Object> map = Collections.unmodifiableMap(
					ConvertUtil.resizeMap(tempMap));
			AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;

			handler.setValue(map);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			tempMap = null;
			break;
		}
	}

}
