package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * �I�u�W�F�N�g�^���C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���I�u�W�F�N�g�̏ꍇ�A
 *�I�u�W�F�N�g�f�[�^�^�C�v�̃o�����[�i{@code <object>}�j�̗v�f���o�͂���XML���C�^�[�B
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
public final class ObjectWriter extends AbstractAttributeValueWriter {


	/**
	 * �R���X�g���N�^�B
	 * <UL>
	 *  <LI>XML�^�O��������������B</LI>
	 *  <LI>�q�^�O���Z�b�g��null������B</LI>
	 *  <LI>�^�O�̏o�͌`�����I���^�O�Ȃ��`���ɐݒ肷��B</LI>
	 * </UL>
	 */
	public ObjectWriter() {
		super(ElementType.OBJECT);
		childSet = null;
		isEmptyElement = true;
	}


	/**
	 * �N���X���ݒ�B
	 * <P>
	 * �^�O��classname�A�g���r���[�g�ɒl��ݒ�B
	 * </P>
	 * @param className �N���X��
	 */
	public void setClassName(String className) {
		setAttribute(AttributeType.CLASS_NAME, className);
	}

	/**
	 * �t�я��ݒ�B
	 * <P>
	 * �^�O��subinfo�A�g���r���[�g�ɒl��ݒ�B
	 * </P>
	 * @param subInfo �t�я��
	 */
	public void setSubInfo(String subInfo) {
		setAttribute(AttributeType.SUB_INFO, subInfo);
	}

}
