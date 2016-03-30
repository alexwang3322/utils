package alex.demo.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 15/12/11.
 */
public class FileUtil {
    
    private final static String EXTERNAL_FILE_ROOT_DIR = "myapp";
    private final static String EXTERNAL_FILE_APP_DIR = "app";
    private final static String EXTERNAL_FILE_DIAGNOSIS_DIR = "diagnosis";
    private final static String EXTERNAL_FILE_IMAGE_DIR = "image";
    private final static String EXTERNAL_FILE_CACHE_DIR = "cache";


    private final static String FLOW_FILE_DIRECOTRY = "flow/";
    private final static String FLOW_PIC_FILE_DIRECOTRY = FLOW_FILE_DIRECOTRY + "pictures/";


     @Nullable
    private static File mkdirDir(@NonNull File dir, @Nullable String fileName) {
        if(!dir.exists() && !dir.mkdir()) {
            return null;
        }
        if(fileName != null) {
            return new File(dir, fileName);
        }
        return dir;
    }

    @Nullable
    public static File getExternalAppFileApp(@Nullable String fileName) {
        File file = getExternalAppFileRoot();
        if(file != null) {
            File dir = new File(file.getAbsolutePath() + File.separator + EXTERNAL_FILE_APP_DIR);
            return mkdirDir(dir, fileName);
        }
        return null;
    }

    @Nullable
    public static File getExternalAppFileRoot() {
        File fileStr = getExternalAppFileRootPath();
        if(fileStr != null) {
            return mkdirDir(fileStr, null);
        }
        return null;
    }

    /** @return "/storage/emulated/0/app"  **/
    @Nullable
    private static File getExternalAppFileRootPath() {
        if(isSupportSDCard()) {
            return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + EXTERNAL_FILE_ROOT_DIR);
        }
        return null;
    }

    public static boolean isSupportSDCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    } 
     /**
     * 未检测
     * /data/data/app-package-name/
     * **/
    public static String getFile(Context context,String fileName) {
        return context.getDir(fileName, Context.MODE_PRIVATE).getAbsolutePath();
    }

    /**	/data/data/app-package-name/files/ **/
    public static File getFileDir(Context context) {
	return context.getFileDir();
    }

    /**
     * //storage/emulated/0/Android/data/com.raventech.projectflow/files/[Pictures]
     *
     *  The file where saving the own public local data while visibility but may not to understand for every app ;
     * */
    public static File getPublicDataDirectory(Context context, String type){
        return context.getExternalFilesDir(type);
    }

    /**
     * //storage/emulated/0/flow/pictures
     *
     * The file where saving the own public local data while visibility and understand for every app ;
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

    /**
     *  To create a image file in the local , also send a {@link Intent#ACTION_MEDIA_SCANNER_SCAN_FILE} broadcast
     * */
    public static File getAnEmptyImageFile(Context context, String fileName) throws IOException{
        File file = getPublicDirectory(fileName);
        // need to send this broadcast to make visible in system album;
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
        return file;
    }

}
