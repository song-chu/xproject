package jp.iwin.pds.xml2db.initialload.handler;

import java.util.HashSet;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;

import org.xml.sax.Attributes;


/**
 * �Z�b�g�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������ڂ̃f�[�^�^�C�v��Set�̏ꍇ�A�萔���i��onst�j��Set�i{@code <set>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHSetHandler extends PCHARuleHandler {

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
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSetHandler(PCHConstHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer= writer;
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

		if (PCTElementType.ELEM.equals(qName)) {
			this.buffer = new StringBuilder();
		}else{
			this.writer.startElement(qName, atts);
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
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case ELEM:

			String str = this.buffer.toString().intern();
			this.writer.dataElement(qName, str);
			this.set.add(str);
			this.buffer = null;
			break;

		case SET:
			this.writer.endElement(qName);
			((PCHConstHandler)this.callerHandler).setValue(this.set);
			this.reader.setContentHandler(this.callerHandler);
			break;
		}
	}
}
