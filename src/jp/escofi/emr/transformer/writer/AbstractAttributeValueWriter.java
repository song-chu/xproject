package jp.escofi.emr.transformer.writer;

import java.util.ArrayList;
import java.util.List;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.util.ConvertUtil;
import jp.escofi.emr.transformer.constant.PDSConstants;


/**
 * �e�����lXML���C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�o�͏����p�̃��C�^�[�Q�̋��ʏ������L�ڂ���XML���C�^�[�B�i���ۃN���X�j
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
public abstract class AbstractAttributeValueWriter extends AbstractXmlWriter {

	/**
	 * �����lID
	 */
	private int attValueID;
	/**
	 * ���^���
	 */
	private String metaInfo;
	/**
	 * ���ʔԍ�
	 */
	private int anserNo;
	/**
	 * �폜�t���O
	 */
	private boolean delFlg;


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * �R���X�g���N�^��XML�^�O��������������B
	 * </P>
	 * @param elementType �o�̓^�O���
	 */
	protected AbstractAttributeValueWriter(ElementType elementType) {
		super(elementType);
	}

	/**
	 * @return �����lID
	 */
	public final int getAttValueID() {
		return attValueID;
	}
	/**
	 * @param attValueID �����lID
	 */
	public final void setAttValueID(int attValueID) {
		this.attValueID = attValueID;
	}
	/**
	 * @return metainfo ���^���
	 */
	public final String getMetaInfo() {
		return metaInfo;
	}
	/**
	 * @param metaInfo ���^���
	 */
	public final void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
	}
	/**
	 * @return ���ʔԍ�
	 */
	public final int getAnserNo() {
		return anserNo;
	}
	/**
	 * @param anserNo ���ʔԍ�
	 */
	public final void setAnserNo(int anserNo) {
		this.anserNo = anserNo;
	}
	/**
	 * @return �폜�t���O
	 */
	public final boolean isDelFlg() {
		return delFlg;
	}
	/**
	 * @param delFlg �폜�t���O
	 */
	public final void setDelFlg(int delFlg) {
		this.delFlg = PDSConstants.TRUE.isEquals(
				String.valueOf(delFlg));
	}
	/**
	 * ����Java�f�[�^�^�ݒ�B
	 * <P>
	 * �^�O��javadatatype�A�g���r���[�g�ɒl��ݒ�B
	 * </P>
	 * @param javaDataType ����Java�f�[�^�^
	 */
	public final void setJavaDataType(String javaDataType) {
		setAttribute(AttributeType.JAVA_DATA_TYPE, javaDataType);
	}


	/**
	 * �p�����[�^������̃��X�g���B
	 * <P>
	 * List�l�AMap�L�[�AMap�l�̕�������J���}�i,�j��؂�Ń��X�g�ɕ�������B<BR>
	 * �������A�_�u���N�H�[�g�i"�j�ň͂񂾕�������̃J���}�͕�����Ƃ��Ă��̂܂܏o�͂���B<BR>
	 * �_�u���N�H�[�g�i"�j�ň͂񂾕�������ŁA�_�u���N�H�[�g��A�����Ă���ꍇ�́A
	 *�P��̃_�u���N�H�[�g�Ƃ��ďo�͂���B
	 * </P>
	 * <P>
	 * �Ώە����񂪋�̏ꍇ�́A�T�C�Y1�̋󕶎��̍��ڂ̃��X�g��Ԃ��B
	 * </P>
	 * @param param �Ώە�����
	 * @return ���X�g�������Ώە�����
	 */
	protected final List<String> split(String param) {
		List<String> ret;

		if (PDSConstants.EMPTY.isEquals(param)) {
			ret = new ArrayList<String>();
			ret.add(param);
		} else {
			ret =  ConvertUtil.parseCSV(param);
		}
		return ret;
	}

}
