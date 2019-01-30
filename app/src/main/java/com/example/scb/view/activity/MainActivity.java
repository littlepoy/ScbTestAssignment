package com.example.scb.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.scb.R;
import com.example.scb.view.dialog.AppBarCustomView;
import com.example.scb.view.dialog.CustomSortDialog;
import com.example.scb.view.fragment.BaseFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomSortDialog customSortDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        BaseFragment baseFragment = new BaseFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentMainFragment, baseFragment);
        transaction.commit();
    }

    private void init() {
        AppBarCustomView topBar = findViewById(R.id.topBar);
        customSortDialog = new CustomSortDialog(this);
        topBar.enableSort(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customSortDialog.show();
            }
        });
    }
}
