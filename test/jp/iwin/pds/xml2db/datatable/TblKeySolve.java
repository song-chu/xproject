package jp.iwin.pds.xml2db.datatable;


/**
 * �L�[���ډ����e�[�u���B
 *
 * @author $Author: park.js $
 */
public final class TblKeySolve {

	/**
	 * �L�[���ډ���ID
	 * �i�V�[�P���X���ځj
	 */
	private int key_solve_id = 0;
	/**
	 * �f�[�^���f��ID
	 */
	private int datamodel_id;
	/**
	 * �C���f�b�N�X
	 */
	private int index;
	/**
	 * �L�[���ړ��{�ꖼ
	 */
	private String key_jp_name = "";
	/**
	 * �L�[���ډp����
	 */
	private String key_en_name;
	/**
	 * �p�����L�[���ډ���ID
	 */
	private int extend_key_solve_id = 0;


	public void setKey_solve_id(int key_solve_id) {
		this.key_solve_id = key_solve_id;
	}

	public void setDatamodel_id(int datamodel_id) {
		this.datamodel_id = datamodel_id;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public void setKey_jp_name(String key_jp_name) {
		this.key_jp_name = key_jp_name;
	}

	public void setKey_en_name(String key_en_name) {
		this.key_en_name = key_en_name;
	}

	public void setExtend_key_solve_id(int extend_key_solve_id) {
		this.extend_key_solve_id = extend_key_solve_id;
	}

	/**
	 * @return key_solve_id
	 */
	public int getKey_solve_id() {
		return this.key_solve_id;
	}

	/**
	 * @return datamodel_id
	 */
	public int getDatamodel_id() {
		return this.datamodel_id;
	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * @return key_jp_name
	 */
	public String getKey_jp_name() {
		return this.key_jp_name;
	}

	/**
	 * @return key_en_name
	 */
	public String getKey_en_name() {
		return this.key_en_name;
	}

	/**
	 * @return extend_key_solve_id
	 */
	public int getExtend_key_solve_id() {
		return this.extend_key_solve_id;
	}

	public void print(){
		System.out.println("***************TblKeySolve�i�L�[���ډ����j***************");
		System.out.println("key_solve_id        : " + this.key_solve_id);
		System.out.println("datamodel_id        : " + this.datamodel_id);
		System.out.println("key_jp_name         : " + this.key_jp_name);
		System.out.println("index               : " + this.index);
		System.out.println("key_en_name         : " + this.key_en_name);
		System.out.println("extend_key_solve_id : " + this.extend_key_solve_id);
	}




}
