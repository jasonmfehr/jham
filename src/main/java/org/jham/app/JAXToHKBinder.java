package org.jham.app;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.jham.encrypt.EncryptionHelper;
import org.jham.service.EncryptionService;

public class JAXToHKBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(EncryptionService.class).to(EncryptionService.class);
		bind(EncryptionHelper.class).to(EncryptionHelper.class);
	}

}
