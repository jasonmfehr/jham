package org.jham.exception;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;

import org.jham.internationalization.I18NHolder;
import org.jham.service.EncryptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A runtime exception indicating the client did not provide the clientId 
 * parameter as expected.  Returns a HTTP 400 error to the client.
 * 
 * @see BadRequestException
 * @author jasonmfehr
 * @since 1.0
 */
public class ClientIdNotProvidedException extends BadRequestException {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(EncryptionService.class);
	
	/**
	 * Constructs an exception with a default message.  Does not provide any 
	 * logging functionality.
	 */
	public ClientIdNotProvidedException() {
		super(I18NHolder.getString(I18NHolder.CLIENT_ID_NOT_PROVIDED_DEFAULT_MESSAGE));
	}
	
	/**
	 * Lower level constructor that relies on the throwing class to provide the 
	 * error message versus allowing this class to construct the message. 
	 * 
	 * @param message {@link String} with the error message, passed to the 
	 *                super class's constructor
	 */
	public ClientIdNotProvidedException(final String message) {
		super(message);
	}
	
	/**
	 * Uses the request details to log a warning in the logs with details 
	 * identifying the client.  Will insert the client's IP address into 
	 * the logs provided the logger for this class is set to WARN or higher.
	 * 
	 * @param request {@link HttpServletRequest} for the request that caused 
	 *                this exception
	 */
	public ClientIdNotProvidedException(final HttpServletRequest request) {
		super(I18NHolder.getString(I18NHolder.CLIENT_ID_NOT_PROVIDED_WITH_IP_MESSAGE, request.getRemoteAddr()));
		logger.warn(this.getMessage());
	}

}
