package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTConditionType;
import jp.iwin.pds.xml2db.common.constant.PCTDataType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.condition.PCOAOperand;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperEXCLUDE;
import jp.iwin.pds.xml2db.datamodel.condition.PCOARelOperINCLUDE;
import jp.iwin.pds.xml2db.datamodel.condition.PCOASingleCondition;
import jp.iwin.pds.xml2db.datamodel.condition.PCOOperandConst;
import jp.iwin.pds.xml2db.datamodel.condition.factory.PCOSingleConditionFactory;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;


/**
 * �֌W���Z���n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�ȉ��̃^�O�ɑΉ�����SAX�C�x���g�n���h���[�B
 *    <UL>
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
 *    </UL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1059 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 11:03:44 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHConstHandler
 * @see PCHVarHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHSingleConditionHandler extends PCHAConditionHandler {

	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �������ڃ��X�g
	 */
	private List<PCOAOperand> conditionItems = new ArrayList<PCOAOperand>();
	/**
	 * �����^�C�v��`
	 * <P>
	 * ���Z�q���ɑ����^�C�v�����K�v����B���Z�q�������^�C�v�����������ivar -> const�j
	 * </P>
	 */
	private PCTDataType dataType;
	/**
	 * �����܂ރt���O
	 */
	private boolean lowereq;
	/**
	 * ����܂ރt���O
	 */
	private boolean uppereq;


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �����ŉ���/����܂ރt���O���g�p���Ȃ��ꍇ�́A������̃R���X�g���N�^���g�p����B
	 * </P>
	 * @param callerHandler �ďo�����n���h���[
	 * @param elementType �G�������g��`
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSingleConditionHandler(PCHApplyHandler callerHandler, PCTElementType elementType, XMLWriter writer) {

		super(callerHandler, elementType);
		this.writer = writer;

		this.lowereq = false;
		this.uppereq = false;
	}

	/**
	 * �R���X�g���N�^(����/����܂ރt���O�t)�B
	 * <P>
	 * �����ŉ���/����܂ރt���O���g�p����ꍇ�́A������̃R���X�g���N�^���g�p����B
	 * </P>
	 * @param callerHandler �ďo�����n���h���[
	 * @param elementType �G�������g��`
	 * @param lowereq �����܂ރt���O
	 * @param uppereq ����܂ރt���O
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHSingleConditionHandler(
			PCHApplyHandler callerHandler, PCTElementType elementType, String lowereq, String uppereq, XMLWriter writer) {

		super(callerHandler, elementType);
		this.writer = writer;
		this.lowereq = Boolean.valueOf(lowereq);
		this.uppereq = Boolean.valueOf(uppereq);
	}


	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �p�����N���X�ϐ��FXML���[�_�[�ɁA�Q�Ƃ���^�O�ɉ������n���h���[��ݒ肷��B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		this.writer.startElement(qName);
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHARuleHandler handler = PCHRuleHandlerFactory.createRuleHandler(
				elementType, this, atts, this.writer);

		if (handler != null) {
			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Q�ƒ��̃^�O������擾�����G�������g��`���A�N���X�ϐ��F�G�������g��`�Ɠ���̏ꍇ�A
	 *�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 *  <LI>�G�������g��`�ɉ������������ڃ��X�g�ϊ��������s���B</LI>
	 *  <LI>�G�������g��`�ɉ��������Z�q��`���擾����B</LI>
	 *  <LI>�G�������g��`�ɉ��������Z�q��`���擾����B</LI>
	 *  <LI>���Z�q��`�ɉ������������I�u�W�F�N�g�𐶐�����B</LI>
	 *  <LI>���Z�q��`��INCLUDE�AEXCLUDE�̏ꍇ�́A�������I�u�W�F�N�g�ɁA
	 *����/����܂ރt���O��ݒ肷��B</LI>
	 *  <LI>�ďo�����n���h���[�̏������ɁA�������I�u�W�F�N�g��ݒ肷��B</LI>
	 *  <LI>XML���[�_�[�̃n���h���[���A�ďo�����n���h���[�ɖ߂��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);
		this.writer.endElement(qName);
		if (this.elementType.equals(elementType)) {
			// �G�������g��`�ɉ������������ڃ��X�g�ϊ�����
			convertItems(elementType);

			PCTConditionType conditionType = getConditionType(elementType);
			PCOASingleCondition condition = PCOSingleConditionFactory.createSingleCondition(
					this.conditionItems, conditionType, this.javaDataType, this.dataType);

			// �֌W���Z�q�^�C�v��INCLUDE�AEXCLUDE�̏ꍇ�́A����/����܂ރt���O��ݒ肷��B
			switch (conditionType) {
			case CONDITION_INCLUDE:
				PCOARelOperINCLUDE roi = (PCOARelOperINCLUDE) condition;

				roi.setLowereq(this.lowereq);
				roi.setUppereq(this.uppereq);
				break;

			case CONDITION_EXCLUDE:
				PCOARelOperEXCLUDE roe = (PCOARelOperEXCLUDE) condition;

				roe.setLowereq(this.lowereq);
				roe.setUppereq(this.uppereq);
				break;
			}
			PCHApplyHandler handler = (PCHApplyHandler) this.callerHandler;

			handler.setCondition(condition);
			this.reader.setContentHandler(handler);
		}
	}


	/**
	 * @param dataType �f�[�^�^
	 * @see PCHVarHandler
	 */
	void setDataType(String dataType) {
		this.dataType = PCTDataType.getType(dataType);
	}
	/**
	 * @param javaDataType ����Java�f�[�^�^
	 * @see PCHVarHandler
	 */
	void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}
	/**
	 * @return �������ڃ��X�g
	 * @see PCHConstHandler
	 * @see PCHVarHandler
	 */
	List<PCOAOperand> getConditionItems() {
		return this.conditionItems;
	}


	/**
	 * �������ڃ��X�g�ϊ��B
	 * <P>
	 * �G�������g��`�ɉ������������ڃ��X�g�ϊ��������s���B
	 * </P>
	 * @param elementType �G�������g��`
	 */
	private void convertItems(PCTElementType elementType) {

		switch (elementType) {
		case GT:
		case GEQ:
		case LT:
		case LEQ:
		case STARTSWITH:
		case NOTSTARTSWITH:
		case INCLUDE:
		case EXCLUDE:
			convertItems();
			break;

		case INTERSECT:
		case NOTINTERSECT:
		case SUBSET:
		case NOTSUBSET:
			convertSetItems();
			break;

		case EQ:
		case NOTEQ:

			if (PCTDataType.SET.equals(this.dataType)) {
				convertSetItems();
			} else {
				convertItems();
			}
			break;

		case IN:
		case NOTIN:
			// ��������(var)�̃f�[�^�^�C�v��Set�̏ꍇ�A�܂�const���v�f�Ƃ��đO�ɂ���ꍇ
			if (PCTDataType.SET.equals(this.dataType)) {
				convertItems();
			} else {
				convertSetItems();
			}
			break;

		default:
			break;
		}
	}

	/**
	 * �������ڃ��X�g�ϊ�(�ʏ�I�u�W�F�N�g)�B
	 * <P>
	 * �������ڃ��X�g�̊e�f�[�^���A����Java�f�[�^�^�̃I�u�W�F�N�g�ɕϊ�����B
	 * </P>
	 */
	private void convertItems() {

		for (PCOAOperand item : this.conditionItems) {

			if (item instanceof PCOOperandConst) {
				item.setValue(PUTConvertUtil.convert(item.getValue(), this.javaDataType));
			}
		}
	}

	/**
	 * �������ڃ��X�g�ϊ�(set�I�u�W�F�N�g)�B
	 * <P>
	 * �������ڃ��X�g�̊eset�f�[�^���A����Java�f�[�^�^�̃I�u�W�F�N�g��set�ɕϊ�����B
	 * </P>
	 */
	private void convertSetItems() {

		for (PCOAOperand item : this.conditionItems) {

			if (item instanceof PCOOperandConst) {
				@SuppressWarnings("unchecked")
				Set<Object> set = (Set<Object>) item.getValue();
				Set<Object> newSet = new HashSet<Object>(set.size());

				for (Object elem : set) {
					newSet.add(PUTConvertUtil.convert(elem, this.javaDataType));
				}
				item.setValue(Collections.unmodifiableSet(newSet));
			}
		}
	}

	/**
	 * ���Z�q��`�擾�B
	 * <P>
	 * �G�������g��`�ɉ��������Z�q��`���擾����B
	 * </P>
	 * @param elementType �G�������g��`
	 * @return ���Z�q��`
	 */
	private PCTConditionType getConditionType(PCTElementType elementType) {
		PCTConditionType ret = null;

		switch (elementType) {
		case EQ:
			ret = PCTConditionType.CONDITION_EQ;
			break;

		case NOTEQ:
			ret = PCTConditionType.CONDITION_NOTEQ;
			break;

		case GT:
			ret = PCTConditionType.CONDITION_GT;
			break;

		case GEQ:
			ret = PCTConditionType.CONDITION_GEQ;
			break;

		case IN:
			ret = PCTConditionType.CONDITION_IN;
			break;

		case NOTIN:
			ret = PCTConditionType.CONDITION_NOTIN;
			break;

		case LT:
			ret = PCTConditionType.CONDITION_LT;
			break;

		case LEQ:
			ret = PCTConditionType.CONDITION_LEQ;
			break;

		case SUBSET:
			ret = PCTConditionType.CONDITION_SUBSET;
			break;

		case NOTSUBSET:
			ret = PCTConditionType.CONDITION_NOTSUBSET;
			break;

		case INTERSECT:
			ret = PCTConditionType.CONDITION_INTERSECT;
			break;

		case NOTINTERSECT:
			ret = PCTConditionType.CONDITION_NOTINTERSECT;
			break;

		case STARTSWITH:
			ret = PCTConditionType.CONDITION_STARTSWITH;
			break;

		case NOTSTARTSWITH:
			ret = PCTConditionType.CONDITION_NOTSTARTSWITH;
			break;

		case INCLUDE:
			ret = PCTConditionType.CONDITION_INCLUDE;
			break;

		case EXCLUDE:
			ret = PCTConditionType.CONDITION_EXCLUDE;
			break;
		}

		return ret;
	}
}
