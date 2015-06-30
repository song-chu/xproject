package jp.iwin.pds.xml2db.datatable;

import java.util.List;


/**
 * 引数管理テーブル。
 *
 * @author $Author: devuser05 $
 */
public final class TblArgsElem {

	/**
	 * 引数管理ID
	 */
	private int args_elem_id = 0;
	/**
	 * データモデルID
	 */
	private int datamodel_id = 0;
	/**
	 * 引数項目日本語名称
	 */
	private String args_field_jp_name = "";
	/**
	 * 引数項目英字名称
	 */
	private String args_field_en_name = "";
	/**
	 * 属性タイプCD
	 */
	private String attribute_type_cd = "";
	/**
	 * JAVAデータ型
	 */
	private String java_class_cd;
	/**
	 * フォームオブジェクトフラグ
	 */
	private int form_object_flg = 0;
	/**
	 * フォームCD
	 */
	private String form_cd = "";
	/**
	 * フォーム単位
	 */
	private String form_unit = "";
	/**
	 * 引数項目情報
	 */
	private String arg_info = "";
	/**
	 * 案件ID
	 */
	private int product_id = 1;
	/**
	 * 論理削除フラグ
	 */
	private int delete_flg = 0;


	public int getArgs_elem_id() {
		return this.args_elem_id;
	}
	public void setArgs_elem_id(int args_elem_id) {
		this.args_elem_id = args_elem_id;
	}
	public int getDatamodel_id() {
		return this.datamodel_id;
	}
	public void setDatamodel_id(int datamodel_id) {
		this.datamodel_id = datamodel_id;
	}
	public String getArgs_field_jp_name() {
		return this.args_field_jp_name;
	}
	public void setArgs_field_jp_name(String args_field_jp_name) {
		if(args_field_jp_name!=null){
			this.args_field_jp_name = args_field_jp_name;
		}
	}
	public String getArgs_field_en_name() {
		return this.args_field_en_name;
	}
	public void setArgs_field_en_name(String args_field_en_name) {
		this.args_field_en_name = args_field_en_name;
	}
	public String getAttribute_type_cd() {
		return this.attribute_type_cd;
	}
	public void setAttribute_type_cd(String attribute_type_cd) {
		this.attribute_type_cd = attribute_type_cd;
	}
	public String getJava_class_cd() {
		return this.java_class_cd;
	}
	public void setJava_class_cd(String java_class_cd) {
		this.java_class_cd = java_class_cd;
	}
	public int getForm_object_flg() {
		return this.form_object_flg;
	}
	public void setForm_object_flg(boolean form_object_flg) {

		if (form_object_flg) {
			this.form_object_flg = 1;
		} else {
			this.form_object_flg = 0;
		}
	}
	public String getForm_cd() {
		return this.form_cd;
	}
	public void setForm_cd(String form_cd) {
		this.form_cd = form_cd;
	}
	public String getForm_unit() {
		return this.form_unit;
	}
	public void setForm_unit(String form_unit) {
		this.form_unit = form_unit;
	}
	public String getArg_info() {
		return this.arg_info;
	}
	public void setArg_info(List<String> list) {
		StringBuilder buffer = new StringBuilder();
		int i = 0;
		buffer.append(list.get(0));
		while(i <list.size()-1){
			i++;
			buffer.append(",");
			buffer.append(list.get(i));
		}
		this.arg_info = buffer.toString();
	}
	public int getProduct_id() {
		return this.product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDelete_flg() {
		return this.delete_flg;
	}
	public void setDelete_flg(boolean delete_flg) {

		if (delete_flg) {
			this.delete_flg = 1;
		} else {
			this.delete_flg = 0;
		}
	}
	public void print(){
		System.out.println("**************TblArgsElem（引数項目）**************");
		System.out.println("args_elem_id       : " + this.args_elem_id);
		System.out.println("datamodel_id       : " + this.datamodel_id);
		System.out.println("args_field_jp_name : " + this.args_field_jp_name);
		System.out.println("args_field_en_name : " + this.args_field_en_name);
		System.out.println("attribute_type_cd  : " + this.attribute_type_cd);
		System.out.println("java_class_cd      : " + this.java_class_cd);
		System.out.println("arg_info           : " + this.arg_info);

	}
	public void setForm_object_flg(int form_object_flg) {
		this.form_object_flg = form_object_flg;
	}
	public void setArg_info(String arg_info) {
		this.arg_info = arg_info;
	}
	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}
}
