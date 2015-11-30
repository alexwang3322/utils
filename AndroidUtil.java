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

}
