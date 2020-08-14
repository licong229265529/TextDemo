package com.example.textdemo.ui;

import android.Manifest;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.textdemo.R;
import com.example.textdemo.base.BaseActivity;
import com.example.textdemo.utils.permissions.PermissionUtil;
import com.example.textdemo.utils.permissions.PermissionsCallBack;


//欢迎引导页面
public class SplashActivity extends BaseActivity implements PermissionsCallBack {


    @Override
    protected int getLayout() {
        return R.layout.activity_lunch;
    }

    @Override
    protected void addListener() {
    }

    @Override
    protected void processLogic() {
        //读取权限
        PermissionUtil.getInstance().getPermissions(this, 1, this, Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA,Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtil.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        //权限申请 成功失败 都继续往下走
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void grantedPermissions(int request, String... permissionsName) {

    }

    @Override
    public void deniedPermissions(int request, String... permissionsName) {

    }

    @Override
    public void neverAskAgainPermissions(int request, String... permissionsName) {

    }


}