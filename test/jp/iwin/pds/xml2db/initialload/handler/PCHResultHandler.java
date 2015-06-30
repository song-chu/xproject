package jp.iwin.pds.xml2db.initialload.handler;

import java.util.List;

import org.xml.sax.Attributes;

import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.constant.PCTIFType;
import jp.iwin.pds.xml2db.common.util.XMLWriter;
import jp.iwin.pds.xml2db.datamodel.PROAction;
import jp.iwin.pds.xml2db.datamodel.PROINIRule;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;


/**
 * ���������ʃn���h���[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�������茋��{@code <result>}�̗v�f����������SAX�C�x���g�n���h���[�B
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
 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHResultHandler extends PCHAResultObjectHandler {

	/**
	 * ���[���I�u�W�F�N�g
	 */
	private PROINIRule rule;
	/**
	 * �������^�C�v
	 */
	private PCTIFType ifType;

	private XMLWriter writer;


	/**
	 * �R���X�g���N�^�B
	 *
	 * @param callerHandler �ďo�����n���h���[
	 * @param rule ���[���I�u�W�F�N�g
	 * @param ifType �������^�C�v
	 * @param atts �A�g���r���[�g���
	 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
	 */
	public PCHResultHandler(PCHADelegateHandler callerHandler, PROINIRule rule,
			PCTIFType ifType, Attributes atts, XMLWriter writer) {

		super(callerHandler, atts);

		this.rule = rule;
		this.ifType = ifType;
		this.writer = writer;
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
	@SuppressWarnings("static-access")
	@Override
	public void endElement(String uri, String localName, String qName) {

		if (PCTElementType.RESULT.equals(qName)) {
			PCHKeyItemHandler.anser_no++;
			this.anser_id = Integer.toString(PCHKeyItemHandler.anser_no);
			this.writer.characters(this.anser_id );
			this.writer.endElement(qName);
			PROResultObject resultObject = getResultObject();
			PROAction action = new PROAction(resultObject);
			PCHConditionHandler.resultMap.put(this.anser_id, resultObject);

			if (PCTIFType.IF_THEN.equals(this.ifType)) {
				this.rule.setThenAction(action);
			} else {
				this.rule.setElseAction(action);
			}


			this.reader.setContentHandler(this.callerHandler);
		}
	}
}
