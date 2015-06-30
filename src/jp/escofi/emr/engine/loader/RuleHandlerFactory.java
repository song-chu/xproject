package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * �������n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������n���h���[�Q�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
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
public final class RuleHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private RuleHandlerFactory() {}


	/**
	 * �������n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @return �������n���h���[
	 */
	public static ConditionHandler createConditionHandler(
			AbstractResultObjectHandler callerHandler) {
		return new ConditionHandler(callerHandler);
	}

	/**
	 * �������A�v���C�n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @return �������A�v���C�n���h���[
	 */
	public static ApplyHandler createApplyHandler(
			AbstractRuleHandler callerHandler) {
		return new ApplyHandler(callerHandler);
	}

	/**
	 * IF���n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ������
	 * @param ifType IF-THEN-ELSE���ʎq
	 * @return IF���n���h���[
	 */
	public static IFHandler createIFHandler(AbstractRuleHandler callerHandler,
			InitRule rule, IFType ifType) {
		return new IFHandler(callerHandler, rule, ifType);
	}

	/**
	 * ELSE���n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ������
	 * @return ELSE���n���h���[
	 */
	public static ELSEHandler createELSEHandler(AbstractRuleHandler callerHandler,
			InitRule rule) {
		return new ELSEHandler(callerHandler, rule);
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
	 */
	public static AbstractRuleHandler createRuleHandler(
			ElementType elementType, ConstHandler callerHandler) {

		switch (elementType) {
		case SET:
			return new SetHandler(callerHandler);

		default:
			return new SingleHandler(callerHandler);
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
	 */
	public static AbstractRuleHandler createRuleHandler(ElementType elementType,
			SingleConditionHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case VAR:

			String strVarInfo = atts.getValue(AttributeType.VAR_INFO.toString());
			List<String> varInfo = ConvertUtil.parseCSV(strVarInfo);

			return new VarHandler(callerHandler,
					atts.getValue(AttributeType.DATA_TYPE.toString()).intern(),
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern(),
					Collections.unmodifiableList(varInfo));

		case CONST:
			return new ConstHandler(callerHandler);

		default:
			return null;
		}
	}


	/**
	 * ���Z�q�n���h���[���������B
	 * <P>
	 * �������A�v���C�n���h���[�Q�̓����ŃG�������g�^�C�v�ɉ��������Z�q�n���h���[�𐶐�����B<BR>
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
	 */
	public static AbstractConditionHandler createConditionHandler(ElementType elementType,
			ApplyHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case AND:
		case OR:
			return new CompositeConditionHandler(callerHandler, elementType);

		case EQ:
		case NOT_EQ:
		case LT:
		case LEQ:
		case GT:
		case GEQ:
		case IN:
		case NOT_IN:
		case INTERSECT:
		case NOT_INTERSECT:
		case START_SWITH:
		case NOT_START_SWITH:
		case SUBSET:
		case NOT_SUBSET:
			return new SingleConditionHandler(callerHandler, elementType);

		case INCLUDE:
		case EXCLUDE:
			return new SingleConditionHandler(callerHandler, elementType,
					atts.getValue(AttributeType.LOWER_EQ.toString()),
					atts.getValue(AttributeType.UPPER_EQ.toString()));

		default:
			return null;
		}
	}

}
