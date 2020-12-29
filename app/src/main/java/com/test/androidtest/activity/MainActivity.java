package com.test.androidtest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.test.androidtest.R;
import com.test.androidtest.adapter.TabAdapter;
import com.test.androidtest.fragment.BlogFragment;
import com.test.androidtest.fragment.QuestIonFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Android Test");
        ViewPager viewPager = findViewById(R.id.myViewPager);
        TabLayout tabLayout =  findViewById(R.id.tabLayout);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void setupViewPager(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new BlogFragment(), "Blog");
        adapter.addFragment(new QuestIonFragment(), "Questions");
        viewPager.setAdapter(adapter);
    }







}