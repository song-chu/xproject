package jp.escofi.emr.engine.condition;

import java.util.Set;

import jp.escofi.emr.engine.common.constant.DataType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.XMLWriter;

import org.xml.sax.SAXException;

/**
 * �I�y�����h�萔���N���X�B
 * <DL>
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
public final class OperandConst extends AbstractOperand {

	/**
	 * �f�[�^�^
	 */
	private DataType dataType;
	/**
	 * �ϊ��O�����l�i�P��l�j
	 */
	private String strValue;
	/**
	 * �ϊ��O�����l�i�Z�b�g�j
	 */
	private Set<String> strSetValue;


	/**
	 * �����o�[�ϐ��Ɉ����̒l��ݒ肷��B
	 * @param value �萔�̒l
	 */
	public OperandConst(String value) {
		dataType = DataType.SINGLE;
		strValue = value;
	}
	/**
	 * �����o�[�ϐ��Ɉ����̒l��ݒ肷��B
	 * @param value �萔�̒l
	 */
	public OperandConst(Set<String> value) {
		dataType = DataType.SET;
		strSetValue = value;
	}


	/**
	 * @return �f�[�^�^
	 */
	public DataType getDataType() {
		return dataType;
	}
	/**
	 * @return �ϊ��O�����l�i�P��l�j
	 */
	public String getStrValue() {
		return strValue;
	}
	/**
	 * @return �ϊ��O�����l�i�Z�b�g�j
	 */
	public Set<String> getStrSetValue() {
		return strSetValue;
	}


	/**
	 * �I�y�����h�萔���������o���B
	 *
	 * @param writer ���C�^�[
	 * @throws SAXException XML��̓G���[
	 */
	protected void toDump(XMLWriter writer) throws SAXException {
		writer.startElement(ElementType.CONST.toString());

		if (DataType.SET == dataType) {
			String sName = ElementType.SET.toString();
			String eName = ElementType.ELEM.toString();

			writer.startElement(sName);

			for (String elem : strSetValue) {
				writer.dataElement(eName, elem);
			}
			writer.endElement(sName);
		} else {
			writer.dataElement(ElementType.SINGLE.toString(),
					strValue.toString());
		}
		writer.endElement(ElementType.CONST.toString());
	}

}
