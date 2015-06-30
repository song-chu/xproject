package jp.iwin.pds.xml2db.initialload.handler;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTCodeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.datamodel.PROAction;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.datamodel.PRORule;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHRuleHandlerFactory;

import org.xml.sax.Attributes;

/**
 * �����l�n���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������ʂ̑����l({@code <value>})����������SAX�C�x���g�n���h���[�B
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
 * @see PCHKeyItemHandler
 * @see PCHMapHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHValueHandler extends PCHAResultObjectHandler {

	/**
	 * �������t���O
	 */
	private boolean condflg;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler
	 * @param atts
	 * @see jp.iwin.pds.initialload.handler.factory.PCHRuleHandlerFactory
	 */
	public PCHValueHandler(PCHKeyItemHandler callerHandler, Attributes atts, String jpname) {

		super(callerHandler, atts, jpname);

		String condflg = atts.getValue(PCTAttributeType.CONDFLG.toString()).intern();
		this.condflg = PUTConvertUtil.convert(
				condflg, PCTCodeType.BOOLEAN.toString());

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
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {

		if ((!this.delflg)&&this.condflg) {
			PCHConditionHandler handler = PCHRuleHandlerFactory.createConditionHandler(this);

			this.reader.setContentHandler(handler);
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
	@SuppressWarnings("static-access")
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.VALUE.equals(qName)) {
			if((!this.delflg)&&this.condflg){
				PRORule rule = (PRORule) this.getValue();
				PROResultObject action = rule.getresultMap().get(this.anser_id);
				if(action.getJavaDataType()!=null){
					this.setJavaDataType(action.getJavaDataType());
				}
				this.setDataType(action.getDataType());
			}
			PROResultObject resultObject = getResultObject();

			((PCHKeyItemHandler) this.callerHandler).setValue(resultObject);
			this.reader.setContentHandler(this.callerHandler);
		}
	}
}
