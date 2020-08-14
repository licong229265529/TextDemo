package com.example.textdemo.utils.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;



import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.textdemo.utils.permissions.PermissionsCallBack;
import com.example.textdemo.utils.permissions.PermissionsStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取权限
 *
 * @author mrzhu
 */
public class AppPermissionsStrategy implements PermissionsStrategy {

    /**
     * 权限回调
     */
    private PermissionsCallBack permissionsCallBack;
    /**
     * 是否为一组权限
     * true 是 false 不是x
     */
    private boolean isGroup = true;
    private int requestCode;

    @Override
    public PermissionsStrategy getPermissions(FragmentActivity activity, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        return getPermissions(activity, PERMISSIONS_REQUEST_CODE, isGroup, permissionsCallBack, permissions);
    }

    @Override
    public PermissionsStrategy getPermissions(FragmentActivity activity, PermissionsCallBack permissionsCallBack, String... permissions) {
        return getPermissions(activity, PERMISSIONS_REQUEST_CODE, true, permissionsCallBack, permissions);
    }

    @Override
    public PermissionsStrategy getPermissions(FragmentActivity activity, int requestCode, PermissionsCallBack permissionsCallBack, String... permissions) {
        return getPermissions(activity, requestCode, true, permissionsCallBack, permissions);
    }

    @Override
    public PermissionsStrategy getPermissions(Fragment fragment, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        return getPermissions(fragment, PERMISSIONS_REQUEST_CODE, isGroup, permissionsCallBack, permissions);
    }

    @Override
    public PermissionsStrategy getPermissions(Fragment fragment, PermissionsCallBack permissionsCallBack, String... permissions) {
        return getPermissions(fragment, PERMISSIONS_REQUEST_CODE, true, permissionsCallBack, permissions);
    }

    @Override
    public PermissionsStrategy getPermissions(Fragment fragment, int requestCode, PermissionsCallBack permissionsCallBack, String... permissions) {
        return getPermissions(fragment, requestCode, true, permissionsCallBack, permissions);
    }

