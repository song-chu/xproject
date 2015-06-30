package jp.iwin.pds.xml2db.initialload.handler.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.initialload.handler.PCHDataModelHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;

import org.w3c.dom.Element;
import org.xml.sax.XMLReader;


/**
 * �f�[�^���f���n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f���n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1230 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-09 15:44:09 +0900 (木, 09 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.PILInitialLoader
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public final class PCHDataModelHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private PCHDataModelHandlerFactory() {}


	/**
	 * �f�[�^���f���n���h���[���������B
	 * <P>
	 * ��������f�[�^���f���n���h���[�ɂ͗\�߃L�[���ڃn���h���[���Z�b�g���Ă����B
	 * </P>
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 * @param reader SAX���[�_�[
	 * @param dataModel �f�[�^���f���̃G�������g���
	 * @param pdsObjectLocal ���[�J���ϐ���PDS�I�u�W�F�N�g�i�p�����p�̃e���|����Map�j
	 * @param itemKeys �L�[���ږ����X�g
	 * @return �f�[�^���f���n���h���[�̐V�K�C���X�^���X
	 */
	public static PCHDataModelHandler createDataModelHandler(
			XMLReader reader, Element dataModel, Map<String, Object> pdsObjectLocal, List<String> itemKeys,HashMap<String, List<String>> pdsItemKeysLocal) {
		// �f�[�^���f����
		String dataModelName = dataModel.getAttribute(PCTAttributeType.NAME.toString()).intern();

		// DataModelHandler����
		PCHDataModelHandler dataModelHandler = new PCHDataModelHandler(reader, dataModelName);

		// KeyItemHandler����
		PCHKeyItemHandler keyItemHandler = PCHKeyItemHandlerFactory.createKeyItemHandler(
				dataModelHandler, dataModel, pdsObjectLocal, itemKeys,pdsItemKeysLocal);

		// �\��KeyItemHandler���Z�b�g���Ă���
		dataModelHandler.setKeyItemHandler(keyItemHandler);

		return dataModelHandler;
	}

}
