package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACompositeCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;
import jp.iwin.pds.xml2db.datamodel.condition.factory.PCOCompositeConditionFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * �_�����Z���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f��XML�̈ȉ��̃^�O�ɑΉ�����SAX�C�x���g�n���h���[�B
 *    <UL>
 *     <LI>{@code <and>}</LI>
 *     <LI>{@code <or>}</LI>
 *    </UL>
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
 * @see PCHApplyHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHCompositeConditionHandler extends PCHAConditionHandler {

	/**
	 * ���������X�g
	 */
	private List<PCOACondition> conditions = new ArrayList<PCOACondition>();


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHCompositeConditionHandler(
			PCHApplyHandler callerHandler, PCTElementType elementType, XMLWriter writer) {
		super(callerHandler, elementType);
		this.writer = writer ;
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �Ώۃ^�O���������J�b�R�̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�ɁA
	 *�������J�b�R�n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName, atts);
		if (PCTElementType.APPLY.equals(qName)) {
			PCHApplyHandler handler = PCHRuleHandlerFactory.createApplyHandler(this, this.writer);

			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Q�ƒ��̃^�O������擾�����G�������g��`���A�N���X�ϐ��F�G�������g��`�Ɠ���̏ꍇ�́A
	 *�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�����������I�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɁA�������������������I�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�ɁA�p�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);
		this.writer.endElement(qName);

		if (this.elementType.equals(elementType)) {
			PCHApplyHandler handler = (PCHApplyHandler) this.callerHandler;
			PCTConditionType conditionType = getConditionType(elementType);
			PCOACompositeCondition compositeCondition =
				PCOCompositeConditionFactory.createCompositeCondition(
						this.conditions, conditionType);

			handler.setCondition(compositeCondition);
			this.reader.setContentHandler(handler);
		}
	}


	/**
	 * @return ���������X�g
	 * @see PCHApplyHandler
	 */
	List<PCOACondition> getConditions() {
		return this.conditions;
	}


	/**
	 * ���Z�q��`�擾�B
	 * <P>
	 * �G�������g��`�ɉ��������Z�q��`���擾����B
	 * </P>
	 * @param elementType �G�������g��`
	 * @return ���Z�q��`
	 */
	private PCTConditionType getConditionType(PCTElementType elementType) {
		PCTConditionType ret = null;

		switch (elementType) {
		case AND:
			ret = PCTConditionType.CONDITION_AND;
			break;

		case OR:
			ret = PCTConditionType.CONDITION_OR;
			break;
		}

		return ret;
	}

}
