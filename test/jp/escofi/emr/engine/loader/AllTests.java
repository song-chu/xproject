package jp.escofi.emr.engine.loader;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(InitialLoaderTest.class);
		suite.addTestSuite(InitialLoader2Test.class);
		suite.addTestSuite(InitialLoader3Test.class);
		suite.addTestSuite(InitialLoader4Test.class);
		suite.addTestSuite(InitialLoader5Test.class);
		//$JUnit-END$
		return suite;
	}

}
