package org.jham.encrypt;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
public class EncryptionHelper {
	
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
}
