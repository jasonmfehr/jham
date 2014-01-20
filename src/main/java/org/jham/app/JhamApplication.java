package org.jham.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jham.encrypt.EncryptionHelper;
import org.jham.service.EncryptionService;

public class JhamApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		
		//resources.add(EncryptionService.class);
		
		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		
		singletons.add(new EncryptionHelper());
		singletons.add(new EncryptionService(null));
		
		return singletons;
	}

	
}
