package jp.iwin.pds.xml2db.initialload.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import jp.iwin.pds.xml2db.common.constant.PCTAttributeType;
import jp.iwin.pds.xml2db.common.constant.PCTElementType;
import jp.iwin.pds.xml2db.common.util.PUTConvertUtil;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.common.util.SqlSessionUtil;
import jp.iwin.pds.xml2db.datamodel.PROConditionItemInfo;
import jp.iwin.pds.xml2db.datamodel.PROObjObject;
import jp.iwin.pds.xml2db.datamodel.PRORangeObject;
import jp.iwin.pds.xml2db.datamodel.PROResultObject;
import jp.iwin.pds.xml2db.datamodel.PRORule;
import jp.iwin.pds.xml2db.datatable.TblArgsElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeElem;
import jp.iwin.pds.xml2db.datatable.TblAttributeField;
import jp.iwin.pds.xml2db.datatable.TblAttributeGroup;
import jp.iwin.pds.xml2db.datatable.TblAttributeValue;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHResultObjectHandlerFactory;

import org.xml.sax.Attributes;

/**
 * キー項目ハンドラー。
 * <DL>
 * <DT>使用目的/機能概要：
 * <DD>属性値（{@code <value>}）要素が現すまで、属性keyを持つ要素を制御するSAXのイベントハンドラー。
 * <DT>最終開発リビジョン：
 * <DD>$Revision: 1059 $
 * <DT>最終開発日時：
 * <DD>$Date: 2010-12-07 11:03:44 +0900 (轣ｫ, 07 12 2010) $
 * <DT>初版情報（作成日・作成者）：
 * <DD>2011/12/01 EBS
 * <DT>変更履歴（変更日、変更者、変更内容）：
 * <DD>
 * <UL>
 * <LI>2011/12/01 EBS 新規作成
 * </UL>
 * </DL>
 * <P>
 * Copyright(c)2011 Nissay Information Technology Co.,Ltd.
 * </P>
 *
 * @see PCHDataModelHandler
 * @see PCHKeyItemHandlerExt
 * @see PCHValueHandler
 * @see jp.iwin.pds.initialload.handler.factory.PCHDataModelHandlerFactory
 * @see jp.iwin.pds.initialload.handler.factory.PCHResultObjectHandlerFactory
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yi $
 */
public class PCHKeyItemHandler extends PCHADelegateHandler {

	/**
	 * キー項目名リスト
	 */
	protected List<String> keyNameList = new ArrayList<String>();
	/**
	 * 属性値オブジェクト
	 */
	protected Object value = null;
	/**
	 * 子データモデル情報マップ
	 */
	protected Map<String, Object> dataModelMap;
	/**
	 * キー項目リスト
	 */
	protected List<String> keys;
	/**
	 * attrnameタグの親タグ名
	 */
	private String attrnameParent;
	/**
	 * 継承元キー項目リスト
	 */
	private List<String> extendsKeys = new ArrayList<String>();

	/**
	 * データモデルID
	 */
	public static int attribute_group_id = 0;
	/**
	 * 属性管理ID
	 */
	public static int attribute_elem_id = 0;
	/**
	 * 属性項目ID
	 */
	public static int attribute_field_id = 0;
	/**
	 * 属性値ID
	 */
	public static int attribute_value_id = 0;
	/**
	 * 結果番号
	 */
	public static int anser_no = 0;
	/**
	 * 引数管理ID
	 */
	public static int args_elem_id = 0;

	/**
	 * データモデルID
	 */
	private int datamodel_id;

	/**
	 * 属性タイプMap
	 */
	private static Map<String, String> attribute_type_map = makeAttributeTypeMap();
	/**
	 * JAVAデータタイプMap
	 */
	private static Map<String, String> javadata_type_map = makeJavadataTyepMap();

	/**
	 * 継承元データモデルId
	 */
	private String extendsDM_id;

