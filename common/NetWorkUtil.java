package alex.demo.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by alex on 15/12/15.
 */
public class NetWorkUtil {

    private static boolean reverseProxyOn = false;
    
    public static boolean isAvaliable(Context context) {
	ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	return cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
    /** must run in worker thread **/
    public static boolean ping() {
	// http://bbs.csdn.net/topics/390235675 
        // 进行正式测试，并记录此方法是否可用	
    }

    public static String getIpAddress(){
        return null;
    }

    public static String getISP(Context context){
        try
        {
            TelephonyManager localTelephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
            if (localTelephonyManager == null)
                return "unknown";
            String str = localTelephonyManager.getNetworkOperatorName();
            return str;
        }
        catch (Exception localException)
        {
        }
        return "unknown";
    }

    /**
     * To call {@link #getNetworkTypeName} to translate the current expression;
     *
     * @return -1 , 0 or 1
     * **/
    public static int getNetWorkType(Context context){
        ConnectivityManager localConnectivityManager;
        NetworkInfo networkInfo;
	String type = getNetworkTypeName(context, networkInfo);
        if("PC".equal(type)) {
  
	} else if("WIFI".equal(type)) {
 	
	} else if("ethernet".equal(type)) {

	} else if("NONE".equal(type)) {
	
	} else {
	// celluar
	}
        return 0;
    }
    // how to make a "reverseproxyOn" ?
    public static String getNetworkTypeName(Context context, NetworkInfo paramNetworkInfo)
    {
        if (paramNetworkInfo == null)
        {
            if (reverseProxyOn)
                return "PC";
        }
        else
        {
            if (paramNetworkInfo.getType() == 0)
                return getNetworkTypeName(((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkType());
	    else if(networkInfo.getType() == 9)
		return "ethernet";"
            return "WIFI";
        }
        return "NONE";
    }

    // return a celluar types.
    private static String getNetworkTypeName(int paramInt)
    {
        switch (paramInt)
        {
            default:
                break;
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 12:
                return "CDMA - EvDo rev. B";
            case 7:
                return "CDMA - 1xRTT";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 11:
                return "iDEN";
            case 15:
                return "HSPA+";
        }
        return "UNKNOWN";
    }
}
