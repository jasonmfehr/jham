package org.jham.service;

import java.util.Random;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jham.encrypt.EncryptionHelper;
import org.jham.transferobjects.KeyHolderTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/encrypt")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Singleton
public class EncryptionService {

	private static final int MAX_RANDOM = 65535;
	private static final Logger logger = LoggerFactory.getLogger(EncryptionService.class);
	
	@Autowired
	private EncryptionHelper helper;
	
	public EncryptionService(@Context ServletContext context) {
		logger.info("EncryptionService ctor called");
		helper = (EncryptionHelper)context.getAttribute("encryptionHelper");
	}
	
    @GET
    @Path("/randomkey")
    public KeyHolderTO generateRandomKey(@QueryParam("clientIdentifier") String clientId) {
    	return new KeyHolderTO(new Random(System.nanoTime()).nextInt(MAX_RANDOM));
    }
}
