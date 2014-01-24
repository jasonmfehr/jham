package org.jham.service;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jham.encrypt.EncryptionHelper;
import org.jham.transferobjects.KeyHolderTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/client")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Singleton
public class ClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private EncryptionHelper encryptionHelper;
	
	@GET
    @Path("/{clientId}/randomkey")
	public KeyHolderTO randomKeyForClient(@PathParam(value="clientId") final String clientId, @Context final HttpServletRequest request) {
    	logger.debug("returning random key to client {}", request.getRemoteAddr());
    	
    	return new KeyHolderTO(encryptionHelper.randomInt());
	}
}
