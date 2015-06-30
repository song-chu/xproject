package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


/**
 * �}�b�v�^���C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v���}�b�v�̏ꍇ�A
 *�}�b�v�f�[�^�^�C�v�̃o�����[�i{@code <map>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class MapWriter extends AbstractAttributeValueWriter {

	/**
	 * �L�[����
	 */
	private String key;


	/**
	 * �R���X�g���N�^��XML�^�O��������������B
	 */
	public MapWriter() {
		super(ElementType.MAP);
	}


	/**
	 * @param key �L�[����
	 */
	public void setKey(String key) {
		this.key = key;
	}


	/**
	 * �^�O���e�����o�͏����B
	 * <OL>
	 * <LI>�N���X�ϐ��F�L�[���ڂ�z�񉻂���B({@code <entry>}��key�A�g���r���[�g)</LI>
	 * <LI>�p�����N���X�ϐ��F�^�O���e��z�񉻂���B({@code <entry>}�̃^�O���e)</LI>
	 * <LI>�L�[���ڔz��̍��ڐ��ƃ^�O���e�z��̍��ڐ��ō���������ꍇ�́A
	 *XML�o�͗�O�𐶐��Ethrow����B</LI>
	 * <LI>�L�[���ڔz��̍��ڐ����A�z�񍀖ڂ�{@code <entry>}�ŏo�͂���B</LI>
	 * </OL>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	@Override
	protected void outputBody(XMLWriter writer) throws SAXException {
		String elementName = ElementType.ENTRY.toString();
		String attName = AttributeType.KEY.toString();
		String empty = PDSConstants.EMPTY.toString();
		List<String> tmpKeys = split(key);
		List<String> tmpVals = split(value);
		AttributesImpl atts = new AttributesImpl();

		if (tmpKeys.size() != tmpVals.size()) {
			throw new SAXException(new EMRException(MessageCode.EMR_B_P910E));
		}

		// �A�g���r���[�g���̃L�[���ڂ�������
		atts.addAttribute(empty, attName, attName, PDSConstants.CDATA.toString(), empty);

		for (int i = 0; i < tmpKeys.size(); i++) {
			atts.setValue(0, tmpKeys.get(i));
			writer.dataElement(elementName, atts, tmpVals.get(i));
		}
	}

}
