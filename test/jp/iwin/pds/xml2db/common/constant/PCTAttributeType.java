package jp.iwin.pds.xml2db.common.constant;


/**
 * �A�g���r���[�g�^�C�v��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�A�g���r���[�g�̃^�C�v��`enum�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1037 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 10:21:17 +0900 (火, 07 12 2010) $
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
public enum PCTAttributeType {

	/**
	 * ���O�i�p���j
	 */
	NAME("name"),
	/**
	 * ���O�i���{��j
	 */
	JPNAME("jpname"),
	/**
	 * �L�[����
	 */
	KEY("key"),
	/**
	 * �V�[�P���X�ԍ�
	 */
	SEQ("seq"),
	/**
	 * �t�@�C����
	 */
	FILE("file"),
	/**
	 * �g��
	 */
	EXTENDSDM("extendsdm"),
	/**
	 * �}�b�v���
	 */
	MAPTYPE("maptype"),
	/**
	 * �����l
	 */
	INITVALUE("initvalue"),
	/**
	 * �p�����t���O
	 */
	PARENTFLG("parentflg"),
	/**
	 * �������t���O
	 */
	CONDFLG("condflg"),
	/**
	 * �f�[�^�^
	 */
	DATATYPE("datatype"),
	/**
	 * �폜�t���O
	 */
	DELFLG("delflg"),
	/**
	 * �p�������
	 */
	ORG("org"),
	/**
	 * ����Java�f�[�^�^
	 */
	JAVADATATYPE("javadatatype"),
	/**
	 * �N���X��
	 */
	CLASSNAME("classname"),
	/**
	 * �N���X���
	 */
	SUBINFO("subinfo"),
	/**
	 * �܂ރt���O
	 */
	EQ("eq"),
	/**
	 * �������ڎ擾���
	 */
	VARINFO("varinfo"),
	/**
	 * ����l�܂�
	 */
	UPPEREQ("uppereq"),
	/**
	 * �����l�܂�
	 */
	LOWEREQ("lowereq"),
	/**
	 * ���^���
	 */
	METAINFO("metainfo"),
	/**
	 * �����l��
	 */
	ATTRNAME("attrname"),
	/**
	 * �p�����f�[�^���f����
	 */
	ATTRNAME_PARENT("attrnameParent"),
	/**
	 * �p����f�[�^���f����
	 */
	ATTRNAME_CHILD("attrnameChild"),
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
	private PCTAttributeType(String value) {
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
		return this.value.intern();
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
	public boolean equals(String value) {
		return this.value.equals(value);
	}

}
