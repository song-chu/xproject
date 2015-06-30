package jp.escofi.emr.transformer.writer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;
import jp.escofi.emr.transformer.sql.AttributeGroupMapper;
import jp.escofi.emr.transformer.sql.KeyitemMapper;
import jp.escofi.emr.transformer.sql.ResultObjectMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;


/**
 * �f�[�^���f�����C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>�f�[�^���f��({@code <datamodel>})�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class DatamodelWriter extends AbstractXmlWriter {

	/**
	 * �f�[�^���f��ID
	 */
	private int dataModelID;
	/**
	 * FROM�L�[���ڗL���t���O
	 */
	private boolean fromKeyFlg = false;
	/**
	 * FROM�L�[���ډp�ꖼ
	 */
	private String fromKeyEnName;
	/**
	 * FROM�L�[���ڏ����l
	 */
	private String fromKeyDefValue;
	/**
	 * �p�����f�[�^���f���t���O
	 */
	private boolean parentDmFlg = false;
	/**
	 * �Č��ԍ�
	 */
	private String productCd;
	/**
	 * �����O���[�vID
	 */
	private int attGroupID = 0;
	/**
	 * �p�����f�[�^���f�����i�p��j
	 */
	private String extendsDm = null;


	/**
	 * �R���X�g���N�^�B
	 * <UL>
	 *  <LI>XML�^�O��������������B</LI>
	 *  <LI>�N���X�ϐ��FFROM�L�[���ڗL���t���O��false��ݒ肷��B</LI>
	 *  <LI>�N���X�ϐ��F�p�����f�[�^���f���t���O��false��ݒ肷��B</LI>
	 * </UL>
	 */
	public DatamodelWriter() {
		super(ElementType.DATA_MODEL);
	}


	/**
	 * @param dataModelID �f�[�^���f��ID
	 */
	public void setDataModelID(int dataModelID) {
		this.dataModelID = dataModelID;
	}
	/**
	 * �A�g���r���[�g���Ƀf�[�^���f�����i�p��j��ݒ�B
	 * @param name �f�[�^���f�����i�p��j
	 */
	public void setName(String name) {
		setAttribute(AttributeType.NAME, name);
	}
	/**
	 * �A�g���r���[�g����XML�t�@�C������ݒ�B
	 * @param file XML�t�@�C����
	 */
	public void setFile(String file) {
		setAttribute(AttributeType.FILE, file);
	}
	/**
	 * �p�����f�[�^���f�����i�p��j��ݒ�B
	 * <P>
	 * �p�����[�^��null�A�󕶎���ȊO�̏ꍇ�̂݁A�p�����f�[�^���f�����i�p��j��ݒ肷��B
	 * </P>
	 * @param extendsDm �p�����f�[�^���f�����i�p��j
	 */
	public void setExtendsDm(String extendsDm) {

		if (extendsDm != null && 0 < extendsDm.length()) {
			this.extendsDm = extendsDm;
		}
	}
	/**
	 * @param fromKeyFlg FROM�L�[���ڗL���t���O�F0�F�Ȃ��A1�F����
	 */
	public void setFromKeyFlg(String fromKeyFlg) {
		this.fromKeyFlg = PDSConstants.TRUE.isEquals(fromKeyFlg);
	}
	/**
	 * @param fromKeyEnName FROM�L�[���ډp�ꖼ
	 */
	public void setFromKeyEnName(String fromKeyEnName) {
		this.fromKeyEnName = fromKeyEnName;
	}
	/**
	 * @param fromKeyDefValue FROM�L�[���ڏ����l
	 */
	public void setFromKeyDefValue(String fromKeyDefValue) {
		this.fromKeyDefValue = fromKeyDefValue;
	}

	/**
	 * @return �f�[�^���f��ID
	 */
	public int getDataModelID() {
		return dataModelID;
	}
	/**
	 * @return �Č�CD
	 */
	public String getProductCd() {
		return productCd;
	}
	/**
	 * @return �����O���[�vID
	 */
	public int getAttGroupID() {
		return attGroupID;
	}


	/**
	 * @param parentDmFlg �p�����f�[�^���f���t���O
	 */
	void setParentDmFlg(boolean parentDmFlg) {
		this.parentDmFlg = parentDmFlg;
	}
	/**
	 * @return �p�����f�[�^���f�����i�p��j
	 */
	String getExtendsDm() {
		return extendsDm;
	}

	/**
	 * �o�͏��ҏW����(XML�Ǘ����)�B
	 * <OL>
	 *  <LI>�N���X�ϐ��F�Č��ԍ��ɁA�����F�Č��ԍ���ێ�����B</LI>
	 *  <LI>�����O���[�v�����擾����B</LI>
	 *  <LI>�����O���[�v��񂩂�A�L�[���ڃ��C�^�[���X�g���擾����B</LI>
	 *  <LI>�L�[���ڃ��C�^�[���X�g�̍��ڂ̓��A�L�[���ږ������镨�̂݁A
	 *�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɒǉ�����B</LI>
	 *  <LI>�L�[���ڃ��C�^�[�𐶐����A�L�[���ږ��ɁuattrName�v��ݒ肵�āA
	 *�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɒǉ�����B</LI>
	 *  <LI>�N���X�ϐ��FFROM�L�[���ڗL���t���O��true�̏ꍇ�A�L�[���ڃ��C�^�[�𐶐����A
	 *�L�[���ږ��ɃN���X�ϐ��FFROM�L�[���ډp�ꖼ��ݒ肵�āA
	 *�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɒǉ�����B</LI>
	 * </OL>
	 * @param session DB�Z�b�V����
	 * @param productCd �Č��ԍ�
	 */
	void init(SqlSession session, String productCd) {
		this.productCd = productCd;

		KeyitemMapper dbMapper = session.getMapper(KeyitemMapper.class);
		List<AttributeGroupMapper> gList = dbMapper.selectAttGroup(this);

		if (!gList.isEmpty()) {
			AttributeGroupMapper mapper = gList.get(0);
			List<KeyitemWriter> kList = mapper.getKeyItemList();

			for (KeyitemWriter writer : kList) {
				String name = writer.getName();

				if (name != null && 0 < name.length()) {
					childSet.add(writer);
				}
			}
		}
		KeyitemWriter writer = new KeyitemWriter();

		writer.setName(AttributeType.ATTR_NAME.toString());
		childSet.add(writer);

		if (fromKeyFlg) {
			writer = new KeyitemWriter();
			writer.setName(fromKeyEnName);
			childSet.add(writer);
		}
	}

	/**
	 * XML�Ǘ��t�@�C���o�͏����B
	 * <OL>
	 * <LI>�A�g���r���[�g���ҏW����
	 *  <OL>
	 *   <LI>�p�����t���O</LI>
	 *   <LI>�N���X�ϐ��FFROM�L�[���ڗL���t���O��true�̏ꍇ�A�����l���o�͂���B</LI>
	 *  </OL>
	 * </LI>
	 * <LI>�^�O�J�n�����o�͏���</LI>
	 * <LI>�^�O���e�����o�͏���</LI>
	 * <LI>�^�O�I�������o�͏���</LI>
	 * </OL>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	@Override
	void write(XMLWriter writer) throws SAXException {

		addAttribute(AttributeType.PARENT_FLG, String.valueOf(parentDmFlg));
		addAttribute(AttributeType.EXTENDS_DM, extendsDm);

		if (fromKeyFlg) {
			addAttribute(AttributeType.INIT_VALUE, fromKeyDefValue);
		}
		startElement(writer);

		for (AbstractXmlWriter child : childSet) {
			child.write(writer);
		}
		endElement(writer);
	}

	/**
	 * �f�[�^���f���t�@�C���o�͏����B
	 * <OL>
	 *  <LI>���O�ȊO�̃A�g���r���[�g���폜����B</LI>
	 *  <LI>�f�[�^���f���o�͗p���f���\�z����</LI>
	 *  <LI>�^�O�J�n�����o�͏���</LI>
	 *  <LI>�^�O���e�����o�͏���</LI>
	 *  <LI>�^�O�I�������o�͏���</LI>
	 * </OL>
	 * @param writer XML���C�^�[
	 * @param session DB�Z�b�V����
	 * @throws SAXException XML�o�͗�O
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws ParserConfigurationException XML��͐ݒ��O
	 * @throws EMRException �Ɩ���O
	 */
	void writeDataModel(XMLWriter writer, SqlSession session)
	throws SAXException, IOException, ParserConfigurationException, EMRException {

		removeAttribute(AttributeType.FILE);
		removeAttribute(AttributeType.PARENT_FLG);
		removeAttribute(AttributeType.EXTENDS_DM);
		removeAttribute(AttributeType.INIT_VALUE);

		initDataModel(session);

		startElement(writer);

		for (AbstractXmlWriter child : childSet) {
			child.write(writer);
		}
		endElement(writer);
	}

	/**
	 * �o�͏��ҏW����(�f�[�^���f��)�B
	 * <OL>
	 *  <LI>�L�[���ڏ����擾����B</LI>
	 *  <LI>�p�����N���X�ϐ��F�q�^�O(�L�[����)�Z�b�g���N���A����B</LI>
	 *  <LI>�ϐ��F�e�^�O���C�^�[�̎q�^�O�Z�b�g�ɁA
	 *�p�����N���X�ϐ��F�q�^�O(�L�[����)�Z�b�g��ݒ肷��B</LI>
	 *  <LI>�ϐ��F�C���f�b�N�X�� 0�ŏ���������B</LI>
	 *  <LI>�擾�����L�[���ڏ�񐔕����[�v
	 *   <OL>
	 *    <LI>�L�[���ڏ��̑����O���[�vID��ϐ��F�����O���[�vID�ɕێ�����B</LI>
	 *    <LI>�N���X�ϐ��F�����O���[�vID�ƕϐ��F�����O���[�vID����v���Ȃ��ꍇ�A�ȉ��̏��������{����B
	 *     <OL>
	 *      <LI>�ϐ��F�C���f�b�N�X�� 0�ȏ�̏ꍇ�́AattrName�ȉ��̏o�͓��e�ҏW���ďo���B</LI>
	 *      <LI>�ϐ��F�e�^�O���C�^�[�̎q�^�O�Z�b�g�ɁA
	 *�p�����N���X�ϐ��F�q�^�O(�L�[����)�Z�b�g��ݒ肷��B</LI>
	 *      <LI>�N���X�ϐ��F�����O���[�vID�ɁA�ϐ��F�����O���[�vID��ێ�����B</LI>
	 *      <LI>�ϐ��F�C���f�b�N�X�� 0�ŏ���������B</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>�ϐ��F�L�[���ږ��ɁA�L�[���ڏ��̃L�[���ږ���ێ�����B</LI>
	 *    <LI>�ϐ��F�L�[���ږ���null�A�܂��͋󕶎��̏ꍇ��continue����B</LI>
	 *    <LI>�ϐ��F�ԍ��ɁA�L�[���ڏ��̃C���f�b�N�X��ێ�����B</LI>
	 *    <LI>�ϐ��F�C���f�b�N�X�ƕϐ��F�ԍ�����v���Ȃ��ꍇ�́A�ϐ��F�C���f�b�N�X�ɁA
	 *�ϐ��F�ԍ���ێ�����B</LI>
	 *    <LI>��L�ȊO�̏ꍇ�́A�Ɩ���O�𐶐��Ethrow����B</LI>
	 *    <LI>�ϐ��F�e�^�O���C�^�[�̎q�^�O�Z�b�g�ɁA�q�^�O�Z�b�g�擾�����̌��ʂ�ێ�����B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>attrName�ȉ��̏o�͓��e�ҏW����</LI>
	 * </OL>
	 * @param session DB�Z�b�V����
	 * @throws ParserConfigurationException XML��͐ݒ��O
	 * @throws SAXException XML�o�͗�O
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �Ɩ���O
	 */
	private void initDataModel(SqlSession session)
	throws ParserConfigurationException, SAXException, IOException, EMRException {
		KeyitemMapper dbMapper = session.getMapper(KeyitemMapper.class);
		List<KeyitemWriter> kList = dbMapper.selectKeyItem(this);

		childSet.clear();

		Set<AbstractXmlWriter> parentSet = childSet;
		int index = 0;

		for (KeyitemWriter writer : kList) {
			int attGroupID = writer.getAttGroupID();

			if (this.attGroupID != attGroupID) {

				if (0 < index) {
					initChildSet(session, parentSet);
				}
				parentSet = childSet;
				this.attGroupID = attGroupID;
				index = 0;
			}
			String name = writer.getName();

			if (name == null || name.length() <= 0) {
				continue;
			}
			int i = writer.getIndex();

			if (i != index) {
				index = i;
			} else {
				throw new EMRException(MessageCode.EMR_B_P910E);
			}
			parentSet = getChildSet(writer, parentSet);
		}
		initChildSet(session, parentSet);
	}

	/**
	 * �q�^�O�Z�b�g�擾�����B
	 * <UL>
	 *  <LI>�����F�e�^�O���C�^�[�̎q�^�O�Z�b�g�ɁA
	 *�����F�L�[���ڃ��C�^�[�Ɠ������O�̃L�[���ڃ��C�^�[������ꍇ�́A
	 *���̃L�[���ڃ��C�^�[�̎q�^�O�Z�b�g��Ԃ��B</LI>
	 *  <LI>�����F�e�^�O���C�^�[�̎q�^�O�Z�b�g�ɁA
	 *�����F�L�[���ڃ��C�^�[�Ɠ������O�̃L�[���ڃ��C�^�[�������ꍇ�́A
	 *�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�����F�L�[���ڃ��C�^�[�̃f�[�^���f���o�̓t���O��true�ɐݒ肷��B</LI>
	 *    <LI>�����F�e�^�O���C�^�[�̎q�^�O�Z�b�g�ɁA
	 *�����F�L�[���ڃ��C�^�[���i�[����B</LI>
	 *    <LI>�����F�L�[���ڃ��C�^�[�̎q�^�O�Z�b�g��Ԃ��B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param writer �L�[���ڃ��C�^�[
	 * @param parentSet �e�^�O���C�^�[�̎q�^�O�Z�b�g
	 * @return �q�^�O�Z�b�g
	 */
	private Set<AbstractXmlWriter> getChildSet(KeyitemWriter writer, Set<AbstractXmlWriter> parentSet) {

		for (AbstractXmlWriter w : parentSet) {
			KeyitemWriter k = (KeyitemWriter) w;

			if (k.equals(writer)) {
				return k.childSet;
			}
		}
		writer.setDataModelWrite(true);
		parentSet.add(writer);

		return writer.childSet;
	}

	/**
	 * attrName�ȉ��̏o�͓��e�ҏW�B
	 * <OL>
	 *  <LI>�ϐ��F�T�C�Y�ɁA�����F�q�^�O���i�[�Z�b�g�̃T�C�Y��ێ�����B</LI>
	 *  <LI>�������ڏ��𒊏o����B</LI>
	 *  <LI>FROM�L�[���ڗL���t���O��true�̏ꍇ
	 *   <OL>
	 *    <LI>�ϐ��FattrName�^�O�ҏW�}�b�v��V�KLinkedHashMap�ŏ���������B</LI>
	 *    <LI>�擾�����������ڏ�񐔕����[�v
	 *     <OL>
	 *      <LI>�������ڏ��̍폜�t���O��true�̏ꍇ�́Acontinue����B</LI>
	 *      <LI>�������ڏ�񂩂瑮�����ږ����擾����B</LI>
	 *      <LI>�ϐ��FattrName�^�O�ҏW�}�b�v����A
	 *�������ږ����L�[��attrName�^�O�擾����B</LI>
	 *      <LI>�擾�ł��Ȃ������ꍇ�́A�ȉ��̏������s���B
	 *       <OL>
	 *        <LI>attrName�^�O�𐶐�����B</LI>
	 *        <LI>�ϐ��FattrName�^�O�ҏW�}�b�v�ɁA
	 *�������ږ����L�[�Ƃ��āA��������attrName�^�O���i�[����B</LI>
	 *       </OL>
	 *      </LI>
	 *      <LI>fromkey�L�[�^�O��������B</LI>
	 *      <LI>value�^�O��������B</LI>
	 *      <LI>fromkey�^�O�̎q�^�O�Z�b�g��value�^�O��ǉ�����B</LI>
	 *      <LI>attrName�^�O�̎q�^�O�Z�b�g��fromkey�^�O��ǉ�����B</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>�����F�q�^�O���i�[�Z�b�g�ɁA
	 *�ϐ��FattrName�^�O�ҏW�}�b�v�̒l��S�Ēǉ�����B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>��L�ȊO�̏ꍇ�A�擾�����������ڏ�񐔕����[�v
	 *   <OL>
	 *    <LI>�������ڏ��̍폜�t���O��true�̏ꍇ�́Acontinue����B</LI>
	 *    <LI>attrName�^�O�𐶐�����B</LI>
	 *    <LI>value�^�O��������B</LI>
	 *    <LI>attrName�^�O�̎q�^�O�Z�b�g��value�^�O��ǉ�����B</LI>
	 *    <LI>�����F�q�^�O���i�[�Z�b�g��attrName�^�O��ǉ�����B</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * <P>
	 * �Ȃ��AattrName���������o�͂����ꍇ�̃\�[�g�́ASQL���o���ōs���Ă���B<BR>
	 * ���я��́AattrName�̃L�[���ڒl(�Afromkey�L�[���ڒl)�̏����ƂȂ�B
	 * </P>
	 * @param session DB�Z�b�V����
	 * @param parentSet �q�^�O���i�[�Z�b�g
	 * @return �ҏW��̎q�^�O���i�[�Z�b�g
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws SAXException XML�o�͗�O
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �f�[�^���f���o�͏�����O
	 */
	private Set<AbstractXmlWriter> initChildSet(SqlSession session, Set<AbstractXmlWriter> parentSet)
	throws ParserConfigurationException, SAXException, IOException, EMRException {
		ResultObjectMapper dbMapper = session.getMapper(ResultObjectMapper.class);
		List<AttributeFieldMapper> list = dbMapper.select(this);

		if (fromKeyFlg) {
			Map<String, KeyitemWriter> attrMap =
				new LinkedHashMap<String, KeyitemWriter>();

			for (AttributeFieldMapper mapper : list) {

				if (mapper.isDelFlg()) {
					continue;
				}
				String key = mapper.getName();
				KeyitemWriter attrName = attrMap.get(key);

				if (attrName == null) {
					attrName = createAttrName(mapper);
					attrMap.put(key, attrName);
				}
				KeyitemWriter fromKey = createFromKey(mapper);
				ValueWiter value = createValue(session, mapper);

				fromKey.childSet.add(value);
				attrName.childSet.add(fromKey);
			}
			parentSet.addAll(attrMap.values());
		} else {

			for (AttributeFieldMapper mapper : list) {

				if (mapper.isDelFlg()) {
					continue;
				}
				KeyitemWriter attrName = createAttrName(mapper);
				ValueWiter value = createValue(session, mapper);

				attrName.childSet.add(value);
				parentSet.add(attrName);
			}
		}

		return parentSet;
	}

	/**
	 * attrName�^�O�����B
	 *
	 * @param mapper �������ڏ��}�b�p�[
	 * @return attrName�^�O
	 */
	private KeyitemWriter createAttrName(AttributeFieldMapper mapper) {
		KeyitemWriter kWriter = new KeyitemWriter();

		kWriter.setDataModelWrite(true);
		kWriter.setName(AttributeType.ATTR_NAME.toString());
		kWriter.setKey(mapper.getName());
		kWriter.setJpName(mapper.getJpName());

		return kWriter;
	}

	/**
	 * fromkey�^�O�����B
	 *
	 * @param mapper �������ڏ��}�b�p�[
	 * @return fromkey�^�O
	 */
	private KeyitemWriter createFromKey(AttributeFieldMapper mapper) {
		KeyitemWriter fromKey = new KeyitemWriter();

		fromKey.setDataModelWrite(true);
		fromKey.setName(fromKeyEnName);
		fromKey.setKey(mapper.getFromKeyValue());

		return fromKey;
	}

	/**
	 * value�^�O�����B
	 *
	 * @param session DB�Z�b�V����
	 * @param mapper �������ڏ��}�b�p�[
	 * @return value�^�O����
	 * @throws ParserConfigurationException XML��͐ݒ��O
	 * @throws SAXException XML�o�͗�O
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �Ɩ���O
	 */
	private ValueWiter createValue(SqlSession session, AttributeFieldMapper mapper)
	throws ParserConfigurationException, SAXException, IOException, EMRException {
		ValueWiter value = new ValueWiter(dataModelID);

		value.init(session, mapper);

		return value;
	}

}
