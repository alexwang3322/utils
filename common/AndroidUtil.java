package utils.common;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by alex on 15/11/26.
 */
public class AndroidUtil {

    /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    } 

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
    	return android.provider.Settings.Secure.getString(context.getContentResolver(),
							android.provider.Settings.Secure.ANDROID_ID);
    }

    /**  @return  SimSerialNumber:898600810110  **/
    public static String getSimSerialNumber(Context context){
	    return ((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getSimSerialNumber();
    }

    /**	 @return  get mac address  **/
    public static String getLocalMacAddress(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }

    public static String getPhoneNumber(Context context) {
        String num = null;
        try {
            num = ((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
            } catch(Exception e) {}
        return num;
    }
}
