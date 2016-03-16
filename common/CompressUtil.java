

/**
 
  all the compress is gzip type for now . may be we can add other type later.
 
**/
public class CompressUtil {

   
    public String compress(String content) {
	return null;
    }

    /**	@see FileUtils$compress */
    public File compress(File target) {
   	return null;
    }
	
    /**  not work right for now. **/
    public String unCompress(String content) {
    	String ret = "";
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream bis = new ByteArrayInputStream(content.getBytes());
            GZIPInputStream gunzip = new GZIPInputStream(bis);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer))>= 0) {
                out.write(buffer, 0, n);
            }
            ret = out.toString();
        } catch (IOException e) {
            return null;
        }
        return ret;
    } 

    public File unCompress(File target) {
   	return null;
    }
}
