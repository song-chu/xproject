package jp.escofi.emr.transformer.constant;


/**
 * �^�p�c�[�������ʒ�`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���ʒ�`�N���X�B
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
public enum PDSConstants {

	/**
	 * �t���O�l�Ftrue
	 */
	TRUE("1"),
	/**
	 * �f�[�^��ʁFCDATA
	 */
	CDATA("CDATA"),
	/**
	 * MyBATIS�ݒ�t�@�C��
	 */
	CONF_MY_BATIS("configuration.xml"),
	/**
	 * JDBC�h���C�o
	 */
	JDBC_DRIVER("jdbc.driver"),
	/**
	 * JDBC URL
	 */
	JDBC_URL("jdbc.url"),
	/**
	 * JDBC ���[�U��
	 */
	JDBC_USER_NAME("jdbc.username"),
	/**
	 * JDBC �p�X���[�h
	 */
	JDBC_PASSWORD("jdbc.password"),
	/**
	 * XML�Ǘ��t�@�C����
	 */
	FILE_META("XML_Meta.xml"),
	/**
	 * XML�t�@�C���g���q
	 */
	FILE_XML(".xml"),
	/**
	 * ���������R�[�h
	 */
	CHARSET(System.getProperty("file.encoding", "Cp943C")),
	/**
	 * �󕶎���
	 */
	EMPTY(""),
	;


	/**
	 * �Ή��������`�l
	 */
	private String value;


	/**
	 * �R���X�g���N�^
	 * @param value	�萔�l
	 */
	private PDSConstants(String value) {
		this.value = value;
	}


	/**
	 * ��`�l��v����B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���̒�`�l�Ɣ�r�����񂪈�v���邩�𔻒肷��B
	 * </DL>
	 * @param value ��r������
	 * @return ��r����<BR>
	 *���̃^�C�v�̕�����\���Ɣ�r�����񂪈�v���Ă���΁Atrue
	 */
	public boolean isEquals(String value) {
		return value.equals(value);
	}

	/**
	 * ��`�l�擾�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>��`�l�̕�����\����Ԃ��B
	 * </DL>
	 * @return ��`�l
	 */
	@Override
	public String toString() {
		return value.intern();
	}

}
