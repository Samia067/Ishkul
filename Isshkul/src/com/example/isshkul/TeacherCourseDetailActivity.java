package com.example.isshkul;

import com.example.isshkul.TeacherHomeActivity.SampleFragmentPagerAdapter;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class TeacherCourseDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_course_detail);
		
		//to navigate back to studentHomeActivity
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
		
		//tabstrip code
		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_course_detail, menu);
		return true;
	}
	
	public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        public SampleFragmentPagerAdapter() {
            super(getSupportFragmentManager());

        }
        
        public CharSequence getPageTitle(int position) {
        	switch (position) {
            case 0:
                return "Tasks";
            case 1:
                return "Enrolled Students";
            
        	}
        	return null;
        }
        
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
        @Override
        public Fragment getItem(int position) {
        	Fragment fragment = null;
        	switch(position)
        	{
        	case 0:
        		fragment =  new TeacherCourseTasksFragment();
        		break;
        	case 1:
        		fragment = new TeacherCourseStudentsFragment();
        		break;
        	
        		
        	};
            return fragment;
        }
    }

}
