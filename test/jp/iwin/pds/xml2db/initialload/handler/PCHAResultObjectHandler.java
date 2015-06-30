package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTCodeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHDelegateHandlerFactory;

import org.xml.sax.Attributes;


/**
 * �����l�e�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�i�������ʂ̑����l�E�������茋�ʂ̑����l�j�̋��ʏ������L�ڂ���SAX�C�x���g�n���h���[�̐e�N���X�B�i���ۃN���X�j
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1800 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date:: 2010-12-17 17:48:0#$
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHConditionHandler
 * @see PCHListHandler
 * @see PCHMapHandler
 * @see PCHObjectHandler
 * @see PCHRangeHandler
 * @see PCHResultHandler
 * @see PCHSingleHandler
 * @see PCHValueHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHDelegateHandlerFactory
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yj $
 */
public abstract class PCHAResultObjectHandler extends PCHADelegateHandler {

	/**
	 * �폜�t���O
	 */
	protected boolean delflg;

	/**
	 * �f�[�^�^
	 */
	private String dataType;

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

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

	private String jpname="";
	protected static String anser_id;

	public Object getValue() {
		return value;
	}



	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @see PCHResultHandler
	 * @see PCHValueHandler
	 */
	public PCHAResultObjectHandler(PCHADelegateHandler callerHandler, Attributes atts, String jpname) {

		super(callerHandler);

		String dataType = atts.getValue(PCTAttributeType.DATATYPE.toString()).intern();
		String delflg = atts.getValue(PCTAttributeType.DELFLG.toString()).intern();
		String metaInfo = atts.getValue(PCTAttributeType.METAINFO.toString()).intern();

		this.dataType = dataType;
		this.delflg = Boolean.parseBoolean(delflg);
		this.metaInfo = metaInfo;
		this.jpname= jpname;
	}

	public PCHAResultObjectHandler(PCHADelegateHandler callerHandler, Attributes atts) {

		super(callerHandler);

		String dataType = atts.getValue(PCTAttributeType.DATATYPE.toString()).intern();
		String delflg = atts.getValue(PCTAttributeType.DELFLG.toString()).intern();
		String metaInfo = atts.getValue(PCTAttributeType.METAINFO.toString()).intern();

		this.dataType = dataType;
		this.delflg = Boolean.parseBoolean(delflg);
		this.metaInfo = metaInfo;
	}


	/**
	 * �^�O�J�n�����B
	 * <P>
	 * �N���X�ϐ��F�폜�t���O��true�̏ꍇ�͉����s��Ȃ��B<BR>
	 * ��L�ȊO�̏ꍇ�́AXML���[�_�[�̃n���h���[���Q�Ƃ���^�O�ɉ������n���h���[�֐ؑւ���B
	 * </P>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @param atts �A�g���r���[�g���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if (this.delflg) {
			return;
		}
		PCTElementType elementType = PCTElementType.getType(qName);
		PCHADelegateHandler handler = PCHDelegateHandlerFactory.createDelegateHandler(
				elementType, this, atts);

		if (handler != null) {
			this.reader.setContentHandler(handler);
		}
	}

	/**
	 * ���ʃI�u�W�F�N�g�擾�����B
	 * <P>
	 * ���݂̃N���X�ϐ�����A���ʃI�u�W�F�N�g�𐶐�����B
	 * </P>
	 * @return ���ʃI�u�W�F�N�g
	 * @see PCHResultHandler
	 * @see PCHValueHandler
	 */
	protected final PROResultObject getResultObject() {
		return  new PROResultObject(this.value, this.dataType,
				this.javaDataType, this.delflg, this.metaInfo, this.jpname);
	}

	/**
	 * @param value �����l
	 * @see PCHConditionHandler
	 * @see PCHListHandler
	 * @see PCHMapHandler
	 * @see PCHObjectHandler
	 * @see PCHRangeHandler
	 * @see PCHSingleHandler
	 */
	protected final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @param javaDataType ����Java�f�[�^�^
	 * @see PCHListHandler
	 * @see PCHMapHandler
	 * @see PCHObjectHandler
	 * @see PCHRangeHandler
	 * @see PCHSingleHandler
	 */
	protected final void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType.intern();
	}

}
