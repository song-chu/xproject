package jp.escofi.emr.engine.loader;


/**
 * Delegate�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�^�O�����p��Delegate�n���h���[�Q�̋��ʏ������L�ڂ���SAX�̃C�x���g�n���h���[�B�i���ۃN���X�j
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
public abstract class AbstractDelegateHandler extends AbstractINIHandler {

	/**
	 * �ďo�����n���h���[
	 */
	protected AbstractINIHandler callerHandler;


	/**
	 * �R���X�g���N�^�B
	 * @param callerHandler �ďo�����n���h���[
	 */
	public AbstractDelegateHandler(AbstractINIHandler callerHandler) {
		this.callerHandler = callerHandler;
		reader = callerHandler.reader;
		reader.setErrorHandler(this);
		globalConditionItemMap = callerHandler.globalConditionItemMap;
	}
}
