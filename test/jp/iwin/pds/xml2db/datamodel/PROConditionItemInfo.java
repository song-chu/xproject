package jp.iwin.pds.xml2db.datamodel;

import java.util.List;

/**
 * �������ڃ��X�g�N���X�B
 * <DL>
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1104 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-07 15:13:14 +0900 (07 12 2010) $
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
 * @author $Author: park.js $
 */
public class PROConditionItemInfo {

	/**
	 * �������ږ�
	 */
	private final String itemName;

	/**
	 * �������ڃf�[�^�^
	 */
	private final String itemType;
	/**
	 * �������ړ����f�[�^�^
	 */
	private final String javaDataType;
	/**
	 * �������ڎ擾���
	 */
	private final List<String> searchInfo;
	/**
	 * �������ړ��{�ꖼ
	 */
	private final String jpname;



	/**
	 * �R���X�g���N�^<br>
	 * �R���X�g���N�^���烁���o�[�ϐ��̒l��ݒ肷�邱�ƂŁA
	 * �O�����烁���o�[�ϐ��̒l�͕ύX�ł��Ȃ��悤�ɂ���B�i�������ڒl���O�j
	 *
	 * @param itemType		�������ڃf�[�^�^
	 * @param javaDataType		�������ړ����f�[�^�^
	 * @param searchInfo	�������ڎ擾���
	 */
	public PROConditionItemInfo(String itemName, String itemType, String javaDataType, List<String> searchInfo,String jpname) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.javaDataType = javaDataType;
		this.searchInfo = searchInfo;
		this.jpname = jpname;
	}

	/**
	 * �������ږ��擾
	 * @return itemName	�������ږ�
	 */
	public final String getItemName() {
		return itemName;
	}

	/**
	 * �������ڃf�[�^�^�擾
	 * @return �������ڃf�[�^�^
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * �������ړ����f�[�^�^�擾
	 * @return �������ړ����f�[�^�^
	 */
	public String getJavaDataType() {
		return javaDataType;
	}

	/**
	 * �������ڎ擾���擾
	 * @return �������ڎ擾���
	 */
	public List<String> getSearchInfo() {
		return searchInfo;
	}

	/**
	 * �������ړ��{�ꖼ�擾
	 * @return
	 */
	public String getJpname() {
		return jpname;
	}
}
