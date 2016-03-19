package com.example.alex.utilstest.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;

import java.util.Locale;

/**
 * origin implements by acra, and may updated by fb; 
 */
public class DumpSysCollector {

    /**
     * 参数说明可见: {@link http://blog.csdn.net/tonyfield2015/article/details/8438723}
     *              {@link http://blog.csdn.net/vshuang/article/details/39647167}
     *              {@link http://blog.163.com/rettar@126/blog/static/12165034220121029025914/}
	*** debug paramters ***
             percent dalvik+native / native / d+n+other / other
             2 / 2 / 11 / 9
	*** not debug paramters ***
             avail/thresh/low
             1577828352/100663296/false/(6%) memclass=192
	*** debug paramters ***
             DebugMemInfo(kB):
             Private / Proportional / Shared
             dalvik:    1196 /    2195 /   22724
             native:    3992 /    4013 /    1124
             other:   18240 /   20822 /    8412
	*** debug paramters ***
             GC:
             9 GCs, 1382816 freed, 22455 free count
             Native Heap:
             size/allocated/free
             5328896 / 4349200 /  979696
             Threads:
             alloc count/alloc size/ext ac/ext as
             23402 / 1248190 /       0 /       0
	*** Runtime paramters ***
             Java Heap:
             size/allocated/free
             201326592 / 23609608 / 8204000

     *
     * **/
    public static String collectMemInfo(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Debug.MemoryInfo debugMemoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(debugMemoryInfo);
        int avaliableMaxMemory = activityManager.getMemoryClass();
        int i = (int) (100.0f * (((float) (debugMemoryInfo.nativePrivateDirty + debugMemoryInfo.dalvikPrivateDirty)) / (((float) avaliableMaxMemory) * 1024.0f)));
        int i2 = (int) (((float) (debugMemoryInfo.nativePrivateDirty * 100)) / (((float) avaliableMaxMemory) * 1024.0f));
        int i3 = (int) (((float) (((debugMemoryInfo.nativePrivateDirty + debugMemoryInfo.dalvikPrivateDirty) + debugMemoryInfo.otherPrivateDirty) * 100)) / (((float) avaliableMaxMemory) * 1024.0f));
        int i4 = (int) (((float) (debugMemoryInfo.otherPrivateDirty * 100)) / (((float) avaliableMaxMemory) * 1024.0f));
        stringBuilder.append(String.format(Locale.US, "percent dalvik+native / native / d+n+other / other \n%d / %d / %d / %d\n", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        stringBuilder.append("avail/thresh/low \n" + memoryInfo.availMem + "/" + memoryInfo.threshold + "/" + memoryInfo.lowMemory + "/(" + ((int) (((float) (100 * memoryInfo.threshold)) / ((float) memoryInfo.availMem))) + "%) memclass=" + avaliableMaxMemory + "\n");
        stringBuilder.append("DebugMemInfo(kB):\n Private / Proportional / Shared \n");
        stringBuilder.append(String.format(Locale.US, "          dalvik: %7d / %7d / %7d\n", new Object[]{Integer.valueOf(debugMemoryInfo.dalvikPrivateDirty), Integer.valueOf(debugMemoryInfo.dalvikPss), Integer.valueOf(debugMemoryInfo.dalvikSharedDirty)}));
        stringBuilder.append(String.format(Locale.US, "          native: %7d / %7d / %7d\n", new Object[]{Integer.valueOf(debugMemoryInfo.nativePrivateDirty), Integer.valueOf(debugMemoryInfo.nativePss), Integer.valueOf(debugMemoryInfo.nativeSharedDirty)}));
        stringBuilder.append(String.format(Locale.US, "           other: %7d / %7d / %7d\n", new Object[]{Integer.valueOf(debugMemoryInfo.otherPrivateDirty), Integer.valueOf(debugMemoryInfo.otherPss), Integer.valueOf(debugMemoryInfo.otherSharedDirty)}));
        stringBuilder.append(String.format(Locale.US, "GC:\n %d GCs, %d freed, %d free count\n", new Object[]{Integer.valueOf(Debug.getGlobalGcInvocationCount()), Integer.valueOf(Debug.getGlobalFreedSize()), Integer.valueOf(Debug.getGlobalFreedCount())}));
        stringBuilder.append(String.format(Locale.US, "Native Heap:\n size/allocated/free\n %7d / %7d / %7d\n", new Object[]{Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize())}));
        stringBuilder.append(String.format(Locale.US, "Threads:\n alloc count/alloc size/ext ac/ext as \n%7d / %7d / %7d / %7d\n", new Object[]{Integer.valueOf(Debug.getThreadAllocCount()), Integer.valueOf(Debug.getThreadAllocSize()), Integer.valueOf(Debug.getThreadExternalAllocCount()), Integer.valueOf(Debug.getThreadExternalAllocSize())}));
        Runtime runtime = Runtime.getRuntime();
        stringBuilder.append(String.format(Locale.US, "Java Heap:\n size/allocated/free\n %7d / %7d / %7d\n", new Object[]{Long.valueOf(runtime.maxMemory()), Long.valueOf(runtime.totalMemory() - runtime.freeMemory()), Long.valueOf(runtime.freeMemory())}));
        return stringBuilder.toString();
    }

    protected static String collectLargerMemoryInfo(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Large heap size =" + ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getLargeMemoryClass());
        return stringBuilder.toString();
    }


}
