package jp.escofi.emr.engine.loader;

import java.util.Map;

import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


/**
 * �e�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�^�O�����p�̃n���h���[�Q�̋��ʏ������L�ڂ���SAX�̃C�x���g�n���h���[�B�i���ۃN���X�j
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
abstract class AbstractINIHandler extends DefaultHandler {

	/**
	 * XML���[�_�[
	 */
	protected XMLReader reader;
	/**
	 * �������ڃ}�b�v
	 */
	protected Map<String, ConditionItemInfo> globalConditionItemMap;

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
}
