package org.jham.encrypt;

public final class EncryptionHelper {
	
	private EncryptionHelper() {
		
	}

	public static int[] encryptValue(String val, String key) {
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
	
	public static String decryptValue(int[] val, String key) {
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
