package jp.escofi.emr.engine.search;

import java.util.Comparator;
import java.util.Map;

/**
 * �}�b�v�R���p���[�^�N���X�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�}�b�v���L�[�����Ń\�[�g���邽�߂ɃL�[���r����N���X�B
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
public class MapComparator implements Comparator<Object> {

	/**
	 * �L�[�l��r�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>��̃G���g���̃L�[�l���r����B
	 * </DL>
	 * @param obj1 �G���g��1
	 * @param obj2 �G���g��2
	 * @return ��r����
	 */
	@SuppressWarnings("unchecked")
	public int compare(Object obj1, Object obj2) {
		Map.Entry<String, Object> ent1 = (Map.Entry<String, Object>) obj1;
		Map.Entry<String, Object> ent2 = (Map.Entry<String, Object>) obj2;
		String val1 = ent1.getKey();
		String val2 = ent2.getKey();
		return val1.compareTo(val2);
	}

}
