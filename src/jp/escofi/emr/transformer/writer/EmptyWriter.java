package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.engine.common.constant.ElementType;


/**
 * �_�~�[���ڃ��C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>�_�~�[����({@code <empty>})���o�͂���XML���C�^�[�B
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
public final class EmptyWriter extends AbstractXmlWriter {

	/**
	 * ���ʃC���X�^���X
	 */
	private static final EmptyWriter WRITER = new EmptyWriter();


	/**
	 * @return �󍀖ڃ��C�^�[
	 */
	public static EmptyWriter getInstance() {
		return WRITER;
	}


	/**
	 * �R���X�g���N�^�B
	 * <P>
	 * ���̃C���X�^���X�̓V���O���g���Ƃ��邽�߁A�R���X�g���N�^��private�w��B
	 * </P>
	 * <UL>
	 *  <LI>XML�^�O��������������B</LI>
	 *  <LI>�^�O���e��null������B</LI>
	 *  <LI>�I���^�O�Ȃ���true�ɂ���B</LI>
	 * </UL>
	 */
	private EmptyWriter() {
		super(ElementType.EMPTY);
		childSet = null;
		value = null;
		isEmptyElement = true;
	}

}
