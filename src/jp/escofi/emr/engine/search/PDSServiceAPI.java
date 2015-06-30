package jp.escofi.emr.engine.search;

import java.util.List;

import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.ConditionNotMatchedException;
import jp.escofi.emr.engine.common.exception.InitializeException;
import jp.escofi.emr.engine.common.exception.InvalidKeyException;
import jp.escofi.emr.engine.common.exception.UnExpectedStateException;

/**
 * ��̓G���W��API�N���X�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�Ɩ����b�p����̖⍇���v���ɑΉ����郁�\�b�h��񋟂���API�N���X�B
 *  <DT>�T���v���R�[�h�F
 *   <DD>�Ɩ����b�p�[����̌ďo����
 *    <PRE style='border: solid 2px #88f; background: #e8f8f8; margin: 1em; padding: 0 1em 1em; font: 100%/1.1em monospace;'><TT>
 *    // �L�[�������X�g�ɒǉ�����B�K���A�L�[�����Ƃ���ɒǉ����邱�ƁB
 *    List&lt;String&gt; keys = new ArrayList&lt;String&gt;();
 *
 *    keys.add("�f�[�^���f����");
 *    keys.add("�����L�[�P");
 *    keys.add("�����L�[�Q");
 *
 *    try {
 *        // �������ڎ擾���\�b�h���ďo���B
 *        PDSResponse res = PDSServiceAPI.getConditionItems(keys);
 *
 *        // �擾�������ʂ��������I�u�W�F�N�g�ł͂Ȃ��ꍇ
 *        if (!res.isCondition()) {
 *            // �������ʃX�e�[�^�X������ł͂Ȃ��ꍇ
 *            if (res.getStatus() != Status.NORMAL) {
 *                // �X�e�[�^�X�ɊY�����鏈���i�ȗ��j
 *            }
 *        } else {
 *            // �擾�������ʂ��������I�u�W�F�N�g�ł���ꍇ
 *              // ��������p�������ڃ}�b�v�擾���A�l��ݒ肷��B
 *              Map&lt;String, ConditionItemInfo&gt; conditionItemInfoMap = res.getConditionItemInfoMap();
 *            Map&lt;String, Object&gt; conditionItemValueMap = new  HashMap&lt;String, Object&gt;();
 *
 *            String itemName           = null;    // �������ږ�
 *              String itemType           = null;    // �������ڃf�[�^�^
 *              String javaDataType       = null;    // �������ړ����f�[�^�^
 *              List<String> searchInfo           = null;    // �������ڎ擾���
 *              Object value              = null;    // �������ڒl
 *
 *              Collection<ConditionItemInfo> collection = conditionItemInfoMap.values();
 *
 *            for(ConditionItemInfo conditionItemInfo: collection) {
 *
 *                // �������ڃN���X��������擾����B
 *                   itemName     = conditionItemInfo.getItemName();
 *                itemType     = conditionItemInfo.getItemType();
 *                javaDataType = conditionItemInfo.getJavaDataType();
 *                searchInfo   = conditionItemInfo.getSearchInfo();
 *
 *                // �������ڎ擾���Ɋ�Â��A�������ڂ��擾��A
 *                   // �������ڃf�[�^�^�A�������ړ����f�[�^�^�ɍ��킹�Č^�ϊ����A�������ڒl�ɑ������B
 *                  // (�ȗ�)
 *
 *                  // �������ڒl�}�b�v�ɐݒ�
 *                  conditionItemValueMap.put(itemName, value);
 *            }
 *
 *            // PDS�����N���X�Ɉ������ڒl�}�b�v��ݒ�
 *              res.setConditionItemValueMap(conditionItemValueMap);
 *
 *            // �����l�擾���\�b�h���Ăяo���B
 *              res = PDSServiceAPI.getAttrValue(res);
 *        }
 *        // �����l�I�u�W�F�N�g���擾���A���ʒl�I�u�W�F�N�g�Ɋi�[����B
 *          ResultObject ro = res.getResultObject();
 *         Object obj = ro.getValue();
 *
 *        // �f�[�^�^���m�F���A�����l�擾�������s���B
 *        if (obj instanceof RangeObject) {
 *            // �ȗ�
 *        } else if (obj instanceof bjObject) {
 *            // �ȗ�
 *        } else {
 *            // �ȗ�
 *        }
 *    } catch (UnExpectedStateException e) {
 *        // ��O�����i�ȗ��j
 *    } catch (InvalidKeyException e) {
 *        // ��O�����i�ȗ��j
 *    } catch (ConditionNotMatchedException e) {
 *        // ��O�����i�ȗ��j
 *    }
 *   </TT></E>
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
public class PDSServiceAPI {

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���N���X����̃R���X�g���N�^�̐�����h�����߁A�f�t�H���g�R���X�g���N�^��private�ɂ���B
	 * </DL>
	 */
	private PDSServiceAPI() {
	}

	/**
	 * �������ڎ擾�����B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����̌����L�[������̓G���W���֓n���A��̓G���W���̈������ڎ擾���\�b�h���Ăяo���B<BR>
	 *       ���̌��ʁA�ԋp�����PDS�����N���X���Ɩ����b�p�[�ɕԋp����B
	 *  <DT>�g�p���@�F
	 *   <DD>�N���XJavaDoc�̃T���v���R�[�h���Q��
	 *  <DT style='color: red'>���ӎ����F
	 *   <DD style='color: red; font-weight: bold'>
	 *    �ďo�����͈����̃L�[����PDS�I�u�W�F�N�g�iMap�j�f�[�^�i�[���Ƀ\�[�g���ēn�����ƁB
	 * </DL>
	 *
	 * @param keys �����L�[���
	 * @return PDS�����N���X
	 * @throws UnExpectedStateException �\���s�\��ԗ�O
	 * @throws InvalidKeyException �L�[�s����O
	 * @throws InitializeException �C�j�V�������[�h��O
	 */
	public static PDSResponse getConditionItems(List<String> keys)
			throws UnExpectedStateException, InvalidKeyException, InitializeException {

		// �C�j�V�������[�h����Ă��Ȃ��ꍇ
		if (!PDSEngine.isLoaded()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P008E);
		}
		return PDSEngine.getInstance().getConditionItems(keys);
	}

	/**
	 * �����l�擾�����B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>
	 *    <UL>������PDS�����N���X����̓G���W���֓n���A��̓G���W���̑����l�擾���\�b�h���ďo���B<BR>
	 *        ���̌��ʁA�ԋp�����PDS�����N���X���Ɩ����b�p�[�ɕԋp����B
	 *    </UL>
	 *  <DT>�g�p���@�F
	 *   <DD>�N���XJavaDoc�̃T���v���R�[�h���Q��
	 *  <DT>�O�񎖍��F
	 *   <DD>��������ɕK�v�Ȉ������ڒl���Ɩ����b�p�[�ɂ�������PDS�����N���X�ɐݒ肳��Ă��邱�ƁB
	 *  <DT style='color: red'>���ӎ����F
	 *   <DD style='color: red; font-weight: bold'>
	 *    �Ɩ����b�p�[�͈������ڎ擾�������s������A�����\�b�h���ďo�����ƁB
	 * </DL>
	 * @param res PDS�����N���X�i��������O�j
	 * @return PDS�����N���X�i���������j
	 * @throws InvalidKeyException �L�[�s����O
	 * @throws ConditionNotMatchedException �����s������O
	 * @throws InitializeException �C�j�V�������[�h��O
	 * @throws UnExpectedStateException �\���s�\��ԗ�O
	 */
	public static PDSResponse getAttrValue(PDSResponse res)
			throws InvalidKeyException, ConditionNotMatchedException, InitializeException, UnExpectedStateException {

		// �C�j�V�������[�h����Ă��Ȃ��ꍇ
		if (!PDSEngine.isLoaded()) {
			throw new UnExpectedStateException(MessageCode.EMR_A_P008E);
		}

		return PDSEngine.getInstance().getAttrValue(res);
	}

}
