package org.jham.encrypt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EncryptionHelperTest {

	private EncryptionHelper fixture;
	
	@Before
	public void setUp() {
		fixture = new EncryptionHelper();
	}
	
	@After
	public void tearDown() {
		fixture = null;
	}
	
	@Test
	public void testRandomInt() {
		assertNotNull(fixture.randomInt());
	}

}
