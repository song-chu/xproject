package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;


/**
 * �L�[���ڃ��C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>�L�[����({@code <keyitem>})�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class KeyitemWriter extends AbstractXmlWriter {

	/**
	 * �L�[���ږ��i�p��j
	 */
	private String name;
	/**
	 * �L�[���ڒl
	 */
	private String key;
	/**
	 * �L�[���ږ��i���{��j
	 */
	private String jpName;
	/**
	 * �p�����L�[���ڒl
	 */
	private String org;
	/**
	 * �f�[�^���f���o�̓t���O
	 */
	private boolean isDataModelWrite = false;
	/**
	 * �����O���[�vID
	 */
	private int attGroupID = 0;
	/**
	 * �L�[���ڃC���f�b�N�X
	 */
	private int index = 0;


	/**
	 * �R���X�g���N�^��XML�^�O��������������B
	 */
	public KeyitemWriter() {
		super(ElementType.KEY_ITEM);
	}


	/**
	 * @param name �L�[���ږ��i�p���j
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param key �L�[���ڒl
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @param jpName �L�[���ږ��i���{��j
	 */
	public void setJpName(String jpName) {
		this.jpName = jpName;
	}
	/**
	 * @param org �p�����L�[���ڒl
	 */
	public void setOrg(String org) {
		this.org = org;
	}
	/**
	 * @param attGroupID �����O���[�vID
	 */
	public void setAttGroupID(int attGroupID) {
		this.attGroupID = attGroupID;
	}
	/**
	 * @param index �L�[���ڃC���f�b�N�X
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * �L�[���ڃ��C�^�[��v����B
	 * <P>
	 * �����F�I�u�W�F�N�g�̃N���X�^����v�����ꍇ�A�����F�I�u�W�F�N�g�̈ȉ��̒l���A
	 *���̃L�[���ڃ��C�^�[�̒l�ƑS�Ĉ�v�����ꍇ�́A����̃L�[���ڃ��C�^�[�Ɣ��肷��B
	 * </P>
	 * <UL>
	 *  <LI>�L�[���ږ��i�p���j</LI>
	 *  <LI>�L�[���ڒl</LI>
	 * </UL>
	 * @param obj �I�u�W�F�N�g
	 * @return ��v���茋��
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;

		if (obj instanceof KeyitemWriter) {
			KeyitemWriter writer = (KeyitemWriter) obj;

			ret = (name.equals(writer.name) &&
					key.equals(writer.key));
		}
		return ret;
	}

	/**
	 * �n�b�V���R�[�h�l�B
	 * <P>
	 * ���̃C���X�^���X�̃n�b�V���R�[�h�l�͈ȉ��̃N���X�ϐ��̃n�b�V���R�[�h�l�̍��v�Ƃ���B
	 * </P>
	 * <UL>
	 *  <LI>�L�[���ږ��i�p���j</LI>
	 *  <LI>�L�[���ڒl</LI>
	 * </UL>
	 * @return �n�b�V���R�[�h�l
	 */
	@Override
	public int hashCode() {
		int name = 0;
		int key = 0;

		if (this.name != null) {
			name = this.name.hashCode();
		}

		if (this.key != null) {
			key = this.key.hashCode();
		}
		return name + key;
	}


	/**
	 * @return �L�[���ږ��i�p���j
	 */
	String getName() {
		return name;
	}
	/**
	 * @return �����O���[�vID
	 */
	int getAttGroupID() {
		return attGroupID;
	}
	/**
	 * @return �L�[���ڃC���f�b�N�X
	 */
	int getIndex() {
		return index;
	}

	/**
	 * �f�[�^���f���o�̓t���O�ݒ�
	 *
	 * @param isDataModelWrite �f�[�^���f���o�̓t���O true:�f�[�^���f���̓��e�Afalse:XML�Ǘ��t�@�C���̓��e
	 */
	void setDataModelWrite(boolean isDataModelWrite) {
		this.isDataModelWrite = isDataModelWrite;
	}

	/**
	 * XML�Ǘ��t�@�C���o�͏����B
	 * <UL>
	 *  <LI>�N���X�ϐ��F�f�[�^���f���o�̓t���O��true�̏ꍇ�́A
	 *�f�[�^���f���t�@�C���o�͏������ďo���B</LI>
	 *  <LI>��L�ȊO�̏ꍇ�́A�ȉ��̏��������{����B
	 *   <OL>
	 *    <LI>�^�O�J�n�����o�͏���</LI>
	 *    <LI>�^�O���e�����o�͏���(�N���X�ϐ��F�L�[���ږ��i�p��j���o��)</LI>
	 *    <LI>�^�O�I�������o�͏���</LI>
	 *   </OL>
	 * </UL>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	@Override
	void write(XMLWriter writer) throws SAXException {

		if (isDataModelWrite) {
			writeDataModel(writer);
		} else {
			// �^�O�J�n�����o�͏���
			startElement(writer);

			// �^�O���e�����o�͏���
			writer.characters(name);

			// �^�O�I�������o�͏���
			endElement(writer);
		}
	}


	/**
	 * �f�[�^���f���t�@�C���o�͏����B
	 * <OL>
	 * <LI>�A�g���r���[�g�ҏW����</LI>
	 * <LI>�^�O�J�n�����o�͏���</LI>
	 * <LI>�^�O���e�����o�͏���</LI>
	 * <LI>�^�O�I�������o�͏���</LI>
	 * <LI>�q�^�O���N���A����</LI>
	 * </OL>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	private void writeDataModel(XMLWriter writer) throws SAXException {

		// �A�g���r���[�g�ҏW
		addAttribute(AttributeType.NAME, name);
		addAttribute(AttributeType.KEY, key);

		if (jpName != null && 0 < jpName.length()) {
			addAttribute(AttributeType.JP_NAME, jpName);
		}

		if (org != null && 0 < org.length()) {
			addAttribute(AttributeType.ORG, org);
		}

		// �^�O�J�n����
		startElement(writer);

		// �^�O���e����
		for (AbstractXmlWriter child : childSet) {
			child.write(writer);
		}

		// �^�O�I������
		endElement(writer);

		// �q�^�O���N���A����
		childSet = null;
	}

}
