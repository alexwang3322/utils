class StringUtils{

    private static boolean write(String content,@Nullable File traget){
	if(target == null)    return false;
	BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new StringReader(content));
            bufferedWriter = new BufferedWriter(new FileWriter(target));
            char buf[] = new char[512];
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }	
    }

    public static boolean write(String content,@Nullable File... targets){
	if(targets == null)	return false;	
        for(File file : targets) {
	    write(content, file);
	}
    }

    public static String read(InputStream src){
	BufferedReader reader = new BufferedReader(new InputStreamReader(src));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                src.close();
            } catch (IOException e) {
            }
        }
	return sb.length() > 1 ? sb.toString() : "null";    
    }

    @Nullable
    public static String read(@Nullable File src){
	if(src == null || !src.exsit())		return null;
	FileInputStream is = new FileInputStream(src);
        return read(is);	
    }

}
