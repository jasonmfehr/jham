package org.jham.service;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.jham.encrypt.EncryptionHelper;
import org.jham.transferobjects.KeyHolderTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

public class ClientServiceTest {

	private ClientService fixture;
	private EncryptionHelper mockEncryptionHelper;
	private HttpServletRequest mockServletRequest;
	
	@Before
	public void setUp() {
		mockEncryptionHelper = Mockito.mock(EncryptionHelper.class);
		fixture = new ClientService();
		ReflectionTestUtils.setField(fixture, "encryptionHelper", mockEncryptionHelper);
		
		mockServletRequest = Mockito.mock(HttpServletRequest.class);
	}
	
	@After
	public void tearDown() {
		fixture = null;
		mockEncryptionHelper = null;
	}
	
	@Test
	public void testRandomKeyHappyPath() {
		KeyHolderTO actualTO;
		
		Mockito.when(mockEncryptionHelper.randomInt()).thenReturn(Integer.valueOf(4292013));

		actualTO = fixture.randomKeyForClient("1234", mockServletRequest);
		assertEquals(Integer.valueOf(4292013), actualTO.getKey());
		
		Mockito.verify(mockEncryptionHelper).randomInt();
		Mockito.verify(mockServletRequest).getRemoteAddr();
	}

}
