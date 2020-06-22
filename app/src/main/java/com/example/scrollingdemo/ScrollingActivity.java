package com.example.scrollingdemo;

import android.content.Intent;
import android.os.Bundle;

import com.example.scrollingdemo.bottomsheet.BottomSheetActivity;
import com.example.scrollingdemo.databinding.ActivityScrollingBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding mBinding;
    private ViewPager mVpBody;
    ArrayList<Fragment> fragmentsList;
    private int currIndex;
    List<String> titles;
    //第一次分支提交

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                startActivity(new Intent(ScrollingActivity.this, BottomSheetActivity.class));
            }
        });

        inivViewPager();
    }

    public void inivViewPager() {
        try {
            TabLayout mTabLayout = (TabLayout) findViewById(R.id.tablayout_srcoll);
            titles = new ArrayList<>();
            titles.add("Exchange");
            titles.add("Activity");
            titles.add("Me");

            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));

            mTabLayout.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.colorPrimary));

            mVpBody = (ViewPager) findViewById(R.id.vp_scroll);
            fragmentsList = new ArrayList<Fragment>();
            Bundle bundle = new Bundle();
            Fragment exchangeFragment = ExchangeFragment.newInstance();
            Fragment activityFragment = ExchangeFragment.newInstance();
            Fragment meFragment = ExchangeFragment.newInstance();


            fragmentsList.add(exchangeFragment);
            fragmentsList.add(activityFragment);
            fragmentsList.add(meFragment);
            TabFragmentPagerAdapter tabFragmentPagerAdapter = new TabFragmentPagerAdapter(
                    getSupportFragmentManager(), fragmentsList);
            mVpBody.setAdapter(new TabFragmentPagerAdapter(
                    getSupportFragmentManager(), fragmentsList));
            mVpBody.setCurrentItem(0);
            mVpBody.setOnPageChangeListener(new MyOnPageChangeListener());


            mTabLayout.setupWithViewPager(mVpBody);
            mTabLayout.setTabsFromPagerAdapter(tabFragmentPagerAdapter);

        } catch (Exception e) {
            Log.e("initViewPager", "initViewPager", e);
        }
    }

    public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> mFragmentsList;

        public TabFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public TabFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
            super(fm);
            mFragmentsList = fragmentsList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class TabOnClickListener implements View.OnClickListener {
        private int index = 0;

        public TabOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mVpBody.setCurrentItem(index);
        }
    }

    ;

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:


                    break;
                case 1:

                    break;
                case 2:

                    break;

            }
            currIndex = arg0;

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}