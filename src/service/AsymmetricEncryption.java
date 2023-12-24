package service;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class AsymmetricEncryption {
    private static Scanner scanner;
    public static KeyPair generateRSAKeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        keyPairGenerator.initialize(2048, secureRandom);

        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] Encrypt(String plainText,
                                 PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(plainText.getBytes());
    }

    public static String Decrypt(byte[] cipherText,
                                 PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }
}
