package jp.iwin.pds.xml2db.datatable;

/**
 * �Č��Ǘ��e�[�u���B
 *
 * @author $Author: devuser05 $
 */
public final class TblProduct implements Cloneable {

	/**
	 * �Č�ID
	 */
	private int product_id = 0;
	/**
	 * �Č�CD
	 */
	private String product_cd;
	/**
	 * ���CD
	 */
	private String corporate_cd;
	/**
	 * �Č�����
	 */
	private String product_name;
	/**
	 * �{�ԓ�
	 */
	private String release_date;
	/**
	 * �����t���O
	 */
	private int commit_flg = 0;
	/**
	 * �폜�t���O
	 */
	private int delete_flg = 0;


	/**
	 * �R���X�g���N�^�B
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
	 * OR�}�b�p�[�psetter
	 * @param delete_flg �폜�t���O
	 */
	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

	/**
	 * �R�[�h�����psetter
	 * @param delete_flg �폜�t���O
	 */
	public void setDelete_flg(boolean delete_flg) {

		if (delete_flg) {
			this.delete_flg = 1;
		} else {
			this.delete_flg = 0;
		}
	}

	/**
	 * clone���\�b�h�B
	 * <P>
	 * ���̃I�u�W�F�N�g�̓��e���R�s�[�����V�K�C���X�^���X��Ԃ��B
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
