package com.example.textdemo.utils.permissions;

/**
 * 权限获取回掉
 *
 * @author mrzhu
 */
public interface PermissionsCallBack {

    /**
     * 获取到权限
     *
     * @param request         请求码
     * @param permissionsName 权限名字
     */
    void grantedPermissions(int request, String... permissionsName);

    /**
     * 拒绝权限
     *
     * @param request         请求码
     * @param permissionsName 权限名字
     */
    void deniedPermissions(int request, String... permissionsName);

    /**
     * 不在询问的权限
     *
     * @param request         请求码
     * @param permissionsName 权限名字
     */
    void neverAskAgainPermissions(int request, String... permissionsName);
}
