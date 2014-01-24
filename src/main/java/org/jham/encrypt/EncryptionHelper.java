package org.jham.encrypt;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EncryptionHelper {
	
	public Integer randomInt() {
		Random r = new Random(System.nanoTime());
		int randomInt;
		
		r = new Random(System.nanoTime());
		randomInt = r.nextInt();
		
		return Integer.valueOf(randomInt);
	}

	//TODO remove old experimental code
	/*
	public int[] encryptValue(String val, String key) {
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
	
	public String decryptValue(int[] val, String key) {
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
	*/

}
