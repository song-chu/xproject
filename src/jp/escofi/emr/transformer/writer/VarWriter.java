package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.sql.ArgsElemMapper;
import jp.escofi.emr.transformer.sql.VarMapper;


/**
 * �I�y�����h�ϐ����C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�I�y�����h�ϐ��i{@code <var>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class VarWriter extends AbstractRuleWriter {

	/**
	 * �R���X�g���N�^�B
	 * <OL>
	 *  <LI>�p�����N���X�̃R���X�g���N�^�ďo���B</LI>
	 *  <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@������������B</LI>
	 * </OL>
	 * @param callerWriter �ďo�������C�^�[
	 */
	VarWriter(ConditionWriter callerWriter) {
		super(ElementType.VAR, callerWriter);
		buffer = new StringBuilder();
	}


	/**
	 * @return �p�����N���X�ϐ��F�ďo�������C�^�[�̃f�[�^���f��ID
	 */
	public int getDataModelID() {
		return callerWriter.dataModelID;
	}
	/**
	 * @return �p�����N���X�ϐ��F�^�O���e(�������ډp������)
	 */
	public String getName() {
		return value;
	}


	/**
	 * �^�O�I�������B
	 * <OL>
	 *  <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@����̏ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@�̓��e(�������ډp������)���A
	 *�p�����N���X�ϐ��F�^�O���e�ɕێ�����B</LI>
	 *  <LI>�����Ǘ����𒊏o����B</LI>
	 *  <LI>�����Ǘ���񂪎擾�ł��Ȃ��A�܂��͕������擾�����ꍇ�́A
	 *�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�����Ǘ����̍폜�t���O��true�̏ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�����Ǘ���񂩂�A�g���r���[�g����ҏW����B</LI>
	 * </OL>
	 * @throws EMRException �I�y�����h�ϐ���񂪎擾�ł��Ȃ������ꍇ�B
	 */
	@Override
	void endElement() throws EMRException {

		if (buffer.length() <= 0) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		value = buffer.toString();

		VarMapper mapper = callerWriter.session.getMapper(VarMapper.class);
		List<ArgsElemMapper> tmpList = mapper.select(this);

		if (tmpList.isEmpty() || 1 < tmpList.size()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		ArgsElemMapper vMapper = tmpList.get(0);

		if (vMapper.isDelFlg()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		// �A�g���r���[�g���ҏW
		addAttribute(AttributeType.JAVA_DATA_TYPE, vMapper.getJavaDataType());
		addAttribute(AttributeType.DATA_TYPE, vMapper.getDataType());
		addAttribute(AttributeType.VAR_INFO, vMapper.getVarInfo());
		addAttribute(AttributeType.JP_NAME, vMapper.getJpName());
	}

}
