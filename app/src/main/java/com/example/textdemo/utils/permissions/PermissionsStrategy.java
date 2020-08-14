package com.example.textdemo.utils.permissions;

import android.app.Activity;
import android.content.Context;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * 权限获取
 *
 * @author mrzhu
 */
public interface PermissionsStrategy {
    /**
     * 权限请求的code
     */
    int PERMISSIONS_REQUEST_CODE = 11011;

    /**
     * 获取权限
     *
     * @param activity            FragmentActivity
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(FragmentActivity activity, PermissionsCallBack permissionsCallBack, String... permissions);


    /**
     * 获取权限
     *
     * @param activity            FragmentActivity
     * @param isGroup             是否是一组权限，true是，false不是
     *                            （如果是一组权限，若果有一个是拒绝的，那就走拒绝方法deniedPermissions，有一个不再询问的，那就是neverAskAgainPermissions）
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(FragmentActivity activity, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions);


    /**
     * 获取权限
     *
     * @param activity            FragmentActivity
     * @param requestCode         自定义的回掉码
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(FragmentActivity activity, int requestCode, PermissionsCallBack permissionsCallBack, String... permissions);

    /**
     * 获取权限
     *
     * @param activity            FragmentActivity
     * @param requestCode         自定义的回掉码
     * @param isGroup             是否是一组权限，true是，false不是
     *                            （如果是一组权限，若果有一个是拒绝的，那就走拒绝方法deniedPermissions，有一个不再询问的，那就是neverAskAgainPermissions）
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(FragmentActivity activity, int requestCode, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions);


    /**
     * 获取权限
     *
     * @param fragment            Fragment
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(Fragment fragment, PermissionsCallBack permissionsCallBack, String... permissions);

    /**
     * 获取权限
     *
     * @param fragment            Fragment
     * @param isGroup             是否是一组权限，true是，false不是
     *                            （如果是一组权限，若果有一个是拒绝的，那就走拒绝方法deniedPermissions，有一个不再询问的，那就是neverAskAgainPermissions）
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(Fragment fragment, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions);

    /**
     * 获取权限
     *
     * @param fragment            Fragment
     * @param requestCode         自定义的回掉码
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(Fragment fragment, int requestCode, PermissionsCallBack permissionsCallBack, String... permissions);

    /**
     * 获取权限
     *
     * @param fragment            Fragment
     * @param requestCode         自定义的回掉码
     * @param isGroup             是否是一组权限，true是，false不是
     *                            （如果是一组权限，若果有一个是拒绝的，那就走拒绝方法deniedPermissions，有一个不再询问的，那就是neverAskAgainPermissions）
     * @param permissionsCallBack 获取的回掉
     * @param permissions         权限
     * @return this
     */
    PermissionsStrategy getPermissions(Fragment fragment, int requestCode, boolean isGroup, PermissionsCallBack permissionsCallBack, String... permissions);

    /**
     * 检查权限
     *
     * @param context     Context
     * @param permissions 检查的全县
     * @return true 授权 false 没有授权
     */
    boolean checkPermissions(Context context, String permissions);

    /**
     * Activity的权限监听
     *
     * @param activity     Activity
     * @param requestCode  requestCode
     * @param permissions  权限
     * @param grantResults 权限状态
     * @see android.content.pm.PackageManager#PERMISSION_GRANTED#PERMISSION_DENIED
     */
    void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String permissions[], @NonNull int[] grantResults);


    /**
     * Fragment的权限监听
     * 需要注意：Activity 重写onRequestPermissionsResult方法时，不要将super.onRequestPermissionsResult 删除
     * 否则Fragment可能不会调用
     *
     * @param fragment     Fragment
     * @param requestCode  requestCode
     * @param permissions  权限
     * @param grantResults 权限状态
     * @see android.content.pm.PackageManager#PERMISSION_GRANTED#PERMISSION_DENIED
     */
    void onRequestPermissionsResult(Fragment fragment, int requestCode, @NonNull String permissions[], @NonNull int[] grantResults);

    /**
     * Activity或者Fragment 关闭时 需要清理
     */
    void onDestroy();
}
