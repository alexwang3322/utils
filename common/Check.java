



/**	
	see {@link https://github.com/google/guava}
	整理了几个比较实用的方法，以后可以将整个库整理进来，要么就是增加新的方法自己整合；
**/
public class Check {

     /**
     * Doug lea 说: null is very bad.
     * 提早发现问题，快速失败，拒绝null值，不要盲目模糊的接受
     * **/
    public static <T> T nonNull(T ref){
        if(ref != null) {
            return ref;
        }
        throw new NullPointerException();
    }

    public static <T> T nonNull(T ref, @NonNull String errorMessage) {
        if(ref != null) {
            return ref;
        }
        throw new NullPointerException(errorMessage);
    }

    /**     同上     **/
    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static boolean isUserAMonkey() {
	 return ActivityManager.isUserAMonkey();
    }

    public static boolean checkPermission(String permission) {
	return PermissionUtil.checkPermission(permission);
    }
}
