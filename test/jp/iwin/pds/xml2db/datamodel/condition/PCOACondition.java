package jp.iwin.pds.xml2db.datamodel.condition;

import java.util.Map;

import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;

/**
 * ���Z�����ۃN���X�B<BR>
 * <BR>
 * IF��THEN�̊ԁA�J�b�R�̊J������J�b�R�����܂ł̕�����"���Z��"�Ƃ���B�i���Z���ɂ͘_�����Z���E�֌W���Z������j <BR>
 * ���Z���̓I�y�����h�Ɖ��Z�q�ō\�������B
 * <DL>
 * <DT>�ŏI�J�����r�W�����F
 * <DD>$Revision: 1115 $
 * <DT>�ŏI�J�������F
 * <DD>$Date: 2010-12-07 16:29:34 +0900 (火, 07 12 2010) $
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/12/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/12/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>
 * Copyright(c)2011 Nissay Information Technology Co.,Ltd.
 * </P>
 *
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public abstract class PCOACondition {

	/**
	 * ����̎��s�B
	 *
	 * @return �������茋��
	 */
	public abstract boolean judge(Map<String, Object> argItems);

	/**
	 * �����������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException  XML��̓G���[
	 */
	public abstract void toDump(PUTXMLWriter writer,
			Map<String, PROConditionItemInfo> conditionItemMap)
			throws SAXException;

}
