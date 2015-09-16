package com.loopeer.app.coordinatelayoutdemo;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.loopeer.app.coordinatelayoutdemo.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView mImage;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);


        initView();
        initToolbar();
        setUpView();
    }

    private void initView() {
        mImage = (SimpleDraweeView) findViewById(R.id.icon);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void setUpView() {
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        tabLayout.setupWithViewPager(viewPager);

        mImage.setImageURI(Uri.parse("http://img.taopic.com/uploads/allimg/130501/240451-13050106450911.jpg"));
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager) {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CheeseListFragment(), "Category 1");
        adapter.addFragment(new CheeseListFragment1(), "Category 2");
        adapter.addFragment(new CheeseListFragment2(), "Category 3");
        viewPager.setAdapter(adapter);

    }

}
