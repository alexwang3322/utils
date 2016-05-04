


public class MyAppUtils extends AppUtils{
    private static boolean isAnonymous = true;

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
