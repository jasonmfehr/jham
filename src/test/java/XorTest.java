import org.junit.Test;

import org.junit.Test;



public class XorTest {

	//@Test
	public void test() {
		//System.out.println("char: " + ('A' ^ 'D'));
		//System.out.println("revr: " + (char)(5 ^ 'D'));
		//string
		//xorkey
		int[] encryptedString = new int[6];
		
		encryptedString[0] = (int) 's' ^ 'x';
		encryptedString[1] = (int) 't' ^ 'o';
		encryptedString[2] = (int) 'r' ^ 'r';
		encryptedString[3] = (int) 'i' ^ 'k';
		encryptedString[4] = (int) 'n' ^ 'e';
		encryptedString[5] = (int) 'g' ^ 'y';
	
		this.printArray(encryptedString);
		//this.printArray(EncryptionHelper.encryptValue("string", "xorkey"));
		
	}
	
	@Test
	public void test2() {
		String key = "abcdefghijklmnopqrstuvwxyz";
		String password = "changeme";
		//System.out.println(EncryptionHelper.decryptValue(EncryptionHelper.encryptValue("foo", key), key));
		
		/*
		int[] encryptedFromServer = EncryptionHelper.encryptValue(password, key);
		this.printArray(encryptedFromServer);
		
		String decryptedFromServer = EncryptionHelper.decryptValue(encryptedFromServer, key);
		System.out.println(decryptedFromServer);
		
		String decryptedFromServerReversed = this.reverse(decryptedFromServer);
		System.out.println(decryptedFromServerReversed);
		
		int[] encryptedFromClient = EncryptionHelper.encryptValue(decryptedFromServerReversed, key);
		this.printArray(encryptedFromClient);
		
		String decryptedFromClient = EncryptionHelper.decryptValue(encryptedFromClient, key);
		System.out.println(decryptedFromClient);
		System.out.println("---");
		int[] xoredArray = new int[8];
		for(int j=0; j<encryptedFromServer.length; j++){
			xoredArray[j] = encryptedFromServer[j] ^ encryptedFromClient[j];
		}
		this.printArray(xoredArray);
		*/
	}
	
	private String reverse(String val) {
		StringBuilder ret = new StringBuilder();
		
		for(int i=val.length()-1; i>=0; i--){
			ret.append(val.charAt(i));
		}
		
		return ret.toString();
	}
	
	private void printArray(int[] arr) {
		System.out.print('[');
		for(int i=0; i<arr.length - 1; i++){
			System.out.print(arr[i]);
			System.out.print(',');
		}
		System.out.print(arr[arr.length - 1]);
		System.out.println(']');
	}
}
