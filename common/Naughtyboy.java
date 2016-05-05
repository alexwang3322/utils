


public class Naughtyboy {
	
    // see active process 
    /**
	com.tencent.mobileqq:MSF
        com.huawei.android.launcher
        com.speedsoftware.rootexplorer
        com.tencent.mobileqq
    **/
    public static String checkOtherBoys(Context context) {
	ActivityManager manager = (ActivityManager) c.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = manager.getRunningAppProcesses();
        StringBuffer stringBuffer = new StringBuffer();
        for (ActivityManager.RunningAppProcessInfo info : list) {
               stringBuffer.append(info.processName + "\n");
        }
	return stringBuffer;
    }


}
