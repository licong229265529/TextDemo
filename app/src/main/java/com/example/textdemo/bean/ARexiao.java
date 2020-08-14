package com.example.textdemo.bean;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.List;

public class ARexiao  implements Serializable {


    //        "item_id": "568667387152",
    //        "num_iid": "568667387152",
    //        "pict_url": "https:\/\/img.alicdn.com\/bao\/uploaded\/TB2Pg_KjlnTBKNjSZPfXXbf1XXa_!!725677994.png",
    //        "zk_final_price": "93.7",
    //        "coupon_amount": "20",
    //        "title": "【拍3份】奥妙洗衣凝珠86颗",
    //        "volume": 42220,
    //        "is_tmall": "1",
    //        "coupon_total_count": "50000",
    //        "user_com": "6.63",
    //        "LastPrice": "73.70",
    //        "TKMoneyRate": "20"


    private Object is_tmall;

    private Object user_com;
    private Object LastPrice;
    private Object TKMoneyRate;

    private Object cut;
    private Object next_user_com;
    private Object supreme;
    private Object unlisted;


    public int getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(int expire_time) {
        this.expire_time = expire_time;
    }

    private String category_id;
    private int expire_time;
    private String qhj;
    private String category_name;
    private String commission_rate;
    private String commission_type;
    private String coupon_amount;
    private String coupon_end_time;
    private Object coupon_id;
    private Object coupon_info;
    private String coupon_remain_count;
    private String coupon_share_url;
    private String coupon_start_fee;
    private String coupon_start_time;
    private String coupon_total_count;
    private String include_dxjh;
    private String include_mkt;
    private String info_dxjh;
    private String item_id;
    private String item_url;
    private String level_one_category_id;
    private String level_one_category_name;
    private String nick;
    private String num_iid;
    private String pict_url;
    private String provcity;
    private String real_post_fee;
    private String reserve_price;
    private String seller_id;
    private String shop_dsr;
    private Object shop_title;
    private Object short_title;
    private Object small_images;
    private String title;
    private String tk_total_commi;
    private String tk_total_sales;
    private String url;
    private String user_type;
    private String volume;
    private String x_id;
    private String zk_final_price;
    private String activity_id;
    private String tab;
    private String subsidy;
    private String total;




    private String typejump;


    private String condition;
    private String surplus;
    private String buy_out;
    private String dsj;
    private String coupon_url;
    private Object item_description;
    private Object white_image;

    private String reward_id;
    private String status;
    private String reward_amount;
    private String share_title;
    private String share_img;
    private String share_imgurl;
    private Object click_url;
    private Object coupon_click_url;
    private String video;
    private String image;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypejump() {
        return typejump;
    }

    public void setTypejump(String typejump) {
        this.typejump = typejump;
    }

    public String getClick_url() {
        if (click_url instanceof String)
            return (String) click_url;
        return null;
    }

    public void setClick_url(String click_url) {
        this.click_url = click_url;
    }


    public String getCoupon_click_url() {
        if (coupon_click_url instanceof String)
            return (String) coupon_click_url;
        return null;
    }

    public void setCoupon_click_url(String coupon_click_url) {
        this.coupon_click_url = coupon_click_url;
    }



