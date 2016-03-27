

// 还有没有测试方法的效果 2016-3-27
public class AnimationUtils {

    private static final int DEFAULT_FADE_DURATION_MILLIS = 500;
   
    public static void fadeIn(View obj) {
	fadeIn(obj, DEFAULT_FADE_DURATION_MILLIS);
    }

    public static void fadeIn(View obj, int duration) {
	fadeIn.setAlpha(0.0f);
        fadeIn.setVisibility(0);
        ObjectAnimator.ofFloat(fadeIn, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration((long) duration).start();
    }

}
