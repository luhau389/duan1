package czzz.luhau.myapplication.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import czzz.luhau.myapplication.Fragment.Bread_Fragment;
import czzz.luhau.myapplication.Fragment.Cafe_Fragment;
import czzz.luhau.myapplication.Fragment.Tea_Fragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public static int int_items = 3 ;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0: return new Tea_Fragment();
            case 1: return new Cafe_Fragment();
            case 2: return new Bread_Fragment();
        }

        return  null;
    }

    @Override
    public int getCount() {
        return int_items;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Trà sữa";
            case 1 :
                return "Cà phê";
            case 2 :
                return "Bánh mì";
        }
        return null;

    }
}
