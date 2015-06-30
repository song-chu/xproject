package jp.escofi.emr.engine.loader;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.MessageUtil;
import jp.escofi.emr.engine.search.ResultObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * �����l�e�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�i�������ʂ̑����l�E�������茋�ʂ̑����l�j�̋��ʏ������L�ڂ���SAX�C�x���g�n���h���[�̐e�N���X�B�i���ۃN���X�j
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
public abstract class AbstractResultObjectHandler extends AbstractDelegateHandler {

	/**
	 * �폜�t���O
	 */
	protected boolean delFlg;
	/**
	 * �f�[�^�^
	 */
	protected String dataType;

	/**
	 * ���^���
	 */
	private String metaInfo;
	/**
	 * ����Java�f�[�^�^
	 */
	private String javaDataType = null;
	/**
	 * �����l
	 */
	private Object value = null;

	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler
	 *            �ďo�����n���h���[
	 * @param atts
	 *            �A�g���r���[�g���
	 */
	public AbstractResultObjectHandler(AbstractDelegateHandler callerHandler,
			Attributes atts) {

		super(callerHandler);
		dataType = atts.getValue(AttributeType.DATA_TYPE.toString()).intern();
		delFlg = ConvertUtil.isConvertBoolean(atts.getValue(AttributeType.DEL_FLG.toString()));
		metaInfo = atts.getValue(AttributeType.META_INFO.toString()).intern();
	}

	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �N���X�ϐ��F�폜�t���O��true�̏ꍇ�͉����s��Ȃ��B<BR>
	 * ��L�ȊO�̏ꍇ�́AXML���[�_�[�̃n���h���[���Q�Ƃ���^�O�ɉ������n���h���[�֐ؑւ���B
	 * </P>
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ���[�J����
	 * @param qName
	 *            �Q�ƒ��̃^�O��
	 * @param atts
	 *            �A�g���r���[�g���
	 * @throws SAXException
	 *             ���̃n���h���[�̃f�[�^�^�Ǝq�^�O�̃^�O������v���Ȃ��ꍇ
	 * @throw IllegalArgumentException �����s����O
	 *        <UL>
	 *        <LI>����elementType��dataTypes�̐�����������Ȃ��ꍇ
	 *        </UL>
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if (delFlg) {
			return;
		}
		ElementType elementType = ElementType.getType(qName);

		if (!elementType.toString().equals(dataType)) {
			throw new IllegalArgumentException(MessageUtil.getMessage(
					MessageCode.EMR_A_P018E.toString(), new String[] {
							elementType.toString(), dataType }));
		}
		AbstractDelegateHandler handler = DelegateHandlerFactory
				.createDelegateHandler(elementType, this, atts);

		if (handler != null) {
			reader.setContentHandler(handler);
		}
	}

	/**
	 * ���ʃI�u�W�F�N�g�擾�����B
	 * <P>
	 * ���݂̃N���X�ϐ�����A���ʃI�u�W�F�N�g�𐶐�����B
	 * </P>
	 *
	 * @return ���ʃI�u�W�F�N�g
	 */
	protected final ResultObject getResultObject() {
		return new ResultObject(value, dataType, javaDataType, delFlg,
				metaInfo);
	}

	/**
	 * @param value
	 *            �����l
	 */
	protected final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @param javaDataType
	 *            ����Java�f�[�^�^
	 */
	protected final void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}

}
