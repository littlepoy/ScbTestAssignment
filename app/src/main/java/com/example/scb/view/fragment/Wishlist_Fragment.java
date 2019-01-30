package com.example.scb.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scb.R;
import com.example.scb.model.CardsModel;
import com.example.scb.model.ListMobile_model;
import com.example.scb.model.RequestClient;
import com.example.scb.model.api.API;
import com.example.scb.presenter.card.CardsAdapter;
import com.example.scb.view.activity.MobileDetailActivity;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Wishlist_Fragment extends Fragment {
    ListView listView;
    ImageView btFav;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private static final String MY_PREFS = "my_prefs";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        listView = (ListView) view.findViewById(R.id.listViewMobile);
        getMobileList();
        setOnclickListview();
        return view;
    }

    public void setOnclickListview(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final TextView tvID =(TextView) view.findViewById(R.id.text_id); //for load img
                TextView tvTitle =(TextView) view.findViewById(R.id.text_title);
                TextView tvRate =(TextView) view.findViewById(R.id.text_rating);
                TextView tvPrice =(TextView) view.findViewById(R.id.text_price);
                TextView tvSubtitle =(TextView) view.findViewById(R.id.text_subtitle);
                TextView tvBrand =(TextView) view.findViewById(R.id.text_brand);
                btFav = (ImageView) view.findViewById(R.id.btnFavorite);

                //onclick wish
                btFav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),
                                "Remove from Favorite",
                                Toast.LENGTH_LONG).show();
                        removeFav(tvID.getText().toString());
                    }
                });

                Intent intent = new Intent(getContext()
                        , MobileDetailActivity.class);
                intent.putExtra("id",tvID.getText());
                intent.putExtra("title",tvTitle.getText());
                intent.putExtra("rating",tvRate.getText());
                intent.putExtra("price",tvPrice.getText());
                intent.putExtra("subtitle",tvSubtitle.getText());
                intent.putExtra("brand",tvBrand.getText());
                startActivity(intent);
            }
        });
    }

    public void getMobileList() {
        API api = RequestClient.ApiService();
        Call<List<ListMobile_model>> call = api.getMobileList();
        call.enqueue(new Callback<List<ListMobile_model>>() {
            @Override
            public void onResponse(Call<List<ListMobile_model>> call, Response<List<ListMobile_model>> response) {
                List<ListMobile_model> Mobilelist = response.body();;
                CardsAdapter adapter = new CardsAdapter(getContext());

                //looping through all the listmobile and inserting the names inside the string array
                for (int i = 0; i < Mobilelist.size(); i++) {
                    try {
                        String id = getFav(Mobilelist.get(i).getId());
                        if(id != null){
                            adapter.addAll(new CardsModel(
                                    Integer.parseInt(Mobilelist.get(i).getId()),
                                    Mobilelist.get(i).getName(),
                                    Mobilelist.get(i).getDescriptioname(),
                                    Mobilelist.get(i).getPrice(),
                                    Mobilelist.get(i).getRating(),
                                    Mobilelist.get(i).getThumbImageURL(),
                                    Mobilelist.get(i).getBrand()
                            ));
                        }
                    }catch (Exception ex){
                    }

                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ListMobile_model>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void removeFav(String key){
        prefs = getContext().getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.remove(key);
        editor.commit();     // This line is IMPORTANT !!!
    }

    public void saveFav(String id, String key){
        prefs = getContext().getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putString(key, id);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public String getFav(String key){
        String id = prefs.getString(key, null);
        return id;
    }
}
