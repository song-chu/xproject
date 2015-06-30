package jp.escofi.emr.transformer.util;

import jp.escofi.emr.engine.common.constant.DataType;

/**
 * �}�b�p�[���ʊ֐����[�e�B���e�B�B
 * <DL>
 * <DT>�g�p�ړI/�@�\�T�v�F
 * <DD>�}�b�p�[�N���X�Q�ɂĎg�p���鋤�ʊ֐����`�������[�e�B���e�B�N���X�B
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/08/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public class MapperUtil {

	/**
	 * �����^�C�v�z��F�o�����^�C�vCD�A�����^�C�v���p
	 * <UL>
	 * <LI>01:�P��^</LI>
	 * <LI>02:���X�g</LI>
	 * <LI>03:�}�b�v</LI>
	 * <LI>04:�͈͌^</LI>
	 * <LI>05:�I�u�W�F�N�g�^</LI>
	 * <LI>06:�Z�b�g�^</LI>
	 * </UL>
	 */
	private static final String[][] DATA_TYPE_ARRAY
	  = {{"01","single"}, {"02","list"}, {"03","map"}, {"04", "range"}, {"05", "object"}, {"06", "set"}};

	/**
	 * �����^�C�v�擾�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�w�肵�������^�C�v�R�[�h�ɊY�����鑮���^�C�v��ԋp�B
	 * </DL>
	 *
	 * @param cd �����^�C�v�R�[�h
	 * @return �����^�C�v�iEnum�^�j
	 * @throw IllegalArgumentException �w�肵�������^�C�v���K��̑����^�C�v�z��ɑ��݂��Ȃ��ꍇ
	 */
	public static DataType getDataTypeByCd(String cd) {

		for (String[] array : DATA_TYPE_ARRAY) {
			if (array[0].equals(cd)) {
				return DataType.getType(array[1]);
			}
		}
		throw new IllegalArgumentException("Invalid data type code:[" + cd + "]");
	}

	/**
	 * �����^�C�v���擾�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�w�肵�������^�C�v�R�[�h�ɊY�����鑮���^�C�v����ԋp�B
	 * </DL>
	 *
	 * @param cd �����^�C�v�R�[�h
	 * @return �����^�C�v��
	 * @throw IllegalArgumentException �w�肵�������^�C�v���K��̑����^�C�v�z��ɑ��݂��Ȃ��ꍇ
	 */
	public static String getDataTypeNameByCd(String cd) {
		for (String[] array : DATA_TYPE_ARRAY) {
			if (array[0].equals(cd)) {
				return array[1];
			}
		}
		throw new IllegalArgumentException("Invalid data type code:[" + cd + "]");
	}
}
