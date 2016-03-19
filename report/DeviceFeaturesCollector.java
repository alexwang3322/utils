

/**
	come from fb

	还没有测试,希望将测试结果加到注释里面来 - 2016-3-18
**/
public class DeviceFeaturesCollector {
    public static String getFeatures(Context context) {
	// if API < 5 then return null;
	
	StringBuffer stringBuffer = new StringBuffer();
        try {
            Object[] objArr = (Object[]) PackageManager.class.getMethod("getSystemAvailableFeatures", null).invoke(context.getPackageManager(), new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    String str = (String) obj.getClass().getField("name").get(obj);
                    if (str != null) {
                        stringBuffer.append(str);
                    } else {
                        str = (String) obj.getClass().getMethod("getGlEsVersion", null).invoke(obj, new Object[0]);
                        stringBuffer.append("glEsVersion = ");
                        stringBuffer.append(str);
                    }
                    stringBuffer.append("\n");
                }
            }
        } catch (Throwable th) {
            Log.w(ACRA.LOG_TAG, "Couldn't retrieve device features for " + context.getPackageName(), th);
            stringBuffer.append("Could not retrieve data: ");
            stringBuffer.append(th.getMessage());
        }
        return stringBuffer.toString();
    }

}
