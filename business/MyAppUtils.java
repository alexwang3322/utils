

import android.text.TextUtils;
import java.util.regex.Pattern;

public class MyAppUtils extends AppUtils{
    private static boolean isAnonymous = true;
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_\\-\\.]{1,}@[a-zA-Z0-9_\\-]{1,}\\.[a-zA-Z0-9_\\-.]{1,}$");
    private static final Pattern NICK_PATTERN = Pattern.compile("[a-zA-Z0-9_\\-\\u4e00-\\u9fa5]{2,12}");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^1\\d{10}$");

    public static boolean isNickValid(String str) {
        return (NICK_PATTERN.matcher(str).matches());
    }

    public static boolean isEmailValid(String str) {
        return (!TextUtils.isEmpty(str) && EMAIL_PATTERN.matcher(str).matches());
    }

    public static boolean isPhoneNumberValid(String str) {
        return PHONE_PATTERN.matcher(str).matches();
    }

    public static AccountType determineAccountType(String str) {
        if (str.contains("@")) {
            return AccountType.EMAIL;
        }
        if (DIGIT_PATTERN.matcher(str).matches()) {
            return AccountType.MOBILE;
        }
        return AccountType.INVALID;
    }

    /**
     * 对登录数据进行操作
     * **/
    public static void onLogin(Context context) {

    }
    /**
     * 对退出登录时的数据进行操作
     * **/
    public static void onLogout(Context context) {

    }

    public static void onLaunched(Context context) {
	if(isAnonymous) {
	} else {
	}
    }
    
    
}
