package org.jham.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.jham.encrypt.EncryptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/mb")
@Singleton
public class ManagedBeanService {

	private static final Logger logger = LoggerFactory.getLogger(ManagedBeanService.class);
	
	//@Context
	@Inject
	private EncryptionHelper encryptionHelper;
	
	public ManagedBeanService() {
		logger.info("ManagedBeanService ctor called");
	}
	
	@GET
	@Produces("text/plain")
	public String sayHello() {
		return "Just Saying Hello";
	}
}
