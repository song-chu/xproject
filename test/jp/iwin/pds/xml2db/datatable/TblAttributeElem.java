package jp.iwin.pds.xml2db.datatable;


/**
 * �����Ǘ��e�[�u���B
 *
 * @author $Author: devuser05 $
 */
public final class TblAttributeElem {

	/**
	 * �����Ǘ�ID
	 */
	private int attribute_elem_id = 0;
	/**
	 * �f�[�^���f��ID
	 */
	private int datamodel_id;
	/**
	 * �������ړ��{�ꖼ
	 */
	private String attribute_field_jp_name = "";
	/**
	 * �������ډp����
	 */
	private String attribute_field_en_name;
	/**
	 * �������ڃ^�C�v
	 */
	private String attribute_type_cd ="";
	/**
	 * JAVA�f�[�^�^
	 */
	private String java_class_cd= "";
	/**
	 * �t�H�[���I�u�W�F�N�g�t���O
	 */
	private int form_object_flg = 0;
	/**
	 * �t�H�[��CD
	 */
	private String form_cd = "";
	/**
	 * �t�H�[���P��
	 */
	private String form_unit = "";
	/**
	 * �Č�ID
	 */
	private int product_id = 1;
	/**
	 * �J�e�S��CD
	 */
	private String  category_cd = "";
	/**
	 * �_���폜�t���O
	 */
	private int delete_flg = 0;


	public void setAttribute_elem_id(int attribute_elem_id) {
		this.attribute_elem_id = attribute_elem_id;
	}

	public void setDatamodel_id(int datamodel_id) {
		this.datamodel_id = datamodel_id;
	}

	public void setAttribute_field_jp_name(String attribute_field_jp_name) {
			this.attribute_field_jp_name = attribute_field_jp_name;
	}

	public void setAttribute_field_en_name(String attribute_field_en_name) {
		this.attribute_field_en_name = attribute_field_en_name;
	}

	public void setAttribute_type_cd(String attribute_type_cd) {
		this.attribute_type_cd = attribute_type_cd;
	}

	public void setJava_class_cd(String java_class_cd) {
		this.java_class_cd = java_class_cd;
	}

	public void setForm_object_flg(boolean form_object_flg) {

		if (form_object_flg) {
			this.form_object_flg = 1;
		} else {
			this.form_object_flg = 0;
		}
	}

	public void setForm_cd(String form_cd) {
		this.form_cd = form_cd;
	}

	public void setForm_unit(String form_unit) {
		this.form_unit = form_unit;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setCategory_cd(String category_cd) {
		this.category_cd = category_cd;
	}

	public void setDelete_flg(boolean delete_flg) {

		if (delete_flg) {
			this.delete_flg = 1;
		} else {
			this.delete_flg = 0;
		}
	}

	public int getAttribute_elem_id() {
		return this.attribute_elem_id;
	}

	public int getDatamodel_id() {
		return this.datamodel_id;
	}

	public String getAttribute_field_jp_name() {
		return this.attribute_field_jp_name;
	}

	public String getAttribute_field_en_name() {
		return this.attribute_field_en_name;
	}

	public String getAttribute_type_cd() {
		return this.attribute_type_cd;
	}

	public String getJava_class_cd() {
		return this.java_class_cd;
	}

	public int getForm_object_flg() {
		return this.form_object_flg;
	}

	public String getForm_cd() {
		return this.form_cd;
	}

	public String getForm_unit() {
		return this.form_unit;
	}

	public int getProduct_id() {
		return this.product_id;
	}

	public String getCategory_cd() {
		return this.category_cd;
	}

	public int getDelete_flg() {
		return this.delete_flg;
	}

	public void print(){
		System.out.println("**************TblAttributeElem�i�����Ǘ��j**************");
		System.out.println("attribute_elem_id       : " + this.attribute_elem_id);
		System.out.println("datamodel_id            : " + this.datamodel_id);
		System.out.println("attribute_field_jp_name : " + this.attribute_field_jp_name);
		System.out.println("attribute_field_en_name : " + this.attribute_field_en_name);
		System.out.println("attribute_type_cd       : " + this.attribute_type_cd);
		System.out.println("java_class_cd           : " + this.java_class_cd);
		System.out.println("product_id              : " + this.product_id);
		System.out.println("category_cd             : " + this.category_cd);
		System.out.println("delete_flg              : " + this.delete_flg);
	}

	public void setForm_object_flg(int form_object_flg) {
		this.form_object_flg = form_object_flg;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

}
