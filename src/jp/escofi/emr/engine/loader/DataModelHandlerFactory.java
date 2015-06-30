package jp.escofi.emr.engine.loader;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.xml.sax.XMLReader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.loader.DataModelHandlerFactory;


/**
 * �f�[�^���f���n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�f�[�^���f���n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
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
public final class DataModelHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private DataModelHandlerFactory() {}


	/**
	 * �f�[�^���f���n���h���[���������B
	 * <P>
	 * ��������f�[�^���f���n���h���[�ɂ͗\�߃L�[���ڃn���h���[���Z�b�g���Ă����B
	 * </P>
	 * @param reader SAX���[�_�[
	 * @param dataModel �f�[�^���f���̃G�������g���
	 * @param pdsObjectLocal ���[�J���ϐ���PDS�I�u�W�F�N�g�i�p�����p�̃e���|����Map�j
	 * @param itemKeys �L�[���ږ����X�g
	 * @return �f�[�^���f���n���h���[�̐V�K�C���X�^���X
	 */
	public static DataModelHandler createDataModelHandler(
			XMLReader reader, Element dataModel, Map<String, Object> pdsObjectLocal, List<String> itemKeys) {
		// �f�[�^���f����
		String dataModelName = dataModel.getAttribute(AttributeType.NAME.toString()).intern();

		// DataModelHandler����
		DataModelHandler dataModelHandler = new DataModelHandler(reader, dataModelName);

		// KeyItemHandler����
		KeyItemHandler keyItemHandler = KeyItemHandlerFactory.createKeyItemHandler(
				dataModelHandler, dataModel, pdsObjectLocal, itemKeys);

		// �\��KeyItemHandler���Z�b�g���Ă���
		dataModelHandler.setKeyItemHandler(keyItemHandler);

		return dataModelHandler;
	}

}
