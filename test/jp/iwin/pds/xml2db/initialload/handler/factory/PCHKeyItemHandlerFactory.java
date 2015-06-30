package jp.iwin.pds.xml2db.initialload.handler.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.common.util.SqlSessionUtil;
import jp.iwin.pds.xml2db.datatable.TblDataModel;
import jp.iwin.pds.xml2db.datatable.TblKeySolve;
import jp.iwin.pds.xml2db.initialload.handler.PCHDataModelHandler;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;

import org.w3c.dom.Element;


/**
 * �L�[���ڃn���h���[���������B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�L�[���ڃn���h���[�S�̃n���h���[�������\�b�h���`�����t�@�N�g���[�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1230 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date: 2010-12-09 15:44:09 +0900 (木, 09 12 2010) $
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see PCHDataModelHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: park.js $
 */
public class PCHKeyItemHandlerFactory {

	/**
	 * �t�@�N�g���[�N���X�Ȃ̂ŃR���X�g���N�^��private�w��B
	 */
	private PCHKeyItemHandlerFactory() {}

	public static int datamodel_id = 0;
	public static int key_solve_id=0;
	private static Map<String,Object> datamodelIdMap= new HashMap<String, Object>();
	private static Map<String,Object> keySolveMap= new HashMap<String, Object>();
	/**
	 * �L�[���ڃn���h���[���������B
	 *
	 * @param dataModelHandler �f�[�^���f���n���h���[
	 * @param dataModel �f�[�^���f���̃G�������g���
	 * @param pdsObjectLocal ���[�J���ϐ���PDS�I�u�W�F�N�g�i�p�����p�̃e���|����Map�j
	 * @param itemKeys �L�[���ږ����X�g
	 * @return �L�[���ڃn���h���[�̐V�K�C���X�^���X
	 * @see PCHDataModelHandlerFactory
	 */
	public static PCHKeyItemHandler createKeyItemHandler(
			PCHDataModelHandler dataModelHandler, Element dataModel,
			Map<String, Object> pdsObjectLocal, List<String> itemKeys,
			HashMap<String, List<String>> pdsItemKeysLocal) {

		String dataModelName = dataModel.getAttribute(
				PCTAttributeType.NAME.toString());
		// �p�����̃f�[�^���f��
		String extendsDM = dataModel.getAttribute(
				PCTAttributeType.EXTENDSDM.toString()).intern();
		Map<PCTAttributeType, String>  extendsInfo = getExtendsInfo(dataModel,itemKeys);

		// �f�[�^���f���t�@�C��Path
		String dataModelFile = dataModel.getAttribute(PCTAttributeType.FILE.toString());

		// �p�������ۂ��̃t���O
		String parentFlg = dataModel.getAttribute(PCTAttributeType.PARENTFLG.toString());

		//TblDataModel�i�f�[�^���f���j���擾
		datamodel_id ++;
		TblDataModel tbldm=new TblDataModel();
		tbldm.setDatamodel_id(datamodel_id);
		tbldm.setXml_object_index(datamodel_id);
		tbldm.setDatamodel_en_name(dataModelName);
//		tbldm.setDatamodel_jp_name(dataModelName);
		tbldm.setStandard_flg(Boolean.parseBoolean(parentFlg));
		tbldm.setXml_name(dataModelFile);
		tbldm.setProduct_id(Integer.parseInt(PUTPropertyUtil.getProperty("productID")));
		if(extendsDM.length()>0){
			tbldm.setExtend_datamodel_id((Integer)datamodelIdMap.get(extendsDM));
		}

		if(extendsInfo.get(PCTAttributeType.ATTRNAME_CHILD)!=null){
			tbldm.setFrom_key_flg(true);
			tbldm.setFrom_key_defaultvalue(extendsInfo.get(PCTAttributeType.INITVALUE));
			tbldm.setFrom_key_en_name(extendsInfo.get(PCTAttributeType.ATTRNAME_CHILD));
			tbldm.setFrom_key_jp_name(extendsInfo.get(PCTAttributeType.ATTRNAME_CHILD));
		}
		//�p�����̃f�[�^���f��ID���擾���邽�߂�Map��Put�i�f�[�^���f�����A�f�[�^���f��ID�j
		datamodelIdMap.put(dataModelName, datamodel_id);
//		tbldm.print();
		//DB��Insert
		SqlSessionUtil.insertDatamodel(tbldm);

		if(extendsInfo.get(PCTAttributeType.ATTRNAME_PARENT)!=null) {
			//TblKeySolve�i�L�[���ډ����j���擾���ADB��Insert
			makeKeySolve(extendsDM,itemKeys,pdsItemKeysLocal);
		}

		// KeyItemHandler�錾
		PCHKeyItemHandler keyItemHandler;

		keyItemHandler = new PCHKeyItemHandler(dataModelHandler, extendsInfo,datamodel_id);

		return keyItemHandler;
	}

