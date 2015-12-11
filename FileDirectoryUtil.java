package com.raventech.projectflow.utils;

import android.content.Context;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 15/12/11.
 */
public class FileDirectoryUtil {

    private final static String FLOW_FILE_DIRECOTRY = "flow/";

    private final static String FLOW_PIC_FILE_DIRECOTRY = FLOW_FILE_DIRECOTRY + "pictures/";

    /**
     * //storage/emulated/0/Android/data/com.raventech.projectflow/files/[Pictures]
     *
     *  The file where saving the public stuff for every app visibility but may not understand;
     * */
    public static File getPublicDataDirectory(Context context, String type){
        return context.getExternalFilesDir(type);
    }

    /**
     * The file where saving the public stuff for every app visibility and understand;
     * */
    public static File getPublicDirectory(String fileName) throws IOException {
        String path = Environment.getExternalStorageDirectory() + "/" + FLOW_PIC_FILE_DIRECOTRY;
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        File f = new File(file , fileName);
        return f;
    }
}
