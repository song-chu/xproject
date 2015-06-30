package jp.iwin.pds.xml2db.datamodel.condition.factory;

import java.util.List;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACompositeCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOACondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOLogicOperAND;
import jp.iwin.pds.xml2db.datamodel.condition.PCOLogicOperOR;


/**
 * �_�����Z���iAND/OR�j�̐�����S������Facroty�N���X
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1040 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:25:55 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOARelOperNOTINTERSECT
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCOCompositeConditionFactory {

	/**
	 * ���E�I�y�����h�iObject��SET�j��NOTINTERSECT���Z���s���B���ʗv�f���P�����݂��Ȃ��ꍇ�ATRUE��Ԃ��B
	 * @param conditions ���Z���̃��X�g
	 * @param conditionType ���Z�q���
	 * @return �_�����Z��
	 */
	public static PCOACompositeCondition createCompositeCondition(List<PCOACondition> conditions,
			PCTConditionType conditionType) {

		if (conditionType.equals(PCTConditionType.CONDITION_AND)) {
			return new PCOLogicOperAND(conditions);
		} else {
			return new PCOLogicOperOR(conditions);
		}
	}
}