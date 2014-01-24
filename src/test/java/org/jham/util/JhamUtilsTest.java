package org.jham.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class JhamUtilsTest {

	private static final String TEST_MSG = "test message";
	
	@Test
	public void testNullMessage() {
		assertNull(JhamUtils.parseString(null, "foo"));
	}
	
	@Test
	public void testNullReplacements() {
		assertEquals(TEST_MSG, JhamUtils.parseString(TEST_MSG, null));
	}
	
	@Test
	public void testNoReplacements() {
		assertEquals(TEST_MSG, JhamUtils.parseString(TEST_MSG));
	}
	
	@Test
	public void testWithReplacement() {
		assertEquals("test zero message one", JhamUtils.parseString("test {0} message {1}", "zero", "one"));
	}

}
