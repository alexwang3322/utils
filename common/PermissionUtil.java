


/**
	combine with PermissionUtil and PermissionChecker
	也许这个类主要用于android api 23 permission check新增功能
	还没实现过
	2016-3-23
	from airbxb
**/
public class PermissionUtil {

    public static boolean verifyPermissions(int... grantResults) {
        for (int result : grantResults) {
            if (result != 0) {
                return false;
            }
        }
        return true;
    }
    /**
	airbxb EmailSignInFragmentPermissionsDispatcher
	if (PermissionUtils.hasSelfPermissions(fragment.getActivity(), PERMISSION_PREFILLPHONENUMBER)) {
            fragment.preFillPhoneNumber();
        } else {
            fragment.requestPermissions(PERMISSION_PREFILLPHONENUMBER, 0);
        }
    @param permission android.permission.READ_PHONE_STATE etc ..
    **/
    public static boolean hasSelfPermissions(Context context, String... permissions) {
        for (String permission : permissions) {
            if (PermissionChecker.checkSelfPermission(context, permission) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String... permissions) {
        for (String permission : permissions) {
            if (fragment.shouldShowRequestPermissionRationale(permission)) {
                return true;
            }
        }
        return false;
    }

    public static int checkPermission(Context context, String permission, int pid, int uid, String packageName) {
        if (context.checkPermission(permission, pid, uid) == -1) {
            return -1;
        }
        String op = AppOpsManagerCompat.permissionToOp(permission);
        if (op == null) {
            return 0;
        }
        if (packageName == null) {
            String[] packageNames = context.getPackageManager().getPackagesForUid(uid);
            if (packageNames == null || packageNames.length <= 0) {
                return -1;
            }
            packageName = packageNames[0];
        }
        return AppOpsManagerCompat.noteProxyOp(context, op, packageName) != 0 ? -2 : 0;
    }

    public static int checkSelfPermission(Context context, String permission) {
        return checkPermission(context, permission, Process.myPid(), Process.myUid(), context.getPackageName());
    }

}