	/**
	 * データモデルグループMap
	 */
	private static Map<Integer, Object> attribute_group_map = new HashMap<Integer, Object>();

	/**
	 * グループMap
	 */
	private Map<Integer, List<String>> group_map = new HashMap<Integer, List<String>>();

	private String attrJpName;

	/**
	 * コンストラクタ。
	 *
	 * @param callerHandler
	 * @param extendsInfo
	 * @param datamodel_id
	 */
	public PCHKeyItemHandler(PCHDataModelHandler callerHandler,
			Map<PCTAttributeType, String> extendsInfo, int datamodel_id) {

		super(callerHandler);

		this.dataModelMap = callerHandler.getDataModelMap();
		this.keys = callerHandler.getKeys();
		this.attrnameParent = extendsInfo.get(PCTAttributeType.ATTRNAME_PARENT);
		this.datamodel_id = datamodel_id;
		this.extendsDM_id = extendsInfo.get(PCTAttributeType.EXTENDSDM);

	}

	/**
	 * 属性タイプMap生成
	 *
	 * @return
	 */
	private static Map<String, String> makeAttributeTypeMap() {
		Map<String, String> attribute_type_map = new HashMap<String, String>();
		attribute_type_map.put("single", "01");
		attribute_type_map.put("list", "02");
		attribute_type_map.put("map", "03");
		attribute_type_map.put("range", "04");
		attribute_type_map.put("object", "05");
		attribute_type_map.put("set", "06");
		return attribute_type_map;
	}

	/**
	 * JAVAデータタイプMap生成
	 *
	 * @return
	 */
	private static Map<String, String> makeJavadataTyepMap() {
		Map<String, String> javadata_type_map = new HashMap<String, String>();
		javadata_type_map.put("java.lang.String", "01");
		javadata_type_map.put("java.lang.Boolean", "02");
		javadata_type_map.put("java.lang.Integer", "03");
		javadata_type_map.put("java.lang.Long", "04");
		javadata_type_map.put("java.lang.Double", "05");
		javadata_type_map.put("java.math.BigDecimal", "06");
		return javadata_type_map;
	}

