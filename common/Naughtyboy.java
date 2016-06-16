


public class Naughtyboy {
	
    /**
	   com.tencent.mobileqq:MSF
        com.huawei.android.launcher
        com.speedsoftware.rootexplorer
        com.tencent.mobileqq
    **/
    public static String getRunningBoys(Context context) {
	   ActivityManager manager = (ActivityManager) c.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = manager.getRunningAppProcesses();
        StringBuffer stringBuffer = new StringBuffer();
        for (ActivityManager.RunningAppProcessInfo info : list) {
               stringBuffer.append(info.processName + "\n");
        }
	return stringBuffer;
    }


    /**

        listviewitemanimations:ListViewItemAnimations:1.0

    **/
    public static String getPersistBoys(Context context) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        StringBuffer builder = new StringBuffer();
        for (PackageInfo packageInfo : pakageinfos) {
            String pack_name = packageInfo.applicationInfo.packageName;
            String str_name = packageInfo.applicationInfo.loadLabel(pm).toString();
            String version = packageInfo.versionName;
            if(pack_name.contains("com.android")) { // get rid of Google Android Application ~ 50 apps
                continue;
            }
            builder.append(pack_name).append(":").append(str_name).append(":").append(version).append(",");
        }
        return builder.toString();
    }
}
