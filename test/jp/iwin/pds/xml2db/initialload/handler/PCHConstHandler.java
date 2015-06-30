package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOOperandConst;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * �������萔�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������̒萔�i{@code <const>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see PCHSetHandler
 * @see PCHSingleHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHConstHandler extends PCHARuleHandler {

	/**
	 * �����l
	 */
	private Object value;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHConstHandler(PCHSingleConditionHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer=writer;
	}


	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �p�����N���X�ϐ��FXML���[�_�[�ɁA�G�������g�^�C�v�ɉ��������[���n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName);
		// �G�������g�^�C�v�擾
		PCTElementType elementType = PCTElementType.getType(qName);
		// ���[���n���h���[�擾
		PCHARuleHandler handler = PCHRuleHandlerFactory.createRuleHandler(elementType, this, this.writer);

		this.reader.setContentHandler(handler);
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���������萔�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�������ڒ萔���I�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɐ��������������ڒ萔���I�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.CONST.equals(qName)) {
			PCHSingleConditionHandler handler = (PCHSingleConditionHandler) this.callerHandler;
			PCOOperandConst itemConst = new PCOOperandConst(this.value);

			handler.getConditionItems().add(itemConst);
			this.reader.setContentHandler(handler);
		}
	}


	/**
	 * @param value �����l
	 * @see PCHSetHandler
	 * @see PCHSingleHandler
	 */
	void setValue(Object value) {
		this.value = value;
	}

}