    public String getShare_title() {
        return share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public String getShare_img() {
        return share_img;
    }

    public void setShare_img(String share_img) {
        this.share_img = share_img;
    }

    public String getShare_imgurl() {
        return share_imgurl;
    }

    public void setShare_imgurl(String share_imgurl) {
        this.share_imgurl = share_imgurl;
    }

    public void setIs_tmall(Object is_tmall) {
        this.is_tmall = is_tmall;
    }

    public void setUser_com(Object user_com) {
        this.user_com = user_com;
    }

    public void setLastPrice(Object lastPrice) {
        LastPrice = lastPrice;
    }

    public void setTKMoneyRate(Object TKMoneyRate) {
        this.TKMoneyRate = TKMoneyRate;
    }

    public void setCut(Object cut) {
        this.cut = cut;
    }

    public void setNext_user_com(Object next_user_com) {
        this.next_user_com = next_user_com;
    }

    public void setSupreme(Object supreme) {
        this.supreme = supreme;
    }

    public void setUnlisted(Object unlisted) {
        this.unlisted = unlisted;
    }

    public void setCoupon_id(Object coupon_id) {
        this.coupon_id = coupon_id;
    }

    public void setCoupon_info(Object coupon_info) {
        this.coupon_info = coupon_info;
    }

    public void setShort_title(Object short_title) {
        this.short_title = short_title;
    }



    public void setItem_description(Object item_description) {
        this.item_description = item_description;
    }

    public String getReward_id() {
        return reward_id;
    }

    public void setReward_id(String reward_id) {
        this.reward_id = reward_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReward_amount() {
        return reward_amount;
    }

    public void setReward_amount(String reward_amount) {
        this.reward_amount = reward_amount;
    }

    public String getCut() {
        if (cut instanceof String) {
            return (String) cut;
        }
        return null;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getNext_user_com() {
        if (next_user_com instanceof String) {
            return (String) next_user_com;
        }
        return null;
    }

    public void setNext_user_com(String next_user_com) {
        this.next_user_com = next_user_com;
    }

    public String getSupreme() {
        if (supreme instanceof String) {
            return (String) supreme;
        }
        return null;
    }

    public void setSupreme(String supreme) {
        this.supreme = supreme;
    }

    public String getUnlisted() {
        if (unlisted instanceof String) {
            return (String) unlisted;
        }
        return null;
    }

    public void setUnlisted(String unlisted) {
        this.unlisted = unlisted;
    }


    public String getIs_tmall() {
        if (is_tmall instanceof String)
            return (String) is_tmall;
        return null;
    }

    public void setIs_tmall(String is_tmall) {
        this.is_tmall = is_tmall;
    }


    public String getUser_com() {
        if (user_com instanceof String)
            return (String) user_com;
        return null;
    }

    public void setUser_com(String user_com) {
        this.user_com = user_com;
    }

    public String getLastPrice() {
        if (LastPrice instanceof String)
            return (String) LastPrice;
        return null;
    }

    public void setLastPrice(String lastPrice) {
        LastPrice = lastPrice;
    }

    public String getTKMoneyRate() {
        if (TKMoneyRate instanceof String)
            return (String) TKMoneyRate;
        return null;
    }

    public void setTKMoneyRate(String TKMoneyRate) {
        this.TKMoneyRate = TKMoneyRate;
    }



    public String getCoupon_url() {
        return coupon_url;
    }

    public void setCoupon_url(String coupon_url) {
        this.coupon_url = coupon_url;
    }

    public String getQhj() {
        return qhj;
    }

    public void setQhj(String qhj) {
        this.qhj = qhj;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(String commission_rate) {
        this.commission_rate = commission_rate;
    }

    public String getCommission_type() {
        return commission_type;
    }

    public void setCommission_type(String commission_type) {
        this.commission_type = commission_type;
    }

    public String getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(String coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    public String getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(String coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }

    public String getCoupon_id() {

        if (coupon_id instanceof String)
            return (String) coupon_id;

        return null;
    }


    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }


    public String getCoupon_info() {
        if (coupon_info instanceof String)
            return (String) coupon_info;

        return null;


    }

    public void setCoupon_info(String coupon_info) {
        this.coupon_info = coupon_info;
    }

    public String getCoupon_remain_count() {
        return coupon_remain_count;
    }

    public void setCoupon_remain_count(String coupon_remain_count) {
        this.coupon_remain_count = coupon_remain_count;
    }

    public String getCoupon_share_url() {
        return coupon_share_url;
    }

    public void setCoupon_share_url(String coupon_share_url) {
        this.coupon_share_url = coupon_share_url;
    }

    public String getCoupon_start_fee() {
        return coupon_start_fee;
    }

    public void setCoupon_start_fee(String coupon_start_fee) {
        this.coupon_start_fee = coupon_start_fee;
    }

    public String getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(String coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public String getCoupon_total_count() {
        return coupon_total_count;
    }

    public void setCoupon_total_count(String coupon_total_count) {
        this.coupon_total_count = coupon_total_count;
    }

    public String getInclude_dxjh() {
        return include_dxjh;
    }

    public void setInclude_dxjh(String include_dxjh) {
        this.include_dxjh = include_dxjh;
    }

    public String getInclude_mkt() {
        return include_mkt;
    }

    public void setInclude_mkt(String include_mkt) {
        this.include_mkt = include_mkt;
    }

    public String getInfo_dxjh() {
        return info_dxjh;
    }

    public void setInfo_dxjh(String info_dxjh) {
        this.info_dxjh = info_dxjh;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public String getLevel_one_category_id() {
        return level_one_category_id;
    }

    public void setLevel_one_category_id(String level_one_category_id) {
        this.level_one_category_id = level_one_category_id;
    }

    public String getLevel_one_category_name() {
        return level_one_category_name;
    }

    public void setLevel_one_category_name(String level_one_category_name) {
        this.level_one_category_name = level_one_category_name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getPict_url() {
        return pict_url;
    }

    public void setPict_url(String pict_url) {
        this.pict_url = pict_url;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public String getReal_post_fee() {
        return real_post_fee;
    }

    public void setReal_post_fee(String real_post_fee) {
        this.real_post_fee = real_post_fee;
    }

    public String getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(String reserve_price) {
        this.reserve_price = reserve_price;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getShop_dsr() {
        return shop_dsr;
    }

    public void setShop_dsr(String shop_dsr) {
        this.shop_dsr = shop_dsr;
    }

    public String getShop_title() {
        if (shop_title instanceof String)
            return (String) shop_title;
        return null;
    }

    public void setShop_title(Object shop_title) {
        this.shop_title = shop_title;
    }


    public String getShort_title() {
        if (short_title instanceof String)
            return (String) short_title;
        return null;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTk_total_commi() {
        return tk_total_commi;
    }

    public void setTk_total_commi(String tk_total_commi) {
        this.tk_total_commi = tk_total_commi;
    }

    public String getTk_total_sales() {
        return tk_total_sales;
    }

    public void setTk_total_sales(String tk_total_sales) {
        this.tk_total_sales = tk_total_sales;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getX_id() {
        return x_id;
    }

    public void setX_id(String x_id) {
        this.x_id = x_id;
    }

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }

    public String getBuy_out() {
        return buy_out;
    }

    public void setBuy_out(String buy_out) {
        this.buy_out = buy_out;
    }

    public String getDsj() {
        return dsj;
    }

    public void setDsj(String dsj) {
        this.dsj = dsj;
    }

    public Object getItem_description() {
        if (item_description instanceof String)
            return (String) item_description;
        return null;
    }

    public void setItem_description(List<?> item_description) {
        this.item_description = item_description;
    }

    public Object getWhite_image() {

        if (white_image instanceof String) {
            return (String) white_image;
        } else if (white_image instanceof List<?>) {
            return (List<?>) white_image;
        }

        return null;


    }

    public void setWhite_image(Object white_image) {
        this.white_image = white_image;
    }



}
