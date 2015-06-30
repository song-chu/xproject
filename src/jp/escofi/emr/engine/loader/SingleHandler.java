package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;


/**
 * �P��^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̑����^�C�v��Single�̏ꍇ�A
 *�P��f�[�^�^�C�v�̃o�����[�i{@code <single>}�j�ȉ��̗v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public class SingleHandler extends AbstractRuleHandler {

	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	private StringBuilder buffer = new StringBuilder();


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 */
	public SingleHandler(ConstHandler callerHandler) {
		super(callerHandler);
	}

	/**
	 * �R���X�g���N�^(����Java�f�[�^�^�t��)�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param javaDataType ����Java�f�[�^�^
	 */
	public SingleHandler(AbstractResultObjectHandler callerHandler, String javaDataType) {

		super(callerHandler);

		this.javaDataType = javaDataType;
	}


	/**
	 * �^�O���e�����B
	 * <p>
	 * �擾�����^�O���e��������N���X�ϐ��F�^�O���e�擾�o�b�t�@�֊i�[����B
	 * </p>
	 * @param ch �擾�����^�O���e
	 * @param start �J�n�ʒu
	 * @param length �Ώە�����
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (buffer != null) {
			buffer.append(ch, start, length);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���P��^�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <UL>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�������l�n���h���[�S�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɕϊ������^�O���e��ݒ肷��B</LI>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�ɃN���X�ϐ��F����Java�f�[�^�^��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 *  <LI>�p�����N���X�ϐ��F�ďo�����n���h���[���������萔�n���h���[�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�p�����N���X�ϐ��F�ďo�����n���h���[�Ɏ擾�����^�O���e��ݒ肷��B</LI>
	 *   </OL>
	 *  </LI>
	 * </UL>
	 * <P>
	 * ��L�̌ďo�����n���h���[���̏����̌�ɁA�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 * <LI>�p�����N���X�ϐ��FXML���[�_�[�Ɍp�����N���X�ϐ��F�ďo�����n���h���[��ݒ肷��B</LI>
	 * <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ɂ���B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.SINGLE.toString().equals(qName)) {
			String str = buffer.toString();

			if (callerHandler instanceof AbstractResultObjectHandler) {
				AbstractResultObjectHandler handler = (AbstractResultObjectHandler) callerHandler;
				Object value = ConvertUtil.convert(str, javaDataType);

				handler.setValue(value);
				handler.setJavaDataType(javaDataType);
			} else {
				ConstHandler handler = (ConstHandler)callerHandler;

				handler.setDataType(ElementType.SINGLE.toString());
				handler.setStrValue(str);
			}
			reader.setContentHandler(callerHandler);
			buffer = null;
		}
	}

}
