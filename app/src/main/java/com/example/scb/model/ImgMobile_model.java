package com.example.scb.model;

import com.google.gson.annotations.SerializedName;

public class ImgMobile_model {
    @SerializedName("mobile_id") private int mobileId;
    @SerializedName("url") private String url;
    @SerializedName("id") private int id;

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
