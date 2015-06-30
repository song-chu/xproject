package jp.iwin.pds.xml2db.datatable;



/**
 * 属性グループテーブル。
 *
 * @author $Author: devuser05 $
 */
public final class TblAttributeGroup {

	/**
	 * 属性グループID
	 */
	private int attribute_group_id = 0;
	/**
	 * 属性グループ日本語名
	 */
	private String attribute_group_jp_name = "";
	/**
	 * データモデルID
	 */
	private int datamodel_id;
	/**
	 * キー項目値１
	 */
	private String key1 = "";
	/**
	 * キー項目値2
	 */
	private String key2 = "";
	/**
	 * キー項目値3
	 */
	private String key3 = "";
	/**
	 * キー項目値4
	 */
	private String key4 = "";
	/**
	 * キー項目値5
	 */
	private String key5 = "";
	/**
	 * キー項目値6
	 */
	private String key6 = "";
	/**
	 * キー項目値7
	 */
	private String key7 = "";
	/**
	 * キー項目値8
	 */
	private String key8 = "";
	/**
	 * キー項目値9
	 */
	private String key9 = "";
	/**
	 * キー項目値１0
	 */
	private String key10 = "";
	/**
	 * 継承元属性グループID
	 */
	private int extend_attribute_group_id = 0;
	/**
	 * 案件ID
	 */
	private int product_id = 1;
	/**
	 * 論理削除フラグ
	 */
	private int delete_flg = 0;


	public void setAttribute_group_id(int attribute_group_id) {
		this.attribute_group_id = attribute_group_id;
	}

	public void setAttribute_group_jp_name(String attribute_group_jp_name) {
		this.attribute_group_jp_name = attribute_group_jp_name;
	}

	public void setDatamodel_id(int datamodel_id) {
		this.datamodel_id = datamodel_id;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public void setKey4(String key4) {
		this.key4 = key4;
	}

	public void setKey5(String key5) {
		this.key5 = key5;
	}

	public void setKey6(String key6) {
		this.key6 = key6;
	}

	public void setKey7(String key7) {
		this.key7 = key7;
	}

	public void setKey8(String key8) {
		this.key8 = key8;
	}

	public void setKey9(String key9) {
		this.key9 = key9;
	}

	public void setKey10(String key10) {
		this.key10 = key10;
	}

	public void setExtend_attribute_group_id(int extend_attribute_group_id) {
		this.extend_attribute_group_id = extend_attribute_group_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

	public void setDelete_flg(boolean delete_flg) {

		if (delete_flg) {
			this.delete_flg = 1;
		} else {
			this.delete_flg = 0;
		}
	}

	/**
	 * @return attribute_group_id
	 */
	public int getAttribute_group_id() {
		return this.attribute_group_id;
	}

	/**
	 * @return attribute_group_jp_name
	 */
	public String getAttribute_group_jp_name() {
		return this.attribute_group_jp_name;
	}

	/**
	 * @return datamodel_id
	 */
	public int getDatamodel_id() {
		return this.datamodel_id;
	}

	/**
	 * @return key1
	 */
	public String getKey1() {
		return this.key1;
	}

	/**
	 * @return key2
	 */
	public String getKey2() {
		return this.key2;
	}

	/**
	 * @return key3
	 */
	public String getKey3() {
		return this.key3;
	}

	/**
	 * @return key4
	 */
	public String getKey4() {
		return this.key4;
	}

	/**
	 * @return key5
	 */
	public String getKey5() {
		return this.key5;
	}

	/**
	 * @return key6
	 */
	public String getKey6() {
		return this.key6;
	}

	/**
	 * @return key7
	 */
	public String getKey7() {
		return this.key7;
	}

	/**
	 * @return key8
	 */
	public String getKey8() {
		return this.key8;
	}

	/**
	 * @return key9
	 */
	public String getKey9() {
		return this.key9;
	}

	/**
	 * @return key10
	 */
	public String getKey10() {
		return this.key10;
	}

	/**
	 * @return extend_attribute_group_id
	 */
	public int getExtend_attribute_group_id() {
		return this.extend_attribute_group_id;
	}

	/**
	 * @return product_id
	 */
	public int getProduct_id() {
		return this.product_id;
	}

	/**
	 * @return delete_flg
	 */
	public int getDelete_flg() {
		return this.delete_flg;
	}

	public void print(){
		System.out.println("*************TblAttributeGroup（属性グループ）************");
		System.out.println("attribute_group_id          : " + this.attribute_group_id);
		System.out.println("attribute_group_jp_name     : " + this.attribute_group_jp_name);
		System.out.println("datamodel_id                : " + this.datamodel_id);
		System.out.println("key1                        : " + this.key1);
		System.out.println("key2                        : " + this.key2);
		System.out.println("key3                        : " + this.key3);
		System.out.println("key4                        : " + this.key4);
		System.out.println("key5                        : " + this.key5);
		System.out.println("key6                        : " + this.key6);
		System.out.println("key7                        : " + this.key7);
		System.out.println("key8                        : " + this.key8);
		System.out.println("key9                        : " + this.key9);
		System.out.println("key10                       : " + this.key10);
		System.out.println("extend_attribute_group_id   : " + this.extend_attribute_group_id);
		System.out.println("product_id                  : " + this.product_id);
		System.out.println("delete_flg                  : " + this.delete_flg);

	}




}
