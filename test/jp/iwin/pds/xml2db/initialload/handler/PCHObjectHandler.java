package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.datamodel.PROObjObject;

/**
 * �I�u�W�F�N�g�^�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���I�u�W�F�N�g�^�̏ꍇ�A
 *�I�u�W�F�N�g�f�[�^�^�C�v�̃o�����[�i{@code <object>}�j�v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHObjectHandler extends PCHADelegateHandler {

	/**
	 * �N���X��
	 */
	private String className = null;
	/**
	 * �N���X���
	 */
	private String classInfo = null;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param className �N���X��
	 * @param classInfo �N���X���
	 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
	 */
	public PCHObjectHandler(
			PCHAResultObjectHandler callerHandler, String className, String classInfo) {

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

		if (PCTElementType.OBJECT.equals(qName)) {
			PCHAResultObjectHandler handler =
				(PCHAResultObjectHandler) this.callerHandler;
			PROObjObject value = new PROObjObject(this.className, this.classInfo);

			handler.setValue(value);
			this.reader.setContentHandler(handler);
		}
	}

}
