package jp.escofi.emr.transformer.writer;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;
import jp.escofi.emr.transformer.sql.ValueMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;


/**
 * �����l���C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>�����l�i{@code <value>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class ValueWiter extends AbstractXmlWriter {

	/**
	 * �f�[�^���f��ID
	 */
	private int dataModelID;


	/**
	 * �R���X�g���N�^��XML�^�O��������������B
	 *
	 * @param dataModelID �f�[�^���f��ID
	 */
	ValueWiter(int dataModelID) {
		super(ElementType.VALUE);
		this.dataModelID = dataModelID;
	}


	/**
	 * @return �f�[�^���f��ID
	 */
	public int getDataModelID() {
		return dataModelID;
	}


	/**
	 * �o�͏��ҏW�����B
	 * <OL>
	 *  <LI>�����F�������ڏ��}�b�p�[�̏����L���t���O��true�̏ꍇ
	 *   <OL>
	 *    <LI>���������C�^�[�𐶐�����B</LI>
	 *    <LI>���������C�^�[������������B</LI>
	 *    <LI>�q�^�O�Z�b�g�ɐ����������������C�^�[��ǉ�����B</LI>
	 *    <LI>�A�g���r���[�g���̃��^���ɋ󕶎���ݒ肷��B</LI>
	 *    <LI>�A�g���r���[�g���̍폜�t���O��false��ݒ肷��B</LI>
	 *   </OL>
	 *  <LI>��L�ȊO�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�����l���C�^�[���擾����B</LI>
	 *    <LI>�擾���������l���C�^�[���I�u�W�F�N�g�^���C�^�[�ȊO�́A
	 *�A�g���r���[�g���:javadatatype��ݒ肷��B</LI>
	 *    <LI>�����l���C�^�[�̍폜�t���O��true�̏ꍇ�́A�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɁA
	 *�_�~�[�����l���C�^�[���i�[����B</LI>
	 *    <LI>��L�ȊO�̏ꍇ�́A�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɁA�擾���������l���C�^�[���i�[����B</LI>
	 *    <LI>�A�g���r���[�g����ҏW����B</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * @param session DB�Z�b�V����
	 * @param mapper �������ڏ��}�b�p�[
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws SAXException XML��̓G���[
	 * @throws IOException ���o�̓G���[
	 * @throws EMRException �f�[�^���f���o�͏�����O
	 */
	void init(SqlSession session, AttributeFieldMapper mapper)
	throws ParserConfigurationException, SAXException, IOException, EMRException {

		// �������t���O
		boolean isConditionFlg = mapper.isConditionFlg();
		boolean isDelFlg = false;
		String metaInfo = PDSConstants.EMPTY.toString();

		if (isConditionFlg) {
			// ����������
			ConditionWriter child = new ConditionWriter(this, mapper);

			child.init(session);
			childSet.add(child);
		} else {
			// �������Ȃ�
			DataType dataType = mapper.getDataType();
			AbstractAttributeValueWriter child = getChildElement(
					session, dataType, mapper.getAttFieldID());

			// �I�u�W�F�N�g�^�ȊO�̓A�g���r���[�g���:javadatatype��ݒ肷��B
			if (DataType.OBJECT != dataType) {
				child.setJavaDataType(mapper.getJavaDataType());
			}
			metaInfo = child.getMetaInfo();

			// �����l�̍폜�t���O����
			isDelFlg = child.isDelFlg();

			if (isDelFlg) {
				childSet.add(EmptyWriter.getInstance());
			} else {
				childSet.add(child);
			}
		}
		addAttribute(AttributeType.COND_FLG, String.valueOf(isConditionFlg));
		addAttribute(AttributeType.META_INFO, metaInfo);
		addAttribute(AttributeType.DATA_TYPE, mapper.getDataType().toString());
		addAttribute(AttributeType.DEL_FLG, String.valueOf(isDelFlg));
	}


	/**
	 * �����l���C�^�[�擾�B
	 * <OL>
	 *  <LI>�����F�f�[�^�^�ɉ����������l���C�^�[�擾���\�b�h���Ăяo���B</LI>
	 *  <LI>�����l���C�^�[���擾�o���Ȃ������A�܂��͎擾����������1��葽���ꍇ�́A
	 *�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�擾���������l���C�^�[�̌��ʔԍ��� 0�ȊO�̏ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�擾���������l���C�^�[��߂��B</LI>
	 * </OL>
	 * @param session DB�Z�b�V����
	 * @param dataType �f�[�^�^
	 * @param attFieldID ��������ID
	 * @return �����l���C�^�[
	 * @throws EMRException �f�[�^���f���o�͏�����O<BR>
	 * - �����l���C�^�[���������擾���ꂽ�ꍇ<BR>
	 * - �擾���������l���C�^�[�̌��ʔԍ����A0�ȊO�̏ꍇ
	 */
	private AbstractAttributeValueWriter getChildElement(
			SqlSession session, DataType dataType, int attFieldID) throws EMRException {
		ValueMapper dbMapper = session.getMapper(ValueMapper.class);
		List<? extends AbstractAttributeValueWriter> recList = null;

		switch (dataType) {
		case LIST:
			recList = dbMapper.selectListAttFieldID(attFieldID);
			break;

		case MAP:
			recList = dbMapper.selectMapAttFieldID(attFieldID);
			break;

		case OBJECT:
			recList = dbMapper.selectObjectAttFieldID(attFieldID);
			break;

		case RANGE:
			recList = dbMapper.selectRangeAttFieldID(attFieldID);
			break;

		case SINGLE:
			recList = dbMapper.selectSingleAttFieldID(attFieldID);
			break;
		}

		if (recList.isEmpty() || 1 < recList.size()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		AbstractAttributeValueWriter writer = recList.get(0);

		if (0 != writer.getAnserNo()) {
			throw new EMRException(MessageCode.EMR_B_P910E);
		}
		return writer;
	}

}
