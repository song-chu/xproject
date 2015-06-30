package jp.escofi.emr.engine.loader;

import org.xml.sax.Attributes;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.IFType;
import jp.escofi.emr.engine.condition.AbstractAction;
import jp.escofi.emr.engine.condition.InitRule;
import jp.escofi.emr.engine.search.ResultObject;


/**
 * ���������ʃn���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������茋��{@code <result>}�̗v�f����������SAX�C�x���g�n���h���[�B
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
public final class ResultHandler extends AbstractResultObjectHandler {

	/**
	 * ���[���I�u�W�F�N�g
	 */
	private InitRule rule;
	/**
	 * �������^�C�v
	 */
	private IFType ifType;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ���[���I�u�W�F�N�g
	 * @param ifType �������^�C�v
	 * @param atts �A�g���r���[�g���
	 */
	public ResultHandler(AbstractDelegateHandler callerHandler, InitRule rule,
			IFType ifType, Attributes atts) {

		super(callerHandler, atts);

		this.rule = rule;
		this.ifType = ifType;
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * ���������ʃ^�O�C�����́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>���ʃI�u�W�F�N�g�𐶐�����B</LI>
	 * <LI>�N���X�ϐ��F���������ʃ^�C�v��THEN�̏ꍇ�́A�N���X�ϐ��F���[���I�u�W�F�N�g��THEN���ʂɁA
	 *�����������ʃI�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>��L�ȊO�̏ꍇ�́A�N���X�ϐ��F���[���I�u�W�F�N�g��THEN���ʂɁA
	 *�����������ʃI�u�W�F�N�g��ݒ肷��B</LI>
	 * <LI>XML���[�_�[�̃n���h���[���ďo�����n���h���[�ɖ߂��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.RESULT.toString().equals(qName)) {
			ResultObject resultObject = getResultObject();
			AbstractAction action = new AbstractAction(resultObject);

			if (IFType.IF_THEN == ifType) {
				rule.setThenAction(action);
			} else {
				rule.setElseAction(action);
			}
			reader.setContentHandler(callerHandler);
		}
	}
}
