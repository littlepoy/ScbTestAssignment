package com.example.scb.view.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.scb.R;
import com.example.scb.presenter.CoreFrameLayout;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class AppBarCustomView extends CoreFrameLayout {

    public AppBarCustomView(@NonNull Context context) {
        super(context);
    }

    public AppBarCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AppBarCustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_appbar;
    }

    @Override
    public void onViewInflated(@Nullable Context context, @Nullable View view, @Nullable AttributeSet attrs) {
        super.onViewInflated(context, view, attrs);

        int[] set = {android.R.attr.textColor, android.R.attr.text};

        if (context == null || view == null) return;

        TypedArray a = context.obtainStyledAttributes(attrs, set);
        int textColor = a.getColor(0, context.getResources().getColor(android.R.color.white));
        @SuppressLint("ResourceType") CharSequence text = a.getText(1);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(text);
        tvTitle.setTextColor(textColor);
        a.recycle();
    }

    public void enableSort(OnClickListener onClickListener) {
        getView().findViewById(R.id.btnSort).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.btnSort).setOnClickListener(onClickListener);
    }

    public void setupWithViewPager(@NonNull ViewPager viewPager) {
        TabLayout tabLayout = getView().findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.VISIBLE);
    }

    public void visibleBackButton() {
        getView().findViewById(R.id.gap).setVisibility(View.GONE);
        getView().findViewById(R.id.btnLeft).setVisibility(View.VISIBLE);
    }

    public void setOnLeftClicked(OnClickListener onLeftClicked) {
        getView().findViewById(R.id.btnLeft).setOnClickListener(onLeftClicked);
    }
}