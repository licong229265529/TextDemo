package com.example.textdemo.bean;

import java.io.Serializable;
import java.util.List;

public class HomeGoodsInfoNotJingXuan implements Serializable {
    private List<ARexiao> map_data;

    public List<ARexiao> getMap_data() {
        return map_data;
    }

    public void setMap_data(List<ARexiao> map_data) {
        this.map_data = map_data;
    }
}