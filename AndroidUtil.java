package com.raventech.projectflow.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by alex on 15/11/26.
 */
public class AndroidUtil {

    public static DisplayMetrics getDisplayMetrics(Context context){
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(metrics);
        return metrics;
    }
    /**  @return  IMEI:868331011992179  **/
    public static String getImei(Context context){
	return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }
    /**  @return ANDROID ID:5a3b287f2b13bef8  **/
    public static String getAndroidId(Context context){
    	return andorid.provider.Settings.Secure.getString(context.getContentResolver(),
							android.provider.Settings.Secure.ANDROID_ID);
    }
    /**  @return  SimSerialNumber:898600810110  **/
    public static String getSimSerialNumber(Context context){
	return ((TelephonyManager)context.getSystemService(Context.TElEPHONY_SERVICE)).getSimSerialNumber();
    }

}
