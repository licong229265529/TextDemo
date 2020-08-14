package com.example.textdemo.presenter;

import android.content.Context;

import com.example.textdemo.api.NullView;
import com.example.textdemo.base.BasePresenter;
import com.example.textdemo.bean.HomeGoodsInfoNotJingXuan;
import com.example.textdemo.http.DataUtils;
import com.example.textdemo.http.JsonDataResponse;
import com.example.textdemo.http.ObserverProgress;

public class Nullpresenter extends BasePresenter<NullView> {
    public static int endpage = -1;
    public static boolean isOK = false;
    private boolean refresh;
    private int page;
    protected ObserverProgress<JsonDataResponse<HomeGoodsInfoNotJingXuan>> ob = new ObserverProgress<JsonDataResponse<HomeGoodsInfoNotJingXuan>>("推荐1123") {
        @Override
        protected void completed() {
        }

        @Override
        protected void error(Throwable e) {
        }

        @Override
        public void onNext(JsonDataResponse<HomeGoodsInfoNotJingXuan> json) {
            super.onNext(json);
            if (refresh) {
                mvpView.refreshList(json.getData());//刷新
            }else {
                mvpView.addList(json.getData());//加载更多
            }
        }
    };
    /**
     * 初始化数据
     * @param context
     * @param page
     */
  /*  public void getData(Context context, String typeld, String sort, int page, String level, boolean refresh) {

        mvpView = getView();
        this.refresh = refresh;
        this.page = page;
        if (endpage != -1) {
            if (page <= endpage) {
                ob.setContext(context);
                subscription = DataUtils.getHomeGoods2(context, typeld, sort, page, level, ob);
            }
        } else {
            ob.setContext(context);
            subscription = DataUtils.getHomeGoods2(context, typeld, sort, page, level, ob);
        }
    }*/
}
