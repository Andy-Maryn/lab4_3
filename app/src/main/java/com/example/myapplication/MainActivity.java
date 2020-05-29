package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(FirstFragment.newInstance(R.drawable.w, getResources().getColor(R.color.color1)));
        adapter.addFragment(FirstFragment.newInstance(R.drawable.m, getResources().getColor(R.color.color2)));
        adapter.addFragment(FirstFragment.newInstance(R.drawable.f, getResources().getColor(R.color.color3)));

        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        new TabLayoutMediator(tabLayout, pager, (tab, position) -> {
            tab.setText("TAB " + (position + 1));
        }).attach();
    }

    private  class  ViewPagerAdapter extends FragmentStateAdapter {

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        private List<Fragment> list = new ArrayList<>();

        public  void addFragment(Fragment fragment) {
            list.add(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return list.get(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
