package jp.escofi.emr;

import java.math.BigDecimal;

/**
 *
 * @author song.ck
 *
 */
public class BigDecimalEx extends BigDecimal {

	/**
	 *
	 */
	private static final long serialVersionUID = 4606284192877147424L;

	/**
	 * @param val �R���X�g���N�^����
	 */
	public BigDecimalEx(String val) {
		super(val);
	}

	/**
	 * @param val	�R���X�g���N�^����
	 */
	public BigDecimalEx(BigDecimal val) {
		super(val.toString());
	}
}
