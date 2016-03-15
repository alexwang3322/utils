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
        byte[] arrayOfByte = new byte[8192];
        for (int i = paramInputStream.read(arrayOfByte, 0, 131072);
                         i > -1;
                         i = paramInputStream.read(arrayOfByte, 0, 131072))
            localMessageDigest.update(arrayOfByte, 0, i);
        return getHexString(localMessageDigest.digest());
    }

    public static String calculateMD5(File updateFile) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "Exception while getting digest", e);
            return null;
        }

        InputStream is;
        try {
            is = new FileInputStream(updateFile);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Exception while getting FileInputStream", e);
            return null;
        }

        byte[] buffer = new byte[8192];
        int read;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            // Fill to 32 chars
            output = String.format("%32s", output).replace(' ', '0');
            return output;
        } catch (IOException e) {
            throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(TAG, "Exception on closing MD5 input stream", e);
            }
        }
    }
}