	/**
	 * タグ開始処理。
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ローカル名
	 * @param qName
	 *            参照中のタグ名
	 * @param atts
	 *            アトリビュート情報
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		PCTElementType elementType = PCTElementType.getType(qName);
		if (atts.getValue(PCTAttributeType.ORG.toString()) != null) {
			this.extendsKeys
					.add(atts.getValue(PCTAttributeType.ORG.toString()));
		}
		switch (elementType) {
		case VALUE:
			PCHValueHandler handler = PCHResultObjectHandlerFactory
					.createValueHandler(this, atts, this.attrJpName);
			this.reader.setContentHandler(handler);

			break;

		default:

			Map<String, Object> map = getDataModelMap(this.dataModelMap,
					this.keys);
			String keyName = atts.getValue(PCTAttributeType.NAME.toString())
					.intern();
			String key = atts.getValue(PCTAttributeType.KEY.toString())
					.intern();

			if (map != null) {
				Map<String, Object> childMap;

				if (PCTAttributeType.ATTRNAME.equals(keyName)) {
					this.attrJpName = atts.getValue(PCTAttributeType.JPNAME
							.toString());
					childMap = new TreeMap<String, Object>();
				} else {
					childMap = new HashMap<String, Object>();
				}
				this.value = childMap;
				map.put(key, childMap);
			}
			this.keys.add(key);
			this.keyNameList.add(keyName);
			break;
		}
	}

	/**
	 * タグ終了処理。
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ローカル名
	 * @param qName
	 *            参照中のタグ名
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case KEYITEM:

			String keyName = this.keyNameList.get(this.keyNameList.size() - 1);
			// attrnameの親タグの場合
			if (this.attrnameParent != null
					&& this.attrnameParent.equals(keyName)) {
				// 属性グループ生成メソッド呼び出し
				makeTblAttrGroup();
				// 属性値がnullではない場合
				if (this.value != null) {
					Map<String, Object> map = ((Map<String, Object>) this.value);
					// 属性管理生成メソッドを呼び出す
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						makeTblAttributeElem(entry);
					}
				}

				if (extendsKeys.size() > 0) {
					this.extendsKeys.remove(this.extendsKeys.size() - 1);
				}

			}
			String key = this.keys.remove(this.keys.size() - 1);
			Map<String, Object> map = getDataModelMap(this.dataModelMap,
					this.keys);
			this.keyNameList.remove(keyNameList.size() - 1);
			map.put(key, this.value);
			this.value = map;
			break;

		case DATAMODEL:
			// attrnameの親タグがデータモデルの場合
			if (this.attrnameParent == null) {
				// 属性グループ生成メソッド呼び出し
				makeTblAttrGroup();
				// 属性値がnullではない場合
				if (this.value != null) {
					Map<String, Object> attrmap = ((Map<String, Object>) this.value);
					// 属性管理生成メソッドを呼び出す
					for (Map.Entry<String, Object> entry : attrmap.entrySet()) {
						makeTblAttributeElem(entry);
					}
				}
			}
			// データモデル毎にAttributeグループ情報をput(データモデルID、AttributeグループMap）
			attribute_group_map.put(this.datamodel_id, this.group_map);
			// コーラーハンドラーから引数項目Mapを取得
			Map<String, PROConditionItemInfo> GlobalConditionItemMap = callerHandler
					.getGlobalConditionItemMap();
			// 引数項目をDBにInsert
			makeTblArgsElem(GlobalConditionItemMap);

			this.reader.setContentHandler(this.callerHandler);
			break;
		}
	}

	/**
	 * 引数管理
	 *
	 * @param GlobalConditionItemMap
	 */
	private void makeTblArgsElem(
			Map<String, PROConditionItemInfo> GlobalConditionItemMap) {

		for (Map.Entry<String, PROConditionItemInfo> argsEntry : GlobalConditionItemMap
				.entrySet()) {
			args_elem_id++;
			TblArgsElem tblArgsElem = new TblArgsElem();
			PROConditionItemInfo item = argsEntry.getValue();
			tblArgsElem.setArgs_elem_id(args_elem_id);
			tblArgsElem.setDatamodel_id(datamodel_id);
			tblArgsElem.setArgs_field_en_name(item.getItemName());
			tblArgsElem.setArgs_field_jp_name(item.getJpname());
			tblArgsElem.setAttribute_type_cd(attribute_type_map.get(item
					.getItemType().toLowerCase()));
			tblArgsElem.setJava_class_cd(javadata_type_map.get(item
					.getJavaDataType()));
			tblArgsElem.setArg_info(item.getSearchInfo());
			tblArgsElem.setProduct_id(Integer.parseInt(PUTPropertyUtil
					.getProperty("productID")));

			// tblArgsElem.print();
			SqlSessionUtil.insertArgElem(tblArgsElem);

		}
	}

