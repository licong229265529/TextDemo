package com.example.textdemo.http;

import com.google.gson.annotations.SerializedName;

public class JsonDataResponse<T> {

    @SerializedName("data")
    private T data;

    @SerializedName("error_code")
    private String error_code;

    @SerializedName("msg")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public String getError_code() {
        return error_code;
    }

    public T getData() {
        return data;
    }
}
