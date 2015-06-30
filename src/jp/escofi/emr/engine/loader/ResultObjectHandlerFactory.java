package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.InitRule;

import org.xml.sax.Attributes;


/**
 * �����l�n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�n���h���[�S�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
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
public final class ResultObjectHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private ResultObjectHandlerFactory() {}


	/**
	 * �����l�n���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @return �����l�n���h���[�̐V�K�C���X�^���X
	 */
	public static ValueHandler createValueHandler(
			KeyItemHandler callerHandler, Attributes atts) {

		return new ValueHandler(callerHandler, atts);
	}

	/**
	 * ���������ʃn���h���[���������B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @param rule ���[���I�u�W�F�N�g
	 * @param ifType �������^�C�v
	 * @return ���������ʃn���h���[�̐V�K�C���X�^���X
	 */
	public static ResultHandler createResultHandler(AbstractRuleHandler callerHandler,
			Attributes atts, InitRule rule, IFType ifType) {

		return new ResultHandler(callerHandler, rule, ifType, atts);
	}
}
