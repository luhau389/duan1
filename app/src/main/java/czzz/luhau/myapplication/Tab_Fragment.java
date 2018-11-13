package czzz.luhau.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import czzz.luhau.myapplication.Adapter.PagerAdapter;

public class Tab_Fragment  extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout,null);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager=view.findViewById(R.id.views);

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });


        return view;
    }
}
