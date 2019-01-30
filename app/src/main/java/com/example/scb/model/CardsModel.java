package com.example.scb.model;

public class CardsModel {
    private int itemId;
    private String titleId;
    private String subtitleId;
    private String price;
    private String rating;
    private String thumbImageURL;
    private String Brand;

    public CardsModel(int itemId, String titleId, String subtitleId, String price, String rating, String thumbImageURL,String brand) {
        this.itemId = itemId;
        this.titleId = titleId;
        this.subtitleId = subtitleId;
        this.price = price;
        this.rating = rating;
        this.thumbImageURL = thumbImageURL;
        this.Brand = brand;
    }

    public String getBrand() {
        return Brand;
    }

    public int getItemId() {
        return itemId;
    }

    public String getThumbImageURL() {
        return thumbImageURL;
    }

    public String getTitle() {
        return titleId;
    }

    public String getSubtitle() {
        return subtitleId;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }
}
