

// 还有没有测试方法的效果 2016-3-27
// airbnb AnimationUtils.java
public class AnimationUtils {

    private static final int DEFAULT_FADE_DURATION_MILLIS = 500;
   
    public static void fadeIn(View fadeIn) {
	fadeIn(fadeIn, DEFAULT_FADE_DURATION_MILLIS);
    }

    public static void fadeIn(View fadeIn, int duration) {
	fadeIn.setAlpha(0.0f);
        fadeIn.setVisibility(0);
        ObjectAnimator.ofFloat(fadeIn, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration((long) duration).start();
    }

    public static void fadeOut(View fadeOut) {
	fadeOut(fadeOut, DEFAULT_FADE_DURATION_MILLIS);
    }

    public static void fadeOut(View fadeOut, int duration) {

    }

}
