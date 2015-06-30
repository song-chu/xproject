package jp.escofi.emr.engine.loader;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.condition.OperandVar;
import jp.escofi.emr.engine.search.ConditionItemInfo;


/**
 * �������ϐ��n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������̕ϐ��i{@code <var>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class VarHandler extends AbstractRuleHandler {

	/**
	 * �f�[�^�^
	 */
	private String dataType;
	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �������ڎ擾���
	 */
	private List<String> varInfo;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder buffer = new StringBuilder();


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param dataType �f�[�^�^
	 * @param javaDataType ����Java�f�[�^�^
	 * @param varInfo �������ڎ擾���
	 */
	public VarHandler(SingleConditionHandler callerHandler, String dataType,
			String javaDataType, List<String> varInfo) {

		super(callerHandler);

		this.dataType = dataType;
		this.javaDataType = javaDataType;
		this.varInfo = varInfo;
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
	 * �Ώۃ^�O���������ϐ��̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�Ɩ����b�p�[�ԋp�p�������ڏ������B</LI>
	 * <LI>�擾�����^�O���e�𕶎��񉻂���B</LI>
	 * <LI>�擾�����^�O���e���A�O���[�o���̈������ڏ��}�b�v�Ɋ܂܂��ꍇ�A
	 *�O���[�o���̈������ڏ��}�b�v����������ڏ����擾����B</LI>
	 * <LI>�擾�����^�O���e���A�O���[�o���̈������ڏ��}�b�v�Ɋ܂܂�Ȃ��ꍇ�A
	 *�������ڏ��𐶐����A�O���[�o���̈������ڏ��}�b�v�֊i�[����B</LI>
	 * <LI>�擾�����������ڏ����A�p�����N���X�ϐ��F�������ڏ��}�b�v�֊i�[����B</LI>
	 * <LI>�擾�����^�O���e����A�������ϐ��I�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɐ��������������ϐ��I�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F�f�[�^�^��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F����Java�f�[�^�^��ݒ肷��B</LI>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.VAR.toString().equals(qName)) {
			// �Ɩ����b�p�[�ԋp�p�������ڏ������B
			String name = buffer.toString().intern();
			ConditionItemInfo conditionItemInfo;

			//�O���[�o���̈������ڏ��Map�ɂ��邩�ۂ����f
			if (globalConditionItemMap.containsKey(name)) {
				//����ꍇ�͎Q�Ƃ��A�T�C��
				conditionItemInfo = globalConditionItemMap.get(name);
			} else {
				//�����ꍇ�͐������O���[�o���ɃZ�b�g
				conditionItemInfo = new ConditionItemInfo(name,
					dataType, javaDataType, varInfo);
				globalConditionItemMap.put(name, conditionItemInfo);
			}
			conditionItemMap.put(name, conditionItemInfo);

			// ���Z�q�iSingleCondition�j�Ƀf�[�^�^�C�v���Z�b�g����B��const�I�u�W�F�N�g�ɃZ�b�g�����B
			SingleConditionHandler handler = (SingleConditionHandler) callerHandler;
			OperandVar itemVar = new OperandVar(name);

			handler.addConditionItem(dataType, itemVar);
			handler.setJavaDataType(javaDataType);
			reader.setContentHandler(handler);
			buffer = null;
		}
	}
}
