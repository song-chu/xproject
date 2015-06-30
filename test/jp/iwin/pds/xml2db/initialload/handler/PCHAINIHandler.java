package jp.iwin.pds.xml2db.initialload.handler;

import java.util.Map;

import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


/**
 * �e�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�^�O�����p�̃n���h���[�Q�̋��ʏ������L�ڂ���SAX�̃C�x���g�n���h���[�B�i���ۃN���X�j
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1405 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-10 18:08:01 +0900 (� 10 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHADelegateHandler
 * @see PCHDataModelHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
abstract class PCHAINIHandler extends DefaultHandler {

	/**
	 * XML���[�_�[
	 */
	protected XMLReader reader;
	/**
	 * �������ڃ}�b�v
	 */
	protected Map<String, PROConditionItemInfo> globalConditionItemMap;

	/**
	 * �G���[���o�͏����B
	 * <P>
	 * XML��͗�O���V�X�e������throw����B<BR>
	 * �ڍׂȃG���[�n���h�����O�͉�͎��s�������ōs���B
	 * </P>
	 * @param e XML��͗�O
	 * @throws SAXException XML��͗�O
	 */
	@Override
	public void error(SAXParseException e) throws SAXException {
		throw e;
	}

	/**
	 * ��������Map���擾�iXML�QDB�j
	 * @return
	 */
	public Map<String, PROConditionItemInfo> getGlobalConditionItemMap() {
		return globalConditionItemMap;
	}
}
