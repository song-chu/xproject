package jp.iwin.pds.xml2db.initialload.handler;

import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * �������J�b�R�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������̃J�b�R�i{@code <apply>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see PCHAConditionHandler
 * @see PCHCompositeConditionHandler
 * @see PCHSingleConditionHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHApplyHandler extends PCHARuleHandler {

	/**
	 * ������
	 */
	private PCOACondition condition;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHApplyHandler(PCHARuleHandler callerHandler, XMLWriter writer) {
		super(callerHandler);
		this.writer=writer;
	}


	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �p�����N���X�ϐ��FXML���[�_�[�ɁA�G�������g�^�C�v�ɉ��������Z�q�n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName,atts);
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHAConditionHandler handler = PCHRuleHandlerFactory.createConditionHandler(
				elementType, this, atts, this.writer);

		if (handler != null) {
			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���������J�b�R�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <UL>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[��IF���n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�ďo�����n���h���[����A�������I�u�W�F�N�g���擾����B</LI>
	 *    <LI>�������I�u�W�F�N�g�ɁA�N���X�ϐ��F��������ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[���_�����Z���n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�ďo�����n���h���[����A���������X�g���擾����B</LI>
	 *    <LI>���������X�g�ɃN���X�ϐ��F���������i�[����B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * <P>
	 * �ďo�����n���h���[���̏����̌�A�p�����N���X�ϐ��FXML���[�_�[�ɁA
	 *�p�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		this.writer.endElement(qName);
		if (PCTElementType.APPLY.equals(qName)) {

			if (this.callerHandler instanceof PCHIFHandler) {
				// IF����Ă΂ꂽ�� -- �Ă΂ꂽ�������ɉ��Z�����Z�b�g����B
				PCHIFHandler handler = (PCHIFHandler) this.callerHandler;

				handler.getRule().setPdsCondition(this.condition);
			} else {
				// �_�����Z���n���h���[����Ă΂ꂽ��
				PCHCompositeConditionHandler handler =
					(PCHCompositeConditionHandler) this.callerHandler;
				List<PCOACondition> conditionItems = handler.getConditions();

				conditionItems.add(this.condition);
			}
			this.reader.setContentHandler(this.callerHandler);
		}
	}


	/**
	 * @param condition ������
	 * @see PCHCompositeConditionHandler
	 * @see PCHSingleConditionHandler
	 */
	void setCondition(PCOACondition condition) {
		this.condition = condition;
	}

}
