package com.example.scb.model;

import com.google.gson.annotations.SerializedName;

public class ListMobile_model {
    @SerializedName("name") private String name;
    @SerializedName("description") private String descriptioname;
    @SerializedName("thumbImageURL") private String thumbImageURL;
    @SerializedName("price") private String price;
    @SerializedName("brand") private String brand;
    @SerializedName("id") private String id;
    @SerializedName("rating") private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptioname() {
        return descriptioname;
    }

    public void setDescriptioname(String Descriptioname) {
        this.descriptioname = Descriptioname;
    }

    public String getThumbImageURL() {
        return thumbImageURL;
    }

    public void setThumbImageURL(String thumbImageURL) {
        this.thumbImageURL = thumbImageURL;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
