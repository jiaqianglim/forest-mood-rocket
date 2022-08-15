package cafefashionsociety.structureliteraturemeadow.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserConfig {

    public static String encryptPassword(String inputpassword) throws NoSuchAlgorithmException {
        String encryptedPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(inputpassword.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toHexString(bytes[i]));
            }
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}
