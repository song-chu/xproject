package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.XMLWriter;


/**
 * �P��^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̑����^�C�v��Single�̏ꍇ�A
 *�P��f�[�^�^�C�v�̃o�����[�i{@code <single>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PCHSingleHandler extends PCHARuleHandler {

	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder buffer = new StringBuilder();


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSingleHandler(PCHConstHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer = writer;
	}

	/**
	 * �R���X�g���N�^(����Java�f�[�^�^�t��)�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param javadatatype ����Java�f�[�^�^
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHSingleHandler(PCHAResultObjectHandler callerHandler, String javadatatype) {

		super(callerHandler);

		this.javaDataType = javadatatype;
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

		if (this.buffer != null) {
			this.buffer.append(ch, start, length);
			this.writer.characters(ch, start, length);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���P��^�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <UL>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�������l�n���h���[�S�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɕϊ������^�O���e��ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F����Java�f�[�^�^��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[���������萔�n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�Ɏ擾�����^�O���e��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * <P>
	 * ��L�̌ďo�����n���h���[���̏����̌�ɁA�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.SINGLE.equals(qName)) {
			String str = this.buffer.toString();

			if (this.callerHandler instanceof PCHAResultObjectHandler) {
				PCHAResultObjectHandler handler = (PCHAResultObjectHandler) this.callerHandler;
				Object value = str;

				handler.setValue(value);
				handler.setJavaDataType(this.javaDataType);
			} else {
				this.writer.endElement(qName);
				((PCHConstHandler) this.callerHandler).setValue(str);
			}
			this.reader.setContentHandler(this.callerHandler);
			this.buffer = null;
		}
	}

}
