package utils.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class PackageUtils {
   
    public static boolean getBooleanMetaData(String key) {
		return getMetaData(ApplicationContext, key).getBoolean(key);
    }

    @Nullable
    public static String getStringMetaData(String key) {
		String ret = null;
		try {
			ret = getMetaData(ApplicatoinContext, key).get(key);
		} catch (PackageManager.NameNotFoundException e) {
		}
		return ret;
    }

    @Nullable
    private static Bundle getMetaData(Context context, String key) throws PackageManager.NameNotFoundException {
		Bundle metaData = context.getPackageManager()
			.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA)
				.metaData;
		return metaData;
    }

}
