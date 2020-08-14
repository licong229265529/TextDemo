package com.example.textdemo.fragments;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.textdemo.R;
import com.example.textdemo.adapters.RecyclerviewAdapter;
import com.example.textdemo.api.NullView;
import com.example.textdemo.base.BaseMvpFragment;
import com.example.textdemo.bean.HomeGoodsInfoNotJingXuan;
import com.example.textdemo.http.DataUtils;
import com.example.textdemo.presenter.Nullpresenter;
import com.example.textdemo.utils.Constants;
import com.example.textdemo.utils.dialog.CustomDialog;
import com.example.textdemo.utils.xrecyclerview.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;




public class A1Fragment extends BaseMvpFragment<NullView, Nullpresenter> implements NullView {


    @BindView(R.id.xrecyc)
    XRecyclerView xrecyc;
    @BindView(R.id.text_s)
    TextView text_s;
    @BindView(R.id.buttons)
    Button buttons;
    private CustomDialog dialog;

    @Override
    public int getContentView() {
        return R.layout.a1fragment;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void addListener() {
        xrecyc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
        xrecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            strings.add("ceshi" + i);
        }
        xrecyc.setRefreshing(true);
        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(getContext(), strings);
        xrecyc.setAdapter(recyclerviewAdapter);
        CustomDialog.Builder builder = new CustomDialog.Builder(getContext());

        dialog = builder
                .style(R.style.Dialog)
                .heightdp(ViewGroup.LayoutParams.MATCH_PARENT)
                .widthdp(ViewGroup.LayoutParams.MATCH_PARENT)
                .cancelTouchout(false)
                .view(R.layout.dialog_test)
                .addViewOnclick(R.id.buttonss,listener)
                .build();
        text_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                buttons.setVisibility(View.VISIBLE);
            }
        });



    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.buttonss :
                    dialog.dismiss();
                    break;
            }

        }

    };
    @Override
    public void processLogic() {
        buttons.setText("测试提交代码");
//getPresenter().getData(getContext(),"1", "", 1, "1", Constants.REFRESH);


    }

    @Override
    public Nullpresenter createPresenter() {
        return new Nullpresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private static final String TAG = "A1Fragment";
    List<HomeGoodsInfoNotJingXuan>homeGoodsInfoNotJingXuans=new ArrayList<>();
    @Override
    public void addList(HomeGoodsInfoNotJingXuan data) {
        Log.d(TAG, "addList: "+data.getMap_data().size());
        if (data!=null){
            homeGoodsInfoNotJingXuans.add(data);
            //刷新适配器  同样用法
        }
    }

    @Override
    public void refreshList(HomeGoodsInfoNotJingXuan data) {
        Log.d(TAG, "refreshList: "+data.getMap_data().size());

        if (data!=null){
            homeGoodsInfoNotJingXuans.clear();
            homeGoodsInfoNotJingXuans.add(data);
            //刷新适配器
        }
    }
}
