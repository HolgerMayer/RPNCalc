package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShortStackTests {

	static final double TOLERANCE = 0.0001;
	
	ShortStack testObject;
	
	
	@Test
	public void testInitialize() {
		
		testObject = new ShortStack();
				
		assertEquals(0.0, testObject.getX(),TOLERANCE);
		assertEquals(0.0, testObject.getY(),TOLERANCE);
		assertEquals(0.0, testObject.getZ(),TOLERANCE);
		assertEquals(0.0, testObject.getT(),TOLERANCE);
		assertEquals(0.0, testObject.getLastX(),TOLERANCE);
	}
	
	@Test
	public void testClear() {
		
		testObject = new ShortStack();
		testObject.push(1);
		testObject.saveToLastXAndPop();
		testObject.push(1);
		testObject.push(2);
		testObject.push(3);
		testObject.push(4);

		testObject.clear();
		
		assertEquals(0.0, testObject.getX(),TOLERANCE);
		assertEquals(0.0, testObject.getY(),TOLERANCE);
		assertEquals(0.0, testObject.getZ(),TOLERANCE);
		assertEquals(0.0, testObject.getT(),TOLERANCE);
		assertEquals(0.0, testObject.getLastX(),TOLERANCE);
	}
	

	@Test
	public void testPush() {
		
		testObject = new ShortStack();
				
		testObject.push(1);
		testObject.push(2);
		testObject.push(3);
		testObject.push(4);
		
		
		assertEquals(4.0, testObject.getX(),TOLERANCE);
		assertEquals(3.0, testObject.getY(),TOLERANCE);
		assertEquals(2.0, testObject.getZ(),TOLERANCE);
		assertEquals(1.0, testObject.getT(),TOLERANCE);
		assertEquals(0.0, testObject.getLastX(),TOLERANCE);
	}
	
	
	@Test
	public void testPop() {
		
		testObject = new ShortStack();

		
		testObject.push(1);
		testObject.push(2);
		testObject.push(3);
		testObject.push(4);

		double result;
		
		result = testObject.pop();
		assertEquals(4.0, result,TOLERANCE);
		
		result = testObject.pop();
		assertEquals(3.0, result,TOLERANCE);

		result = testObject.pop();
		assertEquals(2.0, result,TOLERANCE);

		result = testObject.pop();
		assertEquals(1.0, result,TOLERANCE);
		
		assertEquals(1.0, testObject.getX(),TOLERANCE);
		assertEquals(1.0, testObject.getY(),TOLERANCE);
		assertEquals(1.0, testObject.getZ(),TOLERANCE);
		assertEquals(1.0, testObject.getT(),TOLERANCE);
		assertEquals(0.0, testObject.getLastX(),TOLERANCE);

	}
	
	@Test
	public void testSaveLastXAndPop() {
		
		testObject = new ShortStack();
		
		testObject.push(1);
		testObject.push(2);
		testObject.push(3);
		testObject.push(4);

		double result;
		
		result = testObject.pop();
		assertEquals(4.0, result,TOLERANCE);
		
		result = testObject.saveToLastXAndPop();
		assertEquals(3.0, result,TOLERANCE);

		result = testObject.pop();
		assertEquals(2.0, result,TOLERANCE);
		
		result = testObject.pop();
		assertEquals(1.0, result,TOLERANCE);
	
		assertEquals(1.0, testObject.getX(),TOLERANCE);
		assertEquals(1.0, testObject.getY(),TOLERANCE);
		assertEquals(1.0, testObject.getZ(),TOLERANCE);
		assertEquals(1.0, testObject.getT(),TOLERANCE);
		assertEquals(3.0, testObject.getLastX(),TOLERANCE);
	}

}
