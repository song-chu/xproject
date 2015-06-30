package jp.iwin.pds.xml2db.datatable;

/**
 * 案件管理テーブル。
 *
 * @author $Author: devuser05 $
 */
public final class TblProduct implements Cloneable {

	/**
	 * 案件ID
	 */
	private int product_id = 0;
	/**
	 * 案件CD
	 */
	private String product_cd;
	/**
	 * 企業CD
	 */
	private String corporate_cd;
	/**
	 * 案件名称
	 */
	private String product_name;
	/**
	 * 本番日
	 */
	private String release_date;
	/**
	 * 凍結フラグ
	 */
	private int commit_flg = 0;
	/**
	 * 削除フラグ
	 */
	private int delete_flg = 0;


	/**
	 * コンストラクタ。
	 */
	public TblProduct() {
		super();
	}


	public int getProduct_id() {
		return this.product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_cd() {
		return this.product_cd;
	}

	public void setProduct_cd(String product_cd) {
		this.product_cd = product_cd;
	}

	public String getCorporate_cd() {
		return this.corporate_cd;
	}

	public void setCorporate_cd(String corporate_cd) {
		this.corporate_cd = corporate_cd;
	}

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getRelease_date() {
		return this.release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public int getCommit_flg() {
		return this.commit_flg;
	}

	public void setCommit_flg(int commit_flg) {
		this.commit_flg = commit_flg;
	}

	public int getDelete_flg() {
		return this.delete_flg;
	}

	/**
	 * ORマッパー用setter
	 * @param delete_flg 削除フラグ
	 */
	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

	/**
	 * コード処理用setter
	 * @param delete_flg 削除フラグ
	 */
	public void setDelete_flg(boolean delete_flg) {

		if (delete_flg) {
			this.delete_flg = 1;
		} else {
			this.delete_flg = 0;
		}
	}

	/**
	 * cloneメソッド。
	 * <P>
	 * このオブジェクトの内容をコピーした新規インスタンスを返す。
	 * </P>
	 */
	@Override
	public TblProduct clone() {
		TblProduct ret = new TblProduct();

		ret.product_id = this.product_id;
		ret.product_cd = this.product_cd;
		ret.corporate_cd = this.corporate_cd;
		ret.product_name = this.product_name;
		ret.release_date = this.release_date;
		ret.commit_flg = this.commit_flg;
		ret.delete_flg = this.delete_flg;

		return ret;
	}

}
