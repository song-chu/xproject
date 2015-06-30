package jp.escofi.emr.engine.search;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �I�u�W�F�N�g�^�I�u�W�F�N�g�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>
 *    <UL>
 *     <LI> �I�u�W�F�N�g�̒l��ێ�����N���X�B
 *     <LI> �����l�I�u�W�F�N�g�Ɋi�[�����N���X�B
 *    </UL>
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
public class PDSObjObject {
	/**
	 * ���s�I�u�W�F�N�g��
	 */
	private String className;
	/**
	 * �t�я��
	 */
	private List<String> attachedInfo;

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�ϐ��̒l��ݒ肷�邱�Ƃ�
	 * �O�����烁���o�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B
	 * @param className		���s�I�u�W�F�N�g��
	 * @param attachedInfo	�t�я��
	 */
	public PDSObjObject(String className, List<String> attachedInfo) {
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
	public List<String> getAttachedInfo() {
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
	public void toDump(XMLWriter writer) throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.CLASS_NAME.toString(),
				className);
		writer.addAttribute(atts, AttributeType.SUB_INFO.toString(),
				ConvertUtil.toCsvString(attachedInfo));
		writer.emptyElement(ElementType.OBJECT.toString(), atts);
	}
}
