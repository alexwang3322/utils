package alex.demo.common;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alex on 15/12/15.
 */
public class MD5Util {

    private static String MD5 = "MD5";

    static MessageDigest getDigest(String paramString){
        try
        {
            MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
            return localMessageDigest;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
            throw new RuntimeException(localNoSuchAlgorithmException.getMessage());
        }
    }


    private static String getHexString(byte[] paramArrayOfByte) {
        return String.format("%032x", new Object[] { new BigInteger(1, paramArrayOfByte) });
    }


    public static String md5Digest(InputStream paramInputStream)throws IOException {
        MessageDigest localMessageDigest = getDigest(MD5);
        byte[] arrayOfByte = new byte[131072];
        for (int i = paramInputStream.read(arrayOfByte, 0, 131072);
                         i > -1;
                         i = paramInputStream.read(arrayOfByte, 0, 131072))
            localMessageDigest.update(arrayOfByte, 0, i);
        return getHexString(localMessageDigest.digest());
    }

}
