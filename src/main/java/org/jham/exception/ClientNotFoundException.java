package org.jham.exception;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;

import org.jham.util.JhamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A runtime exception indicating the client with the specified 
 * id does not exist.  Returns a 404 not found.
 * 
 * @see NotFoundException
 * @author jasonmfehr
 * @since 1.0
 */
public class ClientNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 1L;
	private static final String CLIENT_NOT_FOUND_DEFAULT = "Client with specified id was not found";
	private static final String CLIENT_NOT_FOUND_WITH_ID = "Client with id of [{0}] was not found";
	private static final String CLIENT_NOT_FOUND_WITH_IP_ADDR = "Client with specified id from [{0}] was not found";
	private static final String CLIENT_NOT_FOUND_WITH_ID_IP_ADDR = "Client with id of [{0}] from [{1}] was not found";
			
	private static final Logger logger = LoggerFactory.getLogger(ClientNotFoundException.class);
	
	/**
	 * Constructs an exception with a default message.  Does not provide any 
	 * logging functionality.
	 */
	public ClientNotFoundException() {
		super(CLIENT_NOT_FOUND_DEFAULT);
	}
	
	/**
	 * Constructor that builds a message including the client id 
	 * that was not found. 
	 * 
	 * @param clientId {@link String} with the invalid client id
	 */
	public ClientNotFoundException(final String clientId) {
		super(JhamUtils.parseString(CLIENT_NOT_FOUND_WITH_ID, clientId));
		logger.warn(this.getMessage());
	}
	
	/**
	 * Uses the request details to log a warning in the logs with details 
	 * identifying the IP address of the client.  Will insert the IP address 
	 * into the logs provided the logger for this class is set to WARN or higher.
	 * 
	 * @param request {@link HttpServletRequest} for the request that caused 
	 *                this exception
	 */
	public ClientNotFoundException(final HttpServletRequest request) {
		super(JhamUtils.parseString(CLIENT_NOT_FOUND_WITH_IP_ADDR, request.getRemoteAddr()));
		logger.warn(this.getMessage());
	}
	
	/**
	 * Uses the request details to log a warning in the logs with details 
	 * identifying the IP address of the client and the invalid client id.  
	 * Will insert the IP address into the logs provided the logger for 
	 * this class is set to WARN or higher.
	 * 
	 * @param clientId {@link String} with the invalid client id
	 * @param request {@link HttpServletRequest} for the request that caused 
	 *                this exception
	 */
	public ClientNotFoundException(final String clientId, final HttpServletRequest request) {
		super(JhamUtils.parseString(CLIENT_NOT_FOUND_WITH_ID_IP_ADDR, clientId, request.getRemoteAddr()));
		logger.warn(this.getMessage());
	}

}
