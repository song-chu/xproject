package jp.iwin.pds.xml2db.initialload.handler;

import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;


/**
 * ���[���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���[���n���h���[�S�̋��ʏ������L�ڂ���SAX�C�x���g�n���h���[�̐e�N���X�B�i���ۃN���X�j
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
 * @see PCHAConditionHandler
 * @see PCHApplyHandler
 * @see PCHConditionHandler
 * @see PCHConstHandler
 * @see PCHELSEHandler
 * @see PCHIFHandler
 * @see PCHSetHandler
 * @see PCHSingleConditionHandler
 * @see PCHSingleHandler
 * @see PCHVarHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public abstract class PCHARuleHandler extends PCHADelegateHandler {

	/**
	 * �������ڃ}�b�v
	 */
	protected Map<String, PROConditionItemInfo> conditionItemMap;
	protected StringBuilder sb = new StringBuilder();
	protected XMLWriter writer = new XMLWriter(sb);
//	protected Map<String,PROResultObject> resultMap ;


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �ďo�����n���h���[�����[���n���h���[�̃T�u�N���X�̏ꍇ�́A�������ڃ}�b�v�����p���B
	 * </P>
	 * @param callerHandler �ďo�����n���h���[
	 * @see PCHAConditionHandler
	 * @see PCHApplyHandler
	 * @see PCHConditionHandler
	 * @see PCHConstHandler
	 * @see PCHELSEHandler
	 * @see PCHIFHandler
	 * @see PCHSetHandler
	 * @see PCHSingleConditionHandler
	 * @see PCHSingleHandler
	 * @see PCHVarHandler
	 */
	public PCHARuleHandler(PCHADelegateHandler callerHandler) {

		super(callerHandler);

		if (callerHandler instanceof PCHARuleHandler) {
			this.conditionItemMap = ((PCHARuleHandler) callerHandler).conditionItemMap;
//			this.resultMap = ((PCHARuleHandler) callerHandler).resultMap;
		}
	}

}
