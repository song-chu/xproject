package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;
import jp.escofi.emr.transformer.sql.ValueMapper;


/**
 * �������ʒl���C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>�������ʒl�i{@code <result>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class ResultWriter extends AbstractRuleWriter {

	/**
	 * ���ʔԍ�
	 */
	private int anserNo;


	/**
	 * �R���X�g���N�^�B
	 * <OL>
	 *  <LI>�p�����N���X�̃R���X�g���N�^�ďo���B</LI>
	 *  <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@������������B</LI>
	 * </OL>
	 * @param callerWriter �ďo�������C�^�[
	 */
	ResultWriter(ConditionWriter callerWriter) {
		super(ElementType.RESULT, callerWriter);
		buffer = new StringBuilder();
	}


	/**
	 * @return �p�����N���X�ϐ��F�ďo�������C�^�[�̑�������ID
	 */
	public int getAttFieldID() {
		return callerWriter.mapper.getAttFieldID();
	}
	/**
	 * @return ���ʔԍ�
	 */
	public int getAnserNo() {
		return anserNo;
	}


	/**
	 * �^�O�I�������B
	 * <OL>
	 *    <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@����̏ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *    <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@�̓��e���A
	 *�p�����N���X�ϐ��F�^�O���e�ɕێ�����B</LI>
	 *  <LI>�����l���C�^�[���擾����B</LI>
	 *  <LI>�擾���������l���C�^�[���I�u�W�F�N�g�^���C�^�[�ȊO�́A
	 *�A�g���r���[�g���:javadatatype��ݒ肷��B</LI>
	 *  <LI>�����l���C�^�[�̍폜�t���O����
	 *   <OL>
	 *    <LI>�폜�t���O��true�̏ꍇ�́A�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɁA�_�~�[�����l���C�^�[���i�[����B</LI>
	 *    <LI>��L�ȊO�̏ꍇ�́A�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɁA�擾���������l���C�^�[���i�[����B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�A�g���r���[�g����ҏW����B</LI>
	 * </OL>
	 */
	@Override
	void endElement() throws EMRException {

		if (buffer.length() <= 0) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		value = buffer.toString();

		AttributeFieldMapper mapper = callerWriter.mapper;
		DataType dataType = mapper.getDataType();
		AbstractAttributeValueWriter child = getChildElement(dataType);

		// �I�u�W�F�N�g�^�ȊO�̓A�g���r���[�g���:javadatatype��ݒ肷��B
		if (DataType.OBJECT != dataType) {
			child.setJavaDataType(mapper.getJavaDataType());
		}

		// �폜�t���O����
		boolean isDelFlg = child.isDelFlg();

		if (isDelFlg) {
			childSet.add(EmptyWriter.getInstance());
		} else {
			childSet.add(child);
		}

		// �A�g���r���[�g���ҏW
		addAttribute(AttributeType.META_INFO, child.getMetaInfo());
		addAttribute(AttributeType.DATA_TYPE, dataType.toString());
		addAttribute(AttributeType.DEL_FLG, String.valueOf(isDelFlg));
	}

	/**
	 * �����l���C�^�[�擾�B
	 * <OL>
	 *  <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@�̓��e(�⍇���ԍ�)�𐔒l�Ƃ��Ď擾����B</LI>
	 *  <LI>�����F�f�[�^�^�ɉ����������l���C�^�[�擾���\�b�h���Ăяo���B</LI>
	 *  <LI>�����l���C�^�[���擾�o���Ȃ������A�܂��͕����擾�����ꍇ�́A
	 *�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�����l���C�^�[���擾�o�����ꍇ�́A�擾���������l���C�^�[��߂��B</LI>
	 * </OL>
	 * @param dataType �f�[�^�^
	 * @return �����l���C�^�[
	 * @throws EMRException �Ɩ���O<BR>
	 * - �����l���C�^�[���擾�ł��Ȃ������ꍇ<BR>
	 * - �����l���C�^�[���������擾���ꂽ�ꍇ
	 */
	private AbstractAttributeValueWriter getChildElement(DataType dataType) throws EMRException {
		ValueMapper mapper = callerWriter.session.getMapper(ValueMapper.class);
		List<? extends AbstractAttributeValueWriter> recList = null;

		anserNo = Integer.parseInt(value);

		switch (dataType) {
		case LIST:
			recList = mapper.selectListAnserNo(this);
			break;

		case MAP:
			recList = mapper.selectMapAnserNo(this);
			break;

		case OBJECT:
			recList = mapper.selectObjectAnserNo(this);
			break;

		case RANGE:
			recList = mapper.selectRangeAnserNo(this);
			break;

		case SINGLE:
			recList = mapper.selectSingleAnserNo(this);
			break;
		}

		if (recList.isEmpty() || 1 < recList.size()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}

		return recList.get(0);
	}

}
