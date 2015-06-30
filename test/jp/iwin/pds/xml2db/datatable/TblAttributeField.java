package jp.iwin.pds.xml2db.datatable;


/**
 * 属性項目テーブル。
 *
 * @author $Author: devuser05 $
 */
public final class TblAttributeField {

	/**
	 * 属性項目Id
	 */
	private int attribute_field_id = 0;
	/**
	 * 属性グループID
	 */
	private int attribute_group_id;
	/**
	 * 属性管理ID
	 */
	private int attribute_elem_id;
	/**
	 * FROMキー項目値
	 */
	private String from_key_value = "";
	/**
	 * 条件有無フラグ
	 */
	private int condition_flg = 0;
	/**
	 * 条件XML
	 */
	private String condition_XML = "";
	/**
	 * 案件ID
	 */
	private int product_id = 1;
	/**
	 * 論理削除フラグ
	 */
	private int delete_flg = 0;
	/**
	 * 承認フラグ
	 */
	private int approval_flg = 1;


	public void setAttribute_field_id(int attribute_field_id) {
		this.attribute_field_id = attribute_field_id;
	}

	public void setAttribute_group_id(int attribute_group_id) {
		this.attribute_group_id = attribute_group_id;
	}

	public void setAttribute_elem_id(int attribute_elem_id) {
		this.attribute_elem_id = attribute_elem_id;
	}

	public void setFrom_key_value(String from_key_value) {
		this.from_key_value = from_key_value;
	}

	public void setCondition_flg(boolean condition_flg) {

		if (condition_flg) {
			this.condition_flg = 1;
		} else {
			this.condition_flg = 0;
		}
	}

	public void setCondition_XML(String condition_XML) {
		this.condition_XML = condition_XML;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setDelete_flg(boolean delete_flg) {

		if (delete_flg) {
			this.delete_flg = 1;
		} else {
			this.delete_flg = 0;
		}
	}

	public void setApproval_flg(boolean approval_flg) {

		if (approval_flg) {
			this.approval_flg = 1;
		} else {
			this.approval_flg = 0;
		}
	}

	public int getAttribute_field_id() {
		return this.attribute_field_id;
	}

	public int getAttribute_group_id() {
		return this.attribute_group_id;
	}

	public int getAttribute_elem_id() {
		return this.attribute_elem_id;
	}

	public String getFrom_key_value() {
		return this.from_key_value;
	}

	public int getCondition_flg() {
		return this.condition_flg;
	}

	public String getCondition_XML() {
		return this.condition_XML;
	}

	public int getProduct_id() {
		return this.product_id;
	}

	public int getDelete_flg() {
		return this.delete_flg;
	}

	public int getApproval_flg() {
		return this.approval_flg;
	}

	public void print(){
		System.out.println("**************TblAttributeField（属性項目）*************");
		System.out.println("attribute_field_id : " + this.attribute_field_id);
		System.out.println("attribute_group_id : " + this.attribute_group_id);
		System.out.println("attribute_elem_id  : " + this.attribute_elem_id);
		System.out.println("from_key_value     : " + this.from_key_value);
		System.out.println("condition_flg      : " + this.condition_flg);
		System.out.println("condition_XML      : " + this.condition_XML);
		System.out.println("product_id         : " + this.product_id);
		System.out.println("delete_flg         : " + this.delete_flg);
		System.out.println("approval_flg       : " + this.approval_flg);
	}

	public void setCondition_flg(int condition_flg) {
		this.condition_flg = condition_flg;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

	public void setApproval_flg(int approval_flg) {
		this.approval_flg = approval_flg;
	}

}
