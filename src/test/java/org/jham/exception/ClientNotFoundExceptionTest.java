package org.jham.exception;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.mockito.Mockito;

public class ClientNotFoundExceptionTest {

	@Test
	public void testDefaultCtor() {
		ClientNotFoundException fixture = new ClientNotFoundException();
		
		assertEquals("Client with specified id was not found", fixture.getMessage());
	}
	
	@Test
	public void testClientIdOnlyCtor() {
		ClientNotFoundException fixture = new ClientNotFoundException("123");
		
		assertEquals("Client with id of [123] was not found", fixture.getMessage());
	}
	
	@Test
	public void testClientAddressCtor() {
		ClientNotFoundException fixture;
		HttpServletRequest mockRequest;
		
		mockRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(mockRequest.getRemoteAddr()).thenReturn("42.42.42.42");
		
		fixture = new ClientNotFoundException(mockRequest);
		assertEquals("Client with specified id from [42.42.42.42] was not found", fixture.getMessage());
		
		Mockito.verify(mockRequest).getRemoteAddr();
	}
	
	@Test
	public void testClientIdAddressCtor() {
		ClientNotFoundException fixture;
		HttpServletRequest mockRequest;
		
		mockRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(mockRequest.getRemoteAddr()).thenReturn("42.42.42.42");
		
		fixture = new ClientNotFoundException("4567", mockRequest);
		assertEquals("Client with id of [4567] from [42.42.42.42] was not found", fixture.getMessage());
		
		Mockito.verify(mockRequest).getRemoteAddr();
	}

}
