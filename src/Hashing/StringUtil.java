package Hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class StringUtil {

    public static String applySha256(String input) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            int i = 0;
            byte[] hash = sha.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexHash = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexHash.append('0');
                }
                hexHash.append(hex);
            }

            return hexHash.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
