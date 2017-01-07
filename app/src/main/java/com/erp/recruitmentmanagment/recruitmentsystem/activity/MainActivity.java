package com.erp.recruitmentmanagment.recruitmentsystem.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.erp.recruitmentmanagment.recruitmentsystem.R;
import com.erp.recruitmentmanagment.recruitmentsystem.pager.viewpageradapter;

import com.erp.recruitmentmanagment.recruitmentsystem.themesfragment.ThemeFiveFragment;
import com.erp.recruitmentmanagment.recruitmentsystem.themesfragment.ThemeFourFragment;
import com.erp.recruitmentmanagment.recruitmentsystem.themesfragment.ThemeOneFragment;
import com.erp.recruitmentmanagment.recruitmentsystem.themesfragment.ThemeThreeFragment;
import com.erp.recruitmentmanagment.recruitmentsystem.themesfragment.ThemeTwoFragment;

public class MainActivity extends AppCompatActivity {


   Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    com.erp.recruitmentmanagment.recruitmentsystem.pager.viewpageradapter viewpageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewpageradapter = new viewpageradapter(getSupportFragmentManager());

        viewpageradapter.addfragment(new ThemeOneFragment() , "Theme One");


        viewpageradapter.addfragment(new ThemeTwoFragment() , "Theme Two");
        viewpageradapter.addfragment(new ThemeThreeFragment() , "Theme Three");
        viewpageradapter.addfragment(new ThemeFourFragment() , "Theme Four");
        viewpageradapter.addfragment(new ThemeFiveFragment() , "Theme Five");

        viewPager.setAdapter(viewpageradapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
