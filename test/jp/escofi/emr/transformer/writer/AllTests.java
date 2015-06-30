package jp.escofi.emr.transformer.writer;

import jp.escofi.emr.transformer.util.MapperUtilTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(XmlWriterCallerTestE001_001.class);
		suite.addTestSuite(XmlWriterCallerTestE001_027.class);
		suite.addTestSuite(XmlWriterCallerTestE001_037.class);
		suite.addTestSuite(XmlWriterCallerTestE001_059.class);
		suite.addTestSuite(XmlWriterCallerTestE001_069.class);
		suite.addTestSuite(XmlWriterCallerTestE001_088.class);
		suite.addTestSuite(XmlWriterCallerTestE001_100.class);
		suite.addTestSuite(XmlWriterCallerTestE001_129.class);
		suite.addTestSuite(XmlWriterCallerTestE001_143.class);
		suite.addTestSuite(XmlWriterCallerTestE001_180.class);
		suite.addTestSuite(XmlWriterCallerTestE001_202.class);
		suite.addTestSuite(XmlWriterCallerTestE002.class);
		suite.addTestSuite(XmlWriterCallerTestN001_001.class);
		suite.addTestSuite(XmlWriterCallerTestN001_053.class);
		suite.addTestSuite(XmlWriterCallerTestN001_153.class);
		suite.addTestSuite(XmlWriterCallerTestN001_253.class);
		suite.addTestSuite(XmlWriterCallerTestN001_353.class);
		suite.addTestSuite(XmlWriterCallerTestN001_454.class);
		suite.addTestSuite(MapperUtilTest.class);
		//$JUnit-END$
		return suite;
	}

}
