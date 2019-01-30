package com.example.scb.presenter.card;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.scb.R;
import com.example.scb.model.CardsModel;

import io.reactivex.annotations.NonNull;

import static android.support.constraint.Constraints.TAG;

public class CardsAdapter extends ArrayAdapter<CardsModel> {

    public CardsAdapter(Context context) {
        super(context, R.layout.card_item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_item, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CardsModel model = getItem(position);

        Glide.with(getContext()).load(model.getThumbImageURL()).into(holder.imageView);
        holder.tvTitle.setText(model.getTitle());
        holder.tvSubtitle.setText(model.getSubtitle());
        holder.tvPrice.setText("Price: $"+model.getPrice());
        holder.tvRating.setText("Rating: "+model.getRating());
        holder.tvId.setText(String.valueOf(model.getItemId()));
        holder.tvBrand.setText(String.valueOf(model.getBrand()));

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvSubtitle;
        TextView tvPrice;
        TextView tvRating;
        TextView tvId;
        TextView tvBrand;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.image);
            tvTitle = (TextView) view.findViewById(R.id.text_title);
            tvSubtitle = (TextView) view.findViewById(R.id.text_subtitle);
            tvPrice = (TextView) view.findViewById(R.id.text_price);
            tvRating = (TextView) view.findViewById(R.id.text_rating);
            tvId = (TextView) view.findViewById(R.id.text_id);
            tvBrand = (TextView) view.findViewById(R.id.text_brand);
        }
    }
}
