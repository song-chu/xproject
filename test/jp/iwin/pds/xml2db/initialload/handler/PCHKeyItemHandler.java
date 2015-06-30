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
 * �L�[���ڃn���h���[�B
 * <DL>
 * <DT>�g�p�ړI/�@�\�T�v�F
 * <DD>�����l�i{@code <value>}�j�v�f�������܂ŁA����key�����v�f�𐧌䂷��SAX�̃C�x���g�n���h���[�B
 * <DT>�ŏI�J�����r�W�����F
 * <DD>$Revision: 1059 $
 * <DT>�ŏI�J�������F
 * <DD>$Date: 2010-12-07 11:03:44 +0900 (火, 07 12 2010) $
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/12/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/12/01 EBS �V�K�쐬
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
	 * �L�[���ږ����X�g
	 */
	protected List<String> keyNameList = new ArrayList<String>();
	/**
	 * �����l�I�u�W�F�N�g
	 */
	protected Object value = null;
	/**
	 * �q�f�[�^���f�����}�b�v
	 */
	protected Map<String, Object> dataModelMap;
	/**
	 * �L�[���ڃ��X�g
	 */
	protected List<String> keys;
	/**
	 * attrname�^�O�̐e�^�O��
	 */
	private String attrnameParent;
	/**
	 * �p�����L�[���ڃ��X�g
	 */
	private List<String> extendsKeys = new ArrayList<String>();

	/**
	 * �f�[�^���f��ID
	 */
	public static int attribute_group_id = 0;
	/**
	 * �����Ǘ�ID
	 */
	public static int attribute_elem_id = 0;
	/**
	 * ��������ID
	 */
	public static int attribute_field_id = 0;
	/**
	 * �����lID
	 */
	public static int attribute_value_id = 0;
	/**
	 * ���ʔԍ�
	 */
	public static int anser_no = 0;
	/**
	 * �����Ǘ�ID
	 */
	public static int args_elem_id = 0;

	/**
	 * �f�[�^���f��ID
	 */
	private int datamodel_id;

	/**
	 * �����^�C�vMap
	 */
	private static Map<String, String> attribute_type_map = makeAttributeTypeMap();
	/**
	 * JAVA�f�[�^�^�C�vMap
	 */
	private static Map<String, String> javadata_type_map = makeJavadataTyepMap();

	/**
	 * �p�����f�[�^���f��Id
	 */
	private String extendsDM_id;

	/**
	 * �f�[�^���f���O���[�vMap
	 */
	private static Map<Integer, Object> attribute_group_map = new HashMap<Integer, Object>();

	/**
	 * �O���[�vMap
	 */
	private Map<Integer, List<String>> group_map = new HashMap<Integer, List<String>>();

	private String attrJpName;

	/**
	 * �R���X�g���N�^�B
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
	 * �����^�C�vMap����
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
	 * JAVA�f�[�^�^�C�vMap����
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
	 * �^�O�J�n�����B
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ���[�J����
	 * @param qName
	 *            �Q�ƒ��̃^�O��
	 * @param atts
	 *            �A�g���r���[�g���
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
	 * �^�O�I�������B
	 *
	 * @param uri
	 *            URI
	 * @param localName
	 *            ���[�J����
	 * @param qName
	 *            �Q�ƒ��̃^�O��
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void endElement(String uri, String localName, String qName) {
		PCTElementType elementType = PCTElementType.getType(qName);

		switch (elementType) {
		case KEYITEM:

			String keyName = this.keyNameList.get(this.keyNameList.size() - 1);
			// attrname�̐e�^�O�̏ꍇ
			if (this.attrnameParent != null
					&& this.attrnameParent.equals(keyName)) {
				// �����O���[�v�������\�b�h�Ăяo��
				makeTblAttrGroup();
				// �����l��null�ł͂Ȃ��ꍇ
				if (this.value != null) {
					Map<String, Object> map = ((Map<String, Object>) this.value);
					// �����Ǘ��������\�b�h���Ăяo��
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
			// attrname�̐e�^�O���f�[�^���f���̏ꍇ
			if (this.attrnameParent == null) {
				// �����O���[�v�������\�b�h�Ăяo��
				makeTblAttrGroup();
				// �����l��null�ł͂Ȃ��ꍇ
				if (this.value != null) {
					Map<String, Object> attrmap = ((Map<String, Object>) this.value);
					// �����Ǘ��������\�b�h���Ăяo��
					for (Map.Entry<String, Object> entry : attrmap.entrySet()) {
						makeTblAttributeElem(entry);
					}
				}
			}
			// �f�[�^���f������Attribute�O���[�v����put(�f�[�^���f��ID�AAttribute�O���[�vMap�j
			attribute_group_map.put(this.datamodel_id, this.group_map);
			// �R�[���[�n���h���[�����������Map���擾
			Map<String, PROConditionItemInfo> GlobalConditionItemMap = callerHandler
					.getGlobalConditionItemMap();
			// �������ڂ�DB��Insert
			makeTblArgsElem(GlobalConditionItemMap);

			this.reader.setContentHandler(this.callerHandler);
			break;
		}
	}

	/**
	 * �����Ǘ�
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
	 * �����O���[�v
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
		// ��ey����keylist��Copy
		List<String> keylist = new ArrayList<String>();
		for (int i = 0; i < this.keys.size(); i++) {
			keylist.add(this.keys.get(i));
		}
		// Attribute�O���[�v���
		this.group_map.put(attribute_group_id, keylist);

		if (this.extendsDM_id != null) {
			// �p���������O���[�vId�擾���āA�Z�b�g
			tblAttrGroup.setExtend_attribute_group_id(getExtendsGroupID());
		}
		// tblAttrGroup.print();

		SqlSessionUtil.inertAttGroup(tblAttrGroup);

	}

	/**
	 * �p���������O���[�vId�擾
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getExtendsGroupID() {
		// �f�[�^���f���O���[�vMap����p���f�[�^���f���̃O���[�v���擾
		Map<Integer, List<String>> extends_group_map = (Map<Integer, List<String>>) attribute_group_map
				.get(Integer.parseInt(this.extendsDM_id));

		for (Map.Entry<Integer, List<String>> entry : extends_group_map
				.entrySet()) {
			// �O���[�v�̃L�[���X�g���擾
			List<String> extends_group = entry.getValue();
			// �O���[�v�̃L�[���X�g����O�����l���X�g�ithis.extendsKeys�j�̐���������
			// �p���Ώۂł͂Ȃ��L�[��؂�o���B
			int startidx = extends_group.size() - this.extendsKeys.size();
			List<String> orglist = extends_group.subList(startidx,
					extends_group.size());
			// �؂�o�������X�g��Org�l���X�g���������ꍇ�AEntry�̃L�[��Attribute�O���[�v��Id�ɂȂ�B
			if (this.extendsKeys.equals(orglist)) {
				return entry.getKey();
			}

		}
		return 0;
	}

	/**
	 * �����Ǘ�
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

		// �����l��From�L�[�����݂���ꍇ
		if (entry.getValue() instanceof Map) {
			Map<String, Object> fromMap = ((Map<String, Object>) entry
					.getValue());
			for (Map.Entry<String, Object> fromEntry : fromMap.entrySet()) {
				value = (PROResultObject) fromEntry.getValue();
				if (value.getJavaDataType() != null) {
					javadatatype = javadata_type_map.get(value
							.getJavaDataType());
				}
				// Form�L�[�p�̑������ڐ������\�b�h���Ăяo��
				makeTblAttributeField(fromEntry);
			}
		} else {
			value = (PROResultObject) entry.getValue();
			// �������ڐ������\�b�h���Ăяo��
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
	 * Form�L�[�p��������
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
		// �����l���������̏ꍇ
		if (value.getValue() instanceof PRORule) {
			tblAttributeField.setCondition_flg(true);
			// XML�����o��
			PRORule rule = (PRORule) value.getValue();
			tblAttributeField.setCondition_XML(rule.getXml());
			// �A�N�V�����̌��ʔԍ��̒l�𑮐��l�e�[�u����Insert
			for (Map.Entry<String, PROResultObject> entry : rule.getresultMap()
					.entrySet()) {
				makeTblAttributeValue(Integer.parseInt(entry.getKey()),
						entry.getValue());
			}

		} else {
			// �����l�������\�b�h���Ăяo���i�����́u0�v�͌��ʔԍ��j
			makeTblAttributeValue(0, (PROResultObject) fromEntry.getValue());
		}

		// tblAttributeField.print();
		SqlSessionUtil.insertAttField(tblAttributeField);

	}

	/**
	 * ��������
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
		// �����l���������̏ꍇ
		if (value.getValue() instanceof PRORule) {
			tblAttributeField.setCondition_flg(true);
			// XML�����o��
			PRORule rule = (PRORule) value.getValue();
			tblAttributeField.setCondition_XML(rule.getXml());
			// �A�N�V�����̌��ʔԍ��̒l�𑮐��l�e�[�u����Insert
			for (Map.Entry<String, PROResultObject> entry : rule.getresultMap()
					.entrySet()) {
				makeTblAttributeValue(Integer.parseInt(entry.getKey()),
						entry.getValue());
			}
		} else {
			// �����l�������\�b�h���Ăяo���i�����́u0�v�͌��ʔԍ��j
			makeTblAttributeValue(0, value);
		}

		// tblAttributeField.print();
		SqlSessionUtil.insertAttField(tblAttributeField);

	}

	/**
	 * �����l
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
		// delete �����K�v
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
			// �L�[���Ń\�[�g����B
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
	 * list�^���R���}��؂��String�^�ɕϊ�
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
	 * �f�[�^���f���}�b�v���擾�B
	 *
	 * @param orgMap
	 *            �f�[�^���f���}�b�v
	 * @param keys
	 *            �L�[���ڃ��X�g
	 * @return �f�[�^���f���}�b�v
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
	 *            �����l�I�u�W�F�N�g
	 * @see PCHValueHandler
	 */
	protected final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * �p���֌W�����B
	 * <P>
	 * �L�[���ڂ̌p���֌W�����������s���B<BR>
	 * �ʏ�͉������Ȃ��B<BR>
	 * �p����L�[���ڃn���h���[���ŏ������W�b�N������������ׂ̃��\�b�h�B
	 * </P>
	 *
	 * @param keyName
	 *            �Q�ƒ��̃L�[���ږ�
	 * @see PCHKeyItemHandlerExt
	 */
	protected void initDataModelMap(String keyName) {
	}

}
