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



}
