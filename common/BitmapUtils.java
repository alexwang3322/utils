

public class BitmapUtils {

    public static Bitmap scaled(Bitmap origin, int sampleSize) {
	Bitmap bm;
	BitmapFactory.Options bms = new BitmapFactory.options();
	bms.inSampleSize = sampleSize;
	try {
		bm = BitmapFactory.decodeBitmap(origin, bms);
	} catch(OOMError e) {}
	return bm;
    }

}
