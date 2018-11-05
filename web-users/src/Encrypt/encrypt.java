package Encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encrypt {
	// Username, Password ma hóa lần 1 voi SHA256
	// Khi lưu vao` csdl, mã 1 lần nữa với MD5
    // SHA 256
    public static String hashWith256(String input) {
        String encode = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            encode = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encode;
    }
    
    //Md5
    public static String hashWithMD5(String md5) {
    	   try {
    	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
    	        byte[] array = md.digest(md5.getBytes());
    	        StringBuffer sb = new StringBuffer();
    	        for (int i = 0; i < array.length; ++i) {
    	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
    	       }
    	        return sb.toString();
    	    } catch (java.security.NoSuchAlgorithmException e) {
    	    }
    	    return null;
    	}

    // Triple DES
    public static byte[] encrypt(String message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        final byte[] plainTextBytes = message.getBytes("utf-8");
        final byte[] cipherText = cipher.doFinal(plainTextBytes);
        // final String encodedCipherText = new sun.misc.BASE64Encoder()
        // .encode(cipherText);

        return cipherText;
    }

    public static String decrypt(byte[] message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, key, iv);

        // final byte[] encData = new
        // sun.misc.BASE64Decoder().decodeBuffer(message);
        final byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }
    
    // AES
    public static String encryptAES(String key, String initVector, String value) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));

            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            //System.out.println("encrypted string: "
              //      + Base64.encodeBase64String(encrypted));

            //return Base64.encodeBase64String(encrypted);
            String s = new String(Base64.getEncoder().encode(encrypted));
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decryptAES(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
