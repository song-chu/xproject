package jp.escofi.emr.transformer.writer;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.transformer.sql.AttributeFieldMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * ���������C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������S�́i{@code <condition>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
 *	 <DD>�ȉ��̏��������̗v�f������XML���C�^�[�ŏo�͂���B
 *    <UL>
 *     <LI>{@code <if>}</LI>
 *     <LI>{@code <else>}</LI>
 *     <LI>{@code <apply>}</LI>
 *     <LI>{@code <and>}</LI>
 *     <LI>{@code <or>}</LI>
 *     <LI>{@code <eq>}</LI>
 *     <LI>{@code <neq>}</LI>
 *     <LI>{@code <gt>}</LI>
 *     <LI>{@code <geq>}</LI>
 *     <LI>{@code <lt>}</LI>
 *     <LI>{@code <leq>}</LI>
 *     <LI>{@code <in>}</LI>
 *     <LI>{@code <notin>}</LI>
 *     <LI>{@code <intersect>}</LI>
 *     <LI>{@code <nintersect>}</LI>
 *     <LI>{@code <startswith>}</LI>
 *     <LI>{@code <nstartswith>}</LI>
 *     <LI>{@code <subset>}</LI>
 *     <LI>{@code <nsubset>}</LI>
 *     <LI>{@code <include>}</LI>
 *     <LI>{@code <exclude>}</LI>
 *     <LI>{@code <const>}</LI>
 *     <LI>{@code <single>}</LI>
 *     <LI>{@code <set>}</LI>
 *     <LI>{@code <elem>}</LI>
 *    </UL>
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
public final class ConditionWriter extends AbstractRuleWriter {

	/**
	 * XML���[�_�[
	 */
	XMLReader reader;
	/**
	 * SQL�Z�b�V����
	 */
	SqlSession session;
	/**
	 * �������ڏ��}�b�p�[
	 */
	AttributeFieldMapper mapper;
	/**
	 * �f�[�^���f��ID
	 */
	int dataModelID;

	/**
	 * �I�y�����h�ϐ��o���t���O
	 */
	private boolean isVar = false;


	/**
	 * �R���X�g���N�^�i{@code <condition>}�^�O�j�B
	 * <P>
	 * �p�����N���X�̃R���X�g���N�^�ďo���B
	 * </P>
	 * @param callerWriter �ďo�������C�^�[
	 * @param mapper �������ڏ��}�b�p�[
	 */
	public ConditionWriter(
			ValueWiter callerWriter, AttributeFieldMapper mapper) {
		super(ElementType.CONDITION);
		this.mapper = mapper;
		dataModelID = callerWriter.getDataModelID();
	}

	/**
	 * �R���X�g���N�^�i{@code <condition>}�^�O�ȊO�j�B
	 * <OL>
	 *  <LI>�p�����N���X�̃R���X�g���N�^�ďo���B</LI>
	 *  <LI>�ďo�������C�^�[�̃N���X�ϐ����p���B</LI>
	 * </OL>
	 * @param elementType �o�̓^�O���
	 * @param callerWriter �ďo�������C�^�[
	 */
	private ConditionWriter(
			ConditionWriter callerWriter, ElementType elementType) {
		super(elementType, callerWriter);
		mapper = callerWriter.mapper;
		dataModelID = callerWriter.dataModelID;
		reader = callerWriter.reader;
		session = callerWriter.session;
	}

	/**
	 * �o�͏��ҏW�����B
	 * <p>
	 * ������XML��͂���XML�o�̓��f�����\�z����B
	 * </p>
	 * @param session DB�Z�b�V����
	 * @throws ParserConfigurationException XML��͐ݒ�G���[
	 * @throws SAXException XML��̓G���[
	 * @throws IOException ���o�̓G���[
	 */
	public void init(SqlSession session)
	throws ParserConfigurationException, SAXException, IOException {

		this.session = session;

		// ������XML���
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		reader = parser.getXMLReader();

		// �R���e���c�n���h���[�Z�b�g
		reader.setContentHandler(this);

		// �G���[�n���h���[�Z�b�g
		reader.setErrorHandler(this);

		// ������XML��͊J�n
		reader.parse(new InputSource(
				new StringReader(mapper.getConditionXml())));

	}

	/**
	 * �^�O�J�n�����B
	 * <UL>
	 *  <LI>�Ώۃ^�O���������̏ꍇ�́A�����s��Ȃ��B</LI>
	 *  <LI>�Ώۃ^�O���������ʒl�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�V�K�������ʒl���C�^�[�𐶐�����B</LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɐ��������������ʒl���C�^�[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�Ώۃ^�O���I�y�����h�ϐ����̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�N���X�ϐ��F�I�y�����h�ϐ��o���t���O���Atrue�ɂ���B</LI>
	 *    <LI>�V�K�I�y�����h�ϐ����C�^�[�𐶐�����B</LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɐ��������I�y�����h�ϐ����C�^�[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�Ώۃ^�O����L�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�V�K���������C�^�[�𐶐�����B</LI>
	 *    <LI>
	 *     �Ώۃ^�O��{@code <include>}�A{@code <exclude>}�̏ꍇ�͈ȉ��̏������s���B
	 *     �Ɩ���O�����������ꍇ�́ASAX��O�Ƀ��b�v���ĊO����throw����B
	 *     <OL>
	 *      <LI>�A�g���r���[�g���F����l�܂ރt���O���擾����B</LI>
	 *      <LI>�A�g���r���[�g���F����l�܂ރt���O���擾�ł��Ȃ��ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *      <LI>�A�g���r���[�g���F����l�܂ރt���O���A�����������������C�^�[�̃A�g���r���[�g���ɒǉ�����B</LI>
	 *      <LI>�A�g���r���[�g���F�����l�܂ރt���O���擾����B</LI>
	 *      <LI>�A�g���r���[�g���F�����l�܂ރt���O���擾�ł��Ȃ��ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *      <LI>�A�g���r���[�g���F�����l�܂ރt���O���A�����������������C�^�[�̃A�g���r���[�g���ɒǉ�����B</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>
	 *     �Ώۃ^�O��{@code <elem>}�A{@code <single>}�̏ꍇ�́A
	 *�����������������C�^�[�̃^�O���e�擾�o�b�t�@��V�KStringBuilder�C���X�^���X�ŏ���������B
	 *    </LI>
	 *    <LI>�p�����N���X�ϐ��FXML���[�_�[�ɐ����������������C�^�[��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 * @throws SAXException �Ɩ���O
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		ElementType elementType = ElementType.getType(qName);

		switch (elementType) {
		case CONDITION:
			break;
		case RESULT:
			reader.setContentHandler(new ResultWriter(this));
			break;

		case VAR:
			isVar = true;
			reader.setContentHandler(new VarWriter(this));
			break;

		default:
			ConditionWriter writer = new ConditionWriter(this, elementType);

			switch (elementType) {
			case INCLUDE:
			case EXCLUDE:
				String flg = atts.getValue(AttributeType.UPPER_EQ.toString());

				try {
					if (flg == null || flg.length() <= 0) {
						throw new EMRException(MessageCode.EMR_B_P910E);
					}
					writer.addAttribute(AttributeType.UPPER_EQ, flg);

					flg = atts.getValue(AttributeType.LOWER_EQ.toString());

					if (flg == null || flg.length() <= 0) {
						throw new EMRException(MessageCode.EMR_B_P910E);
					}
					writer.addAttribute(AttributeType.LOWER_EQ, flg);
				} catch (EMRException e) {
					throw new SAXException(e);
				}
				break;

			case ELEM:
			case SINGLE:
				writer.buffer = new StringBuilder();
				break;
			}
			reader.setContentHandler(writer);
			break;
		}
	}

	/**
	 * �^�O�I�������B
	 * <UL>
	 *  <LI>�֌W���Z�q�^�O�̏ꍇ�́A�I�y�����h�ϐ��o���t���O��false�̏ꍇ�A
	 *�Ɩ���O�𐶐��Athrow����B</LI>
	 *  <LI>�P��l�A�W���v�f�^�O�̏ꍇ
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@����̏ꍇ�́A�Ɩ���O�𐶐��Athrow����B</LI>
	 *    <LI>�p�����N���X�ϐ��F�^�O���e�擾�o�b�t�@�̓��e���A
	 *�p�����N���X�ϐ��F�^�O���e�ɕێ�����B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * @throws EMRException �Ɩ���O
	 */
	@Override
	void endElement() throws EMRException {

		switch (elementType) {
		case EQ:
		case NOT_EQ:
		case GT:
		case GEQ:
		case LT:
		case LEQ:
		case IN:
		case NOT_IN:
		case SUBSET:
		case NOT_SUBSET:
		case INTERSECT:
		case NOT_INTERSECT:
		case INCLUDE:
		case EXCLUDE:
		case START_SWITH:
		case NOT_START_SWITH:

			if (!isVar) {
				throw new EMRException(MessageCode.EMR_B_P910E);
			}
			break;

		case ELEM:
		case SINGLE:

			if (buffer.length() <= 0) {
				throw new EMRException(MessageCode.EMR_B_P910E);
			}
			value = buffer.toString();
			break;
		}
	}

}
