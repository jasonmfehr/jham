package org.jham.app;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApplication extends ResourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

	public MyApplication() {
		logger.info("MyApplication ctor called");
		
		register(new JAXToHKBinder());
		this.packages("org.jham");
	}
	
}