    @Override
    public PermissionsStrategy getPermissions(FragmentActivity activity, int requestCode, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        if (permissions == null || permissionsCallBack == null) {
            return this;
        }
        this.permissionsCallBack = permissionsCallBack;
        this.isGroup = isGroup;
        this.requestCode = requestCode;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> permissionsDenied = new ArrayList<>();
            for (String applyPermissions : permissions) {
                int hasWriteStoragePermission = ContextCompat.checkSelfPermission(activity.getApplicationContext(), applyPermissions);
                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    //找到没有授权的那些权限
                    permissionsDenied.add(applyPermissions);
                }
            }
            if (permissionsDenied.size() > 0) {
                //申请授权
                ActivityCompat.requestPermissions(activity, permissionsDenied.toArray(new String[]{}), requestCode);
            } else {
                getAll(requestCode, permissions);
            }
        } else {
            //低于6.0 直接赋予权限
            getAll(requestCode, permissions);
        }
        return this;
    }

    @Override
    public PermissionsStrategy getPermissions(Fragment fragment, int requestCode, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions) {
        if (permissions == null || permissionsCallBack == null) {
            return this;
        }
        this.permissionsCallBack = permissionsCallBack;
        this.isGroup = isGroup;
        this.requestCode = requestCode;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (fragment != null && fragment.getActivity() != null) {
                List<String> permissionsDenied = new ArrayList<>();
                for (String applyPermissions : permissions) {
                    int hasWriteStoragePermission = ContextCompat.checkSelfPermission(fragment.getActivity().getApplicationContext(), applyPermissions);
                    if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                        //找到没有授权的那些权限
                        permissionsDenied.add(applyPermissions);
                    }
                }
                if (permissionsDenied.size() > 0) {
                    //申请授权
                    fragment.requestPermissions(permissionsDenied.toArray(new String[]{}), requestCode);
                } else {
                    //都已经有有权限了
                    getAll(requestCode, permissions);
                }
            }
        } else {
            //低于6.0 直接赋予权限
            getAll(requestCode, permissions);
        }
        return this;
    }

    @Override
    public void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == this.requestCode && permissionsCallBack != null) {
            if (permissions.length <= 1) {
                isGroup = false;
            }
            if (isGroup) {
                //是一组权限，要是有失败的权限，那就走deniedPermissions ，如果有不在提示的，那就neverAskAgainPermissions
                //授权的权限
                List<String> grantedPermissions = new ArrayList<>();
                //拒绝的权限
                List<String> deniedPermissions = new ArrayList<>();
                //不在提醒的权限
                List<String> neverAskAgainPermissions = new ArrayList<>();
                for (int i = 0; i < grantResults.length; i++) {
                    int grantResult = grantResults[i];
                    String permission = permissions[i];
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        //授权成功
                        grantedPermissions.add(permission);
                    } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                        //拒绝授权
                        deniedPermissions.add(permission);
                    } else {
                        //不在提醒
                        neverAskAgainPermissions.add(permission);
                    }
                }
                if (neverAskAgainPermissions.size() > 0) {
                    permissionsCallBack.neverAskAgainPermissions(requestCode, neverAskAgainPermissions.toArray(new String[]{}));
                } else if (deniedPermissions.size() > 0) {
                    permissionsCallBack.deniedPermissions(requestCode, deniedPermissions.toArray(new String[]{}));
                } else {
                    permissionsCallBack.grantedPermissions(requestCode, grantedPermissions.toArray(new String[]{}));
                }
            } else {
                //不是一组权限，每个权限，都调用一次
                for (int i = 0; i < grantResults.length; i++) {
                    int grantResult = grantResults[i];
                    String permission = permissions[i];
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        //授权成功
                        permissionsCallBack.grantedPermissions(requestCode, permission);
                    } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                        //拒绝授权
                        permissionsCallBack.deniedPermissions(requestCode, permission);
                    } else {
                        //不在提醒
                        permissionsCallBack.neverAskAgainPermissions(requestCode, permission);
                    }
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(Fragment fragment, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == this.requestCode && permissionsCallBack != null) {
            if (permissions.length <= 1) {
                isGroup = false;
            }
            if (isGroup) {
                //是一组权限，要是有失败的权限，那就走deniedPermissions ，如果有不在提示的，那就neverAskAgainPermissions
                List<String> grantedPermissions = new ArrayList<>();
                List<String> deniedPermissions = new ArrayList<>();
                List<String> neverAskAgainPermissions = new ArrayList<>();
                for (int i = 0; i < grantResults.length; i++) {
                    int grantResult = grantResults[i];
                    String permission = permissions[i];
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        //授权成功
                        grantedPermissions.add(permission);
                    } else if (fragment.shouldShowRequestPermissionRationale(permission)) {
                        //拒绝授权
                        deniedPermissions.add(permission);
                    } else {
                        //不在提醒
                        neverAskAgainPermissions.add(permission);
                    }
                }
                if (neverAskAgainPermissions.size() > 0) {
                    permissionsCallBack.neverAskAgainPermissions(requestCode, neverAskAgainPermissions.toArray(new String[]{}));
                } else if (deniedPermissions.size() > 0) {
                    permissionsCallBack.deniedPermissions(requestCode, deniedPermissions.toArray(new String[]{}));
                } else {
                    permissionsCallBack.grantedPermissions(requestCode, grantedPermissions.toArray(new String[]{}));
                }

            } else {
                for (int i = 0; i < grantResults.length; i++) {
                    int grantResult = grantResults[i];
                    String permission = permissions[i];
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        //授权成功
                        permissionsCallBack.grantedPermissions(requestCode, permission);
                    } else if (fragment.shouldShowRequestPermissionRationale(permission)) {
                        //拒绝授权
                        permissionsCallBack.deniedPermissions(requestCode, permission);
                    } else {
                        //不在提醒
                        permissionsCallBack.neverAskAgainPermissions(requestCode, permission);
                    }
                }
            }
        }
    }

    @Override
    public boolean checkPermissions(Context context, String permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && null != context) {
            int permissionResult = ContextCompat.checkSelfPermission(context, permissions);
            return permissionResult == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    @Override
    public void onDestroy() {
        permissionsCallBack = null;
    }


    /**
     * 获取全部权限
     *
     * @param requestCode requestCode
     * @param permissions permissions
     */
    private void getAll(int requestCode, String... permissions) {
        //都已经有有权限了
        if (permissionsCallBack != null) {
            if (isGroup || permissions.length <= 1) {
                permissionsCallBack.grantedPermissions(requestCode, permissions);
            } else {
                for (String permission : permissions) {
                    permissionsCallBack.grantedPermissions(requestCode, permission);
                }
            }
        }
    }
}
