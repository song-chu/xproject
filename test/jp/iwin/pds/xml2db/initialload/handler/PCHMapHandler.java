package jp.iwin.pds.xml2db.initialload.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;

import org.xml.sax.Attributes;


/**
 * �}�b�v�^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v��Map�̏ꍇ�A
 *Map�f�[�^�^�C�v�̃o�����[�i{@code <map>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class PCHMapHandler extends PCHADelegateHandler {

	/**
	 * �ҏW�}�b�v
	 */
	private Map<String, Object> tempmap = new HashMap<String, Object>();
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
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHMapHandler(PCHAResultObjectHandler callerHandler, String javaDataType) {
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

		if (PCTElementType.ENTRY.equals(qName)) {
			String key = atts.getValue(PCTAttributeType.KEY.toString());

			this.mapKey = key.intern();
			this.buffer = new StringBuilder();
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

		if (this.mapKey != null) {
			this.buffer.append(ch, start, length);
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
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case ENTRY:

			if (0 < this.buffer.length()) {
				this.tempmap.put(this.mapKey,this.buffer.toString().intern());
			}
			this.mapKey = null;
			this.buffer = null;
			break;

		case MAP:
			Map<String,Object> map = Collections.unmodifiableMap(
					PUTConvertUtil.resizeMap(this.tempmap));
			PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;

			handler.setValue(map);
			handler.setJavaDataType(this.javaDataType);
			this.reader.setContentHandler(handler);
			this.tempmap = null;
			break;
		}
	}

}
