package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5 {
private String password;
private MessageDigest alg;
private StringBuffer hashedpasswd;

public MD5(String password){
    try {
        this.password = password;
        alg = MessageDigest.getInstance("MD5");
        alg.update(password.getBytes());
        byte[] digest = alg.digest();
        hashedpasswd = new StringBuffer();
        String hx;
        for (int i=0;i<digest.length;i++){
                hx =  Integer.toHexString(0xFF & digest[i]);
                //0x03 is equal to 0x3, but we need 0x03 for our md5sum
                if(hx.length() == 1){hx = "0" + hx;}
                hashedpasswd.append(hx);
        }
        System.out.println("tu password PEEEEEEEROOOOO HAAAASHH "+hashedpasswd.toString());
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public StringBuffer getHashedpasswd() {
        return hashedpasswd;
    }

    public void setHashedpasswd(StringBuffer hashedpasswd) {
        this.hashedpasswd = hashedpasswd;
    }

}
