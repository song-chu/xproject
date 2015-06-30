package jp.iwin.pds.xml2db.engine;

import java.util.Properties;

import jp.iwin.pds.xml2db.common.constant.PCTMessageCode;
import jp.iwin.pds.xml2db.common.exception.PEXException;
import jp.iwin.pds.xml2db.common.exception.PEXInitializeException;
import jp.iwin.pds.xml2db.common.util.PUTMessageUtil;
import jp.iwin.pds.xml2db.common.util.PUTPropertyUtil;
import jp.iwin.pds.xml2db.common.util.SqlSessionUtil;
import jp.iwin.pds.xml2db.initialload.PILInitialLoader;
import jp.iwin.pds.xml2db.initialload.handler.PCHKeyItemHandler;
import jp.iwin.pds.xml2db.initialload.handler.factory.PCHKeyItemHandlerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 解析エンジンクラス。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>
 *    <UL>
 *     <LI>オンメモリ化されたデータモデルを保持し、検索や条件判定を行うエンジン本体クラス。
 *     <LI>PDSオブジェクトとPDSオブジェクトキー項目は他クラスからのアクセスを制限するため、解析エンジンのメンバー変数として保持する。
 *     <LI>１回ロードされると使いまわせることやリソースの節約を考慮し、
 *         解析エンジンのインスタンスは、システム上１つのみ、イニシャルロードの際に生成する。（Singleton）
 *    </UL>
 *  <DT>最終開発リビジョン：
 *    <DD>$Revision: 1606 $
 *  <DT>最終開発日時：
 *   <DD>$Date: 2010-12-14 16:05:19 +0900 (轣ｫ, 14 12 2010) $
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/12/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @see jp.iwin.pds.engine.PENServiceAPI
 * @see jp.iwin.pds.initialload.PILInitialLoader
 * @see jp.iwin.pds.dumptool.PDMObjectWriter
 * @version 1.0
 * @since 1.0
 * @author $Author: song.ck $
 */
public class PENEngine {

	/**
	 * ログ出力
	 */
	private static final Log logger = LogFactory.getLog(PENEngine.class);


	/**
	 * イニシャルロード済みフラグ：true（ロード済み）、false（未ロード）<br>
	 * 	<DL>
	 *  <DT style='color: red'>注意事項：
	 *   <DD style='color: red; font-weight: bold'>
	 *    true（ロード済み）を設定するのは解析エンジンのみである。
	 * </DL>
	 *
	 */
	private static boolean isLoaded = false;

	public static void excuteXML2DB() throws PEXInitializeException {
//		if (instance == null) {
			new PENEngine();
//		}
//		return instance;
	}

