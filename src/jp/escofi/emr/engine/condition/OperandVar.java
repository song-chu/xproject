package jp.escofi.emr.engine.condition;

import java.util.Map;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.engine.search.ConditionItemInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * �I�y�����h�ϐ����N���X�B
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
public final class OperandVar extends AbstractOperand {

	/**
	 * �ϐ��i�������ځj��
	 */
	private String name;

	/**
	 * �������ږ��̃Z�b�^�[���\�b�h�B
	 * @param name �ϐ��i�������ځj��
	 */
	public OperandVar(String name) {
		this.name = name;
	}

	/**
	 * �������ږ��̃Q�b�^�[���\�b�h�B
	 * @return �ϐ��i�������ځj��
	 */
	protected String getName() {
		return name;
	}

	/**
	 * �I�y�����h�ϐ����������o���B
	 *
	 * @param writer ���C�^�[
	 * @param conditionItemMap �������ڃ}�b�v
	 * @throws SAXException XML��̓G���[
	 */
	protected void toDump(XMLWriter writer,
			Map<String, ConditionItemInfo> conditionItemMap)
			throws SAXException {
		AttributesImpl atts = new AttributesImpl();
		writer.addAttribute(atts, AttributeType.DATA_TYPE.toString(),
				conditionItemMap.get(name).getItemType());
		writer.addAttribute(atts, AttributeType.JAVA_DATA_TYPE.toString(),
				conditionItemMap.get(name).getJavaDataType());
		writer.addAttribute(atts, AttributeType.VAR_INFO.toString(),
				ConvertUtil.toCsvString(conditionItemMap.get(name).getSearchInfo()));
		writer.addAttribute(atts, AttributeType.REF.toString(),
				conditionItemMap.get(name).toString());
		writer.dataElement(ElementType.VAR.toString(), atts, name);
	}

}
