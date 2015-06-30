package jp.escofi.emr.engine.common.constant;

/**
 * ���b�Z�[�W�R�[�h��`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>PDS�G���W���ɂė��p���郁�b�Z�[�W�R�[�h���`����enum�N���X�B
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
public enum MessageCode {
	/**
	 * EMR_A_P001E:�����s���B�����Ώۂ̃f�[�^���f�������݂��܂���B(�f�[�^���f�����F{0}�j
	 */
	EMR_A_P001E,
	/**
	 * EMR_A_P002E:�����s���B�L�[���ڐ�����v���܂���B(�����F{0}�A�f�[�^���f���F{1}�j
	 */
	EMR_A_P002E,
	/**
	 * EMR_A_P003E:�f�[�^�Ȃ��B�w�肵���L�[���ڂɊY������f�[�^������܂���B(�����L�[�F{0}�j
	 */
	EMR_A_P003E,
	/**
	 * EMR_A_P004E:{0}�����݂��܂���B�i�t�@�C���p�X�F{1}�j
	 */
	EMR_A_P004E,
	/**
	 * {0}�������ł��B�i�t�@�C�����F{1}�j
	 */
	EMR_A_P005E,
	/**
	 * EMR_A_P006E:PDS�I�u�W�F�N�g�A������PDS�I�u�W�F�N�g�L�[���ڂ�NULL�ł��B
	 */
	EMR_A_P006E,
	/**
	 * EMR_A_P007E:�������ڂɊY��������������݂��܂���B�i�������ځF{0}�j
	 */
	EMR_A_P007E,
	/**
	 * EMR_A_P008E:�C�j�V�������[�h����Ă��܂���B
	 */
	EMR_A_P008E,
	/**
	 * EMR_A_P009E:�C�j�V�������[�h���ɃG���[���������܂����B
	 */
	EMR_A_P009E,
	/**
	 * EMR_A_P010E:�\�����ʏ�Ԃ��������܂����B
	 */
	EMR_A_P010E,
	/**
	 * EMR_A_P011E:{0}�������ł��B
	 */
	EMR_A_P011E,
	/**
	 * EMR_A_P012I:�C�j�V�������[�h���J�n���܂��B
	 */
	EMR_A_P012I,
	/**
	 * EMR_A_P013I:�C�j�V�������[�h���������܂����B
	 */
	EMR_A_P013I,
	/**
	 * EMR_A_P014E:�L�[���ڂɑ�����������܂���B(�����L�[�F{0}�j
	 */
	EMR_A_P014E,
	/**
	 * EMR_A_P015E:�����s���B�_���v�Ώۂ̃f�[�^���f�������݂��܂���B(�f�[�^���f�����F{0}�j
	 */
	EMR_A_P015E,
	/**
	 * EMR_A_P016E:�_���v�������ɃG���[���������܂����B
	 */
	EMR_A_P016E,
	/**
	 * EMR_A_P017E:�^�O�ɕs���������݂��܂��B(elementType:{0}�Adatatypes:{1})
	 */
	EMR_A_P017E,
	/**
	 * EMR_A_P018E:�^�O�ɕs���������݂��܂��B(elementType:{0}�Adatatype:{1})
	 */
	EMR_A_P018E,
	/**
	 * EMR_A_P019E:�^�O�ɕs���������݂��܂��B(conditionType:{0}�AjavaDataType:{1}�Aset:{2})
	 */
	EMR_A_P019E,
	/**
	 * EMR_A_P020E:�p���Ώۑ�����������܂���B(�L�[���ڃ��X�g�F{0}�A�p�����L�[���ڃ��X�g�F{1})
	 */
	EMR_A_P020E,
	/**
	 * EMR_A_P021E:�p���Ώۃf�[�^���f����������܂���B(�f�[�^���f�����F{0}�A�p�����f�[�^���f���F{1})
	 */
	EMRA_A_P021E,
	/**
	 * EMR_B_P901I=�^�p�c�[�����J�n���܂��B(�Č�CD�F{0}�C�t�@�C���o�͐�F{1})
	 */
	EMR_B_P901I,
	/**
	 * EMR_B_P902I=�^�p�c�[�����I�����܂����B
	 */
	EMR_B_P902I,
	/**
	 * EMR_B_P903E=DB�R�l�N�V�����擾�Ɏ��s���܂����B
	 */
	EMR_B_P903E,
	/**
	 * EMR_B_P904E=XML�t�@�C���o�͒�IO�G���[���������܂����B(�t�@�C���p�X�F{0})
	 */
	EMR_B_P904E,
	/**
	 * EMR_B_P905E=XML�t�@�C���o�͒�XML�G���[���������܂����B(�t�@�C���p�X�F{0})
	 */
	EMR_B_P905E,
	/**
	 * EMR_B_P906E=�Č��f�[�^�����݂��܂���B(�Č�CD�F{0})
	 */
	EMR_B_P906E,
	/**
	 * EMR_B_P907E=�����s���B{0}���w�肳��Ă��܂���B
	 */
	EMR_B_P907E,
	/**
	 * EMR_B_P908E=�����s���B�����̐����s���ł��B�i�����F{0}�j
	 */
	EMR_B_P908E,
	/**
	 * EMR_B_P909E=XML�t�@�C���o�͏�����SQL�G���[���������܂����B
	 */
	EMR_B_P909E,
	/**
	 * EMR_B_P910E=�\�����ʏ�Ԃ��������܂����B
	 */
	EMR_B_P910E,
	/**
	 * EMR_B_P911E=�Č�CD�̌������s���ł��B(�Č�CD�F{0})
	 */
	EMR_B_P911E,
	/**
	 * EMR_B_P912E=�f�[�^���f�������݂��܂���B(�Č�CD�F{0})
	 */
	EMR_B_P912E,
}
