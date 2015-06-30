package jp.escofi.emr.engine.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;

import org.xml.sax.Attributes;


/**
 * �L�[���ڃn���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�i{@code <value>}�j�v�f�������܂ŁA����key�����v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public class KeyItemHandler extends AbstractDelegateHandler {

	/**
	 * �L�[���ږ����X�g
	 */
	protected List<String> keyNameList = new ArrayList<String>();
	/**
	 * �����l�I�u�W�F�N�g
	 */
	protected Object objValue = null;
	/**
	 * �q�f�[�^���f�����}�b�v
	 */
	protected Map<String, Object> dataModelMap;
	/**
	 * �L�[���ڃ��X�g
	 */
	protected List<String> keys;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 */
	public KeyItemHandler(DataModelHandler callerHandler) {

		super(callerHandler);

		dataModelMap = callerHandler.getDataModelMap();
		keys = callerHandler.getKeys();
	}


	/**
	 * �^�O�J�n�����B
	 * <UL>
	 *  <LI>�Q�ƒ��̃^�O�������l�̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�̃n���h���[�ɁA
	 *�����l�n���h���[��ݒ肷��B</LI>
	 *  <LI>�Q�ƒ��̃^�O����L�ȊO�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�N���X�ϐ��F�q�f�[�^���f�����}�b�v����A
	 *�L�[���ڃ��X�g�̍Ō�̍��ڂ̃f�[�^���f���}�b�v���擾����B</LI>
	 *    <LI>�A�g���r���[�g��񂩂�A�f�[�^���f�������擾����B</LI>
	 *    <LI>�A�g���r���[�g��񂩂�A�L�[���ڂ��擾����B</LI>
	 *    <LI>�擾�����f�[�^���f�����ɑΉ�����f�[�^���f���̃}�b�v�C���X�^���X���擾����B</LI>
	 *    <LI>�擾�����f�[�^���f���}�b�v�ɁA�擾�����}�b�v�C���X�^���X���i�[����B</LI>
	 *    <LI>�N���X�ϐ��F�L�[���ڃ��X�g�ɁA�擾�����L�[���ڂ��i�[����B</LI>
	 *    <LI>�N���X�ϐ��F�L�[���ږ����X�g�ɁA�擾�����f�[�^���f�������i�[����B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case VALUE:
			ValueHandler handler = ResultObjectHandlerFactory.createValueHandler(
					this, atts);
			reader.setContentHandler(handler);

			break;

		default:
			Map<String, Object> map = getDataModelMap(dataModelMap, keys);
			String keyName = atts.getValue(AttributeType.NAME.toString()).intern();
			String key = atts.getValue(AttributeType.KEY.toString()).intern();

			if (map != null) {
				Map<String, Object> childMap;

				if (AttributeType.ATTR_NAME.isEquals(keyName)) {
					childMap = new TreeMap<String, Object>();
				} else {
					childMap = new HashMap<String, Object>();
				}
				objValue = childMap;
				map.put(key, childMap);
			}
			keys.add(key);
			keyNameList.add(keyName);
			break;
		}
	}

	/**
	 * �^�O�I�������B
	 * <UL>
	 *  <LI>�Q�ƒ��̃^�O���f�[�^���f���̏ꍇ�́A�p�����N���X�ϐ��FXML���[�_�[�̃n���h���[�ɁA
	 *�p�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B
	 *  </LI>
	 *  <LI>�Q�ƒ��̃^�O���L�[���ڂ̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�N���X�ϐ��F�L�[���ږ����X�g����Ō�̍��ڂ��폜����B</LI>
	 *    <LI>�N���X�ϐ��F�L�[���ڃ��X�g����Ō�̍��ڂ����o���A���X�g����폜����B</LI>
	 *    <LI>�N���X�ϐ��F�q�f�[�^���f�����}�b�v����A
	 *�L�[���ڃ��X�g�̍Ō�̍��ڂ̃f�[�^���f���}�b�v���擾����B</LI>
	 *    <LI>�擾�����f�[�^���f���}�b�v�ɁA�N���X�ϐ��F�����l�I�u�W�F�N�g���i�[����B</LI>
	 *    <LI>�N���X�ϐ��F�����l�I�u�W�F�N�g�ɁA�擾�����f�[�^���f���}�b�v��ێ�����B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */

	@Override
	public void endElement(String uri, String localName, String qName) {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case KEY_ITEM:
			// �L�[���ڂ���폜
			String keyName = keyNameList.remove(keyNameList.size() - 1);

			// �p���֌W��������
			initDataModelMap(keyName);

			String key = keys.remove(keys.size() - 1);
			Map<String, Object> map = getDataModelMap(dataModelMap, keys);

			map.put(key, objValue);
			objValue = map;
			break;

		case DATA_MODEL:
			// �f�[�^���f���^�O�𔲂��鎞��XML���[�_�[�̃n���h���[��
			// �ďo�����n���h���[�i�f�[�^���f���n���h���[�j�ɖ߂�
			// �f�[�^���f���n���h���[���ł�endElement�����͎������Ă��Ȃ��̂ŁA
			// �L�[���ڃn���h���[�Ńf�[�^���f���̕��^�O���Q�Ƃ��Ė��Ȃ�
			reader.setContentHandler(callerHandler);
			break;
		}
	}


	/**
	 * �f�[�^���f���}�b�v���擾�B
	 *
	 * @param orgMap �f�[�^���f���}�b�v
	 * @param keys �L�[���ڃ��X�g
	 * @return �f�[�^���f���}�b�v
	 */
	@SuppressWarnings("unchecked")
	protected final Map<String, Object> getDataModelMap(
			Map<String, Object> orgMap, List<String> keys) {
		Map<String, Object> map = orgMap;

		for (String key : keys) {
			map = (Map<String, Object>) map.get(key);
		}

		return map;
	}

	/**
	 * @param value �����l�I�u�W�F�N�g
	 */
	protected final void setValue(Object value) {
		objValue = value;
	}

	/**
	 * �p���֌W�����B
	 * <P>
	 * �L�[���ڂ̌p���֌W�����������s���B<BR>
	 * �ʏ�͉������Ȃ��B<BR>
	 * �p����L�[���ڃn���h���[���ŏ������W�b�N������������ׂ̃��\�b�h�B
	 * </P>
	 * @param keyName �Q�ƒ��̃L�[���ږ�
	 */
	protected void initDataModelMap(String keyName) {}

}
