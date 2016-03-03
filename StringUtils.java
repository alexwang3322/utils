class StringUtils{

	public static void write(String content, File traget){
	
	}
	public static void write(String content, File... tragets){
		for(int i=0; i<tragets.length; i++){
			write(content, tragets[i]);
		}	
	}

	public static String read(InputStream src){
	
	}

	public static String read(File src){
	
	}

}
