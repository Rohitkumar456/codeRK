import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    // private static final Logger logger = LoggerFactory.getLogger(Encryption.class);
	private static final String DEFAULT_INIT_VECTOR = "U0tESkZpbHVocmVZR2ZlNw==";
	private static final String DEFAULT_ALGORITHM = "AES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";
	private static final Charset UTF8_CHARSET = StandardCharsets.UTF_8;
	
	private static String key = "O+LMyEqfwaMlIWw0/PxFC3KRbUSd8LmRSZ4/oUVRPow=";
    public static void main(String[] args) {
        String in = "JE7ITTNvLbq0IBxfRJ2Z7Q==";
        String pass = decrypt(in, key);
        System.out.println(pass);
    }

    public static String decrypt(String in, String key) {
		String out = null;
		try {
			byte[] keyBytes = Base64.getDecoder().decode(key);
			SecretKey secretKey = new SecretKeySpec(keyBytes, DEFAULT_ALGORITHM);
			IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(DEFAULT_INIT_VECTOR));

			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(in));
			out = new String(decrypted, UTF8_CHARSET);
		} catch (Exception ex) {
			// logger.error("decrypt: Generate Key Error: {}", ex.getMessage());
		}
		return out;
	}
}
