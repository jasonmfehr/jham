package org.jham.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jham.encrypt.EncryptionHelper;
import org.jham.transferobjects.EncryptedValueTO;
import org.jham.transferobjects.KeyHolderTO;

@Path("/encrypt")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EncryptionService {

    @GET
    @Path("/gen/{clientIdentifier}")
    public EncryptedValueTO generateEncryptedPassword(@PathParam("clientIdentifier") String clientId) {
        EncryptedValueTO ret = new EncryptedValueTO();
        
        //ret.setValue(EncryptionHelper.encryptValue("string", "xorkey"));
        int[] array = EncryptionHelper.encryptValue("string", "xorkey");
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<array.length; i++){
            list.add(Integer.valueOf(array[i]));
        }
        ret.setValue(list);
        //ret.setStr("123 hello json world");
        //ret.setTest1(12345);
        
        return ret;
    }
    
    @GET
    @Path("/randomkey/{clientIdentifier}")
    public KeyHolderTO generateRandomKey(@PathParam("clientIdentifier") String clientId) {
    	return new KeyHolderTO(12345);
    }
}
