package com.example.scb.presenter.adapter;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.scb.R;
import com.example.scb.view.fragment.Wishlist_Fragment;
import com.example.scb.view.fragment.Mobilelist_Fragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;
    private int anInt;

    public MyPagerAdapter(FragmentManager fragmentManager,
                          int anInt) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.anInt = anInt;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Mobilelist_Fragment tab1Fragment = new Mobilelist_Fragment();

                return tab1Fragment;
            case 1:
                Wishlist_Fragment tab2Fragment = new Wishlist_Fragment();
                return tab2Fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return anInt;
    }
}