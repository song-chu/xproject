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
 * キー項目ハンドラー生成処理。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>キー項目ハンドラー郡のハンドラー生成メソッドを定義したファクトリークラス。
 *  <DT>最終開発リビジョン：
 *   <DD>$Revision: 1230 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-09 15:44:09 +0900 (譛ｨ, 09 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
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
	 * ファクトリークラスなのでコンストラクタはprivate指定。
	 */
	private PCHKeyItemHandlerFactory() {}

	public static int datamodel_id = 0;
	public static int key_solve_id=0;
	private static Map<String,Object> datamodelIdMap= new HashMap<String, Object>();
	private static Map<String,Object> keySolveMap= new HashMap<String, Object>();
	/**
	 * キー項目ハンドラー生成処理。
	 *
	 * @param dataModelHandler データモデルハンドラー
	 * @param dataModel データモデルのエレメント情報
	 * @param pdsObjectLocal ローカル変数のPDSオブジェクト（継承元用のテンポラリMap）
	 * @param itemKeys キー項目名リスト
	 * @return キー項目ハンドラーの新規インスタンス
	 * @see PCHDataModelHandlerFactory
	 */
	public static PCHKeyItemHandler createKeyItemHandler(
			PCHDataModelHandler dataModelHandler, Element dataModel,
			Map<String, Object> pdsObjectLocal, List<String> itemKeys,
			HashMap<String, List<String>> pdsItemKeysLocal) {

		String dataModelName = dataModel.getAttribute(
				PCTAttributeType.NAME.toString());
		// 継承元のデータモデル
		String extendsDM = dataModel.getAttribute(
				PCTAttributeType.EXTENDSDM.toString()).intern();
		Map<PCTAttributeType, String>  extendsInfo = getExtendsInfo(dataModel,itemKeys);

		// データモデルファイルPath
		String dataModelFile = dataModel.getAttribute(PCTAttributeType.FILE.toString());

		// 継承元か否かのフラグ
		String parentFlg = dataModel.getAttribute(PCTAttributeType.PARENTFLG.toString());

		//TblDataModel（データモデル）情報取得
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
		//継承元のデータモデルIDを取得するためにMapにPut（データモデル名、データモデルID）
		datamodelIdMap.put(dataModelName, datamodel_id);
//		tbldm.print();
		//DBにInsert
		SqlSessionUtil.insertDatamodel(tbldm);

		if(extendsInfo.get(PCTAttributeType.ATTRNAME_PARENT)!=null) {
			//TblKeySolve（キー項目解決）情報取得し、DBにInsert
			makeKeySolve(extendsDM,itemKeys,pdsItemKeysLocal);
		}

		// KeyItemHandler宣言
		PCHKeyItemHandler keyItemHandler;

		keyItemHandler = new PCHKeyItemHandler(dataModelHandler, extendsInfo,datamodel_id);

		return keyItemHandler;
	}

	private static void makeKeySolve(String extendsDM, List<String> itemKeys,HashMap<String, List<String>> pdsItemKeysLocal){
		//attrnameのIndex
		int attrIndex = itemKeys.indexOf(PCTAttributeType.ATTRNAME.toString());

		//attrnameより親に対してtblKeySolveを生成
		for(int j=0 ;j<attrIndex;j++){
			key_solve_id ++;
			TblKeySolve tblKeySolve = new TblKeySolve();
			tblKeySolve.setKey_solve_id(key_solve_id);
			tblKeySolve.setDatamodel_id(datamodel_id);
			tblKeySolve.setIndex(j+1);
//			tblKeySolve.setKey_jp_name(itemKeys.get(j));
			tblKeySolve.setKey_en_name(itemKeys.get(j));
			//継承IDを取得するためにMapにPut（キー名、キーID）
			keySolveMap.put(itemKeys.get(j), key_solve_id);
			//継承データモデルの場合
			if(extendsDM.length()>0){
				List<String> extendsitemKeys = pdsItemKeysLocal.get(extendsDM);
				int extendsattrIndex = extendsitemKeys.indexOf(PCTAttributeType.ATTRNAME.toString());
				if((attrIndex-j)<extendsitemKeys.size()){
					//継承元のキーを取得し、そのキーのIDを取得
					tblKeySolve.setExtend_key_solve_id((Integer)keySolveMap.get(extendsitemKeys.get(extendsattrIndex-(attrIndex-j))));
				}
			}
//			tblKeySolve.print();
			//DBにInsert
			SqlSessionUtil.insertKeySolve(tblKeySolve);
		}
	}

	/**
	 * 継承関係情報マップ取得。
	 *
	 * @param dataModel データモデルのエレメント情報
	 * @param itemKeys キー項目名リスト
	 * @return 継承関係情報マップ
	 */
	private static Map<PCTAttributeType, String> getExtendsInfo(Element dataModel, List<String> itemKeys) {
		HashMap<PCTAttributeType, String> extendsInfo = new HashMap<PCTAttributeType, String>();

		String attrnameChild = null;
		String attrnameParent = null;
		String initvalue = null;
		String extendsDM  = null;

		//initvalue取得
		initvalue = dataModel.getAttribute(PCTAttributeType.INITVALUE.toString());
		extendsInfo.put(PCTAttributeType.INITVALUE, initvalue);

		// 継承元のデータモデル
		extendsDM = dataModel.getAttribute(
				PCTAttributeType.EXTENDSDM.toString()).intern();
		if(extendsDM.length()>0){
		extendsInfo.put(PCTAttributeType.EXTENDSDM, datamodelIdMap.get(extendsDM).toString());
		}
		if(itemKeys.size()>1){
			int attrnameIdex = itemKeys.indexOf(PCTElementType.ATTRNAME.toString());
			//attrnameが最上位エレメントの場合、attrnameChild情報のみ取得
			if(attrnameIdex==0){
				attrnameChild = itemKeys.get(attrnameIdex+1);
			//attrnameが最下位エレメントの場合、attrnameParent情報のみ取得
			}else if(attrnameIdex==(itemKeys.size()-1)){
				attrnameParent = itemKeys.get(attrnameIdex-1);
			//attrnameが真ん中エレメントの場合、attrnameChild、attrnameParent情報取得
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
