package com.example.textdemo.ui;

import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.textdemo.R;
import com.example.textdemo.base.BaseActivity;
import com.example.textdemo.bean.HomeGoodsInfoNotJingXuan;
import com.example.textdemo.fragments.A1Fragment;
import com.example.textdemo.http.DataUtils;
import com.example.textdemo.http.JsonDataResponse;
import com.example.textdemo.http.ObserverProgress;
import com.example.textdemo.utils.dialog.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.frame)
    FrameLayout frame;
    private long mPressedTime = 0;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void processLogic() {
        //添加fragment测试
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        A1Fragment a1Fragment = new A1Fragment();
        fragmentTransaction.add(R.id.frame,a1Fragment);
        fragmentTransaction.commit();




    }

    @Override
    public void onResume() {
        super.onResume();
        //网络请求调用测试
    //    DataUtils.getHomeGoods2(this, "1", "", 1, "1", observerNotJingXuan);

    }

    //测试
    private static final String TAG = "MainActivity";
    protected ObserverProgress<JsonDataResponse<HomeGoodsInfoNotJingXuan>> observerNotJingXuan = new ObserverProgress<JsonDataResponse<HomeGoodsInfoNotJingXuan>>("推荐1123") {
        @Override
        protected void completed() {

        }

        @Override
        protected void error(Throwable e) {

        }

        @Override
        public void onNext(JsonDataResponse<HomeGoodsInfoNotJingXuan> json) {
            super.onNext(json);
       //     Log.d(TAG, "onNext: " + json.getData().getMap_data().size());
        //    Toast.makeText(MainActivity.this, ""+json.getData().getMap_data().size(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long mNowTime = System.currentTimeMillis();//获取第一次按键时间
            if ((mNowTime - mPressedTime) > 2000) {//比较两次按键时间差
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mPressedTime = mNowTime;
            } else {//退出程序
                this.finish();
                System.exit(0);
            }
        }
        return false;
    }


}
