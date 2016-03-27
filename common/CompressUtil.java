

/**
 
  all the compress is gzip type for now . may be we can add other type later.
 
**/
public class CompressUtil {

   
    /** 
	dst = new File(path.. + ".gzip");
        compress(src, dst);
    **/
    public static void compress(File src, File dst)throws IOException{
        if(src == null || dst == null)	throw NullPointerException();

 	FileInputStream fin = null;
        FileOutputStream fout = null;
        GZIPOutputStream gzout = null;
        try {
            fin = new FileInputStream(src);
            fout = new FileOutputStream(dst.getAbsoluteFile());
            gzout = new GZIPOutputStream(fout);
            byte[] buf = new byte[1024];
            int num;
            while ((num = fin.read(buf)) != -1) {
                gzout.write(buf, 0, num);
            }
        } finally {
            if (gzout != null)
                gzout.close();
            if (fout != null)
                fout.close();
            if (fin != null)
                fin.close();
        }
    }

    public static void unCompress(File src, File dst) {}	
   
   
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

}
