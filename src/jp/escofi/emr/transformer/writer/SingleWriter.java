package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * �P��^���C�^�[�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�����l�̑����^�C�v���P��̏ꍇ�A
 *�P��f�[�^�^�C�v�̃o�����[�i{@code <single>}�j�̗v�f���o�͂���XML���C�^�[�B
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
public final class SingleWriter extends AbstractAttributeValueWriter {

	/**
	 * �R���X�g���N�^��XML�^�O��������������B
	 */
	public SingleWriter() {
		super(ElementType.SINGLE);
	}

}
