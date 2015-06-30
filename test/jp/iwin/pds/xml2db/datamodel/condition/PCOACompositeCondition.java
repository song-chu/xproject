package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.List;

/**
 * �_�����Z���B�_�����Z���ɂ�AND��OR������B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1120 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 17:38:14 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.datamodel.condition.PCOACondition
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOACompositeCondition extends PCOACondition {

	/**
	 * �{�_�����Z�����\�����鉉�Z����List
	 */
	protected List<PCOACondition> conditions;

	/**
	 * ���Z�����X�g��ݒ肷��B
	 * @param conditions �{�_�����Z�����\�����鉉�Z����List
	 */
	public PCOACompositeCondition(List<PCOACondition> conditions) {
		this.conditions = conditions;
	}

}
