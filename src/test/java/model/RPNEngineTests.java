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

}
