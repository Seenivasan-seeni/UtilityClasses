package dsa;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.SecretKeyFactory;

import main.Employee;

public class EncryptionMain {
	
	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Employee emp = new Employee("seeni", 1000, "JAVA", "INDIA", 80);
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while(sb.length() < 16) {
			int num = r.nextInt();
			sb.append(Integer.toHexString(num));
		}
		System.out.println(sb);
		String subString =  sb.substring(0, 16);
		System.out.println("SubString -> "+subString);
		byte[] hexBytes = subString.getBytes();
		System.out.println("HexBytes -> "+ hexBytes);
		
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//		KeySpec spec = new PBEKeySpec("sbi pure banking nothing else".toCharArray(), obj.hex(subString), 10000, 256);
//		SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		
	}

}
