

class ApplicationUtils {
    
    
    /**         this method isn't tested yet by IDE  alex 2016-3-5    **/
    public static String getMetaDataInManifest(Context context, String key) {
        Object value = null;
        try {
                value = context.getPackageManager().getApplicationInfo(
			 	context.getPackageName(),
			 	PackageManager.GET_META_DATA).metaData.get(key);
        } catch(Exception e) {}
        return value==null ? value : value.toString();
    }


}
