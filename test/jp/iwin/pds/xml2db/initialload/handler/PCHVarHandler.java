package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.condition.PCOOperandVar;


/**
 * �������ϐ��n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������̕ϐ��i{@code <var>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class PCHVarHandler extends PCHARuleHandler {

	/**
	 * �f�[�^�^
	 */
	private String _dataType;
	/**
	 * ����Java�f�[�^�^
	 */
	private String _javaDataType;
	/**
	 * �������ڎ擾���
	 */
	private String _varInfo;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder _buffer = new StringBuilder();

	private String _jpname;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param dataType �f�[�^�^
	 * @param javaDataType ����Java�f�[�^�^
	 * @param varInfo �������ڎ擾���
	 * @param jpname �������ړ��{�ꖼ
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHVarHandler(PCHSingleConditionHandler callerHandler, String dataType,
			String javaDataType, String varInfo, String jpname, XMLWriter writer) {

		super(callerHandler);

		_jpname = jpname;
		_dataType = dataType;
		_javaDataType = javaDataType;
		_varInfo = varInfo;
		this.writer = writer;
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

		if (_buffer != null) {
			_buffer.append(ch, start, length);
			writer.characters(ch, start, length);
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
		this.writer.endElement(qName);
		if (PCTElementType.VAR.equals(qName)) {
			// �Ɩ����b�p�[�ԋp�p�������ڏ������B
			List<String> varInfoList;
			String name = _buffer.toString().intern();
			PROConditionItemInfo conditionItemInfo;

			if (0 < _varInfo.length()) {
				varInfoList = PUTConvertUtil.parseCSV(_varInfo);
			} else {
				varInfoList = new ArrayList<String>(1);
				varInfoList.add(_varInfo);
			}

			//�O���[�o���̈������ڏ��Map�ɂ��邩�ۂ����f
			if (globalConditionItemMap.containsKey(name)) {
				//����ꍇ�͎Q�Ƃ��A�T�C��
				conditionItemInfo = globalConditionItemMap.get(name);
			} else {
				//�����ꍇ�͐������O���[�o���ɃZ�b�g
				conditionItemInfo = new PROConditionItemInfo(name,
					_dataType, _javaDataType, varInfoList, _jpname);
				globalConditionItemMap.put(name, conditionItemInfo);
			}
			conditionItemMap.put(name, conditionItemInfo);

			// ���Z�q�iSingleCondition�j�Ƀf�[�^�^�C�v���Z�b�g����B��const�I�u�W�F�N�g�ɃZ�b�g�����B
			PCHSingleConditionHandler handler = (PCHSingleConditionHandler) callerHandler;
			PCOOperandVar itemVar = new PCOOperandVar(name);

			handler.getConditionItems().add(itemVar);
			handler.setDataType(_dataType);
			handler.setJavaDataType(_javaDataType);
			reader.setContentHandler(handler);
			_buffer = null;
		}
	}
}
