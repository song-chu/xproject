package jp.escofi.emr.engine.loader;

import java.util.Set;

import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.OperandConst;

import org.xml.sax.Attributes;


/**
 * �������萔�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������̒萔�i{@code <const>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class ConstHandler extends AbstractRuleHandler {

	/**
	 * �f�[�^�^
	 */
	private String dataType;
	/**
	 * �ϊ��O�����l�i�P��l�j
	 */
	private String strValue;
	/**
	 * �ϊ��O�����l�i�Z�b�g�j
	 */
	private Set<String> strSetValue;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 */
	public ConstHandler(SingleConditionHandler callerHandler) {
		super(callerHandler);
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

		// �G�������g�^�C�v�擾
		ElementType elementType = ElementType.getType(qName);
		// ���[���n���h���[�擾
		AbstractRuleHandler handler = RuleHandlerFactory.createRuleHandler(elementType, this);

		reader.setContentHandler(handler);
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

		if (ElementType.CONST.toString().equals(qName)) {
			SingleConditionHandler handler = (SingleConditionHandler) callerHandler;
			OperandConst itemConst = null;

			switch (DataType.getType(dataType)) {
			case SINGLE:
				itemConst = new OperandConst(strValue);
				break;
			case SET:
				itemConst = new OperandConst(strSetValue);
				break;
			}
			handler.addConditionItem(dataType, itemConst);
			reader.setContentHandler(handler);
		}
	}


	/**
	 * @param dataType �f�[�^�^
	 */
	void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * @param value �����l
	 */
	void setStrValue(String value) {
		strValue = value;
	}
	/**
	 * @param value �����l
	 */
	void setStrSetValue(Set<String> value) {
		strSetValue = value;
	}

}
