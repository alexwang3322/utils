

public class TouchUtils {
	
	public static boolean ranged(View view, MotionEvent event) {
        int[] location = new int[2];
        int width = view.getWidth(), height = view.getHeight();
        view.getLocationOnScreen(location);
        return ranged(location, width, height, event);
    }

    private static boolean ranged(int[] location, int w, int h, MotionEvent event) {
        return (location[0] < event.getX()
                && location[1] < event.getY()
                && (location[0] + w) > event.getX()
                && (location[1] + h) > event.getY());
    }

}



