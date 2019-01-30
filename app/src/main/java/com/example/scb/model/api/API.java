package com.example.scb.model.api;

import com.example.scb.model.ImgMobile_model;
import com.example.scb.model.ListMobile_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
//    String BASE_URL = "https://jsonplaceholder.typicode.com/";
//    String BASE_URL = "https://simplifiedcoding.net/demos/";
    String BASE_URL = "https://scb-test-mobile.herokuapp.com/";

//    @GET("todos")
//    @GET("marvel")
    @GET("api/mobiles")
    Call<List<ListMobile_model>> getMobileList();

    @GET("api/mobiles/{mobile_id}/images/")
    Call<List<ImgMobile_model>> getMobileImg(@Path("mobile_id") String mobileId);
}
