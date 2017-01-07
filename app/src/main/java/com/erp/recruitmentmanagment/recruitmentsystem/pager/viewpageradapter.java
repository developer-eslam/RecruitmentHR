package com.erp.recruitmentmanagment.recruitmentsystem.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;



public class viewpageradapter  extends FragmentPagerAdapter {

    List<Fragment>fragments = new ArrayList<>();
    List<String> tabtitles = new ArrayList<>();

    public  void addfragment(Fragment fragment , String tabtitles){
        this.fragments.add(fragment);
        this.tabtitles.add(tabtitles);

    }

    public viewpageradapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }

}
