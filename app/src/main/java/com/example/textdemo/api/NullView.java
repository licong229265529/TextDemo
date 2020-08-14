package com.example.textdemo.api;

import com.example.textdemo.bean.HomeGoodsInfoNotJingXuan;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

public interface NullView extends MvpView {
  void addList(HomeGoodsInfoNotJingXuan data);
  void refreshList(HomeGoodsInfoNotJingXuan data);
}