	public static void excuteXML2DB(Properties props) throws PEXInitializeException {
			new PENEngine(props);
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *	<DT>使用目的/機能概要：
	 *	 <DD>他クラスからのコンストラクタの生成を防ぐため、デフォルトコンストラクタをprivateにする。
	 * </DL>
	 * @throws PEXInitializeException	イニシャルロード例外
	 */
	private PENEngine() throws PEXInitializeException {
		init();
	}

	/**
	 * コンストラクタ。
	 * <DL>
	 *	<DT>使用目的/機能概要：
	 *	 <DD>他クラスからのコンストラクタの生成を防ぐため、デフォルトコンストラクタをprivateにする。
	 * </DL>
	 * @throws PEXInitializeException	イニシャルロード例外
	 */
	private PENEngine(Properties props) throws PEXInitializeException {
		init(props);
	}

	/**
	 * 初期処理。
	 * <DL>
	 *	<DT>使用目的/機能概要：
	 *	 <DD>
	 *    <UL>
	 *     <LI>イニシャルロードを行い、PDSオブジェクト、PDSオブジェクトキー項目にその結果を設定する。
	 *     <LI>コンストラクタから呼出される。
	 *    </UL>
	 *  <DT style='color: red'>注意事項：
	 *   <DD style='color: red; font-weight: bold'>
	 *    イニシャルロード後、イニシャルロード済みフラグをtrueに設定する。
	 * </DL>
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 * @see jp.iwin.pds.common.exception.PEXInitializeException
	 * @throws PEXInitializeException イニシャルロード例外。<br>
	 *         例外発生時にはアラート通知を行う。システムとして回復不能な例外であるため、RuntimeExceptionとして作成する。
	 */
	private void init() throws PEXInitializeException {

		try {
			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P012I.toString()));
			 SqlSessionUtil.getSqlSession();
			 SqlSessionUtil.deleteAll();

			 new PILInitialLoader();

			 isLoaded = true;

			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P013I.toString()));

		} catch (PEXException e) {
			if (e.getCause() == null) {
				// 原因例外のトレース情報を出力
				throw new PEXInitializeException(PCTMessageCode.P009E, e);
			} else {
				// 原因例外のトレース情報は出力済みなので、エラーメッセージのみ
				throw new PEXInitializeException(PCTMessageCode.P009E);
			}
		} catch (Exception e) {
			// 原因例外のトレース情報を出力
			throw new PEXInitializeException(PCTMessageCode.P009E, e);
		}finally{
			 SqlSessionUtil.closeSqlSession();
		}
	}

	/**
	 * 初期処理。
	 * <DL>
	 *	<DT>使用目的/機能概要：
	 *	 <DD>
	 *    <UL>
	 *     <LI>イニシャルロードを行い、PDSオブジェクト、PDSオブジェクトキー項目にその結果を設定する。
	 *     <LI>コンストラクタから呼出される。
	 *    </UL>
	 *  <DT style='color: red'>注意事項：
	 *   <DD style='color: red; font-weight: bold'>
	 *    イニシャルロード後、イニシャルロード済みフラグをtrueに設定する。
	 * </DL>
	 * @see jp.iwin.pds.initialload.PILInitialLoader
	 * @see jp.iwin.pds.common.exception.PEXInitializeException
	 * @param props DB接続情報
	 * @throws PEXInitializeException イニシャルロード例外。<br>
	 *         例外発生時にはアラート通知を行う。システムとして回復不能な例外であるため、RuntimeExceptionとして作成する。
	 */
	private void init(Properties props) throws PEXInitializeException {

		try {
			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P012I.toString()));
			 SqlSessionUtil.getSqlSession(props);
			if(Boolean.valueOf(PUTPropertyUtil.getProperty("DBDeleteFlg"))){
				 SqlSessionUtil.deleteAll();
				 PCHKeyItemHandler.anser_no=0;
				 PCHKeyItemHandler.args_elem_id=0;
				 PCHKeyItemHandler.attribute_value_id=0;
				 PCHKeyItemHandler.attribute_group_id=0;
				 PCHKeyItemHandler.attribute_field_id=0;
				 PCHKeyItemHandler.attribute_elem_id=0;
				 PCHKeyItemHandlerFactory.datamodel_id=0;
				 PCHKeyItemHandlerFactory.key_solve_id=0;

			}
			 new PILInitialLoader();

			 isLoaded = true;

			 logger.info(PUTMessageUtil.getMessage(PCTMessageCode.P013I.toString()));

		} catch (PEXException e) {
			if (e.getCause() == null) {
				// 原因例外のトレース情報を出力
				throw new PEXInitializeException(PCTMessageCode.P009E, e);
			} else {
				// 原因例外のトレース情報は出力済みなので、エラーメッセージのみ
				throw new PEXInitializeException(PCTMessageCode.P009E);
			}
		} catch (Exception e) {
			// 原因例外のトレース情報を出力
			throw new PEXInitializeException(PCTMessageCode.P009E, e);
		}finally{
			 SqlSessionUtil.closeSqlSession();
		}
	}

	/**
	 * イニシャルロード済みフラグの取得処理
	 * <DL>
	 *	<DT>使用目的/機能概要：
	 *	 <DD>
	 *    <UL>
	 *     <LI>イニシャルロード済みフラグを返却する。
	 *    </UL>
	 * </DL>
	 * @throws true イニシャルロード済み、false イニシャルロード未実施
	 */
	protected static boolean isLoaded() {
		return isLoaded;
	}

}
