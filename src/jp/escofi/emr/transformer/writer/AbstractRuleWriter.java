package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.exception.EMRException;

import org.xml.sax.SAXException;


/**
 * �e������XML���C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>������XML�^�O�o�͏����̋��ʕ������`����B�i���ۃN���X�j
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
abstract class AbstractRuleWriter extends AbstractXmlWriter {

	/**
	 * �ďo�������C�^�[
	 */
	ConditionWriter callerWriter = null;
	/**
	 * �^�O���e�擾�o�b�t�@
	 */
	StringBuilder buffer = null;


	/**
	 * �R���X�g���N�^({@code <condition>}�^�O)�B
	 * <OL>
	 *  <LI>�p�����N���X�̃R���X�g���N�^�ďo���B</LI>
	 * </OL>
	 * @param elementType �o�̓^�O���
	 */
	AbstractRuleWriter(ElementType elementType) {
		super(elementType);
	}

	/**
	 * �R���X�g���N�^({@code <condition>}�^�O�ȊO)�B
	 * <OL>
	 *  <LI>�p�����N���X�̃R���X�g���N�^�ďo���B</LI>
	 *  <LI>�ďo�������C�^�[�̎q�^�O�Z�b�g�Ɏ��g��ǉ��B</LI>
	 *  <LI>�ďo�������C�^�[���N���X�ϐ��ɕێ��B</LI>
	 * </OL>
	 * @param elementType �o�̓^�O���
	 * @param callerWriter �ďo�������C�^�[
	 */
	AbstractRuleWriter(ElementType elementType, ConditionWriter callerWriter) {
		super(elementType);
		callerWriter.childSet.add(this);
		this.callerWriter = callerWriter;
	}


	/**
	 * �^�O���e�����B
	 * <P>
	 * �擾�����^�O���e��������N���X�ϐ��F�^�O���e�擾�o�b�t�@�֊i�[����B
	 * </P>
	 * @param ch �擾�����^�O���e
	 * @param start �J�n�ʒu
	 * @param length �Ώە�����
	 */
	@Override
	public void characters(char[] ch, int start, int length) {

		if (buffer != null) {
			buffer.append(ch, start, length);
		}
	}

	/**
	 * �^�O�I�������B
	 * <P>
	 * �Q�ƒ��̃^�O�����p�����N���X�ϐ��F�o�̓^�O��ʂƈ�v����ꍇ�́A�ȉ��̏��������{����B
	 * </P>
	 * <OL>
	 *  <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null�ȊO�̏ꍇ�́A�p����N���X�̃^�O�I�������ďo���B</LI>
	 *  <LI>��L�̏����ŋƖ���O��throw���ꂽ�ꍇ�́A�Ɩ���O��SAX��O�Ƀ��b�v����throw����B</LI>
	 *  <LI>�N���X�ϐ��F�ďo�������C�^�[��null�ȊO�̏ꍇ�́A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�N���X�ϐ��F�ďo�������C�^�[��XML���[�_�[�̃R���e���c�n���h���[���N���X�ϐ��F�ďo�������C�^�[�֐ؑւ���B</LI>
	 *    <LI>�N���X�ϐ��F�ďo�������C�^�[��null������B</LI>
	 *   </OL>
	 *  <LI>�N���X�ϐ��F�^�O���e�擾�o�b�t�@��null������B</LI>
	 * </OL>
	 * @param uri URI
	 * @param localName ���[�J����
	 * @param qName �Q�ƒ��̃^�O��
	 * @throws SAXException �p����N���X�̃^�O�I�������Ŕ��������Ɩ���O
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (elementType.equals(qName)) {

			try {
				endElement();
			} catch (EMRException e) {
				throw new SAXException(e);
			}

			if (callerWriter != null) {
				callerWriter.reader.setContentHandler(callerWriter);
				callerWriter = null;
			}
			buffer = null;
		}
	}


	/**
	 * �p����N���X�̃^�O�I�������B
	 *
	 * @throws EMRException �Ɩ���O
	 */
	abstract void endElement() throws EMRException;

}
