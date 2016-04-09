package utils.common;

import android.animation.ObjectAnimator;
import android.view.View;

// 还有没有测试方法的效果 2016-3-27
// airbnb AnimationUtils.java
public class AnimationUtils {

    private static final int DEFAULT_FADE_DURATION_MILLIS = 500;
   
    public static void fadeIn(View fadeIn) {
	fadeIn(fadeIn, DEFAULT_FADE_DURATION_MILLIS);
    }

    public static void fadeIn(View fadeIn, int duration) {
	    fadeIn.setAlpha(0.0f);
        fadeIn.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(fadeIn, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration((long) duration).start();
    }

    public static void fadeOut(View fadeOut) {
	fadeOut(fadeOut, DEFAULT_FADE_DURATION_MILLIS);
    }

    public static void fadeOut(View fadeOut, int duration) {
	fadeOut.setAlpha(1.0f); // full alpha , visiable .
        ObjectAnimator animator = ObjectAnimator.ofFloat(fadeOut, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration((long) duration);
        animator.addListener(new SimpleAnimatorListener() {
            public void onAnimationEnd(Animator animation) {
                fadeOut.setVisibility(View.GONE);
            }
        });
        animator.start();
    }

    public static void fadeInOut(View fadeIn, View fadeOut, int duration, final boolean setOutViewToGone) {

    }


}
