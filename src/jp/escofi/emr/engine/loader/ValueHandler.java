package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.search.ResultObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * �����l�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������ʂ̑����l({@code <value>})����������SAX�C�x���g�n���h���[�B
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
public final class ValueHandler extends AbstractResultObjectHandler {

	/**
	 * �������t���O
	 */
	private boolean condFlg;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 */
	public ValueHandler(KeyItemHandler callerHandler, Attributes atts) {

		super(callerHandler, atts);
		condFlg = ConvertUtil.isConvertBoolean(atts.getValue(AttributeType.COND_FLG.toString()));
	}


	/**
	 * �^�O�J�n�����B
	 * <UL>
	 *  <LI>���̑����l���p�����N���X�ϐ��F�폜�t���O��false�A�N���X�ϐ��F�������t���O��true�̏ꍇ�́A
	 *XML���[�_�[�ɏ������n���h���[��ݒ肷��B</LI>
	 *  <LI>��L�ȊO�̏ꍇ�́A�p�����N���X���\�b�h�̃^�O�J�n�������s���B</LI>
	 * </UL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 * @throws SAXException  ���̃n���h���[�̃f�[�^�^�Ǝq�^�O�̃^�O������v���Ȃ��ꍇ
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts)
	throws SAXException {

		if (!delFlg && condFlg) {
			ConditionHandler handler = RuleHandlerFactory.createConditionHandler(this);
			reader.setContentHandler(handler);
		} else {
			super.startElement(uri, localName, qName, atts);
		}
	}


	/**
	 * �^�O�I�������B
	 * <P>
	 * ���������ʃ^�O�C�����́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 *  <LI>���ʃI�u�W�F�N�g�𐶐�����B</LI>
	 *  <LI>�ďo�����n���h���[�ɁA�����������ʃI�u�W�F�N�g��ݒ肷��B</LI>
	 *  <LI>XML���[�_�[�̃n���h���[���ďo�����n���h���[�ɖ߂��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.VALUE.toString().equals(qName)) {
			ResultObject resultObject = getResultObject();

			((KeyItemHandler) callerHandler).setValue(resultObject);

			reader.setContentHandler(callerHandler);
		}
	}
}