	/**
	 * 属性グループ
	 */
	protected void makeTblAttrGroup() {
		TblAttributeGroup tblAttrGroup = new TblAttributeGroup();
		attribute_group_id++;
		tblAttrGroup.setAttribute_group_id(attribute_group_id);
		tblAttrGroup.setProduct_id(Integer.parseInt(PUTPropertyUtil
				.getProperty("productID")));
		for (int i = 0; i < this.keys.size(); i++) {
			if (i == 0) {
				tblAttrGroup.setDatamodel_id(datamodel_id);
			} else if (i == 1) {
				tblAttrGroup.setKey1(this.keys.get(i));

			} else if (i == 2) {
				tblAttrGroup.setKey2(this.keys.get(i));

			} else if (i == 3) {
				tblAttrGroup.setKey3(this.keys.get(i));

			} else if (i == 4) {
				tblAttrGroup.setKey4(this.keys.get(i));

			} else if (i == 5) {
				tblAttrGroup.setKey5(this.keys.get(i));

			} else if (i == 6) {
				tblAttrGroup.setKey6(this.keys.get(i));

			} else if (i == 7) {
				tblAttrGroup.setKey7(this.keys.get(i));

			} else if (i == 8) {
				tblAttrGroup.setKey8(this.keys.get(i));

			} else if (i == 9) {
				tblAttrGroup.setKey9(this.keys.get(i));

			} else if (i == 10) {
				tblAttrGroup.setKey10(this.keys.get(i));

			}
		}
		// ｋeyｓをkeylistにCopy
		List<String> keylist = new ArrayList<String>();
		for (int i = 0; i < this.keys.size(); i++) {
			keylist.add(this.keys.get(i));
		}
		// Attributeグループ情報
		this.group_map.put(attribute_group_id, keylist);

		if (this.extendsDM_id != null) {
			// 継承元属性グループId取得して、セット
			tblAttrGroup.setExtend_attribute_group_id(getExtendsGroupID());
		}
		// tblAttrGroup.print();

		SqlSessionUtil.inertAttGroup(tblAttrGroup);

	}

	/**
	 * 継承元属性グループId取得
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getExtendsGroupID() {
		// データモデルグループMapから継承データモデルのグループを取得
		Map<Integer, List<String>> extends_group_map = (Map<Integer, List<String>>) attribute_group_map
				.get(Integer.parseInt(this.extendsDM_id));

		for (Map.Entry<Integer, List<String>> entry : extends_group_map
				.entrySet()) {
			// グループのキーリストを取得
			List<String> extends_group = entry.getValue();
			// グループのキーリストからOｒｇ値リスト（this.extendsKeys）の数分引いて
			// 継承対象ではないキーを切り出す。
			int startidx = extends_group.size() - this.extendsKeys.size();
			List<String> orglist = extends_group.subList(startidx,
					extends_group.size());
			// 切り出したリストとOrg値リストが等しい場合、EntryのキーがAttributeグループのIdになる。
			if (this.extendsKeys.equals(orglist)) {
				return entry.getKey();
			}

		}
		return 0;
	}

	/**
	 * 属性管理
	 *
	 * @param entry
	 */
	@SuppressWarnings({ "unchecked" })
	private void makeTblAttributeElem(Map.Entry<String, Object> entry) {

		TblAttributeElem tblAttributeElem = new TblAttributeElem();
		attribute_elem_id++;
		tblAttributeElem.setAttribute_elem_id(attribute_elem_id);
		tblAttributeElem.setDatamodel_id(datamodel_id);
		tblAttributeElem.setAttribute_field_en_name(entry.getKey());
		tblAttributeElem.setProduct_id(Integer.parseInt(PUTPropertyUtil
				.getProperty("productID")));

		PROResultObject value = null;
		String javadatatype = null;

		// 属性値にFromキーが存在する場合
		if (entry.getValue() instanceof Map) {
			Map<String, Object> fromMap = ((Map<String, Object>) entry
					.getValue());
			for (Map.Entry<String, Object> fromEntry : fromMap.entrySet()) {
				value = (PROResultObject) fromEntry.getValue();
				if (value.getJavaDataType() != null) {
					javadatatype = javadata_type_map.get(value
							.getJavaDataType());
				}
				// Formキー用の属性項目生成メソッドを呼び出す
				makeTblAttributeField(fromEntry);
			}
		} else {
			value = (PROResultObject) entry.getValue();
			// 属性項目生成メソッドを呼び出す
			makeTblAttributeField(value);
			if (value.getJavaDataType() != null) {
				javadatatype = javadata_type_map.get(value.getJavaDataType());
			}
		}
		if (value.getJpname() != null) {
			tblAttributeElem.setAttribute_field_jp_name(value.getJpname());
		}

		if (!value.getDataType().equals("")) {
			tblAttributeElem.setAttribute_type_cd(attribute_type_map.get(value
					.getDataType().toLowerCase()));
		}

		if (javadatatype != null) {
			tblAttributeElem.setJava_class_cd(javadatatype);
		}
		// tblAttributeElem.print();

		SqlSessionUtil.insertAttElem(tblAttributeElem);

	}

