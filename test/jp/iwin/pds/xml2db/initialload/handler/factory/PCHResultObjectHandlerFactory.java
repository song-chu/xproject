package jp.iwin.pds.xml2db.initialload.handler.factory;

import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.PCHARuleHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHResultHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHValueHandler;

import org.xml.sax.Attributes;


/**
 * �����l�n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�n���h���[�S�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1062 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date 2010-11-26 19:51:57 +0900 (��, 26 11 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
 * @see jp.iwin.pds.initialload.handler.PCHELSEHandler
 * @see jp.iwin.pds.initialload.handler.PCHKeyItemHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHResultObjectHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private PCHResultObjectHandlerFactory() {}


	/**
	 * �����l�n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @return �����l�n���h���[�̐V�K�C���X�^���X
	 * @see jp.iwin.pds.initialload.handler.PCHKeyItemHandler
	 */
	public static PCHValueHandler createValueHandler(
			PCHKeyItemHandler callerHandler, Attributes atts,String jpname) {

		return new PCHValueHandler(callerHandler, atts, jpname);
	}

	/**
	 * ���������ʃn���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @param rule ���[���I�u�W�F�N�g
	 * @param ifType �������^�C�v
	 * @return ���������ʃn���h���[�̐V�K�C���X�^���X
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 * @see jp.iwin.pds.initialload.handler.PCHELSEHandler
	 */
	public static PCHResultHandler createResultHandler(PCHARuleHandler callerHandler,
			Attributes atts, PROINIRule rule, PCTIFType ifType, XMLWriter writer) {

		return new PCHResultHandler(callerHandler, rule, ifType, atts, writer);
	}
}
