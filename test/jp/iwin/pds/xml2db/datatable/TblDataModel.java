package jp.iwin.pds.xml2db.datatable;


/**
 * データモデルテーブル。
 *
 * @author $Author: park.js $
 */
public final class TblDataModel {

	/**
	 * データモデルID
	 */
	private int datamodel_id;
	/**
	 * データモデル日本語名
	 */
	private String datamodel_jp_name="";
	/**
	 * データモデル英字名
	 */
	private String datamodel_en_name;
	/**
	 * 製品標準フラグ
	 */
	private int standard_flg = 0;
	/**
	 * 継承データモデルID
	 */
	private int extend_datamodel_id = 0;
	/**
	 * FROMキー項目有無
	 */
	private int from_key_flg = 0;
	/**
	 * FROMキー項目日本語名
	 */
	private String from_key_jp_name = "";
	/**
	 * FROMキー項目英字名
	 */
	private String from_key_en_name = "";
	/**
	 * FROMキー項目初期値
	 */
	private String from_key_defaultvalue = "";
	/**
	 * XMLファイル名
	 */
	private String xml_name;
	/**
	 * XMLオブジェクト化順序
	 */
	private int xml_object_index;
	/**
	 * 案件ID
	 */
	private int product_id = 1;
	/**
	 * 論理削除フラグ
	 */
	private int delete_flg = 0;
	/**
	 * メタ情報選択リスト
	 */
	private String metainfo_list = "";


	public void setDatamodel_id(int datamodel_id) {
		this.datamodel_id = datamodel_id;
	}

	public void setDatamodel_jp_name(String datamodel_jp_name) {
		this.datamodel_jp_name = datamodel_jp_name;
	}

	public void setDatamodel_en_name(String datamodel_en_name) {
		this.datamodel_en_name = datamodel_en_name;
	}

	public void setStandard_flg(boolean standard_flg) {

		if (standard_flg) {
			this.standard_flg = 1;
		} else {
			this.standard_flg = 0;
		}
	}

	public void setExtend_datamodel_id(int extend_datamodel_id) {
		this.extend_datamodel_id = extend_datamodel_id;
	}

	public void setFrom_key_flg(boolean from_key_flg) {

		if (from_key_flg) {
			this.from_key_flg = 1;
		} else {
			this.from_key_flg = 0;
		}
	}

	public void setFrom_key_jp_name(String from_key_jp_name) {
		this.from_key_jp_name = from_key_jp_name;
	}

	public void setFrom_key_en_name(String from_key_en_name) {
		this.from_key_en_name = from_key_en_name;
	}

	public void setFrom_key_defaultvalue(String from_key_defaultvalue) {
		this.from_key_defaultvalue = from_key_defaultvalue;
	}

	public void setXml_name(String xml_name) {
		this.xml_name = xml_name;
	}

	public void setXml_object_index(int xml_object_index) {
		this.xml_object_index = xml_object_index;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

	public void setMetainfo_list(String metainfo_list) {
		this.metainfo_list = metainfo_list;
	}

	public int getStandard_flg() {
		return this.standard_flg;
	}

	public void setStandard_flg(int standard_flg) {
		this.standard_flg = standard_flg;
	}

	public int getFrom_key_flg() {
		return this.from_key_flg;
	}

	public void setFrom_key_flg(int from_key_flg) {
		this.from_key_flg = from_key_flg;
	}


	public int getDatamodel_id() {
		return this.datamodel_id;
	}

	public String getDatamodel_jp_name() {
		return this.datamodel_jp_name;
	}

	public String getDatamodel_en_name() {
		return this.datamodel_en_name;
	}

	public int getExtend_datamodel_id() {
		return this.extend_datamodel_id;
	}

	public String getFrom_key_jp_name() {
		return this.from_key_jp_name;
	}

	public String getFrom_key_en_name() {
		return this.from_key_en_name;
	}

	public String getFrom_key_defaultvalue() {
		return this.from_key_defaultvalue;
	}

	public String getXml_name() {
		return this.xml_name;
	}

	public int getXml_object_index() {
		return this.xml_object_index;
	}

	public int getProduct_id() {
		return this.product_id;
	}

	public int getDelete_flg() {
		return this.delete_flg;
	}

	public String getMetainfo_list() {
		return this.metainfo_list;
	}

	public void print(){
		System.out.println("****************TblDataModel（データモデル）***************");
		System.out.println("datamodel_id          : " + this.datamodel_id);
		System.out.println("datamodel_jp_name     : " + this.datamodel_jp_name);
		System.out.println("datamodel_en_name     : " + this.datamodel_en_name);
		System.out.println("standard_flg          : " + this.standard_flg);
		System.out.println("extend_datamodel_id   : " + this.extend_datamodel_id);
		System.out.println("from_key_flg          : " + this.from_key_flg);
		System.out.println("from_key_jp_name      : " + this.from_key_jp_name);
		System.out.println("from_key_en_name      : " + this.from_key_en_name);
		System.out.println("from_key_defaultvalue : " + this.from_key_defaultvalue);
		System.out.println("xml_name              : " + this.xml_name);
		System.out.println("xml_object_index      : " + this.xml_object_index);
		System.out.println("product_id            : " + this.product_id);
		System.out.println("delete_flg            : " + this.delete_flg);
		System.out.println("metainfo_list         : " + this.metainfo_list);
	}



}
