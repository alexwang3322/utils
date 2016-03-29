
public final class NumberUtils {
    private static final String TAG = "NumberUtils";

    private NumberUtils() {
    }

    public static boolean isInt(String s) {
	return false;
    }

    public static long tryParseLong(String s, long invalidLong) {
        try {
            invalidLong = Long.parseLong(s);
        } catch (NumberFormatException e) {
            Log.w(TAG, e);
        }
        return invalidLong;
    }

    public static double tryParseDouble(String s, double invalidDouble) {
        try {
            invalidDouble = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            Log.w(TAG, e);
        }
        return invalidDouble;
    }

    public static double tryPercentageIntoDecimal(String s, double invalidDouble) {
        try {
            return Double.parseDouble(s) / 100.0d;
        } catch (NumberFormatException e) {
            Log.w(TAG, e);
            return invalidDouble;
        }
    }

    public static int tryParseInt(String s, int invalidInt) {
        try {
            invalidInt = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            Log.w(TAG, e);
        }
        return invalidInt;
    }

    public static String formatLatLong(double latOrLong) {
        return String.format(Locale.US, "%.5f", new Object[]{Double.valueOf(latOrLong)});
    }
}
