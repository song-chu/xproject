package jp.escofi.emr.transformer.writer;

import java.util.List;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;


/**
 * ���X�g�^���C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̃f�[�^�^�C�v�����X�g�̏ꍇ�A
 *���X�g�f�[�^�^�C�v�̃o�����[�i{@code <list>}�j�ȉ��̗v�f���o�͂���XML���C�^�[�B
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
public final class ListWriter extends AbstractAttributeValueWriter {


	/**
	 * �R���X�g���N�^��XML�^�O��������������B
	 */
	public ListWriter() {
		super(ElementType.LIST);
	}


	/**
	 * �^�O���e�����o�͏����B
	 * <OL>
	 * <LI>�p�����N���X�ϐ��F�^�O���e��z�񉻂���B</LI>
	 * <LI>�z��̍��ڐ����A�z�񍀖ڂ�{@code <elem>}�ŏo�͂���B</LI>
	 * </OL>
	 * @param writer XML���C�^�[
	 * @throws SAXException XML�o�͗�O
	 */
	@Override
	protected void outputBody(XMLWriter writer) throws SAXException {
		String elementName = ElementType.ELEM.toString();
		List<String> tmp = split(value);

		for (String val : tmp) {
			writer.dataElement(elementName, val);
		}
	}

}