	/**
	 * Formキー用属性項目
	 *
	 * @param fromEntry
	 */
	private void makeTblAttributeField(Map.Entry<String, Object> fromEntry) {

		TblAttributeField tblAttributeField = new TblAttributeField();
		attribute_field_id++;
		tblAttributeField.setAttribute_field_id(attribute_field_id);
		tblAttributeField.setAttribute_elem_id(attribute_elem_id);
		tblAttributeField.setAttribute_group_id(attribute_group_id);
		tblAttributeField.setFrom_key_value(fromEntry.getKey());
		tblAttributeField.setProduct_id(Integer.parseInt(PUTPropertyUtil
				.getProperty("productID")));
		PROResultObject value = (PROResultObject) fromEntry.getValue();
		// 属性値が条件式の場合
		if (value.getValue() instanceof PRORule) {
			tblAttributeField.setCondition_flg(true);
			// XML書き出し
			PRORule rule = (PRORule) value.getValue();
			tblAttributeField.setCondition_XML(rule.getXml());
			// アクションの結果番号の値を属性値テーブルにInsert
			for (Map.Entry<String, PROResultObject> entry : rule.getresultMap()
					.entrySet()) {
				makeTblAttributeValue(Integer.parseInt(entry.getKey()),
						entry.getValue());
			}

		} else {
			// 属性値生成メソッドを呼び出す（引数の「0」は結果番号）
			makeTblAttributeValue(0, (PROResultObject) fromEntry.getValue());
		}

		// tblAttributeField.print();
		SqlSessionUtil.insertAttField(tblAttributeField);

	}

	/**
	 * 属性項目
	 *
	 * @param value
	 */
	private void makeTblAttributeField(PROResultObject value) {

		TblAttributeField tblAttributeField = new TblAttributeField();
		attribute_field_id++;
		tblAttributeField.setAttribute_field_id(attribute_field_id);
		tblAttributeField.setAttribute_elem_id(attribute_elem_id);
		tblAttributeField.setAttribute_group_id(attribute_group_id);
		tblAttributeField.setProduct_id(Integer.parseInt(PUTPropertyUtil
				.getProperty("productID")));
		// 属性値が条件式の場合
		if (value.getValue() instanceof PRORule) {
			tblAttributeField.setCondition_flg(true);
			// XML書き出し
			PRORule rule = (PRORule) value.getValue();
			tblAttributeField.setCondition_XML(rule.getXml());
			// アクションの結果番号の値を属性値テーブルにInsert
			for (Map.Entry<String, PROResultObject> entry : rule.getresultMap()
					.entrySet()) {
				makeTblAttributeValue(Integer.parseInt(entry.getKey()),
						entry.getValue());
			}
		} else {
			// 属性値生成メソッドを呼び出す（引数の「0」は結果番号）
			makeTblAttributeValue(0, value);
		}

		// tblAttributeField.print();
		SqlSessionUtil.insertAttField(tblAttributeField);

	}