	private static void makeKeySolve(String extendsDM, List<String> itemKeys,HashMap<String, List<String>> pdsItemKeysLocal){
		//attrname��Index
		int attrIndex = itemKeys.indexOf(PCTAttributeType.ATTRNAME.toString());

		//attrname���e�ɑ΂���tblKeySolve�𐶐�
		for(int j=0 ;j<attrIndex;j++){
			key_solve_id ++;
			TblKeySolve tblKeySolve = new TblKeySolve();
			tblKeySolve.setKey_solve_id(key_solve_id);
			tblKeySolve.setDatamodel_id(datamodel_id);
			tblKeySolve.setIndex(j+1);
//			tblKeySolve.setKey_jp_name(itemKeys.get(j));
			tblKeySolve.setKey_en_name(itemKeys.get(j));
			//�p��ID���擾���邽�߂�Map��Put�i�L�[���A�L�[ID�j
			keySolveMap.put(itemKeys.get(j), key_solve_id);
			//�p���f�[�^���f���̏ꍇ
			if(extendsDM.length()>0){
				List<String> extendsitemKeys = pdsItemKeysLocal.get(extendsDM);
				int extendsattrIndex = extendsitemKeys.indexOf(PCTAttributeType.ATTRNAME.toString());
				if((attrIndex-j)<extendsitemKeys.size()){
					//�p�����̃L�[���擾���A���̃L�[��ID���擾
					tblKeySolve.setExtend_key_solve_id((Integer)keySolveMap.get(extendsitemKeys.get(extendsattrIndex-(attrIndex-j))));
				}
			}
//			tblKeySolve.print();
			//DB��Insert
			SqlSessionUtil.insertKeySolve(tblKeySolve);
		}
	}

	/**
	 * �p���֌W���}�b�v�擾�B
	 *
	 * @param dataModel �f�[�^���f���̃G�������g���
	 * @param itemKeys �L�[���ږ����X�g
	 * @return �p���֌W���}�b�v
	 */
	private static Map<PCTAttributeType, String> getExtendsInfo(Element dataModel, List<String> itemKeys) {
		HashMap<PCTAttributeType, String> extendsInfo = new HashMap<PCTAttributeType, String>();

		String attrnameChild = null;
		String attrnameParent = null;
		String initvalue = null;
		String extendsDM  = null;

		//initvalue�擾
		initvalue = dataModel.getAttribute(PCTAttributeType.INITVALUE.toString());
		extendsInfo.put(PCTAttributeType.INITVALUE, initvalue);

		// �p�����̃f�[�^���f��
		extendsDM = dataModel.getAttribute(
				PCTAttributeType.EXTENDSDM.toString()).intern();
		if(extendsDM.length()>0){
		extendsInfo.put(PCTAttributeType.EXTENDSDM, datamodelIdMap.get(extendsDM).toString());
		}
		if(itemKeys.size()>1){
			int attrnameIdex = itemKeys.indexOf(PCTElementType.ATTRNAME.toString());
			//attrname���ŏ�ʃG�������g�̏ꍇ�AattrnameChild���̂ݎ擾
			if(attrnameIdex==0){
				attrnameChild = itemKeys.get(attrnameIdex+1);
			//attrname���ŉ��ʃG�������g�̏ꍇ�AattrnameParent���̂ݎ擾
			}else if(attrnameIdex==(itemKeys.size()-1)){
				attrnameParent = itemKeys.get(attrnameIdex-1);
			//attrname���^�񒆃G�������g�̏ꍇ�AattrnameChild�AattrnameParent���擾
			}else{
				attrnameChild = itemKeys.get(attrnameIdex+1);
				attrnameParent = itemKeys.get(attrnameIdex-1);
			}
		}

		extendsInfo.put(PCTAttributeType.ATTRNAME_PARENT, attrnameParent);
		extendsInfo.put(PCTAttributeType.ATTRNAME_CHILD, attrnameChild);

		return extendsInfo;
	}

}
