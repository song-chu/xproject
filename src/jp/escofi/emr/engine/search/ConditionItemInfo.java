package jp.escofi.emr.engine.search;

import java.util.List;

/**
 * �������ڃ��X�g�N���X�B
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
public class ConditionItemInfo {

	/**
	 * �������ږ�
	 */
	private final String ITEM_NAME;

	/**
	 * �������ڃf�[�^�^
	 */
	private final String ITEM_TYPE;
	/**
	 * �������ړ����f�[�^�^
	 */
	private final String JAVA_DATA_TYPE;
	/**
	 * �������ڎ擾���
	 */
	private final List<String> SEARCH_INFO;

	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�[�ϐ��̒l��ݒ肷�邱�ƂŁA
	 * �O�����烁���o�[�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B�i�������ڒl���O�j
	 *
	 * @param itemName			�������ږ�
	 * @param itemType			�������ڃf�[�^�^
	 * @param javaDataType		�������ړ����f�[�^�^
	 * @param searchInfo		�������ڎ擾���
	 */
	public ConditionItemInfo(String itemName, String itemType, String javaDataType, List<String> searchInfo) {
		this.ITEM_NAME = itemName;
		this.ITEM_TYPE = itemType;
		this.JAVA_DATA_TYPE = javaDataType;
		this.SEARCH_INFO = searchInfo;
	}

	/**
	 * �������ږ��擾
	 * @return �������ږ�
	 */
	public final String getItemName() {
		return ITEM_NAME;
	}

	/**
	 * �������ڃf�[�^�^�擾
	 * @return �������ڃf�[�^�^
	 */
	public String getItemType() {
		return ITEM_TYPE;
	}

	/**
	 * �������ړ����f�[�^�^�擾
	 * @return �������ړ����f�[�^�^
	 */
	public String getJavaDataType() {
		return JAVA_DATA_TYPE;
	}

	/**
	 * �������ڎ擾���擾
	 * @return �������ڎ擾���
	 */
	public List<String> getSearchInfo() {
		return SEARCH_INFO;
	}
}