	/**
	 * 属性値
	 *
	 * @param anser_no
	 * @param value
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void makeTblAttributeValue(int anser_no, PROResultObject value) {

		TblAttributeValue tblAttributeValue = new TblAttributeValue();
		attribute_value_id++;
		tblAttributeValue.setAttribute_value_id(attribute_value_id);
		tblAttributeValue.setAttribute_field_id(attribute_field_id);
		tblAttributeValue.setAnser_no(anser_no);
		tblAttributeValue.setMetainfo(value.getMetaInfo());
		// delete 処理必要
		tblAttributeValue.setDrop_flg(value.isDeleted());

		if (value.getValue() == null) {

		} else if (value.getDataType().equals(PCTElementType.SINGLE.toString())) {
			tblAttributeValue.setSingle_value(value.getValue().toString());
		} else if (value.getDataType().equals(PCTElementType.LIST.toString())) {
			tblAttributeValue.setList_value(toString((List<Object>) value
					.getValue()));
		} else if (value.getDataType().equals(PCTElementType.MAP.toString())) {
			Map<String, Object> map = (Map) value.getValue();
			List<Object> keyList = new ArrayList<Object>();
			List<Object> valueList = new ArrayList<Object>();
			// キー順でソートする。
			List<Map.Entry<String, Object>> entries = PUTConvertUtil
					.sortMap(map);
			for (Entry<String, Object> entry : entries) {
				keyList.add(entry.getKey());
				valueList.add(entry.getValue());
			}
			tblAttributeValue.setMap_key(toString(keyList));
			tblAttributeValue.setMap_value(toString(valueList));
		} else if (value.getDataType().equals(PCTElementType.RANGE.toString())) {
			PRORangeObject range = (PRORangeObject) value.getValue();
			tblAttributeValue.setRange_lower(range.getMin());
			tblAttributeValue.setRange_lower_flg(range.includeMin());
			tblAttributeValue.setRange_upper(range.getMax());
			tblAttributeValue.setRange_upper_flg(range.includeMax());
		} else if (value.getDataType().equals(PCTElementType.OBJECT.toString())) {
			PROObjObject obj = (PROObjObject) value.getValue();
			tblAttributeValue.setObject_name(obj.getClassName());
			tblAttributeValue.setObject_info(obj.getAttachedInfo());
		}
		// tblAttributeValue.print();
		SqlSessionUtil.insertAttValue(tblAttributeValue);
	}

	/**
	 * list型をコンマ区切りのString型に変換
	 *
	 * @param list
	 * @return
	 */
	public String toString(List<Object> list) {

		StringBuilder buffer = new StringBuilder();
		int i = 0;
		if (list.size() > 0) {
			buffer.append(writeQuot(list.get(0).toString()));
			while (i < list.size() - 1) {
				i++;
				String str = writeQuot(list.get(i).toString());
				buffer.append(",");
				buffer.append(str);
			}
		}

		return buffer.toString();
	}

	private String writeQuot(String str){

		if(str.length()>0){
			if(str.contains(",")){
				str = "\"" + str + "\"";
			}else if((str.substring(0, 1).equals("\""))&&(str.substring(str.length()-1).equals("\""))){
				str = "\"\"" + str + "\"\"";
			}
		}

		return str;
	}

	/**
	 * データモデルマップを取得。
	 *
	 * @param orgMap
	 *            データモデルマップ
	 * @param keys
	 *            キー項目リスト
	 * @return データモデルマップ
	 * @see PCHKeyItemHandlerExt
	 */
	@SuppressWarnings("unchecked")
	protected final Map<String, Object> getDataModelMap(
			Map<String, Object> orgMap, List<String> keys) {
		Map<String, Object> map = orgMap;

		for (String key : keys) {
			map = (Map<String, Object>) map.get(key);
		}

		return map;
	}

	/**
	 * @param value
	 *            属性値オブジェクト
	 * @see PCHValueHandler
	 */
	protected final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * 継承関係解決。
	 * <P>
	 * キー項目の継承関係解決処理を行う。<BR>
	 * 通常は何もしない。<BR>
	 * 継承先キー項目ハンドラー側で処理ロジックを実装させる為のメソッド。
	 * </P>
	 *
	 * @param keyName
	 *            参照中のキー項目名
	 * @see PCHKeyItemHandlerExt
	 */
	protected void initDataModelMap(String keyName) {
	}

}
