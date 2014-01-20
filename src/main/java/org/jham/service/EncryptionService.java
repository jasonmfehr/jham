package org.jham.service;

import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jham.encrypt.EncryptionHelper;
import org.jham.exception.ClientIdNotProvidedException;
import org.jham.transferobjects.EncryptedValueTO;
import org.jham.transferobjects.KeyHolderTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/encrypt")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EncryptionService {

	private static final Logger logger = LoggerFactory.getLogger(EncryptionService.class);

	@Inject
	private EncryptionHelper encryptionHelper;

	public EncryptionService() {
		logger.info("EncryptionService ctor called");
	}
	
    @GET
    @Path("/randomkey")
    public KeyHolderTO generateRandomKey(final @QueryParam("clientId") String clientId, final @Context HttpServletRequest request) {
    	if(clientId == null){
    		throw new ClientIdNotProvidedException(request);
    	}

    	logger.debug("returning random key to client {}", request.getRemoteAddr());
    	return new KeyHolderTO(new Random(System.nanoTime()).nextInt());
    }
    
    //TODO old experiment - remove it
    @GET
    @Path("/gen/{clientIdentifier}")
    public EncryptedValueTO generateEncryptedPassword(@PathParam("clientIdentifier") String clientId) {
    	EncryptedValueTO ret = new EncryptedValueTO();
    	
    	//ret.setValue(EncryptionHelper.encryptValue("string", "xorkey"));
    	/*
    	int[] array = EncryptionHelper.encryptValue("string", "xorkey");
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<array.length; i++){
    		list.add(Integer.valueOf(array[i]));
    	}
    	ret.setValue(list);
    	*/
    	//ret.setStr("123 hello json world");
    	//ret.setTest1(12345);
    	
    	return ret;
    }
}
