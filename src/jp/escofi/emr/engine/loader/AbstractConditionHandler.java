package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * ���Z���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���Z���n���h���[�Q�����ʓI�ɍs��������Z�߂����ۃN���X��SAX�C�x���g�n���h���[�B�i���ۃN���X�j
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
public abstract class AbstractConditionHandler extends AbstractRuleHandler {

	/**
	 * �G�������g��`
	 */
	protected ElementType elementType;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param elementType �G�������g��`
	 */
	public AbstractConditionHandler(ApplyHandler callerHandler, ElementType elementType) {

		super(callerHandler);

		this.elementType = elementType;
	}

}
