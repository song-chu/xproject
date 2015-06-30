package jp.iwin.pds.xml2db.datatable;



/**
 * 属性値テーブル。
 *
 * @author $Author: devuser05 $
 */
public final class TblAttributeValue {

	/**
	 * 属性値ID
	 */
	private int attribute_value_id = 0;

	/**
	 * 属性項目ID
	 */
	private int attribute_field_id;

	/**
	 * 結果番号
	 */
	private int anser_no = 0;

	/**
	 * 結果値（単一値）
	 */
	private String single_value = "";

	/**
	 * 結果値（リスト）
	 */
	private String list_value = "";

	/**
	 * MAP（キー）
	 */
	private String map_key = "";

	/**
	 * MAP（値）
	 */
	private String map_value = "";

	/**
	 * 範囲（上限値）
	 */
	private String range_upper = "";

	/**
	 * 範囲（上限含むフラグ）
	 */
	private int range_upper_flg = 0;

	/**
	 * 範囲（下限値）
	 */
	private String range_lower = "";

	/**
	 * 範囲（下限含むフラグ）
	 */
	private int range_lower_flg = 0;

	/**
	 * オブジェクト名
	 */
	private String object_name = "";

	/**
	 * 付帯情報
	 */
	private String object_info = "";

	/**
	 * 定義なしフラグ
	 */
	private int drop_flg = 0;

	/**
	 * ランパーコントロール情報
	 */
	private String metainfo = "";


	public void setAttribute_value_id(int attribute_value_id) {
		this.attribute_value_id = attribute_value_id;
	}

	public void setAttribute_field_id(int attribute_field_id) {
		this.attribute_field_id = attribute_field_id;
	}

	public void setAnser_no(int anser_no) {
		this.anser_no = anser_no;
	}

	public void setSingle_value(String single_value) {
		this.single_value = single_value;
	}

	public void setList_value(String list_value) {
		this.list_value = list_value;
	}

	public void setMap_key(String  map_key) {
		this.map_key = map_key;
	}

	public void setMap_value(String  map_value) {
		this.map_value = map_value;
	}

	public void setRange_upper(Object range_upper) {
		this.range_upper = range_upper.toString();
	}

	public void setRange_upper_flg(boolean range_upper_flg) {

		if (range_upper_flg) {
			this.range_upper_flg = 1;
		} else {
			this.range_upper_flg = 0;
		}
	}

	public void setRange_lower(Object range_lower) {
		this.range_lower = range_lower.toString();
	}

	public void setRange_lower_flg(boolean range_lower_flg) {

		if (range_lower_flg) {
			this.range_lower_flg = 1;
		} else {
			this.range_lower_flg = 0;
		}
	}

	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}

	public void setObject_info(String object_info) {
		this.object_info = object_info;
	}

	public void setDrop_flg(boolean drop_flg) {

		if (drop_flg) {
			this.drop_flg = 1;
		} else {
			this.drop_flg = 0;
		}
	}

	public void setMetainfo(String metainfo) {
		if(metainfo!=null){
			this.metainfo = metainfo;
		}
	}

	public int getAttribute_value_id() {
		return this.attribute_value_id;
	}

	public int getAttribute_field_id() {
		return this.attribute_field_id;
	}

	public int getAnser_no() {
		return this.anser_no;
	}

	public String getSingle_value() {
		return this.single_value;
	}

	public String getList_value() {
		return this.list_value;
	}

	public String getMap_key() {
		return this.map_key;
	}

	public String getMap_value() {
		return this.map_value;
	}

	public String getRange_upper() {
		return this.range_upper;
	}

	public int getRange_upper_flg() {
		return this.range_upper_flg;
	}

	public String getRange_lower() {
		return this.range_lower;
	}

	public int getRange_lower_flg() {
		return this.range_lower_flg;
	}

	public String getObject_name() {
		return this.object_name;
	}

	public String getObject_info() {
		return this.object_info;
	}

	public int getDrop_flg() {
		return this.drop_flg;
	}

	public String getMetainfo() {
		return this.metainfo;
	}

	public void print(){
		System.out.println("***************TblAttributeValue（属性値）**************");
		System.out.println("attribute_value_id : " + this.attribute_value_id);
		System.out.println("attribute_field_id : " + this.attribute_field_id);
		System.out.println("anser_no           : " + this.anser_no);
		System.out.println("single_value       : " + this.single_value);
		System.out.println("list_value         : " + this.list_value);
		System.out.println("map_key            : " + this.map_key);
		System.out.println("map_value          : " + this.map_value);
		System.out.println("range_upper        : " + this.range_upper);
		System.out.println("range_upper_flg    : " + this.range_upper_flg);
		System.out.println("range_lower        : " + this.range_lower);
		System.out.println("range_lower_flg    : " + this.range_lower_flg);
		System.out.println("object_name        : " + this.object_name);
		System.out.println("object_info        : " + this.object_info);
		System.out.println("drop_flg           : " + this.drop_flg);
		System.out.println("metainfo           : " + this.metainfo);
	}

	public void setRange_upper(String range_upper) {
		this.range_upper = range_upper;
	}

	public void setRange_upper_flg(int range_upper_flg) {
		this.range_upper_flg = range_upper_flg;
	}

	public void setRange_lower(String range_lower) {
		this.range_lower = range_lower;
	}

	public void setRange_lower_flg(int range_lower_flg) {
		this.range_lower_flg = range_lower_flg;
	}

	public void setDrop_flg(int drop_flg) {
		this.drop_flg = drop_flg;
	}

}
