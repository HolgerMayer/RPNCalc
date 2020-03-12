package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RPNEngineTests {

	static final double TOLERANCE =  0.0001;
	
	RPNEngine testObject;
	
	@BeforeEach
	public void setUp() throws Exception {
		testObject = new RPNEngine();
	}

	@AfterEach
	public void tearDown() throws Exception {
		testObject = null;
	}

	@Test
	public void testInitialize() {
		assertEquals(TrigonometricMode.RAD, testObject.trigonometricMode);
	}

	@Test
	public void testPush() {
		testObject.push(10);
		
		assertEquals(10,testObject.getTop(), TOLERANCE);
	}
	
	@Test
	public void testPop() {
		testObject.push(11);
		
		assertEquals(11,testObject.pop(), TOLERANCE);
	}
	
	
	@ParameterizedTest(name = "#{index}: {0} + {1} = {2}")
	@CsvSource({
	    "10,  11,  21",
	    " 0,  11,  11,",
	    "-5,   5,   0",
	})
	public void testAdd(int a, int b, int expected) {
		testObject.push(a);
		testObject.push(b);
		
		testObject.add();
		
		assertEquals(expected,testObject.getTop(),TOLERANCE);
		assertEquals(b,testObject.getLastX(),TOLERANCE);
	}
	
	
	@Test
	public void testAdd1StackItem() {
		testObject.push(11);
		
		testObject.add();
		
		assertEquals(11,testObject.getTop(),TOLERANCE);
		assertEquals(11,testObject.getLastX(),TOLERANCE);
	}

	@Test
	public void testAdd0STackItem() {
		
		testObject.add();
		
		assertEquals(0,testObject.getTop(),TOLERANCE);
		assertEquals(0,testObject.getLastX(),TOLERANCE);
	}

	@Test
	public void testSubtract() {
		testObject.push(1);
		testObject.push(2);
		
		testObject.subtract();
		
		assertEquals(-1.0,testObject.getTop(),TOLERANCE);
		assertEquals(2,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testMultiply() {
		testObject.push(3);
		testObject.push(2);
		
		testObject.multiply();
		
		assertEquals(6,testObject.getTop(),TOLERANCE);
		assertEquals(2,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testMultiply1StackItem() {
		testObject.push(2);
		
		testObject.multiply();
		
		assertEquals(0,testObject.getTop(),TOLERANCE);
		assertEquals(2,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testDivide() {
		testObject.push(6);
		testObject.push(2);
		
		testObject.divide();
		
		assertEquals(3,testObject.getTop(),TOLERANCE);
		assertEquals(2,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testDivideBy0() {
		testObject.push(6);
		testObject.push(0);
		
   	    Executable when = () -> testObject.divide();

   	    assertThrows(DivideByZeroException.class ,when);

		}
	
	@Test
	public void testAbsPositive() {
		testObject.push(6);
		
		testObject.abs();
		
		assertEquals(6,testObject.getTop(),TOLERANCE);
		assertEquals(6,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testAbsNegative() {
		testObject.push(-3);
		
		testObject.abs();
		
		assertEquals(3,testObject.getTop(),TOLERANCE);
		assertEquals(-3,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testPowBaseZero() {
		testObject.push(0);
		testObject.push(6);
		
		testObject.pow();
		
		assertEquals(0,testObject.getTop(),TOLERANCE);
		assertEquals(6,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testPowExponentZero() {
		testObject.push(6);
		testObject.push(0);
		
		testObject.pow();
		
		assertEquals(1,testObject.getTop(),TOLERANCE);
		assertEquals(0,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testPow() {
		testObject.push(2);
		testObject.push(5);
		
		testObject.pow();
		
		assertEquals(32,testObject.getTop(),TOLERANCE);
		assertEquals(5,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testSqrtFromZero() {
		testObject.push(0);
		
		testObject.sqrt();
		
		assertEquals(0,testObject.getTop(),TOLERANCE);
		assertEquals(0,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testSqrtFromFour() {
		testObject.push(4);
		
		testObject.sqrt();
		
		assertEquals(2,testObject.getTop(),TOLERANCE);
		assertEquals(4,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testSqrtFromNine() {
		testObject.push(9);
		
		testObject.sqrt();
		
		assertEquals(3,testObject.getTop(),TOLERANCE);
		assertEquals(9,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testSqrtFromNegativeNumber() {
		testObject.push(-6);
		
	    Executable when = () -> testObject.sqrt();

	    assertThrows(SquareRootFromNegativeNumberException.class ,when);

	}
	

	@Test
	public void testLog() throws LogFromZeroException {
		testObject.push(2.7183);
		
   	 	testObject.log();

   	 	assertEquals(1,testObject.getTop(),TOLERANCE);
		assertEquals(2.7183,testObject.getLastX(),TOLERANCE);
	}

	@Test
	public void testLogFromZero() {
		testObject.push(0);
		
 	    Executable when = () -> testObject.log();

	    assertThrows(LogFromZeroException.class ,when);
	}
	
	@Test
	public void testLog10() throws Log10FromZeroException {
		testObject.push(100);

		testObject.log10();

		assertEquals(2,testObject.getTop(),TOLERANCE);
		assertEquals(100,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testLog10FromZero() {
		testObject.push(0);
		
	    Executable when = () -> testObject.log10();

	    assertThrows(Log10FromZeroException.class ,when);
	}
	
	@Test
	public void testhmmsToDecDegree() {
		testObject.push(1.2345);

		testObject.hmmssToDecDegreeConversion();

		assertTrue(testObject.getTop() - 1.1404 <= 0.0001);
	}
	
	@Test
	public void testDecDegreeToHMMSS() {
		testObject.push(1.1404);

		testObject.decDegreeToHMMSSConversion();

		assertTrue(testObject.getTop() - 1.2345 <= 0.0001);
	}
	
	@Test
	public void testPolarConversion() {
		testObject.trigonometricMode = TrigonometricMode.DEG;
		testObject.push(5);
		testObject.push(10);
		
		testObject.polarConversion();

		double rValue = testObject.pop();
		double angle = testObject.pop();
		
		assertEquals(11.1803,rValue,TOLERANCE);
		assertEquals(26.5651,angle,TOLERANCE);
		assertEquals(10,testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testRectangularConversion() {
		testObject.trigonometricMode = TrigonometricMode.DEG;
		testObject.push(30);
		testObject.push(12);
		
		testObject.rectangularConversion();
		
		double xValue = testObject.pop();
		double yValue = testObject.pop();
		
		assertTrue(xValue - 10.3923 <= 0.0001);
		assertTrue(yValue - 6.0 <= 0.0001);
		assertTrue(testObject.getLastX() == 12);
		assertEquals(10.3923,xValue,TOLERANCE);
		assertEquals(6,yValue,TOLERANCE);
		assertEquals(12,testObject.getLastX(),TOLERANCE);
	}
	
	
	
	
}
