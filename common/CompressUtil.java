package com.bugsnag.android;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**

  all the compress is gzip type for now . may be we can add other type later.

**/
public class CompressUtil {

    /**	简单版	2016-4-1 */
    private static void compress(@NonNull File dst, @NonNull String content) throws IOException {
        GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(dst));
        OutputStreamWriter writer = new OutputStreamWriter(gos);
        writer.write(content);
        writer.close();
    }
    /**
	dst = new File(path.. + ".gzip");
        compress(src, dst);
    **/
    public static void compress(@Nullable File src,@Nullable File dst)throws IOException {
        if(src == null || dst == null)	return ;
 	    FileInputStream fin = null;
        FileOutputStream fout = null;
        GZIPOutputStream gzout = null;
        try {
            fin = new FileInputStream(src);
            fout = new FileOutputStream(dst.getAbsoluteFile());
            gzout = new GZIPOutputStream(fout);
            byte[] buf = new byte[1024];
            int num;
            while ((num = fin.read(buf)) != -1) {
                gzout.write(buf, 0, num);
            }
        } finally {
            if (gzout != null)
                gzout.close();
            if (fout != null)
                fout.close();
            if (fin != null)
                fin.close();
        }
    }

    /**  not work right for now. **/
    public String unCompress(File src) throws IOException{
    	StringBuffer ret = new StringBuffer();
        GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(src));
        byte[] buffer = new byte[1024];
        while (gzip.read(buffer) != -1) {
            ret.append(new String(buffer));
        }
        return ret.toString();
    }

}
