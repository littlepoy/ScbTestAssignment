package com.example.scb.view.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.scb.R;
import com.example.scb.model.CardsModel;
import com.example.scb.model.ImgMobile_model;
import com.example.scb.model.ListMobile_model;
import com.example.scb.model.RequestClient;
import com.example.scb.model.api.API;
import com.example.scb.presenter.card.CardsAdapter;
import com.example.scb.view.dialog.AppBarCustomView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileDetailActivity extends AppCompatActivity {

    String id;
    String title;
    String rating;
    String price;
    String subtitle;
    String brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_detail);

        init();
        getData();
        getImg();

    }

    public void init(){
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        AppBarCustomView topBar = findViewById(R.id.topBar);
        topBar.visibleBackButton();
        topBar.setOnLeftClicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    void getData(){
         id = getIntent().getExtras().getString("id");
         title = getIntent().getExtras().getString("title");
         rating = getIntent().getExtras().getString("rating");
         price = getIntent().getExtras().getString("price");
         subtitle = getIntent().getExtras().getString("subtitle");
         brand = getIntent().getExtras().getString("brand");

        TextView tvtitle = (TextView) findViewById(R.id.tvModelName);
                tvtitle.setText(title);
        TextView tvsub = (TextView) findViewById(R.id.tvDetail);
                tvsub.setText(subtitle);
        TextView tvprice = (TextView) findViewById(R.id.tvPrice);
                tvprice.setText(price);
        TextView tvrate = (TextView) findViewById(R.id.tvRating);
                tvrate.setText(rating);
        TextView tvbrand = (TextView) findViewById(R.id.tvBandName);
                tvbrand.setText(brand);
    }

    public void getImg(){
        API api = RequestClient.ApiService();
        Call<List<ImgMobile_model>> call = api.getMobileImg(id);
        call.enqueue(new Callback<List<ImgMobile_model>>() {
            @Override
            public void onResponse(Call<List<ImgMobile_model>> call, Response<List<ImgMobile_model>> response) {
                List<ImgMobile_model> Imglist = response.body();
                    ImageView imageView = (ImageView) findViewById(R.id.vpgMobileImage);
                    Glide.with(getBaseContext()).load(Imglist.get(0).getUrl()).into(imageView);
            }

            @Override
            public void onFailure(Call<List<ImgMobile_model>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
