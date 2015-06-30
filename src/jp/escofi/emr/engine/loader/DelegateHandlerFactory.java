package jp.escofi.emr.engine.loader;

import java.util.Collections;
import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;

import org.xml.sax.Attributes;


/**
 * Delegate�n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>Delegate�n���h���[�S�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
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
public final class DelegateHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private DelegateHandlerFactory() {}


	/**
	 * Delegate�n���h���[���������B
	 * <P>
	 * �����l�n���h���[�S�̓����ŃG�������g�^�C�v�ɉ������n���h���[�𐶐�����B<br>
	 * ���̃��\�b�h�Ő����ł���n���h���[�͉��L�B
	 * </P>
	 * <UL>
	 * <LI>���X�g�^�n���h���[</LI>
	 * <LI>�}�b�v�^�n���h���[</LI>
	 * <LI>�͈͌^�n���h���[</LI>
	 * <LI>�P��^�n���h���[</LI>
	 * <LI>�I�u�W�F�N�g�^�n���h���[</LI>
	 * </UL>
	 * <P>
	 * �G�������g�^�C�v�̒l��null�A�܂��͒�`�O�̃G�������g�^�C�v�̏ꍇ��null��Ԃ��B
	 * </P>
	 * <P>
	 * �������萔�n���h���[���ŒP��^�n���h���[�𐶐�����ꍇ�́A���̃��\�b�h�ł͂Ȃ��A
	 * {@link RuleHandlerFactory#createRuleHandler(ElementType, jp.escofi.emr.engine.loader.ConstHandler)}
	 * ���g�p����B
	 * </P>
	 * @param elementType �G�������g�^�C�v
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @return �G�������g�^�C�v�ɉ������n���h���[
	 */
	public static AbstractDelegateHandler createDelegateHandler(
			ElementType elementType, AbstractResultObjectHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case LIST:
			return new ListHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case MAP:
			return new MapHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case RANGE:
			return new RangeHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case SINGLE:
			return new SingleHandler(callerHandler,
					atts.getValue(AttributeType.JAVA_DATA_TYPE.toString()).intern());

		case OBJECT:

			// �I�u�W�F�N�g�^�̕t�я����擾
			String strSubInfo = atts.getValue(AttributeType.SUB_INFO.toString());
			List<String> subInfo = ConvertUtil.parseCSV(strSubInfo);

			return new ObjectHandler(callerHandler,
					atts.getValue(AttributeType.CLASS_NAME.toString()).intern(),
					Collections.unmodifiableList(subInfo));
		default:
			return null;
		}
	}

}
