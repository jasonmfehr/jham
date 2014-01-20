package org.jham.service;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jham.transferobjects.KeyHolderTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/encrypt")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EncryptionService {

	private static final int MAX_RANDOM = 65535;
    
	private static final Logger logger = LoggerFactory.getLogger(EncryptionService.class);
	
	public EncryptionService() {
		logger.info("EncryptionService ctor called");
	}
	
    @GET
    @Path("/randomkey/{clientId}")
    public KeyHolderTO generateRandomKey(@PathParam("clientIdentifier") String clientId) {
    	return new KeyHolderTO(new Random(System.nanoTime()).nextInt(MAX_RANDOM));
    }
}
