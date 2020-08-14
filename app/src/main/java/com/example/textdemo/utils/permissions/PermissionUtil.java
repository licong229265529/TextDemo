package com.example.textdemo.utils.permissions;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


/**
 * 权限检查获取
 * @see PermissionsStrategy
 * @author mrzhu
 */
public class PermissionUtil {

    private static volatile PermissionUtil permissionUtil;
    private final PermissionsStrategy permissionsStrategy;

    private PermissionUtil() {
        permissionsStrategy = new AppPermissionsStrategy();
    }

    public static PermissionUtil getInstance() {
        if (permissionUtil == null) {
            synchronized (PermissionUtil.class) {
                if (permissionUtil == null) {
                    permissionUtil = new PermissionUtil();
                }
            }
        }
        return permissionUtil;
    }


    public PermissionsStrategy getPermissions(FragmentActivity activity, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(activity, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(FragmentActivity activity, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(activity, isGroup, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(FragmentActivity activity, int requestCode, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(activity, requestCode, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(FragmentActivity activity, int requestCode, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(activity, requestCode, isGroup, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(Fragment fragment, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(fragment, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(Fragment fragment, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(fragment, isGroup, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(Fragment fragment, int requestCode, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(fragment, requestCode, permissionsCallBack, permissions);
    }

    public PermissionsStrategy getPermissions(Fragment fragment, int requestCode, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        return permissionsStrategy.getPermissions(fragment, requestCode, isGroup, permissionsCallBack, permissions);
    }

    public boolean checkPermissions(Context context, String permissions) {
        return permissionsStrategy.checkPermissions(context, permissions);
    }

    public void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsStrategy.onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
    }

    public void onRequestPermissionsResult(Fragment fragment, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsStrategy.onRequestPermissionsResult(fragment, requestCode, permissions, grantResults);
    }

    public void onDestroy() {
        permissionsStrategy.onDestroy();
    }
}
