package com.example.scb.presenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

abstract public class CoreFrameLayout extends FrameLayout {

    private View view;

    public CoreFrameLayout(@NonNull Context context) {
        super(context);
        inflateLayout(context, null);
    }

    public CoreFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(context, attrs);
    }

    public CoreFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateLayout(context, attrs);
    }

    private void inflateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        view = LayoutInflater.from(context).inflate(getLayoutId(), this);
        onViewInflated(context, view, attrs);
    }

    public abstract int getLayoutId();

    public void onViewInflated(@Nullable Context context, @Nullable View view, @Nullable AttributeSet attrs) {

    }

    public View getView() {
        return view;
    }
}