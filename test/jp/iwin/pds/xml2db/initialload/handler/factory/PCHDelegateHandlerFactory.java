package jp.iwin.pds.xml2db.initialload.handler.factory;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.initialload.handler.PCHADelegateHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHAResultObjectHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHListHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHMapHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHObjectHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHRangeHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHSingleHandler;

import org.xml.sax.Attributes;


/**
 * Delegate�n���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>Delegate�n���h���[�S�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1062 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 11:11:06 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.initialload.handler.PCHAResultObjectHandler
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public final class PCHDelegateHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private PCHDelegateHandlerFactory() {}


	/**
	 * Delegate�n���h���[���������B
	 * <P>
	 * �����l�n���h���[�S�̓����ŃG�������g�^�C�v�ɉ������n���h���[�𐶐�����B<br>
	 * ���̃��\�b�h�Ő����ł���n���h���[�͉��L�B
	 * </P>
	 * <UL>
	 * <LI>���X�g�^�n���h���[</LI>
	 * <LI>�}�b�v�^�n���h���[</LI>
	 * <LI>�͈͌^�n���h���[</LI>
	 * <LI>�P��^�n���h���[</LI>
	 * <LI>�I�u�W�F�N�g�^�n���h���[</LI>
	 * </UL>
	 * <P>
	 * �G�������g�^�C�v�̒l��null�A�܂��͒�`�O�̃G�������g�^�C�v�̏ꍇ��null��Ԃ��B
	 * </P>
	 * <P>
	 * �������萔�n���h���[���ŒP��^�n���h���[�𐶐�����ꍇ�́A���̃��\�b�h�ł͂Ȃ��A
	 * {@link PCHRuleHandlerFactory#createRuleHandler(PCTElementType, jp.iwin.pds.initialload.handler.PCHConstHandler)}
	 * ���g�p����B
	 * </P>
	 * @param elementType �G�������g�^�C�v
	 * @param callerHandler �ďo�����n���h���[
	 * @param atts �A�g���r���[�g���
	 * @return �G�������g�^�C�v�ɉ������n���h���[
	 * @see jp.iwin.pds.initialload.handler.PCHAResultObjectHandler
	 */
	public static PCHADelegateHandler createDelegateHandler(
			PCTElementType elementType, PCHAResultObjectHandler callerHandler, Attributes atts) {

		switch (elementType) {
		case LIST:
			return new PCHListHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case MAP:
			return new PCHMapHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case RANGE:
			return new PCHRangeHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case SINGLE:
			return new PCHSingleHandler(callerHandler,
					atts.getValue(PCTAttributeType.JAVADATATYPE.toString()).intern());

		case OBJECT:
			return new PCHObjectHandler(callerHandler,
					atts.getValue(PCTAttributeType.CLASSNAME.toString()).intern(),
					atts.getValue(PCTAttributeType.SUBINFO.toString()).intern());

		default:
			return null;
		}
	}

}
