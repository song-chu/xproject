package jp.iwin.pds.xml2db.datamodel;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTXMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * ���s�I�u�W�F�N�g�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>
 *    <UL>
 *     <LI> ���s�^�̒l��ێ�����N���X�B
 *     <LI> �����l�I�u�W�F�N�g�Ɋi�[�����N���X�B
 *    </UL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1047 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:49:56 +0900 (火, 07 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PROObjObject {
	/**
	 * ���s�I�u�W�F�N�g��
	 */
	private String className;
	/**
	 * �t�я��
	 */
	private String attachedInfo;

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�ϐ��̒l��ݒ肷�邱�Ƃ�
	 * �O�����烁���o�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B
	 * @param className		���s�I�u�W�F�N�g��
	 * @param attachedInfo	�t�я��
	 */
	public PROObjObject(String className, String attachedInfo) {
		this.className = className;
		this.attachedInfo = attachedInfo;
	}

	/**
	 * ���s�I�u�W�F�N�g���擾
	 * @return ���s�I�u�W�F�N�g��
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * �t�я��擾
	 * @return �t�я��
	 */
	public String getAttachedInfo() {
		return attachedInfo;
	}

	/**
	 * �I�u�W�F�N�g�^�����l�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�I�u�W�F�N�g�^�����l�������o���B
	 * </DL>
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	protected void toDump(PUTXMLWriter witer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		witer.addAttribute(atts, PCTAttributeType.CLASSNAME.toString(),
				this.className);
		witer.addAttribute(atts, PCTAttributeType.SUBINFO.toString(),
				this.attachedInfo);
		witer.emptyElement(PCTElementType.OBJECT.toString(), atts);
	}
}
