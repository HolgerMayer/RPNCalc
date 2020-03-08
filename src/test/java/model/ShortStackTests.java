package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShortStackTests {

	ShortStack testObject;
	
	
	@Test
	public void testInitialize() {
		
		testObject = new ShortStack();
				
		assertTrue(testObject.x == 0.0);
		assertTrue(testObject.y == 0.0);
		assertTrue(testObject.z == 0.0);
		assertTrue(testObject.t == 0.0);
	}
	
	@Test
	public void testPush() {
		
		testObject = new ShortStack();
				
		testObject.push(1);
		testObject.push(2);
		testObject.push(3);
		testObject.push(4);
		
		
		assertTrue(testObject.x == 4.0);
		assertTrue(testObject.y == 3.0);
		assertTrue(testObject.z == 2.0);
		assertTrue(testObject.t == 1.0);
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
		assertTrue(result == 4.0);
		
		result = testObject.pop();
		assertTrue(result == 3.0);

		result = testObject.pop();
		assertTrue(result == 2.0);

		result = testObject.pop();
		assertTrue(result == 1.0);

		
		assertTrue(testObject.x == 1.0);
		assertTrue(testObject.y == 1.0);
		assertTrue(testObject.z == 1.0);
		assertTrue(testObject.t == 1.0);
	}

}
