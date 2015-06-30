package jp.iwin.pds.xml2db.datatable;


/**
 * �e�X�g�f�[�^�����pSQL�C���^�[�t�F�[�X�B
 *
 * @author $Author: devuser05 $
 */
public interface TblMapper {

	/**
	 * �f�[�^���f���e�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllDatamodel();
	/**
	 * �����O���[�v�e�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllAttGroup();
	/**
	 * �L�[���ډ����e�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllKeySolve();
	/**
	 * �����Ǘ��e�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllAttElem();
	/**
	 * �������ڃe�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllAttField();
	/**
	 * �����Ǘ��e�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllArgsElem();
	/**
	 * �����l�e�[�u���S�폜�B
	 * @return �폜����
	 */
	int deleteAllAttValue();


	/**
	 * �f�[�^���f���e�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertDatamodel(TblDataModel datamodel);
	/**
	 * �����O���[�v�e�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertAttGroup(TblAttributeGroup attGroup);
	/**
	 * �L�[���ډ����e�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertKeySolve(TblKeySolve keySolve);
	/**
	 * �����Ǘ��e�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertAttElem(TblAttributeElem attElem);
	/**
	 * �������ڃe�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertAttField(TblAttributeField attField);
	/**
	 * �����Ǘ��e�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertArgsElem(TblArgsElem argsElem);
	/**
	 * �����l�e�[�u���f�[�^����
	 * @return SQL���s���ʒl
	 */
	int insertAttValue(TblAttributeValue attValue);

	/**
	 * �f�[�^���f���擾
	 * @param datamodel_id �f�[�^���f��ID
	 * @return �f�[�^���f��
	 */
	TblDataModel selectDataModel(int datamodel_id);
	/**
	 * �����O���[�v�擾
	 * @param attribute_group_id �����O���[�vID
	 * @return �����O���[�v
	 */
	TblAttributeGroup selectAttGroup(int attribute_group_id);
	/**
	 * �L�[���ډ����擾
	 * @param key_solve_id �L�[���ډ���ID
	 * @return �L�[���ډ���
	 */
	TblKeySolve selectKeySolve(int key_solve_id);
	/**
	 * �����Ǘ��擾
	 * @param attribute_elem_id �����Ǘ�ID
	 * @return �����Ǘ�
	 */
	TblAttributeElem selectAttElem(int attribute_elem_id);
	/**
	 * �������ڎ擾
	 * @param attribute_field_id ��������ID
	 * @return ��������
	 */
	TblAttributeField selectAttField(int attribute_field_id);
	/**
	 * �����Ǘ��擾
	 * @param args_elem_id �����Ǘ�ID
	 * @return �����Ǘ�
	 */
	TblArgsElem selectArgsElem(int args_elem_id);
	/**
	 * �����l�擾
	 * @param attribute_value_id �����lID
	 * @return �����l
	 */
	TblAttributeValue selectAttValue(int attribute_value_id);
	/**
	 * �Č��Ǘ��擾
	 * @param product_id �Č��Ǘ�ID
	 * @return �Č��Ǘ�
	 */
	TblProduct selectProduct(int product_id);

	/**
	 * �f�[�^���f���X�V
	 * @param datamodel �f�[�^���f��
	 * @return SQL���s���ʒl
	 */
	int updateDataModel(TblDataModel datamodel);
	/**
	 * �����O���[�v�X�V
	 * @param attGroup �����O���[�v
	 * @return SQL���s���ʒl
	 */
	int updateAttGroup(TblAttributeGroup attGroup);
	/**
	 * �L�[���ډ����X�V
	 * @param keySolve �L�[���ډ���
	 * @return SQL���s���ʒl
	 */
	int updateKeySolve(TblKeySolve keySolve);
	/**
	 * �����Ǘ��X�V
	 * @param attElem �����Ǘ�
	 * @return SQL���s���ʒl
	 */
	int updateAttElem(TblAttributeElem attElem);
	/**
	 * �������ڍX�V
	 * @param attField ��������
	 * @return SQL���s���ʒl
	 */
	int updateAttField(TblAttributeField attField);
	/**
	 * �����Ǘ��X�V
	 * @param argsElem �����Ǘ�
	 * @return SQL���s���ʒl
	 */
	int updateArgsElem(TblArgsElem argsElem);
	/**
	 * �����l�X�V
	 * @param attValue �����l
	 * @return SQL���s���ʒl
	 */
	int updateAttValue(TblAttributeValue attValue);
	/**
	 * �Č��Ǘ��X�V
	 * @param product �Č��Ǘ�
	 * @return SQL���s���ʒl
	 */
	int updateProduct(TblProduct product);

}
