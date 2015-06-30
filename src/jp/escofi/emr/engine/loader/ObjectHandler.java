package jp.escofi.emr.engine.loader;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.search.PDSObjObject;

/**
 * �I�u�W�F�N�g�^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���I�u�W�F�N�g�^�̏ꍇ�A
 *�I�u�W�F�N�g�f�[�^�^�C�v�̃o�����[�i{@code <object>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
public final class ObjectHandler extends AbstractDelegateHandler {

	/**
	 * �N���X��
	 */
	private String className = null;
	/**
	 * �N���X���
	 */
	private List<String> classInfo = null;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param className �N���X��
	 * @param classInfo �N���X���
	 */
	public ObjectHandler(
			AbstractResultObjectHandler callerHandler, String className, List<String> classInfo) {

		super(callerHandler);

		this.className = className;
		this.classInfo = classInfo;
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Ώۃ^�O���I�u�W�F�N�g�^�̏ꍇ�́A�ȉ��̏������s���B
	 * </P>
	 * <OL>
	 *  <LI>���s�I�u�W�F�N�g�𐶐�����B</LI>
	 *  <LI>�ďo�����n���h���[�̑����l�ɁA���s�I�u�W�F�N�g��ݒ肷��B</LI>
	 *  <LI>XML���[�_�[�̃n���h���[���A�ďo�����n���h���[�ɖ߂��B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (ElementType.OBJECT.toString().equals(qName)) {
			AbstractResultObjectHandler handler =
				(AbstractResultObjectHandler) callerHandler;
			PDSObjObject value = new PDSObjObject(className, classInfo);

			handler.setValue(value);
			reader.setContentHandler(handler);
		}
	}

}
