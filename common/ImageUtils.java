package utils.common;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import java.io.File;
import java.io.IOException;

class ImageUtils {

    public final static int UPLOAD_COMPRESS_QUALITY = 80; // airbxb is 80% too.

    public static Bitmap rotateIfNeeded(Bitmap bitmap, int degree) {
		if (!(degree == 0 || bitmap == null)) {
            Matrix m = new Matrix();
            m.setRotate((float) degree, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            try {
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
            } catch (OutOfMemoryError e) {
            	// should catch and report a OOM log.
	    	}
        }
        return bitmap;
    }

	//TODO: bitmap.compress 不支持此参数
    public static String compressBitmapForUpload(Bitmap bitmap, int rotationDegress) throws IOException {
		if(bitmap != null) {
			try {
				bitmap = rotateIfNeeded(bitmap, rotationDegress);
				File temp = File.createTempFile("upload" + System.currentTimeMillis(), "jpg");
				bitmap.compress(bitmap, UPLOAD_COMPRESS_QUALITY, temp);
				return temp.getAbsolutePath();
			} catch (OutOfMemoryError e) {
			} catch (IOException e) {
			}
		}
		return null;
    }
}
