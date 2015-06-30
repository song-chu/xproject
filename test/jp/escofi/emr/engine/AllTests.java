package jp.escofi.emr.engine;

import jp.escofi.emr.engine.common.util.ConvertUtilTest;
import jp.escofi.emr.engine.common.util.MessageUtilTest;
import jp.escofi.emr.engine.common.util.PropertyUtilTest;
import jp.escofi.emr.engine.loader.InitialLoader2Test;
import jp.escofi.emr.engine.loader.InitialLoader3Test;
import jp.escofi.emr.engine.loader.InitialLoader4Test;
import jp.escofi.emr.engine.loader.InitialLoader5Test;
import jp.escofi.emr.engine.loader.InitialLoaderTest;
import jp.escofi.emr.engine.search.PDSDumpServiceAPITest;
import jp.escofi.emr.engine.search.PDSServiceAPITest6;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(PDSServiceAPITest.class);
		suite.addTestSuite(PDSServiceAPITest2.class);
		suite.addTestSuite(PDSServiceAPITest3.class);
		suite.addTestSuite(PDSServiceAPITest4.class);
		suite.addTestSuite(PDSServiceAPITest5.class);
		suite.addTestSuite(PDSServiceAPITest6.class);
		suite.addTestSuite(InitialLoaderTest.class);
		suite.addTestSuite(InitialLoader2Test.class);
		suite.addTestSuite(InitialLoader3Test.class);
		suite.addTestSuite(InitialLoader4Test.class);
		suite.addTestSuite(InitialLoader5Test.class);
		suite.addTestSuite(PDSDumpServiceAPITest.class);
		suite.addTestSuite(ConvertUtilTest.class);
		suite.addTestSuite(MessageUtilTest.class);
		suite.addTestSuite(PropertyUtilTest.class);
		//$JUnit-END$
		return suite;
	}

}
