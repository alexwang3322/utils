

public class PackageUtils {
   
    public static boolean getBooleanMetaData(String key) {
	return getMetaDat(ApplicationContext, key).getBoolean(key);
    }

    @Nullable
    public static String getStringMetaData(String key) {
	String ret = null;
	try {
		ret = getMetaData(ApplicatoinContext, key).get(key)	
	} catch (PackageManager.NameNotFoundException e) {
	}
 	return ret;
    }

    @Nullable
    private static Bundle getMetaData(Context context, String key) throws PackageManager.NameNotFoundException {
	Bundle metaData = context.getPackageManager()
		.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA)	
    		.metaData;
  	return metaData;e
    }

}
