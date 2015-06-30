package jp.iwin.pds.xml2db.engine;

import jp.iwin.pds.xml2db.common.exception.PEXInitializeException;



public class PDSTestXML2DB{

	public static void main(String[] args){

		try {
			PENEngine.excuteXML2DB();
		} catch (PEXInitializeException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}
}

