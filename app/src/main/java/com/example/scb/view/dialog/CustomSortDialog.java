package com.example.scb.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;

import com.example.scb.R;
import com.example.scb.presenter.SortType;

import java.util.ArrayList;

import io.reactivex.annotations.Nullable;

public class CustomSortDialog extends Dialog {

    public interface SortDialogListener {
        void onSortTrigger(SortType sortType);
    }

    public CustomSortDialog(Context context) {
        super(context);
    }

    public CustomSortDialog(Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected CustomSortDialog(Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private SortDialogListener listener;
    private RadioButton chkLowHigh;
    private RadioButton chkHighLow;
    private RadioButton chkRating;

    public void setListener(SortDialogListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setNavigationBarColor(Color.BLACK);
            }
        }

        View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_dialog, null, false);
        setContentView(view);

        chkLowHigh = view.findViewById(R.id.chkLowHigh);
        chkHighLow = view.findViewById(R.id.chkHighLow);
        chkRating = view.findViewById(R.id.chkRating);

        view.findViewById(R.id.chkLowHighDummy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkLowHigh.setChecked(!chkLowHigh.isChecked());
                if (chkLowHigh.isChecked()) {
                    chkHighLow.setChecked(false);
                    chkRating.setChecked(false);
                }
                pushSort(SortType.BY_PRICE_LOW_HIGH);
            }
        });
        view.findViewById(R.id.chkHighLowDummy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkHighLow.setChecked(!chkHighLow.isChecked());
                if (chkHighLow.isChecked()) {
                    chkLowHigh.setChecked(false);
                    chkRating.setChecked(false);
                }
                pushSort(SortType.BY_PRICE_HIGH_LOW);
            }
        });
        view.findViewById(R.id.chkRatingDummy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkRating.setChecked(!chkRating.isChecked());
                if (chkRating.isChecked()) {
                    chkHighLow.setChecked(false);
                    chkLowHigh.setChecked(false);
                }
                pushSort(SortType.BY_RATING_HIGH_LOW);
            }
        });
    }

    private void pushSort(SortType sortType) {
        if (listener != null) {
            if (chkRating.isChecked() || chkLowHigh.isChecked() || chkHighLow.isChecked()) {
                listener.onSortTrigger(sortType);
            } else {
                listener.onSortTrigger(SortType.BY_API);
            }
        }
        dismiss();
    }
}