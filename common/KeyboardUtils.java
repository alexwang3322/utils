package utils.common;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


/**
@alex 
	KeyboardUtils$$Lambda$1 implements Runnabl { ... } // what is going on?

**/
public final class KeyboardUtils {

    public static class SimpleTextWatcher implements TextWatcher {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
        }
    }
    //TODO: 没有ActivityUtils工具，需要加上
    public static boolean isKeyboardUp(AppCompatActivity activity, View rootView) {
        return (rootView.getRootView().getHeight() - ActivityUtils.getStatusBarActionBarHeight(activity)) - ActivityUtils.getNavBarHeight(activity) > rootView.getHeight();
    }

    public static void showKeyboardIf(View view, boolean show) {
        if (show) {
            showSoftKeyboard(view);
        } else {
            dismissSoftKeyboard(view);
        }
    }

    public static void dismissSoftKeyboard(View view) {
        dismissSoftKeyboard(view.getContext(), view);
    }

    public static void dismissSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService("input_method");
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showSoftKeyboard(View view) {
        showSoftKeyboard(view.getContext(), view);
    }

    public static void showSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService("input_method");
        if (imm != null) {
            imm.showSoftInput(view, 0);
        }
    }

    public static void showSoftKeyboardIfFocused(Context context, View view) {
        if (view.isFocused()) {
            view.post(KeyboardUtils$$Lambda$1.lambdaFactory$(view, context));
        }
    }

    private static /* synthetic */ void lambda$showSoftKeyboardIfFocused$0(View view, Context context) {
        view.requestFocusFromTouch();
        showSoftKeyboard(context, view);
    }

    public static void hideSoftKeyboardForCurrentlyFocusedView(Context context) {
        View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus != null) {
            dismissSoftKeyboard(context, currentFocus);
        }
    }

    public static boolean hasExternalKeyboardConnected(Context context) {
        return context.getResources().getConfiguration().keyboard != 1;
    }

    public static boolean isEnterPress(KeyEvent event) {
        return event != null && event.getAction() == 0 && event.getKeyCode() == 66;
    }

    public static boolean isDoneAction(int actionId) {
        return actionId == 6;
    }

    public static boolean isEnterOrDone(int actionId, KeyEvent event) {
        return isEnterPress(event) || isDoneAction(actionId);
    }

    public static boolean isBackPress(int keyCode, KeyEvent event) {
        return event.getAction() == 1 && keyCode == 4;
    }
}
