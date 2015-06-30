package jp.iwin.pds.xml2db.initialload.handler;

/**
 * Delegate�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�^�O�����p��Delegate�n���h���[�Q�̋��ʏ������L�ڂ���SAX�̃C�x���g�n���h���[�B�i���ۃN���X�j
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
 * @see PCHAResultObjectHandler
 * @see PCHARuleHandler
 * @see PCHELSEHandler
 * @see PCHIFHandler
 * @see PCHKeyItemHandler
 * @see PCHListHandler
 * @see PCHMapHandler
 * @see PCHObjectHandler
 * @see PCHRangeHandler
 * @see PCHResultHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public abstract class PCHADelegateHandler extends PCHAINIHandler {

	/**
	 * �ďo�����n���h���[
	 */
	protected PCHAINIHandler callerHandler;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @see PCHAResultObjectHandler
	 * @see PCHARuleHandler
	 * @see PCHKeyItemHandler
	 * @see PCHListHandler
	 * @see PCHMapHandler
	 * @see PCHObjectHandler
	 * @see PCHRangeHandler
	 */
	public PCHADelegateHandler(PCHAINIHandler callerHandler) {
		this.callerHandler = callerHandler;
		this.reader = callerHandler.reader;
		this.reader.setErrorHandler(this);
		this.globalConditionItemMap = callerHandler.globalConditionItemMap;
	}
}
