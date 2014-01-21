package org.jham.encrypt;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EncryptionHelper implements Feature {
	
	private static final Logger logger = LoggerFactory.getLogger(EncryptionHelper.class);
	
	public EncryptionHelper() {
		logger.info("EncryptionHelper ctor called");
	}
	/*private EncryptionHelper() {
		
	}*/

	public /*static*/ int[] encryptValue(String val, String key) {
		int[] encryptedVal = new int[val.length()];
		int keyPos = 0;
		
		for(int i=0; i<val.length(); i++){
			encryptedVal[i] = (int)(val.charAt(i) ^ key.charAt(keyPos));
			
			keyPos++;
			if(keyPos == key.length()){
				keyPos = 0;
			}
		}
		
		return encryptedVal;
	}
	
	public /*static*/ String decryptValue(int[] val, String key) {
		StringBuilder sb = new StringBuilder();
		int keyPos = 0;
		
		for(int i=0; i<val.length; i++){
			sb.append((char)(val[i] ^ key.charAt(keyPos)));
			
			keyPos++;
			if(keyPos == key.length()){
				keyPos = 0;
			}
		}
		
		return sb.toString();
	}

	@Override
	public boolean configure(FeatureContext context) {
		return true;
	}
}
