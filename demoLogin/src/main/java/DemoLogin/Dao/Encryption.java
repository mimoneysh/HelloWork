package DemoLogin.Dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;

public class Encryption {
	@Autowired
	public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes is a common size
        random.nextBytes(salt);
        return salt;
    }
	@Autowired
    public static byte[] hashString(String input, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedValue = md.digest(input.getBytes());

            return hashedValue;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
