package jp.escofi.emr.engine.common.constant;


/**
 * �A�g���r���[�g�^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�A�g���r���[�g�̃^�C�v��`enum�N���X�B
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/0801 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public enum AttributeType {

	/**
	 * ���O�i�p���j
	 */
	NAME("name"),
	/**
	 * ���O�i���{��j
	 */
	JP_NAME("jpname"),
	/**
	 * �L�[����
	 */
	KEY("key"),
	/**
	 * �t�@�C����
	 */
	FILE("file"),
	/**
	 * �g��
	 */
	EXTENDS_DM("extendsdm"),
	/**
	 * �����l
	 */
	INIT_VALUE("initvalue"),
	/**
	 * �p�����t���O
	 */
	PARENT_FLG("parentflg"),
	/**
	 * �������t���O
	 */
	COND_FLG("condflg"),
	/**
	 * �f�[�^�^
	 */
	DATA_TYPE("datatype"),
	/**
	 * �폜�t���O
	 */
	DEL_FLG("delflg"),
	/**
	 * �p�������
	 */
	ORG("org"),
	/**
	 * ����Java�f�[�^�^
	 */
	JAVA_DATA_TYPE("javadatatype"),
	/**
	 * �N���X��
	 */
	CLASS_NAME("classname"),
	/**
	 * �N���X���
	 */
	SUB_INFO("subinfo"),
	/**
	 * �܂ރt���O
	 */
	EQ("eq"),
	/**
	 * �������ڎ擾���
	 */
	VAR_INFO("varinfo"),
	/**
	 * ����l�܂�
	 */
	UPPER_EQ("uppereq"),
	/**
	 * �����l�܂�
	 */
	LOWER_EQ("lowereq"),
	/**
	 * ���^���
	 */
	META_INFO("metainfo"),
	/**
	 * �����l��
	 */
	ATTR_NAME("attrname"),
	/**
	 * �p�����f�[�^���f����
	 */
	ATTR_NAME_PARENT("attrnameParent"),
	/**
	 * �p����f�[�^���f����
	 */
	ATTR_NAME_CHILD("attrnameChild"),
	/**
	 * �������[��̃A�h���X
	 */
	REF("ref"),
	;

	/**
	 * �Ή�������A�g���r���[�g��
	 */
	private String value;

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�R���X�g���N�^�N���X�B
	 * </DL>
	 * @param value �Ή�������A�g���r���[�g��
	 */
	private AttributeType(String value) {
		this.value = value;
	}

	/**
	 * �A�g���r���[�g���擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>������\����Ή�����A�g���r���[�g����Ԃ��B
	 * </DL>
	 * @return �A�g���r���[�g��
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * �������v����B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���̃^�C�v�̕�����\���Ɣ�r�����񂪈�v���邩�𔻒肷��B
	 * </DL>
	 * @param value ��r������
	 * @return ��r����<BR>
	 *���̃^�C�v�̕�����\���Ɣ�r�����񂪈�v���Ă���΁Atrue
	 */
	public boolean isEquals(String value) {
		return value.equals(value);
	}

}
