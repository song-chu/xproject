package jp.iwin.pds.xml2db.initialload.handler.factory;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.initialload.handler.PCHAConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHAResultObjectHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHARuleHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHApplyHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHCompositeConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHConstHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHELSEHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHIFHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSetHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSingleConditionHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSingleHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHVarHandler;

import org.xml.sax.Attributes;


/**
 * �������n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������n���h���[�Q�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1062 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 11:11:06 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHDelegateHandlerFactory
 * @see jp.iwin.pds.initialload.handler.PCHApplyHandler
 * @see jp.iwin.pds.initialload.handler.PCHCompositeConditionHandler
 * @see jp.iwin.pds.initialload.handler.PCHConditionHandler
 * @see jp.iwin.pds.initialload.handler.PCHConstHandler
 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
 * @see jp.iwin.pds.initialload.handler.PCHSingleConditionHandler
 * @see jp.iwin.pds.initialload.handler.PCHValueHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHRuleHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private PCHRuleHandlerFactory() {}

	/**
	 * �������n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @return �������n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHValueHandler
	 */
	public static PCHConditionHandler createConditionHandler(
			PCHAResultObjectHandler callerHandler) {
		return new PCHConditionHandler(callerHandler);
	}

	/**
	 * �������J�b�R�n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @return �������J�b�R�n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHCompositeConditionHandler
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 */
	public static PCHApplyHandler createApplyHandler(
			PCHARuleHandler callerHandler, XMLWriter writer) {
		return new PCHApplyHandler(callerHandler, writer);
	}

	/**
	 * IF���n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ������
	 * @param ifType IF-THEN-ELSE���ʎq
	 * @return IF���n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHConditionHandler
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 */
	public static PCHIFHandler createIFHandler(PCHARuleHandler callerHandler,
			PROINIRule rule, PCTIFType ifType, XMLWriter writer) {
		return new PCHIFHandler(callerHandler, rule, ifType, writer);
	}

	/**
	 * ELSE���n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ������
	 * @return ELSE���n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHConditionHandler
	 * @see jp.iwin.pds.initialload.handler.PCHIFHandler
	 */
	public static PCHELSEHandler createELSEHandler(PCHARuleHandler callerHandler,
			PROINIRule rule, XMLWriter writer) {
		return new PCHELSEHandler(callerHandler, rule,writer);
	}

	/**
	 * �������n���h���[���������B
	 * <P>
	 * �������萔�n���h���[�̓����ŃG�������g�^�C�v�ɉ������n���h���[�𐶐�����B<BR>
	 * ���̃��\�b�h�Ő����ł���n���h���[�͉��L�B
	 * </P>
	 * <UL>
	 * <LI>�Z�b�g�n���h���[(�G�������g�^�C�v�F�Z�b�g)</LI>
	 * <LI>�P��^�n���h���[(�G�������g�^�C�v�F�Z�b�g�ȊO)</LI>
	 * </UL>
	 * @param elementType �G�������g�^�C�v
	 * @param callerHandler �ďo�����n���h���[
	 * @return �������n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHConstHandler
	 */
	public static PCHARuleHandler createRuleHandler(
			PCTElementType elementType, PCHConstHandler callerHandler,XMLWriter writer) {

		switch (elementType) {
		case SET:
			return new PCHSetHandler(callerHandler,writer);

		default:
			return new PCHSingleHandler(callerHandler,writer);
		}
	}

	/**
	 * �������n���h���[���������B
	 * <P>
	 * �֌W���Z���n���h���[�Q�̓����ŃG�������g�^�C�v�ɉ������n���h���[�𐶐�����B<BR>
	 * ���̃��\�b�h�Ő����ł���n���h���[�͉��L�B
	 * </P>
	 * <UL>
	 * <LI>�������ϐ��n���h���[(�G�������g�^�C�v�F�������ϐ�)</LI>
	 * <LI>�������萔�n���h���[(�G�������g�^�C�v�F�������萔)</LI>
	 * </UL>
	 * <P>
	 * �G�������g�^�C�v�̒l��null�A�܂��͒�`�O�̃G�������g�^�C�v�̏ꍇ��null��Ԃ��B
	 * </P>
	 * @param elementType �G�������g�^�C�v
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @return �������n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHSingleConditionHandler
	 */
	public static PCHARuleHandler createRuleHandler(PCTElementType elementType,
			PCHSingleConditionHandler callerHandler, Attributes atts, XMLWriter writer) {

		switch (elementType) {
		case VAR:
			return new PCHVarHandler(callerHandler,
					atts.getValue(PCTAttributeType.DATATYPE.toString()).intern(),
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern(),
					atts.getValue(PCTAttributeType.VARINFO.toString()).intern(),
					atts.getValue(PCTAttributeType.JPNAME.toString()),writer);

		case CONST:
			return new PCHConstHandler(callerHandler,writer);

		default:
			return null;
		}
	}


	/**
	 * ���Z�q�n���h���[���������B
	 * <P>
	 * �������J�b�R�n���h���[�Q�̓����ŃG�������g�^�C�v�ɉ��������Z�q�n���h���[�𐶐�����B<BR>
	 * ���̃��\�b�h�Ő����ł��鉉�Z�q�n���h���[�͉��L�B
	 * </P>
	 * <UL>
	 * <LI>�_�����Z�qAND</LI>
	 * <LI>�_�����Z�qOR</LI>
	 * <LI>�֌W���Z�qEQ</LI>
	 * <LI>�֌W���Z�qNOTEQ</LI>
	 * <LI>�֌W���Z�qLT</LI>
	 * <LI>�֌W���Z�qLEQ</LI>
	 * <LI>�֌W���Z�qGT</LI>
	 * <LI>�֌W���Z�qGEQ</LI>
	 * <LI>�֌W���Z�qIN</LI>
	 * <LI>�֌W���Z�qNOTIN</LI>
	 * <LI>�֌W���Z�qINTERSECT</LI>
	 * <LI>�֌W���Z�qNOTINTERSECT</LI>
	 * <LI>�֌W���Z�qSTARTSWITH</LI>
	 * <LI>�֌W���Z�qNOTSTARTSWITH</LI>
	 * <LI>�֌W���Z�qSUBSET</LI>
	 * <LI>�֌W���Z�qNOTSUBSET</LI>
	 * <LI>�֌W���Z�qINCLUDE</LI>
	 * <LI>�֌W���Z�qEXCLUDE</LI>
	 * </UL>
	 * <P>
	 * �G�������g�^�C�v�̒l��null�A�܂��͒�`�O�̃G�������g�^�C�v�̏ꍇ��null��Ԃ��B
	 * </P>
	 * @param elementType �G�������g�^�C�v
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @return ���Z�q�n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHApplyHandler
	 */
	public static PCHAConditionHandler createConditionHandler(PCTElementType elementType,
			PCHApplyHandler callerHandler, Attributes atts, XMLWriter writer) {

		switch (elementType) {
		case AND:
		case OR:
			return new PCHCompositeConditionHandler(callerHandler, elementType, writer);

		case EQ:
		case NOTEQ:
		case LT:
		case LEQ:
		case GT:
		case GEQ:
		case IN:
		case NOTIN:
		case INTERSECT:
		case NOTINTERSECT:
		case STARTSWITH:
		case NOTSTARTSWITH:
		case SUBSET:
		case NOTSUBSET:
			return new PCHSingleConditionHandler(callerHandler, elementType, writer);

		case INCLUDE:
		case EXCLUDE:
			return new PCHSingleConditionHandler(callerHandler, elementType,
					atts.getValue(PCTAttributeType.LOWEREQ.toString()).intern(),
					atts.getValue(PCTAttributeType.UPPEREQ.toString()).intern(),writer);

		default:
			return null;
		}
	}

}
