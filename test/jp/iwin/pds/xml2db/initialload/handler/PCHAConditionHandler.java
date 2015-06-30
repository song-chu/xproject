package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;


/**
 * ���Z���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���Z���n���h���[�Q�����ʓI�ɍs��������Z�߂����ۃN���X��SAX�C�x���g�n���h���[�B�i���ۃN���X�j
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
 * @see PCHCompositeConditionHandler
 * @see PCHSingleConditionHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public abstract class PCHAConditionHandler extends PCHARuleHandler {

	/**
	 * �G�������g��`
	 */
	protected PCTElementType elementType;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param elementType �G�������g��`
	 * @see PCHCompositeConditionHandler
	 * @see PCHSingleConditionHandler
	 */
	public PCHAConditionHandler(PCHApplyHandler callerHandler, PCTElementType elementType) {

		super(callerHandler);

		this.elementType = elementType;
	}

}
