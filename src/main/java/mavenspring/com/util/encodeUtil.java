package mavenspring.com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class encodeUtil {
	public static void main(String[] args) {
		System.out.println(encode("123456"));
	}
	public static String encode(String str){
		MessageDigest d;
		try {
			d = MessageDigest.getInstance("MD5");
			byte[] output = d.digest(str.getBytes());
			String paws = Base64.encodeBase64String(output);
			return paws;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		   
		
		
	}

}
