package jp.escofi.emr.transformer.sql;

import java.util.Arrays;
import java.util.List;

import jp.escofi.emr.transformer.writer.KeyitemWriter;


/**
 * 属性グループ情報マッパー。
 * <DL>
 *  <DT>使用目的/機能概要：
 *   <DD>取得したキー項目情報付き属性グループ情報を格納するクラス。
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/08/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public final class AttributeGroupMapper {

	/**
	 * 属性グループID
	 */
	private int attGroupID;

	/**
	 * キー項目ライター配列
	 */
	private KeyitemWriter[] keyItems = new KeyitemWriter[10];


	/**
	 * コンストラクタ。
	 * <P>
	 * キー項目ライター配列を初期化する。
	 * </P>
	 */
	public AttributeGroupMapper() {

		for (int i = 0; i < keyItems.length; i++) {
			keyItems[i] = new KeyitemWriter();
		}
	}

	/**
	 * @return 属性グループID
	 */
	public int getAttGroupID() {
		return attGroupID;
	}

	/**
	 * @return キー項目ライターリスト
	 */
	public List<KeyitemWriter> getKeyItemList() {
		return Arrays.asList(keyItems);
	}

	/**
	 * @param attGroupID 属性グループID
	 */
	public void setAttGroupID(int attGroupID) {
		this.attGroupID = attGroupID;
	}

	/**
	 * @param key01Name キー項目01の英字名
	 */
	public void setKey01Name(String key01Name) {
		keyItems[0].setName(key01Name);
	}

	/**
	 * @param key02Name キー項目02の英字名
	 */
	public void setKey02Name(String key02Name) {
		keyItems[1].setName(key02Name);
	}

	/**
	 * @param key03Name キー項目03の英字名
	 */
	public void setKey03Name(String key03Name) {
		keyItems[2].setName(key03Name);
	}

	/**
	 * @param key04Name キー項目04の英字名
	 */
	public void setKey04Name(String key04Name) {
		keyItems[3].setName(key04Name);
	}

	/**
	 * @param key05Name キー項目05の英字名
	 */
	public void setKey05Name(String key05Name) {
		keyItems[4].setName(key05Name);
	}

	/**
	 * @param key06Name キー項目06の英字名
	 */
	public void setKey06Name(String key06Name) {
		keyItems[5].setName(key06Name);
	}

	/**
	 * @param key07Name キー項目07の英字名
	 */
	public void setKey07Name(String key07Name) {
		keyItems[6].setName(key07Name);
	}

	/**
	 * @param key08Name キー項目08の英字名
	 */
	public void setKey08Name(String key08Name) {
		keyItems[7].setName(key08Name);
	}

	/**
	 * @param key09Name キー項目09の英字名
	 */
	public void setKey09Name(String key09Name) {
		keyItems[8].setName(key09Name);
	}

	/**
	 * @param key10Name キー項目10の英字名
	 */
	public void setKey10Name(String key10Name) {
		keyItems[9].setName(key10Name);
	}

}
