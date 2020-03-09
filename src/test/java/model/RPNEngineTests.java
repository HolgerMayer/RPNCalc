package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RPNEngineTests {

	RPNEngine testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new RPNEngine();
	}

	@After
	public void tearDown() throws Exception {
		testObject = null;
	}

	@Test
	public void testInitialize() {
		assertNotNull(testObject.stack);
	}

	@Test
	public void testPush() {
		testObject.push(10);
		
		assertTrue(testObject.top() == 10);
	}
	
	@Test
	public void testPop() {
		testObject.push(11);
		
		assertTrue(testObject.pop() == 11);
	}
	
	@Test
	public void testAdd() {
		testObject.push(10);
		testObject.push(11);
		
		testObject.add();
		
		assertTrue(testObject.top() == 21);
	}
	
	@Test
	public void testAdd1StackItem() {
		testObject.push(11);
		
		testObject.add();
		
		assertTrue(testObject.top() == 11);
	}

	@Test
	public void testAdd0STackItem() {
		
		testObject.add();
		
		assertTrue(testObject.top() == 0);
	}

	@Test
	public void testSubtract() {
		testObject.push(1);
		testObject.push(2);
		
		testObject.subtract();
		
		assertTrue(testObject.top() == -1.0);
	}
	
	@Test
	public void testMultiply() {
		testObject.push(3);
		testObject.push(2);
		
		testObject.multiply();
		
		assertTrue(testObject.top() == 6);
	}
	
	@Test
	public void testMultiply1StackItem() {
		testObject.push(2);
		
		testObject.multiply();
		
		assertTrue(testObject.top() == 0);
	}
	
	@Test
	public void testDivide() {
		testObject.push(6);
		testObject.push(2);
		
		testObject.divide();
		
		assertTrue(testObject.top() == 3);
	}
	
	@Test
	public void testDivideBy0() {
		testObject.push(6);
		testObject.push(0);
		
	     try {
	    	 testObject.divide();

	    	 fail("Should have thrown a DivdeByZeroException");
	     } catch (DivideByZeroException e1) {
	    	 assertTrue(true);	
	     } catch (final RuntimeException e) {
		     fail("Should have thrown a DivdeByZeroException");
	     }
	}
	
	@Test
	public void testAbsPositive() {
		testObject.push(6);
		
		testObject.abs();
		
		assertTrue(testObject.top() == 6);
	}
	
	@Test
	public void testAbsNegative() {
		testObject.push(-3);
		
		testObject.abs();
		
		assertTrue(testObject.top() == 3);
	}
	
	@Test
	public void testPowBaseZero() {
		testObject.push(0);
		testObject.push(6);
		
		testObject.pow();
		
		assertTrue(testObject.top() == 0);
	}
	
	@Test
	public void testPowExponentZero() {
		testObject.push(6);
		testObject.push(0);
		
		testObject.pow();
		
		assertTrue(testObject.top() == 1);
	}
	
	@Test
	public void testPow() {
		testObject.push(2);
		testObject.push(5);
		
		testObject.pow();
		
		assertTrue(testObject.top() == 32);
	}
	
	@Test
	public void testSqrtFromZero() {
		testObject.push(0);
		
		testObject.sqrt();
		
		assertTrue(testObject.top() == 0);
	}
	
	@Test
	public void testSqrtFromFour() {
		testObject.push(4);
		
		testObject.sqrt();
		
		assertTrue(testObject.top() == 2);
	}
	
	@Test
	public void testSqrtFromNine() {
		testObject.push(9);
		
		testObject.sqrt();
		
		assertTrue(testObject.top() == 3);
	}
	
	@Test
	public void testSqrtFromNegativeNumber() {
		testObject.push(-6);
		
	     try {
	    	 testObject.sqrt();

	    	 fail("Should have thrown a SquareRootFromNegativeNumberException");
	     } catch (SquareRootFromNegativeNumberException e1) {
	    	 assertTrue(true);	
	     } catch (final RuntimeException e) {
		     fail("Should have thrown a SquareRootFromNegativeNumberException");
	     }
	}
}
